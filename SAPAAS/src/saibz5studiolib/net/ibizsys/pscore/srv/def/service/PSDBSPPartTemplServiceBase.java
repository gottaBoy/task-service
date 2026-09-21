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
package net.ibizsys.pscore.srv.def.service;

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
import net.ibizsys.pscore.srv.def.dao.PSDBSPPartTemplDAO;
import net.ibizsys.pscore.srv.def.demodel.PSDBSPPartTemplDEModel;
import net.ibizsys.pscore.srv.def.entity.PSDBSPPartTempl;
import net.ibizsys.pscore.srv.def.entity.PSDBSysProcTempl;
import net.ibizsys.pscore.srv.def.entity.PSDBSysProcTemplBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBSPPartTemplServiceBase
extends PSCoreSysServiceBase<PSDBSPPartTempl> {
    private static final Log log = LogFactory.getLog(PSDBSPPartTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDBSPPartTemplDEModel pSDBSPPartTemplDEModel;
    private PSDBSPPartTemplDAO pSDBSPPartTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.def.service.PSDBSPPartTemplService";
    }

    public PSDBSPPartTemplDEModel getPSDBSPPartTemplDEModel() {
        if (this.pSDBSPPartTemplDEModel == null) {
            try {
                this.pSDBSPPartTemplDEModel = (PSDBSPPartTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSDBSPPartTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBSPPartTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDBSPPartTemplDEModel();
    }

    public PSDBSPPartTemplDAO getPSDBSPPartTemplDAO() {
        if (this.pSDBSPPartTemplDAO == null) {
            try {
                this.pSDBSPPartTemplDAO = (PSDBSPPartTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.def.dao.PSDBSPPartTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBSPPartTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDBSPPartTemplDAO();
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

    protected void onFillParentInfo(PSDBSPPartTempl pSDBSPPartTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBSPPARTTEMPL_PSDBSYSPROCTEMPL_PSDBSYSPROCTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSDBSysProcTemplService", (SessionFactory)this.getSessionFactory());
            PSDBSysProcTempl pSDBSysProcTempl = (PSDBSysProcTempl)iService.getDEModel().createEntity();
            pSDBSysProcTempl.set("PSDBSYSPROCTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBSysProcTempl);
            } else {
                iService.get((IEntity)pSDBSysProcTempl);
            }
            this.onFillParentInfo_PSDBSysProcTempl(pSDBSPPartTempl, pSDBSysProcTempl);
            return;
        }
        super.onFillParentInfo((IEntity)pSDBSPPartTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBSysProcTempl(PSDBSPPartTempl pSDBSPPartTempl, PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
        pSDBSPPartTempl.setPSDBSysProcTemplId(pSDBSysProcTempl.getPSDBSysProcTemplId());
        pSDBSPPartTempl.setPSDBSysProcTemplName(pSDBSysProcTempl.getPSDBSysProcTemplName());
    }

    protected void onFillEntityFullInfo(PSDBSPPartTempl pSDBSPPartTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDBSPPartTempl, bl);
        this.onFillEntityFullInfo_PSDBSysProcTempl(pSDBSPPartTempl, bl);
    }

    protected void onFillEntityFullInfo_PSDBSysProcTempl(PSDBSPPartTempl pSDBSPPartTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDBSPPartTempl pSDBSPPartTempl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDBSPPartTempl, bl);
    }

    public ArrayList<PSDBSPPartTempl> selectByPSDBSysProcTempl(PSDBSysProcTemplBase pSDBSysProcTemplBase) throws Exception {
        return this.selectByPSDBSysProcTempl(pSDBSysProcTemplBase, "", -1);
    }

    public ArrayList<PSDBSPPartTempl> selectByPSDBSysProcTempl(PSDBSysProcTemplBase pSDBSysProcTemplBase, String string) throws Exception {
        return this.selectByPSDBSysProcTempl(pSDBSysProcTemplBase, string, -1);
    }

    public ArrayList<PSDBSPPartTempl> selectByPSDBSysProcTempl(PSDBSysProcTemplBase pSDBSysProcTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBSYSPROCTEMPLID", (Object)pSDBSysProcTemplBase.getPSDBSysProcTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBSysProcTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBSysProcTemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBSysProcTempl(PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
    }

    public void resetPSDBSysProcTempl(PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
        ArrayList<PSDBSPPartTempl> arrayList = this.selectByPSDBSysProcTempl(pSDBSysProcTempl);
        for (PSDBSPPartTempl pSDBSPPartTempl : arrayList) {
            PSDBSPPartTempl pSDBSPPartTempl2 = (PSDBSPPartTempl)this.getDEModel().createEntity();
            pSDBSPPartTempl2.setPSDBSPPartTemplId(pSDBSPPartTempl.getPSDBSPPartTemplId());
            pSDBSPPartTempl2.setPSDBSysProcTemplId(null);
            this.update(pSDBSPPartTempl2);
        }
    }

    public void removeByPSDBSysProcTempl(PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
        final PSDBSysProcTempl pSDBSysProcTempl2 = pSDBSysProcTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBSPPartTemplServiceBase.this.onBeforeRemoveByPSDBSysProcTempl(pSDBSysProcTempl2);
                PSDBSPPartTemplServiceBase.this.internalRemoveByPSDBSysProcTempl(pSDBSysProcTempl2);
                PSDBSPPartTemplServiceBase.this.onAfterRemoveByPSDBSysProcTempl(pSDBSysProcTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBSysProcTempl(PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
    }

    protected void internalRemoveByPSDBSysProcTempl(PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
        ArrayList<PSDBSPPartTempl> arrayList = this.selectByPSDBSysProcTempl(pSDBSysProcTempl);
        this.onBeforeRemoveByPSDBSysProcTempl(pSDBSysProcTempl, arrayList);
        for (PSDBSPPartTempl pSDBSPPartTempl : arrayList) {
            this.remove((IEntity)pSDBSPPartTempl);
        }
        this.onAfterRemoveByPSDBSysProcTempl(pSDBSysProcTempl, arrayList);
    }

    protected void onAfterRemoveByPSDBSysProcTempl(PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDBSysProcTempl(PSDBSysProcTempl pSDBSysProcTempl, ArrayList<PSDBSPPartTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBSysProcTempl(PSDBSysProcTempl pSDBSysProcTempl, ArrayList<PSDBSPPartTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDBSPPartTempl pSDBSPPartTempl) throws Exception {
        super.onBeforeRemove(pSDBSPPartTempl);
    }

    protected void replaceParentInfo(PSDBSPPartTempl pSDBSPPartTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDBSPPartTempl, cloneSession);
        if (pSDBSPPartTempl.getPSDBSysProcTemplId() != null && (iEntity = cloneSession.getEntity("PSDBSYSPROCTEMPL", (Object)pSDBSPPartTempl.getPSDBSysProcTemplId())) != null) {
            this.onFillParentInfo_PSDBSysProcTempl(pSDBSPPartTempl, (PSDBSysProcTempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDBSPPartTempl pSDBSPPartTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDBSPPartTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSDBSPPartTempl pSDBSPPartTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDBSPPartTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBSPPartTemplId(bl, pSDBSPPartTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBSPPartTemplName(bl, pSDBSPPartTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBSysProcTemplId(bl, pSDBSPPartTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSDBSPPartTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDBSPPartTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDBSPPartTempl pSDBSPPartTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSPPartTempl.isMemoDirty() : !pSDBSPPartTempl.isMemoDirty()) {
            return null;
        }
        String string = pSDBSPPartTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDBSPPartTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDBSPPartTemplId(boolean bl, PSDBSPPartTempl pSDBSPPartTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSPPartTempl.isPSDBSPPartTemplIdDirty() && !bl2 : !pSDBSPPartTempl.isPSDBSPPartTemplIdDirty()) {
            return null;
        }
        String string = pSDBSPPartTempl.getPSDBSPPartTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSPPARTTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBSPPartTemplId_Default((IEntity)pSDBSPPartTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSPPARTTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBSPPartTemplName(boolean bl, PSDBSPPartTempl pSDBSPPartTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSPPartTempl.isPSDBSPPartTemplNameDirty() && !bl2 : !pSDBSPPartTempl.isPSDBSPPartTemplNameDirty()) {
            return null;
        }
        String string = pSDBSPPartTempl.getPSDBSPPartTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSPPARTTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBSPPartTemplName_Default((IEntity)pSDBSPPartTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSPPARTTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBSysProcTemplId(boolean bl, PSDBSPPartTempl pSDBSPPartTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSPPartTempl.isPSDBSysProcTemplIdDirty() && !bl2 : !pSDBSPPartTempl.isPSDBSysProcTemplIdDirty()) {
            return null;
        }
        String string = pSDBSPPartTempl.getPSDBSysProcTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSYSPROCTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBSysProcTemplId_Default((IEntity)pSDBSPPartTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSYSPROCTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSDBSPPartTempl pSDBSPPartTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSPPartTempl.isTemplCodeDirty() : !pSDBSPPartTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSDBSPPartTempl.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default((IEntity)pSDBSPPartTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDBSPPartTempl pSDBSPPartTempl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDBSPPartTempl, bl);
    }

    protected void onSyncIndexEntities(PSDBSPPartTempl pSDBSPPartTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDBSPPartTempl, bl);
    }

    public Object getDataContextValue(PSDBSPPartTempl pSDBSPPartTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDBSPPartTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDBSPPartTempl pSDBSPPartTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDBSPPartTempl, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDBSPPARTTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBSPPartTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSPPARTTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBSPPartTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSYSPROCTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBSysProcTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSYSPROCTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBSysProcTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDBSPPartTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSPPARTTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBSPPartTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSPPARTTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBSysProcTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSYSPROCTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBSysProcTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSYSPROCTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDBSPPartTempl pSDBSPPartTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDBSPPartTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDBSPPartTempl pSDBSPPartTempl) throws Exception {
        super.onUpdateParent((IEntity)pSDBSPPartTempl);
    }

    @Override
    protected void exportCurXmlModel(PSDBSPPartTempl pSDBSPPartTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDBSPPARTTEMPL");
        if (!bl) {
            pSDBSPPartTempl.setCreateDate(null);
            pSDBSPPartTempl.setCreateMan(null);
            pSDBSPPartTempl.setPSDBSPPartTemplId(null);
            pSDBSPPartTempl.setUpdateDate(null);
            pSDBSPPartTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSDBSPPartTempl, xmlNode, bl);
        }
    }
}

