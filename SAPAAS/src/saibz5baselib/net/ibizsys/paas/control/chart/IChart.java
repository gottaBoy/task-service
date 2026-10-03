package net.ibizsys.paas.control.chart;

import net.ibizsys.paas.control.IControl;

/**
 * 图表控件接口
 * 
 * @author lionlau
 *
 */
public interface IChart extends IControl {
	/**
	 * 获取图表数据项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IChartDataItem> getChartDataItems();
}
