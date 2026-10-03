package net.ibizsys.psba.core;

/**
 * 大数据表相关模型对象基类
 * 
 * @author Administrator
 *
 */
public abstract class BATableObjectModelBase extends BAModelBase implements IBATableObject {

	private IBATable iBATable = null;

	/**
	 * 设置大数据表对象
	 * 
	 * @param iBATable
	 */
	protected void setBATable(IBATable iBATable) {
		this.iBATable = iBATable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATableObject#getBATable()
	 */
	@Override
	public IBATable getBATable() {
		return this.iBATable;
	}

}
