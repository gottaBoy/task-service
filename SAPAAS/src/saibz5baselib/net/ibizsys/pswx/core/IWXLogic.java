package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.IModelBase;

/**
 * 微信处理逻辑
 * 
 * @author Administrator
 * 
 */
public interface IWXLogic extends IModelBase {

	/**
	 * 进入应用
	 */
	final static String EVENTTYPE_APP_IN = "app_in";

	/**
	 * 上报地理位置
	 */
	final static String EVENTTYPE_LOCATION_IN = "location_in";

	/**
	 * 异步任务完成事件推送
	 */
	final static String EVENTTYPE_ASYNCTASK_FINISH = "asynctask_finish";

	/**
	 * 菜单事件
	 */
	final static String EVENTTYPE_MENU_CLICK = "menu_click";

	/**
	 * 消息进入
	 */
	final static String EVENTTYPE_MESSAGE_IN = "message_in";

	/**
	 * 获取微信公众号对象
	 * 
	 * @return
	 */
	IWXAccount getWXAccount();

	/**
	 * 获取微信企业应用对象
	 * 
	 * @return
	 */
	IWXEntApp getWXEntApp();

	/**
	 * 获取逻辑事件类型
	 * 
	 * @return
	 */
	String getEventType();

	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	String getDEName();

	/**
	 * 获取实体行为名称
	 * 
	 * @return
	 */
	String getDEActionName();

	/**
	 * 获取菜单的功能类型
	 * 
	 * @return
	 */
	String getWXFunc();

	/**
	 * 获取菜单的功能类型
	 * 
	 * @return
	 */
	String getClickTag();

	/**
	 * 获取用户标记
	 * 
	 * @return
	 */
	String getUserTag();
}
