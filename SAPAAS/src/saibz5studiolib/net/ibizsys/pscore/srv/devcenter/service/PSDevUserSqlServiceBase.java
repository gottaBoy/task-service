/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDevUserSqlDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserSqlDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserSql;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevUserSqlServiceBase
extends PSCoreSysServiceBase<PSDevUserSql> {
    private static final Log log = LogFactory.getLog(PSDevUserSqlServiceBase.class);
    public static final String DATASET_CURUSERSQL = "CurUserSQL";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_EXECUTESQL = "ExecuteSQL";
    private PSDevUserSqlDEModel pSDevUserSqlDEModel;
    private PSDevUserSqlDAO pSDevUserSqlDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDevUserSqlService";
    }

    public PSDevUserSqlDEModel getPSDevUserSqlDEModel() {
        if (this.pSDevUserSqlDEModel == null) {
            try {
                this.pSDevUserSqlDEModel = (PSDevUserSqlDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserSqlDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserSqlDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevUserSqlDEModel();
    }

    public PSDevUserSqlDAO getPSDevUserSqlDAO() {
        if (this.pSDevUserSqlDAO == null) {
            try {
                this.pSDevUserSqlDAO = (PSDevUserSqlDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDevUserSqlDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserSqlDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevUserSqlDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERSQL, (boolean)true) == 0) {
            return this.fetchCurUserSQL(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_EXECUTESQL, (boolean)true) == 0) {
            this.executeSQL((PSDevUserSql)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurUserSQL(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERSQL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void executeSQL(PSDevUserSql pSDevUserSql) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_EXECUTESQL, 0, pSDevUserSql, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevUserSql, ACTION_EXECUTESQL);
        final PSDevUserSql pSDevUserSql2 = pSDevUserSql;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevUserSqlServiceBase.this.getService(), PSDevUserSqlServiceBase.ACTION_EXECUTESQL, 40, pSDevUserSql2, null).getResult() != 1) {
                    PSDevUserSqlServiceBase.this.onExecuteSQL(pSDevUserSql2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_EXECUTESQL, 99, pSDevUserSql, null);
        }
    }

    protected void onExecuteSQL(PSDevUserSql pSDevUserSql) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ExecuteSQL]");
    }

    protected void onFillParentInfo(PSDevUserSql pSDevUserSql, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVUSERSQL_PSDEVUSER_PSDEVUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = (PSDevUser)iService.getDEModel().createEntity();
            pSDevUser.set("PSDEVUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevUser);
            } else {
                iService.get(pSDevUser);
            }
            this.onFillParentInfo_PSDevUser(pSDevUserSql, pSDevUser);
            return;
        }
        super.onFillParentInfo(pSDevUserSql, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevUser(PSDevUserSql pSDevUserSql, PSDevUser pSDevUser) throws Exception {
        pSDevUserSql.setPSDevUserId(pSDevUser.getPSDevUserId());
        pSDevUserSql.setPSDevUserName(pSDevUser.getPSDevUserName());
    }

    protected void onFillEntityFullInfo(PSDevUserSql pSDevUserSql, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevUserSql, bl);
        this.onFillEntityFullInfo_PSDevUser(pSDevUserSql, bl);
    }

    protected void onFillEntityFullInfo_PSDevUser(PSDevUserSql pSDevUserSql, boolean bl) throws Exception {
        if (pSDevUserSql.isPSDevUserIdDirty()) {
            if (pSDevUserSql.getPSDevUserId() != null) {
                if (pSDevUserSql.getPSDevUserId() == null || pSDevUserSql.getPSDevUserName() == null) {
                    PSDevUser pSDevUser = pSDevUserSql.getPSDevUser();
                    pSDevUserSql.setPSDevUserName(pSDevUser.getPSDevUserName());
                }
            } else {
                pSDevUserSql.setPSDevUserName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevUserSql pSDevUserSql, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevUserSql, bl);
    }

    public ArrayList<PSDevUserSql> selectByPSDevUser(PSDevUserBase pSDevUserBase) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, "", -1);
    }

    public ArrayList<PSDevUserSql> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, string, -1);
    }

    public ArrayList<PSDevUserSql> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVUSERID", (Object)pSDevUserBase.getPSDevUserId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevUserCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevUserCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    public void resetPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevUserSql> arrayList = this.selectByPSDevUser(pSDevUser);
        for (PSDevUserSql pSDevUserSql : arrayList) {
            PSDevUserSql pSDevUserSql2 = (PSDevUserSql)this.getDEModel().createEntity();
            pSDevUserSql2.setPSDevUserSqlId(pSDevUserSql.getPSDevUserSqlId());
            pSDevUserSql2.setPSDevUserId(null);
            this.update(pSDevUserSql2);
        }
    }

    public void removeByPSDevUser(PSDevUser pSDevUser) throws Exception {
        final PSDevUser pSDevUser2 = pSDevUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevUserSqlServiceBase.this.onBeforeRemoveByPSDevUser(pSDevUser2);
                PSDevUserSqlServiceBase.this.internalRemoveByPSDevUser(pSDevUser2);
                PSDevUserSqlServiceBase.this.onAfterRemoveByPSDevUser(pSDevUser2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void internalRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevUserSql> arrayList = this.selectByPSDevUser(pSDevUser);
        this.onBeforeRemoveByPSDevUser(pSDevUser, arrayList);
        for (PSDevUserSql pSDevUserSql : arrayList) {
            this.remove(pSDevUserSql);
        }
        this.onAfterRemoveByPSDevUser(pSDevUser, arrayList);
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDevUserSql> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDevUserSql> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevUserSql pSDevUserSql) throws Exception {
        super.onBeforeRemove(pSDevUserSql);
    }

    protected void replaceParentInfo(PSDevUserSql pSDevUserSql, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevUserSql, cloneSession);
        if (pSDevUserSql.getPSDevUserId() != null && (iEntity = cloneSession.getEntity("PSDEVUSER", (Object)pSDevUserSql.getPSDevUserId())) != null) {
            this.onFillParentInfo_PSDevUser(pSDevUserSql, (PSDevUser)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevUserSql pSDevUserSql, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevUserSql, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevUserSql pSDevUserSql, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSDevUserSql, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileType(bl, pSDevUserSql, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserId(bl, pSDevUserSql, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserName(bl, pSDevUserSql, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserSqlId(bl, pSDevUserSql, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserSqlName(bl, pSDevUserSql, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevUserSql, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSDevUserSql pSDevUserSql, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserSql.isContentDirty() : !pSDevUserSql.isContentDirty()) {
            return null;
        }
        String string = pSDevUserSql.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSDevUserSql, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileType(boolean bl, PSDevUserSql pSDevUserSql, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserSql.isFileTypeDirty() && !bl2 : !pSDevUserSql.isFileTypeDirty()) {
            return null;
        }
        String string = pSDevUserSql.getFileType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileType_Default(pSDevUserSql, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserId(boolean bl, PSDevUserSql pSDevUserSql, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserSql.isPSDevUserIdDirty() && !bl2 : !pSDevUserSql.isPSDevUserIdDirty()) {
            return null;
        }
        String string = pSDevUserSql.getPSDevUserId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserId_Default(pSDevUserSql, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserName(boolean bl, PSDevUserSql pSDevUserSql, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserSql.isPSDevUserNameDirty() && !bl2 : !pSDevUserSql.isPSDevUserNameDirty()) {
            return null;
        }
        String string = pSDevUserSql.getPSDevUserName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserName_Default(pSDevUserSql, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserSqlId(boolean bl, PSDevUserSql pSDevUserSql, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserSql.isPSDevUserSqlIdDirty() && !bl2 : !pSDevUserSql.isPSDevUserSqlIdDirty()) {
            return null;
        }
        String string = pSDevUserSql.getPSDevUserSqlId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERSQLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserSqlId_Default(pSDevUserSql, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERSQLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserSqlName(boolean bl, PSDevUserSql pSDevUserSql, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserSql.isPSDevUserSqlNameDirty() && !bl2 : !pSDevUserSql.isPSDevUserSqlNameDirty()) {
            return null;
        }
        String string = pSDevUserSql.getPSDevUserSqlName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERSQLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserSqlName_Default(pSDevUserSql, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERSQLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevUserSql pSDevUserSql, boolean bl) throws Exception {
        super.onSyncEntity(pSDevUserSql, bl);
    }

    protected void onSyncIndexEntities(PSDevUserSql pSDevUserSql, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevUserSql, bl);
    }

    public Object getDataContextValue(PSDevUserSql pSDevUserSql, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevUserSql, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevUserSql pSDevUserSql, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevUserSql, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERSQLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserSqlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERSQLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserSqlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILETYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserSqlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERSQLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserSqlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERSQLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDevUserSql pSDevUserSql) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevUserSql)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevUserSql pSDevUserSql) throws Exception {
        super.onUpdateParent(pSDevUserSql);
    }

    @Override
    protected void exportCurXmlModel(PSDevUserSql pSDevUserSql, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVUSERSQL");
        if (!bl) {
            pSDevUserSql.setCreateDate(null);
            pSDevUserSql.setCreateMan(null);
            pSDevUserSql.setPSDevUserSqlId(null);
            pSDevUserSql.setUpdateDate(null);
            pSDevUserSql.setUpdateMan(null);
            super.exportCurXmlModel(pSDevUserSql, xmlNode, bl);
        }
    }
}

