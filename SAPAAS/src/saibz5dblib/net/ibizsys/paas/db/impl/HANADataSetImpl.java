package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataTable;
/**
 * HANA数据集合实现
 * @author wuhui
 *
 */
public class HANADataSetImpl extends DataSetImpl {

	public HANADataSetImpl(Connection conn, PreparedStatement cstmt) {
		super(conn, cstmt);
	}

	@Override
	protected IDataTable createDataTable(ResultSet rs) throws SQLException {
		return new HANADataTableImpl(this,rs);
	}

}
