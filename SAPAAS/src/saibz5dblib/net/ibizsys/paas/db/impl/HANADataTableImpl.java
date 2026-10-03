package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
/**
 * HANA数据表对象实现
 * @author wuhui
 *
 */
public class HANADataTableImpl extends DataTableImpl{

	public HANADataTableImpl(IDataSet iDataSet, ResultSet resultSet) throws SQLException {
		super(iDataSet, resultSet);
	}

	@Override
	protected IDataRow createDataRow() throws SQLException {
		return new HANADataRowImpl(this,this.getResultSet());
	}
	
	

}
