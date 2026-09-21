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
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppViewCtrlDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppViewCtrlDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppView;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewCtrl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppVCInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppViewCtrlServiceBase
extends PSCoreSysServiceBase<PSDynaAppViewCtrl> {
    private static final Log log = LogFactory.getLog(PSDynaAppViewCtrlServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaAppViewCtrlDEModel pSDynaAppViewCtrlDEModel;
    private PSDynaAppViewCtrlDAO pSDynaAppViewCtrlDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlService";
    }

    public PSDynaAppViewCtrlDEModel getPSDynaAppViewCtrlDEModel() {
        if (this.pSDynaAppViewCtrlDEModel == null) {
            try {
                this.pSDynaAppViewCtrlDEModel = (PSDynaAppViewCtrlDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppViewCtrlDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppViewCtrlDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaAppViewCtrlDEModel();
    }

    public PSDynaAppViewCtrlDAO getPSDynaAppViewCtrlDAO() {
        if (this.pSDynaAppViewCtrlDAO == null) {
            try {
                this.pSDynaAppViewCtrlDAO = (PSDynaAppViewCtrlDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppViewCtrlDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppViewCtrlDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaAppViewCtrlDAO();
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

    protected void onFillParentInfo(PSDynaAppViewCtrl pSDynaAppViewCtrl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEWCTRL_PSDYNAAPPVIEW_PSDYNAAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService", (SessionFactory)this.getSessionFactory());
            PSDynaAppView pSDynaAppView = (PSDynaAppView)iService.getDEModel().createEntity();
            pSDynaAppView.set("PSDYNAAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaAppView);
            } else {
                iService.get((IEntity)pSDynaAppView);
            }
            this.onFillParentInfo_PSDynaAppView(pSDynaAppViewCtrl, pSDynaAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEWCTRL_PSDYNADEFORM_PSDYNADEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService", (SessionFactory)this.getSessionFactory());
            PSDynaDEForm pSDynaDEForm = (PSDynaDEForm)iService.getDEModel().createEntity();
            pSDynaDEForm.set("PSDYNADEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaDEForm);
            } else {
                iService.get((IEntity)pSDynaDEForm);
            }
            this.onFillParentInfo_PSDynaDEForm(pSDynaAppViewCtrl, pSDynaDEForm);
            return;
        }
        super.onFillParentInfo((IEntity)pSDynaAppViewCtrl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDynaAppView(PSDynaAppViewCtrl pSDynaAppViewCtrl, PSDynaAppView pSDynaAppView) throws Exception {
        pSDynaAppViewCtrl.setPSDynaAppViewId(pSDynaAppView.getPSDynaAppViewId());
        pSDynaAppViewCtrl.setPSDynaAppViewName(pSDynaAppView.getPSDynaAppViewName());
    }

    protected void onFillParentInfo_PSDynaDEForm(PSDynaAppViewCtrl pSDynaAppViewCtrl, PSDynaDEForm pSDynaDEForm) throws Exception {
        pSDynaAppViewCtrl.setPSDynaDEFormId(pSDynaDEForm.getPSDynaDEFormId());
        pSDynaAppViewCtrl.setPSDynaDEFormName(pSDynaDEForm.getPSDynaDEFormName());
    }

    protected void onFillEntityFullInfo(PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDynaAppViewCtrl, bl);
        this.onFillEntityFullInfo_PSDynaAppView(pSDynaAppViewCtrl, bl);
        this.onFillEntityFullInfo_PSDynaDEForm(pSDynaAppViewCtrl, bl);
    }

    protected void onFillEntityFullInfo_PSDynaAppView(PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaDEForm(PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl) throws Exception {
        if (pSDynaAppViewCtrl.isPSDynaDEFormIdDirty()) {
            if (pSDynaAppViewCtrl.getPSDynaDEFormId() != null) {
                if (pSDynaAppViewCtrl.getPSDynaDEFormId() == null || pSDynaAppViewCtrl.getPSDynaDEFormName() == null) {
                    PSDynaDEForm pSDynaDEForm = pSDynaAppViewCtrl.getPSDynaDEForm();
                    pSDynaAppViewCtrl.setPSDynaDEFormName(pSDynaDEForm.getPSDynaDEFormName());
                }
            } else {
                pSDynaAppViewCtrl.setPSDynaDEFormName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDynaAppViewCtrl, bl);
    }

    public ArrayList<PSDynaAppViewCtrl> selectByPSDynaAppView(PSDynaAppViewBase pSDynaAppViewBase) throws Exception {
        return this.selectByPSDynaAppView(pSDynaAppViewBase, "", -1);
    }

    public ArrayList<PSDynaAppViewCtrl> selectByPSDynaAppView(PSDynaAppViewBase pSDynaAppViewBase, String string) throws Exception {
        return this.selectByPSDynaAppView(pSDynaAppViewBase, string, -1);
    }

    public ArrayList<PSDynaAppViewCtrl> selectByPSDynaAppView(PSDynaAppViewBase pSDynaAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAAPPVIEWID", (Object)pSDynaAppViewBase.getPSDynaAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaAppViewCtrl> selectByPSDynaDEForm(PSDynaDEFormBase pSDynaDEFormBase) throws Exception {
        return this.selectByPSDynaDEForm(pSDynaDEFormBase, "", -1);
    }

    public ArrayList<PSDynaAppViewCtrl> selectByPSDynaDEForm(PSDynaDEFormBase pSDynaDEFormBase, String string) throws Exception {
        return this.selectByPSDynaDEForm(pSDynaDEFormBase, string, -1);
    }

    public ArrayList<PSDynaAppViewCtrl> selectByPSDynaDEForm(PSDynaDEFormBase pSDynaDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNADEFORMID", (Object)pSDynaDEFormBase.getPSDynaDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaDEFormCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
    }

    public void resetPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
        ArrayList<PSDynaAppViewCtrl> arrayList = this.selectByPSDynaAppView(pSDynaAppView);
        for (PSDynaAppViewCtrl pSDynaAppViewCtrl : arrayList) {
            PSDynaAppViewCtrl pSDynaAppViewCtrl2 = (PSDynaAppViewCtrl)this.getDEModel().createEntity();
            pSDynaAppViewCtrl2.setPSDynaAppViewCtrlId(pSDynaAppViewCtrl.getPSDynaAppViewCtrlId());
            pSDynaAppViewCtrl2.setPSDynaAppViewId(null);
            this.update(pSDynaAppViewCtrl2);
        }
    }

    public void removeByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
        final PSDynaAppView pSDynaAppView2 = pSDynaAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewCtrlServiceBase.this.onBeforeRemoveByPSDynaAppView(pSDynaAppView2);
                PSDynaAppViewCtrlServiceBase.this.internalRemoveByPSDynaAppView(pSDynaAppView2);
                PSDynaAppViewCtrlServiceBase.this.onAfterRemoveByPSDynaAppView(pSDynaAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
    }

    protected void internalRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
        ArrayList<PSDynaAppViewCtrl> arrayList = this.selectByPSDynaAppView(pSDynaAppView);
        this.onBeforeRemoveByPSDynaAppView(pSDynaAppView, arrayList);
        for (PSDynaAppViewCtrl pSDynaAppViewCtrl : arrayList) {
            this.remove((IEntity)pSDynaAppViewCtrl);
        }
        this.onAfterRemoveByPSDynaAppView(pSDynaAppView, arrayList);
    }

    protected void onAfterRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView, ArrayList<PSDynaAppViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView, ArrayList<PSDynaAppViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        ArrayList<PSDynaAppViewCtrl> arrayList = this.selectByPSDynaDEForm(pSDynaDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNADEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAAPPVIEWCTRL_PSDYNADEFORM_PSDYNADEFORMID", "", iDataEntityModel.getName(), "PSDYNAAPPVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDynaDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        ArrayList<PSDynaAppViewCtrl> arrayList = this.selectByPSDynaDEForm(pSDynaDEForm);
        for (PSDynaAppViewCtrl pSDynaAppViewCtrl : arrayList) {
            PSDynaAppViewCtrl pSDynaAppViewCtrl2 = (PSDynaAppViewCtrl)this.getDEModel().createEntity();
            pSDynaAppViewCtrl2.setPSDynaAppViewCtrlId(pSDynaAppViewCtrl.getPSDynaAppViewCtrlId());
            pSDynaAppViewCtrl2.setPSDynaDEFormId(null);
            this.update(pSDynaAppViewCtrl2);
        }
    }

    public void removeByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        final PSDynaDEForm pSDynaDEForm2 = pSDynaDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewCtrlServiceBase.this.onBeforeRemoveByPSDynaDEForm(pSDynaDEForm2);
                PSDynaAppViewCtrlServiceBase.this.internalRemoveByPSDynaDEForm(pSDynaDEForm2);
                PSDynaAppViewCtrlServiceBase.this.onAfterRemoveByPSDynaDEForm(pSDynaDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
    }

    protected void internalRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        ArrayList<PSDynaAppViewCtrl> arrayList = this.selectByPSDynaDEForm(pSDynaDEForm);
        this.onBeforeRemoveByPSDynaDEForm(pSDynaDEForm, arrayList);
        for (PSDynaAppViewCtrl pSDynaAppViewCtrl : arrayList) {
            this.remove((IEntity)pSDynaAppViewCtrl);
        }
        this.onAfterRemoveByPSDynaDEForm(pSDynaDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm, ArrayList<PSDynaAppViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm, ArrayList<PSDynaAppViewCtrl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
        PSDynaAppVCInstService pSDynaAppVCInstService = (PSDynaAppVCInstService)ServiceGlobal.getService(PSDynaAppVCInstService.class, (SessionFactory)this.getSessionFactory());
        pSDynaAppVCInstService.testRemoveByPSDynaAppViewCtrl(pSDynaAppViewCtrl);
        super.onBeforeRemove(pSDynaAppViewCtrl);
    }

    protected void replaceParentInfo(PSDynaAppViewCtrl pSDynaAppViewCtrl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDynaAppViewCtrl, cloneSession);
        if (pSDynaAppViewCtrl.getPSDynaAppViewId() != null && (iEntity = cloneSession.getEntity("PSDYNAAPPVIEW", (Object)pSDynaAppViewCtrl.getPSDynaAppViewId())) != null) {
            this.onFillParentInfo_PSDynaAppView(pSDynaAppViewCtrl, (PSDynaAppView)iEntity);
        }
        if (pSDynaAppViewCtrl.getPSDynaDEFormId() != null && (iEntity = cloneSession.getEntity("PSDYNADEFORM", (Object)pSDynaAppViewCtrl.getPSDynaDEFormId())) != null) {
            this.onFillParentInfo_PSDynaDEForm(pSDynaAppViewCtrl, (PSDynaDEForm)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDynaAppViewCtrl, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CtrlType(bl, pSDynaAppViewCtrl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaAppViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewCtrlId(bl, pSDynaAppViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewCtrlName(bl, pSDynaAppViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewId(bl, pSDynaAppViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormId(bl, pSDynaAppViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormName(bl, pSDynaAppViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDynaAppViewCtrl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CtrlType(boolean bl, PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewCtrl.isCtrlTypeDirty() && !bl2 : !pSDynaAppViewCtrl.isCtrlTypeDirty()) {
            return null;
        }
        String string = pSDynaAppViewCtrl.getCtrlType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlType_Default((IEntity)pSDynaAppViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewCtrl.isMemoDirty() : !pSDynaAppViewCtrl.isMemoDirty()) {
            return null;
        }
        String string = pSDynaAppViewCtrl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDynaAppViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaAppViewCtrlId(boolean bl, PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewCtrl.isPSDynaAppViewCtrlIdDirty() && !bl2 : !pSDynaAppViewCtrl.isPSDynaAppViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDynaAppViewCtrl.getPSDynaAppViewCtrlId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWCTRLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewCtrlId_Default((IEntity)pSDynaAppViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewCtrlName(boolean bl, PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewCtrl.isPSDynaAppViewCtrlNameDirty() && !bl2 : !pSDynaAppViewCtrl.isPSDynaAppViewCtrlNameDirty()) {
            return null;
        }
        String string = pSDynaAppViewCtrl.getPSDynaAppViewCtrlName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWCTRLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewCtrlName_Default((IEntity)pSDynaAppViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewId(boolean bl, PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewCtrl.isPSDynaAppViewIdDirty() : !pSDynaAppViewCtrl.isPSDynaAppViewIdDirty()) {
            return null;
        }
        String string = pSDynaAppViewCtrl.getPSDynaAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewId_Default((IEntity)pSDynaAppViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormId(boolean bl, PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewCtrl.isPSDynaDEFormIdDirty() : !pSDynaAppViewCtrl.isPSDynaDEFormIdDirty()) {
            return null;
        }
        String string = pSDynaAppViewCtrl.getPSDynaDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormId_Default((IEntity)pSDynaAppViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaDEFormName(boolean bl, PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewCtrl.isPSDynaDEFormNameDirty() : !pSDynaAppViewCtrl.isPSDynaDEFormNameDirty()) {
            return null;
        }
        String string = pSDynaAppViewCtrl.getPSDynaDEFormName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormName_Default((IEntity)pSDynaAppViewCtrl, bl2, bl3);
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

    protected void onSyncEntity(PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDynaAppViewCtrl, bl);
    }

    protected void onSyncIndexEntities(PSDynaAppViewCtrl pSDynaAppViewCtrl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDynaAppViewCtrl, bl);
    }

    public Object getDataContextValue(PSDynaAppViewCtrl pSDynaAppViewCtrl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDynaAppViewCtrl, string, iDataContextParam)) != null) {
            return object;
        }
        PSDynaAppView pSDynaAppView = pSDynaAppViewCtrl.getPSDynaAppView();
        if (pSDynaAppView != null && pSDynaAppView.contains(string)) {
            return pSDynaAppView.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaAppViewCtrl pSDynaAppViewCtrl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDynaAppViewCtrl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CtrlType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDynaAppViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWCTRLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDynaAppViewCtrl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
        super.onUpdateParent((IEntity)pSDynaAppViewCtrl);
    }

    @Override
    protected void exportCurXmlModel(PSDynaAppViewCtrl pSDynaAppViewCtrl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNAAPPVIEWCTRL");
        if (!bl) {
            pSDynaAppViewCtrl.setCreateDate(null);
            pSDynaAppViewCtrl.setCreateMan(null);
            pSDynaAppViewCtrl.setCtrlType(null);
            pSDynaAppViewCtrl.setPSDynaAppViewCtrlId(null);
            pSDynaAppViewCtrl.setPSDynaAppViewCtrlName(null);
            pSDynaAppViewCtrl.setPSDynaAppViewId(null);
            pSDynaAppViewCtrl.setPSDynaAppViewName(null);
            pSDynaAppViewCtrl.setUpdateDate(null);
            pSDynaAppViewCtrl.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaAppViewCtrl, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
        return pSDynaAppViewCtrl.getCtrlType();
    }
}

