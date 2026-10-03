package net.ibizsys.paas.api;

import net.ibizsys.paas.core.ModelBase2Impl;


/**
 * 服务接口方法模型对象
 * @author Administrator
 *
 */
public class ServiceAPIActionModel extends ModelBase2Impl implements IServiceAPIAction {

	private String strActionType = null;
	private String strUniqueTag = null;
	private String strDEName = null;
	
	@Override
	public String getActionType() {
		return this.strActionType;
	}
	
	
	/**
	 * 设置行为类型
	 * @param strActionType
	 */
	public void setActionType(String strActionType){
		this.strActionType = strActionType;
	}
	
	
	/**
	 * 设置行为标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	
	/**
	 * 设置行为名称
	 * @param strId
	 */
	public void setName(String strName){
		this.strName = strName;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.api.IServiceAPIAction#getUniqueTag()
	 */
	@Override
	public String getUniqueTag() {
		return this.strUniqueTag;
	}
	
	
	/**
	 * 设置行为的唯一标记
	 * @param strUniqueTag
	 */
	public void setUniqueTag(String strUniqueTag){
		this.strUniqueTag = strUniqueTag;
	}


	@Override
	public String getDEName() {
		return this.strDEName;
	}
	
	
	/**
	 * 设置实体名称
	 * @param strDEName
	 */
	public void setDEName(String strDEName){
		this.strDEName = strDEName;
	}
	
	

}
