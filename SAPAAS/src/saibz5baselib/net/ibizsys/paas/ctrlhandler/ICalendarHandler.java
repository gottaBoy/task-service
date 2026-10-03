package net.ibizsys.paas.ctrlhandler;


/**
 * 日历视图后台处理接口
 * 
 * @author lionlau
 *
 */
public interface ICalendarHandler extends IMDCtrlHandler,ISDCtrlHandler {
	
	/**
	 * 获取草稿数据
	 */
	final static String ACTION_LOADDRAFT = "loaddraft";

	/**
	 * 获取草稿数据（从源数据）
	 */
	final static String ACTION_LOADDRAFTFROM = "loaddraftfrom";

	
	/**
	 * 获取草稿数据(从粘贴数据中）
	 */
	final static String ACTION_LOADDRAFTPASTE = "loaddraftpaste";
	
}
