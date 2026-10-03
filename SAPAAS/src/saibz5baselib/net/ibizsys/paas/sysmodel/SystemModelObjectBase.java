package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 系统模型相关对象积累
 * @author Administrator
 *
 */
public abstract class SystemModelObjectBase extends ModelBase3Impl implements ISystemModelObject {

	private ISystemModel iSystemModel = null;
	
	
	/**
	 * 设置系统模型对象
	 * @param iSystemModel
	 */
	protected void setSystemModel(ISystemModel iSystemModel){
		this.iSystemModel = iSystemModel;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.ISystemObject#getSystem()
	 */
	@Override
	public ISystem getSystem() {
		return this.iSystemModel;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModelObject#getSystemModel()
	 */
	@Override
	public ISystemModel getSystemModel() {
		return this.iSystemModel;
	}
	
	
}
