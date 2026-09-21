/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBVFCodeDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBVFCodeDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVFBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVFCode;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBVFCodeServiceBase
extends PSCoreSysServiceBase<PSSysDBVFCode> {
    private static final Log log = LogFactory.getLog(PSSysDBVFCodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDBVFCodeDEModel pSSysDBVFCodeDEModel;
    private PSSysDBVFCodeDAO pSSysDBVFCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFCodeService";
    }

    public PSSysDBVFCodeDEModel getPSSysDBVFCodeDEModel() {
        if (this.pSSysDBVFCodeDEModel == null) {
            try {
                this.pSSysDBVFCodeDEModel = (PSSysDBVFCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBVFCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBVFCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDBVFCodeDEModel();
    }

    public PSSysDBVFCodeDAO getPSSysDBVFCodeDAO() {
        if (this.pSSysDBVFCodeDAO == null) {
            try {
                this.pSSysDBVFCodeDAO = (PSSysDBVFCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBVFCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBVFCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDBVFCodeDAO();
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

    protected void onFillParentInfo(PSSysDBVFCode pSSysDBVFCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBVFCODE_PSSYSDBVF_PSSYSDBVFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService", (SessionFactory)this.getSessionFactory());
            PSSysDBVF pSSysDBVF = (PSSysDBVF)iService.getDEModel().createEntity();
            pSSysDBVF.set("PSSYSDBVFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDBVF);
            } else {
                iService.get((IEntity)pSSysDBVF);
            }
            this.onFillParentInfo_PSSysDBVF(pSSysDBVFCode, pSSysDBVF);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDBVFCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysDBVF(PSSysDBVFCode pSSysDBVFCode, PSSysDBVF pSSysDBVF) throws Exception {
        pSSysDBVFCode.setPSSysDBVFId(pSSysDBVF.getPSSysDBVFId());
        pSSysDBVFCode.setPSSysDBVFName(pSSysDBVF.getPSSysDBVFName());
    }

    protected void onFillEntityFullInfo(PSSysDBVFCode pSSysDBVFCode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysDBVFCode, bl);
        this.onFillEntityFullInfo_PSSysDBVF(pSSysDBVFCode, bl);
    }

    protected void onFillEntityFullInfo_PSSysDBVF(PSSysDBVFCode pSSysDBVFCode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDBVFCode pSSysDBVFCode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDBVFCode, bl);
    }

    public ArrayList<PSSysDBVFCode> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, "", -1);
    }

    public ArrayList<PSSysDBVFCode> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, string, -1);
    }

    public ArrayList<PSSysDBVFCode> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBVFID", (Object)pSSysDBVFBase.getPSSysDBVFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBVFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBVFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    public void resetPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSSysDBVFCode> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        for (PSSysDBVFCode pSSysDBVFCode : arrayList) {
            PSSysDBVFCode pSSysDBVFCode2 = (PSSysDBVFCode)this.getDEModel().createEntity();
            pSSysDBVFCode2.setPSSysDBVFCodeId(pSSysDBVFCode.getPSSysDBVFCodeId());
            pSSysDBVFCode2.setPSSysDBVFId(null);
            this.update(pSSysDBVFCode2);
        }
    }

    public void removeByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        final PSSysDBVF pSSysDBVF2 = pSSysDBVF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBVFCodeServiceBase.this.onBeforeRemoveByPSSysDBVF(pSSysDBVF2);
                PSSysDBVFCodeServiceBase.this.internalRemoveByPSSysDBVF(pSSysDBVF2);
                PSSysDBVFCodeServiceBase.this.onAfterRemoveByPSSysDBVF(pSSysDBVF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void internalRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSSysDBVFCode> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        this.onBeforeRemoveByPSSysDBVF(pSSysDBVF, arrayList);
        for (PSSysDBVFCode pSSysDBVFCode : arrayList) {
            this.remove((IEntity)pSSysDBVFCode);
        }
        this.onAfterRemoveByPSSysDBVF(pSSysDBVF, arrayList);
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSSysDBVFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSSysDBVFCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDBVFCode pSSysDBVFCode) throws Exception {
        super.onBeforeRemove(pSSysDBVFCode);
    }

    protected void replaceParentInfo(PSSysDBVFCode pSSysDBVFCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDBVFCode, cloneSession);
        if (pSSysDBVFCode.getPSSysDBVFId() != null && (iEntity = cloneSession.getEntity("PSSYSDBVF", (Object)pSSysDBVFCode.getPSSysDBVFId())) != null) {
            this.onFillParentInfo_PSSysDBVF(pSSysDBVFCode, (PSSysDBVF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDBVFCode pSSysDBVFCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDBVFCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDBVFCode pSSysDBVFCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CallCode(bl, pSSysDBVFCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBType(bl, pSSysDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncCode(bl, pSSysDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFCodeId(bl, pSSysDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFCodeName(bl, pSSysDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFId(bl, pSSysDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDBVFCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CallCode(boolean bl, PSSysDBVFCode pSSysDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBVFCode.isCallCodeDirty() : !pSSysDBVFCode.isCallCodeDirty()) {
            return null;
        }
        String string = pSSysDBVFCode.getCallCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CallCode_Default((IEntity)pSSysDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBType(boolean bl, PSSysDBVFCode pSSysDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBVFCode.isDBTypeDirty() && !bl2 : !pSSysDBVFCode.isDBTypeDirty()) {
            return null;
        }
        String string = pSSysDBVFCode.getDBType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBType_Default((IEntity)pSSysDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSDBVFID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBVFCodeDEModel(), "DBTYPE", string3, pSSysDBVFCode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DBTYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncCode(boolean bl, PSSysDBVFCode pSSysDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBVFCode.isFuncCodeDirty() : !pSSysDBVFCode.isFuncCodeDirty()) {
            return null;
        }
        String string = pSSysDBVFCode.getFuncCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncCode_Default((IEntity)pSSysDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDBVFCode pSSysDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBVFCode.isMemoDirty() : !pSSysDBVFCode.isMemoDirty()) {
            return null;
        }
        String string = pSSysDBVFCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysDBVFCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDBVFCodeId(boolean bl, PSSysDBVFCode pSSysDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBVFCode.isPSSysDBVFCodeIdDirty() && !bl2 : !pSSysDBVFCode.isPSSysDBVFCodeIdDirty()) {
            return null;
        }
        String string = pSSysDBVFCode.getPSSysDBVFCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFCodeId_Default((IEntity)pSSysDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBVFCodeName(boolean bl, PSSysDBVFCode pSSysDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBVFCode.isPSSysDBVFCodeNameDirty() && !bl2 : !pSSysDBVFCode.isPSSysDBVFCodeNameDirty()) {
            return null;
        }
        String string = pSSysDBVFCode.getPSSysDBVFCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFCodeName_Default((IEntity)pSSysDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBVFId(boolean bl, PSSysDBVFCode pSSysDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBVFCode.isPSSysDBVFIdDirty() && !bl2 : !pSSysDBVFCode.isPSSysDBVFIdDirty()) {
            return null;
        }
        String string = pSSysDBVFCode.getPSSysDBVFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFId_Default((IEntity)pSSysDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDBVFCode pSSysDBVFCode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDBVFCode, bl);
    }

    protected void onSyncIndexEntities(PSSysDBVFCode pSSysDBVFCode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDBVFCode, bl);
    }

    public Object getDataContextValue(PSSysDBVFCode pSSysDBVFCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDBVFCode, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDBVFCode pSSysDBVFCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysDBVFCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CALLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CallCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CallCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALLCODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_DBType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PSSysDBVFCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBVFCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBVFCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBVFCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBVFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBVFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBVFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBVFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysDBVFCode pSSysDBVFCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDBVFCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDBVFCode pSSysDBVFCode) throws Exception {
        super.onUpdateParent((IEntity)pSSysDBVFCode);
    }

    @Override
    protected void exportCurXmlModel(PSSysDBVFCode pSSysDBVFCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDBVFCODE");
        if (!bl) {
            pSSysDBVFCode.setCreateDate(null);
            pSSysDBVFCode.setCreateMan(null);
            pSSysDBVFCode.setPSSysDBVFCodeId(null);
            pSSysDBVFCode.setUpdateDate(null);
            pSSysDBVFCode.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDBVFCode, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDBVFCode pSSysDBVFCode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDBVFCode, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBVFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSDBVF#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBVFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDBVFCODE_PSSYSDBVF_PSSYSDBVFID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBVFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBVFNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSDBVF", (boolean)true) == 0) {
            iEntity.set("PSSYSDBVFID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSDBVFID"};
    }

    @Override
    public String getModelV2Tag(PSSysDBVFCode pSSysDBVFCode) {
        return super.getModelV2Tag(pSSysDBVFCode);
    }

    @Override
    public boolean setModelV2Tag(PSSysDBVFCode pSSysDBVFCode, String string) {
        return super.setModelV2Tag(pSSysDBVFCode, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSDBVFID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDBVFCode pSSysDBVFCode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDBVFCode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDBVFCode, true);
        return super.getModelV2Entity(pSSysDBVFCode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDBVFCode pSSysDBVFCode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysDBVFCode, objectNode, string, string2, n);
    }
}

