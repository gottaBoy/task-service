package net.ibizsys.model.control.ajax;

/**
 * 单数据处理后台对象接口
 * @author lionlau
 *
 */
public interface IPSSDAjaxControlHandler extends IPSAjaxControlHandler
{
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
	 * 复制数据
	 */
	final static String ACTION_CLONE = "clone";
	
	
	
	/**
	 * 启动流程
	 */
	final static String ACTION_WFSTART = "wfstart";
	
	
	
	
	/**
	 * 获取读取超时时间
	 * @return
	 */
	int getReadTimeout();
	
	
	
	/**
	 * 获取建立超时时间
	 * @return
	 */
	int getCreateTimeout();
	
	
	
	/**
	 * 获取更新超时时间
	 * @return
	 */
	int getUpdateTimeout();
	
	
	
	/**
	 * 获取删除超时时间
	 * @return
	 */
	int getRemoveTimeout();
}
