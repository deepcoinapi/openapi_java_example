/**
 * Public WebSocket Example Main
 * <p>
 * 订阅公有行情WebSocket示例
 * 参考文档: https://www.deepcoin.com/docs/zh/publicWS/public
 */
public class PublicWSMain {

    // 合约WebSocket地址
    private static final String SWAP_WS_URL = "wss://test-wss.goodtest.cc/streamlet/trade/open/swap?platform=api&version=v2";
    // 现货WebSocket地址
    private static final String SPOT_WS_URL = "wss://stream.deepcoin.com/streamlet/trade/open/spot?platform=api&version=v2";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java PublicWSMain [swap|spot]");
            System.out.println("  swap - Connect to swap (contract) WebSocket");
            System.out.println("  spot - Connect to spot WebSocket");
            System.out.println();
            System.out.println("Example:");
            System.out.println("  java PublicWSMain swap  # Connect to contract WebSocket");
            System.out.println("  java PublicWSMain spot  # Connect to spot WebSocket");
            return;
        }

        String url;
        String type = args[0].toLowerCase();
        if ("swap".equals(type)) {
            url = SWAP_WS_URL;
            System.out.println("Connecting to Swap (Contract) WebSocket...");
        } else if ("spot".equals(type)) {
            url = SPOT_WS_URL;
            System.out.println("Connecting to Spot WebSocket...");
        } else {
            System.out.println("Invalid type: " + type + ". Use 'swap' or 'spot'");
            return;
        }

        try {
            WSClient client = new WSClient(url);
            System.out.println("Connecting to: " + url);
            client.connectBlocking();

            // Wait a bit for connection to establish
            Thread.sleep(1000);

            WSClient.SendTopicAction inner = new WSClient.SendTopicAction();
            inner.Action = "1";
            inner.Symbol = "ETHUSDT";
            inner.LocalNo = 111;
            inner.Count = 1;
            inner.Topic = "kline";
            inner.PeriodID = "5m";
            //inner.Timezone = "UTC";

            client.subscribe(inner); // -1: resume from server's latest position
            System.out.println("WebSocket connection established. Waiting for messages...");
            // Keep the main thread running
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

