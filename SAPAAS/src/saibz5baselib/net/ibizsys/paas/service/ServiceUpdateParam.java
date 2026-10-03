package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * 服务更新操作参数
 * @author Administrator
 *
 * @param <ET>
 */
public class ServiceUpdateParam <ET extends IEntity> extends ServiceActionParamBase<ET> implements IServiceUpdateParam<ET>{

	private boolean bPrepareLast = false;
	private boolean bReturnData = true;
	private boolean bSysUpdate = false;
	
	@Override
	public boolean isReturnData() {
		return this.bReturnData;
	}

	@Override
	public boolean isPrepareLast() {
		return this.bPrepareLast;
	}
	
	/**
	 * 设置是否准备最后一次的数据
	 * @param bPrepareLast
	 */
	public void setPrepareLast(boolean bPrepareLast){
		this.bPrepareLast = bPrepareLast;
	}


	
	/**
	 * 设置是否返回数据
	 * @param bReturnData
	 */
	public void setReturnData(boolean bReturnData) {
		this.bReturnData = bReturnData;
	}

	@Override
	public boolean isSysUpdate() {
		return this.bSysUpdate;
	}
	
	/**
	 * 设置是否为系统更新操作
	 * @param bSysUpdate
	 */
	public void setSysUpdate(boolean bSysUpdate) {
		this.bSysUpdate = bSysUpdate;
	}
	
}
