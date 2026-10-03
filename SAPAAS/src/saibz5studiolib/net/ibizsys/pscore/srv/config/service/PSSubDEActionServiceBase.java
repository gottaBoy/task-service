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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSubDEActionDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSubDEActionDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSubDE;
import net.ibizsys.pscore.srv.config.entity.PSSubDEAction;
import net.ibizsys.pscore.srv.config.entity.PSSubDEBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubDEActionServiceBase
extends PSCoreSysServiceBase<PSSubDEAction> {
    private static final Log log = LogFactory.getLog(PSSubDEActionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSubDEActionDEModel pSSubDEActionDEModel;
    private PSSubDEActionDAO pSSubDEActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSubDEActionService";
    }

    public PSSubDEActionDEModel getPSSubDEActionDEModel() {
        if (this.pSSubDEActionDEModel == null) {
            try {
                this.pSSubDEActionDEModel = (PSSubDEActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSubDEActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubDEActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubDEActionDEModel();
    }

    public PSSubDEActionDAO getPSSubDEActionDAO() {
        if (this.pSSubDEActionDAO == null) {
            try {
                this.pSSubDEActionDAO = (PSSubDEActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSubDEActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubDEActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubDEActionDAO();
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

    protected void onFillParentInfo(PSSubDEAction pSSubDEAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBDEACTION_PSSUBDE_PSSUBDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubDEService", (SessionFactory)this.getSessionFactory());
            PSSubDE pSSubDE = (PSSubDE)iService.getDEModel().createEntity();
            pSSubDE.set("PSSUBDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubDE);
            } else {
                iService.get(pSSubDE);
            }
            this.onFillParentInfo_PSSubDE(pSSubDEAction, pSSubDE);
            return;
        }
        super.onFillParentInfo(pSSubDEAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSubDE(PSSubDEAction pSSubDEAction, PSSubDE pSSubDE) throws Exception {
        pSSubDEAction.setPSSubDEId(pSSubDE.getPSSubDEId());
        pSSubDEAction.setPSSubDEName(pSSubDE.getPSSubDEName());
    }

    protected boolean onFillEntityKeyValue(PSSubDEAction pSSubDEAction, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSubDEAction.get("PSSUBDEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSubDEAction.get("PSDEACTIONID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSubDEAction.set(this.getPSSubDEActionDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSubDEAction pSSubDEAction, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSubDEAction, bl);
        this.onFillEntityFullInfo_PSSubDE(pSSubDEAction, bl);
    }

    protected void onFillEntityFullInfo_PSSubDE(PSSubDEAction pSSubDEAction, boolean bl) throws Exception {
        if (pSSubDEAction.isPSSubDEIdDirty()) {
            if (pSSubDEAction.getPSSubDEId() != null) {
                if (pSSubDEAction.getPSSubDEId() == null || pSSubDEAction.getPSSubDEName() == null) {
                    PSSubDE pSSubDE = pSSubDEAction.getPSSubDE();
                    pSSubDEAction.setPSSubDEName(pSSubDE.getPSSubDEName());
                }
            } else {
                pSSubDEAction.setPSSubDEName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSubDEAction pSSubDEAction, boolean bl) throws Exception {
        super.onWriteBackParent(pSSubDEAction, bl);
    }

    public ArrayList<PSSubDEAction> selectByPSSubDE(PSSubDEBase pSSubDEBase) throws Exception {
        return this.selectByPSSubDE(pSSubDEBase, "", -1);
    }

    public ArrayList<PSSubDEAction> selectByPSSubDE(PSSubDEBase pSSubDEBase, String string) throws Exception {
        return this.selectByPSSubDE(pSSubDEBase, string, -1);
    }

    public ArrayList<PSSubDEAction> selectByPSSubDE(PSSubDEBase pSSubDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBDEID", (Object)pSSubDEBase.getPSSubDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSubDE(PSSubDE pSSubDE) throws Exception {
    }

    public void resetPSSubDE(PSSubDE pSSubDE) throws Exception {
        ArrayList<PSSubDEAction> arrayList = this.selectByPSSubDE(pSSubDE);
        for (PSSubDEAction pSSubDEAction : arrayList) {
            PSSubDEAction pSSubDEAction2 = (PSSubDEAction)this.getDEModel().createEntity();
            pSSubDEAction2.setPSSubDEActionId(pSSubDEAction.getPSSubDEActionId());
            pSSubDEAction2.setPSSubDEId(null);
            this.update(pSSubDEAction2);
        }
    }

    public void removeByPSSubDE(PSSubDE pSSubDE) throws Exception {
        final PSSubDE pSSubDE2 = pSSubDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubDEActionServiceBase.this.onBeforeRemoveByPSSubDE(pSSubDE2);
                PSSubDEActionServiceBase.this.internalRemoveByPSSubDE(pSSubDE2);
                PSSubDEActionServiceBase.this.onAfterRemoveByPSSubDE(pSSubDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubDE(PSSubDE pSSubDE) throws Exception {
    }

    protected void internalRemoveByPSSubDE(PSSubDE pSSubDE) throws Exception {
        ArrayList<PSSubDEAction> arrayList = this.selectByPSSubDE(pSSubDE);
        this.onBeforeRemoveByPSSubDE(pSSubDE, arrayList);
        for (PSSubDEAction pSSubDEAction : arrayList) {
            this.remove(pSSubDEAction);
        }
        this.onAfterRemoveByPSSubDE(pSSubDE, arrayList);
    }

    protected void onAfterRemoveByPSSubDE(PSSubDE pSSubDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSubDE(PSSubDE pSSubDE, ArrayList<PSSubDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubDE(PSSubDE pSSubDE, ArrayList<PSSubDEAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubDEAction pSSubDEAction) throws Exception {
        super.onBeforeRemove(pSSubDEAction);
    }

    protected void replaceParentInfo(PSSubDEAction pSSubDEAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSubDEAction, cloneSession);
        if (pSSubDEAction.getPSSubDEId() != null && (iEntity = cloneSession.getEntity("PSSUBDE", (Object)pSSubDEAction.getPSSubDEId())) != null) {
            this.onFillParentInfo_PSSubDE(pSSubDEAction, (PSSubDE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubDEAction pSSubDEAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSubDEAction, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubDEAction pSSubDEAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSubDEAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSubDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSubDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSSubDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubDEActionId(bl, pSSubDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubDEActionName(bl, pSSubDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubDEId(bl, pSSubDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubDEName(bl, pSSubDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSubDEAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSubDEAction pSSubDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEAction.isCodeNameDirty() && !bl2 : !pSSubDEAction.isCodeNameDirty()) {
            return null;
        }
        String string = pSSubDEAction.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSubDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSubDEAction pSSubDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEAction.isLogicNameDirty() : !pSSubDEAction.isLogicNameDirty()) {
            return null;
        }
        String string = pSSubDEAction.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSubDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubDEAction pSSubDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEAction.isMemoDirty() : !pSSubDEAction.isMemoDirty()) {
            return null;
        }
        String string = pSSubDEAction.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSubDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSSubDEAction pSSubDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEAction.isPSDEActionIdDirty() && !bl2 : !pSSubDEAction.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSSubDEAction.getPSDEActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSSubDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubDEActionId(boolean bl, PSSubDEAction pSSubDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEAction.isPSSubDEActionIdDirty() && !bl2 : !pSSubDEAction.isPSSubDEActionIdDirty()) {
            return null;
        }
        String string = pSSubDEAction.getPSSubDEActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubDEActionId_Default(pSSubDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubDEActionName(boolean bl, PSSubDEAction pSSubDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEAction.isPSSubDEActionNameDirty() && !bl2 : !pSSubDEAction.isPSSubDEActionNameDirty()) {
            return null;
        }
        String string = pSSubDEAction.getPSSubDEActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubDEActionName_Default(pSSubDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubDEId(boolean bl, PSSubDEAction pSSubDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEAction.isPSSubDEIdDirty() && !bl2 : !pSSubDEAction.isPSSubDEIdDirty()) {
            return null;
        }
        String string = pSSubDEAction.getPSSubDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubDEId_Default(pSSubDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubDEName(boolean bl, PSSubDEAction pSSubDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEAction.isPSSubDENameDirty() : !pSSubDEAction.isPSSubDENameDirty()) {
            return null;
        }
        String string = pSSubDEAction.getPSSubDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubDEName_Default(pSSubDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSubDEAction pSSubDEAction, boolean bl) throws Exception {
        super.onSyncEntity(pSSubDEAction, bl);
    }

    protected void onSyncIndexEntities(PSSubDEAction pSSubDEAction, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSubDEAction, bl);
    }

    public Object getDataContextValue(PSSubDEAction pSSubDEAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSubDEAction, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSubDEAction pSSubDEAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSubDEAction, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDEACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSubDEAction pSSubDEAction) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSubDEAction)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubDEAction pSSubDEAction) throws Exception {
        super.onUpdateParent(pSSubDEAction);
    }

    @Override
    protected void exportCurXmlModel(PSSubDEAction pSSubDEAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBDEACTION");
        if (!bl) {
            super.exportCurXmlModel(pSSubDEAction, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSubDEAction pSSubDEAction, PSSystem pSSystem) throws Exception {
        PSSubDEAction pSSubDEAction2 = new PSSubDEAction();
        pSSubDEAction2.setPSSubDEId(pSSubDEAction.getPSSubDEId());
        pSSubDEAction2.setPSDEActionId(pSSubDEAction.getPSDEActionId());
        if (this.selectOne(pSSubDEAction2, true)) {
            return pSSubDEAction2.getPSSubDEActionId();
        }
        return super.getEntityFolderKeyValue(pSSubDEAction, pSSystem);
    }
}

