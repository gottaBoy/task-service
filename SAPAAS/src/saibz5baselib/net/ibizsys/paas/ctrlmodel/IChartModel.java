package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.chart.IChart;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 图表部件模型接口
 * 
 * @author lionlau
 *
 */
public interface IChartModel extends ICtrlModel, IChart {
	/**
	 * 获取图表坐标轴集合
	 * 
	 * @return
	 */
	java.util.Iterator<IChartAxisModel> getChartAxisModels();

	/**
	 * 获取图表坐数据序列集合
	 * 
	 * @return
	 */
	java.util.Iterator<IChartSeriesModel> getChartSeriesModels();

	/**
	 * 填充返回结果对象
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception;
}
