package net.ibizsys.model.app.view;

import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.control.menu.IPSAppMenu;

/**
 * 应用首页视图对象接口
 * @author lionlau
 *
 */
public interface IPSAppIndexView extends IPSAppView
{
	/**
	 * 获取应用功能集合
	 * @return
	 */
	java.util.Iterator<IPSAppFunc> getPSAppFuncs();
	
	
	/**
	 * 获取应用菜单
	 * @return
	 */
	IPSAppMenu getPSAppMenu();
	
	
	
	
	/**
	 * 是否为默认视图
	 * @return
	 */
	boolean isDefaultPage();
	
	
	
	
	/**
	 * 获取应用图标1
	 * @return
	 */
	String getAppIconPath();
	
	
	
	/**
	 * 获取应用图标2
	 * @return
	 */
	String getAppIconPath2();
	
	
	
	
//	/**
//	 * 获取门户计数器引用
//	 * @return
//	 */
//	IPSSysCounterRef getPortalPSSysCounterRef();
	
	
	
	
	/**
	 * 获取主菜单对齐方向
	 * @return
	 */
	String getMainMenuAlign();
	
	
	
	/**
	 * 获取默认打开的视图对象
	 * @return
	 */
	IPSAppView getDefPSAppView();
}
