# **iBiz4j Spring R7 Template**

### 技术栈
我们的目标为您生成一个完整和现代Web应用或者微服务架构, 具体如下:

#### 完整的[Spring应用](https://spring.io/):

* 基于[Spring Boot](https://projects.spring.io/spring-boot/)提供应用配置简化
* [Maven](https://maven.apache.org/)构建，测试，运行应用
* [Spring Security](https://docs.spring.io/spring-security/site/index.html)组件
* [JSON Web令牌（JWT）](https://jwt.io/)身份验证安全机制
* [Spring MVC REST](https://spring.io/guides/gs/rest-service/) + [Jackson](https://github.com/FasterXML/jackson)
* [Swagger](https://swagger.io/)来自动生成REST Controller API文档
* [Zalando Problem Spring Web](https://github.com/zalando/problem-spring-web)处理异常
* ~~基于Spring websocket组件, 可选的Websocket支持~~
* [Mybatis-plus](https://mp.baomidou.com/) / [Spring Data JPA](https://projects.spring.io/spring-data-jpa/)和Bean校验
* 基于[Liquibase](http://www.liquibase.org/)数据库更新
* [Elasticsearch](https://github.com/elastic/elasticsearch)支持，如果你需要基于你的数据库提供高级搜索能力
* [MongoDB](https://www.mongodb.org/)支持, 如果你想使用面向文档的NOSQL数据库替代JPA
* [~~Cassandra~~](https://cassandra.apache.org/)~~支持, 如果你想使用面向列的NOSQL数据库替代JPA~~
* [RocketMQ](http://rocketmq.apache.org/)支持, 如果你需要一个消息发布订阅系统
* 构建标准可执行的JAR文件

#### 微服务[Microservices](https://microservices.io):

* 基于[Netflix Zuul](https://github.com/Netflix/zuul)的HTTP流量路由
* 基于[Nacos](https://nacos.io/zh-cn/index.html)或[Eureka](https://github.com/Netflix/eureka)的服务发现
* 基于[Feign](https://github.com/OpenFeign/feign)的服务消费客户端

#### 生产环境组件:
* 使用[Druid](https://github.com/alibaba/druid)和[ELK Stack](https://www.elastic.co/products)监控
* 使用[Caffeine](https://github.com/ben-manes/caffeine) + [Redis](https://redis.io/)提供两级缓存
* 静态资源优化 (gzip filter, HTTP cache headers)
* 使用[Logback](http://logback.qos.ch/)管理日志，可在运行时配置日志输出
* 使用[dynamic datasource](https://gitee.com/baomidou/dynamic-datasource-spring-boot-starter)多库切换和读写分离，极致的性能提升
* 使用[xxl-job](https://github.com/xuxueli/xxl-job)任务调度引擎
* 完整的[Docker](https://www.docker.com/)和[Docker Compose](https://github.com/docker/compose)支持
* ~~支持云服务提供商: …~~