package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.ibizsys.paas.control.drctrl.IDRCtrl;

/**
 * 关系数据控件接口
 * @author Administrator
 *
 */
public interface IPSDRCtrl  extends IPSAjaxControl,IDRCtrl
{
	/**
	 * 是否包括主信息
	 * @return
	 */
	boolean isIncludeMajor();
	
	

	/**
	 * 获取系统计数器引用对象
	 * @return
	 */
	IPSSysCounterRef getPSSysCounterRef();
	
	
	/**
	 * 获取根节点 
	 * @return
	 */
	DRCtrlRootItem getRootItem();
}
