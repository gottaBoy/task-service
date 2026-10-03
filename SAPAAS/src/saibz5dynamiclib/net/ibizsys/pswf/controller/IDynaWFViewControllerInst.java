package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.IDynaViewControllerInst;

/**
 * 动态工作流视图控制器实例对象接口
 * @author Administrator
 *
 */
public interface IDynaWFViewControllerInst extends IDynaViewControllerInst,IWFViewController {

	/**
	 * 视图模型，流程交互模式
	 */
	public final static String ATTR_WFIAMODE = "wfiamode";
	
	/**
	 * 流程标识
	 */
	public final static String ATTR_WFID = "wfid";
	
	/**
	 * 流程步骤值
	 */
	public final static String ATTR_WFSTEPVALUE = "wfstepvalue";
	
}
