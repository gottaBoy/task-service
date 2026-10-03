package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态工作流交互处理模型对象实现
 * @author Administrator
 *
 */
public class DynaWFInteractiveProcessModel extends WFInteractiveProcessModelBase implements IDynaWFProcessModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaWFInteractiveProcessModel.class);
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
		
		this.setTopPos(JsonNodeHelper.getInt(jsonObject, IDynaWFProcessModel.ATTR_TOPPOS, 0));
		this.setLeftPos(JsonNodeHelper.getInt(jsonObject, IDynaWFProcessModel.ATTR_LEFTPOS, 0));
		
		this.setWFStepValue(JsonNodeHelper.getString(jsonObject, IDynaWFProcessModel.ATTR_WFSTEPVALUE, null));
		
		this.setEditable(JsonNodeHelper.getInt(jsonObject, IDynaWFProcessModel.ATTR_EDITABLE, 0)==1);
		this.setAsynchronousProcess(JsonNodeHelper.getInt(jsonObject, IDynaWFProcessModel.ATTR_ASYNCMODE, 0)==1);
		String strMemoField = JsonNodeHelper.getString(jsonObject, IDynaWFProcessModel.ATTR_MEMOFIELD, null);
		if(!StringHelper.isNullOrEmpty(strMemoField)){
			this.setMemoField(strMemoField);
		}
		
		String strUserData = JsonNodeHelper.getString(jsonObject, IDynaWFProcessModel.ATTR_USERDATA, null);
		if(!StringHelper.isNullOrEmpty(strUserData)){
			this.setUserData(strUserData);
		}
		
		String strUserData2 = JsonNodeHelper.getString(jsonObject, IDynaWFProcessModel.ATTR_USERDATA2, null);
		if(!StringHelper.isNullOrEmpty(strUserData2)){
			this.setUserData2(strUserData2);
		}
		
		if(JsonNodeHelper.getInt(jsonObject, IDynaWFProcessModel.ATTR_SENDINFORM, 0)==1){
			this.setSendInform(true);
			this.setMsgTemplateId( JsonNodeHelper.getString(jsonObject, IDynaWFProcessModel.ATTR_SYSMSGTEMPLID, null));
			this.setMsgType(JsonNodeHelper.getInt(jsonObject, IDynaWFProcessModel.ATTR_MSGTYPE, 0));
		}
			
		
		//注册处理角色
		ArrayNode arrayNode = JsonNodeHelper.getArray(jsonObject, IDynaWFProcessModel.ATTR_WFPROCROLES);
		if(arrayNode!=null){
			for(int i =0;i<arrayNode.size();i++){
				
				ObjectNode wfProcRoleNode = (ObjectNode)arrayNode.get(i);
				String strRoleType  = JsonNodeHelper.getString(wfProcRoleNode, "roletype", "");
				if(StringHelper.compare(strRoleType, IWFProcRoleModel.ROLETYPE_WFROLE,true) == 0){
					WFProcRoleModel wfProcRoleModel = new WFProcRoleModel();
					wfProcRoleModel.setWFRoleId(JsonNodeHelper.getString(wfProcRoleNode,"wfroleid", ""));
					wfProcRoleModel.setId(JsonNodeHelper.getString(wfProcRoleNode, IDynaModel.ATTR_ID, ""));
					wfProcRoleModel.setName(JsonNodeHelper.getString(wfProcRoleNode, IDynaModel.ATTR_NAME, ""));
					wfProcRoleModel.setWFProcRoleType(strRoleType);
					wfProcRoleModel.init(this);
			        this.registerWFProcRoleModel(wfProcRoleModel);
			        continue;
				}
				else
				if(StringHelper.compare(strRoleType, IWFProcRoleModel.ROLETYPE_UDACTOR,true) == 0){
					WFProcUDActorRoleModel wfProcRoleModel = new WFProcUDActorRoleModel();
					wfProcRoleModel.setUDField(JsonNodeHelper.getString(wfProcRoleNode, "udfield", ""));
					wfProcRoleModel.setId(JsonNodeHelper.getString(wfProcRoleNode, IDynaModel.ATTR_ID, ""));
					wfProcRoleModel.setName(JsonNodeHelper.getString(wfProcRoleNode, IDynaModel.ATTR_NAME, ""));
					wfProcRoleModel.setWFProcRoleType(strRoleType);
					wfProcRoleModel.init(this);
			        this.registerWFProcRoleModel(wfProcRoleModel);
			        continue;
				}
				else {
					WFProcSysActorRoleModel wfProcRoleModel = new WFProcSysActorRoleModel();
					wfProcRoleModel.setId(JsonNodeHelper.getString(wfProcRoleNode, IDynaModel.ATTR_ID, ""));
					wfProcRoleModel.setName(JsonNodeHelper.getString(wfProcRoleNode, IDynaModel.ATTR_NAME, ""));
					wfProcRoleModel.setWFProcRoleType(strRoleType);
					wfProcRoleModel.init(this);
			        this.registerWFProcRoleModel(wfProcRoleModel);
			        continue;
				}
			}
			
		}
     }



}
