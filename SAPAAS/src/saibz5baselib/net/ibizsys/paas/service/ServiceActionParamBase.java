package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * 通用服务操作参数对象，实现了建立(Create)，更新（Update）以及删除（Remove）行为参数接口
 * @author Administrator
 *
 * @param <ET>
 */
public class ServiceActionParamBase<ET extends IEntity> implements IServiceActionParam<ET> {

	private String strAction = null;
	private ET et = null;

	
	
	
	@Override
	public String getAction() {
		return strAction;
	}
	
	public void setAction(String strAction){
		this.strAction = strAction;
	}

	@Override
	public boolean testAction(ET et) throws Exception {
		return true;
	}



	
	@Override
	public ET getEntity() {
		return et;
	}

	
	/**
	 * 设置数据对象
	 * @param et
	 */
	void setEntity(ET et){
		this.et = et;
	}
	
	@Override
	public void doBeforeAction(ET et) throws Exception {
		
	}

	@Override
	public void doAfterAction(ET et) throws Exception {
		
	}

}
