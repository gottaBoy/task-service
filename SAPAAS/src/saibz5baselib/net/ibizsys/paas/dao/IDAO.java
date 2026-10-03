package net.ibizsys.paas.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.IDEDBCallContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.web.IWebContext;

/**
 * 数据操作对象接口
 * 
 * @author lionlau
 * 
 */
public interface IDAO<ET extends IEntity> {
	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	IDataEntityModel getDEModel();
	
	
	/**
	 * 获取系统模型
	 * @return
	 */
	ISystemModel getSystemModel();
	

	/**
	 * 获取当前访问上下文
	 * 
	 * @return
	 */
	IWebContext getWebContext();

	/**
	 * 获取数据源链接
	 * 
	 * @return
	 */
	String getDSLink();

	/**
	 * 设置数据源连接
	 * 
	 * @param strDSLink
	 */
	void setDSLink(String strDSLink);

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */
	void setSessionFactory(SessionFactory sessionFactory);

	/**
	 * 获取会话工厂
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory();

	/**
	 * 设置数据库设配器
	 * 
	 * @param iDBDialect
	 */
	void setDBDialect(IDBDialect iDBDialect);

	/**
	 * 获取当前的会话
	 * 
	 * @return
	 */
	Session getCurrentSession() throws Exception;

	/**
	 * GET 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeGetSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception;
	
	
	/**
	 * GET 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param nViewLevel 视图级别
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeGetSql(IDEDBCallContext iDEDBCallContext, ET et,int nViewLevel, boolean bTempMode) throws Exception;

	

	/**
	 * Create 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeCreateSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception;

	/**
	 * Update 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeUpdateSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception;

	/**
	 * 系统 Update 操作，不日志操作时间及操作人
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeSysUpdateSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception;

	/**
	 * Remove 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeRemoveSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception;

	/**
	 * Remove 操作，通过查询条件
	 * 
	 * @param iDEDBCallContext
	 * @param iSelectCond
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeRemoveSql(IDEDBCallContext iDEDBCallContext, ISelectCond iSelectCond, boolean bTempMode) throws Exception;

	/**
	 * Select 操作
	 * 
	 * @param iDEDBCallContext
	 * @param iSelectCond
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeSelectSql(IDEDBCallContext iDEDBCallContext, ISelectCond iSelectCond, boolean bTempMode) throws Exception;

	/**
	 * CHECKKEY 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeCheckKeySql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception;

	/**
	 * 获取数据集合
	 * 
	 * @param iDEDataSetFetchContext
	 * @param strDEDataSetName
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext, String strDEDataSetName, boolean bTempMode) throws Exception;

	/**
	 * 直接SQL 操作
	 * 
	 * @param iDEDBCallContext
	 * @param strSql
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeRawSql(IDEDBCallContext iDEDBCallContext, String strSql, SqlParamList sqlParamList) throws Exception;

	
	
	/**
	 * 直接SQL 操作 (批操作）
	 * @param iDEDBCallContext
	 * @param sql
	 * @param sqlParamLists
	 * @param nBatchSize
	 * @return
	 * @throws Exception
	 */
	DBCallResult executeRawSqlBatch(IDEDBCallContext iDEDBCallContext, String[] sql, SqlParamList[] sqlParamLists,int nBatchSize) throws Exception;
	
	/**
	 * 查询数据集合
	 * 
	 * @param iDEDataSetFetchContext
	 * @param strDEDataQueryName
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBFetchResult fetchDEDataQuery(IDEDataSetFetchContext iDEDataSetFetchContext, String strDEDataQueryName, boolean bTempMode) throws Exception;

	/**
	 * 直接SQL查询 操作
	 * 
	 * @param iDEDBCallContext
	 * @param strSql
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	ArrayList<IEntity> executeRawSelectSql(IDEDBCallContext iDEDBCallContext, String strSql, SqlParamList sqlParamList) throws Exception;
	
	/**
	 * 直接SQL查询 操作
	 * 
	 * @param iDEDBCallContext
	 * @param strSql
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	ArrayList<ET> executeSelectSql(IDEDBCallContext iDEDBCallContext, String strSql, SqlParamList sqlParamList) throws Exception;
	

	/**
	 * 直接SQL查询 操作（只返回1行）
	 * 
	 * @param iDEDBCallContext
	 * @param strSql
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	IEntity executeRawSelectOneSql(IDEDBCallContext iDEDBCallContext, String strSql, SqlParamList sqlParamList) throws Exception;

	/**
	 * 执行存储过程
	 * 
	 * @param iDEDBCallContext
	 * @param strProcName
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	DBCallResult callProc(IDEDBCallContext iDEDBCallContext, String strProcName, SqlParamList sqlParamList) throws Exception;

	/**
	 * 获取数据库适配器接口
	 * 
	 * @return
	 */
	IDBDialect getRealDBDialect();
	
	
	/**
	 * 查询数据集合
	 * @param iSelectContext
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	DBCallResult fetchDEDataQuery(ISelectContext iSelectContext, boolean bTempMode) throws Exception;
}
