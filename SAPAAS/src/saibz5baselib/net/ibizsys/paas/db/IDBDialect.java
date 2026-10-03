package net.ibizsys.paas.db;

import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataRange;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;

/**
 * 数据库适配器接口
 * 
 * @author lionlau
 *
 */
public interface IDBDialect {
	
	/**
	 * 数据库类型：SqlServer
	 */
	final static String DBTYPE_SQLSERVER = "SQLSERVER"; 
	
	/**
	 * 数据库类型：Oracle 
	 */
	final static String DBTYPE_ORACLE = "ORACLE"; 
	
	/**
	 * 数据库类型：MySQL5 
	 */
	final static String DBTYPE_MYSQL5 = "MYSQL5"; 
	
	/**
	 * 数据库类型：DB2 
	 */
	final static String DBTYPE_DB2 = "DB2"; 
	
	/**
	 * 数据库类型：POSTGRESQL 
	 */
	final static String DBTYPE_POSTGRESQL = "POSTGRESQL"; 
	
	
	/**
	 * 数据库类型：PPAS 
	 */
	final static String DBTYPE_PPAS = "PPAS"; 

	
	/**
	 * 函数当前日期时间
	 */
	final static String FUNC_CURDATETIME = "CURDATETIME";

	/**
	 * 函数当前日期
	 */
	final static String FUNC_CURDATE = "CURDATE";

	/**
	 * 版本累加
	 */
	final static String FUNC_VERSION = "VERSION";

	/**
	 * 查找字符串
	 */
	final static String FUNC_INSTR = "INSTR";
	
	/**
	 * 值处理函数，过去天数
	 */
	final static String VALUEFUNC_DATEDIFFNOW = "DATEDIFFNOW";
	
	
	/**
	 * 值处理函数，未来天数
	 */
	final static String VALUEFUNC_DATEDIFFNOW2 = "DATEDIFFNOW2";
	
	
	/**
	 * 值处理函数，字符串长度
	 */
	final static String VALUEFUNC_STRLEN = "STRLEN";
	

	/**
	 * 聚合函数，查找最大值
	 */
	final static String FUNC_MAX = "MAX";

	/**
	 * 聚合函数，查找最小值
	 */
	final static String FUNC_MIN = "MIN";

	/**
	 * 聚合函数，查找平均值
	 */
	final static String FUNC_AVG = "AVG";

	/**
	 * 聚合函数，查找计数
	 */
	final static String FUNC_COUNT = "COUNT";

	/**
	 * 聚合函数，数据汇聚
	 */
	final static String FUNC_SUM = "SUM";
	

	

	/**
	 * 获取数据库类型
	 * 
	 * @return
	 */
	String getDBType();

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
	 * 去除select *
	 * @param strSQL
	 * @param nStartPos
	 * @param nPageSize
	 * @param strMajor
	 * @param strMajorDirection
	 * @param strMinor
	 * @param strMinorDirection
	 * @param iDEDataQuery
	 * @return
	 */
	String getPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection,IDEDataQueryCode iDEDataQueryCode);
	
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
	 * @param connection
	 * @param strProcName
	 * @param list
	 * @param nTimeOut
	 * @return
	 * @throws Exception
	 */
	DBCallResult callProc(java.sql.Connection connection, String strProcName, SqlParamList list, int nTimeOut) throws Exception;

	
	/**
	 * 获取最后插入的标识
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	DBCallResult getLastInsertId(java.sql.Connection connection) throws Exception;
	
	
	/**
	 * 获取属性的条件SQL
	 * 
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValueOrParam 
	 * @param bParam
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	String getConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValueOrParam, boolean bParam, SqlParamList sqlParamList) throws Exception;

	/**
	 * 获取数据库的函数代码
	 * 
	 * @param strFuncType
	 * @param args
	 * @return
	 * @throws Exception
	 */
	String getFuncSQL(String strFuncType, String[] args) throws Exception;

	/**
	 * 获取数据库的函数代码
	 * 
	 * @param strFuncType
	 * @param 是否为数据插入时使用
	 * @param 列名称
	 * @return
	 * @throws Exception
	 */
	String getFuncSQL(String strFuncType, boolean bInsert, String[] args) throws Exception;

	

	/**
	 * 获取属性数据库的函数代码
	 * @param iDEField
	 * @param iEntity
	 * @param bInsert
	 * @param bTemp
	 * @return 返回字符串，null 代表无SQL，继续后续操作，非空字符串代码要插入的直接内容，空字符串代码忽略此属性
	 * @throws Exception
	 */
	String getDEFieldValueSQL(IDEField iDEField,IEntity iEntity,boolean bInsert,boolean bTempMode) throws Exception;
	
	
	
	/**
	 * 获取数据库函数对象
	 * @param strFuncType
	 * @return
	 * @throws Exception
	 */
	IDBFunction getDBFunction(String strFuncType) throws Exception;
	
	
	/**
	 * 获取前部记录数SQL
	 * 
	 * @param strSQL
	 * @param nTopCount
	 * @return
	 * @throws Exception
	 */
	String getTopRowSQL(String strSQL, int nTopCount) throws Exception;

	/**
	 * 获取机构数据范围
	 * 
	 * @param iDEModel
	 * @param userRoleData
	 * @return
	 * @throws Exception
	 */
	String getOrgDRCond(UserRoleData userRoleData, Org curOrg, String strAlias) throws Exception;

	/**
	 * 获取机构部门数据范围
	 * 
	 * @param iDEModel
	 * @param userRoleData
	 * @return
	 * @throws Exception
	 */
	String getOrgSecDRCond(UserRoleData userRoleData, OrgSector curOrgSector, String strAlias) throws Exception;

	/**
	 * 获取机构数据范围
	 * 
	 * @param iDEModel
	 * @param userRoleData
	 * @return
	 * @throws Exception
	 */
	String getOrgDRCond(IDEDataRange iDEDataRange, Org curOrg, String strAlias) throws Exception;

	/**
	 * 获取机构部门数据范围
	 * 
	 * @param iDEModel
	 * @param userRoleData
	 * @return
	 * @throws Exception
	 */
	String getOrgSecDRCond(IDEDataRange iDEDataRange, OrgSector curOrgSector, String strAlias) throws Exception;

	/**
	 * 获取数据库对象标准名称
	 * 
	 * @param strOriginName
	 * @return
	 */
	String getDBObjStandardName(String strOriginName);
	
	
	
	
	/**
	 * 获取数据合并的SQL
	 * @param iDataEntity
	 * @param procParamList
	 * @return
	 * @throws Exception
	 */
	String getMergeSQL(IDataEntity iDataEntity,ProcParamList procParamList) throws Exception;
	
	
	
	

	/**
	 * 直接调用命令（批执行）
	 * @param connection
	 * @param commands
	 * @param lists
	 * @param nBatchSize 每批执行数量
	 * @param nTimeOut
	 * @return
	 * @throws Exception
	 */
	DBCallResult callSqlBatch(java.sql.Connection connection, String[] commands, SqlParamList[] lists, int nBatchSize, int nTimeOut) throws Exception;
}
