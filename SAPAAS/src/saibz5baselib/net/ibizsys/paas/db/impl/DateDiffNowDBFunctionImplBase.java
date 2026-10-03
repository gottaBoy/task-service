package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.db.IDBDialect;

/**
 * 获取过去日期到现在的间隔天数
 * @author Administrator
 *
 */
public abstract class DateDiffNowDBFunctionImplBase extends DBFunctionImplBase {

	@Override
	public String getName() {
		return IDBDialect.VALUEFUNC_DATEDIFFNOW;
	}
	
	
	@Override
	public int getOutputDataType() {
		return DataTypes.INT;
	}

	
	
}
