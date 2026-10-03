package net.ibizsys.paas.ctrlhandler;

/**
 * 单数据处理对象接口
 * 
 * @author Administrator
 *
 */
public interface ISDCtrlHandler extends ICtrlHandler {
	/**
	 * 获取数据
	 */
	final static String ACTION_LOAD = "load";

	/**
	 * 建立数据
	 */
	final static String ACTION_CREATE = "create";

	/**
	 * 更新数据
	 */
	final static String ACTION_UPDATE = "update";

	/**
	 * 删除数据
	 */
	final static String ACTION_REMOVE = "remove";

	/**
	 * 用户界面行为
	 */
	final static String ACTION_UIACTION = "uiaction";
	
	
	/**
	 * 加载运行时界面行为模型
	 */
	final static String ACTION_LOADUIACTION = "loaduiaction";

	/**
	 * 是否启用列权限控制
	 * 
	 * @return
	 */
	boolean isEnableItemPriv();
}
