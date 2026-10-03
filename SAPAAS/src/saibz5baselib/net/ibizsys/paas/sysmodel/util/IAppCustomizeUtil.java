package net.ibizsys.paas.sysmodel.util;

import net.ibizsys.paas.control.menu.IAppMenu;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.sysmodel.ISystemUtil;

/**
 * 系统应用个性化功能组件
 * @author Administrator
 *
 */
public interface IAppCustomizeUtil  extends ISystemUtil {

	/**
	 * 系统应用个性化功能
	 */
	final static String UTILTYPE_APPCUSTOMIZE = "APPCUSTOMIZE";
	
	
	
	/**
	 * 获取应用菜单菜单项集合
	 * @param iAppMenu
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IAppMenuItem> getAppMenuItems(IAppMenu iAppMenu)throws Exception;
	
	
	/**
	 * 安装全部应用可配置数据
	 * @throws Exception
	 */
	void installAll()throws Exception;
	
	
	/**
	 * 安装应用菜单
	 * @param iAppMenu
	 * @throws Exception
	 */
	void installAppMenu(IAppMenu iAppMenu)throws Exception;
	
	
	
	
	/**
	 * 安装全部应用菜单
	 * @throws Exception
	 */
	void installAllAppMenus()throws Exception;
	
	
	/**
	 * 重置缓存
	 * @throws Exception
	 */
	void resetCache()throws Exception;
}
