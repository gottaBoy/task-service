<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
<#list app.getAllPSAppViews() as appview>
<#if appview.getViewStyle?? && appview.getViewStyle()?? && appview.getViewStyle() == "EXTEND">
import { ${appview.getCodeName()} } from './pages/${srffilepath2(appview.getPSAppModule().getCodeName())}/${srffilepath2(appview.getCodeName())}/${srffilepath2(appview.getCodeName())}';
</#if>
</#list>
export const PageComponents = {
    install(v: any, opt: any) {
        <#list app.getAllPSAppViews() as appview>
        <#if appview.getViewStyle?? && appview.getViewStyle()?? && appview.getViewStyle() == "EXTEND">
        v.component('${srffilepath2(appview.getCodeName())}', ${appview.getCodeName()});
        </#if>
        </#list>
    }
};