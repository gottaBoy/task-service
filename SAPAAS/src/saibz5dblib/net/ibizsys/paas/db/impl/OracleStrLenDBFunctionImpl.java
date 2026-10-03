package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.util.StringHelper;

/**
 * Oracle 数据库函数对象[字符串长度]
 * @author Administrator
 *
 */
public class OracleStrLenDBFunctionImpl extends StrLenDBFunctionImplBase {

	/*@Override
	public String getFuncSQL(boolean bInsert, String[] args) throws Exception {//一个汉字的长度为1
		if(args == null|| args.length !=1){
			throw new Exception(StringHelper.format("数据库值函数[%1$s]传入参数不正确", this.getName()));
		}
		return StringHelper.format("LENGTH(%1$s)",args[0]);
	}*/
	
	@Override
	public String getFuncSQL(boolean bInsert, String[] args) throws Exception {//与编码方式有关，编码为utf-8时为3，其他编码方式为其他长度
		if(args == null|| args.length !=1){
			throw new Exception(StringHelper.format("数据库值函数[%1$s]传入参数不正确", this.getName()));
		}
		return StringHelper.format("LENGTHB(%1$s)",args[0]);
	}


}
