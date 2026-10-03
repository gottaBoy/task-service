package net.ibizsys.ssdynawf.controller;

import net.ibizsys.ssdyna.controller.DynaViewControllerBase;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;

/**
 * 动态工作流代理视图控制器基类
 * 
 * @author Administrator
 *
 */
public abstract class DynaWFProxyDataViewControllerBase extends DynaViewControllerBase {

	public DynaWFProxyDataViewControllerBase() throws Exception {
		super();
	}

	@Override
	protected IDynaViewInstModel createDynaViewInstModel() throws Exception {
		return new DynaWFProxyDataViewControllerInst();
	}

}
