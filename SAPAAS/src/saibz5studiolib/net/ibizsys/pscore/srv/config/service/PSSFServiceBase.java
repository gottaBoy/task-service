/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSFDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.service.PSCounterTypeSFService;
import net.ibizsys.pscore.srv.config.service.PSCounterTypeSFServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFACHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSFACHandlerServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFConfigService;
import net.ibizsys.pscore.srv.config.service.PSSFConfigServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFCtrlTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFExceptionService;
import net.ibizsys.pscore.srv.config.service.PSSFExceptionServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFPFService;
import net.ibizsys.pscore.srv.config.service.PSSFPFServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFPkgCatService;
import net.ibizsys.pscore.srv.config.service.PSSFPkgCatServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFPkgService;
import net.ibizsys.pscore.srv.config.service.PSSFPkgServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFPubOjbService;
import net.ibizsys.pscore.srv.config.service.PSSFPubOjbServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFSAHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSFSAHandlerServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStyleParamService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleParamServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFViewTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFViewTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubSysSFService;
import net.ibizsys.pscore.srv.config.service.PSSubSysSFServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.config.service.PSSubSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSFService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSFServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFServiceBase
extends PSCoreSysServiceBase<PSSF> {
    private static final Log log = LogFactory.getLog(PSSFServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VALID = "Valid";
    private PSSFDEModel pSSFDEModel;
    private PSSFDAO pSSFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFService";
    }

    public PSSFDEModel getPSSFDEModel() {
        if (this.pSSFDEModel == null) {
            try {
                this.pSSFDEModel = (PSSFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFDEModel();
    }

    public PSSFDAO getPSSFDAO() {
        if (this.pSSFDAO == null) {
            try {
                this.pSSFDAO = (PSSFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALID, (boolean)true) == 0) {
            return this.fetchValid(iDEDataSetFetchContext);
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

    public DBFetchResult fetchValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALID, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSF pSSF, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSSF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSSF pSSF, boolean bl) throws Exception {
        if (bl && pSSF.getValidFlag() == null) {
            pSSF.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSF, bl);
    }

    protected void onWriteBackParent(PSSF pSSF, boolean bl) throws Exception {
        super.onWriteBackParent(pSSF, bl);
    }

    @Override
    protected void onBeforeRemove(PSSF pSSF) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCounterTypeSFService)ServiceGlobal.getService(PSCounterTypeSFService.class, (SessionFactory)this.getSessionFactory());
        ((PSCounterTypeSFServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        ((PSCounterTypeSFServiceBase)pSCoreSysServiceBase).resetPSSF(pSSF);
        pSCoreSysServiceBase = (PSDCAbilityService)ServiceGlobal.getService(PSDCAbilityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCAbilityServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSDevCenterSFService)ServiceGlobal.getService(PSDevCenterSFService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterSFServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFACHandlerService)ServiceGlobal.getService(PSSFACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFConfigService)ServiceGlobal.getService(PSSFConfigService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFConfigServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFCtrlTypeService)ServiceGlobal.getService(PSSFCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFCtrlTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFExceptionService)ServiceGlobal.getService(PSSFExceptionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFExceptionServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFPFService)ServiceGlobal.getService(PSSFPFService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPFServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        ((PSSFPFServiceBase)pSCoreSysServiceBase).removeByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFPkgCatService)ServiceGlobal.getService(PSSFPkgCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPkgCatServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        ((PSSFPkgCatServiceBase)pSCoreSysServiceBase).resetPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFPkgService)ServiceGlobal.getService(PSSFPkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPkgServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        ((PSSFPkgServiceBase)pSCoreSysServiceBase).removeByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFPubOjbService)ServiceGlobal.getService(PSSFPubOjbService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPubOjbServiceBase)pSCoreSysServiceBase).testRemoveByPssf(pSSF);
        pSCoreSysServiceBase = (PSSFSAHandlerService)ServiceGlobal.getService(PSSFSAHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFSAHandlerServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFStyleParamService)ServiceGlobal.getService(PSSFStyleParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSFViewTypeService)ServiceGlobal.getService(PSSFViewTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFViewTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSubSysSFService)ServiceGlobal.getService(PSSubSysSFService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSFServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        pSCoreSysServiceBase = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPITemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        ((PSSysSFPITemplServiceBase)pSCoreSysServiceBase).resetPSSF(pSSF);
        pSCoreSysServiceBase = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSSF);
        super.onBeforeRemove(pSSF);
    }

    protected void onRemoveEntityUncopyValues(PSSF pSSF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSF, bl);
    }

    protected void onCheckEntity(boolean bl, PSSF pSSF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ClsFCUpperCase(bl, pSSF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPkgParams(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeFlag(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocFlag(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelFlag(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgLowerCase(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SlnFlag(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2Folder(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2GitPath(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ClsFCUpperCase(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isClsFCUpperCaseDirty() : !pSSF.isClsFCUpperCaseDirty()) {
            return null;
        }
        Integer n = pSSF.getClsFCUpperCase();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ClsFCUpperCase_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSFCUPPERCASE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClsPkgParams(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isClsPkgParamsDirty() : !pSSF.isClsPkgParamsDirty()) {
            return null;
        }
        String string = pSSF.getClsPkgParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPkgParams_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSPKGPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeFlag(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isCodeFlagDirty() : !pSSF.isCodeFlagDirty()) {
            return null;
        }
        Integer n = pSSF.getCodeFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CodeFlag_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocFlag(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isDocFlagDirty() : !pSSF.isDocFlagDirty()) {
            return null;
        }
        Integer n = pSSF.getDocFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DocFlag_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isMemoDirty() : !pSSF.isMemoDirty()) {
            return null;
        }
        String string = pSSF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSF, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelFlag(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isModelFlagDirty() : !pSSF.isModelFlagDirty()) {
            return null;
        }
        Integer n = pSSF.getModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelFlag_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgLowerCase(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isPkgLowerCaseDirty() : !pSSF.isPkgLowerCaseDirty()) {
            return null;
        }
        Integer n = pSSF.getPkgLowerCase();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PkgLowerCase_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGLOWERCASE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isPSSFIdDirty() && !bl2 : !pSSF.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSF.getPSSFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isPSSFNameDirty() && !bl2 : !pSSF.isPSSFNameDirty()) {
            return null;
        }
        String string = pSSF.getPSSFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SlnFlag(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isSlnFlagDirty() : !pSSF.isSlnFlagDirty()) {
            return null;
        }
        Integer n = pSSF.getSlnFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SlnFlag_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_V2Folder(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isV2FolderDirty() : !pSSF.isV2FolderDirty()) {
            return null;
        }
        String string = pSSF.getV2Folder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2Folder_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2FOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_V2GitPath(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isV2GitPathDirty() : !pSSF.isV2GitPathDirty()) {
            return null;
        }
        String string = pSSF.getV2GitPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2GitPath_Default(pSSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2GITPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSF pSSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSF.isValidFlagDirty() : !pSSF.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSF.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSF, bl2, bl3);
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

    protected void onSyncEntity(PSSF pSSF, boolean bl) throws Exception {
        super.onSyncEntity(pSSF, bl);
    }

    protected void onSyncIndexEntities(PSSF pSSF, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSF, bl);
    }

    public Object getDataContextValue(PSSF pSSF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSF, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSF pSSF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSF, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLSFCUPPERCASE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsFCUpperCase_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPKGPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPkgParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGLOWERCASE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgLowerCase_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SlnFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V2FOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2Folder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V2GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ClsFCUpperCase_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ClsPkgParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLSPKGPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DocFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PkgLowerCase_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SlnFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_V2Folder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2FOLDER", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_V2GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2GITPATH", iEntity, bl2, null, false, 400, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSF pSSF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSF pSSF) throws Exception {
        super.onUpdateParent(pSSF);
    }

    @Override
    protected void exportCurXmlModel(PSSF pSSF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSF");
        if (!bl) {
            pSSF.setCreateDate(null);
            pSSF.setCreateMan(null);
            pSSF.setUpdateDate(null);
            pSSF.setUpdateMan(null);
            super.exportCurXmlModel(pSSF, xmlNode, bl);
        }
    }
}

