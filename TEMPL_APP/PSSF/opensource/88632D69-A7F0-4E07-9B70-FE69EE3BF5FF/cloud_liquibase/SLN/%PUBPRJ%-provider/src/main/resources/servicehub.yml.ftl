<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<#comment>通用配置文件</#comment>
<#assign dbUserName="">
<#assign dbPassWord="">
<#assign dbUrl="">
<#assign dbDriver="">
<#assign dbType="">
<#comment>一键发布数据库配置</#comment>
<#if sysrun.getPSDBDevInst()??>
    <#assign sysRunDBInst = sysrun.getPSDBDevInst()>
    <#assign dbUserName=sysRunDBInst.getUserName()>
    <#assign dbPassWord=sysRunDBInst.getPassword()>
    <#assign dbUrl=sysRunDBInst.getConnUrl()>
    <#if (sysRunDBInst.getDBType()=='MYSQL5')>
        <#assign dbType = sysRunDBInst.getDBType()>
        <#assign dbDriver="com.mysql.jdbc.Driver">
        <#assign dbUrl=dbUrl+"&allowMultiQueries=true&useSSL=false">
    <#elseif (sysRunDBInst.getDBType()=='DB2')>
        <#assign dbType = sysRunDBInst.getDBType()>
        <#assign dbDriver="com.ibm.db2.jcc.DB2Driver">
    <#elseif (sysRunDBInst.getDBType()=='ORACLE')>
        <#assign dbType = sysRunDBInst.getDBType()>
        <#assign dbDriver="oracle.jdbc.driver.OracleDriver">
    <#elseif (sysRunDBInst.getDBType()=='SQLSERVER')>
        <#assign dbType = sysRunDBInst.getDBType()>
        <#assign dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver">
    <#elseif (sysRunDBInst.getDBType()=='POSTGRESQL')>
        <#assign dbType = sysRunDBInst.getDBType()>
        <#assign dbDriver="org.postgresql.Driver">
    <#elseif (sysRunDBInst.getDBType()=='PPAS')>
        <#assign dbType = sysRunDBInst.getDBType()>
        <#assign dbDriver="com.edb.Driver">
    </#if>
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
        <#assign dbType = sysApiDBInst.getDBType()>
        <#assign dbDriver="com.mysql.jdbc.Driver">
        <#assign dbUrl=dbUrl+"&allowMultiQueries=true&serverTimezone=GMT%2B8&useSSL=false">
      <#elseif (sysApiDBInst.getDBType()=='DB2')>
        <#assign dbType = sysApiDBInst.getDBType()>
        <#assign dbDriver="com.ibm.db2.jcc.DB2Driver">
      <#elseif (sysApiDBInst.getDBType()=='ORACLE')>
        <#assign dbType = sysApiDBInst.getDBType()>
        <#assign dbDriver="oracle.jdbc.driver.OracleDriver">
      <#elseif (sysApiDBInst.getDBType()=='SQLSERVER')>
        <#assign dbType = sysApiDBInst.getDBType()>
        <#assign dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver">
      <#elseif (sysApiDBInst.getDBType()=='POSTGRESQL')>
        <#assign dbType = sysApiDBInst.getDBType()>
        <#assign dbDriver="org.postgresql.Driver">
      <#elseif (sysApiDBInst.getDBType()=='PPAS')>
        <#assign dbType = sysApiDBInst.getDBType()>
        <#assign dbDriver="com.edb.Driver">
      </#if>
      <#break>
    </#if>
  </#list>
</#if>
tempfolder: c:\SRFEX_TEMP
filefolder: c:\SRFEX_FILE
fontfolder: /usr/share/fonts
deploysystems:
  - gateway
  - <#if sys.getDeploySysId()??><#if (sys.getDeploySysId()?length gt 16)>${sys.getName()?lower_case}<#else>${sys.getDeploySysId()?lower_case}</#if><#else>${sys.getName()?lower_case}</#if>
systemsettings:
  cloudclientutil:
    serviceurl: lb://ebsx-oldapi
    accesstokenurl: lb://ibizcloud-uaa/v7/login
    clientid: aibizhi
    clientsecret: '123456'