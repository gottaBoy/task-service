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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFieldImpDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFieldImpDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFieldImpServiceBase
extends PSCoreSysServiceBase<PSDEFieldImp> {
    private static final Log log = LogFactory.getLog(PSDEFieldImpServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFieldImpDEModel pSDEFieldImpDEModel;
    private PSDEFieldImpDAO pSDEFieldImpDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFieldImpService";
    }

    public PSDEFieldImpDEModel getPSDEFieldImpDEModel() {
        if (this.pSDEFieldImpDEModel == null) {
            try {
                this.pSDEFieldImpDEModel = (PSDEFieldImpDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFieldImpDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFieldImpDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFieldImpDEModel();
    }

    public PSDEFieldImpDAO getPSDEFieldImpDAO() {
        if (this.pSDEFieldImpDAO == null) {
            try {
                this.pSDEFieldImpDAO = (PSDEFieldImpDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFieldImpDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFieldImpDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFieldImpDAO();
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

    protected void onFillParentInfo(PSDEFieldImp pSDEFieldImp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELDIMP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEFieldImp, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELDIMP_PSDEFDATATYPE_PSDATATYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService", (SessionFactory)this.getSessionFactory());
            PSDEFDataType pSDEFDataType = (PSDEFDataType)iService.getDEModel().createEntity();
            pSDEFDataType.set("PSDEFDATATYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFDataType);
            } else {
                iService.get((IEntity)pSDEFDataType);
            }
            this.onFillParentInfo_PSDataType(pSDEFieldImp, pSDEFDataType);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEFieldImp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEFieldImp pSDEFieldImp, PSDataEntity pSDataEntity) throws Exception {
        pSDEFieldImp.setPSDEId(pSDataEntity.getPSDataEntityId());
    }

    protected void onFillParentInfo_PSDataType(PSDEFieldImp pSDEFieldImp, PSDEFDataType pSDEFDataType) throws Exception {
        pSDEFieldImp.setPSDataTypeId(pSDEFDataType.getPSDEFDataTypeId());
        pSDEFieldImp.setPSDataTypeName(pSDEFDataType.getPSDEFDataTypeName());
    }

    protected boolean onFillEntityKeyValue(PSDEFieldImp pSDEFieldImp, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEFieldImp.get("PSDEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEFieldImp.get("PSDEFIELDNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEFieldImp.set(this.getPSDEFieldImpDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEFieldImp pSDEFieldImp, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEFieldImp, bl);
        this.onFillEntityFullInfo_PSDE(pSDEFieldImp, bl);
        this.onFillEntityFullInfo_PSDataType(pSDEFieldImp, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEFieldImp pSDEFieldImp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDataType(PSDEFieldImp pSDEFieldImp, boolean bl) throws Exception {
        if (pSDEFieldImp.isPSDataTypeIdDirty()) {
            if (pSDEFieldImp.getPSDataTypeId() != null) {
                if (pSDEFieldImp.getPSDataTypeId() == null || pSDEFieldImp.getPSDataTypeName() == null) {
                    PSDEFDataType pSDEFDataType = pSDEFieldImp.getPSDataType();
                    pSDEFieldImp.setPSDataTypeName(pSDEFDataType.getPSDEFDataTypeName());
                }
            } else {
                pSDEFieldImp.setPSDataTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEFieldImp pSDEFieldImp, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEFieldImp, bl);
    }

    public ArrayList<PSDEFieldImp> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEFieldImp> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEFieldImp> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFieldImp> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase) throws Exception {
        return this.selectByPSDataType(pSDEFDataTypeBase, "", -1);
    }

    public ArrayList<PSDEFieldImp> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase, String string) throws Exception {
        return this.selectByPSDataType(pSDEFDataTypeBase, string, -1);
    }

    public ArrayList<PSDEFieldImp> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFieldImp> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEFieldImp pSDEFieldImp : arrayList) {
            PSDEFieldImp pSDEFieldImp2 = (PSDEFieldImp)this.getDEModel().createEntity();
            pSDEFieldImp2.setPSDEFieldId(pSDEFieldImp.getPSDEFieldId());
            pSDEFieldImp2.setPSDEId(null);
            this.update(pSDEFieldImp2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldImpServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEFieldImpServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEFieldImpServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFieldImp> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEFieldImp pSDEFieldImp : arrayList) {
            this.remove((IEntity)pSDEFieldImp);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFieldImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFieldImp> arrayList) throws Exception {
    }

    public void testRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
    }

    public void resetPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSDEFieldImp> arrayList = this.selectByPSDataType(pSDEFDataType);
        for (PSDEFieldImp pSDEFieldImp : arrayList) {
            PSDEFieldImp pSDEFieldImp2 = (PSDEFieldImp)this.getDEModel().createEntity();
            pSDEFieldImp2.setPSDEFieldId(pSDEFieldImp.getPSDEFieldId());
            pSDEFieldImp2.setPSDataTypeId(null);
            this.update(pSDEFieldImp2);
        }
    }

    public void removeByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        final PSDEFDataType pSDEFDataType2 = pSDEFDataType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldImpServiceBase.this.onBeforeRemoveByPSDataType(pSDEFDataType2);
                PSDEFieldImpServiceBase.this.internalRemoveByPSDataType(pSDEFDataType2);
                PSDEFieldImpServiceBase.this.onAfterRemoveByPSDataType(pSDEFDataType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
    }

    protected void internalRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSDEFieldImp> arrayList = this.selectByPSDataType(pSDEFDataType);
        this.onBeforeRemoveByPSDataType(pSDEFDataType, arrayList);
        for (PSDEFieldImp pSDEFieldImp : arrayList) {
            this.remove((IEntity)pSDEFieldImp);
        }
        this.onAfterRemoveByPSDataType(pSDEFDataType, arrayList);
    }

    protected void onAfterRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
    }

    protected void onBeforeRemoveByPSDataType(PSDEFDataType pSDEFDataType, ArrayList<PSDEFieldImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDataType(PSDEFDataType pSDEFDataType, ArrayList<PSDEFieldImp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFieldImp pSDEFieldImp) throws Exception {
        super.onBeforeRemove(pSDEFieldImp);
    }

    protected void replaceParentInfo(PSDEFieldImp pSDEFieldImp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEFieldImp, cloneSession);
        if (pSDEFieldImp.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEFieldImp.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEFieldImp, (PSDataEntity)iEntity);
        }
        if (pSDEFieldImp.getPSDataTypeId() != null && (iEntity = cloneSession.getEntity("PSDEFDATATYPE", (Object)pSDEFieldImp.getPSDataTypeId())) != null) {
            this.onFillParentInfo_PSDataType(pSDEFieldImp, (PSDEFDataType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFieldImp pSDEFieldImp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEFieldImp, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSDEFieldImp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImportKey(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImportOrder(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImportTag(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PhysicalField(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataTypeId(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataTypeName(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFieldId(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFieldName(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEFieldImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEFieldImp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isAllowEmptyDirty() && !bl2 : !pSDEFieldImp.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSDEFieldImp.getAllowEmpty();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default((IEntity)pSDEFieldImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_ImportKey(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isImportKeyDirty() : !pSDEFieldImp.isImportKeyDirty()) {
            return null;
        }
        Integer n = pSDEFieldImp.getImportKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImportKey_Default((IEntity)pSDEFieldImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPORTKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImportOrder(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isImportOrderDirty() : !pSDEFieldImp.isImportOrderDirty()) {
            return null;
        }
        Integer n = pSDEFieldImp.getImportOrder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImportOrder_Default((IEntity)pSDEFieldImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPORTORDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImportTag(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isImportTagDirty() : !pSDEFieldImp.isImportTagDirty()) {
            return null;
        }
        String string = pSDEFieldImp.getImportTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ImportTag_Default((IEntity)pSDEFieldImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPORTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isLogicNameDirty() && !bl2 : !pSDEFieldImp.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEFieldImp.getLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDEFieldImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PhysicalField(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isPhysicalFieldDirty() : !pSDEFieldImp.isPhysicalFieldDirty()) {
            return null;
        }
        Integer n = pSDEFieldImp.getPhysicalField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PhysicalField_Default((IEntity)pSDEFieldImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHYSICALFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDataTypeId(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isPSDataTypeIdDirty() : !pSDEFieldImp.isPSDataTypeIdDirty()) {
            return null;
        }
        String string = pSDEFieldImp.getPSDataTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataTypeId_Default((IEntity)pSDEFieldImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDataTypeName(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isPSDataTypeNameDirty() && !bl2 : !pSDEFieldImp.isPSDataTypeNameDirty()) {
            return null;
        }
        String string = pSDEFieldImp.getPSDataTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATATYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataTypeName_Default((IEntity)pSDEFieldImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFieldId(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isPSDEFieldIdDirty() && !bl2 : !pSDEFieldImp.isPSDEFieldIdDirty()) {
            return null;
        }
        String string = pSDEFieldImp.getPSDEFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFieldId_Default((IEntity)pSDEFieldImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFieldName(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isPSDEFieldNameDirty() && !bl2 : !pSDEFieldImp.isPSDEFieldNameDirty()) {
            return null;
        }
        String string = pSDEFieldImp.getPSDEFieldName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFieldName_Default((IEntity)pSDEFieldImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEFieldImpDEModel(), "PSDEFIELDNAME", string3, pSDEFieldImp, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFIELDNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEFieldImp pSDEFieldImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFieldImp.isPSDEIdDirty() && !bl2 : !pSDEFieldImp.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEFieldImp.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEFieldImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFieldImp pSDEFieldImp, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEFieldImp, bl);
    }

    protected void onSyncIndexEntities(PSDEFieldImp pSDEFieldImp, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEFieldImp, bl);
    }

    public Object getDataContextValue(PSDEFieldImp pSDEFieldImp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEFieldImp, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFieldImp pSDEFieldImp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEFieldImp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPORTKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImportKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPORTORDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImportOrder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPORTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImportTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHYSICALFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PhysicalField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATATYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATATYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ImportKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ImportOrder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ImportTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPORTTAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PhysicalField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIELDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDEFIELDNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEFieldImp pSDEFieldImp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEFieldImp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFieldImp pSDEFieldImp) throws Exception {
        super.onUpdateParent((IEntity)pSDEFieldImp);
    }

    @Override
    protected void exportCurXmlModel(PSDEFieldImp pSDEFieldImp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFIELDIMP");
        if (!bl) {
            pSDEFieldImp.setPhysicalField(null);
            pSDEFieldImp.setPSDEFieldId(null);
            super.exportCurXmlModel(pSDEFieldImp, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEFieldImp pSDEFieldImp, PSSystem pSSystem) throws Exception {
        PSDEFieldImp pSDEFieldImp2 = new PSDEFieldImp();
        pSDEFieldImp2.setPSDEId(pSDEFieldImp.getPSDEId());
        pSDEFieldImp2.setPSDEFieldName(pSDEFieldImp.getPSDEFieldName());
        if (this.selectOne((IEntity)pSDEFieldImp2, true)) {
            return pSDEFieldImp2.getPSDEFieldId();
        }
        return super.getEntityFolderKeyValue(pSDEFieldImp, pSSystem);
    }
}

