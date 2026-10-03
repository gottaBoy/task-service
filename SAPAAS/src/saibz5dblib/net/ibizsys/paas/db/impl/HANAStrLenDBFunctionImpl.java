package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.util.StringHelper;

/**
 * HANA 数据库函数对象[字符串长度]
 * @author Administrator
 *
 */
public class HANAStrLenDBFunctionImpl extends StrLenDBFunctionImplBase{

/*	@Override
	public String getFuncSQL(boolean bInsert, String[] args) throws Exception {//字符串长度,汉字1
		if(args == null|| args.length !=1){
			throw new Exception(StringHelper.format("数据库值函数[%1$s]传入参数不正确", this.getName()));
		}
		return StringHelper.format("LEN(%1$s)",args[0]);
	}*/
	
	@Override
	public String getFuncSQL(boolean bInsert, String[] args) throws Exception {//字符串长度,汉字2,长度与编码方式有关
		if(args == null|| args.length !=1){
			throw new Exception(StringHelper.format("数据库值函数[%1$s]传入参数不正确", this.getName()));
		}
		return StringHelper.format("LENGTH(%1$s)",args[0]);
	}

}
