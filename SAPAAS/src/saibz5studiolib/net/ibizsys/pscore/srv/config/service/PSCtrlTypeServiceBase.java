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
import net.ibizsys.pscore.srv.appdesign.service.PSAppCtrlStyleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppCtrlStyleServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSCtrlTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeActionService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeActionServiceBase;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeCallbackService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeCallbackServiceBase;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeEventService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeEventServiceBase;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeModelService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeModelServiceBase;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeMsgTagService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeMsgTagServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFCtrlTypeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeServiceBase
extends PSCoreSysServiceBase<PSCtrlType> {
    private static final Log log = LogFactory.getLog(PSCtrlTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCtrlTypeDEModel pSCtrlTypeDEModel;
    private PSCtrlTypeDAO pSCtrlTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSCtrlTypeService";
    }

    public PSCtrlTypeDEModel getPSCtrlTypeDEModel() {
        if (this.pSCtrlTypeDEModel == null) {
            try {
                this.pSCtrlTypeDEModel = (PSCtrlTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCtrlTypeDEModel();
    }

    public PSCtrlTypeDAO getPSCtrlTypeDAO() {
        if (this.pSCtrlTypeDAO == null) {
            try {
                this.pSCtrlTypeDAO = (PSCtrlTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSCtrlTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCtrlTypeDAO();
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

    protected void onFillParentInfo(PSCtrlType pSCtrlType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLTYPE_PSMODEL_PSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModel);
            } else {
                iService.get((IEntity)pSModel);
            }
            this.onFillParentInfo_PSModel(pSCtrlType, pSModel);
            return;
        }
        super.onFillParentInfo((IEntity)pSCtrlType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModel(PSCtrlType pSCtrlType, PSModel pSModel) throws Exception {
        pSCtrlType.setPSModelId(pSModel.getPSModelId());
        pSCtrlType.setPSModelName(pSModel.getPSModelName());
    }

    protected void onFillEntityFullInfo(PSCtrlType pSCtrlType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSCtrlType, bl);
        this.onFillEntityFullInfo_PSModel(pSCtrlType, bl);
    }

    protected void onFillEntityFullInfo_PSModel(PSCtrlType pSCtrlType, boolean bl) throws Exception {
        if (pSCtrlType.isPSModelIdDirty()) {
            if (pSCtrlType.getPSModelId() != null) {
                if (pSCtrlType.getPSModelId() == null || pSCtrlType.getPSModelName() == null) {
                    PSModel pSModel = pSCtrlType.getPSModel();
                    pSCtrlType.setPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSCtrlType.setPSModelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCtrlType pSCtrlType, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSCtrlType, bl);
    }

    public ArrayList<PSCtrlType> selectByPSModel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPSModel(pSModelBase, "", -1);
    }

    public ArrayList<PSCtrlType> selectByPSModel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPSModel(pSModelBase, string, -1);
    }

    public ArrayList<PSCtrlType> selectByPSModel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    public void resetPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSCtrlType> arrayList = this.selectByPSModel(pSModel);
        for (PSCtrlType pSCtrlType : arrayList) {
            PSCtrlType pSCtrlType2 = (PSCtrlType)this.getDEModel().createEntity();
            pSCtrlType2.setPSCtrlTypeId(pSCtrlType.getPSCtrlTypeId());
            pSCtrlType2.setPSModelId(null);
            this.update(pSCtrlType2);
        }
    }

    public void removeByPSModel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlTypeServiceBase.this.onBeforeRemoveByPSModel(pSModel2);
                PSCtrlTypeServiceBase.this.internalRemoveByPSModel(pSModel2);
                PSCtrlTypeServiceBase.this.onAfterRemoveByPSModel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSCtrlType> arrayList = this.selectByPSModel(pSModel);
        this.onBeforeRemoveByPSModel(pSModel, arrayList);
        for (PSCtrlType pSCtrlType : arrayList) {
            this.remove((IEntity)pSCtrlType);
        }
        this.onAfterRemoveByPSModel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel, ArrayList<PSCtrlType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel, ArrayList<PSCtrlType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCtrlType pSCtrlType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppCtrlStyleService)ServiceGlobal.getService(PSAppCtrlStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppCtrlStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlType(pSCtrlType);
        pSCoreSysServiceBase = (PSCtrlTypeActionService)ServiceGlobal.getService(PSCtrlTypeActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlTypeActionServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlType(pSCtrlType);
        ((PSCtrlTypeActionServiceBase)pSCoreSysServiceBase).removeByPSCtrlType(pSCtrlType);
        pSCoreSysServiceBase = (PSCtrlTypeCallbackService)ServiceGlobal.getService(PSCtrlTypeCallbackService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlTypeCallbackServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlType(pSCtrlType);
        ((PSCtrlTypeCallbackServiceBase)pSCoreSysServiceBase).removeByPSCtrlType(pSCtrlType);
        pSCoreSysServiceBase = (PSCtrlTypeEventService)ServiceGlobal.getService(PSCtrlTypeEventService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlTypeEventServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlType(pSCtrlType);
        ((PSCtrlTypeEventServiceBase)pSCoreSysServiceBase).removeByPSCtrlType(pSCtrlType);
        pSCoreSysServiceBase = (PSCtrlTypeModelService)ServiceGlobal.getService(PSCtrlTypeModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlTypeModelServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlType(pSCtrlType);
        ((PSCtrlTypeModelServiceBase)pSCoreSysServiceBase).removeByPSCtrlType(pSCtrlType);
        pSCoreSysServiceBase = (PSCtrlTypeMsgTagService)ServiceGlobal.getService(PSCtrlTypeMsgTagService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlTypeMsgTagServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlType(pSCtrlType);
        ((PSCtrlTypeMsgTagServiceBase)pSCoreSysServiceBase).removeByPSCtrlType(pSCtrlType);
        pSCoreSysServiceBase = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFCtrlTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlType(pSCtrlType);
        pSCoreSysServiceBase = (PSPFCtrlTypeService)ServiceGlobal.getService(PSPFCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFCtrlTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlType(pSCtrlType);
        pSCoreSysServiceBase = (PSSFCtrlTypeService)ServiceGlobal.getService(PSSFCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFCtrlTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlType(pSCtrlType);
        super.onBeforeRemove(pSCtrlType);
    }

    protected void replaceParentInfo(PSCtrlType pSCtrlType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSCtrlType, cloneSession);
        if (pSCtrlType.getPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSCtrlType.getPSModelId())) != null) {
            this.onFillParentInfo_PSModel(pSCtrlType, (PSModel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCtrlType pSCtrlType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSCtrlType, bl);
    }

    protected void onCheckEntity(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AjaxCtrl(bl, pSCtrlType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CTFullSN(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlObj(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlObjInt(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlTypeParams(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CTSN(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerObj(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPath(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JITCtrlObj(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JITCtrlObj2(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JITModelObj(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamObj(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamObjInt(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeId(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeName(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeObj(bl, pSCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSCtrlType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AjaxCtrl(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isAjaxCtrlDirty() && !bl2 : !pSCtrlType.isAjaxCtrlDirty()) {
            return null;
        }
        Integer n = pSCtrlType.getAjaxCtrl();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AJAXCTRL");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AjaxCtrl_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AJAXCTRL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CTFullSN(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isCTFullSNDirty() : !pSCtrlType.isCTFullSNDirty()) {
            return null;
        }
        String string = pSCtrlType.getCTFullSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CTFullSN_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTFULLSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlObj(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isCtrlObjDirty() && !bl2 : !pSCtrlType.isCtrlObjDirty()) {
            return null;
        }
        String string = pSCtrlType.getCtrlObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlObj_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlObjInt(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isCtrlObjIntDirty() : !pSCtrlType.isCtrlObjIntDirty()) {
            return null;
        }
        String string = pSCtrlType.getCtrlObjInt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlObjInt_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLOBJINT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlTypeParams(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isCtrlTypeParamsDirty() : !pSCtrlType.isCtrlTypeParamsDirty()) {
            return null;
        }
        String string = pSCtrlType.getCtrlTypeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlTypeParams_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CTSN(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isCTSNDirty() : !pSCtrlType.isCTSNDirty()) {
            return null;
        }
        String string = pSCtrlType.getCTSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CTSN_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerObj(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isHandlerObjDirty() : !pSCtrlType.isHandlerObjDirty()) {
            return null;
        }
        String string = pSCtrlType.getHandlerObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerObj_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPath(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isIconPathDirty() : !pSCtrlType.isIconPathDirty()) {
            return null;
        }
        String string = pSCtrlType.getIconPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPath_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JITCtrlObj(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isJITCtrlObjDirty() : !pSCtrlType.isJITCtrlObjDirty()) {
            return null;
        }
        String string = pSCtrlType.getJITCtrlObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JITCtrlObj_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JITCTRLOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JITCtrlObj2(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isJITCtrlObj2Dirty() : !pSCtrlType.isJITCtrlObj2Dirty()) {
            return null;
        }
        String string = pSCtrlType.getJITCtrlObj2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JITCtrlObj2_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JITCTRLOBJ2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JITModelObj(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isJITModelObjDirty() : !pSCtrlType.isJITModelObjDirty()) {
            return null;
        }
        String string = pSCtrlType.getJITModelObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JITModelObj_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JITMODELOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isMemoDirty() : !pSCtrlType.isMemoDirty()) {
            return null;
        }
        String string = pSCtrlType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSCtrlType, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isOrderValueDirty() : !pSCtrlType.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSCtrlType.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSCtrlType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamObj(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isParamObjDirty() && !bl2 : !pSCtrlType.isParamObjDirty()) {
            return null;
        }
        String string = pSCtrlType.getParamObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamObj_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamObjInt(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isParamObjIntDirty() : !pSCtrlType.isParamObjIntDirty()) {
            return null;
        }
        String string = pSCtrlType.getParamObjInt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamObjInt_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMOBJINT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeId(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isPSCtrlTypeIdDirty() && !bl2 : !pSCtrlType.isPSCtrlTypeIdDirty()) {
            return null;
        }
        String string = pSCtrlType.getPSCtrlTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeId_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeName(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isPSCtrlTypeNameDirty() && !bl2 : !pSCtrlType.isPSCtrlTypeNameDirty()) {
            return null;
        }
        String string = pSCtrlType.getPSCtrlTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeName_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isPSModelIdDirty() : !pSCtrlType.isPSModelIdDirty()) {
            return null;
        }
        String string = pSCtrlType.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isPSModelNameDirty() : !pSCtrlType.isPSModelNameDirty()) {
            return null;
        }
        String string = pSCtrlType.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeObj(boolean bl, PSCtrlType pSCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlType.isTypeObjDirty() : !pSCtrlType.isTypeObjDirty()) {
            return null;
        }
        String string = pSCtrlType.getTypeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeObj_Default((IEntity)pSCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCtrlType pSCtrlType, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSCtrlType, bl);
    }

    protected void onSyncIndexEntities(PSCtrlType pSCtrlType, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSCtrlType, bl);
    }

    public Object getDataContextValue(PSCtrlType pSCtrlType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSCtrlType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSCtrlType pSCtrlType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSCtrlType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AJAXCTRL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AjaxCtrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTFULLSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CTFullSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLOBJINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlObjInt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLTYPEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlTypeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CTSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLEROBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JITCTRLOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JITCtrlObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JITCTRLOBJ2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JITCtrlObj2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JITMODELOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JITModelObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMOBJINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamObjInt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AjaxCtrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_CTFullSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTFULLSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlObjInt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLOBJINT", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlTypeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLTYPEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CTSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLEROBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JITCtrlObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JITCTRLOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JITCtrlObj2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JITCTRLOBJ2", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JITModelObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JITMODELOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_ParamObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamObjInt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMOBJINT", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected boolean onMergeChild(String string, String string2, PSCtrlType pSCtrlType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSCtrlType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCtrlType pSCtrlType) throws Exception {
        super.onUpdateParent((IEntity)pSCtrlType);
    }

    @Override
    protected void exportCurXmlModel(PSCtrlType pSCtrlType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCTRLTYPE");
        if (!bl) {
            pSCtrlType.setCreateDate(null);
            pSCtrlType.setCreateMan(null);
            pSCtrlType.setUpdateDate(null);
            pSCtrlType.setUpdateMan(null);
            super.exportCurXmlModel(pSCtrlType, xmlNode, bl);
        }
    }
}

