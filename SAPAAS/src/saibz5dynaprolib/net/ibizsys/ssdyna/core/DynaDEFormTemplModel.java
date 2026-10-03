package net.ibizsys.ssdyna.core;

import net.ibizsys.paas.core.ModelBase2Impl;

/**
 * 动态实体表单模板
 * @author Administrator
 *
 */
public class DynaDEFormTemplModel extends ModelBase2Impl implements IDynaDEFormTemplModel{

	private String strDEFormId = null;
	
	@Override
	public String getDEFormId() {
		return this.strDEFormId;
	}
	
	/**
	 * 设置实体表单标识
	 * @param strDEFormId
	 */
	public void setDEFormId(String strDEFormId) {
		this.strDEFormId = strDEFormId;
	}

	/**
	 * 设置动态实体表单模板标识
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}
	
	/**
	 * 设置动态实体表单模板名称
	 * @param strId
	 */
	public void setName(String strName) {
		this.strName = strName;
	}
	

	
}
