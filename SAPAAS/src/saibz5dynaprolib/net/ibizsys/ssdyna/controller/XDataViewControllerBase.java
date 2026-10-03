package net.ibizsys.ssdyna.controller;

import net.ibizsys.paas.controller.IXDataViewController;


/**
 * 数据相关视图控制器对象实现基类
 * @author Administrator
 *
 */
public abstract class XDataViewControllerBase extends ViewControllerBase implements IXDataViewController {

	private boolean bReadOnly = false;
	
	public XDataViewControllerBase() throws Exception {
		super();
	}

	@Override
	public boolean isReadOnly() {
		return this.bReadOnly;
	}

	/**
	 * 设置视图是否处于只读模式
	 * @param bReadOnly
	 */
	protected void setReadOnly(boolean bReadOnly){
		this.bReadOnly = bReadOnly;
	}

	
	
}
