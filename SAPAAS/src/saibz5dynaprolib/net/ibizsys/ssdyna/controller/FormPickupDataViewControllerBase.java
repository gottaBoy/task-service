package net.ibizsys.ssdyna.controller;

/**
 * 表单选择数据视图控制器对象
 * 
 * @author Administrator
 *
 */
public abstract class FormPickupDataViewControllerBase extends PickupDataViewControllerBase {
	public FormPickupDataViewControllerBase() throws Exception {
		super();
	}

	/**
	 * 是否为拾取视图<弹出型的 数据选择视图>
	 * 
	 * @return
	 */
	@Override
	public boolean isPickupView() {
		return true;
	}
}
