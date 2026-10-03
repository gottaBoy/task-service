package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 实体操作附加逻辑模型
 * 
 * @author Administrator
 *
 */
public class DEActionLogicModel extends ModelBase3Impl implements IDEActionLogicModel {
	private String strDEName = "";
	private String strDEActionName = "";
	private boolean bCloneParam = false;
	private boolean bIgnoreException = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEActionLogicModel#getDEName()
	 */
	@Override
	public String getDEName() {
		return strDEName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEActionLogicModel#getDEActionName()
	 */
	@Override
	public String getDEActionName() {
		return strDEActionName;
	}

	/**
	 * 设置实体模型名称
	 * 
	 * @param strDEName the strDEName to set
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	/**
	 * 设置实体行为名称
	 * 
	 * @param strDEActionName the strDEActionName to set
	 */
	public void setDEActionName(String strDEActionName) {
		this.strDEActionName = strDEActionName;
	}

	@Override
	public boolean isCloneParam() {
		return this.bCloneParam;
	}

	@Override
	public boolean isIgnoreException() {
		return this.bIgnoreException;
	}

	/**
	 * 设置是否克隆传入参数
	 * @param bCloneParam
	 */
	public void setCloneParam(boolean bCloneParam) {
		this.bCloneParam = bCloneParam;
	}

	/**
	 * 设置是否忽略处理异常
	 * @param bIgnoreException
	 */
	public void setIgnoreException(boolean bIgnoreException) {
		this.bIgnoreException = bIgnoreException;
	}
	
	
	

}
