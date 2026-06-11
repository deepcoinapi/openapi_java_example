package ws;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Private WebSocket Controller V2
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
        String listenKey = "a04291a7ba8e6cb6e695763b6b0c5132";
        String path = Constants.EXTEND_LISTEN_KEY + "?listenKey=" + listenKey;
        SignatureUtil.doHttp(env.getUrl() + path, Constants.HTTP_METHOD_GET, path, "", env);
    }
}
