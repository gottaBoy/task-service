package net.ibizsys.paas.web;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IUserPrivilegeMgr;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.security.UserPrivilegeMgr;
import net.ibizsys.paas.security.UserRoleMgr;
import net.ibizsys.paas.sysmodel.UserCodeListGlobal;
import net.ibizsys.paas.util.GlobalContext;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.sf.json.JSONObject;

/**
 * 网络访问上下文对象
 * 
 * @author lionlau
 *
 */
public class WebContext extends WebContextBase implements IWebContext {
	// private static final Log log = LogFactory.getLog(WebContext.class);

	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private ServletContext servletContext = null;
	private HashMap<String, String> paramList = new HashMap<String, String>();
	private AjaxActionResult ajaxActionResult = null;
	// private HashMap<String,String> cacheLocalizationMap = null;
	private ISystem curSystem = null;
	private IApplication curApplication = null;
	private HashMap<String, String> postValueMap = null;
	
	public static final String WEB_APPLICATION_CONTEXT_ATTRIBUTE = WebContext.class.getName() + ".CONTEXT";

	private WebApplicationContext webApplicationContext;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#init(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.ServletContext)
	 */
	@Override
	public void init(HttpServletRequest arg0, HttpServletResponse arg1, ServletContext arg2) throws Exception {
		if (arg0 instanceof HttpServletRequest) {
			request = (HttpServletRequest) arg0;

			parseRequest(request.getQueryString());
			parsePost();
		}

		if (arg1 instanceof HttpServletResponse) {
			response = (HttpServletResponse) arg1;
		}

		servletContext = arg2;
		prepareWebApplicationContext();
	}
	
	/**
	 * 准备Spring WebApplicationContext
	 * @throws Exception
	 */
	protected void prepareWebApplicationContext()throws Exception{

		this.webApplicationContext = (WebApplicationContext) request.getAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		if (this.webApplicationContext == null) {
			this.webApplicationContext = RequestContextUtils.getWebApplicationContext(request, servletContext);
		}
	}

	/**
	 * 分析URL参数串
	 * 
	 * @param strQueryString
	 */
	protected void parseRequest(String strQueryString) {
		// 将所有的值进行枚举
		if (strQueryString == null) {
			return;
		}
		String[] strLists = strQueryString.split("&");

		for (int i = 0; i < strLists.length; i++) {
			String[] set = strLists[i].split("=");
			if (set.length == 2) {
				try {
					String strValue = java.net.URLDecoder.decode(set[1], "UTF-8");
					if (StringHelper.length(strValue) != 0) {
						this.setParamValue(set[0], strValue);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * 分析请求参数
	 */
	protected void parsePost() throws Exception {
		if (StringHelper.compare(this.getRequest().getMethod(), "POST", true) != 0) return;

		if (this.getRequest().getContentType() == null || this.getRequest().getContentType().indexOf("application/x-www-form-urlencoded") != 0) return;

		Map map = this.getRequest().getParameterMap();
		if (map.size() > 0) return;

		InputStream is = this.getRequest().getInputStream();
		if (is != null) {

			Scanner br = null;
			try {
				br = new Scanner(is);
				StringBuilderEx sb = new StringBuilderEx();
				while (br.hasNextLine()) {
					String tempStream = br.nextLine();
					if (tempStream.trim() == null || tempStream.trim().equals("")) continue;
					sb.append(tempStream);
				}
				String strFormValues = sb.toString();
				if (!StringHelper.isNullOrEmpty(strFormValues)) {
					this.postValueMap = new HashMap<String, String>();

					String[] strLists = strFormValues.split("&");

					for (int i = 0; i < strLists.length; i++) {
						String[] set = strLists[i].split("=");
						if (set.length == 2) {
							try {
								String strValue = java.net.URLDecoder.decode(set[1], this.getRequest().getCharacterEncoding());
								if (StringHelper.length(strValue) != 0) {
									this.postValueMap.put(set[0], strValue);
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}

				}

			} catch (Exception ex) {

			} finally {
				br.close();
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#setParamValue(java.lang.String, java.lang.String)
	 */
	@Override
	public void setParamValue(String strParamName, String strParamValue) {
		strParamValue = strParamValue.trim();
		if (!StringHelper.isNullOrEmpty(strParamValue))
			paramList.put(strParamName.toUpperCase(), strParamValue);
		else
			this.removeParam(strParamName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#removeParam(java.lang.String)
	 */
	@Override
	public void removeParam(String strParamName) {
		if (paramList.containsKey(strParamName.toUpperCase())) {
			paramList.remove(strParamName.toUpperCase());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getParamValue(java.lang.String)
	 */
	@Override
	public String getParamValue(String strParamName) {
		if (paramList.containsKey(strParamName.toUpperCase())) {
			return paramList.get(strParamName.toUpperCase()).toString();
		} else {
			return null;
		}
	}

	@Override
	public String getCookieValue(String strParamName) {
		if (this.getRequest() == null) {
			return null;
		}
		Cookie[] cookies = this.getRequest().getCookies();
		if(cookies != null)
		{
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (StringHelper.compare(strParamName, cookie.getName(), true) == 0) {
					return cookie.getValue();
				}
			}
		}
		
		return null;
	}

	@Override
	public void setCookieValue(String name, String value,int maxAge) {
		if (response == null) {
			return;
		}
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);

		response.addCookie(cookie);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getSessionValue(java.lang.String)
	 */
	@Override
	public Object getSessionValue(String strKey) {
		Object objValue = null;
		if(this.getRequest() != null && this.getRequest().getSession()!=null){
			if (isEnableSessionShare()) {
				objValue = LocalSessionStorage.getCurrent(this.getServletContext()).getSessionValue(this.getRequest().getSession(), strKey);
				if (objValue != null){
					return objValue;
				}
			}
			return this.getRequest().getSession().getAttribute(strKey);
		}
		return objValue;		
	}

	@Override
	public Object getSessionValue(String strKey, boolean bSerializable) {
		Object objValue = null;
		if(this.getRequest() != null && this.getRequest().getSession()!=null){
			if (!bSerializable && isEnableSessionShare()) {
				return LocalSessionStorage.getCurrent(this.getServletContext()).getSessionValue(this.getRequest().getSession(), strKey);
			}
			return this.getRequest().getSession().getAttribute(strKey);
		}
		return objValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#setSessionValue(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setSessionValue(String strKey, Object objValue) {
		setSessionValue(strKey, objValue, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurUserId()
	 */
	@Override
	public String getCurUserId() {
		Object objValue = getSessionValue(IWebContext.PERSONID);
		if(objValue == null)
			objValue = getSessionValue(IWebContext.USERID);
		if (objValue == null) return "";
		return objValue.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurUserName()
	 */
	@Override
	public String getCurUserName() {
		Object objValue = getSessionValue(IWebContext.USERNAME);
		if(objValue == null)
			objValue = getSessionValue(IWebContext.UESRNAME);
		if (objValue == null) return "";
		return objValue.toString();
	}
	
	
	/**
	 * 设置当前用户名称
	 * @param strUserName
	 */
	public void setCurUserName(String strUserName){
		setSessionValue(IWebContext.USERNAME,strUserName);
		setSessionValue(IWebContext.UESRNAME,strUserName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurLoginName()
	 */
	@Override
	public String getCurLoginName() {
		Object objValue = getSessionValue(IWebContext.LOGINNAME);
		if (objValue == null) return "";
		return (String) objValue;
	}
	
	
	/**
	 * 设置当前登录名称
	 * @param strLoginName
	 */
	public void setCurLoginName(String strLoginName) {
		setSessionValue(IWebContext.LOGINNAME,strLoginName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurUserIconPath()
	 */
	@Override
	public String getCurUserIconPath() {
		Object objValue = getSessionValue(IWebContext.USERICONPATH);
		if (objValue == null)
			 objValue = getSessionValue(IWebContext.UESRICONPATH);
		if (objValue == null) return "";
	
		return objValue.toString();
	}
	

	/**
	 * 设置当前用户标识
	 * @param strUserId
	 */
	public void setCurUserId(String strUserId) {
		this.setSessionValue(PERSONID, strUserId);
		this.setSessionValue(USERID, strUserId);
	}
	
	
	/**
	 * 设置当前用户图标路径
	 * @param strUserIconPath
	 */
	public void setCurUserIconPath(String strUserIconPath) {
		this.setSessionValue(USERICONPATH, strUserIconPath);
		this.setSessionValue(UESRICONPATH, strUserIconPath);
	}
	
	
	/**
	 * 设置当前用户密码过期
	 * @param bExpired
	 */
	public void setCurUserPasswordExpired(boolean bExpired){
		this.setSessionValue(USERPASSWORDEXPIRED, bExpired?"1":"0");
	}
	
	
	/**
	 * 获取当前用户是否密码过期
	 * @return
	 */
	public boolean isCurUserPasswordExpired(){
		Object objExpired = this.getSessionValue(USERPASSWORDEXPIRED);
		if(StringHelper.isNullOrEmpty(objExpired))
			return false;
		return StringHelper.compare(objExpired.toString(), "1",false) == 0;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getGlobalValue(java.lang.String)
	 */
	@Override
	public Object getGlobalValue(String strKey) {
		return getServletContext().getAttribute(strKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#setGlobalValue(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setGlobalValue(String strKey, Object objValue) {
		if (objValue == null)
			getServletContext().removeAttribute(strKey);
		else
			getServletContext().setAttribute(strKey, objValue);
	}

	/**
	 * 获取ServletContext
	 * 
	 * @return
	 */
	public ServletContext getServletContext() {
		return this.servletContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getRemoteAddr()
	 */
	@Override
	public String getRemoteAddr() {
		if(this.getRequest() == null)
			return null;
		return this.getRequest().getRemoteAddr();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getRealRemoteAddr()
	 */
	@Override
	public String getRealRemoteAddr() {
		if(this.getRequest()==null)
			return null;
		String strRealIp = this.getRequest().getHeader(HEADER_REALIP);
		return strRealIp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getUserAgent()
	 */
	@Override
	public String getUserAgent() {
		if(this.getRequest() == null)
			return null;
		return this.getRequest().getHeader("User-Agent");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getGlobalContext()
	 */
	@Override
	public IGlobalContext getGlobalContext() {
		return GlobalContext.getCurrent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurUserMode()
	 */
	@Override
	public String getCurUserMode() {
		Object objValue = getSessionValue(IWebContext.USERMODE);
		if (objValue == null)
			objValue = getSessionValue(IWebContext.UESRMODE);
		if (objValue == null) return "DEFAULT";
		return objValue.toString();
	}
	
	
	/**
	 * 设置当前用户模式
	 * @param strUserMode
	 */
	public void setCurUserMode(String strUserMode){
		setSessionValue(IWebContext.USERMODE,strUserMode);
		setSessionValue(IWebContext.UESRMODE,strUserMode);
	}
	

	/**
	 * 获取提交的值
	 * 
	 * @param strParamName
	 * @param strDefault 默认值
	 * @return
	 */
	public String getPostValue(String strParamName, String strDefault) {
		if(this.getRequest()!=null){
			strParamName = strParamName.toLowerCase();
			String strValue = this.getRequest().getParameter(strParamName);
			if (strValue == null) {
				if (this.postValueMap != null) {
					strValue = this.postValueMap.get(strParamName);
				}
				if (strValue == null) return strDefault;
			}
			return strValue;
		}
		return strDefault;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getPostValue(java.lang.String)
	 */
	@Override
	public String getPostValue(String strParamName) {
		if(this.getRequest()!=null){
			strParamName = strParamName.toLowerCase();
			String strValue = this.getRequest().getParameter(strParamName);
			if (strValue == null) {
				if (this.postValueMap != null) {
					strValue = this.postValueMap.get(strParamName);
				}
			}
			return strValue;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getPostValues(java.lang.String)
	 */
	@Override
	public String[] getPostValues(String strParamName) {
		if(this.getRequest()!=null){
			strParamName = strParamName.toLowerCase();
			String strValue = this.getRequest().getParameter(strParamName);
			if (strValue == null) return null;
			return this.getRequest().getParameterValues(strParamName);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getQueryStringWithout(java.lang.String)
	 */
	@Override
	public String getQueryStringWithout(String strParams) {
		if (StringHelper.length(strParams) == 0) {
			return this.getQueryString();
		}

		String strURLCall = "";
		String list[] = strParams.split("[|]");

		TreeMap<String, String> notKeys = new TreeMap<String, String>();
		for (int i = 0; i < list.length; i++)
			notKeys.put(list[i].toUpperCase(), "");

		for (String strName : paramList.keySet()) {
			if (StringHelper.length(strName) == 0) continue;

			// 在排除范围之中
			if (notKeys.containsKey(strName.toUpperCase())) continue;

			String strValue = (String) paramList.get(strName);
			if (StringHelper.length(strValue) == 0) continue;

			if (strURLCall.length() > 0) {
				strURLCall = strURLCall + "&";
			}
			strURLCall += strName;
			strURLCall += "=";
			try {
				strURLCall += java.net.URLEncoder.encode(strValue, "UTF-8");
			} catch (Exception ex) {
				strURLCall += strValue;
			}
		}
		return strURLCall;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getQueryString()
	 */
	@Override
	public String getQueryString() {
		return WebUtility.getQueryString(paramList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getLocalization()
	 */
	@Override
	public String getLocalization() {
		Object objValue = getSessionValue(IWebContext.LOCALIZATION);
		if (objValue == null)
			return "";
		else
			return (String) objValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurTimeZone()
	 */
	@Override
	public TimeZone getCurTimeZone() {
		Object objTimeZone = this.getSessionValue(IWebContext.TIMEZONE);
		if (objTimeZone == null) {
			return TimeZone.getDefault();
		} else
			return (TimeZone) objTimeZone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getLocalization(java.lang.String, java.lang.String)
	 */
	@Override
	public String getLocalization(String strResId, String strDefault) {
		String strValue =  getWebApplicationContext().getMessage(strResId, null,strDefault,this.getLocale());
		if(StringHelper.isNullOrEmpty(strValue))
			return strDefault;
		return strValue;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.web.IWebContext#getLocalization(java.lang.String, java.lang.Object[], java.lang.String)
	 */
	@Override
	public String getLocalization(String strResId,  Object[] params, String strDefault) {
		String strValue =  getWebApplicationContext().getMessage(strResId, params,strDefault,this.getLocale());
		if(StringHelper.isNullOrEmpty(strValue))
			return strDefault;
		return strValue;
	}

	
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.web.IWebContext#getLocalization(java.lang.String, java.lang.String, java.util.Locale)
	 */
	@Override
	public String getLocalization(String strResId, String strDefault, Locale locale) {
		String strValue =  getWebApplicationContext().getMessage(strResId, null,strDefault,locale);
		if(StringHelper.isNullOrEmpty(strValue))
			return strDefault;
		return strValue;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.web.IWebContext#getLocalization(java.lang.String, java.lang.Object[], java.lang.String, java.util.Locale)
	 */
	@Override
	public String getLocalization(String strResId, Object[] params, String strDefault, Locale locale) {
		String strValue =  getWebApplicationContext().getMessage(strResId, params,strDefault,locale);
		if(StringHelper.isNullOrEmpty(strValue))
			return strDefault;
		return strValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurOrgId()
	 */
	@Override
	public String getCurOrgId() {
		Object objCurOrgId = this.getSessionValue(IWebContext.ORGID);
		if (objCurOrgId == null) return "";
		return objCurOrgId.toString();
	}

	/**
	 * 设置当前的用户组织编号
	 * 
	 * @param strValue
	 */
	public void setCurOrgId(String strValue) {
		this.setSessionValue(IWebContext.ORGID, strValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurOrgName()
	 */
	@Override
	public String getCurOrgName() {
		Object objCurOrgName = this.getSessionValue(IWebContext.ORGNAME);
		if (objCurOrgName == null) return "";
		return objCurOrgName.toString();

	}

	/**
	 * 设置当前的用户组织名称
	 * 
	 * @param strValue
	 */
	public void setCurOrgName(String strValue) {
		this.setSessionValue(IWebContext.ORGNAME, strValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurOrgSectorId()
	 */
	public String getCurOrgSectorId() {
		Object objCurOrgUnitId = this.getSessionValue(IWebContext.ORGSECTORID);
		if (objCurOrgUnitId == null) return "";
		return objCurOrgUnitId.toString();
	}

	/**
	 * 设置当前的用户组织单元编号
	 * 
	 * @param strValue
	 */
	public void setCurOrgSectorId(String strValue) {
		this.setSessionValue(IWebContext.ORGSECTORID, strValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurOrgSectorName()
	 */
	@Override
	public String getCurOrgSectorName() {
		Object objCurOrgUnitName = this.getSessionValue(IWebContext.ORGSECTORNAME);
		if (objCurOrgUnitName == null) return "";
		return objCurOrgUnitName.toString();

	}

	/**
	 * 设置当前的用户组织单元名称
	 * 
	 * @param strValue
	 */
	public void setCurOrgSectorName(String strValue) {
		this.setSessionValue(IWebContext.ORGSECTORNAME, strValue);
	}

	@Override
	public String getCurOrgSectorBC() {
		Object objCurOrgUnitBC = this.getSessionValue(IWebContext.ORGSECTORBC);
		if (objCurOrgUnitBC == null) return "";
		return objCurOrgUnitBC.toString();

	}

	/**
	 * 设置当前的用户条线代码
	 * 
	 * @param strValue
	 */
	public void setCurOrgSectorBC(String strValue) {
		this.setSessionValue(IWebContext.ORGSECTORBC, strValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getParams()
	 */
	@Override
	public Map<String, String> getParams() {
		return this.paramList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurPagePath()
	 */
	@Override
	public String getCurPagePath() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurAjaxActionResult()
	 */
	@Override
	public AjaxActionResult getCurAjaxActionResult() {
		return this.ajaxActionResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#setCurAjaxActionResult(net.ibizsys.paas.web.AjaxActionResult)
	 */
	@Override
	public void setCurAjaxActionResult(AjaxActionResult ajaxActionResult) {
		this.ajaxActionResult = ajaxActionResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getUserPrivilegeMgr()
	 */
	@Override
	public IUserPrivilegeMgr getUserPrivilegeMgr() throws Exception {
		Object objUserPrivilegeMgr = this.getSessionValue(USERPRIVILEGEMGR, false);
		if (objUserPrivilegeMgr == null) {
			IUserPrivilegeMgr iUserPrivilegeMgr = createUserPrivilegeMgr();
			this.setSessionValue(USERPRIVILEGEMGR, iUserPrivilegeMgr, false);
			return iUserPrivilegeMgr;

		}
		return (IUserPrivilegeMgr) objUserPrivilegeMgr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getUserPrivilegeMgr()
	 */
	@Override
	public IUserRoleMgr getUserRoleMgr() throws Exception {
		Object objUserRoleMgr = this.getSessionValue(USERROLEMGR, false);
		if (objUserRoleMgr == null) {
			IUserRoleMgr iUserRoleMgr = createUserRoleMgr();
			this.setSessionValue(USERROLEMGR, iUserRoleMgr, false);
			return iUserRoleMgr;

		}
		return (IUserRoleMgr) objUserRoleMgr;
	}

	/**
	 * 建立用户角色管理对象
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IUserRoleMgr createUserRoleMgr() throws Exception {
		UserRoleMgr userRoleMgr = new UserRoleMgr();
		userRoleMgr.init(this);
		return userRoleMgr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurSystem()
	 */
	@Override
	public ISystem getCurSystem() {
		return curSystem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCurApplication()
	 */
	@Override
	public IApplication getCurApplication() {
		return curApplication;
	}

	/**
	 * 设置当前系统
	 * 
	 * @param curSystem the curSystem to set
	 */
	public void setCurSystem(ISystem curSystem) {
		this.curSystem = curSystem;
	}

	/**
	 * 设置当前应用
	 * 
	 * @param curApplication the curApplication to set
	 */
	public void setCurApplication(IApplication curApplication) {
		this.curApplication = curApplication;
	}

	/**
	 * 建立用户权限管理对象
	 * 
	 * @return
	 */
	protected IUserPrivilegeMgr createUserPrivilegeMgr() throws Exception {
		return new UserPrivilegeMgr();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getRequest()
	 */
	@Override
	public HttpServletRequest getRequest() {
		return this.request;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getResponse()
	 */
	@Override
	public HttpServletResponse getResponse() {
		return this.response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#logout()
	 */
	@Override
	public void logout() {
		logout(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#logout(boolean)
	 */
	@Override
	public void logout(boolean bReleaseSession) {
		this.setSessionValue(LOGINNAME, null);
		this.setSessionValue(USERROLEMGR, null);
		this.setSessionValue(USERPRIVILEGEMGR, null);
		this.setSessionValue(USERCODELISTMGR, null);

		// 将Session对象释放
		if (bReleaseSession) {
			request.getSession().invalidate();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#login(java.lang.String)
	 */
	@Override
	public void login(String strLoginName) throws Exception {
		// this.logout(false);
		this.setSessionValue(LOGINNAME, strLoginName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#remoteLogin(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public void remoteLogin(IEntity iEntity) throws Exception {

		String strUserId = DataObject.getStringValue(iEntity, "userid", "");
		String strUserName = DataObject.getStringValue(iEntity, "username", "");

		this.setSessionValue(IWebContext.PERSONID, strUserId);
		this.setSessionValue(IWebContext.USERID, strUserId);
		this.setSessionValue(IWebContext.USERNAME, strUserName);
		this.setSessionValue(IWebContext.UESRNAME, strUserName);
		
		String strRet =  DataObject.getStringValue(iEntity, IWebContext.SUPERUSER, "0");
		this.setSessionValue(IWebContext.SUPERUSER, strRet);
		strRet =  DataObject.getStringValue(iEntity, IWebContext.ORGADMIN, "0");
		this.setSessionValue(IWebContext.ORGADMIN, strRet);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#isSuperUser()
	 */
	@Override
	public boolean isSuperUser() {
		Object objSuperUser = this.getSessionValue(SUPERUSER);
		if (objSuperUser == null) return false;
		if (objSuperUser.toString().compareTo("1") == 0) return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getSession()
	 */
	@Override
	public HttpSession getSession() {
		return request.getSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getSessionId()
	 */
	@Override
	public String getSessionId() {
		return getSession().getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getParamOrPostValue(java.lang.String)
	 */
	@Override
	public String getPostOrParamValue(String strParamName) {
		String strValue = this.getPostValue(strParamName);
		if (strValue != null) return strValue;
		return this.getParamValue(strParamName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getAppDataValue(java.lang.String)
	 */
	@Override
	public String getAppDataValue(String strParamName) {
		JSONObject jsonObject = getAppData(this);
		if (jsonObject == null) return null;

		return jsonObject.optString(strParamName, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getViewParamValue(java.lang.String)
	 */
	@Override
	public String getViewParamValue(String strParamName) {
		JSONObject jsonObject = getViewParam(this);
		if (jsonObject == null) return null;

		return jsonObject.optString(strParamName, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getCodeList(java.lang.String, org.hibernate.SessionFactory)
	 */
	@Override
	public ICodeList getUserCodeList(ICodeList iCodeList) throws Exception {
		if (!iCodeList.isUserScope()) return iCodeList;

		return getUserCodeListGlobal().getUserCodeList(iCodeList);
	}

	/**
	 * 获取用户代码表全局对象
	 * 
	 * @return
	 */
	public UserCodeListGlobal getUserCodeListGlobal() throws Exception {
		UserCodeListGlobal userCodeListGlobal = null;
		Object objUserCodeListGlobal = this.getSessionValue(USERCODELISTMGR, false);
		if (objUserCodeListGlobal == null) {
			userCodeListGlobal = new UserCodeListGlobal(this.getCurUserId());
			this.setSessionValue(USERCODELISTMGR, userCodeListGlobal, false);
		} else {
			userCodeListGlobal = (UserCodeListGlobal) objUserCodeListGlobal;
		}
		return userCodeListGlobal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getViewController()
	 */
	@Override
	public IViewController getViewController() {
		return ViewController.getCurrent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#isOrgAdmin()
	 */
	@Override
	public boolean isOrgAdmin() {
		Object objOrgAdmin = this.getSessionValue(ORGADMIN);
		if (objOrgAdmin == null) return false;
		if (objOrgAdmin.toString().compareTo("1") == 0) return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getAttribute(java.lang.String)
	 */
	@Override
	public Object getAttribute(String strName) {
		if(this.getRequest() == null)
			return null;
		return this.request.getAttribute(strName.toUpperCase());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#setAttribute(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setAttribute(String strName, Object objValue) {
		if (objValue == null) {
			this.request.removeAttribute(strName.toUpperCase());
		} else {
			this.request.setAttribute(strName.toUpperCase(), objValue);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#getWFMode()
	 */
	@Override
	public String getWFMode() {
		Object objWFMode = this.getSessionValue(IWebContext.WFMODE);
		if (objWFMode == null) return "";
		return (String) objWFMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IWebContext#setSessionValue(java.lang.String, java.lang.Object, boolean)
	 */
	@Override
	public void setSessionValue(String strKey, Object objValue, boolean bSerializable) {
		if(this.getRequest() != null && this.getRequest().getSession()!=null ){
			if (objValue == null) {
				if (isEnableSessionShare()) LocalSessionStorage.getCurrent(this.getServletContext()).setSessionValue(this.getRequest().getSession(), strKey, objValue);
				this.getRequest().getSession().removeAttribute(strKey);
			} else {
				if (!bSerializable && isEnableSessionShare()) {
					LocalSessionStorage.getCurrent(this.getServletContext()).setSessionValue(request.getSession(), strKey, objValue);
				} else {
					this.getRequest().getSession().setAttribute(strKey, objValue);
				}
			}
		}
	}

	/**
	 * 是否启用Session共享
	 * 
	 * @return
	 */
	public boolean isEnableSessionShare() {
		return false;
	}
	
	
	/**
	 * 获取Spring WEB程序上下文
	 * @return
	 */
	public WebApplicationContext getWebApplicationContext(){
		return this.webApplicationContext;
	}

	
	@Override
	public Locale getLocale() {
		
		Locale locale = null;
		Object objLocale = this.getSessionValue(LOCALE);
		if(objLocale==null){
			String strLocale = this.getLocalization();
			if(StringHelper.isNullOrEmpty(strLocale)){
				locale = Locale.CHINA;
			}
			else{
				String[] parts = strLocale.split("[_]");
				if(parts.length == 1){
					locale = new Locale(parts[0].toLowerCase());
				}
				else{
					locale = new Locale(parts[0].toLowerCase(),parts[1].toUpperCase());
				}
			}
			this.setSessionValue(LOCALE, locale, false);
		}
		else{
			locale = (Locale)objLocale;
		}
		return locale;
	}
	
	/**
	 * 设置PostValue
	 * @param strParamName
	 * @param strValue
	 */
	public void setPostValue(String strParamName,String strValue) {
		strParamName = strParamName.toLowerCase();
		if(this.postValueMap == null) {
			this.postValueMap = new HashMap<String, String>();
		}
		this.postValueMap.put(strParamName, strValue);
	}
	
}
