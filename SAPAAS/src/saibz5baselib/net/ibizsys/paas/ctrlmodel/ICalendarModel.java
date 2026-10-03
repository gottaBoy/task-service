package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;

import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;


/**
 * 日历部件模型接口
 * 
 * @author lionlau
 *
 */
public interface ICalendarModel extends ICtrlModel {
	
	
	/**
	 * 节点分隔符号
	 */
	static final String ITEM_SEPARATOR = ";";
	
	
	/**
	 * 获取指定日历项模型
	 * @param strCalendarItemModelId
	 * @return
	 * @throws Exception
	 */
	ICalendarItemModel getCalendarItemModel(String strCalendarItemModelId) throws Exception;
	
	
	
	/**
	 * 获取日历项模型集合
	 * @return
	 */
	Iterator<ICalendarItemModel> getCalendarItemModels();
	
	
	
	/**
	 * 是否输出指定日历项
	 * @param iCalendarItemFetchContext
	 * @param iCalendarItem
	 * @return
	 * @throws Exception
	 */
	boolean isOutputCalendarItem(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItem iCalendarItem) throws Exception ;
	
	
	
	
	/**
	 * 是否输出指定日历项模型
	 * @param iCalendarItemFetchContext
	 * @param iCalendarItem
	 * @return
	 * @throws Exception
	 */
	boolean isOutputCalendarItemModel(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItemModel iCalendarItemModel) throws Exception ;
}
