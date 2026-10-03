package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

public interface IDynaWFRuntime {

	/**
	 * 初始化
	 * @param iDynaSysModel
	 * @param iPSWorkflow
	 * @throws Exception
	 */
	public void init(IDynaSysModel iDynaSysModel, IPSWorkflow iPSWorkflow) throws Exception;
}
