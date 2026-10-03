package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * 服务删除操作参数
 * @author Administrator
 *
 * @param <ET>
 */
public class ServiceRemoveParam <ET extends IEntity> extends ServiceActionParamBase<ET> implements IServiceRemoveParam<ET>{

	private boolean bPrepareLast = false;
	
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

}
