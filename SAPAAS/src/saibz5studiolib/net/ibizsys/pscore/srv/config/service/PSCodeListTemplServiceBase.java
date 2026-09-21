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
import net.ibizsys.pscore.srv.config.dao.PSCodeListTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSCodeListTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCodeListTempl;
import net.ibizsys.pscore.srv.config.entity.PSSysLanRes;
import net.ibizsys.pscore.srv.config.entity.PSSysLanResBase;
import net.ibizsys.pscore.srv.config.service.PSDEFTypeService;
import net.ibizsys.pscore.srv.config.service.PSDEFTypeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCodeListTemplServiceBase
extends PSCoreSysServiceBase<PSCodeListTempl> {
    private static final Log log = LogFactory.getLog(PSCodeListTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCodeListTemplDEModel pSCodeListTemplDEModel;
    private PSCodeListTemplDAO pSCodeListTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSCodeListTemplService";
    }

    public PSCodeListTemplDEModel getPSCodeListTemplDEModel() {
        if (this.pSCodeListTemplDEModel == null) {
            try {
                this.pSCodeListTemplDEModel = (PSCodeListTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSCodeListTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCodeListTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCodeListTemplDEModel();
    }

    public PSCodeListTemplDAO getPSCodeListTemplDAO() {
        if (this.pSCodeListTemplDAO == null) {
            try {
                this.pSCodeListTemplDAO = (PSCodeListTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSCodeListTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCodeListTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCodeListTemplDAO();
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

    protected void onFillParentInfo(PSCodeListTempl pSCodeListTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELISTTEMPL_PSSYSLANRES_EMPTYTEXTPSSYSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysLanResService", (SessionFactory)this.getSessionFactory());
            PSSysLanRes pSSysLanRes = (PSSysLanRes)iService.getDEModel().createEntity();
            pSSysLanRes.set("PSSYSLANRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysLanRes);
            } else {
                iService.get((IEntity)pSSysLanRes);
            }
            this.onFillParentInfo_EmptyTextPSSysLanRes(pSCodeListTempl, pSSysLanRes);
            return;
        }
        super.onFillParentInfo((IEntity)pSCodeListTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_EmptyTextPSSysLanRes(PSCodeListTempl pSCodeListTempl, PSSysLanRes pSSysLanRes) throws Exception {
        pSCodeListTempl.setEmptyTextPSSyslanResId(pSSysLanRes.getPSSysLanResId());
        pSCodeListTempl.setEmptyTextPSSyslanResName(pSSysLanRes.getPSSysLanResName());
    }

    protected void onFillEntityFullInfo(PSCodeListTempl pSCodeListTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSCodeListTempl, bl);
        this.onFillEntityFullInfo_EmptyTextPSSysLanRes(pSCodeListTempl, bl);
    }

    protected void onFillEntityFullInfo_EmptyTextPSSysLanRes(PSCodeListTempl pSCodeListTempl, boolean bl) throws Exception {
        if (pSCodeListTempl.isEmptyTextPSSyslanResIdDirty()) {
            if (pSCodeListTempl.getEmptyTextPSSyslanResId() != null) {
                if (pSCodeListTempl.getEmptyTextPSSyslanResId() == null || pSCodeListTempl.getEmptyTextPSSyslanResName() == null) {
                    PSSysLanRes pSSysLanRes = pSCodeListTempl.getEmptyTextPSSysLanRes();
                    pSCodeListTempl.setEmptyTextPSSyslanResName(pSSysLanRes.getPSSysLanResName());
                }
            } else {
                pSCodeListTempl.setEmptyTextPSSyslanResName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCodeListTempl pSCodeListTempl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSCodeListTempl, bl);
    }

    public ArrayList<PSCodeListTempl> selectByEmptyTextPSSysLanRes(PSSysLanResBase pSSysLanResBase) throws Exception {
        return this.selectByEmptyTextPSSysLanRes(pSSysLanResBase, "", -1);
    }

    public ArrayList<PSCodeListTempl> selectByEmptyTextPSSysLanRes(PSSysLanResBase pSSysLanResBase, String string) throws Exception {
        return this.selectByEmptyTextPSSysLanRes(pSSysLanResBase, string, -1);
    }

    public ArrayList<PSCodeListTempl> selectByEmptyTextPSSysLanRes(PSSysLanResBase pSSysLanResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMPTYTEXTPSSYSLANRESID", (Object)pSSysLanResBase.getPSSysLanResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmptyTextPSSysLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmptyTextPSSysLanResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByEmptyTextPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSCodeListTempl> arrayList = this.selectByEmptyTextPSSysLanRes(pSSysLanRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSLANRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysLanRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELISTTEMPL_PSSYSLANRES_EMPTYTEXTPSSYSLANRESID", "", iDataEntityModel.getName(), "PSCODELISTTEMPL", iDataEntityModel.getDataInfo((IEntity)pSSysLanRes), arrayList.get(0)));
        }
    }

    public void resetEmptyTextPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSCodeListTempl> arrayList = this.selectByEmptyTextPSSysLanRes(pSSysLanRes);
        for (PSCodeListTempl pSCodeListTempl : arrayList) {
            PSCodeListTempl pSCodeListTempl2 = (PSCodeListTempl)this.getDEModel().createEntity();
            pSCodeListTempl2.setPSCodeListTemplId(pSCodeListTempl.getPSCodeListTemplId());
            pSCodeListTempl2.setEmptyTextPSSyslanResId(null);
            this.update(pSCodeListTempl2);
        }
    }

    public void removeByEmptyTextPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        final PSSysLanRes pSSysLanRes2 = pSSysLanRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListTemplServiceBase.this.onBeforeRemoveByEmptyTextPSSysLanRes(pSSysLanRes2);
                PSCodeListTemplServiceBase.this.internalRemoveByEmptyTextPSSysLanRes(pSSysLanRes2);
                PSCodeListTemplServiceBase.this.onAfterRemoveByEmptyTextPSSysLanRes(pSSysLanRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmptyTextPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
    }

    protected void internalRemoveByEmptyTextPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSCodeListTempl> arrayList = this.selectByEmptyTextPSSysLanRes(pSSysLanRes);
        this.onBeforeRemoveByEmptyTextPSSysLanRes(pSSysLanRes, arrayList);
        for (PSCodeListTempl pSCodeListTempl : arrayList) {
            this.remove((IEntity)pSCodeListTempl);
        }
        this.onAfterRemoveByEmptyTextPSSysLanRes(pSSysLanRes, arrayList);
    }

    protected void onAfterRemoveByEmptyTextPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
    }

    protected void onBeforeRemoveByEmptyTextPSSysLanRes(PSSysLanRes pSSysLanRes, ArrayList<PSCodeListTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmptyTextPSSysLanRes(PSSysLanRes pSSysLanRes, ArrayList<PSCodeListTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCodeListTempl pSCodeListTempl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeListTempl(pSCodeListTempl);
        pSCoreSysServiceBase = (PSDEFTypeService)ServiceGlobal.getService(PSDEFTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeListTempl(pSCodeListTempl);
        super.onBeforeRemove(pSCodeListTempl);
    }

    protected void replaceParentInfo(PSCodeListTempl pSCodeListTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSCodeListTempl, cloneSession);
        if (pSCodeListTempl.getEmptyTextPSSyslanResId() != null && (iEntity = cloneSession.getEntity("PSSYSLANRES", (Object)pSCodeListTempl.getEmptyTextPSSyslanResId())) != null) {
            this.onFillParentInfo_EmptyTextPSSysLanRes(pSCodeListTempl, (PSSysLanRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCodeListTempl pSCodeListTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSCodeListTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CLModel(bl, pSCodeListTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CLParam(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CLPath(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSSyslanResId(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSSyslanResName(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoValueEmpty(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NumberItem(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrMode(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListTemplId(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListTemplName(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Seperator(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueSeperator(bl, pSCodeListTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSCodeListTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CLModel(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isCLModelDirty() : !pSCodeListTempl.isCLModelDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getCLModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CLModel_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CLParam(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isCLParamDirty() : !pSCodeListTempl.isCLParamDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getCLParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CLParam_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CLPath(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isCLPathDirty() : !pSCodeListTempl.isCLPathDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getCLPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CLPath_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isCodeNameDirty() && !bl2 : !pSCodeListTempl.isCodeNameDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isEmptyTextDirty() : !pSCodeListTempl.isEmptyTextDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSSyslanResId(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isEmptyTextPSSyslanResIdDirty() : !pSCodeListTempl.isEmptyTextPSSyslanResIdDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getEmptyTextPSSyslanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSSyslanResId_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSSYSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSSyslanResName(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isEmptyTextPSSyslanResNameDirty() : !pSCodeListTempl.isEmptyTextPSSyslanResNameDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getEmptyTextPSSyslanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSSyslanResName_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSSYSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isMemoDirty() : !pSCodeListTempl.isMemoDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSCodeListTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NoValueEmpty(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isNoValueEmptyDirty() : !pSCodeListTempl.isNoValueEmptyDirty()) {
            return null;
        }
        Integer n = pSCodeListTempl.getNoValueEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoValueEmpty_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOVALUEEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NumberItem(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isNumberItemDirty() : !pSCodeListTempl.isNumberItemDirty()) {
            return null;
        }
        Integer n = pSCodeListTempl.getNumberItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NumberItem_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NUMBERITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrMode(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isOrModeDirty() : !pSCodeListTempl.isOrModeDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getOrMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrMode_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isPredefinedTypeDirty() : !pSCodeListTempl.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListTemplId(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isPSCodeListTemplIdDirty() && !bl2 : !pSCodeListTempl.isPSCodeListTemplIdDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getPSCodeListTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListTemplId_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListTemplName(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isPSCodeListTemplNameDirty() && !bl2 : !pSCodeListTempl.isPSCodeListTemplNameDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getPSCodeListTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListTemplName_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Seperator(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isSeperatorDirty() : !pSCodeListTempl.isSeperatorDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getSeperator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Seperator_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEPERATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueSeperator(boolean bl, PSCodeListTempl pSCodeListTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeListTempl.isValueSeperatorDirty() : !pSCodeListTempl.isValueSeperatorDirty()) {
            return null;
        }
        String string = pSCodeListTempl.getValueSeperator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueSeperator_Default((IEntity)pSCodeListTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUESEPERATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCodeListTempl pSCodeListTempl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSCodeListTempl, bl);
    }

    protected void onSyncIndexEntities(PSCodeListTempl pSCodeListTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSCodeListTempl, bl);
    }

    public Object getDataContextValue(PSCodeListTempl pSCodeListTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSCodeListTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSCodeListTempl pSCodeListTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSCodeListTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CLModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CLParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CLPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSSYSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSSyslanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSSYSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSSyslanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOVALUEEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoValueEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NUMBERITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NumberItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEPERATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Seperator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUESEPERATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueSeperator_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CLModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CLParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLPARAM", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CLPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_EmptyText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSSyslanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSSYSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSSyslanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSSYSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_NoValueEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NumberItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Seperator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEPERATOR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected String onTestValueRule_ValueSeperator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUESEPERATOR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSCodeListTempl pSCodeListTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSCodeListTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCodeListTempl pSCodeListTempl) throws Exception {
        super.onUpdateParent((IEntity)pSCodeListTempl);
    }

    @Override
    protected void exportCurXmlModel(PSCodeListTempl pSCodeListTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCODELISTTEMPL");
        if (!bl) {
            pSCodeListTempl.setCreateDate(null);
            pSCodeListTempl.setCreateMan(null);
            pSCodeListTempl.setUpdateDate(null);
            pSCodeListTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSCodeListTempl, xmlNode, bl);
        }
    }
}

