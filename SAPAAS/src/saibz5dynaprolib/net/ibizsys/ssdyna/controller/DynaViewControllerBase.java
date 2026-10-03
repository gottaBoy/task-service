package net.ibizsys.ssdyna.controller;

/**
 * 动态控制器基类
 * @author Administrator
 *
 */
public abstract class DynaViewControllerBase extends ViewControllerBase {

	public DynaViewControllerBase() throws Exception {
		super();
	}

	
	@Override
	public boolean isEnableDynaView() {
		return true;
	}
}
