package net.ibizsys.model.control.calendar;



/**
 * 系统日历部件对象
 * @author Administrator
 *
 */
public interface IPSSysCalendar extends IPSCalendar {

	
	/**
	 * 获取日历项集合
	 * @return
	 */
	java.util.Iterator<IPSSysCalendarItem> getPSSysCalendarItems();
	
	
	/**
	 * 获取指定日历项
	 * @param strPSSysCalendarItemId
	 * @return
	 * @throws Exception
	 */
	IPSSysCalendarItem getPSSysCalendarItem(String strPSSysCalendarItemId) throws Exception;
	

}
