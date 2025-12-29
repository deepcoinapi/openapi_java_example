import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.util.*;

import consts.Constants;
import structs.Env;
import accountCtrl.AccountCtrl;
import marketCtrl.MarketCtrl;
import tradeCtrl.TradeCtrl;
import ws.PrivateWsCtrl;
import copytrading.CopyTradingCtrl;
import asset.AssetCtrl;

/**
 * Main Entry Point
 */
public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("command is required");
            return;
        }

        Env env = getConfigs();
        Map<String, Runnable> handlers = buildHandlers(env);

        Runnable handler = handlers.get(args[0]);
        if (handler == null) {
            System.out.println("unknown command: " + args[0]);
            return;
        }
        handler.run();
    }

    private static Env getConfigs() {
        System.out.println(Constants.MASTER);
        Yaml yaml = new Yaml();

        try (InputStream is = new FileInputStream("config/" + Constants.MASTER + ".yaml")) {
            Map<String, Object> config = yaml.load(is);
            @SuppressWarnings("unchecked")
            Map<String, String> apiConfig = (Map<String, String>) config.get("api");
            return new Env(
                apiConfig.get("url"),
                apiConfig.get("key"),
                apiConfig.get("secret_key"),
                apiConfig.get("passphrase")
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to read config: " + e.getMessage(), e);
        }
    }

    private static Map<String, Runnable> buildHandlers(Env env) {
        AccountCtrl account = new AccountCtrl(env);
        MarketCtrl market = new MarketCtrl(env);
        TradeCtrl trade = new TradeCtrl(env);
        PrivateWsCtrl ws = new PrivateWsCtrl(env);
        CopyTradingCtrl copytrading = new CopyTradingCtrl(env);
        AssetCtrl asset = new AssetCtrl(env);

        Map<String, Runnable> handlers = new HashMap<>();

        // Account APIs
        handlers.put("getAccountBalance", account::getAccountBalance);
        handlers.put("getAccountBills", account::getAccountBills);
        handlers.put("setLeverage", account::setLeverage);
        handlers.put("getPositions", account::getPositions);

        // Market APIs
        handlers.put("getMarketCandles", market::getMarketCandles);
        handlers.put("getMarketTickers", market::getMarketTickers);
        handlers.put("getMarketInstruments", market::getMarketInstruments);

        // Trade APIs
        handlers.put("order", trade::order);
        handlers.put("cancelOrder", trade::cancelOrder);
        handlers.put("tradeFills", trade::tradeFills);
        handlers.put("historyOrder", trade::historyOrder);
        handlers.put("spotHistoryOrder", trade::spotHistoryOrder);
        handlers.put("pendingOrder", trade::pendingOrder);
        handlers.put("spotPendingOrder", trade::spotPendingOrder);
        handlers.put("swapQueryOrderByOrderSysID", trade::swapQueryOrderByOrderSysID);
        handlers.put("spotQueryOrderByOrderSysID", trade::spotQueryOrderByOrderSysID);
        handlers.put("swapFinishQueryOrderByOrderSysID", trade::swapFinishQueryOrderByOrderSysID);
        handlers.put("spotFinishQueryOrderByOrderSysID", trade::spotFinishQueryOrderByOrderSysID);
        handlers.put("getPosition", trade::getPosition);
        handlers.put("getFundingRate", trade::getFundingRate);
        handlers.put("replace-order", trade::replaceOrder);
        handlers.put("batch-cancel-order", trade::batchCancelOrder);
        handlers.put("swapQueryPendingOrders", trade::swapQueryPendingOrders);
        handlers.put("swapCalcelAllOrders", trade::swapCancelAllOrders);
        handlers.put("swapReplaceOrderSlTp", trade::swapReplaceOrderSlTp);
        handlers.put("swapReplacePositionSlTp", trade::swapReplacePositionSlTp);

        // CopyTrading APIs
        handlers.put("leader-settings", copytrading::leaderSettings);
        handlers.put("support-contracts", copytrading::supportContracts);
        handlers.put("set-contracts", copytrading::setContracts);
        handlers.put("leader-position", copytrading::leaderPosition);
        handlers.put("estimate-profit", copytrading::estimateProfit);
        handlers.put("history-profit", copytrading::historyProfit);
        handlers.put("follower-rank", copytrading::followerRank);
        handlers.put("getAccountIDs", copytrading::getAccountIDs);

        // WebSocket APIs
        handlers.put("getListenKey", ws::getListenKey);
        handlers.put("extendListenKey", ws::extend);

        // Asset APIs
        handlers.put("depositList", asset::getDepositList);
        handlers.put("withdrawList", asset::getWithdrawList);
        handlers.put("getInternalTransferSupport", asset::getInternalTransferSupport);
        handlers.put("postInternalTransfer", asset::postInternalTransfer);
        handlers.put("getInternalTransferHistory", asset::getInternalTransferHistory);

        return handlers;
    }
}
