package net.ibizsys.paas.controller;

/**
 * 索引选择视图控制器对象
 * 
 * @author Administrator
 *
 */
public abstract class IndexPickupDataViewControllerBase extends PickupDataViewControllerBase {
	public IndexPickupDataViewControllerBase() throws Exception {
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
