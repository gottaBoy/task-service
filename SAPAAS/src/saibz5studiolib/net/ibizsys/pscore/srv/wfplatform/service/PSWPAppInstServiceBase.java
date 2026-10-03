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
import net.ibizsys.pscore.srv.wfplatform.dao.PSWPAppInstDAO;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPAppInstDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPApp;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppBase;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppInst;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPAppInstServiceBase
extends PSCoreSysServiceBase<PSWPAppInst> {
    private static final Log log = LogFactory.getLog(PSWPAppInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWPAppInstDEModel pSWPAppInstDEModel;
    private PSWPAppInstDAO pSWPAppInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfplatform.service.PSWPAppInstService";
    }

    public PSWPAppInstDEModel getPSWPAppInstDEModel() {
        if (this.pSWPAppInstDEModel == null) {
            try {
                this.pSWPAppInstDEModel = (PSWPAppInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPAppInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPAppInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWPAppInstDEModel();
    }

    public PSWPAppInstDAO getPSWPAppInstDAO() {
        if (this.pSWPAppInstDAO == null) {
            try {
                this.pSWPAppInstDAO = (PSWPAppInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfplatform.dao.PSWPAppInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPAppInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWPAppInstDAO();
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

    protected void onFillParentInfo(PSWPAppInst pSWPAppInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPAPPINST_PSWPAPP_PSWPAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPAppService", (SessionFactory)this.getSessionFactory());
            PSWPApp pSWPApp = (PSWPApp)iService.getDEModel().createEntity();
            pSWPApp.set("PSWPAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWPApp);
            } else {
                iService.get(pSWPApp);
            }
            this.onFillParentInfo_PSWPApp(pSWPAppInst, pSWPApp);
            return;
        }
        super.onFillParentInfo(pSWPAppInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSWPApp(PSWPAppInst pSWPAppInst, PSWPApp pSWPApp) throws Exception {
        pSWPAppInst.setPSWPAppId(pSWPApp.getPSWPAppId());
        pSWPAppInst.setPSWPAppName(pSWPApp.getPSWPAppName());
    }

    protected void onFillEntityFullInfo(PSWPAppInst pSWPAppInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWPAppInst, bl);
        this.onFillEntityFullInfo_PSWPApp(pSWPAppInst, bl);
    }

    protected void onFillEntityFullInfo_PSWPApp(PSWPAppInst pSWPAppInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWPAppInst pSWPAppInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSWPAppInst, bl);
    }

    public ArrayList<PSWPAppInst> selectByPSWPApp(PSWPAppBase pSWPAppBase) throws Exception {
        return this.selectByPSWPApp(pSWPAppBase, "", -1);
    }

    public ArrayList<PSWPAppInst> selectByPSWPApp(PSWPAppBase pSWPAppBase, String string) throws Exception {
        return this.selectByPSWPApp(pSWPAppBase, string, -1);
    }

    public ArrayList<PSWPAppInst> selectByPSWPApp(PSWPAppBase pSWPAppBase, String string, int n) throws Exception {
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
        ArrayList<PSWPAppInst> arrayList = this.selectByPSWPApp(pSWPApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWPAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWPApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPAPPINST_PSWPAPP_PSWPAPPID", "", iDataEntityModel.getName(), "PSWPAPPINST", iDataEntityModel.getDataInfo(pSWPApp), arrayList.get(0)));
        }
    }

    public void resetPSWPApp(PSWPApp pSWPApp) throws Exception {
        ArrayList<PSWPAppInst> arrayList = this.selectByPSWPApp(pSWPApp);
        for (PSWPAppInst pSWPAppInst : arrayList) {
            PSWPAppInst pSWPAppInst2 = (PSWPAppInst)this.getDEModel().createEntity();
            pSWPAppInst2.setPSWPAppInstId(pSWPAppInst.getPSWPAppInstId());
            pSWPAppInst2.setPSWPAppId(null);
            this.update(pSWPAppInst2);
        }
    }

    public void removeByPSWPApp(PSWPApp pSWPApp) throws Exception {
        final PSWPApp pSWPApp2 = pSWPApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPAppInstServiceBase.this.onBeforeRemoveByPSWPApp(pSWPApp2);
                PSWPAppInstServiceBase.this.internalRemoveByPSWPApp(pSWPApp2);
                PSWPAppInstServiceBase.this.onAfterRemoveByPSWPApp(pSWPApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSWPApp(PSWPApp pSWPApp) throws Exception {
    }

    protected void internalRemoveByPSWPApp(PSWPApp pSWPApp) throws Exception {
        ArrayList<PSWPAppInst> arrayList = this.selectByPSWPApp(pSWPApp);
        this.onBeforeRemoveByPSWPApp(pSWPApp, arrayList);
        for (PSWPAppInst pSWPAppInst : arrayList) {
            this.remove(pSWPAppInst);
        }
        this.onAfterRemoveByPSWPApp(pSWPApp, arrayList);
    }

    protected void onAfterRemoveByPSWPApp(PSWPApp pSWPApp) throws Exception {
    }

    protected void onBeforeRemoveByPSWPApp(PSWPApp pSWPApp, ArrayList<PSWPAppInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWPApp(PSWPApp pSWPApp, ArrayList<PSWPAppInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWPAppInst pSWPAppInst) throws Exception {
        PSWPDCAppInstService pSWPDCAppInstService = (PSWPDCAppInstService)ServiceGlobal.getService(PSWPDCAppInstService.class, (SessionFactory)this.getSessionFactory());
        pSWPDCAppInstService.testRemoveByPswpappinst(pSWPAppInst);
        super.onBeforeRemove(pSWPAppInst);
    }

    protected void replaceParentInfo(PSWPAppInst pSWPAppInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWPAppInst, cloneSession);
        if (pSWPAppInst.getPSWPAppId() != null && (iEntity = cloneSession.getEntity("PSWPAPP", (Object)pSWPAppInst.getPSWPAppId())) != null) {
            this.onFillParentInfo_PSWPApp(pSWPAppInst, (PSWPApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWPAppInst pSWPAppInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWPAppInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSWPAppInst pSWPAppInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSWPAppId(bl, pSWPAppInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPAppInstId(bl, pSWPAppInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPAppInstName(bl, pSWPAppInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWPAppInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSWPAppId(boolean bl, PSWPAppInst pSWPAppInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPAppInst.isPSWPAppIdDirty() && !bl2 : !pSWPAppInst.isPSWPAppIdDirty()) {
            return null;
        }
        String string = pSWPAppInst.getPSWPAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppId_Default(pSWPAppInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWPAppInstId(boolean bl, PSWPAppInst pSWPAppInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPAppInst.isPSWPAppInstIdDirty() && !bl2 : !pSWPAppInst.isPSWPAppInstIdDirty()) {
            return null;
        }
        String string = pSWPAppInst.getPSWPAppInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppInstId_Default(pSWPAppInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPAppInstName(boolean bl, PSWPAppInst pSWPAppInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPAppInst.isPSWPAppInstNameDirty() && !bl2 : !pSWPAppInst.isPSWPAppInstNameDirty()) {
            return null;
        }
        String string = pSWPAppInst.getPSWPAppInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppInstName_Default(pSWPAppInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWPAppInst pSWPAppInst, boolean bl) throws Exception {
        super.onSyncEntity(pSWPAppInst, bl);
    }

    protected void onSyncIndexEntities(PSWPAppInst pSWPAppInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWPAppInst, bl);
    }

    public Object getDataContextValue(PSWPAppInst pSWPAppInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWPAppInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWPAppInst pSWPAppInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWPAppInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSWPAppInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPAppInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSWPAppInst pSWPAppInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWPAppInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWPAppInst pSWPAppInst) throws Exception {
        super.onUpdateParent(pSWPAppInst);
    }

    @Override
    protected void exportCurXmlModel(PSWPAppInst pSWPAppInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWPAPPINST");
        if (!bl) {
            pSWPAppInst.setCreateDate(null);
            pSWPAppInst.setCreateMan(null);
            pSWPAppInst.setPSWPAppInstId(null);
            pSWPAppInst.setPSWPAppName(null);
            pSWPAppInst.setUpdateDate(null);
            pSWPAppInst.setUpdateMan(null);
            super.exportCurXmlModel(pSWPAppInst, xmlNode, bl);
        }
    }
}

