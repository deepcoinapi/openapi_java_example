package tradeCtrl;

import com.google.gson.Gson;
import java.util.*;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Trade Controller V2
 */
public class TradeCtrl {
    private final Env env;
    private final Gson gson = new Gson();

    public TradeCtrl(Env env) {
        this.env = env;
    }

    public void order() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("ccy", "USDT");
        req.put("side", Constants.SIDE_BUY);
        req.put("ordType", Constants.ORDER_TYPE_MARKET);
        req.put("sz", "90000");
        req.put("px", "1");
        req.put("posSide", Constants.POSITION_SIDE_LONG);
        req.put("tdMode", Constants.CROSS);
        req.put("mrgPosition", Constants.SPLIT);
        req.put("tPTriggerPrice", "100000");

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_ORDER, gson.toJson(req), env);
    }

    public void batchOrders() {
        List<Map<String, Object>> orders = new ArrayList<>();

        Map<String, Object> order1 = new HashMap<>();
        order1.put("instId", "BTC-USDT-SWAP");
        order1.put("tdMode", Constants.CROSS);
        order1.put("side", Constants.SIDE_BUY);
        order1.put("ordType", Constants.ORDER_TYPE_LIMIT);
        order1.put("sz", "1");
        order1.put("px", "65000");
        order1.put("posSide", Constants.POSITION_SIDE_LONG);
        order1.put("mrgPosition", Constants.MERGE);
        orders.add(order1);

        Map<String, Object> order2 = new HashMap<>();
        order2.put("instId", "ETH-USDT-SWAP");
        order2.put("tdMode", Constants.CROSS);
        order2.put("side", Constants.SIDE_SELL);
        order2.put("ordType", Constants.ORDER_TYPE_MARKET);
        order2.put("sz", "2");
        order2.put("posSide", Constants.POSITION_SIDE_SHORT);
        order2.put("mrgPosition", Constants.MERGE);
        orders.add(order2);

        Map<String, Object> req = new HashMap<>();
        req.put("orders", orders);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_BATCH_ORDERS, Constants.HTTP_METHOD_POST, Constants.TRADE_BATCH_ORDERS, gson.toJson(req), env);
    }

    public void replaceOrder() {
        Map<String, Object> req = new HashMap<>();
        req.put("ordId", "1000597765908207");
        req.put("px", 110003);
        req.put("sz", 111);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_REPLACE_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_REPLACE_ORDER, gson.toJson(req), env);
    }

    public void cancelOrder() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("ordId", "1000587866272245");

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_CANCEL_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_CANCEL_ORDER, gson.toJson(req), env);
    }

    public void cancelTriggerOrder() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("ordId", "1000587866272245");

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_CANCEL_TRIGGER_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_CANCEL_TRIGGER_ORDER, gson.toJson(req), env);
    }

    public void batchCancelOrder() {
        Map<String, Object> req = new HashMap<>();
        req.put("ordIds", Arrays.asList("1000587865918838", "1000587865914949"));

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_BATCH_CANCEL_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_BATCH_CANCEL_ORDER, gson.toJson(req), env);
    }

    public void cancelOrderAll() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("IsCrossMargin", 1);
        req.put("IsMergeMode", 1);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_CANCEL_ORDER_ALL, Constants.HTTP_METHOD_POST, Constants.TRADE_CANCEL_ORDER_ALL, gson.toJson(req), env);
    }

    public void cancelTriggerOrderAll() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("IsCrossMargin", 1);
        req.put("IsMergeMode", 1);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_CANCEL_TRIGGER_ALL, Constants.HTTP_METHOD_POST, Constants.TRADE_CANCEL_TRIGGER_ALL, gson.toJson(req), env);
    }

    public void tradeFills() {
        String path = Constants.TRADE_FILLS + "?instType=" + Constants.SWAP + "&instId=BTC-USDT-SWAP";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void queryOrderByOrderSysID() {
        String path = Constants.TRADE_ORDER_BY_ID + "?instId=BTC-USDT-SWAP&ordId=1000597765910558";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void finishQueryOrderByOrderSysID() {
        String path = Constants.TRADE_FINISH_ORDER_BY_ID + "?instId=BTC-USDT-SWAP&ordId=1000587866272245";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void historyOrder() {
        String path = Constants.TRADE_HISTORY_ORDER + "?instType=" + Constants.SWAP;
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void pendingOrder() {
        String path = Constants.TRADE_PENDING_ORDER + "?page=1";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void triggerOrder() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("sz", "1");
        req.put("side", Constants.SIDE_BUY);
        req.put("posSide", Constants.POSITION_SIDE_LONG);
        req.put("orderType", Constants.ORDER_TYPE_MARKET);
        req.put("triggerPrice", "150000");
        req.put("mrgPosition", Constants.MERGE);
        req.put("tdMode", Constants.CROSS);
        req.put("tpTriggerPx", 160000);
        req.put("slTriggerPx", 140000);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_TRIGGER_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_TRIGGER_ORDER, gson.toJson(req), env);
    }

    public void triggerOrdersPending() {
        String path = Constants.TRADE_TRIGGER_ORDERS_PENDING + "?instId=BTC-USDT-SWAP&orderType=limit&limit=100";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void triggerOrdersHistory() {
        String path = Constants.TRADE_TRIGGER_ORDERS_HISTORY + "?instId=BTC-USDT-SWAP&OrderType=limit&limit=100";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void replaceOrderSlTp() {
        Map<String, Object> req = new HashMap<>();
        req.put("ordId", "1000588112470603");
        req.put("slTriggerPx", 80005);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_REPLACE_ORDER_SLTP, Constants.HTTP_METHOD_POST, Constants.TRADE_REPLACE_ORDER_SLTP, gson.toJson(req), env);
    }

    public void setPositionSLTP() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("posSide", Constants.POSITION_SIDE_LONG);
        req.put("mrgPosition", Constants.MERGE);
        req.put("tdMode", Constants.CROSS);
        req.put("tpTriggerPx", 170000);
        req.put("slTriggerPx", 130000);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_SET_POSITION_SLTP, Constants.HTTP_METHOD_POST, Constants.TRADE_SET_POSITION_SLTP, gson.toJson(req), env);
    }

    public void cancelPositionSLTP() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("ordId", "1000587866272245");

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_CANCEL_POSITION_SLTP, Constants.HTTP_METHOD_POST, Constants.TRADE_CANCEL_POSITION_SLTP, gson.toJson(req), env);
    }

    public void modifyPositionSLTP() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("ordId", "1000587866272245");
        req.put("posSide", Constants.POSITION_SIDE_LONG);
        req.put("mrgPosition", Constants.MERGE);
        req.put("tdMode", Constants.CROSS);
        req.put("tpTriggerPx", 180000);
        req.put("slTriggerPx", 120000);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_MODIFY_POSITION_SLTP, Constants.HTTP_METHOD_POST, Constants.TRADE_MODIFY_POSITION_SLTP, gson.toJson(req), env);
    }

    public void batchClosePosition() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_BATCH_CLOSE_POSITION, Constants.HTTP_METHOD_POST, Constants.TRADE_BATCH_CLOSE_POSITION, gson.toJson(req), env);
    }

    public void closePositionByIds() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("posIds", Arrays.asList("1000439562104988", "1000439562104989"));

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_CLOSE_POSITION_BY_IDS, Constants.HTTP_METHOD_POST, Constants.TRADE_CLOSE_POSITION_BY_IDS, gson.toJson(req), env);
    }

    public void batchOrderQuery() {
        List<Map<String, Object>> orders = new ArrayList<>();

        Map<String, Object> q1 = new HashMap<>();
        q1.put("instId", "BTC-USDT-SWAP");
        orders.add(q1);

        Map<String, Object> q2 = new HashMap<>();
        q2.put("instId", "ETH-USDT-SWAP");
        q2.put("ordId", "1000597586292104");
        orders.add(q2);

        Map<String, Object> req = new HashMap<>();
        req.put("orders", orders);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_BATCH_ORDER_QUERY, Constants.HTTP_METHOD_POST, Constants.TRADE_BATCH_ORDER_QUERY, gson.toJson(req), env);
    }

    public void traceOrder() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "ETH-USDT-SWAP");
        req.put("retracePoint", "10");
        req.put("triggerPrice", "0");
        req.put("posSide", Constants.POSITION_SIDE_LONG);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_TRACE_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_TRACE_ORDER, gson.toJson(req), env);
    }

    public void traceOrderList() {
        String path = Constants.TRADE_TRACE_ORDER_LIST + "?instId=BTC-USDT-SWAP";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void dslTriggerOrder() {
        Map<String, Object> tradeInfo = new HashMap<>();
        tradeInfo.put("instid", "BTC-USDT-SWAP");
        tradeInfo.put("lever", 20);
        tradeInfo.put("tradeMode", "1");
        tradeInfo.put("mrgPosition", "merge");

        Map<String, Object> market = new HashMap<>();
        market.put("instid", "BTC-USDT");
        market.put("trigger", "on_bar_close");

        Map<String, Object> bollParams = new HashMap<>();
        bollParams.put("interval", "1m");
        bollParams.put("period", 20);
        bollParams.put("std", 2);

        Map<String, Object> bollCondition = new HashMap<>();
        bollCondition.put("ref", "boll.lower");
        bollCondition.put("op", "<");
        bollCondition.put("right", 45000.0);

        Map<String, Object> boll = new HashMap<>();
        boll.put("name", "boll");
        boll.put("type", "BOLL");
        boll.put("params", bollParams);
        boll.put("condition", bollCondition);
        boll.put("scope", "entry");

        Map<String, Object> kdjParams = new HashMap<>();
        kdjParams.put("interval", "1m");
        kdjParams.put("n", 9);
        kdjParams.put("k_smoothing", 3);
        kdjParams.put("d_smoothing", 3);

        Map<String, Object> kdjCondition = new HashMap<>();
        kdjCondition.put("ref", "kdj.k");
        kdjCondition.put("op", ">");
        kdjCondition.put("right", 30.0);

        Map<String, Object> kdj = new HashMap<>();
        kdj.put("name", "kdj");
        kdj.put("type", "KDJ");
        kdj.put("params", kdjParams);
        kdj.put("condition", kdjCondition);
        kdj.put("scope", "entry");

        List<Map<String, Object>> indicators = Arrays.asList(boll, kdj);

        Map<String, Object> entryAction = new HashMap<>();
        entryAction.put("action", "open");
        entryAction.put("side", "long");
        entryAction.put("volume", 100);

        Map<String, Object> exitAction = new HashMap<>();
        exitAction.put("action", "close");
        exitAction.put("side", "long");
        exitAction.put("volume", 100);

        Map<String, Object> onTrue = new HashMap<>();
        onTrue.put("on_true", entryAction);
        onTrue.put("on_false", exitAction);

        Map<String, Object> then = new HashMap<>();
        then.put("entry", onTrue);
        then.put("exit", onTrue);

        Map<String, Object> stopLoss = new HashMap<>();
        stopLoss.put("enabled", true);
        stopLoss.put("type", "percentage");
        stopLoss.put("value", 0.1);
        stopLoss.put("basis", "entry_price");
        stopLoss.put("trigger", "price");

        Map<String, Object> takeProfit = new HashMap<>();
        takeProfit.put("enabled", true);
        takeProfit.put("type", "percentage");
        takeProfit.put("value", 0.5);
        takeProfit.put("basis", "entry_price");
        takeProfit.put("trigger", "price");

        Map<String, Object> risk = new HashMap<>();
        risk.put("stop_loss", stopLoss);
        risk.put("take_profit", takeProfit);

        Map<String, Object> dslJson = new HashMap<>();
        dslJson.put("version", "1.0");
        dslJson.put("market", market);
        dslJson.put("indicators", indicators);
        dslJson.put("then", then);
        dslJson.put("risk", risk);

        Map<String, Object> req = new HashMap<>();
        req.put("trade_info", tradeInfo);
        req.put("dsl_json", dslJson);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_DSL_TRIGGER_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_DSL_TRIGGER_ORDER, gson.toJson(req), env);
    }

    public void backtestRun() {
        Map<String, Object> market = new HashMap<>();
        market.put("instid", "BTC-USDT-SWAP");
        market.put("trigger", "on_bar_close");

        Map<String, Object> bollParams = new HashMap<>();
        bollParams.put("interval", "1m");
        bollParams.put("period", 20);
        bollParams.put("std", 2);

        Map<String, Object> bollCondition = new HashMap<>();
        bollCondition.put("ref", "boll.lower");
        bollCondition.put("op", "<");
        bollCondition.put("right", 45000.0);

        Map<String, Object> boll = new HashMap<>();
        boll.put("name", "boll");
        boll.put("type", "BOLL");
        boll.put("params", bollParams);
        boll.put("condition", bollCondition);
        boll.put("scope", "entry");

        Map<String, Object> kdjParams = new HashMap<>();
        kdjParams.put("interval", "1m");
        kdjParams.put("n", 9);
        kdjParams.put("k_smoothing", 3);
        kdjParams.put("d_smoothing", 3);

        Map<String, Object> kdjCondition = new HashMap<>();
        kdjCondition.put("ref", "kdj.k");
        kdjCondition.put("op", ">");
        kdjCondition.put("right", 30.0);

        Map<String, Object> kdj = new HashMap<>();
        kdj.put("name", "kdj");
        kdj.put("type", "KDJ");
        kdj.put("params", kdjParams);
        kdj.put("condition", kdjCondition);
        kdj.put("scope", "entry");

        List<Map<String, Object>> indicators = Arrays.asList(boll, kdj);

        Map<String, Object> entryAction = new HashMap<>();
        entryAction.put("action", "open");
        entryAction.put("side", "long");
        entryAction.put("volume", 100);

        Map<String, Object> exitAction = new HashMap<>();
        exitAction.put("action", "close");
        exitAction.put("side", "long");
        exitAction.put("volume", 100);

        Map<String, Object> onTrue = new HashMap<>();
        onTrue.put("on_true", entryAction);
        onTrue.put("on_false", exitAction);

        Map<String, Object> then = new HashMap<>();
        then.put("entry", onTrue);
        then.put("exit", onTrue);

        Map<String, Object> stopLoss = new HashMap<>();
        stopLoss.put("enabled", true);
        stopLoss.put("type", "percentage");
        stopLoss.put("value", 0.1);
        stopLoss.put("basis", "entry_price");
        stopLoss.put("trigger", "price");

        Map<String, Object> takeProfit = new HashMap<>();
        takeProfit.put("enabled", true);
        takeProfit.put("type", "percentage");
        takeProfit.put("value", 0.5);
        takeProfit.put("basis", "entry_price");
        takeProfit.put("trigger", "price");

        Map<String, Object> risk = new HashMap<>();
        risk.put("stop_loss", stopLoss);
        risk.put("take_profit", takeProfit);

        Map<String, Object> dsl = new HashMap<>();
        dsl.put("version", "1.0");
        dsl.put("market", market);
        dsl.put("indicators", indicators);
        dsl.put("then", then);
        dsl.put("risk", risk);

        Map<String, Object> dataSource = new HashMap<>();
        dataSource.put("instid", "BTC-USDT-SWAP");
        dataSource.put("from_ts", 1770652800);
        dataSource.put("to_ts", 1773072000);

        Map<String, Object> req = new HashMap<>();
        req.put("dsl", dsl);
        req.put("data_source", dataSource);

        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_BACKTEST_RUN, Constants.HTTP_METHOD_POST, Constants.TRADE_BACKTEST_RUN, gson.toJson(req), env);
    }
}
