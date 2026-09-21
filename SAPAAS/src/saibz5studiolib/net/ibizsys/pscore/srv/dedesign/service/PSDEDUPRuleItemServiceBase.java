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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDUPRuleItemDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDUPRuleItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDUPRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDUPRuleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDUPRuleItem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDUPRuleItemServiceBase
extends PSCoreSysServiceBase<PSDEDUPRuleItem> {
    private static final Log log = LogFactory.getLog(PSDEDUPRuleItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEDUPRuleItemDEModel pSDEDUPRuleItemDEModel;
    private PSDEDUPRuleItemDAO pSDEDUPRuleItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDUPRuleItemService";
    }

    public PSDEDUPRuleItemDEModel getPSDEDUPRuleItemDEModel() {
        if (this.pSDEDUPRuleItemDEModel == null) {
            try {
                this.pSDEDUPRuleItemDEModel = (PSDEDUPRuleItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDUPRuleItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDUPRuleItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDUPRuleItemDEModel();
    }

    public PSDEDUPRuleItemDAO getPSDEDUPRuleItemDAO() {
        if (this.pSDEDUPRuleItemDAO == null) {
            try {
                this.pSDEDUPRuleItemDAO = (PSDEDUPRuleItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDUPRuleItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDUPRuleItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDUPRuleItemDAO();
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

    protected void onFillParentInfo(PSDEDUPRuleItem pSDEDUPRuleItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDUPRULEITEM_PSDEDUPRULE_PSDEDUPRULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDUPRuleService", (SessionFactory)this.getSessionFactory());
            PSDEDUPRule pSDEDUPRule = (PSDEDUPRule)iService.getDEModel().createEntity();
            pSDEDUPRule.set("PSDEDUPRULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDUPRule);
            } else {
                iService.get((IEntity)pSDEDUPRule);
            }
            this.onFillParentInfo_PSDEDupRule(pSDEDUPRuleItem, pSDEDUPRule);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDUPRuleItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEDupRule(PSDEDUPRuleItem pSDEDUPRuleItem, PSDEDUPRule pSDEDUPRule) throws Exception {
        pSDEDUPRuleItem.setPSDEDUPRuleId(pSDEDUPRule.getPSDEDUPRuleId());
        pSDEDUPRuleItem.setPSDEDUPRuleName(pSDEDUPRule.getPSDEDUPRuleName());
    }

    protected void onFillEntityFullInfo(PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEDUPRuleItem, bl);
        this.onFillEntityFullInfo_PSDEDupRule(pSDEDUPRuleItem, bl);
    }

    protected void onFillEntityFullInfo_PSDEDupRule(PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDUPRuleItem, bl);
    }

    public ArrayList<PSDEDUPRuleItem> selectByPSDEDupRule(PSDEDUPRuleBase pSDEDUPRuleBase) throws Exception {
        return this.selectByPSDEDupRule(pSDEDUPRuleBase, "", -1);
    }

    public ArrayList<PSDEDUPRuleItem> selectByPSDEDupRule(PSDEDUPRuleBase pSDEDUPRuleBase, String string) throws Exception {
        return this.selectByPSDEDupRule(pSDEDUPRuleBase, string, -1);
    }

    public ArrayList<PSDEDUPRuleItem> selectByPSDEDupRule(PSDEDUPRuleBase pSDEDUPRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDUPRULEID", (Object)pSDEDUPRuleBase.getPSDEDUPRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDupRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDupRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEDupRule(PSDEDUPRule pSDEDUPRule) throws Exception {
    }

    public void resetPSDEDupRule(PSDEDUPRule pSDEDUPRule) throws Exception {
        ArrayList<PSDEDUPRuleItem> arrayList = this.selectByPSDEDupRule(pSDEDUPRule);
        for (PSDEDUPRuleItem pSDEDUPRuleItem : arrayList) {
            PSDEDUPRuleItem pSDEDUPRuleItem2 = (PSDEDUPRuleItem)this.getDEModel().createEntity();
            pSDEDUPRuleItem2.setPSDEDUPRuleItemId(pSDEDUPRuleItem.getPSDEDUPRuleItemId());
            pSDEDUPRuleItem2.setPSDEDUPRuleId(null);
            this.update(pSDEDUPRuleItem2);
        }
    }

    public void removeByPSDEDupRule(PSDEDUPRule pSDEDUPRule) throws Exception {
        final PSDEDUPRule pSDEDUPRule2 = pSDEDUPRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDUPRuleItemServiceBase.this.onBeforeRemoveByPSDEDupRule(pSDEDUPRule2);
                PSDEDUPRuleItemServiceBase.this.internalRemoveByPSDEDupRule(pSDEDUPRule2);
                PSDEDUPRuleItemServiceBase.this.onAfterRemoveByPSDEDupRule(pSDEDUPRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDupRule(PSDEDUPRule pSDEDUPRule) throws Exception {
    }

    protected void internalRemoveByPSDEDupRule(PSDEDUPRule pSDEDUPRule) throws Exception {
        ArrayList<PSDEDUPRuleItem> arrayList = this.selectByPSDEDupRule(pSDEDUPRule);
        this.onBeforeRemoveByPSDEDupRule(pSDEDUPRule, arrayList);
        for (PSDEDUPRuleItem pSDEDUPRuleItem : arrayList) {
            this.remove((IEntity)pSDEDUPRuleItem);
        }
        this.onAfterRemoveByPSDEDupRule(pSDEDUPRule, arrayList);
    }

    protected void onAfterRemoveByPSDEDupRule(PSDEDUPRule pSDEDUPRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDupRule(PSDEDUPRule pSDEDUPRule, ArrayList<PSDEDUPRuleItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDupRule(PSDEDUPRule pSDEDUPRule, ArrayList<PSDEDUPRuleItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDUPRuleItem pSDEDUPRuleItem) throws Exception {
        super.onBeforeRemove(pSDEDUPRuleItem);
    }

    protected void replaceParentInfo(PSDEDUPRuleItem pSDEDUPRuleItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDUPRuleItem, cloneSession);
        if (pSDEDUPRuleItem.getPSDEDUPRuleId() != null && (iEntity = cloneSession.getEntity("PSDEDUPRULE", (Object)pSDEDUPRuleItem.getPSDEDUPRuleId())) != null) {
            this.onFillParentInfo_PSDEDupRule(pSDEDUPRuleItem, (PSDEDUPRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDUPRuleItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDEDUPRuleId(bl, pSDEDUPRuleItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDUPRuleItemId(bl, pSDEDUPRuleItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDUPRuleItemName(bl, pSDEDUPRuleItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDUPRuleItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDEDUPRuleId(boolean bl, PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDUPRuleItem.isPSDEDUPRuleIdDirty() && !bl2 : !pSDEDUPRuleItem.isPSDEDUPRuleIdDirty()) {
            return null;
        }
        String string = pSDEDUPRuleItem.getPSDEDUPRuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDUPRULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDUPRuleId_Default((IEntity)pSDEDUPRuleItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDUPRULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDUPRuleItemId(boolean bl, PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDUPRuleItem.isPSDEDUPRuleItemIdDirty() && !bl2 : !pSDEDUPRuleItem.isPSDEDUPRuleItemIdDirty()) {
            return null;
        }
        String string = pSDEDUPRuleItem.getPSDEDUPRuleItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDUPRULEITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDUPRuleItemId_Default((IEntity)pSDEDUPRuleItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDUPRULEITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDUPRuleItemName(boolean bl, PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDUPRuleItem.isPSDEDUPRuleItemNameDirty() && !bl2 : !pSDEDUPRuleItem.isPSDEDUPRuleItemNameDirty()) {
            return null;
        }
        String string = pSDEDUPRuleItem.getPSDEDUPRuleItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDUPRULEITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDUPRuleItemName_Default((IEntity)pSDEDUPRuleItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDUPRULEITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDUPRuleItem, bl);
    }

    protected void onSyncIndexEntities(PSDEDUPRuleItem pSDEDUPRuleItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDUPRuleItem, bl);
    }

    public Object getDataContextValue(PSDEDUPRuleItem pSDEDUPRuleItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDUPRuleItem, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDUPRuleItem pSDEDUPRuleItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDUPRuleItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDUPRULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDUPRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDUPRULEITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDUPRuleItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDUPRULEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDUPRuleItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDUPRULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDUPRuleName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEDUPRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDUPRULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDUPRuleItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDUPRULEITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDUPRuleItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDUPRULEITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDUPRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDUPRULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEDUPRuleItem pSDEDUPRuleItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDUPRuleItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDUPRuleItem pSDEDUPRuleItem) throws Exception {
        super.onUpdateParent((IEntity)pSDEDUPRuleItem);
    }

    @Override
    protected void exportCurXmlModel(PSDEDUPRuleItem pSDEDUPRuleItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDUPRULEITEM");
        if (!bl) {
            pSDEDUPRuleItem.setCreateDate(null);
            pSDEDUPRuleItem.setCreateMan(null);
            pSDEDUPRuleItem.setPSDEDUPRuleItemId(null);
            pSDEDUPRuleItem.setUpdateDate(null);
            pSDEDUPRuleItem.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDUPRuleItem, xmlNode, bl);
        }
    }
}

