<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
import { ViewTool } from "ibiz-core";
export const Environment = {
    // 原型示例数模式
    SampleMode: false,
    // 应用名称
    AppName: '${app.getPKGCodeName()}',
    // 应用 title
    AppTitle: '${app.getName()}',
    // 应用基础路径
    BaseUrl: process.env.VUE_APP_BASEURL,
    // 系统名称
    SysName: '${sys.getCodeName()}',
    // 远程登录地址，本地开发调试使用
    RemoteLogin: process.env.VUE_APP_REMOTELOGIN,
    // 文件导出
    ExportFile: process.env.VUE_APP_EXPORTFILE,
    // 文件上传
    UploadFile: process.env.VUE_APP_UPLOADFILE,
    // 数据导入单次上传最大数量
    sliceUploadCnt: Number(process.env.VUE_APP_SLICEUPLOADCNT),
    // 是否为pc端应用
    isAppMode: true,
    //统一地址
    uniteAddress: process.env.VUE_APP_UNITEADDRESS,
    // 是否为开发模式
    devMode: Boolean(process.env.VUE_APP_DEVMODE === "true"),
    // 是否启用AppData
    enableAppData: Boolean(process.env.VUE_APP_ENABLEAPPDATA === "true"),
    // 是否开启权限认证
    enablePermissionValid: Boolean(process.env.VUE_APP_ENABLEPERMISSIONVALID === "true"),
    // 菜单权限模式，可选值：RT(RT模式),RESOURCE(资源模式),MINIX(混合模式),默认MINIX
    menuPermissionMode: process.env.VUE_APP_MENUPERMISSIONMODE,
    // 项目模板地址
    ProjectUrl: '${app.getPSSystem().getReadOnlyPSSVNInstRepo().getGitPath()}',
    // 打开目标工具，可选参数：sln、mos
    debugOpenMode: 'mos',
    // 配置平台地址
    StudioUrl: 'http://172.16.170.145/mos/',
    // 中心标识
    SlnId: 'B4BF5C84-D020-4D9A-A986-8FA4FD72816C',
    // 系统标识
    SysId: 'B428B5BE-EA90-4101-A493-BA7085D89F0A',
    // 前端应用标识
    AppId: '6e0b7357169ef4eba84e1347ed94bd84',
    // 项目发布文件地址
    PublishProjectUrl: 'http://oauth2:7QqmRhw_zQwFM7k9PYuV@ibiz.ibizee.cn/iBizPSSln/ibizstudioplugin.git',
    // ibiz开放平台地址
    ibizlabtUrl: 'https://www.ibizlab.cn',
    // ibiz论坛地址
    ibizbbstUrl: 'https://bbs.ibizlab.cn',
    // 应用动态路径
    appDynaModelFilePath: '<#if app.getDynaModelFilePath?? && app.getDynaModelFilePath()??>${app.getDynaModelFilePath()}</#if>',
    // 远端动态基础路径
    remoteDynaPath: process.env.VUE_APP_REMOTEDYNAPATH,
    // 预览动态基础路径
    previewDynaPath: process.env.VUE_APP_PREVIEWDYNAPATH,
    // 实例配置地址
    configDynaPath: process.env.VUE_APP_CONFIGDYNAPATH,
    // 是否开启工作流
    workflow: Boolean(process.env.VUE_APP_WORKFLOW === "true"),
    // 是否启用动态
    bDynamic: Boolean(process.env.VUE_APP_BDYNAMIC === "true"),
    // 动态模式(RT/WEB)
    dynaMode: process.env.VUE_APP_DYNAMODE,
    // 是否预览模式
    isPreviewMode: false,
    // SaaS模式
    SaaSMode: Boolean(process.env.VUE_APP_SAASMODE === "true"),
    // 仿真mockDcSystemId
    mockDcSystemId: process.env.VUE_APP_MOCKDCSYSTEMID,
    // 钉钉内部集成应用标识，用于钉钉应用内免登
    dingTalkAppId: process.env.VUE_APP_DINGTALKAPPID,
    // 钉钉登录应用标识，用于网页扫码登录
    dingTalkAccAppId: process.env.VUE_APP_DINGTALKACCAPPID,
    // 企业微信登录应用标识,用于网页扫码登录和企业微信内部免登
    wxWorkAppId: process.env.VUE_APP_WXWORKAPPID,
    // 登录地址
    loginUrl: process.env.VUE_APP_LOGINURL,
    // 门户地址
    portalUrl: process.env.VUE_APP_PORTALURL,
    // cas登录地址
    casLoginUrl: process.env.VUE_APP_CASLOGINURL,
    // cas登出地址
    casLogoutUrl: process.env.VUE_APP_CASLOGOUTURL,
    // 跳cas后cas未登录时默认跳转的地址
    casRedirectUrl: process.env.VUE_APP_CASREDIRECTURL,
    // Debug栏模型配置工具地址
    dynamicConfigToolUrl: process.env.VUE_APP_DYNAMICCONFIGTOOLURL,
    // 应用是否支持多语言
    isEnableMultiLan:<#if app.isEnableMultiLan?? && app.isEnableMultiLan()??>${app.isEnableMultiLan()?c}<#else>false</#if>,
    // 是否启用修复
    enableIssue:true,
    // 刷新token即将到期时间间隔(默认10分钟，单位：ms)
    refreshTokenTime:Number(process.env.VUE_APP_REFRESHTOKENTIME),
    // 表单项标题位置（'', 'LEFT', 'RIGHT', 'TOP', 'BOTTOM'）
    formItemLabelPos: process.env.VUE_APP_FORMITEMLABELPOS,
    // 微应用名称
    microAppName:process.env.VUE_APP_MICROAPPNAME,
    // 打包基础路径(适配微应用)
    publicPath: process.env.VUE_APP_PUBLICPATH,
    // 是否提示所有的字段的错误信息
    noticeAllFieldsError: Boolean(process.env.VUE_APP_NOTICEALLFIELDSERROR === "true"),
    // 系统默认的最大导出个数
    exportMaxRowCount:Number(process.env.VUE_APP_EXPORTMAXROWCOUNT),
    // 应用是否显示多语言
    showLang: true,
    // 应用是否显示组织
    showOrg: true,
    // 工作流审批日志是否需要全部
    enableWfAllHistory: true,
    // 是否启用异步导入
    enableAsyncImport: true,
    // ws重连次数
    wsRetry: 3,
    // 是否启用ui逻辑修复
    enableUILogicIssue: true,
};
// 挂载外部配置文件
if ((window as any).Environment) {
    Object.assign(Environment, (window as any).Environment);
    const dynamicParams = ViewTool.getMockViewParams(window.location.href);
    if(dynamicParams.mockdcsystem){
        Object.assign(Environment, {mockDcSystemId: dynamicParams.mockdcsystem});
    }
    if(dynamicParams.baseurl){
        Object.assign(Environment, {BaseUrl: dynamicParams.baseurl});
    }
}