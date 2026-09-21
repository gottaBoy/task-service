<#comment>实体行为调用实体行为</#comment>
<#assign hasAfterLogic =false>
<#assign de=item.getPSDataEntity()>
<#if item.getAfterPSDEActionLogics?? && item.getAfterPSDEActionLogics()??>
    <#list item.getAfterPSDEActionLogics() as afterlogic>
        <#if afterlogic.isValid()==true && afterlogic.getActionLogicType()?c!='2'>
            <#if (afterlogic.getDstPSDE()!'')!='' && (afterlogic.getDstPSDEAction()!'')!='' && afterlogic.getDstPSDEAction().isEnableBackend()>
                <#assign hasAfterLogic=true>
                <#assign dataentity = afterlogic.getDstPSDE()>
                <#if !P.exists("refservice",dataentity+"service")>
global ${pub.getPKGCodeName()}.core.${dataentity.getPSSystemModule().codeName?lower_case}.service.I${dataentity.codeName}Service  ${srfcaseformat(dataentity.getCodeName(),'l_u2lC')}Service;
                </#if>
            </#if>
        </#if>
    </#list>
</#if>
<#if hasAfterLogic>
global ${pub.getPKGCodeName()}.core.${de.getPSSystemModule().getCodeName()?lower_case}.domain.${de.getCodeName()} et;

    <#if item.getAfterPSDEActionLogics?? && item.getAfterPSDEActionLogics()??>
    no-loop
        <#list item.getAfterPSDEActionLogics() as afterlogic>
            <#comment>实体行为附加逻辑</#comment>
            <#if afterlogic.isValid()==true && afterlogic.getActionLogicType()?c!='2' && afterlogic.getDstPSDEAction()??  &&  afterlogic.getDstPSDEAction().isEnableBackend()>
                <#assign dataentity = afterlogic.getDstPSDE()>
                <#assign deaction = afterlogic.getDstPSDEAction()>
                <#assign dataentityCodeName = afterlogic.getDstPSDE().codeName>
                <#assign deactionCodeName = srfmethodname(afterlogic.getDstPSDEAction().codeName)>
                <#assign groupName = (dataentity.codeName + deaction.codeName)?lower_case>
                <#assign target = afterlogic.getId()>

    rule "${groupName}"
    ruleflow-group "${target}"
    when
    then
    <@addActionLogic deaction afterlogic/>
    end
            </#if>
        </#list>
    </#if>
</#if>


<#comment>附加实体行为</#comment>
<#macro addActionLogic deaction actionlogic>
    <#assign actionLogicDE=actionlogic.getDstPSDE()>
    <#assign actionLogicDEAction=actionlogic.getDstPSDEAction()>
    <#assign sourceActionType=deaction.getActionType()>
    <#assign sourceCodeName=deaction.getCodeName()?lower_case>
    <#assign targetActionType=actionLogicDEAction.getActionType()>
    <#assign targetCodeName=actionLogicDEAction.getCodeName()?lower_case>
    <#if  ((sourceActionType=='SCRIPT')|| (sourceActionType=='USERCUSTOM')|| sourceActionType=='DELOGIC'|| sourceCodeName == "create" || sourceCodeName == "update" ||
    sourceCodeName == "save" || sourceCodeName == "getdraft" || sourceCodeName == "checkkey")  &&
    ((targetActionType=='SCRIPT')|| (targetActionType=='USERCUSTOM')|| targetActionType=='DELOGIC'|| targetCodeName == "create" || targetCodeName == "update" ||
    targetCodeName == "save" || targetCodeName == "getdraft" || targetCodeName == "checkkey")>
        <#if actionlogic.isIgnoreException()?? && actionlogic.isIgnoreException()==true>
        try {
            <@actionLogic_entity actionlogic/>
        }
        catch(Exception e) {
            log.error("执行[${srfmethodname(actionLogicDEAction.getCodeName())}]行为附加逻辑发生异常");
        }
        <#else>
            <@actionLogic_entity actionlogic/>
        </#if>
    <#elseif sourceCodeName=='remove' && targetCodeName == "remove">
        <#if actionlogic.isIgnoreException()?? && actionlogic.isIgnoreException()==true>
        try {
            <@actionLogic_remove actionlogic/>
        }
        catch(Exception e) {
            log.error("执行[${srfmethodname(actionLogicDEAction.getCodeName())}]行为附加逻辑发生异常");
        }
        <#else>
            <@actionLogic_remove actionlogic/>
        </#if>
    </#if>
</#macro>

<#comment>实体行为附加逻辑-参数:实体</#comment>
<#macro actionLogic_entity actionlogic>
    <#assign actionLogicDE=actionlogic.getDstPSDE()>
    <#assign actionLogicDEAction=actionlogic.getDstPSDEAction()>
    ${pub.getPKGCodeName()}.core.${actionLogicDE.getPSSystemModule().getCodeName()?lower_case}.domain.${actionLogicDE.getCodeName()} actionLogicDE =new ${pub.getPKGCodeName()}.core.${actionLogicDE.getPSSystemModule().getCodeName()?lower_case}.domain.${actionLogicDE.getCodeName()}();
    et.copyTo(actionLogicDE,true);
    ${srfcaseformat(actionLogicDE.getCodeName(),'l_u2lC')}Service.${srfmethodname(actionLogicDEAction.getCodeName())}(actionLogicDE);
</#macro>

<#comment>实体行为附加逻辑-remove</#comment>
<#macro actionLogic_remove actionlogic>
    <#if de.getKeyPSDEField().getStdDataType()==actionLogicDE.getKeyPSDEField().getStdDataType()>
        <#assign privateCodeName = srfcaseformat(de.getKeyPSDEField().getCodeName(),'l_u2lC') >
        <#assign publicCodeName = privateCodeName?cap_first >
    ${srfcaseformat(actionLogicDE.getCodeName(),'l_u2lC')}Service.remove(et.get${publicCodeName}());
    </#if>
</#macro>