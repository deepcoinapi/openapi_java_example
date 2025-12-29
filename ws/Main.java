/**
 * WebSocket Example Main
 */
public class Main {

    private static final String WS_URL = "wss://test-wss.goodtest.cc/v1/private?listenKey=3f8021a44a262e69344d5c522b613006";

    public static void main(String[] args) {
        try {
            WSClient client = new WSClient(WS_URL);
            client.connectBlocking();

            // Keep the main thread running
            Thread.currentThread().join();
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
