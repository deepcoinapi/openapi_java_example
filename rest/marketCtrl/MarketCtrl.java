package marketCtrl;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Market Controller
 */
public class MarketCtrl {
    private final Env env;

    public MarketCtrl(Env env) {
        this.env = env;
    }

    public void getMarketCandles() {
        String requestPath = Constants.MARKET_CANDLES + "?instId=BTC-USDT";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketTickers() {
        String requestPath = Constants.MARKET_TICKERS + "?instType=" + Constants.SPOT + "&uly=SAGE-USDT";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketInstruments() {
        String requestPath = Constants.MARKET_INSTRUMENTS + "?instType=" + Constants.SWAP + "&uly=BTC-USDT";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }
}
