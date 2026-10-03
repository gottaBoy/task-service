package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IAppMenuPortletModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IPortletModel;

/**
 * 应用菜单栏门户部件模型后台处理对象
 * 
 * @author lionlau
 *
 */
public abstract class AppMenuPortletHandlerBase extends PortletHandlerBase implements IPortletHandler {
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

	/**
	 * 应用菜单门户部件模型
	 * 
	 * @return
	 */
	protected IAppMenuPortletModel getAppMenuPortletModel() {
		return (IAppMenuPortletModel) getPortletModel();
	}

}
