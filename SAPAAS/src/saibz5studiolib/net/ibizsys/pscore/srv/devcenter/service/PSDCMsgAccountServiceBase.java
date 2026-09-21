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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCMsgAccountDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMsgAccountDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMsgAccount;
import net.ibizsys.pscore.srv.sysrt.entity.PSDCOrgUser;
import net.ibizsys.pscore.srv.sysrt.entity.PSDCOrgUserBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMsgAccountServiceBase
extends PSCoreSysServiceBase<PSDCMsgAccount> {
    private static final Log log = LogFactory.getLog(PSDCMsgAccountServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCMsgAccountDEModel pSDCMsgAccountDEModel;
    private PSDCMsgAccountDAO pSDCMsgAccountDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMsgAccountService";
    }

    public PSDCMsgAccountDEModel getPSDCMsgAccountDEModel() {
        if (this.pSDCMsgAccountDEModel == null) {
            try {
                this.pSDCMsgAccountDEModel = (PSDCMsgAccountDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMsgAccountDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMsgAccountDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCMsgAccountDEModel();
    }

    public PSDCMsgAccountDAO getPSDCMsgAccountDAO() {
        if (this.pSDCMsgAccountDAO == null) {
            try {
                this.pSDCMsgAccountDAO = (PSDCMsgAccountDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCMsgAccountDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMsgAccountDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCMsgAccountDAO();
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

    protected void onFillParentInfo(PSDCMsgAccount pSDCMsgAccount, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSGACCOUNT_PSDCORGUSER_PSDCORGUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysrt.service.PSDCOrgUserService", (SessionFactory)this.getSessionFactory());
            PSDCOrgUser pSDCOrgUser = (PSDCOrgUser)iService.getDEModel().createEntity();
            pSDCOrgUser.set("PSDCORGUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCOrgUser);
            } else {
                iService.get((IEntity)pSDCOrgUser);
            }
            this.onFillParentInfo_PSDCOrgUser(pSDCMsgAccount, pSDCOrgUser);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCMsgAccount, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCOrgUser(PSDCMsgAccount pSDCMsgAccount, PSDCOrgUser pSDCOrgUser) throws Exception {
        pSDCMsgAccount.setPSDCOrgUserId(pSDCOrgUser.getPSDCOrgUserId());
        pSDCMsgAccount.setPSDCOrgUserName(pSDCOrgUser.getPSDCOrgUserName());
    }

    protected void onFillEntityFullInfo(PSDCMsgAccount pSDCMsgAccount, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDCMsgAccount, bl);
        this.onFillEntityFullInfo_PSDCOrgUser(pSDCMsgAccount, bl);
    }

    protected void onFillEntityFullInfo_PSDCOrgUser(PSDCMsgAccount pSDCMsgAccount, boolean bl) throws Exception {
        if (pSDCMsgAccount.isPSDCOrgUserIdDirty()) {
            if (pSDCMsgAccount.getPSDCOrgUserId() != null) {
                if (pSDCMsgAccount.getPSDCOrgUserId() == null || pSDCMsgAccount.getPSDCOrgUserName() == null) {
                    PSDCOrgUser pSDCOrgUser = pSDCMsgAccount.getPSDCOrgUser();
                    pSDCMsgAccount.setPSDCOrgUserName(pSDCOrgUser.getPSDCOrgUserName());
                }
            } else {
                pSDCMsgAccount.setPSDCOrgUserName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCMsgAccount pSDCMsgAccount, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCMsgAccount, bl);
    }

    public ArrayList<PSDCMsgAccount> selectByPSDCOrgUser(PSDCOrgUserBase pSDCOrgUserBase) throws Exception {
        return this.selectByPSDCOrgUser(pSDCOrgUserBase, "", -1);
    }

    public ArrayList<PSDCMsgAccount> selectByPSDCOrgUser(PSDCOrgUserBase pSDCOrgUserBase, String string) throws Exception {
        return this.selectByPSDCOrgUser(pSDCOrgUserBase, string, -1);
    }

    public ArrayList<PSDCMsgAccount> selectByPSDCOrgUser(PSDCOrgUserBase pSDCOrgUserBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCORGUSERID", (Object)pSDCOrgUserBase.getPSDCOrgUserId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCOrgUserCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCOrgUserCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCOrgUser(PSDCOrgUser pSDCOrgUser) throws Exception {
        ArrayList<PSDCMsgAccount> arrayList = this.selectByPSDCOrgUser(pSDCOrgUser, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCORGUSER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCOrgUser);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSGACCOUNT_PSDCORGUSER_PSDCORGUSERID", "", iDataEntityModel.getName(), "PSDCMSGACCOUNT", iDataEntityModel.getDataInfo((IEntity)pSDCOrgUser), arrayList.get(0)));
        }
    }

    public void resetPSDCOrgUser(PSDCOrgUser pSDCOrgUser) throws Exception {
        ArrayList<PSDCMsgAccount> arrayList = this.selectByPSDCOrgUser(pSDCOrgUser);
        for (PSDCMsgAccount pSDCMsgAccount : arrayList) {
            PSDCMsgAccount pSDCMsgAccount2 = (PSDCMsgAccount)this.getDEModel().createEntity();
            pSDCMsgAccount2.setPSDCMsgAccountId(pSDCMsgAccount.getPSDCMsgAccountId());
            pSDCMsgAccount2.setPSDCOrgUserId(null);
            this.update(pSDCMsgAccount2);
        }
    }

    public void removeByPSDCOrgUser(PSDCOrgUser pSDCOrgUser) throws Exception {
        final PSDCOrgUser pSDCOrgUser2 = pSDCOrgUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMsgAccountServiceBase.this.onBeforeRemoveByPSDCOrgUser(pSDCOrgUser2);
                PSDCMsgAccountServiceBase.this.internalRemoveByPSDCOrgUser(pSDCOrgUser2);
                PSDCMsgAccountServiceBase.this.onAfterRemoveByPSDCOrgUser(pSDCOrgUser2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCOrgUser(PSDCOrgUser pSDCOrgUser) throws Exception {
    }

    protected void internalRemoveByPSDCOrgUser(PSDCOrgUser pSDCOrgUser) throws Exception {
        ArrayList<PSDCMsgAccount> arrayList = this.selectByPSDCOrgUser(pSDCOrgUser);
        this.onBeforeRemoveByPSDCOrgUser(pSDCOrgUser, arrayList);
        for (PSDCMsgAccount pSDCMsgAccount : arrayList) {
            this.remove((IEntity)pSDCMsgAccount);
        }
        this.onAfterRemoveByPSDCOrgUser(pSDCOrgUser, arrayList);
    }

    protected void onAfterRemoveByPSDCOrgUser(PSDCOrgUser pSDCOrgUser) throws Exception {
    }

    protected void onBeforeRemoveByPSDCOrgUser(PSDCOrgUser pSDCOrgUser, ArrayList<PSDCMsgAccount> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCOrgUser(PSDCOrgUser pSDCOrgUser, ArrayList<PSDCMsgAccount> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCMsgAccount pSDCMsgAccount) throws Exception {
        super.onBeforeRemove(pSDCMsgAccount);
    }

    protected void replaceParentInfo(PSDCMsgAccount pSDCMsgAccount, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCMsgAccount, cloneSession);
        if (pSDCMsgAccount.getPSDCOrgUserId() != null && (iEntity = cloneSession.getEntity("PSDCORGUSER", (Object)pSDCMsgAccount.getPSDCOrgUserId())) != null) {
            this.onFillParentInfo_PSDCOrgUser(pSDCMsgAccount, (PSDCOrgUser)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCMsgAccount pSDCMsgAccount, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCMsgAccount, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCMsgAccount pSDCMsgAccount, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDCMsgAccountId(bl, pSDCMsgAccount, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMsgAccountName(bl, pSDCMsgAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCOrgUserId(bl, pSDCMsgAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCOrgUserName(bl, pSDCMsgAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCMsgAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCMsgAccount, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDCMsgAccountId(boolean bl, PSDCMsgAccount pSDCMsgAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMsgAccount.isPSDCMsgAccountIdDirty() && !bl2 : !pSDCMsgAccount.isPSDCMsgAccountIdDirty()) {
            return null;
        }
        String string = pSDCMsgAccount.getPSDCMsgAccountId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSGACCOUNTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMsgAccountId_Default((IEntity)pSDCMsgAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSGACCOUNTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMsgAccountName(boolean bl, PSDCMsgAccount pSDCMsgAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMsgAccount.isPSDCMsgAccountNameDirty() && !bl2 : !pSDCMsgAccount.isPSDCMsgAccountNameDirty()) {
            return null;
        }
        String string = pSDCMsgAccount.getPSDCMsgAccountName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSGACCOUNTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMsgAccountName_Default((IEntity)pSDCMsgAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSGACCOUNTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCOrgUserId(boolean bl, PSDCMsgAccount pSDCMsgAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMsgAccount.isPSDCOrgUserIdDirty() : !pSDCMsgAccount.isPSDCOrgUserIdDirty()) {
            return null;
        }
        String string = pSDCMsgAccount.getPSDCOrgUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCOrgUserId_Default((IEntity)pSDCMsgAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCORGUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCOrgUserName(boolean bl, PSDCMsgAccount pSDCMsgAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMsgAccount.isPSDCOrgUserNameDirty() : !pSDCMsgAccount.isPSDCOrgUserNameDirty()) {
            return null;
        }
        String string = pSDCMsgAccount.getPSDCOrgUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCOrgUserName_Default((IEntity)pSDCMsgAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCORGUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCMsgAccount pSDCMsgAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMsgAccount.isValidFlagDirty() && !bl2 : !pSDCMsgAccount.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCMsgAccount.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDCMsgAccount, bl2, bl3);
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

    protected void onSyncEntity(PSDCMsgAccount pSDCMsgAccount, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCMsgAccount, bl);
    }

    protected void onSyncIndexEntities(PSDCMsgAccount pSDCMsgAccount, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCMsgAccount, bl);
    }

    public Object getDataContextValue(PSDCMsgAccount pSDCMsgAccount, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCMsgAccount, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCMsgAccount pSDCMsgAccount, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCMsgAccount, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSGACCOUNTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMsgAccountId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSGACCOUNTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMsgAccountName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCORGUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCOrgUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCORGUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCOrgUserName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCMsgAccountId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSGACCOUNTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMsgAccountName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSGACCOUNTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCOrgUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCORGUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCOrgUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCORGUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCMsgAccount pSDCMsgAccount) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCMsgAccount)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCMsgAccount pSDCMsgAccount) throws Exception {
        super.onUpdateParent((IEntity)pSDCMsgAccount);
    }

    @Override
    protected void exportCurXmlModel(PSDCMsgAccount pSDCMsgAccount, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMSGACCOUNT");
        if (!bl) {
            pSDCMsgAccount.setCreateDate(null);
            pSDCMsgAccount.setCreateMan(null);
            pSDCMsgAccount.setPSDCMsgAccountId(null);
            pSDCMsgAccount.setUpdateDate(null);
            pSDCMsgAccount.setUpdateMan(null);
            super.exportCurXmlModel(pSDCMsgAccount, xmlNode, bl);
        }
    }
}

