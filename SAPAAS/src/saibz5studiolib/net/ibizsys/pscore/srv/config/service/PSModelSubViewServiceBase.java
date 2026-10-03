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
import net.ibizsys.pscore.srv.config.dao.PSModelSubViewDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelSubViewDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelSubView;
import net.ibizsys.pscore.srv.config.entity.PSModelView;
import net.ibizsys.pscore.srv.config.entity.PSModelViewBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelSubViewServiceBase
extends PSCoreSysServiceBase<PSModelSubView> {
    private static final Log log = LogFactory.getLog(PSModelSubViewServiceBase.class);
    private PSModelSubViewDEModel pSModelSubViewDEModel;
    private PSModelSubViewDAO pSModelSubViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelSubViewService";
    }

    public PSModelSubViewDEModel getPSModelSubViewDEModel() {
        if (this.pSModelSubViewDEModel == null) {
            try {
                this.pSModelSubViewDEModel = (PSModelSubViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelSubViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelSubViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelSubViewDEModel();
    }

    public PSModelSubViewDAO getPSModelSubViewDAO() {
        if (this.pSModelSubViewDAO == null) {
            try {
                this.pSModelSubViewDAO = (PSModelSubViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelSubViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelSubViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelSubViewDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSModelSubView pSModelSubView, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELSUBVIEW_PSMODELVIEW_PSMODELVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelViewService", (SessionFactory)this.getSessionFactory());
            PSModelView pSModelView = (PSModelView)iService.getDEModel().createEntity();
            pSModelView.set("PSMODELVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelView);
            } else {
                iService.get(pSModelView);
            }
            this.onFillParentInfo_PSModelView(pSModelSubView, pSModelView);
            return;
        }
        super.onFillParentInfo(pSModelSubView, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModelView(PSModelSubView pSModelSubView, PSModelView pSModelView) throws Exception {
        pSModelSubView.setPSModelViewId(pSModelView.getPSModelViewId());
        pSModelSubView.setPSModelViewName(pSModelView.getPSModelViewName());
    }

    protected void onFillEntityFullInfo(PSModelSubView pSModelSubView, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSModelSubView, bl);
        this.onFillEntityFullInfo_PSModelView(pSModelSubView, bl);
    }

    protected void onFillEntityFullInfo_PSModelView(PSModelSubView pSModelSubView, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSModelSubView pSModelSubView, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelSubView, bl);
    }

    public ArrayList<PSModelSubView> selectByPSModelView(PSModelViewBase pSModelViewBase) throws Exception {
        return this.selectByPSModelView(pSModelViewBase, "", -1);
    }

    public ArrayList<PSModelSubView> selectByPSModelView(PSModelViewBase pSModelViewBase, String string) throws Exception {
        return this.selectByPSModelView(pSModelViewBase, string, -1);
    }

    public ArrayList<PSModelSubView> selectByPSModelView(PSModelViewBase pSModelViewBase, String string, int n) throws Exception {
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

    public void testRemoveByPSModelView(PSModelView pSModelView) throws Exception {
    }

    public void resetPSModelView(PSModelView pSModelView) throws Exception {
        ArrayList<PSModelSubView> arrayList = this.selectByPSModelView(pSModelView);
        for (PSModelSubView pSModelSubView : arrayList) {
            PSModelSubView pSModelSubView2 = (PSModelSubView)this.getDEModel().createEntity();
            pSModelSubView2.setPSModelSubViewId(pSModelSubView.getPSModelSubViewId());
            pSModelSubView2.setPSModelViewId(null);
            this.update(pSModelSubView2);
        }
    }

    public void removeByPSModelView(PSModelView pSModelView) throws Exception {
        final PSModelView pSModelView2 = pSModelView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelSubViewServiceBase.this.onBeforeRemoveByPSModelView(pSModelView2);
                PSModelSubViewServiceBase.this.internalRemoveByPSModelView(pSModelView2);
                PSModelSubViewServiceBase.this.onAfterRemoveByPSModelView(pSModelView2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelView(PSModelView pSModelView) throws Exception {
    }

    protected void internalRemoveByPSModelView(PSModelView pSModelView) throws Exception {
        ArrayList<PSModelSubView> arrayList = this.selectByPSModelView(pSModelView);
        this.onBeforeRemoveByPSModelView(pSModelView, arrayList);
        for (PSModelSubView pSModelSubView : arrayList) {
            this.remove(pSModelSubView);
        }
        this.onAfterRemoveByPSModelView(pSModelView, arrayList);
    }

    protected void onAfterRemoveByPSModelView(PSModelView pSModelView) throws Exception {
    }

    protected void onBeforeRemoveByPSModelView(PSModelView pSModelView, ArrayList<PSModelSubView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelView(PSModelView pSModelView, ArrayList<PSModelSubView> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelSubView pSModelSubView) throws Exception {
        super.onBeforeRemove(pSModelSubView);
    }

    protected void replaceParentInfo(PSModelSubView pSModelSubView, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelSubView, cloneSession);
        if (pSModelSubView.getPSModelViewId() != null && (iEntity = cloneSession.getEntity("PSMODELVIEW", (Object)pSModelSubView.getPSModelViewId())) != null) {
            this.onFillParentInfo_PSModelView(pSModelSubView, (PSModelView)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelSubView pSModelSubView, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelSubView, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BottomContent(bl, pSModelSubView, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSModelSubView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderContent(bl, pSModelSubView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImageFlag(bl, pSModelSubView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelSubView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSModelSubView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelSubViewId(bl, pSModelSubView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelSubViewName(bl, pSModelSubView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelViewId(bl, pSModelSubView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubViewDesc(bl, pSModelSubView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelSubView, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BottomContent(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isBottomContentDirty() : !pSModelSubView.isBottomContentDirty()) {
            return null;
        }
        String string = pSModelSubView.getBottomContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomContent_Default(pSModelSubView, bl2, bl3);
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

    protected EntityFieldError onCheckField_Content(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isContentDirty() : !pSModelSubView.isContentDirty()) {
            return null;
        }
        String string = pSModelSubView.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSModelSubView, bl2, bl3);
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

    protected EntityFieldError onCheckField_HeaderContent(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isHeaderContentDirty() : !pSModelSubView.isHeaderContentDirty()) {
            return null;
        }
        String string = pSModelSubView.getHeaderContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderContent_Default(pSModelSubView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ImageFlag(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isImageFlagDirty() : !pSModelSubView.isImageFlagDirty()) {
            return null;
        }
        Integer n = pSModelSubView.getImageFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImageFlag_Default(pSModelSubView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMAGEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isMemoDirty() : !pSModelSubView.isMemoDirty()) {
            return null;
        }
        String string = pSModelSubView.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelSubView, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isOrderValueDirty() && !bl2 : !pSModelSubView.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSModelSubView.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSModelSubView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelSubViewId(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isPSModelSubViewIdDirty() && !bl2 : !pSModelSubView.isPSModelSubViewIdDirty()) {
            return null;
        }
        String string = pSModelSubView.getPSModelSubViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSUBVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelSubViewId_Default(pSModelSubView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSUBVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelSubViewName(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isPSModelSubViewNameDirty() && !bl2 : !pSModelSubView.isPSModelSubViewNameDirty()) {
            return null;
        }
        String string = pSModelSubView.getPSModelSubViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSUBVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelSubViewName_Default(pSModelSubView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSUBVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelViewId(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isPSModelViewIdDirty() && !bl2 : !pSModelSubView.isPSModelViewIdDirty()) {
            return null;
        }
        String string = pSModelSubView.getPSModelViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelViewId_Default(pSModelSubView, bl2, bl3);
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

    protected EntityFieldError onCheckField_SubViewDesc(boolean bl, PSModelSubView pSModelSubView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSubView.isSubViewDescDirty() : !pSModelSubView.isSubViewDescDirty()) {
            return null;
        }
        String string = pSModelSubView.getSubViewDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubViewDesc_Default(pSModelSubView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBVIEWDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelSubView pSModelSubView, boolean bl) throws Exception {
        super.onSyncEntity(pSModelSubView, bl);
    }

    protected void onSyncIndexEntities(PSModelSubView pSModelSubView, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelSubView, bl);
    }

    public Object getDataContextValue(PSModelSubView pSModelSubView, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelSubView, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelSubView pSModelSubView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelSubView, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BOTTOMCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_BottomContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_HeaderContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMAGEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ImageFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELSUBVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelSubViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELSUBVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelSubViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBVIEWDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SubViewDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ImageFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSModelSubViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELSUBVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelSubViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELSUBVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SubViewDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBVIEWDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSModelSubView pSModelSubView) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelSubView)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelSubView pSModelSubView) throws Exception {
        super.onUpdateParent(pSModelSubView);
    }

    @Override
    protected void exportCurXmlModel(PSModelSubView pSModelSubView, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELSUBVIEW");
        if (!bl) {
            pSModelSubView.setCreateDate(null);
            pSModelSubView.setCreateMan(null);
            pSModelSubView.setPSModelSubViewId(null);
            pSModelSubView.setUpdateDate(null);
            pSModelSubView.setUpdateMan(null);
            super.exportCurXmlModel(pSModelSubView, xmlNode, bl);
        }
    }
}

