package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 图表绘制器接口
 * 
 * @author Administrator
 *
 */
public interface IChartRender extends IMDCtrlRender {

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	void fillFetchResult(IChartModel iChartModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception;

}
