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
import net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCat;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCatBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdServiceBase
extends PSCoreSysServiceBase<PSCorePrd> {
    private static final Log log = LogFactory.getLog(PSCorePrdServiceBase.class);
    public static final String DATASET_CURCAT = "CurCat";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCorePrdDEModel pSCorePrdDEModel;
    private PSCorePrdDAO pSCorePrdDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService";
    }

    public PSCorePrdDEModel getPSCorePrdDEModel() {
        if (this.pSCorePrdDEModel == null) {
            try {
                this.pSCorePrdDEModel = (PSCorePrdDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCorePrdDEModel();
    }

    public PSCorePrdDAO getPSCorePrdDAO() {
        if (this.pSCorePrdDAO == null) {
            try {
                this.pSCorePrdDAO = (PSCorePrdDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCorePrdDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURCAT, (boolean)true) == 0) {
            return this.fetchCurCat(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurCat(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURCAT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSCorePrd pSCorePrd, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRD_PSCOREPRDCAT_PSCOREPRDCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService", (SessionFactory)this.getSessionFactory());
            PSCorePrdCat pSCorePrdCat = (PSCorePrdCat)iService.getDEModel().createEntity();
            pSCorePrdCat.set("PSCOREPRDCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCorePrdCat);
            } else {
                iService.get(pSCorePrdCat);
            }
            this.onFillParentInfo_PSCorePrdCat(pSCorePrd, pSCorePrdCat);
            return;
        }
        super.onFillParentInfo(pSCorePrd, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCorePrdCat(PSCorePrd pSCorePrd, PSCorePrdCat pSCorePrdCat) throws Exception {
        pSCorePrd.setPSCorePrdCatId(pSCorePrdCat.getPSCorePrdCatId());
        pSCorePrd.setPSCorePrdCatName(pSCorePrdCat.getPSCorePrdCatName());
        pSCorePrd.setPSCorePrdCatPath(pSCorePrdCat.getPath());
    }

    protected void onFillEntityFullInfo(PSCorePrd pSCorePrd, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSCorePrd, bl);
        this.onFillEntityFullInfo_PSCorePrdCat(pSCorePrd, bl);
    }

    protected void onFillEntityFullInfo_PSCorePrdCat(PSCorePrd pSCorePrd, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSCorePrd pSCorePrd, boolean bl) throws Exception {
        super.onWriteBackParent(pSCorePrd, bl);
    }

    public ArrayList<PSCorePrd> selectByPSCorePrdCat(PSCorePrdCatBase pSCorePrdCatBase) throws Exception {
        return this.selectByPSCorePrdCat(pSCorePrdCatBase, "", -1);
    }

    public ArrayList<PSCorePrd> selectByPSCorePrdCat(PSCorePrdCatBase pSCorePrdCatBase, String string) throws Exception {
        return this.selectByPSCorePrdCat(pSCorePrdCatBase, string, -1);
    }

    public ArrayList<PSCorePrd> selectByPSCorePrdCat(PSCorePrdCatBase pSCorePrdCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDCATID", (Object)pSCorePrdCatBase.getPSCorePrdCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdCatCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        ArrayList<PSCorePrd> arrayList = this.selectByPSCorePrdCat(pSCorePrdCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCOREPRDCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCorePrdCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCOREPRD_PSCOREPRDCAT_PSCOREPRDCATID", "", iDataEntityModel.getName(), "PSCOREPRD", iDataEntityModel.getDataInfo(pSCorePrdCat), arrayList.get(0)));
        }
    }

    public void resetPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        ArrayList<PSCorePrd> arrayList = this.selectByPSCorePrdCat(pSCorePrdCat);
        for (PSCorePrd pSCorePrd : arrayList) {
            PSCorePrd pSCorePrd2 = (PSCorePrd)this.getDEModel().createEntity();
            pSCorePrd2.setPSCorePrdId(pSCorePrd.getPSCorePrdId());
            pSCorePrd2.setPSCorePrdCatId(null);
            this.update(pSCorePrd2);
        }
    }

    public void removeByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        final PSCorePrdCat pSCorePrdCat2 = pSCorePrdCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdServiceBase.this.onBeforeRemoveByPSCorePrdCat(pSCorePrdCat2);
                PSCorePrdServiceBase.this.internalRemoveByPSCorePrdCat(pSCorePrdCat2);
                PSCorePrdServiceBase.this.onAfterRemoveByPSCorePrdCat(pSCorePrdCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
    }

    protected void internalRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        ArrayList<PSCorePrd> arrayList = this.selectByPSCorePrdCat(pSCorePrdCat);
        this.onBeforeRemoveByPSCorePrdCat(pSCorePrdCat, arrayList);
        for (PSCorePrd pSCorePrd : arrayList) {
            this.remove(pSCorePrd);
        }
        this.onAfterRemoveByPSCorePrdCat(pSCorePrdCat, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat, ArrayList<PSCorePrd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat, ArrayList<PSCorePrd> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCorePrd pSCorePrd) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCorePrdFuncService)ServiceGlobal.getService(PSCorePrdFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSCorePrdFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrd(pSCorePrd);
        ((PSCorePrdFuncServiceBase)pSCoreSysServiceBase).removeByPSCorePrd(pSCorePrd);
        pSCoreSysServiceBase = (PSCorePrdIssueService)ServiceGlobal.getService(PSCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSCorePrdIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrd(pSCorePrd);
        ((PSCorePrdIssueServiceBase)pSCoreSysServiceBase).removeByPSCorePrd(pSCorePrd);
        pSCoreSysServiceBase = (PSCorePrdVerService)ServiceGlobal.getService(PSCorePrdVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSCorePrdVerServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrd(pSCorePrd);
        super.onBeforeRemove(pSCorePrd);
    }

    protected void replaceParentInfo(PSCorePrd pSCorePrd, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCorePrd, cloneSession);
        if (pSCorePrd.getPSCorePrdCatId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDCAT", (Object)pSCorePrd.getPSCorePrdCatId())) != null) {
            this.onFillParentInfo_PSCorePrdCat(pSCorePrd, (PSCorePrdCat)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCorePrd pSCorePrd, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCorePrd, bl);
    }

    protected void onCheckEntity(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AvatarUrl(bl, pSCorePrd, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Category(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChangeLog(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CurrentVersion(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullName(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullPath(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpUrlToRepo(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Info(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Path(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgFolder(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrdSN(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrdTag(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrdTag2(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdCatId(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdId(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdName(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Settings(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SettingUrl(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Vers(bl, pSCorePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCorePrd, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AvatarUrl(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isAvatarUrlDirty() : !pSCorePrd.isAvatarUrlDirty()) {
            return null;
        }
        String string = pSCorePrd.getAvatarUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AvatarUrl_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_Category(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isCategoryDirty() : !pSCorePrd.isCategoryDirty()) {
            return null;
        }
        String string = pSCorePrd.getCategory();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Category_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_ChangeLog(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isChangeLogDirty() : !pSCorePrd.isChangeLogDirty()) {
            return null;
        }
        String string = pSCorePrd.getChangeLog();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChangeLog_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_CurrentVersion(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isCurrentVersionDirty() : !pSCorePrd.isCurrentVersionDirty()) {
            return null;
        }
        String string = pSCorePrd.getCurrentVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CurrentVersion_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_FullName(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isFullNameDirty() : !pSCorePrd.isFullNameDirty()) {
            return null;
        }
        String string = pSCorePrd.getFullName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullName_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_FullPath(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isFullPathDirty() : !pSCorePrd.isFullPathDirty()) {
            return null;
        }
        String string = pSCorePrd.getFullPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullPath_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_HttpUrlToRepo(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isHttpUrlToRepoDirty() : !pSCorePrd.isHttpUrlToRepoDirty()) {
            return null;
        }
        String string = pSCorePrd.getHttpUrlToRepo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HttpUrlToRepo_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_Info(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isInfoDirty() : !pSCorePrd.isInfoDirty()) {
            return null;
        }
        String string = pSCorePrd.getInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Info_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isMemoDirty() : !pSCorePrd.isMemoDirty()) {
            return null;
        }
        String string = pSCorePrd.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_Path(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isPathDirty() : !pSCorePrd.isPathDirty()) {
            return null;
        }
        String string = pSCorePrd.getPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Path_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgFolder(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isPkgFolderDirty() : !pSCorePrd.isPkgFolderDirty()) {
            return null;
        }
        String string = pSCorePrd.getPkgFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgFolder_Default(pSCorePrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrdSN(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isPrdSNDirty() : !pSCorePrd.isPrdSNDirty()) {
            return null;
        }
        String string = pSCorePrd.getPrdSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrdSN_Default(pSCorePrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRDSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrdTag(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isPrdTagDirty() : !pSCorePrd.isPrdTagDirty()) {
            return null;
        }
        String string = pSCorePrd.getPrdTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrdTag_Default(pSCorePrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrdTag2(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isPrdTag2Dirty() : !pSCorePrd.isPrdTag2Dirty()) {
            return null;
        }
        String string = pSCorePrd.getPrdTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrdTag2_Default(pSCorePrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdCatId(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isPSCorePrdCatIdDirty() : !pSCorePrd.isPSCorePrdCatIdDirty()) {
            return null;
        }
        String string = pSCorePrd.getPSCorePrdCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdCatId_Default(pSCorePrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdId(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isPSCorePrdIdDirty() && !bl2 : !pSCorePrd.isPSCorePrdIdDirty()) {
            return null;
        }
        String string = pSCorePrd.getPSCorePrdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdId_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdName(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isPSCorePrdNameDirty() && !bl2 : !pSCorePrd.isPSCorePrdNameDirty()) {
            return null;
        }
        String string = pSCorePrd.getPSCorePrdName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdName_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_Settings(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isSettingsDirty() : !pSCorePrd.isSettingsDirty()) {
            return null;
        }
        String string = pSCorePrd.getSettings();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Settings_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_SettingUrl(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isSettingUrlDirty() : !pSCorePrd.isSettingUrlDirty()) {
            return null;
        }
        String string = pSCorePrd.getSettingUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SettingUrl_Default(pSCorePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_Vers(boolean bl, PSCorePrd pSCorePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrd.isVersDirty() : !pSCorePrd.isVersDirty()) {
            return null;
        }
        String string = pSCorePrd.getVers();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Vers_Default(pSCorePrd, bl2, bl3);
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

    protected void onSyncEntity(PSCorePrd pSCorePrd, boolean bl) throws Exception {
        super.onSyncEntity(pSCorePrd, bl);
    }

    protected void onSyncIndexEntities(PSCorePrd pSCorePrd, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCorePrd, bl);
    }

    public Object getDataContextValue(PSCorePrd pSCorePrd, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCorePrd, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSCorePrd pSCorePrd, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCorePrd, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"HTTPURLTOREPO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpUrlToRepo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Info_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Path_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRDSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrdSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrdTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrdTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDCATPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdCatPath_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PkgFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGFOLDER", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrdSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRDSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrdTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRDTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrdTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRDTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdCatPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDCATPATH", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCorePrd pSCorePrd) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCorePrd)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCorePrd pSCorePrd) throws Exception {
        super.onUpdateParent(pSCorePrd);
    }

    @Override
    protected void exportCurXmlModel(PSCorePrd pSCorePrd, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCOREPRD");
        if (!bl) {
            pSCorePrd.setCreateDate(null);
            pSCorePrd.setCreateMan(null);
            pSCorePrd.setPSCorePrdCatName(null);
            pSCorePrd.setUpdateDate(null);
            pSCorePrd.setUpdateMan(null);
            super.exportCurXmlModel(pSCorePrd, xmlNode, bl);
        }
    }
}

