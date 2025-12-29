package copytrading;

import com.google.gson.Gson;
import java.util.*;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Copy Trading Controller
 */
public class CopyTradingCtrl {
    private final Env env;
    private final Gson gson = new Gson();

    public CopyTradingCtrl(Env env) {
        this.env = env;
    }

    public void leaderSettings() {
        Map<String, Object> req = new HashMap<>();
        req.put("status", 0);
        req.put("homeMode", 1);
        req.put("isClosedCopyCode", true);
        req.put("copyCode", "");
        SignatureUtil.doHttp(env.getUrl() + Constants.COPYTRADING_LEADER_SETTINGS, Constants.HTTP_METHOD_POST, Constants.COPYTRADING_LEADER_SETTINGS, gson.toJson(req), env);
    }

    public void supportContracts() {
        SignatureUtil.doHttp(env.getUrl() + Constants.COPYTRADING_SUPPORT_CONTRACT, Constants.HTTP_METHOD_GET, Constants.COPYTRADING_SUPPORT_CONTRACT, "", env);
    }

    public void setContracts() {
        Map<String, Object> req = new HashMap<>();
        req.put("constracts", Arrays.asList("BTCUSDT", "ETHUSDT"));
        SignatureUtil.doHttp(env.getUrl() + Constants.COPYTRADING_SET_CONTRACT, Constants.HTTP_METHOD_POST, Constants.COPYTRADING_SET_CONTRACT, gson.toJson(req), env);
    }

    public void leaderPosition() {
        String path = Constants.COPYTRADING_LEADER_POSITION + "?pageNum=1&pageSize=1";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void estimateProfit() {
        String path = Constants.COPYTRADING_ESTIMATE_PROFIT + "?pageNum=1&pageSize=20";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void historyProfit() {
        SignatureUtil.doHttp(env.getUrl() + Constants.COPYTRADING_HISTORY_PROFIT, Constants.HTTP_METHOD_GET, Constants.COPYTRADING_HISTORY_PROFIT, "", env);
    }

    public void followerRank() {
        String path = Constants.COPYTRADING_FOLLOWER_RANK + "?status=2";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void getAccountIDs() {
        SignatureUtil.doHttp(env.getUrl() + Constants.COPYTRADING_GET_ACCOUNTID, Constants.HTTP_METHOD_GET, Constants.COPYTRADING_GET_ACCOUNTID, "", env);
    }
}
