package net.ibizsys.model.control.chart;

import net.ibizsys.model.control.IPSAjaxControlParam;

/**
 * 实体图表参数对象接口
 * @author lionlau
 *
 */
public interface IPSDEChartParam extends IPSAjaxControlParam
{
	/**
	 * 获取实体图表标识
	 * @return
	 */
	String getPSDEChartId();
	
	
	
	/**
	 * 获取实体数据集合标识
	 * @return
	 */
	String getPSDEDataSetId();
}
