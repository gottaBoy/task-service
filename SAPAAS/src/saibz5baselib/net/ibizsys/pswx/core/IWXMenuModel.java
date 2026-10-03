package net.ibizsys.pswx.core;

import net.sf.json.JSONObject;

/**
 * 微信菜单模型接口
 * 
 * @author Administrator
 * 
 */
public interface IWXMenuModel extends IWXMenu {

	/**
	 * 获取微信公众号模型
	 * 
	 * @return
	 */
	IWXAccountModel getWXAccountModel();

	/**
	 * 获取微信企业应用模型
	 * 
	 * @return
	 */
	IWXEntAppModel getWXEntAppModel();

	/**
	 * 转换成JSON对象
	 * 
	 * @return
	 */
	JSONObject toJSON();
}
