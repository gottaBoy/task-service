package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;

/**
 * PostgreSQL 数据表对象实现
 * @author Administrator
 *
 */
public class PPASDataTableImpl extends DataTableImpl
{

	public PPASDataTableImpl(IDataSet iDataSet, ResultSet resultSet) throws SQLException
	{
		super(iDataSet, resultSet);
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.impl.DataTableImpl#createDataRow()
	 */
	@Override
	protected IDataRow createDataRow() throws SQLException
	{
		return new PPASDataRowImpl(this, this.getResultSet());
	}

}
