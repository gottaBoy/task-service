<#assign hasAfterLogic =false>
<#assign hasAfterDrl=false>
<#assign de=item.getPSDataEntity()>
<#if item.getAfterPSDEActionLogics?? && item.getAfterPSDEActionLogics()??>
    <#list item.getAfterPSDEActionLogics() as afterlogic>
        <#if afterlogic.isValid()==true && afterlogic.getActionLogicType()?c!='2'>
            <#if afterlogic.isInternalLogic() && afterlogic.getPSDELogic().isEnableBackend() && afterlogic.getPSDELogic().isCustomCode()== false>
                <#assign hasAfterLogic=true>
            <#elseif (afterlogic.getDstPSDE()!'')!='' && (afterlogic.getDstPSDEAction()!'')!='' && afterlogic.getDstPSDEAction().isEnableBackend()>
                <#assign hasAfterLogic=true>
                <#assign hasAfterDrl=true>
                <#break >
            </#if>
        </#if>
    </#list>
</#if>
<#if hasAfterLogic>
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" xmlns:g="http://www.jboss.org/drools/flow/gpd" xmlns:tns="http://www.jboss.org/drools" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" expressionLanguage="http://www.mvel.org/2.0" id="Definition" name="" targetNamespace="http://www.jboss.org/drools" typeLanguage="http://www.java.com/javaTypes">
        <process id="${pub.getPKGCodeName()}.core.${de.getPSSystemModule().codeName?lower_case}.${de.codeName?lower_case}.${item.codeName?lower_case}.afterLogic" isClosed="false" isExecutable="true" name="${de.getPSSystemModule().codeName?lower_case}_${de.codeName?lower_case}_${item.codeName?lower_case}_afterLogic" processType="Private" tns:packageName="${pub.getPKGCodeName()}.core.${de.getPSSystemModule().codeName?lower_case}.${de.codeName?lower_case}.${item.codeName?lower_case}.afterLogic">
            <extensionElements>
                <tns:import name="java.util.Map"/>
                <tns:import name="org.springframework.util.StringUtils"/>
                <tns:import name="${pub.getPKGCodeName()}.util.helper.RuleUtils"/>
                <tns:import name="${pub.getPKGCodeName()}.core.${de.getPSSystemModule().getCodeName()?lower_case}.domain.${de.getCodeName()}"/>
                <#comment>插入服务对象</#comment>
                <#list item.getAfterPSDEActionLogics() as afterlogic>
                    <#if (afterlogic.getDstPSDE()!'')!='' && (afterlogic.getDstPSDEAction()!'')!='' && afterlogic.getDstPSDEAction().isEnableBackend()>
                        <#assign dataentity = afterlogic.getDstPSDE()>
                        <#assign deaction = afterlogic.getDstPSDEAction()>
                        <#if !P.exists("refservice",dataentity+"service")>
                            <tns:metaData express="T(${pub.getPKGCodeName()}.util.security.SpringContextHolder).getBean(T(${pub.getPKGCodeName()}.core.${dataentity.getPSSystemModule().codeName?lower_case}.service.I${dataentity.codeName}Service))" name="${srfcaseformat(dataentity.getCodeName(),'l_u2lC')}Service" type="service"/>
                        </#if>
                    </#if>
                </#list>
                <#if hasAfterDrl>
                    <#comment>插入当前实体对象</#comment>
                    <tns:metaData express="" name="et" type="entity"/>
                </#if>
            </extensionElements>
            <#if item.getAfterPSDEActionLogics?? && item.getAfterPSDEActionLogics()??>
                <startEvent id="begin" isInterrupting="true"/>
                <endEvent id="prepareparam1_end" name="end"/>
                <#assign source="begin">
                <#list item.getAfterPSDEActionLogics() as afterlogic>
                    <#if afterlogic.isValid()==true && afterlogic.getActionLogicType()?c!='2'>
                        <#comment>实体行为附加逻辑</#comment>
                        <#if afterlogic.isInternalLogic() && afterlogic.getPSDELogic().isEnableBackend() && afterlogic.getPSDELogic().isCustomCode()== false>
                            <#assign delogic = afterlogic.getPSDELogic()>
                            <#assign target =afterlogic.getId()>
                            <callActivity activiti:exclusive="true" calledElement="${pub.getPKGCodeName()}.core.${de.getPSSystemModule().codeName?lower_case}.service.logic.${de.codeName?lower_case}${delogic.getCodeName()?lower_case}" id="${target}" name="${delogic.codeName}.json.bpmn"/>
                        <#elseif afterlogic.getDstPSDEAction()??  &&  afterlogic.getDstPSDEAction().isEnableBackend()>
                            <#assign dataentity = afterlogic.getDstPSDE()>
                            <#assign deaction = afterlogic.getDstPSDEAction()>
                            <#assign groupName = (dataentity.codeName + deaction.codeName)?lower_case>
                            <#assign target = afterlogic.getId()>
                            <businessRuleTask activiti:exclusive="true" g:ruleFlowGroup="${target}" id="${target}" implementation="http://www.jboss.org/drools/rule" name="${groupName}"/>
                        </#if>
                        <sequenceFlow id="${source}_${target}" sourceRef="${source}" targetRef="${target}"/>
                        <#assign source = target>
                        <#if !afterlogic_has_next>
                            <sequenceFlow id="${source}_prepareparam1_end" sourceRef="${source}" targetRef="prepareparam1_end"/>
                        </#if>
                    </#if>
                </#list>
            </#if>
        </process>
    </definitions>
</#if>
