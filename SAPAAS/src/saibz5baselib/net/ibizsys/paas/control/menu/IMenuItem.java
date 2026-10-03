package net.ibizsys.paas.control.menu;

/**
 * 菜单项接口
 * 
 * @author lionlau
 *
 */
public interface IMenuItem {
	/**
	 * 菜单项类型：分割项
	 */
	public final static String MENUITEMTYPE_SEPERATOR = "SEPERATOR";

	/**
	 * 菜单项类型：菜单项
	 */
	public final static String MENUITEMTYPE_MENUITEM = "MENUITEM";

	/**
	 * 菜单项类型：用户自定义项
	 */
	public final static String MENUITEMTYPE_USERITEM = "USERITEM";

	/**
	 * 获取菜单项类型，值参考 net.ibizsys.paas.control.menu.IMenuItem.MENUITEMTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getItemType();

	/**
	 * 获取标识
	 * 
	 * @return
	 */
	String getId();

	/**
	 * 获取父标识
	 * 
	 * @return
	 */
	String getPId();

	/**
	 * 获取文本
	 * 
	 * @return
	 */
	String getText();

	/**
	 * 是否展开
	 * 
	 * @return
	 */
	boolean isExpanded();

	/**
	 * 获取文本样式
	 * 
	 * @return
	 */
	String getTextCls();

	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	String getIconCls();

	/**
	 * 获取图标路径
	 * 
	 * @return
	 */
	String getIconPath();

	/**
	 * 获取计数器标识
	 * 
	 * @return
	 */
	String getCounterId();

	/**
	 * 设置属性
	 * 
	 * @param strName
	 * @param objValue
	 */
	void setAttribute(String strName, Object objValue);

	/**
	 * 获取属性
	 * 
	 * @param strName
	 * @return
	 */
	Object getAttribute(String strName);

	/**
	 * 获取功能访问模式
	 * 
	 * @return
	 */
	int getAccUserMode();

	/**
	 * 获取功能访问资源标识
	 * 
	 * @return
	 */
	String getAccessKey();

	
	
	/**
	 * 获取文本语言资源标识
	 * @return
	 */
	String getTextLanResTag();
	
	
	
	/**
	 * 获取菜单项提示
	 * @return
	 */
	String getTooltip();
	
	
	/**
	 * 获取提示语言资源标识
	 * @return
	 */
	String getTooltipLanResTag();
	
	
	
	/**
	 * 是否隐藏
	 * @return
	 */
	boolean isHidden();
	
	
	/**
	 * 获取填充器对象
	 * @return
	 */
	String getFillerObj();
	
	/**
	 * 获取菜单项填充器
	 * @return
	 */
	IMenuItemFiller getFiller() throws Exception;
}
