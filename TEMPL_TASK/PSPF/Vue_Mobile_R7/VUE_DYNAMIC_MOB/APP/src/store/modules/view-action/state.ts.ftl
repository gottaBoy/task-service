<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
/**
 * 所有应用视图
 */
export const viewstate: any = {
    appviews: [
<#--  视图参数状态  -->
        <#if app.isPubRefViewOnly()><#assign allAppViews = app.getAllRefPSAppViews()/><#else><#assign allAppViews = app.getAllPSAppViews()/></#if>
        <#if allAppViews??>
        <#list allAppViews as appview>
        {
            viewtag: '${appview.getId()}',
            viewmodule: '${appview.getPSAppModule().getCodeName()}',
            viewname: '${appview.getCodeName()}',
            viewaction: '',
            viewdatachange: false,
            refviews: [
                <#list appview.getAllRelatedPSAppViews() as refview>
                <#if refview.getId() != appview.getId()>
                '${refview.getId()}',
                </#if>
                </#list>
            ],
        },
        </#list>
        </#if>
    ],
    createdviews: [],
}