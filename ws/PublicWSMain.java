/**
 * Public WebSocket Example Main
 * 
 * 订阅公有行情WebSocket示例
 * 参考文档: https://test-www.goodtest.cc/docs/zh/publicWS/public
 */
public class PublicWSMain {

    // 合约WebSocket地址
    private static final String SWAP_WS_URL = "wss://stream.deepcoin.com/streamlet/trade/public/swap?platform=api";
    // 现货WebSocket地址
    private static final String SPOT_WS_URL = "wss://stream.deepcoin.com/streamlet/trade/public/spot?platform=api";

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
            PublicWSClient client = new PublicWSClient(url);
            System.out.println("Connecting to: " + url);
            client.connectBlocking();

            // Wait a bit for connection to establish
            Thread.sleep(1000);

            // Example: Subscribe to trade details (成交明细)
            // FilterValue format: $ExchangeID_$InstrumentID_$Period
            // ExchangeID: DEEPCOIN
            // InstrumentID: BTC-USDT-SWAP (for swap) or BTC-USDT (for spot)
            // Period: 1m, 5m, 15m, 30m, 1h, 4h, 12h, 1d, 1w, 1o, 1y
            String exchangeID = "DEEPCOIN";
            String instrumentId = "swap".equals(type) ? "BTC-USDT-SWAP" : "BTC-USDT";
            String period = "1m"; // 1 minute
            String filterValue = exchangeID + "_" + instrumentId + "_" + period;
            String topicID = "2"; // 2: 成交明细 (trade details)

            System.out.println("Subscribing to trade details:");
            System.out.println("  FilterValue: " + filterValue);
            System.out.println("  TopicID: " + topicID);
            client.subscribe(filterValue, topicID, -1); // -1: resume from server's latest position

            System.out.println("WebSocket connection established. Waiting for messages...");
            System.out.println("Press Ctrl+C to exit.");

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

