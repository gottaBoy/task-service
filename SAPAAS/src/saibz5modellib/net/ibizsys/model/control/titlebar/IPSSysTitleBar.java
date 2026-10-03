package net.ibizsys.model.control.titlebar;

import net.ibizsys.model.control.toolbar.IPSDEToolbar;

/**
 * 系统标题栏对象接口
 * @author Administrator
 *
 */
public interface IPSSysTitleBar extends IPSTitleBar {

	/**
	 * 获取左侧实体工具栏
	 * @return
	 */
	IPSDEToolbar getLeftPSDEToolbar();
	
	
	/**
	 * 获取右侧实体工具栏
	 * @return
	 */
	IPSDEToolbar getRightPSDEToolbar();
	
}
