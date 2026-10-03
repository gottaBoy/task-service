package net.ibizsys.model.control.chart;

import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

/**
 * 实体图表控件
 * @author lionlau
 *
 */
public interface IPSDEChart extends IPSChart
{
	/**
	 * 获取图表标题对象
	 * @return
	 */
	IPSDEChartTitle getPSDEChartTitle();
	
	
	
	/**
	 * 获取实体图表图例对象
	 * 
	 * @return
	 */
	IPSDEChartLegend getPSDEChartLegend();
	
	/**
	 * 获取数据集合
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet();
	
	
	/**
	 * 获取数据集合上下文数据转换逻辑
	 * @return
	 */
	IPSDELogic getActiveDataPSDELogic();
	
	/**
	 * 直角坐标系内绘图网格
	 * @return
	 */
	java.util.Iterator<IPSChartGrid> getPSChartGrids();
	
	
	/**
	 * 获取图表的坐标轴集合
	 * @return
	 */
	java.util.Iterator<IPSDEChartAxes> getPSDEChartAxeses();
	                                   
	
	
	
	/**
	 * 获取图表的数据序列集合
	 * @return
	 */
	java.util.Iterator<IPSDEChartSeries> getPSDEChartSerieses();
	
	
	
	/**
	 * 通过坐标轴类型获取坐标轴集合
	 * @param strPos [x,y]
	 * @return
	 */
	java.util.ArrayList<IPSDEChartAxes> getPSDEChartAxesesByPos(String strPos);
	
	
	
	
	
	/**
	 * 获取指定坐标轴
	 * @param strPSDEChartAxesId
	 * @return
	 * @throws Exception
	 */
	IPSDEChartAxes getPSDEChartAxes(String strPSDEChartAxesId) throws Exception;
	
	
//	/**
//	 * 获取图表绘制器
//	 * @return
//	 */
//	IPSSysPFPlugin getPSSysPFPlugin();
	
	
	
	
}
