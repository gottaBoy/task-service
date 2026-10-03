package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.chart.IChart;
import net.ibizsys.paas.control.chart.IChartDataItem;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.demodel.IDataEntityModel;

/**
 * 图表数据项模型对象
 * 
 * @author lionlau
 *
 */
public class ChartDataItemModel extends DataItemModel implements IChartDataItem {
	protected IChart iChart = null;

	public ChartDataItemModel() {

	}

	/**
	 * 初始化
	 * 
	 * @param iChart
	 * @throws Exception
	 */
	public void init(IChart iChart) throws Exception {
		this.setChart(iChart);
		this.onInit();
	}

	/**
	 * 获取图表对象
	 * 
	 * @return the iChart
	 */
	protected IChart getChart() {
		return iChart;
	}

	/**
	 * 设置图表对象
	 * 
	 * @param iChart the iChart to set
	 */
	protected void setChart(IChart iChart) {
		this.iChart = iChart;
	}

	/**
	 * 获取当前的系统
	 * 
	 * @return
	 */
	@Override
	public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
		return this.getChart().getDataEntity().getSystem();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.impl.DataItemImpl#getDEModel()
	 */
	@Override
	protected IDataEntityModel getDEModel() throws Exception {
		return (IDataEntityModel) this.getChart().getDataEntity();
	}
}
