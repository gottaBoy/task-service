package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;

/**
 * 实体工具栏控件对象接口 
 * @author lionlau
 *
 */
public interface IPSDEToolbar extends IPSControl
{
	/**
	*工具栏样式：工具栏
	*/
	final static String TOOLBARSTYLE_TOOLBAR = "TOOLBAR" ;

	/**
	*工具栏样式：菜单
	*/
	final static String TOOLBARSTYLE_MENU = "MENU" ;

	/**
	*工具栏样式：上下文菜单
	*/
	final static String TOOLBARSTYLE_CONTEXTMENU = "CONTEXTMENU" ;

	/**
	*工具栏样式：移动端导航栏左侧菜单
	*/
	final static String TOOLBARSTYLE_MOBNAVLEFTMENU = "MOBNAVLEFTMENU" ;

	/**
	*工具栏样式：移动端导航栏右侧菜单
	*/
	final static String TOOLBARSTYLE_MOBNAVRIGHTMENU = "MOBNAVRIGHTMENU" ;

	/**
	*工具栏样式：移动端流程操作菜单
	*/
	final static String TOOLBARSTYLE_MOBWFACTIONMENU = "MOBWFACTIONMENU" ;
	
	/**
	 * 获取工具栏样式
	 * @return
	 */
	String getToolbarStyle();
	
	
	/**
	 * 获取工具栏项集合（顶级）
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEToolbarItem> getPSDEToolbarItems()throws Exception;
	
	
	/**
	 * 获取全部工具栏项集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEToolbarItem> getAllPSDEToolbarItems()throws Exception;
	
	/**
	 * 获取要求的界面行为组
	 * @param strPSSysDEUIActionId
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup(String strPSSysDEUIActionId)throws Exception;
}
