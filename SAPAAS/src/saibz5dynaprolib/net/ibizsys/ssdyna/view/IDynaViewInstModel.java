package net.ibizsys.ssdyna.view;

import net.ibizsys.paas.controller.IDynaViewControllerInst;

/**
 * 动态视图实例模型接口
 * @author Administrator
 *
 */
public interface IDynaViewInstModel extends IDynaViewModel,IDynaViewControllerInst {

	/**
	 * 获取动态视图模型对象
	 * @return
	 */
	IDynaViewModel getDynaViewModel();
}
