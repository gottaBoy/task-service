package net.ibizsys.paas.controller;

/**
 *  态视数据相关动图控制器实例对象实现基类
 * @author Administrator
 *
 */
public abstract class DynaXDataViewControllerInstBase extends DynaViewControllerInstBase implements IXDataViewController {

	public DynaXDataViewControllerInstBase() throws Exception {
		super();
	}

	private boolean bReadOnly = false;
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IXDataViewController#isReadOnly()
	 */
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
