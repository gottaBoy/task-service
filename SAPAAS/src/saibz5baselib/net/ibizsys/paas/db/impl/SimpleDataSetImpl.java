package net.ibizsys.paas.db.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;

/**
 * 简单数据集合对象
 * 
 * @author Administrator
 *
 */
public class SimpleDataSetImpl implements IDataSet {
	protected ArrayList<IDataTable> dataTableList = new ArrayList<IDataTable>();

	public SimpleDataSetImpl() {

	}

	/**
	 * 增加结果集合
	 * 
	 * @param iDataTable
	 * @throws SQLException
	 */
	public void addDataTable(IDataTable iDataTable) throws SQLException {
		dataTableList.add(iDataTable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataSet#getDataTableCount()
	 */
	@Override
	public int getDataTableCount() {
		return dataTableList.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataSet#getDataTable(int)
	 */
	@Override
	public IDataTable getDataTable(int nIndex) {
		if (nIndex < 0) return null;

		if (nIndex > (dataTableList.size() - 1)) return null;
		return (IDataTable) dataTableList.get(nIndex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataSet#close()
	 */
	@Override
	public void close() {
		for (IDataTable iDataTable : this.dataTableList) {
			iDataTable.close();
		}
		dataTableList.clear();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataSet#cacheDataRow()
	 */
	@Override
	public void cacheDataRow() throws SQLException {
		for (IDataTable iDataTable : this.dataTableList) {
			if(iDataTable.getCachedRowCount() == -1)
				iDataTable.cacheRows(-1);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataSet#getSqlInfo()
	 */
	@Override
	public String getSqlInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
