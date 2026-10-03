package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IListPortletModel;
import net.ibizsys.paas.ctrlmodel.IPortletModel;

/**
 * 列表门户部件模型后台处理对象
 * 
 * @author lionlau
 *
 */
public abstract class ListPortletHandlerBase extends PortletHandlerBase implements IPortletHandler {
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
	 * 列表门户部件模型
	 * 
	 * @return
	 */
	protected IListPortletModel getListPortletModel() {
		return (IListPortletModel) getPortletModel();
	}

}
