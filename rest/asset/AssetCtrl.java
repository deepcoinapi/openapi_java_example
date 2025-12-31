package asset;

import com.google.gson.Gson;
import java.util.*;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Asset Controller
 */
public class AssetCtrl {
    private final Env env;
    private final Gson gson = new Gson();

    public AssetCtrl(Env env) {
        this.env = env;
    }

    public void getDepositList() {
        String path = Constants.ASSET_DEPOSIT_LIST + "?size=50";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void getWithdrawList() {
        String path = Constants.ASSET_WITHDRAW_LIST + "?size=1";
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }

    public void getInternalTransferSupport() {
        SignatureUtil.doHttp(env.getUrl() + Constants.INTERNAL_TRANSFER_SUPPORT, Constants.HTTP_METHOD_GET, Constants.INTERNAL_TRANSFER_SUPPORT, "", env);
    }

    public void getInternalTransferHistory() {
        SignatureUtil.doHttp(env.getUrl() + Constants.INTERNAL_TRANSFER_HISTORY, Constants.HTTP_METHOD_GET, Constants.INTERNAL_TRANSFER_HISTORY, "", env);
    }

    public void postInternalTransfer() {
        Map<String, Object> req = new HashMap<>();
        req.put("amount", "10");
        req.put("coin", "USDT");
        req.put("receiverUID", "36007196");
        SignatureUtil.doHttp(env.getUrl() + Constants.INTERNAL_TRANSFER, Constants.HTTP_METHOD_POST, Constants.INTERNAL_TRANSFER, gson.toJson(req), env);
    }

    /**
     * 资金划转：POST /deepcoin/asset/transfer
     * 对应文档“资金划转”接口
     */
    public void transfer() {
        Map<String, Object> req = new HashMap<>();
        req.put("currency_id", "USDT");
        req.put("amount", "100.00");
        req.put("from_id", 7);
        req.put("to_id", 1);
        req.put("uid", 36020176);
        SignatureUtil.doHttp(
                env.getUrl() + Constants.ASSET_TRANSFER,
                Constants.HTTP_METHOD_POST,
                Constants.ASSET_TRANSFER,
                gson.toJson(req),
                env
        );
    }
}
