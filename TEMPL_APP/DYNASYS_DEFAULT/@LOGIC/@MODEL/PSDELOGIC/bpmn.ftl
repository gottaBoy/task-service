<#if item.isEnableBackend() && item.isCustomCode()== false>
    <#assign de=item.getPSDataEntity()>
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" xmlns:g="http://www.jboss.org/drools/flow/gpd" xmlns:tns="http://www.jboss.org/drools" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" expressionLanguage="http://www.mvel.org/2.0" id="Definition" name="" targetNamespace="http://www.jboss.org/drools" typeLanguage="http://www.java.com/javaTypes">
        <process id="${pub.getPKGCodeName()}.core.${de.getPSSystemModule().codeName?lower_case}.service.logic.${de.codeName?lower_case}${item.getCodeName()?lower_case}" isClosed="false" isExecutable="true" name="${de.getPSSystemModule().codeName?lower_case}_${de.codeName?lower_case}_${item.codeName?lower_case}_ruleFlow" processType="Private" tns:packageName="${pub.getPKGCodeName()}.core.${de.getPSSystemModule().codeName?lower_case}.service.logic.${de.codeName?lower_case}${item.getCodeName()?lower_case}">
            <extensionElements>
                <tns:import name="java.util.Map" />
                <tns:import name="org.springframework.util.StringUtils"/>
                <tns:import name="${pub.getPKGCodeName()}.util.helper.RuleUtils"/>
                <#if pub.isEnableDynaModel()?? && pub.isEnableDynaModel()== true>
                    <#comment>插入逻辑参数</#comment>
                    <#if item.getPSDELogicParams?? && item.getPSDELogicParams()??>
                        <#assign logicName=(de.codeName+item.codeName)?lower_case>
                        <#list item.getPSDELogicParams() as logicParam>
                            <#assign paramObj=(logicName+logicParam.codeName)?lower_case>
                            <#if logicParam.isDefault()==true><#comment>默认变量</#comment>
                                <tns:metaData express="" name="${paramObj}" type="entity"/>
                            <#elseif logicParam.getParamPSDataEntity?? && logicParam.getParamPSDataEntity()??>
                                <#assign ParamPSDataEntity=logicParam.getParamPSDataEntity()>
                                <tns:metaData express="new ${pub.getPKGCodeName()}.core.${ParamPSDataEntity.getPSSystemModule().codeName?lower_case}.domain.${ParamPSDataEntity.codeName}()" name="${(logicName+logicParam.codeName)?lower_case}" type="refentity"/>
                            <#else>
                                <tns:metaData express="new HashMap()" name="${(logicName+logicParam.codeName)?lower_case}" type="refentity"/>
                            </#if>
                        </#list>
                    </#if>
                    <#comment>插入处理逻辑中所用到的service对象</#comment>
                    <#if item.getPSDELogicNodes?? && item.getPSDELogicNodes()??>
                        <#list item.getPSDELogicNodes() as deLogicNode>
                            <#if deLogicNode.getDstPSDataEntity?? && deLogicNode.getDstPSDataEntity()??>
                                <#assign nodePSDataEntity=deLogicNode.getDstPSDataEntity()>
                                <#if !P.exists(item.codeName,"kieSessionGlobalServiceBpmn",deLogicNode.getDstPSDataEntity().getCodeName()?lower_case)>
                                    <tns:metaData express="T(${pub.getPKGCodeName()}.util.security.SpringContextHolder).getBean(T(${pub.getPKGCodeName()}.core.${nodePSDataEntity.getPSSystemModule().codeName?lower_case}.service.I${nodePSDataEntity.codeName}Service))" name="${deLogicNode.getDstPSDataEntity().getCodeName()?lower_case}service" type="service"/>
                                </#if>
                            </#if>
                        </#list>
                    </#if>
                    <#comment>插入当前实体的defaultService对象，供自定义查询使用</#comment>
                    <tns:metaData express="T(${pub.getPKGCodeName()}.util.security.SpringContextHolder).getBean(T(${pub.getPKGCodeName()}.core.${de.getPSSystemModule().codeName?lower_case}.service.I${de.codeName}Service))" name="iBzSys${de.codeName?lower_case?cap_first}DefaultService" type="service"/>
                    <tns:metaData express="T(${pub.getPKGCodeName()}.util.security.AuthenticationUser).getAuthenticationUser()" name="curuser" type="session"/>
                </#if>
                <#assign logicName=(de.codeName+item.codeName)?lower_case>
                <#comment>插入逻辑参数</#comment>
                <#if item.getPSDELogicParams?? && item.getPSDELogicParams()??>
                    <#list item.getPSDELogicParams() as logicParam>
                        <#if logicParam.getParamPSDataEntity?? && logicParam.getParamPSDataEntity()??>
                            <#assign ParamPSDataEntity=logicParam.getParamPSDataEntity()>
                            <tns:global identifier="${logicName+logicParam.codeName?lower_case}" type="${pub.getPKGCodeName()}.core.${ParamPSDataEntity.getPSSystemModule().codeName?lower_case}.domain.${ParamPSDataEntity.codeName}" />
                        <#else>
                        </#if>
                    </#list>
                </#if>
            </extensionElements>
            <#comment>绘制处理节点</#comment>
            <#if item.getPSDELogicNodes?? && item.getPSDELogicNodes()??>
                <#list item.getPSDELogicNodes() as logicNode>
                    <#if logicNode.getLogicNodeType()=='BEGIN'>
                        <startEvent id="${logicNode.getCodeName()?lower_case}" isInterrupting="true"/>
                    <#else>
                        <businessRuleTask activiti:exclusive="true" g:ruleFlowGroup="${logicName+logicNode.getCodeName()?lower_case}" id="${logicNode.getCodeName()?lower_case}" implementation="http://www.jboss.org/drools/rule" name="${logicNode.getName()}"/>
                    </#if>
                    <#if !(logicNode.getPSDELogicLinks()??)><#comment>是否为流程最后一个处理节点，若为最后一个处理节点则生成End节点</#comment>
                        <endEvent id="${logicNode.getCodeName()?lower_case}_end" name="end"/>
                        <sequenceFlow id="${logicNode.getCodeName()?lower_case}_end_line" sourceRef="${logicNode.getCodeName()?lower_case}" targetRef="${logicNode.getCodeName()?lower_case}_end"/><#comment>生成流程最后一个处理节点与End节点之间的连线</#comment>
                    </#if>
                </#list>
            </#if>
            <#comment>绘制节点连线</#comment>
            <#if item.getPSDELogicLinks?? && item.getPSDELogicLinks()??>
                <#list item.getPSDELogicLinks() as LogicLink>
                    <#assign sourceNodeId=LogicLink.getSrcPSDELogicNode().getCodeName()?lower_case>
                    <#if LogicLink.getPSDELogicLinkGroupCond?? && LogicLink.getPSDELogicLinkGroupCond()??><#comment>判断连接线含有条件，若有条件，则将源节点指向网关</#comment>
                        <#assign sourceNodeId=("gateway-"+LogicLink.getSrcPSDELogicNode().getCodeName())?lower_case>
                    </#if>
                    <#assign targetNodeId=LogicLink.getDstPSDELogicNode().getCodeName()?lower_case>
                    <sequenceFlow id="${sourceNodeId}_${targetNodeId}" sourceRef="${sourceNodeId}" targetRef="${targetNodeId}">
                        <#if LogicLink.getPSDELogicLinkGroupCond?? && LogicLink.getPSDELogicLinkGroupCond()??><#comment>连接线含有条件</#comment>
                            <conditionExpression  language="http://www.jboss.org/drools/rule" ><![CDATA[
                                <#comment>准备逻辑参数</#comment>
                                <#if item.getPSDELogicParams?? && item.getPSDELogicParams()??>
                                    <#list item.getPSDELogicParams() as logicParam>
                                        <#if logicParam.getParamPSDataEntity?? && logicParam.getParamPSDataEntity()??>
                                            <#assign ParamPSDataEntity=logicParam.getParamPSDataEntity()>
                                            $${logicName+logicParam.codeName?lower_case}:${ParamPSDataEntity.codeName}();
                                        <#else>
                                            $${logicName+logicParam.codeName?lower_case}:Map();
                                        </#if>
                                    </#list>
                                    <#assign strExpCond=getConditionExpression(item)>
                                    eval(${strExpCond});<#comment>在fact中寻找与global中对应参数</#comment>
                                </#if>
                                <#assign LogicLinkCond=LogicLink.getPSDELogicLinkGroupCond()>
                                <#assign strGroupCond=getGroupCond(LogicLinkCond)>
                                eval${strGroupCond}
                                ]]>
                            </conditionExpression>
                        </#if>
                    </sequenceFlow>
                </#list>
            </#if>
            <#comment>生成交互网关节点</#comment>
            <#if item.getPSDELogicLinks?? && item.getPSDELogicLinks()??>
                <#list item.getPSDELogicLinks() as LogicLink>
                    <#if LogicLink.getPSDELogicLinkGroupCond?? && LogicLink.getPSDELogicLinkGroupCond()??><#comment>连接线含有条件</#comment>
                        <#assign  gatewayId="gateway-"+LogicLink.getSrcPSDELogicNode().getCodeName()?lower_case>
                        <#if !P.exists("gateway",gatewayId)>
                            <#comment>绘制网关</#comment>
                            <exclusiveGateway id="${gatewayId}" name="Gateway" gatewayDirection="Diverging" default="${gatewayId}_end_line"></exclusiveGateway>
                            <#comment>绘制网关与源节点的连线</#comment>
                            <#assign sourceNodeId=LogicLink.getSrcPSDELogicNode().getCodeName()?lower_case>
                            <sequenceFlow id="${sourceNodeId}_${gatewayId}_gatewayline" sourceRef="${sourceNodeId}" targetRef="${gatewayId}"></sequenceFlow>
                        </#if>
                        <#comment>绘制网关默认结束节点</#comment>
                        <#if !P.exists("gateway-end",gatewayId)>
                            <sequenceFlow id="${gatewayId}_end_line" sourceRef="${gatewayId}" targetRef="${gatewayId}_end"/><#comment>生成流程最后一个处理节点与End节点之间的连线</#comment>
                            <endEvent id="${gatewayId}_end" name="end"/>
                        </#if>
                    </#if>
                </#list>
            </#if>
        </process>
    </definitions>
</#if>

<#comment>获取组合条件表达式</#comment>
<#function getGroupCond LogicLinkCond>
    <#assign strRuleCond="(">
    <#if LogicLinkCond.getPSDELogicLinkConds?? && LogicLinkCond.getPSDELogicLinkConds()??><#comment>判断是否有组条件</#comment>
        <#assign conn=LogicLinkCond.getGroupOP()?replace("AND","&&")?replace("OR","||")>
        <#list LogicLinkCond.getPSDELogicLinkConds() as childLogicLinkCond><#comment>组条件，递归</#comment>
            <#if childLogicLinkCond.getPSDELogicLinkConds?? && childLogicLinkCond.getPSDELogicLinkConds()??>
                <#assign strRuleCond=strRuleCond+getGroupCond(childLogicLinkCond)>//getGroupCond
            <#else>
                <#assign strRuleCond=strRuleCond+getFieldCond(childLogicLinkCond)>//getFieldCond
            </#if>
            <#if childLogicLinkCond_has_next>
                <#assign strRuleCond=strRuleCond+conn>//拼接连接符
            </#if>
        </#list>
    </#if>
    <#assign strRuleCond=strRuleCond+")">
    <#return strRuleCond/>
</#function>

<#comment>获取单项条件表达式</#comment>
<#function getFieldCond LogicLinkCond>
    <#assign fieldCond="(" >
    <#assign condBody="">
    <#assign targetParam=LogicLinkCond.getDstLogicParam()><#comment>目标参数</#comment>
    <#assign targetFieldName=LogicLinkCond.getDstFieldName()><#comment>目标属性名称</#comment>
    <#assign targetDEField=((targetParam.getParamPSDataEntity().getPSDEField(targetFieldName,true))!'')><#comment>目标属性</#comment>
    <#assign targetDBValueOP=LogicLinkCond.getPSDBValueOPId()><#comment>表达式</#comment>
    <#assign targetValue=LogicLinkCond.getValue()><#comment>值项</#comment>
    <#if targetDEField!=''>
        <#assign targetFieldName=srfcaseformat(targetDEField.codeName,'l_u2lC')>
    </#if>
    <#assign condBody="RuleUtils.test($"+logicName+targetParam.getCodeName()?lower_case+".get(\""+targetFieldName+"\"),\""+targetDBValueOP+"\","+"\""+targetValue+"\")">
    <#assign fieldCond=fieldCond+condBody >
    <#assign fieldCond=fieldCond+")" >
    <#return fieldCond/>
</#function>

<#comment>获取conditionExpression</#comment>
<#function getConditionExpression LogicParams>
    <#assign expressionCond="" >
    <#list LogicParams.getPSDELogicParams() as logicParam>
        <#assign condBody="">
        <#if logicParam.getParamPSDataEntity?? && logicParam.getParamPSDataEntity()??>
            <#assign condBody='$'+logicName+logicParam.codeName?lower_case+'=='+logicName+logicParam.codeName?lower_case>
            <#if logicParam_has_next>
                <#assign condBody=condBody+" && ">
            </#if>
        <#else>
            //暂未实现
        </#if>
        <#assign expressionCond=expressionCond+condBody >
    </#list>
    <#return expressionCond/>
</#function>
