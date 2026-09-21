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
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
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
package net.ibizsys.pscore.srv.sysdesign.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnCSSessionDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnCSSessionDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCSSession;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUserCS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUserCSBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnCSSessionServiceBase
extends PSCoreSysServiceBase<PSDevSlnCSSession> {
    private static final Log log = LogFactory.getLog(PSDevSlnCSSessionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnCSSessionDEModel pSDevSlnCSSessionDEModel;
    private PSDevSlnCSSessionDAO pSDevSlnCSSessionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCSSessionService";
    }

    public PSDevSlnCSSessionDEModel getPSDevSlnCSSessionDEModel() {
        if (this.pSDevSlnCSSessionDEModel == null) {
            try {
                this.pSDevSlnCSSessionDEModel = (PSDevSlnCSSessionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnCSSessionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnCSSessionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnCSSessionDEModel();
    }

    public PSDevSlnCSSessionDAO getPSDevSlnCSSessionDAO() {
        if (this.pSDevSlnCSSessionDAO == null) {
            try {
                this.pSDevSlnCSSessionDAO = (PSDevSlnCSSessionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnCSSessionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnCSSessionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnCSSessionDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevSlnCSSession pSDevSlnCSSession, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNCSSESSION_PSDEVSLNUSERCS_PSDEVSLNUSERCSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService", (SessionFactory)this.getSessionFactory());
            PSDevSlnUserCS pSDevSlnUserCS = (PSDevSlnUserCS)iService.getDEModel().createEntity();
            pSDevSlnUserCS.set("PSDEVSLNUSERCSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnUserCS);
            } else {
                iService.get((IEntity)pSDevSlnUserCS);
            }
            this.onFillParentInfo_PSDevSlnUserCS(pSDevSlnCSSession, pSDevSlnUserCS);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnCSSession, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnUserCS(PSDevSlnCSSession pSDevSlnCSSession, PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
        pSDevSlnCSSession.setPSDevSlnUserCSId(pSDevSlnUserCS.getPSDevSlnUserCSId());
        pSDevSlnCSSession.setPSDevSlnUserCSName(pSDevSlnUserCS.getPSDevSlnUserCSName());
    }

    protected void onFillEntityFullInfo(PSDevSlnCSSession pSDevSlnCSSession, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnCSSession, bl);
        this.onFillEntityFullInfo_PSDevSlnUserCS(pSDevSlnCSSession, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnUserCS(PSDevSlnCSSession pSDevSlnCSSession, boolean bl) throws Exception {
        if (pSDevSlnCSSession.isPSDevSlnUserCSIdDirty()) {
            if (pSDevSlnCSSession.getPSDevSlnUserCSId() != null) {
                if (pSDevSlnCSSession.getPSDevSlnUserCSId() == null || pSDevSlnCSSession.getPSDevSlnUserCSName() == null) {
                    PSDevSlnUserCS pSDevSlnUserCS = pSDevSlnCSSession.getPSDevSlnUserCS();
                    pSDevSlnCSSession.setPSDevSlnUserCSName(pSDevSlnUserCS.getPSDevSlnUserCSName());
                }
            } else {
                pSDevSlnCSSession.setPSDevSlnUserCSName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnCSSession pSDevSlnCSSession, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnCSSession, bl);
    }

    public ArrayList<PSDevSlnCSSession> selectByPSDevSlnUserCS(PSDevSlnUserCSBase pSDevSlnUserCSBase) throws Exception {
        return this.selectByPSDevSlnUserCS(pSDevSlnUserCSBase, "", -1);
    }

    public ArrayList<PSDevSlnCSSession> selectByPSDevSlnUserCS(PSDevSlnUserCSBase pSDevSlnUserCSBase, String string) throws Exception {
        return this.selectByPSDevSlnUserCS(pSDevSlnUserCSBase, string, -1);
    }

    public ArrayList<PSDevSlnCSSession> selectByPSDevSlnUserCS(PSDevSlnUserCSBase pSDevSlnUserCSBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNUSERCSID", (Object)pSDevSlnUserCSBase.getPSDevSlnUserCSId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnUserCSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnUserCSCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnUserCS(PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
        ArrayList<PSDevSlnCSSession> arrayList = this.selectByPSDevSlnUserCS(pSDevSlnUserCS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNUSERCS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnUserCS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNCSSESSION_PSDEVSLNUSERCS_PSDEVSLNUSERCSID", "", iDataEntityModel.getName(), "PSDEVSLNCSSESSION", iDataEntityModel.getDataInfo((IEntity)pSDevSlnUserCS), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnUserCS(PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
        ArrayList<PSDevSlnCSSession> arrayList = this.selectByPSDevSlnUserCS(pSDevSlnUserCS);
        for (PSDevSlnCSSession pSDevSlnCSSession : arrayList) {
            PSDevSlnCSSession pSDevSlnCSSession2 = (PSDevSlnCSSession)this.getDEModel().createEntity();
            pSDevSlnCSSession2.setPSDevSlnCSSessionId(pSDevSlnCSSession.getPSDevSlnCSSessionId());
            pSDevSlnCSSession2.setPSDevSlnUserCSId(null);
            this.update(pSDevSlnCSSession2);
        }
    }

    public void removeByPSDevSlnUserCS(PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
        final PSDevSlnUserCS pSDevSlnUserCS2 = pSDevSlnUserCS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnCSSessionServiceBase.this.onBeforeRemoveByPSDevSlnUserCS(pSDevSlnUserCS2);
                PSDevSlnCSSessionServiceBase.this.internalRemoveByPSDevSlnUserCS(pSDevSlnUserCS2);
                PSDevSlnCSSessionServiceBase.this.onAfterRemoveByPSDevSlnUserCS(pSDevSlnUserCS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnUserCS(PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
    }

    protected void internalRemoveByPSDevSlnUserCS(PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
        ArrayList<PSDevSlnCSSession> arrayList = this.selectByPSDevSlnUserCS(pSDevSlnUserCS);
        this.onBeforeRemoveByPSDevSlnUserCS(pSDevSlnUserCS, arrayList);
        for (PSDevSlnCSSession pSDevSlnCSSession : arrayList) {
            this.remove((IEntity)pSDevSlnCSSession);
        }
        this.onAfterRemoveByPSDevSlnUserCS(pSDevSlnUserCS, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnUserCS(PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnUserCS(PSDevSlnUserCS pSDevSlnUserCS, ArrayList<PSDevSlnCSSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnUserCS(PSDevSlnUserCS pSDevSlnUserCS, ArrayList<PSDevSlnCSSession> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnCSSession pSDevSlnCSSession) throws Exception {
        super.onBeforeRemove(pSDevSlnCSSession);
    }

    protected void replaceParentInfo(PSDevSlnCSSession pSDevSlnCSSession, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnCSSession, cloneSession);
        if (pSDevSlnCSSession.getPSDevSlnUserCSId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNUSERCS", (Object)pSDevSlnCSSession.getPSDevSlnUserCSId())) != null) {
            this.onFillParentInfo_PSDevSlnUserCS(pSDevSlnCSSession, (PSDevSlnUserCS)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnCSSession pSDevSlnCSSession, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnCSSession, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeTarget(bl, pSDevSlnCSSession, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam2(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam3(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam4(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParams(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GitPath(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GitUser(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostAddress(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostPasswd(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostPort(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostUserName(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnCSSessionId(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnCSSessionName(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnUserCSId(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnUserCSName(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadOnlyMode(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetId(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSDevSlnCSSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnCSSession, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeTarget(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isCodeTargetDirty() && !bl2 : !pSDevSlnCSSession.isCodeTargetDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getCodeTarget();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETARGET");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeTarget_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETARGET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isCSParamDirty() : !pSDevSlnCSSession.isCSParamDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getCSParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSParam_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam2(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isCSParam2Dirty() : !pSDevSlnCSSession.isCSParam2Dirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getCSParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSParam2_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam3(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isCSParam3Dirty() : !pSDevSlnCSSession.isCSParam3Dirty()) {
            return null;
        }
        Integer n = pSDevSlnCSSession.getCSParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CSParam3_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam4(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isCSParam4Dirty() : !pSDevSlnCSSession.isCSParam4Dirty()) {
            return null;
        }
        Integer n = pSDevSlnCSSession.getCSParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CSParam4_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParams(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isCSParamsDirty() : !pSDevSlnCSSession.isCSParamsDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getCSParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSParams_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isExpriedTimeDirty() : !pSDevSlnCSSession.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnCSSession.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPRIEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GitPath(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isGitPathDirty() : !pSDevSlnCSSession.isGitPathDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getGitPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GitPath_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GitUser(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isGitUserDirty() : !pSDevSlnCSSession.isGitUserDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getGitUser();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GitUser_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITUSER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostAddress(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isHostAddressDirty() : !pSDevSlnCSSession.isHostAddressDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getHostAddress();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostAddress_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTADDRESS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostPasswd(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isHostPasswdDirty() : !pSDevSlnCSSession.isHostPasswdDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getHostPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostPasswd_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostPort(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isHostPortDirty() : !pSDevSlnCSSession.isHostPortDirty()) {
            return null;
        }
        Integer n = pSDevSlnCSSession.getHostPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HostPort_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostUserName(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isHostUserNameDirty() : !pSDevSlnCSSession.isHostUserNameDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getHostUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostUserName_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isMemoDirty() : !pSDevSlnCSSession.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnCSSessionId(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isPSDevSlnCSSessionIdDirty() && !bl2 : !pSDevSlnCSSession.isPSDevSlnCSSessionIdDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getPSDevSlnCSSessionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNCSSESSIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnCSSessionId_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNCSSESSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnCSSessionName(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isPSDevSlnCSSessionNameDirty() && !bl2 : !pSDevSlnCSSession.isPSDevSlnCSSessionNameDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getPSDevSlnCSSessionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNCSSESSIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnCSSessionName_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNCSSESSIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnUserCSId(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isPSDevSlnUserCSIdDirty() : !pSDevSlnCSSession.isPSDevSlnUserCSIdDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getPSDevSlnUserCSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnUserCSId_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERCSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnUserCSName(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isPSDevSlnUserCSNameDirty() : !pSDevSlnCSSession.isPSDevSlnUserCSNameDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getPSDevSlnUserCSName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnUserCSName_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERCSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReadOnlyMode(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isReadOnlyModeDirty() && !bl2 : !pSDevSlnCSSession.isReadOnlyModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnCSSession.getReadOnlyMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ReadOnlyMode_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isResReadyTimeDirty() : !pSDevSlnCSSession.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnCSSession.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESREADYTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isResStateDirty() : !pSDevSlnCSSession.isResStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnCSSession.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetId(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isTargetIdDirty() : !pSDevSlnCSSession.isTargetIdDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getTargetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetId_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSDevSlnCSSession pSDevSlnCSSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCSSession.isWorkshopPathDirty() : !pSDevSlnCSSession.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSDevSlnCSSession.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default((IEntity)pSDevSlnCSSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKSHOPPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnCSSession pSDevSlnCSSession, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnCSSession, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnCSSession pSDevSlnCSSession, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnCSSession, bl);
    }

    public Object getDataContextValue(PSDevSlnCSSession pSDevSlnCSSession, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnCSSession, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnCSSession pSDevSlnCSSession, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnCSSession, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODETARGET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeTarget_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITUSER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitUser_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTADDRESS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostAddress_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNCSSESSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnCSSessionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNCSSESSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnCSSessionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNUSERCSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnUserCSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNUSERCSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnUserCSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READONLYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadOnlyMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSHOPPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopPath_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeTarget_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODETARGET", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_CSParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CSParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CSParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GitUser_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITUSER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HostAddress_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTADDRESS", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HostPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTPASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HostPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HostUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTUSERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnCSSessionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNCSSESSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnCSSessionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNCSSESSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnUserCSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNUSERCSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnUserCSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNUSERCSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReadOnlyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TargetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_WorkshopPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WORKSHOPPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnCSSession pSDevSlnCSSession) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnCSSession)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnCSSession pSDevSlnCSSession) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnCSSession);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnCSSession pSDevSlnCSSession, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNCSSESSION");
        if (!bl) {
            pSDevSlnCSSession.setCreateDate(null);
            pSDevSlnCSSession.setCreateMan(null);
            pSDevSlnCSSession.setPSDevSlnCSSessionId(null);
            pSDevSlnCSSession.setUpdateDate(null);
            pSDevSlnCSSession.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnCSSession, xmlNode, bl);
        }
    }
}

