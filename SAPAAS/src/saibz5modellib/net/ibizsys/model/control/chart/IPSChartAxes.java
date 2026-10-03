package net.ibizsys.model.control.chart;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 图表坐标轴对象接口
 * @author lionlau
 *
 */
public interface IPSChartAxes extends IPSModelObject
{
	/**
	 * 坐标轴数据显示方式：纵向
	 */
	public final int DATASHOWMODE_LONGITUDINAL = 1;
	
	/**
	 * 坐标轴数据显示方式：横向
	 */
	public final int DATASHOWMODE_HORIZONTAL = 2;
	
	/**
	 * 坐标轴数据显示方式：斜向
	 */
	public final int DATASHOWMODE_OBLIQUE = 3;
	
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();
	
	
	
	/**
	 * 获取坐标轴类型
	 * @return
	 */
	String getAxesType();
	
	
	
	
	/**
	 * 获取坐标轴位置
	 * @return
	 */
	String getAxesPos();
	
	
	
	
	/**
	 * 获取图表
	 * @return
	 */
	IPSChart getPSChart();
	
	
	
	
	/**
	 * 获取数据字段集合
	 * @return
	 */
	String[] getFields();
	
	
	
//	/**
//	 * 获取标题语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getCapPSLanguageRes();
	
	
	
	
	/**
	 * 获取数据显示模式，值参考 SA.SRFDA.PS.Core.Control.Chart.IPSChartAxes.DATASHOWMODE_XXXX 定义
	 * @return
	 */
	int getDataShowMode();
	
	
	
	/**
	 * 获取最大值
	 * @return
	 */
	Double getMaxValue();
	
	
	
	
	/**
	 * 获取最小值
	 * @return
	 */
	Double getMinValue();
}
