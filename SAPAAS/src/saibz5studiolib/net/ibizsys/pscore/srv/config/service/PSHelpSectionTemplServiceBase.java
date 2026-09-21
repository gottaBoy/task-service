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
import net.ibizsys.pscore.srv.config.dao.PSHelpSectionTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSHelpSectionTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionTempl;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionType;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionTypeBase;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTypeService;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTypeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpSectionTemplServiceBase
extends PSCoreSysServiceBase<PSHelpSectionTempl> {
    private static final Log log = LogFactory.getLog(PSHelpSectionTemplServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSHelpSectionTemplDEModel pSHelpSectionTemplDEModel;
    private PSHelpSectionTemplDAO pSHelpSectionTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplService";
    }

    public PSHelpSectionTemplDEModel getPSHelpSectionTemplDEModel() {
        if (this.pSHelpSectionTemplDEModel == null) {
            try {
                this.pSHelpSectionTemplDEModel = (PSHelpSectionTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSHelpSectionTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpSectionTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpSectionTemplDEModel();
    }

    public PSHelpSectionTemplDAO getPSHelpSectionTemplDAO() {
        if (this.pSHelpSectionTemplDAO == null) {
            try {
                this.pSHelpSectionTemplDAO = (PSHelpSectionTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSHelpSectionTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpSectionTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpSectionTemplDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSHelpSectionTempl pSHelpSectionTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTIONTEMPL_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSHelpSectionTempl, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTIONTEMPL_PSHELPSECTIONTYPE_PSHELPSECTIONTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpSectionTypeService", (SessionFactory)this.getSessionFactory());
            PSHelpSectionType pSHelpSectionType = (PSHelpSectionType)iService.getDEModel().createEntity();
            pSHelpSectionType.set("PSHELPSECTIONTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSHelpSectionType);
            } else {
                iService.get((IEntity)pSHelpSectionType);
            }
            this.onFillParentInfo_PSHelpArticleType(pSHelpSectionTempl, pSHelpSectionType);
            return;
        }
        super.onFillParentInfo((IEntity)pSHelpSectionTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSHelpSectionTempl pSHelpSectionTempl, PSDevCenter pSDevCenter) throws Exception {
        pSHelpSectionTempl.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSHelpSectionTempl.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSHelpArticleType(PSHelpSectionTempl pSHelpSectionTempl, PSHelpSectionType pSHelpSectionType) throws Exception {
        pSHelpSectionTempl.setPSHelpSectionTypeId(pSHelpSectionType.getPSHelpSectionTypeId());
        pSHelpSectionTempl.setPSHelpSectionTypeName(pSHelpSectionType.getPSHelpSectionTypeName());
    }

    protected void onFillEntityFullInfo(PSHelpSectionTempl pSHelpSectionTempl, boolean bl) throws Exception {
        if (bl && pSHelpSectionTempl.getValidFlag() == null) {
            pSHelpSectionTempl.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSHelpSectionTempl, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSHelpSectionTempl, bl);
        this.onFillEntityFullInfo_PSHelpArticleType(pSHelpSectionTempl, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSHelpSectionTempl pSHelpSectionTempl, boolean bl) throws Exception {
        if (pSHelpSectionTempl.isPSDevCenterIdDirty()) {
            if (pSHelpSectionTempl.getPSDevCenterId() != null) {
                if (pSHelpSectionTempl.getPSDevCenterId() == null || pSHelpSectionTempl.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSHelpSectionTempl.getPSDevCenter();
                    pSHelpSectionTempl.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSHelpSectionTempl.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSHelpArticleType(PSHelpSectionTempl pSHelpSectionTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSHelpSectionTempl pSHelpSectionTempl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSHelpSectionTempl, bl);
    }

    public ArrayList<PSHelpSectionTempl> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSHelpSectionTempl> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSHelpSectionTempl> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSHelpSectionTempl> selectByPSHelpArticleType(PSHelpSectionTypeBase pSHelpSectionTypeBase) throws Exception {
        return this.selectByPSHelpArticleType(pSHelpSectionTypeBase, "", -1);
    }

    public ArrayList<PSHelpSectionTempl> selectByPSHelpArticleType(PSHelpSectionTypeBase pSHelpSectionTypeBase, String string) throws Exception {
        return this.selectByPSHelpArticleType(pSHelpSectionTypeBase, string, -1);
    }

    public ArrayList<PSHelpSectionTempl> selectByPSHelpArticleType(PSHelpSectionTypeBase pSHelpSectionTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPSECTIONTYPEID", (Object)pSHelpSectionTypeBase.getPSHelpSectionTypeId());
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
        ArrayList<PSHelpSectionTempl> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPSECTIONTEMPL_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSHELPSECTIONTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSHelpSectionTempl> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSHelpSectionTempl pSHelpSectionTempl : arrayList) {
            PSHelpSectionTempl pSHelpSectionTempl2 = (PSHelpSectionTempl)this.getDEModel().createEntity();
            pSHelpSectionTempl2.setPSHelpSectionTemplId(pSHelpSectionTempl.getPSHelpSectionTemplId());
            pSHelpSectionTempl2.setPSDevCenterId(null);
            this.update(pSHelpSectionTempl2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionTemplServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSHelpSectionTemplServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSHelpSectionTemplServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSHelpSectionTempl> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSHelpSectionTempl pSHelpSectionTempl : arrayList) {
            this.remove((IEntity)pSHelpSectionTempl);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSHelpSectionTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSHelpSectionTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpArticleType(PSHelpSectionType pSHelpSectionType) throws Exception {
        ArrayList<PSHelpSectionTempl> arrayList = this.selectByPSHelpArticleType(pSHelpSectionType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPSECTIONTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSHelpSectionType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPSECTIONTEMPL_PSHELPSECTIONTYPE_PSHELPSECTIONTYPEID", "", iDataEntityModel.getName(), "PSHELPSECTIONTEMPL", iDataEntityModel.getDataInfo((IEntity)pSHelpSectionType), arrayList.get(0)));
        }
    }

    public void resetPSHelpArticleType(PSHelpSectionType pSHelpSectionType) throws Exception {
        ArrayList<PSHelpSectionTempl> arrayList = this.selectByPSHelpArticleType(pSHelpSectionType);
        for (PSHelpSectionTempl pSHelpSectionTempl : arrayList) {
            PSHelpSectionTempl pSHelpSectionTempl2 = (PSHelpSectionTempl)this.getDEModel().createEntity();
            pSHelpSectionTempl2.setPSHelpSectionTemplId(pSHelpSectionTempl.getPSHelpSectionTemplId());
            pSHelpSectionTempl2.setPSHelpSectionTypeId(null);
            this.update(pSHelpSectionTempl2);
        }
    }

    public void removeByPSHelpArticleType(PSHelpSectionType pSHelpSectionType) throws Exception {
        final PSHelpSectionType pSHelpSectionType2 = pSHelpSectionType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionTemplServiceBase.this.onBeforeRemoveByPSHelpArticleType(pSHelpSectionType2);
                PSHelpSectionTemplServiceBase.this.internalRemoveByPSHelpArticleType(pSHelpSectionType2);
                PSHelpSectionTemplServiceBase.this.onAfterRemoveByPSHelpArticleType(pSHelpSectionType2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpArticleType(PSHelpSectionType pSHelpSectionType) throws Exception {
    }

    protected void internalRemoveByPSHelpArticleType(PSHelpSectionType pSHelpSectionType) throws Exception {
        ArrayList<PSHelpSectionTempl> arrayList = this.selectByPSHelpArticleType(pSHelpSectionType);
        this.onBeforeRemoveByPSHelpArticleType(pSHelpSectionType, arrayList);
        for (PSHelpSectionTempl pSHelpSectionTempl : arrayList) {
            this.remove((IEntity)pSHelpSectionTempl);
        }
        this.onAfterRemoveByPSHelpArticleType(pSHelpSectionType, arrayList);
    }

    protected void onAfterRemoveByPSHelpArticleType(PSHelpSectionType pSHelpSectionType) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpArticleType(PSHelpSectionType pSHelpSectionType, ArrayList<PSHelpSectionTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpArticleType(PSHelpSectionType pSHelpSectionType, ArrayList<PSHelpSectionTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSHelpSectionTypeService)ServiceGlobal.getService(PSHelpSectionTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpSectionTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpSectionTempl(pSHelpSectionTempl);
        pSCoreSysServiceBase = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpSectionTempl(pSHelpSectionTempl);
        super.onBeforeRemove(pSHelpSectionTempl);
    }

    protected void replaceParentInfo(PSHelpSectionTempl pSHelpSectionTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSHelpSectionTempl, cloneSession);
        if (pSHelpSectionTempl.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSHelpSectionTempl.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSHelpSectionTempl, (PSDevCenter)iEntity);
        }
        if (pSHelpSectionTempl.getPSHelpSectionTypeId() != null && (iEntity = cloneSession.getEntity("PSHELPSECTIONTYPE", (Object)pSHelpSectionTempl.getPSHelpSectionTypeId())) != null) {
            this.onFillParentInfo_PSHelpArticleType(pSHelpSectionTempl, (PSHelpSectionType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpSectionTempl pSHelpSectionTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSHelpSectionTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DefaultFlag(bl, pSHelpSectionTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionTemplId(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionTemplName(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionTypeId(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSHelpSectionTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSHelpSectionTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isDefaultFlagDirty() && !bl2 : !pSHelpSectionTempl.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSHelpSectionTempl.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isMemoDirty() : !pSHelpSectionTempl.isMemoDirty()) {
            return null;
        }
        String string = pSHelpSectionTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isPSDevCenterIdDirty() : !pSHelpSectionTempl.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSHelpSectionTempl.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isPSDevCenterNameDirty() : !pSHelpSectionTempl.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSHelpSectionTempl.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpSectionTemplId(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isPSHelpSectionTemplIdDirty() && !bl2 : !pSHelpSectionTempl.isPSHelpSectionTemplIdDirty()) {
            return null;
        }
        String string = pSHelpSectionTempl.getPSHelpSectionTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionTemplId_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionTemplName(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isPSHelpSectionTemplNameDirty() && !bl2 : !pSHelpSectionTempl.isPSHelpSectionTemplNameDirty()) {
            return null;
        }
        String string = pSHelpSectionTempl.getPSHelpSectionTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionTemplName_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionTypeId(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isPSHelpSectionTypeIdDirty() : !pSHelpSectionTempl.isPSHelpSectionTypeIdDirty()) {
            return null;
        }
        String string = pSHelpSectionTempl.getPSHelpSectionTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionTypeId_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isPubModeDirty() : !pSHelpSectionTempl.isPubModeDirty()) {
            return null;
        }
        Integer n = pSHelpSectionTempl.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isPubObjDirty() : !pSHelpSectionTempl.isPubObjDirty()) {
            return null;
        }
        String string = pSHelpSectionTempl.getPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isTemplCodeDirty() : !pSHelpSectionTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSHelpSectionTempl.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isTemplCode2Dirty() : !pSHelpSectionTempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSHelpSectionTempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSHelpSectionTempl pSHelpSectionTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionTempl.isValidFlagDirty() && !bl2 : !pSHelpSectionTempl.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSHelpSectionTempl.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSHelpSectionTempl, bl2, bl3);
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

    protected void onSyncEntity(PSHelpSectionTempl pSHelpSectionTempl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSHelpSectionTempl, bl);
    }

    protected void onSyncIndexEntities(PSHelpSectionTempl pSHelpSectionTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSHelpSectionTempl, bl);
    }

    public Object getDataContextValue(PSHelpSectionTempl pSHelpSectionTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSHelpSectionTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpSectionTempl pSHelpSectionTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSHelpSectionTempl, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSHelpSectionTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSHelpSectionTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        super.onUpdateParent((IEntity)pSHelpSectionTempl);
    }

    @Override
    protected void exportCurXmlModel(PSHelpSectionTempl pSHelpSectionTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPSECTIONTEMPL");
        if (!bl) {
            pSHelpSectionTempl.setCreateDate(null);
            pSHelpSectionTempl.setCreateMan(null);
            pSHelpSectionTempl.setPSHelpSectionTemplId(null);
            pSHelpSectionTempl.setPSHelpSectionTypeName(null);
            pSHelpSectionTempl.setTemplCode(null);
            pSHelpSectionTempl.setUpdateDate(null);
            pSHelpSectionTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpSectionTempl, xmlNode, bl);
        }
    }
}

