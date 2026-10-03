package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 属性搜索模式
 * 
 * @author lionlau
 *
 */
public class DEFSearchModeModel extends ModelBase3Impl implements IDEFSearchMode {
	private IDEField iDEField = null;

	private String strValueFunc = null;
	private String strValueOp = null;

	public DEFSearchModeModel() {

	}

	/**
	 * 初始化
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		onInit();
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEFSearchModeModel#getValueFunc()
	 */
	@Override
	public String getValueFunc() {
		return this.strValueFunc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEFSearchModeModel#getValueOp()
	 */
	@Override
	public String getValueOp() {
		return this.strValueOp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEFSearchMode#getDEFName()
	 */
	@Override
	public String getDEFName() {
		return iDEField.getName();
	}

	/**
	 * 获取属性对象
	 * 
	 * @return
	 */
	public IDEField getDEField() {
		return iDEField;
	}

	/**
	 * 设置属性对象
	 * 
	 * @param iDEField the iDEField to set
	 */
	public void setDEField(IDEField iDEField) {
		this.iDEField = iDEField;
	}

	/**
	 * 设置值函数
	 * 
	 * @param strValueFunc the strValueFunc to set
	 */
	public void setValueFunc(String strValueFunc) {
		this.strValueFunc = strValueFunc;
	}

	/**
	 * 设置值操作
	 * 
	 * @param strValueOp the strValueOp to set
	 */
	public void setValueOp(String strValueOp) {
		this.strValueOp = strValueOp;
	}

}
