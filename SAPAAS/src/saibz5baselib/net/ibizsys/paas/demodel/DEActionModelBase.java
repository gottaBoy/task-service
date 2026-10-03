package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEAction;
import net.ibizsys.paas.core.IDEActionCaller;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBaseImpl;

/**
 * 实体操作模型基类
 * 
 * @author Administrator
 *
 */
public abstract class DEActionModelBase extends ModelBaseImpl implements IDEAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntityObject#getDataEntity()
	 */
	@Override
	public IDataEntity getDataEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEAction#getActionType()
	 */
	@Override
	public String getActionType() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEAction#getCallerObject()
	 */
	@Override
	public String getCallerObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEAction#getDEActionCaller()
	 */
	@Override
	public IDEActionCaller getDEActionCaller() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEAction#releaseDEActionCaller(net.ibizsys.paas.core.IDEActionCaller)
	 */
	@Override
	public void releaseDEActionCaller(IDEActionCaller iDEActionCaller) {
		// TODO Auto-generated method stub

	}

}
