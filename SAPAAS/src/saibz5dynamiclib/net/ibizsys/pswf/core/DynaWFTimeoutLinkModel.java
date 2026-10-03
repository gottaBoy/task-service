package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态流程超时连接模型
 * @author Administrator
 *
 */
public class DynaWFTimeoutLinkModel extends WFTimeoutLinkModelBase implements IDynaWFLinkModel {
	
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaWFTimeoutLinkModel.class);
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
			throw new Exception(StringHelper.format("没有指定流程连接标识"));
		}
		this.setId(strId);
		String strName = JsonNodeHelper.getString(jsonObject, IDynaModel.ATTR_NAME, null);
		if(!StringHelper.isNullOrEmpty(strName)){
			this.setName(strName);
		}
		
		String strModelId = JsonNodeHelper.getString(jsonObject, IDynaWFLinkModel.ATTR_MODELID, null);
		if(!StringHelper.isNullOrEmpty(strModelId)){
			this.setBPMNModelId(strModelId);
		}
		
		String strLogicName = JsonNodeHelper.getString(jsonObject, IDynaWFLinkModel.ATTR_LOGICNAME, null);
		if(!StringHelper.isNullOrEmpty(strLogicName)){
			this.setLogicName(strLogicName);
		}
		
		String strFromWFProcId = JsonNodeHelper.getString(jsonObject, IDynaWFLinkModel.ATTR_FROMWFPROCID, null);
		if(!StringHelper.isNullOrEmpty(strFromWFProcId)){
			this.setFrom(strFromWFProcId);
		}
		
		String strToWFProcId = JsonNodeHelper.getString(jsonObject, IDynaWFLinkModel.ATTR_TOWFPROCID, null);
		if(!StringHelper.isNullOrEmpty(strToWFProcId)){
			this.setNext(strToWFProcId);
		}
	}
}
