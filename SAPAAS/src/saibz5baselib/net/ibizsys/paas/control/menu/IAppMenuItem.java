package net.ibizsys.paas.control.menu;

/**
 * 应用菜单项接口
 * 
 * @author lionlau
 *
 */
public interface IAppMenuItem extends IMenuItem {
	
	/**
	 * 菜单状态，新建
	 */
	final int STATE_NEW = 1;
	
	
	
	/**
	 * 菜单状态，热门
	 */
	final int STATE_HOT = 2;
	
	
	/**
	 * 获取项集合
	 * 
	 * @return
	 */
	java.util.ArrayList<IAppMenuItem> getItems();

	/**
	 * 获取应用功能编号
	 * 
	 * @return
	 */
	String getAppFuncId();

	/**
	 * 是否为分隔项
	 * 
	 * @return
	 */
	boolean isSeperator();

	/**
	 * 是否隐藏边栏
	 * 
	 * @return
	 */
	boolean isHideSideBar();

	/**
	 * 默认打开
	 * 
	 * @return
	 */
	boolean isOpenDefault();
	
	
	
	/**
	 * 获取应用菜单项状态
	 * @return
	 */
	int getAppMenuItemState();

	
	
	

}
