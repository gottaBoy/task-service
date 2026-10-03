package net.ibizsys.paas.web;

import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IUserPrivilegeMgr;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.util.IGlobalContext;

/**
 * HTTP请求上下文对象接口
 * 
 * @author lionlau
 */
public interface IWebContext {

	/**
	 * 用户标识
	 */
	final public static String PERSONID = "SRFPERSONID";

	/**
	 * 用户标识
	 */
	final public static String USERID = "SRFUSERID";
	
	/**
	 * 用户名称
	 */
	final public static String USERNAME = "SRFUSERNAME";

	/**
	 * 用户图像路径
	 */
	final public static String USERICONPATH = "SRFUSERICONPATH";
	
	
	/**
	 * 用户密码过期
	 */
	final public static String USERPASSWORDEXPIRED = "SRFUSERPASSWORDEXPIRED";
	

	/**
	 * 当前的用户模式
	 */
	final public static String USERMODE = "SRFUSERMODE";
	
	
	/**
	 * 用户名称（错误拼写，后期废弃）
	 */
	@Deprecated
	final public static String UESRNAME = "SRFUESRNAME";

	/**
	 * 用户图像路径（错误拼写，后期废弃）
	 */
	@Deprecated
	final public static String UESRICONPATH = "SRFUESRICONPATH";

	/**
	 * 当前的用户模式（错误拼写，后期废弃）
	 */
	@Deprecated
	final public static String UESRMODE = "SRFUESRMODE";
	
	

	/**
	 * 登录名称
	 */
	public final static String LOGINNAME = "SRFLOGINNAME";

	/**
	 * 超级用户模式
	 */
	public final static String SUPERUSER = "SRFSUPERUSER";

	/**
	 * 组织管理员
	 */
	public final static String ORGADMIN = "SRFORGADMIN";

	/**
	 * 本地化
	 */
	public final static String LOCALIZATION = "SRFLOCALIZATION";

	/**
	 * 本地化（Spring变量）
	 */
	public final static String LOCALE = "SRFLOCALE";
	
	/**
	 * 当前用户时区标识
	 */
	public final static String TIMEZONE = "SRFTIMEZONE";

	/**
	 * 当前用户组织标识
	 */
	public final static String ORGID = "SRFORGID";

	/**
	 * 当前用户组织名称
	 */
	public final static String ORGNAME = "SRFORGNAME";

	/**
	 * 当前用户组织部门标识
	 */
	public final static String ORGSECTORID = "SRFORGSECTORID";

	/**
	 * 当前用户组织部门名称
	 */
	public final static String ORGSECTORNAME = "SRFORGSECTORNAME";

	/**
	 * 当前用户条线代码
	 */
	public final static String ORGSECTORBC = "SRFORGSECTORBC";

	/**
	 * 用户权限管理器
	 */
	public final static String USERPRIVILEGEMGR = "SRFUSERPRIVILEGEMGR";

	/**
	 * 用户代码表管理器
	 */
	public final static String USERCODELISTMGR = "SRFUSERCODELISTMGR";

	/**
	 * 用户角色权限管理对象
	 */
	public final static String USERROLEMGR = "SRFUSERROLEMGR";

	/**
	 * 当前的用户流程模式
	 */
	final public static String WFMODE = "SRFWFMODE";
	
	
	/**
	 * 当前用户动态系统实例标识
	 */
	public final static String DYNASYSINSTID = "SRFDYNASYSINSTID";
	

	

	/**
	 * 初始化
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws Exception
	 */
	void init(HttpServletRequest arg0, HttpServletResponse arg1, ServletContext arg2) throws Exception;

	/**
	 * 获取当前用户名称
	 * 
	 * @return
	 */
	String getCurUserName();

	/**
	 * 获取当前用户标识
	 * 
	 * @return
	 */
	String getCurUserId();

	/**
	 * 获取当前组织单元标识
	 * 
	 * @return
	 */
	String getCurOrgSectorId();

	/**
	 * 获取当前组织单元名称
	 * 
	 * @return
	 */
	String getCurOrgSectorName();

	/**
	 * 获取当前条线代码
	 * 
	 * @return
	 */
	String getCurOrgSectorBC();

	/**
	 * 获取当前组织标识
	 * 
	 * @return
	 */
	String getCurOrgId();

	/**
	 * 获取当前组织名称
	 * 
	 * @return
	 */
	String getCurOrgName();

	/**
	 * 获取当前用户的时区
	 * 
	 * @return
	 */
	TimeZone getCurTimeZone();

	/**
	 * 获取远端地址
	 * 
	 * @return
	 */
	String getRemoteAddr();

	/**
	 * 获取实际远端地址
	 * 
	 * @return
	 */
	String getRealRemoteAddr();

	/**
	 * 获取远端客户端信息
	 * 
	 * @return
	 */
	String getUserAgent();

	/**
	 * 获取会话标识
	 * 
	 * @return
	 */
	String getSessionId();

	/**
	 * 获取Session值
	 * 
	 * @param strKey
	 * @param bSerializable 值支持序列化
	 * @return
	 */
	Object getSessionValue(String strKey, boolean bSerializable);

	/**
	 * 获取Session值
	 * 
	 * @param strKey
	 * @return
	 */
	Object getSessionValue(String strKey);

	/**
	 * 设置Session值
	 * 
	 * @param strKey
	 * @param objValue
	 */
	void setSessionValue(String strKey, Object objValue);

	/**
	 * 设置Session值
	 * 
	 * @param strKey
	 * @param objValue
	 * @param bSerializable 值支持序列化
	 */
	void setSessionValue(String strKey, Object objValue, boolean bSerializable);

	/**
	 * 获取Global值
	 * 
	 * @param strKey
	 * @return
	 */
	Object getGlobalValue(String strKey);

	/**
	 * 设置Global值
	 * 
	 * @param strKey
	 * @param objValue
	 */
	void setGlobalValue(String strKey, Object objValue);

	/**
	 * 获取全局上下文对象
	 * 
	 * @return
	 */
	IGlobalContext getGlobalContext();

	/**
	 * 获取URL参数
	 * 
	 * @param strParamName
	 * @return
	 */
	String getParamValue(String strParamName);

	/**
	 * 获取cookie值
	 * 
	 * @param strParamName 参数名称
	 * @return
	 */
	String getCookieValue(String strParamName);

	/**
	 * 设置cookie值
	 * 
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 有效时间
	 */
	void setCookieValue(String name, String value,int maxAge);

	/**
	 * 设置URL参数
	 * 
	 * @param strParamName
	 * @param strParamValue
	 */
	void setParamValue(String strParamName, String strParamValue);

	/**
	 * 移除URL参数
	 * 
	 * @param strParamName
	 */
	void removeParam(String strParamName);

	/**
	 * 获取当前用户模式
	 * 
	 * @return
	 */
	String getCurUserMode();

	/**
	 * 获取POST数据（参数名称会自动转为小写）
	 * 
	 * @param strParamName
	 * @return
	 */
	String getPostValue(String strParamName);

	/**
	 * 获取提交的数组值（参数名称会自动转为小写）
	 * 
	 * @param strParamName
	 * @return
	 */
	String[] getPostValues(String strParamName);

	/**
	 * 获取本地化语言
	 * 
	 * @return
	 */
	String getLocalization();

	/**
	 * 获取查询字符串
	 * 
	 * @return
	 */
	String getQueryString();

	/**
	 * 获取指定语言资源的本地化语言
	 * 
	 * @param strResId
	 * @param strDefault
	 * @return
	 */
	String getLocalization(String strResId, String strDefault);

	/**
	 * 获取指定语言资源的本地化语言
	 * 
	 * @param strResId
	 * @param params 参数结合
	 * @param strDefault
	 * @return
	 */
	String getLocalization(String strResId, Object[] params, String strDefault);
	
	
	/**
	 * 获取指定语言资源的本地化语言
	 * 
	 * @param strResId
	 * @param strDefault
	 * @param locale 所在区域
	 * @return
	 */
	String getLocalization(String strResId, String strDefault,Locale locale);

	/**
	 * 获取指定语言资源的本地化语言
	 * 
	 * @param strResId
	 * @param params 参数结合
	 * @param strDefault
	 * @param locale 所在区域
	 * @return
	 */
	String getLocalization(String strResId, Object[] params, String strDefault,Locale locale);
	

	/**
	 * 获取参数集合
	 * 
	 * @return
	 */
	Map<String, String> getParams();

	/**
	 * 设置当前的页面路径，带目录
	 * 
	 * @return
	 */
	String getCurPagePath();

	/**
	 * 获取查询串的键值（可指定排除值），使用[|]分割要排除的键值
	 * 
	 * @param strParams
	 * @return
	 */
	String getQueryStringWithout(String strParams);

	/**
	 * 获取当前的异步请求结果
	 * 
	 * @return
	 */
	AjaxActionResult getCurAjaxActionResult();

	/**
	 * 设置当前的异步请求结果
	 * 
	 * @param ajaxActionResult
	 */
	void setCurAjaxActionResult(AjaxActionResult ajaxActionResult);

	/**
	 * 获取用户权限管理对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IUserPrivilegeMgr getUserPrivilegeMgr() throws Exception;

	/**
	 * 获取用户角色管理对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IUserRoleMgr getUserRoleMgr() throws Exception;

	/**
	 * 获取当前的系统
	 * 
	 * @return
	 */
	ISystem getCurSystem();

	/**
	 * 获取当前的应用程序
	 * 
	 * @return
	 */
	IApplication getCurApplication();

	/**
	 * 获取请求对象
	 * 
	 * @return
	 */
	HttpServletRequest getRequest();

	/**
	 * 获取输出对象
	 * 
	 * @return
	 */
	HttpServletResponse getResponse();

	/**
	 * 登录
	 * 
	 * @param 登录名称
	 */
	void login(String strLoginName) throws Exception;

	/**
	 * 远程登录
	 * 
	 * @param iEntity LoginLog 数据对象
	 * @throws Exception
	 */
	void remoteLogin(IEntity iEntity) throws Exception;

	/**
	 * 登出
	 */
	void logout();

	/**
	 * 执行注销操作
	 * 
	 * @param bReleaseSession 是否释放Session对象
	 */
	void logout(boolean bReleaseSession);

	/**
	 * 获取当前用户是否为超级用户
	 * 
	 * @return
	 */
	boolean isSuperUser();

	/**
	 * 获取Session对象
	 * 
	 * @return
	 */
	HttpSession getSession();

	/**
	 * 获取通过Post或是Url请求的参数，Post优先
	 * 
	 * @param strParamName
	 * @return
	 */
	String getPostOrParamValue(String strParamName);

	/**
	 * 获取应用数据指定属性值
	 * 
	 * @param strParamName
	 * @return
	 */
	String getAppDataValue(String strParamName);

	/**
	 * 获取视图参数指定属性值
	 * 
	 * @param strParamName
	 * @return
	 */
	String getViewParamValue(String strParamName);

	/**
	 * 获取当前登录名称
	 * 
	 * @return
	 */
	String getCurLoginName();

	/**
	 * 获取用户代码表对象
	 * 
	 * @param iCodeList
	 * @return
	 * @throws Exception
	 */
	ICodeList getUserCodeList(ICodeList iCodeList) throws Exception;

	/**
	 * 获取当前的视图控制器
	 * 
	 * @return
	 */
	IViewController getViewController();

	/**
	 * 是否为当前机构管理员
	 * 
	 * @return
	 */
	boolean isOrgAdmin();

	/**
	 * 获取属性值
	 * 
	 * @param strName
	 * @return
	 */
	Object getAttribute(String strName);

	/**
	 * 设置属性值
	 * 
	 * @param strName
	 * @param objValue
	 */
	void setAttribute(String strName, Object objValue);

	/**
	 * 获取当前用户头像图表路径
	 * 
	 * @return
	 */
	String getCurUserIconPath();

	/**
	 * 获取当前用户的流程模式
	 * 
	 * @return
	 */
	String getWFMode();

	
	
	/**
	 * 获取JAVA本地化对象
	 * @return
	 */
	Locale getLocale();
	
	
	/**
	 * 获取当前用是否密码过期
	 * 
	 * @return
	 */
	boolean isCurUserPasswordExpired();
}
