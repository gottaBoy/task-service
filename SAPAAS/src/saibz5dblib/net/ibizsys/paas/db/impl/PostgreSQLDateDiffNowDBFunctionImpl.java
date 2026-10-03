package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.util.StringHelper;

/**
 * PostgreSQL 数据库函数对象[过去天数]
 * @author Administrator
 *
 */
public class PostgreSQLDateDiffNowDBFunctionImpl extends DateDiffNowDBFunctionImplBase {

	
	
	@Override
	public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
		if(args == null|| args.length !=1){
			throw new Exception(StringHelper.format("数据库值函数[%1$s]传入参数不正确", this.getName()));
		}
		return StringHelper.format("(current_date - %1$s::date)",args[0]);
	}
	
	/*@Override
	public String getFuncSQL(boolean bInsert, String[] args) throws Exception {//相隔24小时算一天
		if(args == null|| args.length !=1){
			throw new Exception(StringHelper.format("数据库值函数[%1$s]传入参数不正确", this.getName()));
		}
		return StringHelper.format("date_part('day',current_timestamp - %1$s)",args[0]);
	}*/

}
