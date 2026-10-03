package net.ibizsys.ssdyna.controller;

/**
 * 移动端用于数据选择的树视图控制器基类
 * @author Administrator
 *
 */
public abstract class MobPickupTreeViewControllerBase extends MobTreeViewControllerBase {
	
	public MobPickupTreeViewControllerBase() throws Exception {
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
