<#ibiztemplate>
TARGET=PSSYSSERVICEAPI
</#ibiztemplate>
<#assign httpPort = "8081">
<#assign nacosUrl = "127.0.0.1:8848" >
<#assign redisHost = "127.0.0.1" >
<#assign redisPort = "6379" >
<#assign redisDataBase = "0" >
<#assign dbUserName="root">
<#assign dbPassWord="123456">
<#assign dbUrl="jdbc:mysql://127.0.0.1:3306/"+sys.name+"?useSSL=false&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useOldAliasMetadataBehavior=true&allowMultiQueries=true">
<#assign dbDriver="com.mysql.jdbc.Driver">
<#assign dockerPortMap="">
<#assign dockerimage="">
<#assign servicehubid="">
<#if sysrun?? && sysrun.getPSDevSlnMSDepAPI()?? >
    <#assign depSysApi=sysrun.getPSDevSlnMSDepAPI()>
    <#if depSysApi.getHttpPort()??>
        <#assign httpPort = depSysApi.getHttpPort()?c>
    </#if>
    <#if depSysApi.getPSDCMSPlatformNode()??>
        <#assign depSysApiPlatformNode=depSysApi.getPSDCMSPlatformNode()>
        <#assign depSysApiPlatform=depSysApi.getPSDCMSPlatform()>
        <#if depSysApiPlatform.getUserParam("nacos","127.0.0.1:8848")??>
            <#assign nacosUrl = depSysApiPlatform.getUserParam("nacos","127.0.0.1:8848")>
        </#if>
        <#if depSysApi.getUserParam("spring.redis.host","")?? && depSysApi.getUserParam("spring.redis.host","")!="">
            <#assign redisHost = depSysApi.getUserParam("spring.redis.host","")>
        <#elseif depSysApiPlatform.getUserParam("spring.redis.host","")?? && depSysApiPlatform.getUserParam("spring.redis.host","")!="">
            <#assign redisHost = depSysApiPlatform.getUserParam("spring.redis.host","")>
        </#if>
        <#if depSysApi.getUserParam("spring.redis.port","")?? && depSysApi.getUserParam("spring.redis.port","")!="">
            <#assign redisPort = depSysApi.getUserParam("spring.redis.port")>
        <#elseif depSysApiPlatform.getUserParam("spring.redis.port","")?? && depSysApiPlatform.getUserParam("spring.redis.port","")!="">
            <#assign redisPort = depSysApiPlatform.getUserParam("spring.redis.port")>
        </#if>
        <#if depSysApi.getUserParam("spring.redis.database","")?? && depSysApi.getUserParam("spring.redis.database","")!="">
            <#assign redisDataBase = depSysApi.getUserParam("spring.redis.database","")>
        <#elseif depSysApiPlatform.getUserParam("spring.redis.database","")?? && depSysApiPlatform.getUserParam("spring.redis.database","")!="">
            <#assign redisDataBase = depSysApiPlatform.getUserParam("spring.redis.database","")>
        </#if>
        <#if depSysApi.getUserParam("portmap","")?? && depSysApi.getUserParam("portmap","")!="">
            <#assign dockerPortMap= depSysApi.getUserParam("portmap","")>
        </#if>
        <#if depSysApi.getUserParam("dockerimage","")?? && depSysApi.getUserParam("dockerimage","")!="">
            <#assign servicehubid=depSysApiPlatformNode.name>
            <#assign dockerimage= depSysApi.getUserParam("dockerimage","")>
        </#if>
    </#if>
</#if>
<#comment>数据库配置</#comment>
<#if sysrun.getPSDBDevInst()??>
    <#assign sysRunDBInst = sysrun.getPSDBDevInst()>
    <#assign dbUserName=sysRunDBInst.getUserName()>
    <#assign dbPassWord=sysRunDBInst.getPassword()>
    <#assign dbUrl=sysRunDBInst.getConnUrl()>
    <#if (sysRunDBInst.getDBType()=='MYSQL5')>
        <#assign dbDriver="com.mysql.jdbc.Driver">
        <#assign dbUrl=dbUrl+"&allowMultiQueries=true&serverTimezone=GMT%2B8">
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
version: "3.2"
services:
  ${pub.getCodeName()?lower_case}-provider:
    <#if dockerimage!=''>
    image: ${dockerimage}
    <#else>
    image: dstimage
    </#if>
    ports:
      - "${httpPort}:${httpPort}"
    <#if dockerPortMap!=''>
      - "${dockerPortMap}"
    </#if>
    networks:
      - agent_network
  <#if  sysrun?? && sysrun.getPSDevSlnMSDepAPI()?? && sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatformNode()??>
      <#assign depSysApi=sysrun.getPSDevSlnMSDepAPI()>
      <#assign depSysApiPlatformNode=sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatformNode()>
      <#assign depSysApiPlatform=sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatform()>
    environment:
      <#if depSysApiPlatformNode.getSSHIPAddr()??>
      - SPRING_CLOUD_NACOS_DISCOVERY_IP=${depSysApiPlatformNode.getSSHIPAddr()}
      </#if>
      <#if servicehubid!=''>
      - IBIZ_SERVICEHUB_ID=${servicehubid}
      </#if>     
      <#comment>系统运行参数设置，从SysRun中获取到当前部署相关信息</#comment> 
      - SERVER_PORT=${httpPort}
      - SPRING_CLOUD_NACOS_DISCOVERY_SERVER-ADDR=${nacosUrl}
      - SPRING_CLOUD_NACOS_CONFIG_SERVER-ADDR=${nacosUrl}
      - SPRING_REDIS_HOST=${redisHost}
      - SPRING_REDIS_PORT=${redisPort}
      - SPRING_REDIS_DATABASE=${redisDataBase}
      - SPRING_DATASOURCE_USERNAME=${dbUserName}
      - SPRING_DATASOURCE_PASSWORD=${dbPassWord}
      - SPRING_DATASOURCE_URL=${dbUrl}
      - SPRING_DATASOURCE_DRIVER-CLASS-NAME=${dbDriver}
      - SPRING_DATASOURCE_DEFAULTSCHEMA=${dbUserName}
      <#comment>输出服务接口自定义参数替换标准参数</#comment>
      <#if depSysApi.getUserParamNames()??>
          <@outputUserParam depSysApi depSysApi.getUserParamNames()/>
      </#if>
      <#comment>输出微服务平台自定义参数替换标准参数</#comment>
      <#if depSysApiPlatform.getUserParamNames()??>
          <@outputUserParam depSysApiPlatform depSysApiPlatform.getUserParamNames()/>
      </#if>
  </#if>
    deploy:
      resources:
           limits:
               memory: 4048M
           reservations:
               memory: 400M    
      mode: replicated
      replicas: 1
      restart_policy:
        condition: on-failure
        max_attempts: 3
        window: 120s
    volumes:
      - "nfs:/app/file"

volumes:
  nfs:
    driver: local
    driver_opts:
      type: "nfs"
      o: "addr=172.16.240.140,rw"
      device: ":/data/nfs"

networks:
  agent_network:
    driver: overlay
    attachable: true

<#comment>输出用户自定义参数</#comment>
<#macro outputUserParam paramObj paramList>
    <#list paramList as param>
        <#assign userParamkey=param?upper_case?replace(".","_")>
        <#comment>nacos、数据库连接等信息从sysRun中获取</#comment>
        <#if userParamkey!="SPRING_CLOUD_NACOS_DISCOVERY_SERVER-ADDR" && userParamkey!="SPRING_REDIS_HOST" &&
        userParamkey!="SERVER_PORT" &&userParamkey!="SPRING_REDIS_PORT" &&userParamkey!="SPRING_REDIS_DATABASE"
        &&userParamkey!="SPRING_DATASOURCE_USERNAME" &&userParamkey!="SPRING_DATASOURCE_PASSWORD"
        &&userParamkey!="SPRING_DATASOURCE_URL" &&userParamkey!="SPRING_DATASOURCE_DRIVER-CLASS-NAME" &&userParamkey!="SPRING_DATASOURCE_DEFAULTSCHEMA">
            <#comment>扩展标准配置:用户配置参数替换标准配置(application-sys.yml)</#comment>
            <#if !P.exists('SysApiDeployUserParam',param)>
      - ${userParamkey}=${paramObj.getUserParam(param,"")}
            </#if>
        </#if>
    </#list>
</#macro>