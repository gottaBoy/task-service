package net.ibizsys.model.app.view;

/**
 * 应用实体搜索视图对象接口
 * @author Administrator
 *
 */
public interface IPSAppDESearchView extends IPSAppDEView {

	/**
	 * 默认搜索表单部件名称
	 */
	final static String CONTROL_SEARCHFORM = "searchform";
	
	
	/**
	 * 是否支持快速搜索
	 * @return
	 */
	boolean isEnableQuickSearch();
	
	
	
	
	/**
	 * 是否支持搜索
	 * @return
	 */
	boolean isEnableSearch();
	
	
	
	
	
	/**
	 * 是否为默认加载
	 * @return
	 */
	boolean isLoadDefault();
	
}
