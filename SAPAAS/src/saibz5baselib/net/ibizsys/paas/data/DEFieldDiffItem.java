package net.ibizsys.paas.data;

import net.ibizsys.paas.core.IDEField;

/**
 * 属性差异项
 * 
 * @author Administrator
 *
 */
public class DEFieldDiffItem implements IDEFieldDiffItem {
	private IDEField iDEField = null;
	private Object newValue = null;
	private Object oldValue = null;

	private String strDiffInfo = "";
	private String strNewText = null;
	private String strOldText = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDEFieldDiffItem#getDEField()
	 */
	@Override
	public IDEField getDEField() {
		return iDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDEFieldDiffItem#getNewValue()
	 */
	@Override
	public Object getNewValue() {
		return newValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDEFieldDiffItem#getOldValue()
	 */
	@Override
	public Object getOldValue() {
		return oldValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDEFieldDiffItem#getDiffInfo()
	 */
	@Override
	public String getDiffInfo() {
		return strDiffInfo;
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
	 * 设置新值
	 * 
	 * @param newValue the newValue to set
	 */
	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}

	/**
	 * 设置旧值
	 * 
	 * @param oldValue the oldValue to set
	 */
	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}

	/**
	 * 设置值变化差异信息
	 * 
	 * @param strDiffInfo the strDiffInfo to set
	 */
	public void setDiffInfo(String strDiffInfo) {
		this.strDiffInfo = strDiffInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDEFieldDiffItem#getNewText()
	 */
	public String getNewText() {
		if (this.strNewText == null) {
			if (this.getNewValue() != null) return this.getNewValue().toString();
		}
		return this.strNewText;
	}

	/**
	 * 设置新值文本
	 * 
	 * @param strNewText
	 */
	public void setNewText(String strNewText) {
		this.strNewText = strNewText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDEFieldDiffItem#getOldText()
	 */
	public String getOldText() {
		if (this.strOldText == null) {
			if (this.getOldValue() != null) return this.getOldValue().toString();
		}
		return this.strOldText;
	}

	/**
	 * 设置旧值文本
	 * 
	 * @param strOldText
	 */
	public void setOldText(String strOldText) {
		this.strOldText = strOldText;
	}
}
