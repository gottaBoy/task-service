package net.ibizsys.model.app.func;

import net.ibizsys.model.app.IPSApplicationObject;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 应用功能对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSAppFunc extends IPSApplicationObject,IPSModelObject {

	/**
	 * 应用功能类型：打开应用视图
	 */
	static String APPFUNCTYPE_APPVIEW = "APPVIEW";

	/**
	 * 应用功能类型：子应用视图（废弃）
	 */
	static String APPFUNCTYPE_SUBAPPVIEW = "SUBAPPVIEW";

	/**
	 * 应用功能类型：打开HTML页面
	 */
	static String APPFUNCTYPE_OPENHTMLPAGE = "OPENHTMLPAGE";

	/**
	 * 应用功能类型：自定义
	 */
	static String APPFUNCTYPE_CUSTOM = "CUSTOM";

	/**
	 * 应用功能类型：平台预置应用功能
	 */
	static String APPFUNCTYPE_PDTAPPFUNC = "PDTAPPFUNC";

	/**
	 * 应用功能类型：JavaScript 脚本
	 */
	static String APPFUNCTYPE_JAVASCRIPT = "JAVASCRIPT";

	/**
	 * 视图打开方式：应用容器分页
	 */
	public final static String OPENMODE_INDEXVIEWTAB = "INDEXVIEWTAB";

	/**
	 * 视图打开方式：应用容器弹出
	 */
	public final static String OPENMODE_INDEXVIEWPOPUP = "INDEXVIEWPOPUP";

	/**
	 * 视图打开方式：应用容器弹出（模式）
	 */
	public final static String OPENMODE_INDEXVIEWPOPUPMODAL = "INDEXVIEWPOPUPMODAL";

	/**
	 * 视图打开方式：独立网页弹出
	 */
	public final static String OPENMODE_HTMLPOPUP = "HTMLPOPUP";

	

	/**
	 * 获取功能编号
	 * 
	 * @return
	 */
	String getFuncSN();

	/**
	 * 获取应用功能类型，参考：IPSAppFunc.APPFUNCTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getAppFuncType();

	/**
	 * 获取打开的应用视图
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSAppView getPSAppView() throws Exception;

	/**
	 * 获取视图打开方式，参考：IPSAppFunc.OPENMODE_XXX 定义
	 * 
	 * @return
	 */
	String getOpenMode();

	/**
	 * 获取用户数据
	 * 
	 * @return
	 */
	String getUserData();

	/**
	 * 获取用户数据2
	 * 
	 * @return
	 */
	String getUserData2();

	/**
	 * 获取视图宽度
	 * 
	 * @return
	 */
	int getViewWidth();

	/**
	 * 获取视图高度
	 * 
	 * @return
	 */
	int getViewHeight();

	/**
	 * 获取视图标题
	 * 
	 * @return
	 */
	String getViewTitle();

	/**
	 * 获取打开视图参数
	 * 
	 * @return
	 */
	ObjectNode getOpenViewParam();

	/**
	 * 获取功能访问模式
	 * 
	 * @return
	 */
	int getAccUserMode();

	/**
	 * 获取功能访问资源标识
	 * 
	 * @return
	 */
	String getAccessKey();

	/**
	 * 获取平台预置应用功能标识
	 * 
	 * @return
	 */
	String getPSPDTAppFuncId();

	/**
	 * 获取Html页面路径
	 * 
	 * @return
	 */
	String getHtmlPageUrl();

	/**
	 * 获取调用的JS脚本
	 * 
	 * @return
	 */
	String getJSCode();

	/**
	 * 获取名称语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getNamePSLanguageRes();

	/**
	 * 获取提示信息
	 * 
	 * @return
	 */
	String getTooltip();

	/**
	 * 获取提示语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getTooltipPSLanguageRes();
	

}
