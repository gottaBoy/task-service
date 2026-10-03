package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSDEUIActionItem;
import net.ibizsys.model.app.view.IPSWFUIActionItem;

/**
 * 实体上下文界面行为菜单项对象接口
 * @author Administrator
 *
 */
public interface IPSDECMUIActionItem extends IPSDEContextMenuItem,IPSDEUIActionItem,IPSWFUIActionItem{
	
	//定义行为组展开模式代码表

	/**
	*行为组展开模式：按项展开
	*/
	public final static String GROUPEXTRACTMODE_ITEM = "ITEM" ;

	/**
	*行为组展开模式：按分组展开
	*/
	public final static String GROUPEXTRACTMODE_ITEMS = "ITEMS" ;
	
	
	/**
	 * 获取菜单项集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems()throws Exception;
	
	
	
	
	/**
	 * 获取前端应用界面
	 * @return
	 * @throws Exception
	 */
	IPSAppView getFrontPSAppView()throws Exception;
	
	
	
	/**
	 * 是否启用Toggle模式
	 * @return
	 */
	boolean isEnableToggleMode();
	
	
	/**
	 * 是否为隐藏项
	 * @return
	 */
	boolean isHiddenItem();
	
	
	
	
	
	/**
	 * 获取界面行为组展开模式，值参考  SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMUIActionItem.GROUPEXTRACTMODE_XXX 定义
	 * @return
	 */
	String getGroupExtractMode();
}
