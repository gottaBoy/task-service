package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetGroupParam;
import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 数据集合分组参数集合
 * 
 * @author lionlau
 *
 */
public class DEDataSetGroupParamModel extends ModelBase3Impl implements IDEDataSetGroupParam {
	private IDEDataSet iDEDataSet = null;
	private String strGroupCode = null;
	private String strSortDir = null;
	private int nSortOrder = -1;
	private boolean bEnableGroup = false;
	private String[] groupFields = null;
	private boolean bReCalc = false;

	public void init(IDEDataSet iDEDataSet) throws Exception {
		this.iDEDataSet = iDEDataSet;
		this.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetGroupParam#getGroupCode()
	 */
	@Override
	public String getGroupCode() {
		return this.strGroupCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetGroupParam#getSortDir()
	 */
	@Override
	public String getSortDir() {
		return this.strSortDir;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetGroupParam#getSortOrder()
	 */
	@Override
	public int getSortOrder() {
		return this.nSortOrder;
	}

	/**
	 * @param strGroupCode the strGroupCode to set
	 */
	public void setGroupCode(String strGroupCode) {
		this.strGroupCode = strGroupCode;
	}

	/**
	 * @param strSortDir the strSortDir to set
	 */
	public void setSortDir(String strSortDir) {
		this.strSortDir = strSortDir;
	}

	/**
	 * @param nSortOrder the nSortOrder to set
	 */
	public void setSortOrder(int nSortOrder) {
		this.nSortOrder = nSortOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetGroupParam#getDEDataSet()
	 */
	@Override
	public IDEDataSet getDEDataSet() {
		return this.iDEDataSet;
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
	 * @see net.ibizsys.paas.core.IDEDataSetGroupParam#getGroupFields()
	 */
	@Override
	public String[] getGroupFields() {
		return groupFields;
	}

	public void setGroupFields(String[] groupFields) {
		this.groupFields = groupFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetGroupParam#isReCalc()
	 */
	@Override
	public boolean isReCalc() {
		return this.bReCalc;
	}

	public void setReCalc(boolean bRecalc) {
		this.bReCalc = bRecalc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetGroupParam#isEnableGroup()
	 */
	@Override
	public boolean isEnableGroup() {
		return this.bEnableGroup;
	}

	public void setEnableGroup(boolean bEnableGroup) {
		this.bEnableGroup = bEnableGroup;
	}

}
