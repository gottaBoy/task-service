<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
// 注册视图插件
<#if app.getAllPSAppSubViewTypeRefs?? && app.getAllPSAppSubViewTypeRefs()??>
  <#list app.getAllPSAppSubViewTypeRefs() as subViewTypeRef>
    <#if subViewTypeRef.getPSSysPFPlugin()?? && (subViewTypeRef.getPSSysPFPlugin().isRuntimeObject() == false)>
      <#if !P.exists("plugin_view_import", subViewTypeRef.getPSSysPFPlugin().getPFPluginType(), subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())>
import { ${srfclassname(subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())} as ${subViewTypeRef.getPSSysPFPlugin().getPFPluginType()}_${srfclassname(subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())} } from './view/${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginType())}/${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())}';
      </#if>
    </#if>
  </#list>
</#if>
// 注册编辑器插件
<#if app.getAllPSAppEditorStyleRefs?? && app.getAllPSAppEditorStyleRefs()??>
  <#list app.getAllPSAppEditorStyleRefs() as editorStyleRef>
    <#if editorStyleRef.getPSSysPFPlugin?? && editorStyleRef.getPSSysPFPlugin()?? && (editorStyleRef.getPSSysPFPlugin().isRuntimeObject() == false)>
      <#if !P.exists("plugin_editor_import", editorStyleRef.getPSSysEditorStyle().getEditorType(), editorStyleRef.getPSSysEditorStyle().getCodeName())>
import { ${srfclassname(editorStyleRef.getPSSysEditorStyle().getCodeName())} as ${editorStyleRef.getPSSysEditorStyle().getEditorType()}_${srfclassname(editorStyleRef.getPSSysEditorStyle().getCodeName())} } from './editor/${srffilepath2(editorStyleRef.getPSSysEditorStyle().getPSEditorType().getStandardPSEditorType())}/${srffilepath2(editorStyleRef.getPSSysEditorStyle().getCodeName())}';
      </#if>
    </#if>
  </#list>
</#if>
// 注册部件插件
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
  <#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
    <#if (appPFPluginRef.getRefMode() == "CONTROL") && appPFPluginRef.getPSSysPFPlugin()??  && (appPFPluginRef.getPSSysPFPlugin().isRuntimeObject() == false)>
      <#if !P.exists("plugin_control_import", appPFPluginRef.getPSSysPFPlugin().getPFPluginType(), appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())>
import { ${srfclassname(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())} as ${appPFPluginRef.getPSSysPFPlugin().getPFPluginType()}_${srfclassname(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())} } from './plugin/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginType())}/${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}';
      </#if>
    </#if>
  </#list>
</#if>
export const PluginRegister = {
    install(v: any, opt: any) {
        // 注册视图插件
<#if app.getAllPSAppSubViewTypeRefs?? && app.getAllPSAppSubViewTypeRefs()??>
  <#list app.getAllPSAppSubViewTypeRefs() as subViewTypeRef>
    <#if subViewTypeRef.getPSSysPFPlugin()?? && (subViewTypeRef.getPSSysPFPlugin().isRuntimeObject() == false)>
      <#if !P.exists("plugin_view_set", subViewTypeRef.getPSSysPFPlugin().getPFPluginType(), subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())>
        v.component('app-${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginType())}-${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())}', ${subViewTypeRef.getPSSysPFPlugin().getPFPluginType()}_${srfclassname(subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())} );
      </#if>
    </#if>
  </#list>
</#if>
       // 注册编辑器插件
<#if app.getAllPSAppEditorStyleRefs?? && app.getAllPSAppEditorStyleRefs()??>
  <#list app.getAllPSAppEditorStyleRefs() as editorStyleRef>
    <#if editorStyleRef.getPSSysPFPlugin?? && editorStyleRef.getPSSysPFPlugin()?? && (editorStyleRef.getPSSysPFPlugin().isRuntimeObject() == false)>
      <#if !P.exists("plugin_editor_set", editorStyleRef.getPSSysEditorStyle().getEditorType(), editorStyleRef.getPSSysEditorStyle().getCodeName())>
        v.component('app-${srffilepath2(editorStyleRef.getPSSysEditorStyle().getEditorType())}-${srffilepath2(editorStyleRef.getPSSysEditorStyle().getCodeName())}', ${editorStyleRef.getPSSysEditorStyle().getEditorType()}_${srfclassname(editorStyleRef.getPSSysEditorStyle().getCodeName())});
      </#if>
    </#if>
  </#list>
</#if>
        // 注册部件插件
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
  <#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
    <#if (appPFPluginRef.getRefMode() == "CONTROL") && appPFPluginRef.getPSSysPFPlugin()?? && (appPFPluginRef.getPSSysPFPlugin().isRuntimeObject() == false)>
      <#if !P.exists("plugin_control_set", appPFPluginRef.getPSSysPFPlugin().getPFPluginType(), appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())>
        v.component('app-${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginType())}-${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}', ${appPFPluginRef.getPSSysPFPlugin().getPFPluginType()}_${srfclassname(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())});
      </#if>
    </#if>
  </#list>
</#if>
    }
}