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
import net.ibizsys.pscore.srv.config.dao.PSHelpArtSecDAO;
import net.ibizsys.pscore.srv.config.demodel.PSHelpArtSecDEModel;
import net.ibizsys.pscore.srv.config.entity.PSHelpArtSec;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleType;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionType;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpArtSecServiceBase
extends PSCoreSysServiceBase<PSHelpArtSec> {
    private static final Log log = LogFactory.getLog(PSHelpArtSecServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSHelpArtSecDEModel pSHelpArtSecDEModel;
    private PSHelpArtSecDAO pSHelpArtSecDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSHelpArtSecService";
    }

    public PSHelpArtSecDEModel getPSHelpArtSecDEModel() {
        if (this.pSHelpArtSecDEModel == null) {
            try {
                this.pSHelpArtSecDEModel = (PSHelpArtSecDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSHelpArtSecDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArtSecDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpArtSecDEModel();
    }

    public PSHelpArtSecDAO getPSHelpArtSecDAO() {
        if (this.pSHelpArtSecDAO == null) {
            try {
                this.pSHelpArtSecDAO = (PSHelpArtSecDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSHelpArtSecDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArtSecDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpArtSecDAO();
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

    protected void onFillParentInfo(PSHelpArtSec pSHelpArtSec, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTSEC_PSHELPARTICLETYPE_PSHELPARTICLETYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpArticleTypeService", (SessionFactory)this.getSessionFactory());
            PSHelpArticleType pSHelpArticleType = (PSHelpArticleType)iService.getDEModel().createEntity();
            pSHelpArticleType.set("PSHELPARTICLETYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpArticleType);
            } else {
                iService.get(pSHelpArticleType);
            }
            this.onFillParentInfo_PSHelpArticleType(pSHelpArtSec, pSHelpArticleType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTSEC_PSHELPSECTIONTYPE_PSHELPSECTIONTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpSectionTypeService", (SessionFactory)this.getSessionFactory());
            PSHelpSectionType pSHelpSectionType = (PSHelpSectionType)iService.getDEModel().createEntity();
            pSHelpSectionType.set("PSHELPSECTIONTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpSectionType);
            } else {
                iService.get(pSHelpSectionType);
            }
            this.onFillParentInfo_PSHelpSectionType(pSHelpArtSec, pSHelpSectionType);
            return;
        }
        super.onFillParentInfo(pSHelpArtSec, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSHelpArticleType(PSHelpArtSec pSHelpArtSec, PSHelpArticleType pSHelpArticleType) throws Exception {
        pSHelpArtSec.setPSHelpArticleTypeId(pSHelpArticleType.getPSHelpArticleTypeId());
        pSHelpArtSec.setPSHelpArticleTypeName(pSHelpArticleType.getPSHelpArticleTypeName());
    }

    protected void onFillParentInfo_PSHelpSectionType(PSHelpArtSec pSHelpArtSec, PSHelpSectionType pSHelpSectionType) throws Exception {
        pSHelpArtSec.setPSHelpSectionTypeId(pSHelpSectionType.getPSHelpSectionTypeId());
        pSHelpArtSec.setPSHelpSectionTypeName(pSHelpSectionType.getPSHelpSectionTypeName());
    }

    protected void onFillEntityFullInfo(PSHelpArtSec pSHelpArtSec, boolean bl) throws Exception {
        if (bl && pSHelpArtSec.getValidFlag() == null) {
            pSHelpArtSec.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSHelpArtSec, bl);
        this.onFillEntityFullInfo_PSHelpArticleType(pSHelpArtSec, bl);
        this.onFillEntityFullInfo_PSHelpSectionType(pSHelpArtSec, bl);
    }

    protected void onFillEntityFullInfo_PSHelpArticleType(PSHelpArtSec pSHelpArtSec, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSHelpSectionType(PSHelpArtSec pSHelpArtSec, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSHelpArtSec pSHelpArtSec, boolean bl) throws Exception {
        super.onWriteBackParent(pSHelpArtSec, bl);
    }

    public ArrayList<PSHelpArtSec> selectByPSHelpArticleType(PSHelpArticleTypeBase pSHelpArticleTypeBase) throws Exception {
        return this.selectByPSHelpArticleType(pSHelpArticleTypeBase, "", -1);
    }

    public ArrayList<PSHelpArtSec> selectByPSHelpArticleType(PSHelpArticleTypeBase pSHelpArticleTypeBase, String string) throws Exception {
        return this.selectByPSHelpArticleType(pSHelpArticleTypeBase, string, -1);
    }

    public ArrayList<PSHelpArtSec> selectByPSHelpArticleType(PSHelpArticleTypeBase pSHelpArticleTypeBase, String string, int n) throws Exception {
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

    public ArrayList<PSHelpArtSec> selectByPSHelpSectionType(PSHelpSectionTypeBase pSHelpSectionTypeBase) throws Exception {
        return this.selectByPSHelpSectionType(pSHelpSectionTypeBase, "", -1);
    }

    public ArrayList<PSHelpArtSec> selectByPSHelpSectionType(PSHelpSectionTypeBase pSHelpSectionTypeBase, String string) throws Exception {
        return this.selectByPSHelpSectionType(pSHelpSectionTypeBase, string, -1);
    }

    public ArrayList<PSHelpArtSec> selectByPSHelpSectionType(PSHelpSectionTypeBase pSHelpSectionTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPSECTIONTYPEID", (Object)pSHelpSectionTypeBase.getPSHelpSectionTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpSectionTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpSectionTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
    }

    public void resetPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
        ArrayList<PSHelpArtSec> arrayList = this.selectByPSHelpArticleType(pSHelpArticleType);
        for (PSHelpArtSec pSHelpArtSec : arrayList) {
            PSHelpArtSec pSHelpArtSec2 = (PSHelpArtSec)this.getDEModel().createEntity();
            pSHelpArtSec2.setPSHelpArtSecId(pSHelpArtSec.getPSHelpArtSecId());
            pSHelpArtSec2.setPSHelpArticleTypeId(null);
            this.update(pSHelpArtSec2);
        }
    }

    public void removeByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
        final PSHelpArticleType pSHelpArticleType2 = pSHelpArticleType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArtSecServiceBase.this.onBeforeRemoveByPSHelpArticleType(pSHelpArticleType2);
                PSHelpArtSecServiceBase.this.internalRemoveByPSHelpArticleType(pSHelpArticleType2);
                PSHelpArtSecServiceBase.this.onAfterRemoveByPSHelpArticleType(pSHelpArticleType2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
    }

    protected void internalRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
        ArrayList<PSHelpArtSec> arrayList = this.selectByPSHelpArticleType(pSHelpArticleType);
        this.onBeforeRemoveByPSHelpArticleType(pSHelpArticleType, arrayList);
        for (PSHelpArtSec pSHelpArtSec : arrayList) {
            this.remove(pSHelpArtSec);
        }
        this.onAfterRemoveByPSHelpArticleType(pSHelpArticleType, arrayList);
    }

    protected void onAfterRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType, ArrayList<PSHelpArtSec> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpArticleType(PSHelpArticleType pSHelpArticleType, ArrayList<PSHelpArtSec> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpSectionType(PSHelpSectionType pSHelpSectionType) throws Exception {
        ArrayList<PSHelpArtSec> arrayList = this.selectByPSHelpSectionType(pSHelpSectionType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPSECTIONTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpSectionType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPARTSEC_PSHELPSECTIONTYPE_PSHELPSECTIONTYPEID", "", iDataEntityModel.getName(), "PSHELPARTSEC", iDataEntityModel.getDataInfo(pSHelpSectionType), arrayList.get(0)));
        }
    }

    public void resetPSHelpSectionType(PSHelpSectionType pSHelpSectionType) throws Exception {
        ArrayList<PSHelpArtSec> arrayList = this.selectByPSHelpSectionType(pSHelpSectionType);
        for (PSHelpArtSec pSHelpArtSec : arrayList) {
            PSHelpArtSec pSHelpArtSec2 = (PSHelpArtSec)this.getDEModel().createEntity();
            pSHelpArtSec2.setPSHelpArtSecId(pSHelpArtSec.getPSHelpArtSecId());
            pSHelpArtSec2.setPSHelpSectionTypeId(null);
            this.update(pSHelpArtSec2);
        }
    }

    public void removeByPSHelpSectionType(PSHelpSectionType pSHelpSectionType) throws Exception {
        final PSHelpSectionType pSHelpSectionType2 = pSHelpSectionType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArtSecServiceBase.this.onBeforeRemoveByPSHelpSectionType(pSHelpSectionType2);
                PSHelpArtSecServiceBase.this.internalRemoveByPSHelpSectionType(pSHelpSectionType2);
                PSHelpArtSecServiceBase.this.onAfterRemoveByPSHelpSectionType(pSHelpSectionType2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpSectionType(PSHelpSectionType pSHelpSectionType) throws Exception {
    }

    protected void internalRemoveByPSHelpSectionType(PSHelpSectionType pSHelpSectionType) throws Exception {
        ArrayList<PSHelpArtSec> arrayList = this.selectByPSHelpSectionType(pSHelpSectionType);
        this.onBeforeRemoveByPSHelpSectionType(pSHelpSectionType, arrayList);
        for (PSHelpArtSec pSHelpArtSec : arrayList) {
            this.remove(pSHelpArtSec);
        }
        this.onAfterRemoveByPSHelpSectionType(pSHelpSectionType, arrayList);
    }

    protected void onAfterRemoveByPSHelpSectionType(PSHelpSectionType pSHelpSectionType) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpSectionType(PSHelpSectionType pSHelpSectionType, ArrayList<PSHelpArtSec> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpSectionType(PSHelpSectionType pSHelpSectionType, ArrayList<PSHelpArtSec> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpArtSec pSHelpArtSec) throws Exception {
        super.onBeforeRemove(pSHelpArtSec);
    }

    protected void replaceParentInfo(PSHelpArtSec pSHelpArtSec, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSHelpArtSec, cloneSession);
        if (pSHelpArtSec.getPSHelpArticleTypeId() != null && (iEntity = cloneSession.getEntity("PSHELPARTICLETYPE", (Object)pSHelpArtSec.getPSHelpArticleTypeId())) != null) {
            this.onFillParentInfo_PSHelpArticleType(pSHelpArtSec, (PSHelpArticleType)iEntity);
        }
        if (pSHelpArtSec.getPSHelpSectionTypeId() != null && (iEntity = cloneSession.getEntity("PSHELPSECTIONTYPE", (Object)pSHelpArtSec.getPSHelpSectionTypeId())) != null) {
            this.onFillParentInfo_PSHelpSectionType(pSHelpArtSec, (PSHelpSectionType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpArtSec pSHelpArtSec, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSHelpArtSec, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpArtSec pSHelpArtSec, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSHelpArtSec, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSHelpArtSec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleTypeId(bl, pSHelpArtSec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArtSecId(bl, pSHelpArtSec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArtSecName(bl, pSHelpArtSec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionTypeId(bl, pSHelpArtSec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSHelpArtSec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSHelpArtSec, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpArtSec pSHelpArtSec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArtSec.isMemoDirty() : !pSHelpArtSec.isMemoDirty()) {
            return null;
        }
        String string = pSHelpArtSec.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSHelpArtSec, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSHelpArtSec pSHelpArtSec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArtSec.isOrderValueDirty() && !bl2 : !pSHelpArtSec.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSHelpArtSec.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSHelpArtSec, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpArticleTypeId(boolean bl, PSHelpArtSec pSHelpArtSec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArtSec.isPSHelpArticleTypeIdDirty() && !bl2 : !pSHelpArtSec.isPSHelpArticleTypeIdDirty()) {
            return null;
        }
        String string = pSHelpArtSec.getPSHelpArticleTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleTypeId_Default(pSHelpArtSec, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpArtSecId(boolean bl, PSHelpArtSec pSHelpArtSec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArtSec.isPSHelpArtSecIdDirty() && !bl2 : !pSHelpArtSec.isPSHelpArtSecIdDirty()) {
            return null;
        }
        String string = pSHelpArtSec.getPSHelpArtSecId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTSECID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArtSecId_Default(pSHelpArtSec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTSECID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArtSecName(boolean bl, PSHelpArtSec pSHelpArtSec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArtSec.isPSHelpArtSecNameDirty() && !bl2 : !pSHelpArtSec.isPSHelpArtSecNameDirty()) {
            return null;
        }
        String string = pSHelpArtSec.getPSHelpArtSecName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTSECNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArtSecName_Default(pSHelpArtSec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTSECNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionTypeId(boolean bl, PSHelpArtSec pSHelpArtSec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArtSec.isPSHelpSectionTypeIdDirty() && !bl2 : !pSHelpArtSec.isPSHelpSectionTypeIdDirty()) {
            return null;
        }
        String string = pSHelpArtSec.getPSHelpSectionTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionTypeId_Default(pSHelpArtSec, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSHelpArtSec pSHelpArtSec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArtSec.isValidFlagDirty() && !bl2 : !pSHelpArtSec.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSHelpArtSec.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSHelpArtSec, bl2, bl3);
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

    protected void onSyncEntity(PSHelpArtSec pSHelpArtSec, boolean bl) throws Exception {
        super.onSyncEntity(pSHelpArtSec, bl);
    }

    protected void onSyncIndexEntities(PSHelpArtSec pSHelpArtSec, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSHelpArtSec, bl);
    }

    public Object getDataContextValue(PSHelpArtSec pSHelpArtSec, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSHelpArtSec, string, iDataContextParam)) != null) {
            return object;
        }
        PSHelpArticleType pSHelpArticleType = pSHelpArtSec.getPSHelpArticleType();
        if (pSHelpArticleType != null && pSHelpArticleType.contains(string)) {
            return pSHelpArticleType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpArtSec pSHelpArtSec, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSHelpArtSec, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTSECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArtSecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTSECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArtSecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSHelpArtSecId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTSECID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArtSecName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTSECNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSHelpArtSec pSHelpArtSec) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSHelpArtSec)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpArtSec pSHelpArtSec) throws Exception {
        super.onUpdateParent(pSHelpArtSec);
    }

    @Override
    protected void exportCurXmlModel(PSHelpArtSec pSHelpArtSec, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPARTSEC");
        if (!bl) {
            pSHelpArtSec.setCreateDate(null);
            pSHelpArtSec.setCreateMan(null);
            pSHelpArtSec.setPSHelpArtSecId(null);
            pSHelpArtSec.setUpdateDate(null);
            pSHelpArtSec.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpArtSec, xmlNode, bl);
        }
    }
}

