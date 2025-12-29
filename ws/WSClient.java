import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;

/**
 * WebSocket Client
 */
public class WSClient extends WebSocketClient {

    public WSClient(String url) throws Exception {
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("start...");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("recv message: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed: code=" + code + ", reason=" + reason);
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("WebSocket error: " + ex.getMessage());
        ex.printStackTrace();
    }
}
