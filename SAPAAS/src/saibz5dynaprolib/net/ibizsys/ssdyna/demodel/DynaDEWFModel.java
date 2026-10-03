package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.wf.IPSDEWF;


/**
 * JIT 实体工作流模型对象
 * 
 * @author Administrator
 *
 */
public class DynaDEWFModel extends DynaDEWFModelBase {

	private IDynaDEModel iDynaDEModel = null;
	private IPSDEWF iPSDEWF = null;

	/**
	 * 初始化
	 * 
	 * @param iDynaDEModel
	 * @param iPSDEWF
	 * @throws Exception
	 */
	public void init(IDynaDEModel iDynaDEModel, IPSDEWF iPSDEWF) throws Exception {
		this.iDynaDEModel = iDynaDEModel;
		this.iPSDEWF = iPSDEWF;

		// 设置标识
		this.setId(iPSDEWF.getId());
		// 设置工作流标识
		this.setWorkflowId(iPSDEWF.getWorkflowId());
		// 设置实体流程名称
		this.setName(iPSDEWF.getCodeName());

		if (iPSDEWF.getWFStepPSDEField() != null) {
			// 设置流程步骤属性 ${item.getWFStepPSDEField().logicName}
			this.setWFStepField(iPSDEWF.getWFStepPSDEField().getName());
		}
		if (iPSDEWF.getWFStatePSDEField() != null) {
			// 设置流程状态属性 ${item.getWFStatePSDEField().logicName}
			this.setWFStateField(iPSDEWF.getWFStatePSDEField().getName());
		}
		if (iPSDEWF.getUDStatePSDEField() != null) {
			// 设置用户数据状态属性 ${item.getUDStatePSDEField().logicName}
			this.setUDStateField(iPSDEWF.getUDStatePSDEField().getName());
		}
		if (iPSDEWF.getWFInstPSDEField() != null) {
			// 设置流程实例属性 ${item.getWFInstPSDEField().logicName}
			this.setWFInstField(iPSDEWF.getWFInstPSDEField().getName());
		}
		if (iPSDEWF.getWFActorsPSDEField() != null) {
			// 设置流程操作者属性 ${item.getWFActorsPSDEField().logicName}
			this.setWFActorsField(iPSDEWF.getWFActorsPSDEField().getName());
		}
		if (iPSDEWF.getEntityWFState() != null) {
			// 设置流程状态值
			this.setEntityWFState(iPSDEWF.getEntityWFState());
		}
		if (iPSDEWF.getWFRetPSDEField() != null) {
			// 设置流程返回值属性 ${item.getWFRetPSDEField().logicName}
			this.setWFRetField(iPSDEWF.getWFRetPSDEField().getName());
		}
		if (iPSDEWF.getWFVerPSDEField() != null) {
			// 设置流程版本属性 ${item.getWFVerPSDEField().logicName}
			this.setWFVerField(iPSDEWF.getWFVerPSDEField().getName());
		}
		if (iPSDEWF.getWorkflowPSDEField() != null) {
			// 设置流程标识属性 ${item.getWorkflowPSDEField().logicName}
			this.setWorkflowField(iPSDEWF.getWorkflowPSDEField().getName());
		}
		
		this.setWFProxyMode(iPSDEWF.getWFProxyMode());
		
		if (iPSDEWF.getProxyDataPSDEField() != null) {
			// 设置代理流程数据属性 ${item.getProxyDataPSDEField().logicName}
			this.setProxyDataField(iPSDEWF.getProxyDataPSDEField().getName());
		}
		
		if (iPSDEWF.getProxyModulePSDEField() != null) {
			// 设置代理模块属性 ${item.getProxyModulePSDEField().logicName}
			this.setProxyModuleField(iPSDEWF.getProxyModulePSDEField().getName());
		}
		
		this.init(iDynaDEModel);
		this.iPSDEWF = null;
	}
}
