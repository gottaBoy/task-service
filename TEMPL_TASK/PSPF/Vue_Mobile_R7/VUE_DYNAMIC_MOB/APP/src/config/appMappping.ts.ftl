<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
export const appMapping: any = {
    <#if app.getAllPSAppDataEntities?? && app.getAllPSAppDataEntities()??>
    <#list app.getAllPSAppDataEntities() as appDataEntity>
    '${appDataEntity.getName()?lower_case}': '${appDataEntity.getCodeName()?lower_case}'<#if appDataEntity_has_next>,</#if>
    </#list>
    </#if>
}