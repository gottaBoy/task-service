package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.menu.IPSAppMenu;

/**
 * 数据看板应用菜单门户部件对象接口
 * @author Administrator
 *
 */
public interface IPSDBAppMenuPortletPart extends IPSDBPortletPart
{
	
	/**
	 * 获取应用菜单对象
	 * @return
	 */
	IPSAppMenu getPSAppMenu();
	
	
	
//	/**
//	 * 获取菜单绘制器
//	 * @return
//	 */
//	IPSSysPFPlugin getAMSysPFPlugin();
	
	
	
	
	/**
	 * 获取菜单列表样式
	 * @return
	 */
	String getAMListStyle();
	
}
