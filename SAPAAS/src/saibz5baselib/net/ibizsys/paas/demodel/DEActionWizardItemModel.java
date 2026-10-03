package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 实体操作向导项模型对象
 * @author Administrator
 *
 */
public class DEActionWizardItemModel extends ModelBase3Impl implements IDEActionWizardItemModel {

	private String strContent = null;
	private String strMoreUrl = null;
	private String strActionValue = null;
	private IDEActionWizard iDEActionWizard = null;
	
	public void init(IDEActionWizard iDEActionWizard)throws Exception{
		this.iDEActionWizard = iDEActionWizard;
		this.onInit();
	}
	
	/**
	 * 设置标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	/**
	 * 设置名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}
	
	
	

	/**
	 * 设置内容
	 * @param strContent
	 */
	public void setContent(String strContent){
		this.strContent = strContent;
	}

	/**
	 * 设置Url
	 * @param strMoreUrl
	 */
	public void setMoreUrl(String strMoreUrl){
		this.strMoreUrl = strMoreUrl;
	}
	
	/**
	 * 设置操作值
	 * @param strActionValue
	 */
	public void setActionValue(String strActionValue){
		this.strActionValue = strActionValue;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEActionWizardItem#getContent()
	 */
	@Override
	public String getContent() {
		return this.strContent;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEActionWizardItem#getMoreUrl()
	 */
	@Override
	public String getMoreUrl() {
		return this.strMoreUrl;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEActionWizardItem#getActionValue()
	 */
	@Override
	public String getActionValue() {
		return this.strActionValue;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEActionWizardItem#getDEActionWizard()
	 */
	@Override
	public IDEActionWizard getDEActionWizard() {
		return this.iDEActionWizard;
	}
}
