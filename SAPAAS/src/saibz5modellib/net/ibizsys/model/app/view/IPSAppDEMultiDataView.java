package net.ibizsys.model.app.view;

import net.ibizsys.model.control.IPSControlMDataContainer;


/**
 * 应用实体多数据视图对象接口
 * @author lionlau
 *
 */
public interface IPSAppDEMultiDataView extends IPSAppDEXDataView,IPSAppDESearchView,IPSControlMDataContainer
{
	/**
	 * 支持快速搜索
	 */
	public final static String VIEWPARAM_UI_ENABLEQUICKSEARCH = "UI.ENABLEQUICKSEARCH";
	
	
	/**
	 * 支持搜索
	 */
	public final static String VIEWPARAM_UI_ENABLESEARCH = "UI.ENABLESEARCH";
	
	
	

	
	
	/**
	 * 视图引用模式，新建数据
	 */
	public final static String VIEWREFMODE_NEWDATA = "NEWDATA";
	
	
	/**
	 * 视图引用模式，编辑数据
	 */
	public final static String VIEWREFMODE_EDITDATA = "EDITDATA";
	
	/**
	 * 视图引用模式，编辑数据，需要指定视图模式
	 */
	public final static String VIEWREFMODE_EDITDATAX = "EDITDATAX";
	
	
	/**
	 * 视图引用模式，新建数据向导
	 */
	public final static String VIEWREFMODE_NEWDATAWIZARD = "NEWDATAWIZARD";
	
	
	/**
	 * 视图引用模式，批添加多选视图
	 */
	public final static String VIEWREFMODE_MPICKUPVIEW = "MPICKUPVIEW";
	
	
	
}
