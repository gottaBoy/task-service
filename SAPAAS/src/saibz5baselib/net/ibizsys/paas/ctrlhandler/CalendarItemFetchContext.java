package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 日历项获取上下文对象
 * 
 * @author Administrator
 *
 */
public class CalendarItemFetchContext implements ICalendarItemFetchContext {

	private java.sql.Timestamp beginTime = null;
	private java.sql.Timestamp endTime = null;

	public CalendarItemFetchContext() {

	}

	public CalendarItemFetchContext(ICalendarItemFetchContext iCalendarItemFetchContext) {
		this.beginTime = iCalendarItemFetchContext.getBeginTime();
		this.endTime = iCalendarItemFetchContext.getEndTime();
	
	}

	public CalendarItemFetchContext(IWebContext iWebContext) throws Exception{
		String strBeginTime = iWebContext.getPostValue("srfbegintime");
		if (!StringHelper.isNullOrEmpty(strBeginTime)) {
			this.beginTime = new java.sql.Timestamp(DateHelper.parse(strBeginTime).getTime());
		}
		String strEndTime = iWebContext.getPostValue("srfendtime");
		if (!StringHelper.isNullOrEmpty(strEndTime)) {
			this.endTime = new java.sql.Timestamp(DateHelper.parse(strEndTime).getTime());
		}
	}
	
	
	
	@Override
	public java.sql.Timestamp getBeginTime() {
		return beginTime;
	}

	/**
	 * 设置开始时间
	 * @param beginTime
	 */
	public void setBeginTime(java.sql.Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Override
	public java.sql.Timestamp getEndTime() {
		return endTime;
	}

	
	/**
	 * 设置结束时间
	 * @param endTime
	 */
	public void setEndTime(java.sql.Timestamp endTime) {
		this.endTime = endTime;
	}

}
