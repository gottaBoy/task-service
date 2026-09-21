<#if item.getActionType()=='DELOGIC' && item.getPSDELogic()??  && item.getPSDELogic().isEnableBackend() && item.getPSDELogic().isCustomCode()== false>
    <#assign de=item.getPSDataEntity()>
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" xmlns:g="http://www.jboss.org/drools/flow/gpd" xmlns:tns="http://www.jboss.org/drools" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" expressionLanguage="http://www.mvel.org/2.0" id="Definition" name="" targetNamespace="http://www.jboss.org/drools" typeLanguage="http://www.java.com/javaTypes">
        <process id="${pub.getPKGCodeName()}.core.extensions.service.logic.execute" isClosed="false" isExecutable="true" name="${de.getPSSystemModule().codeName?lower_case}_${de.codeName?lower_case}_${item.codeName?lower_case}_execLogic" processType="Private" tns:packageName="${pub.getPKGCodeName()}.core.extensions.service.logic.execute">
            <extensionElements>
                <tns:import name="java.util.Map"/>
                <tns:import name="org.springframework.util.StringUtils"/>
                <tns:import name="${pub.getPKGCodeName()}.util.helper.RuleUtils"/>
            </extensionElements>
            <#comment>实体行为附加逻辑</#comment>
            <#assign delogic = item.getPSDELogic()>
            <#assign source="begin">
            <#assign action=item.getPSDELogic()>
            <startEvent id="begin" isInterrupting="true"/>
            <endEvent id="prepareparam1_end" name="end"/>
            <#assign target = action.getCodeName()>
            <callActivity activiti:exclusive="true" calledElement="${pub.getPKGCodeName()}.core.${de.getPSSystemModule().codeName?lower_case}.service.logic.${de.codeName?lower_case}${delogic.getCodeName()?lower_case}" id="${target}" name="${delogic.codeName}.json.bpmn"/>
            <sequenceFlow id="${source}_${target}" sourceRef="${source}" targetRef="${target}"/>
            <#assign source = target>
            <sequenceFlow id="${source}_${target}" sourceRef="${source}" targetRef="prepareparam1_end"/>
        </process>
    </definitions>
</#if>