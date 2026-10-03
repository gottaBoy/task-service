package net.ibizsys.paas.web;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.security.IUserRoleMgr2;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.sf.json.JSONObject;

/**
 * 网络访问上下文基类，当前对象主要提供了大量的预置静态方法
 * 
 * @author lionlau
 *
 */
public abstract class WebContextBase {
	private static ThreadLocal<IWebContext> webContext = new ThreadLocal<IWebContext>();
	private static ThreadLocal<JSONObject> activeData = new ThreadLocal<JSONObject>();
	private static ThreadLocal<JSONObject> referData = new ThreadLocal<JSONObject>();
	private static ThreadLocal<JSONObject> parentData = new ThreadLocal<JSONObject>();
	private static ThreadLocal<JSONObject> appData = new ThreadLocal<JSONObject>();
	private static ThreadLocal<JSONObject> viewParam = new ThreadLocal<JSONObject>();

	/**
	 * 父数据类型
	 */
	public final static String PARAM_PARENTTYPE = "SRFPARENTTYPE";

	/**
	 * 父数据键值
	 */
	public final static String PARAM_PARENTKEY = "SRFPARENTKEY";

	/**
	 * 父数据键值2
	 */
	public final static String PARAM_PARENTKEY2 = "SRFPARENTKEY2";

	/**
	 * 源数据键值
	 */
	public final static String PARAM_SOURCEKEY = "SRFSOURCEKEY";

	/**
	 * 请求的键值清单，多个
	 */
	public final static String PARAM_KEYS = "SRFKEYS";

	/**
	 * 请求的键值
	 */
	public final static String PARAM_KEY = "SRFKEY";

	/**
	 * 请求的临时数据键值
	 */
	public final static String PARAM_TEMPKEY = "SRFTEMPKEY";

	/**
	 * 1：N关系标识
	 */
	public final static String PARAM_DER1NID = "SRFDER1NID";

	/**
	 * 索引关系标识
	 */
	public final static String PARAM_DERINDEXID = "SRFDERINDEXID";

	/**
	 * 1:1关系标识
	 */
	public final static String PARAM_DER11ID = "SRFDER11ID";

	/**
	 * 过滤器标识
	 */
	public final static String PARAM_FILTER = "SRFFILTER";

	/**
	 * 快速搜索内容
	 */
	public final static String PARAM_QUICKSEARCH = "SRFQUICKSEARCH";

	/**
	 * 应用程序标识
	 */
	public final static String PARAM_APPID = "SRFAPPID";

	/**
	 * 视图标识
	 */
	public final static String PARAM_VIEWID = "SRFVIEWID";
	
	
	/**
	 * 视图模式
	 */
	public final static String PARAM_VIEWMODE = "SRFVIEWMODE";
	
	
	/**
	 * 视图实体标识
	 */
	public final static String PARAM_VIEWDEID = "SRFVIEWDEID";
	
	/**
	 * 视图工作流标识
	 */
	public final static String PARAM_VIEWWFID = "SRFVIEWWFID";
	
	
	/**
	 * 代码表标识
	 */
	public final static String PARAM_CODELISTID = "SRFCODELISTID";

	/**
	 * 表单项标识
	 */
	public final static String PARAM_FORMITEMID = "SRFFORMITEMID";

	/**
	 * 控件标识
	 */
	public final static String PARAM_CTRLID = "SRFCTRLID";

	/**
	 * 计数器标识
	 */
	public final static String PARAM_COUNTERID = "SRFCOUNTERID";

	/**
	 * 计数器参数
	 */
	public final static String PARAM_COUNTERPARAM = "SRFCOUNTERPARAM";

	/**
	 * 请求操作
	 */
	public final static String PARAM_ACTION = "SRFACTION";

	/**
	 * 当前容器标识
	 */
	public final static String PARAM_CONTAINERID = "SRFCID";

	/**
	 * 当前容器级别
	 */
	public final static String PARAM_CONTAINERLEVEL = "SRFCLEVEL";

	/**
	 * 绘制器
	 */
	public final static String PARAM_RENDER = "SRFRENDER";

	/**
	 * 当前实体编号
	 */
	public final static String PARAM_DEID = "srfdeid";

	/**
	 * 父实体编号
	 */
	public final static String PARAM_PARENTDEID = "srfparentdeid";

	/**
	 * 流程步骤值
	 */
	public final static String PARAM_WFSTEP = "srfwfstep";

	/**
	 * 流程业务数据状态
	 */
	public final static String PARAM_WFUDSTATE = "srfwfudstate";

	/**
	 * 流程数据状态
	 */
	public final static String PARAM_WFSTATE = "srfwfstate";

	/**
	 * 流程交互标识
	 */
	public final static String PARAM_WFIATAG = "srfwfiatag";

	/**
	 * 流程处理意见
	 */
	public final static String PARAM_WFMEMO = "srfwfmemo";

	/**
	 * 界面行为标识
	 */
	public final static String PARAM_UIACTIONID = "SRFUIACTIONID";

	/**
	 * 附加的提取数据条件
	 */
	public final static String PARAM_FETCHCOND = "SRFFETCHCOND";

	/**
	 * 获取当前数据
	 */
	public final static String PARAM_ACTIVEDATA = "SRFACTIVEDATA";

	/**
	 * 获取当前引用数据
	 */
	public final static String PARAM_REFERDATA = "SRFREFERDATA";

	/**
	 * 获取当前引用项
	 */
	public final static String PARAM_REFERITEM = "SRFREFERITEM";

	/**
	 * 获取当前父数据
	 */
	public final static String PARAM_PARENTDATA = "SRFPARENTDATA";

	/**
	 * 获取当前父数据
	 */
	public final static String PARAM_PARENTMODE = "SRFPARENTMODE";

	/**
	 * 当前应用数据
	 */
	public final static String PARAM_APPDATA = "SRFAPPDATA";

	/**
	 * 视图处于IFrame子视图模式
	 */
	public final static String PARAM_IFCHILD = "SRFIFCHILD";

	/**
	 * 父类型 DER1N
	 */
	public final static String PARAM_PARENTTYPE_DER1N = "DER1N";

	/**
	 * 系统DER1N SYSDER1N
	 */
	public final static String PARAM_PARENTTYPE_SYSDER1N = "SYSDER1N";

	/**
	 * 父类型 DER11
	 */
	public final static String PARAM_PARENTTYPE_DER11 = "DER11";

	/**
	 * 系统DER1N SYSDER11
	 */
	public final static String PARAM_PARENTTYPE_SYSDER11 = "SYSDER11";

	/**
	 * 临时数据
	 */
	public final static String PARAM_TEMPMODE = "SRFTEMPMODE";

	/**
	 * 表单项更新模式
	 */
	public final static String PARAM_UFIMODE = "SRFUFIMODE";

	/**
	 * 树节点选择
	 */
	public final static String PARAM_NODESELECT = "SRFNODESELECT";

	/**
	 * 树节点标识
	 */
	public final static String PARAM_NODEID = "SRFNODEID";
	
	/**
	 * 树节点类型
	 */
	public final static String PARAM_NODETYPE = "SRFNODETYPE";

	
	/**
	 * 通用界面项标识
	 */
	public final static String PARAM_ITEMID = "SRFITEMID";
	
	/**
	 * 通用界面项类型
	 */
	public final static String PARAM_ITEMTYPE = "SRFITEMTYPE";
	
	
	/**
	 * 远程调用
	 */
	public final static String PARAM_CALL = "SRFCALL";

	/**
	 * 远程调用参数
	 */
	public final static String PARAM_CALLARG = "SRFCALLARG";

	/**
	 * 调用返回包括空值
	 */
	public final static String PARAM_CALLRETINCEMPTY = "SRFCALLRETINCEMPTY";

	/**
	 * 调用返回时间格式
	 */
	public final static String PARAM_CALLRETTIMEFMT = "SRFCALLRETTIMEFMT";

	/**
	 * 远程登录键值
	 */
	public final static String PARAM_LOGINKEY = "SRFLOGINKEY";

	/**
	 * 当前流程编号
	 */
	public final static String PARAM_WFID = "SRFWFID";

	/**
	 * 获取数据导入模式
	 */
	public final static String PARAM_DEDATAIMPORT = "SRFDEDATAIMPORT";

	/**
	 * 获取当前视图参数
	 */
	public final static String PARAM_VIEWPARAM = "SRFVIEWPARAM";

	/**
	 * 获取打印标识
	 */
	public final static String PARAM_PRINTID = "SRFPRINTID";

	/**
	 * 获取报表标识
	 */
	public final static String PARAM_REPORTID = "SRFREPORTID";
	
	
	/**
	 * 所在地点
	 */
	public final static String PARAM_LOCALE = "SRFLOCALE";
	
	
	/**
	 * 重新加载
	 */
	public final static String PARAM_RELOAD = "SRFRELOAD";
	
	
	/**
	 * 获取原来主键
	 */
	public final static String PARAM_ORIKEY = "srforikey";

	
	/**
	 * 请求操作数据
	 */
	public final static String PARAM_ACTIONDATA = "SRFACTIONDATA";
	
	
	
	/**
	 * 获取应用模式
	 */
	final public static String PARAM_APPMODE = "SRFAPPMODE";
	
	/**
	 * 实际的远端地址
	 */
	public final static String HEADER_REALIP = "X-Real-IP";

	/**
	 * 当前容器标识取值规则，规则为：半角大小写英文、半角数字和_
	 */
	public final static String PARAM_CONTAINERID_REGEX = "^\\w+$";

	/**
	 * 编码Url变量
	 * 
	 * @param strValue
	 * @return
	 */
	public static String encodeURLParamValue(String strValue) {
		try {
			return java.net.URLEncoder.encode(strValue, "UTF-8");
		} catch (Exception ex) {
			return strValue;
		}
	}

	
	/**
	 * 获取上下文对象
	 * @param 是否必须存在
	 * @return
	 */
	public static IWebContext getCurrent(boolean bMust)throws Exception {
		IWebContext iWebContext = webContext.get();
		if(iWebContext == null && bMust){
			throw new Exception("用户请求上下文对象无效");
		}
		return iWebContext;
	}
		
	
	/**
	 * 获取上下文对象
	 * 
	 * @return
	 */
	public static IWebContext getCurrent() {
		return webContext.get();
	}

	/**
	 * 设置上下文对象
	 * 
	 * @param value
	 */
	public static void setCurrent(IWebContext value) {
		webContext.set(value);
		activeData.set(null);
		appData.set(null);
		referData.set(null);
		parentData.set(null);
		viewParam.set(null);
	}

	/**
	 * 获取父数据类型
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getParentType(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_PARENTTYPE);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_PARENTTYPE);
	}

	
	
	
	
	/**
	 * 获取父数据键值
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getParentKey(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_PARENTKEY);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_PARENTKEY);
	}
	
	
	/**
	 * 获取父数据键值
	 * @return
	 */
	public static String getParentKey() {
		return getParentKey(WebContext.getCurrent());
	}


	/**
	 * 获取父数据键值2
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getParentKey2(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_PARENTKEY2);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_PARENTKEY2);
	}
	
	/**
	 * 获取父数据键值2
	 * @return
	 */
	public static String getParentKey2() {
		return getParentKey2(WebContext.getCurrent());
	}

	/**
	 * 获取源值
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getSourceKey(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_SOURCEKEY);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_SOURCEKEY);
	}

	/**
	 * 获取请求的键值清单
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getKeys(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_KEYS);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_KEYS);
	}

	/**
	 * 获取请求的键值
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getKey(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_KEY);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_KEY);
	}

	/**
	 * 获取请求的1：N关系标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getDER1NId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_DER1NID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_DER1NID);
	}

	/**
	 * 获取请求的控件标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getCtrlId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_CTRLID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_CTRLID);
	}
	
	/**
	 * 获取请求的控件标识
	 * 
	 * @param iWebContext
	 * @param bPostOnly
	 * @return
	 */
	public static String getCtrlId(IWebContext iWebContext,boolean bPostOnly) {
		String strValue = iWebContext.getPostValue(PARAM_CTRLID);
		if (strValue != null) return strValue;
		if(bPostOnly)
			return strValue;
		return iWebContext.getParamValue(PARAM_CTRLID);
	}

	/**
	 * 获取请求的计数器标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getCounterId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_COUNTERID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_COUNTERID);
	}

	/**
	 * 获取请求的计数器参数
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getCounterParam(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_COUNTERPARAM);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_COUNTERPARAM);
	}

	/**
	 * 获取请求行为
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getAction(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_ACTION);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_ACTION);
	}

	
	/**
	 * 获取请求行为
	 * @param iWebContext
	 * @param bPostOnly 
	 * @return
	 */
	public static String getAction(IWebContext iWebContext,boolean bPostOnly) {
		String strValue = iWebContext.getPostValue(PARAM_ACTION);
		if (strValue != null) return strValue;
		if(bPostOnly)
			return strValue;
		return iWebContext.getParamValue(PARAM_ACTION);
	}
	
	
	/**
	 * 获取请求的索引关系标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getDERIndexId(IWebContext iWebContext) {
		return iWebContext.getParamValue(PARAM_DERINDEXID);
	}

	/**
	 * 获取请求的过滤器内容
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getFilter(IWebContext iWebContext) {
		return iWebContext.getParamValue(PARAM_FILTER);
	}

	/**
	 * 获取请求的应用程序标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getAppId(IWebContext iWebContext) {
		return iWebContext.getParamValue(PARAM_APPID);
	}

	/**
	 * 获取请求的视图标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getAppViewId(IWebContext iWebContext) {
		return iWebContext.getParamValue(PARAM_VIEWID);
	}
	
	
	/**
	 * 获取请求的视图模式
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getAppViewMode(IWebContext iWebContext) {
		return iWebContext.getParamValue(PARAM_VIEWMODE);
	}
	
	
	
	/**
	 * 获取请求的视图实体标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getAppViewDEId(IWebContext iWebContext) {
		return iWebContext.getParamValue(PARAM_VIEWDEID);
	}

	/**
	 * 获取请求的视图工作流标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getAppViewWFId(IWebContext iWebContext) {
		return iWebContext.getParamValue(PARAM_VIEWWFID);
	}
	

	/**
	 * 获取请求的代码表标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getCodeListId(IWebContext iWebContext) {
		return iWebContext.getParamValue(PARAM_CODELISTID);
	}

	/**
	 * 获取请求的表单项标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getFormItemId(IWebContext iWebContext) {
		return iWebContext.getParamValue(PARAM_FORMITEMID);
	}

	/**
	 * 获取请求的界面行为标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getUIActionId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_UIACTIONID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_UIACTIONID);
	}

	/**
	 * 获取请求的搜索条件
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getFetchCond(IWebContext iWebContext) {
		return iWebContext.getPostValue(PARAM_FETCHCOND);
	}

	/**
	 * 获取请求的当前数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getActiveData() throws Exception {
		return getActiveData(WebContextBase.getCurrent());
	}

	/**
	 * 获取请求的当前数据
	 * 
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getActiveData(IWebContext iWebContext) throws Exception {
		JSONObject dataObject = activeData.get();
		if (dataObject == null) {
			String strActiveData = iWebContext.getPostValue(PARAM_ACTIVEDATA);
			if (!StringHelper.isNullOrEmpty(strActiveData)) {
				dataObject = JSONObjectHelper.fromString(strActiveData);
				activeData.set(dataObject);
			}
		}
		return dataObject;
	}
	
	
	/**
	 * 设置当前上下文引用数据
	 * @param dataObject
	 */
	public static void setActiveData(JSONObject dataObject ){
		activeData.set(dataObject);
	}
	
	
	

	/**
	 * 获取当前上下文应用数据
	 * 
	 * @return
	 */
	public static JSONObject getAppData() {
		return getAppData(WebContextBase.getCurrent());
	}

	/**
	 * 获取当前上下文应用数据
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static JSONObject getAppData(IWebContext iWebContext) {
		JSONObject dataObject = appData.get();
		if (dataObject == null && iWebContext!=null) {
			String strAppData = iWebContext.getPostValue(PARAM_APPDATA);
			if (!StringHelper.isNullOrEmpty(strAppData)) {
				strAppData = new String(Base64Helper.decode(strAppData));
				dataObject = JSONObjectHelper.fromString(strAppData);
				appData.set(dataObject);
			}
		}
		return dataObject;
	}
	
	/**
	 * 设置当前应用数据
	 * @param dataObject
	 */
	public static void setAppData(JSONObject dataObject ){
		appData.set(dataObject);
	}

	/**
	 * 获取当前上下文引用数据
	 * 
	 * @return
	 */
	public static JSONObject getReferData() {
		return getReferData(WebContextBase.getCurrent());
	}

	/**
	 * 获取当前上下文引用数据
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static JSONObject getReferData(IWebContext iWebContext) {
		JSONObject dataObject = referData.get();
		if (dataObject == null) {
			String strReferData = iWebContext.getPostValue(PARAM_REFERDATA);
			if (!StringHelper.isNullOrEmpty(strReferData)) {
				dataObject = JSONObjectHelper.fromString(strReferData);
				referData.set(dataObject);
			}
		}
		return dataObject;
	}
	
	
	/**
	 * 设置当前上下文引用数据
	 * @param dataObject
	 */
	public static void setReferData(JSONObject dataObject ){
		referData.set(dataObject);
	}


	
	/**
	 * 获取请求的父数据对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getParentData() throws Exception {
		return getParentData(WebContextBase.getCurrent());
	}

	/**
	 * 获取请求的父数据对象
	 * 
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getParentData(IWebContext iWebContext) throws Exception {
		JSONObject dataObject = parentData.get();
		if (dataObject == null) {
			String strParentData = iWebContext.getPostValue(PARAM_PARENTDATA);
			if (!StringHelper.isNullOrEmpty(strParentData)) {
				dataObject = JSONObjectHelper.fromString(strParentData);
				parentData.set(dataObject);
			} else {
				String strParentType = WebContext.getParentType(iWebContext);
				String strParentKey = WebContext.getParentKey(iWebContext);
				String strParentDEId = WebContext.getParentDEId(iWebContext);
				if (!StringHelper.isNullOrEmpty(strParentType) && !StringHelper.isNullOrEmpty(strParentKey) && !StringHelper.isNullOrEmpty(strParentDEId)) {
					dataObject = new JSONObject();
					dataObject.put("srfparentkey", JSONObjectHelper.stripQuotes(strParentKey,true));
					dataObject.put("srfparentdeid", JSONObjectHelper.stripQuotes(strParentDEId,true));
					dataObject.put("srfparenttype", JSONObjectHelper.stripQuotes(strParentType,true));
					parentData.set(dataObject);
				}
			}
		}
		return dataObject;
	}

	/**
	 * 获取获取数据的起始行数
	 * 
	 * @param iWebContext
	 * @param nDefault
	 * @return
	 */
	public static int getFetchStart(IWebContext iWebContext, int nDefault) {
		String strStart = iWebContext.getPostValue("start");
		if (StringHelper.isNullOrEmpty(strStart)) return nDefault;
		return Integer.parseInt(strStart);
	}

	/**
	 * 获取获取数据的分页行数
	 * 
	 * @param iWebContext
	 * @param nDefault
	 * @return
	 */
	public static int getFetchSize(IWebContext iWebContext, int nDefault) {
		String strSize = iWebContext.getPostValue("limit");
		if (StringHelper.isNullOrEmpty(strSize)) return nDefault;
		return Integer.parseInt(strSize);
	}

	/**
	 * 获取数据的快速搜索条件
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getFetchQuickSearch(IWebContext iWebContext) {
		String strQuery = iWebContext.getPostValue("query");
		return strQuery;
	}

	/**
	 * 获取数据的排序参数
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getSortParam(IWebContext iWebContext) {
		String strSortField = iWebContext.getPostValue("sort");
		return strSortField;
	}

	/**
	 * 获取数据的排序方向
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getSortDir(IWebContext iWebContext) {
		String strSortDir = iWebContext.getPostValue("sortdir");
		return strSortDir;
	}

	/**
	 * 获取当前是否处于临时数据
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static boolean isTempMode(IWebContext iWebContext) {
		String strTempMode = iWebContext.getPostValue(PARAM_TEMPMODE);
		if (StringHelper.isNullOrEmpty(strTempMode)) strTempMode = iWebContext.getParamValue(PARAM_TEMPMODE);
		if (StringHelper.isNullOrEmpty(strTempMode)) return false;
		return StringHelper.compare(strTempMode, "true", true) == 0;
	}

	/**
	 * 获取表单项更新模式
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getUFIMode(IWebContext iWebContext) {
		String strUFIMode = iWebContext.getPostValue(PARAM_UFIMODE);
		if (StringHelper.isNullOrEmpty(strUFIMode)) strUFIMode = iWebContext.getParamValue(PARAM_UFIMODE);
		return strUFIMode;
	}

	/**
	 * 获取流程步骤值
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getWFStep(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_WFSTEP);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_WFSTEP);
	}

	/**
	 * 获取流程状态值
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getWFState(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_WFSTATE);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_WFSTATE);
	}

	/**
	 * 获取流程用户数据状态值
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getWFUDState(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_WFUDSTATE);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_WFUDSTATE);
	}

	/**
	 * 获取流程交互值
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getWFIATag(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_WFIATAG);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_WFIATAG);
	}

	/**
	 * 获取流程处理意见
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getWFMemo(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_WFMEMO);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_WFMEMO);
	}

	/**
	 * 获取当前实体编号
	 * 
	 * @return
	 */
	public static String getDEId() {
		return WebContext.getDEId(WebContext.getCurrent());
	}

	/**
	 * 获取当前实体编号
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getDEId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_DEID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_DEID);
	}

	/**
	 * 获取当前父实体编号
	 * 
	 * @return
	 */
	public static String getParentDEId() {
		return getParentDEId(WebContext.getCurrent());
	}

	/**
	 * 获取当前父实体编号
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getParentDEId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_PARENTDEID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_PARENTDEID);
	}

	/**
	 * 获取当前当前容器编号
	 * 
	 * @return
	 */
	public static String getContainerId() {
		return getContainerId(WebContext.getCurrent());
	}

	/**
	 * 获取当前容器编号
	 *
	 * @param iWebContext
	 * @return
	 */
	public static String getContainerId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_CONTAINERID);
		if (strValue == null) {
			strValue = iWebContext.getParamValue(PARAM_CONTAINERID);
		}
		// 值规则校验，后期推荐可以采取注解方式@XXXX，注解可以直接抛异常。
		if (!StringHelper.isNullOrEmpty(strValue)) {
			Pattern pattern = Pattern.compile(PARAM_CONTAINERID_REGEX);
	        Matcher m = pattern.matcher(strValue);
	        if (!m.matches()) {
	        	// 不符合规则的当前容器编号置为NULL
	        	strValue = null;
	        }
		}
		return strValue;
	}

	/**
	 * 获取当前当前容器级别
	 * 
	 * @return
	 */
	public static String getContainerLevel() {
		return getContainerLevel(WebContext.getCurrent());
	}

	/**
	 * 获取当前当前容器级别
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getContainerLevel(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_CONTAINERLEVEL);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_CONTAINERLEVEL);
	}

	/**
	 * 获取当前绘制器
	 * 
	 * @return
	 */
	public static String getRender() {
		return getRender(WebContext.getCurrent());
	}

	/**
	 * 获取当前绘制器
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getRender(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_RENDER);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_RENDER);
	}

	/**
	 * 获取当前树节点标识
	 * 
	 * @return
	 */
	public static String getNodeId() {
		return getNodeId(WebContext.getCurrent());
	}

	/**
	 * 获取当前树节点标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getNodeId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_NODEID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_NODEID);
	}
	
	/**
	 * 获取当前树节点类型
	 * 
	 * @return
	 */
	public static String getNodeType() {
		return getNodeType(WebContext.getCurrent());
	}
	
	
	/**
	 * 获取当前树节点类型
	 * @param iWebContext
	 * @return
	 */
	public static String getNodeType(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_NODETYPE);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_NODETYPE);
	}

	
	/**
	 * 获取当前通用界面项标识
	 * 
	 * @return
	 */
	public static String getItemId() {
		return getItemId(WebContext.getCurrent());
	}

	/**
	 * 获取当前通用界面项标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getItemId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_ITEMID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_ITEMID);
	}
	
	/**
	 * 获取当前通用界面项类型
	 * 
	 * @return
	 */
	public static String getItemType() {
		return getItemType(WebContext.getCurrent());
	}
	
	
	/**
	 * 获取当前通用界面项类型
	 * @param iWebContext
	 * @return
	 */
	public static String getItemType(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_ITEMTYPE);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_ITEMTYPE);
	}
	
	
	
	/**
	 * 获取远程调用名称
	 * 
	 * @return
	 */
	public static String getRemoteCall() {
		return getRemoteCall(WebContext.getCurrent());
	}

	/**
	 * 获取远程调用名称
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getRemoteCall(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_CALL);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_CALL);
	}

	/**
	 * 获取远程调用参数
	 * 
	 * @return
	 */
	public static String getRemoteCallArg() {
		return getRemoteCallArg(WebContext.getCurrent());
	}

	/**
	 * 获取远程调用参数
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getRemoteCallArg(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_CALLARG);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_CALLARG);
	}

	/**
	 * 获取调用返回包括空值
	 * 
	 * @return
	 */
	public static String getRemoteCallRetIncEmpty() {
		return getRemoteCallRetIncEmpty(WebContext.getCurrent());
	}

	/**
	 * 获取调用返回包括空值
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getRemoteCallRetIncEmpty(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_CALLRETINCEMPTY);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_CALLRETINCEMPTY);
	}

	/**
	 * 获取调用返回时间格式
	 * 
	 * @return
	 */
	public static String getRemoteCallRetTimeFmt() {
		return getRemoteCallRetTimeFmt(WebContext.getCurrent());
	}

	/**
	 * 获取调用返回时间格式
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getRemoteCallRetTimeFmt(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_CALLRETTIMEFMT);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_CALLRETTIMEFMT);
	}

	/**
	 * 获取登录标识
	 * 
	 * @return
	 */
	public static String getLoginKey() {
		return getLoginKey(WebContext.getCurrent());
	}

	/**
	 * 获取登录标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getLoginKey(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_LOGINKEY);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_LOGINKEY);
	}

	/**
	 * 获取当前流程编号
	 * 
	 * @return
	 */
	public static String getWFId() {
		return WebContext.getWFId(WebContext.getCurrent());
	}

	/**
	 * 获取当前流程编号
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getWFId(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_WFID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_WFID);
	}

	/**
	 * 获取当前引用项
	 * 
	 * @return
	 */
	public static String getReferItem() {
		return WebContext.getReferItem(WebContext.getCurrent());
	}

	/**
	 * 获取当前引用项
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getReferItem(IWebContext iWebContext) {
		if (iWebContext == null) return null;
		String strValue = iWebContext.getPostValue(PARAM_REFERITEM);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_REFERITEM);
	}

	/**
	 * 从登录账户中构建
	 * 
	 * @param iWebContext
	 * @param loginAccount
	 */
	public static void fillByLoginAccount(IWebContext iWebContext, LoginAccount loginAccount) {
		iWebContext.setSessionValue(IWebContext.PERSONID, loginAccount.getUserId());
		iWebContext.setSessionValue(IWebContext.USERID, loginAccount.getUserId());
		iWebContext.setSessionValue(IWebContext.USERNAME, loginAccount.getUserName());
		iWebContext.setSessionValue(IWebContext.UESRNAME, loginAccount.getUserName());
		iWebContext.setSessionValue(IWebContext.LOGINNAME, loginAccount.getLoginAccountName());
		
		WebContext.setLocalization(iWebContext, loginAccount.getLanguage());
		
		if (DataObject.getBoolValue(loginAccount.getSuperUser(), false)) {
			iWebContext.setSessionValue(IWebContext.SUPERUSER, "1");
		} else {
			iWebContext.setSessionValue(IWebContext.SUPERUSER, "0");
		}

		if (DataObject.getBoolValue(loginAccount.getOrgAdmin(), false)) {
			iWebContext.setSessionValue(IWebContext.ORGADMIN, "1");
		} else {
			iWebContext.setSessionValue(IWebContext.ORGADMIN, "0");
		}
		
		

	}

	/**
	 * 从组织用户中构建
	 * 
	 * @param iWebContext
	 * @param orgUser
	 */
	public static void fillByOrgUser(IWebContext iWebContext, OrgUser orgUser) {
		iWebContext.setSessionValue(IWebContext.ORGID, orgUser.getOrgId());
		iWebContext.setSessionValue(IWebContext.ORGNAME, orgUser.getOrgName());
		iWebContext.setSessionValue(IWebContext.ORGSECTORID, orgUser.getOrgSectorId());
		iWebContext.setSessionValue(IWebContext.ORGSECTORNAME, orgUser.getOrgSectorName());
		iWebContext.setSessionValue(IWebContext.ORGSECTORBC, orgUser.getBizCode());
	}

	/**
	 * 获取数据导入模式
	 * 
	 * @return
	 */
	public static String getDEDataImport() {
		return WebContext.getDEDataImport(WebContext.getCurrent());
	}

	/**
	 * 获取数据导入模式
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getDEDataImport(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_DEDATAIMPORT);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_DEDATAIMPORT);
	}

	/**
	 * 获取视图参数
	 * 
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getViewParam() {
		return getViewParam(WebContextBase.getCurrent());
	}

	/**
	 * 获取视图参数
	 * 
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getViewParam(IWebContext iWebContext) {
		JSONObject dataObject = viewParam.get();
		if (dataObject == null) {
			String strViewParam = iWebContext.getPostValue(PARAM_VIEWPARAM);
			if (!StringHelper.isNullOrEmpty(strViewParam)) {
				dataObject = JSONObjectHelper.fromString(strViewParam);
				viewParam.set(dataObject);
			}
		}
		return dataObject;
	}

	/**
	 * 获取报表标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getReportId(IWebContext iWebContext) {
		if (iWebContext == null) return null;
		String strValue = iWebContext.getPostValue(PARAM_REPORTID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_REPORTID);
	}

	/**
	 * 获取打印标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getPrintId(IWebContext iWebContext) {
		if (iWebContext == null) return null;
		String strValue = iWebContext.getPostValue(PARAM_PRINTID);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_PRINTID);
	}

	/**
	 * 获取原始主键
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getOriginKey(IWebContext iWebContext) {
		if (iWebContext == null) return null;
		String strValue = iWebContext.getPostValue(PARAM_ORIKEY);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_ORIKEY);
	}

	/**
	 * 获取实际主键
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getRealKey(IWebContext iWebContext) {
		String strKey = WebContext.getKey(iWebContext);
		if (StringHelper.isNullOrEmpty(strKey)) {
			return strKey;
		}

		if (KeyValueHelper.isTempKey(strKey)) {
			return getOriginKey(iWebContext);
		}
		return strKey;
	}

	
	/**
	 * 设置上下文本地化
	 * @param iWebContext
	 * @param strLocalization
	 */
	public static void setLocalization(IWebContext iWebContext,String strLocalization) {
		if(StringHelper.isNullOrEmpty(strLocalization)){
			iWebContext.setSessionValue(IWebContext.LOCALIZATION,null);
			iWebContext.setSessionValue(IWebContext.LOCALE,null);
			iWebContext.setSessionValue(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,null);
		}
		else{
			iWebContext.setSessionValue(IWebContext.LOCALE,null);
			iWebContext.setSessionValue(IWebContext.LOCALIZATION,strLocalization);
			Locale locale = iWebContext.getLocale();
			iWebContext.setSessionValue(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
		}
	}
	
	/**
	 * 获取用户角色管理器2
	 * @return
	 * @throws Exception
	 */
	public static IUserRoleMgr2 getUserRoleMgr2()throws Exception{
		return getUserRoleMgr2(WebContext.getCurrent());
	}
	
	/**
	 * 获取用户角色管理器2
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	public static IUserRoleMgr2 getUserRoleMgr2(IWebContext iWebContext)throws Exception{
		IUserRoleMgr iUserRoleMgr = iWebContext.getUserRoleMgr();
		if(!(iUserRoleMgr instanceof IUserRoleMgr2)){
			throw new Exception(StringHelper.format("用户角色管理器对象[%1$s]没有实现接口[net.ibizsys.paas.security.IUserRoleMgr2]",iUserRoleMgr));
		}
		return (IUserRoleMgr2)iUserRoleMgr;
	}
	
	
	
	/**
	 * 获取当前操作数据
	 * 
	 * @return
	 */
	public static String getActionData() {
		return getActionData(WebContext.getCurrent());
	}

	/**
	 * 获取当前操作数据
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getActionData(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_ACTIONDATA);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_ACTIONDATA);
	}
	
	
	/**
	 * 获取当前动态实例实例标识
	 * 
	 * @return
	 */
	public static String getDynaSysInstId() {
		return getDynaSysInstId(WebContext.getCurrent());
	}

	/**
	 * 获取当前动态实例标识
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getDynaSysInstId(IWebContext iWebContext) {
		Object objDynaInstId = iWebContext.getSessionValue(IWebContext.DYNASYSINSTID);
		if(StringHelper.isNullOrEmpty(objDynaInstId))
		{
			return WebConfig.getCurrent().getDynaSysInstId();
		}
		return (String)objDynaInstId;
	}
	
	
	
	
	/**
	 * 获取应用模式
	 * 
	 * @return
	 */
	public static String getAppMode() {
		return getAppMode(WebContext.getCurrent());
	}

	/**
	 * 获取应用模式
	 * 
	 * @param iWebContext
	 * @return
	 */
	public static String getAppMode(IWebContext iWebContext) {
		String strValue = iWebContext.getPostValue(PARAM_APPMODE);
		if (strValue != null) return strValue;
		return iWebContext.getParamValue(PARAM_APPMODE);
	}
}
