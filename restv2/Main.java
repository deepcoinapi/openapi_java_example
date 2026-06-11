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
import rebate.RebateCtrl;

/**
 * Main Entry Point for V2 APIs
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
        CopyTradingCtrl copytrading = new CopyTradingCtrl(env);
        AssetCtrl asset = new AssetCtrl(env);
        PrivateWsCtrl ws = new PrivateWsCtrl(env);
        RebateCtrl rebate = new RebateCtrl(env);

        Map<String, Runnable> handlers = new HashMap<>();

        // Account APIs
        handlers.put("getAccountBalance", account::getAccountBalance);
        handlers.put("getUid", account::getUid);
        handlers.put("getAccountBills", account::getAccountBills);
        handlers.put("setLeverage", account::setLeverage);
        handlers.put("getPositions", account::getPositions);

        // Market APIs
        handlers.put("getMarketBooks", market::getMarketBooks);
        handlers.put("getMarketCandles", market::getMarketCandles);
        handlers.put("getMarketInstruments", market::getMarketInstruments);
        handlers.put("getMarketTickers", market::getMarketTickers);
        handlers.put("getMarketIndexCandles", market::getMarketIndexCandles);
        handlers.put("getMarketTrades", market::getMarketTrades);
        handlers.put("getMarketMarkCandles", market::getMarketMarkCandles);
        handlers.put("getMarketPositionGrade", market::getMarketPositionGrade);
        handlers.put("getMarketBookSpread", market::getMarketBookSpread);
        handlers.put("getMarketSysTime", market::getMarketSysTime);
        handlers.put("getMarketSysPing", market::getMarketSysPing);
        handlers.put("getMarketHandicapKline1m", market::getMarketHandicapKline1m);
        handlers.put("getMarketHandicapOrderbook", market::getMarketHandicapOrderbook);
        handlers.put("getMarketHandicapTrade", market::getMarketHandicapTrade);
        handlers.put("getMarketFundingRate", market::getMarketFundingRate);
        handlers.put("getMarketCurrentFundingRate", market::getMarketCurrentFundingRate);
        handlers.put("getMarketFundingRateHistory", market::getMarketFundingRateHistory);

        // Trade APIs
        handlers.put("order", trade::order);
        handlers.put("batchOrders", trade::batchOrders);
        handlers.put("replace-order", trade::replaceOrder);
        handlers.put("cancelOrder", trade::cancelOrder);
        handlers.put("cancelTriggerOrder", trade::cancelTriggerOrder);
        handlers.put("batch-cancel-order", trade::batchCancelOrder);
        handlers.put("cancelOrderAll", trade::cancelOrderAll);
        handlers.put("cancelTriggerOrderAll", trade::cancelTriggerOrderAll);
        handlers.put("tradeFills", trade::tradeFills);
        handlers.put("queryOrderByOrderSysID", trade::queryOrderByOrderSysID);
        handlers.put("batchOrderQuery", trade::batchOrderQuery);
        handlers.put("finishQueryOrderByOrderSysID", trade::finishQueryOrderByOrderSysID);
        handlers.put("historyOrder", trade::historyOrder);
        handlers.put("pendingOrder", trade::pendingOrder);
        handlers.put("triggerOrder", trade::triggerOrder);
        handlers.put("triggerOrdersPending", trade::triggerOrdersPending);
        handlers.put("triggerOrdersHistory", trade::triggerOrdersHistory);
        handlers.put("replaceOrderSlTp", trade::replaceOrderSlTp);
        handlers.put("setPositionSLTP", trade::setPositionSLTP);
        handlers.put("cancelPositionSLTP", trade::cancelPositionSLTP);
        handlers.put("modifyPositionSLTP", trade::modifyPositionSLTP);
        handlers.put("batchClosePosition", trade::batchClosePosition);
        handlers.put("closePositionByIds", trade::closePositionByIds);
        handlers.put("traceOrder", trade::traceOrder);
        handlers.put("traceOrderList", trade::traceOrderList);
        handlers.put("dslTriggerOrder", trade::dslTriggerOrder);
        handlers.put("backtestRun", trade::backtestRun);

        // Copy Trading APIs
        handlers.put("leader-settings", copytrading::leaderSettings);
        handlers.put("support-contracts", copytrading::supportContracts);
        handlers.put("set-contracts", copytrading::setContracts);
        handlers.put("leader-position", copytrading::leaderPosition);
        handlers.put("estimate-profit", copytrading::estimateProfit);
        handlers.put("history-profit", copytrading::historyProfit);
        handlers.put("follower-rank", copytrading::followerRank);
        handlers.put("positionType", copytrading::positionType);
        handlers.put("updatePositionType", copytrading::updatePositionType);

        // WebSocket APIs
        handlers.put("getListenKey", ws::getListenKey);
        handlers.put("extendListenKey", ws::extend);

        // Asset APIs
        handlers.put("depositList", asset::getDepositList);
        handlers.put("withdrawList", asset::getWithdrawList);
        handlers.put("rechargeChainList", asset::getRechargeChainList);
        handlers.put("assetTransfer", asset::assetTransfer);

        // Internal Transfer APIs
        handlers.put("getInternalTransferSupport", asset::getInternalTransferSupport);
        handlers.put("postInternalTransfer", asset::postInternalTransfer);
        handlers.put("getInternalTransferHistory", asset::getInternalTransferHistory);

        // Sub-Account APIs
        handlers.put("subAccountTransfer", asset::subAccountTransfer);
        handlers.put("subAccountTransferRecord", asset::subAccountTransferRecord);
        handlers.put("subAccountList", asset::subAccountList);

        // Rebate APIs
        handlers.put("rebateConfig", rebate::rebateConfig);
        handlers.put("setRebateConfig", rebate::setRebateConfig);
        handlers.put("agentsUsers", rebate::agentsUsers);
        handlers.put("agentsRebateList", rebate::agentsRebateList);
        handlers.put("agentsRebates", rebate::agentsRebates);

        return handlers;
    }
}
