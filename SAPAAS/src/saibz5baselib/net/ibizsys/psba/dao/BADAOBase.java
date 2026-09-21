/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psba.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psba.core.IBACallContext;
import net.ibizsys.psba.core.IBAColumn;
import net.ibizsys.psba.core.IBADialect;
import net.ibizsys.psba.dao.BAEntityActionHelperImpl;
import net.ibizsys.psba.dao.IBAAsyncSelectHandler;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.dao.IBADAOWork;
import net.ibizsys.psba.dao.IBASelectContext;
import net.ibizsys.psba.entity.IBAEntity;
import net.ibizsys.psba.entity.IBAEntityActionHelper;
import net.ibizsys.psrt.srv.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BADAOBase<ET extends IBAEntity>
implements IBADAO<ET>,
IBACallContext {
    private static final Log log = LogFactory.getLog(BADAOBase.class);
    private ThreadPoolExecutor threadPoolExecutor = null;
    private IBAEntityActionHelper iBAEntityActionHelper = null;

    protected String getBADAOId() {
        return null;
    }

    @Override
    public IWebContext getWebContext() {
        return WebContext.getCurrent();
    }

    protected ThreadPoolExecutor createThreadPoolExecutor() {
        return new ThreadPoolExecutor(0, 10, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.AbortPolicy());
    }

    protected synchronized ThreadPoolExecutor getSelectThreadPoolExecutor() {
        if (this.threadPoolExecutor == null) {
            this.threadPoolExecutor = this.createThreadPoolExecutor();
        }
        return this.threadPoolExecutor;
    }

    protected synchronized ThreadPoolExecutor getWorkThreadPoolExecutor() {
        if (this.threadPoolExecutor == null) {
            this.threadPoolExecutor = this.createThreadPoolExecutor();
        }
        return this.threadPoolExecutor;
    }

    @Override
    public IBAEntityActionHelper getBAEntityActionHelper() throws Exception {
        if (this.iBAEntityActionHelper != null) {
            return this.iBAEntityActionHelper;
        }
        BAEntityActionHelperImpl iBAEntityActionHelper = new BAEntityActionHelperImpl();
        iBAEntityActionHelper.init(this);
        this.iBAEntityActionHelper = iBAEntityActionHelper;
        return this.iBAEntityActionHelper;
    }

    @Override
    public void executeGetCmd(IBAEntity et, String[] families) throws Exception {
        et.setActionHelper(this.getBAEntityActionHelper());
        final IBAEntity et2 = et;
        final BADAOBase iBACallContext = this;
        final String[] families2 = families;
        this.doWork(new IBADAOWork(){

            @Override
            public void execute(Object connection) throws Exception {
                BADAOBase.this.getRealBADialect().executeGetCmd(iBACallContext, connection, et2, families2);
            }
        });
    }

    @Override
    public void executeCreateCmd(IBAEntity et, String[] families) throws Exception {
        final IBAEntity et2 = et;
        final BADAOBase iBACallContext = this;
        final String[] families2 = families;
        this.doWork(new IBADAOWork(){

            @Override
            public void execute(Object connection) throws Exception {
                HashMap<IBAColumn, Object> insertColumnsMap = new HashMap<IBAColumn, Object>();
                if (!BADAOBase.this.fillInsertColumnMap(insertColumnsMap, et2, families2)) {
                    return;
                }
                BADAOBase.this.onBeforeCreate(iBACallContext, connection, insertColumnsMap, et2, families2);
                BADAOBase.this.getRealBADialect().executeCreateCmd(iBACallContext, connection, insertColumnsMap, et2, families2);
                BADAOBase.this.onAfterCreate(iBACallContext, connection, insertColumnsMap, et2, families2);
            }
        });
    }

    @Override
    public void executeBatchCreateCmd(IBAEntity[] ets, String[] families) throws Exception {
        final IBAEntity[] ets2 = ets;
        final BADAOBase iBACallContext = this;
        final String[] families2 = families;
        this.doWork(new IBADAOWork(){

            @Override
            public void execute(Object connection) throws Exception {
                IBAEntity et2;
                HashMap insertColumnsMap;
                HashMap<IBAEntity, HashMap> baEntityMap = new HashMap<IBAEntity, HashMap>();
                ArrayList<Map<IBAColumn, Object>> list = new ArrayList<Map<IBAColumn, Object>>();
                ArrayList<IBAEntity> etlist = new ArrayList<IBAEntity>();
                IBAEntity[] iBAEntityArray = ets2;
                int n = ets2.length;
                int n2 = 0;
                while (n2 < n) {
                    insertColumnsMap = new HashMap();
                    et2 = iBAEntityArray[n2];
                    if (BADAOBase.this.fillInsertColumnMap(insertColumnsMap, et2, families2)) {
                        baEntityMap.put(et2, insertColumnsMap);
                        etlist.add(et2);
                        BADAOBase.this.onBeforeCreate(iBACallContext, connection, insertColumnsMap, et2, families2);
                        list.add(insertColumnsMap);
                    }
                    ++n2;
                }
                BADAOBase.this.getRealBADialect().executeBatchCreateCmd(iBACallContext, connection, list, etlist.toArray(new IBAEntity[etlist.size()]), families2);
                iBAEntityArray = ets2;
                n = ets2.length;
                n2 = 0;
                while (n2 < n) {
                    et2 = iBAEntityArray[n2];
                    insertColumnsMap = (HashMap)baEntityMap.get(et2);
                    if (insertColumnsMap != null) {
                        BADAOBase.this.onAfterCreate(iBACallContext, connection, insertColumnsMap, et2, families2);
                    }
                    ++n2;
                }
            }
        });
    }

    protected void onBeforeCreate(IBACallContext iBACallContext, Object connection, Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception {
    }

    protected void onAfterCreate(IBACallContext iBACallContext, Object connection, Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception {
    }

    @Override
    public void executeUpdateCmd(IBAEntity et, String[] families) throws Exception {
        final IBAEntity et2 = et;
        final BADAOBase iBACallContext = this;
        final String[] families2 = families;
        this.doWork(new IBADAOWork(){

            @Override
            public void execute(Object connection) throws Exception {
                HashMap<IBAColumn, Object> updateColumnsMap = new HashMap<IBAColumn, Object>();
                if (!BADAOBase.this.fillUpdateColumnMap(updateColumnsMap, et2, families2, false)) {
                    return;
                }
                BADAOBase.this.onBeforeUpdate(iBACallContext, connection, updateColumnsMap, et2, families2);
                BADAOBase.this.getRealBADialect().executeUpdateCmd(iBACallContext, connection, updateColumnsMap, et2, families2);
                BADAOBase.this.onAfterUpdate(iBACallContext, connection, updateColumnsMap, et2, families2);
            }
        });
    }

    protected void onBeforeUpdate(IBACallContext iBACallContext, Object connection, Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception {
    }

    protected void onAfterUpdate(IBACallContext iBACallContext, Object connection, Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception {
    }

    protected void onBeforeSysUpdate(IBACallContext iBACallContext, Object connection, Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception {
    }

    protected void onAfterSysUpdate(IBACallContext iBACallContext, Object connection, Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception {
    }

    @Override
    public void executeRemoveCmd(IBAEntity et) throws Exception {
        final IBAEntity et2 = et;
        final BADAOBase iBACallContext = this;
        this.doWork(new IBADAOWork(){

            @Override
            public void execute(Object connection) throws Exception {
                BADAOBase.this.onBeforeRemove(iBACallContext, connection, et2);
                BADAOBase.this.getRealBADialect().executeRemoveCmd(iBACallContext, connection, et2);
                BADAOBase.this.onAfterRemove(iBACallContext, connection, et2);
            }
        });
    }

    protected void onBeforeRemove(IBACallContext iBACallContext, Object connection, IBAEntity et) throws Exception {
    }

    protected void onAfterRemove(IBACallContext iBACallContext, Object connection, IBAEntity et) throws Exception {
    }

    @Override
    public ArrayList<IBAEntity> executeSelectCmd(IBASelectContext iBASelectContext) throws Exception {
        final IBASelectContext iBASelectContext2 = iBASelectContext;
        final BADAOBase iBACallContext = this;
        final CallResult callResult = new CallResult();
        this.doWork(new IBADAOWork(){

            @Override
            public void execute(Object connection) throws Exception {
                ArrayList<IBAEntity> list2 = BADAOBase.this.getRealBADialect().executeSelectCmd(iBACallContext, connection, iBASelectContext2, null);
                for (IBAEntity ibaEntity : list2) {
                    ibaEntity.setActionHelper(BADAOBase.this.getBAEntityActionHelper());
                }
                callResult.setUserObject(list2);
            }
        });
        return (ArrayList)callResult.getUserObject();
    }

    @Override
    public void executeSelectCmdAsync(IBASelectContext iBASelectContext, IBAAsyncSelectHandler iBAAsyncSelectHandler) throws Exception {
        if (iBAAsyncSelectHandler == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f02\u6b65\u5904\u7406\u5bf9\u8c61");
        }
        final IBASelectContext iBASelectContext2 = iBASelectContext;
        final IBAAsyncSelectHandler iBAAsyncSelectHandler2 = iBAAsyncSelectHandler;
        this.getSelectThreadPoolExecutor().execute(new Runnable(){

            @Override
            public void run() {
                try {
                    BADAOBase.this.executeSelectCmd(iBASelectContext2, new IBAAsyncSelectHandler(){

                        @Override
                        public void exception(Exception exception) {
                            iBAAsyncSelectHandler2.exception(exception);
                        }

                        @Override
                        public void processBAEntity(IBAEntity iBAEntity) {
                            try {
                                iBAEntity.setActionHelper(BADAOBase.this.getBAEntityActionHelper());
                                iBAAsyncSelectHandler2.processBAEntity(iBAEntity);
                            }
                            catch (Exception ex) {
                                log.error((Object)ex);
                            }
                        }
                    });
                }
                catch (Exception e) {
                    iBAAsyncSelectHandler2.exception(e);
                    return;
                }
            }
        });
    }

    @Override
    public void executeSelectCmd(IBASelectContext iBASelectContext, IBAAsyncSelectHandler iBAAsyncSelectHandler) throws Exception {
        if (iBAAsyncSelectHandler == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f02\u6b65\u5904\u7406\u5bf9\u8c61");
        }
        final IBASelectContext iBASelectContext2 = iBASelectContext;
        final BADAOBase iBACallContext = this;
        final IBAAsyncSelectHandler iBAAsyncSelectHandler2 = iBAAsyncSelectHandler;
        this.doWork(new IBADAOWork(){

            @Override
            public void execute(Object connection) throws Exception {
                BADAOBase.this.getRealBADialect().executeSelectCmd(iBACallContext, connection, iBASelectContext2, new IBAAsyncSelectHandler(){

                    @Override
                    public void exception(Exception exception) {
                        iBAAsyncSelectHandler2.exception(exception);
                    }

                    @Override
                    public void processBAEntity(IBAEntity iBAEntity) {
                        try {
                            iBAEntity.setActionHelper(BADAOBase.this.getBAEntityActionHelper());
                            iBAAsyncSelectHandler2.processBAEntity(iBAEntity);
                        }
                        catch (Exception ex) {
                            log.error((Object)ex);
                        }
                    }
                });
            }
        });
    }

    protected void addAsyncSelectBAEntityWork(IBAEntity iBAEntity, IBAAsyncSelectHandler iBAAsyncSelectHandler) {
        final IBAAsyncSelectHandler iBAAsyncSelectHandler2 = iBAAsyncSelectHandler;
        final IBAEntity iBAEntity2 = iBAEntity;
        this.getWorkThreadPoolExecutor().execute(new Runnable(){

            @Override
            public void run() {
                iBAAsyncSelectHandler2.processBAEntity(iBAEntity2);
            }
        });
    }

    @Override
    public IBADialect getRealBADialect() {
        return this.getBASchemeModel().getBADialect();
    }

    protected Object getParamValue(String strParamName, ISimpleDataObject iEntity) throws Exception {
        return BADAOBase.getParamValue(strParamName, iEntity, WebContext.getCurrent(), null, null);
    }

    protected Object getParamValue(String strParamName, ISimpleDataObject iEntity, IDataEntity iDataEntity) throws Exception {
        return BADAOBase.getParamValue(strParamName, iEntity, WebContext.getCurrent(), iDataEntity, null);
    }

    protected Object getParamValue(String strParamName, IEntity iEntity, Object objDefaultValue, IDataEntity iDataEntity) throws Exception {
        return BADAOBase.getParamValue(strParamName, iEntity, WebContext.getCurrent(), iDataEntity, objDefaultValue);
    }

    protected boolean fillInsertColumnMap(HashMap<IBAColumn, Object> insertColumnsMap, IBAEntity et2, String[] families) throws Exception {
        IBAColumn iBAColumn;
        String objKeyValue = et2.getRowKey();
        if (this.getBATableModel().getBATableType() == 3) {
            throw new Exception("\u6682\u65f6\u4e0d\u652f\u6301");
        }
        if (et2.getCreateDate() != null) {
            iBAColumn = this.getBATableModel().getBAColumn("CREATEINFO", "SRFCREATEDATE");
            insertColumnsMap.put(iBAColumn, et2.getCreateDate());
        }
        if (et2.getUpdateDate() != null) {
            iBAColumn = this.getBATableModel().getBAColumn("UPDATEINFO", "SRFUPDATEDATE");
            insertColumnsMap.put(iBAColumn, et2.getUpdateDate());
        }
        HashMap<String, ISimpleDataObject> entityMap = new HashMap<String, ISimpleDataObject>();
        if (families == null) {
            Iterator<String> names = et2.getFamilyNames();
            while (names.hasNext()) {
                String strFamily = names.next();
                entityMap.put(strFamily, et2.getFamily(strFamily, true));
            }
        } else {
            String[] stringArray = families;
            int n = families.length;
            int n2 = 0;
            while (n2 < n) {
                String strFamily = stringArray[n2];
                entityMap.put(strFamily, et2.getFamily(strFamily, true));
                ++n2;
            }
        }
        for (String strFamily : entityMap.keySet()) {
            ISimpleDataObject et = (ISimpleDataObject)entityMap.get(strFamily);
            Iterator<IBAColumn> baColumns = this.getBATableModel().getBAColSet(strFamily).getBAColumns();
            while (baColumns.hasNext()) {
                IBAColumn iBAColumn2 = baColumns.next();
                IDEField iDEField = iBAColumn2.getDEField();
                if (!StringHelper.isNullOrEmpty(iBAColumn2.getDBValueFunc())) {
                    Object objValue = this.getRealBADialect().getFuncValue(iBAColumn2.getDBValueFunc(), true, new String[]{iBAColumn2.getName()});
                    insertColumnsMap.put(iBAColumn2, objValue);
                    continue;
                }
                insertColumnsMap.put(iBAColumn2, this.getParamValue(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()), et, iDEField.getDataEntity()));
            }
        }
        return true;
    }

    protected boolean fillUpdateColumnMap(HashMap<IBAColumn, Object> updateColumnsMap, IBAEntity et, String[] families, boolean bSysUpdateMode) throws Exception {
        return this.fillInsertColumnMap(updateColumnsMap, et, families);
    }

    protected static Object getParamValue(String strParamName, ISimpleDataObject iEntity, IWebContext iWebContext, IDataEntity iDataEntity, Object objDefaultValue) throws Exception {
        if ((strParamName = strParamName.toUpperCase()).indexOf("VAR_") == 0) {
            Object objValue;
            strParamName = strParamName.substring(4);
            Object object = objValue = iEntity == null ? null : iEntity.get(strParamName);
            if (objValue != null && objValue instanceof String && StringHelper.isNullOrEmpty((String)objValue)) {
                objValue = null;
            }
            return objValue;
        }
        if (strParamName.indexOf("VF_") == 0) {
            strParamName = strParamName.substring(3);
            if (iEntity != null && iEntity.contains(strParamName)) {
                return 1;
            }
            return 0;
        }
        if (StringHelper.compare(strParamName, "SRF_CURTIME", true) == 0) {
            if (iEntity != null) {
                Timestamp curTime = DataTypeHelper.getTimestampValue(iEntity, "SRF_CURTIME", null);
                if (curTime == null) {
                    curTime = DateHelper.getCurTime();
                }
                return curTime;
            }
            return DateHelper.getCurTime();
        }
        if (StringHelper.compare(strParamName, "SRF_PERSONID", true) == 0) {
            if (iEntity != null) {
                String strTempOpPersonId = DataTypeHelper.getStringValue(iEntity, "SRF_PERSONID", iWebContext == null ? null : iWebContext.getCurUserId());
                return strTempOpPersonId;
            }
            return iWebContext == null ? null : iWebContext.getCurUserId();
        }
        if (StringHelper.compare(strParamName, "SRF_PERSONNAME", true) == 0) {
            if (iEntity != null) {
                String strTempOpPersonName = DataTypeHelper.getStringValue(iEntity, "SRF_PERSONNAME", iWebContext == null ? null : iWebContext.getCurUserName());
                return strTempOpPersonName;
            }
            return iWebContext == null ? null : iWebContext.getCurUserName();
        }
        if (StringHelper.compare(strParamName, "SRF_ORGID", true) == 0) {
            if (iEntity != null) {
                IDEField ideField;
                String strOrgId = DataTypeHelper.getStringValue(iEntity, "SRF_ORGID", null);
                if (StringHelper.isNullOrEmpty(strOrgId) && iDataEntity != null && (ideField = ((IDataEntityModel)iDataEntity).getDEFieldByPDT("ORGID", true)) != null) {
                    strOrgId = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
                }
                if (StringHelper.isNullOrEmpty(strOrgId) && iWebContext != null) {
                    strOrgId = iWebContext.getCurOrgId();
                }
                return strOrgId;
            }
            return iWebContext == null ? null : iWebContext.getCurOrgId();
        }
        if (StringHelper.compare(strParamName, "SRF_ORGNAME", true) == 0) {
            if (iEntity != null) {
                IDEField ideField;
                String strOrgName = DataTypeHelper.getStringValue(iEntity, "SRF_ORGNAME", null);
                if (StringHelper.isNullOrEmpty(strOrgName) && iDataEntity != null && (ideField = ((IDataEntityModel)iDataEntity).getDEFieldByPDT("ORGNAME", true)) != null) {
                    strOrgName = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
                }
                if (StringHelper.isNullOrEmpty(strOrgName) && iWebContext != null) {
                    strOrgName = iWebContext.getCurOrgName();
                }
                return strOrgName;
            }
            return iWebContext == null ? null : iWebContext.getCurOrgName();
        }
        if (StringHelper.compare(strParamName, "SRF_ORGSECTORID", true) == 0) {
            if (iEntity != null) {
                IDEField ideField;
                String strOrgSectorId = DataTypeHelper.getStringValue(iEntity, "SRF_ORGSECTORID", null);
                if (StringHelper.isNullOrEmpty(strOrgSectorId) && iDataEntity != null && (ideField = ((IDataEntityModel)iDataEntity).getDEFieldByPDT("ORGSECTORID", true)) != null) {
                    strOrgSectorId = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
                }
                if (StringHelper.isNullOrEmpty(strOrgSectorId) && iWebContext != null) {
                    strOrgSectorId = iWebContext.getCurOrgSectorId();
                }
                return strOrgSectorId;
            }
            return iWebContext == null ? null : iWebContext.getCurOrgSectorId();
        }
        if (StringHelper.compare(strParamName, "SRF_ORGSECTORNAME", true) == 0) {
            if (iEntity != null) {
                IDEField ideField;
                String strOrgSectorName = DataTypeHelper.getStringValue(iEntity, "SRF_ORGSECTORNAME", null);
                if (StringHelper.isNullOrEmpty(strOrgSectorName) && iDataEntity != null && (ideField = ((IDataEntityModel)iDataEntity).getDEFieldByPDT("ORGSECTORNAME", true)) != null) {
                    strOrgSectorName = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
                }
                if (StringHelper.isNullOrEmpty(strOrgSectorName) && iWebContext != null) {
                    strOrgSectorName = iWebContext.getCurOrgSectorName();
                }
                return strOrgSectorName;
            }
            return iWebContext == null ? null : iWebContext.getCurOrgSectorName();
        }
        if (StringHelper.compare(strParamName, "SRF_ACTIONARG", true) == 0) {
            throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u9ed8\u8ba4\u53c2\u6570[%1$s]", strParamName));
        }
        if (StringHelper.compare(strParamName, "SRF_RD", true) == 0) {
            throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u9ed8\u8ba4\u53c2\u6570[%1$s]", strParamName));
        }
        if (StringHelper.compare(strParamName, "SRF_RETCODE", true) == 0) {
            throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u9ed8\u8ba4\u53c2\u6570[%1$s]", strParamName));
        }
        if (StringHelper.compare(strParamName, "SRF_RETINFO", true) == 0) {
            throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u9ed8\u8ba4\u53c2\u6570[%1$s]", strParamName));
        }
        if (StringHelper.compare(strParamName, "SRF_RETINFORES", true) == 0) {
            throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u9ed8\u8ba4\u53c2\u6570[%1$s]", strParamName));
        }
        if (StringHelper.compare(strParamName, "SRF_RETINFORESARG", true) == 0) {
            throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u9ed8\u8ba4\u53c2\u6570[%1$s]", strParamName));
        }
        if (StringHelper.compare(strParamName, "SRF_DALOG", true) == 0) {
            if (iEntity != null) {
                return DataTypeHelper.getIntegerValue(iEntity, "SRF_DALOG", 1);
            }
            return 1;
        }
        if (StringHelper.compare(strParamName, "SRF_CHECKKEY", true) == 0) {
            if (iEntity != null) {
                return DataTypeHelper.getIntegerValue(iEntity, "SRF_CHECKKEY", 1);
            }
            return 1;
        }
        if (StringHelper.compare(strParamName, "SRF_RETDATA", true) == 0) {
            if (iEntity != null) {
                return DataTypeHelper.getIntegerValue(iEntity, "SRF_RETDATA", 1);
            }
            return 1;
        }
        if (StringHelper.compare(strParamName, "SRF_TAG", true) == 0) {
            throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u9ed8\u8ba4\u53c2\u6570[%1$s]", strParamName));
        }
        if (objDefaultValue == null) {
            throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u53c2\u6570\u540d\u79f0[%1$s]", strParamName));
        }
        return objDefaultValue;
    }

    protected void doWork(IBADAOWork iBADAOWork) throws Exception {
        this.doWork(-1, iBADAOWork, true);
    }

    protected void doWork(IBADAOWork iBADAOWork, boolean bTransaction) throws Exception {
        this.doWork(-1, iBADAOWork, false);
    }

    protected void doWork(int nMode, IBADAOWork iBADAOWork, boolean bTransaction) throws Exception {
        long nBeginTime = System.currentTimeMillis();
        Object connection = this.getConnection();
        try {
            if (bTransaction) {
                iBADAOWork.execute(connection);
            } else {
                iBADAOWork.execute(connection);
            }
            this.closeConnection(connection);
        }
        catch (Exception ex) {
            if (connection != null) {
                this.closeConnection(connection);
                connection = null;
            }
            String strMessage = ex.getMessage();
            if (ex.getCause() != null && ex.getCause() instanceof Exception) {
                Exception exception = (Exception)ex.getCause();
                strMessage = exception.getMessage();
            }
            log.error((Object)StringHelper.format("\u5927\u6570\u636e\u8868[%1$s]doWork\u53d1\u751f\u5f02\u5e38\uff0c%2$s", this.getBATableModel().getName(), strMessage), (Throwable)ex);
            throw ex;
        }
        long nTime = System.currentTimeMillis() - nBeginTime;
        log.debug((Object)StringHelper.format("\u4f5c\u4e1a \u8017\u65f6[%1$s]", nTime));
    }

    protected Object getConnection() throws Exception {
        return this.getBASchemeModel().getBADataSource().getConnection();
    }

    protected void closeConnection(Object objConn) throws Exception {
        this.getBASchemeModel().getBADataSource().closeConnection(objConn);
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

