[![index]( https://s1.ax1x.com/2022/05/17/O5tgbR.png )]( https://curl.qcloud.com/kgMaOjoq )

[![Github stars](https://img.shields.io/github/stars/201206030/novel-cloud?logo=github)](https://github.com/201206030/novel-cloud)
[![Github forks](https://img.shields.io/github/forks/201206030/novel-cloud?logo=github)](https://github.com/201206030/novel-cloud)
[![Gitee star](https://gitee.com/novel_dev_team/novel-cloud/badge/star.svg?theme=gitee)](https://gitee.com/novel_dev_team/novel-cloud)
[![Gitee fork](https://gitee.com/novel_dev_team/novel-cloud/badge/fork.svg?theme=gitee)](https://gitee.com/novel_dev_team/novel-cloud)


#### 官网

https://201206030.github.io

#### 学习版

[基于 Sprint Boot 3 + Vue 3 开发的前后端分离学习型小说项目](https://github.com/201206030/novel)

#### 背景

小说网站业务难度适中，没有商城系统那种复杂的业务。但是作为互联网项目，一样需要面对大规模用户和海量数据的处理，所以高并发、高可用、高性能、高容错、可扩展性、可维护性也是小说网站设计需要考虑的问题，商城系统中所用到的技术同样适用于小说网站。综上所述，使用微服务架构来构建一个小说门户平台是非常有必要的，利用微服务构建的小说门户平台来学习现下流行技术相较于业务比较复杂的商场系统来说也是比较容易的，非常适合于没有实际微服务项目经验的同学用来学习和入门微服务技术栈。

#### 介绍

novel-cloud 是基于 [novel-plus](https://www.oschina.net/p/novel-plus) 构建的 Spring Cloud 微服务小说门户学习平台，致力于原创文学阅读与写作，提供了爬虫工具用于开发过程中测试数据的采集（爬虫项目和 novel-plus 通用）。采用了 Spring Boot 2.2.5.RELEASE 、Spring Cloud Hoxton.SR4、 MyBatis3DynamicSql、Sharding-Jdbc、Redis、RabbitMQ、Elasticsearch、Docker 等流行技术，集成了 Nacos 注册中心/配置中心、Spring Cloud Gateway 网关、Spring Boot Admin 监控中心、ELK 分布式日志分析等基础服务。前端计划使用 Vue 开发，后台接口一期开发已完成（充值/作家专区除外的所有接口）。

#### 软件架构

![QQ20200520-215756](https://s3.ax1x.com/2020/12/09/r92rrT.png)

#### 项目结构

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

#### 技术选型

| 技术                   | 说明                                                         
|----------------------| ---------------------------
| Spring Boot          | Spring 应用快速开发脚手架     
| Spring Cloud         | 微服务架构解决方案 
| Nacos                | 注册中心和配置中心
| Sentine              | 限流/熔断/降级
| Spring Cloud Gateway | 微服务网关
| Spring Boot Admin    | 微服务监控
| MyBatis              | 持久层 ORM 框架 
| MyBatis Dynamic SQL  | Mybatis 动态 sql
| PageHelper           | MyBatis 分页插件
| MyBatisGenerator     | 持久层代码生成插件
| Seata                | 分布式事务中间件（待应用）
| Sharding-Jdbc        | 代码层分库分表中间件
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
| Vue                  | 前端开发框架

#### 数据模型

![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/BvtUXt.png)

#### 截图

1. 注册中心截图

![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/BvtYpd.png)

2. 配置中心截图

   ![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/Bvtrtg.png)

3. 监控中心截图

   ![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/Bvt2Xq.png)

   ![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/BvtjHK.png)

   ![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/BvN99H.png)

   

   4. 接口文档

      ![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/BvNkut.png)
      
      ![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/BvNK3j.png)
      
      ![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/BvNUC4.md.png)
   
   5. 分布式日志收集
   
      ![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/BvNd29.md.png)
   
   6. 门户网站
   
   ![QQ20200520-215756](https://s3.ax1x.com/2020/11/11/BvNBK1.md.png)
   
   

#### 安装步骤

1. 下载源码，如果是 ZIP 包，下载后需要解压。

   ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvN6UO.md.png)

2. 开发环境配置，请确保开发机器上已安装如下软件环境。
   - [x] Java 开发工具包 jdk1.8+
   - [x] IDE（Eclipse 或 IntelliJ IDEA）
   - [x] 项目管理工具 maven
   - [x] 微服务注册中心/配置中心 nacos
   - [x] 分布式缓存服务 Redis
   - [x] 搜索引擎服务 Elasticsearch
   - [x] Elasticsearch 可视化客户端 Kibana
   - [x] 消息中间件 RabbitMQ
   - [x] 数据库服务 MySQL
   
3. 登陆 nacos 配置中心导入下载源码中的配置文件。

   ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvN2Pe.png)
   
   ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvN5rt.png)

   ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvNHIS.png)

   ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvNXxs.png)

4. 使用 IDE 导入下载的源码（这里以 IntelliJ IDEA 为例）。

   ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvUCIU.png)

5. 修改通用配置中的配置中心地址和命名空间 ID。

   ![image-20200529182810929](https://s3.ax1x.com/2020/11/11/BvUAz9.png)

   ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvUVMR.png)

6. 启动微服务网关。

   - 修改网关服务的配置中心地址和命名空间ID

     ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvUJsI.png)

   - 修改网关配置文件注册中心地址和命名空间 ID

   ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvUwFS.jpg)

   ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvUDzj.png)

   - 启动网关服务 novel-gateway

     ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvU6Lq.jpg)

     ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvU2wV.png)

7. 启动监控服务。

   - 修改监控服务的配置中心地址和命名空间 ID![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvU4W4.png)

   - 修改监控微服务的注册中心地址和命名空间 ID以及登陆的用户名和密码![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvUqw6.png)

   - 启动监控服务 novel-monitor，启动方法和网关服务相同

   - 访问监控服务，因为网关中配置了监控服务的路由，所以可直接或通过网关来访问监控服务：http://<网关ip>:<网关端口号>/monitor

     ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvUXFO.png)

     

8. 启动业务微服务，这里以小说微服务为例。

   - 修改网关配置文件 book-service.yml 中的注册中心地址和命名空间ID，以及其他配置（数据库/redis/elasticsearch/mq等），方法同上

   - 启动 novel-service 服务，方法同上

   - 访问接口文档:http://<服务IP>:<服务端口号>/swagger-ui.html，

     例如：http://127.0.0.1:620/swagger-ui.html

     

9. 通过网关统一接口访问路径。

   http://<网关IP>:<网关端口号>/api/<接口路径>

   以小说小说分类列表查询接口为例：http://127.0.0.1:527/api/book/listBookCategory
   
10. 访问用户中心/作家中心等需要认证的接口。

    - 访问登陆接口获取JWT![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvUzSH.png)
    ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvRtIJ.png)

    - 设置 JWT 认证![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvRwxx.png)

    - 访问需要认证的接口![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvRBM6.png)

      ![image-20200529173322783](https://s3.ax1x.com/2020/11/11/BvRyZD.png)

#### 代码仓库

Gitee 仓库地址： https://gitee.com/xiongxyang/novel-cloud

Github 仓库地址：  https://github.com/201206030/novel-cloud

#### QQ交流群

[点击前往官网查看](https://xiongxyang.gitee.io/service.htm)

#### 微信公众号（发布最新更新资讯）

![mini-code](https://s3.ax1x.com/2020/12/03/DoImOx.png)

#### 捐赠支持

开源项目不易，若此项目能得到你的青睐，可以捐赠支持作者持续开发与维护。

![mini-code](https://s1.ax1x.com/2020/10/31/BUQJwq.png)

