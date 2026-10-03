package net.ibizsys.model.control.chart;

import net.ibizsys.model.core.IPSModelObject;

/**
 * 图表元素对象接口
 * @author Administrator
 *
 */
public interface IPSChartObject extends IPSModelObject
{
	/**
	 * 获取图表对象
	 * @return
	 */
	IPSChart  getPSChart();
}
