package net.ibizsys.model.control;

import net.ibizsys.model.control.ajax.IPSAjaxControlHandler;
import net.ibizsys.paas.control.IAjaxControl;

/**
 * 异步请求视图部件对象接口
 * @author Administrator
 *
 */
public interface IPSAjaxControl extends IPSControl,IAjaxControl {

	
	/**
	 * 获取异步请求参数
	 * @return
	 */
	IPSAjaxControlParam getPSAjaxControlParam();
	
	
	
	/**
	 * 获取后台处理对象
	 * @return
	 */
	IPSAjaxControlHandler getPSAjaxControlHandler();
	
	
	
	
	/**
	 * 是否为临时模式
	 * @return
	 */
	boolean isTempMode();
	
	
	
	
	
	/**
	 * 是否进行默认加载
	 * @return
	 */
	boolean isAutoLoad();
	
	
	
	/**
	 * 是否启用项权限控制
	 * @return
	 */
	boolean isEnableItemPrivilege();
	

	
	
	/**
	 * 获取接收的异步请求模式
	 * @return
	 */
	int getRecvAjaxActionMode();
	
	
	
	/**
	 * 是否为异步请求控件
	 * @return
	 */
	boolean isAjaxCtrl();
}
