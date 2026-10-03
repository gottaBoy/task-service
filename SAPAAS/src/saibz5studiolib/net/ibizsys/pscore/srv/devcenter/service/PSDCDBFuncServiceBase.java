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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCDBFuncDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBFuncDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBFunc;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDBFuncServiceBase
extends PSCoreSysServiceBase<PSDCDBFunc> {
    private static final Log log = LogFactory.getLog(PSDCDBFuncServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCDBFuncDEModel pSDCDBFuncDEModel;
    private PSDCDBFuncDAO pSDCDBFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCDBFuncService";
    }

    public PSDCDBFuncDEModel getPSDCDBFuncDEModel() {
        if (this.pSDCDBFuncDEModel == null) {
            try {
                this.pSDCDBFuncDEModel = (PSDCDBFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCDBFuncDEModel();
    }

    public PSDCDBFuncDAO getPSDCDBFuncDAO() {
        if (this.pSDCDBFuncDAO == null) {
            try {
                this.pSDCDBFuncDAO = (PSDCDBFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCDBFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCDBFuncDAO();
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

    protected void onFillParentInfo(PSDCDBFunc pSDCDBFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDBFUNC_PSDEVCENTERDBINST_PSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_Psdcdbinst(pSDCDBFunc, pSDevCenterDBInst);
            return;
        }
        super.onFillParentInfo(pSDCDBFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psdcdbinst(PSDCDBFunc pSDCDBFunc, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDCDBFunc.setPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDCDBFunc.setPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillEntityFullInfo(PSDCDBFunc pSDCDBFunc, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCDBFunc, bl);
        this.onFillEntityFullInfo_Psdcdbinst(pSDCDBFunc, bl);
    }

    protected void onFillEntityFullInfo_Psdcdbinst(PSDCDBFunc pSDCDBFunc, boolean bl) throws Exception {
        if (pSDCDBFunc.isPSDCDBInstIdDirty()) {
            if (pSDCDBFunc.getPSDCDBInstId() != null) {
                if (pSDCDBFunc.getPSDCDBInstId() == null || pSDCDBFunc.getPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDCDBFunc.getPsdcdbinst();
                    pSDCDBFunc.setPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDCDBFunc.setPSDCDBInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCDBFunc pSDCDBFunc, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCDBFunc, bl);
    }

    public ArrayList<PSDCDBFunc> selectByPsdcdbinst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPsdcdbinst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDCDBFunc> selectByPsdcdbinst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPsdcdbinst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDCDBFunc> selectByPsdcdbinst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsdcdbinstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsdcdbinstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    public void resetPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDCDBFunc> arrayList = this.selectByPsdcdbinst(pSDevCenterDBInst);
        for (PSDCDBFunc pSDCDBFunc : arrayList) {
            PSDCDBFunc pSDCDBFunc2 = (PSDCDBFunc)this.getDEModel().createEntity();
            pSDCDBFunc2.setPSDCDBFuncId(pSDCDBFunc.getPSDCDBFuncId());
            pSDCDBFunc2.setPSDCDBInstId(null);
            this.update(pSDCDBFunc2);
        }
    }

    public void removeByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDBFuncServiceBase.this.onBeforeRemoveByPsdcdbinst(pSDevCenterDBInst2);
                PSDCDBFuncServiceBase.this.internalRemoveByPsdcdbinst(pSDevCenterDBInst2);
                PSDCDBFuncServiceBase.this.onAfterRemoveByPsdcdbinst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDCDBFunc> arrayList = this.selectByPsdcdbinst(pSDevCenterDBInst);
        this.onBeforeRemoveByPsdcdbinst(pSDevCenterDBInst, arrayList);
        for (PSDCDBFunc pSDCDBFunc : arrayList) {
            this.remove(pSDCDBFunc);
        }
        this.onAfterRemoveByPsdcdbinst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDCDBFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDCDBFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCDBFunc pSDCDBFunc) throws Exception {
        super.onBeforeRemove(pSDCDBFunc);
    }

    protected void replaceParentInfo(PSDCDBFunc pSDCDBFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCDBFunc, cloneSession);
        if (pSDCDBFunc.getPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDCDBFunc.getPSDCDBInstId())) != null) {
            this.onFillParentInfo_Psdcdbinst(pSDCDBFunc, (PSDevCenterDBInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCDBFunc pSDCDBFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCDBFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCDBFunc pSDCDBFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCDBFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBFuncId(bl, pSDCDBFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBFuncName(bl, pSDCDBFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBInstId(bl, pSDCDBFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBInstName(bl, pSDCDBFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SQL(bl, pSDCDBFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCDBFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCDBFunc pSDCDBFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBFunc.isMemoDirty() : !pSDCDBFunc.isMemoDirty()) {
            return null;
        }
        String string = pSDCDBFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCDBFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDBFuncId(boolean bl, PSDCDBFunc pSDCDBFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBFunc.isPSDCDBFuncIdDirty() && !bl2 : !pSDCDBFunc.isPSDCDBFuncIdDirty()) {
            return null;
        }
        String string = pSDCDBFunc.getPSDCDBFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBFuncId_Default(pSDCDBFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDBFuncName(boolean bl, PSDCDBFunc pSDCDBFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBFunc.isPSDCDBFuncNameDirty() && !bl2 : !pSDCDBFunc.isPSDCDBFuncNameDirty()) {
            return null;
        }
        String string = pSDCDBFunc.getPSDCDBFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBFuncName_Default(pSDCDBFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDBInstId(boolean bl, PSDCDBFunc pSDCDBFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBFunc.isPSDCDBInstIdDirty() : !pSDCDBFunc.isPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDCDBFunc.getPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBInstId_Default(pSDCDBFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDBInstName(boolean bl, PSDCDBFunc pSDCDBFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBFunc.isPSDCDBInstNameDirty() : !pSDCDBFunc.isPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDCDBFunc.getPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBInstName_Default(pSDCDBFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SQL(boolean bl, PSDCDBFunc pSDCDBFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBFunc.isSQLDirty() : !pSDCDBFunc.isSQLDirty()) {
            return null;
        }
        String string = pSDCDBFunc.getSQL();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SQL_Default(pSDCDBFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCDBFunc pSDCDBFunc, boolean bl) throws Exception {
        super.onSyncEntity(pSDCDBFunc, bl);
    }

    protected void onSyncIndexEntities(PSDCDBFunc pSDCDBFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCDBFunc, bl);
    }

    public Object getDataContextValue(PSDCDBFunc pSDCDBFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCDBFunc, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCDBFunc pSDCDBFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCDBFunc, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCDBFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SQL_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SQL_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SQL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCDBFunc pSDCDBFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCDBFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCDBFunc pSDCDBFunc) throws Exception {
        super.onUpdateParent(pSDCDBFunc);
    }

    @Override
    protected void exportCurXmlModel(PSDCDBFunc pSDCDBFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCDBFUNC");
        if (!bl) {
            pSDCDBFunc.setCreateDate(null);
            pSDCDBFunc.setCreateMan(null);
            pSDCDBFunc.setPSDCDBFuncId(null);
            pSDCDBFunc.setUpdateDate(null);
            pSDCDBFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSDCDBFunc, xmlNode, bl);
        }
    }
}

