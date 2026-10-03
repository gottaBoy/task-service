package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;

/**
 * 简单数据表对象
 * 
 * @author Administrator
 *
 */
public class SimpleDataTableImpl implements IDataTable {
	private static final Log log = LogFactory.getLog(SimpleDataTableImpl.class);

	// protected HashMap<String,Integer> columnIndextable = new HashMap<String,Integer>(); //数据列集合
	//
	// protected ArrayList<IDataColumn> columnVector = new ArrayList<IDataColumn>(); //数据列头数组

	protected Vector<IDataRow> rowVector = null;

	public SimpleDataTableImpl(IDataSet iDataSet) throws SQLException {
		// 初始化列信息
		// initColumns(resultSet);
		rowVector = new Vector<IDataRow>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getColumnCount()
	 */
	public int getColumnCount() {
		// return columnVector.size();
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getColumnIndex(java.lang.String)
	 */
	public int getColumnIndex(String strColumnName) {
		// strColumnName = strColumnName.toUpperCase();
		// if (columnIndextable.containsKey(strColumnName))
		// {
		// return columnIndextable.get(strColumnName);
		// }
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getDataColumn(int)
	 */
	public IDataColumn getDataColumn(int nIndex) {
		// if (nIndex < 0 || nIndex >= columnVector.size())
		// return null;
		//
		// return columnVector.get(nIndex);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#next()
	 */
	public IDataRow next() throws SQLException {
		// if(this.getResultSet() == null)
		// return null;
		//
		// if(this.getResultSet().next())
		// {
		// return createDataRow();
		// }
		// else
		// {
		// return null;
		// }
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getResultSet()
	 */
	@Override
	public ResultSet getResultSet() {
		// return this.resultSet;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#close()
	 */
	@Override
	public void close() {
		// try
		// {
		// if(this.resultSet!=null)
		// {
		// this.resultSet.close();
		// this.resultSet = null;
		// }
		// }
		// catch (Exception e)
		// {
		// log.error(e.getMessage(),e);
		// }
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
		// if(rowVector==null)
		// rowVector = new Vector<IDataRow>();
		// else
		// rowVector.clear();
		// while(nSize==-1||nSize>0)
		// {
		// IDataRow iDataRow = this.next();
		// if(iDataRow==null)
		// {
		// this.close();
		// break;
		// }
		//
		// rowVector.add(iDataRow);
		// if(nSize>0)
		// nSize --;
		// }
		return rowVector.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataTable#getCachedRow(int)
	 */
	@Override
	public IDataRow getCachedRow(int nIndex) throws Exception {
		return rowVector.get(nIndex);
	}

	/**
	 * 添加缓存行记录
	 * 
	 * @param iDataRow
	 */
	public void addCachedRow(IDataRow iDataRow) {
		rowVector.add(iDataRow);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.IDataTable#cacheAllRows()
	 */
	@Override
	public int cacheAllRows() throws SQLException {
		return this.cacheRows(-1);
	}

	/**
	 * 重置表记录
	 */
	public void reset(){
		if(this.rowVector!=null)
			this.rowVector.clear();
	}
	
	
}
