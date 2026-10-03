package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;

/**
 * DB2 数据表对象
 * 
 * @author Administrator
 *
 */
public class DB2DataTableImpl extends DataTableImpl {

	public DB2DataTableImpl(IDataSet iDataSet, ResultSet resultSet) throws SQLException {
		super(iDataSet, resultSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.impl.DataTableImpl#createDataRow()
	 */
	@Override
	protected IDataRow createDataRow() throws SQLException {
		return new DB2DataRowImpl(this, this.getResultSet());
	}

}
