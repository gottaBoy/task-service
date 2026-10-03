package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IChartModel;

/**
 * 图表处理对象接口
 * 
 * @author lionlau
 *
 */
public interface IChartHandler extends IMDCtrlHandler {
	/**
	 * 获取图表模型
	 * 
	 * @return
	 */
	IChartModel getChartModel();
}
