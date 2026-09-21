<#if item.isEnableBackend()>
    <#assign de=item.getPSDataEntity()>
    package ${pub.getPKGCodeName()}.${de.getPSSystemModule().codeName?lower_case}.logic.${de.codeName?lower_case}logic.${item.getCodeName()?lower_case};
    <#comment>是否包含启动工作流节点</#comment>
    <#assign startWF=false>
    <#if item.getPSDELogicNodes?? && item.getPSDELogicNodes()??>
        <#list item.getPSDELogicNodes() as deLogicNode>
            <#if deLogicNode.getLogicNodeType()=='STARTWF'>
                <#assign startWF=true>
                <#break>
            </#if>
        </#list>
    </#if>
    <#assign logicName=(de.codeName+item.codeName)?lower_case>
    <#assign delogic=item>
    <#assign defaultLogicParam="">
    <#comment>插入逻辑参数</#comment>
    <#if delogic.getPSDELogicParams?? && delogic.getPSDELogicParams()??>
        import java.util.Map;
        import java.util.HashMap;
        import com.alibaba.fastjson.JSONObject;
        import org.springframework.util.StringUtils;
        import org.springframework.util.ObjectUtils;
        import ${pub.getPKGCodeName()}.util.errors.BadRequestAlertException;
        <#list delogic.getPSDELogicParams() as logicParam>
            <#if logicParam.isDefault()==true>
                <#assign defaultLogicParam=logicParam><#comment>获取处理逻辑中默认逻辑参数</#comment>
            </#if>
            <#if logicParam.getParamPSDataEntity?? && logicParam.getParamPSDataEntity()??>
                <#assign ParamPSDataEntity=logicParam.getParamPSDataEntity()>
                global ${pub.getPKGCodeName()}.core.${ParamPSDataEntity.getPSSystemModule().codeName?lower_case}.domain.${ParamPSDataEntity.codeName} ${logicName+logicParam.codeName?lower_case};
            <#else>
                global java.util.Map ${logicName+logicParam.codeName?lower_case};
            </#if>
        </#list>
    </#if>
    <#comment>插入wfclient</#comment>
    <#if startWF>
        global ${pub.getPKGCodeName()}.util.client.IBZWFFeignClient wfClient;
    </#if>
    <#comment>插入处理逻辑中所用到的service对象</#comment>
    <#if delogic.getPSDELogicNodes?? && delogic.getPSDELogicNodes()??>
        <#list delogic.getPSDELogicNodes() as deLogicNode>
            <#if deLogicNode.getDstPSDataEntity?? && deLogicNode.getDstPSDataEntity()??>
                <#if !P.exists("kieSession",deLogicNode.getDstPSDataEntity().getCodeName()?lower_case,"service")>
                    <#assign DstPSDataEntity=deLogicNode.getDstPSDataEntity()>
                    global ${pub.getPKGCodeName()}.core.${DstPSDataEntity.getPSSystemModule().codeName?lower_case}.service.I${DstPSDataEntity.codeName}Service ${deLogicNode.getDstPSDataEntity().getCodeName()?lower_case}service;
                </#if>
            </#if>
        </#list>
        <#comment>插入当前实体的defaultService对象，供自定义查询使用</#comment>
        global ${pub.getPKGCodeName()}.core.${de.getPSSystemModule().codeName?lower_case}.service.I${de.codeName}Service iBzSys${de.codeName?lower_case?cap_first}DefaultService;
        global ${pub.getPKGCodeName()}.util.security.AuthenticationUser curuser;
    </#if>


    no-loop
    <#if delogic.getPSDELogicNodes?? && delogic.getPSDELogicNodes()??>
        <#list delogic.getPSDELogicNodes() as deLogicNode>

            //逻辑处理节点[${deLogicNode.getName()?lower_case}]
            rule "${deLogicNode.getCodeName()?lower_case}"
            ruleflow-group "${logicName+deLogicNode.getCodeName()?lower_case}"
            when
            then
            <#if deLogicNode.codeName !='Begin'><#comment>开始节点不输出内容</#comment>
                <#if deLogicNode.getLogicNodeType()=='PREPAREPARAM' && deLogicNode.getPSDELogicNodeParams()??><#comment>准备参数</#comment>
                    <#list deLogicNode.getPSDELogicNodeParams() as nodeParam>
                        <#assign targetLogicParam=nodeParam.getDstPSDELogicParam()>
                        <#assign targetLogicFieldName=nodeParam.getDstFieldName()>
                        <#if targetLogicParam.getParamPSDataEntity()?? && targetLogicParam.getParamPSDataEntity().getPSDEField(targetLogicFieldName,true)??>
                            <#assign targetLogicFieldName=srfcaseformat(targetLogicParam.getParamPSDataEntity().getPSDEField(targetLogicFieldName,true).getCodeName(),'l_u2lC')>
                        </#if>
                        <#if nodeParam.getSrcValueType()=='SRCVALUE'><#comment>直接值</#comment>
                            ${logicName+targetLogicParam.getCodeName()?lower_case}.set("${targetLogicFieldName?lower_case}","${nodeParam.getSrcValue()}");
                        <#elseif nodeParam.getSrcValueType()=='SRCDLPARAM' ><#comment>源逻辑参数</#comment>
                            <#assign  srcPSDELogicParam=nodeParam.getSrcPSDELogicParam()>
                            <#assign  srcFieldName=nodeParam.getSrcFieldName()>
                            <#if srcPSDELogicParam.getParamPSDataEntity()?? && srcPSDELogicParam.getParamPSDataEntity().getPSDEField(srcFieldName,true)??>
                                <#assign srcFieldName=srfcaseformat(srcPSDELogicParam.getParamPSDataEntity().getPSDEField(srcFieldName,true).getCodeName(),'l_u2lC')>
                            </#if>
                            ${logicName+targetLogicParam.getCodeName()?lower_case}.set("${targetLogicFieldName?lower_case}",${logicName+srcPSDELogicParam.getCodeName()?lower_case}.get("${srcFieldName?lower_case}"));<#comment>源逻辑参数选择了实体</#comment>
                        <#else>
                            <#assign  srcFieldName=nodeParam.getSrcFieldName()>
                            <#if nodeParam.getSrcValueType()=="CURTIME">
                                ${logicName+targetLogicParam.getCodeName()?lower_case}.set("${targetLogicFieldName?lower_case}",(new java.sql.Timestamp(new java.util.Date().getTime()))));
                            <#elseif nodeParam.getSrcValueType()=="OPERATOR">
                                ${logicName+targetLogicParam.getCodeName()?lower_case}.set("${targetLogicFieldName?lower_case}",curuser.getUserid());
                            <#elseif nodeParam.getSrcValueType()=="OPERATORNAME">
                                ${logicName+targetLogicParam.getCodeName()?lower_case}.set("${targetLogicFieldName?lower_case}",curuser.getPersonname());
                            <#elseif nodeParam.getSrcValueType()=="CONTEXT">
                                ${logicName+targetLogicParam.getCodeName()?lower_case}.set("${targetLogicFieldName?lower_case}",${logicName+"default"}.get("${srcFieldName?lower_case}"));<#comment>源逻辑参数选择了实体</#comment>
                            <#elseif nodeParam.getSrcValueType()=="SESSION">
                                ${logicName+targetLogicParam.getCodeName()?lower_case}.set("${targetLogicFieldName?lower_case}",curuser.getSessionParams().get("${srcFieldName?lower_case}"));
                            <#elseif nodeParam.getSrcValueType()=="NULLVALUE">
                                ${logicName+targetLogicParam.getCodeName()?lower_case}.set("${targetLogicFieldName?lower_case}",null);
                            </#if>
                        </#if>
                    </#list>
                <#elseif deLogicNode.getLogicNodeType()=='DEACTION'><#comment>调用实体行为</#comment>
                    <#assign  operateEntity=deLogicNode.getDstPSDataEntity()><#comment>操作实体</#comment>
                    <#assign  operateAction=deLogicNode.getDstPSDEAction()><#comment>操作行为</#comment>
                    <#assign  operateParam=deLogicNode.getDstPSDELogicParam()><#comment>操作参数</#comment>
                    <#assign  logicParamEntity=logicName+operateParam.codeName?lower_case>
                    <#if deLogicNode.getDstPSDEAction().codeName?lower_case=='get'>
                        <#if operateEntity.getKeyPSDEField()??>
                            <#assign operateEntityKeyField=srfcaseformat(operateEntity.getKeyPSDEField().getCodeName(),'l_u2lC')?cap_first>
                            ${pub.getPKGCodeName()}.util.helper.CachedBeanCopier.copy(${operateEntity.codeName?lower_case}service.get(${logicParamEntity}.get${operateEntityKeyField}()),${logicParamEntity});
                        <#else>
                            //操作实体没有主键属性，未能正常发布出get行为
                        </#if>
                    <#elseif deLogicNode.getDstPSDEAction().codeName?lower_case=='remove'>
                        <#assign operateEntityKeyField=srfcaseformat(operateEntity.getKeyPSDEField().getCodeName(),'l_u2lC')?cap_first>
                        ${operateEntity.codeName?lower_case}service.remove(${logicParamEntity}.get${operateEntityKeyField}());
                    <#else>
                        ${operateEntity.codeName?lower_case}service.${operateAction.codeName?uncap_first}(${logicParamEntity});
                    </#if>
                <#elseif deLogicNode.getLogicNodeType()=='RAWSQLCALL'><#comment>直接SQL</#comment>
                    <#if deLogicNode.getPSDELogicNodeParams()??>
                        <#comment>包含参数列表</#comment>
                        <@getCallSQL2 deLogicNode/>
                    <#else>
                        Map param = null;
                        String strSql="${srfjavasqlcode('${deLogicNode.getParam("PARAM4","")}')}";
                    </#if>
                    <#if (deLogicNode.getParam("PARAM9",0)==1)>
                        java.util.List<JSONObject> entities=iBzSys${de.codeName?lower_case?cap_first}DefaultService.select(strSql,param);//SQL调用
                        <#comment>是否返回参数</#comment>
                        <#if  deLogicNode.getDstPSDELogicParam?? && deLogicNode.getDstPSDELogicParam()?? ><#comment>配置返回参数</#comment>
                            if(entities.size()>0){
                            <#assign targetLogicParam=deLogicNode.getDstPSDELogicParam()>
                            JSONObject entity=entities.get(0);
                            <#assign targetLogicParamCodeName=logicName+targetLogicParam.getCodeName()?lower_case>
                            <#if targetLogicParam.getParamPSDataEntity?? && targetLogicParam.getParamPSDataEntity()??>
                                <#assign targetEntity=targetLogicParam.getParamPSDataEntity()>
                                <#if (deLogicNode.getParam("PARAM7",1)==0)><#comment>重置原数据</#comment>
                                    ${pub.getPKGCodeName()}.core.${targetEntity.getPSSystemModule().codeName?lower_case}.domain.${targetEntity.codeName} targetEntity =new ${pub.getPKGCodeName()}.core.${targetEntity.getPSSystemModule().codeName?lower_case}.domain.${targetEntity.codeName}();
                                    for (Map.Entry entry : entity.entrySet()) {
                                    targetEntity.set(String.valueOf(entry.getKey()),entry.getValue());
                                    }
                                    org.springframework.cglib.beans.BeanCopier copier= org.springframework.cglib.beans.BeanCopier.create(targetEntity.getClass(),${targetLogicParamCodeName}.getClass(), false);
                                    copier.copy(targetEntity,${targetLogicParamCodeName},null);
                                <#else><#comment>不重置原数据</#comment>
                                    for (Map.Entry entry : entity.entrySet()) {
                                    ${targetLogicParamCodeName}.set(String.valueOf(entry.getKey()),entry.getValue());
                                    }
                                </#if>
                            <#else>
                                ${targetLogicParamCodeName}.putAll(entity);
                            </#if>
                            }
                        <#else>
                            iBzSys${de.codeName?lower_case?cap_first}DefaultService.execute(strSql);//SQL调用
                        </#if>
                    <#else>
                        iBzSys${de.codeName?lower_case?cap_first}DefaultService.execute(strSql,param);//SQL调用
                    </#if>
                <#elseif  deLogicNode.getLogicNodeType()=='RAWSQLANDLOOPCALL'><#comment>直接SQL并循环调用</#comment>
                    <#if deLogicNode.getPSDELogicNodeParams()??>
                        <#comment>包含参数列表</#comment>
                        <@getCallSQL2 deLogicNode/>
                    <#else>
                        Map param = null;
                        String strSql="${srfjavasqlcode('${deLogicNode.getParam("PARAM4","")}')}";
                    </#if>
                    java.util.List<JSONObject> entities=iBzSys${de.codeName?lower_case?cap_first}DefaultService.select(strSql,param);//SQL调用
                    if(entities.size()>0){
                    <#if deLogicNode.getDstPSDataEntity?? && deLogicNode.getDstPSDataEntity()?? &&deLogicNode.getDstPSDEAction?? && deLogicNode.getDstPSDEAction()??>
                        <#assign targetEntity=deLogicNode.getDstPSDataEntity()>
                        <#assign targetAction=deLogicNode.getDstPSDEAction()>
                        for(JSONObject entity:entities){
                        ${pub.getPKGCodeName()}.core.${targetEntity.getPSSystemModule().codeName?lower_case}.domain.${targetEntity.codeName} targetEntity =new ${pub.getPKGCodeName()}.core.${targetEntity.getPSSystemModule().codeName?lower_case}.domain.${targetEntity.codeName}();
                        for (Map.Entry<String,Object> entry : entity.entrySet()) {
                        targetEntity.set(entry.getKey(),entry.getValue());
                        }
                        ${targetEntity.codeName?lower_case}service.${targetAction.codeName?lower_case}(targetEntity);
                        }
                    </#if>
                    }
                <#elseif  deLogicNode.getLogicNodeType()=='STARTWF'><#comment>启动工作流</#comment>
                    <#assign wfDE=deLogicNode.getPSDEWF().getPSDataEntity()>
                    <#assign wfDEKeyField=srfcaseformat(wfDE.getKeyPSDEField().codeName,'l_u2lC')>
                    <#assign wfParam=deLogicNode.getDstPSDELogicParam()>
                    <#assign wfLogicParam=(logicName+wfParam.codeName)?lower_case>
                    <#assign wfDECodeName=srfpluralize(wfDE.getCodeName()?lower_case)>
                    <#assign appName="">
                    <#if wfDE.hasPSAppDataEntity()??>
                        <#list wfDE.getAllPSAppDataEntities() as WFAppDE>
                            <#assign appName=((WFAppDE.getPSApplication().getPKGCodeName())!'')?lower_case>
                            <#break>
                        </#list>
                    </#if>
                    JSONObject activeData=(JSONObject) JSONObject.toJSON(${wfLogicParam});
                    Object businessKey=${wfLogicParam}.get("${wfDEKeyField}");
                    String appName="${appName}";
                    if(StringUtils.isEmpty(appName))
                    throw new BadRequestAlertException("无法获取流程应用名称，请检查[${wfDE.getLogicName()}]实体是否已经添加到应用","StartWF","");
                    if(ObjectUtils.isEmpty(businessKey))
                    throw new BadRequestAlertException("启动流程失败，逻辑参数[${wfParam.codeName?lower_case}]中未包含实体业务主键","StartWF","");
                    wfClient.wfstart("${sys.codeName}",appName,"${wfDECodeName}",String.valueOf(businessKey),activeData);
                </#if>
                <#if delogic.getPSDELogicParams?? && delogic.getPSDELogicParams()??>
                    <#list delogic.getPSDELogicParams() as logicParam>
                        update(${logicName+logicParam.codeName?lower_case});//更新fact中变量值
                    </#list>
                </#if>
            </#if>
            end
        </#list>
    </#if>
</#if>

<#macro getCallSQL2 deLogicNode >
    Map param =new HashMap();
    <#comment>准备参数列表</#comment>
    <#list deLogicNode.getPSDELogicNodeParams() as nodeParam>
        <#assign  sqlParam="null">
        <#assign  srcFieldName=nodeParam.getSrcFieldName()>
        <#assign  curLogicEntity=logicName+"default">
        <#if nodeParam.getSrcValueType()=='SRCDLPARAM'><#comment>源逻辑参数</#comment>
            <#assign  srcPSDELogicParam=nodeParam.getSrcPSDELogicParam()>
            <#if srcPSDELogicParam.getParamPSDataEntity()?? && srcPSDELogicParam.getParamPSDataEntity().getPSDEField(srcFieldName,true)??>
                <#assign srcFieldName=srfcaseformat(srcPSDELogicParam.getParamPSDataEntity().getPSDEField(srcFieldName,true).getCodeName(),'l_u2lC')>
            </#if>
            <#assign  srfLogicParamEntity=logicName+srcPSDELogicParam.getCodeName()?lower_case>
            <#assign sqlParam=srfLogicParamEntity+".get(\""+srcFieldName?lower_case+"\")">
        <#elseif nodeParam.getSrcValueType()=="WEBCONTEXT"><#comment>网页请求上下文</#comment>
            <#assign sqlParam=curLogicEntity+".get(\""+srcFieldName?lower_case+"\")">
        <#elseif nodeParam.getSrcValueType()=="APPDATA"><#comment>当前应用数据</#comment>
        <#elseif nodeParam.getSrcValueType()=="APPLICATION"><#comment>系统全局对象</#comment>
        <#elseif nodeParam.getSrcValueType()=="SESSION"><#comment>用户全局对象</#comment>
            <#assign sqlParam="curuser.getSessionParams().get(\""+srcFieldName?lower_case+"\")">
        <#elseif nodeParam.getSrcValueType()=="DATACONTEXT"><#comment>数据上下文</#comment>
            <#assign sqlParam=curLogicEntity+".get(\""+srcFieldName?lower_case+"\")">
        <#elseif nodeParam.getSrcValueType()=="ENVPARAM"><#comment>当前环境参数</#comment>
        <#elseif nodeParam.getSrcValueType()=="VIEWPARAM"><#comment>当前视图参数</#comment>
        <#elseif nodeParam.getSrcValueType()=="NONE"><#comment>无值</#comment>
        <#elseif nodeParam.getSrcValueType()=="NULLVALUE"><#comment>空值</#comment>
        <#elseif nodeParam.getSrcValueType()=="SRCVALUE"><#comment>直接值</#comment>
            <#assign sqlParam="\""+nodeParam.getSrcValue()+"\"">
        <#else>
            <#comment>暂未支持其余准备参数设置</#comment>
        </#if>
        param.put("param${nodeParam_index}",${sqlParam});
    </#list>
    <#comment>将占位符?替换为#{et.param1}</#comment>
    <#assign sql=srfjavasqlcode('${deLogicNode.getParam("PARAM4","")}')>
    <#list deLogicNode.getPSDELogicNodeParams() as nodeParam>
        <#assign sql=sql?replace("?","#"+"{et.param"+nodeParam_index+"}","f")>
    </#list>
    String strSql="${sql}";
</#macro>