package net.ibizsys.pswf.core;

import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态工作流版本模型对象基类
 * @author Administrator
 *
 */
public abstract class DynaWFVersionModelBase  extends WFVersionModelBase implements IDynaWFVersionModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaWFVersionModelBase.class);
	private String strDynaInstId = null;
	private ObjectNode modelJsonObject = null;
	private IDynaWFModel iDynaWFModel = null;
	private DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();
	
	
	
	@Override
	public void init(IDynaWFModel iDynaWFModel, IEntity iEntity) throws Exception {
		iEntity.copyTo(dsDynaWFVer, false);
		this.iDynaWFModel = iDynaWFModel;
		this.setId(dsDynaWFVer.getDSDynaWFVerId());
		this.setName(dsDynaWFVer.getDSDynaWFVerName());
		this.strDynaInstId = dsDynaWFVer.getDynaSysInstId();
		this.setWFVersion(DataObject.getIntegerValue(dsDynaWFVer.getWFVersion(),1));
		this.init(iDynaWFModel);
		if(!StringHelper.isNullOrEmpty(dsDynaWFVer.getDynaModel())){
			ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString(dsDynaWFVer.getDynaModel());
			this.loadJsonObject(objectNode);
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
		//加载处理集合
		ArrayNode arrayNode = JsonNodeHelper.getArray(jsonObject, ATTR_WFPROCESSES);
		if (arrayNode != null) {
			int nSize = arrayNode.size();
			for (int i = 0; i < nSize; i++) {
				ObjectNode processNode = (ObjectNode) arrayNode.get(i);
				this.registerWFProcessModel(loadWFProcessModel(processNode));
			}
		}
		//加载连接集合
		arrayNode = JsonNodeHelper.getArray(jsonObject, ATTR_WFLINKS);
		if (arrayNode != null) {
			int nSize = arrayNode.size();
			for (int i = 0; i < nSize; i++) {
				ObjectNode linkNode = (ObjectNode) arrayNode.get(i);
				this.registerWFLinkModel(loadWFLinkModel(linkNode));
			}
		}
		String strBPMNModel = JsonNodeHelper.getString(jsonObject, ATTR_BPMNMODEL, null);
		if(!StringHelper.isNullOrEmpty(strBPMNModel)){
			this.setBPMNModel(strBPMNModel);
		}
	}

	
	
	protected IDynaWFProcessModel loadWFProcessModel(ObjectNode wfProcessModelNode) throws Exception{
		String strItemType = JsonNodeHelper.getString(wfProcessModelNode,IDynaCtrlModel.ATTR_TYPE,null);
		if(StringHelper.isNullOrEmpty(strItemType)){
			throw new Exception(StringHelper.format("没有指定处理类型"));
		}
		IDynaWFProcessModel iDynaWFProcessModel = createDynaWFProcessModel(strItemType);
		iDynaWFProcessModel.init(this,wfProcessModelNode);
		return iDynaWFProcessModel;
	}
	
	public IDynaWFProcessModel createDynaWFProcessModel(String strType)throws Exception{
		if(StringHelper.compare(strType, IDynaWFProcessModel.Start, true)==0){
			return new DynaWFStartProcessModel();
		}
		if(StringHelper.compare(strType, IDynaWFProcessModel.End, true)==0){
			return new DynaWFEndProcessModel();
		}
		if(StringHelper.compare(strType, IDynaWFProcessModel.Embed, true)==0){
			return new DynaWFEmbedWFProcessModel();
		}
		if(StringHelper.compare(strType, IDynaWFProcessModel.Interactive, true)==0){
			return new DynaWFInteractiveProcessModel();
		}
		if(StringHelper.compare(strType, IDynaWFProcessModel.ExclusiveGateway, true)==0){
			return new DynaWFExclusiveGatewayProcessModel();
		}
		if(StringHelper.compare(strType, IDynaWFProcessModel.InclusiveGateway, true)==0){
			return new DynaWFInclusiveGatewayProcessModel();
		}
		if(StringHelper.compare(strType, IDynaWFProcessModel.Parallel, true)==0){
			return new DynaWFParallelSubWFProcessModel();
		}
		if(StringHelper.compare(strType, IDynaWFProcessModel.ParallelGateway, true)==0){
			return new DynaWFParallelGatewayProcessModel();
		}
		if(StringHelper.compare(strType, IDynaWFProcessModel.Process, true)==0){
			return new DynaWFDEActionProcessModel();
		}
		if(StringHelper.compare(strType, IDynaWFProcessModel.TimerEvent, true)==0){
			return new DynaWFTimerEventProcessModel();
		}
		throw new Exception(StringHelper.format("无法识别的工作流处理类型[%1$s]",strType));
	}


	protected IDynaWFLinkModel loadWFLinkModel(ObjectNode wfLinkModelNode) throws Exception{
		String strItemType = JsonNodeHelper.getString(wfLinkModelNode,IDynaCtrlModel.ATTR_TYPE,null);
		if(StringHelper.isNullOrEmpty(strItemType)){
			throw new Exception(StringHelper.format("没有指定连接类型"));
		}
		IDynaWFLinkModel iDynaWFLinkModel = createDynaWFLinkModel(strItemType);
		iDynaWFLinkModel.init(this,wfLinkModelNode);
		return iDynaWFLinkModel;
	}
	
	public IDynaWFLinkModel createDynaWFLinkModel(String strType)throws Exception{
		if(StringHelper.compare(strType, IDynaWFLinkModel.Route, true)==0){
			return new DynaWFRouteLinkModel();
		}
		if(StringHelper.compare(strType, IDynaWFLinkModel.IAAction, true)==0){
			return new DynaWFInteractiveLinkModel();
		}
		if(StringHelper.compare(strType, IDynaWFLinkModel.Timeout, true)==0){
			return new DynaWFTimeoutLinkModel();
		}
		if(StringHelper.compare(strType, IDynaWFLinkModel.WFReturn, true)==0){
			return new DynaWFEmbedWFReturnModel();
		}
		
		throw new Exception(StringHelper.format("无法识别的工作流连接类型[%1$s]",strType));
	}

	
	

	@Override
	public String getDynaInstId() {
		return this.strDynaInstId;
	}
	
	
	
}
