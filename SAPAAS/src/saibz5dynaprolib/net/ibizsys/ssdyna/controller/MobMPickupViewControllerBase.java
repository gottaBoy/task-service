package net.ibizsys.ssdyna.controller;

/**
 * 移动端多数据选择视图控制器对象
 * 
 * @author Administrator
 *
 */
public abstract class MobMPickupViewControllerBase extends MobPickupViewControllerBase {

	public MobMPickupViewControllerBase() throws Exception {
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
