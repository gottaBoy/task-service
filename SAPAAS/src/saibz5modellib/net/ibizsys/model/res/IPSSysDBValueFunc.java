package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;


/**
 * 系统数据库值函数接口
 * @author Administrator
 *
 */
public interface IPSSysDBValueFunc extends IPSSystemObject
{
	
	/**
	 * 数据库值函数类型，云平台内置
	 */
	public final String DBVALUEFUNCTYPE_PS = "PS";
	
	/**
	 * 数据库值函数类型，用户扩展
	 */
	public final String DBVALUEFUNCTYPE_UX = "UX";
	
	
	
	/**
	 * 获取输入的标准数据类型
	 * @return
	 */
	int getInputStdDataType();
	
	
	/**
	 * 获取输出的标准数据类型
	 * @return
	 */
	int getOutputStdDataType();
	
	
//	/**
//	 * 获取函数代码
//	 * @param strDBType
//	 * @return
//	 * @throws Exception
//	 */
//	IPSSysDBValueFuncCode getFuncCode(String strDBType)throws Exception;
	
	
	
	
	/**
	 * 获取数据库值函数类型
	 * @return
	 */
	String getDBValueFuncType();
	
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	
	
	
	/**
	 * 获取输出值格式
	 * @return
	 */
	String getOutputValueFormat();
}
