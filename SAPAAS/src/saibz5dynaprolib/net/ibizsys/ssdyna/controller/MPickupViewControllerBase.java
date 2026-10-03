package net.ibizsys.ssdyna.controller;

/**
 * 多选视图控制器对象
 * 
 * @author Administrator
 *
 */
public abstract class MPickupViewControllerBase extends PickupViewControllerBase {
	public MPickupViewControllerBase() throws Exception {
		super();
	}

	/**
	 * 是否支持多项选择
	 * 
	 * @return
	 */
	@Override
	protected boolean isEnableMultiSelect() {
		return true;
	}
}
