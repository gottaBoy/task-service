package net.ibizsys.paas.controller;

/**
 * 选择数据视图控制器对象
 * 
 * @author Administrator
 *
 */
public abstract class PickupDataViewControllerBase extends ViewControllerBase {
	public PickupDataViewControllerBase() throws Exception {
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
