<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<#comment>通用配置文件</#comment>
<#assign redisHost = "127.0.0.1" >
<#assign redisPort = "6379" >
<#assign redisDataBase = "0" >
<#assign dbUserName="root">
<#assign dbPassWord="123456">
<#assign dbUrl="jdbc:mysql://mysql:3306/"+sys.name+"?useSSL=false&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useOldAliasMetadataBehavior=true&allowMultiQueries=true">
<#assign dbDriver="com.mysql.jdbc.Driver">
<#assign bmogo=false>
<#assign mongodbUri="mongodb://"+sys.name+":"+sys.name+"@127.0.0.1:27017/"+sys.name>
<#assign hasMQProducer=false>
<#assign hasMQConsumer=false>
<#if sys.getAllPSDataEntities()??>
    <#list sys.getAllPSDataEntities() as de>
        <#if de.getStorageMode()?? && de.getStorageMode()==2>
        <#assign bmogo=true>
        <#break >
        </#if>
    </#list>
</#if>
<#assign hasESEntity=false>
<#list sys.getAllPSDataEntities() as dataEntity>
    <#if dataEntity.getUserTag()?? && dataEntity.getUserTag()=='elasticsearch'>
        <#assign hasESEntity=true>
        <#break>
    </#if>
</#list>
<#assign TcServerCluster="default">
<#assign seataServerName="seata-server">
<#assign nacosAddress="localhost">
<#assign nacosGroup="DEFAULT_GROUP">
<#assign nacosNamespace="">
<#assign nacosUserName="">
<#assign nacosPassWord="">

<#comment>前端应用微服务平台配置</#comment>
<#if sys.getAllPSDevSlnMSDepApps()??>
  <#list sys.getAllPSDevSlnMSDepApps() as depApp>
      <#if depApp.getPSDCMSPlatform()??>
        <#assign appPlatform=depApp.getPSDCMSPlatform()>
        <#if appPlatform.getUserParam("spring.redis.host","127.0.0.1")??>
            <#assign redisHost = appPlatform.getUserParam("spring.redis.host","127.0.0.1")>
        </#if>
        <#if appPlatform.getUserParam("spring.redis.port","6379")??>
            <#assign redisPort = appPlatform.getUserParam("spring.redis.port","6379")>
        </#if>
        <#if appPlatform.getUserParam("spring.redis.database","0")??>
            <#assign redisDataBase = appPlatform.getUserParam("spring.redis.database","0")>
        </#if>
        <#if appPlatform.getUserParam("spring.data.mongodb.uri",mongodbUri)??>
            <#assign mongodbUri = appPlatform.getUserParam("spring.data.mongodb.uri",mongodbUri)>
        </#if>
        <#if appPlatform.getUserParam("seata.service.vgroup-mapping."+sys.getName()+"group",TcServerCluster)??>
              <#assign TcServerCluster = appPlatform.getUserParam("seata.service.vgroup-mapping."+sys.getName()+"group",TcServerCluster)>
        </#if>
        <#if appPlatform.getUserParam("seata.registry.nacos.application",seataServerName)??>
              <#assign seataServerName = appPlatform.getUserParam("seata.registry.nacos.application",seataServerName)>
        </#if>
        <#if appPlatform.getUserParam("seata.registry.nacos.server-addr",nacosAddress)??>
              <#assign nacosAddress = appPlatform.getUserParam("seata.registry.nacos.server-addr",nacosAddress)>
        </#if>
        <#if appPlatform.getUserParam("seata.registry.nacos.group",nacosGroup)??>
              <#assign nacosGroup = appPlatform.getUserParam("seata.registry.nacos.group",nacosGroup)>
        </#if>
        <#if appPlatform.getUserParam("seata.registry.nacos.namespace",nacosNamespace)??>
              <#assign nacosNamespace = appPlatform.getUserParam("seata.registry.nacos.namespace",nacosNamespace)>
        </#if>
        <#if appPlatform.getUserParam("seata.registry.nacos.userName",nacosUserName)??>
              <#assign nacosUserName = appPlatform.getUserParam("seata.registry.nacos.userName",nacosUserName)>
        </#if>
        <#if appPlatform.getUserParam("seata.registry.nacos.password",nacosPassWord)??>
              <#assign nacosPassWord = appPlatform.getUserParam("seata.registry.nacos.password",nacosPassWord)>
        </#if>
        <#break>
    </#if>
  </#list>
</#if>
<#comment>服务接口微服务平台配置</#comment>
<#if sys.getAllPSDevSlnMSDepAPIs()??>
  <#list sys.getAllPSDevSlnMSDepAPIs() as depSysApi>
    <#if depSysApi.getPSDCMSPlatform()?? >
      <#assign sysApiPlatform=depSysApi.getPSDCMSPlatform()>
      <#if sysApiPlatform.getUserParam("spring.redis.host","127.0.0.1")??>
            <#assign redisHost = sysApiPlatform.getUserParam("spring.redis.host","127.0.0.1")>
      </#if>
      <#if sysApiPlatform.getUserParam("spring.redis.port","6379")??>
            <#assign redisPort = sysApiPlatform.getUserParam("spring.redis.port","6379")>
      </#if>
      <#if sysApiPlatform.getUserParam("spring.redis.database","0")??>
            <#assign redisDataBase = sysApiPlatform.getUserParam("spring.redis.database","0")>
      </#if>
       <#if sysApiPlatform.getUserParam("spring.data.mongodb.uri",mongodbUri)??>
            <#assign mongodbUri = sysApiPlatform.getUserParam("spring.data.mongodb.uri",mongodbUri)>
       </#if>
        <#if sysApiPlatform.getUserParam("seata.service.vgroup-mapping."+sys.getName()+"group",TcServerCluster)??>
            <#assign TcServerCluster = sysApiPlatform.getUserParam("seata.service.vgroup-mapping."+sys.getName()+"group",TcServerCluster)>
        </#if>
        <#if sysApiPlatform.getUserParam("seata.registry.nacos.application",seataServerName)??>
            <#assign seataServerName = sysApiPlatform.getUserParam("seata.registry.nacos.application",seataServerName)>
        </#if>
        <#if sysApiPlatform.getUserParam("seata.registry.nacos.server-addr",nacosAddress)??>
            <#assign nacosAddress = sysApiPlatform.getUserParam("seata.registry.nacos.server-addr",nacosAddress)>
        </#if>
        <#if sysApiPlatform.getUserParam("seata.registry.nacos.group",nacosGroup)??>
            <#assign nacosGroup = sysApiPlatform.getUserParam("seata.registry.nacos.group",nacosGroup)>
        </#if>
        <#if sysApiPlatform.getUserParam("seata.registry.nacos.namespace",nacosNamespace)??>
            <#assign nacosNamespace = sysApiPlatform.getUserParam("seata.registry.nacos.namespace",nacosNamespace)>
        </#if>
        <#if sysApiPlatform.getUserParam("seata.registry.nacos.userName",nacosUserName)??>
            <#assign nacosUserName = sysApiPlatform.getUserParam("seata.registry.nacos.userName",nacosUserName)>
        </#if>
        <#if sysApiPlatform.getUserParam("seata.registry.nacos.password",nacosPassWord)??>
            <#assign nacosPassWord = sysApiPlatform.getUserParam("seata.registry.nacos.password",nacosPassWord)>
        </#if>
      <#break>
    </#if>
  </#list>
</#if>
<#comment>一键发布数据库配置</#comment>
<#if sysrun.getPSDBDevInst()??>
    <#assign sysRunDBInst = sysrun.getPSDBDevInst()>
    <#assign dbUserName=sysRunDBInst.getUserName()>
    <#assign dbPassWord=sysRunDBInst.getPassword()>
    <#assign dbUrl=sysRunDBInst.getConnUrl()>
    <#if (sysRunDBInst.getDBType()=='MYSQL5')>
        <#assign dbDriver="com.mysql.jdbc.Driver">
        <#assign dbUrl=dbUrl+"&allowMultiQueries=true&useSSL=false">
    <#elseif (sysRunDBInst.getDBType()=='DB2')>
        <#assign dbDriver="com.ibm.db2.jcc.DB2Driver">
    <#elseif (sysRunDBInst.getDBType()=='ORACLE')>
        <#assign dbDriver="oracle.jdbc.driver.OracleDriver">
    <#elseif (sysRunDBInst.getDBType()=='SQLSERVER')>
        <#assign dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver">
    <#elseif (sysRunDBInst.getDBType()=='POSTGRESQL')>
        <#assign dbDriver="org.postgresql.Driver">
    <#elseif (sysRunDBInst.getDBType()=='PPAS')>
        <#assign dbDriver="com.edb.Driver">
    </#if>
</#if>
<#comment>部署-前端应用数据库配置</#comment>
<#if sys.getAllPSDevSlnMSDepApps()??>
  <#list sys.getAllPSDevSlnMSDepApps() as depApp>
    <#if depApp.getPSDBDevInst()??>
      <#assign appDBInst=depApp.getPSDBDevInst()>
      <#assign dbUserName=appDBInst.getUserName()>
      <#assign dbPassWord=appDBInst.getPassword()>
      <#assign dbUrl=appDBInst.getConnUrl()>
      <#if (appDBInst.getDBType()=='MYSQL5')>
        <#assign dbDriver="com.mysql.jdbc.Driver">
        <#assign dbUrl=dbUrl+"&allowMultiQueries=true&useSSL=false">
      <#elseif (appDBInst.getDBType()=='DB2')>
        <#assign dbDriver="com.ibm.db2.jcc.DB2Driver">
      <#elseif (appDBInst.getDBType()=='ORACLE')>
        <#assign dbDriver="oracle.jdbc.driver.OracleDriver">
      <#elseif (appDBInst.getDBType()=='SQLSERVER')>
        <#assign dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver">
      <#elseif (appDBInst.getDBType()=='POSTGRESQL')>
        <#assign dbDriver="org.postgresql.Driver">
      <#elseif (appDBInst.getDBType()=='PPAS')>
        <#assign dbDriver="com.edb.Driver">
      </#if>
      <#break>
    </#if>
  </#list>
</#if>
<#comment>部署-服务接口数据库配置</#comment>
<#if sys.getAllPSDevSlnMSDepAPIs()??>
  <#list sys.getAllPSDevSlnMSDepAPIs() as depSysApi>
    <#if depSysApi.getPSDBDevInst()??>
      <#assign sysApiDBInst=depSysApi.getPSDBDevInst()>
      <#assign dbUserName=sysApiDBInst.getUserName()>
      <#assign dbPassWord=sysApiDBInst.getPassword()>
      <#assign dbUrl=sysApiDBInst.getConnUrl()>
      <#if (sysApiDBInst.getDBType()=='MYSQL5')>
        <#assign dbDriver="com.mysql.jdbc.Driver">
        <#assign dbUrl=dbUrl+"&allowMultiQueries=true&serverTimezone=GMT%2B8&useSSL=false">
      <#elseif (sysApiDBInst.getDBType()=='DB2')>
        <#assign dbDriver="com.ibm.db2.jcc.DB2Driver">
      <#elseif (sysApiDBInst.getDBType()=='ORACLE')>
        <#assign dbDriver="oracle.jdbc.driver.OracleDriver">
      <#elseif (sysApiDBInst.getDBType()=='SQLSERVER')>
        <#assign dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver">
      <#elseif (sysApiDBInst.getDBType()=='POSTGRESQL')>
        <#assign dbDriver="org.postgresql.Driver">
      <#elseif (sysApiDBInst.getDBType()=='PPAS')>
        <#assign dbDriver="com.edb.Driver">
      </#if>
      <#break>
    </#if>
  </#list>
</#if>
#缓存、数据源
spring:
  jackson:
    time-zone: GMT+8
  cache:
    redis:
      time-to-live: 72000
    caffeine:
      spec: initialCapacity=5,maximumSize=500,expireAfterWrite=72000s
  redis:
    host: 172.16.240.110
    port: 6379
    password:
    database: 0
    lettuce:
      pool:
        max-active: 32
        max-wait: 300ms
        max-idle: 16
        min-idle: 8
  servlet:
    multipart:
      max-file-size: 100MB
      max-request-size: 100MB
<#if bmogo || hasESEntity>
  data:
    <#if bmogo>
    mongodb:
      uri: ${mongodbUri}
    </#if>
    <#if hasESEntity>
    elasticsearch:
      cluster-name: es-cluster
      cluster-nodes: 127.0.0.1:9300
      repositories:
        enabled: true
    </#if>
<#if hasESEntity>
management:
  health:
    elasticsearch:
      enabled: false
</#if>
</#if>
<@dynamicDatasourceConfig/>
  #启动是否加载liquibase构建表结构
  liquibase:
    enabled: false
    change-log: classpath:liquibase/master_table.xml

# Mybatis-plus配置
mybatis-plus:
  global-config:
    refresh-mapper: true
    db-config:
      # 全局逻辑已删除默认值
      logic-delete-value: 0
      # 全局逻辑未删除默认值
      logic-not-delete-value: 1
#   mapper-locations: classpath*:/mapper/*/*/*.xml
  configuration:
    jdbc-type-for-null: 'null'
    map-underscore-to-camel-case: false
  type-handlers-package: net.ibizsys.central.plugin.mybatisplus.spring.typehandler

# 阿里sentinel熔断器
feign:
  httpclient:
    enabled: true
  sentinel:
    enabled: true
  compression:
    request:
      enabled: true
      mime-types: application/javascript,text/css,application/json,application/xml,text/html,text/xml,text/plain
      min-response-size: 10240
    response:
      enabled: true

#zuul网关超时设置
ribbon:
  ReadTimeout: 60000
  ConnectTimeout: 60000
  
#Log配置
logging:
  level:
    net.ibizsys.central.database.mybatis: INFO
    org.springframework.boot.autoconfigure: ERROR

<#assign enableDataAcc="false">
#系统是否开启权限验证、是否开启缓存
#缓存级别：无缓存(无配置项)、一级缓存(L1)、二级缓存(L2)
ibiz:
  db:
    batchsize: 2000
  auth:
    excludesPattern: /v7/login,/uaa/login,/uaa/loginbyusername,/uaa/casproxylogin
  <#if sys.getPSSystemSetting()?? && sys.getPSSystemSetting().getDataAccCtrlArch()?? && sys.getPSSystemSetting().getDataAccCtrlArch()==1>
    <#assign enableDataAcc="true">
  </#if>
  enablePermissionValid: ${enableDataAcc}
  cacheLevel: L2 #(L1)一级本地caffeine缓存;(L2)caffeine缓存+Redis缓存
  deploysystems:
    - deploysystemobj: ${pub.getPKGCodeName()}.core.runtime.SystemRuntime
      deploysystemid: ${item.getName()}
#      fromjar: false
#      modelpath: model
      fromjar: true
      modelpath: model--${sys.getPubSystemId()}--${sys.getSysVersion()}
      db: master

# jobs:
#   admin-address: http://127.0.0.1:40005
#   app-name: ${sys.getName()}
#   app-port: 9999
#   app-ip: 127.0.0.1

### 启用Gzip压缩
server:
 compression:
   enabled: true
   mime-types: application/javascript,text/css,application/json,application/xml,text/html,text/xml,text/plain
   min-response-size: 10240

<#if pub.isEnableGlobalTransaction?? && pub.isEnableGlobalTransaction()?? && pub.isEnableGlobalTransaction()==true>
seata:
  enabled: true    #是否开启全局事务
  application-id: ${sys.getName()}        #服务标识
  tx-service-group: ${sys.getName()}group #事务组
  service:
    vgroup-mapping:
      ${sys.getName()}group: ${TcServerCluster}   #指定事务组对应的Tc Server集群
  registry:
    type: nacos   #注册中心
    nacos:
      application: ${seataServerName}  #Tc Server服务标识
      server-addr: ${nacosAddress}     #注册中心地址
      group: ${nacosGroup}             #服务组
      namespace: ${nacosNamespace}     #服务命名空间
      userName: "${nacosUserName}"     #用户名
      password: "${nacosPassWord}"     #密码
</#if>

<#assign producerMQServer="127.0.0.1:9876">
<#assign consumerMQServer="127.0.0.1:9876">
<#assign producerisOnOff="off">
<#assign consumerisOnOff="off">
<#assign producerGroupName="default">
<#assign consumerGroupName="default">
<#assign producerTopic="default">
<#assign consumerTopic="default">
<#if sys.getAllPSDevSlnMSDepAPIs()??>
    <#list sys.getAllPSDevSlnMSDepAPIs() as depSysApi>
        <#if depSysApi.getPSDCMSPlatform()?? >
            <#if depSysApi.getUserParam("rocketmq.producer.namesrvAddr","")?? && depSysApi.getUserParam("rocketmq.producer.namesrvAddr","")!=''>
                <#assign hasMQProducer=true>
                <#assign producerMQServer=depSysApi.getUserParam("rocketmq.producer.namesrvAddr","")>
                <#if depSysApi.getUserParam("rocketmq.producer.isOnOff","")?? && depSysApi.getUserParam("rocketmq.producer.isOnOff","")!=''>
                    <#assign producerMQServer=depSysApi.getUserParam("rocketmq.producer.isOnOff","")>
                </#if>
                <#if depSysApi.getUserParam("rocketmq.producer.groupName","")?? && depSysApi.getUserParam("rocketmq.producer.groupName","")!=''>
                    <#assign producerGroupName=depSysApi.getUserParam("rocketmq.producer.groupName","")>
                </#if>
                <#if depSysApi.getUserParam("rocketmq.producer.topic","")?? && depSysApi.getUserParam("rocketmq.producer.topic","")!=''>
                    <#assign producerTopic=depSysApi.getUserParam("rocketmq.producer.topic","")>
                </#if>
            </#if>
            <#if depSysApi.getUserParam("rocketmq.consumer.namesrvAddr","")?? && depSysApi.getUserParam("rocketmq.consumer.namesrvAddr","")!=''>
                <#assign hasMQConsumer=true>
                <#assign consumerMQServer=depSysApi.getUserParam("rocketmq.consumer.namesrvAddr","")>
                <#if depSysApi.getUserParam("rocketmq.consumer.isOnOff","")?? && depSysApi.getUserParam("rocketmq.consumer.isOnOff","")!=''>
                    <#assign consumerisOnOff=depSysApi.getUserParam("rocketmq.consumer.isOnOff","")>
                </#if>
                <#if depSysApi.getUserParam("rocketmq.consumer.groupName","")?? && depSysApi.getUserParam("rocketmq.consumer.groupName","")!=''>
                    <#assign consumerGroupName=depSysApi.getUserParam("rocketmq.consumer.groupName","")>
                </#if>
                <#if depSysApi.getUserParam("rocketmq.consumer.topic","")?? && depSysApi.getUserParam("rocketmq.consumer.topic","")!=''>
                    <#assign consumerTopic=depSysApi.getUserParam("rocketmq.consumer.topic","")>
                </#if>
            </#if>
        </#if>
    </#list>
</#if>
<#if hasMQProducer ||hasMQConsumer>
rocketmq:
    <#if hasMQProducer>
  producer:
    namesrvAddr: ${producerMQServer}
    isOnOff: 'on'
    groupName: ${producerGroupName}
    topic: ${producerTopic}
    </#if>
    <#if hasMQConsumer>
  consumer:
    namesrvAddr: ${consumerMQServer}
    isOnOff: 'on'
    groupName: ${consumerGroupName}
    topic: ${consumerTopic}
    </#if>
</#if>

<#macro dynamicDatasourceConfig>
  datasource:
    username: ${dbUserName}
    password: '${dbPassWord}'
    url: ${dbUrl}
    driver-class-name: ${dbDriver}
    isSyncDBSchema: false
    defaultSchema: <#if dbUserName=='root'>${sys.name}<#else>${dbUserName}</#if>
    dynamic:
      druid: #以下是全局默认值，可以全局更改
        filters: stat,wall,log4j2
        #配置初始化大小/最小/最大
        initial-size: 1
        min-idle: 1
        max-active: 20
        #获取连接等待超时时间
        max-wait: 60000
        #间隔多久进行一次检测，检测需要关闭的空闲连接
        time-between-eviction-runs-millis: 60000
        #一个连接在池中最小生存的时间
        min-evictable-idle-time-millis: 300000
        validation-query: SELECT 1 FROM DUAL
        test-while-idle: true
        test-on-borrow: false
        test-on-return: false
        #打开PSCache，并指定每个连接上PSCache的大小。oracle设为true，mysql设为false。分库分表较多推荐设置为false
        pool-prepared-statements: false
        max-pool-prepared-statement-per-connection-size: 20
      datasource:
        master:
          username: ${r'${spring.datasource.username}'}
          password: ${r'${spring.datasource.password}'}
          url: ${r'${spring.datasource.url}'}
          driver-class-name: ${r'${spring.datasource.driver-class-name}'}
    <#list sys.getAllPSDataEntities() as entity>
        <#if (entity.getStorageMode()==1 || entity.getStorageMode()==2) && entity.getDSLink()!='DEFAULT'>
        <#assign dbLink=entity.getDSLink()?lower_case>
            <#if !P.exists('dynamicDatasource',dbLink)>
        ${dbLink}:
          username: ${r'${spring.datasource.username}'}
          password: ${r'${spring.datasource.password}'}
          url: ${r'${spring.datasource.url}'}
          driver-class-name: ${r'${spring.datasource.driver-class-name}'}
            </#if>
        </#if>
    </#list>
</#macro>



