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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCDBSequDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBSequDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBSequ;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDBSequServiceBase
extends PSCoreSysServiceBase<PSDCDBSequ> {
    private static final Log log = LogFactory.getLog(PSDCDBSequServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCDBSequDEModel pSDCDBSequDEModel;
    private PSDCDBSequDAO pSDCDBSequDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCDBSequService";
    }

    public PSDCDBSequDEModel getPSDCDBSequDEModel() {
        if (this.pSDCDBSequDEModel == null) {
            try {
                this.pSDCDBSequDEModel = (PSDCDBSequDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBSequDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBSequDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCDBSequDEModel();
    }

    public PSDCDBSequDAO getPSDCDBSequDAO() {
        if (this.pSDCDBSequDAO == null) {
            try {
                this.pSDCDBSequDAO = (PSDCDBSequDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCDBSequDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBSequDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCDBSequDAO();
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

    protected void onFillParentInfo(PSDCDBSequ pSDCDBSequ, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDBSEQU_PSDEVCENTERDBINST_PSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterDBInst);
            } else {
                iService.get((IEntity)pSDevCenterDBInst);
            }
            this.onFillParentInfo_Psdcdbinst(pSDCDBSequ, pSDevCenterDBInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCDBSequ, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psdcdbinst(PSDCDBSequ pSDCDBSequ, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDCDBSequ.setPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDCDBSequ.setPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillEntityFullInfo(PSDCDBSequ pSDCDBSequ, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDCDBSequ, bl);
        this.onFillEntityFullInfo_Psdcdbinst(pSDCDBSequ, bl);
    }

    protected void onFillEntityFullInfo_Psdcdbinst(PSDCDBSequ pSDCDBSequ, boolean bl) throws Exception {
        if (pSDCDBSequ.isPSDCDBInstIdDirty()) {
            if (pSDCDBSequ.getPSDCDBInstId() != null) {
                if (pSDCDBSequ.getPSDCDBInstId() == null || pSDCDBSequ.getPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDCDBSequ.getPsdcdbinst();
                    pSDCDBSequ.setPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDCDBSequ.setPSDCDBInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCDBSequ pSDCDBSequ, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCDBSequ, bl);
    }

    public ArrayList<PSDCDBSequ> selectByPsdcdbinst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPsdcdbinst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDCDBSequ> selectByPsdcdbinst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPsdcdbinst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDCDBSequ> selectByPsdcdbinst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
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
        ArrayList<PSDCDBSequ> arrayList = this.selectByPsdcdbinst(pSDevCenterDBInst);
        for (PSDCDBSequ pSDCDBSequ : arrayList) {
            PSDCDBSequ pSDCDBSequ2 = (PSDCDBSequ)this.getDEModel().createEntity();
            pSDCDBSequ2.setPSDCDBSequId(pSDCDBSequ.getPSDCDBSequId());
            pSDCDBSequ2.setPSDCDBInstId(null);
            this.update(pSDCDBSequ2);
        }
    }

    public void removeByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDBSequServiceBase.this.onBeforeRemoveByPsdcdbinst(pSDevCenterDBInst2);
                PSDCDBSequServiceBase.this.internalRemoveByPsdcdbinst(pSDevCenterDBInst2);
                PSDCDBSequServiceBase.this.onAfterRemoveByPsdcdbinst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDCDBSequ> arrayList = this.selectByPsdcdbinst(pSDevCenterDBInst);
        this.onBeforeRemoveByPsdcdbinst(pSDevCenterDBInst, arrayList);
        for (PSDCDBSequ pSDCDBSequ : arrayList) {
            this.remove((IEntity)pSDCDBSequ);
        }
        this.onAfterRemoveByPsdcdbinst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDCDBSequ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsdcdbinst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDCDBSequ> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCDBSequ pSDCDBSequ) throws Exception {
        super.onBeforeRemove(pSDCDBSequ);
    }

    protected void replaceParentInfo(PSDCDBSequ pSDCDBSequ, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCDBSequ, cloneSession);
        if (pSDCDBSequ.getPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDCDBSequ.getPSDCDBInstId())) != null) {
            this.onFillParentInfo_Psdcdbinst(pSDCDBSequ, (PSDevCenterDBInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCDBSequ pSDCDBSequ, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCDBSequ, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCDBSequ pSDCDBSequ, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCDBSequ, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBInstId(bl, pSDCDBSequ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBInstName(bl, pSDCDBSequ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBSequId(bl, pSDCDBSequ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBSequName(bl, pSDCDBSequ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SQL(bl, pSDCDBSequ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCDBSequ, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCDBSequ pSDCDBSequ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBSequ.isMemoDirty() : !pSDCDBSequ.isMemoDirty()) {
            return null;
        }
        String string = pSDCDBSequ.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDCDBSequ, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDBInstId(boolean bl, PSDCDBSequ pSDCDBSequ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBSequ.isPSDCDBInstIdDirty() : !pSDCDBSequ.isPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDCDBSequ.getPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBInstId_Default((IEntity)pSDCDBSequ, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDBInstName(boolean bl, PSDCDBSequ pSDCDBSequ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBSequ.isPSDCDBInstNameDirty() : !pSDCDBSequ.isPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDCDBSequ.getPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBInstName_Default((IEntity)pSDCDBSequ, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDBSequId(boolean bl, PSDCDBSequ pSDCDBSequ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBSequ.isPSDCDBSequIdDirty() && !bl2 : !pSDCDBSequ.isPSDCDBSequIdDirty()) {
            return null;
        }
        String string = pSDCDBSequ.getPSDCDBSequId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBSEQUID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBSequId_Default((IEntity)pSDCDBSequ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBSEQUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDBSequName(boolean bl, PSDCDBSequ pSDCDBSequ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBSequ.isPSDCDBSequNameDirty() && !bl2 : !pSDCDBSequ.isPSDCDBSequNameDirty()) {
            return null;
        }
        String string = pSDCDBSequ.getPSDCDBSequName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBSEQUNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBSequName_Default((IEntity)pSDCDBSequ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBSEQUNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SQL(boolean bl, PSDCDBSequ pSDCDBSequ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBSequ.isSQLDirty() : !pSDCDBSequ.isSQLDirty()) {
            return null;
        }
        String string = pSDCDBSequ.getSQL();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SQL_Default((IEntity)pSDCDBSequ, bl2, bl3);
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

    protected void onSyncEntity(PSDCDBSequ pSDCDBSequ, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCDBSequ, bl);
    }

    protected void onSyncIndexEntities(PSDCDBSequ pSDCDBSequ, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCDBSequ, bl);
    }

    public Object getDataContextValue(PSDCDBSequ pSDCDBSequ, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCDBSequ, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCDBSequ pSDCDBSequ, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCDBSequ, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBSEQUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBSequId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBSEQUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBSequName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCDBSequId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBSEQUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBSequName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBSEQUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCDBSequ pSDCDBSequ) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCDBSequ)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCDBSequ pSDCDBSequ) throws Exception {
        super.onUpdateParent((IEntity)pSDCDBSequ);
    }

    @Override
    protected void exportCurXmlModel(PSDCDBSequ pSDCDBSequ, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCDBSEQU");
        if (!bl) {
            pSDCDBSequ.setCreateDate(null);
            pSDCDBSequ.setCreateMan(null);
            pSDCDBSequ.setPSDCDBSequId(null);
            pSDCDBSequ.setUpdateDate(null);
            pSDCDBSequ.setUpdateMan(null);
            super.exportCurXmlModel(pSDCDBSequ, xmlNode, bl);
        }
    }
}

