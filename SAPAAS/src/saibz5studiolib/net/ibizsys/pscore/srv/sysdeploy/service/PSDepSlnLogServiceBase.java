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
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnLogDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnLogDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnLog;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnLogServiceBase
extends PSCoreSysServiceBase<PSDepSlnLog> {
    private static final Log log = LogFactory.getLog(PSDepSlnLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnLogDEModel pSDepSlnLogDEModel;
    private PSDepSlnLogDAO pSDepSlnLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnLogService";
    }

    public PSDepSlnLogDEModel getPSDepSlnLogDEModel() {
        if (this.pSDepSlnLogDEModel == null) {
            try {
                this.pSDepSlnLogDEModel = (PSDepSlnLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnLogDEModel();
    }

    public PSDepSlnLogDAO getPSDepSlnLogDAO() {
        if (this.pSDepSlnLogDAO == null) {
            try {
                this.pSDepSlnLogDAO = (PSDepSlnLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnLogDAO();
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

    protected void onFillParentInfo(PSDepSlnLog pSDepSlnLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNLOG_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnLog, pSDepSln);
            return;
        }
        super.onFillParentInfo(pSDepSlnLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnLog pSDepSlnLog, PSDepSln pSDepSln) throws Exception {
        pSDepSlnLog.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnLog.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSDepSlnLog pSDepSlnLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnLog, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnLog, bl);
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnLog pSDepSlnLog, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnLog pSDepSlnLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnLog, bl);
    }

    public ArrayList<PSDepSlnLog> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnLog> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnLog> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
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
        ArrayList<PSDepSlnLog> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnLog pSDepSlnLog : arrayList) {
            PSDepSlnLog pSDepSlnLog2 = (PSDepSlnLog)this.getDEModel().createEntity();
            pSDepSlnLog2.setPSDepSlnLogId(pSDepSlnLog.getPSDepSlnLogId());
            pSDepSlnLog2.setPSDepSlnId(null);
            this.update(pSDepSlnLog2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnLogServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnLogServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnLogServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnLog> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnLog pSDepSlnLog : arrayList) {
            this.remove(pSDepSlnLog);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnLog pSDepSlnLog) throws Exception {
        super.onBeforeRemove(pSDepSlnLog);
    }

    protected void replaceParentInfo(PSDepSlnLog pSDepSlnLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnLog, cloneSession);
        if (pSDepSlnLog.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnLog.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnLog, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnLog pSDepSlnLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnLog pSDepSlnLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnLogId(bl, pSDepSlnLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnLogName(bl, pSDepSlnLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnLog pSDepSlnLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnLog.isPSDepSlnIdDirty() : !pSDepSlnLog.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnLog.getPSDepSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnLogId(boolean bl, PSDepSlnLog pSDepSlnLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnLog.isPSDepSlnLogIdDirty() && !bl2 : !pSDepSlnLog.isPSDepSlnLogIdDirty()) {
            return null;
        }
        String string = pSDepSlnLog.getPSDepSlnLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnLogId_Default(pSDepSlnLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnLogName(boolean bl, PSDepSlnLog pSDepSlnLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnLog.isPSDepSlnLogNameDirty() && !bl2 : !pSDepSlnLog.isPSDepSlnLogNameDirty()) {
            return null;
        }
        String string = pSDepSlnLog.getPSDepSlnLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnLogName_Default(pSDepSlnLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnLog pSDepSlnLog, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnLog, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnLog pSDepSlnLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnLog, bl);
    }

    public Object getDataContextValue(PSDepSlnLog pSDepSlnLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnLog pSDepSlnLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnLogName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSlnLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnLog pSDepSlnLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnLog pSDepSlnLog) throws Exception {
        super.onUpdateParent(pSDepSlnLog);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnLog pSDepSlnLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNLOG");
        if (!bl) {
            pSDepSlnLog.setPSDepSlnName(null);
            super.exportCurXmlModel(pSDepSlnLog, xmlNode, bl);
        }
    }
}

