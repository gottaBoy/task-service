package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * 服务建立行为参数
 * @author Administrator
 *
 * @param <ET>
 */
public class ServiceCreateParam <ET extends IEntity> extends ServiceActionParamBase<ET> implements IServiceCreateParam<ET>{

	private boolean bReturnData = true;
	
	@Override
	public boolean isReturnData() {
		return this.bReturnData;
	}


	/**
	 * 设置是否返回数据
	 * @param bReturnData
	 */
	public void setReturnData(boolean bReturnData) {
		this.bReturnData = bReturnData;
	}
}
