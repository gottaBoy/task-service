package net.ibizsys.model.control.toolbar;


/**
 * 实体上下文菜单项对象接口
 * @author Administrator
 *
 */
public interface IPSDEContextMenuItem  extends IPSDEToolbarItem{
	
	/**
	 * 获取上下文菜单对象
	 * @return
	 */
	IPSDEContextMenu getPSDEContextMenu();
	
	
	
	/**
	 * 获取父菜单项对象
	 * @return
	 */
	IPSDEContextMenuItem getParentPSDEContextMenuItem();
}
