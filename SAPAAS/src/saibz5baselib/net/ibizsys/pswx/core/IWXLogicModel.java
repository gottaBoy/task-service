package net.ibizsys.pswx.core;

/**
 * 微信处理逻辑
 * 
 * @author Administrator
 * 
 */
public interface IWXLogicModel extends IWXLogic {

	/**
	 * 获取微信公众号对象
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

}
