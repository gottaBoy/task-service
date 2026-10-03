package net.ibizsys.model.app.view;

import net.ibizsys.model.app.func.IPSAppFunc;

/**
 * 应用门户视图对象接口
 * @author lionlau
 *
 */
public interface IPSAppPortalView extends IPSAppView
{
	/**
	 * 获取应用功能集合
	 * @return
	 */
	java.util.Iterator<IPSAppFunc> getPSAppFuncs();

	
	
	/**
	 * 是否为默认视图
	 * @return
	 */
	boolean isDefaultPage();
}
