package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.util.StringHelper;

/**
 * MySQL5 数据库函数对象[字符串长度]
 * @author Administrator
 *
 */
public class SQLiteStrLenDBFunctionImpl extends StrLenDBFunctionImplBase {

	@Override
	public String getFuncSQL(boolean bInsert, String[] args) throws Exception {//如果SQLite被配置为支持UTF-8，则返回UTF-8字符数而不是字节数。 
		if(args == null|| args.length !=1){
			throw new Exception(StringHelper.format("数据库值函数[%1$s]传入参数不正确", this.getName()));
		}
		return StringHelper.format("LENGTH(%1$s)",args[0]);
	}

}
