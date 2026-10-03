package net.ibizsys.paas.core;

import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体数据查询代码接口
 * 
 * @author lionlau
 *
 */
public interface IDEDataQueryCode extends IModelBase {
	/**
	 * 获取实体数据查询
	 * 
	 * @return
	 */
	IDEDataQuery getDEDataQuery();

	/**
	 * 获取数据库类型
	 * 
	 * @return
	 */
	String getDBType();

	/**
	 * 获取查询代码
	 * 
	 * @return
	 */
	String getQueryCode();

	/**
	 * 获取查询代码(临时数据）
	 * 
	 * @return
	 */
	String getQueryCodeTemp();

	/**
	 * 获取定义代码
	 * 
	 * @return
	 */
	String getDeclareCode();

	/**
	 * 获取查询代码
	 * 
	 * @param iDEDataSetFetchContext
	 * @param iDBDialect
	 * @param list
	 * @return
	 * @throws Exception
	 */
	String getQueryCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception;

	/**
	 * 获取查询代码(临时数据)
	 * 
	 * @param iDEDataSetFetchContext
	 * @param iDBDialect
	 * @param list
	 * @return
	 * @throws Exception
	 */
	String getQueryCodeTemp(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception;

	/**
	 * 获取定义代码
	 * 
	 * @param iDEDataSetFetchContext
	 * @param iDBDialect
	 * @param list
	 * @return
	 * @throws Exception
	 */
	String getDeclareCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception;

	/**
	 * 填充定义参数
	 * 
	 * @param webContext
	 * @param iDataObject
	 * @param sqlParamList
	 * @throws Exception
	 */
	void fillDeclareParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception;

	/**
	 * 填充查询参数
	 * 
	 * @param webContext
	 * @param iDataObject
	 * @param sqlParamList
	 * @throws Exception
	 */
	void fillQueryParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception;

	/**
	 * 获取连接条件代码
	 * 
	 * @param iDEDataSetFetchContext
	 * @param iDEDataQueryCond
	 * @param iDBDialect
	 * @param list
	 * @return
	 * @throws Exception
	 */
	String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEDataQueryCodeCond iDEDataQueryCond, IDBDialect iDBDialect, SqlParamList list) throws Exception;

	/**
	 * 获取扩展的连接代码
	 * 
	 * @param iDEDataSetFetchContext
	 * @param strCode
	 * @param iDBDialect
	 * @param list
	 * @return
	 * @throws Exception
	 */
	String getExtJoinSQL(IDEDataSetFetchContext iDEDataSetFetchContext, String strCode, IDBDialect iDBDialect, SqlParamList list) throws Exception;

	/**
	 * 获取条件集合
	 * 
	 * @return
	 */
	java.util.Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds();

	/**
	 * 获取属性表达式
	 * 
	 * @param strName
	 * @param bTry
	 * @return
	 * @throws Exception
	 */
	String getDEFieldExp(String strName, boolean bTry) throws Exception;
	
	/**
	 * 获取全部表达式
	 * 
	 * @return
	 * @throws Exception
	 */
	Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps();
	
	
}
