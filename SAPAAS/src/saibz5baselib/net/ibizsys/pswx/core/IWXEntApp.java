package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.IModelBase;

/**
 * 微信公众号企业应用对象接口
 * 
 * @author Administrator
 * 
 */
public interface IWXEntApp extends IModelBase {

	/**
	 * H5主页型
	 */
	public final static String APPTYPE_H5 = "H5";

	/**
	 * 消息响应型
	 */
	public final static String APPTYPE_MSG = "MSG";

	/**
	 * 获取微信公众号
	 * 
	 * @return
	 */
	IWXAccount getWXAccount();

	/**
	 * 获取应用的访问路径
	 * 
	 * @return
	 */
	String getAppURL();

	/**
	 * 获取应用程序类型
	 * 
	 * @return
	 */
	String getAppType();

	/**
	 * 是否报告位置
	 * 
	 * @return
	 */
	boolean isReportLocation();

	/**
	 * 是否报告进入程序
	 * 
	 * @return
	 */
	boolean isReportEnter();

	/**
	 * 获取应用密钥
	 * 
	 * @return
	 */
	String getAppSecret();

	/**
	 * 获取票据
	 * 
	 * @return
	 */
	String getToken();

	/**
	 * 获取回调密钥
	 * 
	 * @return
	 */
	String getEncodingAESKey();

	/**
	 * 获取默认的微信菜单
	 * 
	 * @return
	 */
	IWXMenu getDefaultWXMenu();

}
