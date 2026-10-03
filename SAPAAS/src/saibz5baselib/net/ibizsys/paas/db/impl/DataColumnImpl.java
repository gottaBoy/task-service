package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.db.IDataColumn;

/**
 * 数据表列对象实现类
 * 
 * @author Administrator
 * 
 */
public class DataColumnImpl implements IDataColumn {
	private String strName = "";
	private String strDBDataType = "";
	private int nIndex = -1;
	private String strCatalogName = "";
	private String strColumnClassName = "";
	private int nDisplaySize = 20;
	private int nColumnType = 0;

	public DataColumnImpl() {
	}

	/**
	 * 设置分类名称
	 * 
	 * @param strCatalogName
	 */
	public void setCatalogName(String strCatalogName) {
		this.strCatalogName = strCatalogName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataColumn#getCatalogName()
	 */
	public String getCatalogName() {
		return this.strCatalogName;
	}

	/**
	 * 设置列类名词
	 * 
	 * @param strColumnClassName
	 */
	public void setColumnClassName(String strColumnClassName) {
		this.strColumnClassName = strColumnClassName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataColumn#getColumnClassName()
	 */
	public String getColumnClassName() {
		return this.strColumnClassName;
	}

	/**
	 * 设置显示大小
	 * 
	 * @param nDisplaySize
	 */
	public void setDisplaySize(int nDisplaySize) {
		this.nDisplaySize = nDisplaySize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataColumn#getDisplaySize()
	 */
	public int getDisplaySize() {
		return this.nDisplaySize;
	}

	/**
	 * 设置列类型
	 * 
	 * @param nColumnType
	 */
	public void setColumnType(int nColumnType) {
		this.nColumnType = nColumnType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataColumn#getColumnType()
	 */
	public int getColumnType() {
		return this.nColumnType;
	}

	/**
	 * 设置名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.strName = name;
	}

	/**
	 * 设置数据库数据类型
	 * 
	 * @param DBDataType
	 */
	public void setDBDataType(String DBDataType) {
		this.strDBDataType = DBDataType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataColumn#getName()
	 */
	public String getName() {
		return strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataColumn#getDBDataType()
	 */
	public String getDBDataType() {
		return strDBDataType;
	}

	/**
	 * 设置列索引
	 * 
	 * @param index
	 */
	public void setIndex(int index) {
		this.nIndex = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataColumn#getIndex()
	 */
	public int getIndex() {
		return nIndex;
	}
}
