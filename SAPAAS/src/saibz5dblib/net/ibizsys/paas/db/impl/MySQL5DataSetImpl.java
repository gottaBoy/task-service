package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * MySQL5 数据集合对象
 * 
 * @author Administrator
 *
 */
public class MySQL5DataSetImpl extends DataSetImpl {

	public MySQL5DataSetImpl(Connection conn, PreparedStatement cstmt) {
		super(conn, cstmt);
	}

}
