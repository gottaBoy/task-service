<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
server:
  port: 8080

spring:
  profiles:
    include: sys
  application:
    name: ${sys.getCodeName()?lower_case}
  cloud:
    nacos:
      discovery:
        server-addr: nacos.ibizcloud.cn:8848
        group: ibiz_config_group
      config:
        server-addr: nacos.ibizcloud.cn:8848
        group: ibiz_config_group
        file-extension: yaml

ibiz:
  servicehub:
    id: <#if sys.getDeploySysId()??><#if (sys.getDeploySysId()?length gt 16)>${sys.getName()?lower_case}<#else>${sys.getDeploySysId()?lower_case}</#if><#else>${sys.getName()?lower_case}</#if>
#    register-naming-service: false
#    publish-config: false
  tenant: true

#生产环境需要关闭
springfox:
  documentation:
    enabled: true

logging:
  level:
    net.ibizsys.central.cloud: debug
    net.ibizsys.central: debug
    net.ibizsys.runtime: debug
    ${pub.getPKGCodeName()}: debug