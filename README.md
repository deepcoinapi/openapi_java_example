# DeepCoin OpenAPI Java Example

Java版本的DeepCoin OpenAPI示例代码，包含REST API和WebSocket API的实现。

## 项目结构

```
openapi_java_example/
├── rest/          # REST API示例项目（独立项目）
│   ├── accountCtrl/      # 账户相关API
│   ├── asset/            # 资产相关API
│   ├── copytrading/      # 跟单相关API
│   ├── marketCtrl/       # 行情相关API
│   ├── tradeCtrl/        # 交易相关API
│   ├── signature/        # 签名工具
│   ├── config/           # 配置文件
│   └── pom.xml           # Maven配置
│
└── ws/            # WebSocket API示例项目（独立项目）
    ├── PrivateMain.java       # 私有WebSocket示例
    ├── PublicWSMain.java      # 公有WebSocket示例
    ├── WSClient.java          # WebSocket客户端
    └── pom.xml                # Maven配置
```

## 使用说明

### REST API 示例

单独打开 `rest` 目录，参考各个Controller类使用对应的API。

### WebSocket 示例

#### 私有WebSocket（订阅私有频道）

单独打开 `ws` 目录，PrivateWSMain.java->main运行：

#### 公有WebSocket（订阅公有行情）

单独打开 `ws` 目录，PublicWSMain.java->main运行：

## 参考文档

- API文档: https://www.deepcoin.com/docs/zh/authentication

