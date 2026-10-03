package net.ibizsys.paas.control.menu;

import net.ibizsys.paas.control.IControl;

/**
 * 主菜单控件接口
 * 
 * @author lionlau
 *
 */
public interface IAppMenu extends IControl {
	/**
	 * 获取主菜单项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IAppMenuItem> getAppMenuItems();

}
