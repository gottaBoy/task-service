package net.ibizsys.model.control.calendar;

import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.paas.control.calendar.ICalendar;

/**
 * 日历部件对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSCalendar extends IPSMDAjaxControl, ICalendar {
	/**
	 * 日历部件样式：天
	 */
	public final static String CALENDARSTYLE_DAY = "DAY";

	/**
	 * 日历部件样式：周
	 */
	public final static String CALENDARSTYLE_WEEK = "WEEK";

	/**
	 * 日历部件样式：月
	 */
	public final static String CALENDARSTYLE_MONTH = "MONTH";

	/**
	 * 日历部件样式：用户自定义
	 */
	public final static String CALENDARSTYLE_USER = "USER";

	/**
	 * 日历部件样式：用户自定义2
	 */
	public final static String CALENDARSTYLE_USER2 = "USER2";

	/**
	 * 获取日历部件样式，值参考 SA.SRFDA.PS.Core.Control.Calendar.IPSCalendar.CALENDARSTYLE_XXX 定义
	 * 
	 * @return
	 */
	String getCalendarStyle();

//	/**
//	 * 获取无值显示内容语言资源对象
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getEmptyTextPSLanguageRes();

	/**
	 * 获取无值显示内容
	 * 
	 * @return
	 */
	String getEmptyText();

	/**
	 * 是否使用缓存绘制模式，默认为是
	 * 
	 * @return
	 */
	boolean isBufferRenderer();

}
