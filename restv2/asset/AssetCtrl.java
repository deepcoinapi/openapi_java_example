package asset;

import com.google.gson.Gson;
import java.util.*;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Asset Controller V2
 */
public class AssetCtrl {
    private final Env env;
    private final Gson gson = new Gson();

    public AssetCtrl(Env env) {
        this.env = env;
    }

    public void getDepositList() {
        String path = Constants.ASSET_DEPOSIT_LIST + "?ccy=USDT&size=50";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void getWithdrawList() {
        String path = Constants.ASSET_WITHDRAW_LIST + "?size=1";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void getRechargeChainList() {
        String path = Constants.ASSET_RECHARGE_CHAIN_LIST + "?ccy=USDT&lang=zh";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void assetTransfer() {
        Map<String, Object> req = new HashMap<>();
        req.put("ccy", "USDT");
        req.put("amount", "10");
        req.put("from_id", 7);
        req.put("to_id", 1);
        req.put("uid", 36007196);

        SignatureUtil.doHttp(env.getUrl() + Constants.ASSET_TRANSFER, Constants.HTTP_METHOD_POST, Constants.ASSET_TRANSFER, gson.toJson(req), env);
    }

    public void getInternalTransferSupport() {
        SignatureUtil.doHttp(env.getUrl() + Constants.INTERNAL_TRANSFER_SUPPORT, Constants.HTTP_METHOD_GET, Constants.INTERNAL_TRANSFER_SUPPORT, "", env);
    }

    public void postInternalTransfer() {
        Map<String, Object> req = new HashMap<>();
        req.put("amount", "10");
        req.put("coin", "USDT");
        req.put("receiverUID", "36007196");

        SignatureUtil.doHttp(env.getUrl() + Constants.INTERNAL_TRANSFER, Constants.HTTP_METHOD_POST, Constants.INTERNAL_TRANSFER, gson.toJson(req), env);
    }

    public void getInternalTransferHistory() {
        SignatureUtil.doHttp(env.getUrl() + Constants.INTERNAL_TRANSFER_HISTORY, Constants.HTTP_METHOD_GET, Constants.INTERNAL_TRANSFER_HISTORY, "", env);
    }

    public void subAccountTransfer() {
        Map<String, Object> req = new HashMap<>();
        req.put("fromUid", "36033735");
        req.put("toUid", "36034023");
        req.put("fromId", "7");
        req.put("toId", "7");
        req.put("amount", "10");
        req.put("coin", "USDT");

        SignatureUtil.doHttp(env.getUrl() + Constants.SUB_ACCOUNT_TRANSFER, Constants.HTTP_METHOD_POST, Constants.SUB_ACCOUNT_TRANSFER, gson.toJson(req), env);
    }

    public void subAccountTransferRecord() {
        String path = Constants.SUB_ACCOUNT_TRANSFER_RECORD + "?coin=USDT&fromId=7&toId=7&relationType=1&page=1&size=20";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void subAccountList() {
        SignatureUtil.doHttp(env.getUrl() + Constants.SUB_ACCOUNT_LIST, Constants.HTTP_METHOD_GET, Constants.SUB_ACCOUNT_LIST, "", env);
    }
}
