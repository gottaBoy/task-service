package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态流程实体操作处理模型对象实现
 * @author Administrator
 *
 */
public class DynaWFDEActionProcessModel extends WFDEActionProcessModelBase implements IDynaWFProcessModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaWFDEActionProcessModel.class);
	private ObjectNode modelJsonObject = null;
	
	@Override
	public void init(IDynaWFVersionModel iDynaWFVersionModel, Object modelObject) throws Exception {
		this.init(iDynaWFVersionModel);
		if(modelObject !=null ){
			if(modelObject instanceof ObjectNode){
				loadJsonObject((ObjectNode)modelObject);
				return;
			}
		}	
	}
	
	
	/**
	 * 加载Json模型
	 * @param jsonObject
	 * @throws Exception
	 */
	public void loadJsonObject(ObjectNode jsonObject) throws Exception {
		this.modelJsonObject = jsonObject;
		onLoadJsonObject(jsonObject);
	}
	
	/**
	 * 加载Json对象模型
	 * @param jsonObject
	 * @throws Exception
	 */
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		String strId = JsonNodeHelper.getString(jsonObject, IDynaModel.ATTR_ID, null);
		if(StringHelper.isNullOrEmpty(strId)){
			throw new Exception(StringHelper.format("没有指定流程处理标识"));
		}
		this.setId(strId);
	
		String strName = JsonNodeHelper.getString(jsonObject, IDynaModel.ATTR_NAME, null);
		if(!StringHelper.isNullOrEmpty(strName)){
			this.setName(strName);
		}
		
		String strModelId = JsonNodeHelper.getString(jsonObject, IDynaWFProcessModel.ATTR_MODELID, null);
		if(!StringHelper.isNullOrEmpty(strModelId)){
			this.setBPMNModelId(strModelId);
		}
		
		String strDEActionName = JsonNodeHelper.getString(jsonObject, IDynaWFProcessModel.ATTR_DEACTIONNAME, null);
		if(!StringHelper.isNullOrEmpty(strDEActionName)){
			this.setDEActionName(strDEActionName);
		}
		
		ArrayNode arrayNode = JsonNodeHelper.getArray(jsonObject, IDynaWFProcessModel.ATTR_WFPROCPARAMS);
		if(arrayNode!=null){
			for(int i =0;i<arrayNode.size();i++){
				ObjectNode wfProcParamNode = (ObjectNode)arrayNode.get(i);
				net.ibizsys.pswf.core.WFDEActionProcessParamModel procParam = new net.ibizsys.pswf.core.WFDEActionProcessParamModel();
				String strDstField = JsonNodeHelper.getString(wfProcParamNode,"customdstdefname", "");
				if(StringHelper.isNullOrEmpty(strDstField))
					strDstField = JsonNodeHelper.getString(wfProcParamNode,"defname", "");
				procParam.setDstField(strDstField);
				procParam.setSrcValueType(JsonNodeHelper.getString(wfProcParamNode,"srcvaluetype", ""));
				procParam.setSrcValue(JsonNodeHelper.getString(wfProcParamNode,"srcvalue", ""));
				this.registerWFDEActionProcessParamModel(procParam);
			}
		}
		this.setTopPos(JsonNodeHelper.getInt(jsonObject, IDynaWFProcessModel.ATTR_TOPPOS, 0));
		this.setLeftPos(JsonNodeHelper.getInt(jsonObject, IDynaWFProcessModel.ATTR_LEFTPOS, 0));
	}

}
