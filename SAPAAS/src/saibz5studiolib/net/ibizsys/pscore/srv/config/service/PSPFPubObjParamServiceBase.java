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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSPFPubObjParamDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFPubObjParamDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPubObj;
import net.ibizsys.pscore.srv.config.entity.PSPFPubObjBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPubObjParam;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPubObjParamServiceBase
extends PSCoreSysServiceBase<PSPFPubObjParam> {
    private static final Log log = LogFactory.getLog(PSPFPubObjParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFPubObjParamDEModel pSPFPubObjParamDEModel;
    private PSPFPubObjParamDAO pSPFPubObjParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFPubObjParamService";
    }

    public PSPFPubObjParamDEModel getPSPFPubObjParamDEModel() {
        if (this.pSPFPubObjParamDEModel == null) {
            try {
                this.pSPFPubObjParamDEModel = (PSPFPubObjParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPubObjParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPubObjParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFPubObjParamDEModel();
    }

    public PSPFPubObjParamDAO getPSPFPubObjParamDAO() {
        if (this.pSPFPubObjParamDAO == null) {
            try {
                this.pSPFPubObjParamDAO = (PSPFPubObjParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFPubObjParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPubObjParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFPubObjParamDAO();
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

    protected void onFillParentInfo(PSPFPubObjParam pSPFPubObjParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPUBOBJPARAM_PSPFPUBOBJ_PSPFPUBOBJID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubObjService", (SessionFactory)this.getSessionFactory());
            PSPFPubObj pSPFPubObj = (PSPFPubObj)iService.getDEModel().createEntity();
            pSPFPubObj.set("PSPFPUBOBJID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFPubObj);
            } else {
                iService.get((IEntity)pSPFPubObj);
            }
            this.onFillParentInfo_Pspfpubobj(pSPFPubObjParam, pSPFPubObj);
            return;
        }
        super.onFillParentInfo((IEntity)pSPFPubObjParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Pspfpubobj(PSPFPubObjParam pSPFPubObjParam, PSPFPubObj pSPFPubObj) throws Exception {
        pSPFPubObjParam.setPSPFPubObjId(pSPFPubObj.getPSPFPubObjId());
        pSPFPubObjParam.setPSPFPubObjName(pSPFPubObj.getPSPFPubObjName());
    }

    protected void onFillEntityFullInfo(PSPFPubObjParam pSPFPubObjParam, boolean bl) throws Exception {
        if (bl && pSPFPubObjParam.getValidFlag() == null) {
            pSPFPubObjParam.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSPFPubObjParam, bl);
        this.onFillEntityFullInfo_Pspfpubobj(pSPFPubObjParam, bl);
    }

    protected void onFillEntityFullInfo_Pspfpubobj(PSPFPubObjParam pSPFPubObjParam, boolean bl) throws Exception {
        if (pSPFPubObjParam.isPSPFPubObjIdDirty()) {
            if (pSPFPubObjParam.getPSPFPubObjId() != null) {
                if (pSPFPubObjParam.getPSPFPubObjId() == null || pSPFPubObjParam.getPSPFPubObjName() == null) {
                    PSPFPubObj pSPFPubObj = pSPFPubObjParam.getPspfpubobj();
                    pSPFPubObjParam.setPSPFPubObjName(pSPFPubObj.getPSPFPubObjName());
                }
            } else {
                pSPFPubObjParam.setPSPFPubObjName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPFPubObjParam pSPFPubObjParam, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPFPubObjParam, bl);
    }

    public ArrayList<PSPFPubObjParam> selectByPspfpubobj(PSPFPubObjBase pSPFPubObjBase) throws Exception {
        return this.selectByPspfpubobj(pSPFPubObjBase, "", -1);
    }

    public ArrayList<PSPFPubObjParam> selectByPspfpubobj(PSPFPubObjBase pSPFPubObjBase, String string) throws Exception {
        return this.selectByPspfpubobj(pSPFPubObjBase, string, -1);
    }

    public ArrayList<PSPFPubObjParam> selectByPspfpubobj(PSPFPubObjBase pSPFPubObjBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPUBOBJID", (Object)pSPFPubObjBase.getPSPFPubObjId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPspfpubobjCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPspfpubobjCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
    }

    public void resetPspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
        ArrayList<PSPFPubObjParam> arrayList = this.selectByPspfpubobj(pSPFPubObj);
        for (PSPFPubObjParam pSPFPubObjParam : arrayList) {
            PSPFPubObjParam pSPFPubObjParam2 = (PSPFPubObjParam)this.getDEModel().createEntity();
            pSPFPubObjParam2.setPSPFPubObjParamId(pSPFPubObjParam.getPSPFPubObjParamId());
            pSPFPubObjParam2.setPSPFPubObjId(null);
            this.update(pSPFPubObjParam2);
        }
    }

    public void removeByPspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
        final PSPFPubObj pSPFPubObj2 = pSPFPubObj;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPubObjParamServiceBase.this.onBeforeRemoveByPspfpubobj(pSPFPubObj2);
                PSPFPubObjParamServiceBase.this.internalRemoveByPspfpubobj(pSPFPubObj2);
                PSPFPubObjParamServiceBase.this.onAfterRemoveByPspfpubobj(pSPFPubObj2);
            }
        });
    }

    protected void onBeforeRemoveByPspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
    }

    protected void internalRemoveByPspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
        ArrayList<PSPFPubObjParam> arrayList = this.selectByPspfpubobj(pSPFPubObj);
        this.onBeforeRemoveByPspfpubobj(pSPFPubObj, arrayList);
        for (PSPFPubObjParam pSPFPubObjParam : arrayList) {
            this.remove((IEntity)pSPFPubObjParam);
        }
        this.onAfterRemoveByPspfpubobj(pSPFPubObj, arrayList);
    }

    protected void onAfterRemoveByPspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
    }

    protected void onBeforeRemoveByPspfpubobj(PSPFPubObj pSPFPubObj, ArrayList<PSPFPubObjParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPspfpubobj(PSPFPubObj pSPFPubObj, ArrayList<PSPFPubObjParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFPubObjParam pSPFPubObjParam) throws Exception {
        super.onBeforeRemove(pSPFPubObjParam);
    }

    protected void replaceParentInfo(PSPFPubObjParam pSPFPubObjParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPFPubObjParam, cloneSession);
        if (pSPFPubObjParam.getPSPFPubObjId() != null && (iEntity = cloneSession.getEntity("PSPFPUBOBJ", (Object)pSPFPubObjParam.getPSPFPubObjId())) != null) {
            this.onFillParentInfo_Pspfpubobj(pSPFPubObjParam, (PSPFPubObj)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFPubObjParam pSPFPubObjParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPFPubObjParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogicName(bl, pSPFPubObjParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjName(bl, pSPFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSPFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubObjId(bl, pSPFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubObjName(bl, pSPFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubObjParamId(bl, pSPFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubObjParamName(bl, pSPFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSPFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPFPubObjParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObjParam.isLogicNameDirty() && !bl2 : !pSPFPubObjParam.isLogicNameDirty()) {
            return null;
        }
        String string = pSPFPubObjParam.getLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSPFPubObjParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObjParam.isMemoDirty() : !pSPFPubObjParam.isMemoDirty()) {
            return null;
        }
        String string = pSPFPubObjParam.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPFPubObjParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ObjName(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObjParam.isObjNameDirty() && !bl2 : !pSPFPubObjParam.isObjNameDirty()) {
            return null;
        }
        String string = pSPFPubObjParam.getObjName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjName_Default((IEntity)pSPFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObjParam.isParamTypeDirty() && !bl2 : !pSPFPubObjParam.isParamTypeDirty()) {
            return null;
        }
        String string = pSPFPubObjParam.getParamType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default((IEntity)pSPFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubObjId(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObjParam.isPSPFPubObjIdDirty() : !pSPFPubObjParam.isPSPFPubObjIdDirty()) {
            return null;
        }
        String string = pSPFPubObjParam.getPSPFPubObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubObjId_Default((IEntity)pSPFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubObjName(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObjParam.isPSPFPubObjNameDirty() : !pSPFPubObjParam.isPSPFPubObjNameDirty()) {
            return null;
        }
        String string = pSPFPubObjParam.getPSPFPubObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubObjName_Default((IEntity)pSPFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubObjParamId(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObjParam.isPSPFPubObjParamIdDirty() && !bl2 : !pSPFPubObjParam.isPSPFPubObjParamIdDirty()) {
            return null;
        }
        String string = pSPFPubObjParam.getPSPFPubObjParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubObjParamId_Default((IEntity)pSPFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubObjParamName(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObjParam.isPSPFPubObjParamNameDirty() && !bl2 : !pSPFPubObjParam.isPSPFPubObjParamNameDirty()) {
            return null;
        }
        String string = pSPFPubObjParam.getPSPFPubObjParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubObjParamName_Default((IEntity)pSPFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSPFPubObjParam pSPFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObjParam.isValidFlagDirty() && !bl2 : !pSPFPubObjParam.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSPFPubObjParam.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSPFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPFPubObjParam pSPFPubObjParam, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPFPubObjParam, bl);
    }

    protected void onSyncIndexEntities(PSPFPubObjParam pSPFPubObjParam, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPFPubObjParam, bl);
    }

    public Object getDataContextValue(PSPFPubObjParam pSPFPubObjParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPFPubObjParam, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFPubObjParam pSPFPubObjParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPFPubObjParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
        if (StringHelper.compare((String)string, (String)"OBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBOBJPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubObjParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBOBJPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubObjParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OBJNAME", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubObjParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBOBJPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubObjParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBOBJPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSPFPubObjParam pSPFPubObjParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPFPubObjParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFPubObjParam pSPFPubObjParam) throws Exception {
        super.onUpdateParent((IEntity)pSPFPubObjParam);
    }

    @Override
    protected void exportCurXmlModel(PSPFPubObjParam pSPFPubObjParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFPUBOBJPARAM");
        if (!bl) {
            pSPFPubObjParam.setCreateDate(null);
            pSPFPubObjParam.setCreateMan(null);
            pSPFPubObjParam.setPSPFPubObjParamId(null);
            pSPFPubObjParam.setUpdateDate(null);
            pSPFPubObjParam.setUpdateMan(null);
            super.exportCurXmlModel(pSPFPubObjParam, xmlNode, bl);
        }
    }
}

