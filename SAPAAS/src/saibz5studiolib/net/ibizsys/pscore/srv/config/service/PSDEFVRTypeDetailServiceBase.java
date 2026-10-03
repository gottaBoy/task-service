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
import net.ibizsys.pscore.srv.config.dao.PSDEFVRTypeDetailDAO;
import net.ibizsys.pscore.srv.config.demodel.PSDEFVRTypeDetailDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDEFVRType;
import net.ibizsys.pscore.srv.config.entity.PSDEFVRTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSDEFVRTypeDetail;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFVRTypeDetailServiceBase
extends PSCoreSysServiceBase<PSDEFVRTypeDetail> {
    private static final Log log = LogFactory.getLog(PSDEFVRTypeDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFVRTypeDetailDEModel pSDEFVRTypeDetailDEModel;
    private PSDEFVRTypeDetailDAO pSDEFVRTypeDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSDEFVRTypeDetailService";
    }

    public PSDEFVRTypeDetailDEModel getPSDEFVRTypeDetailDEModel() {
        if (this.pSDEFVRTypeDetailDEModel == null) {
            try {
                this.pSDEFVRTypeDetailDEModel = (PSDEFVRTypeDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDEFVRTypeDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFVRTypeDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFVRTypeDetailDEModel();
    }

    public PSDEFVRTypeDetailDAO getPSDEFVRTypeDetailDAO() {
        if (this.pSDEFVRTypeDetailDAO == null) {
            try {
                this.pSDEFVRTypeDetailDAO = (PSDEFVRTypeDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSDEFVRTypeDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFVRTypeDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFVRTypeDetailDAO();
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

    protected void onFillParentInfo(PSDEFVRTypeDetail pSDEFVRTypeDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRTYPEDETAIL_PSDEFVRTYPE_PSDEFVRTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFVRTypeService", (SessionFactory)this.getSessionFactory());
            PSDEFVRType pSDEFVRType = (PSDEFVRType)iService.getDEModel().createEntity();
            pSDEFVRType.set("PSDEFVRTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFVRType);
            } else {
                iService.get(pSDEFVRType);
            }
            this.onFillParentInfo_PSDEFVRType(pSDEFVRTypeDetail, pSDEFVRType);
            return;
        }
        super.onFillParentInfo(pSDEFVRTypeDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEFVRType(PSDEFVRTypeDetail pSDEFVRTypeDetail, PSDEFVRType pSDEFVRType) throws Exception {
        pSDEFVRTypeDetail.setPSDEFVRTypeId(pSDEFVRType.getPSDEFVRTypeId());
        pSDEFVRTypeDetail.setPSDEFVRTypeName(pSDEFVRType.getPSDEFVRTypeName());
    }

    protected void onFillEntityFullInfo(PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDEFVRTypeDetail, bl);
        this.onFillEntityFullInfo_PSDEFVRType(pSDEFVRTypeDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDEFVRType(PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFVRTypeDetail, bl);
    }

    public ArrayList<PSDEFVRTypeDetail> selectByPSDEFVRType(PSDEFVRTypeBase pSDEFVRTypeBase) throws Exception {
        return this.selectByPSDEFVRType(pSDEFVRTypeBase, "", -1);
    }

    public ArrayList<PSDEFVRTypeDetail> selectByPSDEFVRType(PSDEFVRTypeBase pSDEFVRTypeBase, String string) throws Exception {
        return this.selectByPSDEFVRType(pSDEFVRTypeBase, string, -1);
    }

    public ArrayList<PSDEFVRTypeDetail> selectByPSDEFVRType(PSDEFVRTypeBase pSDEFVRTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVRTYPEID", (Object)pSDEFVRTypeBase.getPSDEFVRTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFVRTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFVRTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEFVRType(PSDEFVRType pSDEFVRType) throws Exception {
    }

    public void resetPSDEFVRType(PSDEFVRType pSDEFVRType) throws Exception {
        ArrayList<PSDEFVRTypeDetail> arrayList = this.selectByPSDEFVRType(pSDEFVRType);
        for (PSDEFVRTypeDetail pSDEFVRTypeDetail : arrayList) {
            PSDEFVRTypeDetail pSDEFVRTypeDetail2 = (PSDEFVRTypeDetail)this.getDEModel().createEntity();
            pSDEFVRTypeDetail2.setPSDEFVRTypeDetailId(pSDEFVRTypeDetail.getPSDEFVRTypeDetailId());
            pSDEFVRTypeDetail2.setPSDEFVRTypeId(null);
            this.update(pSDEFVRTypeDetail2);
        }
    }

    public void removeByPSDEFVRType(PSDEFVRType pSDEFVRType) throws Exception {
        final PSDEFVRType pSDEFVRType2 = pSDEFVRType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRTypeDetailServiceBase.this.onBeforeRemoveByPSDEFVRType(pSDEFVRType2);
                PSDEFVRTypeDetailServiceBase.this.internalRemoveByPSDEFVRType(pSDEFVRType2);
                PSDEFVRTypeDetailServiceBase.this.onAfterRemoveByPSDEFVRType(pSDEFVRType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFVRType(PSDEFVRType pSDEFVRType) throws Exception {
    }

    protected void internalRemoveByPSDEFVRType(PSDEFVRType pSDEFVRType) throws Exception {
        ArrayList<PSDEFVRTypeDetail> arrayList = this.selectByPSDEFVRType(pSDEFVRType);
        this.onBeforeRemoveByPSDEFVRType(pSDEFVRType, arrayList);
        for (PSDEFVRTypeDetail pSDEFVRTypeDetail : arrayList) {
            this.remove(pSDEFVRTypeDetail);
        }
        this.onAfterRemoveByPSDEFVRType(pSDEFVRType, arrayList);
    }

    protected void onAfterRemoveByPSDEFVRType(PSDEFVRType pSDEFVRType) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFVRType(PSDEFVRType pSDEFVRType, ArrayList<PSDEFVRTypeDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFVRType(PSDEFVRType pSDEFVRType, ArrayList<PSDEFVRTypeDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFVRTypeDetail pSDEFVRTypeDetail) throws Exception {
        super.onBeforeRemove(pSDEFVRTypeDetail);
    }

    protected void replaceParentInfo(PSDEFVRTypeDetail pSDEFVRTypeDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFVRTypeDetail, cloneSession);
        if (pSDEFVRTypeDetail.getPSDEFVRTypeId() != null && (iEntity = cloneSession.getEntity("PSDEFVRTYPE", (Object)pSDEFVRTypeDetail.getPSDEFVRTypeId())) != null) {
            this.onFillParentInfo_PSDEFVRType(pSDEFVRTypeDetail, (PSDEFVRType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFVRTypeDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDEFVRTypeDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProcessObj(bl, pSDEFVRTypeDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRTypeDetailId(bl, pSDEFVRTypeDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRTypeDetailName(bl, pSDEFVRTypeDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRTypeId(bl, pSDEFVRTypeDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFVRTypeDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRTypeDetail.isMemoDirty() : !pSDEFVRTypeDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEFVRTypeDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFVRTypeDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ProcessObj(boolean bl, PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRTypeDetail.isProcessObjDirty() && !bl2 : !pSDEFVRTypeDetail.isProcessObjDirty()) {
            return null;
        }
        String string = pSDEFVRTypeDetail.getProcessObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProcessObj_Default(pSDEFVRTypeDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRTypeDetailId(boolean bl, PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRTypeDetail.isPSDEFVRTypeDetailIdDirty() && !bl2 : !pSDEFVRTypeDetail.isPSDEFVRTypeDetailIdDirty()) {
            return null;
        }
        String string = pSDEFVRTypeDetail.getPSDEFVRTypeDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPEDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRTypeDetailId_Default(pSDEFVRTypeDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPEDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRTypeDetailName(boolean bl, PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRTypeDetail.isPSDEFVRTypeDetailNameDirty() && !bl2 : !pSDEFVRTypeDetail.isPSDEFVRTypeDetailNameDirty()) {
            return null;
        }
        String string = pSDEFVRTypeDetail.getPSDEFVRTypeDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPEDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRTypeDetailName_Default(pSDEFVRTypeDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPEDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRTypeId(boolean bl, PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRTypeDetail.isPSDEFVRTypeIdDirty() && !bl2 : !pSDEFVRTypeDetail.isPSDEFVRTypeIdDirty()) {
            return null;
        }
        String string = pSDEFVRTypeDetail.getPSDEFVRTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRTypeId_Default(pSDEFVRTypeDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFVRTypeDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEFVRTypeDetail pSDEFVRTypeDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFVRTypeDetail, bl);
    }

    public Object getDataContextValue(PSDEFVRTypeDetail pSDEFVRTypeDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFVRTypeDetail, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFVRTypeDetail pSDEFVRTypeDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFVRTypeDetail, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PROCESSOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProcessObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRTYPEDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRTypeDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRTYPEDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRTypeDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ProcessObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROCESSOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRTypeDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRTYPEDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRTypeDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRTYPEDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEFVRTypeDetail pSDEFVRTypeDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFVRTypeDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFVRTypeDetail pSDEFVRTypeDetail) throws Exception {
        super.onUpdateParent(pSDEFVRTypeDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEFVRTypeDetail pSDEFVRTypeDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFVRTYPEDETAIL");
        if (!bl) {
            pSDEFVRTypeDetail.setCreateDate(null);
            pSDEFVRTypeDetail.setCreateMan(null);
            pSDEFVRTypeDetail.setUpdateDate(null);
            pSDEFVRTypeDetail.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFVRTypeDetail, xmlNode, bl);
        }
    }
}

