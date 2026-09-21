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
import net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdCatDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdCatDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCat;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCatBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdCatServiceBase
extends PSCoreSysServiceBase<PSCorePrdCat> {
    private static final Log log = LogFactory.getLog(PSCorePrdCatServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCorePrdCatDEModel pSCorePrdCatDEModel;
    private PSCorePrdCatDAO pSCorePrdCatDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService";
    }

    public PSCorePrdCatDEModel getPSCorePrdCatDEModel() {
        if (this.pSCorePrdCatDEModel == null) {
            try {
                this.pSCorePrdCatDEModel = (PSCorePrdCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdCatDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCorePrdCatDEModel();
    }

    public PSCorePrdCatDAO getPSCorePrdCatDAO() {
        if (this.pSCorePrdCatDAO == null) {
            try {
                this.pSCorePrdCatDAO = (PSCorePrdCatDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdCatDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdCatDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCorePrdCatDAO();
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

    protected void onFillParentInfo(PSCorePrdCat pSCorePrdCat, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDCAT_PSCOREPRDCAT_PPSCOREPRDCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService", (SessionFactory)this.getSessionFactory());
            PSCorePrdCat pSCorePrdCat2 = (PSCorePrdCat)iService.getDEModel().createEntity();
            pSCorePrdCat2.set("PSCOREPRDCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrdCat2);
            } else {
                iService.get((IEntity)pSCorePrdCat2);
            }
            this.onFillParentInfo_PPSCorePrdCat(pSCorePrdCat, pSCorePrdCat2);
            return;
        }
        super.onFillParentInfo((IEntity)pSCorePrdCat, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSCorePrdCat(PSCorePrdCat pSCorePrdCat, PSCorePrdCat pSCorePrdCat2) throws Exception {
        pSCorePrdCat.setPPSCorePrdCatId(pSCorePrdCat2.getPSCorePrdCatId());
        pSCorePrdCat.setPPSCorePrdCatName(pSCorePrdCat2.getPSCorePrdCatName());
    }

    protected void onFillEntityFullInfo(PSCorePrdCat pSCorePrdCat, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSCorePrdCat, bl);
        this.onFillEntityFullInfo_PPSCorePrdCat(pSCorePrdCat, bl);
    }

    protected void onFillEntityFullInfo_PPSCorePrdCat(PSCorePrdCat pSCorePrdCat, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSCorePrdCat pSCorePrdCat, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSCorePrdCat, bl);
    }

    public ArrayList<PSCorePrdCat> selectByPPSCorePrdCat(PSCorePrdCatBase pSCorePrdCatBase) throws Exception {
        return this.selectByPPSCorePrdCat(pSCorePrdCatBase, "", -1);
    }

    public ArrayList<PSCorePrdCat> selectByPPSCorePrdCat(PSCorePrdCatBase pSCorePrdCatBase, String string) throws Exception {
        return this.selectByPPSCorePrdCat(pSCorePrdCatBase, string, -1);
    }

    public ArrayList<PSCorePrdCat> selectByPPSCorePrdCat(PSCorePrdCatBase pSCorePrdCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSCOREPRDCATID", (Object)pSCorePrdCatBase.getPSCorePrdCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSCorePrdCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSCorePrdCatCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        ArrayList<PSCorePrdCat> arrayList = this.selectByPPSCorePrdCat(pSCorePrdCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCOREPRDCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCorePrdCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCOREPRDCAT_PSCOREPRDCAT_PPSCOREPRDCATID", "", iDataEntityModel.getName(), "PSCOREPRDCAT", iDataEntityModel.getDataInfo((IEntity)pSCorePrdCat), arrayList.get(0)));
        }
    }

    public void resetPPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        ArrayList<PSCorePrdCat> arrayList = this.selectByPPSCorePrdCat(pSCorePrdCat);
        for (PSCorePrdCat pSCorePrdCat2 : arrayList) {
            PSCorePrdCat pSCorePrdCat3 = (PSCorePrdCat)this.getDEModel().createEntity();
            pSCorePrdCat3.setPSCorePrdCatId(pSCorePrdCat2.getPSCorePrdCatId());
            pSCorePrdCat3.setPPSCorePrdCatId(null);
            this.update(pSCorePrdCat3);
        }
    }

    public void removeByPPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        final PSCorePrdCat pSCorePrdCat2 = pSCorePrdCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdCatServiceBase.this.onBeforeRemoveByPPSCorePrdCat(pSCorePrdCat2);
                PSCorePrdCatServiceBase.this.internalRemoveByPPSCorePrdCat(pSCorePrdCat2);
                PSCorePrdCatServiceBase.this.onAfterRemoveByPPSCorePrdCat(pSCorePrdCat2);
            }
        });
    }

    protected void onBeforeRemoveByPPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
    }

    protected void internalRemoveByPPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        ArrayList<PSCorePrdCat> arrayList = this.selectByPPSCorePrdCat(pSCorePrdCat);
        this.onBeforeRemoveByPPSCorePrdCat(pSCorePrdCat, arrayList);
        for (PSCorePrdCat pSCorePrdCat2 : arrayList) {
            this.remove((IEntity)pSCorePrdCat2);
        }
        this.onAfterRemoveByPPSCorePrdCat(pSCorePrdCat, arrayList);
    }

    protected void onAfterRemoveByPPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
    }

    protected void onBeforeRemoveByPPSCorePrdCat(PSCorePrdCat pSCorePrdCat, ArrayList<PSCorePrdCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSCorePrdCat(PSCorePrdCat pSCorePrdCat, ArrayList<PSCorePrdCat> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCorePrdCat pSCorePrdCat) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCorePrdCatService)ServiceGlobal.getService(PSCorePrdCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSCorePrdCatServiceBase)pSCoreSysServiceBase).testRemoveByPPSCorePrdCat(pSCorePrdCat);
        pSCoreSysServiceBase = (PSCorePrdService)ServiceGlobal.getService(PSCorePrdService.class, (SessionFactory)this.getSessionFactory());
        ((PSCorePrdServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrdCat(pSCorePrdCat);
        pSCoreSysServiceBase = (PSDCCorePrdIssueService)ServiceGlobal.getService(PSDCCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCCorePrdIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrdCat(pSCorePrdCat);
        ((PSDCCorePrdIssueServiceBase)pSCoreSysServiceBase).resetPSCorePrdCat(pSCorePrdCat);
        super.onBeforeRemove(pSCorePrdCat);
    }

    protected void replaceParentInfo(PSCorePrdCat pSCorePrdCat, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSCorePrdCat, cloneSession);
        if (pSCorePrdCat.getPPSCorePrdCatId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDCAT", (Object)pSCorePrdCat.getPPSCorePrdCatId())) != null) {
            this.onFillParentInfo_PPSCorePrdCat(pSCorePrdCat, (PSCorePrdCat)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCorePrdCat pSCorePrdCat, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSCorePrdCat, bl);
    }

    protected void onCheckEntity(boolean bl, PSCorePrdCat pSCorePrdCat, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AvatarUrl(bl, pSCorePrdCat, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullName(bl, pSCorePrdCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullPath(bl, pSCorePrdCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCorePrdCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Path(bl, pSCorePrdCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSCorePrdCatId(bl, pSCorePrdCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdCatId(bl, pSCorePrdCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdCatName(bl, pSCorePrdCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSCorePrdCat, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AvatarUrl(boolean bl, PSCorePrdCat pSCorePrdCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdCat.isAvatarUrlDirty() : !pSCorePrdCat.isAvatarUrlDirty()) {
            return null;
        }
        String string = pSCorePrdCat.getAvatarUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AvatarUrl_Default((IEntity)pSCorePrdCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_FullName(boolean bl, PSCorePrdCat pSCorePrdCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdCat.isFullNameDirty() : !pSCorePrdCat.isFullNameDirty()) {
            return null;
        }
        String string = pSCorePrdCat.getFullName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullName_Default((IEntity)pSCorePrdCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_FullPath(boolean bl, PSCorePrdCat pSCorePrdCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdCat.isFullPathDirty() : !pSCorePrdCat.isFullPathDirty()) {
            return null;
        }
        String string = pSCorePrdCat.getFullPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullPath_Default((IEntity)pSCorePrdCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCorePrdCat pSCorePrdCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdCat.isMemoDirty() : !pSCorePrdCat.isMemoDirty()) {
            return null;
        }
        String string = pSCorePrdCat.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSCorePrdCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_Path(boolean bl, PSCorePrdCat pSCorePrdCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdCat.isPathDirty() : !pSCorePrdCat.isPathDirty()) {
            return null;
        }
        String string = pSCorePrdCat.getPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Path_Default((IEntity)pSCorePrdCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSCorePrdCatId(boolean bl, PSCorePrdCat pSCorePrdCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdCat.isPPSCorePrdCatIdDirty() : !pSCorePrdCat.isPPSCorePrdCatIdDirty()) {
            return null;
        }
        String string = pSCorePrdCat.getPPSCorePrdCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSCorePrdCatId_Default((IEntity)pSCorePrdCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSCOREPRDCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdCatId(boolean bl, PSCorePrdCat pSCorePrdCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdCat.isPSCorePrdCatIdDirty() && !bl2 : !pSCorePrdCat.isPSCorePrdCatIdDirty()) {
            return null;
        }
        String string = pSCorePrdCat.getPSCorePrdCatId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDCATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdCatId_Default((IEntity)pSCorePrdCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdCatName(boolean bl, PSCorePrdCat pSCorePrdCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdCat.isPSCorePrdCatNameDirty() && !bl2 : !pSCorePrdCat.isPSCorePrdCatNameDirty()) {
            return null;
        }
        String string = pSCorePrdCat.getPSCorePrdCatName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDCATNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdCatName_Default((IEntity)pSCorePrdCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDCATNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCorePrdCat pSCorePrdCat, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSCorePrdCat, bl);
    }

    protected void onSyncIndexEntities(PSCorePrdCat pSCorePrdCat, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSCorePrdCat, bl);
    }

    public Object getDataContextValue(PSCorePrdCat pSCorePrdCat, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSCorePrdCat, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSCorePrdCat pSCorePrdCat, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSCorePrdCat, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AVATARURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AvatarUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Path_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSCOREPRDCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSCorePrdCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSCOREPRDCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSCorePrdCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PPSCorePrdCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSCOREPRDCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSCorePrdCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSCOREPRDCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCorePrdCat pSCorePrdCat) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSCorePrdCat)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCorePrdCat pSCorePrdCat) throws Exception {
        super.onUpdateParent((IEntity)pSCorePrdCat);
    }

    @Override
    protected void exportCurXmlModel(PSCorePrdCat pSCorePrdCat, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCOREPRDCAT");
        if (!bl) {
            pSCorePrdCat.setCreateDate(null);
            pSCorePrdCat.setCreateMan(null);
            pSCorePrdCat.setUpdateDate(null);
            pSCorePrdCat.setUpdateMan(null);
            super.exportCurXmlModel(pSCorePrdCat, xmlNode, bl);
        }
    }
}

