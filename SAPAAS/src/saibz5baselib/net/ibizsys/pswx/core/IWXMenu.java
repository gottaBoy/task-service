package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.IModelBase;

/**
 * 微信菜单模型接口
 * 
 * @author Administrator
 * 
 */
public interface IWXMenu extends IModelBase {

	/**
	 * 获取微信公众号对象
	 * 
	 * @return
	 */
	IWXAccount getWXAccount();

	/**
	 * 获取微信企业应用对象
	 * 
	 * @return
	 */
	IWXEntApp getWXEntApp();

	/**
	 * 获取菜单项模型
	 * 
	 * @return
	 */
	java.util.Iterator<IWXMenuItem> getWXMenuItems();

}
