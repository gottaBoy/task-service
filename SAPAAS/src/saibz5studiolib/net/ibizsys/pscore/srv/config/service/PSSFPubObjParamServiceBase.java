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
import net.ibizsys.pscore.srv.config.dao.PSSFPubObjParamDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFPubObjParamDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFPubObjParam;
import net.ibizsys.pscore.srv.config.entity.PSSFPubOjb;
import net.ibizsys.pscore.srv.config.entity.PSSFPubOjbBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPubObjParamServiceBase
extends PSCoreSysServiceBase<PSSFPubObjParam> {
    private static final Log log = LogFactory.getLog(PSSFPubObjParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFPubObjParamDEModel pSSFPubObjParamDEModel;
    private PSSFPubObjParamDAO pSSFPubObjParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFPubObjParamService";
    }

    public PSSFPubObjParamDEModel getPSSFPubObjParamDEModel() {
        if (this.pSSFPubObjParamDEModel == null) {
            try {
                this.pSSFPubObjParamDEModel = (PSSFPubObjParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFPubObjParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPubObjParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFPubObjParamDEModel();
    }

    public PSSFPubObjParamDAO getPSSFPubObjParamDAO() {
        if (this.pSSFPubObjParamDAO == null) {
            try {
                this.pSSFPubObjParamDAO = (PSSFPubObjParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFPubObjParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPubObjParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFPubObjParamDAO();
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

    protected void onFillParentInfo(PSSFPubObjParam pSSFPubObjParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPUBOBJPARAM_PSSFPUBOBJ_PSSFPUBOBJID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPubOjbService", (SessionFactory)this.getSessionFactory());
            PSSFPubOjb pSSFPubOjb = (PSSFPubOjb)iService.getDEModel().createEntity();
            pSSFPubOjb.set("PSSFPUBOBJID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFPubOjb);
            } else {
                iService.get((IEntity)pSSFPubOjb);
            }
            this.onFillParentInfo_Pssfpubobj(pSSFPubObjParam, pSSFPubOjb);
            return;
        }
        super.onFillParentInfo((IEntity)pSSFPubObjParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Pssfpubobj(PSSFPubObjParam pSSFPubObjParam, PSSFPubOjb pSSFPubOjb) throws Exception {
        pSSFPubObjParam.setPSSFPubObjId(pSSFPubOjb.getPSSFPubObjId());
        pSSFPubObjParam.setPSSFPubObjName(pSSFPubOjb.getPSSFPubObjName());
    }

    protected void onFillEntityFullInfo(PSSFPubObjParam pSSFPubObjParam, boolean bl) throws Exception {
        if (bl && pSSFPubObjParam.getValidFlag() == null) {
            pSSFPubObjParam.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSFPubObjParam, bl);
        this.onFillEntityFullInfo_Pssfpubobj(pSSFPubObjParam, bl);
    }

    protected void onFillEntityFullInfo_Pssfpubobj(PSSFPubObjParam pSSFPubObjParam, boolean bl) throws Exception {
        if (pSSFPubObjParam.isPSSFPubObjIdDirty()) {
            if (pSSFPubObjParam.getPSSFPubObjId() != null) {
                if (pSSFPubObjParam.getPSSFPubObjId() == null || pSSFPubObjParam.getPSSFPubObjName() == null) {
                    PSSFPubOjb pSSFPubOjb = pSSFPubObjParam.getPssfpubobj();
                    pSSFPubObjParam.setPSSFPubObjName(pSSFPubOjb.getPSSFPubObjName());
                }
            } else {
                pSSFPubObjParam.setPSSFPubObjName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSFPubObjParam pSSFPubObjParam, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSFPubObjParam, bl);
    }

    public ArrayList<PSSFPubObjParam> selectByPssfpubobj(PSSFPubOjbBase pSSFPubOjbBase) throws Exception {
        return this.selectByPssfpubobj(pSSFPubOjbBase, "", -1);
    }

    public ArrayList<PSSFPubObjParam> selectByPssfpubobj(PSSFPubOjbBase pSSFPubOjbBase, String string) throws Exception {
        return this.selectByPssfpubobj(pSSFPubOjbBase, string, -1);
    }

    public ArrayList<PSSFPubObjParam> selectByPssfpubobj(PSSFPubOjbBase pSSFPubOjbBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFPUBOBJID", (Object)pSSFPubOjbBase.getPSSFPubObjId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssfpubobjCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssfpubobjCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
    }

    public void resetPssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
        ArrayList<PSSFPubObjParam> arrayList = this.selectByPssfpubobj(pSSFPubOjb);
        for (PSSFPubObjParam pSSFPubObjParam : arrayList) {
            PSSFPubObjParam pSSFPubObjParam2 = (PSSFPubObjParam)this.getDEModel().createEntity();
            pSSFPubObjParam2.setPSSFPubObjParamId(pSSFPubObjParam.getPSSFPubObjParamId());
            pSSFPubObjParam2.setPSSFPubObjId(null);
            this.update(pSSFPubObjParam2);
        }
    }

    public void removeByPssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
        final PSSFPubOjb pSSFPubOjb2 = pSSFPubOjb;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPubObjParamServiceBase.this.onBeforeRemoveByPssfpubobj(pSSFPubOjb2);
                PSSFPubObjParamServiceBase.this.internalRemoveByPssfpubobj(pSSFPubOjb2);
                PSSFPubObjParamServiceBase.this.onAfterRemoveByPssfpubobj(pSSFPubOjb2);
            }
        });
    }

    protected void onBeforeRemoveByPssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
    }

    protected void internalRemoveByPssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
        ArrayList<PSSFPubObjParam> arrayList = this.selectByPssfpubobj(pSSFPubOjb);
        this.onBeforeRemoveByPssfpubobj(pSSFPubOjb, arrayList);
        for (PSSFPubObjParam pSSFPubObjParam : arrayList) {
            this.remove((IEntity)pSSFPubObjParam);
        }
        this.onAfterRemoveByPssfpubobj(pSSFPubOjb, arrayList);
    }

    protected void onAfterRemoveByPssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
    }

    protected void onBeforeRemoveByPssfpubobj(PSSFPubOjb pSSFPubOjb, ArrayList<PSSFPubObjParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssfpubobj(PSSFPubOjb pSSFPubOjb, ArrayList<PSSFPubObjParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFPubObjParam pSSFPubObjParam) throws Exception {
        super.onBeforeRemove(pSSFPubObjParam);
    }

    protected void replaceParentInfo(PSSFPubObjParam pSSFPubObjParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSFPubObjParam, cloneSession);
        if (pSSFPubObjParam.getPSSFPubObjId() != null && (iEntity = cloneSession.getEntity("PSSFPUBOBJ", (Object)pSSFPubObjParam.getPSSFPubObjId())) != null) {
            this.onFillParentInfo_Pssfpubobj(pSSFPubObjParam, (PSSFPubOjb)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFPubObjParam pSSFPubObjParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSFPubObjParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogicName(bl, pSSFPubObjParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjName(bl, pSSFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSSFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPubObjId(bl, pSSFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPubObjName(bl, pSSFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPubObjParamId(bl, pSSFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPubObjParamName(bl, pSSFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSFPubObjParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSFPubObjParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubObjParam.isLogicNameDirty() && !bl2 : !pSSFPubObjParam.isLogicNameDirty()) {
            return null;
        }
        String string = pSSFPubObjParam.getLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSFPubObjParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubObjParam.isMemoDirty() : !pSSFPubObjParam.isMemoDirty()) {
            return null;
        }
        String string = pSSFPubObjParam.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSFPubObjParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ObjName(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubObjParam.isObjNameDirty() && !bl2 : !pSSFPubObjParam.isObjNameDirty()) {
            return null;
        }
        String string = pSSFPubObjParam.getObjName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjName_Default((IEntity)pSSFPubObjParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubObjParam.isParamTypeDirty() && !bl2 : !pSSFPubObjParam.isParamTypeDirty()) {
            return null;
        }
        String string = pSSFPubObjParam.getParamType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default((IEntity)pSSFPubObjParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFPubObjId(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubObjParam.isPSSFPubObjIdDirty() : !pSSFPubObjParam.isPSSFPubObjIdDirty()) {
            return null;
        }
        String string = pSSFPubObjParam.getPSSFPubObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPubObjId_Default((IEntity)pSSFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPubObjName(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubObjParam.isPSSFPubObjNameDirty() : !pSSFPubObjParam.isPSSFPubObjNameDirty()) {
            return null;
        }
        String string = pSSFPubObjParam.getPSSFPubObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPubObjName_Default((IEntity)pSSFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPubObjParamId(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubObjParam.isPSSFPubObjParamIdDirty() && !bl2 : !pSSFPubObjParam.isPSSFPubObjParamIdDirty()) {
            return null;
        }
        String string = pSSFPubObjParam.getPSSFPubObjParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPubObjParamId_Default((IEntity)pSSFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPubObjParamName(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubObjParam.isPSSFPubObjParamNameDirty() && !bl2 : !pSSFPubObjParam.isPSSFPubObjParamNameDirty()) {
            return null;
        }
        String string = pSSFPubObjParam.getPSSFPubObjParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPubObjParamName_Default((IEntity)pSSFPubObjParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSFPubObjParam pSSFPubObjParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubObjParam.isValidFlagDirty() && !bl2 : !pSSFPubObjParam.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSFPubObjParam.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSFPubObjParam, bl2, bl3);
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

    protected void onSyncEntity(PSSFPubObjParam pSSFPubObjParam, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSFPubObjParam, bl);
    }

    protected void onSyncIndexEntities(PSSFPubObjParam pSSFPubObjParam, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSFPubObjParam, bl);
    }

    public Object getDataContextValue(PSSFPubObjParam pSSFPubObjParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSFPubObjParam, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSFPubObjParam pSSFPubObjParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSFPubObjParam, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSFPUBOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPubObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPUBOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPubObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPUBOBJPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPubObjParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPUBOBJPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPubObjParamName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSFPubObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPUBOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPubObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPUBOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPubObjParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPUBOBJPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPubObjParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPUBOBJPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSFPubObjParam pSSFPubObjParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSFPubObjParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFPubObjParam pSSFPubObjParam) throws Exception {
        super.onUpdateParent((IEntity)pSSFPubObjParam);
    }

    @Override
    protected void exportCurXmlModel(PSSFPubObjParam pSSFPubObjParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFPUBOBJPARAM");
        if (!bl) {
            pSSFPubObjParam.setCreateDate(null);
            pSSFPubObjParam.setCreateMan(null);
            pSSFPubObjParam.setPSSFPubObjParamId(null);
            pSSFPubObjParam.setUpdateDate(null);
            pSSFPubObjParam.setUpdateMan(null);
            super.exportCurXmlModel(pSSFPubObjParam, xmlNode, bl);
        }
    }
}

