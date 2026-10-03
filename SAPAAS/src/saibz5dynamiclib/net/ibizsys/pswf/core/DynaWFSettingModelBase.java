package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.sysmodel.IDynaSystemSettingModel;

/**
 * 动态工作流设置模型对象接口实现基类
 * @author Administrator
 *
 */
public abstract class DynaWFSettingModelBase extends ModelBase3Impl implements IDynaWFSettingModel {

	private IDynaSystemSettingModel iDynaSystemSettingModel = null;
	
	@Override
	public void init(IDynaSystemSettingModel iDynaSystemSettingModel) throws Exception {
		this.iDynaSystemSettingModel = iDynaSystemSettingModel;
		this.onInit();
	}
	
	@Override
	public IDynaSystemSettingModel getDynaSystemSettingModel() {
		return this.iDynaSystemSettingModel;
	}
	
	@Override
	public String getWFDEName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWFVersionDEName() {
		// TODO Auto-generated method stub
		return null;
	}

}
