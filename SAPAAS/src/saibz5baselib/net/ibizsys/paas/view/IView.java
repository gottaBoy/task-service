package net.ibizsys.paas.view;

import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;

/**
 * 视图对象基本接口
 * 
 * @author lionlau
 *
 */
public interface IView extends IModelBase {

	// 定义预置视图类型代码表

	/**
	 * 默认单选视图
	 */
	final static String PREDEFINEDVIEWTYPE_PICKUPVIEW = "PICKUPVIEW";

	/**
	 * 默认编辑视图
	 */
	final static String PREDEFINEDVIEWTYPE_EDITVIEW = "EDITVIEW";

	/**
	 * 默认索引实体选择视图
	 */
	final static String PREDEFINEDVIEWTYPE_INDEXDEPICKUPVIEW = "INDEXDEPICKUPVIEW";

	/**
	 * 默认多表单选择视图
	 */
	final static String PREDEFINEDVIEWTYPE_FORMPICKUPVIEW = "FORMPICKUPVIEW";

	/**
	 * 默认多选视图
	 */
	final static String PREDEFINEDVIEWTYPE_MPICKUPVIEW = "MPICKUPVIEW";

	/**
	 * 默认多项视图
	 */
	final static String PREDEFINEDVIEWTYPE_MDATAVIEW = "MDATAVIEW";

	/**
	 * 默认流程编辑视图
	 */
	final static String PREDEFINEDVIEWTYPE_WFEDITVIEW = "WFEDITVIEW";

	/**
	 * 默认流程多项视图
	 */
	final static String PREDEFINEDVIEWTYPE_WFMDATAVIEW = "WFMDATAVIEW";

	/**
	 * 默认数据重定向视图
	 */
	public final static String PREDEFINEDVIEWTYPE_REDIRECTVIEW = "REDIRECTVIEW";

	/**
	 * 默认移动端单选视图
	 */
	final static String PREDEFINEDVIEWTYPE_MOBPICKUPVIEW = "MOBPICKUPVIEW";

	/**
	 * 默认移动端编辑视图
	 */
	final static String PREDEFINEDVIEWTYPE_MOBEDITVIEW = "MOBEDITVIEW";

	/**
	 * 默认移动端索引实体选择视图
	 */
	final static String PREDEFINEDVIEWTYPE_MOBINDEXDEPICKUPVIEW = "MOBINDEXDEPICKUPVIEW";

	/**
	 * 默认移动端多表单选择视图
	 */
	final static String PREDEFINEDVIEWTYPE_MOBFORMPICKUPVIEW = "MOBFORMPICKUPVIEW";

	/**
	 * 默认移动端多选视图
	 */
	final static String PREDEFINEDVIEWTYPE_MOBMPICKUPVIEW = "MOBMPICKUPVIEW";

	/**
	 * 默认移动端多项视图
	 */
	final static String PREDEFINEDVIEWTYPE_MOBMDATAVIEW = "MOBMDATAVIEW";

	/**
	 * 默认移动端流程编辑视图
	 */
	final static String PREDEFINEDVIEWTYPE_MOBWFEDITVIEW = "MOBWFEDITVIEW";

	/**
	 * 默认移动端流程多项视图
	 */
	final static String PREDEFINEDVIEWTYPE_MOBWFMDATAVIEW = "MOBWFMDATAVIEW";

	
	/**
	 * 默认移动端数据重定向视图
	 */
	public final static String PREDEFINEDVIEWTYPE_MOBREDIRECTVIEW = "MOBREDIRECTVIEW";
	
	
	/**
	 * 工具栏
	 */
	final static String VIEWCTRLTYPE_TOOLBAR = "TOOLBAR";

	/**
	 * 数据表格
	 */
	final static String VIEWCTRLTYPE_GRID = "GRID";

	/**
	 * 编辑表单
	 */
	final static String VIEWCTRLTYPE_FORM = "FORM";

	/**
	 * 搜索表单
	 */
	final static String VIEWCTRLTYPE_SEARCHFORM = "SEARCHFORM";

	/**
	 * 数据关系栏
	 */
	final static String VIEWCTRLTYPE_DRBAR = "DRBAR";

	/**
	 * 单视图面板
	 */
	final static String VIEWCTRLTYPE_VIEWPANEL = "VIEWPANEL";

	/**
	 * 单选择视图面板
	 */
	final static String VIEWCTRLTYPE_PICKUPVIEWPANEL = "PICKUPVIEWPANEL";

	/**
	 * 数据视图
	 */
	final static String VIEWCTRLTYPE_DATAVIEW = "DATAVIEW";

	/**
	 * 数据关系分页部件
	 */
	final static String VIEWCTRLTYPE_DRTAB = "DRTAB";
	
	
	/**
	 * 移动端多项数据视图
	 */
	final static String VIEWCTRLTYPE_MOBMDCTRL = "MOBMDCTRL";
	

	// 视图打开模式

	/**
	 * 顶级容器分页
	 */
	public final static String OPENMODE_INDEXVIEWTAB = "INDEXVIEWTAB";

	/**
	 * 非模式弹出
	 */
	public final static String OPENMODE_POPUP = "POPUP";

	/**
	 * 模式弹出
	 */
	public final static String OPENMODE_POPUPMODAL = "POPUPMODAL";

	/**
	 * 获取应用
	 * 
	 * @return
	 */
	IApplication getApplication();

	/**
	 * 获取视图类型
	 * 
	 * @return
	 */
	String getViewType();

	/**
	 * 获取指定控件
	 * 
	 * @param strControlName
	 * @return
	 * @throws Exception
	 */
	IControl getControl(String strControlName) throws Exception;

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 */
	IDataEntity getDataEntity();

	/**
	 * 处理请求
	 * 
	 * @param iSRFDAWebContext
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	AjaxActionResult process(IAjaxActionContext iAjaxActionContext) throws Exception;

}
