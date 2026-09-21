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
import net.ibizsys.pscore.srv.config.dao.PSViewTypeCatDAO;
import net.ibizsys.pscore.srv.config.demodel.PSViewTypeCatDEModel;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeCat;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeCatBase;
import net.ibizsys.pscore.srv.config.service.PSVTCatDetailService;
import net.ibizsys.pscore.srv.config.service.PSVTCatDetailServiceBase;
import net.ibizsys.pscore.srv.config.service.PSViewTypeCatService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewTypeCatServiceBase
extends PSCoreSysServiceBase<PSViewTypeCat> {
    private static final Log log = LogFactory.getLog(PSViewTypeCatServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_ROOTCAT = "RootCat";
    private PSViewTypeCatDEModel pSViewTypeCatDEModel;
    private PSViewTypeCatDAO pSViewTypeCatDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSViewTypeCatService";
    }

    public PSViewTypeCatDEModel getPSViewTypeCatDEModel() {
        if (this.pSViewTypeCatDEModel == null) {
            try {
                this.pSViewTypeCatDEModel = (PSViewTypeCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSViewTypeCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewTypeCatDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSViewTypeCatDEModel();
    }

    public PSViewTypeCatDAO getPSViewTypeCatDAO() {
        if (this.pSViewTypeCatDAO == null) {
            try {
                this.pSViewTypeCatDAO = (PSViewTypeCatDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSViewTypeCatDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewTypeCatDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSViewTypeCatDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_ROOTCAT, (boolean)true) == 0) {
            return this.fetchRootCat(iDEDataSetFetchContext);
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

    public DBFetchResult fetchRootCat(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_ROOTCAT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSViewTypeCat pSViewTypeCat, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWTYPECAT_PSVIEWTYPECAT_PPSVIEWTYPECATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeCatService", (SessionFactory)this.getSessionFactory());
            PSViewTypeCat pSViewTypeCat2 = (PSViewTypeCat)iService.getDEModel().createEntity();
            pSViewTypeCat2.set("PSVIEWTYPECATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewTypeCat2);
            } else {
                iService.get((IEntity)pSViewTypeCat2);
            }
            this.onFillParentInfo_Ppsviewtypecat(pSViewTypeCat, pSViewTypeCat2);
            return;
        }
        super.onFillParentInfo((IEntity)pSViewTypeCat, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Ppsviewtypecat(PSViewTypeCat pSViewTypeCat, PSViewTypeCat pSViewTypeCat2) throws Exception {
        pSViewTypeCat.setPPSViewTypeCatId(pSViewTypeCat2.getPSViewTypeCatId());
        pSViewTypeCat.setPPSViewTypeCatName(pSViewTypeCat2.getPSViewTypeCatName());
    }

    protected void onFillEntityFullInfo(PSViewTypeCat pSViewTypeCat, boolean bl) throws Exception {
        if (bl && pSViewTypeCat.getValidFlag() == null) {
            pSViewTypeCat.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSViewTypeCat, bl);
        this.onFillEntityFullInfo_Ppsviewtypecat(pSViewTypeCat, bl);
    }

    protected void onFillEntityFullInfo_Ppsviewtypecat(PSViewTypeCat pSViewTypeCat, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSViewTypeCat pSViewTypeCat, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSViewTypeCat, bl);
    }

    public ArrayList<PSViewTypeCat> selectByPpsviewtypecat(PSViewTypeCatBase pSViewTypeCatBase) throws Exception {
        return this.selectByPpsviewtypecat(pSViewTypeCatBase, "", -1);
    }

    public ArrayList<PSViewTypeCat> selectByPpsviewtypecat(PSViewTypeCatBase pSViewTypeCatBase, String string) throws Exception {
        return this.selectByPpsviewtypecat(pSViewTypeCatBase, string, -1);
    }

    public ArrayList<PSViewTypeCat> selectByPpsviewtypecat(PSViewTypeCatBase pSViewTypeCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSVIEWTYPECATID", (Object)pSViewTypeCatBase.getPSViewTypeCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPpsviewtypecatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPpsviewtypecatCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPpsviewtypecat(PSViewTypeCat pSViewTypeCat) throws Exception {
    }

    public void resetPpsviewtypecat(PSViewTypeCat pSViewTypeCat) throws Exception {
        ArrayList<PSViewTypeCat> arrayList = this.selectByPpsviewtypecat(pSViewTypeCat);
        for (PSViewTypeCat pSViewTypeCat2 : arrayList) {
            PSViewTypeCat pSViewTypeCat3 = (PSViewTypeCat)this.getDEModel().createEntity();
            pSViewTypeCat3.setPSViewTypeCatId(pSViewTypeCat2.getPSViewTypeCatId());
            pSViewTypeCat3.setPPSViewTypeCatId(null);
            this.update(pSViewTypeCat3);
        }
    }

    public void removeByPpsviewtypecat(PSViewTypeCat pSViewTypeCat) throws Exception {
        final PSViewTypeCat pSViewTypeCat2 = pSViewTypeCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewTypeCatServiceBase.this.onBeforeRemoveByPpsviewtypecat(pSViewTypeCat2);
                PSViewTypeCatServiceBase.this.internalRemoveByPpsviewtypecat(pSViewTypeCat2);
                PSViewTypeCatServiceBase.this.onAfterRemoveByPpsviewtypecat(pSViewTypeCat2);
            }
        });
    }

    protected void onBeforeRemoveByPpsviewtypecat(PSViewTypeCat pSViewTypeCat) throws Exception {
    }

    protected void internalRemoveByPpsviewtypecat(PSViewTypeCat pSViewTypeCat) throws Exception {
        ArrayList<PSViewTypeCat> arrayList = this.selectByPpsviewtypecat(pSViewTypeCat);
        this.onBeforeRemoveByPpsviewtypecat(pSViewTypeCat, arrayList);
        for (PSViewTypeCat pSViewTypeCat2 : arrayList) {
            this.remove((IEntity)pSViewTypeCat2);
        }
        this.onAfterRemoveByPpsviewtypecat(pSViewTypeCat, arrayList);
    }

    protected void onAfterRemoveByPpsviewtypecat(PSViewTypeCat pSViewTypeCat) throws Exception {
    }

    protected void onBeforeRemoveByPpsviewtypecat(PSViewTypeCat pSViewTypeCat, ArrayList<PSViewTypeCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPpsviewtypecat(PSViewTypeCat pSViewTypeCat, ArrayList<PSViewTypeCat> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSViewTypeCat pSViewTypeCat) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSViewTypeCatService)ServiceGlobal.getService(PSViewTypeCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewTypeCatServiceBase)pSCoreSysServiceBase).testRemoveByPpsviewtypecat(pSViewTypeCat);
        ((PSViewTypeCatServiceBase)pSCoreSysServiceBase).removeByPpsviewtypecat(pSViewTypeCat);
        pSCoreSysServiceBase = (PSVTCatDetailService)ServiceGlobal.getService(PSVTCatDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSVTCatDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSViewTypeCat(pSViewTypeCat);
        super.onBeforeRemove(pSViewTypeCat);
    }

    protected void replaceParentInfo(PSViewTypeCat pSViewTypeCat, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSViewTypeCat, cloneSession);
        if (pSViewTypeCat.getPPSViewTypeCatId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPECAT", (Object)pSViewTypeCat.getPPSViewTypeCatId())) != null) {
            this.onFillParentInfo_Ppsviewtypecat(pSViewTypeCat, (PSViewTypeCat)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSViewTypeCat pSViewTypeCat, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSViewTypeCat, bl);
    }

    protected void onCheckEntity(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CatCode(bl, pSViewTypeCat, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPath(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSViewTypeCatId(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeCatId(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeCatName(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSViewTypeCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSViewTypeCat, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CatCode(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isCatCodeDirty() : !pSViewTypeCat.isCatCodeDirty()) {
            return null;
        }
        String string = pSViewTypeCat.getCatCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatCode_Default((IEntity)pSViewTypeCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPath(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isIconPathDirty() : !pSViewTypeCat.isIconPathDirty()) {
            return null;
        }
        String string = pSViewTypeCat.getIconPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPath_Default((IEntity)pSViewTypeCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isMemoDirty() : !pSViewTypeCat.isMemoDirty()) {
            return null;
        }
        String string = pSViewTypeCat.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSViewTypeCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isOrderValueDirty() : !pSViewTypeCat.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSViewTypeCat.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSViewTypeCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSViewTypeCatId(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isPPSViewTypeCatIdDirty() : !pSViewTypeCat.isPPSViewTypeCatIdDirty()) {
            return null;
        }
        String string = pSViewTypeCat.getPPSViewTypeCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSViewTypeCatId_Default((IEntity)pSViewTypeCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSVIEWTYPECATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeCatId(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isPSViewTypeCatIdDirty() && !bl2 : !pSViewTypeCat.isPSViewTypeCatIdDirty()) {
            return null;
        }
        String string = pSViewTypeCat.getPSViewTypeCatId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPECATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeCatId_Default((IEntity)pSViewTypeCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPECATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeCatName(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isPSViewTypeCatNameDirty() && !bl2 : !pSViewTypeCat.isPSViewTypeCatNameDirty()) {
            return null;
        }
        String string = pSViewTypeCat.getPSViewTypeCatName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPECATNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeCatName_Default((IEntity)pSViewTypeCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPECATNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isUserCatDirty() : !pSViewTypeCat.isUserCatDirty()) {
            return null;
        }
        String string = pSViewTypeCat.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSViewTypeCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isUserTagDirty() : !pSViewTypeCat.isUserTagDirty()) {
            return null;
        }
        String string = pSViewTypeCat.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSViewTypeCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isUserTag2Dirty() : !pSViewTypeCat.isUserTag2Dirty()) {
            return null;
        }
        String string = pSViewTypeCat.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSViewTypeCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isUserTag3Dirty() : !pSViewTypeCat.isUserTag3Dirty()) {
            return null;
        }
        String string = pSViewTypeCat.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSViewTypeCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isUserTag4Dirty() : !pSViewTypeCat.isUserTag4Dirty()) {
            return null;
        }
        String string = pSViewTypeCat.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSViewTypeCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSViewTypeCat pSViewTypeCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeCat.isValidFlagDirty() && !bl2 : !pSViewTypeCat.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSViewTypeCat.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSViewTypeCat, bl2, bl3);
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

    protected void onSyncEntity(PSViewTypeCat pSViewTypeCat, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSViewTypeCat, bl);
    }

    protected void onSyncIndexEntities(PSViewTypeCat pSViewTypeCat, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSViewTypeCat, bl);
    }

    public Object getDataContextValue(PSViewTypeCat pSViewTypeCat, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSViewTypeCat, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSViewTypeCat pSViewTypeCat, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSViewTypeCat, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CATCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSVIEWTYPECATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSViewTypeCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSVIEWTYPECATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSViewTypeCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPECATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPECATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeCatName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CatCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATCODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSViewTypeCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSVIEWTYPECATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSViewTypeCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSVIEWTYPECATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPECATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPECATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSViewTypeCat pSViewTypeCat) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSViewTypeCat)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSViewTypeCat pSViewTypeCat) throws Exception {
        super.onUpdateParent((IEntity)pSViewTypeCat);
    }

    @Override
    protected void exportCurXmlModel(PSViewTypeCat pSViewTypeCat, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVIEWTYPECAT");
        if (!bl) {
            pSViewTypeCat.setPPSViewTypeCatName(null);
            super.exportCurXmlModel(pSViewTypeCat, xmlNode, bl);
        }
    }
}

