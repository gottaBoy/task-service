package net.ibizsys.model.control;

import net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler;


/**
 * 多项数据Ajax部件对象接口
 * @author Administrator
 *
 */
public interface IPSMDAjaxControl extends IPSAjaxControl
{
	/**
	 * 获取多项数据后台处理对象
	 * @return
	 */
	IPSMDAjaxControlHandler getPSMDAjaxControlHandler();
	

	
	/**
	 * 是否发布系统级工作流数据项 srfwfstep,srfwfver
	 * @return
	 */
	boolean hasWFDataItems();
	
}
