package net.ibizsys.paas.core;

import java.util.ArrayList;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体结果集合代码
 * 
 * @author lionlau
 * 
 */
public interface IDEDataSetCode extends IModelBase {
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
	 * 获取定义代码
	 * 
	 * @return
	 */
	String getDeclareScript();

	/**
	 * 获取条件
	 * 
	 * @param iDEDataSetFetchContext
	 * @param iDEField
	 * @param strFunc
	 * @param strAction
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEField iDEField, String strFunc, String strAction, String strValue) throws Exception;

	/**
	 * 获取条件SQL
	 * 
	 * @param iDEDataSetFetchContext
	 * @param iDEFSearchItem
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEFSearchMode iDEFSearchItem, String strValue) throws Exception;

	/**
	 * 替换URL变量参数
	 * 
	 * @param strFinalScript
	 * @param webContext
	 * @param bTestPost
	 * @return
	 * @throws Exception
	 */
	String replaceURLParamMacro(String strFinalScript, IWebContext webContext, boolean bTestPost) throws Exception;

	/**
	 * 替换URL变量参数
	 * 
	 * @param strFinalScript
	 * @param webContext
	 * @return
	 * @throws Exception
	 */
	String replaceURLParamMacro(String strFinalScript, IWebContext webContext) throws Exception;

	/**
	 * 替换动态表变量参数
	 * 
	 * @param strFinalScript
	 * @param dynamicTables
	 * @return
	 * @throws Exception
	 */
	String replaceDynamicTableMacro(String strFinalScript, ArrayList<String> dynamicTables) throws Exception;

	/**
	 * 填充SQL的定义参数集合
	 * 
	 * @param sqlParamList
	 * @param webContext
	 * @param iDataObject
	 * @throws Exception
	 */
	void fillDeclareParams(SqlParamList sqlParamList, IWebContext webContext, IDataObject iDataObject) throws Exception;

	/**
	 * 填充SQL参数
	 * 
	 * @param sqlParamList
	 * @param webContext
	 * @param iDataObject
	 * @throws Exception
	 */
	void fillSqlParams(SqlParamList sqlParamList, IWebContext webContext, IDataObject iDataObject) throws Exception;

	/**
	 * 填充SQL查询
	 * 
	 * @param sqlParamList
	 * @param webContext
	 * @throws Exception
	 */
	void fillSqlParams(SqlParamList sqlParamList, IWebContext webContext) throws Exception;

	/**
	 * 获取指定属性表达式
	 * 
	 * @param iDEField
	 * @return
	 * @throws Exception
	 */
	String getDEFieldExp(IDEField iDEField) throws Exception;
}
