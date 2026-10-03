package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.ctrlmodel.ICalendarModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 日历视图绘制器接口
 * 
 * @author Administrator
 * 
 */
public interface ICalendarRender extends IMDCtrlRender {

	/**
	 * 获取传入的日历项类型
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	String getItemType(IWebContext iWebContext) throws Exception;
	
	
	/**
	 * 获取传入的日历项标识
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	String getItemId(IWebContext iWebContext) throws Exception;
	
	
	/**
	 * 填充数据获取结果
	 * @param iCalendarModel
	 * @param fetchResult
	 * @param calendarItemList
	 * @throws Exception
	 */
	void fillFetchResult(ICalendarModel iCalendarModel, MDAjaxActionResult fetchResult, ArrayList<ICalendarItem> calendarItemList) throws Exception;
	
	
	
	
	
	/**
	 * 填充数据获取结果
	 * @param iCalendarModel
	 * @param fetchResult
	 * @param iCalendarItem
	 * @throws Exception
	 */
	void fillItemResult(ICalendarModel iCalendarModel, MDAjaxActionResult fetchResult, ICalendarItem iCalendarItem) throws Exception;
}
