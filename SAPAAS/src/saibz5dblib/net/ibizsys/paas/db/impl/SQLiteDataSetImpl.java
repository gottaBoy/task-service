package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * SQLite 数据集合对象
 * @author Administrator
 *
 */
public class SQLiteDataSetImpl extends DataSetImpl
{

	public SQLiteDataSetImpl(Connection conn, PreparedStatement cstmt)
	{
		super(conn, cstmt);
	}
}
