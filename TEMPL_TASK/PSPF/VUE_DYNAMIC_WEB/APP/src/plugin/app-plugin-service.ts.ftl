<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
  <#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
    <#if (appPFPluginRef.getRefMode() == "CONTROLITEM") && appPFPluginRef.getPSSysPFPlugin()??>
      <#if !P.exists("plugin_controlitem_import", appPFPluginRef.getPSSysPFPlugin().getPFPluginTag(), "")>
import { ${srfclassname(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())} } from './plugin/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginType())}/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}';
      </#if>
    </#if>
  </#list>
</#if>
/**
 * 插件实例工厂（部件项，界面行为）
 *
 * @export
 * @class AppPluginService
 */
export class AppPluginService {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AppPluginService}
     * @memberof AppPluginService
     */
    private static AppPluginService: AppPluginService;

    /**
     * 部件成员Map
     *
     * @private
     * @static
     * @type Map<string,any>
     * 
     * @memberof AppPluginService
     */
    private controlItemMap:Map<string,any> = new Map();

    /**
     * 界面行为Map
     *
     * @private
     * @static
     * @type Map<string,any>
     * 
     * @memberof AppPluginService
     */
    private UIActionMap:Map<string,any> = new Map();

    /**
     * 应用实体方法Map
     *
     * @private
     * @static
     * @type Map<string,any>
     * 
     * @memberof AppPluginService
     */
    private DEMethodMap:Map<string,any> = new Map();

    /**
     * 实体自填项插件Map
     *
     * @private
     * @static
     * @type Map<string,any>
     * 
     * @memberof AppPluginService
     */
    private DEAcModeMap:Map<string,any> = new Map();

    /**
     * Creates an instance of AppPluginService.
     * 私有构造，拒绝通过 new 创建对象
     * 
     * @memberof AppPluginService
     */
    private constructor() {
        this.registerControlItemPlugin();
        this.registerUIActionPlugin();
        this.registerDEMethodPlugin();
        this.registerDEAcModePlugin();
    }

    /**
     * 获取 AppPluginService 单例对象
     *
     * @static
     * @returns {AppPluginService}
     * @memberof AppPluginService
     */
    public static getInstance(): AppPluginService {
        if (!AppPluginService.AppPluginService) {
            AppPluginService.AppPluginService = new AppPluginService();
        }
        return this.AppPluginService;
    }

    /**
     * 注册部件成员插件
     * 
     * @memberof AppPluginService
     */
    private registerControlItemPlugin(){
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
  <#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
    <#if (appPFPluginRef.getRefMode() == "CONTROLITEM") && appPFPluginRef.getPSSysPFPlugin()??>
      <#if !P.exists("plugin_controlitem_set", appPFPluginRef.getPSSysPFPlugin().getPFPluginTag(), "")>
        this.controlItemMap.set('${appPFPluginRef.getPSSysPFPlugin().getPFPluginCode()}',new ${srfclassname(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}());
      </#if>
    </#if>
  </#list>
</#if>
    }

    /**
     * 注册界面行为插件
     * 
     * @memberof AppPluginService
     */
    private registerUIActionPlugin(){
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
  <#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
    <#if (appPFPluginRef.getRefMode() == "UIACTION") && appPFPluginRef.getPSSysPFPlugin()?? >
      <#if !P.exists("plugin_uiaction_import", appPFPluginRef.getPSSysPFPlugin().getPFPluginTag(), "")>
        this.UIActionMap.set('${appPFPluginRef.getPSSysPFPlugin().getPFPluginTag()}',() => import('./plugin/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginType())}/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}'));
      </#if>
    </#if>
  </#list>
</#if>
    }

    /**
     * 注册应用实体方法插件
     * 
     * @memberof AppPluginService
     */
    private registerDEMethodPlugin(){
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
  <#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
    <#if (appPFPluginRef.getRefMode() == "DEMETHOD") && appPFPluginRef.getPSSysPFPlugin()?? >
      <#if !P.exists("plugin_demethod_import", appPFPluginRef.getPSSysPFPlugin().getPFPluginTag(), "")>
        this.DEMethodMap.set('${appPFPluginRef.getPSSysPFPlugin().getPFPluginTag()}',() => import('./plugin/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginType())}/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}'));
      </#if>
    </#if>
  </#list>
</#if>
    }

    /**
     * 注册自填项插件
     * 
     * @memberof AppPluginService
     */
    private registerDEAcModePlugin(){
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
  <#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
    <#if (appPFPluginRef.getRefMode() == "DEACMODE") && appPFPluginRef.getPSSysPFPlugin()??>
      <#if !P.exists("plugin_deacmode_register", appPFPluginRef.getPSSysPFPlugin().getPFPluginType(), appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())>
        this.DEAcModeMap.set('${appPFPluginRef.getPSSysPFPlugin().getPFPluginCode()}',new ${srfclassname(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}());
      </#if>
    </#if>
  </#list>
</#if>
    }
    
}
export const installPlugin:Function = () =>{
    (window as any).plugin = AppPluginService.getInstance();
}