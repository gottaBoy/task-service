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
package net.ibizsys.pscore.srv.wfplatform.service;

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
import net.ibizsys.pscore.srv.wfplatform.dao.PSWPAppEntityDAO;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPAppEntityDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPApp;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppBase;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppEntity;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPAppEntityServiceBase
extends PSCoreSysServiceBase<PSWPAppEntity> {
    private static final Log log = LogFactory.getLog(PSWPAppEntityServiceBase.class);
    private PSWPAppEntityDEModel pSWPAppEntityDEModel;
    private PSWPAppEntityDAO pSWPAppEntityDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfplatform.service.PSWPAppEntityService";
    }

    public PSWPAppEntityDEModel getPSWPAppEntityDEModel() {
        if (this.pSWPAppEntityDEModel == null) {
            try {
                this.pSWPAppEntityDEModel = (PSWPAppEntityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPAppEntityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPAppEntityDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWPAppEntityDEModel();
    }

    public PSWPAppEntityDAO getPSWPAppEntityDAO() {
        if (this.pSWPAppEntityDAO == null) {
            try {
                this.pSWPAppEntityDAO = (PSWPAppEntityDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfplatform.dao.PSWPAppEntityDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPAppEntityDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWPAppEntityDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSWPAppEntity pSWPAppEntity, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPAPPENTITY_PSWPAPP_PSWPAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPAppService", (SessionFactory)this.getSessionFactory());
            PSWPApp pSWPApp = (PSWPApp)iService.getDEModel().createEntity();
            pSWPApp.set("PSWPAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWPApp);
            } else {
                iService.get(pSWPApp);
            }
            this.onFillParentInfo_PSWPApp(pSWPAppEntity, pSWPApp);
            return;
        }
        super.onFillParentInfo(pSWPAppEntity, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSWPApp(PSWPAppEntity pSWPAppEntity, PSWPApp pSWPApp) throws Exception {
        pSWPAppEntity.setPSWPAppId(pSWPApp.getPSWPAppId());
        pSWPAppEntity.setPSWPAppName(pSWPApp.getPSWPAppName());
    }

    protected void onFillEntityFullInfo(PSWPAppEntity pSWPAppEntity, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWPAppEntity, bl);
        this.onFillEntityFullInfo_PSWPApp(pSWPAppEntity, bl);
    }

    protected void onFillEntityFullInfo_PSWPApp(PSWPAppEntity pSWPAppEntity, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWPAppEntity pSWPAppEntity, boolean bl) throws Exception {
        super.onWriteBackParent(pSWPAppEntity, bl);
    }

    public ArrayList<PSWPAppEntity> selectByPSWPApp(PSWPAppBase pSWPAppBase) throws Exception {
        return this.selectByPSWPApp(pSWPAppBase, "", -1);
    }

    public ArrayList<PSWPAppEntity> selectByPSWPApp(PSWPAppBase pSWPAppBase, String string) throws Exception {
        return this.selectByPSWPApp(pSWPAppBase, string, -1);
    }

    public ArrayList<PSWPAppEntity> selectByPSWPApp(PSWPAppBase pSWPAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWPAPPID", (Object)pSWPAppBase.getPSWPAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWPAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWPAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSWPApp(PSWPApp pSWPApp) throws Exception {
        ArrayList<PSWPAppEntity> arrayList = this.selectByPSWPApp(pSWPApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWPAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWPApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPAPPENTITY_PSWPAPP_PSWPAPPID", "", iDataEntityModel.getName(), "PSWPAPPENTITY", iDataEntityModel.getDataInfo(pSWPApp), arrayList.get(0)));
        }
    }

    public void resetPSWPApp(PSWPApp pSWPApp) throws Exception {
        ArrayList<PSWPAppEntity> arrayList = this.selectByPSWPApp(pSWPApp);
        for (PSWPAppEntity pSWPAppEntity : arrayList) {
            PSWPAppEntity pSWPAppEntity2 = (PSWPAppEntity)this.getDEModel().createEntity();
            pSWPAppEntity2.setPSWPAppEntityId(pSWPAppEntity.getPSWPAppEntityId());
            pSWPAppEntity2.setPSWPAppId(null);
            this.update(pSWPAppEntity2);
        }
    }

    public void removeByPSWPApp(PSWPApp pSWPApp) throws Exception {
        final PSWPApp pSWPApp2 = pSWPApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPAppEntityServiceBase.this.onBeforeRemoveByPSWPApp(pSWPApp2);
                PSWPAppEntityServiceBase.this.internalRemoveByPSWPApp(pSWPApp2);
                PSWPAppEntityServiceBase.this.onAfterRemoveByPSWPApp(pSWPApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSWPApp(PSWPApp pSWPApp) throws Exception {
    }

    protected void internalRemoveByPSWPApp(PSWPApp pSWPApp) throws Exception {
        ArrayList<PSWPAppEntity> arrayList = this.selectByPSWPApp(pSWPApp);
        this.onBeforeRemoveByPSWPApp(pSWPApp, arrayList);
        for (PSWPAppEntity pSWPAppEntity : arrayList) {
            this.remove(pSWPAppEntity);
        }
        this.onAfterRemoveByPSWPApp(pSWPApp, arrayList);
    }

    protected void onAfterRemoveByPSWPApp(PSWPApp pSWPApp) throws Exception {
    }

    protected void onBeforeRemoveByPSWPApp(PSWPApp pSWPApp, ArrayList<PSWPAppEntity> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWPApp(PSWPApp pSWPApp, ArrayList<PSWPAppEntity> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWPAppEntity pSWPAppEntity) throws Exception {
        PSWPDCAppEntityService pSWPDCAppEntityService = (PSWPDCAppEntityService)ServiceGlobal.getService(PSWPDCAppEntityService.class, (SessionFactory)this.getSessionFactory());
        pSWPDCAppEntityService.testRemoveByPSWPAppEntity(pSWPAppEntity);
        super.onBeforeRemove(pSWPAppEntity);
    }

    protected void replaceParentInfo(PSWPAppEntity pSWPAppEntity, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWPAppEntity, cloneSession);
        if (pSWPAppEntity.getPSWPAppId() != null && (iEntity = cloneSession.getEntity("PSWPAPP", (Object)pSWPAppEntity.getPSWPAppId())) != null) {
            this.onFillParentInfo_PSWPApp(pSWPAppEntity, (PSWPApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWPAppEntity pSWPAppEntity, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWPAppEntity, bl);
    }

    protected void onCheckEntity(boolean bl, PSWPAppEntity pSWPAppEntity, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSWPAppEntityId(bl, pSWPAppEntity, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPAppEntityName(bl, pSWPAppEntity, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPAppId(bl, pSWPAppEntity, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWPAppEntity, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSWPAppEntityId(boolean bl, PSWPAppEntity pSWPAppEntity, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPAppEntity.isPSWPAppEntityIdDirty() && !bl2 : !pSWPAppEntity.isPSWPAppEntityIdDirty()) {
            return null;
        }
        String string = pSWPAppEntity.getPSWPAppEntityId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPENTITYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppEntityId_Default(pSWPAppEntity, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPENTITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPAppEntityName(boolean bl, PSWPAppEntity pSWPAppEntity, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPAppEntity.isPSWPAppEntityNameDirty() && !bl2 : !pSWPAppEntity.isPSWPAppEntityNameDirty()) {
            return null;
        }
        String string = pSWPAppEntity.getPSWPAppEntityName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPENTITYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppEntityName_Default(pSWPAppEntity, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPENTITYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPAppId(boolean bl, PSWPAppEntity pSWPAppEntity, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPAppEntity.isPSWPAppIdDirty() && !bl2 : !pSWPAppEntity.isPSWPAppIdDirty()) {
            return null;
        }
        String string = pSWPAppEntity.getPSWPAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppId_Default(pSWPAppEntity, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWPAppEntity pSWPAppEntity, boolean bl) throws Exception {
        super.onSyncEntity(pSWPAppEntity, bl);
    }

    protected void onSyncIndexEntities(PSWPAppEntity pSWPAppEntity, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWPAppEntity, bl);
    }

    public Object getDataContextValue(PSWPAppEntity pSWPAppEntity, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWPAppEntity, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWPAppEntity pSWPAppEntity, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWPAppEntity, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPENTITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppEntityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPENTITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppEntityName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
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

    protected String onTestValueRule_PSWPAppEntityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPENTITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPAppEntityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPENTITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWPAppEntity pSWPAppEntity) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWPAppEntity)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWPAppEntity pSWPAppEntity) throws Exception {
        super.onUpdateParent(pSWPAppEntity);
    }

    @Override
    protected void exportCurXmlModel(PSWPAppEntity pSWPAppEntity, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWPAPPENTITY");
        if (!bl) {
            pSWPAppEntity.setCreateDate(null);
            pSWPAppEntity.setCreateMan(null);
            pSWPAppEntity.setPSWPAppEntityId(null);
            pSWPAppEntity.setPSWPAppName(null);
            pSWPAppEntity.setUpdateDate(null);
            pSWPAppEntity.setUpdateMan(null);
            super.exportCurXmlModel(pSWPAppEntity, xmlNode, bl);
        }
    }
}

