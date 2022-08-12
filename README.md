[![index]( https://youdoc.github.io/img/tencent.jpg )]( https://cloud.tencent.com/act/cps/redirect?redirect=2446&cps_key=736e609d66e0ac4e57813316cec6fd0b&from=console )
<p align="center">
    <a href='https://github.com/201206030/novel-cloud'><img alt="Github stars" src="https://img.shields.io/github/stars/201206030/novel-cloud?logo=github"></a>
    <a href='https://github.com/201206030/novel-cloud'><img alt="Github forks" src="https://img.shields.io/github/forks/201206030/novel-cloud?logo=github"></a>
    <a href='https://gitee.com/novel_dev_team/novel-cloud'><img alt="Gitee stars" src="https://gitee.com/novel_dev_team/novel-cloud/badge/star.svg?theme=gitee"></a>
    <a href='https://gitee.com/novel_dev_team/novel-cloud'><img alt="Gitee forks" src="https://gitee.com/novel_dev_team/novel-cloud/badge/fork.svg?theme=gitee"></a>
    <a href="https://github.com/201206030/novel-cloud"><img src="https://visitor-badge.glitch.me/badge?page_id=201206030.novel-cloud" alt="visitors"></a>
</p>

<p align="center">
      👉<a href='https://docs.xxyopen.com/course/novelcloud/'>项目文档</a>  |  <a href='https://novel.xxyopen.com'>👉官网</a>  |  <a href='http://47.106.243.172:8888'>👉演示站点</a>
</p>   

### 学习版

[基于 Sprint Boot 3 + Vue 3 开发的前后端分离学习型小说项目](https://github.com/201206030/novel)

### 项目背景

小说网站业务难度适中，没有商城系统那种复杂的业务。但是作为互联网项目，一样需要面对大规模用户和海量数据的处理，所以高并发、高可用、高性能、高容错、可扩展性、可维护性也是小说网站设计需要考虑的问题，商城系统中所用到的技术同样适用于小说网站。

综上所述，使用微服务架构来构建一个小说门户平台是非常有必要的，利用微服务技术栈构建的小说门户平台学习时下流行技术相较于业务比较复杂的商城系统来说也是比较容易的，非常适合没有实际微服务项目经验的同学用来学习和入门微服务技术栈。

### 项目简介

novel-cloud 是基于 [novel-plus](https://github.com/201206030/novel-plus) 构建的 Spring Cloud 微服务架构小说门户平台，致力于原创文学阅读与写作，提供了爬虫工具用于开发过程中测试数据的采集（爬虫项目和 novel-plus 通用）。采用了 Spring Boot 2.2.5.RELEASE 、Spring Cloud Hoxton.SR4、 MyBatis3 Dynamic SQL、Sharding-JDBC、Redis、RabbitMQ、Elasticsearch、Docker 等流行技术，集成了 Nacos 注册中心/配置中心、Spring Cloud Gateway 网关、Spring Boot Admin 监控中心、ELK 分布式日志分析等基础服务。

### 项目结构

```
novel-cloud
├── novel-common -- 通用模块，供其他业务微服务模块依赖
├── novel-gen -- 持久层代码生成器，集成 Swagger
├── novel-gateway -- 基于 Spring Cloud Gateway 构建的网关服务
├── novel-monitor -- 基于 Spring Boot Admin 构建的监控中心
├── novel-search -- 基于 Elasticsearch 构建的搜索微服务
├── novel-file -- 基于 Aliyun OSS 构建的文件微服务
├── novel-home -- 门户首页微服务
├── novel-news -- 新闻中心微服务
├── novel-user -- 用户中心微服务
├── novel-author -- 作家中心微服务
├── novel-book -- 小说微服务
└── novel-pay -- 支付微服务
```

### 技术选型

| 技术                   | 说明                                                         
|----------------------| ---------------------------
| Spring Boot          | Spring 应用快速开发脚手架     
| Spring Cloud         | 微服务架构解决方案 
| Nacos                | 注册中心和配置中心
| Sentinel             | 限流/熔断/降级
| Spring Cloud Gateway | 微服务网关
| Spring Boot Admin    | 微服务监控
| MyBatis              | 持久层 ORM 框架 
| MyBatis Dynamic SQL  | MyBatis 动态 SQL
| PageHelper           | MyBatis 分页插件
| MyBatis Generator    | 持久层代码生成插件
| Seata                | 分布式事务中间件（待应用）
| Sharding-JDBC        | 代码层分库分表中间件
| JJWT                 | JWT 登录支持  
| Redis                | 分布式缓存                              
| Elasticsearch        | 搜索引擎                
| RabbitMQ             | 消息队列
| Aliyun OSS           | 阿里云对象存储服务   
| MySQL                | 数据库服务                 
| Redisson             | 实现分布式锁                                       
| Lombok               | 简化对象封装工具  
| Swagger              | API 文档生成工具                                                                              
| Docker               | 应用容器引擎   
| Logstash             | 分布式日志采集   
| Vue.js               | 前端开发框架

### 项目架构

![](https://s3.ax1x.com/2020/12/09/r92rrT.png)

### 代码仓库

Gitee 仓库地址： https://gitee.com/novel_dev_team/novel-cloud

GitHub 仓库地址：  https://github.com/201206030/novel-cloud

### QQ 交流群

👉[立即查看](https://novel.xxyopen.com/service.htm)

### 微信公众号（发布最新更新资讯）

![](https://docs.xxyopen.com/img/qrcode_for_gh.jpg)

### 捐赠支持

开源项目不易，若此项目能得到你的青睐，可以捐赠支持作者持续开发与维护。

![](https://s1.ax1x.com/2020/10/31/BUQJwq.png)
