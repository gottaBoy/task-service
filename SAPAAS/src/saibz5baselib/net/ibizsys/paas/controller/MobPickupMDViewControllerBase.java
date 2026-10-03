package net.ibizsys.paas.controller;

/**
 * 移动端用于数据选择的视图控制器基类
 * @author Administrator
 *
 */
public abstract class MobPickupMDViewControllerBase extends MobMDViewControllerBase {

	public MobPickupMDViewControllerBase() throws Exception {
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
