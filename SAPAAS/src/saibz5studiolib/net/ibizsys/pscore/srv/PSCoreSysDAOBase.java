/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDBCallContext
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataQueryCode
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataSet
 *  net.ibizsys.paas.core.IDEDataSetCond
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetQuery
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.dao.DAOBase
 *  net.ibizsys.paas.data.ISimpleDataObject
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.IDEDataSetModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.Session
 *  org.hibernate.jdbc.Work
 */
package net.ibizsys.pscore.srv;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDBCallContext;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.dao.DAOBase;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDEDataSetModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.IPSCoreSysDAO;
import net.ibizsys.pscore.srv.IPSRawSelectWork;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.util.modelinst.IPSDBServerSessionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

public abstract class PSCoreSysDAOBase<ET extends IEntity>
extends DAOBase<ET>
implements IPSCoreSysDAO {
    public static final String NODB = "SRFNODB";
    private static final Log log = LogFactory.getLog(PSCoreSysDAOBase.class);
    private static Map<String, String> psDevCenterDEFieldMap = new HashMap<String, String>();
    private static Map<String, String> psDevSlnDEFieldMap = new HashMap<String, String>();

    protected void onPrepareConnection(Connection connection, Object object) throws Exception {
        DBCallResult dBCallResult;
        IPSDBServerSessionFactory iPSDBServerSessionFactory;
        if (connection != null && this.getRealSessionFactory() instanceof IPSDBServerSessionFactory && StringHelper.compare((String)(iPSDBServerSessionFactory = (IPSDBServerSessionFactory)this.getRealSessionFactory()).getRealDBName(), (String)NODB, (boolean)false) != 0 && (dBCallResult = this.getRealDBDialect().callSql(connection, StringHelper.format((String)"use %1$s;", (Object)iPSDBServerSessionFactory.getRealDBName()), null, -1)).isError()) {
            log.error((Object)StringHelper.format((String)"\u9009\u62e9\u6a21\u578b\u4ed3\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)dBCallResult.getErrorInfo()));
            throw new Exception(StringHelper.format((String)"\u9009\u62e9\u6a21\u578b\u4ed3\u5e93\u53d1\u751f\u9519\u8bef"));
        }
    }

    @Override
    public void executeRawSelectSql(IDEDBCallContext iDEDBCallContext, String string, SqlParamList sqlParamList, IPSRawSelectWork iPSRawSelectWork) throws Exception {
        Session session = this.getCurrentSession();
        final String string2 = string;
        final DBFetchResult dBFetchResult = new DBFetchResult();
        final SqlParamList sqlParamList2 = sqlParamList;
        final IDEDBCallContext iDEDBCallContext2 = iDEDBCallContext;
        final IPSRawSelectWork iPSRawSelectWork2 = iPSRawSelectWork;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                try {
                    IDataSet iDataSet;
                    PSCoreSysDAOBase.this.onPrepareConnection(connection, iDEDBCallContext2);
                    DBCallResult dBCallResult = PSCoreSysDAOBase.this.getRealDBDialect().callSql(connection, string2, sqlParamList2, -1);
                    if (dBCallResult.isOk()) {
                        iDataSet = dBCallResult.getDataSet();
                        if (iDataSet == null || iDataSet.getDataTableCount() == 0) {
                            throw new ErrorException(3);
                        }
                    } else {
                        throw new Exception(dBCallResult.getErrorInfo());
                    }
                    IDataTable iDataTable = iDataSet.getDataTable(0);
                    iPSRawSelectWork2.process(iDataTable);
                    iDataSet.close();
                }
                catch (Exception exception) {
                    if (dBFetchResult.getDataSet() != null) {
                        dBFetchResult.getDataSet().close();
                    }
                    throw new SQLException(StringHelper.format((String)"\u6570\u636e\u5e93\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
        });
    }

    public DBCallResult fetchDEDataQuery(ISelectContext iSelectContext, boolean bl) throws Exception {
        Object object;
        Object object2;
        String string;
        Object object3;
        Object object4;
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext();
        dEDataSetFetchContext.setWebContext(iSelectContext.getWebContext());
        dEDataSetFetchContext.setFetchTotalRow(false);
        dEDataSetFetchContext.setPaging(false);
        dEDataSetFetchContext.setActiveDataObject((ISimpleDataObject)iSelectContext);
        dEDataSetFetchContext.setSort(iSelectContext.getSort());
        dEDataSetFetchContext.setSortDir(iSelectContext.getSortDir());
        DEDataSetFetchContext.setCurrent((IDEDataSetFetchContext)dEDataSetFetchContext);
        IDEDataQuery iDEDataQuery = this.getDEModel().getDEDataQuery(iSelectContext.getDEDataQueryName());
        Session session = this.getCurrentSession();
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        StringBuilderEx stringBuilderEx2 = new StringBuilderEx();
        SqlParamList sqlParamList = new SqlParamList();
        IDEDataQueryCode iDEDataQueryCode = this.getDEModel().getDEDataQuery(iDEDataQuery.getId()).getDEDataQueryCode(this.getRealDBDialect().getDBType());
        if (!StringHelper.isNullOrEmpty((String)iDEDataQueryCode.getDeclareCode())) {
            stringBuilderEx2.append(iDEDataQueryCode.getDeclareCode());
            stringBuilderEx2.append("\n");
            iDEDataQueryCode.fillDeclareParams(dEDataSetFetchContext.getWebContext(), null, sqlParamList);
        }
        dEDataSetFetchContext.fillDeclareParams(sqlParamList);
        iDEDataQueryCode.fillQueryParams(dEDataSetFetchContext.getWebContext(), null, sqlParamList);
        if (bl) {
            stringBuilderEx.append(iDEDataQueryCode.getQueryCodeTemp());
        } else {
            stringBuilderEx.append(iDEDataQueryCode.getQueryCode());
        }
        if (!StringHelper.isNullOrEmpty((String)dEDataSetFetchContext.getJoinScript())) {
            stringBuilderEx.append(iDEDataQueryCode.getExtJoinSQL((IDEDataSetFetchContext)dEDataSetFetchContext, dEDataSetFetchContext.getJoinScript(), this.getRealDBDialect(), sqlParamList));
        }
        boolean bl2 = false;
        boolean bl3 = true;
        Iterator iterator = iDEDataQueryCode.getDEDataQueryCodeConds();
        while (iterator.hasNext()) {
            object4 = (IDEDataQueryCodeCond)iterator.next();
            object3 = iDEDataQueryCode.getConditionSQL((IDEDataSetFetchContext)dEDataSetFetchContext, (IDEDataQueryCodeCond)object4, this.getRealDBDialect(), sqlParamList);
            if (StringHelper.isNullOrEmpty((String)object3)) continue;
            if (!bl2) {
                stringBuilderEx.append(" WHERE ");
                bl2 = true;
            }
            if (bl3) {
                bl3 = false;
            } else {
                stringBuilderEx.append(" AND ");
            }
            stringBuilderEx.append("(%1$s)", object3);
        }
        object4 = new HashMap();
        iSelectContext.fillMap((HashMap)object4);
        object3 = ((HashMap)object4).keySet().iterator();
        while (object3.hasNext()) {
            string = (String)object3.next();
            object2 = this.getDEModel().getDEField(string, true);
            if (object2 == null) continue;
            if (!bl2) {
                stringBuilderEx.append(" WHERE ");
                bl2 = true;
            }
            if (bl3) {
                bl3 = false;
            } else {
                stringBuilderEx.append(" AND ");
            }
            object = ((HashMap)object4).get(string);
            if (object == SelectCond.ISNOTNULL) {
                stringBuilderEx.append(" %1$s IS NOT NULL ", (Object)iDEDataQueryCode.getDEFieldExp(object2.getName(), false));
                continue;
            }
            if (object == SelectCond.ISNULL) {
                stringBuilderEx.append(" %1$s IS NULL ", (Object)iDEDataQueryCode.getDEFieldExp(object2.getName(), false));
                continue;
            }
            SqlParam sqlParam = new SqlParam();
            sqlParam.setDataType(object2.getStdDataType());
            sqlParam.setParamName(StringHelper.format((String)"VAR_%1$s", (Object)object2.getName().toUpperCase()));
            sqlParam.setValue(object);
            sqlParamList.add((Object)sqlParam);
            stringBuilderEx.append(" %1$s = ? ", (Object)iDEDataQueryCode.getDEFieldExp(object2.getName(), false));
        }
        if (iSelectContext.getSelectFilter() != null && iSelectContext.getSelectFilter() instanceof IDEDataQueryCodeCond && !StringHelper.isNullOrEmpty((String)(string = iDEDataQueryCode.getConditionSQL((IDEDataSetFetchContext)dEDataSetFetchContext, (IDEDataQueryCodeCond)(object3 = (IDEDataQueryCodeCond)iSelectContext.getSelectFilter()), this.getRealDBDialect(), sqlParamList)))) {
            if (!bl2) {
                stringBuilderEx.append(" WHERE ");
                bl2 = true;
            }
            if (bl3) {
                bl3 = false;
            } else {
                stringBuilderEx.append(" AND ");
            }
            stringBuilderEx.append("(%1$s)", (Object)string);
        }
        object3 = "";
        string = "";
        string = stringBuilderEx.toString();
        object2 = iSelectContext.getSelectFields();
        if (object2 != null) {
            object = new StringBuilderEx();
            object.append("SELECT ");
            int n = 0;
            while (object2.hasNext()) {
                if (n != 0) {
                    object.append(",");
                }
                ++n;
                ISelectField iSelectField = (ISelectField)object2.next();
                String string2 = iSelectField.getAlias();
                if (StringHelper.isNullOrEmpty((String)iSelectField.getFunc())) {
                    if (StringHelper.isNullOrEmpty((String)iSelectField.getName())) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b57\u6bb5\u540d\u79f0");
                    }
                    if (StringHelper.isNullOrEmpty((String)string2)) {
                        object.append("%1$s", (Object)this.getRealDBDialect().getDBObjStandardName(iSelectField.getName()));
                        continue;
                    }
                    object.append("%1$s AS %2$s", (Object)this.getRealDBDialect().getDBObjStandardName(iSelectField.getName()), (Object)this.getRealDBDialect().getDBObjStandardName(string2));
                    continue;
                }
                String[] stringArray = null;
                if (!StringHelper.isNullOrEmpty((String)iSelectField.getName())) {
                    stringArray = iSelectField.getName().split("[,]");
                }
                if (StringHelper.isNullOrEmpty((String)string2)) {
                    string2 = stringArray != null && stringArray.length > 0 ? stringArray[0] : StringHelper.format((String)"A%1$s", (Object)string2);
                }
                object.append("%1$s AS %2$s", (Object)this.getRealDBDialect().getFuncSQL(iSelectField.getFunc(), stringArray), (Object)this.getRealDBDialect().getDBObjStandardName(string2));
            }
            object.append(" FROM (%1$s) m1  ", (Object)string);
            string = object.toString();
        }
        object = this.fetchDataSet(session, (String)object3, string, dEDataSetFetchContext.getStartRow(), dEDataSetFetchContext.getPageSize(), sqlParamList);
        return object;
    }

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext, String string, boolean bl) throws Exception {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        IDEDataSetModel iDEDataSetModel;
        DEDataSetFetchContext.setCurrent((IDEDataSetFetchContext)iDEDataSetFetchContext);
        ArrayList arrayList = iDEDataSetFetchContext.getConditionList();
        IDEDataSet iDEDataSet = this.getDEModel().getDEDataSet(string);
        if (iDEDataSet instanceof IDEDataSetModel && (iDEDataSetModel = (IDEDataSetModel)iDEDataSet).isCustomDS()) {
            return iDEDataSetModel.fetchDEDataSet(iDEDataSetFetchContext);
        }
        iDEDataSetModel = this.getCurrentSession();
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        StringBuilderEx stringBuilderEx2 = new StringBuilderEx();
        SqlParamList sqlParamList = new SqlParamList();
        Iterator iterator = iDEDataSet.getDEDataSetQueries();
        Object object5 = null;
        while (iterator.hasNext()) {
            IDEDataSetQuery iDEDataSetQuery = (IDEDataSetQuery)iterator.next();
            object4 = this.getDEModel().getDEDataQuery(iDEDataSetQuery.getDEDataQueryId()).getDEDataQueryCode(this.getRealDBDialect().getDBType());
            if (object5 == null) {
                object5 = object4;
            }
            if (StringHelper.isNullOrEmpty((String)object4.getDeclareCode())) continue;
            stringBuilderEx2.append(object4.getDeclareCode());
            stringBuilderEx2.append("\n");
            object4.fillDeclareParams(iDEDataSetFetchContext.getWebContext(), null, sqlParamList);
        }
        iDEDataSetFetchContext.fillDeclareParams(sqlParamList);
        boolean bl2 = true;
        iterator = iDEDataSet.getDEDataSetQueries();
        while (iterator.hasNext()) {
            Object object6;
            String string2;
            Object object7;
            object4 = (IDEDataSetQuery)iterator.next();
            object3 = this.getDEModel().getDEDataQuery(object4.getDEDataQueryId());
            object2 = object3.getDEDataQueryCode(this.getRealDBDialect().getDBType());
            object2.fillQueryParams(iDEDataSetFetchContext.getWebContext(), null, sqlParamList);
            if (bl2) {
                bl2 = false;
            } else {
                stringBuilderEx.append(" UNION \n");
            }
            if (bl) {
                stringBuilderEx.append(object2.getQueryCodeTemp(iDEDataSetFetchContext, this.getRealDBDialect(), sqlParamList));
            } else {
                stringBuilderEx.append(object2.getQueryCode(iDEDataSetFetchContext, this.getRealDBDialect(), sqlParamList));
            }
            if (!StringHelper.isNullOrEmpty((String)iDEDataSetFetchContext.getJoinScript())) {
                stringBuilderEx.append(object2.getExtJoinSQL(iDEDataSetFetchContext, iDEDataSetFetchContext.getJoinScript(), this.getRealDBDialect(), sqlParamList));
            }
            boolean bl3 = false;
            boolean bl4 = true;
            object = object2.getDEDataQueryCodeConds();
            while (object.hasNext()) {
                object7 = (IDEDataQueryCodeCond)object.next();
                string2 = object2.getConditionSQL(iDEDataSetFetchContext, (IDEDataQueryCodeCond)object7, this.getRealDBDialect(), sqlParamList);
                if (StringHelper.isNullOrEmpty((String)string2)) continue;
                if (!bl3) {
                    stringBuilderEx.append(" WHERE ");
                    bl3 = true;
                }
                if (bl4) {
                    bl4 = false;
                } else {
                    stringBuilderEx.append(" AND ");
                }
                stringBuilderEx.append("(%1$s)", (Object)string2);
            }
            if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
                String string3;
                if (PSCoreSysServiceBase.isEnableCurDCLimit() && !StringHelper.isNullOrEmpty((String)(object7 = this.getPSDevCenterDEField(this.getDEModel(), (IDEDataQuery)object3)))) {
                    string2 = PSCoreSysServiceBase.getCurrentPSDCId();
                    if (StringHelper.isNullOrEmpty((String)string2)) {
                        string2 = "__INVALIDDCID__";
                    }
                    object6 = new DEDataSetCond();
                    object6.setCondType("DEFIELD");
                    object6.setDEFName((String)object7);
                    object6.setCondOp("EQ");
                    object6.setCondValue(string2);
                    string3 = object2.getConditionSQL(iDEDataSetFetchContext, (IDEDataQueryCodeCond)object6, this.getRealDBDialect(), sqlParamList);
                    if (!StringHelper.isNullOrEmpty((String)string3)) {
                        if (!bl3) {
                            stringBuilderEx.append(" WHERE ");
                            bl3 = true;
                        }
                        if (bl4) {
                            bl4 = false;
                        } else {
                            stringBuilderEx.append(" AND ");
                        }
                        stringBuilderEx.append("(%1$s)", (Object)string3);
                    }
                }
                if (PSCoreSysServiceBase.isEnableCurDevSlnLimit() && !StringHelper.isNullOrEmpty((String)(object7 = this.getPSDevSlnDEField(this.getDEModel(), (IDEDataQuery)object3)))) {
                    string2 = PSCoreSysServiceBase.getCurrentPSDevSlnId();
                    if (StringHelper.isNullOrEmpty((String)string2)) {
                        string2 = "__INVALIDSLNID__";
                    }
                    object6 = new DEDataSetCond();
                    object6.setCondType("DEFIELD");
                    object6.setDEFName((String)object7);
                    object6.setCondOp("EQ");
                    object6.setCondValue(string2);
                    string3 = object2.getConditionSQL(iDEDataSetFetchContext, (IDEDataQueryCodeCond)object6, this.getRealDBDialect(), sqlParamList);
                    if (!StringHelper.isNullOrEmpty((String)string3)) {
                        if (!bl3) {
                            stringBuilderEx.append(" WHERE ");
                            bl3 = true;
                        }
                        if (bl4) {
                            bl4 = false;
                        } else {
                            stringBuilderEx.append(" AND ");
                        }
                        stringBuilderEx.append("(%1$s)", (Object)string3);
                    }
                }
            }
            if (arrayList.size() == 0) continue;
            if (!bl3) {
                stringBuilderEx.append(" WHERE ");
                bl3 = true;
            }
            object7 = arrayList.iterator();
            while (object7.hasNext()) {
                string2 = (IDEDataSetCond)object7.next();
                if (!StringHelper.isNullOrEmpty((String)string2.getDEDataQueryName()) && StringHelper.compare((String)object2.getName(), (String)string2.getDEDataQueryName(), (boolean)false) != 0 || StringHelper.isNullOrEmpty((String)(object6 = object2.getConditionSQL(iDEDataSetFetchContext, (IDEDataQueryCodeCond)string2, this.getRealDBDialect(), sqlParamList)))) continue;
                if (bl4) {
                    bl4 = false;
                } else {
                    stringBuilderEx.append(" AND ");
                }
                stringBuilderEx.append("(%1$s)", object6);
            }
        }
        if (iDEDataSet.isEnableGroup()) {
            object4 = stringBuilderEx2.toString() + iDEDataSetFetchContext.getDeclareScript() + this.getGroupSQL(stringBuilderEx.toString(), iDEDataSet);
            object3 = this.fetchDataSet((Session)iDEDataSetModel, null, (String)object4, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), sqlParamList);
            if (object3.isOk() && object3.getDataSet() != null && iDEDataSetFetchContext.isCacheDataSet()) {
                object3.getDataSet().cacheDataRow();
            }
            return object3;
        }
        object4 = "";
        if (iDEDataSetFetchContext.isFetchTotalRow()) {
            object4 = stringBuilderEx2.toString() + iDEDataSetFetchContext.getDeclareScript() + this.getRealDBDialect().getCountSQL(stringBuilderEx.toString());
        }
        object3 = "";
        if (iDEDataSetFetchContext.isFetchData()) {
            object2 = iDEDataSetFetchContext.getSort();
            String string4 = iDEDataSetFetchContext.getSortDir();
            String string5 = iDEDataSetFetchContext.getSort2();
            object = iDEDataSetFetchContext.getSort2Dir();
            if (StringHelper.isNullOrEmpty((String)object2) && StringHelper.isNullOrEmpty((String)string5)) {
                object2 = iDEDataSet.getMajorSortField();
                string4 = iDEDataSet.getMajorSortDir();
                string5 = iDEDataSet.getMinorSortField();
                object = iDEDataSet.getMinorSortDir();
            }
            if (StringHelper.isNullOrEmpty((String)object2)) {
                string4 = null;
            }
            if (StringHelper.isNullOrEmpty((String)string5)) {
                object = null;
            }
            object3 = StringHelper.isNullOrEmpty((String)object2) && StringHelper.isNullOrEmpty((String)string5) && !iDEDataSetFetchContext.isPaging() ? stringBuilderEx.toString() : this.getRealDBDialect().getPagingSQL(stringBuilderEx.toString(), iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), (String)object2, string4, string5, (String)object, object5);
        }
        if ((object2 = this.fetchDataSet((Session)iDEDataSetModel, (String)object4, (String)object3, iDEDataSetFetchContext.getStartRow(), iDEDataSetFetchContext.getPageSize(), sqlParamList)).isOk() && object2.getDataSet() != null && iDEDataSetFetchContext.isCacheDataSet()) {
            object2.getDataSet().cacheDataRow();
        }
        return object2;
    }

    protected String getPSDevCenterDEField(IDataEntityModel iDataEntityModel, IDEDataQuery iDEDataQuery) throws Exception {
        String string = psDevCenterDEFieldMap.get(iDataEntityModel.getName());
        if (string == null && iDEDataQuery != null) {
            string = psDevCenterDEFieldMap.get(StringHelper.format((String)"%1$s|%2$s", (Object)iDataEntityModel.getName(), (Object)iDEDataQuery.getName()));
        }
        if (string != null) {
            if (StringHelper.isNullOrEmpty((String)string)) {
                return "";
            }
            return this.onGetPSDevCenterDEField(iDataEntityModel, iDEDataQuery, string);
        }
        IDEField iDEField = iDataEntityModel.getDEField("PSDEVCENTERID", true);
        if (iDEField != null) {
            return this.onGetPSDevCenterDEField(iDataEntityModel, iDEDataQuery, iDEField.getName());
        }
        return null;
    }

    protected String onGetPSDevCenterDEField(IDataEntityModel iDataEntityModel, IDEDataQuery iDEDataQuery, String string) throws Exception {
        return string;
    }

    protected String getPSDevSlnDEField(IDataEntityModel iDataEntityModel, IDEDataQuery iDEDataQuery) throws Exception {
        String string = psDevSlnDEFieldMap.get(iDataEntityModel.getName());
        if (string != null) {
            if (StringHelper.isNullOrEmpty((String)string)) {
                return "";
            }
            return this.onGetPSDevSlnDEField(iDataEntityModel, iDEDataQuery, string);
        }
        IDEField iDEField = iDataEntityModel.getDEField("PSDEVSLNID", true);
        if (iDEField != null) {
            return this.onGetPSDevSlnDEField(iDataEntityModel, iDEDataQuery, iDEField.getName());
        }
        return null;
    }

    protected String onGetPSDevSlnDEField(IDataEntityModel iDataEntityModel, IDEDataQuery iDEDataQuery, String string) throws Exception {
        return string;
    }

    static {
        psDevSlnDEFieldMap.put("PSPFSTYLE", "");
        psDevSlnDEFieldMap.put("PSSFSTYLE", "");
        psDevCenterDEFieldMap.put("PSDEVSLN|FromDCSLNUser", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYS|CurSln", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYS|CurUser3", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYS|CurUserTrunk3", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYS|CurUser4", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYS|CurUserTrunk4", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYS|CurUser5", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYS|CurUserTrunk5", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYS|CurUser6", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYS|CurUserTrunk6", "");
        psDevCenterDEFieldMap.put("PSDEVSLNTEMPL|CurUser3", "");
        psDevCenterDEFieldMap.put("PSDEVSLNTEMPL|CurUser4", "");
        psDevCenterDEFieldMap.put("PSDEVSLNTEMPL|CurUser5", "");
        psDevCenterDEFieldMap.put("PSDEVSLNTEMPL|CurUser6", "");
        psDevCenterDEFieldMap.put("PSDEVSLNTEMPL|CurSln", "");
        psDevCenterDEFieldMap.put("PSDCMSPLATFORMNODE|CurSln", "");
        psDevCenterDEFieldMap.put("PSDEVSLNMSDEPAPP|DEFAULT", "");
        psDevCenterDEFieldMap.put("PSDEVSLNMSDEPAPI|DEFAULT", "");
        psDevCenterDEFieldMap.put("PSDEVCENTERAS|CurSln", "");
        psDevCenterDEFieldMap.put("PSDEVCENTERDBINST|CurSln", "");
        psDevCenterDEFieldMap.put("PSDCWORKSPACE|CurSln", "");
        psDevCenterDEFieldMap.put("PSDCBKTASK|CurSlnRun", "");
        psDevCenterDEFieldMap.put("PSDCBKTASK|CurSlnFinish", "");
        psDevCenterDEFieldMap.put("PSDCMSPLATFORM|CurSln", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYSDYNAINST|CurUser3", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYSDYNAINST|CurUser4", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYSDYNAINST|CurUser5", "");
        psDevCenterDEFieldMap.put("PSDEVSLNSYSDYNAINST|CurUser6", "");
        psDevCenterDEFieldMap.put("PSDCDETEMPL|AllDCValid", "");
        psDevCenterDEFieldMap.put("PSDCMODELTEMPL|AllDC", "");
        psDevCenterDEFieldMap.put("PSPFSTYLE|CurDCPF", "");
        psDevCenterDEFieldMap.put("PSSFSTYLE|CurDCSF", "");
        psDevCenterDEFieldMap.put("PSSFSTYLE|CurDCDoc", "");
        psDevCenterDEFieldMap.put("PSSTUDIOPLUGIN|AllDCValid", "");
        psDevCenterDEFieldMap.put("PSSTUDIOPLUGIN|AllDC", "");
    }
}

