package net.ibizsys.ssdyna.controller;

/**
 * 选择树视图控制器对象
 * 
 * @author Administrator
 *
 */
public abstract class PickupTreeViewControllerBase extends ViewControllerBase {
	public PickupTreeViewControllerBase() throws Exception {
		super();
	}

	/**
	 * 是否为拾取视图
	 * 
	 * @return
	 */
	@Override
	public boolean isPickupView() {
		return true;
	}
}
