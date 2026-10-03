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
package net.ibizsys.pscore.srv.paasmgr.service;

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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdFuncDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdFuncDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFunc;
import net.ibizsys.pscore.srv.paasmgr.service.PSCPVFuncService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCPVFuncServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdFuncServiceBase
extends PSCoreSysServiceBase<PSCorePrdFunc> {
    private static final Log log = LogFactory.getLog(PSCorePrdFuncServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCorePrdFuncDEModel pSCorePrdFuncDEModel;
    private PSCorePrdFuncDAO pSCorePrdFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService";
    }

    public PSCorePrdFuncDEModel getPSCorePrdFuncDEModel() {
        if (this.pSCorePrdFuncDEModel == null) {
            try {
                this.pSCorePrdFuncDEModel = (PSCorePrdFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCorePrdFuncDEModel();
    }

    public PSCorePrdFuncDAO getPSCorePrdFuncDAO() {
        if (this.pSCorePrdFuncDAO == null) {
            try {
                this.pSCorePrdFuncDAO = (PSCorePrdFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCorePrdFuncDAO();
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

    protected void onFillParentInfo(PSCorePrdFunc pSCorePrdFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDFUNC_PSCOREPRD_PSCOREPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService", (SessionFactory)this.getSessionFactory());
            PSCorePrd pSCorePrd = (PSCorePrd)iService.getDEModel().createEntity();
            pSCorePrd.set("PSCOREPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCorePrd);
            } else {
                iService.get(pSCorePrd);
            }
            this.onFillParentInfo_PSCorePrd(pSCorePrdFunc, pSCorePrd);
            return;
        }
        super.onFillParentInfo(pSCorePrdFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCorePrd(PSCorePrdFunc pSCorePrdFunc, PSCorePrd pSCorePrd) throws Exception {
        pSCorePrdFunc.setPSCorePrdId(pSCorePrd.getPSCorePrdId());
        pSCorePrdFunc.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
    }

    protected void onFillEntityFullInfo(PSCorePrdFunc pSCorePrdFunc, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSCorePrdFunc, bl);
        this.onFillEntityFullInfo_PSCorePrd(pSCorePrdFunc, bl);
    }

    protected void onFillEntityFullInfo_PSCorePrd(PSCorePrdFunc pSCorePrdFunc, boolean bl) throws Exception {
        if (pSCorePrdFunc.isPSCorePrdIdDirty()) {
            if (pSCorePrdFunc.getPSCorePrdId() != null) {
                if (pSCorePrdFunc.getPSCorePrdId() == null || pSCorePrdFunc.getPSCorePrdName() == null) {
                    PSCorePrd pSCorePrd = pSCorePrdFunc.getPSCorePrd();
                    pSCorePrdFunc.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
                }
            } else {
                pSCorePrdFunc.setPSCorePrdName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCorePrdFunc pSCorePrdFunc, boolean bl) throws Exception {
        super.onWriteBackParent(pSCorePrdFunc, bl);
    }

    public ArrayList<PSCorePrdFunc> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, "", -1);
    }

    public ArrayList<PSCorePrdFunc> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, string, -1);
    }

    public ArrayList<PSCorePrdFunc> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDID", (Object)pSCorePrdBase.getPSCorePrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    public void resetPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSCorePrdFunc> arrayList = this.selectByPSCorePrd(pSCorePrd);
        for (PSCorePrdFunc pSCorePrdFunc : arrayList) {
            PSCorePrdFunc pSCorePrdFunc2 = (PSCorePrdFunc)this.getDEModel().createEntity();
            pSCorePrdFunc2.setPSCorePrdFuncId(pSCorePrdFunc.getPSCorePrdFuncId());
            pSCorePrdFunc2.setPSCorePrdId(null);
            this.update(pSCorePrdFunc2);
        }
    }

    public void removeByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        final PSCorePrd pSCorePrd2 = pSCorePrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdFuncServiceBase.this.onBeforeRemoveByPSCorePrd(pSCorePrd2);
                PSCorePrdFuncServiceBase.this.internalRemoveByPSCorePrd(pSCorePrd2);
                PSCorePrdFuncServiceBase.this.onAfterRemoveByPSCorePrd(pSCorePrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void internalRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSCorePrdFunc> arrayList = this.selectByPSCorePrd(pSCorePrd);
        this.onBeforeRemoveByPSCorePrd(pSCorePrd, arrayList);
        for (PSCorePrdFunc pSCorePrdFunc : arrayList) {
            this.remove(pSCorePrdFunc);
        }
        this.onAfterRemoveByPSCorePrd(pSCorePrd, arrayList);
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSCorePrdFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSCorePrdFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCorePrdVerService)ServiceGlobal.getService(PSCorePrdVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSCorePrdVerServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrdFunc(pSCorePrdFunc);
        ((PSCorePrdVerServiceBase)pSCoreSysServiceBase).removeByPSCorePrdFunc(pSCorePrdFunc);
        pSCoreSysServiceBase = (PSCPVFuncService)ServiceGlobal.getService(PSCPVFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSCPVFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrdFunc(pSCorePrdFunc);
        pSCoreSysServiceBase = (PSDCCorePrdIssueService)ServiceGlobal.getService(PSDCCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCCorePrdIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrdFunc(pSCorePrdFunc);
        ((PSDCCorePrdIssueServiceBase)pSCoreSysServiceBase).resetPSCorePrdFunc(pSCorePrdFunc);
        super.onBeforeRemove(pSCorePrdFunc);
    }

    protected void replaceParentInfo(PSCorePrdFunc pSCorePrdFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCorePrdFunc, cloneSession);
        if (pSCorePrdFunc.getPSCorePrdId() != null && (iEntity = cloneSession.getEntity("PSCOREPRD", (Object)pSCorePrdFunc.getPSCorePrdId())) != null) {
            this.onFillParentInfo_PSCorePrd(pSCorePrdFunc, (PSCorePrd)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCorePrdFunc pSCorePrdFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCorePrdFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AvatarUrl(bl, pSCorePrdFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Category(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChangeLog(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CurrentVersion(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullName(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullPath(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParams(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncSN(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncState(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncTag(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncTag2(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncType(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncUrl(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpUrlToRepo(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Info(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Path(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdFuncId(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdFuncName(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdId(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdName(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Settings(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SettingUrl(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Vers(bl, pSCorePrdFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCorePrdFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AvatarUrl(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isAvatarUrlDirty() : !pSCorePrdFunc.isAvatarUrlDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getAvatarUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AvatarUrl_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AVATARURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Category(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isCategoryDirty() : !pSCorePrdFunc.isCategoryDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getCategory();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Category_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATEGORY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ChangeLog(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isChangeLogDirty() : !pSCorePrdFunc.isChangeLogDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getChangeLog();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChangeLog_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHANGELOG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CurrentVersion(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isCurrentVersionDirty() : !pSCorePrdFunc.isCurrentVersionDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getCurrentVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CurrentVersion_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURRENTVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FullName(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isFullNameDirty() : !pSCorePrdFunc.isFullNameDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getFullName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullName_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FullPath(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isFullPathDirty() : !pSCorePrdFunc.isFullPathDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getFullPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullPath_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParams(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isFuncParamsDirty() : !pSCorePrdFunc.isFuncParamsDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getFuncParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncParams_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncSN(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isFuncSNDirty() : !pSCorePrdFunc.isFuncSNDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getFuncSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncSN_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncState(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isFuncStateDirty() && !bl2 : !pSCorePrdFunc.isFuncStateDirty()) {
            return null;
        }
        Integer n = pSCorePrdFunc.getFuncState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_FuncState_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncTag(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isFuncTagDirty() : !pSCorePrdFunc.isFuncTagDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getFuncTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncTag_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncTag2(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isFuncTag2Dirty() : !pSCorePrdFunc.isFuncTag2Dirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getFuncTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncTag2_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncType(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isFuncTypeDirty() : !pSCorePrdFunc.isFuncTypeDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getFuncType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncType_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncUrl(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isFuncUrlDirty() : !pSCorePrdFunc.isFuncUrlDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getFuncUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncUrl_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpUrlToRepo(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isHttpUrlToRepoDirty() : !pSCorePrdFunc.isHttpUrlToRepoDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getHttpUrlToRepo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HttpUrlToRepo_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPURLTOREPO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Info(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isInfoDirty() : !pSCorePrdFunc.isInfoDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Info_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isMemoDirty() : !pSCorePrdFunc.isMemoDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCorePrdFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isOrderValueDirty() : !pSCorePrdFunc.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSCorePrdFunc.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Path(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isPathDirty() : !pSCorePrdFunc.isPathDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Path_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdFuncId(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isPSCorePrdFuncIdDirty() && !bl2 : !pSCorePrdFunc.isPSCorePrdFuncIdDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getPSCorePrdFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdFuncId_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdFuncName(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isPSCorePrdFuncNameDirty() && !bl2 : !pSCorePrdFunc.isPSCorePrdFuncNameDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getPSCorePrdFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdFuncName_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdId(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isPSCorePrdIdDirty() : !pSCorePrdFunc.isPSCorePrdIdDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getPSCorePrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdId_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdName(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isPSCorePrdNameDirty() && !bl2 : !pSCorePrdFunc.isPSCorePrdNameDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getPSCorePrdName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdName_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Settings(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isSettingsDirty() : !pSCorePrdFunc.isSettingsDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getSettings();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Settings_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SETTINGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SettingUrl(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isSettingUrlDirty() : !pSCorePrdFunc.isSettingUrlDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getSettingUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SettingUrl_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SETTINGURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Vers(boolean bl, PSCorePrdFunc pSCorePrdFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdFunc.isVersDirty() : !pSCorePrdFunc.isVersDirty()) {
            return null;
        }
        String string = pSCorePrdFunc.getVers();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Vers_Default(pSCorePrdFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCorePrdFunc pSCorePrdFunc, boolean bl) throws Exception {
        super.onSyncEntity(pSCorePrdFunc, bl);
    }

    protected void onSyncIndexEntities(PSCorePrdFunc pSCorePrdFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCorePrdFunc, bl);
    }

    public Object getDataContextValue(PSCorePrdFunc pSCorePrdFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCorePrdFunc, string, iDataContextParam)) != null) {
            return object;
        }
        PSCorePrd pSCorePrd = pSCorePrdFunc.getPSCorePrd();
        if (pSCorePrd != null && pSCorePrd.contains(string)) {
            return pSCorePrd.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCorePrdFunc pSCorePrdFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCorePrdFunc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AVATARURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AvatarUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CATEGORY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Category_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHANGELOG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChangeLog_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURRENTVERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CurrentVersion_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPURLTOREPO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpUrlToRepo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Info_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Path_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SETTINGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Settings_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SETTINGURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SettingUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Vers_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AvatarUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AVATARURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Category_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATEGORY", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ChangeLog_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHANGELOG", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_CurrentVersion_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CURRENTVERSION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FullName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLNAME", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FullPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLPATH", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FuncTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HttpUrlToRepo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTTPURLTOREPO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Info_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Path_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PATH", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Settings_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SETTINGS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SettingUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SETTINGURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_Vers_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSCorePrdFunc pSCorePrdFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCorePrdFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        super.onUpdateParent(pSCorePrdFunc);
    }

    @Override
    protected void exportCurXmlModel(PSCorePrdFunc pSCorePrdFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCOREPRDFUNC");
        if (!bl) {
            pSCorePrdFunc.setCreateDate(null);
            pSCorePrdFunc.setCreateMan(null);
            pSCorePrdFunc.setPSCorePrdFuncId(null);
            pSCorePrdFunc.setUpdateDate(null);
            pSCorePrdFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSCorePrdFunc, xmlNode, bl);
        }
    }
}

