package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IChartPortletModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IPortletModel;

/**
 * 图形门户部件模型后台处理对象
 * 
 * @author lionlau
 *
 */
public abstract class ChartPortletHandlerBase extends PortletHandlerBase implements IPortletHandler {
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
	 * 图表门户部件模型
	 * 
	 * @return
	 */
	protected IChartPortletModel getChartPortletModel() {
		return (IChartPortletModel) getPortletModel();
	}

}
