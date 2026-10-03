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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSCssTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSCssTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCssCatTempl;
import net.ibizsys.pscore.srv.config.entity.PSCssCatTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSCssTempl;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemService;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCssTemplServiceBase
extends PSCoreSysServiceBase<PSCssTempl> {
    private static final Log log = LogFactory.getLog(PSCssTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCssTemplDEModel pSCssTemplDEModel;
    private PSCssTemplDAO pSCssTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSCssTemplService";
    }

    public PSCssTemplDEModel getPSCssTemplDEModel() {
        if (this.pSCssTemplDEModel == null) {
            try {
                this.pSCssTemplDEModel = (PSCssTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSCssTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCssTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCssTemplDEModel();
    }

    public PSCssTemplDAO getPSCssTemplDAO() {
        if (this.pSCssTemplDAO == null) {
            try {
                this.pSCssTemplDAO = (PSCssTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSCssTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCssTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCssTemplDAO();
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

    protected void onFillParentInfo(PSCssTempl pSCssTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCSSTEMPL_PSCSSCATTEMPL_PSCSSCATTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCssCatTemplService", (SessionFactory)this.getSessionFactory());
            PSCssCatTempl pSCssCatTempl = (PSCssCatTempl)iService.getDEModel().createEntity();
            pSCssCatTempl.set("PSCSSCATTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCssCatTempl);
            } else {
                iService.get(pSCssCatTempl);
            }
            this.onFillParentInfo_PSCssCatTempl(pSCssTempl, pSCssCatTempl);
            return;
        }
        super.onFillParentInfo(pSCssTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCssCatTempl(PSCssTempl pSCssTempl, PSCssCatTempl pSCssCatTempl) throws Exception {
        pSCssTempl.setPSCssCatTemplId(pSCssCatTempl.getPSCssCatTemplId());
        pSCssTempl.setPSCssCatTemplName(pSCssCatTempl.getPSCssCatTemplName());
    }

    protected void onFillEntityFullInfo(PSCssTempl pSCssTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSCssTempl, bl);
        this.onFillEntityFullInfo_PSCssCatTempl(pSCssTempl, bl);
    }

    protected void onFillEntityFullInfo_PSCssCatTempl(PSCssTempl pSCssTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSCssTempl pSCssTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSCssTempl, bl);
    }

    public ArrayList<PSCssTempl> selectByPSCssCatTempl(PSCssCatTemplBase pSCssCatTemplBase) throws Exception {
        return this.selectByPSCssCatTempl(pSCssCatTemplBase, "", -1);
    }

    public ArrayList<PSCssTempl> selectByPSCssCatTempl(PSCssCatTemplBase pSCssCatTemplBase, String string) throws Exception {
        return this.selectByPSCssCatTempl(pSCssCatTemplBase, string, -1);
    }

    public ArrayList<PSCssTempl> selectByPSCssCatTempl(PSCssCatTemplBase pSCssCatTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCSSCATTEMPLID", (Object)pSCssCatTemplBase.getPSCssCatTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCssCatTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCssCatTemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCssCatTempl(PSCssCatTempl pSCssCatTempl) throws Exception {
        ArrayList<PSCssTempl> arrayList = this.selectByPSCssCatTempl(pSCssCatTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCSSCATTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCssCatTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCSSTEMPL_PSCSSCATTEMPL_PSCSSCATTEMPLID", "", iDataEntityModel.getName(), "PSCSSTEMPL", iDataEntityModel.getDataInfo(pSCssCatTempl), arrayList.get(0)));
        }
    }

    public void resetPSCssCatTempl(PSCssCatTempl pSCssCatTempl) throws Exception {
        ArrayList<PSCssTempl> arrayList = this.selectByPSCssCatTempl(pSCssCatTempl);
        for (PSCssTempl pSCssTempl : arrayList) {
            PSCssTempl pSCssTempl2 = (PSCssTempl)this.getDEModel().createEntity();
            pSCssTempl2.setPSCssTemplId(pSCssTempl.getPSCssTemplId());
            pSCssTempl2.setPSCssCatTemplId(null);
            this.update(pSCssTempl2);
        }
    }

    public void removeByPSCssCatTempl(PSCssCatTempl pSCssCatTempl) throws Exception {
        final PSCssCatTempl pSCssCatTempl2 = pSCssCatTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCssTemplServiceBase.this.onBeforeRemoveByPSCssCatTempl(pSCssCatTempl2);
                PSCssTemplServiceBase.this.internalRemoveByPSCssCatTempl(pSCssCatTempl2);
                PSCssTemplServiceBase.this.onAfterRemoveByPSCssCatTempl(pSCssCatTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSCssCatTempl(PSCssCatTempl pSCssCatTempl) throws Exception {
    }

    protected void internalRemoveByPSCssCatTempl(PSCssCatTempl pSCssCatTempl) throws Exception {
        ArrayList<PSCssTempl> arrayList = this.selectByPSCssCatTempl(pSCssCatTempl);
        this.onBeforeRemoveByPSCssCatTempl(pSCssCatTempl, arrayList);
        for (PSCssTempl pSCssTempl : arrayList) {
            this.remove(pSCssTempl);
        }
        this.onAfterRemoveByPSCssCatTempl(pSCssCatTempl, arrayList);
    }

    protected void onAfterRemoveByPSCssCatTempl(PSCssCatTempl pSCssCatTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSCssCatTempl(PSCssCatTempl pSCssCatTempl, ArrayList<PSCssTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCssCatTempl(PSCssCatTempl pSCssCatTempl, ArrayList<PSCssTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCssTempl pSCssTempl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCssServiceBase)pSCoreSysServiceBase).testRemoveByPSCssTempl(pSCssTempl);
        pSCoreSysServiceBase = (PSSysTBItemService)ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTBItemServiceBase)pSCoreSysServiceBase).testRemoveByPscsstempl(pSCssTempl);
        super.onBeforeRemove(pSCssTempl);
    }

    protected void replaceParentInfo(PSCssTempl pSCssTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCssTempl, cloneSession);
        if (pSCssTempl.getPSCssCatTemplId() != null && (iEntity = cloneSession.getEntity("PSCSSCATTEMPL", (Object)pSCssTempl.getPSCssCatTemplId())) != null) {
            this.onFillParentInfo_PSCssCatTempl(pSCssTempl, (PSCssCatTempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCssTempl pSCssTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCssTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSCssTempl pSCssTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CSSName(bl, pSCssTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSSStyle(bl, pSCssTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCssTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCssCatTemplId(bl, pSCssTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCssTemplId(bl, pSCssTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCssTemplName(bl, pSCssTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCssTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CSSName(boolean bl, PSCssTempl pSCssTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCssTempl.isCSSNameDirty() : !pSCssTempl.isCSSNameDirty()) {
            return null;
        }
        String string = pSCssTempl.getCSSName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSSName_Default(pSCssTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSSStyle(boolean bl, PSCssTempl pSCssTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCssTempl.isCSSStyleDirty() : !pSCssTempl.isCSSStyleDirty()) {
            return null;
        }
        String string = pSCssTempl.getCSSStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSSStyle_Default(pSCssTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCssTempl pSCssTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCssTempl.isMemoDirty() : !pSCssTempl.isMemoDirty()) {
            return null;
        }
        String string = pSCssTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCssTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCssCatTemplId(boolean bl, PSCssTempl pSCssTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCssTempl.isPSCssCatTemplIdDirty() : !pSCssTempl.isPSCssCatTemplIdDirty()) {
            return null;
        }
        String string = pSCssTempl.getPSCssCatTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCssCatTemplId_Default(pSCssTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCSSCATTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCssTemplId(boolean bl, PSCssTempl pSCssTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCssTempl.isPSCssTemplIdDirty() && !bl2 : !pSCssTempl.isPSCssTemplIdDirty()) {
            return null;
        }
        String string = pSCssTempl.getPSCssTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCSSTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCssTemplId_Default(pSCssTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCSSTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCssTemplName(boolean bl, PSCssTempl pSCssTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCssTempl.isPSCssTemplNameDirty() && !bl2 : !pSCssTempl.isPSCssTemplNameDirty()) {
            return null;
        }
        String string = pSCssTempl.getPSCssTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCSSTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCssTemplName_Default(pSCssTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCSSTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCssTempl pSCssTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSCssTempl, bl);
    }

    protected void onSyncIndexEntities(PSCssTempl pSCssTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCssTempl, bl);
    }

    public Object getDataContextValue(PSCssTempl pSCssTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCssTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSCssTempl pSCssTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCssTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSSStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCSSCATTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCssCatTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCSSCATTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCssCatTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCSSTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCssTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCSSTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCssTemplName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CSSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSSStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSSTYLE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
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

    protected String onTestValueRule_PSCssCatTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCSSCATTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCssCatTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCSSCATTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCssTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCSSTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCssTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCSSTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCssTempl pSCssTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCssTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCssTempl pSCssTempl) throws Exception {
        super.onUpdateParent(pSCssTempl);
    }

    @Override
    protected void exportCurXmlModel(PSCssTempl pSCssTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCSSTEMPL");
        if (!bl) {
            pSCssTempl.setPSCssCatTemplName(null);
            super.exportCurXmlModel(pSCssTempl, xmlNode, bl);
        }
    }
}

