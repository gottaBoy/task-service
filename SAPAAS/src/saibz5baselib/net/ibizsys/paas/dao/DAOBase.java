package net.ibizsys.paas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEDBCallContext;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetGroupParam;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IPostConstructable;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDEDBProcModel;
import net.ibizsys.paas.demodel.IDEDataSetModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.ISqlCommandModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * 数据访问对象
 * 
 * @author lionlau
 * 
 */
public abstract class DAOBase<ET extends IEntity> implements IDAO<ET>, IPostConstructable {
	private static final Log log = LogFactory.getLog(DAOBase.class);

	/**
	 * 获取数据SQL命令模型
	 */
	protected ISqlCommandModel getSqlCommandModel = null;
	
	/**
	 * 获取数据SQL命令模型（视图模式2）
	 */
	protected ISqlCommandModel get2SqlCommandModel = null;
	
	/**
	 * 获取数据SQL命令模型（视图模式3）
	 */
	protected ISqlCommandModel get3SqlCommandModel = null;
	
	/**
	 * 获取数据SQL命令模型（视图模式4）
	 */
	protected ISqlCommandModel get4SqlCommandModel = null;

	/**
	 * 获取数据SQL命令模型
	 */
	protected ISqlCommandModel getTempSqlCommandModel = null;

	/**
	 * 检查主键SQL命令模型
	 */
	protected ISqlCommandModel checkKeySqlCommandModel = null;

	/**
	 * 检查主键SQL命令模型
	 */
	protected ISqlCommandModel checkKeyTempSqlCommandModel = null;
	
	
	/**
	 * 获取数据SQL命令模型
	 */
	protected ISqlCommandModel getSqlCommandModel2 = null;
	
	/**
	 * 获取数据SQL命令模型（视图模式2）
	 */
	protected ISqlCommandModel get2SqlCommandModel2 = null;
	
	/**
	 * 获取数据SQL命令模型（视图模式3）
	 */
	protected ISqlCommandModel get3SqlCommandModel2 = null;
	
	/**
	 * 获取数据SQL命令模型（视图模式4）
	 */
	protected ISqlCommandModel get4SqlCommandModel2 = null;

	/**
	 * 获取数据SQL命令模型
	 */
	protected ISqlCommandModel getTempSqlCommandModel2 = null;

	/**
	 * 检查主键SQL命令模型
	 */
	protected ISqlCommandModel checkKeySqlCommandModel2 = null;

	/**
	 * 检查主键SQL命令模型
	 */
	protected ISqlCommandModel checkKeyTempSqlCommandModel2 = null;

//	/**
//	 * 建立数据SQL命令模型
//	 */
//	protected ISqlCommandModel createSqlCommandModel = null;
//
//	/**
//	 * 建立数据SQL命令模型
//	 */
//	protected ISqlCommandModel createTempSqlCommandModel = null;

	/**
	 * 删除数据SQL命令模型
	 */
	protected ISqlCommandModel removeSqlCommandModel = null;

	/**
	 * 删除数据SQL命令模型
	 */
	protected ISqlCommandModel removeTempSqlCommandModel = null;
	
	

	private String strDSLink = null;

	private SessionFactory sessionFactory = null;

	private IDBDialect iDBDialect = null;

	protected class DBCallResultProxy {
		private DBCallResult dbCallResult = null;

		public DBCallResult getDBCallResult() {
			return this.dbCallResult;
		}

		public void setDBCallResult(DBCallResult dbCallResult) {
			this.dbCallResult = dbCallResult;
		}
	}

	public DAOBase() {
		// log.info(StringHelper.format("初始化DAO对象[%1$s]",this));
	}

	/**
	 * 获取DAO对象的标识
	 * 
	 * @return
	 */
	protected String getDAOId() {
		return null;
	}

	/**
	 * 获取继承实体的数据访问对象
	 * 
	 * @return
	 */
	protected IDAO getInheritDEDAO() {
		return null;
	}

	/**
	 * 获取上下文对象
	 * 
	 * @return
	 */
	@Override
	public IWebContext getWebContext() {
		return WebContext.getCurrent();
	}

	/**
	 * 支持数据库存储过程
	 * 
	 * @param iDEDBCallContext
	 * @param strDEProcName
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public DBCallResult executeDEDBProc(IDEDBCallContext iDEDBCallContext, String strDEProcName, ET entity) throws Exception {
		Session session = this.getCurrentSession();

		log.debug(StringHelper.format("执行过程 %1$s", strDEProcName));

		final DBCallResult dbCallResult = new DBCallResult();

		final IDEDBProcModel iDEDBProcModel = (IDEDBProcModel) this.getDEModel().getDEAction(strDEProcName);

		final SqlParamList sqlParamList = new SqlParamList();

		this.fillDBProcSqlParams(iDEDBProcModel, entity, sqlParamList);
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult2 = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					dbCallResult2 = getRealDBDialect().callProc(connection, iDEDBProcModel.getDBProcName(), sqlParamList, iDEDBProcModel.getTimeOut());
					if (dbCallResult2.getRetCode() != Errors.OK) {
						throw new Exception(dbCallResult2.getErrorInfo());
					}

					dbCallResult.from(dbCallResult2);
				} catch (Exception e) {
					if (dbCallResult2.getDataSet() != null) {
						dbCallResult2.getDataSet().close();
					}
					throw new SQLException(e.getMessage(), e);
				}
			}
		});

		return dbCallResult;

	}

	/**
	 * 填充过程参数
	 * 
	 * @param iDEDBProcModel
	 * @param entity
	 * @param sqlParamList
	 * @throws Exception
	 */
	protected void fillDBProcSqlParams(IDEDBProcModel iDEDBProcModel, ET entity, SqlParamList sqlParamList) throws Exception {
		iDEDBProcModel.fillSqlParams(this.getDBType(), entity, this.getWebContext(), sqlParamList);
	}

	/**
	 * 获取数据集合结果
	 * 
	 * @param iDEDataSetFetchContext
	 * @param strDEDataSetName
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext, String strDEDataSetName, boolean bTempMode) throws Exception {
		DEDataSetFetchContext.setCurrent(iDEDataSetFetchContext);

		ArrayList<IDEDataSetCond> userConditions = iDEDataSetFetchContext.getConditionList();
		IDEDataSet iDEDataSet = this.getDEModel().getDEDataSet(strDEDataSetName);
		if (iDEDataSet instanceof IDEDataSetModel) {
			IDEDataSetModel iDEDataSetModel = (IDEDataSetModel) iDEDataSet;
			if (iDEDataSetModel.isCustomDS()){
				return iDEDataSetModel.fetchDEDataSet(iDEDataSetFetchContext);
			}
		}

		Session session = this.getCurrentSession();

		// 新建查询模型用户上下文
		StringBuilderEx script = new StringBuilderEx();
		StringBuilderEx declareScript = new StringBuilderEx();
		SqlParamList list = new SqlParamList();

		java.util.Iterator<IDEDataSetQuery> deDataSetQueries = iDEDataSet.getDEDataSetQueries();
		IDEDataQueryCode pagingDEDataQueryCode = null ;
		while (deDataSetQueries.hasNext()) {
			IDEDataSetQuery iDEDataSetQuery = deDataSetQueries.next();
			IDEDataQueryCode iDEDataQueryCode = this.getDEModel().getDEDataQuery(iDEDataSetQuery.getDEDataQueryId()).getDEDataQueryCode(getRealDBDialect().getDBType());
			if(pagingDEDataQueryCode == null)
				pagingDEDataQueryCode = iDEDataQueryCode ;
			if (!StringHelper.isNullOrEmpty(iDEDataQueryCode.getDeclareCode())) {
				declareScript.append(iDEDataQueryCode.getDeclareCode());
				declareScript.append("\n");
				iDEDataQueryCode.fillDeclareParams(iDEDataSetFetchContext.getWebContext(), null, list);
			}
		}

		iDEDataSetFetchContext.fillDeclareParams(list);

		boolean bFirst = true;
		deDataSetQueries = iDEDataSet.getDEDataSetQueries();
		while (deDataSetQueries.hasNext()) {
			IDEDataSetQuery iDEDataSetQuery = deDataSetQueries.next();
			IDEDataQueryCode iDEDataQueryCode = this.getDEModel().getDEDataQuery(iDEDataSetQuery.getDEDataQueryId()).getDEDataQueryCode(getRealDBDialect().getDBType());
			iDEDataQueryCode.fillQueryParams(iDEDataSetFetchContext.getWebContext(), null, list);

			if (bFirst)
				bFirst = false;
			else {
				script.append(" UNION \n");
			}

			if (bTempMode) {
				script.append(iDEDataQueryCode.getQueryCodeTemp(iDEDataSetFetchContext, this.getRealDBDialect(), list));
			} else
				script.append(iDEDataQueryCode.getQueryCode(iDEDataSetFetchContext, this.getRealDBDialect(), list));

			if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getJoinScript())) {
				script.append(iDEDataQueryCode.getExtJoinSQL(iDEDataSetFetchContext, iDEDataSetFetchContext.getJoinScript(), this.getRealDBDialect(), list));
			}

			boolean bOutputWhere = false;
			boolean bCondFirst = true;

			java.util.Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
			while (deDataQueryCodeConds.hasNext()) {
				IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
				String strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataQueryCodeCond, this.getRealDBDialect(), list);
				if (StringHelper.isNullOrEmpty(strCondition)) continue;

				if (!bOutputWhere) {
					script.append(" WHERE ");
					bOutputWhere = true;
				}

				if (bCondFirst)
					bCondFirst = false;
				else
					script.append(" AND ");

				script.append("(%1$s)", strCondition);
			}

			if (userConditions.size() != 0) {
				if (!bOutputWhere) {
					script.append(" WHERE ");
					bOutputWhere = true;
				}

				for (IDEDataSetCond iDEDataSetCond : userConditions) {
					if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEDataQueryName())) {
						if (StringHelper.compare(iDEDataQueryCode.getName(), iDEDataSetCond.getDEDataQueryName(), false) != 0) continue;
					}

					String strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataSetCond, this.getRealDBDialect(), list);
					if (StringHelper.isNullOrEmpty(strCondition)) continue;

					if (bCondFirst)
						bCondFirst = false;
					else
						script.append(" AND ");

					script.append("(%1$s)", strCondition);

				}
			}
		}

		if (iDEDataSet.isEnableGroup()) {
			String strGroupSQL = declareScript.toString() + iDEDataSetFetchContext.getDeclareScript() + this.getGroupSQL(script.toString(), iDEDataSet);
			DBFetchResult dbFetchResult = fetchDataSet(session, null, strGroupSQL, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), list);
			if (dbFetchResult.isOk() && dbFetchResult.getDataSet() != null && iDEDataSetFetchContext.isCacheDataSet()) {
				dbFetchResult.getDataSet().cacheDataRow();
			}
			return dbFetchResult;
		} else {
			//String strCountSQL = declareScript.toString() + iDEDataSetFetchContext.getDeclareScript() + getRealDBDialect().getCountSQL(script.toString());
			String strCountSQL = "";
			if (iDEDataSetFetchContext.isFetchTotalRow()) {
				strCountSQL = declareScript.toString() + iDEDataSetFetchContext.getDeclareScript() + getRealDBDialect().getCountSQL(script.toString());
			}
			// 继续排序信息
			//String strPagingSQL = this.getRealDBDialect().getPagingSQL(script.toString(), iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), iDEDataSetFetchContext.getSort(), iDEDataSetFetchContext.getSortDir(), iDEDataSetFetchContext.getSort2(), iDEDataSetFetchContext.getSort2Dir());
			String strPagingSQL = "";
			if (iDEDataSetFetchContext.isFetchData()) {
				
				String strSort = iDEDataSetFetchContext.getSort();
				String strSortDir = iDEDataSetFetchContext.getSortDir();
				String strSort2 = iDEDataSetFetchContext.getSort2();
				String strSort2Dir = iDEDataSetFetchContext.getSort2Dir();
				if(StringHelper.isNullOrEmpty(strSort) && StringHelper.isNullOrEmpty(strSort2)) {
					//使用结果集合默认排序
					strSort = iDEDataSet.getMajorSortField();
					strSortDir = iDEDataSet.getMajorSortDir();
					strSort2 = iDEDataSet.getMinorSortField();
					strSort2Dir = iDEDataSet.getMinorSortDir();
				}
				if(StringHelper.isNullOrEmpty(strSort)) {
					strSortDir = null; 
				}
				if(StringHelper.isNullOrEmpty(strSort2)) {
					strSort2Dir = null; 
				}
				
				if (StringHelper.isNullOrEmpty(strSort) && StringHelper.isNullOrEmpty(strSort2) && (!iDEDataSetFetchContext.isPaging()))
					strPagingSQL = script.toString();
				else {
					strPagingSQL = this.getRealDBDialect().getPagingSQL(script.toString(), iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), strSort, strSortDir, strSort2, strSort2Dir,pagingDEDataQueryCode);
				}
			}
			DBFetchResult dbFetchResult = fetchDataSet(session, strCountSQL, strPagingSQL, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), list);
			if (dbFetchResult.isOk() && dbFetchResult.getDataSet() != null && iDEDataSetFetchContext.isCacheDataSet()) {
				dbFetchResult.getDataSet().cacheDataRow();
			}
			return dbFetchResult;
		}

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.dao.IDAO#fetchDEDataQuery(net.ibizsys.paas.db.ISelectContext, boolean)
	 */
	@Override
	public DBCallResult fetchDEDataQuery(ISelectContext iSelectContext, boolean bTempMode) throws Exception {
		//初始化获取上下文对象
		DEDataSetFetchContext iDEDataSetFetchContext = new DEDataSetFetchContext();
		iDEDataSetFetchContext.setWebContext(iSelectContext.getWebContext());
		iDEDataSetFetchContext.setFetchTotalRow(false);
		iDEDataSetFetchContext.setPaging(false);
		iDEDataSetFetchContext.setActiveDataObject(iSelectContext);
		iDEDataSetFetchContext.setSort(iSelectContext.getSort());
		iDEDataSetFetchContext.setSortDir(iSelectContext.getSortDir());
		
		/**
		 * 20200801增强查询
		 */
		DEDataSetFetchContext.setCurrent(iDEDataSetFetchContext);
		
		//ArrayList<IDEDataSetCond> userConditions = iDEDataSetFetchContext.getConditionList();
		IDEDataQuery iDEDataQuery = this.getDEModel().getDEDataQuery(iSelectContext.getDEDataQueryName());

		Session session = this.getCurrentSession();

		// 新建查询模型用户上下文
		StringBuilderEx script = new StringBuilderEx();
		StringBuilderEx declareScript = new StringBuilderEx();
		SqlParamList list = new SqlParamList();

		IDEDataQueryCode iDEDataQueryCode = this.getDEModel().getDEDataQuery(iDEDataQuery.getId()).getDEDataQueryCode(getRealDBDialect().getDBType());
		if (!StringHelper.isNullOrEmpty(iDEDataQueryCode.getDeclareCode())) {
			declareScript.append(iDEDataQueryCode.getDeclareCode());
			declareScript.append("\n");
			iDEDataQueryCode.fillDeclareParams(iDEDataSetFetchContext.getWebContext(), null, list);
		}

		iDEDataSetFetchContext.fillDeclareParams(list);
		iDEDataQueryCode.fillQueryParams(iDEDataSetFetchContext.getWebContext(), null, list);

		if (bTempMode) {
			script.append(iDEDataQueryCode.getQueryCodeTemp());
		} else
			script.append(iDEDataQueryCode.getQueryCode());

		if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getJoinScript())) {
			script.append(iDEDataQueryCode.getExtJoinSQL(iDEDataSetFetchContext, iDEDataSetFetchContext.getJoinScript(), this.getRealDBDialect(), list));
		}

		boolean bOutputWhere = false;
		boolean bCondFirst = true;

		java.util.Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
		while (deDataQueryCodeConds.hasNext()) {
			IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
			String strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataQueryCodeCond, this.getRealDBDialect(), list);
			if (StringHelper.isNullOrEmpty(strCondition)) continue;

			if (!bOutputWhere) {
				script.append(" WHERE ");
				bOutputWhere = true;
			}

			if (bCondFirst)
				bCondFirst = false;
			else
				script.append(" AND ");

			script.append("(%1$s)", strCondition);
		}
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		iSelectContext.fillMap(paramMap);
		for (String strFieldName : paramMap.keySet()) {
			IDEField iDEField = this.getDEModel().getDEField(strFieldName, true);
			if (iDEField == null) continue;

			if (!bOutputWhere) {
				script.append(" WHERE ");
				bOutputWhere = true;
			}

			if (bCondFirst)
				bCondFirst = false;
			else
				script.append(" AND ");
			
//			if (bCondFirst) {
//				bCondFirst = false;
//				script.append(" WHERE ");
//			} else
//				script.append("AND ");

			Object objValue = paramMap.get(strFieldName);
			if (objValue == SelectCond.ISNOTNULL) {
				script.append(" %1$s IS NOT NULL ", iDEDataQueryCode.getDEFieldExp(iDEField.getName(), false));
				continue;
			}
			if (objValue == SelectCond.ISNULL) {
				script.append(" %1$s IS NULL ", iDEDataQueryCode.getDEFieldExp(iDEField.getName(), false));
				continue;
			}

			SqlParam procParam = new SqlParam();
			procParam.setDataType(iDEField.getStdDataType());
			procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
			procParam.setValue(objValue);
			list.add(procParam);

			script.append(" %1$s = ? ", iDEDataQueryCode.getDEFieldExp(iDEField.getName(), false));
		}
		
		/**
		 * 20170830 实现查询条件过滤器
		 */
		if(iSelectContext.getSelectFilter()!=null && (iSelectContext.getSelectFilter() instanceof IDEDataQueryCodeCond)){
			IDEDataQueryCodeCond iDEDataQueryCodeCond = (IDEDataQueryCodeCond) iSelectContext.getSelectFilter();
			String strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataQueryCodeCond, this.getRealDBDialect(), list);
			if (!StringHelper.isNullOrEmpty(strCondition)){
				if (!bOutputWhere) {
					script.append(" WHERE ");
					bOutputWhere = true;
				}

				if (bCondFirst)
					bCondFirst = false;
				else
					script.append(" AND ");

				script.append("(%1$s)", strCondition);
			}
		}
		
		

		String strCountSQL = "";
		

		String strPagingSQL = "";
		
		strPagingSQL = script.toString();
		
		java.util.Iterator<ISelectField> selectFields = iSelectContext.getSelectFields();
		if (selectFields != null) {
			StringBuilderEx script2 = new StringBuilderEx();
			script2.append("SELECT ");
			int nIndex = 0;
			while (selectFields.hasNext()) {
				if (nIndex != 0) {
					script2.append(",");
				}
				nIndex++;
				ISelectField iSelectField = selectFields.next();
				String strAlias = iSelectField.getAlias();
				if (StringHelper.isNullOrEmpty(iSelectField.getFunc())) {
					if (StringHelper.isNullOrEmpty(iSelectField.getName())) {
						throw new Exception("没有指定字段名称");
					}

					if (StringHelper.isNullOrEmpty(strAlias)) {
						script2.append("%1$s", getRealDBDialect().getDBObjStandardName(iSelectField.getName()));
					} else {
						script2.append("%1$s AS %2$s", getRealDBDialect().getDBObjStandardName(iSelectField.getName()), getRealDBDialect().getDBObjStandardName(strAlias));
					}

				} else {
					String fields[] = null;
					if (!StringHelper.isNullOrEmpty(iSelectField.getName())) {
						fields = iSelectField.getName().split("[,]");
					}
					if (StringHelper.isNullOrEmpty(strAlias)) {
						if (fields != null && fields.length > 0) {
							strAlias = fields[0];
						} else {
							strAlias = StringHelper.format("A%1$s", strAlias);
						}
					}
					script2.append("%1$s AS %2$s", getRealDBDialect().getFuncSQL(iSelectField.getFunc(), fields), getRealDBDialect().getDBObjStandardName(strAlias));
				}
			}

			script2.append(" FROM (%1$s) m1  ", strPagingSQL);
			strPagingSQL = script2.toString();
		}

		DBFetchResult dbFetchResult = fetchDataSet(session, strCountSQL, strPagingSQL, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), list);
//		if (dbFetchResult.isOk() && dbFetchResult.getDataSet() != null && iDEDataSetFetchContext.isCacheDataSet()) {
//			dbFetchResult.getDataSet().cacheDataRow();
//		}
		
		return dbFetchResult;
		
		
		
		
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.dao.IDAO#fetchDEDataQuery(net.ibizsys.paas.core.IDEDataSetFetchContext, java.lang.String, boolean)
	 */
	@Override
	public DBFetchResult fetchDEDataQuery(IDEDataSetFetchContext iDEDataSetFetchContext, String strDEDataQueryName, boolean bTempMode) throws Exception {
		DEDataSetFetchContext.setCurrent(iDEDataSetFetchContext);

		ArrayList<IDEDataSetCond> userConditions = iDEDataSetFetchContext.getConditionList();
		IDEDataQuery iDEDataQuery = this.getDEModel().getDEDataQuery(strDEDataQueryName);

		Session session = this.getCurrentSession();

		// 新建查询模型用户上下文
		StringBuilderEx script = new StringBuilderEx();
		StringBuilderEx declareScript = new StringBuilderEx();
		SqlParamList list = new SqlParamList();

		IDEDataQueryCode iDEDataQueryCode = this.getDEModel().getDEDataQuery(iDEDataQuery.getId()).getDEDataQueryCode(getRealDBDialect().getDBType());
		if (!StringHelper.isNullOrEmpty(iDEDataQueryCode.getDeclareCode())) {
			declareScript.append(iDEDataQueryCode.getDeclareCode());
			declareScript.append("\n");
			iDEDataQueryCode.fillDeclareParams(iDEDataSetFetchContext.getWebContext(), null, list);
		}

		iDEDataSetFetchContext.fillDeclareParams(list);
		iDEDataQueryCode.fillQueryParams(iDEDataSetFetchContext.getWebContext(), null, list);

		if (bTempMode) {
			script.append(iDEDataQueryCode.getQueryCodeTemp());
		} else
			script.append(iDEDataQueryCode.getQueryCode());

		if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getJoinScript())) {
			script.append(iDEDataQueryCode.getExtJoinSQL(iDEDataSetFetchContext, iDEDataSetFetchContext.getJoinScript(), this.getRealDBDialect(), list));
		}

		boolean bOutputWhere = false;
		boolean bCondFirst = true;

		java.util.Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
		while (deDataQueryCodeConds.hasNext()) {
			IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
			String strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataQueryCodeCond, this.getRealDBDialect(), list);
			if (StringHelper.isNullOrEmpty(strCondition)) continue;

			if (!bOutputWhere) {
				script.append(" WHERE ");
				bOutputWhere = true;
			}

			if (bCondFirst)
				bCondFirst = false;
			else
				script.append(" AND ");

			script.append("(%1$s)", strCondition);
		}

		if (userConditions.size() != 0) {
			if (!bOutputWhere) {
				script.append(" WHERE ");
				bOutputWhere = true;
			}

			for (IDEDataSetCond iDEDataSetCond : userConditions) {
				if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEDataQueryName())) {
					if (StringHelper.compare(iDEDataQueryCode.getName(), iDEDataSetCond.getDEDataQueryName(), false) != 0) continue;
				}

				String strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataSetCond, this.getRealDBDialect(), list);
				if (StringHelper.isNullOrEmpty(strCondition)) continue;

				if (bCondFirst)
					bCondFirst = false;
				else
					script.append(" AND ");

				script.append("(%1$s)", strCondition);

			}
		}

		String strCountSQL = "";
		if (iDEDataSetFetchContext.isFetchTotalRow()) {
			strCountSQL = declareScript.toString() + iDEDataSetFetchContext.getDeclareScript() + getRealDBDialect().getCountSQL(script.toString());
		}

		String strPagingSQL = "";
		if (iDEDataSetFetchContext.isFetchData()) {
			if (StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort()) && StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort2()) && (!iDEDataSetFetchContext.isPaging()))
				strPagingSQL = script.toString();
			else {
				strPagingSQL = this.getRealDBDialect().getPagingSQL(script.toString(), iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), iDEDataSetFetchContext.getSort(), iDEDataSetFetchContext.getSortDir(), iDEDataSetFetchContext.getSort2(), iDEDataSetFetchContext.getSort2Dir(),iDEDataQueryCode);
			}
		}

		DBFetchResult dbFetchResult = fetchDataSet(session, strCountSQL, strPagingSQL, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), list);
		if (dbFetchResult.isOk() && dbFetchResult.getDataSet() != null && iDEDataSetFetchContext.isCacheDataSet()) {
			dbFetchResult.getDataSet().cacheDataRow();
		}
		return dbFetchResult;
	}

	/**
	 * 获取数据集合结果
	 * 
	 * @param session
	 * @param strCountSQL
	 * @param strPagingSQL
	 * @param nStartPos
	 * @param nPageSize
	 * @param list
	 * @return
	 * @throws Exception
	 */
	protected DBFetchResult fetchDataSet(Session session, String strCountSQL, String strPagingSQL, int nStartPos, int nPageSize, SqlParamList list) throws Exception {
		final DBFetchResult dbFetchResult = new DBFetchResult();
		final String strCountSQL2 = strCountSQL;
		final String strPagingSQL2 = strPagingSQL;
		final int nStartPos2 = nStartPos;
		final int nPageSize2 = nPageSize;
		final SqlParamList list2 = list;

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();

			if (!StringHelper.isNullOrEmpty(strPagingSQL)) {
				sb.append("查询SQL\r\n%1$s", strPagingSQL);
				int nIndex = 0;
				for (SqlParam sqlParam : list) {
					sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
					nIndex++;
				}
				sb.append("\r\n");
			}

			if (!StringHelper.isNullOrEmpty(strCountSQL)) {
				sb.append("分页SQL\r\n%1$s", strCountSQL);
				int nIndex = 0;
				for (SqlParam sqlParam : list) {
					sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
					nIndex++;
				}
			}

			log.debug(sb.toString());
		}
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					onPrepareConnection(connection,null);
					if (!StringHelper.isNullOrEmpty(strPagingSQL2)) {
						DBCallResult dbCallResult = getRealDBDialect().callSql(connection, strPagingSQL2, list2, -1);
						if (dbCallResult.isOk()) {
							IDataSet iDataSet = dbCallResult.getDataSet();
							dbFetchResult.setDataSet(iDataSet);
						} else {
							throw new Exception(dbCallResult.getErrorInfo());
						}
					}

					if (!StringHelper.isNullOrEmpty(strCountSQL2)) {
						DBCallResult dbCallResult = getRealDBDialect().callSql(connection, strCountSQL2, list2, -1);
						if (dbCallResult.isOk()) {
							IDataSet iDataSet = dbCallResult.getDataSet();
							if (iDataSet != null) {
								IDataRow iDataRow = iDataSet.getDataTable(0).next();
								dbFetchResult.setTotalRow(Integer.parseInt(iDataRow.get("TOTALROW").toString()));
								iDataSet.close();
							}
						} else {
							throw new Exception(dbCallResult.getErrorInfo());
						}
					}
				} catch (Exception e) {
					if (dbFetchResult.getDataSet() != null) {
						dbFetchResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});
		return dbFetchResult;
	}
	
	
	

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 */
	public abstract IDataEntityModel getDEModel();

	/**
	 * 获取当前数据库类型
	 * 
	 * @return
	 */

	protected String getDBType() {
		return this.getRealDBDialect().getDBType();
	}

	/**
	 * GET 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	@Override
	public DBCallResult executeGetSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
		return executeGetSql(iDEDBCallContext,  et, IDataEntity.VIEWLEVEL_DEFAULT,bTempMode);
	}
	
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.dao.IDAO#executeGetSql(net.ibizsys.paas.core.IDEDBCallContext, net.ibizsys.paas.entity.IEntity, int, boolean)
	 */
	@Override
	public DBCallResult executeGetSql(IDEDBCallContext iDEDBCallContext, ET et, int nViewLevel, boolean bTempMode) throws Exception {
		Session session = this.getCurrentSession();
		ISqlCommandModel curSqlCommandModel = null;
		
		if((et.get(this.getDEModel().getKeyDEField().getName())!=null) || ((this.getDEModel().getUniTagDEField() == null) || (et.get(this.getDEModel().getUniTagDEField().getName())==null))){
			//传入主键
			if (bTempMode) {
				if (getTempSqlCommandModel == null) getTempSqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(), bTempMode);
				curSqlCommandModel = getTempSqlCommandModel;
			} else {
				switch(nViewLevel){
				case IDataEntity.VIEWLEVEL_LEVEL2:
					if (get2SqlCommandModel == null){
						get2SqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(),nViewLevel, bTempMode);
					}
					curSqlCommandModel = get2SqlCommandModel;
					break;
				case IDataEntity.VIEWLEVEL_LEVEL3:
					if (get3SqlCommandModel == null){
						get3SqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(),nViewLevel, bTempMode);
					}
					curSqlCommandModel = get3SqlCommandModel;
					break;
				case IDataEntity.VIEWLEVEL_LEVEL4:
					if (get4SqlCommandModel == null){
						get4SqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(),nViewLevel, bTempMode);
					}
					curSqlCommandModel = get4SqlCommandModel;
					break;
				default:
					if (getSqlCommandModel == null){
						getSqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(), bTempMode);
					}
					curSqlCommandModel = getSqlCommandModel;
					break;
				}
			}
		}
		else{
			
			if (bTempMode) {
				if (getTempSqlCommandModel2 == null){
					getTempSqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(),IDataEntity.VIEWLEVEL_DEFAULT ,bTempMode);
				}
				curSqlCommandModel = getTempSqlCommandModel2;
			} else {
				switch(nViewLevel){
				case IDataEntity.VIEWLEVEL_LEVEL2:
					if (get2SqlCommandModel2 == null){
						get2SqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(),nViewLevel, bTempMode);
					}
					curSqlCommandModel = get2SqlCommandModel2;
					break;
				case IDataEntity.VIEWLEVEL_LEVEL3:
					if (get3SqlCommandModel2 == null){
						get3SqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(),nViewLevel, bTempMode);
					}
					curSqlCommandModel = get3SqlCommandModel2;
					break;
				case IDataEntity.VIEWLEVEL_LEVEL4:
					if (get4SqlCommandModel2 == null){
						get4SqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(),nViewLevel, bTempMode);
					}
					curSqlCommandModel = get4SqlCommandModel2;
					break;
				default:
					if (getSqlCommandModel2 == null){
						getSqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(),IDataEntity.VIEWLEVEL_DEFAULT , bTempMode);
					}
					curSqlCommandModel = getSqlCommandModel2;
					break;
				}
			}
		}
		
		
		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		final ISqlCommandModel iSqlCommandModel = curSqlCommandModel;

		SqlParamList sqlParamList = new SqlParamList();
		iSqlCommandModel.fillSqlParams(et, this.getWebContext(), sqlParamList);

		if (log.isDebugEnabled()) {
			StringBuilderEx sBuilderEx = new StringBuilderEx();
			sBuilderEx.append("查询SQL\r\n%1$s", iSqlCommandModel.getSql());
			int nIndex = 0;
			for (SqlParam sqlParam : sqlParamList) {
				sBuilderEx.append(StringHelper.format("\r\n[%1$s]%2$s==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue()));
				nIndex++;
			}
			log.debug(sBuilderEx.toString());

		}

		final SqlParamList sqlParamList2 = sqlParamList;
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					dbCallResult = getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}
				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	@Override
	public DBCallResult executeCheckKeySql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
		Session session = this.getCurrentSession();
		ISqlCommandModel curSqlCommandModel = null;
		if((et.get(this.getDEModel().getKeyDEField().getName())!=null) || ((this.getDEModel().getUniTagDEField() == null) || (et.get(this.getDEModel().getUniTagDEField().getName())==null))){
			if (bTempMode) {
				if (checkKeyTempSqlCommandModel == null) checkKeyTempSqlCommandModel = this.getDEModel().getCheckKeySqlCommandModel(this.getRealDBDialect(), bTempMode);
			} else {
				if (checkKeySqlCommandModel == null) checkKeySqlCommandModel = this.getDEModel().getCheckKeySqlCommandModel(this.getRealDBDialect(), bTempMode);
			}
			curSqlCommandModel = bTempMode ? checkKeyTempSqlCommandModel : checkKeySqlCommandModel;
		}
		else{
			if (bTempMode) {
				if (checkKeyTempSqlCommandModel2 == null) checkKeyTempSqlCommandModel2 = this.getDEModel().getCheckKeySqlCommandModel2(this.getRealDBDialect(), bTempMode);
			} else {
				if (checkKeySqlCommandModel2 == null) checkKeySqlCommandModel2 = this.getDEModel().getCheckKeySqlCommandModel2(this.getRealDBDialect(), bTempMode);
			}
			curSqlCommandModel = bTempMode ? checkKeyTempSqlCommandModel2 : checkKeySqlCommandModel2;
		}
		

		final ISqlCommandModel iSqlCommandModel = curSqlCommandModel;

		SqlParamList sqlParamList = new SqlParamList();
		iSqlCommandModel.fillSqlParams(et, this.getWebContext(), sqlParamList);

		if (log.isDebugEnabled()) {
			StringBuilderEx sBuilderEx = new StringBuilderEx();
			sBuilderEx.append("查询SQL\r\n%1$s", iSqlCommandModel.getSql());
			int nIndex = 0;
			for (SqlParam sqlParam : sqlParamList) {
				sBuilderEx.append(StringHelper.format("\r\n[%1$s]%2$s==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue()));
				nIndex++;
			}
			log.debug(sBuilderEx.toString());
		}

		final SqlParamList sqlParamList2 = sqlParamList;
		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					dbCallResult = getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}
				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	/**
	 * Create 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	@Override
	public DBCallResult executeCreateSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
		Session session = this.getCurrentSession();

		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		final ET et2 = et;
		final boolean bTempMode2 = bTempMode;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					if (getInheritDEDAO() != null) {
						
						fillInheritEntity(et2);
						DBCallResult dbCallResult2 = getInheritDEDAO().executeCreateSql(iDEDBCallContext2, et2, bTempMode2);
						if (!dbCallResult2.isOk()) {
							throw new Exception(dbCallResult2.getErrorInfo());
						}
						if (dbCallResult2.getDataSet() != null) {
							dbCallResult2.getDataSet().cacheDataRow();
						}
						
						if(et2.get(getDEModel().getKeyDEField().getName())==null){
							if(et2.get(getInheritDEDAO().getDEModel().getKeyDEField().getName())==null){
								getInheritDEDAO().getDEModel().getService(getSessionFactory()).get(et2);
							}
							et2.set(getDEModel().getKeyDEField().getName(), et2.get(getInheritDEDAO().getDEModel().getKeyDEField().getName()));
						}
					}
					
					/**
					 * 建立数据SQL命令模型
					 */
					ISqlCommandModel createSqlCommandModel =  getDEModel().getCreateSqlCommandModel(getRealDBDialect(),et2, bTempMode2);
				
					SqlParamList sqlParamList = new SqlParamList();
					createSqlCommandModel.fillSqlParams(et2, getWebContext(), sqlParamList);

					if (log.isDebugEnabled()) {
						StringBuilderEx sb = new StringBuilderEx();
						sb.append("插入SQL\r\n%1$s",createSqlCommandModel.getSql());
						int nIndex = 0;
						for (SqlParam sqlParam : sqlParamList) {
							sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
							nIndex++;
						}
						log.debug(sb.toString());
					}

					dbCallResult = getRealDBDialect().callSql(connection, createSqlCommandModel.getSql(), sqlParamList, -1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
						if (dbCallResult.getDataSet() != null) {
							dbCallResult.getDataSet().cacheDataRow();
						}
						
						if(getDEModel().getKeyDEField().isPhisicalDEField() && et2.get(getDEModel().getKeyDEField().getName())==null){
							//判断主键是否有插入模式
							if(!getDEModel().getKeyDEField().isEnableDBValueInsertUpdateMode() || StringHelper.isNullOrEmpty(getDEModel().getKeyDEField().getDBValueInsertMode())){
								DBCallResult dbCallResult2 = getRealDBDialect().getLastInsertId(connection);
								if(dbCallResult2.isOk()){
									Object objKeyValue = null;
									if (dbCallResult2.getDataSet() != null) {
										dbCallResult2.getDataSet().cacheDataRow();
										if(dbCallResult2.getDataSet().getDataTableCount()>0){
											IDataTable iDataTable = dbCallResult2.getDataSet().getDataTable(0);
											if(iDataTable.getCachedRowCount()>0){
												objKeyValue  = iDataTable.getCachedRow(0).get(0);
											}
										}
									}
									if(objKeyValue == null){
										throw new Exception("无法获取最后插入的数据标识");
									}
									et2.set(getDEModel().getKeyDEField().getName(), objKeyValue);
								}
								else{
									throw new Exception(dbCallResult2.getErrorInfo());
								}
							}
						}
						
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}
				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	/**
	 * Update 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	@Override
	public DBCallResult executeUpdateSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
		Session session = this.getCurrentSession();

		ISqlCommandModel updateSqlCommandModel = this.getDEModel().getUpdateSqlCommandModel(this.getRealDBDialect(), et, bTempMode);

		if (getInheritDEDAO() != null) {
			fillInheritEntity(et);
		}

		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		final ISqlCommandModel iSqlCommandModel = updateSqlCommandModel;

		SqlParamList sqlParamList = new SqlParamList();
		iSqlCommandModel.fillSqlParams(et, this.getWebContext(), sqlParamList);

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();
			sb.append("更新SQL\r\n%1$s", updateSqlCommandModel.getSql());
			int nIndex = 0;
			for (SqlParam sqlParam : sqlParamList) {
				sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
				nIndex++;
			}
			log.debug(sb.toString());
		}

		final SqlParamList sqlParamList2 = sqlParamList;
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		final ET et2 = et;
		final boolean bTempMode2 = bTempMode;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					if (getInheritDEDAO() != null) {
						DBCallResult dbCallResult2 = getInheritDEDAO().executeUpdateSql(iDEDBCallContext2, et2, bTempMode2);
						if (!dbCallResult2.isOk()) {
							throw new Exception(dbCallResult2.getErrorInfo());
						}
						if (dbCallResult2.getDataSet() != null) {
							dbCallResult2.getDataSet().cacheDataRow();
						}
					}

					dbCallResult = getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
						if (dbCallResult.getDataSet() != null) {
							dbCallResult.getDataSet().cacheDataRow();
						}
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}
				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.dao.IDAO#executeSysUpdateSql(net.ibizsys.paas.core.IDEDBCallContext, net.ibizsys.paas.entity.IEntity, boolean)
	 */
	@Override
	public DBCallResult executeSysUpdateSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
		Session session = this.getCurrentSession();

		ISqlCommandModel updateSqlCommandModel = this.getDEModel().getSysUpdateSqlCommandModel(this.getRealDBDialect(), et, bTempMode);

		if (getInheritDEDAO() != null) {
			fillInheritEntity(et);
		}

		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		final ISqlCommandModel iSqlCommandModel = updateSqlCommandModel;

		SqlParamList sqlParamList = new SqlParamList();
		iSqlCommandModel.fillSqlParams(et, this.getWebContext(), sqlParamList);

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();
			sb.append("更新SQL\r\n%1$s", updateSqlCommandModel.getSql());
			int nIndex = 0;
			for (SqlParam sqlParam : sqlParamList) {
				sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
				nIndex++;
			}
			log.debug(sb.toString());
		}

		final SqlParamList sqlParamList2 = sqlParamList;
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		final ET et2 = et;
		final boolean bTempMode2 = bTempMode;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					if (getInheritDEDAO() != null) {
						DBCallResult dbCallResult2 = getInheritDEDAO().executeSysUpdateSql(iDEDBCallContext2, et2, bTempMode2);
						if (!dbCallResult2.isOk()) {
							throw new Exception(dbCallResult2.getErrorInfo());
						}
						if (dbCallResult2.getDataSet() != null) {
							dbCallResult2.getDataSet().cacheDataRow();
						}
					}

					dbCallResult = getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
						if (dbCallResult.getDataSet() != null) {
							dbCallResult.getDataSet().cacheDataRow();
						}
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}
				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	/**
	 * Select 操作
	 * 
	 * @param iDEDBCallContext
	 * @param iSelectCond
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	@Override
	public DBCallResult executeSelectSql(IDEDBCallContext iDEDBCallContext, ISelectCond iSelectCond, boolean bTempMode) throws Exception {
		Session session = this.getCurrentSession();

		ISqlCommandModel selectSqlCommandModel = this.getDEModel().getSelectSqlCommandModel(this.getRealDBDialect(), iSelectCond, bTempMode);

		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		final ISqlCommandModel iSqlCommandModel = selectSqlCommandModel;

		SqlParamList sqlParamList = new SqlParamList();
		iSqlCommandModel.fillSqlParams(iSelectCond, this.getWebContext(), sqlParamList);

		final SqlParamList sqlParamList2 = sqlParamList;

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();
			sb.append("查询 SQL\r\n%1$s", selectSqlCommandModel.getSql());
			int nIndex = 0;
			for (SqlParam sqlParam : sqlParamList) {
				sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
				nIndex++;
			}
			log.debug(sb.toString());
		}
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					dbCallResult = getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}
				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	/**
	 * Remove 操作
	 * 
	 * @param iDEDBCallContext
	 * @param et
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	@Override
	public DBCallResult executeRemoveSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
		Session session = this.getCurrentSession();

		if (bTempMode) {
			if (removeTempSqlCommandModel == null) removeTempSqlCommandModel = this.getDEModel().getRemoveSqlCommandModel(this.getRealDBDialect(), bTempMode);
		} else {
			if (removeSqlCommandModel == null) removeSqlCommandModel = this.getDEModel().getRemoveSqlCommandModel(this.getRealDBDialect(), bTempMode);
		}

		if (getInheritDEDAO() != null) {
			fillInheritEntity(et);
		}

		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		final ISqlCommandModel iSqlCommandModel = (bTempMode ? removeTempSqlCommandModel : removeSqlCommandModel);

		SqlParamList sqlParamList = new SqlParamList();
		iSqlCommandModel.fillSqlParams(et, this.getWebContext(), sqlParamList);

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();
			sb.append("删除SQL\r\n%1$s", (bTempMode ? removeTempSqlCommandModel : removeSqlCommandModel).getSql());
			int nIndex = 0;
			for (SqlParam sqlParam : sqlParamList) {
				sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
				nIndex++;
			}
			log.debug(sb.toString());
		}

		final SqlParamList sqlParamList2 = sqlParamList;
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		final ET et2 = et;
		final boolean bTempMode2 = bTempMode;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					dbCallResult = getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}

					if (getInheritDEDAO() != null) {
						dbCallResult = getInheritDEDAO().executeRemoveSql(iDEDBCallContext2, et2, bTempMode2);
						if (!dbCallResult.isOk()) {
							throw new Exception(dbCallResult.getErrorInfo());
						}
					}

				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	/**
	 * Remove 操作，通过查询条件
	 * 
	 * @param iDEDBCallContext
	 * @param iSelectCond
	 * @param bTempMode
	 * @return
	 * @throws Exception
	 */
	@Override
	public DBCallResult executeRemoveSql(IDEDBCallContext iDEDBCallContext, ISelectCond iSelectCond, boolean bTempMode) throws Exception {
		// Session session = this.getCurrentSession();
		//
		// ISqlCommandModel removeSqlCommandModel = this.getDEModel().getRemoveSqlCommandModel(this.getRealDBDialect(),iSelectCond,bTempMode);
		//
		// final DBFetchResult dbFetchResult = new DBFetchResult();
		// final ISqlCommandModel iSqlCommandModel = removeSqlCommandModel;
		//
		//
		// SqlParamList sqlParamList = new SqlParamList();
		// iSqlCommandModel.fillSqlParams(iSelectCond, this.getWebContext(), sqlParamList);
		//
		// final SqlParamList sqlParamList2 = sqlParamList;
		//
		// if(log.isDebugEnabled())
		// {
		// StringBuilderEx sb = new StringBuilderEx();
		// sb.append("删除 SQL\r\n%1$s", removeSqlCommandModel.getSql());
		// int nIndex =0;
		// for(SqlParam sqlParam: sqlParamList)
		// {
		// sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex,sqlParam.getParamName(),sqlParam.getValue());
		// nIndex++;
		// }
		// log.debug(sb.toString());
		// }
		//
		// session.doWork(new Work()
		// {
		// @Override
		// public void execute(Connection connection) throws SQLException
		// {
		// try
		// {
		// DBCallResult dbCallResult = getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
		// if (dbCallResult.isOk())
		// {
		// IDataSet iDataSet = dbCallResult.getDataSet();
		// dbFetchResult.setDataSet(iDataSet);
		// }
		// else
		// {
		// throw new Exception(dbCallResult.getErrorInfo());
		// }
		// }
		// catch (Exception e)
		// {
		// if (dbFetchResult.getDataSet() != null)
		// {
		// dbFetchResult.getDataSet().close();
		// }
		// throw new SQLException(e.getMessage(),e);
		// }
		// }
		// });
		//
		// return dbFetchResult;

		throw new Exception("没有实现");
	}

	
	@Override
	public ArrayList<IEntity> executeRawSelectSql(IDEDBCallContext iDEDBCallContext, String strSql, SqlParamList sqlParamList) throws Exception {
		Session session = this.getCurrentSession();

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();
			sb.append("SQL\r\n%1$s", strSql);
			int nIndex = 0;
			if (sqlParamList != null) {
				for (SqlParam sqlParam : sqlParamList) {
					sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
					nIndex++;
				}
			}
			log.debug(sb.toString());
		}

		final String strSql2 = strSql;
		final DBFetchResult dbFetchResult = new DBFetchResult();
		final SqlParamList sqlParamList2 = sqlParamList;
		final ArrayList<IEntity> entityList = new ArrayList<IEntity>();
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					DBCallResult dbCallResult = getRealDBDialect().callSql(connection, strSql2, sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						IDataSet iDataSet = dbCallResult.getDataSet();
						if (iDataSet == null || (iDataSet.getDataTableCount() == 0)) throw new ErrorException(Errors.INVALIDDATA);

						IDataTable iDataTable = iDataSet.getDataTable(0);
						iDataTable.cacheRows(-1);
						int nCount = iDataTable.getCachedRowCount();
						for (int i = 0; i < nCount; i++) {
							IDataRow iDataRow = iDataTable.getCachedRow(i);
							SimpleEntity simpleEntity = new SimpleEntity();
							DataObject.fromDataRow(simpleEntity, iDataRow, false);
							entityList.add(simpleEntity);
						}

						iDataSet.close();
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}

				} catch (Exception e) {
					if (dbFetchResult.getDataSet() != null) {
						dbFetchResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return entityList;
	}
	
	@Override
	public ArrayList<ET> executeSelectSql(IDEDBCallContext iDEDBCallContext, String strSql, SqlParamList sqlParamList) throws Exception {
		Session session = this.getCurrentSession();

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();
			sb.append("SQL\r\n%1$s", strSql);
			int nIndex = 0;
			if (sqlParamList != null) {
				for (SqlParam sqlParam : sqlParamList) {
					sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
					nIndex++;
				}
			}
			log.debug(sb.toString());
		}

		final String strSql2 = strSql;
		final DBFetchResult dbFetchResult = new DBFetchResult();
		final SqlParamList sqlParamList2 = sqlParamList;
		final ArrayList<ET> entityList = new ArrayList<ET>();
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					DBCallResult dbCallResult = getRealDBDialect().callSql(connection, strSql2, sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						IDataSet iDataSet = dbCallResult.getDataSet();
						if (iDataSet == null || (iDataSet.getDataTableCount() == 0)) throw new ErrorException(Errors.INVALIDDATA);

						IDataTable iDataTable = iDataSet.getDataTable(0);
						iDataTable.cacheRows(-1);
						int nCount = iDataTable.getCachedRowCount();
						for (int i = 0; i < nCount; i++) {
							IDataRow iDataRow = iDataTable.getCachedRow(i);
							ET simpleEntity = (ET) getDEModel().createEntity();
							DataObject.fromDataRow(simpleEntity, iDataRow, false);
							entityList.add(simpleEntity);
						}

						iDataSet.close();
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}

				} catch (Exception e) {
					if (dbFetchResult.getDataSet() != null) {
						dbFetchResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return entityList;
	}

	@Override
	public IEntity executeRawSelectOneSql(IDEDBCallContext iDEDBCallContext, String strSql, SqlParamList sqlParamList) throws Exception {
		Session session = this.getCurrentSession();

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();
			sb.append("SQL\r\n%1$s", strSql);
			int nIndex = 0;
			if (sqlParamList != null) {
				for (SqlParam sqlParam : sqlParamList) {
					sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
					nIndex++;
				}
			}
			log.debug(sb.toString());
		}

		final String strSql2 = strSql;
		final DBFetchResult dbFetchResult = new DBFetchResult();
		final SqlParamList sqlParamList2 = sqlParamList;
		final ArrayList<IEntity> entityList = new ArrayList<IEntity>();
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					DBCallResult dbCallResult = getRealDBDialect().callSql(connection, strSql2, sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						IDataSet iDataSet = dbCallResult.getDataSet();
						if (iDataSet == null || (iDataSet.getDataTableCount() == 0)) throw new ErrorException(Errors.INVALIDDATA);

						IDataTable iDataTable = iDataSet.getDataTable(0);
						iDataTable.cacheRows(1);
						int nCount = iDataTable.getCachedRowCount();
						for (int i = 0; i < nCount; i++) {
							IDataRow iDataRow = iDataTable.getCachedRow(i);
							SimpleEntity simpleEntity = new SimpleEntity();
							DataObject.fromDataRow(simpleEntity, iDataRow, false);
							entityList.add(simpleEntity);
						}

						iDataSet.close();
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}

				} catch (Exception e) {
					if (dbFetchResult.getDataSet() != null) {
						dbFetchResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		if (entityList.size() == 0) {
			return null;
			// throw new ErrorException(Errors.INVALIDDATA);
		}
		return entityList.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.dao.IDAO#executeRawSql(net.ibizsys.paas.core.IDEDBCallContext, java.lang.String, net.ibizsys.paas.db.SqlParamList)
	 */
	@Override
	public DBCallResult executeRawSql(IDEDBCallContext iDEDBCallContext, String strSql, SqlParamList sqlParamList) throws Exception {
		Session session = this.getCurrentSession();

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();
			sb.append("SQL\r\n%1$s", strSql);
			int nIndex = 0;
			if (sqlParamList != null) {
				for (SqlParam sqlParam : sqlParamList) {
					sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
					nIndex++;
				}
			}
			log.debug(sb.toString());
		}

		final String strSql2 = strSql;
		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		final SqlParamList sqlParamList2 = sqlParamList;
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					dbCallResult = getRealDBDialect().callSql(connection, strSql2, sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}
				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.dao.IDAO#executeRawSqlBatch(net.ibizsys.paas.core.IDEDBCallContext, java.lang.String[], net.ibizsys.paas.db.SqlParamList[], int)
	 */
	@Override
	public DBCallResult executeRawSqlBatch(IDEDBCallContext iDEDBCallContext, String[] sqls, SqlParamList[] sqlParamLists,int nBatchSize) throws Exception {
		Session session = this.getCurrentSession();

//		if (log.isDebugEnabled()) {
//			StringBuilderEx sb = new StringBuilderEx();
//			sb.append("SQL\r\n%1$s", strSql);
//			int nIndex = 0;
//			if (sqlParamList != null) {
//				for (SqlParam sqlParam : sqlParamList) {
//					sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
//					nIndex++;
//				}
//			}
//			log.debug(sb.toString());
//		}

		final String[] sqls2 = sqls;
		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		final SqlParamList[] sqlParamLists2 = sqlParamLists;
		final int nBatchSize2 = nBatchSize;
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					dbCallResult = getRealDBDialect().callSqlBatch(connection, sqls2, sqlParamLists2, nBatchSize2,-1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}
				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.dao.IDAO#executeRawSql(net.ibizsys.paas.core.IDEDBCallContext, java.lang.String, net.ibizsys.paas.db.SqlParamList)
	 */
	@Override
	public DBCallResult callProc(IDEDBCallContext iDEDBCallContext, String strProcName, SqlParamList sqlParamList) throws Exception {
		Session session = this.getCurrentSession();

		if (log.isDebugEnabled()) {
			StringBuilderEx sb = new StringBuilderEx();
			sb.append("存储过程\r\n%1$s", strProcName);
			int nIndex = 0;
			if (sqlParamList != null) {
				for (SqlParam sqlParam : sqlParamList) {
					sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
					nIndex++;
				}
			}
			log.debug(sb.toString());
		}

		final String strProcName2 = strProcName;
		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
		final SqlParamList sqlParamList2 = sqlParamList;
		final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				DBCallResult dbCallResult = null;
				try {
					onPrepareConnection(connection,iDEDBCallContext2);
					dbCallResult = getRealDBDialect().callProc(connection, strProcName2, sqlParamList2, -1);
					if (dbCallResult.isOk()) {
						dbCallResultProxy.setDBCallResult(dbCallResult);
					} else {
						throw new Exception(dbCallResult.getErrorInfo());
					}
				} catch (Exception e) {
					if (dbCallResult != null && dbCallResult.getDataSet() != null) {
						dbCallResult.getDataSet().close();
					}
					throw new SQLException(StringHelper.format("数据库操作发生异常，%1$s", e.getMessage()), e);
				}
			}
		});

		return dbCallResultProxy.getDBCallResult();
	}

	/**
	 * 填充继承实体的信息
	 * 
	 * @param et
	 * @param inheritET
	 * @throws Exception
	 */
	protected void fillInheritEntity(ET et) throws Exception {

	}

	@Override
	public void setDBDialect(IDBDialect iDBDialect) {
		this.iDBDialect = iDBDialect;
	}

	/**
	 * 获取数据库适配器
	 * 
	 * @return
	 */
	public IDBDialect getRealDBDialect() {
		if (this.iDBDialect != null) return this.iDBDialect;
		return this.getDEModel().getSystemRuntime().getDBDialect(this.getDEModel().getDSLink());
	}

	/**
	 * 获取会话工厂
	 * 
	 * @return
	 */
	public SessionFactory getRealSessionFactory() {
		if (this.sessionFactory != null) {
			return this.sessionFactory;
		}

		return this.getDEModel().getSystemRuntime().getSessionFactory(this.getDEModel().getDSLink());
	}

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获取会话工厂
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	/**
	 * 获取当前会话
	 * 
	 * @return
	 */
	@Override
	public Session getCurrentSession() throws Exception {
		return SessionFactoryManager.getCurrentSession(this.getRealSessionFactory());
	}

	/**
	 * 获取分组语句
	 * 
	 * @param strSQL
	 * @param iDEDataSet
	 * @return
	 * @throws Exception
	 */
	protected String getGroupSQL(String strSQL, IDEDataSet iDEDataSet) throws Exception {
		if (StringHelper.isNullOrEmpty(strSQL)) {
			throw new Exception(StringHelper.format("主查询语句无效"));
		}

		StringBuilderEx sqlGroup = new StringBuilderEx();

		IDataEntity majorDataEntity = iDEDataSet.getDataEntity();

		sqlGroup.append("SELECT ");

		boolean bFirst = true;

		int nAliasIndex = 0;

		// TreeMap<Integer, String> orderMap = new TreeMap<Integer, String>();
		ArrayList<String> groupFields = new ArrayList<String>();
		ArrayList<String> orderList = new ArrayList<String>();

		ArrayList<IDEDataSetGroupParam> recalcItems = new ArrayList<IDEDataSetGroupParam>();

		java.util.Iterator<IDEDataSetGroupParam> deDataSetGroupParams = iDEDataSet.getDEDataSetGroupParams();

		while (deDataSetGroupParams.hasNext()) {
			IDEDataSetGroupParam iDEDataSetGroupParam = deDataSetGroupParams.next();
			if (iDEDataSetGroupParam.isReCalc()) {
				recalcItems.add(iDEDataSetGroupParam);
				continue;
			}

			nAliasIndex++;

			String strFormular = iDEDataSetGroupParam.getGroupCode();
			String[] fields = iDEDataSetGroupParam.getGroupFields();

			if (StringHelper.isNullOrEmpty(strFormular) && fields == null) {
				continue;
			}
			String strFieldCode = "";
			// String strAlias = iDEDataSetGroupParam.getAlias();
			String strAlias = iDEDataSetGroupParam.getName();
			if (fields != null) {
				// String[] fields = strDEFields.split("[,]");

				String[] fieldCodes = new String[fields.length];

				if (StringHelper.isNullOrEmpty(strFormular)) {
					strFormular = "%1$s";
					// 取第一个字段
					String strDEField = fields[0];
					IDEField defHelper = majorDataEntity.getDEField(strDEField, true);
					if (defHelper == null) {
						if (StringHelper.isNullOrEmpty(strAlias)) strAlias = fields[0];
						fieldCodes[0] = strDEField;
					} else {
						if (StringHelper.isNullOrEmpty(strAlias)) strAlias = fields[0];

						String strRealCode = getDEFieldStatisticsNullConvertCode(defHelper);
						fieldCodes[0] = strRealCode;
					}
				} else {

					for (int i = 0; i < fields.length; i++) {
						String strDEField = fields[i];
						IDEField defHelper = majorDataEntity.getDEField(strDEField, true);
						if (defHelper == null) {
							fieldCodes[i] = strDEField;
						} else {
							String strRealCode = getDEFieldStatisticsNullConvertCode(defHelper);
							fieldCodes[i] = strRealCode;
						}
					}
				}

				strFieldCode = StringHelper.format(strFormular, fieldCodes);
			} else {
				strFieldCode = strFormular;
			}

			if (bFirst) {
				bFirst = false;
			} else
				sqlGroup.append(",");

			// if (StringHelper.isNullOrEmpty(strAlias))
			// {
			// strAlias = StringHelper.format("A%1$s", nAliasIndex);
			// iDEDataSetGroupParam.setAlias(strAlias);
			// }

			sqlGroup.append("%1$s as %2$s", strFieldCode, strAlias);

			if (iDEDataSetGroupParam.isEnableGroup()) groupFields.add(strFieldCode);

			if (!StringHelper.isNullOrEmpty(iDEDataSetGroupParam.getSortDir())) {
				orderList.add(StringHelper.format("%1$s %2$s", strAlias, iDEDataSetGroupParam.getSortDir()));
				// orderMap.put(iDEDataSetGroupParam.getOrder(), StringHelper.format("%1$s %2$s", strAlias, iDEDataSetGroupParam.getSortDir()));
			}

			// 增加变量
			// String strParams = iDEDataSetGroupParam.getUserTag();
			// if (!StringHelper.isNullOrEmpty(strParams))
			// {
			// String[] params = strParams.split("[;]");
			// for (int i = 0; i < params.length; i++)
			// {
			// CallParam cp = new CallParam();
			// cp.setParamName(params[i]);
			// CallResult callResult = MacroHelper.GetValue(cp.getParamName(), webContext, globalHelperEx, strCurPersonId, baseDataEntity);
			// if (callResult.getRetCode() == Errors.OK)
			// {
			// Object objValue = callResult.getUserObject();
			// if (objValue == null || StringHelper.Compare(objValue.toString(), cp.getParamName(), true) != 0)
			// {
			// cp.setValue(objValue);
			// }
			// }
			// list.add(cp);
			// }
			// }

		}
		sqlGroup.append(" FROM (%1$s) m1 ", strSQL);

		if (groupFields.size() == 0) {
			throw new Exception(StringHelper.format("没有指定任何分组属性"));
		}

		bFirst = true;
		// 执行分组
		for (String strFieldCode : groupFields) {
			if (bFirst) {
				sqlGroup.append(" GROUP BY ");
				bFirst = false;
			} else {
				sqlGroup.append(" , ");
			}
			sqlGroup.append(strFieldCode);
		}

		String strGroupSql = sqlGroup.toString();
		if (recalcItems.size() > 0) {
			sqlGroup.reset();
			sqlGroup.append("SELECT m3.*");
			for (IDEDataSetGroupParam iDEDataSetGroupParam : recalcItems) {
				nAliasIndex++;

				String strFormular = iDEDataSetGroupParam.getGroupCode();
				String[] fields = iDEDataSetGroupParam.getGroupFields();

				if (StringHelper.isNullOrEmpty(strFormular) && fields == null) {
					continue;
				}
				String strFieldCode = "";
				String strAlias = iDEDataSetGroupParam.getName();

				strFieldCode = strFormular;
				sqlGroup.append(",");

				// if (StringHelper.isNullOrEmpty(strAlias))
				// {
				// strAlias = StringHelper.format("A%1$s", nAliasIndex);
				// iDEDataSetGroupParam.setAlias(strAlias);
				// }

				sqlGroup.append("%1$s as %2$s", strFieldCode, strAlias);

				if (!StringHelper.isNullOrEmpty(iDEDataSetGroupParam.getSortDir())) {
					orderList.add(StringHelper.format("%1$s %2$s", strAlias, iDEDataSetGroupParam.getSortDir()));
					// orderMap.put(iDEDataSetGroupParam.getOrder(), StringHelper.format("%1$s %2$s", strAlias, iDEDataSetGroupParam.getSortDir()));
				}
			}

			sqlGroup.append(" FROM (%1$s) m3", strGroupSql);
			strGroupSql = sqlGroup.toString();
		}

		// if(!StringHelper.isNullOrEmpty(queryGroupModelConfig.getGroupCond()))
		// {
		// sqlGroup.reset();
		// sqlGroup.append("SELECT m4.*");
		// sqlGroup.append(" FROM (%1$s) m4 where %2$s",strGroupSql,queryGroupModelConfig.getGroupCond());
		// strGroupSql = sqlGroup.toString();
		// }

		if (orderList.size() > 0) {
			StringBuilderEx sqlGroupEx = new StringBuilderEx();
			sqlGroupEx.append("SELECT * FROM (%1$s) m2 ", strGroupSql);

			bFirst = true;
			for (String strOrderCode : orderList)
			// for (int nValue : orderMap.keySet())
			{
				if (bFirst) {
					sqlGroupEx.append(" ORDER BY ");
					bFirst = false;
				} else
					sqlGroupEx.append(" , ");

				sqlGroupEx.append(strOrderCode);
			}
			strGroupSql = sqlGroupEx.toString();
		}

		if (iDEDataSet.getGroupTopCount() <= 0) return strGroupSql;

		return this.getRealDBDialect().getTopRowSQL(strGroupSql, iDEDataSet.getGroupTopCount());
	}

	/**
	 * 获取属性统计空值时转换代码
	 * 
	 * @param defHelper
	 * @return
	 */
	protected String getDEFieldStatisticsNullConvertCode(IDEField defHelper) {
		// String strStaNullConv = defHelper.GetDTColumn().GetStatisticsNullConvert();
		// if (!StringHelper.IsNullOrEmpty(strStaNullConv))
		// {
		// return StringHelper.Format("(CASE WHEN %1$s IS NULL THEN %2$s ELSE %1$s END)", defHelper.GetDTColumn().GetFormalColumnName(), strStaNullConv);
		// }
		// else
		// return defHelper.getName();
		return defHelper.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.dao.IDAO#getDSLink()
	 */
	@Override
	public String getDSLink() {
		return strDSLink;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.dao.IDAO#setDSLink(java.lang.String)
	 */
	@Override
	public void setDSLink(String strDSLink) {
		this.strDSLink = strDSLink;
	}

	@Override
	public void postConstruct() throws Exception {

	}

	@Override
	public ISystemModel getSystemModel() {
		return this.getDEModel().getSystemModel();
	}

	/**
	 * 准备数据库连接
	 * @param connection
	 * @param objTag
	 * @throws Exception
	 */
	protected void onPrepareConnection(Connection connection,Object objTag)throws Exception{
		
	}
}
