package net.ibizsys.pswf.controller;

import net.ibizsys.paas.core.IDEWF;

/**
 * 工作流实体视图模型控制器接口
 * 
 * @author lionlau
 *
 */
public interface IWFDEViewController extends IWFViewController {
	
	
	/**
	 * 获取实体工作流模型
	 * 
	 * @return
	 */
	IDEWF getDEWF();

}
