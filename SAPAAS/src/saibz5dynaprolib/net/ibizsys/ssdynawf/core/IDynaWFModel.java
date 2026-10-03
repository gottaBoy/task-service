package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.sswf.core.ISaaSWFModel;

/**
 * JIT工作流模型对象接口
 * @author Administrator
 *
 */
public interface IDynaWFModel extends ISaaSWFModel {
	
	/**
	 * 获取JIT系统模型对象
	 * @return
	 */
	IDynaSysModel getDynaSysModel();
	
	
	/**
	 * 获取工作流对象
	 * @return
	 */
	IPSWorkflow getPSWorkflow();
}
