### 需求
>https://bbs.csdn.net/topics/392011822

#### 场景业务
1. 每人每天最多抽2次
2. 免费抽奖次数用完之后 每抽一次扣除N个积分，积分不足进行提示
3. 中奖后发放优惠券到账户，或者发送商品到礼品盒（可延迟发送）
4. 如果发现（优惠券、礼品）库存不足返回未中奖
5. 抽奖记录要存放在数据库中

#### 问题
1. 如何防止高并发情况下用户出现3次或者N次免费抽奖机会，因为每抽一次奖品都会在数据库记录一条抽奖数据 包括是否中奖 奖品是什么，如果用户并发访问会出现 上次抽奖记录未插入 下次抽奖已经开始 此时查询抽奖次数仍未免费抽奖，这就是问题所在（积分扣除也是一样的问题）
2. 中奖后处理策略
3. 发放礼品如何保证最后一个礼品最后一个礼品（商品）不会出现多送的情况

#### 实现思路
1. 用户抽奖请求入MQ
2. 消费者从MQ拉取抽奖请求进行处理
3. TODO