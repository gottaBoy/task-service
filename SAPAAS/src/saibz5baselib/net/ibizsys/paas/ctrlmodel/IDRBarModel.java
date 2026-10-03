package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;

/**
 * 数据关系栏部件模型
 * 
 * @author lionlau
 *
 */
public interface IDRBarModel extends IDRCtrlModel {
	/**
	 * 获取根项
	 * 
	 * @return
	 */
	DRCtrlRootItem getRootItem();
}
