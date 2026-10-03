package net.ibizsys.paas.ctrlmodel.toolbar;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.IDynaToolbarModel;

/**
 * 动态工具栏成员对象接口
 * @author Administrator
 *
 */
public interface IDynaToolbarItemModel extends IDynaModel,IDynaModelJsonExporter,IDynaModelJsonLoader{

	/**
	 * 项类型:界面行为
	 */
	public final static String ITEMTYPE_UIACTION = "UIACTION";

	/**
	 * 项类型:分割线
	 */
	public final static String ITEMTYPE_SEPARATOR = "SEPARATOR";
	
	/**
	 * 项类型:分组项
	 */
	public final static String ITEMTYPE_ITEMS = "ITEMS";

	/**
	 * 项类型:直接内容项
	 */
	public final static String ITEMTYPE_RAWITEM = "RAWITEM";


	
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
	 * 模型属性：标题
	 */
	public final static String ATTR_CAPTION = "caption";

	
	/**
	 * 模型属性：提示
	 */
	public final static String ATTR_TOOLTIP = "tooltip";
	
	
	/**
	 * 模型属性：图标式样
	 */
	public final static String ATTR_ICONCLS = "iconcls";
	
	
	/**
	 * 模型属性：图标路径
	 */
	public final static String ATTR_ICONPATH = "iconpath";
	
	
	/**
	 * 模型属性：界面行为
	 */
	public final static String ATTR_UIACTION = "uiaction";
	
	
	
	/**
	 * 模型属性：界面行为参数
	 */
	public final static String ATTR_UIACTIONPARAM = "uiactionparam";
	
	
	/**
	 * 初始化
	 * @param iDynaToolbarModel
	 * @param parentModel
	 * @param modelObject
	 * @throws Exception
	 */
	void init(IDynaToolbarModel iDynaToolbarModel,IDynaToolbarItemModel parentModel,Object modelObject) throws Exception;
	
	/**
	 * 获取成员类型
	 * @return
	 */
	String getItemType();
	
	/**
	 * 获取动态工具栏模型对象
	 * @return
	 */
	IDynaToolbarModel getDynaToolbarModel();
	
	
	/**
	 * 获取父工具栏成员对象
	 * @return
	 */
	IDynaToolbarItemModel getParentModel();
	
	

}
