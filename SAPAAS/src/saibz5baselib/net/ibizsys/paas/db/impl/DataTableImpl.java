package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;

/**
 * 数据表对象集合
 * 
 * @author Administrator
 *
 */
public class DataTableImpl implements IDataTable {
	/**
	 * 未关闭结果集合对象
	 */
	private static Integer rsCount = 0;

	private static final Log log = LogFactory.getLog(DataTableImpl.class);
	protected ResultSet resultSet = null;

	protected HashMap<String, Integer> columnIndextable = new HashMap<String, Integer>(); // 数据列集合

	protected ArrayList<IDataColumn> columnVector = new ArrayList<IDataColumn>(); // 数据列头数组

	protected Vector<IDataRow> rowVector = null;

	public DataTableImpl(IDataSet iDataSet, ResultSet resultSet) throws SQLException {
		if (iDataSet == null || resultSet == null) return;

		// curDataSet = iDataSet;
		// 初始化列信息
		initColumns(resultSet);
		this.resultSet = resultSet;
		if (this.resultSet != null) {
			synchronized (rsCount) {
				rsCount++;
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return columnVector.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getColumnIndex(java.lang.String)
	 */
	@Override
	public int getColumnIndex(String strColumnName) {
		strColumnName = strColumnName.toUpperCase();
		if (columnIndextable.containsKey(strColumnName)) {
			return columnIndextable.get(strColumnName);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getDataColumn(int)
	 */
	@Override
	public IDataColumn getDataColumn(int nIndex) {
		if (nIndex < 0 || nIndex >= columnVector.size()) return null;

		return columnVector.get(nIndex);
	}

	/**
	 * 初始化列信息
	 * 
	 * @param resultSet
	 * @throws SQLException
	 */
	private void initColumns(ResultSet resultSet) throws SQLException {
		// 媒介数据结构
		ResultSetMetaData resultSetmd = resultSet.getMetaData();
		int numberOfColumns = resultSetmd.getColumnCount();
		for (int i = 1; i <= numberOfColumns; i++) {
			DataColumnImpl dataColumn = new DataColumnImpl();

			dataColumn.setName(resultSetmd.getColumnName(i));
			dataColumn.setIndex(i);
			dataColumn.setDBDataType(resultSetmd.getColumnTypeName(i));
			dataColumn.setCatalogName(resultSetmd.getCatalogName(i));
			dataColumn.setColumnClassName(resultSetmd.getColumnClassName(i));
			dataColumn.setColumnType(resultSetmd.getColumnType(i));
			dataColumn.setDisplaySize(resultSetmd.getColumnDisplaySize(i));

			columnVector.add(dataColumn);
			columnIndextable.put(dataColumn.getName().toUpperCase(), i - 1);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#next()
	 */
	@Override
	public IDataRow next() throws SQLException {
		if (this.getResultSet() == null) return null;

		if (this.getResultSet().next()) {
			return createDataRow();
		} else {
			return null;
		}
	}

	/**
	 * 建立数据行对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	protected IDataRow createDataRow() throws SQLException {
		return new DataRowImpl(this, this.getResultSet());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getResultSet()
	 */
	@Override
	public ResultSet getResultSet() {
		return this.resultSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#close()
	 */
	@Override
	public void close() {
		try {
			if (this.resultSet != null) {
				this.resultSet.close();
				this.resultSet = null;

				synchronized (rsCount) {
					rsCount--;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getCachedRowCount()
	 */
	@Override
	public int getCachedRowCount() {
		if (rowVector == null) return -1;
		return rowVector.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#readRows(int)
	 */
	@Override
	public int cacheRows(int nSize) throws SQLException {
		if (rowVector == null)
			rowVector = new Vector<IDataRow>();
		else
			rowVector.clear();
		while (nSize == -1 || nSize > 0) {
			IDataRow iDataRow = this.next();
			if (iDataRow == null) {
				this.close();
				break;
			}

			rowVector.add(iDataRow);
			if (nSize > 0) nSize--;
		}
		return rowVector.size();
	}

	/**
	 * 读记录
	 * 
	 * @param nSize
	 * @return
	 * @throws SQLException
	 */
	@Override
	public IDataRow getCachedRow(int nIndex) throws Exception {
		return rowVector.get(nIndex);
	}

	/**
	 * 获取未关闭的结果集合数量
	 * 
	 * @return
	 */
	public static int getUnclosedRSCount() {
		return rsCount;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.IDataTable#cacheAllRows()
	 */
	@Override
	public int cacheAllRows() throws SQLException {
		if(this.getResultSet()  == null)
			return this.getCachedRowCount();
		return this.cacheRows(-1);
	}

	
	
	
}
