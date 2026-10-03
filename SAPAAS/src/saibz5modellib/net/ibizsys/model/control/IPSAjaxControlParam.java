package net.ibizsys.model.control;

import net.ibizsys.paas.control.IAjaxControlHandlerParam;

/**
 * 异步请求部件参数接口对象
 * @author lionlau
 *
 */
public interface IPSAjaxControlParam extends IPSControlParam,IAjaxControlHandlerParam
{
	/**
	 * 是否启用项权限控制
	 * @return
	 */
	Boolean isEnableItemPrivilege();
	
	
	/**
	 * 获取接收的异步请求模式
	 * @return
	 */
	Integer getRecvAjaxActionMode();
	

	
	/**
	 * Ajax 控件处理对象
	 * @return
	 */
	String getPSAjaxControlHandlerId();
	
	
	
	
	/**
	 * 是否进行默认加载
	 * @return
	 */
	boolean isAutoLoad();
	

}
