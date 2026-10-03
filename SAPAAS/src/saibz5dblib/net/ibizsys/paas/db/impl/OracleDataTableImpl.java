package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;

/**
 * Oracle 数据表对象实现
 * 
 * @author Administrator
 *
 */
public class OracleDataTableImpl extends DataTableImpl {

	public OracleDataTableImpl(IDataSet iDataSet, ResultSet resultSet) throws SQLException {
		super(iDataSet, resultSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.impl.DataTableImpl#createDataRow()
	 */
	@Override
	protected IDataRow createDataRow() throws SQLException {
		return new OracleDataRowImpl(this, this.getResultSet());
	}

}
