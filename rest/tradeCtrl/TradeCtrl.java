package tradeCtrl;

import com.google.gson.Gson;
import java.util.*;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Trade Controller
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

    public void cancelOrder() {
        Map<String, Object> req = new HashMap<>();
        req.put("instId", "BTC-USDT-SWAP");
        req.put("ordId", "1000587866272245");
        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_CANCEL_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_CANCEL_ORDER, gson.toJson(req), env);
    }

    public void tradeFills() {
        String path = Constants.TRADE_FILLS + "?instType=" + Constants.SWAP + "&instId=BTC-USDT-SWAP";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void historyOrder() {
        String path = Constants.TRADE_HISTORY_ORDER + "?instType=" + Constants.SWAP + "&ordType=market";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void spotHistoryOrder() {
        String path = Constants.TRADE_HISTORY_ORDER + "?instType=" + Constants.SPOT + "&ordId=1000750232272249";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void pendingOrder() {
        String path = Constants.TRADE_PENDING_ORDER + "?instType=" + Constants.SWAP + "&ordId=1000187178097137";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void spotPendingOrder() {
        String path = Constants.TRADE_PENDING_ORDER + "?instType=" + Constants.SPOT;
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void swapQueryOrderByOrderSysID() {
        String path = Constants.TRADE_ORDER_BY_ID + "?instId=BTC-USDT-SWAP&ordId=1000587866808715";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void spotQueryOrderByOrderSysID() {
        String path = Constants.TRADE_ORDER_BY_ID + "?instId=BTC-USDT&ordId=1000188018518136";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void swapFinishQueryOrderByOrderSysID() {
        String path = Constants.TRADE_FINISH_ORDER_BY_ID + "?instId=BTC-USDT-SWAP&ordId=1000587866272245";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void spotFinishQueryOrderByOrderSysID() {
        String path = Constants.TRADE_FINISH_ORDER_BY_ID + "?instId=BTC-USDT&ordId=1000188021378725";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void getPosition() {
        String path = Constants.TRADE_POSITION + "?instType=" + Constants.SWAP + "&posId=1000439562104988";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void getFundingRate() {
        String path = Constants.TRADE_FUNDING_RATE + "?instType=SwapU";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void replaceOrder() {
        Map<String, Object> req = new HashMap<>();
        req.put("orderSysID", "1000587867035933");
        req.put("tpTriggerPx", 110003);
        req.put("slTriggerPx", 70002);
        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_REPLACE_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_REPLACE_ORDER, gson.toJson(req), env);
    }

    public void batchCancelOrder() {
        Map<String, Object> req = new HashMap<>();
        req.put("orderSysIDs", Arrays.asList("1000587865918838", "1000587865914949"));
        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_BATCH_CANCEL_ORDER, Constants.HTTP_METHOD_POST, Constants.TRADE_BATCH_CANCEL_ORDER, gson.toJson(req), env);
    }

    public void swapQueryPendingOrders() {
        String path = Constants.TRADE_PENDING_ORDER_V2 + "?instId=BTC-USDT-SWAP&index=1&limit=100";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void swapCancelAllOrders() {
        Map<String, Object> req = new HashMap<>();
        req.put("instrumentID", "BTCUSDT");
        req.put("productGroup", "SwapU");
        req.put("IsCrossMargin", 1);
        req.put("IsMergeMode", 0);
        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_SWAP_CANCEL_ALL, Constants.HTTP_METHOD_POST, Constants.TRADE_SWAP_CANCEL_ALL, gson.toJson(req), env);
    }

    public void swapReplaceOrderSlTp() {
        Map<String, Object> req = new HashMap<>();
        req.put("orderSysID", "1000588112470603");
        req.put("slTriggerPx", 80005);
        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_REPLACE_ORDER_SLTP, Constants.HTTP_METHOD_POST, Constants.TRADE_REPLACE_ORDER_SLTP, gson.toJson(req), env);
    }

    public void swapReplacePositionSlTp() {
        Map<String, Object> req = new HashMap<>();
        req.put("orderSysID", "1000588139491613");
        req.put("tpTriggerPx", 100006);
        req.put("slTriggerPx", 80006);
        req.put("volume", 0);
        SignatureUtil.doHttp(env.getUrl() + Constants.TRADE_REPLACE_POS_SLTP, Constants.HTTP_METHOD_POST, Constants.TRADE_REPLACE_POS_SLTP, gson.toJson(req), env);
    }
}
