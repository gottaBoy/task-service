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
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.demodel.IDataEntityModel;
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSRobotAbilityDAO;
import net.ibizsys.pscore.srv.config.demodel.PSRobotAbilityDEModel;
import net.ibizsys.pscore.srv.config.entity.PSRobotAbility;
import net.ibizsys.pscore.srv.config.entity.PSRobotWork;
import net.ibizsys.pscore.srv.config.entity.PSRobotWorkBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRobotAbilityServiceBase
extends PSCoreSysServiceBase<PSRobotAbility> {
    private static final Log log = LogFactory.getLog(PSRobotAbilityServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSRobotAbilityDEModel pSRobotAbilityDEModel;
    private PSRobotAbilityDAO pSRobotAbilityDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSRobotAbilityService";
    }

    public PSRobotAbilityDEModel getPSRobotAbilityDEModel() {
        if (this.pSRobotAbilityDEModel == null) {
            try {
                this.pSRobotAbilityDEModel = (PSRobotAbilityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSRobotAbilityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRobotAbilityDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSRobotAbilityDEModel();
    }

    public PSRobotAbilityDAO getPSRobotAbilityDAO() {
        if (this.pSRobotAbilityDAO == null) {
            try {
                this.pSRobotAbilityDAO = (PSRobotAbilityDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSRobotAbilityDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRobotAbilityDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSRobotAbilityDAO();
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

    protected void onFillParentInfo(PSRobotAbility pSRobotAbility, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSROBOTABILITY_PSROBOTWORK_PSROBOTWORKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRobotWorkService", (SessionFactory)this.getSessionFactory());
            PSRobotWork pSRobotWork = (PSRobotWork)iService.getDEModel().createEntity();
            pSRobotWork.set("PSROBOTWORKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSRobotWork);
            } else {
                iService.get((IEntity)pSRobotWork);
            }
            this.onFillParentInfo_PSRobotWork(pSRobotAbility, pSRobotWork);
            return;
        }
        super.onFillParentInfo((IEntity)pSRobotAbility, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSRobotWork(PSRobotAbility pSRobotAbility, PSRobotWork pSRobotWork) throws Exception {
        pSRobotAbility.setPSRobotWorkId(pSRobotWork.getPSRobotWorkId());
        pSRobotAbility.setPSRobotWorkName(pSRobotWork.getPSRobotWorkName());
    }

    protected boolean onFillEntityKeyValue(PSRobotAbility pSRobotAbility, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSRobotAbility.get("PSROBOTWORKID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSRobotAbility.get("ABILITYTAG");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSRobotAbility.get("ABILITYTAG2");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSRobotAbility.set(this.getPSRobotAbilityDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSRobotAbility pSRobotAbility, boolean bl) throws Exception {
        if (bl) {
            if (pSRobotAbility.getDefaultFlag() == null) {
                pSRobotAbility.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSRobotAbility.getValidFlag() == null) {
                pSRobotAbility.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSRobotAbility, bl);
        this.onFillEntityFullInfo_PSRobotWork(pSRobotAbility, bl);
    }

    protected void onFillEntityFullInfo_PSRobotWork(PSRobotAbility pSRobotAbility, boolean bl) throws Exception {
        if (pSRobotAbility.isPSRobotWorkIdDirty()) {
            if (pSRobotAbility.getPSRobotWorkId() != null) {
                if (pSRobotAbility.getPSRobotWorkId() == null || pSRobotAbility.getPSRobotWorkName() == null) {
                    PSRobotWork pSRobotWork = pSRobotAbility.getPSRobotWork();
                    pSRobotAbility.setPSRobotWorkName(pSRobotWork.getPSRobotWorkName());
                }
            } else {
                pSRobotAbility.setPSRobotWorkName(null);
            }
        }
    }

    protected void onWriteBackParent(PSRobotAbility pSRobotAbility, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSRobotAbility, bl);
    }

    public ArrayList<PSRobotAbility> selectByPSRobotWork(PSRobotWorkBase pSRobotWorkBase) throws Exception {
        return this.selectByPSRobotWork(pSRobotWorkBase, "", -1);
    }

    public ArrayList<PSRobotAbility> selectByPSRobotWork(PSRobotWorkBase pSRobotWorkBase, String string) throws Exception {
        return this.selectByPSRobotWork(pSRobotWorkBase, string, -1);
    }

    public ArrayList<PSRobotAbility> selectByPSRobotWork(PSRobotWorkBase pSRobotWorkBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSROBOTWORKID", (Object)pSRobotWorkBase.getPSRobotWorkId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSRobotWorkCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSRobotWorkCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSRobotWork(PSRobotWork pSRobotWork) throws Exception {
        ArrayList<PSRobotAbility> arrayList = this.selectByPSRobotWork(pSRobotWork, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSROBOTWORK");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSRobotWork);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSROBOTABILITY_PSROBOTWORK_PSROBOTWORKID", "", iDataEntityModel.getName(), "PSROBOTABILITY", iDataEntityModel.getDataInfo((IEntity)pSRobotWork), arrayList.get(0)));
        }
    }

    public void resetPSRobotWork(PSRobotWork pSRobotWork) throws Exception {
        ArrayList<PSRobotAbility> arrayList = this.selectByPSRobotWork(pSRobotWork);
        for (PSRobotAbility pSRobotAbility : arrayList) {
            PSRobotAbility pSRobotAbility2 = (PSRobotAbility)this.getDEModel().createEntity();
            pSRobotAbility2.setPSRobotAbilityId(pSRobotAbility.getPSRobotAbilityId());
            pSRobotAbility2.setPSRobotWorkId(null);
            this.update(pSRobotAbility2);
        }
    }

    public void removeByPSRobotWork(PSRobotWork pSRobotWork) throws Exception {
        final PSRobotWork pSRobotWork2 = pSRobotWork;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSRobotAbilityServiceBase.this.onBeforeRemoveByPSRobotWork(pSRobotWork2);
                PSRobotAbilityServiceBase.this.internalRemoveByPSRobotWork(pSRobotWork2);
                PSRobotAbilityServiceBase.this.onAfterRemoveByPSRobotWork(pSRobotWork2);
            }
        });
    }

    protected void onBeforeRemoveByPSRobotWork(PSRobotWork pSRobotWork) throws Exception {
    }

    protected void internalRemoveByPSRobotWork(PSRobotWork pSRobotWork) throws Exception {
        ArrayList<PSRobotAbility> arrayList = this.selectByPSRobotWork(pSRobotWork);
        this.onBeforeRemoveByPSRobotWork(pSRobotWork, arrayList);
        for (PSRobotAbility pSRobotAbility : arrayList) {
            this.remove((IEntity)pSRobotAbility);
        }
        this.onAfterRemoveByPSRobotWork(pSRobotWork, arrayList);
    }

    protected void onAfterRemoveByPSRobotWork(PSRobotWork pSRobotWork) throws Exception {
    }

    protected void onBeforeRemoveByPSRobotWork(PSRobotWork pSRobotWork, ArrayList<PSRobotAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSRobotWork(PSRobotWork pSRobotWork, ArrayList<PSRobotAbility> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSRobotAbility pSRobotAbility) throws Exception {
        PSDCRobotAbilityService pSDCRobotAbilityService = (PSDCRobotAbilityService)ServiceGlobal.getService(PSDCRobotAbilityService.class, (SessionFactory)this.getSessionFactory());
        pSDCRobotAbilityService.testRemoveByPSRobotAbility(pSRobotAbility);
        super.onBeforeRemove(pSRobotAbility);
    }

    protected void replaceParentInfo(PSRobotAbility pSRobotAbility, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSRobotAbility, cloneSession);
        if (pSRobotAbility.getPSRobotWorkId() != null && (iEntity = cloneSession.getEntity("PSROBOTWORK", (Object)pSRobotAbility.getPSRobotWorkId())) != null) {
            this.onFillParentInfo_PSRobotWork(pSRobotAbility, (PSRobotWork)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSRobotAbility pSRobotAbility, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSRobotAbility, bl);
    }

    protected void onCheckEntity(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AbilityTag(bl, pSRobotAbility, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AbilityTag2(bl, pSRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotAbilityId(bl, pSRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotAbilityName(bl, pSRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotWorkId(bl, pSRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotWorkName(bl, pSRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeObj(bl, pSRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSRobotAbility, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AbilityTag(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isAbilityTagDirty() && !bl2 : !pSRobotAbility.isAbilityTagDirty()) {
            return null;
        }
        String string = pSRobotAbility.getAbilityTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ABILITYTAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AbilityTag_Default((IEntity)pSRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ABILITYTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AbilityTag2(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isAbilityTag2Dirty() : !pSRobotAbility.isAbilityTag2Dirty()) {
            return null;
        }
        String string = pSRobotAbility.getAbilityTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AbilityTag2_Default((IEntity)pSRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ABILITYTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isDefaultFlagDirty() && !bl2 : !pSRobotAbility.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSRobotAbility.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isMemoDirty() : !pSRobotAbility.isMemoDirty()) {
            return null;
        }
        String string = pSRobotAbility.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSRobotAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSRobotAbilityId(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isPSRobotAbilityIdDirty() && !bl2 : !pSRobotAbility.isPSRobotAbilityIdDirty()) {
            return null;
        }
        String string = pSRobotAbility.getPSRobotAbilityId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTABILITYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotAbilityId_Default((IEntity)pSRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTABILITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRobotAbilityName(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isPSRobotAbilityNameDirty() && !bl2 : !pSRobotAbility.isPSRobotAbilityNameDirty()) {
            return null;
        }
        String string = pSRobotAbility.getPSRobotAbilityName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTABILITYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotAbilityName_Default((IEntity)pSRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTABILITYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRobotWorkId(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isPSRobotWorkIdDirty() && !bl2 : !pSRobotAbility.isPSRobotWorkIdDirty()) {
            return null;
        }
        String string = pSRobotAbility.getPSRobotWorkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTWORKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotWorkId_Default((IEntity)pSRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTWORKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRobotWorkName(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isPSRobotWorkNameDirty() : !pSRobotAbility.isPSRobotWorkNameDirty()) {
            return null;
        }
        String string = pSRobotAbility.getPSRobotWorkName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotWorkName_Default((IEntity)pSRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTWORKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeObj(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isTypeObjDirty() : !pSRobotAbility.isTypeObjDirty()) {
            return null;
        }
        String string = pSRobotAbility.getTypeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeObj_Default((IEntity)pSRobotAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSRobotAbility pSRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotAbility.isValidFlagDirty() && !bl2 : !pSRobotAbility.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSRobotAbility.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSRobotAbility, bl2, bl3);
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

    protected void onSyncEntity(PSRobotAbility pSRobotAbility, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSRobotAbility, bl);
    }

    protected void onSyncIndexEntities(PSRobotAbility pSRobotAbility, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSRobotAbility, bl);
    }

    public Object getDataContextValue(PSRobotAbility pSRobotAbility, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSRobotAbility, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSRobotAbility pSRobotAbility, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSRobotAbility, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ABILITYTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AbilityTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ABILITYTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AbilityTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTABILITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotAbilityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTABILITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotAbilityName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTWORKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotWorkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTWORKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotWorkName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AbilityTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ABILITYTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AbilityTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ABILITYTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSRobotAbilityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTABILITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotAbilityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTABILITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotWorkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTWORKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotWorkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTWORKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSRobotAbility pSRobotAbility) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSRobotAbility)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSRobotAbility pSRobotAbility) throws Exception {
        super.onUpdateParent((IEntity)pSRobotAbility);
    }

    @Override
    protected void exportCurXmlModel(PSRobotAbility pSRobotAbility, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSROBOTABILITY");
        if (!bl) {
            pSRobotAbility.setCreateDate(null);
            pSRobotAbility.setCreateMan(null);
            pSRobotAbility.setPSRobotAbilityId(null);
            pSRobotAbility.setUpdateDate(null);
            pSRobotAbility.setUpdateMan(null);
            super.exportCurXmlModel(pSRobotAbility, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSRobotAbility pSRobotAbility, PSSystem pSSystem) throws Exception {
        PSRobotAbility pSRobotAbility2 = new PSRobotAbility();
        pSRobotAbility2.setPSRobotWorkId(pSRobotAbility.getPSRobotWorkId());
        pSRobotAbility2.setAbilityTag(pSRobotAbility.getAbilityTag());
        pSRobotAbility2.setAbilityTag2(pSRobotAbility.getAbilityTag2());
        if (this.selectOne((IEntity)pSRobotAbility2, true)) {
            return pSRobotAbility2.getPSRobotAbilityId();
        }
        return super.getEntityFolderKeyValue(pSRobotAbility, pSSystem);
    }
}

