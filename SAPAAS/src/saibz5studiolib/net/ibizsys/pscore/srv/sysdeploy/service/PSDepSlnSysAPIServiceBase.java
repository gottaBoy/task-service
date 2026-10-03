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
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysAPIDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysAPIDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysAPI;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysAPIServiceBase
extends PSCoreSysServiceBase<PSDepSlnSysAPI> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysAPIServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnSysAPIDEModel pSDepSlnSysAPIDEModel;
    private PSDepSlnSysAPIDAO pSDepSlnSysAPIDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysAPIService";
    }

    public PSDepSlnSysAPIDEModel getPSDepSlnSysAPIDEModel() {
        if (this.pSDepSlnSysAPIDEModel == null) {
            try {
                this.pSDepSlnSysAPIDEModel = (PSDepSlnSysAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysAPIDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysAPIDEModel();
    }

    public PSDepSlnSysAPIDAO getPSDepSlnSysAPIDAO() {
        if (this.pSDepSlnSysAPIDAO == null) {
            try {
                this.pSDepSlnSysAPIDAO = (PSDepSlnSysAPIDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysAPIDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysAPIDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysAPIDAO();
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

    protected void onFillParentInfo(PSDepSlnSysAPI pSDepSlnSysAPI, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSAPI_PSDEPSLNSYS_PSDEPSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSys pSDepSlnSys = (PSDepSlnSys)iService.getDEModel().createEntity();
            pSDepSlnSys.set("PSDEPSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnSys);
            } else {
                iService.get(pSDepSlnSys);
            }
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysAPI, pSDepSlnSys);
            return;
        }
        super.onFillParentInfo(pSDepSlnSysAPI, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnSys(PSDepSlnSysAPI pSDepSlnSysAPI, PSDepSlnSys pSDepSlnSys) throws Exception {
        pSDepSlnSysAPI.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
        pSDepSlnSysAPI.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnSysAPI, bl);
        this.onFillEntityFullInfo_PSDepSlnSys(pSDepSlnSysAPI, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnSys(PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnSysAPI, bl);
    }

    public ArrayList<PSDepSlnSysAPI> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSysAPI> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSysAPI> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNSYSID", (Object)pSDepSlnSysBase.getPSDepSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysAPI> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSAPI_PSDEPSLNSYS_PSDEPSLNSYSID", "", iDataEntityModel.getName(), "PSDEPSLNSYSAPI", iDataEntityModel.getDataInfo(pSDepSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysAPI> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        for (PSDepSlnSysAPI pSDepSlnSysAPI : arrayList) {
            PSDepSlnSysAPI pSDepSlnSysAPI2 = (PSDepSlnSysAPI)this.getDEModel().createEntity();
            pSDepSlnSysAPI2.setPSDepSlnSysAPIId(pSDepSlnSysAPI.getPSDepSlnSysAPIId());
            pSDepSlnSysAPI2.setPSDepSlnSysId(null);
            this.update(pSDepSlnSysAPI2);
        }
    }

    public void removeByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        final PSDepSlnSys pSDepSlnSys2 = pSDepSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysAPIServiceBase.this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysAPIServiceBase.this.internalRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysAPIServiceBase.this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysAPI> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
        for (PSDepSlnSysAPI pSDepSlnSysAPI : arrayList) {
            this.remove(pSDepSlnSysAPI);
        }
        this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysAPI> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSysAPI pSDepSlnSysAPI) throws Exception {
        super.onBeforeRemove(pSDepSlnSysAPI);
    }

    protected void replaceParentInfo(PSDepSlnSysAPI pSDepSlnSysAPI, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnSysAPI, cloneSession);
        if (pSDepSlnSysAPI.getPSDepSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYS", (Object)pSDepSlnSysAPI.getPSDepSlnSysId())) != null) {
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysAPI, (PSDepSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnSysAPI, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDepSlnSysAPIId(bl, pSDepSlnSysAPI, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysAPIName(bl, pSDepSlnSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnSysAPI, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDepSlnSysAPIId(boolean bl, PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAPI.isPSDepSlnSysAPIIdDirty() && !bl2 : !pSDepSlnSysAPI.isPSDepSlnSysAPIIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysAPI.getPSDepSlnSysAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysAPIId_Default(pSDepSlnSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysAPIName(boolean bl, PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAPI.isPSDepSlnSysAPINameDirty() && !bl2 : !pSDepSlnSysAPI.isPSDepSlnSysAPINameDirty()) {
            return null;
        }
        String string = pSDepSlnSysAPI.getPSDepSlnSysAPIName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSAPINAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysAPIName_Default(pSDepSlnSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAPI.isPSDepSlnSysIdDirty() : !pSDepSlnSysAPI.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysAPI.getPSDepSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default(pSDepSlnSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnSysAPI, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSysAPI pSDepSlnSysAPI, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnSysAPI, bl);
    }

    public Object getDataContextValue(PSDepSlnSysAPI pSDepSlnSysAPI, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnSysAPI, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSlnSys pSDepSlnSys = pSDepSlnSysAPI.getPSDepSlnSys();
        if (pSDepSlnSys != null && pSDepSlnSys.contains(string)) {
            return pSDepSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSysAPI pSDepSlnSysAPI, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnSysAPI, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSlnSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnSysAPI pSDepSlnSysAPI) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnSysAPI)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSysAPI pSDepSlnSysAPI) throws Exception {
        super.onUpdateParent(pSDepSlnSysAPI);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSysAPI pSDepSlnSysAPI, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYSAPI");
        if (!bl) {
            pSDepSlnSysAPI.setCreateDate(null);
            pSDepSlnSysAPI.setCreateMan(null);
            pSDepSlnSysAPI.setPSDepSlnSysAPIId(null);
            pSDepSlnSysAPI.setPSDepSlnSysName(null);
            pSDepSlnSysAPI.setUpdateDate(null);
            pSDepSlnSysAPI.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSysAPI, xmlNode, bl);
        }
    }
}

