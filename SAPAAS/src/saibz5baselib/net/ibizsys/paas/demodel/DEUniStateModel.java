package net.ibizsys.paas.demodel;

import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 实体统一状态模型对象接口实现
 * 
 * @author Administrator
 *
 */
public class DEUniStateModel extends ModelBase3Impl implements IDEUniStateModel {
	
	private IDataEntity iDataEntity = null;
	private boolean bDefault = false;
	private ISystemModel iSystemModel = null;
	private IUniStateModel iUniStateModel = null;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUniState#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.iDataEntity = iDataEntity;
		this.iSystemModel = (ISystemModel)this.iDataEntity.getSystem();
		this.onInit();
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUniState#isDefault()
	 */
	@Override
	public boolean isDefault() {
		return bDefault;
	}

	

	/**
	 * 设置是否默认状态
	 * 
	 * @param bDefault the bDefault to set
	 */
	public void setDefault(boolean bDefault) {
		this.bDefault = bDefault;
	}

	@Override
	public IDataEntity getDataEntity() {
		return this.iDataEntity;
	}

	@Override
	public IUniStateModel getUniStateModel() throws Exception {
		if(this.iUniStateModel == null){
			this.iUniStateModel = this.iSystemModel.getUniStateModel(this.getId());
		}
		return this.iUniStateModel;
	}

	

}
