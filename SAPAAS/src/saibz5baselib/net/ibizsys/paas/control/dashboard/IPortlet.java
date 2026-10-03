package net.ibizsys.paas.control.dashboard;

import net.ibizsys.paas.control.IControl;

/**
 * 数据看板控件
 * 
 * @author lionlau
 *
 */
public interface IPortlet extends IControl {
	/**
	 * 门户部件，图表
	 */
	final static String PORTLETTYPE_CHART = "CHART";

	/**
	 * 门户部件，列表
	 */
	final static String PORTLETTYPE_LIST = "LIST";

	/**
	 * 门户部件，自定义
	 */
	final static String PORTLETTYPE_CUSTOM = "CUSTOM";

	/**
	 * 门户部件，Html
	 */
	final static String PORTLETTYPE_HTML = "HTML";

	/**
	 * 门户部件，视图
	 */
	final static String PORTLETTYPE_VIEW = "VIEW";

	/**
	 * 门户部件，快速菜单
	 */
	final static String PORTLETTYPE_APPMENU = "APPMENU";

	
	/**
	 * 门户部件，表单
	 */
	final static String PORTLETTYPE_FORM = "FORM";
	
	
	
	/**
	 * 门户部件，搜索表单
	 */
	final static String PORTLETTYPE_SEARCHFORM = "SEARCHFORM";
	
	
	/**
	 * 门户部件，布局容器
	 */
	final static String PORTLETTYPE_CONTAINER = "CONTAINER";
	
	
	/**
	 * 门户部件，直接内容
	 */
	final static String PORTLETTYPE_RAWITEM = "RAWITEM";
	
	
	/**
	 * 获取部件的类型
	 * 
	 * @return
	 */
	String getPortletType();

	/**
	 * 获取部件标题
	 * 
	 * @return
	 */
	String getTitle();
}
