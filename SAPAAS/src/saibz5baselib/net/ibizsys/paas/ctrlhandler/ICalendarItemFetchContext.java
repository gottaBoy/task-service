package net.ibizsys.paas.ctrlhandler;

/**
 * 日历数据项获取上下文对象
 * 
 * @author Administrator
 *
 */
public interface ICalendarItemFetchContext {
	
	/**
	 * 获取查询开始时间
	 * @return
	 */
	java.sql.Timestamp getBeginTime();
	
	
	/**
	 * 获取查询结束时间
	 * @return
	 */
	java.sql.Timestamp getEndTime();
}
