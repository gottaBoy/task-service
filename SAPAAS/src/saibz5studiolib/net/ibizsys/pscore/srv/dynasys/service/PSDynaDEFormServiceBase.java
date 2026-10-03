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
package net.ibizsys.pscore.srv.dynasys.service;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaDEFormDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDE;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDEFormServiceBase
extends PSCoreSysServiceBase<PSDynaDEForm> {
    private static final Log log = LogFactory.getLog(PSDynaDEFormServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaDEFormDEModel pSDynaDEFormDEModel;
    private PSDynaDEFormDAO pSDynaDEFormDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService";
    }

    public PSDynaDEFormDEModel getPSDynaDEFormDEModel() {
        if (this.pSDynaDEFormDEModel == null) {
            try {
                this.pSDynaDEFormDEModel = (PSDynaDEFormDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDEFormDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaDEFormDEModel();
    }

    public PSDynaDEFormDAO getPSDynaDEFormDAO() {
        if (this.pSDynaDEFormDAO == null) {
            try {
                this.pSDynaDEFormDAO = (PSDynaDEFormDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaDEFormDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDEFormDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaDEFormDAO();
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

    protected void onFillParentInfo(PSDynaDEForm pSDynaDEForm, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADEFORM_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDynaDEForm, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADEFORM_PSDYNADE_PSDYNADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEService", (SessionFactory)this.getSessionFactory());
            PSDynaDE pSDynaDE = (PSDynaDE)iService.getDEModel().createEntity();
            pSDynaDE.set("PSDYNADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaDE);
            } else {
                iService.get(pSDynaDE);
            }
            this.onFillParentInfo_PSDynaDE(pSDynaDEForm, pSDynaDE);
            return;
        }
        super.onFillParentInfo(pSDynaDEForm, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEForm(PSDynaDEForm pSDynaDEForm, PSDEForm pSDEForm) throws Exception {
        pSDynaDEForm.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDynaDEForm.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDynaDE(PSDynaDEForm pSDynaDEForm, PSDynaDE pSDynaDE) throws Exception {
        pSDynaDEForm.setPSDynaDEId(pSDynaDE.getPSDynaDEId());
        pSDynaDEForm.setPSDynaDEName(pSDynaDE.getPSDynaDEName());
    }

    protected void onFillEntityFullInfo(PSDynaDEForm pSDynaDEForm, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDynaDEForm, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDynaDEForm, bl);
        this.onFillEntityFullInfo_PSDynaDE(pSDynaDEForm, bl);
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDynaDEForm pSDynaDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaDE(PSDynaDEForm pSDynaDEForm, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDynaDEForm pSDynaDEForm, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaDEForm, bl);
    }

    public ArrayList<PSDynaDEForm> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDynaDEForm> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDynaDEForm> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaDEForm> selectByPSDynaDE(PSDynaDEBase pSDynaDEBase) throws Exception {
        return this.selectByPSDynaDE(pSDynaDEBase, "", -1);
    }

    public ArrayList<PSDynaDEForm> selectByPSDynaDE(PSDynaDEBase pSDynaDEBase, String string) throws Exception {
        return this.selectByPSDynaDE(pSDynaDEBase, string, -1);
    }

    public ArrayList<PSDynaDEForm> selectByPSDynaDE(PSDynaDEBase pSDynaDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNADEID", (Object)pSDynaDEBase.getPSDynaDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDynaDEForm> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNADEFORM_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDYNADEFORM", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDynaDEForm> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDynaDEForm pSDynaDEForm : arrayList) {
            PSDynaDEForm pSDynaDEForm2 = (PSDynaDEForm)this.getDEModel().createEntity();
            pSDynaDEForm2.setPSDynaDEFormId(pSDynaDEForm.getPSDynaDEFormId());
            pSDynaDEForm2.setPSDEFormId(null);
            this.update(pSDynaDEForm2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDEFormServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDynaDEFormServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDynaDEFormServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDynaDEForm> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDynaDEForm pSDynaDEForm : arrayList) {
            this.remove(pSDynaDEForm);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDynaDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDynaDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
    }

    public void resetPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
        ArrayList<PSDynaDEForm> arrayList = this.selectByPSDynaDE(pSDynaDE);
        for (PSDynaDEForm pSDynaDEForm : arrayList) {
            PSDynaDEForm pSDynaDEForm2 = (PSDynaDEForm)this.getDEModel().createEntity();
            pSDynaDEForm2.setPSDynaDEFormId(pSDynaDEForm.getPSDynaDEFormId());
            pSDynaDEForm2.setPSDynaDEId(null);
            this.update(pSDynaDEForm2);
        }
    }

    public void removeByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
        final PSDynaDE pSDynaDE2 = pSDynaDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDEFormServiceBase.this.onBeforeRemoveByPSDynaDE(pSDynaDE2);
                PSDynaDEFormServiceBase.this.internalRemoveByPSDynaDE(pSDynaDE2);
                PSDynaDEFormServiceBase.this.onAfterRemoveByPSDynaDE(pSDynaDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
    }

    protected void internalRemoveByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
        ArrayList<PSDynaDEForm> arrayList = this.selectByPSDynaDE(pSDynaDE);
        this.onBeforeRemoveByPSDynaDE(pSDynaDE, arrayList);
        for (PSDynaDEForm pSDynaDEForm : arrayList) {
            this.remove(pSDynaDEForm);
        }
        this.onAfterRemoveByPSDynaDE(pSDynaDE, arrayList);
    }

    protected void onAfterRemoveByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaDE(PSDynaDE pSDynaDE, ArrayList<PSDynaDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaDE(PSDynaDE pSDynaDE, ArrayList<PSDynaDEForm> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaDEForm pSDynaDEForm) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaDEForm(pSDynaDEForm);
        pSCoreSysServiceBase = (PSDynaAppViewCtrlService)ServiceGlobal.getService(PSDynaAppViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaDEForm(pSDynaDEForm);
        pSCoreSysServiceBase = (PSDynaDEFormInstService)ServiceGlobal.getService(PSDynaDEFormInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaDEFormInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaDEForm(pSDynaDEForm);
        super.onBeforeRemove(pSDynaDEForm);
    }

    protected void replaceParentInfo(PSDynaDEForm pSDynaDEForm, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaDEForm, cloneSession);
        if (pSDynaDEForm.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDynaDEForm.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDynaDEForm, (PSDEForm)iEntity);
        }
        if (pSDynaDEForm.getPSDynaDEId() != null && (iEntity = cloneSession.getEntity("PSDYNADE", (Object)pSDynaDEForm.getPSDynaDEId())) != null) {
            this.onFillParentInfo_PSDynaDE(pSDynaDEForm, (PSDynaDE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaDEForm pSDynaDEForm, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaDEForm, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaDEForm pSDynaDEForm, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDynaDEForm, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDynaDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormId(bl, pSDynaDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormName(bl, pSDynaDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEId(bl, pSDynaDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaDEForm, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaDEForm pSDynaDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEForm.isMemoDirty() : !pSDynaDEForm.isMemoDirty()) {
            return null;
        }
        String string = pSDynaDEForm.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDynaDEForm pSDynaDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEForm.isPSDEFormIdDirty() && !bl2 : !pSDynaDEForm.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDynaDEForm.getPSDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSDynaDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormId(boolean bl, PSDynaDEForm pSDynaDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEForm.isPSDynaDEFormIdDirty() && !bl2 : !pSDynaDEForm.isPSDynaDEFormIdDirty()) {
            return null;
        }
        String string = pSDynaDEForm.getPSDynaDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormId_Default(pSDynaDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormName(boolean bl, PSDynaDEForm pSDynaDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEForm.isPSDynaDEFormNameDirty() && !bl2 : !pSDynaDEForm.isPSDynaDEFormNameDirty()) {
            return null;
        }
        String string = pSDynaDEForm.getPSDynaDEFormName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormName_Default(pSDynaDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEId(boolean bl, PSDynaDEForm pSDynaDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEForm.isPSDynaDEIdDirty() && !bl2 : !pSDynaDEForm.isPSDynaDEIdDirty()) {
            return null;
        }
        String string = pSDynaDEForm.getPSDynaDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEId_Default(pSDynaDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaDEForm pSDynaDEForm, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaDEForm, bl);
    }

    protected void onSyncIndexEntities(PSDynaDEForm pSDynaDEForm, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaDEForm, bl);
    }

    public Object getDataContextValue(PSDynaDEForm pSDynaDEForm, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaDEForm, string, iDataContextParam)) != null) {
            return object;
        }
        PSDynaDE pSDynaDE = pSDynaDEForm.getPSDynaDE();
        if (pSDynaDE != null && pSDynaDE.contains(string)) {
            return pSDynaDE.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaDEForm pSDynaDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaDEForm, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaDEForm pSDynaDEForm) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaDEForm)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaDEForm pSDynaDEForm) throws Exception {
        super.onUpdateParent(pSDynaDEForm);
    }

    @Override
    protected void exportCurXmlModel(PSDynaDEForm pSDynaDEForm, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNADEFORM");
        if (!bl) {
            pSDynaDEForm.setCreateDate(null);
            pSDynaDEForm.setCreateMan(null);
            pSDynaDEForm.setPSDEFormName(null);
            pSDynaDEForm.setPSDynaDEFormId(null);
            pSDynaDEForm.setPSDynaDEId(null);
            pSDynaDEForm.setPSDynaDEName(null);
            pSDynaDEForm.setUpdateDate(null);
            pSDynaDEForm.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaDEForm, xmlNode, bl);
        }
    }
}

