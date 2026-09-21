<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
// 扩展部件样式内容
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
<#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
<#if (appPFPluginRef.getRefMode() == "CONTROL") && appPFPluginRef.render?? && appPFPluginRef.render.code3??>
${appPFPluginRef.render.code3}
</#if>
</#list>
</#if>