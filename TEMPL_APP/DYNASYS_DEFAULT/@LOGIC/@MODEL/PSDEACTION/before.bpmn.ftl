<#assign hasBeforeLogic =false>
<#assign hasBeforeDrl=false>
<#assign de=item.getPSDataEntity()>
<#if item.getBeforePSDEActionLogics?? && item.getBeforePSDEActionLogics()??>
    <#list item.getBeforePSDEActionLogics() as beforelogic>
        <#if beforelogic.isValid()==true && beforelogic.getActionLogicType()?c!='2'>
            <#if beforelogic.isInternalLogic() && beforelogic.getPSDELogic().isEnableBackend() && beforelogic.getPSDELogic().isCustomCode()== false>
                <#assign hasBeforeLogic=true>
            <#elseif (beforelogic.getDstPSDE()!'')!='' && (beforelogic.getDstPSDEAction()!'')!='' && beforelogic.getDstPSDEAction().isEnableBackend()>
                <#assign hasBeforeLogic=true>
                <#assign hasBeforeDrl=true>
                <#break>
            </#if>
        </#if>
    </#list>
</#if>
<#if hasBeforeLogic>
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" xmlns:g="http://www.jboss.org/drools/flow/gpd" xmlns:tns="http://www.jboss.org/drools" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" expressionLanguage="http://www.mvel.org/2.0" id="Definition" name="" targetNamespace="http://www.jboss.org/drools" typeLanguage="http://www.java.com/javaTypes">
        <process id="${pub.getPKGCodeName()}.core.extensions.service.logic.before" isClosed="false" isExecutable="true" name="${de.getPSSystemModule().codeName?lower_case}_${de.codeName?lower_case}_${item.codeName?lower_case}_beforeLogic" processType="Private" tns:packageName="${pub.getPKGCodeName()}.core.extensions.service.logic.before">
            <extensionElements>
                <tns:import name="java.util.Map"/>
                <tns:import name="org.springframework.util.StringUtils"/>
                <tns:import name="${pub.getPKGCodeName()}.util.helper.RuleUtils"/>
                <tns:import name="${pub.getPKGCodeName()}.core.${de.getPSSystemModule().getCodeName()?lower_case}.domain.${de.getCodeName()}"/>
                <#comment>插入服务对象</#comment>
                <#list item.getBeforePSDEActionLogics() as beforelogic>
                    <#if (beforelogic.getDstPSDE()!'')!='' && (beforelogic.getDstPSDEAction()!'')!='' && beforelogic.getDstPSDEAction().isEnableBackend()>
                        <#assign dataentity = beforelogic.getDstPSDE()>
                        <#assign deaction = beforelogic.getDstPSDEAction()>
                        <#if !P.exists("refservice",dataentity+"service")>
                            <tns:metaData express="T(${pub.getPKGCodeName()}.util.security.SpringContextHolder).getBean(T(${pub.getPKGCodeName()}.core.${dataentity.getPSSystemModule().codeName?lower_case}.service.I${dataentity.codeName}Service))" name="${srfcaseformat(dataentity.getCodeName(),'l_u2lC')}Service" type="service"/>
                        </#if>
                    </#if>
                </#list>
                <#if hasBeforeDrl>
                    <#comment>插入当前实体对象</#comment>
                    <tns:metaData express="" name="et" type="entity"/>
                </#if>
            </extensionElements>
            <#if item.getBeforePSDEActionLogics?? && item.getBeforePSDEActionLogics()??>
                <startEvent id="begin" isInterrupting="true"/>
                <endEvent id="prepareparam1_end" name="end"/>
                <#assign source="begin">
                <#list item.getBeforePSDEActionLogics() as beforelogic>
                    <#if beforelogic.isValid()==true && beforelogic.getActionLogicType()?c!='2'>
                        <#comment>实体行为附加逻辑</#comment>
                        <#if beforelogic.isInternalLogic() && beforelogic.getPSDELogic().isEnableBackend() && beforelogic.getPSDELogic().isCustomCode()== false>
                            <#assign delogic = beforelogic.getPSDELogic()>
                            <#assign target =beforelogic.getId()>
                            <callActivity activiti:exclusive="true" calledElement="${pub.getPKGCodeName()}.core.${de.getPSSystemModule().codeName?lower_case}.service.logic.${de.codeName?lower_case}${delogic.getCodeName()?lower_case}" id="${target}" name="${delogic.codeName}.json.bpmn"/>
                        <#elseif beforelogic.getDstPSDEAction()??  &&  beforelogic.getDstPSDEAction().isEnableBackend()>
                            <#assign dataentity = beforelogic.getDstPSDE()>
                            <#assign deaction = beforelogic.getDstPSDEAction()>
                            <#assign target = beforelogic.getId()>
                            <#assign groupName = (dataentity.codeName + deaction.codeName)?lower_case>

                            <businessRuleTask activiti:exclusive="true" g:ruleFlowGroup="${target}" id="${target}" implementation="http://www.jboss.org/drools/rule" name="${groupName}"/>
                        </#if>
                        <sequenceFlow id="${source}_${target}" sourceRef="${source}" targetRef="${target}"/>
                        <#assign source = target>
                        <#if !beforelogic_has_next>
                            <sequenceFlow id="${source}_prepareparam1_end" sourceRef="${source}" targetRef="prepareparam1_end"/>
                        </#if>
                    </#if>
                </#list>
            </#if>
        </process>
    </definitions>
</#if>