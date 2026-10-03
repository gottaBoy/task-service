package net.ibizsys.paas.web;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.FilterConfig;

/**
 * 应用程序或服务配置对象
 * 
 * @author Administrator
 *
 */
public class WebConfig {
	
	private static WebConfig webConfig = null;
	protected HashMap<String, String> extAttrList = new HashMap<String, String>();

	/**
	 * 上下文参数
	 */
	public final static String WEBCONTEXT = "WEBCONTEXT";

	/**
	 * 临时路径
	 */
	public final static String TEMPPATH = "TEMPPATH";
	
	/**
	 * sql小写
	 */
	public final static String LOWCASESQL = "LOWCASESQL";

	/**
	 * 文件存储路径
	 */
	public final static String FILEPATH = "FILEPATH";

	/**
	 * 后台服务容器
	 */
	public final static String SERVICECONTAINER = "SERVICECONTAINER";
	
	/**
	 * 默认操作人标识
	 */
	public final static String DEFAULTOPERATOR = "DEFAULTOPERATOR";
	
	
	/**
	 * 默认操作人名称
	 */
	public final static String DEFAULTOPERATORNAME = "DEFAULTOPERATORNAME";
	
	/**
	 * 动态系统实例标识
	 */
	public final static String DYNASYSINSTID = "DYNASYSINSTID";
	
	
	/**
	 * 应用程序路径
	 */
	public final static String APPURL  = "APPURL_";
	
	
	/**
	 * 外部Html路径
	 */
	public final static String HTMLURL  = "HTMLURL_";
	
	
	
	/**
	 * 默认应用程序路径（Web端）
	 */
	public final static String DEFAULTWEBAPPURL  = "DEFAULTWEBAPPURL";
	
	/**
	 * 默认应用程序路径（移动端）
	 */
	public final static String DEFAULTMOBAPPURL  = "DEFAULTMOBAPPURL";
	

	private String strWebContextObj = null;
	private String strFilePath = null;
	private String strTempPath = null;
	private String strServiceContainer = null;
	private String strDefaultOperator = null;
	private String strDefaultOperatorName = null;
	private String strDynaSysInstId = null;
	private String strDefaultWebAppUrl = null;
	private String strDefaultMobAppUrl = null;
	private boolean bLowCaseSql = false ;

	public WebConfig(FilterConfig config) {
		if(config != null){
			Enumeration enumeration = config.getInitParameterNames();
			while (enumeration.hasMoreElements()) {
				String strName = (String) enumeration.nextElement();
				String strValue = config.getInitParameter(strName);
				if (strValue != null) {
					extAttrList.put(strName.toUpperCase(), strValue);
				}
			}
			
			this.strWebContextObj = extAttrList.get(WEBCONTEXT);
			this.strFilePath = extAttrList.get(FILEPATH);
			this.strTempPath = extAttrList.get(TEMPPATH);
			this.strServiceContainer = extAttrList.get(SERVICECONTAINER);
			this.strDefaultOperator = extAttrList.get(DEFAULTOPERATOR);
			this.strDefaultOperatorName = extAttrList.get(DEFAULTOPERATORNAME);
			this.strDynaSysInstId = extAttrList.get(DYNASYSINSTID);
			this.strDefaultWebAppUrl = extAttrList.get(DEFAULTWEBAPPURL);
			this.strDefaultMobAppUrl = extAttrList.get(DEFAULTMOBAPPURL);
			this.bLowCaseSql = getAttribute(LOWCASESQL, false) ;
		}
		
		WebConfig.webConfig = this;
	}

	/**
	 * 获取上下文对象
	 * 
	 * @return
	 */
	public String getWebContextObj() {
		return this.strWebContextObj;
	}

	/**
	 * 设置参数
	 * 
	 * @param strKey
	 * @param strDefault
	 * @return
	 */
	public String getAttribute(String strKey, String strDefault) {
		strKey = strKey.toUpperCase();
		String strValue = extAttrList.get(strKey);
		if(strValue==null){
			return strDefault;
		}
		return strValue;
//		if (extAttrList.containsKey(strKey)) {
//			return (String) extAttrList.get(strKey);
//		}
//		return strDefault;
	}

	/**
	 * 获取配置参数（INT）
	 * 
	 * @param strKey
	 * @param nDefault
	 * @return
	 */
	public int getAttribute(String strKey, int nDefault) {
		try {
			return Integer.parseInt(getAttribute(strKey, ((Integer) nDefault).toString()));
		} catch (Exception ex) {
			return nDefault;
		}
	}

	/**
	 * 获取配置参数（Long）
	 * 
	 * @param strKey
	 * @param nDefault
	 * @return
	 */
	public long getAttribute(String strKey, Long nDefault) {
		try {
			return Long.parseLong(getAttribute(strKey, nDefault.toString()));
		} catch (Exception ex) {
			return nDefault;
		}

	}

	/**
	 * 获取配置参数（boolean）
	 * 
	 * @param strKey
	 * @param bDefault
	 * @return
	 */
	public boolean getAttribute(String strKey, boolean bDefault) {
		try {
			return Boolean.parseBoolean(getAttribute(strKey, bDefault ? "True" : "False"));
		} catch (Exception ex) {
			return bDefault;
		}

	}

	/**
	 * 转换字符串到布尔值
	 * 
	 * @param strValue
	 * @param bDefault
	 * @return
	 */
	protected static boolean getValue(String strValue, boolean bDefault) {
		try {
			return Boolean.parseBoolean(strValue);
		} catch (Exception ex) {
			return bDefault;
		}

	}

	/**
	 * 转换字符串到Double
	 * 
	 * @param strValue
	 * @param fDefault
	 * @return
	 */
	protected static double getValue(String strValue, Double fDefault) {
		try {
			return Double.parseDouble(strValue);
		} catch (Exception ex) {
			return fDefault;
		}
	}

	/**
	 * 转换字符串到Int
	 * 
	 * @param strValue
	 * @param fDefault
	 * @return
	 */
	protected static int getValue(String strValue, int nDefault) {
		try {
			return Integer.parseInt(strValue);
		} catch (Exception ex) {
			return nDefault;
		}
	}

	/**
	 * 设置参数
	 * 
	 * @param strName
	 * @param strValue
	 */
	public void setAttribute(String strName, String strValue) {
		if (strValue != null) {
			extAttrList.put(strName.toUpperCase(), strValue);
		}
	}

	/**
	 * 获取当前应用WebP配置对象
	 * 
	 * @return
	 */
	public static WebConfig getCurrent() {
		return WebConfig.webConfig;
	}

	/**
	 * 获取临时文件路径
	 * 
	 * @return
	 */
	public String getTempPath() {
		return this.strTempPath;
	}

	/**
	 * 获取文件存储路径
	 * 
	 * @return
	 */
	public String getFilePath() {
		return strFilePath;
	}

	/**
	 * 获取后台服务容器
	 * 
	 * @return
	 */
	public String getServiceContainer() {
		return this.strServiceContainer;
	}

	
	/**
	 * 获取默认操作者标识
	 * @return
	 */
	public String getDefaultOperator(){
		return this.strDefaultOperator;
	}
	
	/**
	 * 获取默认操作者名称
	 * @return
	 */
	public String getDefaultOperatorName(){
		return this.strDefaultOperatorName;
	}
	
	
	/**
	 * 获取动态系统实例标识
	 * @return
	 */
	public String getDynaSysInstId(){
		return this.strDynaSysInstId;
	}
	
	
	/**
	 * 获取系统的默认Web应用路径
	 * @return
	 */
	public String getDefaultWebAppUrl() {
		return this.strDefaultWebAppUrl;
	}
	
	
	/**
	 * 获取系统的默认移动端应用路径
	 * @return
	 */
	public String getDefaultMobAppUrl() {
		return this.strDefaultMobAppUrl;
	}
	
	/**
	 * Sql是否小写
	 * @return
	 */
	public boolean isLowCaseSql() {
		return this.bLowCaseSql ;
	}
}
