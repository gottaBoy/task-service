/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.Session
 *  org.hibernate.SessionFactory
 *  org.hibernate.jdbc.Work
 */
package net.ibizsys.paas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.DEDataSetFetchContext;
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
import net.ibizsys.paas.dao.IDAO;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;

public abstract class DAOBase<ET extends IEntity>
implements IDAO<ET>,
IPostConstructable {
    private static final Log log = LogFactory.getLog(DAOBase.class);
    protected ISqlCommandModel getSqlCommandModel = null;
    protected ISqlCommandModel get2SqlCommandModel = null;
    protected ISqlCommandModel get3SqlCommandModel = null;
    protected ISqlCommandModel get4SqlCommandModel = null;
    protected ISqlCommandModel getTempSqlCommandModel = null;
    protected ISqlCommandModel checkKeySqlCommandModel = null;
    protected ISqlCommandModel checkKeyTempSqlCommandModel = null;
    protected ISqlCommandModel getSqlCommandModel2 = null;
    protected ISqlCommandModel get2SqlCommandModel2 = null;
    protected ISqlCommandModel get3SqlCommandModel2 = null;
    protected ISqlCommandModel get4SqlCommandModel2 = null;
    protected ISqlCommandModel getTempSqlCommandModel2 = null;
    protected ISqlCommandModel checkKeySqlCommandModel2 = null;
    protected ISqlCommandModel checkKeyTempSqlCommandModel2 = null;
    protected ISqlCommandModel removeSqlCommandModel = null;
    protected ISqlCommandModel removeTempSqlCommandModel = null;
    private String strDSLink = null;
    private SessionFactory sessionFactory = null;
    private IDBDialect iDBDialect = null;

    protected String getDAOId() {
        return null;
    }

    protected IDAO getInheritDEDAO() {
        return null;
    }

    @Override
    public IWebContext getWebContext() {
        return WebContext.getCurrent();
    }

    public DBCallResult executeDEDBProc(IDEDBCallContext iDEDBCallContext, String strDEProcName, ET entity) throws Exception {
        Session session = this.getCurrentSession();
        log.debug((Object)StringHelper.format("\u6267\u884c\u8fc7\u7a0b %1$s", strDEProcName));
        final DBCallResult dbCallResult = new DBCallResult();
        final IDEDBProcModel iDEDBProcModel = (IDEDBProcModel)this.getDEModel().getDEAction(strDEProcName);
        final SqlParamList sqlParamList = new SqlParamList();
        this.fillDBProcSqlParams(iDEDBProcModel, entity, sqlParamList);
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                DBCallResult dbCallResult2 = null;
                try {
                    DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                    dbCallResult2 = DAOBase.this.getRealDBDialect().callProc(connection, iDEDBProcModel.getDBProcName(), sqlParamList, iDEDBProcModel.getTimeOut());
                    if (dbCallResult2.getRetCode() != 0) {
                        throw new Exception(dbCallResult2.getErrorInfo());
                    }
                    dbCallResult.from(dbCallResult2);
                }
                catch (Exception e) {
                    if (dbCallResult2.getDataSet() != null) {
                        dbCallResult2.getDataSet().close();
                    }
                    throw new SQLException(e.getMessage(), e);
                }
            }
        });
        return dbCallResult;
    }

    protected void fillDBProcSqlParams(IDEDBProcModel iDEDBProcModel, ET entity, SqlParamList sqlParamList) throws Exception {
        iDEDBProcModel.fillSqlParams(this.getDBType(), (IEntity)entity, this.getWebContext(), sqlParamList);
    }

    @Override
    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext, String strDEDataSetName, boolean bTempMode) throws Exception {
        DBFetchResult dbFetchResult;
        IDEDataSetModel iDEDataSetModel;
        DEDataSetFetchContext.setCurrent(iDEDataSetFetchContext);
        ArrayList<IDEDataSetCond> userConditions = iDEDataSetFetchContext.getConditionList();
        IDEDataSet iDEDataSet = this.getDEModel().getDEDataSet(strDEDataSetName);
        if (iDEDataSet instanceof IDEDataSetModel && (iDEDataSetModel = (IDEDataSetModel)iDEDataSet).isCustomDS()) {
            return iDEDataSetModel.fetchDEDataSet(iDEDataSetFetchContext);
        }
        Session session = this.getCurrentSession();
        StringBuilderEx script = new StringBuilderEx();
        StringBuilderEx declareScript = new StringBuilderEx();
        SqlParamList list = new SqlParamList();
        Iterator<IDEDataSetQuery> deDataSetQueries = iDEDataSet.getDEDataSetQueries();
        IDEDataQueryCode pagingDEDataQueryCode = null;
        while (deDataSetQueries.hasNext()) {
            IDEDataSetQuery iDEDataSetQuery = deDataSetQueries.next();
            IDEDataQueryCode iDEDataQueryCode = this.getDEModel().getDEDataQuery(iDEDataSetQuery.getDEDataQueryId()).getDEDataQueryCode(this.getRealDBDialect().getDBType());
            if (pagingDEDataQueryCode == null) {
                pagingDEDataQueryCode = iDEDataQueryCode;
            }
            if (StringHelper.isNullOrEmpty(iDEDataQueryCode.getDeclareCode())) continue;
            declareScript.append(iDEDataQueryCode.getDeclareCode());
            declareScript.append("\n");
            iDEDataQueryCode.fillDeclareParams(iDEDataSetFetchContext.getWebContext(), null, list);
        }
        iDEDataSetFetchContext.fillDeclareParams(list);
        boolean bFirst = true;
        deDataSetQueries = iDEDataSet.getDEDataSetQueries();
        while (deDataSetQueries.hasNext()) {
            IDEDataSetQuery iDEDataSetQuery = deDataSetQueries.next();
            IDEDataQueryCode iDEDataQueryCode = this.getDEModel().getDEDataQuery(iDEDataSetQuery.getDEDataQueryId()).getDEDataQueryCode(this.getRealDBDialect().getDBType());
            iDEDataQueryCode.fillQueryParams(iDEDataSetFetchContext.getWebContext(), null, list);
            if (bFirst) {
                bFirst = false;
            } else {
                script.append(" UNION \n");
            }
            if (bTempMode) {
                script.append(iDEDataQueryCode.getQueryCodeTemp(iDEDataSetFetchContext, this.getRealDBDialect(), list));
            } else {
                script.append(iDEDataQueryCode.getQueryCode(iDEDataSetFetchContext, this.getRealDBDialect(), list));
            }
            if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getJoinScript())) {
                script.append(iDEDataQueryCode.getExtJoinSQL(iDEDataSetFetchContext, iDEDataSetFetchContext.getJoinScript(), this.getRealDBDialect(), list));
            }
            boolean bOutputWhere = false;
            boolean bCondFirst = true;
            Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
            while (deDataQueryCodeConds.hasNext()) {
                IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
                String strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataQueryCodeCond, this.getRealDBDialect(), list);
                if (StringHelper.isNullOrEmpty(strCondition)) continue;
                if (!bOutputWhere) {
                    script.append(" WHERE ");
                    bOutputWhere = true;
                }
                if (bCondFirst) {
                    bCondFirst = false;
                } else {
                    script.append(" AND ");
                }
                script.append("(%1$s)", strCondition);
            }
            if (userConditions.size() == 0) continue;
            if (!bOutputWhere) {
                script.append(" WHERE ");
                bOutputWhere = true;
            }
            for (IDEDataSetCond iDEDataSetCond : userConditions) {
                String strCondition;
                if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEDataQueryName()) && StringHelper.compare(iDEDataQueryCode.getName(), iDEDataSetCond.getDEDataQueryName(), false) != 0 || StringHelper.isNullOrEmpty(strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataSetCond, this.getRealDBDialect(), list))) continue;
                if (bCondFirst) {
                    bCondFirst = false;
                } else {
                    script.append(" AND ");
                }
                script.append("(%1$s)", strCondition);
            }
        }
        if (iDEDataSet.isEnableGroup()) {
            String strGroupSQL = String.valueOf(declareScript.toString()) + iDEDataSetFetchContext.getDeclareScript() + this.getGroupSQL(script.toString(), iDEDataSet);
            DBFetchResult dbFetchResult2 = this.fetchDataSet(session, null, strGroupSQL, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), list);
            if (dbFetchResult2.isOk() && dbFetchResult2.getDataSet() != null && iDEDataSetFetchContext.isCacheDataSet()) {
                dbFetchResult2.getDataSet().cacheDataRow();
            }
            return dbFetchResult2;
        }
        String strCountSQL = "";
        if (iDEDataSetFetchContext.isFetchTotalRow()) {
            strCountSQL = String.valueOf(declareScript.toString()) + iDEDataSetFetchContext.getDeclareScript() + this.getRealDBDialect().getCountSQL(script.toString());
        }
        String strPagingSQL = "";
        if (iDEDataSetFetchContext.isFetchData()) {
            String strSort = iDEDataSetFetchContext.getSort();
            String strSortDir = iDEDataSetFetchContext.getSortDir();
            String strSort2 = iDEDataSetFetchContext.getSort2();
            String strSort2Dir = iDEDataSetFetchContext.getSort2Dir();
            if (StringHelper.isNullOrEmpty(strSort) && StringHelper.isNullOrEmpty(strSort2)) {
                strSort = iDEDataSet.getMajorSortField();
                strSortDir = iDEDataSet.getMajorSortDir();
                strSort2 = iDEDataSet.getMinorSortField();
                strSort2Dir = iDEDataSet.getMinorSortDir();
            }
            if (StringHelper.isNullOrEmpty(strSort)) {
                strSortDir = null;
            }
            if (StringHelper.isNullOrEmpty(strSort2)) {
                strSort2Dir = null;
            }
            strPagingSQL = StringHelper.isNullOrEmpty(strSort) && StringHelper.isNullOrEmpty(strSort2) && !iDEDataSetFetchContext.isPaging() ? script.toString() : this.getRealDBDialect().getPagingSQL(script.toString(), iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), strSort, strSortDir, strSort2, strSort2Dir, pagingDEDataQueryCode);
        }
        if ((dbFetchResult = this.fetchDataSet(session, strCountSQL, strPagingSQL, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), list)).isOk() && dbFetchResult.getDataSet() != null && iDEDataSetFetchContext.isCacheDataSet()) {
            dbFetchResult.getDataSet().cacheDataRow();
        }
        return dbFetchResult;
    }

    @Override
    public DBCallResult fetchDEDataQuery(ISelectContext iSelectContext, boolean bTempMode) throws Exception {
        IDEDataQueryCodeCond iDEDataQueryCodeCond;
        String strCondition;
        DEDataSetFetchContext iDEDataSetFetchContext = new DEDataSetFetchContext();
        iDEDataSetFetchContext.setWebContext(iSelectContext.getWebContext());
        iDEDataSetFetchContext.setFetchTotalRow(false);
        iDEDataSetFetchContext.setPaging(false);
        iDEDataSetFetchContext.setActiveDataObject(iSelectContext);
        iDEDataSetFetchContext.setSort(iSelectContext.getSort());
        iDEDataSetFetchContext.setSortDir(iSelectContext.getSortDir());
        DEDataSetFetchContext.setCurrent(iDEDataSetFetchContext);
        IDEDataQuery iDEDataQuery = this.getDEModel().getDEDataQuery(iSelectContext.getDEDataQueryName());
        Session session = this.getCurrentSession();
        StringBuilderEx script = new StringBuilderEx();
        StringBuilderEx declareScript = new StringBuilderEx();
        SqlParamList list = new SqlParamList();
        IDEDataQueryCode iDEDataQueryCode = this.getDEModel().getDEDataQuery(iDEDataQuery.getId()).getDEDataQueryCode(this.getRealDBDialect().getDBType());
        if (!StringHelper.isNullOrEmpty(iDEDataQueryCode.getDeclareCode())) {
            declareScript.append(iDEDataQueryCode.getDeclareCode());
            declareScript.append("\n");
            iDEDataQueryCode.fillDeclareParams(iDEDataSetFetchContext.getWebContext(), null, list);
        }
        iDEDataSetFetchContext.fillDeclareParams(list);
        iDEDataQueryCode.fillQueryParams(iDEDataSetFetchContext.getWebContext(), null, list);
        if (bTempMode) {
            script.append(iDEDataQueryCode.getQueryCodeTemp());
        } else {
            script.append(iDEDataQueryCode.getQueryCode());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getJoinScript())) {
            script.append(iDEDataQueryCode.getExtJoinSQL(iDEDataSetFetchContext, iDEDataSetFetchContext.getJoinScript(), this.getRealDBDialect(), list));
        }
        boolean bOutputWhere = false;
        boolean bCondFirst = true;
        Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
        while (deDataQueryCodeConds.hasNext()) {
            IDEDataQueryCodeCond iDEDataQueryCodeCond2 = deDataQueryCodeConds.next();
            String strCondition2 = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataQueryCodeCond2, this.getRealDBDialect(), list);
            if (StringHelper.isNullOrEmpty(strCondition2)) continue;
            if (!bOutputWhere) {
                script.append(" WHERE ");
                bOutputWhere = true;
            }
            if (bCondFirst) {
                bCondFirst = false;
            } else {
                script.append(" AND ");
            }
            script.append("(%1$s)", strCondition2);
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
            if (bCondFirst) {
                bCondFirst = false;
            } else {
                script.append(" AND ");
            }
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
        if (iSelectContext.getSelectFilter() != null && iSelectContext.getSelectFilter() instanceof IDEDataQueryCodeCond && !StringHelper.isNullOrEmpty(strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataQueryCodeCond = (IDEDataQueryCodeCond)iSelectContext.getSelectFilter(), this.getRealDBDialect(), list))) {
            if (!bOutputWhere) {
                script.append(" WHERE ");
                bOutputWhere = true;
            }
            if (bCondFirst) {
                bCondFirst = false;
            } else {
                script.append(" AND ");
            }
            script.append("(%1$s)", strCondition);
        }
        String strCountSQL = "";
        String strPagingSQL = "";
        strPagingSQL = script.toString();
        Iterator<ISelectField> selectFields = iSelectContext.getSelectFields();
        if (selectFields != null) {
            StringBuilderEx script2 = new StringBuilderEx();
            script2.append("SELECT ");
            int nIndex = 0;
            while (selectFields.hasNext()) {
                if (nIndex != 0) {
                    script2.append(",");
                }
                ++nIndex;
                ISelectField iSelectField = selectFields.next();
                String strAlias = iSelectField.getAlias();
                if (StringHelper.isNullOrEmpty(iSelectField.getFunc())) {
                    if (StringHelper.isNullOrEmpty(iSelectField.getName())) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b57\u6bb5\u540d\u79f0");
                    }
                    if (StringHelper.isNullOrEmpty(strAlias)) {
                        script2.append("%1$s", this.getRealDBDialect().getDBObjStandardName(iSelectField.getName()));
                        continue;
                    }
                    script2.append("%1$s AS %2$s", this.getRealDBDialect().getDBObjStandardName(iSelectField.getName()), this.getRealDBDialect().getDBObjStandardName(strAlias));
                    continue;
                }
                String[] fields = null;
                if (!StringHelper.isNullOrEmpty(iSelectField.getName())) {
                    fields = iSelectField.getName().split("[,]");
                }
                if (StringHelper.isNullOrEmpty(strAlias)) {
                    strAlias = fields != null && fields.length > 0 ? fields[0] : StringHelper.format("A%1$s", strAlias);
                }
                script2.append("%1$s AS %2$s", this.getRealDBDialect().getFuncSQL(iSelectField.getFunc(), fields), this.getRealDBDialect().getDBObjStandardName(strAlias));
            }
            script2.append(" FROM (%1$s) m1  ", strPagingSQL);
            strPagingSQL = script2.toString();
        }
        DBFetchResult dbFetchResult = this.fetchDataSet(session, strCountSQL, strPagingSQL, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), list);
        return dbFetchResult;
    }

    @Override
    public DBFetchResult fetchDEDataQuery(IDEDataSetFetchContext iDEDataSetFetchContext, String strDEDataQueryName, boolean bTempMode) throws Exception {
        DBFetchResult dbFetchResult;
        DEDataSetFetchContext.setCurrent(iDEDataSetFetchContext);
        ArrayList<IDEDataSetCond> userConditions = iDEDataSetFetchContext.getConditionList();
        IDEDataQuery iDEDataQuery = this.getDEModel().getDEDataQuery(strDEDataQueryName);
        Session session = this.getCurrentSession();
        StringBuilderEx script = new StringBuilderEx();
        StringBuilderEx declareScript = new StringBuilderEx();
        SqlParamList list = new SqlParamList();
        IDEDataQueryCode iDEDataQueryCode = this.getDEModel().getDEDataQuery(iDEDataQuery.getId()).getDEDataQueryCode(this.getRealDBDialect().getDBType());
        if (!StringHelper.isNullOrEmpty(iDEDataQueryCode.getDeclareCode())) {
            declareScript.append(iDEDataQueryCode.getDeclareCode());
            declareScript.append("\n");
            iDEDataQueryCode.fillDeclareParams(iDEDataSetFetchContext.getWebContext(), null, list);
        }
        iDEDataSetFetchContext.fillDeclareParams(list);
        iDEDataQueryCode.fillQueryParams(iDEDataSetFetchContext.getWebContext(), null, list);
        if (bTempMode) {
            script.append(iDEDataQueryCode.getQueryCodeTemp());
        } else {
            script.append(iDEDataQueryCode.getQueryCode());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getJoinScript())) {
            script.append(iDEDataQueryCode.getExtJoinSQL(iDEDataSetFetchContext, iDEDataSetFetchContext.getJoinScript(), this.getRealDBDialect(), list));
        }
        boolean bOutputWhere = false;
        boolean bCondFirst = true;
        Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
        while (deDataQueryCodeConds.hasNext()) {
            IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
            String strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataQueryCodeCond, this.getRealDBDialect(), list);
            if (StringHelper.isNullOrEmpty(strCondition)) continue;
            if (!bOutputWhere) {
                script.append(" WHERE ");
                bOutputWhere = true;
            }
            if (bCondFirst) {
                bCondFirst = false;
            } else {
                script.append(" AND ");
            }
            script.append("(%1$s)", strCondition);
        }
        if (userConditions.size() != 0) {
            if (!bOutputWhere) {
                script.append(" WHERE ");
                bOutputWhere = true;
            }
            for (IDEDataSetCond iDEDataSetCond : userConditions) {
                String strCondition;
                if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEDataQueryName()) && StringHelper.compare(iDEDataQueryCode.getName(), iDEDataSetCond.getDEDataQueryName(), false) != 0 || StringHelper.isNullOrEmpty(strCondition = iDEDataQueryCode.getConditionSQL(iDEDataSetFetchContext, iDEDataSetCond, this.getRealDBDialect(), list))) continue;
                if (bCondFirst) {
                    bCondFirst = false;
                } else {
                    script.append(" AND ");
                }
                script.append("(%1$s)", strCondition);
            }
        }
        String strCountSQL = "";
        if (iDEDataSetFetchContext.isFetchTotalRow()) {
            strCountSQL = String.valueOf(declareScript.toString()) + iDEDataSetFetchContext.getDeclareScript() + this.getRealDBDialect().getCountSQL(script.toString());
        }
        String strPagingSQL = "";
        if (iDEDataSetFetchContext.isFetchData()) {
            strPagingSQL = StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort()) && StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort2()) && !iDEDataSetFetchContext.isPaging() ? script.toString() : this.getRealDBDialect().getPagingSQL(script.toString(), iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), iDEDataSetFetchContext.getSort(), iDEDataSetFetchContext.getSortDir(), iDEDataSetFetchContext.getSort2(), iDEDataSetFetchContext.getSort2Dir(), iDEDataQueryCode);
        }
        if ((dbFetchResult = this.fetchDataSet(session, strCountSQL, strPagingSQL, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), list)).isOk() && dbFetchResult.getDataSet() != null && iDEDataSetFetchContext.isCacheDataSet()) {
            dbFetchResult.getDataSet().cacheDataRow();
        }
        return dbFetchResult;
    }

    protected DBFetchResult fetchDataSet(Session session, String strCountSQL, String strPagingSQL, int nStartPos, int nPageSize, SqlParamList list) throws Exception {
        final DBFetchResult dbFetchResult = new DBFetchResult();
        final String strCountSQL2 = strCountSQL;
        final String strPagingSQL2 = strPagingSQL;
        int nStartPos2 = nStartPos;
        int nPageSize2 = nPageSize;
        final SqlParamList list2 = list;
        if (log.isDebugEnabled()) {
            int nIndex;
            StringBuilderEx sb = new StringBuilderEx();
            if (!StringHelper.isNullOrEmpty(strPagingSQL)) {
                sb.append("\u67e5\u8be2SQL\r\n%1$s", strPagingSQL);
                nIndex = 0;
                for (SqlParam sqlParam : list) {
                    sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
                    ++nIndex;
                }
                sb.append("\r\n");
            }
            if (!StringHelper.isNullOrEmpty(strCountSQL)) {
                sb.append("\u5206\u9875SQL\r\n%1$s", strCountSQL);
                nIndex = 0;
                for (SqlParam sqlParam : list) {
                    sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
                    ++nIndex;
                }
            }
            log.debug((Object)sb.toString());
        }
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                block8: {
                    try {
                        IDataSet iDataSet;
                        DBCallResult dbCallResult;
                        DAOBase.this.onPrepareConnection(connection, null);
                        if (!StringHelper.isNullOrEmpty(strPagingSQL2)) {
                            dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, strPagingSQL2, list2, -1);
                            if (dbCallResult.isOk()) {
                                iDataSet = dbCallResult.getDataSet();
                                dbFetchResult.setDataSet(iDataSet);
                            } else {
                                throw new Exception(dbCallResult.getErrorInfo());
                            }
                        }
                        if (StringHelper.isNullOrEmpty(strCountSQL2)) break block8;
                        dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, strCountSQL2, list2, -1);
                        if (dbCallResult.isOk()) {
                            iDataSet = dbCallResult.getDataSet();
                            if (iDataSet != null) {
                                IDataRow iDataRow = iDataSet.getDataTable(0).next();
                                dbFetchResult.setTotalRow(Integer.parseInt(iDataRow.get("TOTALROW").toString()));
                                iDataSet.close();
                            }
                            break block8;
                        }
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    catch (Exception e) {
                        if (dbFetchResult.getDataSet() != null) {
                            dbFetchResult.getDataSet().close();
                        }
                        throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                    }
                }
            }
        });
        return dbFetchResult;
    }

    @Override
    public abstract IDataEntityModel getDEModel();

    protected String getDBType() {
        return this.getRealDBDialect().getDBType();
    }

    @Override
    public DBCallResult executeGetSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
        return this.executeGetSql(iDEDBCallContext, et, 0, bTempMode);
    }

    @Override
    public DBCallResult executeGetSql(IDEDBCallContext iDEDBCallContext, ET et, int nViewLevel, boolean bTempMode) throws Exception {
        Session session = this.getCurrentSession();
        ISqlCommandModel curSqlCommandModel = null;
        if (et.get(this.getDEModel().getKeyDEField().getName()) != null || this.getDEModel().getUniTagDEField() == null || et.get(this.getDEModel().getUniTagDEField().getName()) == null) {
            if (bTempMode) {
                if (this.getTempSqlCommandModel == null) {
                    this.getTempSqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(), bTempMode);
                }
                curSqlCommandModel = this.getTempSqlCommandModel;
            } else {
                switch (nViewLevel) {
                    case 1: {
                        if (this.get2SqlCommandModel == null) {
                            this.get2SqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(), nViewLevel, bTempMode);
                        }
                        curSqlCommandModel = this.get2SqlCommandModel;
                        break;
                    }
                    case 2: {
                        if (this.get3SqlCommandModel == null) {
                            this.get3SqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(), nViewLevel, bTempMode);
                        }
                        curSqlCommandModel = this.get3SqlCommandModel;
                        break;
                    }
                    case 3: {
                        if (this.get4SqlCommandModel == null) {
                            this.get4SqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(), nViewLevel, bTempMode);
                        }
                        curSqlCommandModel = this.get4SqlCommandModel;
                        break;
                    }
                    default: {
                        if (this.getSqlCommandModel == null) {
                            this.getSqlCommandModel = this.getDEModel().getGetSqlCommandModel(this.getRealDBDialect(), bTempMode);
                        }
                        curSqlCommandModel = this.getSqlCommandModel;
                        break;
                    }
                }
            }
        } else if (bTempMode) {
            if (this.getTempSqlCommandModel2 == null) {
                this.getTempSqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(), 0, bTempMode);
            }
            curSqlCommandModel = this.getTempSqlCommandModel2;
        } else {
            switch (nViewLevel) {
                case 1: {
                    if (this.get2SqlCommandModel2 == null) {
                        this.get2SqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(), nViewLevel, bTempMode);
                    }
                    curSqlCommandModel = this.get2SqlCommandModel2;
                    break;
                }
                case 2: {
                    if (this.get3SqlCommandModel2 == null) {
                        this.get3SqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(), nViewLevel, bTempMode);
                    }
                    curSqlCommandModel = this.get3SqlCommandModel2;
                    break;
                }
                case 3: {
                    if (this.get4SqlCommandModel2 == null) {
                        this.get4SqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(), nViewLevel, bTempMode);
                    }
                    curSqlCommandModel = this.get4SqlCommandModel2;
                    break;
                }
                default: {
                    if (this.getSqlCommandModel2 == null) {
                        this.getSqlCommandModel2 = this.getDEModel().getGetSqlCommandModel2(this.getRealDBDialect(), 0, bTempMode);
                    }
                    curSqlCommandModel = this.getSqlCommandModel2;
                }
            }
        }
        final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        final ISqlCommandModel iSqlCommandModel = curSqlCommandModel;
        SqlParamList sqlParamList = new SqlParamList();
        iSqlCommandModel.fillSqlParams((IEntity)et, this.getWebContext(), sqlParamList);
        if (log.isDebugEnabled()) {
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            sBuilderEx.append("\u67e5\u8be2SQL\r\n%1$s", iSqlCommandModel.getSql());
            int nIndex = 0;
            for (SqlParam sqlParam : sqlParamList) {
                sBuilderEx.append(StringHelper.format("\r\n[%1$s]%2$s==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue()));
                ++nIndex;
            }
            log.debug((Object)sBuilderEx.toString());
        }
        final SqlParamList sqlParamList2 = sqlParamList;
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                DBCallResult dbCallResult = null;
                try {
                    DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                    dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
                    if (!dbCallResult.isOk()) {
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    dbCallResultProxy.setDBCallResult(dbCallResult);
                }
                catch (Exception e) {
                    if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                        dbCallResult.getDataSet().close();
                    }
                    throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult executeCheckKeySql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
        Session session = this.getCurrentSession();
        ISqlCommandModel curSqlCommandModel = null;
        if (et.get(this.getDEModel().getKeyDEField().getName()) != null || this.getDEModel().getUniTagDEField() == null || et.get(this.getDEModel().getUniTagDEField().getName()) == null) {
            if (bTempMode) {
                if (this.checkKeyTempSqlCommandModel == null) {
                    this.checkKeyTempSqlCommandModel = this.getDEModel().getCheckKeySqlCommandModel(this.getRealDBDialect(), bTempMode);
                }
            } else if (this.checkKeySqlCommandModel == null) {
                this.checkKeySqlCommandModel = this.getDEModel().getCheckKeySqlCommandModel(this.getRealDBDialect(), bTempMode);
            }
            curSqlCommandModel = bTempMode ? this.checkKeyTempSqlCommandModel : this.checkKeySqlCommandModel;
        } else {
            if (bTempMode) {
                if (this.checkKeyTempSqlCommandModel2 == null) {
                    this.checkKeyTempSqlCommandModel2 = this.getDEModel().getCheckKeySqlCommandModel2(this.getRealDBDialect(), bTempMode);
                }
            } else if (this.checkKeySqlCommandModel2 == null) {
                this.checkKeySqlCommandModel2 = this.getDEModel().getCheckKeySqlCommandModel2(this.getRealDBDialect(), bTempMode);
            }
            curSqlCommandModel = bTempMode ? this.checkKeyTempSqlCommandModel2 : this.checkKeySqlCommandModel2;
        }
        final ISqlCommandModel iSqlCommandModel = curSqlCommandModel;
        SqlParamList sqlParamList = new SqlParamList();
        iSqlCommandModel.fillSqlParams((IEntity)et, this.getWebContext(), sqlParamList);
        if (log.isDebugEnabled()) {
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            sBuilderEx.append("\u67e5\u8be2SQL\r\n%1$s", iSqlCommandModel.getSql());
            int nIndex = 0;
            for (SqlParam sqlParam : sqlParamList) {
                sBuilderEx.append(StringHelper.format("\r\n[%1$s]%2$s==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue()));
                ++nIndex;
            }
            log.debug((Object)sBuilderEx.toString());
        }
        final SqlParamList sqlParamList2 = sqlParamList;
        final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                DBCallResult dbCallResult = null;
                try {
                    DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                    dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
                    if (!dbCallResult.isOk()) {
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    dbCallResultProxy.setDBCallResult(dbCallResult);
                }
                catch (Exception e) {
                    if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                        dbCallResult.getDataSet().close();
                    }
                    throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult executeCreateSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
        Session session = this.getCurrentSession();
        DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        ET et2 = et;
        boolean bTempMode2 = bTempMode;
        session.doWork(new Work((IEntity)et2, bTempMode2, dbCallResultProxy){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ boolean val$bTempMode2;
            private final /* synthetic */ DBCallResultProxy val$dbCallResultProxy;
            {
                this.val$et2 = iEntity;
                this.val$bTempMode2 = bl;
                this.val$dbCallResultProxy = dBCallResultProxy;
            }

            public void execute(Connection connection) throws SQLException {
                block16: {
                    DBCallResult dbCallResult = null;
                    try {
                        DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                        if (DAOBase.this.getInheritDEDAO() != null) {
                            DAOBase.this.fillInheritEntity(this.val$et2);
                            DBCallResult dbCallResult2 = DAOBase.this.getInheritDEDAO().executeCreateSql(iDEDBCallContext2, this.val$et2, this.val$bTempMode2);
                            if (!dbCallResult2.isOk()) {
                                throw new Exception(dbCallResult2.getErrorInfo());
                            }
                            if (dbCallResult2.getDataSet() != null) {
                                dbCallResult2.getDataSet().cacheDataRow();
                            }
                            if (this.val$et2.get(DAOBase.this.getDEModel().getKeyDEField().getName()) == null) {
                                if (this.val$et2.get(DAOBase.this.getInheritDEDAO().getDEModel().getKeyDEField().getName()) == null) {
                                    DAOBase.this.getInheritDEDAO().getDEModel().getService(DAOBase.this.getSessionFactory()).get(this.val$et2);
                                }
                                this.val$et2.set(DAOBase.this.getDEModel().getKeyDEField().getName(), this.val$et2.get(DAOBase.this.getInheritDEDAO().getDEModel().getKeyDEField().getName()));
                            }
                        }
                        ISqlCommandModel createSqlCommandModel = DAOBase.this.getDEModel().getCreateSqlCommandModel(DAOBase.this.getRealDBDialect(), this.val$et2, this.val$bTempMode2);
                        SqlParamList sqlParamList = new SqlParamList();
                        createSqlCommandModel.fillSqlParams(this.val$et2, DAOBase.this.getWebContext(), sqlParamList);
                        if (log.isDebugEnabled()) {
                            StringBuilderEx sb = new StringBuilderEx();
                            sb.append("\u63d2\u5165SQL\r\n%1$s", createSqlCommandModel.getSql());
                            int nIndex = 0;
                            for (SqlParam sqlParam : sqlParamList) {
                                sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
                                ++nIndex;
                            }
                            log.debug((Object)sb.toString());
                        }
                        if ((dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, createSqlCommandModel.getSql(), sqlParamList, -1)).isOk()) {
                            this.val$dbCallResultProxy.setDBCallResult(dbCallResult);
                            if (dbCallResult.getDataSet() != null) {
                                dbCallResult.getDataSet().cacheDataRow();
                            }
                            if (!DAOBase.this.getDEModel().getKeyDEField().isPhisicalDEField() || this.val$et2.get(DAOBase.this.getDEModel().getKeyDEField().getName()) != null || DAOBase.this.getDEModel().getKeyDEField().isEnableDBValueInsertUpdateMode() && !StringHelper.isNullOrEmpty(DAOBase.this.getDEModel().getKeyDEField().getDBValueInsertMode())) break block16;
                            DBCallResult dbCallResult2 = DAOBase.this.getRealDBDialect().getLastInsertId(connection);
                            if (dbCallResult2.isOk()) {
                                Object objKeyValue = null;
                                if (dbCallResult2.getDataSet() != null) {
                                    IDataTable iDataTable;
                                    dbCallResult2.getDataSet().cacheDataRow();
                                    if (dbCallResult2.getDataSet().getDataTableCount() > 0 && (iDataTable = dbCallResult2.getDataSet().getDataTable(0)).getCachedRowCount() > 0) {
                                        objKeyValue = iDataTable.getCachedRow(0).get(0);
                                    }
                                }
                                if (objKeyValue == null) {
                                    throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6700\u540e\u63d2\u5165\u7684\u6570\u636e\u6807\u8bc6");
                                }
                                this.val$et2.set(DAOBase.this.getDEModel().getKeyDEField().getName(), objKeyValue);
                                break block16;
                            }
                            throw new Exception(dbCallResult2.getErrorInfo());
                        }
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    catch (Exception e) {
                        if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                            dbCallResult.getDataSet().close();
                        }
                        throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                    }
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult executeUpdateSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
        Session session = this.getCurrentSession();
        ISqlCommandModel updateSqlCommandModel = this.getDEModel().getUpdateSqlCommandModel(this.getRealDBDialect(), (IEntity)et, bTempMode);
        if (this.getInheritDEDAO() != null) {
            this.fillInheritEntity(et);
        }
        DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        ISqlCommandModel iSqlCommandModel = updateSqlCommandModel;
        SqlParamList sqlParamList = new SqlParamList();
        iSqlCommandModel.fillSqlParams((IEntity)et, this.getWebContext(), sqlParamList);
        if (log.isDebugEnabled()) {
            StringBuilderEx sb = new StringBuilderEx();
            sb.append("\u66f4\u65b0SQL\r\n%1$s", updateSqlCommandModel.getSql());
            int nIndex = 0;
            for (SqlParam sqlParam : sqlParamList) {
                sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
                ++nIndex;
            }
            log.debug((Object)sb.toString());
        }
        SqlParamList sqlParamList2 = sqlParamList;
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        ET et2 = et;
        boolean bTempMode2 = bTempMode;
        session.doWork(new Work((IEntity)et2, bTempMode2, iSqlCommandModel, sqlParamList2, dbCallResultProxy){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ boolean val$bTempMode2;
            private final /* synthetic */ ISqlCommandModel val$iSqlCommandModel;
            private final /* synthetic */ SqlParamList val$sqlParamList2;
            private final /* synthetic */ DBCallResultProxy val$dbCallResultProxy;
            {
                this.val$et2 = iEntity;
                this.val$bTempMode2 = bl;
                this.val$iSqlCommandModel = iSqlCommandModel;
                this.val$sqlParamList2 = sqlParamList;
                this.val$dbCallResultProxy = dBCallResultProxy;
            }

            public void execute(Connection connection) throws SQLException {
                block8: {
                    DBCallResult dbCallResult = null;
                    try {
                        DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                        if (DAOBase.this.getInheritDEDAO() != null) {
                            DBCallResult dbCallResult2 = DAOBase.this.getInheritDEDAO().executeUpdateSql(iDEDBCallContext2, this.val$et2, this.val$bTempMode2);
                            if (!dbCallResult2.isOk()) {
                                throw new Exception(dbCallResult2.getErrorInfo());
                            }
                            if (dbCallResult2.getDataSet() != null) {
                                dbCallResult2.getDataSet().cacheDataRow();
                            }
                        }
                        if ((dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, this.val$iSqlCommandModel.getSql(), this.val$sqlParamList2, -1)).isOk()) {
                            this.val$dbCallResultProxy.setDBCallResult(dbCallResult);
                            if (dbCallResult.getDataSet() != null) {
                                dbCallResult.getDataSet().cacheDataRow();
                            }
                            break block8;
                        }
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    catch (Exception e) {
                        if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                            dbCallResult.getDataSet().close();
                        }
                        throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                    }
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult executeSysUpdateSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
        Session session = this.getCurrentSession();
        ISqlCommandModel updateSqlCommandModel = this.getDEModel().getSysUpdateSqlCommandModel(this.getRealDBDialect(), (IEntity)et, bTempMode);
        if (this.getInheritDEDAO() != null) {
            this.fillInheritEntity(et);
        }
        DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        ISqlCommandModel iSqlCommandModel = updateSqlCommandModel;
        SqlParamList sqlParamList = new SqlParamList();
        iSqlCommandModel.fillSqlParams((IEntity)et, this.getWebContext(), sqlParamList);
        if (log.isDebugEnabled()) {
            StringBuilderEx sb = new StringBuilderEx();
            sb.append("\u66f4\u65b0SQL\r\n%1$s", updateSqlCommandModel.getSql());
            int nIndex = 0;
            for (SqlParam sqlParam : sqlParamList) {
                sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
                ++nIndex;
            }
            log.debug((Object)sb.toString());
        }
        SqlParamList sqlParamList2 = sqlParamList;
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        ET et2 = et;
        boolean bTempMode2 = bTempMode;
        session.doWork(new Work((IEntity)et2, bTempMode2, iSqlCommandModel, sqlParamList2, dbCallResultProxy){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ boolean val$bTempMode2;
            private final /* synthetic */ ISqlCommandModel val$iSqlCommandModel;
            private final /* synthetic */ SqlParamList val$sqlParamList2;
            private final /* synthetic */ DBCallResultProxy val$dbCallResultProxy;
            {
                this.val$et2 = iEntity;
                this.val$bTempMode2 = bl;
                this.val$iSqlCommandModel = iSqlCommandModel;
                this.val$sqlParamList2 = sqlParamList;
                this.val$dbCallResultProxy = dBCallResultProxy;
            }

            public void execute(Connection connection) throws SQLException {
                block8: {
                    DBCallResult dbCallResult = null;
                    try {
                        DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                        if (DAOBase.this.getInheritDEDAO() != null) {
                            DBCallResult dbCallResult2 = DAOBase.this.getInheritDEDAO().executeSysUpdateSql(iDEDBCallContext2, this.val$et2, this.val$bTempMode2);
                            if (!dbCallResult2.isOk()) {
                                throw new Exception(dbCallResult2.getErrorInfo());
                            }
                            if (dbCallResult2.getDataSet() != null) {
                                dbCallResult2.getDataSet().cacheDataRow();
                            }
                        }
                        if ((dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, this.val$iSqlCommandModel.getSql(), this.val$sqlParamList2, -1)).isOk()) {
                            this.val$dbCallResultProxy.setDBCallResult(dbCallResult);
                            if (dbCallResult.getDataSet() != null) {
                                dbCallResult.getDataSet().cacheDataRow();
                            }
                            break block8;
                        }
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    catch (Exception e) {
                        if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                            dbCallResult.getDataSet().close();
                        }
                        throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                    }
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

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
            sb.append("\u67e5\u8be2 SQL\r\n%1$s", selectSqlCommandModel.getSql());
            int nIndex = 0;
            for (SqlParam sqlParam : sqlParamList) {
                sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
                ++nIndex;
            }
            log.debug((Object)sb.toString());
        }
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                DBCallResult dbCallResult = null;
                try {
                    DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                    dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
                    if (!dbCallResult.isOk()) {
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    dbCallResultProxy.setDBCallResult(dbCallResult);
                }
                catch (Exception e) {
                    if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                        dbCallResult.getDataSet().close();
                    }
                    throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult executeRemoveSql(IDEDBCallContext iDEDBCallContext, ET et, boolean bTempMode) throws Exception {
        Session session = this.getCurrentSession();
        if (bTempMode) {
            if (this.removeTempSqlCommandModel == null) {
                this.removeTempSqlCommandModel = this.getDEModel().getRemoveSqlCommandModel(this.getRealDBDialect(), bTempMode);
            }
        } else if (this.removeSqlCommandModel == null) {
            this.removeSqlCommandModel = this.getDEModel().getRemoveSqlCommandModel(this.getRealDBDialect(), bTempMode);
        }
        if (this.getInheritDEDAO() != null) {
            this.fillInheritEntity(et);
        }
        final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        final ISqlCommandModel iSqlCommandModel = bTempMode ? this.removeTempSqlCommandModel : this.removeSqlCommandModel;
        SqlParamList sqlParamList = new SqlParamList();
        iSqlCommandModel.fillSqlParams((IEntity)et, this.getWebContext(), sqlParamList);
        if (log.isDebugEnabled()) {
            StringBuilderEx sb = new StringBuilderEx();
            sb.append("\u5220\u9664SQL\r\n%1$s", (bTempMode ? this.removeTempSqlCommandModel : this.removeSqlCommandModel).getSql());
            int nIndex = 0;
            for (SqlParam sqlParam : sqlParamList) {
                sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
                ++nIndex;
            }
            log.debug((Object)sb.toString());
        }
        final SqlParamList sqlParamList2 = sqlParamList;
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        ET et2 = et;
        boolean bTempMode2 = bTempMode;
        session.doWork(new Work((IEntity)et2, bTempMode2){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ boolean val$bTempMode2;
            {
                this.val$et2 = iEntity;
                this.val$bTempMode2 = bl;
            }

            public void execute(Connection connection) throws SQLException {
                DBCallResult dbCallResult = null;
                try {
                    DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                    dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, iSqlCommandModel.getSql(), sqlParamList2, -1);
                    if (!dbCallResult.isOk()) {
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    dbCallResultProxy.setDBCallResult(dbCallResult);
                    if (DAOBase.this.getInheritDEDAO() != null && !(dbCallResult = DAOBase.this.getInheritDEDAO().executeRemoveSql(iDEDBCallContext2, this.val$et2, this.val$bTempMode2)).isOk()) {
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                }
                catch (Exception e) {
                    if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                        dbCallResult.getDataSet().close();
                    }
                    throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult executeRemoveSql(IDEDBCallContext iDEDBCallContext, ISelectCond iSelectCond, boolean bTempMode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
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
                    ++nIndex;
                }
            }
            log.debug((Object)sb.toString());
        }
        final String strSql2 = strSql;
        final DBFetchResult dbFetchResult = new DBFetchResult();
        final SqlParamList sqlParamList2 = sqlParamList;
        final ArrayList<IEntity> entityList = new ArrayList<IEntity>();
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                block6: {
                    try {
                        DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                        DBCallResult dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, strSql2, sqlParamList2, -1);
                        if (dbCallResult.isOk()) {
                            IDataSet iDataSet = dbCallResult.getDataSet();
                            if (iDataSet == null || iDataSet.getDataTableCount() == 0) {
                                throw new ErrorException(3);
                            }
                            IDataTable iDataTable = iDataSet.getDataTable(0);
                            iDataTable.cacheRows(-1);
                            int nCount = iDataTable.getCachedRowCount();
                            int i = 0;
                            while (i < nCount) {
                                IDataRow iDataRow = iDataTable.getCachedRow(i);
                                SimpleEntity simpleEntity = new SimpleEntity();
                                DataObject.fromDataRow(simpleEntity, iDataRow, false);
                                entityList.add(simpleEntity);
                                ++i;
                            }
                            iDataSet.close();
                            break block6;
                        }
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    catch (Exception e) {
                        if (dbFetchResult.getDataSet() != null) {
                            dbFetchResult.getDataSet().close();
                        }
                        throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                    }
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
                    ++nIndex;
                }
            }
            log.debug((Object)sb.toString());
        }
        final String strSql2 = strSql;
        final DBFetchResult dbFetchResult = new DBFetchResult();
        final SqlParamList sqlParamList2 = sqlParamList;
        final ArrayList entityList = new ArrayList();
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                block6: {
                    try {
                        DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                        DBCallResult dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, strSql2, sqlParamList2, -1);
                        if (dbCallResult.isOk()) {
                            IDataSet iDataSet = dbCallResult.getDataSet();
                            if (iDataSet == null || iDataSet.getDataTableCount() == 0) {
                                throw new ErrorException(3);
                            }
                            IDataTable iDataTable = iDataSet.getDataTable(0);
                            iDataTable.cacheRows(-1);
                            int nCount = iDataTable.getCachedRowCount();
                            int i = 0;
                            while (i < nCount) {
                                IDataRow iDataRow = iDataTable.getCachedRow(i);
                                Object simpleEntity = DAOBase.this.getDEModel().createEntity();
                                DataObject.fromDataRow(simpleEntity, iDataRow, false);
                                entityList.add(simpleEntity);
                                ++i;
                            }
                            iDataSet.close();
                            break block6;
                        }
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    catch (Exception e) {
                        if (dbFetchResult.getDataSet() != null) {
                            dbFetchResult.getDataSet().close();
                        }
                        throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                    }
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
                    ++nIndex;
                }
            }
            log.debug((Object)sb.toString());
        }
        final String strSql2 = strSql;
        final DBFetchResult dbFetchResult = new DBFetchResult();
        final SqlParamList sqlParamList2 = sqlParamList;
        final ArrayList entityList = new ArrayList();
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                block6: {
                    try {
                        DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                        DBCallResult dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, strSql2, sqlParamList2, -1);
                        if (dbCallResult.isOk()) {
                            IDataSet iDataSet = dbCallResult.getDataSet();
                            if (iDataSet == null || iDataSet.getDataTableCount() == 0) {
                                throw new ErrorException(3);
                            }
                            IDataTable iDataTable = iDataSet.getDataTable(0);
                            iDataTable.cacheRows(1);
                            int nCount = iDataTable.getCachedRowCount();
                            int i = 0;
                            while (i < nCount) {
                                IDataRow iDataRow = iDataTable.getCachedRow(i);
                                SimpleEntity simpleEntity = new SimpleEntity();
                                DataObject.fromDataRow(simpleEntity, iDataRow, false);
                                entityList.add(simpleEntity);
                                ++i;
                            }
                            iDataSet.close();
                            break block6;
                        }
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    catch (Exception e) {
                        if (dbFetchResult.getDataSet() != null) {
                            dbFetchResult.getDataSet().close();
                        }
                        throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                    }
                }
            }
        });
        if (entityList.size() == 0) {
            return null;
        }
        return (IEntity)entityList.get(0);
    }

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
                    ++nIndex;
                }
            }
            log.debug((Object)sb.toString());
        }
        final String strSql2 = strSql;
        final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        final SqlParamList sqlParamList2 = sqlParamList;
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                DBCallResult dbCallResult = null;
                try {
                    DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                    dbCallResult = DAOBase.this.getRealDBDialect().callSql(connection, strSql2, sqlParamList2, -1);
                    if (!dbCallResult.isOk()) {
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    dbCallResultProxy.setDBCallResult(dbCallResult);
                }
                catch (Exception e) {
                    if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                        dbCallResult.getDataSet().close();
                    }
                    throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult executeRawSqlBatch(IDEDBCallContext iDEDBCallContext, String[] sqls, SqlParamList[] sqlParamLists, int nBatchSize) throws Exception {
        Session session = this.getCurrentSession();
        final String[] sqls2 = sqls;
        final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        final SqlParamList[] sqlParamLists2 = sqlParamLists;
        final int nBatchSize2 = nBatchSize;
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                DBCallResult dbCallResult = null;
                try {
                    DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                    dbCallResult = DAOBase.this.getRealDBDialect().callSqlBatch(connection, sqls2, sqlParamLists2, nBatchSize2, -1);
                    if (!dbCallResult.isOk()) {
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    dbCallResultProxy.setDBCallResult(dbCallResult);
                }
                catch (Exception e) {
                    if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                        dbCallResult.getDataSet().close();
                    }
                    throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult callProc(IDEDBCallContext iDEDBCallContext, String strProcName, SqlParamList sqlParamList) throws Exception {
        Session session = this.getCurrentSession();
        if (log.isDebugEnabled()) {
            StringBuilderEx sb = new StringBuilderEx();
            sb.append("\u5b58\u50a8\u8fc7\u7a0b\r\n%1$s", strProcName);
            int nIndex = 0;
            if (sqlParamList != null) {
                for (SqlParam sqlParam : sqlParamList) {
                    sb.append("\r\n[%1$s] %2$s ==> (%3$s) ", nIndex, sqlParam.getParamName(), sqlParam.getValue());
                    ++nIndex;
                }
            }
            log.debug((Object)sb.toString());
        }
        final String strProcName2 = strProcName;
        final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        final SqlParamList sqlParamList2 = sqlParamList;
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                DBCallResult dbCallResult = null;
                try {
                    DAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                    dbCallResult = DAOBase.this.getRealDBDialect().callProc(connection, strProcName2, sqlParamList2, -1);
                    if (!dbCallResult.isOk()) {
                        throw new Exception(dbCallResult.getErrorInfo());
                    }
                    dbCallResultProxy.setDBCallResult(dbCallResult);
                }
                catch (Exception e) {
                    if (dbCallResult != null && dbCallResult.getDataSet() != null) {
                        dbCallResult.getDataSet().close();
                    }
                    throw new SQLException(StringHelper.format("\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", e.getMessage()), e);
                }
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    protected void fillInheritEntity(ET et) throws Exception {
    }

    @Override
    public void setDBDialect(IDBDialect iDBDialect) {
        this.iDBDialect = iDBDialect;
    }

    @Override
    public IDBDialect getRealDBDialect() {
        if (this.iDBDialect != null) {
            return this.iDBDialect;
        }
        return this.getDEModel().getSystemRuntime().getDBDialect(this.getDEModel().getDSLink());
    }

    public SessionFactory getRealSessionFactory() {
        if (this.sessionFactory != null) {
            return this.sessionFactory;
        }
        return this.getDEModel().getSystemRuntime().getSessionFactory(this.getDEModel().getDSLink());
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @Override
    public Session getCurrentSession() throws Exception {
        return SessionFactoryManager.getCurrentSession(this.getRealSessionFactory());
    }

    /*
     * WARNING - void declaration
     */
    protected String getGroupSQL(String strSQL, IDEDataSet iDEDataSet) throws Exception {
        void var11_18;
        if (StringHelper.isNullOrEmpty(strSQL)) {
            throw new Exception(StringHelper.format("\u4e3b\u67e5\u8be2\u8bed\u53e5\u65e0\u6548"));
        }
        StringBuilderEx sqlGroup = new StringBuilderEx();
        IDataEntity majorDataEntity = iDEDataSet.getDataEntity();
        sqlGroup.append("SELECT ");
        boolean bFirst = true;
        int nAliasIndex = 0;
        ArrayList<Object> groupFields = new ArrayList<Object>();
        ArrayList<String> orderList = new ArrayList<String>();
        ArrayList<IDEDataSetGroupParam> recalcItems = new ArrayList<IDEDataSetGroupParam>();
        Iterator<IDEDataSetGroupParam> deDataSetGroupParams = iDEDataSet.getDEDataSetGroupParams();
        while (deDataSetGroupParams.hasNext()) {
            IDEDataSetGroupParam iDEDataSetGroupParam = deDataSetGroupParams.next();
            if (iDEDataSetGroupParam.isReCalc()) {
                recalcItems.add(iDEDataSetGroupParam);
                continue;
            }
            ++nAliasIndex;
            Object strFormular = iDEDataSetGroupParam.getGroupCode();
            String[] fields = iDEDataSetGroupParam.getGroupFields();
            if (StringHelper.isNullOrEmpty((String)strFormular) && fields == null) continue;
            Object strFieldCode = "";
            Object strAlias = iDEDataSetGroupParam.getName();
            if (fields != null) {
                Object[] fieldCodes = new String[fields.length];
                if (StringHelper.isNullOrEmpty((String)strFormular)) {
                    strFormular = "%1$s";
                    Object strDEField = fields[0];
                    IDEField defHelper = majorDataEntity.getDEField((String)strDEField, true);
                    if (defHelper == null) {
                        if (StringHelper.isNullOrEmpty((String)strAlias)) {
                            strAlias = fields[0];
                        }
                        fieldCodes[0] = strDEField;
                    } else {
                        if (StringHelper.isNullOrEmpty((String)strAlias)) {
                            strAlias = fields[0];
                        }
                        String strRealCode = this.getDEFieldStatisticsNullConvertCode(defHelper);
                        fieldCodes[0] = strRealCode;
                    }
                } else {
                    int i = 0;
                    while (i < fields.length) {
                        Object strDEField = fields[i];
                        IDEField defHelper = majorDataEntity.getDEField((String)strDEField, true);
                        if (defHelper == null) {
                            fieldCodes[i] = strDEField;
                        } else {
                            String strRealCode = this.getDEFieldStatisticsNullConvertCode(defHelper);
                            fieldCodes[i] = strRealCode;
                        }
                        ++i;
                    }
                }
                strFieldCode = StringHelper.format((String)strFormular, fieldCodes);
            } else {
                strFieldCode = strFormular;
            }
            if (bFirst) {
                bFirst = false;
            } else {
                sqlGroup.append(",");
            }
            sqlGroup.append("%1$s as %2$s", strFieldCode, strAlias);
            if (iDEDataSetGroupParam.isEnableGroup()) {
                groupFields.add(strFieldCode);
            }
            if (StringHelper.isNullOrEmpty(iDEDataSetGroupParam.getSortDir())) continue;
            orderList.add(StringHelper.format("%1$s %2$s", strAlias, iDEDataSetGroupParam.getSortDir()));
        }
        sqlGroup.append(" FROM (%1$s) m1 ", strSQL);
        if (groupFields.size() == 0) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u4efb\u4f55\u5206\u7ec4\u5c5e\u6027"));
        }
        bFirst = true;
        for (String string : groupFields) {
            if (bFirst) {
                sqlGroup.append(" GROUP BY ");
                bFirst = false;
            } else {
                sqlGroup.append(" , ");
            }
            sqlGroup.append(string);
        }
        String string = sqlGroup.toString();
        if (recalcItems.size() > 0) {
            sqlGroup.reset();
            sqlGroup.append("SELECT m3.*");
            for (IDEDataSetGroupParam iDEDataSetGroupParam : recalcItems) {
                ++nAliasIndex;
                String strFormular = iDEDataSetGroupParam.getGroupCode();
                String[] fields = iDEDataSetGroupParam.getGroupFields();
                if (StringHelper.isNullOrEmpty(strFormular) && fields == null) continue;
                String strFieldCode = "";
                String strAlias = iDEDataSetGroupParam.getName();
                strFieldCode = strFormular;
                sqlGroup.append(",");
                sqlGroup.append("%1$s as %2$s", strFieldCode, strAlias);
                if (StringHelper.isNullOrEmpty(iDEDataSetGroupParam.getSortDir())) continue;
                orderList.add(StringHelper.format("%1$s %2$s", strAlias, iDEDataSetGroupParam.getSortDir()));
            }
            sqlGroup.append(" FROM (%1$s) m3", string);
            String string2 = sqlGroup.toString();
        }
        if (orderList.size() > 0) {
            void var11_16;
            StringBuilderEx sqlGroupEx = new StringBuilderEx();
            sqlGroupEx.append("SELECT * FROM (%1$s) m2 ", var11_16);
            bFirst = true;
            for (String strOrderCode : orderList) {
                if (bFirst) {
                    sqlGroupEx.append(" ORDER BY ");
                    bFirst = false;
                } else {
                    sqlGroupEx.append(" , ");
                }
                sqlGroupEx.append(strOrderCode);
            }
            String string3 = sqlGroupEx.toString();
        }
        if (iDEDataSet.getGroupTopCount() <= 0) {
            return var11_18;
        }
        return this.getRealDBDialect().getTopRowSQL((String)var11_18, iDEDataSet.getGroupTopCount());
    }

    protected String getDEFieldStatisticsNullConvertCode(IDEField defHelper) {
        return defHelper.getName();
    }

    @Override
    public String getDSLink() {
        return this.strDSLink;
    }

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

    protected void onPrepareConnection(Connection connection, Object objTag) throws Exception {
    }

    protected class DBCallResultProxy {
        private DBCallResult dbCallResult = null;

        protected DBCallResultProxy() {
        }

        public DBCallResult getDBCallResult() {
            return this.dbCallResult;
        }

        public void setDBCallResult(DBCallResult dbCallResult) {
            this.dbCallResult = dbCallResult;
        }
    }
}

