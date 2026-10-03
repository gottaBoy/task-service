package net.ibizsys.paas.appmodel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.AppDataAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;

/**
 * 应用程序模型接口
 * 
 * @author lionlau
 *
 */
public interface IApplicationModel extends IApplication,IModelBase3 {
	/**
	 * 下载临时文件
	 */
	final static String UTILPAGE_DOWNLOADTMPFILE = "DOWNLOADTMPFILE";

	/**
	 * 登录路径
	 */
	final static String UTILPAGE_LOGIN = "LOGIN";

	/**
	 * 注销路径
	 */
	final static String UTILPAGE_LOGOUT = "LOGOUT";

	/**
	 * 访问被拒绝
	 */
	final static String UTILPAGE_ACCESSDENY = "ACCESSDENY";

	/**
	 * 系统处理错误
	 */
	final static String UTILPAGE_INTERNALERROR = "INTERNALERROR";
	
	
	/**
	 * 密码过期
	 */
	final static String UTILPAGE_PASSWORDEXPIRED = "PASSWORDEXPIRED";
	
	
	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	ISystemModel getSystemModel();
	

	/**
	 * 获取部件绘制器接口
	 * 
	 * @param strCtrlType 部件类型
	 * @param strRender 绘制器标识
	 * @return
	 */
	ICtrlRender getCtrlRender(String strCtrlType, String strRender);

	/**
	 * 建立HTTP访问上下文对象
	 * 
	 * @param 视图控制器接口
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	IWebContext createWebContext(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * 过滤请求，如果处理，返回true
	 * 
	 * @param iViewController 视图控制器接口
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	boolean doFilter(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * 过滤请求，如果处理，返回true
	 * 
	 * @param page 页面对象
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	boolean doFilter(Page page, HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * 过滤控件的操作
	 * 
	 * @param iViewController 控制器
	 * @param request
	 * @param response
	 * @param strCtrlId 控件标识
	 * @param strAction 请求操作标识
	 * @param iCtrlHandler 控件处理对象
	 * @return
	 * @throws Exception
	 */
	AjaxActionResult doViewCtrlAjaxAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction, ICtrlHandler iCtrlHandler) throws Exception;

	/**
	 * 过滤视图的操作
	 * 
	 * @param iViewController 控制器
	 * @param request
	 * @param response
	 * @param strAction 请求操作标识
	 * @param ajaxActionResult 反馈对象
	 * @return
	 * @throws Exception
	 */
	AjaxActionResult doFilterViewAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strAction, AjaxActionResult ajaxActionResult) throws Exception;

	/**
	 * 获取功能页面路径
	 * 
	 * @param strUtilType 页面类型
	 * @return
	 * @throws Exception
	 */
	String getUtilPageUrl(String strUtilType) throws Exception;

	/**
	 * 安装运行时数据
	 */
	void installRTDatas() throws Exception;

	/**
	 * 注册应用视图
	 * 
	 * @param iAppViewModel 应用视图模型
	 * @throws Exception
	 */
	void registerAppView(IAppViewModel iAppViewModel) throws Exception;

	/**
	 * 获取应用视图
	 * 
	 * @param strAppViewId 应用视图标识
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IAppViewModel getAppView(String strAppViewId, boolean bTryMode) throws Exception;

	/**
	 * 获取应用实体视图
	 * 
	 * @param strDEViewId 实体视图标识
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IAppDEViewModel getAppViewByDEViewId(String strDEViewId, boolean bTryMode) throws Exception;

	/**
	 * 获取应用框架辅助对象
	 * 
	 * @return
	 */
	IAppPFHelper getAppPFHelper();

	/**
	 * 获取指定用户模式的应用菜单模型
	 * 
	 * @param strUserMode 用户模式
	 * @return
	 * @throws Exception
	 */
	IAppMenuModel getAppMenuModel(String strUserMode) throws Exception;

	/**
	 * 注册应用用户模式菜单
	 * 
	 * @param strUserMode 用户模式
	 * @param strAppMenuModelId 菜单模式标识
	 * @throws Exception
	 */
	void registerUserModeMenu(String strUserMode, String strAppMenuModelId) throws Exception;

	/**
	 * 获取视图消息集合
	 * 
	 * @param iViewController 视图控制器
	 * @param iViewMsgGroupModel 视图消息模型
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IViewMessage> getViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel) throws Exception;
	
	
	/**
	 * 获取视图消息集合
	 * 
	 * @param iViewController 视图控制器
	 * @param iViewMsgGroupModel 视图消息模型
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IViewWizard> getViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel,String strQuery) throws Exception;
	
	
	
	/**
	 * 判断用户视图访问
	 * @param iViewController
	 * @param iWebContext
	 * @return
	 */
	boolean testUserViewAccess(IViewController iViewController,IWebContext iWebContext)throws Exception;  
	
	
	
	
	/**
	 * 设置Application插件，继承原功能
	 * @param iApplicationPlugin
	 * @throws Exception
	 */
	void setApplicationPlugin(IApplicationPlugin iApplicationPlugin) throws Exception;
	
	
	/**
	 * 设置Application插件，
	 * @param iApplicationPlugin
	 * @param bResetOrigin 是否重置原插件功能 
	 * @throws Exception
	 */
	void setApplicationPlugin(IApplicationPlugin iApplicationPlugin,boolean bIgnoreOrigin) throws Exception;
	
	
	
	/**
	 * 获取Application插件
	 * @return
	 */
	IApplicationPlugin getApplicationPlugin();
	
	
	
	
	/**
	 * 获取应用程序类型
	 * @return
	 */
	int getAppType();

	
	
	/**
	 * 获取应用目录
	 * @return
	 */
	String getAppFolder();
	
	
	
	
	/**
	 * 填充应用数据异步请求结果对象
	 * @param iViewController
	 * @param AppDataAjaxActionResult
	 * @throws Exception
	 */
	void fillAppDataAjaxActionResult(IViewController iViewController,AppDataAjaxActionResult AppDataAjaxActionResult)throws Exception;
	
	
	
	/**
	 * 登记应用异常
	 * @param logger
	 * @param throwable
	 * @param 额外异常消息
	 * @param 用户标记数据
	 */
	void logException(Object logger,Throwable throwable,String strMessage,Object objUserData);

	
	
	/**
	 * 是否输出表单项允许更新权限控制标识
	 * @return
	 */
	boolean isOutputFormItemUpdatePrivTag();
}
