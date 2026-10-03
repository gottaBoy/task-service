package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;

/**
 * 简单行记录对象
 * 
 * @author Administrator
 *
 */
public class SimpleDataRowImpl extends DataObject implements IDataRow, ISimpleDataObject {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#getDataTable()
	 */
	@Override
	public IDataTable getDataTable() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#get(int)
	 */
	@Override
	public Object get(int nIndex) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#isDBNull(int)
	 */
	@Override
	public boolean isDBNull(int nIndex) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#isDBNull(java.lang.String)
	 */
	@Override
	public boolean isDBNull(String strColumnName) throws Exception {
		return this.isNull(strColumnName);
	}

}
