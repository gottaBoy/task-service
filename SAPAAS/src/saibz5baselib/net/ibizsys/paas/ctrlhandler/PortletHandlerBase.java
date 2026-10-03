package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IPortletModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;

/**
 * 门户部件模型后台处理对象
 * 
 * @author lionlau
 *
 */
public abstract class PortletHandlerBase extends CtrlHandlerBase implements IPortletHandler {
	/**
	 * 获取部件模型
	 * 
	 * @return
	 */
	protected abstract IPortletModel getPortletModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getPortletModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang .String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, ACTION_FETCH, true) == 0) {
			return onFetch();
		}
		return super.onProcessAction(strAction);
	}

	/*
	 * 后台处理
	 */
	protected AjaxActionResult onFetch() throws Exception {
		throw new Exception("没有实现");
	}
}
