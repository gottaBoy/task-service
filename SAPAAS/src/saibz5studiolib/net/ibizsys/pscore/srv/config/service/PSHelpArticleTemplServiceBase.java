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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSHelpArticleTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSHelpArticleTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleTempl;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleType;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleTypeBase;
import net.ibizsys.pscore.srv.config.service.PSHelpArticleTypeService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpArticleTemplServiceBase
extends PSCoreSysServiceBase<PSHelpArticleTempl> {
    private static final Log log = LogFactory.getLog(PSHelpArticleTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSHelpArticleTemplDEModel pSHelpArticleTemplDEModel;
    private PSHelpArticleTemplDAO pSHelpArticleTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSHelpArticleTemplService";
    }

    public PSHelpArticleTemplDEModel getPSHelpArticleTemplDEModel() {
        if (this.pSHelpArticleTemplDEModel == null) {
            try {
                this.pSHelpArticleTemplDEModel = (PSHelpArticleTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSHelpArticleTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArticleTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpArticleTemplDEModel();
    }

    public PSHelpArticleTemplDAO getPSHelpArticleTemplDAO() {
        if (this.pSHelpArticleTemplDAO == null) {
            try {
                this.pSHelpArticleTemplDAO = (PSHelpArticleTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSHelpArticleTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArticleTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpArticleTemplDAO();
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

    protected void onFillParentInfo(PSHelpArticleTempl pSHelpArticleTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTICLETEMPL_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSHelpArticleTempl, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTICLETEMPL_PSHELPARTICLETYPE_PSHELPARTICLETYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpArticleTypeService", (SessionFactory)this.getSessionFactory());
            PSHelpArticleType pSHelpArticleType = (PSHelpArticleType)iService.getDEModel().createEntity();
            pSHelpArticleType.set("PSHELPARTICLETYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSHelpArticleType);
            } else {
                iService.get((IEntity)pSHelpArticleType);
            }
            this.onFillParentInfo_PSHelpArticleType(pSHelpArticleTempl, pSHelpArticleType);
            return;
        }
        super.onFillParentInfo((IEntity)pSHelpArticleTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSHelpArticleTempl pSHelpArticleTempl, PSDevCenter pSDevCenter) throws Exception {
        pSHelpArticleTempl.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSHelpArticleTempl.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSHelpArticleType(PSHelpArticleTempl pSHelpArticleTempl, PSHelpArticleType pSHelpArticleType) throws Exception {
        pSHelpArticleTempl.setPSHelpArticleTypeId(pSHelpArticleType.getPSHelpArticleTypeId());
        pSHelpArticleTempl.setPSHelpArticleTypeName(pSHelpArticleType.getPSHelpArticleTypeName());
    }

    protected void onFillEntityFullInfo(PSHelpArticleTempl pSHelpArticleTempl, boolean bl) throws Exception {
        if (bl) {
            if (pSHelpArticleTempl.getDefaultFlag() == null) {
                pSHelpArticleTempl.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSHelpArticleTempl.getValidFlag() == null) {
                pSHelpArticleTempl.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSHelpArticleTempl, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSHelpArticleTempl, bl);
        this.onFillEntityFullInfo_PSHelpArticleType(pSHelpArticleTempl, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSHelpArticleTempl pSHelpArticleTempl, boolean bl) throws Exception {
        if (pSHelpArticleTempl.isPSDevCenterIdDirty()) {
            if (pSHelpArticleTempl.getPSDevCenterId() != null) {
                if (pSHelpArticleTempl.getPSDevCenterId() == null || pSHelpArticleTempl.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSHelpArticleTempl.getPSDevCenter();
                    pSHelpArticleTempl.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSHelpArticleTempl.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSHelpArticleType(PSHelpArticleTempl pSHelpArticleTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSHelpArticleTempl pSHelpArticleTempl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSHelpArticleTempl, bl);
    }

    public ArrayList<PSHelpArticleTempl> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSHelpArticleTempl> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSHelpArticleTempl> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSHelpArticleTempl> selectByPSHelpArticleType(PSHelpArticleTypeBase pSHelpArticleTypeBase) throws Exception {
        return this.selectByPSHelpArticleType(pSHelpArticleTypeBase, "", -1);
    }

    public ArrayList<PSHelpArticleTempl> selectByPSHelpArticleType(PSHelpArticleTypeBase pSHelpArticleTypeBase, String string) throws Exception {
        return this.selectByPSHelpArticleType(pSHelpArticleTypeBase, string, -1);
    }

    public ArrayList<PSHelpArticleTempl> selectByPSHelpArticleType(PSHelpArticleTypeBase pSHelpArticleTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPARTICLETYPEID", (Object)pSHelpArticleTypeBase.getPSHelpArticleTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpArticleTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpArticleTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSHelpArticleTempl> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPARTICLETEMPL_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSHELPARTICLETEMPL", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSHelpArticleTempl> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSHelpArticleTempl pSHelpArticleTempl : arrayList) {
            PSHelpArticleTempl pSHelpArticleTempl2 = (PSHelpArticleTempl)this.getDEModel().createEntity();
            pSHelpArticleTempl2.setPSHelpArticleTemplId(pSHelpArticleTempl.getPSHelpArticleTemplId());
            pSHelpArticleTempl2.setPSDevCenterId(null);
            this.update(pSHelpArticleTempl2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArticleTemplServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSHelpArticleTemplServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSHelpArticleTemplServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSHelpArticleTempl> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSHelpArticleTempl pSHelpArticleTempl : arrayList) {
            this.remove((IEntity)pSHelpArticleTempl);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSHelpArticleTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSHelpArticleTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
        ArrayList<PSHelpArticleTempl> arrayList = this.selectByPSHelpArticleType(pSHelpArticleType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPARTICLETYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSHelpArticleType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPARTICLETEMPL_PSHELPARTICLETYPE_PSHELPARTICLETYPEID", "", iDataEntityModel.getName(), "PSHELPARTICLETEMPL", iDataEntityModel.getDataInfo((IEntity)pSHelpArticleType), arrayList.get(0)));
        }
    }

    public void resetPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
        ArrayList<PSHelpArticleTempl> arrayList = this.selectByPSHelpArticleType(pSHelpArticleType);
        for (PSHelpArticleTempl pSHelpArticleTempl : arrayList) {
            PSHelpArticleTempl pSHelpArticleTempl2 = (PSHelpArticleTempl)this.getDEModel().createEntity();
            pSHelpArticleTempl2.setPSHelpArticleTemplId(pSHelpArticleTempl.getPSHelpArticleTemplId());
            pSHelpArticleTempl2.setPSHelpArticleTypeId(null);
            this.update(pSHelpArticleTempl2);
        }
    }

    public void removeByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
        final PSHelpArticleType pSHelpArticleType2 = pSHelpArticleType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArticleTemplServiceBase.this.onBeforeRemoveByPSHelpArticleType(pSHelpArticleType2);
                PSHelpArticleTemplServiceBase.this.internalRemoveByPSHelpArticleType(pSHelpArticleType2);
                PSHelpArticleTemplServiceBase.this.onAfterRemoveByPSHelpArticleType(pSHelpArticleType2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
    }

    protected void internalRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
        ArrayList<PSHelpArticleTempl> arrayList = this.selectByPSHelpArticleType(pSHelpArticleType);
        this.onBeforeRemoveByPSHelpArticleType(pSHelpArticleType, arrayList);
        for (PSHelpArticleTempl pSHelpArticleTempl : arrayList) {
            this.remove((IEntity)pSHelpArticleTempl);
        }
        this.onAfterRemoveByPSHelpArticleType(pSHelpArticleType, arrayList);
    }

    protected void onAfterRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType, ArrayList<PSHelpArticleTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType, ArrayList<PSHelpArticleTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
        PSHelpArticleTypeService pSHelpArticleTypeService = (PSHelpArticleTypeService)ServiceGlobal.getService(PSHelpArticleTypeService.class, (SessionFactory)this.getSessionFactory());
        pSHelpArticleTypeService.testRemoveByPSHelpArticleTempl(pSHelpArticleTempl);
        super.onBeforeRemove(pSHelpArticleTempl);
    }

    protected void replaceParentInfo(PSHelpArticleTempl pSHelpArticleTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSHelpArticleTempl, cloneSession);
        if (pSHelpArticleTempl.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSHelpArticleTempl.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSHelpArticleTempl, (PSDevCenter)iEntity);
        }
        if (pSHelpArticleTempl.getPSHelpArticleTypeId() != null && (iEntity = cloneSession.getEntity("PSHELPARTICLETYPE", (Object)pSHelpArticleTempl.getPSHelpArticleTypeId())) != null) {
            this.onFillParentInfo_PSHelpArticleType(pSHelpArticleTempl, (PSHelpArticleType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpArticleTempl pSHelpArticleTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSHelpArticleTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DefaultFlag(bl, pSHelpArticleTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleTemplId(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleTemplName(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleTypeId(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSHelpArticleTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSHelpArticleTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isDefaultFlagDirty() && !bl2 : !pSHelpArticleTempl.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSHelpArticleTempl.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isMemoDirty() : !pSHelpArticleTempl.isMemoDirty()) {
            return null;
        }
        String string = pSHelpArticleTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isPSDevCenterIdDirty() : !pSHelpArticleTempl.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSHelpArticleTempl.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isPSDevCenterNameDirty() : !pSHelpArticleTempl.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSHelpArticleTempl.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpArticleTemplId(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isPSHelpArticleTemplIdDirty() && !bl2 : !pSHelpArticleTempl.isPSHelpArticleTemplIdDirty()) {
            return null;
        }
        String string = pSHelpArticleTempl.getPSHelpArticleTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleTemplId_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArticleTemplName(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isPSHelpArticleTemplNameDirty() && !bl2 : !pSHelpArticleTempl.isPSHelpArticleTemplNameDirty()) {
            return null;
        }
        String string = pSHelpArticleTempl.getPSHelpArticleTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleTemplName_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArticleTypeId(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isPSHelpArticleTypeIdDirty() : !pSHelpArticleTempl.isPSHelpArticleTypeIdDirty()) {
            return null;
        }
        String string = pSHelpArticleTempl.getPSHelpArticleTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleTypeId_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isPubModeDirty() : !pSHelpArticleTempl.isPubModeDirty()) {
            return null;
        }
        Integer n = pSHelpArticleTempl.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isPubObjDirty() : !pSHelpArticleTempl.isPubObjDirty()) {
            return null;
        }
        String string = pSHelpArticleTempl.getPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isTemplCodeDirty() : !pSHelpArticleTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSHelpArticleTempl.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isTemplCode2Dirty() : !pSHelpArticleTempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSHelpArticleTempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSHelpArticleTempl pSHelpArticleTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleTempl.isValidFlagDirty() && !bl2 : !pSHelpArticleTempl.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSHelpArticleTempl.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSHelpArticleTempl, bl2, bl3);
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

    protected void onSyncEntity(PSHelpArticleTempl pSHelpArticleTempl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSHelpArticleTempl, bl);
    }

    protected void onSyncIndexEntities(PSHelpArticleTempl pSHelpArticleTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSHelpArticleTempl, bl);
    }

    public Object getDataContextValue(PSHelpArticleTempl pSHelpArticleTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSHelpArticleTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpArticleTempl pSHelpArticleTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSHelpArticleTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSHelpArticleTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLETEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLETEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_TemplCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSHelpArticleTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
        super.onUpdateParent((IEntity)pSHelpArticleTempl);
    }

    @Override
    protected void exportCurXmlModel(PSHelpArticleTempl pSHelpArticleTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPARTICLETEMPL");
        if (!bl) {
            pSHelpArticleTempl.setCreateDate(null);
            pSHelpArticleTempl.setCreateMan(null);
            pSHelpArticleTempl.setPSHelpArticleTemplId(null);
            pSHelpArticleTempl.setPSHelpArticleTypeName(null);
            pSHelpArticleTempl.setTemplCode(null);
            pSHelpArticleTempl.setUpdateDate(null);
            pSHelpArticleTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpArticleTempl, xmlNode, bl);
        }
    }
}

