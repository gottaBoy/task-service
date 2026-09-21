<#assign hasPSWFProcesses=false>
<#list item.getPSWFProcesses() as wfProcess>
    <#assign hasPSWFProcesses=true>
    <#break >
</#list>
<#if hasPSWFProcesses>
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:flowable="http://flowable.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC" xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI" typeLanguage="http://www.w3.org/2001/XMLSchema" expressionLanguage="http://www.w3.org/1999/XPath" targetNamespace="http://www.flowable.org/processdef">
    <process id="${sys.getCodeName()?lower_case}-${item.codeName?lower_case}" isClosed="false" isExecutable="true" name="${item.getName()}" processType="None">
        <extensionElements>
            <flowable:eventListener delegateExpression="${r'${processInstanceListener}'}"  />
            <#if item.getPSWFProcesses?? && item.getPSWFProcesses()??>
                <#assign rolesList="">
                <#list item.getPSWFProcesses() as WFProcess>
                    <#if WFProcess.getPSWFProcessRoles?? && WFProcess.getPSWFProcessRoles()??>
                        <#list WFProcess.getPSWFProcessRoles() as processRole>
                            <#assign processRoleType=processRole.getWFProcessRoleType()>
                            <#if processRoleType=='WFROLE'>
                               <#if processRole.getPSWFRole()?? && processRole.getPSWFRole().getCodeName()??>
                                    <#if !P.exists("refgroups",processRole.getPSWFRole().getCodeName())>
                                        <#if rolesList!=""><#assign rolesList=rolesList+","></#if>
                                        <#assign rolesList=rolesList+processRole.getPSWFRole().getCodeName()+"|"+processRole.getPSWFRole().getName()+"|"+processRole.getPSWFRole().getWFRoleType()>
                                        <#if processRole.getPSWFRole().getWFRoleType()=="DEDATASET">
                                            <#assign rolesList=rolesList+"/"+processRole.getPSWFRole().getPSDEDataSet().getPSDataEntity().getName()?lower_case+"/"+processRole.getPSWFRole().getPSDEDataSet().getCodeName()?lower_case+"/"+processRole.getPSWFRole().getWFUserIdPSDEF().getCodeName()?lower_case>
                                        </#if>
                                    </#if>
                               </#if>
                            </#if>
                        </#list>
                    </#if>
                </#list>
                <#if rolesList!="">
            <flowable:field name="refgroups">
                <flowable:string>${rolesList}</flowable:string>
            </flowable:field>
                </#if>
            </#if>
            <#if item.getPSWorkflow()?? && item.getPSWorkflow().getPSWFDEs()??>
            <#assign des="">
            <#list item.getPSWorkflow().getPSWFDEs() as wfde>
            <#if des!=""><#assign des=des+","></#if>
            <#assign des=des+wfde.getPSDataEntity().getName()?lower_case>
            </#list>
            <#if des!="">
            <flowable:field name="bookings">
                <flowable:string>${des}</flowable:string>
            </flowable:field>
            </#if>
            <#list item.getPSWorkflow().getPSWFDEs() as wfde>
            <#assign mobApp="">
            <#assign pcApp="">
            <#if wfde.getPSDataEntity()??>
            <#assign refDE=wfde.getPSDataEntity()>
                <#if refDE.getAllPSAppDataEntities()??>
                    <#list refDE.getAllPSAppDataEntities() as refAppDE>
                        <#assign app=refAppDE.getPSApplication()>
                        <#if app.isMobileApp()>
                            <#if !P.exists("mob",app.codeName)>
                                <#if mobApp=="">
                                    <#assign mobApp=app.codeName>
                                <#else>
                                    <#assign mobApp=mobApp+","+app.codeName>
                                </#if>
                            </#if>
                        <#else>
                            <#if !P.exists("pc",app.codeName)>
                                <#if pcApp=="">
                                    <#assign pcApp=app.codeName>
                                <#else>
                                    <#assign pcApp=pcApp+","+app.codeName>
                                </#if>
                            </#if>
                        </#if>
                    </#list>
                </#if>
                <#if pcApp!="">
            <flowable:field name="bookingapps_${refDE.getName()?lower_case}">
                <flowable:string>${pcApp}</flowable:string>
            </flowable:field>
                </#if>
                <#if mobApp!="">
            <flowable:field name="bookingmobs_${refDE.getName()?lower_case}">
                <flowable:string>${mobApp}</flowable:string>
            </flowable:field>
                </#if>
            </#if>
            </#list>
            <#list item.getPSWorkflow().getPSWFDEs() as wfde>
            <#if wfde.getWFStepPSDEField()??>
            <flowable:field name="wfstepfield_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${(wfde.getWFStepPSDEField().getCodeName()?lower_case)}</flowable:string>
            </flowable:field>
            </#if>
            <#if wfde.getWFInstPSDEField()??>
            <flowable:field name="wfinstfield_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${(wfde.getWFInstPSDEField().getCodeName()?lower_case)}</flowable:string>
            </flowable:field>
            </#if>
            <#if wfde.getUDStatePSDEField()??>
            <flowable:field name="udstatefield_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${(wfde.getUDStatePSDEField().getCodeName()?lower_case)}</flowable:string>
            </flowable:field>
            </#if>
            <#comment>流程中状态值</#comment>
            <#if item.getPSWorkflow().getEntityWFStates?? && item.getPSWorkflow().getEntityWFStates()??>
                <#list item.getPSWorkflow().getEntityWFStates() as wfStatus>
            <flowable:field name="udstateingval_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${wfStatus}</flowable:string>
            </flowable:field>
                <#break>
                </#list>
            </#if>
            <#comment>流程结束状态值</#comment>
            <#if item.getPSWorkflow().getEntityWFFinishState?? && item.getPSWorkflow().getEntityWFFinishState()??>
            <flowable:field name="wffinishval_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${item.getPSWorkflow().getEntityWFFinishState()}</flowable:string>
            </flowable:field>
            </#if>
            <#comment>流程取消状态值</#comment>
            <#if item.getPSWorkflow().getEntityWFCancelState?? && item.getPSWorkflow().getEntityWFCancelState()??>
            <flowable:field name="wfcancelval_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${item.getPSWorkflow().getEntityWFCancelState()}</flowable:string>
            </flowable:field>
            </#if>
            <#comment>流程异常状态值</#comment>
            <#if item.getPSWorkflow().getEntityWFErrorState?? && item.getPSWorkflow().getEntityWFErrorState()??>
            <flowable:field name="wferrorval_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${item.getPSWorkflow().getEntityWFErrorState()}</flowable:string>
            </flowable:field>
            </#if>
            <#if wfde.getWFStatePSDEField()??>
            <flowable:field name="wfstatefield_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${(wfde.getWFStatePSDEField().getCodeName()?lower_case)}</flowable:string>
            </flowable:field>
            </#if>
            <#if wfde.getWFVerPSDEField()??>
            <flowable:field name="wfverfield_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${(wfde.getWFVerPSDEField().getCodeName()?lower_case)}</flowable:string>
            </flowable:field>
            </#if>
            <#if wfde.getPSDataEntity().getMajorPSDEField()??&&wfde.getPSDataEntity().getMajorPSDEField().getCodeName()??>
            <flowable:field name="majortext_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${(wfde.getPSDataEntity().getMajorPSDEField().getCodeName()?lower_case)}</flowable:string>
            </flowable:field>
            </#if>
            <#comment>组织属性</#comment>
            <#if wfde.getPSDataEntity()?? && wfde.getPSDataEntity().getPSDEFieldByPDT('ORGID',true)??>
            <#assign orgField = wfde.getPSDataEntity().getPSDEFieldByPDT('ORGID',true)>
            <flowable:field name="orgfield_${wfde.getPSDataEntity().getName()?lower_case}">
                <flowable:string>${(orgField.getCodeName()?lower_case)}</flowable:string>
            </flowable:field>
            </#if>
            </#list>
            <#comment>工作流是否启动</#comment>
            <flowable:field name="isvalid">
            <#if item.isValid()>
                <flowable:string>1</flowable:string>
            <#else>
                <flowable:string>0</flowable:string>
            </#if>
            </flowable:field>
            </#if>
        </extensionElements>

            <#comment>绘制处理节点</#comment>
            <#if item.getPSWFProcesses?? && item.getPSWFProcesses()??>
                <#list item.getPSWFProcesses() as WFProcess>
                    <#if WFProcess.getWFProcessType()=='START'>
     <startEvent id="sid-${WFProcess.getDeployId()}" name="${WFProcess.getName()}">
                        <#if ( ((WFProcess.getFormCodeName())!'')!='' || ((WFProcess.getMobFormCodeName())!'')!='' )  && item.getWFVersion()??>
          <extensionElements>
            <flowable:form <#if ((WFProcess.getFormCodeName())!'')!=''>process-form="${WFProcess.getFormCodeName()}"</#if><#if ((WFProcess.getMobFormCodeName())!'')!=''> process-mobform="${WFProcess.getMobFormCodeName()}" </#if> <#if item.getWFVersion()??>wfversion="${item.getWFVersion()}"</#if>/>
          </extensionElements>
                        </#if>
     </startEvent>
                    <#elseif WFProcess.getWFProcessType()=='END'>
     <endEvent id="sid-${WFProcess.getDeployId()}" name="${WFProcess.getName()}">
         <#assign endFormParam="">
          <#comment>退出切换状态值</#comment>
         <#if ((WFProcess.getExitStateValue())!'')!=''>
             <#assign endFormParam=endFormParam+ "exitstatevalue=\""+WFProcess.getExitStateValue()+"\" ">
         </#if>
         <#comment>处理数据</#comment>
         <#if ((WFProcess.getUserData())!'')!=''>
             <#assign endFormParam=endFormParam+ "userdata=\""+WFProcess.getUserData()+"\" ">
         </#if>
         <#comment>处理数据2</#comment>
          <#if ((WFProcess.getUserData2())!'')!=''>
              <#assign endFormParam=endFormParam+ "userdata2=\""+WFProcess.getUserData2()+"\" ">
          </#if>
       <#if endFormParam!=''>
            <extensionElements>
                <flowable:form ${endFormParam} />
            </extensionElements>
       </#if>
     </endEvent>
                    <#elseif WFProcess.getWFProcessType()=='PARALLELGATEWAY'>
     <parallelGateway id="sid-${WFProcess.getDeployId()}"></parallelGateway>
                    <#elseif WFProcess.getWFProcessType()=='INCLUSIVEGATEWAY'>
     <inclusiveGateway id="sid-${WFProcess.getDeployId()}"></inclusiveGateway>
                    <#elseif WFProcess.getWFProcessType()=='EXCLUSIVEGATEWAY'>
     <exclusiveGateway id="sid-${WFProcess.getDeployId()}"></exclusiveGateway>
                    <#elseif WFProcess.getWFProcessType()=='PROCESS'>
     <serviceTask id="sid-${WFProcess.getDeployId()}" name="${WFProcess.getName()}" flowable:expression="${r'${wfCoreService.execute(execution, activedata)}'}" >
         <#if WFProcess.getPSDataEntity()??>
         <extensionElements>
         <flowable:field name="service-entity"><flowable:string>${WFProcess.getPSDataEntity().getName()?lower_case}</flowable:string></flowable:field>
         <flowable:field name="service-deaction"><flowable:string>${WFProcess.getPSDEAction().getCodeName()?lower_case}</flowable:string></flowable:field>
         <#if WFProcess.getPSWFProcessParams()??>
         <#list WFProcess.getPSWFProcessParams() as processparams>
         <#if processparams.getDstField()?? && processparams.getDstField()!="">
            <#if processparams.getSrcValueType()?? && processparams.getSrcValueType()!="" >
                <#if processparams.getSrcValueType()=="CURTIME">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${wfCoreService.getnow()}'}]]></flowable:expression></flowable:field>
                <#elseif processparams.getSrcValueType()=="OPERATOR">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${curuser.userid}'}]]></flowable:expression></flowable:field>
                <#elseif processparams.getSrcValueType()=="OPERATORNAME">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${curuser.personname}'}]]></flowable:expression></flowable:field>
                <#elseif processparams.getSrcValueType()=="CONTEXT">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${activedata.'}${(processparams.getSrcValue()?lower_case)}${r'}'}]]></flowable:expression></flowable:field>
                <#elseif processparams.getSrcValueType()=="SESSION">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${curuser.sessionParams.'}${processparams.getSrcValue()?lower_case}${r'}'}]]></flowable:expression></flowable:field>
                </#if>
            <#else>
        <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:string>${processparams.getSrcValue()}</flowable:string></flowable:field>
            </#if>
         </#if>
         </#list>
         </#if>
         </extensionElements>
         </#if>
         <#comment>空处理</#comment>
         <#if !(WFProcess.getPSDataEntity()??)>
         <extensionElements>
         <#if WFProcess.getPSWFProcessParams()??>
            <#list WFProcess.getPSWFProcessParams() as processparams>
                <#if processparams.getSrcValue()?? && processparams.getDstField()?? && processparams.getDstField()!="">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:string>${processparams.getSrcValue()}</flowable:string></flowable:field>
                </#if>
            </#list>
         </#if>
         </extensionElements>
         </#if>
     </serviceTask>
                    <#else>
                        <#assign assignCond="">
                        <#assign isSequential="">
                        <#if WFProcess.getMultiInstMode?? && WFProcess.getMultiInstMode()?? && ( WFProcess.getMultiInstMode()=='PARALLEL' || WFProcess.getMultiInstMode()=='SEQUENTIAL')>
                            <#assign assignCond="flowable:assignee=\""+"$"+"{assignee}\"">
                            <#if WFProcess.getMultiInstMode()=='SEQUENTIAL'>
                                <#assign isSequential="isSequential=\"true\"">
                            <#else>
                                <#assign isSequential="isSequential=\"false\"">
                            </#if>
                        </#if>
                        <#assign assignCond="">
                        <#assign assignUtCond="">
                        <#assign assignSendCopyCond="">
                        <#assign assignGroupCond="">
                        <#assign assignUtGroupCond="">
                        <#if WFProcess.getPSWFProcessRoles?? && WFProcess.getPSWFProcessRoles()??>
                            <#list WFProcess.getPSWFProcessRoles() as processRole>
                                <#assign processRoleType=processRole.getWFProcessRoleType()>
                                <#assign roleId="">
                                <#if processRoleType=='WFROLE'>
                                   <#if processRole.getPSWFRole()?? && processRole.getPSWFRole().getCodeName()??>
                                       <#if assignGroupCond!="">
                                           <#assign assignGroupCond=assignGroupCond+",">
                                           <#assign assignUtGroupCond=assignUtGroupCond+",">
                                       </#if>
                                       <#assign assignGroupCond=assignGroupCond+processRole.getPSWFRole().getCodeName()>
                                       <#if processRole.getUserData()?? && processRole.getUserData2()?? && processRole.getUserData()!="" && processRole.getUserData()!="">
                                       <#assign assignGroupCond=assignGroupCond+"|"+processRole.getUserData()+"|"+processRole.getUserData2()>
                                       </#if>
                                   </#if>
                                <#elseif processRoleType == 'CURACTOR'>
                                        <#assign assignCond=assignCond+"$"+"{activedata."+("CREATEMAN"?lower_case)+"}">
                                <#else>
                                   <#if processRole.getUDField()?? && processRole.getUDField()!="">
                                       <#if assignCond!="">
                                           <#assign assignCond=assignCond+",">
                                           <#assign assignUtCond=assignUtCond+",">
                                       </#if>
                                       <#if processRole.getUDField()?contains(";")>
                                           <#assign users=''>
                                           <#assign multiUsers=''>
                                           <#list processRole.getUDField()?split(";") as userType>
                                              <#assign users = users + "$"+"{activedata."+(userType?lower_case)+"}">
                                               <#assign multiUsers = multiUsers + "#activedata."+(userType?lower_case)>
                                               <#if userType_has_next>
                                                   <#assign users = users+",">
                                                   <#assign multiUsers = multiUsers+"|">
                                               </#if>
                                           </#list>
                                            <#assign assignCond=assignCond + users>
                                            <#assign assignUtCond=assignUtCond + multiUsers>
                                       <#else>
                                           <#assign assignCond=assignCond+"$"+"{activedata."+(processRole.getUDField()?lower_case)+"}">
                                           <#assign assignUtCond=assignUtCond+"#activedata."+(processRole.getUDField()?lower_case)>
                                       </#if>
                                   </#if>
                                </#if>
                            </#list>
                         </#if>
                         <#if assignGroupCond!="">
                         <#if assignCond!="">
                                           <#assign assignCond=assignCond+",">
                                           <#assign assignUtCond=assignUtCond+"||">
                         </#if>
                         <#assign assignCond=assignCond+"$"+"{wfCoreService.getGroupUsers('"+assignGroupCond+"',execution)}">
                         <#assign assignUtCond=assignUtCond+"#"+"wfCoreService.getGroupUsers2('"+assignGroupCond+"',#execution)">
                         </#if>
                        <#comment>工作流预置属性（用于流程跳转）</#comment>
                        <#if assignCond!="">
                            <#assign assignCond=assignCond+",">
                        </#if>
                        <#if assignUtCond!="">
                            <#assign assignUtCond=assignUtCond+"||">
                        </#if>
                        <#assign assignCond=assignCond+"$"+"{activedata.srfwfpredefinedusers}">
                        <#assign assignUtCond=assignUtCond+"#activedata.srfwfpredefinedusers">
                        <#assign isMultiInstance =false>
                            <#if WFProcess.getMultiInstMode?? && WFProcess.getMultiInstMode()?? && ( WFProcess.getMultiInstMode()=='PARALLEL' || WFProcess.getMultiInstMode()=='SEQUENTIAL')>
                                <#assign isMultiInstance=true>
                            </#if>
                        <#assign isTimeOut =false>
                            <#if WFProcess.isEnableTimeout()>
                                <#assign isTimeOut=true>
                                <#assign timeoutType = WFProcess.getTimeoutType()>
                                <#assign timeout = WFProcess.getTimeout()>
                                <#assign timeUnit = "">
                                <#assign timeType = "">
                                <#if timeoutType == 'MINUTE'>
                                    <#assign timeUnit = 'M'>
                                    <#assign timeType = "PT">
                                <#elseif  timeoutType == 'HOUR'>
                                    <#assign timeUnit = 'H'>
                                    <#assign timeType = "PT">
                                <#elseif  timeoutType == 'DAY'>
                                    <#assign timeUnit = 'D'>
                                    <#assign timeType = "P">
                                </#if>
                            </#if>
                        <#assign formParam="">
                        <#assign dueDate="">
                        <#assign procfunc="">
                        <#if WFProcess.getPredefinedActions?? && WFProcess.getPredefinedActions()??>
                            <#list WFProcess.getPredefinedActions() as preaction>
                                <#assign procfunc=procfunc+preaction?lower_case>
                                <#if preaction_has_next>
                                    <#assign procfunc=procfunc+";">
                                </#if>
                            </#list>
                        </#if>
                        <#comment>流程辅助功能</#comment>
                        <#if procfunc!=''>
                            <#assign formParam=formParam+ "procfunc=\""+procfunc+"\" ">
                        </#if>
                        <#comment>超时策略</#comment>
                        <#assign isTimeoutLink = false>
                        <#if isTimeOut>
                            <#if WFProcess.getPSWFLinks?? && WFProcess.getPSWFLinks()??>
                            <#list WFProcess.getPSWFLinks() as WFLink>
                                <#if WFLink.getWFLinkType() == 'TIMEOUT'>
                                    <#assign isTimeoutLink = true>
                                </#if>
                            </#list>
                            <#if !isTimeoutLink>
                                <#assign timeoutStrategy =  timeType + timeout + timeUnit>
                                <#assign dueDate = "flowable:dueDate=\""+timeoutStrategy+"\" ">
                            </#if>
                        </#if>
                        </#if>
                        <#comment>流程表单配置</#comment>
                        <#if ((WFProcess.getFormCodeName())!'')!=''>
                            <#assign formParam=formParam+ "process-form=\""+WFProcess.getFormCodeName()+"\" " >
                        </#if>
                        <#comment>流程表单配置(移动端)</#comment>
                        <#if ((WFProcess.getMobFormCodeName())!'')!=''>
                            <#assign formParam=formParam+ "process-mobform=\""+WFProcess.getMobFormCodeName()+"\" ">
                        </#if>
                        <#comment>流程辅助功能表单配置(pc)</#comment>
                        <#if ((WFProcess.utilFormCodeName)!'')!=''>
                            <#assign formParam=formParam+ "process-utilform=\""+WFProcess.utilFormCodeName+"\" ">
                        </#if>
                        <#if ((WFProcess.util2FormCodeName)!'')!=''>
                            <#assign formParam=formParam+ "process-util2form=\""+WFProcess.util2FormCodeName+"\" " >
                        </#if>
                        <#if ((WFProcess.util3FormCodeName)!'')!=''>
                            <#assign formParam=formParam+ "process-util3form=\""+WFProcess.util3FormCodeName+"\" ">
                        </#if>
                        <#comment>流程辅助功能表单名称</#comment>
                        <#if ((WFProcess.utilFormName)!'')!=''>
                            <#assign formParam=formParam+ "process-utilformname=\""+WFProcess.utilFormName+"\" ">
                        </#if>
                        <#if ((WFProcess.util2FormName)!'')!=''>
                            <#assign formParam=formParam+ "process-util2formname=\""+WFProcess.util2FormName+"\" ">
                        </#if>
                        <#if ((WFProcess.util3FormName)!'')!=''>
                            <#assign formParam=formParam+ "process-util3formname=\""+WFProcess.util3FormName+"\" ">
                        </#if>
                        <#comment>流程辅助功能表单配置(移动端)</#comment>
                        <#if ((WFProcess.mobUtilFormCodeName)!'')!=''>
                            <#assign formParam=formParam+ "process-mobutilform=\""+WFProcess.mobUtilFormCodeName+"\" ">
                        </#if>
                        <#if ((WFProcess.mobUtil2FormCodeName)!'')!=''>
                            <#assign formParam=formParam+ "process-mobutil2form=\""+WFProcess.mobUtil2FormCodeName+"\" ">
                        </#if>
                        <#if ((WFProcess.mobUtil3FormCodeName)!'')!=''>
                            <#assign formParam=formParam+ "process-mobutil3form=\""+WFProcess.mobUtil3FormCodeName+"\" ">
                        </#if>
                        <#comment>流程辅助功能表单名称</#comment>
                        <#if ((WFProcess.mobUtilFormName)!'')!=''>
                            <#assign formParam=formParam+ "process-mobutilformname=\""+WFProcess.mobUtilFormName+"\" ">
                        </#if>
                        <#if ((WFProcess.mobUtil2FormName)!'')!=''>
                            <#assign formParam=formParam+ "process-mobutil2formname=\""+WFProcess.mobUtil2FormName+"\" ">
                        </#if>
                        <#if ((WFProcess.mobUtil3FormName)!'')!=''>
                            <#assign formParam=formParam+ "process-mobutil3formname=\""+WFProcess.mobUtil3FormName+"\" ">
                        </#if>
                        <#comment>工作流多实例</#comment>
                        <#if isMultiInstance && assignUtCond!=''>
                            <#assign formParam=formParam+ "candidateUsersList=\""+assignUtCond+"\" ">
                        </#if>
                        <#comment>工作流消息</#comment>
                        <#if (WFProcess.isSendInform?? && WFProcess.isSendInform()??) && (WFProcess.getassMsgTempl?? && WFProcess.getPSSysMsgTempl()??) && (WFProcess.getMsgType?? && WFProcess.getMsgType()??)>
                            <#assign formParam=formParam+ "msg-template=\""+WFProcess.getPSSysMsgTempl().getCodeName()?lower_case+"\" , msg-type=\""+WFProcess.getMsgType()+"\"" >
                        </#if>
                        <#comment>自定义参数</#comment>
                        <#if ((WFProcess.getUserData())!'')!='' || ((WFProcess.getUserData2())!'')!=''>
                            <#assign usertag = "">
                            <#if ((WFProcess.getUserData())!'')!=''>
                                <#assign usertag=WFProcess.getUserData()>
                            </#if>
                            <#if ((WFProcess.getUserData2())!'')!=''>
                                <#assign usertag = usertag+"|">
                                <#assign usertag=usertag+WFProcess.getUserData2()>
                            </#if>
                            <#assign formParam=formParam+ "usertag=\""+usertag+"\" " >
                        </#if>
                        <#comment>是否支持编辑</#comment>
                        <#if ((WFProcess.isEditable())!false)!=false>
                            <#assign formParam=formParam+ "isEditable=\""+WFProcess.isEditable()?c+"\" " >
                        </#if>
                        <#comment>编辑模式</#comment>
                        <#if ((WFProcess.isEditable())!false)!=false>
                            <#assign formParam=formParam+ "editMode=\""+WFProcess.getEditMode()+"\" " >
                        </#if>
                        <#comment>编辑属性</#comment>
                        <#if WFProcess.getEditFields?? && WFProcess.getEditFields()??>
                            <#assign editfields ="">
                            <#list WFProcess.getEditFields() as editfield>
                                <#assign editfields=editfields+ editfield>
                                <#if editfield_has_next>
                                    <#assign editfields=editfields+";" >
                                </#if>
                            </#list>
                            <#if editfields!="">
                                <#assign formParam=formParam+ "editFields=\""+editfields?lower_case+"\" " >
                            </#if>
                        </#if>
                        <#comment>处理意见属性</#comment>
                        <#if WFProcess.getMemoField?? && WFProcess.getMemoField()?? && ((WFProcess.getMemoField())!'')!=''>
                            <#assign formParam=formParam+ "memofield=\""+WFProcess.getMemoField()+"\" " >
                        </#if>
        <#if WFProcess.getWFProcessType()?? && (WFProcess.getWFProcessType()=="EMBED")>
    <subProcess flowable:category="${r'${businessKey}'}"  <#if dueDate != "">${dueDate}</#if> flowable:candidateUsers="<#if isMultiInstance>${r'${candidateUsers}'}<#else>${assignCond}</#if>" flowable:exclusive="true" id="sid-${WFProcess.getDeployId()}" name="${WFProcess.getName()}"  flowable:formKey="${WFProcess.getWFProcessType()}">
    <#elseif WFProcess.getWFProcessType()?? && (WFProcess.getWFProcessType()=="CALLORGACTIVITY")> 
    <#assign targetwf = WFProcess.getTargetPSWF()>
    <callActivity id="sid-${WFProcess.getDeployId()}" calledElement="${r'${wfCoreService.getDefinitionKey('}'${targetwf.getCodeName()}'${r', execution)}'}" flowable:calledElementType="key" flowable:inheritVariables="true" name="${WFProcess.getName()}"> 
    <#else>
    <userTask flowable:category="${r'${businessKey}'}"  <#if dueDate != "">${dueDate}</#if> flowable:candidateUsers="<#if isMultiInstance>${r'${candidateUsers}'}<#else>${assignCond}</#if>" flowable:exclusive="true" id="tid-${WFProcess.getWFStepValue()}-${WFProcess.getDeployId()}" name="${WFProcess.getName()}">
    </#if>
     <#if WFProcess.getPSWFProcessSubWFs?? && WFProcess.getPSWFProcessSubWFs()??>
     <#list WFProcess.getPSWFProcessSubWFs() as subWFVersion>
      <#assign EMBEDWFVersion=subWFVersion.getPSWFVersion()>
     <#if EMBEDWFVersion.getPSWorkflow().getUserTag()?? && EMBEDWFVersion.getPSWorkflow().getUserTag() == "EMB">
            <#comment>绘制处理节点</#comment>
            <#if EMBEDWFVersion.getPSWFProcesses?? && EMBEDWFVersion.getPSWFProcesses()??>
                <#list EMBEDWFVersion.getPSWFProcesses() as WFProcess>
                    <#if WFProcess.getWFProcessType()=='START'>
     <startEvent id="sub-sid-${WFProcess.getDeployId()}" name="${WFProcess.getName()}">
                        <#if ( ((WFProcess.getFormCodeName())!'')!='' || ((WFProcess.getMobFormCodeName())!'')!='' )  && EMBEDWFVersion.getWFVersion()??>
          <extensionElements>
            <flowable:form <#if ((WFProcess.getFormCodeName())!'')!=''>process-form="${WFProcess.getFormCodeName()}"</#if><#if ((WFProcess.getMobFormCodeName())!'')!=''> process-mobform="${WFProcess.getMobFormCodeName()}" </#if> <#if EMBEDWFVersion.getWFVersion()??>wfversion="${EMBEDWFVersion.getWFVersion()}"</#if>/>
          </extensionElements>
                        </#if>
     </startEvent>
                    <#elseif WFProcess.getWFProcessType()=='END'>
     <endEvent id="sub-sid-${WFProcess.getDeployId()}" name="${WFProcess.getName()}">
         <#assign endFormParamSub="">
         <#comment>退出切换状态值</#comment>
         <#if ((WFProcess.getExitStateValue())!'')!=''>
             <#assign endFormParamSub=endFormParamSub+ "exitstatevalue=\""+WFProcess.getExitStateValue()+"\" ">
         </#if>
         <#comment>处理数据</#comment>
         <#if ((WFProcess.getUserData())!'')!=''>
             <#assign endFormParamSub=endFormParamSub+ "userdata=\""+WFProcess.getUserData()+"\" ">
         </#if>
         <#comment>处理数据2</#comment>
          <#if ((WFProcess.getUserData2())!'')!=''>
              <#assign endFormParamSub=endFormParamSub+ "userdata2=\""+WFProcess.getUserData2()+"\" ">
          </#if>
       <#if endFormParamSub!=''>
            <extensionElements>
                <flowable:form ${endFormParamSub} />
            </extensionElements>
       </#if>
     </endEvent>
                    <#elseif WFProcess.getWFProcessType()=='PARALLELGATEWAY'>
     <parallelGateway id="sub-sid-${WFProcess.getDeployId()}"></parallelGateway>
                    <#elseif WFProcess.getWFProcessType()=='INCLUSIVEGATEWAY'>
     <inclusiveGateway id="sub-sid-${WFProcess.getDeployId()}"></inclusiveGateway>
                    <#elseif WFProcess.getWFProcessType()=='EXCLUSIVEGATEWAY'>
     <exclusiveGateway id="sub-sid-${WFProcess.getDeployId()}"></exclusiveGateway>
                    <#elseif WFProcess.getWFProcessType()=='PROCESS'>
     <serviceTask id="sub-sid-${WFProcess.getDeployId()}" name="${WFProcess.getName()}" flowable:expression="${r'${wfCoreService.execute(execution, activedata)}'}" >
         <#if WFProcess.getPSDataEntity()??>
         <extensionElements>
         <flowable:field name="service-entity"><flowable:string>${WFProcess.getPSDataEntity().getName()?lower_case}</flowable:string></flowable:field>
         <flowable:field name="service-deaction"><flowable:string>${WFProcess.getPSDEAction().getCodeName()?lower_case}</flowable:string></flowable:field>
         <#if WFProcess.getPSWFProcessParams()??>
         <#list WFProcess.getPSWFProcessParams() as processparams>
         <#if processparams.getDstField()?? && processparams.getDstField()!="">
            <#if processparams.getSrcValueType()?? && processparams.getSrcValueType()!="" >
                <#if processparams.getSrcValueType()=="CURTIME">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${wfCoreService.getnow()}'}]]></flowable:expression></flowable:field>
                <#elseif processparams.getSrcValueType()=="OPERATOR">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${curuser.userid}'}]]></flowable:expression></flowable:field>
                <#elseif processparams.getSrcValueType()=="OPERATORNAME">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${curuser.personname}'}]]></flowable:expression></flowable:field>
                <#elseif processparams.getSrcValueType()=="CONTEXT">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${activedata.'}${(processparams.getSrcValue()?lower_case)}${r'}'}]]></flowable:expression></flowable:field>
                <#elseif processparams.getSrcValueType()=="SESSION">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:expression><![CDATA[${r'${curuser.sessionParams.'}${processparams.getSrcValue()?lower_case}${r'}'}]]></flowable:expression></flowable:field>
                </#if>
            <#else>
        <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:string>${processparams.getSrcValue()}</flowable:string></flowable:field>
            </#if>
         </#if>
         </#list>
         </#if>
         </extensionElements>
         </#if>
         <#comment>空处理</#comment>
         <#if !(WFProcess.getPSDataEntity()??)>
         <extensionElements>
         <#if WFProcess.getPSWFProcessParams()??>
            <#list WFProcess.getPSWFProcessParams() as processparams>
                <#if processparams.getSrcValue()?? && processparams.getDstField()?? && processparams.getDstField()!="">
         <flowable:field name="params-${(processparams.getDstField()?lower_case)}"><flowable:string>${processparams.getSrcValue()}</flowable:string></flowable:field>
                </#if>
            </#list>
         </#if>
         </extensionElements>
         </#if>
     </serviceTask>
                    <#else>
                        <#assign assignCondSub="">
                        <#assign isSequentialSub="">
                        <#if WFProcess.getMultiInstMode?? && WFProcess.getMultiInstMode()?? && ( WFProcess.getMultiInstMode()=='PARALLEL' || WFProcess.getMultiInstMode()=='SEQUENTIAL')>
                            <#assign assignCondSub="flowable:assignee=\""+"$"+"{assignee}\"">
                            <#if WFProcess.getMultiInstMode()=='SEQUENTIAL'>
                                <#assign isSequentialSub="isSequentialSub=\"true\"">
                            <#else>
                                <#assign isSequentialSub="isSequentialSub=\"false\"">
                            </#if>
                        </#if>
                        <#assign assignCondSub="">
                        <#assign assignUtCondSub="">
                        <#assign assignSendCopyCondSub="">
                        <#assign assignGroupCondSub="">
                        <#assign assignUtGroupCondSub="">
                        <#if WFProcess.getPSWFProcessRoles?? && WFProcess.getPSWFProcessRoles()??>
                            <#list WFProcess.getPSWFProcessRoles() as processRole>
                                <#assign processRoleTypeSub=processRole.getWFProcessRoleType()>
                                <#assign roleIdSub="">
                                <#if processRoleTypeSub=='WFROLE'>
                                   <#if processRole.getPSWFRole()?? && processRole.getPSWFRole().getCodeName()??>
                                       <#if assignGroupCondSub!="">
                                           <#assign assignGroupCondSub=assignGroupCondSub+",">
                                           <#assign assignUtGroupCondSub=assignUtGroupCondSub+",">
                                       </#if>
                                       <#assign assignGroupCondSub=assignGroupCondSub+processRole.getPSWFRole().getCodeName()>
                                       <#if processRole.getUserData()?? && processRole.getUserData2()?? && processRole.getUserData()!="" && processRole.getUserData()!="">
                                       <#assign assignGroupCondSub=assignGroupCondSub+"|"+processRole.getUserData()+"|"+processRole.getUserData2()>
                                       </#if>
                                   </#if>
                                <#elseif processRoleTypeSub == 'CURACTOR'>
                                        <#assign assignCondSub=assignCondSub+"$"+"{activedata."+("CREATEMAN"?lower_case)+"}">
                                <#else>
                                   <#if processRole.getUDField()?? && processRole.getUDField()!="">
                                       <#if assignCondSub!="">
                                           <#assign assignCondSub=assignCondSub+",">
                                           <#assign assignUtCondSub=assignUtCondSub+",">
                                       </#if>
                                       <#if processRole.getUDField()?contains(";")>
                                           <#assign usersSub=''>
                                           <#assign multiUsersSub=''>
                                           <#list processRole.getUDField()?split(";") as userType>
                                              <#assign usersSub = usersSub + "$"+"{activedata."+(userType?lower_case)+"}">
                                               <#assign multiUsersSub = multiUsersSub + "#activedata."+(userType?lower_case)>
                                               <#if userType_has_next>
                                                   <#assign usersSub = usersSub+",">
                                                   <#assign multiUsersSub = multiUsersSub+"|">
                                               </#if>
                                           </#list>
                                            <#assign assignCondSub=assignCondSub + usersSub>
                                            <#assign assignUtCondSub=assignUtCondSub + multiUsersSub>
                                       <#else>
                                           <#assign assignCondSub=assignCondSub+"$"+"{activedata."+(processRole.getUDField()?lower_case)+"}">
                                           <#assign assignUtCondSub=assignUtCondSub+"#activedata."+(processRole.getUDField()?lower_case)>
                                       </#if>
                                   </#if>
                                </#if>
                            </#list>
                         </#if>
                         <#if assignGroupCondSub!="">
                         <#if assignCondSub!="">
                                           <#assign assignCondSub=assignCondSub+",">
                                           <#assign assignUtCondSub=assignUtCondSub+"||">
                         </#if>
                         <#assign assignCondSub=assignCondSub+"$"+"{wfCoreService.getGroupUsers('"+assignGroupCondSub+"',execution)}">
                         <#assign assignUtCondSub=assignUtCondSub+"#"+"wfCoreService.getGroupUsers2('"+assignGroupCondSub+"',#execution)">
                         </#if>
                        <#comment>工作流预置属性（用于流程跳转）</#comment>
                        <#if assignCondSub!="">
                            <#assign assignCondSub=assignCondSub+",">
                        </#if>
                        <#if assignUtCondSub!="">
                            <#assign assignUtCondSub=assignUtCondSub+"||">
                        </#if>
                        <#assign assignCondSub=assignCondSub+"$"+"{activedata.srfwfpredefinedusers}">
                        <#assign assignUtCondSub=assignUtCondSub+"#activedata.srfwfpredefinedusers">
                        <#assign isMultiInstanceSub =false>
                            <#if WFProcess.getMultiInstMode?? && WFProcess.getMultiInstMode()?? && ( WFProcess.getMultiInstMode()=='PARALLEL' || WFProcess.getMultiInstMode()=='SEQUENTIAL')>
                                <#assign isMultiInstanceSub=true>
                            </#if>
                        <#assign isTimeOutSub =false>
                            <#if WFProcess.isEnableTimeout()>
                                <#assign isTimeOutSub=true>
                                <#assign timeoutTypeSub = WFProcess.getTimeoutType()>
                                <#assign timeoutSub = WFProcess.getTimeout()>
                                <#assign timeUnitSub = "">
                                <#assign timeTypeSub = "">
                                <#if timeoutSubTypeSub == 'MINUTE'>
                                    <#assign timeUnitSub = 'M'>
                                    <#assign timeTypeSub = "PT">
                                <#elseif  timeoutSubTypeSub == 'HOUR'>
                                    <#assign timeUnitSub = 'H'>
                                    <#assign timeTypeSub = "PT">
                                <#elseif  timeoutSubTypeSub == 'DAY'>
                                    <#assign timeUnitSub = 'D'>
                                    <#assign timeTypeSub = "P">
                                </#if>
                            </#if>
                        <#assign formParamSub="">
                        <#assign dueDateSub="">
                        <#assign procfuncSub="">
                        <#if WFProcess.getPredefinedActions?? && WFProcess.getPredefinedActions()??>
                            <#list WFProcess.getPredefinedActions() as preaction>
                                <#assign procfuncSub=procfuncSub+preaction?lower_case>
                                <#if preaction_has_next>
                                    <#assign procfuncSub=procfuncSub+";">
                                </#if>
                            </#list>
                        </#if>
                        <#comment>流程辅助功能</#comment>
                        <#if procfuncSub!=''>
                            <#assign formParamSub=formParamSub+ "procfuncSub=\""+procfuncSub+"\" ">
                        </#if>
                        <#comment>超时策略</#comment>
                        <#assign isTimeoutLinkSub = false>
                        <#if isTimeOutSub>
                            <#if WFProcess.getPSWFLinks?? && WFProcess.getPSWFLinks()??>
                            <#list WFProcess.getPSWFLinks() as WFLink>
                                <#if WFLink.getWFLinkType() == 'TIMEOUT'>
                                    <#assign isTimeoutLinkSub = true>
                                </#if>
                            </#list>
                            <#if !isTimeoutLinkSub>
                                <#assign timeoutSubStrategySub =  timeTypeSub + timeoutSub + timeUnitSub>
                                <#assign dueDateSub = "flowable:dueDateSub=\""+timeoutSubStrategySub+"\" ">
                            </#if>
                        </#if>
                        </#if>
                        <#comment>流程表单配置</#comment>
                        <#if ((WFProcess.getFormCodeName())!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-form=\""+WFProcess.getFormCodeName()+"\" " >
                        </#if>
                        <#comment>流程表单配置(移动端)</#comment>
                        <#if ((WFProcess.getMobFormCodeName())!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-mobform=\""+WFProcess.getMobFormCodeName()+"\" ">
                        </#if>
                        <#comment>流程辅助功能表单配置(pc)</#comment>
                        <#if ((WFProcess.utilFormCodeName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-utilform=\""+WFProcess.utilFormCodeName+"\" ">
                        </#if>
                        <#if ((WFProcess.util2FormCodeName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-util2form=\""+WFProcess.util2FormCodeName+"\" " >
                        </#if>
                        <#if ((WFProcess.util3FormCodeName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-util3form=\""+WFProcess.util3FormCodeName+"\" ">
                        </#if>
                        <#comment>流程辅助功能表单名称</#comment>
                        <#if ((WFProcess.utilFormName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-utilformname=\""+WFProcess.utilFormName+"\" ">
                        </#if>
                        <#if ((WFProcess.util2FormName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-util2formname=\""+WFProcess.util2FormName+"\" ">
                        </#if>
                        <#if ((WFProcess.util3FormName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-util3formname=\""+WFProcess.util3FormName+"\" ">
                        </#if>
                        <#comment>流程辅助功能表单配置(移动端)</#comment>
                        <#if ((WFProcess.mobUtilFormCodeName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-mobutilform=\""+WFProcess.mobUtilFormCodeName+"\" ">
                        </#if>
                        <#if ((WFProcess.mobUtil2FormCodeName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-mobutil2form=\""+WFProcess.mobUtil2FormCodeName+"\" ">
                        </#if>
                        <#if ((WFProcess.mobUtil3FormCodeName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-mobutil3form=\""+WFProcess.mobUtil3FormCodeName+"\" ">
                        </#if>
                        <#comment>流程辅助功能表单名称</#comment>
                        <#if ((WFProcess.mobUtilFormName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-mobutilformname=\""+WFProcess.mobUtilFormName+"\" ">
                        </#if>
                        <#if ((WFProcess.mobUtil2FormName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-mobutil2formname=\""+WFProcess.mobUtil2FormName+"\" ">
                        </#if>
                        <#if ((WFProcess.mobUtil3FormName)!'')!=''>
                            <#assign formParamSub=formParamSub+ "process-mobutil3formname=\""+WFProcess.mobUtil3FormName+"\" ">
                        </#if>
                        <#comment>工作流多实例</#comment>
                        <#if isMultiInstanceSub && assignUtCondSub!=''>
                            <#assign formParamSub=formParamSub+ "candidateUsersList=\""+assignUtCondSub+"\" ">
                        </#if>
                        <#comment>工作流消息</#comment>
                        <#if (WFProcess.isSendInform?? && WFProcess.isSendInform()??) && (WFProcess.getassMsgTempl?? && WFProcess.getPSSysMsgTempl()??) && (WFProcess.getMsgType?? && WFProcess.getMsgType()??)>
                            <#assign formParamSub=formParamSub+ "msg-template=\""+WFProcess.getPSSysMsgTempl().getCodeName()?lower_case+"\" , msg-type=\""+WFProcess.getMsgType()+"\"" >
                        </#if>
                        <#comment>自定义参数</#comment>
                        <#if ((WFProcess.getUserData())!'')!='' || ((WFProcess.getUserData2())!'')!=''>
                            <#assign usertagSub = "">
                            <#if ((WFProcess.getUserData())!'')!=''>
                                <#assign usertagSub=WFProcess.getUserData()>
                            </#if>
                            <#if ((WFProcess.getUserData2())!'')!=''>
                                <#assign usertagSub = usertagSub+"|">
                                <#assign usertagSub=usertagSub+WFProcess.getUserData2()>
                            </#if>
                            <#assign formParamSub=formParamSub+ "usertagSub=\""+usertagSub+"\" " >
                        </#if>
                        <#comment>是否支持编辑</#comment>
                        <#if ((WFProcess.isEditable())!false)!=false>
                            <#assign formParamSub=formParamSub+ "isEditable=\""+WFProcess.isEditable()?c+"\" " >
                        </#if>
                        <#comment>编辑模式</#comment>
                        <#if ((WFProcess.isEditable())!false)!=false>
                            <#assign formParamSub=formParamSub+ "editMode=\""+WFProcess.getEditMode()+"\" " >
                        </#if>
                        <#comment>编辑属性</#comment>
                        <#if WFProcess.getEditFields?? && WFProcess.getEditFields()??>
                            <#assign editfieldsSub ="">
                            <#list WFProcess.getEditFields() as editfield>
                                <#assign editfieldsSub=editfieldsSub+ editfield>
                                <#if editfield_has_next>
                                    <#assign editfieldsSub=editfieldsSub+";" >
                                </#if>
                            </#list>
                            <#if editfieldsSub!="">
                                <#assign formParamSub=formParamSub+ "editFields=\""+editfieldsSub?lower_case+"\" " >
                            </#if>
                        </#if>
                        <#comment>处理意见属性</#comment>
                        <#if WFProcess.getMemoField?? && WFProcess.getMemoField()?? && ((WFProcess.getMemoField())!'')!=''>
                            <#assign formParamSub=formParamSub+ "memofield=\""+WFProcess.getMemoField()+"\" " >
                        </#if>
     <userTask flowable:category="${r'${businessKey}'}"  <#if dueDateSub != "">${dueDateSub}</#if> flowable:candidateUsers="<#if isMultiInstanceSub>${r'${candidateUsers}'}<#else>${assignCondSub}</#if>" flowable:exclusive="true" id="sub-tid-${WFProcess.getWFStepValue()}-${WFProcess.getDeployId()}" name="${WFProcess.getName()}" <#if WFProcess.getWFProcessType()?? && (WFProcess.getWFProcessType()=="CALLORGACTIVITY" || WFProcess.getWFProcessType()=="EMBED")>flowable:formKey="${WFProcess.getWFProcessType()}"</#if>><#comment>标记子流程节点</#comment>
         <documentation>${r'${majortext}'}</documentation>
         <#if formParamSub !=''>
         <extensionElements>
         <flowable:form ${formParamSub} />
         </extensionElements>
         </#if>
        <#comment>多实例节点</#comment>
        <#if isMultiInstanceSub>
         <multiInstanceLoopCharacteristics flowable:collection="candidateUsersList" flowable:elementVariable="candidateUsers" ${isSequentialSub}>
             <completionCondition><![CDATA[${r'${wfCoreService.accessCondition(execution)}'}]]></completionCondition>
         </multiInstanceLoopCharacteristics>
        </#if>
     </userTask>
        <#if isTimeoutLinkSub>
     <boundaryEvent id="sub-bid-${WFProcess.getWFStepValue()}-${WFProcess.getDeployId()}" name="timeoutSub-${WFProcess.getName()}" attachedToRef="sub-tid-${WFProcess.getWFStepValue()}-${WFProcess.getDeployId()}" cancelActivity="true">
        <timerEventDefinition>
            <timeDate>${timeTypeSub}${timeoutSub}${timeUnitSub}</timeDate>
        </timerEventDefinition>
     </boundaryEvent>
        </#if>
                    </#if>
                </#list>
            </#if>
          <#comment>绘制节点连线</#comment>
          <#if EMBEDWFVersion.getPSWFLinks?? && EMBEDWFVersion.getPSWFLinks()??>
              <#list EMBEDWFVersion.getPSWFLinks() as WFLink>
                  <#assign sourceProcessIdSub="">
                  <#assign targetProcessIdSub="">
                  <#assign sourceProcessSub=WFLink.getFromPSWFProcess()>
                  <#assign targetProcessSub=WFLink.getToPSWFProcess()>
                  <#assign sourceProcessIdSub="sub-sid-"+sourceProcessSub.getDeployId()>
                  <#if sourceProcessSub.getWFProcessType()=='INTERACTIVE'>
                    <#assign sourceProcessIdSub="sub-tid-"+sourceProcessSub.getWFStepValue()+"-"+sourceProcessSub.getDeployId()>
                  </#if>
                  <#assign targetProcessIdSub="sub-sid-"+targetProcessSub.getDeployId()>
                  <#if targetProcessSub.getWFProcessType()=='INTERACTIVE'>
                    <#assign targetProcessIdSub="sub-tid-"+targetProcessSub.getWFStepValue()+"-"+targetProcessSub.getDeployId()>
                  </#if>
                  <#if WFLink.getWFLinkType() == 'TIMEOUT'>
                      <#assign sourceProcessIdSub="sub-bid-"+sourceProcessSub.getWFStepValue()+"-"+sourceProcessSub.getDeployId()>
                  </#if>
                  <#assign sourceProcessCodeNameSub=WFLink.getFromPSWFProcess().getCodeName()>
                  <#assign flowIdSub="sub-rid-"+WFLink.getDeployId()>
                  <#if WFLink.getWFLinkType()!='ROUTE'>
                    <#assign flowIdSub="sub-lid-"+WFLink.getName()+"-"+WFLink.getDeployId()>
                  </#if>
                  <#assign flowTagSub=WFLink.getName()>
                <#comment>链接参数</#comment>
                <#assign linkParamSub="">
                  <#if ((WFLink.getFormCodeName())!'')!=''>
                      <#assign linkParamSub=linkParamSub+ "sequenceFlowForm=\""+WFLink.getFormCodeName()+"\" " >
                  </#if>
                  <#if ((WFLink.getMobFormCodeName())!'')!=''>
                      <#assign linkParamSub=linkParamSub+ "sequenceFlowMobForm=\""+WFLink.getMobFormCodeName()+"\" " >
                  </#if>
                  <#if ((WFLink.getViewCodeName())!'')!=''>
                      <#assign linkParamSub=linkParamSub+ "sequenceFlowView=\""+WFLink.getViewCodeName()+"\" " >
                  </#if>
                  <#if ((WFLink.getMobViewCodeName())!'')!=''>
                      <#assign linkParamSub=linkParamSub+ "sequenceFlowMobView=\""+WFLink.getMobViewCodeName()+"\" " >
                  </#if>
                  <#if ((WFLink.getNextCondition())!'')!=''>
                      <#assign linkParamSub=linkParamSub+ "nextCondition=\""+WFLink.getNextCondition()+"\" " >
                  </#if>
                  <#if ((WFLink.getCustomCond())!'')!=''>
                      <#assign linkParamSub=linkParamSub+ "customCond=\""+WFLink.getCustomCond()+"\" " >
                  </#if>
                  <#if ((WFLink.getUserData())!'')!=''>
                      <#assign linkParamSub=linkParamSub+ "userdata=\""+WFLink.getUserData()+"\" " >
                  </#if>
                  <#if ((WFLink.getUserData2())!'')!=''>
                      <#assign linkParamSub=linkParamSub+ "userdata2=\""+WFLink.getUserData2()+"\" " >
                  </#if>
      <sequenceFlow id="${flowIdSub}" sourceRef="${sourceProcessIdSub}" targetRef="${targetProcessIdSub}" name="${WFLink.getLogicName()}">
       <#if WFLink.getWFLinkType() != 'TIMEOUT'><#comment>超时链接不带内容</#comment>
        <#if sourceProcessCodeNameSub!="Start001"><#comment>连接线含有条件</#comment>
            <#assign LinkCondSub="">
            <#assign strGroupCondSub="">
            <#if WFLink.getWFLinkType()=='ROUTE'>
                <#if WFLink.getCustomCond?? && WFLink.getCustomCond()??>
                    <#assign LinkCondSub=WFLink.getCustomCond()>
                <#elseif WFLink.getPSWFLinkGroupCond?? && WFLink.getPSWFLinkGroupCond()??>
                    <#assign WFLinkCondSub=WFLink.getPSWFLinkGroupCond()>
                    <#assign strGroupCondSub=getGroupCond(WFLinkCondSub)>
                    <#assign strGroupCondSub="$\{"+strGroupCondSub+"} ">
                    <#assign LinkCondSub="<![CDATA["+strGroupCondSub+"]]>">
                </#if>
            <#else>
                <#assign LinkCondSub="<![CDATA[$\{sequenceFlowId==\""+flowIdSub+"\"}]]>">
            </#if>
            <#if LinkCondSub!="">
        <conditionExpression  xsi:type="tFormalExpression" >${LinkCondSub}</conditionExpression>
            </#if>
        </#if>
         <#if linkParamSub!=''>
         <extensionElements>
             <flowable:form ${linkParamSub} />
         </extensionElements>
         </#if>
        </#if>
     </sequenceFlow>
              </#list>
          </#if>
       
    </#if>
     </#list>
     </#if>
         <documentation>${r'${majortext}'}</documentation>
         <#if formParam !=''>
         <extensionElements>
         <flowable:form ${formParam} />
         </extensionElements>
         </#if>
        <#comment>多实例节点</#comment>
        <#if isMultiInstance>
         <multiInstanceLoopCharacteristics flowable:collection="candidateUsersList" flowable:elementVariable="candidateUsers" ${isSequential}>
             <completionCondition><![CDATA[${r'${wfCoreService.accessCondition(execution)}'}]]></completionCondition>
         </multiInstanceLoopCharacteristics>
        </#if>
        <#if WFProcess.getWFProcessType()?? && (WFProcess.getWFProcessType()=="EMBED")>
    </subProcess>
    <#elseif WFProcess.getWFProcessType()?? && (WFProcess.getWFProcessType()=="CALLORGACTIVITY")> 
    </callActivity>
    <#else>
    </userTask>
    </#if>
        <#if isTimeoutLink>
     <boundaryEvent id="bid-${WFProcess.getWFStepValue()}-${WFProcess.getDeployId()}" name="timeout-${WFProcess.getName()}" attachedToRef="tid-${WFProcess.getWFStepValue()}-${WFProcess.getDeployId()}" cancelActivity="true">
        <timerEventDefinition>
            <timeDate>${timeType}${timeout}${timeUnit}</timeDate>
        </timerEventDefinition>
     </boundaryEvent>
        </#if>
                    </#if>
                </#list>
            </#if>
          <#comment>绘制节点连线</#comment>
          <#if item.getPSWFLinks?? && item.getPSWFLinks()??>
              <#list item.getPSWFLinks() as WFLink>
                  <#assign sourceProcessId="">
                  <#assign targetProcessId="">
                  <#assign sourceProcess=WFLink.getFromPSWFProcess()>
                  <#assign targetProcess=WFLink.getToPSWFProcess()>
                  <#assign sourceProcessId="sid-"+sourceProcess.getDeployId()>
                  <#if sourceProcess.getWFProcessType()=='INTERACTIVE'>
                    <#assign sourceProcessId="tid-"+sourceProcess.getWFStepValue()+"-"+sourceProcess.getDeployId()>
                  </#if>
                  <#assign targetProcessId="sid-"+targetProcess.getDeployId()>
                  <#if targetProcess.getWFProcessType()=='INTERACTIVE'>
                    <#assign targetProcessId="tid-"+targetProcess.getWFStepValue()+"-"+targetProcess.getDeployId()>
                  </#if>
                  <#if WFLink.getWFLinkType() == 'TIMEOUT'>
                      <#assign sourceProcessId="bid-"+sourceProcess.getWFStepValue()+"-"+sourceProcess.getDeployId()>
                  </#if>
                  <#assign sourceProcessCodeName=WFLink.getFromPSWFProcess().getCodeName()>
                  <#assign flowId="rid-"+WFLink.getDeployId()>
                  <#if WFLink.getWFLinkType()!='ROUTE'>
                    <#assign flowId="lid-"+WFLink.getName()+"-"+WFLink.getDeployId()>
                  </#if>
                  <#assign flowTag=WFLink.getName()>
                <#comment>链接参数</#comment>
                <#assign linkParam="">
                  <#if ((WFLink.getFormCodeName())!'')!=''>
                      <#assign linkParam=linkParam+ "sequenceFlowForm=\""+WFLink.getFormCodeName()+"\" " >
                  </#if>
                  <#if ((WFLink.getMobFormCodeName())!'')!=''>
                      <#assign linkParam=linkParam+ "sequenceFlowMobForm=\""+WFLink.getMobFormCodeName()+"\" " >
                  </#if>
                  <#if ((WFLink.getViewCodeName())!'')!=''>
                      <#assign linkParam=linkParam+ "sequenceFlowView=\""+WFLink.getViewCodeName()+"\" " >
                  </#if>
                  <#if ((WFLink.getMobViewCodeName())!'')!=''>
                      <#assign linkParam=linkParam+ "sequenceFlowMobView=\""+WFLink.getMobViewCodeName()+"\" " >
                  </#if>
                  <#if ((WFLink.getNextCondition())!'')!=''>
                      <#assign linkParam=linkParam+ "nextCondition=\""+WFLink.getNextCondition()+"\" " >
                  </#if>
                  <#if ((WFLink.getCustomCond())!'')!=''>
                      <#assign linkParam=linkParam+ "customCond=\""+WFLink.getCustomCond()+"\" " >
                  </#if>
                  <#if ((WFLink.getUserData())!'')!=''>
                      <#assign linkParam=linkParam+ "userdata=\""+WFLink.getUserData()+"\" " >
                  </#if>
                  <#if ((WFLink.getUserData2())!'')!=''>
                      <#assign linkParam=linkParam+ "userdata2=\""+WFLink.getUserData2()+"\" " >
                  </#if>
      <sequenceFlow id="${flowId}" sourceRef="${sourceProcessId}" targetRef="${targetProcessId}" name="${WFLink.getLogicName()}">
       <#if WFLink.getWFLinkType() != 'TIMEOUT'><#comment>超时链接不带内容</#comment>
        <#if sourceProcessCodeName!="Start001"><#comment>连接线含有条件</#comment>
            <#assign LinkCond="">
            <#assign strGroupCond="">
            <#if WFLink.getWFLinkType()=='ROUTE'>
                <#if WFLink.getCustomCond?? && WFLink.getCustomCond()??>
                    <#assign LinkCond=WFLink.getCustomCond()>
                <#elseif WFLink.getPSWFLinkGroupCond?? && WFLink.getPSWFLinkGroupCond()??>
                    <#assign WFLinkCond=WFLink.getPSWFLinkGroupCond()>
                    <#assign strGroupCond=getGroupCond(WFLinkCond)>
                    <#assign strGroupCond="$\{"+strGroupCond+"} ">
                    <#assign LinkCond="<![CDATA["+strGroupCond+"]]>">
                </#if>
            <#else>
                <#assign LinkCond="<![CDATA[$\{sequenceFlowId==\""+flowId+"\"}]]>">
            </#if>
        <#if WFLink.getWFLinkType() == 'WFRETURN'>
            <#assign LinkCond = "">
        </#if>
            <#if LinkCond!="">
        <conditionExpression  xsi:type="tFormalExpression" >${LinkCond}</conditionExpression>
            </#if>
        </#if>
         <#if linkParam!=''>
         <extensionElements>
             <flowable:form ${linkParam} />
         </extensionElements>
         </#if>
        </#if>
     </sequenceFlow>
              </#list>
          </#if>
    </process>
    <#comment>下面定义图形位置</#comment>
    <bpmndi:BPMNDiagram id="BPMNDiagram_${sys.getCodeName()?lower_case}-${item.codeName?lower_case}">
        <bpmndi:BPMNPlane id="BPMNPlane_${sys.getCodeName()?lower_case}-${item.codeName?lower_case}" bpmnElement="${sys.getCodeName()?lower_case}-${item.codeName?lower_case}">
           <#comment>绘制处理节点</#comment>
            <#if item.getPSWFProcesses?? && item.getPSWFProcesses()??>
                <#list item.getPSWFProcesses() as WFProcess>
                 <#assign sourceProcessId="sid-"+WFProcess.getDeployId()>
                  <#if WFProcess.getWFProcessType()=='INTERACTIVE'>
                    <#assign sourceProcessId="tid-"+WFProcess.getWFStepValue()+"-"+WFProcess.getDeployId()>
                  </#if>
                 <bpmndi:BPMNShape id="BPMNShape-${WFProcess.getDeployId()}" bpmnElement="${sourceProcessId}">
                     <omgdi:Bounds x="${WFProcess.getLeftPos()?c}" y="${WFProcess.getTopPos()?c}" width="${WFProcess.getWidth()?c}" height="${WFProcess.getHeight()?c}" />
                 </bpmndi:BPMNShape>
                </#list>
            </#if>
          <#comment>绘制节点连线</#comment>
          <#if item.getPSWFLinks?? && item.getPSWFLinks()??>
              <#list item.getPSWFLinks() as WFLink>
                  <#assign flowId="rid-"+WFLink.getDeployId()>
                  <#if WFLink.getWFLinkType()!='ROUTE'>
                    <#assign flowId="lid-"+WFLink.getName()+"-"+WFLink.getDeployId()>
                  </#if>
               <bpmndi:BPMNEdge id="BPMNEdge-${flowId}" bpmnElement="${flowId}">
                   <omgdi:waypoint x="0" y="0" />
                   <omgdi:waypoint x="0" y="0" />
               </bpmndi:BPMNEdge>
              </#list>
          </#if>
        </bpmndi:BPMNPlane>
    </bpmndi:BPMNDiagram>
</definitions>
</#if>

<#comment>获取组合条件表达式</#comment>
<#function getGroupCond WFLinkCond>
    <#assign strRuleCond="(">
    <#if WFLinkCond.getPSWFLinkConds()?? && WFLinkCond.getPSWFLinkConds()??><#comment>判断是否有组条件</#comment>
        <#assign conn=WFLinkCond.getGroupOP()?replace("AND","&&")?replace("OR","||")>
        <#list WFLinkCond.getPSWFLinkConds() as childWFLinkCond><#comment>组条件，递归</#comment>
            <#assign childLinkType = childWFLinkCond.getCondType()>
            <#if (childWFLinkCond.getPSWFLinkConds?? && childWFLinkCond.getPSWFLinkConds()?? ) || childLinkType=='GROUP'>
                <#assign strRuleCond=strRuleCond+getGroupCond(childWFLinkCond)>//getGroupCond
            <#else>
                <#assign strRuleCond=strRuleCond+getFieldCond(childWFLinkCond)>//getFieldCond
            </#if>
            <#if childWFLinkCond_has_next>
                <#assign strRuleCond=strRuleCond+conn>//拼接连接符
            </#if>
        </#list>
    <#else>

    </#if>
    <#assign strRuleCond=strRuleCond+")">
    <#return strRuleCond/>
</#function>

<#comment>获取单项条件表达式</#comment>
<#function getFieldCond WFLinkCond>
    <#assign fieldCond="(" >
    <#assign condBody="">
    <#assign paramType=((WFLinkCond.getParamType())!'')><#comment>参数类型</#comment>
    <#assign targetField=WFLinkCond.getFieldName()><#comment>目标属性</#comment>
    <#assign targetDBValueOP=WFLinkCond.getCondOP()><#comment>表达式</#comment>
    <#assign targetValue=WFLinkCond.getParamValue()><#comment>值项</#comment>
    <#if targetField??>
            <#assign targetField=targetField?lower_case>
            <#--<#assign strTargetDBValueOP=targetDBValueOP?replace("ISNOTNULL","!= null")?replace("ISNULL","== null")?replace("AND","&&")?replace("OR","||")?replace("GT&&EQ",">=")?replace("LT&&EQ","<=")?replace("NOTEQ","!=")?replace("EQ","==")?replace("GT",">")?replace("LT","<") >-->
            <#if targetDBValueOP=="ISNULL" || targetDBValueOP=="ISNOTNULL">
                <#assign condBody="wfCoreService.test(activedata."+targetField+", '"+targetDBValueOP+"', null)" >
            <#elseif paramType??&&paramType=='ENTITYFIELD'>
                <#if targetValue??&&targetValue!="">
                <#assign condBody="wfCoreService.test(activedata."+targetField+", '"+targetDBValueOP+"', activedata."+targetValue?lower_case+")" >
                <#else>
                <#assign condBody="wfCoreService.test(activedata."+targetField+", '"+targetDBValueOP+"', null)" >
                </#if>
            <#elseif paramType??&&paramType=='CURTIME'>
                <#assign condBody="wfCoreService.test(activedata."+targetField+", '"+targetDBValueOP+"', wfCoreService.getnow())" >
            <#else>
                <#if targetValue??&&targetValue!="">
                <#assign condBody="wfCoreService.test(activedata."+targetField+", '"+targetDBValueOP+"', '"+targetValue?replace("\"","")?replace("‘","")?replace("“","")?replace("”","")+"')" >
                <#else>
                <#assign condBody="wfCoreService.test(activedata."+targetField+", '"+targetDBValueOP+"', null)" >
                </#if>
            </#if>
    </#if>
    <#assign fieldCond=fieldCond+condBody >
    <#assign fieldCond=fieldCond+")" >
    <#return fieldCond/>
</#function>
