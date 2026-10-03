package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFRole;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.pswf.core.IWFRoleModel;

/**
 * JIT 流程角色模型
 * @author Administrator
 *
 */
public interface IDynaWFRoleModel  extends IWFRoleModel{

	
	/**
	 * 获取JIT系统模型对象
	 * @return
	 */
	IDynaSysModel getDynaSysModel();
	
	
	/**
	 * 获取工作流角色对象
	 * @return
	 */
	IPSWFRole getPSWFRole();
	
	
}
