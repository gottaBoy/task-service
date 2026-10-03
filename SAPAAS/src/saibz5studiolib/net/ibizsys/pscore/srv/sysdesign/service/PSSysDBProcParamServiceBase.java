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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBProcParamDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBProcParamDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBProc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBProcBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBProcParam;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBProcParamServiceBase
extends PSCoreSysServiceBase<PSSysDBProcParam> {
    private static final Log log = LogFactory.getLog(PSSysDBProcParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDBProcParamDEModel pSSysDBProcParamDEModel;
    private PSSysDBProcParamDAO pSSysDBProcParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBProcParamService";
    }

    public PSSysDBProcParamDEModel getPSSysDBProcParamDEModel() {
        if (this.pSSysDBProcParamDEModel == null) {
            try {
                this.pSSysDBProcParamDEModel = (PSSysDBProcParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBProcParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBProcParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDBProcParamDEModel();
    }

    public PSSysDBProcParamDAO getPSSysDBProcParamDAO() {
        if (this.pSSysDBProcParamDAO == null) {
            try {
                this.pSSysDBProcParamDAO = (PSSysDBProcParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBProcParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBProcParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDBProcParamDAO();
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

    protected void onFillParentInfo(PSSysDBProcParam pSSysDBProcParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPROCPARAM_PSSYSDBPROC_PSSYSDBPROCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBProcService", (SessionFactory)this.getSessionFactory());
            PSSysDBProc pSSysDBProc = (PSSysDBProc)iService.getDEModel().createEntity();
            pSSysDBProc.set("PSSYSDBPROCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDBProc);
            } else {
                iService.get(pSSysDBProc);
            }
            this.onFillParentInfo_PSSysDBProc(pSSysDBProcParam, pSSysDBProc);
            return;
        }
        super.onFillParentInfo(pSSysDBProcParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysDBProc(PSSysDBProcParam pSSysDBProcParam, PSSysDBProc pSSysDBProc) throws Exception {
        pSSysDBProcParam.setPSSysDBProcId(pSSysDBProc.getPSSysDBProcId());
        pSSysDBProcParam.setPSSysDBProcName(pSSysDBProc.getPSSysDBProcName());
    }

    protected void onFillEntityFullInfo(PSSysDBProcParam pSSysDBProcParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysDBProcParam, bl);
        this.onFillEntityFullInfo_PSSysDBProc(pSSysDBProcParam, bl);
    }

    protected void onFillEntityFullInfo_PSSysDBProc(PSSysDBProcParam pSSysDBProcParam, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDBProcParam pSSysDBProcParam, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDBProcParam, bl);
    }

    public ArrayList<PSSysDBProcParam> selectByPSSysDBProc(PSSysDBProcBase pSSysDBProcBase) throws Exception {
        return this.selectByPSSysDBProc(pSSysDBProcBase, "", -1);
    }

    public ArrayList<PSSysDBProcParam> selectByPSSysDBProc(PSSysDBProcBase pSSysDBProcBase, String string) throws Exception {
        return this.selectByPSSysDBProc(pSSysDBProcBase, string, -1);
    }

    public ArrayList<PSSysDBProcParam> selectByPSSysDBProc(PSSysDBProcBase pSSysDBProcBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBPROCID", (Object)pSSysDBProcBase.getPSSysDBProcId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBProcCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBProcCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysDBProc(PSSysDBProc pSSysDBProc) throws Exception {
    }

    public void resetPSSysDBProc(PSSysDBProc pSSysDBProc) throws Exception {
        ArrayList<PSSysDBProcParam> arrayList = this.selectByPSSysDBProc(pSSysDBProc);
        for (PSSysDBProcParam pSSysDBProcParam : arrayList) {
            PSSysDBProcParam pSSysDBProcParam2 = (PSSysDBProcParam)this.getDEModel().createEntity();
            pSSysDBProcParam2.setPSSysDBProcParamId(pSSysDBProcParam.getPSSysDBProcParamId());
            pSSysDBProcParam2.setPSSysDBProcId(null);
            this.update(pSSysDBProcParam2);
        }
    }

    public void removeByPSSysDBProc(PSSysDBProc pSSysDBProc) throws Exception {
        final PSSysDBProc pSSysDBProc2 = pSSysDBProc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBProcParamServiceBase.this.onBeforeRemoveByPSSysDBProc(pSSysDBProc2);
                PSSysDBProcParamServiceBase.this.internalRemoveByPSSysDBProc(pSSysDBProc2);
                PSSysDBProcParamServiceBase.this.onAfterRemoveByPSSysDBProc(pSSysDBProc2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBProc(PSSysDBProc pSSysDBProc) throws Exception {
    }

    protected void internalRemoveByPSSysDBProc(PSSysDBProc pSSysDBProc) throws Exception {
        ArrayList<PSSysDBProcParam> arrayList = this.selectByPSSysDBProc(pSSysDBProc);
        this.onBeforeRemoveByPSSysDBProc(pSSysDBProc, arrayList);
        for (PSSysDBProcParam pSSysDBProcParam : arrayList) {
            this.remove(pSSysDBProcParam);
        }
        this.onAfterRemoveByPSSysDBProc(pSSysDBProc, arrayList);
    }

    protected void onAfterRemoveByPSSysDBProc(PSSysDBProc pSSysDBProc) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBProc(PSSysDBProc pSSysDBProc, ArrayList<PSSysDBProcParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBProc(PSSysDBProc pSSysDBProc, ArrayList<PSSysDBProcParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDBProcParam pSSysDBProcParam) throws Exception {
        super.onBeforeRemove(pSSysDBProcParam);
    }

    protected void replaceParentInfo(PSSysDBProcParam pSSysDBProcParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDBProcParam, cloneSession);
        if (pSSysDBProcParam.getPSSysDBProcId() != null && (iEntity = cloneSession.getEntity("PSSYSDBPROC", (Object)pSSysDBProcParam.getPSSysDBProcId())) != null) {
            this.onFillParentInfo_PSSysDBProc(pSSysDBProcParam, (PSSysDBProc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDBProcParam pSSysDBProcParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDBProcParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DefaultValue(bl, pSSysDBProcParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Length(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamDIR(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBProcId(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBProcParamId(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBProcParamName(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDBProcParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isDefaultValueDirty() : !pSSysDBProcParam.isDefaultValueDirty()) {
            return null;
        }
        String string = pSSysDBProcParam.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Length(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isLengthDirty() : !pSSysDBProcParam.isLengthDirty()) {
            return null;
        }
        Integer n = pSSysDBProcParam.getLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Length_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isLogicNameDirty() : !pSSysDBProcParam.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysDBProcParam.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSysDBProcParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isMemoDirty() : !pSSysDBProcParam.isMemoDirty()) {
            return null;
        }
        String string = pSSysDBProcParam.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDBProcParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isOrderValueDirty() && !bl2 : !pSSysDBProcParam.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysDBProcParam.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamDIR(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isParamDIRDirty() && !bl2 : !pSSysDBProcParam.isParamDIRDirty()) {
            return null;
        }
        Integer n = pSSysDBProcParam.getParamDIR();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMDIR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ParamDIR_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isPrecision2Dirty() : !pSSysDBProcParam.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSSysDBProcParam.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBProcId(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isPSSysDBProcIdDirty() && !bl2 : !pSSysDBProcParam.isPSSysDBProcIdDirty()) {
            return null;
        }
        String string = pSSysDBProcParam.getPSSysDBProcId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBProcId_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBProcParamId(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isPSSysDBProcParamIdDirty() && !bl2 : !pSSysDBProcParam.isPSSysDBProcParamIdDirty()) {
            return null;
        }
        String string = pSSysDBProcParam.getPSSysDBProcParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBProcParamId_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBProcParamName(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isPSSysDBProcParamNameDirty() && !bl2 : !pSSysDBProcParam.isPSSysDBProcParamNameDirty()) {
            return null;
        }
        String string = pSSysDBProcParam.getPSSysDBProcParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBProcParamName_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCPARAMNAME");
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
                string3 = "PSSYSDBPROCID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBProcParamDEModel(), "PSSYSDBPROCPARAMNAME", string3, pSSysDBProcParam, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDBPROCPARAMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isStdDataTypeDirty() && !bl2 : !pSSysDBProcParam.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSysDBProcParam.getStdDataType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STDDATATYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STDDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isUserCatDirty() : !pSSysDBProcParam.isUserCatDirty()) {
            return null;
        }
        String string = pSSysDBProcParam.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isUserTagDirty() : !pSSysDBProcParam.isUserTagDirty()) {
            return null;
        }
        String string = pSSysDBProcParam.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysDBProcParam pSSysDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProcParam.isUserTag2Dirty() : !pSSysDBProcParam.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysDBProcParam.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDBProcParam pSSysDBProcParam, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDBProcParam, bl);
    }

    protected void onSyncIndexEntities(PSSysDBProcParam pSSysDBProcParam, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDBProcParam, bl);
    }

    public Object getDataContextValue(PSSysDBProcParam pSSysDBProcParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysDBProcParam, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysDBProc pSSysDBProc = pSSysDBProcParam.getPSSysDBProc();
        if (pSSysDBProc != null && pSSysDBProc.contains(string)) {
            return pSSysDBProc.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDBProcParam pSSysDBProcParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDBProcParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Length_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamDIR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBPROCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBProcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBPROCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBProcName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBPROCPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBProcParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBPROCPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBProcParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Length_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ParamDIR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysDBProcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBPROCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBProcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBPROCNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBProcParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBPROCPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBProcParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBPROCPARAMNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSSYSDBPROCPARAMNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysDBProcParam pSSysDBProcParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDBProcParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDBProcParam pSSysDBProcParam) throws Exception {
        super.onUpdateParent(pSSysDBProcParam);
    }

    @Override
    protected void exportCurXmlModel(PSSysDBProcParam pSSysDBProcParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDBPROCPARAM");
        if (!bl) {
            pSSysDBProcParam.setCreateDate(null);
            pSSysDBProcParam.setCreateMan(null);
            pSSysDBProcParam.setPSSysDBProcParamId(null);
            pSSysDBProcParam.setUpdateDate(null);
            pSSysDBProcParam.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDBProcParam, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDBProcParam pSSysDBProcParam, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDBProcParam, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBPROCID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSDBPROC#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBPROCID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDBPROCPARAM_PSSYSDBPROC_PSSYSDBPROCID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBPROCID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBPROCNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSDBPROC", (boolean)true) == 0) {
            iEntity.set("PSSYSDBPROCID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSDBPROCID"};
    }

    @Override
    public String getModelV2Tag(PSSysDBProcParam pSSysDBProcParam) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDBProcParam.getPSSysDBProcParamName())) {
            return pSSysDBProcParam.getPSSysDBProcParamName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDBProcParam.getPSSysDBProcParamName())) {
            return pSSysDBProcParam.getPSSysDBProcParamName();
        }
        return super.getModelV2Tag(pSSysDBProcParam);
    }

    @Override
    public boolean setModelV2Tag(PSSysDBProcParam pSSysDBProcParam, String string) {
        return super.setModelV2Tag(pSSysDBProcParam, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSDBPROCPARAMNAME", "");
        map.put("PSSYSDBPROCPARAMNAME", "");
        map.put("PSSYSDBPROCID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDBProcParam pSSysDBProcParam, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDBProcParam.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDBProcParam, true);
        pSSysDBProcParam.set("PSSYSDBPROCPARAMNAME", string);
        if (this.select(pSSysDBProcParam, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDBProcParam, true);
        return super.getModelV2Entity(pSSysDBProcParam, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDBProcParam pSSysDBProcParam, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysDBProcParam, objectNode, string, string2, n);
    }
}

