package accountCtrl;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Account Controller V2
 */
public class AccountCtrl {
    private final Env env;
    private final Gson gson = new Gson();

    public AccountCtrl(Env env) {
        this.env = env;
    }

    public void getAccountBalance() {
        String requestPath = Constants.ACCOUNT_BALANCE + "?instType=" + Constants.SWAP + "&ccy=";
        String requestURL = env.getUrl() + requestPath;
        SignatureUtil.doHttp(requestURL, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getUid() {
        SignatureUtil.doHttp(env.getUrl() + Constants.ACCOUNT_UID, Constants.HTTP_METHOD_GET, Constants.ACCOUNT_UID, "", env);
    }

    public void getAccountBills() {
        String requestPath = Constants.ACCOUNT_BILLS + "?instType=" + Constants.SWAP + "&startTime=1771335466000&endTime=1775635466000";
        String requestURL = env.getUrl() + requestPath;
        SignatureUtil.doHttp(requestURL, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void setLeverage() {
        Map<String, Object> request = new HashMap<>();
        request.put("instId", "BTC-USDT-SWAP");
        request.put("lever", "17");
        request.put("mgnMode", Constants.CROSS);
        request.put("mrgPosition", Constants.MERGE);

        String requestBody = gson.toJson(request);
        SignatureUtil.doHttp(env.getUrl() + Constants.SET_LEVERAGE, Constants.HTTP_METHOD_POST, Constants.SET_LEVERAGE, requestBody, env);
    }

    public void getPositions() {
        String requestPath = Constants.POSITIONS + "?instType=" + Constants.SWAP + "&instId=BTC-USDT-SWAP";
        String requestURL = env.getUrl() + requestPath;
        SignatureUtil.doHttp(requestURL, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }
}
