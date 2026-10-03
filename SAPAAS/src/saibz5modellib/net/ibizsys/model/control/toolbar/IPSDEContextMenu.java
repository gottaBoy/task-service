package net.ibizsys.model.control.toolbar;

/**
 * 实体上下文菜单对象接口
 * @author Administrator
 *
 */
public interface IPSDEContextMenu extends IPSDEToolbar {
	
	
	/**
	 * 获取上下文菜单项集合
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	java.util.Iterator<IPSDEContextMenuItem> getPSContextMenuItems()throws Exception;
	
	
	
	/**
	 * 获取上下文菜单项集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems()throws Exception;
}
