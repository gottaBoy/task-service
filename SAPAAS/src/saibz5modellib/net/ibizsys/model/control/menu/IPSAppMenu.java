package net.ibizsys.model.control.menu;

import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.menu.IPSAppMenuModel;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenu;

/**
 * 应用菜单对象接口
 * @author lionlau
 *
 */
public interface IPSAppMenu extends IPSAjaxControl,IAppMenu,IPSAppMenuModel
{
	/**
	 * 获取顶级菜单项集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSAppMenuItem> getPSAppMenuItems()throws Exception;
	
	
	
	/**
	 * 获取应用根节点
	 * @return
	 */
	AppMenuRootItem getRootItem();
	
	
	
	/**
	 * 获取应用功能集合
	 * @return
	 */
	java.util.Iterator<IPSAppFunc> getPSAppFuncs();
	
	
	
	/**
	 * 获取指定系统计数器
	 * @return
	 */
	IPSSysCounter getPSSysCounter();
	
	
	
	/**
	 * 获取全部菜单项集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSAppMenuItem> getAllPSAppMenuItems()throws Exception;
}
