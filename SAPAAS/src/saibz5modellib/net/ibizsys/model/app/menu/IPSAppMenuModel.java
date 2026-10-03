package net.ibizsys.model.app.menu;

import net.ibizsys.model.app.IPSApplicationObject;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;

/**
 * 应用菜单模型对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSAppMenuModel extends IPSApplicationObject {
	

	/**
	 * 获取应用菜单项集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSAppMenuItem> getPSAppMenuItems() throws Exception;

	/**
	 * 获取应用菜单项根节点
	 * 
	 * @return
	 */
	AppMenuRootItem getRootItem();

	/**
	 * 获取应用功能集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSAppFunc> getPSAppFuncs();

//	/**
//	 * 获取指定系统计数器
//	 * 
//	 * @return
//	 */
//	IPSSysCounter getPSSysCounter();

	/**
	 * 获取代码名称
	 * 
	 * @return
	 */
	String getCodeName();
}
