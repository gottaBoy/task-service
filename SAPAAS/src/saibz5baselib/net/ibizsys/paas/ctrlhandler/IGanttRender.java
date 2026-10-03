package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.control.gantt.IGanttItem;
import net.ibizsys.paas.ctrlmodel.IGanttModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 甘特视图绘制器接口
 * 
 * @author Administrator
 * 
 */
public interface IGanttRender extends IMDCtrlRender {

	/**
	 * 获取传入的甘特项类型
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	String getItemType(IWebContext iWebContext) throws Exception;
	
	
	/**
	 * 获取传入的甘特项标识
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	String getItemId(IWebContext iWebContext) throws Exception;
	
	
	/**
	 * 填充数据获取结果
	 * @param iGanttModel
	 * @param fetchResult
	 * @param calendarItemList
	 * @throws Exception
	 */
	void fillFetchResult(IGanttModel iGanttModel, MDAjaxActionResult fetchResult, ArrayList<IGanttItem> calendarItemList) throws Exception;
	
	
	
	
	
	/**
	 * 填充数据获取结果
	 * @param iGanttModel
	 * @param fetchResult
	 * @param iGanttItem
	 * @throws Exception
	 */
	void fillItemResult(IGanttModel iGanttModel, MDAjaxActionResult fetchResult, IGanttItem iGanttItem) throws Exception;
}
