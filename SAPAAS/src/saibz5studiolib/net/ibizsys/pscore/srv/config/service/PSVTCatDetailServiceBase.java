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
import net.ibizsys.pscore.srv.config.dao.PSVTCatDetailDAO;
import net.ibizsys.pscore.srv.config.demodel.PSVTCatDetailDEModel;
import net.ibizsys.pscore.srv.config.entity.PSVTCatDetail;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeCat;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeCatBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSVTCatDetailServiceBase
extends PSCoreSysServiceBase<PSVTCatDetail> {
    private static final Log log = LogFactory.getLog(PSVTCatDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VALID = "Valid";
    private PSVTCatDetailDEModel pSVTCatDetailDEModel;
    private PSVTCatDetailDAO pSVTCatDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSVTCatDetailService";
    }

    public PSVTCatDetailDEModel getPSVTCatDetailDEModel() {
        if (this.pSVTCatDetailDEModel == null) {
            try {
                this.pSVTCatDetailDEModel = (PSVTCatDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSVTCatDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSVTCatDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSVTCatDetailDEModel();
    }

    public PSVTCatDetailDAO getPSVTCatDetailDAO() {
        if (this.pSVTCatDetailDAO == null) {
            try {
                this.pSVTCatDetailDAO = (PSVTCatDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSVTCatDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSVTCatDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSVTCatDetailDAO();
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

    protected void onFillParentInfo(PSVTCatDetail pSVTCatDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVTCATDETAIL_PSVIEWTYPECAT_PSVIEWTYPECATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeCatService", (SessionFactory)this.getSessionFactory());
            PSViewTypeCat pSViewTypeCat = (PSViewTypeCat)iService.getDEModel().createEntity();
            pSViewTypeCat.set("PSVIEWTYPECATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewTypeCat);
            } else {
                iService.get((IEntity)pSViewTypeCat);
            }
            this.onFillParentInfo_PSViewTypeCat(pSVTCatDetail, pSViewTypeCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVTCATDETAIL_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeService", (SessionFactory)this.getSessionFactory());
            PSViewType pSViewType = (PSViewType)iService.getDEModel().createEntity();
            pSViewType.set("PSVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewType);
            } else {
                iService.get((IEntity)pSViewType);
            }
            this.onFillParentInfo_PSViewType(pSVTCatDetail, pSViewType);
            return;
        }
        super.onFillParentInfo((IEntity)pSVTCatDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSViewTypeCat(PSVTCatDetail pSVTCatDetail, PSViewTypeCat pSViewTypeCat) throws Exception {
        pSVTCatDetail.setPSViewTypeCatId(pSViewTypeCat.getPSViewTypeCatId());
        pSVTCatDetail.setPSViewTypeCatName(pSViewTypeCat.getPSViewTypeCatName());
    }

    protected void onFillParentInfo_PSViewType(PSVTCatDetail pSVTCatDetail, PSViewType pSViewType) throws Exception {
        pSVTCatDetail.setPSViewTypeId(pSViewType.getPSViewTypeId());
        pSVTCatDetail.setPSViewTypeName(pSViewType.getPSViewTypeName());
    }

    protected boolean onFillEntityKeyValue(PSVTCatDetail pSVTCatDetail, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSVTCatDetail.get("PSVIEWTYPEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSVTCatDetail.get("PSVIEWTYPECATID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSVTCatDetail.set(this.getPSVTCatDetailDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSVTCatDetail pSVTCatDetail, boolean bl) throws Exception {
        if (bl) {
            if (pSVTCatDetail.getPSVTCatDetailName() == null) {
                pSVTCatDetail.setPSVTCatDetailName((String)this.getDefaultValue(this.getWebContext(), "", "\u6210\u5458\u540d\u79f0", 25));
            }
            if (pSVTCatDetail.getValidFlag() == null) {
                pSVTCatDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSVTCatDetail, bl);
        this.onFillEntityFullInfo_PSViewTypeCat(pSVTCatDetail, bl);
        this.onFillEntityFullInfo_PSViewType(pSVTCatDetail, bl);
    }

    protected void onFillEntityFullInfo_PSViewTypeCat(PSVTCatDetail pSVTCatDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewType(PSVTCatDetail pSVTCatDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSVTCatDetail pSVTCatDetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSVTCatDetail, bl);
    }

    public ArrayList<PSVTCatDetail> selectByPSViewTypeCat(PSViewTypeCatBase pSViewTypeCatBase) throws Exception {
        return this.selectByPSViewTypeCat(pSViewTypeCatBase, "", -1);
    }

    public ArrayList<PSVTCatDetail> selectByPSViewTypeCat(PSViewTypeCatBase pSViewTypeCatBase, String string) throws Exception {
        return this.selectByPSViewTypeCat(pSViewTypeCatBase, string, -1);
    }

    public ArrayList<PSVTCatDetail> selectByPSViewTypeCat(PSViewTypeCatBase pSViewTypeCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWTYPECATID", (Object)pSViewTypeCatBase.getPSViewTypeCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewTypeCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewTypeCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSVTCatDetail> selectByPSViewType(PSViewTypeBase pSViewTypeBase) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, "", -1);
    }

    public ArrayList<PSVTCatDetail> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, string, -1);
    }

    public ArrayList<PSVTCatDetail> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWTYPEID", (Object)pSViewTypeBase.getPSViewTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSViewTypeCat(PSViewTypeCat pSViewTypeCat) throws Exception {
        ArrayList<PSVTCatDetail> arrayList = this.selectByPSViewTypeCat(pSViewTypeCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWTYPECAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSViewTypeCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVTCATDETAIL_PSVIEWTYPECAT_PSVIEWTYPECATID", "", iDataEntityModel.getName(), "PSVTCATDETAIL", iDataEntityModel.getDataInfo((IEntity)pSViewTypeCat), arrayList.get(0)));
        }
    }

    public void resetPSViewTypeCat(PSViewTypeCat pSViewTypeCat) throws Exception {
        ArrayList<PSVTCatDetail> arrayList = this.selectByPSViewTypeCat(pSViewTypeCat);
        for (PSVTCatDetail pSVTCatDetail : arrayList) {
            PSVTCatDetail pSVTCatDetail2 = (PSVTCatDetail)this.getDEModel().createEntity();
            pSVTCatDetail2.setPSVTCatDetailId(pSVTCatDetail.getPSVTCatDetailId());
            pSVTCatDetail2.setPSViewTypeCatId(null);
            this.update(pSVTCatDetail2);
        }
    }

    public void removeByPSViewTypeCat(PSViewTypeCat pSViewTypeCat) throws Exception {
        final PSViewTypeCat pSViewTypeCat2 = pSViewTypeCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSVTCatDetailServiceBase.this.onBeforeRemoveByPSViewTypeCat(pSViewTypeCat2);
                PSVTCatDetailServiceBase.this.internalRemoveByPSViewTypeCat(pSViewTypeCat2);
                PSVTCatDetailServiceBase.this.onAfterRemoveByPSViewTypeCat(pSViewTypeCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewTypeCat(PSViewTypeCat pSViewTypeCat) throws Exception {
    }

    protected void internalRemoveByPSViewTypeCat(PSViewTypeCat pSViewTypeCat) throws Exception {
        ArrayList<PSVTCatDetail> arrayList = this.selectByPSViewTypeCat(pSViewTypeCat);
        this.onBeforeRemoveByPSViewTypeCat(pSViewTypeCat, arrayList);
        for (PSVTCatDetail pSVTCatDetail : arrayList) {
            this.remove((IEntity)pSVTCatDetail);
        }
        this.onAfterRemoveByPSViewTypeCat(pSViewTypeCat, arrayList);
    }

    protected void onAfterRemoveByPSViewTypeCat(PSViewTypeCat pSViewTypeCat) throws Exception {
    }

    protected void onBeforeRemoveByPSViewTypeCat(PSViewTypeCat pSViewTypeCat, ArrayList<PSVTCatDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewTypeCat(PSViewTypeCat pSViewTypeCat, ArrayList<PSVTCatDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    public void resetPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSVTCatDetail> arrayList = this.selectByPSViewType(pSViewType);
        for (PSVTCatDetail pSVTCatDetail : arrayList) {
            PSVTCatDetail pSVTCatDetail2 = (PSVTCatDetail)this.getDEModel().createEntity();
            pSVTCatDetail2.setPSVTCatDetailId(pSVTCatDetail.getPSVTCatDetailId());
            pSVTCatDetail2.setPSViewTypeId(null);
            this.update(pSVTCatDetail2);
        }
    }

    public void removeByPSViewType(PSViewType pSViewType) throws Exception {
        final PSViewType pSViewType2 = pSViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSVTCatDetailServiceBase.this.onBeforeRemoveByPSViewType(pSViewType2);
                PSVTCatDetailServiceBase.this.internalRemoveByPSViewType(pSViewType2);
                PSVTCatDetailServiceBase.this.onAfterRemoveByPSViewType(pSViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void internalRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSVTCatDetail> arrayList = this.selectByPSViewType(pSViewType);
        this.onBeforeRemoveByPSViewType(pSViewType, arrayList);
        for (PSVTCatDetail pSVTCatDetail : arrayList) {
            this.remove((IEntity)pSVTCatDetail);
        }
        this.onAfterRemoveByPSViewType(pSViewType, arrayList);
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSVTCatDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSVTCatDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSVTCatDetail pSVTCatDetail) throws Exception {
        super.onBeforeRemove(pSVTCatDetail);
    }

    protected void replaceParentInfo(PSVTCatDetail pSVTCatDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSVTCatDetail, cloneSession);
        if (pSVTCatDetail.getPSViewTypeCatId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPECAT", (Object)pSVTCatDetail.getPSViewTypeCatId())) != null) {
            this.onFillParentInfo_PSViewTypeCat(pSVTCatDetail, (PSViewTypeCat)iEntity);
        }
        if (pSVTCatDetail.getPSViewTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPE", (Object)pSVTCatDetail.getPSViewTypeId())) != null) {
            this.onFillParentInfo_PSViewType(pSVTCatDetail, (PSViewType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSVTCatDetail pSVTCatDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSVTCatDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSVTCatDetail pSVTCatDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSViewTypeCatId(bl, pSVTCatDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeId(bl, pSVTCatDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVTCatDetailId(bl, pSVTCatDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVTCatDetailName(bl, pSVTCatDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSVTCatDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSVTCatDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSViewTypeCatId(boolean bl, PSVTCatDetail pSVTCatDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCatDetail.isPSViewTypeCatIdDirty() : !pSVTCatDetail.isPSViewTypeCatIdDirty()) {
            return null;
        }
        String string = pSVTCatDetail.getPSViewTypeCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeCatId_Default((IEntity)pSVTCatDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewTypeId(boolean bl, PSVTCatDetail pSVTCatDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCatDetail.isPSViewTypeIdDirty() : !pSVTCatDetail.isPSViewTypeIdDirty()) {
            return null;
        }
        String string = pSVTCatDetail.getPSViewTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeId_Default((IEntity)pSVTCatDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSVTCatDetailId(boolean bl, PSVTCatDetail pSVTCatDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCatDetail.isPSVTCatDetailIdDirty() && !bl2 : !pSVTCatDetail.isPSVTCatDetailIdDirty()) {
            return null;
        }
        String string = pSVTCatDetail.getPSVTCatDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTCATDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVTCatDetailId_Default((IEntity)pSVTCatDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTCATDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSVTCatDetailName(boolean bl, PSVTCatDetail pSVTCatDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCatDetail.isPSVTCatDetailNameDirty() && !bl2 : !pSVTCatDetail.isPSVTCatDetailNameDirty()) {
            return null;
        }
        String string = pSVTCatDetail.getPSVTCatDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTCATDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVTCatDetailName_Default((IEntity)pSVTCatDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTCATDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSVTCatDetail pSVTCatDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCatDetail.isValidFlagDirty() && !bl2 : !pSVTCatDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSVTCatDetail.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSVTCatDetail, bl2, bl3);
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

    protected void onSyncEntity(PSVTCatDetail pSVTCatDetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSVTCatDetail, bl);
    }

    protected void onSyncIndexEntities(PSVTCatDetail pSVTCatDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSVTCatDetail, bl);
    }

    public Object getDataContextValue(PSVTCatDetail pSVTCatDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSVTCatDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSViewTypeCat pSViewTypeCat = pSVTCatDetail.getPSViewTypeCat();
        if (pSViewTypeCat != null && pSViewTypeCat.contains(string)) {
            return pSViewTypeCat.get(string);
        }
        PSViewType pSViewType = pSVTCatDetail.getPSViewType();
        if (pSViewType != null && pSViewType.contains(string)) {
            return pSViewType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSVTCatDetail pSVTCatDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSVTCatDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPECATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPECATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVTCATDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVTCatDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVTCATDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVTCatDetailName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSViewTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVTCatDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVTCATDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVTCatDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVTCATDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSVTCatDetail pSVTCatDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSVTCatDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSVTCatDetail pSVTCatDetail) throws Exception {
        super.onUpdateParent((IEntity)pSVTCatDetail);
    }

    @Override
    protected void exportCurXmlModel(PSVTCatDetail pSVTCatDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVTCATDETAIL");
        if (!bl) {
            pSVTCatDetail.setCreateDate(null);
            pSVTCatDetail.setCreateMan(null);
            pSVTCatDetail.setPSVTCatDetailId(null);
            pSVTCatDetail.setUpdateDate(null);
            pSVTCatDetail.setUpdateMan(null);
            super.exportCurXmlModel(pSVTCatDetail, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSVTCatDetail pSVTCatDetail, PSSystem pSSystem) throws Exception {
        PSVTCatDetail pSVTCatDetail2 = new PSVTCatDetail();
        pSVTCatDetail2.setPSViewTypeId(pSVTCatDetail.getPSViewTypeId());
        pSVTCatDetail2.setPSViewTypeCatId(pSVTCatDetail.getPSViewTypeCatId());
        if (this.selectOne((IEntity)pSVTCatDetail2, true)) {
            return pSVTCatDetail2.getPSVTCatDetailId();
        }
        return super.getEntityFolderKeyValue(pSVTCatDetail, pSSystem);
    }
}

