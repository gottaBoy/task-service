package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * 动态系统工作流模型基类
 * @author Administrator
 *
 */
public abstract class WFModelBase extends net.ibizsys.sswf.core.WFModelBase implements IDynaWFModel{

	private IPSWorkflow iPSWorkflow = null;
	private int wfProxyMode;

	public int getWFProxyMode() {
		return wfProxyMode;
	}

	protected void setWFProxyMode(int wfProxyMode) {
		this.wfProxyMode = wfProxyMode;
	}
	@Override
	public IDynaSysModel getDynaSysModel() {
		return (IDynaSysModel) this.getSystemModel();
	}

	@Override
	public IPSWorkflow getPSWorkflow() {
		return this.iPSWorkflow;
	}
	
	/**
	 * 设置工作流对象
	 * @param iPSWorkflow
	 */
	protected void setPSWorkflow(IPSWorkflow iPSWorkflow) {
		this.iPSWorkflow = iPSWorkflow;
	}

	
	@Override
	public IEntity createEntity(String strDEName) throws Exception {
		return this.getDynaSysModel().getDataEntityModel(strDEName).createEntity();
	}
}
