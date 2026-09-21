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
package net.ibizsys.pscore.srv.sysdevstudio.service;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSModelBookmarkDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSModelBookmarkDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSModelBookmark;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSModelBookmarkBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSModelBookmarkService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelBookmarkServiceBase
extends PSCoreSysServiceBase<PSModelBookmark> {
    private static final Log log = LogFactory.getLog(PSModelBookmarkServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelBookmarkDEModel pSModelBookmarkDEModel;
    private PSModelBookmarkDAO pSModelBookmarkDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSModelBookmarkService";
    }

    public PSModelBookmarkDEModel getPSModelBookmarkDEModel() {
        if (this.pSModelBookmarkDEModel == null) {
            try {
                this.pSModelBookmarkDEModel = (PSModelBookmarkDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSModelBookmarkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelBookmarkDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelBookmarkDEModel();
    }

    public PSModelBookmarkDAO getPSModelBookmarkDAO() {
        if (this.pSModelBookmarkDAO == null) {
            try {
                this.pSModelBookmarkDAO = (PSModelBookmarkDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSModelBookmarkDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelBookmarkDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelBookmarkDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSModelBookmark pSModelBookmark, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELBOOKMARK_PSMODELBOOKMARK_PPSMODELBOOKMARKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSModelBookmarkService", (SessionFactory)this.getSessionFactory());
            PSModelBookmark pSModelBookmark2 = (PSModelBookmark)iService.getDEModel().createEntity();
            pSModelBookmark2.set("PSMODELBOOKMARKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelBookmark2);
            } else {
                iService.get((IEntity)pSModelBookmark2);
            }
            this.onFillParentInfo_PPSModelBookmark(pSModelBookmark, pSModelBookmark2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELBOOKMARK_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSModelBookmark, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSModelBookmark, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSModelBookmark(PSModelBookmark pSModelBookmark, PSModelBookmark pSModelBookmark2) throws Exception {
        pSModelBookmark.setPPSModelBookmarkId(pSModelBookmark2.getPSModelBookmarkId());
        pSModelBookmark.setPPSModelBookmarkName(pSModelBookmark2.getPSModelBookmarkName());
    }

    protected void onFillParentInfo_PSSystem(PSModelBookmark pSModelBookmark, PSSystem pSSystem) throws Exception {
        pSModelBookmark.setPSSystemId(pSSystem.getPSSystemId());
        pSModelBookmark.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSModelBookmark pSModelBookmark, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSModelBookmark, bl);
        this.onFillEntityFullInfo_PPSModelBookmark(pSModelBookmark, bl);
        this.onFillEntityFullInfo_PSSystem(pSModelBookmark, bl);
    }

    protected void onFillEntityFullInfo_PPSModelBookmark(PSModelBookmark pSModelBookmark, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSModelBookmark pSModelBookmark, boolean bl) throws Exception {
        if (pSModelBookmark.isPSSystemIdDirty()) {
            if (pSModelBookmark.getPSSystemId() != null) {
                if (pSModelBookmark.getPSSystemId() == null || pSModelBookmark.getPSSystemName() == null) {
                    PSSystem pSSystem = pSModelBookmark.getPSSystem();
                    pSModelBookmark.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSModelBookmark.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelBookmark pSModelBookmark, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSModelBookmark, bl);
    }

    public ArrayList<PSModelBookmark> selectByPPSModelBookmark(PSModelBookmarkBase pSModelBookmarkBase) throws Exception {
        return this.selectByPPSModelBookmark(pSModelBookmarkBase, "", -1);
    }

    public ArrayList<PSModelBookmark> selectByPPSModelBookmark(PSModelBookmarkBase pSModelBookmarkBase, String string) throws Exception {
        return this.selectByPPSModelBookmark(pSModelBookmarkBase, string, -1);
    }

    public ArrayList<PSModelBookmark> selectByPPSModelBookmark(PSModelBookmarkBase pSModelBookmarkBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSMODELBOOKMARKID", (Object)pSModelBookmarkBase.getPSModelBookmarkId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSModelBookmarkCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSModelBookmarkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelBookmark> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSModelBookmark> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSModelBookmark> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSModelBookmark(PSModelBookmark pSModelBookmark) throws Exception {
        ArrayList<PSModelBookmark> arrayList = this.selectByPPSModelBookmark(pSModelBookmark, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELBOOKMARK");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModelBookmark);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELBOOKMARK_PSMODELBOOKMARK_PPSMODELBOOKMARKID", "", iDataEntityModel.getName(), "PSMODELBOOKMARK", iDataEntityModel.getDataInfo((IEntity)pSModelBookmark), arrayList.get(0)));
        }
    }

    public void resetPPSModelBookmark(PSModelBookmark pSModelBookmark) throws Exception {
        ArrayList<PSModelBookmark> arrayList = this.selectByPPSModelBookmark(pSModelBookmark);
        for (PSModelBookmark pSModelBookmark2 : arrayList) {
            PSModelBookmark pSModelBookmark3 = (PSModelBookmark)this.getDEModel().createEntity();
            pSModelBookmark3.setPSModelBookmarkId(pSModelBookmark2.getPSModelBookmarkId());
            pSModelBookmark3.setPPSModelBookmarkId(null);
            this.update(pSModelBookmark3);
        }
    }

    public void removeByPPSModelBookmark(PSModelBookmark pSModelBookmark) throws Exception {
        final PSModelBookmark pSModelBookmark2 = pSModelBookmark;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelBookmarkServiceBase.this.onBeforeRemoveByPPSModelBookmark(pSModelBookmark2);
                PSModelBookmarkServiceBase.this.internalRemoveByPPSModelBookmark(pSModelBookmark2);
                PSModelBookmarkServiceBase.this.onAfterRemoveByPPSModelBookmark(pSModelBookmark2);
            }
        });
    }

    protected void onBeforeRemoveByPPSModelBookmark(PSModelBookmark pSModelBookmark) throws Exception {
    }

    protected void internalRemoveByPPSModelBookmark(PSModelBookmark pSModelBookmark) throws Exception {
        ArrayList<PSModelBookmark> arrayList = this.selectByPPSModelBookmark(pSModelBookmark);
        this.onBeforeRemoveByPPSModelBookmark(pSModelBookmark, arrayList);
        for (PSModelBookmark pSModelBookmark2 : arrayList) {
            this.remove((IEntity)pSModelBookmark2);
        }
        this.onAfterRemoveByPPSModelBookmark(pSModelBookmark, arrayList);
    }

    protected void onAfterRemoveByPPSModelBookmark(PSModelBookmark pSModelBookmark) throws Exception {
    }

    protected void onBeforeRemoveByPPSModelBookmark(PSModelBookmark pSModelBookmark, ArrayList<PSModelBookmark> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSModelBookmark(PSModelBookmark pSModelBookmark, ArrayList<PSModelBookmark> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSModelBookmark> arrayList = this.selectByPSSystem(pSSystem);
        for (PSModelBookmark pSModelBookmark : arrayList) {
            PSModelBookmark pSModelBookmark2 = (PSModelBookmark)this.getDEModel().createEntity();
            pSModelBookmark2.setPSModelBookmarkId(pSModelBookmark.getPSModelBookmarkId());
            pSModelBookmark2.setPSSystemId(null);
            this.update(pSModelBookmark2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelBookmarkServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSModelBookmarkServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSModelBookmarkServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSModelBookmark> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSModelBookmark pSModelBookmark : arrayList) {
            this.remove((IEntity)pSModelBookmark);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSModelBookmark> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSModelBookmark> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelBookmark pSModelBookmark) throws Exception {
        PSModelBookmarkService pSModelBookmarkService = (PSModelBookmarkService)ServiceGlobal.getService(PSModelBookmarkService.class, (SessionFactory)this.getSessionFactory());
        pSModelBookmarkService.testRemoveByPPSModelBookmark(pSModelBookmark);
        super.onBeforeRemove(pSModelBookmark);
    }

    protected void replaceParentInfo(PSModelBookmark pSModelBookmark, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSModelBookmark, cloneSession);
        if (pSModelBookmark.getPPSModelBookmarkId() != null && (iEntity = cloneSession.getEntity("PSMODELBOOKMARK", (Object)pSModelBookmark.getPPSModelBookmarkId())) != null) {
            this.onFillParentInfo_PPSModelBookmark(pSModelBookmark, (PSModelBookmark)iEntity);
        }
        if (pSModelBookmark.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSModelBookmark.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSModelBookmark, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelBookmark pSModelBookmark, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSModelBookmark, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FolderFlag(bl, pSModelBookmark, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSModelBookmarkId(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelBookmarkId(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelBookmarkName(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjId(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjName(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjType(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjTypeName(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSModelBookmark, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSModelBookmark, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FolderFlag(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isFolderFlagDirty() : !pSModelBookmark.isFolderFlagDirty()) {
            return null;
        }
        Integer n = pSModelBookmark.getFolderFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FolderFlag_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOLDERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isMemoDirty() : !pSModelBookmark.isMemoDirty()) {
            return null;
        }
        String string = pSModelBookmark.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSModelBookmark, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSModelBookmarkId(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isPPSModelBookmarkIdDirty() : !pSModelBookmark.isPPSModelBookmarkIdDirty()) {
            return null;
        }
        String string = pSModelBookmark.getPPSModelBookmarkId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSModelBookmarkId_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSMODELBOOKMARKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelBookmarkId(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isPSModelBookmarkIdDirty() && !bl2 : !pSModelBookmark.isPSModelBookmarkIdDirty()) {
            return null;
        }
        String string = pSModelBookmark.getPSModelBookmarkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELBOOKMARKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelBookmarkId_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELBOOKMARKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelBookmarkName(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isPSModelBookmarkNameDirty() && !bl2 : !pSModelBookmark.isPSModelBookmarkNameDirty()) {
            return null;
        }
        String string = pSModelBookmark.getPSModelBookmarkName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELBOOKMARKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelBookmarkName_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELBOOKMARKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjId(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isPSObjIdDirty() : !pSModelBookmark.isPSObjIdDirty()) {
            return null;
        }
        String string = pSModelBookmark.getPSObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjId_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjName(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isPSObjNameDirty() : !pSModelBookmark.isPSObjNameDirty()) {
            return null;
        }
        String string = pSModelBookmark.getPSObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjName_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjType(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isPSObjTypeDirty() : !pSModelBookmark.isPSObjTypeDirty()) {
            return null;
        }
        String string = pSModelBookmark.getPSObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjType_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjTypeName(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isPSObjTypeNameDirty() : !pSModelBookmark.isPSObjTypeNameDirty()) {
            return null;
        }
        String string = pSModelBookmark.getPSObjTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjTypeName_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isPSSystemIdDirty() && !bl2 : !pSModelBookmark.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSModelBookmark.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSModelBookmark pSModelBookmark, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelBookmark.isPSSystemNameDirty() : !pSModelBookmark.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSModelBookmark.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSModelBookmark, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelBookmark pSModelBookmark, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSModelBookmark, bl);
    }

    protected void onSyncIndexEntities(PSModelBookmark pSModelBookmark, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSModelBookmark, bl);
    }

    public Object getDataContextValue(PSModelBookmark pSModelBookmark, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSModelBookmark, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSModelBookmark.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSModelBookmark pSModelBookmark, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSModelBookmark, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FOLDERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FolderFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELBOOKMARKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelBookmarkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELBOOKMARKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelBookmarkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELBOOKMARKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelBookmarkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELBOOKMARKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelBookmarkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FolderFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PPSModelBookmarkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELBOOKMARKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSModelBookmarkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELBOOKMARKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelBookmarkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELBOOKMARKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelBookmarkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELBOOKMARKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSModelBookmark pSModelBookmark) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSModelBookmark)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelBookmark pSModelBookmark) throws Exception {
        super.onUpdateParent((IEntity)pSModelBookmark);
    }

    @Override
    protected void exportCurXmlModel(PSModelBookmark pSModelBookmark, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELBOOKMARK");
        if (!bl) {
            pSModelBookmark.setCreateDate(null);
            pSModelBookmark.setCreateMan(null);
            pSModelBookmark.setPSModelBookmarkId(null);
            pSModelBookmark.setUpdateDate(null);
            pSModelBookmark.setUpdateMan(null);
            super.exportCurXmlModel(pSModelBookmark, xmlNode, bl);
        }
    }
}

