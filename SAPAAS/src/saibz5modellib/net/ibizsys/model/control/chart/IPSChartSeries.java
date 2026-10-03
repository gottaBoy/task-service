package net.ibizsys.model.control.chart;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;

/**
 * 图表数据序列对象接口
 * @author lionlau
 *
 */
public interface IPSChartSeries extends IPSModelObject
{
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();
	
	
//	/**
//	 * 获取标题语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getCapPSLanguageRes();
//	
//	
	/**
	 * 获取标题语言资源标记
	 * @return
	 */
	String getCapLanResTag();
	
	
	/**
	 * 获取数据序列类型
	 * @return
	 */
	String getSeriesType();
	
	
	
	
	/**
	 * 获取图表
	 * @return
	 */
	IPSChart getPSChart();
	
	/**
	 * 获取序列识别属性
	 * @return
	 */
	String getSeriesField();
	
	
	/**
	 * 获取X值属性
	 * @return
	 */
	String getCatalogField();
	
	
	/**
	 * 获取Y值属性
	 * @return
	 */
	String getValueField();
	
	/**
	 * 获取Z值属性
	 * @return
	 */
	String getValue2Field();
	
	
	/**
	 * 获取值3属性
	 * @return
	 */
	String getValue3Field();
	
	
	/**
	 * 获取值4属性
	 * @return
	 */
	String getValue4Field();
	
	
	/**
	 * 获取值5属性
	 * @return
	 */
	String getValue5Field();
	
	
	/**
	 * 获取值6属性
	 * @return
	 */
	String getValue6Field();
	
	
	/**
	 * 获取数据序列的X轴
	 * @return
	 */
	IPSChartAxes getXPSChartAxes();
	
	
	
	
	/**
	 * 获取数据序列的Y轴
	 * @return
	 */
	IPSChartAxes getYPSChartAxes();
	
	
	
	/**
	 * 获取时间自动分组模式
	 * @return
	 */
	String getTimeGroupMode();
	
	
	/**
	 * 获取序列值代码表对象
	 * @return
	 */
	IPSCodeList getSeriesPSCodeList();
	
	
	/**
	 * 获取分类值代码表对象
	 * @return
	 */
	IPSCodeList getCatalogPSCodeList();
}
