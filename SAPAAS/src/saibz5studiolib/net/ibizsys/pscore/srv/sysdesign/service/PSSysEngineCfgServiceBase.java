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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysEngineCfgDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysEngineCfgDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEngineCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEngineCfgServiceBase
extends PSCoreSysServiceBase<PSSysEngineCfg> {
    private static final Log log = LogFactory.getLog(PSSysEngineCfgServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysEngineCfgDEModel pSSysEngineCfgDEModel;
    private PSSysEngineCfgDAO pSSysEngineCfgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysEngineCfgService";
    }

    public PSSysEngineCfgDEModel getPSSysEngineCfgDEModel() {
        if (this.pSSysEngineCfgDEModel == null) {
            try {
                this.pSSysEngineCfgDEModel = (PSSysEngineCfgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysEngineCfgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEngineCfgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysEngineCfgDEModel();
    }

    public PSSysEngineCfgDAO getPSSysEngineCfgDAO() {
        if (this.pSSysEngineCfgDAO == null) {
            try {
                this.pSSysEngineCfgDAO = (PSSysEngineCfgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysEngineCfgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEngineCfgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysEngineCfgDAO();
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

    protected void onFillParentInfo(PSSysEngineCfg pSSysEngineCfg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSENGINECFG_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSSysEngineCfg, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSSysEngineCfg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSSysEngineCfg pSSysEngineCfg, PSDevCenter pSDevCenter) throws Exception {
        pSSysEngineCfg.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSSysEngineCfg.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSSysEngineCfg pSSysEngineCfg, boolean bl) throws Exception {
        if (bl) {
            if (pSSysEngineCfg.getCfgVer() == null) {
                pSSysEngineCfg.setCfgVer((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSysEngineCfg.getValidFlag() == null) {
                pSSysEngineCfg.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSysEngineCfg.getViewCtrlAjaxMode() == null) {
                pSSysEngineCfg.setViewCtrlAjaxMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysEngineCfg.getViewUARegMode() == null) {
                pSSysEngineCfg.setViewUARegMode((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysEngineCfg, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSSysEngineCfg, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSSysEngineCfg pSSysEngineCfg, boolean bl) throws Exception {
        if (pSSysEngineCfg.isPSDevCenterIdDirty()) {
            if (pSSysEngineCfg.getPSDevCenterId() != null) {
                if (pSSysEngineCfg.getPSDevCenterId() == null || pSSysEngineCfg.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSSysEngineCfg.getPSDevCenter();
                    pSSysEngineCfg.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSSysEngineCfg.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysEngineCfg pSSysEngineCfg, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysEngineCfg, bl);
    }

    public ArrayList<PSSysEngineCfg> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSSysEngineCfg> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSSysEngineCfg> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSysEngineCfg> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSSysEngineCfg pSSysEngineCfg : arrayList) {
            PSSysEngineCfg pSSysEngineCfg2 = (PSSysEngineCfg)this.getDEModel().createEntity();
            pSSysEngineCfg2.setPSSysEngineCfgId(pSSysEngineCfg.getPSSysEngineCfgId());
            pSSysEngineCfg2.setPSDevCenterId(null);
            this.update(pSSysEngineCfg2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEngineCfgServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSSysEngineCfgServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSSysEngineCfgServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSysEngineCfg> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSSysEngineCfg pSSysEngineCfg : arrayList) {
            this.remove(pSSysEngineCfg);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSSysEngineCfg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSSysEngineCfg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysEngineCfg pSSysEngineCfg) throws Exception {
        PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
        pSSystemService.testRemoveByPSSysEngineCfg(pSSysEngineCfg);
        super.onBeforeRemove(pSSysEngineCfg);
    }

    protected void replaceParentInfo(PSSysEngineCfg pSSysEngineCfg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysEngineCfg, cloneSession);
        if (pSSysEngineCfg.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSSysEngineCfg.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSSysEngineCfg, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysEngineCfg pSSysEngineCfg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysEngineCfg, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CfgVer(bl, pSSysEngineCfg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GlobalFlag(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImpDEFRule(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEngineCfgId(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEngineCfgName(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewCtrlAjaxMode(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewCtrlHandlerFirst(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewUARegMode(bl, pSSysEngineCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysEngineCfg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CfgVer(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isCfgVerDirty() : !pSSysEngineCfg.isCfgVerDirty()) {
            return null;
        }
        Integer n = pSSysEngineCfg.getCfgVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CfgVer_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GlobalFlag(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isGlobalFlagDirty() && !bl2 : !pSSysEngineCfg.isGlobalFlagDirty()) {
            return null;
        }
        Integer n = pSSysEngineCfg.getGlobalFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GLOBALFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_GlobalFlag_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GLOBALFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImpDEFRule(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isImpDEFRuleDirty() : !pSSysEngineCfg.isImpDEFRuleDirty()) {
            return null;
        }
        Integer n = pSSysEngineCfg.getImpDEFRule();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImpDEFRule_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPDEFRULE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isMemoDirty() : !pSSysEngineCfg.isMemoDirty()) {
            return null;
        }
        String string = pSSysEngineCfg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysEngineCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isPSDevCenterIdDirty() : !pSSysEngineCfg.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSSysEngineCfg.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isPSDevCenterNameDirty() : !pSSysEngineCfg.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSSysEngineCfg.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEngineCfgId(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isPSSysEngineCfgIdDirty() && !bl2 : !pSSysEngineCfg.isPSSysEngineCfgIdDirty()) {
            return null;
        }
        String string = pSSysEngineCfg.getPSSysEngineCfgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSENGINECFGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEngineCfgId_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSENGINECFGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEngineCfgName(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isPSSysEngineCfgNameDirty() && !bl2 : !pSSysEngineCfg.isPSSysEngineCfgNameDirty()) {
            return null;
        }
        String string = pSSysEngineCfg.getPSSysEngineCfgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSENGINECFGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEngineCfgName_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSENGINECFGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isValidFlagDirty() && !bl2 : !pSSysEngineCfg.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysEngineCfg.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysEngineCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewCtrlAjaxMode(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isViewCtrlAjaxModeDirty() : !pSSysEngineCfg.isViewCtrlAjaxModeDirty()) {
            return null;
        }
        Integer n = pSSysEngineCfg.getViewCtrlAjaxMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewCtrlAjaxMode_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWCTRLAJAXMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewCtrlHandlerFirst(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isViewCtrlHandlerFirstDirty() : !pSSysEngineCfg.isViewCtrlHandlerFirstDirty()) {
            return null;
        }
        Integer n = pSSysEngineCfg.getViewCtrlHandlerFirst();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewCtrlHandlerFirst_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWCTRLHANDLERFIRST");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewUARegMode(boolean bl, PSSysEngineCfg pSSysEngineCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEngineCfg.isViewUARegModeDirty() : !pSSysEngineCfg.isViewUARegModeDirty()) {
            return null;
        }
        Integer n = pSSysEngineCfg.getViewUARegMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewUARegMode_Default(pSSysEngineCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWUAREGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysEngineCfg pSSysEngineCfg, boolean bl) throws Exception {
        super.onSyncEntity(pSSysEngineCfg, bl);
    }

    protected void onSyncIndexEntities(PSSysEngineCfg pSSysEngineCfg, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysEngineCfg, bl);
    }

    public Object getDataContextValue(PSSysEngineCfg pSSysEngineCfg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysEngineCfg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysEngineCfg pSSysEngineCfg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysEngineCfg, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CFGVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GLOBALFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GlobalFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPDEFRULE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImpDEFRule_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSENGINECFGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEngineCfgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSENGINECFGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEngineCfgName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWCTRLAJAXMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewCtrlAjaxMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWCTRLHANDLERFIRST", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewCtrlHandlerFirst_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWUAREGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewUARegMode_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CfgVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_GlobalFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ImpDEFRule_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEngineCfgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSENGINECFGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEngineCfgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSENGINECFGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ViewCtrlAjaxMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewCtrlHandlerFirst_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewUARegMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSysEngineCfg pSSysEngineCfg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysEngineCfg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysEngineCfg pSSysEngineCfg) throws Exception {
        super.onUpdateParent(pSSysEngineCfg);
    }

    @Override
    protected void exportCurXmlModel(PSSysEngineCfg pSSysEngineCfg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSENGINECFG");
        if (!bl) {
            pSSysEngineCfg.setCreateDate(null);
            pSSysEngineCfg.setCreateMan(null);
            pSSysEngineCfg.setPSSysEngineCfgId(null);
            pSSysEngineCfg.setUpdateDate(null);
            pSSysEngineCfg.setUpdateMan(null);
            super.exportCurXmlModel(pSSysEngineCfg, xmlNode, bl);
        }
    }
}

