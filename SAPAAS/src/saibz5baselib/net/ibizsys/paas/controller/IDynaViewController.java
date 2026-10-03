package net.ibizsys.paas.controller;

import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;

/**
 * 动态视图控制器对象接口
 * @author Administrator
 *
 */
public interface IDynaViewController extends IViewController {

	/**
	 * 获取动态视图控制器实例对象
	 * @return
	 */
	IDynaViewControllerInst getDynaViewControllerInst();
	

	/**
	 * 是否启用动态视图
	 * @return
	 */
	boolean isEnableDynaView();
	
	
	
	/**
	 * 准备动态视图控制器实例
	 * @throws Exception
	 */
	IDynaViewControllerInst prepareDynaViewControllerInst() throws Exception;
	
	
	
	/**
	 * 获取控件处理对象
	 * 
	 * @param strName 控件名称
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	ICtrlHandler getCtrlHandler(String strName,boolean bTryMode) throws Exception;
	
	
	
	
	/**
	 * 获取控件模型对象
	 * 
	 * @param strName 控件名称
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	ICtrlModel getCtrlModel(String strName,boolean bTryMode) throws Exception;
	
	/**
	 * 重置动态视图控制器实例
	 */
	void resetDynaViewControllerInsts() throws Exception;
}
