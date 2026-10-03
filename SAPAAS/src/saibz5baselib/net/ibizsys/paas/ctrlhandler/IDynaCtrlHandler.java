package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;

/**
 * 动态部件处理器对象接口
 * @author Administrator
 *
 */
public interface IDynaCtrlHandler extends ICtrlHandler{

	/**
	 * 初始化控件处理器对象
	 * @param iDynaViewControllerInst
	 * @param iDynaViewCtrlModel
	 * @throws Exception
	 */
	void init(IDynaViewControllerInst iDynaViewControllerInst,IDynaCtrlModel iDynaCtrlModel) throws Exception;
	
	
	/**
	 * 获取动态部件模型对象
	 * @return
	 */
	IDynaCtrlModel getDynaCtrlModel();
}
