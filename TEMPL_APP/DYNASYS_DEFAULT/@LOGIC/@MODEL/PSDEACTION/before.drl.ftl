<#comment>实体行为调用实体行为</#comment>
<#assign hasBeforeLogic =false>
<#assign de=item.getPSDataEntity()>
<#if item.getBeforePSDEActionLogics?? && item.getBeforePSDEActionLogics()??>
    <#list item.getBeforePSDEActionLogics() as beforelogic>
        <#if beforelogic.isValid()==true && beforelogic.getActionLogicType()?c!='2'>
            <#if (beforelogic.getDstPSDE()!'')!='' && (beforelogic.getDstPSDEAction()!'')!='' && beforelogic.getDstPSDEAction().isEnableBackend()>
                <#assign hasBeforeLogic=true>
                <#assign dataentity = beforelogic.getDstPSDE()>
                <#if !P.exists("refservice",dataentity+"service")>
global ${pub.getPKGCodeName()}.core.${dataentity.getPSSystemModule().codeName?lower_case}.service.I${dataentity.codeName}Service  ${srfcaseformat(dataentity.getCodeName(),'l_u2lC')}Service;
                </#if>
            </#if>
        </#if>
    </#list>
</#if>
<#if hasBeforeLogic>
global ${pub.getPKGCodeName()}.core.${de.getPSSystemModule().getCodeName()?lower_case}.domain.${de.getCodeName()} et;

    <#if item.getBeforePSDEActionLogics?? && item.getBeforePSDEActionLogics()??>
    no-loop
        <#list item.getBeforePSDEActionLogics() as beforelogic>
            <#comment>实体行为附加逻辑</#comment>
            <#if beforelogic.isValid()==true && beforelogic.getActionLogicType()?c!='2' && beforelogic.getDstPSDEAction()??  &&  beforelogic.getDstPSDEAction().isEnableBackend()>
                <#assign dataentity = beforelogic.getDstPSDE()>
                <#assign deaction = beforelogic.getDstPSDEAction()>
                <#assign dataentityCodeName = beforelogic.getDstPSDE().codeName>
                <#assign deactionCodeName = srfmethodname(beforelogic.getDstPSDEAction().codeName)>
                <#assign groupName = (dataentity.codeName + deaction.codeName)?lower_case>
                <#assign target = beforelogic.getId()>

    rule "${groupName}"
    ruleflow-group "${target}"
    when
    then
    <@addActionLogic deaction beforelogic/>
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