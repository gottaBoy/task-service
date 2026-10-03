package net.ibizsys.model.control.toolbar;

import java.util.Iterator;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSDEUIActionItem;
import net.ibizsys.model.app.view.IPSWFUIActionItem;

/**
 * 实体工具栏界面行为项对象接口
 * @author lionlau
 *
 */
public interface IPSDETBUIActionItem extends IPSDEToolbarItem,IPSDEUIActionItem,IPSWFUIActionItem
{
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
	 * 获取工具栏项集合
	 * @return
	 * @throws Exception
	 */
	Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception;
	
	
	
	
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
	 * 获取无权限时的显示模式：具体值参考 SA.SRFDA.PS.Core.View.IPSUIAction.NOPRIVDISPLAYMODE_XXX 定义
	 * @return
	 */
	int getNoPrivDisplayMode();
	
	
	
	/**
	 * 获取界面行为组展开模式，值参考  SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem.GROUPEXTRACTMODE_XXX 定义
	 * @return
	 */
	String getGroupExtractMode();
	
	
	
//	/**
//	 * 是否为分组项
//	 * @return
//	 */
//	boolean isGroupItem();
}
