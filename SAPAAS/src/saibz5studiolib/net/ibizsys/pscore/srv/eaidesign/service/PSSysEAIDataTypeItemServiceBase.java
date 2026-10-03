/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.eaidesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDataTypeItemDAO;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDataTypeItemDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataType;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataTypeBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataTypeItem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDataTypeItemServiceBase
extends PSCoreSysServiceBase<PSSysEAIDataTypeItem> {
    private static final Log log = LogFactory.getLog(PSSysEAIDataTypeItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysEAIDataTypeItemDEModel pSSysEAIDataTypeItemDEModel;
    private PSSysEAIDataTypeItemDAO pSSysEAIDataTypeItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeItemService";
    }

    public PSSysEAIDataTypeItemDEModel getPSSysEAIDataTypeItemDEModel() {
        if (this.pSSysEAIDataTypeItemDEModel == null) {
            try {
                this.pSSysEAIDataTypeItemDEModel = (PSSysEAIDataTypeItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDataTypeItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDataTypeItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysEAIDataTypeItemDEModel();
    }

    public PSSysEAIDataTypeItemDAO getPSSysEAIDataTypeItemDAO() {
        if (this.pSSysEAIDataTypeItemDAO == null) {
            try {
                this.pSSysEAIDataTypeItemDAO = (PSSysEAIDataTypeItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDataTypeItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDataTypeItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysEAIDataTypeItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDATATYPEITEM_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeService", (SessionFactory)this.getSessionFactory());
            PSSysEAIDataType pSSysEAIDataType = (PSSysEAIDataType)iService.getDEModel().createEntity();
            pSSysEAIDataType.set("PSSYSEAIDATATYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEAIDataType);
            } else {
                iService.get(pSSysEAIDataType);
            }
            this.onFillParentInfo_PSSysEAIDataType(pSSysEAIDataTypeItem, pSSysEAIDataType);
            return;
        }
        super.onFillParentInfo(pSSysEAIDataTypeItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysEAIDataType(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, PSSysEAIDataType pSSysEAIDataType) throws Exception {
        pSSysEAIDataTypeItem.setPSSysEAIDataTypeId(pSSysEAIDataType.getPSSysEAIDataTypeId());
        pSSysEAIDataTypeItem.setPSSysEAIDataTypeName(pSSysEAIDataType.getPSSysEAIDataTypeName());
    }

    protected void onFillEntityFullInfo(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl) throws Exception {
        if (bl && pSSysEAIDataTypeItem.getValue() == null) {
            pSSysEAIDataTypeItem.setValue((String)this.getDefaultValue(this.getWebContext(), "", "1", 25));
        }
        super.onFillEntityFullInfo(pSSysEAIDataTypeItem, bl);
        this.onFillEntityFullInfo_PSSysEAIDataType(pSSysEAIDataTypeItem, bl);
    }

    protected void onFillEntityFullInfo_PSSysEAIDataType(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysEAIDataTypeItem, bl);
    }

    public ArrayList<PSSysEAIDataTypeItem> selectByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase) throws Exception {
        return this.selectByPSSysEAIDataType(pSSysEAIDataTypeBase, "", -1);
    }

    public ArrayList<PSSysEAIDataTypeItem> selectByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, String string) throws Exception {
        return this.selectByPSSysEAIDataType(pSSysEAIDataTypeBase, string, -1);
    }

    public ArrayList<PSSysEAIDataTypeItem> selectByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIDATATYPEID", (Object)pSSysEAIDataTypeBase.getPSSysEAIDataTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIDataTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIDataTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIDataTypeItem> selectTempByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase) throws Exception {
        return this.selectTempByPSSysEAIDataType(pSSysEAIDataTypeBase, "");
    }

    public ArrayList<PSSysEAIDataTypeItem> selectTempByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIDATATYPEID", (Object)pSSysEAIDataTypeBase.getPSSysEAIDataTypeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysEAIDataTypeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysEAIDataTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
    }

    public void resetPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        ArrayList<PSSysEAIDataTypeItem> arrayList = this.selectByPSSysEAIDataType(pSSysEAIDataType);
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList) {
            PSSysEAIDataTypeItem pSSysEAIDataTypeItem2 = (PSSysEAIDataTypeItem)this.getDEModel().createEntity();
            pSSysEAIDataTypeItem2.setPSSysEAIDataTypeItemId(pSSysEAIDataTypeItem.getPSSysEAIDataTypeItemId());
            pSSysEAIDataTypeItem2.setPSSysEAIDataTypeId(null);
            this.update(pSSysEAIDataTypeItem2);
        }
    }

    public void resetTempPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        ArrayList<PSSysEAIDataTypeItem> arrayList = this.selectTempByPSSysEAIDataType(pSSysEAIDataType);
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList) {
            PSSysEAIDataTypeItem pSSysEAIDataTypeItem2 = (PSSysEAIDataTypeItem)this.getDEModel().createEntity();
            pSSysEAIDataTypeItem2.setPSSysEAIDataTypeItemId(pSSysEAIDataTypeItem.getPSSysEAIDataTypeItemId());
            pSSysEAIDataTypeItem2.setPSSysEAIDataTypeId(null);
            this.updateTemp(pSSysEAIDataTypeItem2);
        }
    }

    public void removeByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        final PSSysEAIDataType pSSysEAIDataType2 = pSSysEAIDataType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDataTypeItemServiceBase.this.onBeforeRemoveByPSSysEAIDataType(pSSysEAIDataType2);
                PSSysEAIDataTypeItemServiceBase.this.internalRemoveByPSSysEAIDataType(pSSysEAIDataType2);
                PSSysEAIDataTypeItemServiceBase.this.onAfterRemoveByPSSysEAIDataType(pSSysEAIDataType2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
    }

    protected void internalRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        ArrayList<PSSysEAIDataTypeItem> arrayList = this.selectByPSSysEAIDataType(pSSysEAIDataType);
        this.onBeforeRemoveByPSSysEAIDataType(pSSysEAIDataType, arrayList);
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList) {
            this.remove(pSSysEAIDataTypeItem);
        }
        this.onAfterRemoveByPSSysEAIDataType(pSSysEAIDataType, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType, ArrayList<PSSysEAIDataTypeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType, ArrayList<PSSysEAIDataTypeItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysEAIDataTypeItem pSSysEAIDataTypeItem) throws Exception {
        super.onBeforeRemove(pSSysEAIDataTypeItem);
    }

    public void removeTempByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        final PSSysEAIDataType pSSysEAIDataType2 = pSSysEAIDataType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDataTypeItemServiceBase.this.onBeforeRemoveTempByPSSysEAIDataType(pSSysEAIDataType2);
                PSSysEAIDataTypeItemServiceBase.this.internalRemoveTempByPSSysEAIDataType(pSSysEAIDataType2);
                PSSysEAIDataTypeItemServiceBase.this.onAfterRemoveTempByPSSysEAIDataType(pSSysEAIDataType2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
    }

    protected void internalRemoveTempByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        ArrayList<PSSysEAIDataTypeItem> arrayList = this.selectTempByPSSysEAIDataType(pSSysEAIDataType);
        this.onBeforeRemoveTempByPSSysEAIDataType(pSSysEAIDataType, arrayList);
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList) {
            this.removeTemp(pSSysEAIDataTypeItem);
        }
        this.onAfterRemoveTempByPSSysEAIDataType(pSSysEAIDataType, arrayList);
    }

    protected void onAfterRemoveTempByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType, ArrayList<PSSysEAIDataTypeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType, ArrayList<PSSysEAIDataTypeItem> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysEAIDataTypeItem, cloneSession);
        if (pSSysEAIDataTypeItem.getPSSysEAIDataTypeId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIDATATYPE", (Object)pSSysEAIDataTypeItem.getPSSysEAIDataTypeId())) != null) {
            this.onFillParentInfo_PSSysEAIDataType(pSSysEAIDataTypeItem, (PSSysEAIDataType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysEAIDataTypeItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysEAIDataTypeItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDataTypeItemTag(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDataTypeItemTag2(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDataTypeId(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDataTypeItemId(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDataTypeItemName(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value(bl, pSSysEAIDataTypeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysEAIDataTypeItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isCodeNameDirty() && !bl2 : !pSSysEAIDataTypeItem.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysEAIDataTypeItem, bl2, bl3);
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
                string3 = "PSSYSEAIDATATYPEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDataTypeItemDEModel(), "CODENAME", string3, pSSysEAIDataTypeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Data(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isDataDirty() : !pSSysEAIDataTypeItem.isDataDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSSysEAIDataTypeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIDataTypeItemTag(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isEAIDataTypeItemTagDirty() : !pSSysEAIDataTypeItem.isEAIDataTypeItemTagDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getEAIDataTypeItemTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDataTypeItemTag_Default(pSSysEAIDataTypeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDATATYPEITEMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIDataTypeItemTag2(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isEAIDataTypeItemTag2Dirty() : !pSSysEAIDataTypeItem.isEAIDataTypeItemTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getEAIDataTypeItemTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDataTypeItemTag2_Default(pSSysEAIDataTypeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDATATYPEITEMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isMemoDirty() : !pSSysEAIDataTypeItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysEAIDataTypeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isOrderValueDirty() : !pSSysEAIDataTypeItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysEAIDataTypeItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysEAIDataTypeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEAIDataTypeId(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isPSSysEAIDataTypeIdDirty() : !pSSysEAIDataTypeItem.isPSSysEAIDataTypeIdDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getPSSysEAIDataTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDataTypeId_Default(pSSysEAIDataTypeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDataTypeItemId(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isPSSysEAIDataTypeItemIdDirty() && !bl2 : !pSSysEAIDataTypeItem.isPSSysEAIDataTypeItemIdDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getPSSysEAIDataTypeItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPEITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDataTypeItemId_Default(pSSysEAIDataTypeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPEITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDataTypeItemName(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isPSSysEAIDataTypeItemNameDirty() && !bl2 : !pSSysEAIDataTypeItem.isPSSysEAIDataTypeItemNameDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getPSSysEAIDataTypeItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPEITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDataTypeItemName_Default(pSSysEAIDataTypeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPEITEMNAME");
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
                string3 = "PSSYSEAIDATATYPEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDataTypeItemDEModel(), "PSSYSEAIDATATYPEITEMNAME", string3, pSSysEAIDataTypeItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSEAIDATATYPEITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isUserCatDirty() : !pSSysEAIDataTypeItem.isUserCatDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysEAIDataTypeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isUserTagDirty() : !pSSysEAIDataTypeItem.isUserTagDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysEAIDataTypeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isUserTag2Dirty() : !pSSysEAIDataTypeItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysEAIDataTypeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isUserTag3Dirty() : !pSSysEAIDataTypeItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysEAIDataTypeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isUserTag4Dirty() : !pSSysEAIDataTypeItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysEAIDataTypeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isValidFlagDirty() && !bl2 : !pSSysEAIDataTypeItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysEAIDataTypeItem.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysEAIDataTypeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Value(boolean bl, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataTypeItem.isValueDirty() && !bl2 : !pSSysEAIDataTypeItem.isValueDirty()) {
            return null;
        }
        String string = pSSysEAIDataTypeItem.getValue();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Value_Default(pSSysEAIDataTypeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUE");
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
                string3 = "PSSYSEAIDATATYPEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDataTypeItemDEModel(), "VALUE", string3, pSSysEAIDataTypeItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("VALUE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl) throws Exception {
        super.onSyncEntity(pSSysEAIDataTypeItem, bl);
    }

    protected void onSyncIndexEntities(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysEAIDataTypeItem, bl);
    }

    public Object getDataContextValue(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysEAIDataTypeItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysEAIDataType pSSysEAIDataType = pSSysEAIDataTypeItem.getPSSysEAIDataType();
        if (pSSysEAIDataType != null && pSSysEAIDataType.contains(string)) {
            return pSSysEAIDataType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysEAIDataTypeItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIDATATYPEITEMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDataTypeItemTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIDATATYPEITEMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDataTypeItemTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDATATYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDataTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDATATYPEITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDataTypeItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDATATYPEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDataTypeItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDATATYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDataTypeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Value_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EAIDataTypeItemTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDATATYPEITEMTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EAIDataTypeItemTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDATATYPEITEMTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysEAIDataTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDATATYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDataTypeItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDATATYPEITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDataTypeItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDATATYPEITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDataTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDATATYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_Value_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysEAIDataTypeItem pSSysEAIDataTypeItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysEAIDataTypeItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysEAIDataTypeItem pSSysEAIDataTypeItem) throws Exception {
        super.onUpdateParent(pSSysEAIDataTypeItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSEAIDATATYPEITEM");
        if (!bl) {
            pSSysEAIDataTypeItem.setCreateDate(null);
            pSSysEAIDataTypeItem.setCreateMan(null);
            pSSysEAIDataTypeItem.setPSSysEAIDataTypeItemId(null);
            pSSysEAIDataTypeItem.setUpdateDate(null);
            pSSysEAIDataTypeItem.setUpdateMan(null);
            pSSysEAIDataTypeItem.setPSSysEAIDataTypeId(null);
            pSSysEAIDataTypeItem.setPSSysEAIDataTypeName(null);
            super.exportCurXmlModel(pSSysEAIDataTypeItem, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysEAIDataTypeItem pSSysEAIDataTypeItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysEAIDataTypeItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDATATYPEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSEAIDATATYPE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDATATYPEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSEAIDATATYPEITEM_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDATATYPEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDATATYPENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDATATYPE", (boolean)true) == 0) {
            iEntity.set("PSSYSEAIDATATYPEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSEAIDATATYPEID"};
    }

    @Override
    public String getModelV2Tag(PSSysEAIDataTypeItem pSSysEAIDataTypeItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDataTypeItem.getCodeName())) {
            return pSSysEAIDataTypeItem.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDataTypeItem.getPSSysEAIDataTypeItemName())) {
            return pSSysEAIDataTypeItem.getPSSysEAIDataTypeItemName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDataTypeItem.getCodeName())) {
            return pSSysEAIDataTypeItem.getCodeName();
        }
        return super.getModelV2Tag(pSSysEAIDataTypeItem);
    }

    @Override
    public boolean setModelV2Tag(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, String string) {
        pSSysEAIDataTypeItem.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSEAIDATATYPEITEMNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSEAIDATATYPEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysEAIDataTypeItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysEAIDataTypeItem, true);
        pSSysEAIDataTypeItem.set("CODENAME", string);
        if (this.select(pSSysEAIDataTypeItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysEAIDataTypeItem, true);
        return super.getModelV2Entity(pSSysEAIDataTypeItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysEAIDataTypeItem pSSysEAIDataTypeItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysEAIDataTypeItem, objectNode, string, string2, n);
    }
}

