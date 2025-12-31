package consts;

/**
 * API Constants
 */
public class Constants {
    
    public static final String MASTER = "master";

    // HTTP Methods
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";

    // Instrument Types
    public static final String SPOT = "SPOT";
    public static final String SWAP = "SWAP";

    // Margin Modes
    public static final String CROSS = "cross";
    public static final String ISOLATED = "isolated";
    public static final String MERGE = "merge";
    public static final String SPLIT = "split";

    // Order Sides
    public static final String SIDE_BUY = "buy";
    public static final String SIDE_SELL = "sell";

    // Order Types
    public static final String ORDER_TYPE_MARKET = "market";
    public static final String ORDER_TYPE_LIMIT = "limit";
    public static final String ORDER_TYPE_POST_ONLY = "post_only";
    public static final String ORDER_TYPE_IOC = "ioc";

    // Position Sides
    public static final String POSITION_SIDE_LONG = "long";
    public static final String POSITION_SIDE_SHORT = "short";

    // Account Endpoints
    public static final String ACCOUNT_BALANCE = "/deepcoin/account/balances";
    public static final String ACCOUNT_BILLS = "/deepcoin/account/bills";
    public static final String SET_LEVERAGE = "/deepcoin/account/set-leverage";
    public static final String POSITIONS = "/deepcoin/account/positions";

    // Market Endpoints
    public static final String MARKET_CANDLES = "/deepcoin/market/candles";
    public static final String MARKET_TICKERS = "/deepcoin/market/tickers";
    public static final String MARKET_INSTRUMENTS = "/deepcoin/market/instruments";

    // Trade Endpoints
    public static final String TRADE_ORDER = "/deepcoin/trade/order";
    public static final String TRADE_CANCEL_ORDER = "/deepcoin/trade/cancel-order";
    public static final String TRADE_FILLS = "/deepcoin/trade/fills";
    public static final String TRADE_HISTORY_ORDER = "/deepcoin/trade/orders-history";
    public static final String TRADE_PENDING_ORDER = "/deepcoin/trade/orders-pending";
    public static final String TRADE_POSITION = "/deepcoin/account/positions";
    public static final String TRADE_ORDER_BY_ID = "/deepcoin/trade/orderByID";
    public static final String TRADE_FINISH_ORDER_BY_ID = "/deepcoin/trade/finishOrderByID";
    public static final String TRADE_FUNDING_RATE = "/deepcoin/trade/funding-rate";
    public static final String TRADE_REPLACE_ORDER = "/deepcoin/trade/replace-order";
    public static final String TRADE_BATCH_CANCEL_ORDER = "/deepcoin/trade/batch-cancel-order";
    public static final String TRADE_PENDING_ORDER_V2 = "/deepcoin/trade/v2/orders-pending";
    public static final String TRADE_SWAP_CANCEL_ALL = "/deepcoin/trade/swap/cancel-all";
    public static final String TRADE_REPLACE_ORDER_SLTP = "/deepcoin/trade/replace-order-sltp";
    public static final String TRADE_REPLACE_POS_SLTP = "/deepcoin/trade/replace-pos-sltp";
     public static final String TRADE_TRIGGER_ORDER = "/deepcoin/trade/trigger-order";
     public static final String TRADE_CANCEL_POSITION_SLTP = "/deepcoin/trade/cancel-position-sltp";
     public static final String TRADE_TRACE_ORDER = "/deepcoin/trade/trace-order";

    // Copy Trading Endpoints
    public static final String COPYTRADING_LEADER_SETTINGS = "/deepcoin/copytrading/leader-settings";
    public static final String COPYTRADING_SUPPORT_CONTRACT = "/deepcoin/copytrading/support-contracts";
    public static final String COPYTRADING_SET_CONTRACT = "/deepcoin/copytrading/set-contracts";
    public static final String COPYTRADING_LEADER_POSITION = "/deepcoin/copytrading/leader-position";
    public static final String COPYTRADING_ESTIMATE_PROFIT = "/deepcoin/copytrading/estimate-profit";
    public static final String COPYTRADING_HISTORY_PROFIT = "/deepcoin/copytrading/history-profit";
    public static final String COPYTRADING_FOLLOWER_RANK = "/deepcoin/copytrading/follower-rank";
    public static final String COPYTRADING_GET_ACCOUNTID = "/deepcoin/copytrading/get-accountIDs";

    // Asset Endpoints
    public static final String ASSET_DEPOSIT_LIST = "/deepcoin/asset/deposit-list";
    public static final String ASSET_WITHDRAW_LIST = "/deepcoin/asset/withdraw-list";

    // Listen Key Endpoints
    public static final String LISTEN_KEY = "/deepcoin/listenkey/acquire";
    public static final String EXTEND_LISTEN_KEY = "/deepcoin/listenkey/extend";

    // Internal Transfer Endpoints
    public static final String INTERNAL_TRANSFER_SUPPORT = "/deepcoin/internal-transfer/support";
    public static final String INTERNAL_TRANSFER = "/deepcoin/internal-transfer";
    public static final String INTERNAL_TRANSFER_HISTORY = "/deepcoin/internal-transfer/history-order";
 
     // Asset Transfer Endpoint
     public static final String ASSET_TRANSFER = "/deepcoin/asset/transfer";
}
