package net.ibizsys.paas.ctrlmodel.toolbar;

import net.ibizsys.paas.view.IDynaUIActionModel;
import net.sf.json.JSONObject;

/**
 * 动态工具栏界面行为模型对象接口
 * @author Administrator
 *
 */
public interface IDynaToolbarUIActionItemModel extends IDynaToolbarItemModel {

	/**
	 * 显示模式:图标+短词
	 */
	public final static String SHOWMODE_ICONANDSHORTWORD = "ICONANDSHORTWORD";

	/**
	 * 显示模式:图标
	 */
	public final static String SHOWMODE_ICON = "ICON";

	/**
	 * 显示模式:短词
	 */
	public final static String SHOWMODE_SHORTWORD = "SHORTWORD";
	
	
	/**
	*行为组展开模式：按项展开
	*/
	public final static String GROUPEXTRACTMODE_ITEM = "ITEM" ;

	/**
	*行为组展开模式：按分组展开
	*/
	public final static String GROUPEXTRACTMODE_ITEMS = "ITEMS" ;
	
	/**
	 * 获取行为操作的显示模式，值参考 net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarUIActionItemModel.SHOWMODE_XXX 定义
	 * @return
	 */
	String getShowMode();
	
	
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
	 * 获取界面行为模型
	 * @return
	 */
	IDynaUIActionModel getUIActionModel();
	
	
	
	/**
	 * 获取界面行为参数
	 * @return
	 */
	JSONObject getUIActionParam();
	
	
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();

	

	/**
	 * 获取标题语言资源标识
	 * @return
	 */
	String getCapLanResTag();



	/**
	 * 获取项操作提示
	 * @return
	 */
	String getTooltip();
	/**
	 * 获取项操作提示语言资源标识
	 * @return
	 */
	String getTooltipLanResTag();

}
