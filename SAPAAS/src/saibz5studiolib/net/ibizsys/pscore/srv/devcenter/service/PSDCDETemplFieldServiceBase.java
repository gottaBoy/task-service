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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCDETemplFieldDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDETemplFieldDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETemplBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETemplField;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDETemplFieldServiceBase
extends PSCoreSysServiceBase<PSDCDETemplField> {
    private static final Log log = LogFactory.getLog(PSDCDETemplFieldServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCDETemplFieldDEModel pSDCDETemplFieldDEModel;
    private PSDCDETemplFieldDAO pSDCDETemplFieldDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplFieldService";
    }

    public PSDCDETemplFieldDEModel getPSDCDETemplFieldDEModel() {
        if (this.pSDCDETemplFieldDEModel == null) {
            try {
                this.pSDCDETemplFieldDEModel = (PSDCDETemplFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDETemplFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDETemplFieldDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCDETemplFieldDEModel();
    }

    public PSDCDETemplFieldDAO getPSDCDETemplFieldDAO() {
        if (this.pSDCDETemplFieldDAO == null) {
            try {
                this.pSDCDETemplFieldDAO = (PSDCDETemplFieldDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCDETemplFieldDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDETemplFieldDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCDETemplFieldDAO();
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

    protected void onFillParentInfo(PSDCDETemplField pSDCDETemplField, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDETEMPLFIELD_PSDCDETEMPL_PSDCDETEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplService", (SessionFactory)this.getSessionFactory());
            PSDCDETempl pSDCDETempl = (PSDCDETempl)iService.getDEModel().createEntity();
            pSDCDETempl.set("PSDCDETEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCDETempl);
            } else {
                iService.get(pSDCDETempl);
            }
            this.onFillParentInfo_PSDCDETempl(pSDCDETemplField, pSDCDETempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDETEMPLFIELD_PSDEFDATATYPE_PSDATATYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService", (SessionFactory)this.getSessionFactory());
            PSDEFDataType pSDEFDataType = (PSDEFDataType)iService.getDEModel().createEntity();
            pSDEFDataType.set("PSDEFDATATYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFDataType);
            } else {
                iService.get(pSDEFDataType);
            }
            this.onFillParentInfo_PSDataType(pSDCDETemplField, pSDEFDataType);
            return;
        }
        super.onFillParentInfo(pSDCDETemplField, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCDETempl(PSDCDETemplField pSDCDETemplField, PSDCDETempl pSDCDETempl) throws Exception {
        pSDCDETemplField.setPSDCDETemplId(pSDCDETempl.getPSDCDETemplId());
        pSDCDETemplField.setPSDCDETemplName(pSDCDETempl.getPSDCDETemplName());
    }

    protected void onFillParentInfo_PSDataType(PSDCDETemplField pSDCDETemplField, PSDEFDataType pSDEFDataType) throws Exception {
        pSDCDETemplField.setPSDataTypeId(pSDEFDataType.getPSDEFDataTypeId());
        pSDCDETemplField.setPSDataTypeName(pSDEFDataType.getPSDEFDataTypeName());
    }

    protected void onFillEntityFullInfo(PSDCDETemplField pSDCDETemplField, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCDETemplField, bl);
        this.onFillEntityFullInfo_PSDCDETempl(pSDCDETemplField, bl);
        this.onFillEntityFullInfo_PSDataType(pSDCDETemplField, bl);
    }

    protected void onFillEntityFullInfo_PSDCDETempl(PSDCDETemplField pSDCDETemplField, boolean bl) throws Exception {
        if (pSDCDETemplField.isPSDCDETemplIdDirty()) {
            if (pSDCDETemplField.getPSDCDETemplId() != null) {
                if (pSDCDETemplField.getPSDCDETemplId() == null || pSDCDETemplField.getPSDCDETemplName() == null) {
                    PSDCDETempl pSDCDETempl = pSDCDETemplField.getPSDCDETempl();
                    pSDCDETemplField.setPSDCDETemplName(pSDCDETempl.getPSDCDETemplName());
                }
            } else {
                pSDCDETemplField.setPSDCDETemplName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDataType(PSDCDETemplField pSDCDETemplField, boolean bl) throws Exception {
        if (pSDCDETemplField.isPSDataTypeIdDirty()) {
            if (pSDCDETemplField.getPSDataTypeId() != null) {
                if (pSDCDETemplField.getPSDataTypeId() == null || pSDCDETemplField.getPSDataTypeName() == null) {
                    PSDEFDataType pSDEFDataType = pSDCDETemplField.getPSDataType();
                    pSDCDETemplField.setPSDataTypeName(pSDEFDataType.getPSDEFDataTypeName());
                }
            } else {
                pSDCDETemplField.setPSDataTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCDETemplField pSDCDETemplField, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCDETemplField, bl);
    }

    public ArrayList<PSDCDETemplField> selectByPSDCDETempl(PSDCDETemplBase pSDCDETemplBase) throws Exception {
        return this.selectByPSDCDETempl(pSDCDETemplBase, "", -1);
    }

    public ArrayList<PSDCDETemplField> selectByPSDCDETempl(PSDCDETemplBase pSDCDETemplBase, String string) throws Exception {
        return this.selectByPSDCDETempl(pSDCDETemplBase, string, -1);
    }

    public ArrayList<PSDCDETemplField> selectByPSDCDETempl(PSDCDETemplBase pSDCDETemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCDETEMPLID", (Object)pSDCDETemplBase.getPSDCDETemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCDETemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCDETemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDETemplField> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase) throws Exception {
        return this.selectByPSDataType(pSDEFDataTypeBase, "", -1);
    }

    public ArrayList<PSDCDETemplField> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase, String string) throws Exception {
        return this.selectByPSDataType(pSDEFDataTypeBase, string, -1);
    }

    public ArrayList<PSDCDETemplField> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDATATYPEID", (Object)pSDEFDataTypeBase.getPSDEFDataTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDataTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDataTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCDETempl(PSDCDETempl pSDCDETempl) throws Exception {
    }

    public void resetPSDCDETempl(PSDCDETempl pSDCDETempl) throws Exception {
        ArrayList<PSDCDETemplField> arrayList = this.selectByPSDCDETempl(pSDCDETempl);
        for (PSDCDETemplField pSDCDETemplField : arrayList) {
            PSDCDETemplField pSDCDETemplField2 = (PSDCDETemplField)this.getDEModel().createEntity();
            pSDCDETemplField2.setPSDCDETemplFieldId(pSDCDETemplField.getPSDCDETemplFieldId());
            pSDCDETemplField2.setPSDCDETemplId(null);
            this.update(pSDCDETemplField2);
        }
    }

    public void removeByPSDCDETempl(PSDCDETempl pSDCDETempl) throws Exception {
        final PSDCDETempl pSDCDETempl2 = pSDCDETempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDETemplFieldServiceBase.this.onBeforeRemoveByPSDCDETempl(pSDCDETempl2);
                PSDCDETemplFieldServiceBase.this.internalRemoveByPSDCDETempl(pSDCDETempl2);
                PSDCDETemplFieldServiceBase.this.onAfterRemoveByPSDCDETempl(pSDCDETempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCDETempl(PSDCDETempl pSDCDETempl) throws Exception {
    }

    protected void internalRemoveByPSDCDETempl(PSDCDETempl pSDCDETempl) throws Exception {
        ArrayList<PSDCDETemplField> arrayList = this.selectByPSDCDETempl(pSDCDETempl);
        this.onBeforeRemoveByPSDCDETempl(pSDCDETempl, arrayList);
        for (PSDCDETemplField pSDCDETemplField : arrayList) {
            this.remove(pSDCDETemplField);
        }
        this.onAfterRemoveByPSDCDETempl(pSDCDETempl, arrayList);
    }

    protected void onAfterRemoveByPSDCDETempl(PSDCDETempl pSDCDETempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDCDETempl(PSDCDETempl pSDCDETempl, ArrayList<PSDCDETemplField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCDETempl(PSDCDETempl pSDCDETempl, ArrayList<PSDCDETemplField> arrayList) throws Exception {
    }

    public void testRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSDCDETemplField> arrayList = this.selectByPSDataType(pSDEFDataType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFDATATYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFDataType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDETEMPLFIELD_PSDEFDATATYPE_PSDATATYPEID", "", iDataEntityModel.getName(), "PSDCDETEMPLFIELD", iDataEntityModel.getDataInfo(pSDEFDataType), arrayList.get(0)));
        }
    }

    public void resetPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSDCDETemplField> arrayList = this.selectByPSDataType(pSDEFDataType);
        for (PSDCDETemplField pSDCDETemplField : arrayList) {
            PSDCDETemplField pSDCDETemplField2 = (PSDCDETemplField)this.getDEModel().createEntity();
            pSDCDETemplField2.setPSDCDETemplFieldId(pSDCDETemplField.getPSDCDETemplFieldId());
            pSDCDETemplField2.setPSDataTypeId(null);
            this.update(pSDCDETemplField2);
        }
    }

    public void removeByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        final PSDEFDataType pSDEFDataType2 = pSDEFDataType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDETemplFieldServiceBase.this.onBeforeRemoveByPSDataType(pSDEFDataType2);
                PSDCDETemplFieldServiceBase.this.internalRemoveByPSDataType(pSDEFDataType2);
                PSDCDETemplFieldServiceBase.this.onAfterRemoveByPSDataType(pSDEFDataType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
    }

    protected void internalRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSDCDETemplField> arrayList = this.selectByPSDataType(pSDEFDataType);
        this.onBeforeRemoveByPSDataType(pSDEFDataType, arrayList);
        for (PSDCDETemplField pSDCDETemplField : arrayList) {
            this.remove(pSDCDETemplField);
        }
        this.onAfterRemoveByPSDataType(pSDEFDataType, arrayList);
    }

    protected void onAfterRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
    }

    protected void onBeforeRemoveByPSDataType(PSDEFDataType pSDEFDataType, ArrayList<PSDCDETemplField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDataType(PSDEFDataType pSDEFDataType, ArrayList<PSDCDETemplField> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCDETemplField pSDCDETemplField) throws Exception {
        super.onBeforeRemove(pSDCDETemplField);
    }

    protected void replaceParentInfo(PSDCDETemplField pSDCDETemplField, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCDETemplField, cloneSession);
        if (pSDCDETemplField.getPSDCDETemplId() != null && (iEntity = cloneSession.getEntity("PSDCDETEMPL", (Object)pSDCDETemplField.getPSDCDETemplId())) != null) {
            this.onFillParentInfo_PSDCDETempl(pSDCDETemplField, (PSDCDETempl)iEntity);
        }
        if (pSDCDETemplField.getPSDataTypeId() != null && (iEntity = cloneSession.getEntity("PSDEFDATATYPE", (Object)pSDCDETemplField.getPSDataTypeId())) != null) {
            this.onFillParentInfo_PSDataType(pSDCDETemplField, (PSDEFDataType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCDETemplField pSDCDETemplField, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCDETemplField, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSDCDETemplField, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFType(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Length(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreDefineType(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataTypeId(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataTypeName(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDETemplFieldId(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDETemplFieldName(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDETemplId(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDETemplName(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCDETemplField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCDETemplField, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isAllowEmptyDirty() && !bl2 : !pSDCDETemplField.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSDCDETemplField.getAllowEmpty();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isCodeNameDirty() : !pSDCDETemplField.isCodeNameDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDCDETEMPLID";
                String string4 = this.checkFieldDupRule(this.getPSDCDETemplFieldDEModel(), "CODENAME", string3, pSDCDETemplField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFType(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isDEFTypeDirty() && !bl2 : !pSDCDETemplField.isDEFTypeDirty()) {
            return null;
        }
        Integer n = pSDCDETemplField.getDEFType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DEFType_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Length(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isLengthDirty() : !pSDCDETemplField.isLengthDirty()) {
            return null;
        }
        Integer n = pSDCDETemplField.getLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Length_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isLogicNameDirty() && !bl2 : !pSDCDETemplField.isLogicNameDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isMemoDirty() : !pSDCDETemplField.isMemoDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCDETemplField, bl2, bl3);
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

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isPrecision2Dirty() : !pSDCDETemplField.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSDCDETemplField.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreDefineType(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isPreDefineTypeDirty() : !pSDCDETemplField.isPreDefineTypeDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getPreDefineType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreDefineType_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDataTypeId(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isPSDataTypeIdDirty() : !pSDCDETemplField.isPSDataTypeIdDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getPSDataTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataTypeId_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATATYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDataTypeName(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isPSDataTypeNameDirty() : !pSDCDETemplField.isPSDataTypeNameDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getPSDataTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataTypeName_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATATYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDETemplFieldId(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isPSDCDETemplFieldIdDirty() && !bl2 : !pSDCDETemplField.isPSDCDETemplFieldIdDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getPSDCDETemplFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDETEMPLFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDETemplFieldId_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDETEMPLFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDETemplFieldName(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isPSDCDETemplFieldNameDirty() && !bl2 : !pSDCDETemplField.isPSDCDETemplFieldNameDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getPSDCDETemplFieldName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDETEMPLFIELDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDETemplFieldName_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDETEMPLFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDCDETEMPLID";
                String string4 = this.checkFieldDupRule(this.getPSDCDETemplFieldDEModel(), "PSDCDETEMPLFIELDNAME", string3, pSDCDETemplField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDCDETEMPLFIELDNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDETemplId(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isPSDCDETemplIdDirty() && !bl2 : !pSDCDETemplField.isPSDCDETemplIdDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getPSDCDETemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDETEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDETemplId_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDETEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDETemplName(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isPSDCDETemplNameDirty() : !pSDCDETemplField.isPSDCDETemplNameDirty()) {
            return null;
        }
        String string = pSDCDETemplField.getPSDCDETemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDETemplName_Default(pSDCDETemplField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDETEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCDETemplField pSDCDETemplField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDETemplField.isValidFlagDirty() && !bl2 : !pSDCDETemplField.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCDETemplField.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCDETemplField, bl2, bl3);
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

    protected void onSyncEntity(PSDCDETemplField pSDCDETemplField, boolean bl) throws Exception {
        super.onSyncEntity(pSDCDETemplField, bl);
    }

    protected void onSyncIndexEntities(PSDCDETemplField pSDCDETemplField, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCDETemplField, bl);
    }

    public Object getDataContextValue(PSDCDETemplField pSDCDETemplField, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCDETemplField, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCDETempl pSDCDETempl = pSDCDETemplField.getPSDCDETempl();
        if (pSDCDETempl != null && pSDCDETempl.contains(string)) {
            return pSDCDETempl.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCDETemplField pSDCDETemplField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCDETemplField, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Length_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreDefineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATATYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATATYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDETEMPLFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDETemplFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDETEMPLFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDETemplFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDETEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDETemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDETEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDETemplName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DEFType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Length_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PreDefineType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDataTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDATATYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDataTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDATATYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDETemplFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDETEMPLFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDETemplFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDETEMPLFIELDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDCDETEMPLFIELDNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDETemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDETEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDETemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDETEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDCDETemplField pSDCDETemplField) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCDETemplField)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCDETemplField pSDCDETemplField) throws Exception {
        super.onUpdateParent(pSDCDETemplField);
    }

    @Override
    protected void exportCurXmlModel(PSDCDETemplField pSDCDETemplField, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCDETEMPLFIELD");
        if (!bl) {
            pSDCDETemplField.setCreateDate(null);
            pSDCDETemplField.setCreateMan(null);
            pSDCDETemplField.setPSDCDETemplFieldId(null);
            pSDCDETemplField.setUpdateDate(null);
            pSDCDETemplField.setUpdateMan(null);
            super.exportCurXmlModel(pSDCDETemplField, xmlNode, bl);
        }
    }
}

