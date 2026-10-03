package net.ibizsys.paas.controller;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.web.IWebContext;

/**
 * 视图控制器接口
 * 
 * @author lionlau
 *
 */
public interface IViewController {
	
	/**
	 * 视图后台请求：加载视图模型
	 */
	public static String VIEWACTION_LOADMODEL = "loadmodel";

	/**
	 * 视图后台请求：查询视图消息
	 */
	public static String VIEWACTION_FETCHMSG = "fetchmsg";
	
	/**
	 * 视图后台请求：查询视图向导
	 */
	public static String VIEWACTION_FETCHWIZARD = "fetchwizard";
	
	/**
	 * 视图后台请求：获取应用上下文数据
	 */
	public static String VIEWACTION_LOADAPPDATA = "loadappdata";
	
	
	/**
	 * 用户界面行为处理
	 */
	final static String VIEWACTION_UIACTION = "uiaction";

	/**
	 * 加载运行时界面行为模型
	 */
	final static String VIEWACTION_LOADUIACTION = "loaduiaction";
	
	
	/**
	 * 获取视图控制器标识
	 * 
	 * @return
	 */
	String getId();

	/**
	 * 获取当前访问上下文
	 * 
	 * @return
	 */
	IWebContext getWebContext();

	/**
	 * 准备视图控制器
	 * 
	 * @throws Exception
	 */
	void prepareViewController() throws Exception;


	/**
	 * 是否已经准备视图
	 * 
	 * @return
	 */
	boolean isPrepareViewController();

	/**
	 * 获取应用程序模型
	 * 
	 * @return
	 */
	IApplicationModel getAppModel();

	/**
	 * 获取系统模型
	 * 
	 * @return
	 */
	ISystemModel getSystemModel();

	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	IDataEntityModel getDEModel();

	/**
	 * 注册控件模型
	 * 
	 * @param strCtrlId 控件标识
	 * @param iCtrlModel 控件模型
	 * @throws Exception
	 */
	void registerCtrlModel(String strCtrlId, ICtrlModel iCtrlModel) throws Exception;

	/**
	 * 注册控件处理对象
	 * 
	 * @param strCtrlId 控件标识
	 * @param iCtrlHandler 控件处理器
	 * @throws Exception
	 */
	void registerCtrlHandler(String strCtrlId, ICtrlHandler iCtrlHandler) throws Exception;

	/**
	 * 获取控件模型
	 * 
	 * @param strName 控件名称
	 * @return
	 * @throws Exception
	 */
	ICtrlModel getCtrlModel(String strName) throws Exception;

	/**
	 * 获取控件处理对象
	 * 
	 * @param strName 控件名称
	 * @return
	 * @throws Exception
	 */
	ICtrlHandler getCtrlHandler(String strName) throws Exception;

	/**
	 * 获取服务对象
	 * 
	 * @return
	 */
	IService getService();

	/**
	 * 是否为拾取视图
	 * 
	 * @return
	 */
	boolean isPickupView();

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */
	void setSessionFactory(SessionFactory sessionFactory);

	/**
	 * 获取会话工厂
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory();

	/**
	 * 获取视图标题
	 * 
	 * @return
	 */
	String getCaption();
	
	
	/**
	 * 获取视图标题
	 * @bLocale 是否本地化
	 *  
	 * @return
	 */
	String getCaption(boolean bLocale);
	

	/**
	 * 获取视图抬头
	 * 
	 * @return
	 */
	String getTitle();

	/**
	 * 获取视图子标题
	 * 
	 * @return
	 */
	String getSubCaption();
	
	
	/**
	 * 获取视图抬头
	 * @bLocale 是否本地化
	 * @return
	 */
	String getTitle(boolean bLocale);

	/**
	 * 获取视图子标题
	 * @bLocale 是否本地化
	 * @return
	 */
	String getSubCaption(boolean bLocale);
	

	/**
	 * 获取视图属性
	 * 
	 * @param strKey
	 * @return
	 */
	Object getAttribute(String strKey) throws Exception;

	/**
	 * 获取boolean 视图属性
	 * 
	 * @param strKey
	 * @param bDefault 默认值
	 * @return
	 */
	boolean getAttribute(String strKey, boolean bDefault) throws Exception;

	/**
	 * 获取String 视图属性
	 * 
	 * @param strKey
	 * @param strDefault 默认值
	 * @return
	 */
	String getAttribute(String strKey, String strDefault) throws Exception;

	/**
	 * 获取Integer 视图属性
	 * 
	 * @param strKey
	 * @param nDefault 默认值
	 * @return
	 */
	int getAttribute(String strKey, int nDefault) throws Exception;

	/**
	 * 获取Double 视图属性
	 * 
	 * @param strKey
	 * @param fDefault 默认值
	 * @return
	 */
	double getAttribute(String strKey, double fDefault) throws Exception;

	/**
	 * 设置视图属性
	 * 
	 * @param strKey
	 * @param objValue
	 */
	void setAttribute(String strKey, Object objValue) throws Exception;

	/**
	 * 获取视图的访问用户模式，值参考 net.ibizsys.paas.security.AccessUserModes
	 * 
	 * @return
	 */
	int getAccessUserMode();

	/**
	 * 获取视图的访问标识，在视图访问模式为 AccessUserModes.LOGINUSERWITHKEY 时进一步获取访问标识
	 * 
	 * @return
	 */
	String getAccessKey();

	/**
	 * 获取视图的主数据状态
	 * 
	 * @return
	 */
	String getMSTag();

	/**
	 * 获取视图消息组标识
	 * 
	 * @return
	 */
	String getViewMsgGroupId();

	/**
	 * 获取界面行为集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<String> getUIActions() throws Exception;

	/**
	 * 获取视图中对应实体的界面访问行为
	 * 
	 * @return
	 */
	java.util.Iterator<String> getDEDataAccessActions(String strDEName);
	
	
	/**
	 * 获取视图向导组标识
	 * 
	 * @return
	 */
	String getViewWizardGroupId();

	
	
	/**
	 * 测试是否可以访问此页面
	 * @param iWebContext
	 * @param bSendResult 如不通过，以JSON形式返回结果到客户端
	 * @return
	 * @throws Exception
	 */
	boolean testUserAccess(IWebContext iWebContext,boolean bSendResult) throws Exception ;
	
	
	
	/**
	 * 测试是否可以访问此页面（返回不通过结果）
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	boolean testUserAccess(IWebContext iWebContext) throws Exception ;
	
	
	
	/**
	 * 获取标题语言资源标识
	 * @return
	 */
	String getCapLanResTag();
	
	
	
	/**
	 * 获取子标题语言资源标识
	 * @return
	 */
	String getSubCapLanResTag();
	
	
	/**
	 * 获取抬头语言资源标识
	 * @return
	 */
	String getTitleLanResTag();
	
	
	
	/**
	 * 获取视图的实体数据访问行为能力
	 * @param iDataEntityModel
	 * @param object 数据对象
	 * @param strAction
	 * @param bCache
	 * @return
	 * @throws Exception
	 */
	CallResult testDEDataAccessAction(IDataEntityModel iDataEntityModel,Object object, String strAction, boolean bCache)throws Exception;

	
	
	
}
