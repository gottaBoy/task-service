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
package net.ibizsys.pscore.srv.sysdevstudio.service;

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
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWCreateDEItemDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEItemDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDE;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEItem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWCreateDEItemServiceBase
extends PSCoreSysServiceBase<PSUWCreateDEItem> {
    private static final Log log = LogFactory.getLog(PSUWCreateDEItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUWCreateDEItemDEModel pSUWCreateDEItemDEModel;
    private PSUWCreateDEItemDAO pSUWCreateDEItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEItemService";
    }

    public PSUWCreateDEItemDEModel getPSUWCreateDEItemDEModel() {
        if (this.pSUWCreateDEItemDEModel == null) {
            try {
                this.pSUWCreateDEItemDEModel = (PSUWCreateDEItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWCreateDEItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUWCreateDEItemDEModel();
    }

    public PSUWCreateDEItemDAO getPSUWCreateDEItemDAO() {
        if (this.pSUWCreateDEItemDAO == null) {
            try {
                this.pSUWCreateDEItemDAO = (PSUWCreateDEItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWCreateDEItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWCreateDEItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUWCreateDEItemDAO();
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

    protected void onFillParentInfo(PSUWCreateDEItem pSUWCreateDEItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUWCREATEDEITEM_PSUWCREATEDE_PSUWCREATEDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEService", (SessionFactory)this.getSessionFactory());
            PSUWCreateDE pSUWCreateDE = (PSUWCreateDE)iService.getDEModel().createEntity();
            pSUWCreateDE.set("PSUWCREATEDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSUWCreateDE);
            } else {
                iService.get(pSUWCreateDE);
            }
            this.onFillParentInfo_PSUWCreateDE(pSUWCreateDEItem, pSUWCreateDE);
            return;
        }
        super.onFillParentInfo(pSUWCreateDEItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSUWCreateDE(PSUWCreateDEItem pSUWCreateDEItem, PSUWCreateDE pSUWCreateDE) throws Exception {
        pSUWCreateDEItem.setPSUWCreateDEId(pSUWCreateDE.getPSUWCreateDEId());
    }

    protected void onFillEntityFullInfo(PSUWCreateDEItem pSUWCreateDEItem, boolean bl) throws Exception {
        if (bl && pSUWCreateDEItem.getPSUWCreateDEItemName() == null) {
            pSUWCreateDEItem.setPSUWCreateDEItemName((String)this.getDefaultValue(this.getWebContext(), "", "\u540d\u79f0", 25));
        }
        super.onFillEntityFullInfo(pSUWCreateDEItem, bl);
        this.onFillEntityFullInfo_PSUWCreateDE(pSUWCreateDEItem, bl);
    }

    protected void onFillEntityFullInfo_PSUWCreateDE(PSUWCreateDEItem pSUWCreateDEItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSUWCreateDEItem pSUWCreateDEItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSUWCreateDEItem, bl);
    }

    public ArrayList<PSUWCreateDEItem> selectByPSUWCreateDE(PSUWCreateDEBase pSUWCreateDEBase) throws Exception {
        return this.selectByPSUWCreateDE(pSUWCreateDEBase, "", -1);
    }

    public ArrayList<PSUWCreateDEItem> selectByPSUWCreateDE(PSUWCreateDEBase pSUWCreateDEBase, String string) throws Exception {
        return this.selectByPSUWCreateDE(pSUWCreateDEBase, string, -1);
    }

    public ArrayList<PSUWCreateDEItem> selectByPSUWCreateDE(PSUWCreateDEBase pSUWCreateDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUWCREATEDEID", (Object)pSUWCreateDEBase.getPSUWCreateDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUWCreateDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUWCreateDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSUWCreateDE(PSUWCreateDE pSUWCreateDE) throws Exception {
    }

    public void resetPSUWCreateDE(PSUWCreateDE pSUWCreateDE) throws Exception {
        ArrayList<PSUWCreateDEItem> arrayList = this.selectByPSUWCreateDE(pSUWCreateDE);
        for (PSUWCreateDEItem pSUWCreateDEItem : arrayList) {
            PSUWCreateDEItem pSUWCreateDEItem2 = (PSUWCreateDEItem)this.getDEModel().createEntity();
            pSUWCreateDEItem2.setPSUWCreateDEItemId(pSUWCreateDEItem.getPSUWCreateDEItemId());
            pSUWCreateDEItem2.setPSUWCreateDEId(null);
            this.update(pSUWCreateDEItem2);
        }
    }

    public void removeByPSUWCreateDE(PSUWCreateDE pSUWCreateDE) throws Exception {
        final PSUWCreateDE pSUWCreateDE2 = pSUWCreateDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUWCreateDEItemServiceBase.this.onBeforeRemoveByPSUWCreateDE(pSUWCreateDE2);
                PSUWCreateDEItemServiceBase.this.internalRemoveByPSUWCreateDE(pSUWCreateDE2);
                PSUWCreateDEItemServiceBase.this.onAfterRemoveByPSUWCreateDE(pSUWCreateDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSUWCreateDE(PSUWCreateDE pSUWCreateDE) throws Exception {
    }

    protected void internalRemoveByPSUWCreateDE(PSUWCreateDE pSUWCreateDE) throws Exception {
        ArrayList<PSUWCreateDEItem> arrayList = this.selectByPSUWCreateDE(pSUWCreateDE);
        this.onBeforeRemoveByPSUWCreateDE(pSUWCreateDE, arrayList);
        for (PSUWCreateDEItem pSUWCreateDEItem : arrayList) {
            this.remove(pSUWCreateDEItem);
        }
        this.onAfterRemoveByPSUWCreateDE(pSUWCreateDE, arrayList);
    }

    protected void onAfterRemoveByPSUWCreateDE(PSUWCreateDE pSUWCreateDE) throws Exception {
    }

    protected void onBeforeRemoveByPSUWCreateDE(PSUWCreateDE pSUWCreateDE, ArrayList<PSUWCreateDEItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUWCreateDE(PSUWCreateDE pSUWCreateDE, ArrayList<PSUWCreateDEItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSUWCreateDEItem pSUWCreateDEItem) throws Exception {
        super.onBeforeRemove(pSUWCreateDEItem);
    }

    protected void replaceParentInfo(PSUWCreateDEItem pSUWCreateDEItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSUWCreateDEItem, cloneSession);
        if (pSUWCreateDEItem.getPSUWCreateDEId() != null && (iEntity = cloneSession.getEntity("PSUWCREATEDE", (Object)pSUWCreateDEItem.getPSUWCreateDEId())) != null) {
            this.onFillParentInfo_PSUWCreateDE(pSUWCreateDEItem, (PSUWCreateDE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSUWCreateDEItem pSUWCreateDEItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSUWCreateDEItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSUWCreateDEItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam2(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam3(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam4(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewCodeName(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewDELogicName(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewDEName(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewDETableName(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewDEViewName(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUWCreateDEId(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUWCreateDEItemId(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUWCreateDEItemName(bl, pSUWCreateDEItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSUWCreateDEItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isCodeNameDirty() : !pSUWCreateDEItem.isCodeNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isItemParamDirty() : !pSUWCreateDEItem.isItemParamDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getItemParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParam_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam2(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isItemParam2Dirty() : !pSUWCreateDEItem.isItemParam2Dirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getItemParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParam2_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam3(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isItemParam3Dirty() : !pSUWCreateDEItem.isItemParam3Dirty()) {
            return null;
        }
        Integer n = pSUWCreateDEItem.getItemParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam3_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam4(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isItemParam4Dirty() : !pSUWCreateDEItem.isItemParam4Dirty()) {
            return null;
        }
        Integer n = pSUWCreateDEItem.getItemParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam4_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewCodeName(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isNewCodeNameDirty() : !pSUWCreateDEItem.isNewCodeNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getNewCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewCodeName_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewDELogicName(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isNewDELogicNameDirty() : !pSUWCreateDEItem.isNewDELogicNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getNewDELogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewDELogicName_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWDELOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewDEName(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isNewDENameDirty() : !pSUWCreateDEItem.isNewDENameDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getNewDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewDEName_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewDETableName(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isNewDETableNameDirty() : !pSUWCreateDEItem.isNewDETableNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getNewDETableName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewDETableName_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWDETABLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewDEViewName(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isNewDEViewNameDirty() : !pSUWCreateDEItem.isNewDEViewNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getNewDEViewName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewDEViewName_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWDEVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isPSDEIdDirty() : !pSUWCreateDEItem.isPSDEIdDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSUWCreateDEItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isPSDENameDirty() : !pSUWCreateDEItem.isPSDENameDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isPSDynaInstIdDirty() : !pSUWCreateDEItem.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUWCreateDEId(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isPSUWCreateDEIdDirty() : !pSUWCreateDEItem.isPSUWCreateDEIdDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getPSUWCreateDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUWCreateDEId_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUWCreateDEItemId(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isPSUWCreateDEItemIdDirty() && !bl2 : !pSUWCreateDEItem.isPSUWCreateDEItemIdDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getPSUWCreateDEItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUWCreateDEItemId_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUWCreateDEItemName(boolean bl, PSUWCreateDEItem pSUWCreateDEItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEItem.isPSUWCreateDEItemNameDirty() && !bl2 : !pSUWCreateDEItem.isPSUWCreateDEItemNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEItem.getPSUWCreateDEItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUWCreateDEItemName_Default(pSUWCreateDEItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSUWCreateDEItem pSUWCreateDEItem, boolean bl) throws Exception {
        super.onSyncEntity(pSUWCreateDEItem, bl);
    }

    protected void onSyncIndexEntities(PSUWCreateDEItem pSUWCreateDEItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSUWCreateDEItem, bl);
    }

    public Object getDataContextValue(PSUWCreateDEItem pSUWCreateDEItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSUWCreateDEItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSUWCreateDE pSUWCreateDE = pSUWCreateDEItem.getPSUWCreateDE();
        if (pSUWCreateDE != null && pSUWCreateDE.contains(string)) {
            return pSUWCreateDE.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSUWCreateDEItem pSUWCreateDEItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSUWCreateDEItem, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"ITEMPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWDETABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewDETableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUWCREATEDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUWCreateDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUWCREATEDEITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUWCreateDEItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUWCREATEDEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUWCreateDEItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_ItemParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NewCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWCODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWDELOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWDENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewDETableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWDETABLENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWDEVIEWNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUWCreateDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUWCREATEDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUWCreateDEItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUWCREATEDEITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUWCreateDEItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUWCREATEDEITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSUWCreateDEItem pSUWCreateDEItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSUWCreateDEItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUWCreateDEItem pSUWCreateDEItem) throws Exception {
        super.onUpdateParent(pSUWCreateDEItem);
    }

    @Override
    protected void exportCurXmlModel(PSUWCreateDEItem pSUWCreateDEItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUWCREATEDEITEM");
        if (!bl) {
            pSUWCreateDEItem.setCreateDate(null);
            pSUWCreateDEItem.setCreateMan(null);
            pSUWCreateDEItem.setPSUWCreateDEItemId(null);
            pSUWCreateDEItem.setUpdateDate(null);
            pSUWCreateDEItem.setUpdateMan(null);
            super.exportCurXmlModel(pSUWCreateDEItem, xmlNode, bl);
        }
    }
}

