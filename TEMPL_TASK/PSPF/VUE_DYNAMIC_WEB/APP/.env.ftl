<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
<#comment>远端动态基础路径</#comment>
<#assign remoteDynaPath = "" >
<#if sysrun?? && sysrun.getPSDevSlnMSDepApp()??>
<#assign depApp=sysrun.getPSDevSlnMSDepApp()>
    <#if depApp.getPSDCMSPlatform()??>
      <#assign appPlatform=depApp.getPSDCMSPlatform()>
      <#if appPlatform.getUserParam("remoteDynaPath","")??>
        <#assign remoteDynaPath = appPlatform.getUserParam("remoteDynaPath","")>
      </#if>
    </#if>
</#if>
<#comment>是否启用动态</#comment>
<#assign bDynamic = "false" >
<#if sysrun?? && sysrun.getPSDevSlnMSDepApp()??>
<#assign depApp=sysrun.getPSDevSlnMSDepApp()>
    <#if depApp.getPSDCMSPlatform()??>
      <#assign appPlatform=depApp.getPSDCMSPlatform()>
      <#if appPlatform.getUserParam("bDynamic","false")??>
        <#assign bDynamic = appPlatform.getUserParam("bDynamic","false")>
      </#if>
    </#if>
</#if>
<#comment>应用基础路径</#comment>
<#assign BaseUrl = "/api" >
<#if sysrun?? && sysrun.getPSDevSlnMSDepApp()??>
<#assign depApp=sysrun.getPSDevSlnMSDepApp()>
      <#if depApp.getUserParam("server.servlet.contextPath","")?? && depApp.getUserParam("server.servlet.contextPath","")!="">
        <#assign BaseUrl = depApp.getUserParam("server.servlet.contextPath","")>
      </#if>
</#if>
<#comment>应用登录路径</#comment>
<#assign loginUrl = "" >
<#if sysrun?? && sysrun.getPSDevSlnMSDepApp()??>
<#assign depApp=sysrun.getPSDevSlnMSDepApp()>
      <#if depApp.getUserParam("loginUrl","")?? && depApp.getUserParam("loginUrl","")!="">
        <#assign loginUrl = depApp.getUserParam("loginUrl","")>
      </#if>
</#if>
<#comment>门户路径</#comment>
<#assign portalUrl = "" >
<#if sysrun?? && sysrun.getPSDevSlnMSDepApp()??>
<#assign depApp=sysrun.getPSDevSlnMSDepApp()>
      <#if depApp.getUserParam("portalUrl","")?? && depApp.getUserParam("portalUrl","")!="">
        <#assign portalUrl = depApp.getUserParam("portalUrl","")>
      </#if>
</#if>
<#comment>仿真mockDcSystemId</#comment>
<#assign mockDcSystemId = "" >
<#if sysrun?? && sysrun.getPSDevSlnMSDepApp()??>
<#assign depApp=sysrun.getPSDevSlnMSDepApp()>
      <#if depApp.getUserParam("mockDcSystemId","")?? && depApp.getUserParam("mockDcSystemId","")!="">
        <#assign mockDcSystemId = depApp.getUserParam("mockDcSystemId","")>
      </#if>
</#if>
// 远程登录地址，本地开发调试使用
VUE_APP_BASEURL=${BaseUrl}
// 远程登录地址，本地开发调试使用
VUE_APP_REMOTELOGIN=/ibizutil/login
// 文件导出
VUE_APP_EXPORTFILE=/ibizutil/download
// 文件上传
VUE_APP_UPLOADFILE=/ibizutil/upload
// 数据导入单次上传最大数量
VUE_APP_SLICEUPLOADCNT=100
// 是否为开发模式
VUE_APP_DEVMODE=false
// 是否启用AppData
VUE_APP_ENABLEAPPDATA=true
// 是否开启权限认证
VUE_APP_ENABLEPERMISSIONVALID=false
// 远端动态基础路径
VUE_APP_REMOTEDYNAPATH=${remoteDynaPath}
// 是否开启工作流
VUE_APP_WORKFLOW=false
// 是否启用动态
VUE_APP_BDYNAMIC=${bDynamic}
// SaaS模式
VUE_APP_SAASMODE=<#if app.getPSSystem()?? && app.getPSSystem().getSaaSMode()?? && app.getPSSystem().getSaaSMode() == 4>true<#else><#if mockDcSystemId?? && (mockDcSystemId != "")>true<#else>false</#if></#if>
// 仿真mockDcSystemId
VUE_APP_MOCKDCSYSTEMID=${mockDcSystemId}
// 登录地址
VUE_APP_LOGINURL=${loginUrl}
// 门户地址
VUE_APP_PORTALURL=${portalUrl}
// 刷新token即将到期时间间隔(默认10分钟，单位：ms)
VUE_APP_REFRESHTOKENTIME=600000
// 微应用名称
VUE_APP_MICROAPPNAME=${app.getCodeName()}
//统一地址
VUE_APP_UNITEADDRESS=http=//172.16.100.202=8114
// 菜单权限模式，可选值：RT(RT模式),RESOURCE(资源模式),MINIX(混合模式),默认MINIX
VUE_APP_MENUPERMISSIONMODE=RESOURCE
// 预览动态基础路径
VUE_APP_PREVIEWDYNAPATH=http=//172.16.170.145
// 实例配置地址
VUE_APP_CONFIGDYNAPATH=http=//172.16.170.145/DynamicBackend/designtool/redirect
// 动态模式(RT/WEB)
VUE_APP_DYNAMODE=WEB
// 钉钉内部集成应用标识，用于钉钉应用内免登
VUE_APP_DINGTALKAPPID=
// 钉钉登录应用标识，用于网页扫码登录
VUE_APP_DINGTALKACCAPPID=
// 企业微信登录应用标识,用于网页扫码登录和企业微信内部免登
VUE_APP_WXWORKAPPID=
// cas登录地址
VUE_APP_CASLOGINURL=
// cas登出地址
VUE_APP_CASLOGOUTURL=
// 跳cas后cas未登录时默认跳转的地址
VUE_APP_CASREDIRECTURL=
// Debug栏模型配置工具地址
VUE_APP_DYNAMICCONFIGTOOLURL=http=//172.16.170.145/dynamictool/debug-bar/?origin=
// 表单项标题位置（'', 'LEFT', 'RIGHT', 'TOP', 'BOTTOM'）
VUE_APP_FORMITEMLABELPOS=
// 打包基础路径
VUE_APP_PUBLICPATH=./
// 是否提示所有的字段的错误信息
VUE_APP_NOTICEALLFIELDSERROR=false
// 系统默认的最大导出个数
<#if sys.getPSSystemSetting()?? && sys.getPSSystemSetting().getDEDataExportMaxRowCount()?? && sys.getPSSystemSetting().getDEDataExportMaxRowCount()??>
VUE_APP_EXPORTMAXROWCOUNT=${sys.getPSSystemSetting().getDEDataExportMaxRowCount()?c}
<#else>
VUE_APP_EXPORTMAXROWCOUNT=1000
</#if>

