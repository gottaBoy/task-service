package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.chart.IPSChart;

/**
 * 图表部件
 * @author lionlau
 *
 */
public interface IPSDBChartPartPortlet extends IPSDBSysPortletPart
{
	/**
	 * 获取图形部件
	 * @return
	 */
	IPSChart getPSChart();
}
