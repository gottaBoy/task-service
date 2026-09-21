<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
// 注册视图插件
export const PluginRegister = {
    install(v: any, opt: any) {
        // 注册视图插件
<#if app.getAllPSAppSubViewTypeRefs?? && app.getAllPSAppSubViewTypeRefs()??>
<#list app.getAllPSAppSubViewTypeRefs() as subViewTypeRef>
<#if subViewTypeRef.getPSSysPFPlugin()??>
        v.component('app-${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginType())}-${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())}', ()=>{ return import('./view/${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginType())}/${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())}')});
</#if>
</#list>
</#if>
       // 注册编辑器插件
<#if app.getAllPSAppEditorStyleRefs?? && app.getAllPSAppEditorStyleRefs()??>
<#list app.getAllPSAppEditorStyleRefs() as editorStyleRef>
<#if editorStyleRef.getPSSysPFPlugin?? && editorStyleRef.getPSSysPFPlugin()??>
        v.component('app-${srffilepath2(editorStyleRef.getPSSysEditorStyle().getPSEditorType().getStandardPSEditorType())}-${srffilepath2(editorStyleRef.getPSSysEditorStyle().getCodeName())}', ()=>{ return import('./editor/${srffilepath2(editorStyleRef.getPSSysEditorStyle().getPSEditorType().getStandardPSEditorType())}/${srffilepath2(editorStyleRef.getPSSysEditorStyle().getCodeName())}')});
</#if>
</#list>
</#if>
        // 注册部件插件
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
<#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
<#if (appPFPluginRef.getRefMode() == "CONTROL") && appPFPluginRef.getPSSysPFPlugin()??>
        v.component('app-${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginType())}-${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}', ()=>{ return import('./plugin/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginType())}/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}')});
</#if>
</#list>
</#if>
    }
}