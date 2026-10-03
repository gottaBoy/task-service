package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.IDynaViewController;

/**
 * 动态视图控制器对象接口
 * @author Administrator
 *
 */
public interface IDynaWFViewController extends IDynaViewController {

	/**
	 * 获取动态视图控制器实例对象
	 * @return
	 */
	IDynaWFViewControllerInst getDynaWFViewControllerInst();
	
	
	/**
	 * 获取视图流程标识
	 * @return
	 */
	String getViewWFId();

}
