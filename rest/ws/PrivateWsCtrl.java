package ws;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Private WebSocket Controller
 */
public class PrivateWsCtrl {
    private final Env env;

    public PrivateWsCtrl(Env env) {
        this.env = env;
    }

    public void getListenKey() {
        SignatureUtil.doHttp(env.getUrl() + Constants.LISTEN_KEY, Constants.HTTP_METHOD_GET, Constants.LISTEN_KEY, "", env);
    }

    public void extend() {
        String listenKey = "3f8021a44a262e69344d5c522b613006";
        String path = Constants.EXTEND_LISTEN_KEY + "?listenKey=" + listenKey;
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }
}
