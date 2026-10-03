package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.ibizsys.paas.db.DataSetCache;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;

/**
 * 数据集合实现对象
 * 
 * @author Administrator
 *
 */
public class DataSetImpl implements IDataSet {
	protected ArrayList<IDataTable> dataTableList = new ArrayList<IDataTable>();

	// /**
	// * 未关闭数据连接数量
	// */
	// private static Integer connCount = 0;
	//

	protected Connection conn;
	protected PreparedStatement cstmt;

	private String strSqlInfo = null;

	/**
	 * 数据集合实现对象
	 * 
	 * @param conn
	 * @param cstmt
	 */
	public DataSetImpl(Connection conn, PreparedStatement cstmt) {
		this.conn = conn;
		this.cstmt = cstmt;
		// if(this.conn!=null)
		// {
		// synchronized(connCount)
		// {
		// connCount ++;
		// }
		// }
		DataSetCache.register(this);
	}

	/**
	 * 增加结果集合
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	public void addResultSet(ResultSet rs) throws SQLException {
		IDataTable dataTable = createDataTable(rs);
		dataTableList.add(dataTable);
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

	/**
	 * 从结果集中建立数据表
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	protected IDataTable createDataTable(ResultSet rs) throws SQLException {
		return new DataTableImpl(this, rs);
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
		closeDBLink();
		DataSetCache.unregister(this);
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
		closeDBLink();
		DataSetCache.unregister(this);
	}

	/**
	 * 关闭数据连接
	 */
	protected void closeDBLink() {
		try {
			if (cstmt != null) {
				cstmt.close();
			}
		} catch (Exception e) {
			// log.e
		}

		try {
			if (conn != null) {
				conn.close();
				conn = null;
				//
				// synchronized(connCount)
				// {
				// connCount --;
				// }
			}
		} catch (Exception e) {
			// log.e
		}

		cstmt = null;
		conn = null;
	}

	// /**
	// * 获取未关闭的数据库连接数量
	// * @return
	// */
	// public static int getUnclosedConnCount()
	// {
	// return connCount;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataSet#getSqlInfo()
	 */
	@Override
	public String getSqlInfo() {
		return strSqlInfo;
	}

	/**
	 * 设置相关的SQL信息
	 * 
	 * @param strSqlInfo the strSqlInfo to set
	 */
	public void setSqlInfo(String strSqlInfo) {
		this.strSqlInfo = strSqlInfo;
	}

}
