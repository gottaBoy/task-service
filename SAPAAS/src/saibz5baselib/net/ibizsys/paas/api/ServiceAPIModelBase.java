package net.ibizsys.paas.api;

import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 系统服务接口对象模型基类
 * @author Administrator
 *
 */
public abstract class ServiceAPIModelBase  extends ModelBase3Impl implements IServiceAPIModel{

	/**
	 * 设置标识
	 * 
	 * @param strId the strId to set
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName the strName to set
	 */
	protected void setName(String strName) {
		this.strName = strName;
	}
}
