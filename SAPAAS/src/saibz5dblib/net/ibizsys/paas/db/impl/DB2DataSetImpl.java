package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataTable;

/**
 * DB2 数据集合对象
 * 
 * @author Administrator
 *
 */
public class DB2DataSetImpl extends DataSetImpl {

	public DB2DataSetImpl(Connection conn, PreparedStatement cstmt) {
		super(conn, cstmt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.impl.DataSetImpl#createDataTable(java.sql.ResultSet)
	 */
	@Override
	protected IDataTable createDataTable(ResultSet rs) throws SQLException {
		return new DB2DataTableImpl(this, rs);
	}
}
