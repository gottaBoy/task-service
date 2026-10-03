package net.ibizsys.model.control.ajax;

import net.ibizsys.model.core.IPSModelObject;

/**
 * 异步处理对象行为接口
 * @author Administrator
 *
 */
public interface IPSAjaxHandlerAction extends IPSModelObject {


	
	
	
	/**
	 * 获取行为类型
	 * @return
	 */
	String getActionType();
	
	
	/**
	 * 获取行为的超时时长
	 * @return
	 */
	int getTimeout();
	
	
	/**
	 * 该行为是否有效
	 * @return
	 */
	boolean isValid();
	
	
	
	/**
	 * 获取行为信息
	 * @return
	 */
	String getActionDesc();
	

	
	
	/**
	 * 获取后台处理对象
	 * @return
	 */
	IPSAjaxHandler getPSAjaxHandler();
}
