package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.util.StringHelper;

/**
 * MySQL5 数据库函数对象[未来天数]
 * @author Administrator
 *
 */
public class SQLiteDateDiffNow2DBFunctionImpl extends DateDiffNow2DBFunctionImplBase{

	@Override
	public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
		if(args == null|| args.length !=1){
			throw new Exception(StringHelper.format("数据库值函数[%1$s]传入参数不正确", this.getName()));
		}
		return StringHelper.format("(JULIANDAY(DATE(%1$s))-JULIANDAY(DATE()))",args[0]);
	}

}
