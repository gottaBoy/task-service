package net.ibizsys.ssdynawf.controller;

import net.ibizsys.ssdyna.controller.DynaViewControllerBase;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;

/**
 * 动态实体流程数据重定向视图控制器基类
 * @author Administrator
 *
 */
public abstract class DynaWFDataRedirectViewControllerBase extends DynaViewControllerBase {

	public DynaWFDataRedirectViewControllerBase() throws Exception {
		super();
	}

	
	@Override
	protected IDynaViewInstModel createDynaViewInstModel() throws Exception {
		return new DynaWFDataRedirectViewControllerInst();
	}
}
