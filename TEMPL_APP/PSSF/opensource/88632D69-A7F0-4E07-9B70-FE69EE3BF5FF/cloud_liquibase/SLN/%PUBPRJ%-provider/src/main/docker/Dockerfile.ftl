<#ibiztemplate>
TARGET=PSSYSSERVICEAPI
</#ibiztemplate>
<#assign httpPort = "8081">
<#assign timezone = "Asia/Shanghai">
<#if sysrun?? >
    <#if sysrun.getPSDevSlnMSDepAPI()??>
        <#if sysrun.getPSDevSlnMSDepAPI().getHttpPort()??>
            <#assign httpPort = sysrun.getPSDevSlnMSDepAPI().getHttpPort()?c>
        </#if>
        <#if sysrun.getPSDevSlnMSDepAPI().getUserParam("timezone","")?? && sysrun.getPSDevSlnMSDepAPI().getUserParam("timezone","")!="">
            <#assign timezone = sysrun.getPSDevSlnMSDepAPI().getUserParam("timezone","")>
        <#elseif sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatform().getUserParam("timezone","")?? && sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatform().getUserParam("timezone","")!="">
            <#assign timezone = sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatform().getUserParam("timezone","")>
        </#if>
    </#if>
</#if>

FROM eclipse-temurin:17-jre

ENV TZ=${timezone} \
    SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBIZ_SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${r'${IBIZ_SLEEP}'}s..." && \
    sleep ${r'${IBIZ_SLEEP}'} && \
    java ${r'${JAVA_OPTS}'} -Duser.timezone=$TZ -Djava.security.egd=file:/dev/./urandom -jar /${pub.getCodeName()?lower_case}-provider.jar

EXPOSE ${httpPort}

ADD ${pub.getCodeName()?lower_case}-provider.jar /${pub.getCodeName()?lower_case}-provider.jar
