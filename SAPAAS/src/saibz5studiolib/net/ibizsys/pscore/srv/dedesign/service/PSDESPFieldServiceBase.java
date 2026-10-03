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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDESPFieldDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESPFieldDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESPField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProc;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProcBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESPFieldServiceBase
extends PSCoreSysServiceBase<PSDESPField> {
    private static final Log log = LogFactory.getLog(PSDESPFieldServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDESPFieldDEModel pSDESPFieldDEModel;
    private PSDESPFieldDAO pSDESPFieldDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDESPFieldService";
    }

    public PSDESPFieldDEModel getPSDESPFieldDEModel() {
        if (this.pSDESPFieldDEModel == null) {
            try {
                this.pSDESPFieldDEModel = (PSDESPFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESPFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESPFieldDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDESPFieldDEModel();
    }

    public PSDESPFieldDAO getPSDESPFieldDAO() {
        if (this.pSDESPFieldDAO == null) {
            try {
                this.pSDESPFieldDAO = (PSDESPFieldDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDESPFieldDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESPFieldDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDESPFieldDAO();
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

    protected void onFillParentInfo(PSDESPField pSDESPField, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESPFIELD_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDESPField, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESPFIELD_PSDESYSPROC_PSDESYSPROCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService", (SessionFactory)this.getSessionFactory());
            PSDESysProc pSDESysProc = (PSDESysProc)iService.getDEModel().createEntity();
            pSDESysProc.set("PSDESYSPROCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDESysProc);
            } else {
                iService.get(pSDESysProc);
            }
            this.onFillParentInfo_Psdesysproc(pSDESPField, pSDESysProc);
            return;
        }
        super.onFillParentInfo(pSDESPField, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEF(PSDESPField pSDESPField, PSDEField pSDEField) throws Exception {
        pSDESPField.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDESPField.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Psdesysproc(PSDESPField pSDESPField, PSDESysProc pSDESysProc) throws Exception {
        pSDESPField.setPSDESysProcId(pSDESysProc.getPSDESysProcId());
        pSDESPField.setPSDESysProcName(pSDESysProc.getPSDESysProcName());
    }

    protected void onFillEntityFullInfo(PSDESPField pSDESPField, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDESPField, bl);
        this.onFillEntityFullInfo_PSDEF(pSDESPField, bl);
        this.onFillEntityFullInfo_Psdesysproc(pSDESPField, bl);
    }

    protected void onFillEntityFullInfo_PSDEF(PSDESPField pSDESPField, boolean bl) throws Exception {
        if (pSDESPField.isPSDEFIdDirty()) {
            if (pSDESPField.getPSDEFId() != null) {
                if (pSDESPField.getPSDEFId() == null || pSDESPField.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDESPField.getPSDEF();
                    pSDESPField.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDESPField.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Psdesysproc(PSDESPField pSDESPField, boolean bl) throws Exception {
        if (pSDESPField.isPSDESysProcIdDirty()) {
            if (pSDESPField.getPSDESysProcId() != null) {
                if (pSDESPField.getPSDESysProcId() == null || pSDESPField.getPSDESysProcName() == null) {
                    PSDESysProc pSDESysProc = pSDESPField.getPsdesysproc();
                    pSDESPField.setPSDESysProcName(pSDESysProc.getPSDESysProcName());
                }
            } else {
                pSDESPField.setPSDESysProcName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDESPField pSDESPField, boolean bl) throws Exception {
        super.onWriteBackParent(pSDESPField, bl);
    }

    public ArrayList<PSDESPField> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDESPField> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDESPField> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESPField> selectByPsdesysproc(PSDESysProcBase pSDESysProcBase) throws Exception {
        return this.selectByPsdesysproc(pSDESysProcBase, "", -1);
    }

    public ArrayList<PSDESPField> selectByPsdesysproc(PSDESysProcBase pSDESysProcBase, String string) throws Exception {
        return this.selectByPsdesysproc(pSDESysProcBase, string, -1);
    }

    public ArrayList<PSDESPField> selectByPsdesysproc(PSDESysProcBase pSDESysProcBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESYSPROCID", (Object)pSDESysProcBase.getPSDESysProcId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsdesysprocCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsdesysprocCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDESPField> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESPFIELD_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSDESPFIELD", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDESPField> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDESPField pSDESPField : arrayList) {
            PSDESPField pSDESPField2 = (PSDESPField)this.getDEModel().createEntity();
            pSDESPField2.setPSDESPFieldId(pSDESPField.getPSDESPFieldId());
            pSDESPField2.setPSDEFId(null);
            this.update(pSDESPField2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESPFieldServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDESPFieldServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDESPFieldServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDESPField> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDESPField pSDESPField : arrayList) {
            this.remove(pSDESPField);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDESPField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDESPField> arrayList) throws Exception {
    }

    public void testRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
    }

    public void resetPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
        ArrayList<PSDESPField> arrayList = this.selectByPsdesysproc(pSDESysProc);
        for (PSDESPField pSDESPField : arrayList) {
            PSDESPField pSDESPField2 = (PSDESPField)this.getDEModel().createEntity();
            pSDESPField2.setPSDESPFieldId(pSDESPField.getPSDESPFieldId());
            pSDESPField2.setPSDESysProcId(null);
            this.update(pSDESPField2);
        }
    }

    public void removeByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
        final PSDESysProc pSDESysProc2 = pSDESysProc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESPFieldServiceBase.this.onBeforeRemoveByPsdesysproc(pSDESysProc2);
                PSDESPFieldServiceBase.this.internalRemoveByPsdesysproc(pSDESysProc2);
                PSDESPFieldServiceBase.this.onAfterRemoveByPsdesysproc(pSDESysProc2);
            }
        });
    }

    protected void onBeforeRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
    }

    protected void internalRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
        ArrayList<PSDESPField> arrayList = this.selectByPsdesysproc(pSDESysProc);
        this.onBeforeRemoveByPsdesysproc(pSDESysProc, arrayList);
        for (PSDESPField pSDESPField : arrayList) {
            this.remove(pSDESPField);
        }
        this.onAfterRemoveByPsdesysproc(pSDESysProc, arrayList);
    }

    protected void onAfterRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
    }

    protected void onBeforeRemoveByPsdesysproc(PSDESysProc pSDESysProc, ArrayList<PSDESPField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsdesysproc(PSDESysProc pSDESysProc, ArrayList<PSDESPField> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDESPField pSDESPField) throws Exception {
        super.onBeforeRemove(pSDESPField);
    }

    protected void replaceParentInfo(PSDESPField pSDESPField, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDESPField, cloneSession);
        if (pSDESPField.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDESPField.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDESPField, (PSDEField)iEntity);
        }
        if (pSDESPField.getPSDESysProcId() != null && (iEntity = cloneSession.getEntity("PSDESYSPROC", (Object)pSDESPField.getPSDESysProcId())) != null) {
            this.onFillParentInfo_Psdesysproc(pSDESPField, (PSDESysProc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDESPField pSDESPField, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDESPField, bl);
    }

    protected void onCheckEntity(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DeclareParam(bl, pSDESPField, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDESPField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDESPField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PROCParam(bl, pSDESPField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDESPField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDESPField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESPFieldId(bl, pSDESPField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESPFieldName(bl, pSDESPField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESysProcId(bl, pSDESPField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESysProcName(bl, pSDESPField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDESPField, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DeclareParam(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isDeclareParamDirty() && !bl2 : !pSDESPField.isDeclareParamDirty()) {
            return null;
        }
        Integer n = pSDESPField.getDeclareParam();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DECLAREPARAM");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DeclareParam_Default(pSDESPField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DECLAREPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isMemoDirty() : !pSDESPField.isMemoDirty()) {
            return null;
        }
        String string = pSDESPField.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDESPField, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isOrderValueDirty() : !pSDESPField.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDESPField.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDESPField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PROCParam(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isPROCParamDirty() && !bl2 : !pSDESPField.isPROCParamDirty()) {
            return null;
        }
        Integer n = pSDESPField.getPROCParam();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCPARAM");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PROCParam_Default(pSDESPField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isPSDEFIdDirty() && !bl2 : !pSDESPField.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDESPField.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSDESPField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isPSDEFNameDirty() && !bl2 : !pSDESPField.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDESPField.getPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSDESPField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESPFieldId(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isPSDESPFieldIdDirty() && !bl2 : !pSDESPField.isPSDESPFieldIdDirty()) {
            return null;
        }
        String string = pSDESPField.getPSDESPFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESPFieldId_Default(pSDESPField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESPFieldName(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isPSDESPFieldNameDirty() && !bl2 : !pSDESPField.isPSDESPFieldNameDirty()) {
            return null;
        }
        String string = pSDESPField.getPSDESPFieldName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPFIELDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESPFieldName_Default(pSDESPField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESysProcId(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isPSDESysProcIdDirty() && !bl2 : !pSDESPField.isPSDESysProcIdDirty()) {
            return null;
        }
        String string = pSDESPField.getPSDESysProcId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESysProcId_Default(pSDESPField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESysProcName(boolean bl, PSDESPField pSDESPField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPField.isPSDESysProcNameDirty() && !bl2 : !pSDESPField.isPSDESysProcNameDirty()) {
            return null;
        }
        String string = pSDESPField.getPSDESysProcName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESysProcName_Default(pSDESPField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDESPField pSDESPField, boolean bl) throws Exception {
        super.onSyncEntity(pSDESPField, bl);
    }

    protected void onSyncIndexEntities(PSDESPField pSDESPField, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDESPField, bl);
    }

    public Object getDataContextValue(PSDESPField pSDESPField, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDESPField, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDESPField pSDESPField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDESPField, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DECLAREPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeclareParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROCPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PROCParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESYSPROCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESysProcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESYSPROCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESysProcName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DeclareParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PROCParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESPFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESPFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESPFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESPFIELDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESysProcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESYSPROCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESysProcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESYSPROCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDESPField pSDESPField) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDESPField)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDESPField pSDESPField) throws Exception {
        super.onUpdateParent(pSDESPField);
    }

    @Override
    protected void exportCurXmlModel(PSDESPField pSDESPField, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESPFIELD");
        if (!bl) {
            pSDESPField.setCreateDate(null);
            pSDESPField.setCreateMan(null);
            pSDESPField.setPSDESPFieldId(null);
            pSDESPField.setUpdateDate(null);
            pSDESPField.setUpdateMan(null);
            super.exportCurXmlModel(pSDESPField, xmlNode, bl);
        }
    }
}

