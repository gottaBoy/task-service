package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 属性输入提示模型对象接口实现
 * @author Administrator
 *
 */
public class DEFInputTipModel extends ModelBase3Impl implements IDEFInputTipModel{

	private String strContent = null;
	private String strContentLanResTag = null;
	private String strMoreUrl = null;
	private boolean bEnableClose = true;
	private String strUniqueTag = null;
	
	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTip#getContent()
	 */
	@Override
	public String getContent() {
		return this.strContent;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTip#getContentLanResTag()
	 */
	@Override
	public String getContentLanResTag() {
		return this.strContentLanResTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTip#getMoreUrl()
	 */
	@Override
	public String getMoreUrl() {
		return this.strMoreUrl;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTip#isEnableClose()
	 */
	@Override
	public boolean isEnableClose() {
		return this.bEnableClose;
	}

	/**
	 * 设置内容
	 * @param strContent
	 */
	public void setContent(String strContent) {
		this.strContent = strContent;
	}

	/**
	 * 设置内容语言资源标识
	 * @param strContentLanResTag
	 */
	public void setContentLanResTag(String strContentLanResTag) {
		this.strContentLanResTag = strContentLanResTag;
	}

	/**
	 * 设置链接
	 * @param strMoreUrl
	 */
	public void setMoreUrl(String strMoreUrl) {
		this.strMoreUrl = strMoreUrl;
	}

	/**
	 * 设置支持关闭
	 * @param bEnableClose
	 */
	public void setEnableClose(boolean bEnableClose) {
		this.bEnableClose = bEnableClose;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTip#getUniqueTag()
	 */
	@Override
	public String getUniqueTag() {
		return this.strUniqueTag;
	}

	
	/**
	 * 设置唯一的业务标识
	 * @param strUniqueTag
	 */
	public void setUniqueTag(String strUniqueTag){
		this.strUniqueTag = strUniqueTag;
	}
}
