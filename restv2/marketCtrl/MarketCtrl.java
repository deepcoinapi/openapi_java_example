package marketCtrl;

import signature.SignatureUtil;
import structs.Env;
import consts.Constants;

/**
 * Market Controller V2
 */
public class MarketCtrl {
    private final Env env;

    public MarketCtrl(Env env) {
        this.env = env;
    }

    public void getMarketBooks() {
        String requestPath = Constants.MARKET_BOOKS + "?instId=BTC-USDT-SWAP&sz=200";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketCandles() {
        String requestPath = Constants.MARKET_CANDLES + "?instId=BTC-USDT-SWAP&bar=4H&startTime=1775793600000&endTime=1775866400000&limit=2";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketInstruments() {
        String requestPath = Constants.MARKET_INSTRUMENTS + "?instType=" + Constants.SWAP + "&uly=BTC-USDT";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketTickers() {
        String requestPath = Constants.MARKET_TICKERS + "?instType=" + Constants.SPOT + "&uly=SAGE-USDT";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketIndexCandles() {
        String requestPath = Constants.MARKET_INDEX_CANDLES + "?instId=BTC-USDT-SWAP&bar=1H&startTime=1776081649633&limit=2";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketTrades() {
        String requestPath = Constants.MARKET_TRADES + "?instId=BTC-USDT-SWAP&limit=100";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketMarkCandles() {
        String requestPath = Constants.MARKET_MARK_CANDLES + "?instId=BTC-USDT-SWAP&bar=1m";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketPositionGrade() {
        String requestPath = Constants.MARKET_POSITION_GRADE + "?instId=BTC-USDT-SWAP";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketBookSpread() {
        String requestPath = Constants.MARKET_BOOK_SPREAD + "?instId=BTC-USDT-SWAP&value=100000&vType=0";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketSysTime() {
        SignatureUtil.doHttp(env.getUrl() + Constants.MARKET_SYS_TIME, Constants.HTTP_METHOD_GET, Constants.MARKET_SYS_TIME, "", env);
    }

    public void getMarketSysPing() {
        SignatureUtil.doHttp(env.getUrl() + Constants.MARKET_SYS_PING, Constants.HTTP_METHOD_GET, Constants.MARKET_SYS_PING, "", env);
    }

    public void getMarketHandicapKline1m() {
        String requestPath = Constants.MARKET_HANDICAP_KLINE1M + "?instId=BTC-USDT-SWAP&startTime=1700000000&endTime=1700003600&limit=60";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketHandicapOrderbook() {
        String requestPath = Constants.MARKET_HANDICAP_ORDERBOOK + "?instId=BTC-USDT-SWAP&startTime=1700000000&endTime=1700003600&limit=60";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketHandicapTrade() {
        String requestPath = Constants.MARKET_HANDICAP_TRADE + "?instId=BTC-USDT-SWAP&startTime=1700000000&endTime=1700003600&limit=60";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketFundingRate() {
        String requestPath = Constants.MARKET_FUNDING_RATE + "?instId=";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketCurrentFundingRate() {
        String requestPath = Constants.MARKET_CURRENT_FUNDING_RATE + "?instId=BTC-USDT";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }

    public void getMarketFundingRateHistory() {
        String requestPath = Constants.MARKET_FUNDING_RATE_HISTORY + "?instId=BTC-USDT-SWAP&page=1&size=20";
        SignatureUtil.doHttp(env.getUrl() + requestPath, Constants.HTTP_METHOD_GET, requestPath, "", env);
    }
}
