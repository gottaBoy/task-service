package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.db.IDBDialect;

/**
 * 获取字符串长度
 * @author Administrator
 *
 */
public abstract class StrLenDBFunctionImplBase extends DBFunctionImplBase {

	@Override
	public String getName() {
		return IDBDialect.VALUEFUNC_STRLEN;
	}
	
	@Override
	public int getOutputDataType() {
		return DataTypes.INT;
	}

	
}
