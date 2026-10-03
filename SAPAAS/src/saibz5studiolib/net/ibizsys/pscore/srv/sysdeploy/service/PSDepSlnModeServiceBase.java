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
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnModeDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnModeDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnMode;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModePrdService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModePrdServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnModeServiceBase
extends PSCoreSysServiceBase<PSDepSlnMode> {
    private static final Log log = LogFactory.getLog(PSDepSlnModeServiceBase.class);
    public static final String DATASET_CURDEPSLN = "CurDepSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnModeDEModel pSDepSlnModeDEModel;
    private PSDepSlnModeDAO pSDepSlnModeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModeService";
    }

    public PSDepSlnModeDEModel getPSDepSlnModeDEModel() {
        if (this.pSDepSlnModeDEModel == null) {
            try {
                this.pSDepSlnModeDEModel = (PSDepSlnModeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnModeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnModeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnModeDEModel();
    }

    public PSDepSlnModeDAO getPSDepSlnModeDAO() {
        if (this.pSDepSlnModeDAO == null) {
            try {
                this.pSDepSlnModeDAO = (PSDepSlnModeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnModeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnModeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnModeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEPSLN, (boolean)true) == 0) {
            return this.fetchCurDepSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDepSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEPSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSlnMode pSDepSlnMode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNMODE_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnMode, pSDepSln);
            return;
        }
        super.onFillParentInfo(pSDepSlnMode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnMode pSDepSlnMode, PSDepSln pSDepSln) throws Exception {
        pSDepSlnMode.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnMode.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSDepSlnMode pSDepSlnMode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnMode, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnMode, bl);
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnMode pSDepSlnMode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnMode pSDepSlnMode, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnMode, bl);
    }

    public ArrayList<PSDepSlnMode> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnMode> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnMode> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNID", (Object)pSDepSlnBase.getPSDepSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnMode> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnMode pSDepSlnMode : arrayList) {
            PSDepSlnMode pSDepSlnMode2 = (PSDepSlnMode)this.getDEModel().createEntity();
            pSDepSlnMode2.setPSDepSlnModeId(pSDepSlnMode.getPSDepSlnModeId());
            pSDepSlnMode2.setPSDepSlnId(null);
            this.update(pSDepSlnMode2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnModeServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnModeServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnModeServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnMode> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnMode pSDepSlnMode : arrayList) {
            this.remove(pSDepSlnMode);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnMode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnMode pSDepSlnMode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnModePrdService)ServiceGlobal.getService(PSDepSlnModePrdService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnModePrdServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnMode(pSDepSlnMode);
        pSCoreSysServiceBase = (PSDepSlnRunLogService)ServiceGlobal.getService(PSDepSlnRunLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnRunLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnMode(pSDepSlnMode);
        ((PSDepSlnRunLogServiceBase)pSCoreSysServiceBase).resetPSDepSlnMode(pSDepSlnMode);
        super.onBeforeRemove(pSDepSlnMode);
    }

    protected void replaceParentInfo(PSDepSlnMode pSDepSlnMode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnMode, cloneSession);
        if (pSDepSlnMode.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnMode.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnMode, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnMode pSDepSlnMode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnMode, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnMode pSDepSlnMode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSlnMode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnModeId(bl, pSDepSlnMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnModeName(bl, pSDepSlnMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnMode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnMode pSDepSlnMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMode.isMemoDirty() : !pSDepSlnMode.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnMode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSlnMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnMode pSDepSlnMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMode.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnMode.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnMode.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnModeId(boolean bl, PSDepSlnMode pSDepSlnMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMode.isPSDepSlnModeIdDirty() && !bl2 : !pSDepSlnMode.isPSDepSlnModeIdDirty()) {
            return null;
        }
        String string = pSDepSlnMode.getPSDepSlnModeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnModeId_Default(pSDepSlnMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnModeName(boolean bl, PSDepSlnMode pSDepSlnMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMode.isPSDepSlnModeNameDirty() && !bl2 : !pSDepSlnMode.isPSDepSlnModeNameDirty()) {
            return null;
        }
        String string = pSDepSlnMode.getPSDepSlnModeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnModeName_Default(pSDepSlnMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEPSLNID";
                String string4 = this.checkFieldDupRule(this.getPSDepSlnModeDEModel(), "PSDEPSLNMODENAME", string3, pSDepSlnMode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEPSLNMODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnMode pSDepSlnMode, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnMode, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnMode pSDepSlnMode, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnMode, bl);
    }

    public Object getDataContextValue(PSDepSlnMode pSDepSlnMode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnMode, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnMode.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnMode pSDepSlnMode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnMode, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDepSlnMode pSDepSlnMode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnMode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnMode pSDepSlnMode) throws Exception {
        super.onUpdateParent(pSDepSlnMode);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnMode pSDepSlnMode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNMODE");
        if (!bl) {
            super.exportCurXmlModel(pSDepSlnMode, xmlNode, bl);
        }
    }
}

