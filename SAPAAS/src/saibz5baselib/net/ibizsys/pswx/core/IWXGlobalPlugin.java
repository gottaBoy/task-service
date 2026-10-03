package net.ibizsys.pswx.core;

/**
 * 微信模块全局对象插件
 * 
 * @author Administrator
 * 
 */
public interface IWXGlobalPlugin {
	/**
	 * 注册微信公众号
	 * 
	 * @param strWXAccountModelClsType
	 * @param iWXAccountModel
	 */
	void registerWXAccountModel(String strWXAccountModelClsType, IWXAccountModel iWXAccountModel);

	/**
	 * 获取微信公众号
	 * 
	 * @param strWXAccountModelClsType
	 * @return
	 * @throws Exception
	 */
	IWXAccountModel getWXAccountModel(Class<?> cls) throws Exception;

	/**
	 * 获取微信公众号
	 * 
	 * @param strWXAccountModelClsType
	 * @return
	 * @throws Exception
	 */
	IWXAccountModel getWXAccountModel(String strWXAccountModelClsType) throws Exception;
}
