package net.ibizsys.model.control.chart;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.paas.control.chart.IChart;

/**
 * 云平台图表控件
 * 
 * @author lionlau
 *
 */
public interface IPSChart extends IPSAjaxControl, IChart {

	// 定义坐标系代码表

	/**
	 * 坐标系类型:直角坐标系
	 */
	public final static String COORDINATESYSTEM_XY = "XY";

	/**
	 * 坐标系类型:极坐标系
	 */
	public final static String COORDINATESYSTEM_POLAR = "POLAR";

	/**
	 * 坐标系类型:雷达坐标系
	 */
	public final static String COORDINATESYSTEM_RADAR = "RADAR";

	/**
	 * 坐标系类型:平行坐标系
	 */
	public final static String COORDINATESYSTEM_PARALLEL = "PARALLEL";

	/**
	 * 坐标系类型:单轴坐标系
	 */
	public final static String COORDINATESYSTEM_SINGLE = "SINGLE";

	/**
	 * 坐标系类型:日历坐标系
	 */
	public final static String COORDINATESYSTEM_CALENDAR = "CALENDAR";

	/**
	 * 坐标系类型:地图坐标系
	 */
	public final static String COORDINATESYSTEM_MAP = "MAP";

	/**
	 * 坐标系类型:无坐标系
	 */
	public final static String COORDINATESYSTEM_NONE = "NONE";

	/**
	 * 获取图表界面主题
	 * 
	 * @return
	 */
	String getChartTheme();

	/**
	 * 获取图表标题对象
	 * 
	 * @return
	 */
	IPSChartTitle getPSChartTitle();

	/**
	 * 获取图表图例对象
	 * 
	 * @return
	 */
	IPSChartLegend getPSChartLegend();

	/**
	 * 获取图表的坐标轴集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSChartAxes> getPSChartAxeses();

	/**
	 * 获取图表的数据序列集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSChartSeries> getPSChartSerieses();

	/**
	 * 获取图表的数据项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSChartDataItem> getPSChartDataItems();

	/**
	 * 获取图表视觉映射
	 * 
	 * @return
	 */
	java.util.Iterator<IPSChartVisualMap> getPSChartVisualMaps();

	/**
	 * 获取图表表格对象集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSChartGrid> getPSChartGrids();

	/**
	 * 获取图表的极坐标集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSChartPolar> getPSChartPolars();

//	/**
//	 * 获取无值显示内容语言资源对象
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getEmptyTextPSLanguageRes();

	/**
	 * 获取无值显示内容
	 * 
	 * @return
	 */
	String getEmptyText();

	/**
	 * 获取图表的坐标系统
	 * 
	 * @return
	 */
	String getCoordinateSystem();
}
