package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 动态系统实例对象接口实现基类
 * @author Administrator
 *
 */
public abstract class DynaInstBase extends ModelBase3Impl implements IDynaInst {

	private IDynaSystemSetting iDynaSystemSetting = null;
	private String strDynaSystemInstId = null;
	private ISystemModel iSystemModel = null;
	
	@Override
	public void init(ISystemModel iSystemModel, String strDynaSystemInstId) throws Exception {
		this.iSystemModel = iSystemModel;
		this.iDynaSystemSetting = this.iSystemModel.getDynaSystemSetting();
		this.strDynaSystemInstId = strDynaSystemInstId;
		this.strId = strDynaSystemInstId;
		this.onInit();
	}
	
	
	
	@Override
	public ISystemModel getSystemModel() {
		return this.iSystemModel;
	}



	@Override
	public IDynaSystemSetting getDynaSystemSetting() {
		return iDynaSystemSetting;
	}
	
	


	@Override
	public IDynaInst getParentDynaInst() {
		return null;
	}

}
