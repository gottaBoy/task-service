package net.ibizsys.paas.db;

import net.ibizsys.paas.core.IModelBase;

/**
 * 数据库对象接口
 * 
 * @author Administrator
 *
 */
public interface IDatabase extends IModelBase {
	/**
	 * 获取数据库类型
	 * 
	 * @return
	 */
	String getDBType();

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	java.sql.Connection getConnection() throws Exception;

	/**
	 * 获取计数的语句
	 * 
	 * @param strSQL
	 * @return
	 */
	String getCountSQL(String strSQL);

	/**
	 * 获取分页的SQL语句
	 * 
	 * @param strSQL
	 * @param nStartPos
	 * @param nPageSize
	 * @param strMajor
	 * @param strMajorDirection
	 * @param strMinor
	 * @param strMinorDirection
	 * @return
	 */
	String getPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection);

	/**
	 * 获取JDBC数据类型
	 * 
	 * @param nDataType
	 * @return
	 */
	int getJDBCType(int nDataType);

	/**
	 * 直接调用命令
	 * 
	 * @param strCommand
	 * @param list
	 * @param nTimeOut
	 * @return
	 */
	DBCallResult callSql(java.sql.Connection connection, String strCommand, SqlParamList list, int nTimeOut) throws Exception;

	/**
	 * 直接调用存储过程
	 * 
	 * @param strProcName
	 * @param list
	 * @param nTimeOut
	 * @return
	 */
	DBCallResult callProc(java.sql.Connection connection, String strProcName, SqlParamList list, int nTimeOut) throws Exception;

	/**
	 * 获取条件SQL语句
	 * 
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValue
	 * @param bParam
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	String getConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList) throws Exception;

	/**
	 * 获取数据库对象标准名称
	 * 
	 * @param strOriginName
	 * @return
	 */
	String getDBObjStandardName(String strOriginName);

}
