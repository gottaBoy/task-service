package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 属性值规则模型对象
 * 
 * @author Administrator
 *
 */
public abstract class DEFValueRuleModelBase extends ModelBase3Impl implements IDEFValueRuleModel {
	private IDataEntity iDataEntity = null;
	private IDEField iDEField = null;

	/**
	 * 初始化
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {

	}

	/**
	 * 设置实体模型对象
	 * 
	 * @param iDataEntity
	 */
	public void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getDataEntity()
	 */
	@Override
	public IDataEntity getDataEntity() {
		return this.iDataEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.valuerule.IDEFValueRule#getDEField()
	 */
	@Override
	public IDEField getDEField() {
		return this.iDEField;
	}

	/**
	 * 设置属性
	 * 
	 * @param iDEField
	 */
	public void setDEField(IDEField iDEField) {
		this.iDEField = iDEField;
	}

}
