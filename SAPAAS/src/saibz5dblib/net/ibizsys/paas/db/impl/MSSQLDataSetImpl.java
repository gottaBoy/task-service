package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * MSSQLServer 数据集合对象
 * 
 * @author Administrator
 *
 */
public class MSSQLDataSetImpl extends DataSetImpl {

	public MSSQLDataSetImpl(Connection conn, PreparedStatement cstmt) {
		super(conn, cstmt);
	}

}
