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
import net.ibizsys.pscore.srv.config.dao.PSModelViewUIActionDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelViewUIActionDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelUIAction;
import net.ibizsys.pscore.srv.config.entity.PSModelUIActionBase;
import net.ibizsys.pscore.srv.config.entity.PSModelView;
import net.ibizsys.pscore.srv.config.entity.PSModelViewBase;
import net.ibizsys.pscore.srv.config.entity.PSModelViewUIAction;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelViewUIActionServiceBase
extends PSCoreSysServiceBase<PSModelViewUIAction> {
    private static final Log log = LogFactory.getLog(PSModelViewUIActionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelViewUIActionDEModel pSModelViewUIActionDEModel;
    private PSModelViewUIActionDAO pSModelViewUIActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelViewUIActionService";
    }

    public PSModelViewUIActionDEModel getPSModelViewUIActionDEModel() {
        if (this.pSModelViewUIActionDEModel == null) {
            try {
                this.pSModelViewUIActionDEModel = (PSModelViewUIActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelViewUIActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelViewUIActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelViewUIActionDEModel();
    }

    public PSModelViewUIActionDAO getPSModelViewUIActionDAO() {
        if (this.pSModelViewUIActionDAO == null) {
            try {
                this.pSModelViewUIActionDAO = (PSModelViewUIActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelViewUIActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelViewUIActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelViewUIActionDAO();
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

    protected void onFillParentInfo(PSModelViewUIAction pSModelViewUIAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELVIEWUIACTION_PSMODELUIACTION_PSMODELUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelUIActionService", (SessionFactory)this.getSessionFactory());
            PSModelUIAction pSModelUIAction = (PSModelUIAction)iService.getDEModel().createEntity();
            pSModelUIAction.set("PSMODELUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelUIAction);
            } else {
                iService.get(pSModelUIAction);
            }
            this.onFillParentInfo_PSModelUIAction(pSModelViewUIAction, pSModelUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELVIEWUIACTION_PSMODELVIEW_PSMODELVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelViewService", (SessionFactory)this.getSessionFactory());
            PSModelView pSModelView = (PSModelView)iService.getDEModel().createEntity();
            pSModelView.set("PSMODELVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelView);
            } else {
                iService.get(pSModelView);
            }
            this.onFillParentInfo_PSModelView(pSModelViewUIAction, pSModelView);
            return;
        }
        super.onFillParentInfo(pSModelViewUIAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModelUIAction(PSModelViewUIAction pSModelViewUIAction, PSModelUIAction pSModelUIAction) throws Exception {
        pSModelViewUIAction.setPSModelUIActionId(pSModelUIAction.getPSModelUIActionId());
        pSModelViewUIAction.setPSModelUIActionName(pSModelUIAction.getPSModelUIActionName());
    }

    protected void onFillParentInfo_PSModelView(PSModelViewUIAction pSModelViewUIAction, PSModelView pSModelView) throws Exception {
        pSModelViewUIAction.setPSModelViewId(pSModelView.getPSModelViewId());
        pSModelViewUIAction.setPSModelViewName(pSModelView.getPSModelViewName());
    }

    protected void onFillEntityFullInfo(PSModelViewUIAction pSModelViewUIAction, boolean bl) throws Exception {
        if (bl && pSModelViewUIAction.getValidFlag() == null) {
            pSModelViewUIAction.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSModelViewUIAction, bl);
        this.onFillEntityFullInfo_PSModelUIAction(pSModelViewUIAction, bl);
        this.onFillEntityFullInfo_PSModelView(pSModelViewUIAction, bl);
    }

    protected void onFillEntityFullInfo_PSModelUIAction(PSModelViewUIAction pSModelViewUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModelView(PSModelViewUIAction pSModelViewUIAction, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSModelViewUIAction pSModelViewUIAction, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelViewUIAction, bl);
    }

    public ArrayList<PSModelViewUIAction> selectByPSModelUIAction(PSModelUIActionBase pSModelUIActionBase) throws Exception {
        return this.selectByPSModelUIAction(pSModelUIActionBase, "", -1);
    }

    public ArrayList<PSModelViewUIAction> selectByPSModelUIAction(PSModelUIActionBase pSModelUIActionBase, String string) throws Exception {
        return this.selectByPSModelUIAction(pSModelUIActionBase, string, -1);
    }

    public ArrayList<PSModelViewUIAction> selectByPSModelUIAction(PSModelUIActionBase pSModelUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELUIACTIONID", (Object)pSModelUIActionBase.getPSModelUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelViewUIAction> selectByPSModelView(PSModelViewBase pSModelViewBase) throws Exception {
        return this.selectByPSModelView(pSModelViewBase, "", -1);
    }

    public ArrayList<PSModelViewUIAction> selectByPSModelView(PSModelViewBase pSModelViewBase, String string) throws Exception {
        return this.selectByPSModelView(pSModelViewBase, string, -1);
    }

    public ArrayList<PSModelViewUIAction> selectByPSModelView(PSModelViewBase pSModelViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELVIEWID", (Object)pSModelViewBase.getPSModelViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelViewCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModelUIAction(PSModelUIAction pSModelUIAction) throws Exception {
        ArrayList<PSModelViewUIAction> arrayList = this.selectByPSModelUIAction(pSModelUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModelUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELVIEWUIACTION_PSMODELUIACTION_PSMODELUIACTIONID", "", iDataEntityModel.getName(), "PSMODELVIEWUIACTION", iDataEntityModel.getDataInfo(pSModelUIAction), arrayList.get(0)));
        }
    }

    public void resetPSModelUIAction(PSModelUIAction pSModelUIAction) throws Exception {
        ArrayList<PSModelViewUIAction> arrayList = this.selectByPSModelUIAction(pSModelUIAction);
        for (PSModelViewUIAction pSModelViewUIAction : arrayList) {
            PSModelViewUIAction pSModelViewUIAction2 = (PSModelViewUIAction)this.getDEModel().createEntity();
            pSModelViewUIAction2.setPSModelViewUIActionId(pSModelViewUIAction.getPSModelViewUIActionId());
            pSModelViewUIAction2.setPSModelUIActionId(null);
            this.update(pSModelViewUIAction2);
        }
    }

    public void removeByPSModelUIAction(PSModelUIAction pSModelUIAction) throws Exception {
        final PSModelUIAction pSModelUIAction2 = pSModelUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelViewUIActionServiceBase.this.onBeforeRemoveByPSModelUIAction(pSModelUIAction2);
                PSModelViewUIActionServiceBase.this.internalRemoveByPSModelUIAction(pSModelUIAction2);
                PSModelViewUIActionServiceBase.this.onAfterRemoveByPSModelUIAction(pSModelUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelUIAction(PSModelUIAction pSModelUIAction) throws Exception {
    }

    protected void internalRemoveByPSModelUIAction(PSModelUIAction pSModelUIAction) throws Exception {
        ArrayList<PSModelViewUIAction> arrayList = this.selectByPSModelUIAction(pSModelUIAction);
        this.onBeforeRemoveByPSModelUIAction(pSModelUIAction, arrayList);
        for (PSModelViewUIAction pSModelViewUIAction : arrayList) {
            this.remove(pSModelViewUIAction);
        }
        this.onAfterRemoveByPSModelUIAction(pSModelUIAction, arrayList);
    }

    protected void onAfterRemoveByPSModelUIAction(PSModelUIAction pSModelUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSModelUIAction(PSModelUIAction pSModelUIAction, ArrayList<PSModelViewUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelUIAction(PSModelUIAction pSModelUIAction, ArrayList<PSModelViewUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSModelView(PSModelView pSModelView) throws Exception {
        ArrayList<PSModelViewUIAction> arrayList = this.selectByPSModelView(pSModelView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModelView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELVIEWUIACTION_PSMODELVIEW_PSMODELVIEWID", "", iDataEntityModel.getName(), "PSMODELVIEWUIACTION", iDataEntityModel.getDataInfo(pSModelView), arrayList.get(0)));
        }
    }

    public void resetPSModelView(PSModelView pSModelView) throws Exception {
        ArrayList<PSModelViewUIAction> arrayList = this.selectByPSModelView(pSModelView);
        for (PSModelViewUIAction pSModelViewUIAction : arrayList) {
            PSModelViewUIAction pSModelViewUIAction2 = (PSModelViewUIAction)this.getDEModel().createEntity();
            pSModelViewUIAction2.setPSModelViewUIActionId(pSModelViewUIAction.getPSModelViewUIActionId());
            pSModelViewUIAction2.setPSModelViewId(null);
            this.update(pSModelViewUIAction2);
        }
    }

    public void removeByPSModelView(PSModelView pSModelView) throws Exception {
        final PSModelView pSModelView2 = pSModelView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelViewUIActionServiceBase.this.onBeforeRemoveByPSModelView(pSModelView2);
                PSModelViewUIActionServiceBase.this.internalRemoveByPSModelView(pSModelView2);
                PSModelViewUIActionServiceBase.this.onAfterRemoveByPSModelView(pSModelView2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelView(PSModelView pSModelView) throws Exception {
    }

    protected void internalRemoveByPSModelView(PSModelView pSModelView) throws Exception {
        ArrayList<PSModelViewUIAction> arrayList = this.selectByPSModelView(pSModelView);
        this.onBeforeRemoveByPSModelView(pSModelView, arrayList);
        for (PSModelViewUIAction pSModelViewUIAction : arrayList) {
            this.remove(pSModelViewUIAction);
        }
        this.onAfterRemoveByPSModelView(pSModelView, arrayList);
    }

    protected void onAfterRemoveByPSModelView(PSModelView pSModelView) throws Exception {
    }

    protected void onBeforeRemoveByPSModelView(PSModelView pSModelView, ArrayList<PSModelViewUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelView(PSModelView pSModelView, ArrayList<PSModelViewUIAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelViewUIAction pSModelViewUIAction) throws Exception {
        super.onBeforeRemove(pSModelViewUIAction);
    }

    protected void replaceParentInfo(PSModelViewUIAction pSModelViewUIAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelViewUIAction, cloneSession);
        if (pSModelViewUIAction.getPSModelUIActionId() != null && (iEntity = cloneSession.getEntity("PSMODELUIACTION", (Object)pSModelViewUIAction.getPSModelUIActionId())) != null) {
            this.onFillParentInfo_PSModelUIAction(pSModelViewUIAction, (PSModelUIAction)iEntity);
        }
        if (pSModelViewUIAction.getPSModelViewId() != null && (iEntity = cloneSession.getEntity("PSMODELVIEW", (Object)pSModelViewUIAction.getPSModelViewId())) != null) {
            this.onFillParentInfo_PSModelView(pSModelViewUIAction, (PSModelView)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelViewUIAction pSModelViewUIAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelViewUIAction, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BottomContent(bl, pSModelViewUIAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderContent(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelUIActionId(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelViewId(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelViewUIActionId(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelViewUIActionName(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionDesc(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelViewUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelViewUIAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BottomContent(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isBottomContentDirty() : !pSModelViewUIAction.isBottomContentDirty()) {
            return null;
        }
        String string = pSModelViewUIAction.getBottomContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomContent_Default(pSModelViewUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isContentDirty() : !pSModelViewUIAction.isContentDirty()) {
            return null;
        }
        String string = pSModelViewUIAction.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSModelViewUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderContent(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isHeaderContentDirty() : !pSModelViewUIAction.isHeaderContentDirty()) {
            return null;
        }
        String string = pSModelViewUIAction.getHeaderContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderContent_Default(pSModelViewUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isMemoDirty() : !pSModelViewUIAction.isMemoDirty()) {
            return null;
        }
        String string = pSModelViewUIAction.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelViewUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isOrderValueDirty() && !bl2 : !pSModelViewUIAction.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSModelViewUIAction.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSModelViewUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelUIActionId(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isPSModelUIActionIdDirty() : !pSModelViewUIAction.isPSModelUIActionIdDirty()) {
            return null;
        }
        String string = pSModelViewUIAction.getPSModelUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelUIActionId_Default(pSModelViewUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelViewId(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isPSModelViewIdDirty() : !pSModelViewUIAction.isPSModelViewIdDirty()) {
            return null;
        }
        String string = pSModelViewUIAction.getPSModelViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelViewId_Default(pSModelViewUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelViewUIActionId(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isPSModelViewUIActionIdDirty() && !bl2 : !pSModelViewUIAction.isPSModelViewUIActionIdDirty()) {
            return null;
        }
        String string = pSModelViewUIAction.getPSModelViewUIActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWUIACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelViewUIActionId_Default(pSModelViewUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelViewUIActionName(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isPSModelViewUIActionNameDirty() && !bl2 : !pSModelViewUIAction.isPSModelViewUIActionNameDirty()) {
            return null;
        }
        String string = pSModelViewUIAction.getPSModelViewUIActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWUIACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelViewUIActionName_Default(pSModelViewUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWUIACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionDesc(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isUIActionDescDirty() : !pSModelViewUIAction.isUIActionDescDirty()) {
            return null;
        }
        String string = pSModelViewUIAction.getUIActionDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionDesc_Default(pSModelViewUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelViewUIAction pSModelViewUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelViewUIAction.isValidFlagDirty() && !bl2 : !pSModelViewUIAction.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelViewUIAction.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSModelViewUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelViewUIAction pSModelViewUIAction, boolean bl) throws Exception {
        super.onSyncEntity(pSModelViewUIAction, bl);
    }

    protected void onSyncIndexEntities(PSModelViewUIAction pSModelViewUIAction, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelViewUIAction, bl);
    }

    public Object getDataContextValue(PSModelViewUIAction pSModelViewUIAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelViewUIAction, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelViewUIAction pSModelViewUIAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelViewUIAction, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BOTTOMCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVIEWUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelViewUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVIEWUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelViewUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BottomContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_HeaderContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_PSModelUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelViewUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVIEWUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelViewUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVIEWUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSModelViewUIAction pSModelViewUIAction) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelViewUIAction)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelViewUIAction pSModelViewUIAction) throws Exception {
        super.onUpdateParent(pSModelViewUIAction);
    }

    @Override
    protected void exportCurXmlModel(PSModelViewUIAction pSModelViewUIAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELVIEWUIACTION");
        if (!bl) {
            pSModelViewUIAction.setCreateDate(null);
            pSModelViewUIAction.setCreateMan(null);
            pSModelViewUIAction.setPSModelUIActionName(null);
            pSModelViewUIAction.setPSModelViewName(null);
            pSModelViewUIAction.setPSModelViewUIActionId(null);
            pSModelViewUIAction.setUpdateDate(null);
            pSModelViewUIAction.setUpdateMan(null);
            super.exportCurXmlModel(pSModelViewUIAction, xmlNode, bl);
        }
    }
}

