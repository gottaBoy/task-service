<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>

<#comment>远端动态基础路径</#comment>
<#assign remoteDynaPath = "" >
<#if app.getPSSystem?? && app.getPSSystem()??>
<#assign sys = app.getPSSystem()/>
<#if sys.getAllPSDevSlnMSDepApps()??>
  <#list sys.getAllPSDevSlnMSDepApps() as depApp>
    <#if depApp.getPSDCMSPlatform()??>
      <#assign appPlatform=depApp.getPSDCMSPlatform()>
      <#if appPlatform.getUserParam("remoteDynaPath","")??>
        <#assign remoteDynaPath = appPlatform.getUserParam("remoteDynaPath","")>
      </#if>
      <#break>
    </#if>
  </#list>
</#if>
</#if>

<#comment>是否启用动态</#comment>
<#assign bDynamic = "false" >
<#if app.getPSSystem?? && app.getPSSystem()??>
<#assign sys = app.getPSSystem()/>
<#if sys.getAllPSDevSlnMSDepApps()??>
  <#list sys.getAllPSDevSlnMSDepApps() as depApp>
    <#if depApp.getPSDCMSPlatform()??>
      <#assign appPlatform=depApp.getPSDCMSPlatform()>
      <#if appPlatform.getUserParam("bDynamic","false")??>
        <#assign bDynamic = appPlatform.getUserParam("bDynamic","false")>
      </#if>
      <#break>
    </#if>
  </#list>
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
export const Environment = {
    // 原型示例数模式
    SampleMode: false,
    // 应用名称
    AppName: '${app.getPKGCodeName()}',
    // 应用标题
    AppCaption: '${app.getCaption()}',
    // 应用 title
    AppTitle: '${app.getName()}',
    // 应用基础路径
    BaseUrl: '/api',
    // 系统名称
    SysName: '${sys.getCodeName()}',
    // 远程登录地址，本地开发调试使用
    // RemoteLogin: 'ibizutil/login',
    RemoteLogin: '/v7/login',
    // 文件导出
    ExportFile: '/ibizutil/download',
    // 文件上传
    UploadFile: '/ibizutil/upload',
    // 是否为pc端应用
    isAppMode: true,
    // 是否开启权限认证
    enablePermissionValid: false,
    //统一地址
    uniteAddress: 'http://172.16.100.202:8114',
    // 是否为开发模式
    devMode: true,
    // 项目模板地址
    ProjectUrl: 'http://172.16.180.229/wangxiang1/VUE_R7_FTL',
    // 配置平台地址
    StudioUrl: 'http://172.16.170.145/slnstudio/',
    // 中心标识
    SlnId: 'B4BF5C84-D020-4D9A-A986-8FA4FD72816C',
    // 系统标识
    SysId: 'B428B5BE-EA90-4101-A493-BA7085D89F0A',
    // 前端应用标识
    AppId: '6e0b7357169ef4eba84e1347ed94bd84',
    // 项目发布文件地址
    PublishProjectUrl: '${app.getPSSystem().getReadOnlyPSSVNInstRepo().getGitPath()}',
    // ibiz开放平台地址
    ibizlabtUrl: 'https://www.ibizlab.cn',
    // ibiz论坛地址
    ibizbbstUrl: 'https://bbs.ibizlab.cn',
    // 是否开启访客模式
    VisitorsMode: false,
    // 访客模式地址
    VisitorsUrl: '',
    // 默认菜单
    useDefaultMenu: true,
    // 启用更新日志
    useUpdateLog: true,
    // 菜单权限模式，可选值：RT(RT模式),RESOURCE(资源模式),MINIX(混合模式),默认MINIX
    menuPermissionMode: 'MINIX',
    // 是否开启第三方免登
    enableThirdPartyLogin: false,
    // 应用动态路径
    appDynaModelFilePath: "<#if app.getDynaModelFilePath?? && app.getDynaModelFilePath()??>${app.getDynaModelFilePath()}</#if>",
    // 远端动态基础路径
    remoteDynaPath: "${remoteDynaPath}",
    // 是否开启工作流
    workflow: false,
    // 是否开启预览模式
    isPreviewMode: false,
    // SaaS模式
    SaaSMode: <#if app.getPSSystem()?? && app.getPSSystem().getSaaSMode()?? && app.getPSSystem().getSaaSMode() == 4>true<#else><#if mockDcSystemId?? && (mockDcSystemId != "")>true<#else>false</#if></#if>,
    // 是否启用动态
    bDynamic: ${bDynamic},
    // 仿真mockDcSystemId
    mockDcSystemId: '${mockDcSystemId}',
    // 登录地址
    loginUrl: ''
};
// 挂载外部配置文件
if ((window as any).Environment) {
    Object.assign(Environment, (window as any).Environment);
}