package net.ibizsys.model.control.chart;

/**
 * 实体图表坐标轴对象
 * @author lionlau
 *
 */
public interface IPSDEChartSeries extends IPSChartSeries
{
	
	
	
	
	/**
	 * 获取实体图表对象
	 * @return
	 */
	IPSDEChart getPSDEChart();
	

	
	
	/**
	 * 获取数据序列的X轴
	 * @return
	 */
	IPSDEChartAxes getXPSDEChartAxes();
	
	
	
	
	/**
	 * 获取数据序列的Y轴
	 * @return
	 */
	IPSDEChartAxes getYPSDEChartAxes();
}
