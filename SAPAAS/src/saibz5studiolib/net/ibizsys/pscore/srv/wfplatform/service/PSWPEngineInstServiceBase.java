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
import net.ibizsys.pscore.srv.wfplatform.dao.PSWPEngineInstDAO;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPEngineInstDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWFEngine;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWFEngineBase;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPEngineInst;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCEngineInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPEngineInstServiceBase
extends PSCoreSysServiceBase<PSWPEngineInst> {
    private static final Log log = LogFactory.getLog(PSWPEngineInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWPEngineInstDEModel pSWPEngineInstDEModel;
    private PSWPEngineInstDAO pSWPEngineInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfplatform.service.PSWPEngineInstService";
    }

    public PSWPEngineInstDEModel getPSWPEngineInstDEModel() {
        if (this.pSWPEngineInstDEModel == null) {
            try {
                this.pSWPEngineInstDEModel = (PSWPEngineInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPEngineInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPEngineInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWPEngineInstDEModel();
    }

    public PSWPEngineInstDAO getPSWPEngineInstDAO() {
        if (this.pSWPEngineInstDAO == null) {
            try {
                this.pSWPEngineInstDAO = (PSWPEngineInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfplatform.dao.PSWPEngineInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPEngineInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWPEngineInstDAO();
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

    protected void onFillParentInfo(PSWPEngineInst pSWPEngineInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPENGINEINST_PSWPENGINE_PSWPENGINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWFEngineService", (SessionFactory)this.getSessionFactory());
            PSWFEngine pSWFEngine = (PSWFEngine)iService.getDEModel().createEntity();
            pSWFEngine.set("PSWPENGINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFEngine);
            } else {
                iService.get(pSWFEngine);
            }
            this.onFillParentInfo_PSWPEngine(pSWPEngineInst, pSWFEngine);
            return;
        }
        super.onFillParentInfo(pSWPEngineInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSWPEngine(PSWPEngineInst pSWPEngineInst, PSWFEngine pSWFEngine) throws Exception {
        pSWPEngineInst.setPSWPEngineId(pSWFEngine.getPSWPEngineId());
        pSWPEngineInst.setPSWPEngineName(pSWFEngine.getPSWPEngineName());
    }

    protected void onFillEntityFullInfo(PSWPEngineInst pSWPEngineInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWPEngineInst, bl);
        this.onFillEntityFullInfo_PSWPEngine(pSWPEngineInst, bl);
    }

    protected void onFillEntityFullInfo_PSWPEngine(PSWPEngineInst pSWPEngineInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWPEngineInst pSWPEngineInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSWPEngineInst, bl);
    }

    public ArrayList<PSWPEngineInst> selectByPSWPEngine(PSWFEngineBase pSWFEngineBase) throws Exception {
        return this.selectByPSWPEngine(pSWFEngineBase, "", -1);
    }

    public ArrayList<PSWPEngineInst> selectByPSWPEngine(PSWFEngineBase pSWFEngineBase, String string) throws Exception {
        return this.selectByPSWPEngine(pSWFEngineBase, string, -1);
    }

    public ArrayList<PSWPEngineInst> selectByPSWPEngine(PSWFEngineBase pSWFEngineBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWPENGINEID", (Object)pSWFEngineBase.getPSWPEngineId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWPEngineCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWPEngineCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSWPEngine(PSWFEngine pSWFEngine) throws Exception {
        ArrayList<PSWPEngineInst> arrayList = this.selectByPSWPEngine(pSWFEngine, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFENGINE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFEngine);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPENGINEINST_PSWPENGINE_PSWPENGINEID", "", iDataEntityModel.getName(), "PSWPENGINEINST", iDataEntityModel.getDataInfo(pSWFEngine), arrayList.get(0)));
        }
    }

    public void resetPSWPEngine(PSWFEngine pSWFEngine) throws Exception {
        ArrayList<PSWPEngineInst> arrayList = this.selectByPSWPEngine(pSWFEngine);
        for (PSWPEngineInst pSWPEngineInst : arrayList) {
            PSWPEngineInst pSWPEngineInst2 = (PSWPEngineInst)this.getDEModel().createEntity();
            pSWPEngineInst2.setPSWPEngineInstId(pSWPEngineInst.getPSWPEngineInstId());
            pSWPEngineInst2.setPSWPEngineId(null);
            this.update(pSWPEngineInst2);
        }
    }

    public void removeByPSWPEngine(PSWFEngine pSWFEngine) throws Exception {
        final PSWFEngine pSWFEngine2 = pSWFEngine;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPEngineInstServiceBase.this.onBeforeRemoveByPSWPEngine(pSWFEngine2);
                PSWPEngineInstServiceBase.this.internalRemoveByPSWPEngine(pSWFEngine2);
                PSWPEngineInstServiceBase.this.onAfterRemoveByPSWPEngine(pSWFEngine2);
            }
        });
    }

    protected void onBeforeRemoveByPSWPEngine(PSWFEngine pSWFEngine) throws Exception {
    }

    protected void internalRemoveByPSWPEngine(PSWFEngine pSWFEngine) throws Exception {
        ArrayList<PSWPEngineInst> arrayList = this.selectByPSWPEngine(pSWFEngine);
        this.onBeforeRemoveByPSWPEngine(pSWFEngine, arrayList);
        for (PSWPEngineInst pSWPEngineInst : arrayList) {
            this.remove(pSWPEngineInst);
        }
        this.onAfterRemoveByPSWPEngine(pSWFEngine, arrayList);
    }

    protected void onAfterRemoveByPSWPEngine(PSWFEngine pSWFEngine) throws Exception {
    }

    protected void onBeforeRemoveByPSWPEngine(PSWFEngine pSWFEngine, ArrayList<PSWPEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWPEngine(PSWFEngine pSWFEngine, ArrayList<PSWPEngineInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWPEngineInst pSWPEngineInst) throws Exception {
        PSWPDCEngineInstService pSWPDCEngineInstService = (PSWPDCEngineInstService)ServiceGlobal.getService(PSWPDCEngineInstService.class, (SessionFactory)this.getSessionFactory());
        pSWPDCEngineInstService.testRemoveByPSWPEngineInst(pSWPEngineInst);
        super.onBeforeRemove(pSWPEngineInst);
    }

    protected void replaceParentInfo(PSWPEngineInst pSWPEngineInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWPEngineInst, cloneSession);
        if (pSWPEngineInst.getPSWPEngineId() != null && (iEntity = cloneSession.getEntity("PSWPENGINE", (Object)pSWPEngineInst.getPSWPEngineId())) != null) {
            this.onFillParentInfo_PSWPEngine(pSWPEngineInst, (PSWFEngine)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWPEngineInst pSWPEngineInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWPEngineInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSWPEngineInst pSWPEngineInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSWPEngineId(bl, pSWPEngineInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPEngineInstId(bl, pSWPEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPEngineInstName(bl, pSWPEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWPEngineInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSWPEngineId(boolean bl, PSWPEngineInst pSWPEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPEngineInst.isPSWPEngineIdDirty() && !bl2 : !pSWPEngineInst.isPSWPEngineIdDirty()) {
            return null;
        }
        String string = pSWPEngineInst.getPSWPEngineId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPEngineId_Default(pSWPEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPEngineInstId(boolean bl, PSWPEngineInst pSWPEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPEngineInst.isPSWPEngineInstIdDirty() && !bl2 : !pSWPEngineInst.isPSWPEngineInstIdDirty()) {
            return null;
        }
        String string = pSWPEngineInst.getPSWPEngineInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINEINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPEngineInstId_Default(pSWPEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPEngineInstName(boolean bl, PSWPEngineInst pSWPEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPEngineInst.isPSWPEngineInstNameDirty() && !bl2 : !pSWPEngineInst.isPSWPEngineInstNameDirty()) {
            return null;
        }
        String string = pSWPEngineInst.getPSWPEngineInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINEINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPEngineInstName_Default(pSWPEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINEINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWPEngineInst pSWPEngineInst, boolean bl) throws Exception {
        super.onSyncEntity(pSWPEngineInst, bl);
    }

    protected void onSyncIndexEntities(PSWPEngineInst pSWPEngineInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWPEngineInst, bl);
    }

    public Object getDataContextValue(PSWPEngineInst pSWPEngineInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWPEngineInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWPEngineInst pSWPEngineInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWPEngineInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPENGINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPEngineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPENGINEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPEngineInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPENGINEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPEngineInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPENGINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPEngineName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSWPEngineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPENGINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPEngineInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPENGINEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPEngineInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPENGINEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPEngineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPENGINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWPEngineInst pSWPEngineInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWPEngineInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWPEngineInst pSWPEngineInst) throws Exception {
        super.onUpdateParent(pSWPEngineInst);
    }

    @Override
    protected void exportCurXmlModel(PSWPEngineInst pSWPEngineInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWPENGINEINST");
        if (!bl) {
            pSWPEngineInst.setCreateDate(null);
            pSWPEngineInst.setCreateMan(null);
            pSWPEngineInst.setPSWPEngineInstId(null);
            pSWPEngineInst.setUpdateDate(null);
            pSWPEngineInst.setUpdateMan(null);
            super.exportCurXmlModel(pSWPEngineInst, xmlNode, bl);
        }
    }
}

