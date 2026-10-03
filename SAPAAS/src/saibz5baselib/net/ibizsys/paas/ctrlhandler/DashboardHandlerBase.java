package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDashboardModel;

/**
 * 门户部件模型后台处理对象
 * 
 * @author lionlau
 *
 */
public abstract class DashboardHandlerBase extends CtrlHandlerBase {
	protected abstract IDashboardModel getDashboardModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getDashboardModel();
	}

}
