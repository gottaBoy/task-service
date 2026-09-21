<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
<#assign httpPort = "80">
<#assign gateway_ip = "172.16.240.140">
<#if sysrun?? && sysrun.getPSDevSlnMSDepApp()??>
    <#assign depApp=sysrun.getPSDevSlnMSDepApp()>
    <#if depApp.getHttpPort()??>
        <#assign httpPort = sysrun.getPSDevSlnMSDepApp().getHttpPort()?c>
    </#if>
    <#if depApp.getPSDCMSPlatformNode()??>
        <#assign appPlatform=depApp.getPSDCMSPlatform()>
        <#if appPlatform.getUserParam("gateway_ip","172.16.240.140")??>
            <#assign gateway_ip = appPlatform.getUserParam("gateway_ip","172.16.240.140")>
        </#if>
    </#if>
</#if>
version: "3.2"
services:
  ${pub.getCodeName()?lower_case}-app-${app.getPKGCodeName()?lower_case}:
    image: dstimage
    ports:
      - "${httpPort}:80"
    networks:
      - agent_network
    environment:
      - APP_ID=<#if sys.getDeploySysId()??><#if (sys.getDeploySysId()?length gt 16)>${sys.getName()?lower_case}<#else>${sys.getDeploySysId()?lower_case}</#if><#else>${sys.getName()?lower_case}</#if>__${app.getPKGCodeName()?lower_case}
      - APPCODE=${app.getPKGCodeName()?lower_case}
    deploy:
      resources:
           limits:
               memory: 800M
           reservations:
               memory: 400M
      mode: replicated
      replicas: 1
    extra_hosts:
      - "gateway.ibizcloud.cn:${gateway_ip}"

networks:
  agent_network:
    driver: overlay
    attachable: true