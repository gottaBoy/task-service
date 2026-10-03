package net.ibizsys.psba.core;

import net.ibizsys.paas.core.ModelBaseImpl;

/**
 * 大数据模型基类
 * 
 * @author Administrator
 *
 */
public abstract class BAModelBase extends ModelBaseImpl implements IBAModelBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAModelBase#setId(java.lang.String)
	 */
	@Override
	public void setId(String strId) {
		this.strId = strId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAModelBase#setName(java.lang.String)
	 */
	@Override
	public void setName(String strName) {
		this.strName = strName;
	}

}
