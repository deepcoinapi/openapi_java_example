import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Public WebSocket Client
 */
public class PublicWSClient extends WebSocketClient {
    private ScheduledExecutorService heartbeatExecutor;
    private int localNoCounter = 1;

    public PublicWSClient(String url) throws Exception {
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("WebSocket connection opened");
        // Start heartbeat
        startHeartbeat();
    }

    @Override
    public void onMessage(String message) {
        // Handle pong response
        if ("pong".equals(message.trim())) {
            System.out.println("Received pong");
            return;
        }
        System.out.println("Received message: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed: code=" + code + ", reason=" + reason);
        stopHeartbeat();
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("WebSocket error: " + ex.getMessage());
        ex.printStackTrace();
    }

    /**
     * Send heartbeat (ping)
     */
    private void startHeartbeat() {
        heartbeatExecutor = Executors.newSingleThreadScheduledExecutor();
        heartbeatExecutor.scheduleAtFixedRate(() -> {
            if (isOpen()) {
                send("ping");
                System.out.println("Sent ping");
            }
        }, 0, 20, TimeUnit.SECONDS);
    }

    private void stopHeartbeat() {
        if (heartbeatExecutor != null && !heartbeatExecutor.isShutdown()) {
            heartbeatExecutor.shutdown();
        }
    }

    /**
     * Escape JSON string value
     */
    private String escapeJsonString(String value) {
        return value.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\t", "\\t");
    }

    /**
     * Build JSON message for subscription
     */
    private String buildJsonMessage(String action, String filterValue, int localNo, int resumeNo, String topicID) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"Action\":\"").append(escapeJsonString(action)).append("\",");
        sb.append("\"FilterValue\":\"").append(escapeJsonString(filterValue)).append("\",");
        sb.append("\"LocalNo\":").append(localNo).append(",");
        sb.append("\"ResumeNo\":").append(resumeNo).append(",");
        sb.append("\"TopicID\":\"").append(escapeJsonString(topicID)).append("\"");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Subscribe to a topic
     * @param filterValue Format: $ExchangeID_$InstrumentID_$Period (e.g., "DEEPCOIN_BTC-USDT-SWAP_1m")
     * @param topicID Topic ID (e.g., "2" for trade details/成交明细)
     * @param resumeNo 0: start from beginning, -1: resume from server's latest position
     * @return LocalNo for this subscription
     */
    public int subscribe(String filterValue, String topicID, int resumeNo) {
        int localNo = localNoCounter++;
        String message = buildJsonMessage("1", filterValue, localNo, resumeNo, topicID);
        send(message);
        System.out.println("Sent subscribe: " + message);
        return localNo;
    }

    /**
     * Unsubscribe from a topic
     * @param filterValue Format: $ExchangeID_$InstrumentID_$Period
     * @param topicID Topic ID
     * @return LocalNo for this unsubscription
     */
    public int unsubscribe(String filterValue, String topicID) {
        int localNo = localNoCounter++;
        String message = buildJsonMessage("2", filterValue, localNo, 0, topicID);
        send(message);
        System.out.println("Sent unsubscribe: " + message);
        return localNo;
    }

    /**
     * Unsubscribe from all topics
     */
    public int unsubscribeAll() {
        int localNo = localNoCounter++;
        String message = buildJsonMessage("0", "", localNo, 0, "");
        send(message);
        System.out.println("Sent unsubscribe all: " + message);
        return localNo;
    }

    @Override
    public void close() {
        stopHeartbeat();
        super.close();
    }
}

