# novel-cloud

#### 背景

小说网站业务难度适中，没有商城系统那种复杂的业务。但是作为互联网项目，一样需要面对大规模用户和海量数据的处理，所以高并发、高可用、高性能、高容错、可扩展性、可维护性也是小说网站设计需要考虑的问题，商城系统中所用到的技术同样适用于小说网站。综上所述，使用微服务架构来构建一个小说门户平台是非常有必要的，利用微服务构建的小说门户平台来学习现下流行技术相较于业务比较复杂的商场系统来说也是比较容易的，非常适合于没有实际项目经验的同学用来学习和入门微服务技术栈。

#### 介绍

Novel-Cloud是基于[小说精品屋-plus](https://www.oschina.net/p/novel-plus)构建的Spring Cloud 微服务小说门户学习平台，致力于原创文学阅读与写作，提供了爬虫工具用于开发过程中测试数据的采集。采用了Spring Boot 2.2.5.RELEASE 、Spring Cloud Hoxton.SR4、 MyBatis3DynamicSql、Redis、Mq、Elasticsearch、Docker等流行技术，集成了Nacos注册中心/配置中心、Spring Cloud Gateway网关、Spring Boot Admin监控中心等基础服务。前端计划使用Vue开发，后台接口一期开发已完成（充值/作家专区除外的所有接口）。

#### 演示地址

[点击前往](http://www.java2nb.com/)（前台门户）

#### 软件架构

![QQ20200520-215756](./assert/小说网站Springcloud架构设计.png)


#### 项目结构

```
novel-cloud
├── novel-common -- 通用模块，供其他业务微服务模块依赖
├── novel-gen -- 持久层代码生成器，集成Swagger
├── novel-gateway -- 基于Spring Cloud Gateway构建的网关服务
├── novel-monitor -- 基于Spring Boot Admin构建的监控中心
├── novel-search -- 基于Elastic Search构建的搜索微服务
├── novel-file -- 基于阿里云OSS构建的文件微服务
├── novel-home -- 门户首页微服务
├── novel-news -- 新闻中心微服务
├── novel-user -- 用户中心微服务
├── novel-author -- 作家中心微服务
├── novel-book -- 小说微服务
└── novel-pay -- 支付微服务
```

#### 技术选型

| 技术                 | 说明                                                         
| --------------------| ---------------------------
| SpringBoot          | Spring应用快速开发脚手架     
| SpringCloud         | 微服务架构解决方案 
| Nacos               | 注册中心和配置中心
| SpringCloud Gateway | 微服务网关
| SpringBoot Admin    | 微服务监控
| MyBatis             | 持久层ORM框架 
| MyBatis Dynamic SQL | Mybatis动态sql
| PageHelper          | MyBatis分页插件
| MyBatisGenerator    | 持久层代码生成插件
| Seata               | 分布式事务中间件
| Sharding-Jdbc       | 代码层分库分表中间件
| JJWT                | JWT登录支持  
| Redis               | 分布式缓存                              
| ElasticSearch       | 搜索引擎                
| RabbitMq            | 消息队列
| OSS                 | 阿里云对象存储服务   
| Mysql               | 数据库服务                 
| Redisson            | 实现分布式锁                                       
| Lombok              | 简化对象封装工具  
| Swagger             | API文档生成工具                                                                              
| Docker              | 应用容器引擎   
| ELK                 | 分布式日志分析   
| Vue                 | 前端开发框架

#### 数据模型

![QQ20200520-215756](./assert/QQ20200529-170006.png)

#### 截图

1. 注册中心截图

![QQ20200520-215756](./assert/QQ20200528-020224.png)

2. 配置中心截图

   ![QQ20200520-215756](./assert/QQ20200528-020357.png)

3. 监控中心截图

   ![QQ20200520-215756](./assert/QQ20200528-020445.png)

   ![QQ20200520-215756](./assert/QQ20200531-194554.png)

   ![QQ20200520-215756](./assert/QQ20200528-020543.png)

   

   4. 接口文档

      ![QQ20200520-215756](./assert/QQ20200528-200023.png)

      

      ![QQ20200520-215756](./assert/QQ20200528-221348.png)

      
   
      ![QQ20200520-215756](./assert/QQ20200529-082052.png)
   
   5. 门户网站
   
   ![QQ20200520-215756](./assert/pc_index.png)
   
   

#### 安装步骤

1. 下载源码，如果是ZIP包，下载后需要解压。

   ![image-20200529173322783](./assert/image-20200529173322783.png)

2. 开发环境配置，请确保开发机器上已安装如下软件环境。
   - [x] Java开发工具包jdk1.8+
   - [x] IDE（Eclipse或IntelliJ IDEA）
   - [x] 项目管理工具maven
   - [x] 微服务注册中心/配置中心nacos
   - [x] 分布式缓存服务Redis
   - [x] 搜索引擎服务ElasticSearch
   - [x] ElasticSearch可视化客户端Kibana
   - [x] 消息中间件RabbitMq
   - [x] 数据库服务Mysql
   
3. 登陆nacos配置中心导入下载源码中的配置文件。

   ![image-20200529173322783](./assert/QQ20200529-180807.png)![image-20200529173322783](./assert/QQ20200529-181203.png)

   ![image-20200529173322783](./assert/QQ20200529-181406.png)

   ![image-20200529173322783](./assert/QQ20200529-181531.png)

4. 使用IDE导入下载的源码（这里以IntelliJ IDEA为例）。

   ![image-20200529173322783](./assert/QQ20200529-175108.png)

5. 修改通用配置中的配置中心地址和命名空间ID。

   ![image-20200529182810929](./assert/QQ20200529-182931.png)

   ![image-20200529173322783](./assert/QQ20200529-182657.png)

6. 启动微服务网关。

   - 修改网关服务的配置中心地址和命名空间ID

     ![image-20200529173322783](./assert/QQ20200529-184805.png)

   - 修改网关配置文件注册中心地址和命名空间ID

   ![image-20200529173322783](./assert/QQ20200529-0.png)

   ![image-20200529173322783](./assert/QQ20200529-182356.png)

   - 启动网关服务novel-gateway

     ![image-20200529173322783](./assert/QQ20200529-1.png)

     ![image-20200529173322783](./assert/QQ20200529-183445.png)

7. 启动监控服务。

   - 修改监控服务的配置中心地址和命名空间ID![image-20200529173322783](./assert/QQ20200529-185750.png)

   - 修改监控微服务的注册中心地址和命名空间ID以及登陆的用户名和密码![image-20200529173322783](./assert/QQ20200529-185912.png)

   - 启动监控服务novel-monitor，启动方法和网关服务相同

   - 访问监控服务，因为网关中配置了监控服务的路由，所以可直接或通过网关来访问监控服务：http://<网关ip>:<网关端口号>/monitor

     ![image-20200529173322783](./assert/QQ20200529-190730.png)

     

8. 启动业务微服务，这里以小说微服务为例。

   - 修改网关配置文件book-service.yml中的注册中心地址和命名空间ID，以及其他配置（数据库/redis/elasticsearch/mq等），方法同上

   - 启动novel-service服务，方法同上

   - 访问接口文档:http://<服务IP>:<服务端口号>/swagger-ui.html，

     例如：http://127.0.0.1:620/swagger-ui.html

     

9. 通过网关统一接口访问路径。

   http://<网关IP>:<网关端口号>/api/<接口路径>

   以小说小说分类列表查询接口为例：http://127.0.0.1:527/api/book/listBookCategory
   
10. 访问用户中心/作家中心等需要认证的接口。

    - 访问登陆接口获取JWT![image-20200529173322783](./assert/QQ20200602-194556.png)![image-20200529173322783](./assert/QQ20200602-194713.png)

    - 设置JWT认证![image-20200529173322783](./assert/QQ20200602-194859.png)

    - 访问需要认证的接口![image-20200529173322783](./assert/QQ20200602-195025.png)

      ![image-20200529173322783](./assert/QQ20200602-195114.png)

#### 代码仓库

Gitee仓库地址： https://gitee.com/xiongxyang/novel-cloud

GitHub仓库地址：  https://github.com/201206030/novel-cloud

#### QQ交流群

![mini-code](https://gitee.com/xiongxyang/novel-plus/raw/release_v2.5.0/assets/%E5%B0%8F%E8%AF%B4%E7%B2%BE%E5%93%81%E5%B1%8B%E5%BC%80%E6%BA%90%E9%A1%B9%E7%9B%AE%E4%BA%A4%E6%B5%81%E7%BE%A4%E7%BE%A4%E8%81%8A%E4%BA%8C%E7%BB%B4%E7%A0%81.png)

#### 捐赠支持

开源项目不易，若此项目能得到你的青睐，可以捐赠支持作者持续开发与维护。

![mini-code](https://gitee.com/xiongxyang/novel-plus/raw/release_v2.5.0/assets/jk.png)