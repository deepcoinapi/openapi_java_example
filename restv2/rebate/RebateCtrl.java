package rebate;

import com.google.gson.Gson;
import java.util.*;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Rebate Controller V2
 */
public class RebateCtrl {
    private final Env env;
    private final Gson gson = new Gson();

    public RebateCtrl(Env env) {
        this.env = env;
    }

    public void rebateConfig() {
        String path = Constants.REBATE_CONFIG + "?uid=36007196";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void setRebateConfig() {
        Map<String, Object> req = new HashMap<>();
        req.put("uid", 36023405);
        req.put("rate", 10);

        SignatureUtil.doHttp(env.getUrl() + Constants.REBATE_CONFIG, Constants.HTTP_METHOD_POST, Constants.REBATE_CONFIG, gson.toJson(req), env);
    }

    public void agentsUsers() {
        String path = Constants.AGENTS_USERS + "?uid=36007196&startTime=1700000000&endTime=1800000000";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void agentsRebateList() {
        String path = Constants.AGENTS_REBATE_LIST + "?uid=36007196&type=0&startTime=1776081649&endTime=1776210092&pageNum=1&pageSize=100";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void agentsRebates() {
        String path = Constants.AGENTS_REBATES + "?uid=36007196&type=0&startTime=1776081649&endTime=1776210092";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }
}
