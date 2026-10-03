package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.util.StringHelper;

/**
 * DM 数据库函数对象[过去天数]
 * @author Administrator
 *
 */
public class DMDateDiffNowDBFunctionImpl extends DateDiffNowDBFunctionImplBase {

	@Override
	public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
		if(args == null|| args.length !=1){
			throw new Exception(StringHelper.format("数据库值函数[%1$s]传入参数不正确", this.getName()));
		}
		return StringHelper.format("DAYS_BETWEEN(%1$s,CURRENT_TIMESTAMP)",args[0]);
	}

}
