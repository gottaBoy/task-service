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
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysApp;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysAppBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSaaSSysAppDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSaaSSysAppDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSaaSSysApp;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSaaSSysAppServiceBase
extends PSCoreSysServiceBase<PSDepSaaSSysApp> {
    private static final Log log = LogFactory.getLog(PSDepSaaSSysAppServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSaaSSysAppDEModel pSDepSaaSSysAppDEModel;
    private PSDepSaaSSysAppDAO pSDepSaaSSysAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSaaSSysAppService";
    }

    public PSDepSaaSSysAppDEModel getPSDepSaaSSysAppDEModel() {
        if (this.pSDepSaaSSysAppDEModel == null) {
            try {
                this.pSDepSaaSSysAppDEModel = (PSDepSaaSSysAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSaaSSysAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSaaSSysAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSaaSSysAppDEModel();
    }

    public PSDepSaaSSysAppDAO getPSDepSaaSSysAppDAO() {
        if (this.pSDepSaaSSysAppDAO == null) {
            try {
                this.pSDepSaaSSysAppDAO = (PSDepSaaSSysAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSaaSSysAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSaaSSysAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSaaSSysAppDAO();
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

    protected void onFillParentInfo(PSDepSaaSSysApp pSDepSaaSSysApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSAASSYSAPP_PSSAASSYSAPP_PSSAASSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSaaSSysApp pSSaaSSysApp = (PSSaaSSysApp)iService.getDEModel().createEntity();
            pSSaaSSysApp.set("PSSAASSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSaaSSysApp);
            } else {
                iService.get((IEntity)pSSaaSSysApp);
            }
            this.onFillParentInfo_PSSaaSSysApp(pSDepSaaSSysApp, pSSaaSSysApp);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSaaSSysApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSaaSSysApp(PSDepSaaSSysApp pSDepSaaSSysApp, PSSaaSSysApp pSSaaSSysApp) throws Exception {
        pSDepSaaSSysApp.setPSSaaSSysAppId(pSSaaSSysApp.getPSSaaSSysAppId());
        pSDepSaaSSysApp.setPSSaaSSysAppName(pSSaaSSysApp.getPSSaaSSysAppName());
    }

    protected void onFillEntityFullInfo(PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSaaSSysApp, bl);
        this.onFillEntityFullInfo_PSSaaSSysApp(pSDepSaaSSysApp, bl);
    }

    protected void onFillEntityFullInfo_PSSaaSSysApp(PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl) throws Exception {
        if (pSDepSaaSSysApp.isPSSaaSSysAppIdDirty()) {
            if (pSDepSaaSSysApp.getPSSaaSSysAppId() != null) {
                if (pSDepSaaSSysApp.getPSSaaSSysAppId() == null || pSDepSaaSSysApp.getPSSaaSSysAppName() == null) {
                    PSSaaSSysApp pSSaaSSysApp = pSDepSaaSSysApp.getPSSaaSSysApp();
                    pSDepSaaSSysApp.setPSSaaSSysAppName(pSSaaSSysApp.getPSSaaSSysAppName());
                }
            } else {
                pSDepSaaSSysApp.setPSSaaSSysAppName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSaaSSysApp, bl);
    }

    public ArrayList<PSDepSaaSSysApp> selectByPSSaaSSysApp(PSSaaSSysAppBase pSSaaSSysAppBase) throws Exception {
        return this.selectByPSSaaSSysApp(pSSaaSSysAppBase, "", -1);
    }

    public ArrayList<PSDepSaaSSysApp> selectByPSSaaSSysApp(PSSaaSSysAppBase pSSaaSSysAppBase, String string) throws Exception {
        return this.selectByPSSaaSSysApp(pSSaaSSysAppBase, string, -1);
    }

    public ArrayList<PSDepSaaSSysApp> selectByPSSaaSSysApp(PSSaaSSysAppBase pSSaaSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSAPPID", (Object)pSSaaSSysAppBase.getPSSaaSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
    }

    public void resetPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
        ArrayList<PSDepSaaSSysApp> arrayList = this.selectByPSSaaSSysApp(pSSaaSSysApp);
        for (PSDepSaaSSysApp pSDepSaaSSysApp : arrayList) {
            PSDepSaaSSysApp pSDepSaaSSysApp2 = (PSDepSaaSSysApp)this.getDEModel().createEntity();
            pSDepSaaSSysApp2.setPSDepSaaSSysAppId(pSDepSaaSSysApp.getPSDepSaaSSysAppId());
            pSDepSaaSSysApp2.setPSSaaSSysAppId(null);
            this.update(pSDepSaaSSysApp2);
        }
    }

    public void removeByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
        final PSSaaSSysApp pSSaaSSysApp2 = pSSaaSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSaaSSysAppServiceBase.this.onBeforeRemoveByPSSaaSSysApp(pSSaaSSysApp2);
                PSDepSaaSSysAppServiceBase.this.internalRemoveByPSSaaSSysApp(pSSaaSSysApp2);
                PSDepSaaSSysAppServiceBase.this.onAfterRemoveByPSSaaSSysApp(pSSaaSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
        ArrayList<PSDepSaaSSysApp> arrayList = this.selectByPSSaaSSysApp(pSSaaSSysApp);
        this.onBeforeRemoveByPSSaaSSysApp(pSSaaSSysApp, arrayList);
        for (PSDepSaaSSysApp pSDepSaaSSysApp : arrayList) {
            this.remove((IEntity)pSDepSaaSSysApp);
        }
        this.onAfterRemoveByPSSaaSSysApp(pSSaaSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp, ArrayList<PSDepSaaSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp, ArrayList<PSDepSaaSSysApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSaaSSysApp pSDepSaaSSysApp) throws Exception {
        super.onBeforeRemove(pSDepSaaSSysApp);
    }

    protected void replaceParentInfo(PSDepSaaSSysApp pSDepSaaSSysApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSaaSSysApp, cloneSession);
        if (pSDepSaaSSysApp.getPSSaaSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSAASSYSAPP", (Object)pSDepSaaSSysApp.getPSSaaSSysAppId())) != null) {
            this.onFillParentInfo_PSSaaSSysApp(pSDepSaaSSysApp, (PSSaaSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSaaSSysApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDepSaaSSysAppId(bl, pSDepSaaSSysApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSaaSSysAppName(bl, pSDepSaaSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysAppId(bl, pSDepSaaSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysAppName(bl, pSDepSaaSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSaaSSysApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDepSaaSSysAppId(boolean bl, PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSysApp.isPSDepSaaSSysAppIdDirty() && !bl2 : !pSDepSaaSSysApp.isPSDepSaaSSysAppIdDirty()) {
            return null;
        }
        String string = pSDepSaaSSysApp.getPSDepSaaSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSaaSSysAppId_Default((IEntity)pSDepSaaSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSaaSSysAppName(boolean bl, PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSysApp.isPSDepSaaSSysAppNameDirty() && !bl2 : !pSDepSaaSSysApp.isPSDepSaaSSysAppNameDirty()) {
            return null;
        }
        String string = pSDepSaaSSysApp.getPSDepSaaSSysAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSaaSSysAppName_Default((IEntity)pSDepSaaSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysAppId(boolean bl, PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSysApp.isPSSaaSSysAppIdDirty() : !pSDepSaaSSysApp.isPSSaaSSysAppIdDirty()) {
            return null;
        }
        String string = pSDepSaaSSysApp.getPSSaaSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysAppId_Default((IEntity)pSDepSaaSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysAppName(boolean bl, PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSysApp.isPSSaaSSysAppNameDirty() : !pSDepSaaSSysApp.isPSSaaSSysAppNameDirty()) {
            return null;
        }
        String string = pSDepSaaSSysApp.getPSSaaSSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysAppName_Default((IEntity)pSDepSaaSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSaaSSysApp, bl);
    }

    protected void onSyncIndexEntities(PSDepSaaSSysApp pSDepSaaSSysApp, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSaaSSysApp, bl);
    }

    public Object getDataContextValue(PSDepSaaSSysApp pSDepSaaSSysApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSaaSSysApp, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSaaSSysApp pSDepSaaSSysApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSaaSSysApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSAASSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSaaSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSAASSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSaaSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAppName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSaaSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSAASSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSaaSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSAASSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSaaSSysApp pSDepSaaSSysApp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSaaSSysApp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSaaSSysApp pSDepSaaSSysApp) throws Exception {
        super.onUpdateParent((IEntity)pSDepSaaSSysApp);
    }

    @Override
    protected void exportCurXmlModel(PSDepSaaSSysApp pSDepSaaSSysApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSAASSYSAPP");
        if (!bl) {
            pSDepSaaSSysApp.setCreateDate(null);
            pSDepSaaSSysApp.setCreateMan(null);
            pSDepSaaSSysApp.setPSDepSaaSSysAppId(null);
            pSDepSaaSSysApp.setUpdateDate(null);
            pSDepSaaSSysApp.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSaaSSysApp, xmlNode, bl);
        }
    }
}

