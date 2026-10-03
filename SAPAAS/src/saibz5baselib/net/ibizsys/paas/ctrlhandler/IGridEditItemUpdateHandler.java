package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IGridModel;

/**
 * 表格编辑项更新后台处理接口
 * 
 * @author Administrator
 *
 */
public interface IGridEditItemUpdateHandler extends ICtrlItemHandler {
	/**
	 * 更新表单项
	 */
	final static String ACTION_UPDATEGRIDEDITITEM = "updategridedititem";

	/**
	 * @param iGridModel 表格模型
	 * @param iCtrlHandler 控件处理器
	 * @throws Exception
	 */
	void init(IGridModel iGridModel, ICtrlHandler iCtrlHandler) throws Exception;
}
