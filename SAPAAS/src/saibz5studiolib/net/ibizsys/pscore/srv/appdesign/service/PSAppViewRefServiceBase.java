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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppViewRefDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewRefDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewRef;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewRefServiceBase
extends PSCoreSysServiceBase<PSAppViewRef> {
    private static final Log log = LogFactory.getLog(PSAppViewRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppViewRefDEModel pSAppViewRefDEModel;
    private PSAppViewRefDAO pSAppViewRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppViewRefService";
    }

    public PSAppViewRefDEModel getPSAppViewRefDEModel() {
        if (this.pSAppViewRefDEModel == null) {
            try {
                this.pSAppViewRefDEModel = (PSAppViewRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppViewRefDEModel();
    }

    public PSAppViewRefDAO getPSAppViewRefDAO() {
        if (this.pSAppViewRefDAO == null) {
            try {
                this.pSAppViewRefDAO = (PSAppViewRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppViewRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppViewRefDAO();
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

    protected void onFillParentInfo(PSAppViewRef pSAppViewRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEWREF_PSAPPVIEW_MAJORPSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppView);
            } else {
                iService.get(pSAppView);
            }
            this.onFillParentInfo_MajorPSAppView(pSAppViewRef, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEWREF_PSAPPVIEW_MINORPSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppView);
            } else {
                iService.get(pSAppView);
            }
            this.onFillParentInfo_MinorPSAppView(pSAppViewRef, pSAppView);
            return;
        }
        super.onFillParentInfo(pSAppViewRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_MajorPSAppView(PSAppViewRef pSAppViewRef, PSAppView pSAppView) throws Exception {
        pSAppViewRef.setMajorPSAppViewId(pSAppView.getPSAppViewId());
        pSAppViewRef.setMajorPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_MinorPSAppView(PSAppViewRef pSAppViewRef, PSAppView pSAppView) throws Exception {
        pSAppViewRef.setMinorPSAppViewId(pSAppView.getPSAppViewId());
        pSAppViewRef.setMinorPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillEntityFullInfo(PSAppViewRef pSAppViewRef, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSAppViewRef, bl);
        this.onFillEntityFullInfo_MajorPSAppView(pSAppViewRef, bl);
        this.onFillEntityFullInfo_MinorPSAppView(pSAppViewRef, bl);
    }

    protected void onFillEntityFullInfo_MajorPSAppView(PSAppViewRef pSAppViewRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorPSAppView(PSAppViewRef pSAppViewRef, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppViewRef pSAppViewRef, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppViewRef, bl);
    }

    public ArrayList<PSAppViewRef> selectByMajorPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByMajorPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSAppViewRef> selectByMajorPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByMajorPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSAppViewRef> selectByMajorPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppViewRef> selectByMinorPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByMinorPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSAppViewRef> selectByMinorPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByMinorPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSAppViewRef> selectByMinorPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByMajorPSAppView(PSAppView pSAppView) throws Exception {
    }

    public void resetMajorPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppViewRef> arrayList = this.selectByMajorPSAppView(pSAppView);
        for (PSAppViewRef pSAppViewRef : arrayList) {
            PSAppViewRef pSAppViewRef2 = (PSAppViewRef)this.getDEModel().createEntity();
            pSAppViewRef2.setPSAppViewRefId(pSAppViewRef.getPSAppViewRefId());
            pSAppViewRef2.setMajorPSAppViewId(null);
            this.update(pSAppViewRef2);
        }
    }

    public void removeByMajorPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewRefServiceBase.this.onBeforeRemoveByMajorPSAppView(pSAppView2);
                PSAppViewRefServiceBase.this.internalRemoveByMajorPSAppView(pSAppView2);
                PSAppViewRefServiceBase.this.onAfterRemoveByMajorPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByMajorPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppViewRef> arrayList = this.selectByMajorPSAppView(pSAppView);
        this.onBeforeRemoveByMajorPSAppView(pSAppView, arrayList);
        for (PSAppViewRef pSAppViewRef : arrayList) {
            this.remove(pSAppViewRef);
        }
        this.onAfterRemoveByMajorPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByMajorPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSAppView(PSAppView pSAppView, ArrayList<PSAppViewRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSAppView(PSAppView pSAppView, ArrayList<PSAppViewRef> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppViewRef> arrayList = this.selectByMinorPSAppView(pSAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEWREF_PSAPPVIEW_MINORPSAPPVIEWID", "", iDataEntityModel.getName(), "PSAPPVIEWREF", iDataEntityModel.getDataInfo(pSAppView), arrayList.get(0)));
        }
    }

    public void resetMinorPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppViewRef> arrayList = this.selectByMinorPSAppView(pSAppView);
        for (PSAppViewRef pSAppViewRef : arrayList) {
            PSAppViewRef pSAppViewRef2 = (PSAppViewRef)this.getDEModel().createEntity();
            pSAppViewRef2.setPSAppViewRefId(pSAppViewRef.getPSAppViewRefId());
            pSAppViewRef2.setMinorPSAppViewId(null);
            this.update(pSAppViewRef2);
        }
    }

    public void removeByMinorPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewRefServiceBase.this.onBeforeRemoveByMinorPSAppView(pSAppView2);
                PSAppViewRefServiceBase.this.internalRemoveByMinorPSAppView(pSAppView2);
                PSAppViewRefServiceBase.this.onAfterRemoveByMinorPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByMinorPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppViewRef> arrayList = this.selectByMinorPSAppView(pSAppView);
        this.onBeforeRemoveByMinorPSAppView(pSAppView, arrayList);
        for (PSAppViewRef pSAppViewRef : arrayList) {
            this.remove(pSAppViewRef);
        }
        this.onAfterRemoveByMinorPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByMinorPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSAppView(PSAppView pSAppView, ArrayList<PSAppViewRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSAppView(PSAppView pSAppView, ArrayList<PSAppViewRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppViewRef pSAppViewRef) throws Exception {
        super.onBeforeRemove(pSAppViewRef);
    }

    protected void replaceParentInfo(PSAppViewRef pSAppViewRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppViewRef, cloneSession);
        if (pSAppViewRef.getMajorPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSAppViewRef.getMajorPSAppViewId())) != null) {
            this.onFillParentInfo_MajorPSAppView(pSAppViewRef, (PSAppView)iEntity);
        }
        if (pSAppViewRef.getMinorPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSAppViewRef.getMinorPSAppViewId())) != null) {
            this.onFillParentInfo_MinorPSAppView(pSAppViewRef, (PSAppView)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppViewRef pSAppViewRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppViewRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppViewRef pSAppViewRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_MajorPSAppViewId(bl, pSAppViewRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSAppViewId(bl, pSAppViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenMode(bl, pSAppViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewRefId(bl, pSAppViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewRefName(bl, pSAppViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefModeText(bl, pSAppViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppViewRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_MajorPSAppViewId(boolean bl, PSAppViewRef pSAppViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewRef.isMajorPSAppViewIdDirty() && !bl2 : !pSAppViewRef.isMajorPSAppViewIdDirty()) {
            return null;
        }
        String string = pSAppViewRef.getMajorPSAppViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSAPPVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSAppViewId_Default(pSAppViewRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppViewRef pSAppViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewRef.isMemoDirty() : !pSAppViewRef.isMemoDirty()) {
            return null;
        }
        String string = pSAppViewRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppViewRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSAppViewId(boolean bl, PSAppViewRef pSAppViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewRef.isMinorPSAppViewIdDirty() : !pSAppViewRef.isMinorPSAppViewIdDirty()) {
            return null;
        }
        String string = pSAppViewRef.getMinorPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSAppViewId_Default(pSAppViewRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenMode(boolean bl, PSAppViewRef pSAppViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewRef.isOpenModeDirty() : !pSAppViewRef.isOpenModeDirty()) {
            return null;
        }
        String string = pSAppViewRef.getOpenMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenMode_Default(pSAppViewRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewRefId(boolean bl, PSAppViewRef pSAppViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewRef.isPSAppViewRefIdDirty() && !bl2 : !pSAppViewRef.isPSAppViewRefIdDirty()) {
            return null;
        }
        String string = pSAppViewRef.getPSAppViewRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewRefId_Default(pSAppViewRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewRefName(boolean bl, PSAppViewRef pSAppViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewRef.isPSAppViewRefNameDirty() && !bl2 : !pSAppViewRef.isPSAppViewRefNameDirty()) {
            return null;
        }
        String string = pSAppViewRef.getPSAppViewRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewRefName_Default(pSAppViewRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefModeText(boolean bl, PSAppViewRef pSAppViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewRef.isRefModeTextDirty() : !pSAppViewRef.isRefModeTextDirty()) {
            return null;
        }
        String string = pSAppViewRef.getRefModeText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefModeText_Default(pSAppViewRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSAppViewRef pSAppViewRef, boolean bl) throws Exception {
        super.onSyncEntity(pSAppViewRef, bl);
    }

    protected void onSyncIndexEntities(PSAppViewRef pSAppViewRef, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppViewRef, bl);
    }

    public Object getDataContextValue(PSAppViewRef pSAppViewRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppViewRef, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSAppViewRef pSAppViewRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppViewRef, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefModeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_MajorPSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
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

    protected String onTestValueRule_MinorPSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefModeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODETEXT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSAppViewRef pSAppViewRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppViewRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppViewRef pSAppViewRef) throws Exception {
        super.onUpdateParent(pSAppViewRef);
    }

    @Override
    protected void exportCurXmlModel(PSAppViewRef pSAppViewRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPVIEWREF");
        if (!bl) {
            pSAppViewRef.setCreateDate(null);
            pSAppViewRef.setCreateMan(null);
            pSAppViewRef.setPSAppViewRefId(null);
            pSAppViewRef.setUpdateDate(null);
            pSAppViewRef.setUpdateMan(null);
            super.exportCurXmlModel(pSAppViewRef, xmlNode, bl);
        }
    }
}

