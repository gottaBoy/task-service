package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IFormModel;

/**
 * 表单项更新后台处理接口
 * 
 * @author Administrator
 *
 */
public interface IFormItemUpdateHandler extends ICtrlItemHandler {
	/**
	 * 更新表单项
	 */
	final static String ACTION_UPDATEFORMITEM = "updateformitem";

	/**
	 * @param iFormModel
	 * @param iCtrlHandler
	 * @throws Exception
	 */
	void init(IFormModel iFormModel, ICtrlHandler iCtrlHandler) throws Exception;
}
