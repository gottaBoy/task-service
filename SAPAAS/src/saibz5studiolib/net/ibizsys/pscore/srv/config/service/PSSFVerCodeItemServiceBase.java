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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSFVerCodeItemDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFVerCodeItemDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCode;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCodeBase;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCodeItem;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFVerCodeItemServiceBase
extends PSCoreSysServiceBase<PSSFVerCodeItem> {
    private static final Log log = LogFactory.getLog(PSSFVerCodeItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFVerCodeItemDEModel pSSFVerCodeItemDEModel;
    private PSSFVerCodeItemDAO pSSFVerCodeItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFVerCodeItemService";
    }

    public PSSFVerCodeItemDEModel getPSSFVerCodeItemDEModel() {
        if (this.pSSFVerCodeItemDEModel == null) {
            try {
                this.pSSFVerCodeItemDEModel = (PSSFVerCodeItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFVerCodeItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFVerCodeItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFVerCodeItemDEModel();
    }

    public PSSFVerCodeItemDAO getPSSFVerCodeItemDAO() {
        if (this.pSSFVerCodeItemDAO == null) {
            try {
                this.pSSFVerCodeItemDAO = (PSSFVerCodeItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFVerCodeItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFVerCodeItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFVerCodeItemDAO();
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

    protected void onFillParentInfo(PSSFVerCodeItem pSSFVerCodeItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFVERCODEITEM_PSSFVERCODE_PSSFVERCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFVerCodeService", (SessionFactory)this.getSessionFactory());
            PSSFVerCode pSSFVerCode = (PSSFVerCode)iService.getDEModel().createEntity();
            pSSFVerCode.set("PSSFVERCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFVerCode);
            } else {
                iService.get((IEntity)pSSFVerCode);
            }
            this.onFillParentInfo_PSSFVerCode(pSSFVerCodeItem, pSSFVerCode);
            return;
        }
        super.onFillParentInfo((IEntity)pSSFVerCodeItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFVerCode(PSSFVerCodeItem pSSFVerCodeItem, PSSFVerCode pSSFVerCode) throws Exception {
        pSSFVerCodeItem.setPSSFStyleVerId(pSSFVerCode.getPSSFStyleVerId());
        pSSFVerCodeItem.setPSSFVerCodeId(pSSFVerCode.getPSSFVerCodeId());
        pSSFVerCodeItem.setPSSFVerCodeName(pSSFVerCode.getPSSFVerCodeName());
    }

    protected boolean onFillEntityKeyValue(PSSFVerCodeItem pSSFVerCodeItem, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSFVerCodeItem.get("PSSFVERCODEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSFVerCodeItem.get("PSSFVERCODEITEMNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSFVerCodeItem.set(this.getPSSFVerCodeItemDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSFVerCodeItem pSSFVerCodeItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSFVerCodeItem, bl);
        this.onFillEntityFullInfo_PSSFVerCode(pSSFVerCodeItem, bl);
    }

    protected void onFillEntityFullInfo_PSSFVerCode(PSSFVerCodeItem pSSFVerCodeItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFVerCodeItem pSSFVerCodeItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSFVerCodeItem, bl);
    }

    public ArrayList<PSSFVerCodeItem> selectByPSSFVerCode(PSSFVerCodeBase pSSFVerCodeBase) throws Exception {
        return this.selectByPSSFVerCode(pSSFVerCodeBase, "", -1);
    }

    public ArrayList<PSSFVerCodeItem> selectByPSSFVerCode(PSSFVerCodeBase pSSFVerCodeBase, String string) throws Exception {
        return this.selectByPSSFVerCode(pSSFVerCodeBase, string, -1);
    }

    public ArrayList<PSSFVerCodeItem> selectByPSSFVerCode(PSSFVerCodeBase pSSFVerCodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFVERCODEID", (Object)pSSFVerCodeBase.getPSSFVerCodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFVerCodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFVerCodeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFVerCode(PSSFVerCode pSSFVerCode) throws Exception {
    }

    public void resetPSSFVerCode(PSSFVerCode pSSFVerCode) throws Exception {
        ArrayList<PSSFVerCodeItem> arrayList = this.selectByPSSFVerCode(pSSFVerCode);
        for (PSSFVerCodeItem pSSFVerCodeItem : arrayList) {
            PSSFVerCodeItem pSSFVerCodeItem2 = (PSSFVerCodeItem)this.getDEModel().createEntity();
            pSSFVerCodeItem2.setPSSFVerCodeItemId(pSSFVerCodeItem.getPSSFVerCodeItemId());
            pSSFVerCodeItem2.setPSSFVerCodeId(null);
            this.update(pSSFVerCodeItem2);
        }
    }

    public void removeByPSSFVerCode(PSSFVerCode pSSFVerCode) throws Exception {
        final PSSFVerCode pSSFVerCode2 = pSSFVerCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFVerCodeItemServiceBase.this.onBeforeRemoveByPSSFVerCode(pSSFVerCode2);
                PSSFVerCodeItemServiceBase.this.internalRemoveByPSSFVerCode(pSSFVerCode2);
                PSSFVerCodeItemServiceBase.this.onAfterRemoveByPSSFVerCode(pSSFVerCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFVerCode(PSSFVerCode pSSFVerCode) throws Exception {
    }

    protected void internalRemoveByPSSFVerCode(PSSFVerCode pSSFVerCode) throws Exception {
        ArrayList<PSSFVerCodeItem> arrayList = this.selectByPSSFVerCode(pSSFVerCode);
        this.onBeforeRemoveByPSSFVerCode(pSSFVerCode, arrayList);
        for (PSSFVerCodeItem pSSFVerCodeItem : arrayList) {
            this.remove((IEntity)pSSFVerCodeItem);
        }
        this.onAfterRemoveByPSSFVerCode(pSSFVerCode, arrayList);
    }

    protected void onAfterRemoveByPSSFVerCode(PSSFVerCode pSSFVerCode) throws Exception {
    }

    protected void onBeforeRemoveByPSSFVerCode(PSSFVerCode pSSFVerCode, ArrayList<PSSFVerCodeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFVerCode(PSSFVerCode pSSFVerCode, ArrayList<PSSFVerCodeItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFVerCodeItem pSSFVerCodeItem) throws Exception {
        super.onBeforeRemove(pSSFVerCodeItem);
    }

    protected void replaceParentInfo(PSSFVerCodeItem pSSFVerCodeItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSFVerCodeItem, cloneSession);
        if (pSSFVerCodeItem.getPSSFVerCodeId() != null && (iEntity = cloneSession.getEntity("PSSFVERCODE", (Object)pSSFVerCodeItem.getPSSFVerCodeId())) != null) {
            this.onFillParentInfo_PSSFVerCode(pSSFVerCodeItem, (PSSFVerCode)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFVerCodeItem pSSFVerCodeItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSFVerCodeItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFVerCodeItem pSSFVerCodeItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSFVerCodeItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFVerCodeId(bl, pSSFVerCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFVerCodeItemId(bl, pSSFVerCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFVerCodeItemName(bl, pSSFVerCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSSFVerCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSSFVerCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSFVerCodeItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFVerCodeItem pSSFVerCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCodeItem.isMemoDirty() : !pSSFVerCodeItem.isMemoDirty()) {
            return null;
        }
        String string = pSSFVerCodeItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSFVerCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFVerCodeId(boolean bl, PSSFVerCodeItem pSSFVerCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCodeItem.isPSSFVerCodeIdDirty() && !bl2 : !pSSFVerCodeItem.isPSSFVerCodeIdDirty()) {
            return null;
        }
        String string = pSSFVerCodeItem.getPSSFVerCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFVerCodeId_Default((IEntity)pSSFVerCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFVerCodeItemId(boolean bl, PSSFVerCodeItem pSSFVerCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCodeItem.isPSSFVerCodeItemIdDirty() && !bl2 : !pSSFVerCodeItem.isPSSFVerCodeItemIdDirty()) {
            return null;
        }
        String string = pSSFVerCodeItem.getPSSFVerCodeItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODEITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFVerCodeItemId_Default((IEntity)pSSFVerCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODEITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFVerCodeItemName(boolean bl, PSSFVerCodeItem pSSFVerCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCodeItem.isPSSFVerCodeItemNameDirty() && !bl2 : !pSSFVerCodeItem.isPSSFVerCodeItemNameDirty()) {
            return null;
        }
        String string = pSSFVerCodeItem.getPSSFVerCodeItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODEITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFVerCodeItemName_Default((IEntity)pSSFVerCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODEITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSSFVerCodeItem pSSFVerCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCodeItem.isTemplCodeDirty() : !pSSFVerCodeItem.isTemplCodeDirty()) {
            return null;
        }
        String string = pSSFVerCodeItem.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default((IEntity)pSSFVerCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSSFVerCodeItem pSSFVerCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCodeItem.isTemplCode2Dirty() : !pSSFVerCodeItem.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSSFVerCodeItem.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default((IEntity)pSSFVerCodeItem, bl2, bl3);
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

    protected void onSyncEntity(PSSFVerCodeItem pSSFVerCodeItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSFVerCodeItem, bl);
    }

    protected void onSyncIndexEntities(PSSFVerCodeItem pSSFVerCodeItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSFVerCodeItem, bl);
    }

    public Object getDataContextValue(PSSFVerCodeItem pSSFVerCodeItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSFVerCodeItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSSFVerCode pSSFVerCode = pSSFVerCodeItem.getPSSFVerCode();
        if (pSSFVerCode != null && pSSFVerCode.contains(string)) {
            return pSSFVerCode.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSFVerCodeItem pSSFVerCodeItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSFVerCodeItem, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFVERCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFVerCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFVERCODEITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFVerCodeItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFVERCODEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFVerCodeItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFVERCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFVerCodeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSFStyleVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFVerCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFVERCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFVerCodeItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFVERCODEITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFVerCodeItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFVERCODEITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSSFVERCODEITEMNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFVerCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFVERCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSSFVerCodeItem pSSFVerCodeItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSFVerCodeItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFVerCodeItem pSSFVerCodeItem) throws Exception {
        super.onUpdateParent((IEntity)pSSFVerCodeItem);
    }

    @Override
    protected void exportCurXmlModel(PSSFVerCodeItem pSSFVerCodeItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFVERCODEITEM");
        if (!bl) {
            pSSFVerCodeItem.setCreateDate(null);
            pSSFVerCodeItem.setCreateMan(null);
            pSSFVerCodeItem.setPSSFVerCodeItemId(null);
            pSSFVerCodeItem.setTemplCode(null);
            pSSFVerCodeItem.setUpdateDate(null);
            pSSFVerCodeItem.setUpdateMan(null);
            super.exportCurXmlModel(pSSFVerCodeItem, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSFVerCodeItem pSSFVerCodeItem, PSSystem pSSystem) throws Exception {
        PSSFVerCodeItem pSSFVerCodeItem2 = new PSSFVerCodeItem();
        pSSFVerCodeItem2.setPSSFVerCodeId(pSSFVerCodeItem.getPSSFVerCodeId());
        pSSFVerCodeItem2.setPSSFVerCodeItemName(pSSFVerCodeItem.getPSSFVerCodeItemName());
        if (this.selectOne((IEntity)pSSFVerCodeItem2, true)) {
            return pSSFVerCodeItem2.getPSSFVerCodeItemId();
        }
        return super.getEntityFolderKeyValue(pSSFVerCodeItem, pSSystem);
    }
}

