package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.bean.WXOutMsg;

/**
 * 微信公众号企业应用模型接口
 * 
 * @author Administrator
 * 
 */
public interface IWXEntAppModel extends IWXEntApp {

	/**
	 * 获取微信公众号模型
	 * 
	 * @return
	 */
	IWXAccountModel getWXAccountModel();

	/**
	 * 获取授权方应用标识
	 * 
	 * @return
	 */
	int getAgentId();

	/**
	 * 设置授权方应用标识
	 * 
	 * @param nAgentId
	 */
	void setAgentId(int nAgentId);

	/**
	 * 是否报告位置
	 * 
	 * @param bReportLocation
	 */
	void setReportLocation(boolean bReportLocation);

	/**
	 * 是否报告进入
	 * 
	 * @param bReportEnter
	 */
	void setReportEnter(boolean bReportEnter);

	/**
	 * 设置企业应用URL
	 * 
	 * @param strAppURL
	 */
	void setAppURL(String strAppURL);

	/**
	 * 处理微信消息
	 * 
	 * @param wxMessage
	 * @throws Exception
	 */
	void processWXMessage(WXMessage wxMessage) throws Exception;

	/**
	 * 设置应用密钥
	 * 
	 * @param secret
	 */
	void setAppSecret(String secret);

	/**
	 * 设置票据
	 * 
	 * @param token 票据
	 */
	void setToken(String token);

	/**
	 * 设置回调密钥
	 * 
	 * @param key
	 */
	void setEncodingAESKey(String key);

	/**
	 * 获取访问票据
	 * 
	 * @return
	 */
	String getAccessToken();

	/**
	 * 创建脚本
	 * 
	 * @param url
	 * @return
	 */
	String createJsToken(String url);

	/**
	 * 发送通知消息到微信
	 * 
	 * @param wxOutMsg
	 * @return
	 */
	CallResult sendMsg(WXOutMsg wxOutMsg);

	/**
	 * 下载多媒体文件
	 * 
	 * @return
	 */
	CallResult downloadMedia(String mediaId);

	/**
	 * 发布应用菜单
	 * 
	 * @return
	 */
	CallResult publishMenu();

	/**
	 * 删除应用菜单
	 * 
	 * @return
	 */
	CallResult deleteMenu();

	/**
	 * 获取应用菜单
	 * 
	 * @return
	 */
	CallResult getMenu();
	
	
	
	/**
	 * 获取运行时标识
	 * @return
	 */
	Object getRuntimeId();
	
	
	/**
	 * 设置运行时标识
	 * @param objId
	 */
	void setRuntimeId(Object objId);
	
}
