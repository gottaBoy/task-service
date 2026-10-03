package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.db.IDBDialect;

/**
 * 获取未来日期到现在的间隔天数
 * @author Administrator
 *
 */
public abstract class DateDiffNow2DBFunctionImplBase extends DBFunctionImplBase {

	@Override
	public String getName() {
		return IDBDialect.VALUEFUNC_DATEDIFFNOW2;
	}
	
	
	@Override
	public int getOutputDataType() {
		return DataTypes.INT;
	}

	
	
}
