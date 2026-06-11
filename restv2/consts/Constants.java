package consts;

/**
 * API Constants V2
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
    public static final String ACCOUNT_BALANCE = "/deepcoin/v2/account/balances";
    public static final String ACCOUNT_UID = "/deepcoin/v2/account/uid";
    public static final String ACCOUNT_BILLS = "/deepcoin/v2/account/bills";
    public static final String SET_LEVERAGE = "/deepcoin/v2/account/set-leverage";
    public static final String POSITIONS = "/deepcoin/v2/account/positions";

    // Market Endpoints
    public static final String MARKET_BOOKS = "/deepcoin/v2/market/books";
    public static final String MARKET_CANDLES = "/deepcoin/v2/market/candles";
    public static final String MARKET_INSTRUMENTS = "/deepcoin/v2/market/instruments";
    public static final String MARKET_TICKERS = "/deepcoin/v2/market/tickers";
    public static final String MARKET_INDEX_CANDLES = "/deepcoin/v2/market/index-candles";
    public static final String MARKET_TRADES = "/deepcoin/v2/market/trades";
    public static final String MARKET_MARK_CANDLES = "/deepcoin/v2/market/mark-price-candles";
    public static final String MARKET_POSITION_GRADE = "/deepcoin/v2/market/step-margin";
    public static final String MARKET_BOOK_SPREAD = "/deepcoin/v2/market/book-spread";
    public static final String MARKET_SYS_TIME = "/deepcoin/v2/market/time";
    public static final String MARKET_HANDICAP_KLINE1M = "/deepcoin/v2/market/handicap-kline1m";
    public static final String MARKET_HANDICAP_ORDERBOOK = "/deepcoin/v2/market/handicap-orderbook";
    public static final String MARKET_HANDICAP_TRADE = "/deepcoin/v2/market/handicap-trade";
    public static final String MARKET_FUNDING_RATE = "/deepcoin/v2/market/funding-rate";
    public static final String MARKET_CURRENT_FUNDING_RATE = "/deepcoin/v2/market/fund-rate/current-funding-rate";
    public static final String MARKET_FUNDING_RATE_HISTORY = "/deepcoin/v2/market/fund-rate/history";
    public static final String MARKET_SYS_PING = "/deepcoin/v2/market/ping";

    // Trade Endpoints
    public static final String TRADE_ORDER = "/deepcoin/v2/trade/order";
    public static final String TRADE_BATCH_ORDERS = "/deepcoin/v2/trade/batch-orders";
    public static final String TRADE_REPLACE_ORDER = "/deepcoin/v2/trade/replace-order";
    public static final String TRADE_CANCEL_ORDER = "/deepcoin/v2/trade/cancel-order";
    public static final String TRADE_CANCEL_TRIGGER_ORDER = "/deepcoin/v2/trade/cancel-trigger-order";
    public static final String TRADE_BATCH_CANCEL_ORDER = "/deepcoin/v2/trade/batch-cancel-order";
    public static final String TRADE_CANCEL_ORDER_ALL = "/deepcoin/v2/trade/swap/cancel-all";
    public static final String TRADE_CANCEL_TRIGGER_ALL = "/deepcoin/v2/trade/swap/cancel-trigger-all";
    public static final String TRADE_FILLS = "/deepcoin/v2/trade/fills";
    public static final String TRADE_ORDER_BY_ID = "/deepcoin/v2/trade/orderByID";
    public static final String TRADE_FINISH_ORDER_BY_ID = "/deepcoin/v2/trade/finishOrderByID";
    public static final String TRADE_HISTORY_ORDER = "/deepcoin/v2/trade/orders-history";
    public static final String TRADE_PENDING_ORDER = "/deepcoin/v2/trade/orders-pending";
    public static final String TRADE_TRIGGER_ORDER = "/deepcoin/v2/trade/trigger-order";
    public static final String TRADE_TRIGGER_ORDERS_PENDING = "/deepcoin/v2/trade/trigger-orders-pending";
    public static final String TRADE_TRIGGER_ORDERS_HISTORY = "/deepcoin/v2/trade/trigger-orders-history";
    public static final String TRADE_REPLACE_ORDER_SLTP = "/deepcoin/v2/trade/replace-order-sltp";
    public static final String TRADE_SET_POSITION_SLTP = "/deepcoin/v2/trade/set-position-sltp";
    public static final String TRADE_CANCEL_POSITION_SLTP = "/deepcoin/v2/trade/cancel-position-sltp";
    public static final String TRADE_MODIFY_POSITION_SLTP = "/deepcoin/v2/trade/modify-position-sltp";
    public static final String TRADE_BATCH_CLOSE_POSITION = "/deepcoin/v2/trade/batch-close-position";
    public static final String TRADE_CLOSE_POSITION_BY_IDS = "/deepcoin/v2/trade/close-position-by-ids";
    public static final String TRADE_BATCH_ORDER_QUERY = "/deepcoin/v2/trade/batch-order-query";
    public static final String TRADE_TRACE_ORDER = "/deepcoin/v2/trade/trace-order";
    public static final String TRADE_TRACE_ORDER_LIST = "/deepcoin/v2/trade/trace-order-list";
    public static final String TRADE_DSL_TRIGGER_ORDER = "/deepcoin/v2/trade/dsl-trigger-order";
    public static final String TRADE_BACKTEST_RUN = "/deepcoin/v2/trade/backtest-run";

    // Copy Trading Endpoints
    public static final String COPYTRADING_LEADER_SETTINGS = "/deepcoin/v2/copytrading/leader-settings";
    public static final String COPYTRADING_SUPPORT_CONTRACT = "/deepcoin/v2/copytrading/support-contracts";
    public static final String COPYTRADING_SET_CONTRACT = "/deepcoin/v2/copytrading/set-contracts";
    public static final String COPYTRADING_LEADER_POSITION = "/deepcoin/v2/copytrading/leader-position";
    public static final String COPYTRADING_ESTIMATE_PROFIT = "/deepcoin/v2/copytrading/estimate-profit";
    public static final String COPYTRADING_HISTORY_PROFIT = "/deepcoin/v2/copytrading/history-profit";
    public static final String COPYTRADING_FOLLOWER_RANK = "/deepcoin/v2/copytrading/follower-rank";
    public static final String COPYTRADING_POSITION_TYPE = "/deepcoin/v2/copytrading/position-type";

    // Asset Endpoints
    public static final String ASSET_DEPOSIT_LIST = "/deepcoin/v2/asset/deposit-list";
    public static final String ASSET_WITHDRAW_LIST = "/deepcoin/v2/asset/withdraw-list";
    public static final String ASSET_RECHARGE_CHAIN_LIST = "/deepcoin/v2/asset/recharge-chain-list";
    public static final String ASSET_TRANSFER = "/deepcoin/v2/asset/transfer";

    // Internal Transfer Endpoints
    public static final String INTERNAL_TRANSFER_SUPPORT = "/deepcoin/v2/internal-transfer/support";
    public static final String INTERNAL_TRANSFER = "/deepcoin/v2/internal-transfer";
    public static final String INTERNAL_TRANSFER_HISTORY = "/deepcoin/v2/internal-transfer/history-order";

    // Sub-Account Endpoints
    public static final String SUB_ACCOUNT_TRANSFER = "/deepcoin/v2/sub-account/sub-account-transfer";
    public static final String SUB_ACCOUNT_TRANSFER_RECORD = "/deepcoin/v2/sub-account/sub-account-transfer-record";
    public static final String SUB_ACCOUNT_LIST = "/deepcoin/v2/sub-account/sub-account-list";

    // Listen Key Endpoints
    public static final String LISTEN_KEY = "/deepcoin/v2/listenkey/acquire";
    public static final String EXTEND_LISTEN_KEY = "/deepcoin/v2/listenkey/extend";

    // Rebate Endpoints
    public static final String REBATE_CONFIG = "/deepcoin/v2/rebate/config";
    public static final String AGENTS_USERS = "/deepcoin/v2/agents/users";
    public static final String AGENTS_REBATE_LIST = "/deepcoin/v2/agents/users/rebate-list";
    public static final String AGENTS_REBATES = "/deepcoin/v2/agents/users/rebates";
}
