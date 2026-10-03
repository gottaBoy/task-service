package net.ibizsys.ssdyna.controller;

/**
 * 选择表格视图控制器对象
 * 
 * @author Administrator
 *
 */
public abstract class PickupGridViewControllerBase extends ViewControllerBase {
	public PickupGridViewControllerBase() throws Exception {
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
