package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataTable;

/**
 * PostgreSQL 数据集合实现
 * @author Administrator
 *
 */
public class PPASDataSetImpl extends DataSetImpl
{

	public PPASDataSetImpl(Connection conn, PreparedStatement cstmt)
	{
		super(conn, cstmt);
		}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.impl.DataSetImpl#createDataTable(java.sql.ResultSet)
	 */
	@Override
	protected IDataTable createDataTable(ResultSet rs) throws SQLException
	{
		return new PPASDataTableImpl(this, rs);
	}
}
