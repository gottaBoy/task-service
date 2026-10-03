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
package net.ibizsys.pscore.srv.wxdesign.service;

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
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wxdesign.dao.PSWXMenuFuncDAO;
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuFuncDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccountBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntAppBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicServiceBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXMenuFuncServiceBase
extends PSCoreSysServiceBase<PSWXMenuFunc> {
    private static final Log log = LogFactory.getLog(PSWXMenuFuncServiceBase.class);
    public static final String DATASET_CURWX = "CurWX";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWXMenuFuncDEModel pSWXMenuFuncDEModel;
    private PSWXMenuFuncDAO pSWXMenuFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService";
    }

    public PSWXMenuFuncDEModel getPSWXMenuFuncDEModel() {
        if (this.pSWXMenuFuncDEModel == null) {
            try {
                this.pSWXMenuFuncDEModel = (PSWXMenuFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXMenuFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWXMenuFuncDEModel();
    }

    public PSWXMenuFuncDAO getPSWXMenuFuncDAO() {
        if (this.pSWXMenuFuncDAO == null) {
            try {
                this.pSWXMenuFuncDAO = (PSWXMenuFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wxdesign.dao.PSWXMenuFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXMenuFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWXMenuFuncDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURWX, (boolean)true) == 0) {
            return this.fetchCurWX(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurWX(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWX, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSWXMenuFunc pSWXMenuFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENUFUNC_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory());
            PSWXAccount pSWXAccount = (PSWXAccount)iService.getDEModel().createEntity();
            pSWXAccount.set("PSWXACCOUNTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWXAccount);
            } else {
                iService.get(pSWXAccount);
            }
            this.onFillParentInfo_PSWXAccount(pSWXMenuFunc, pSWXAccount);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENUFUNC_PSWXENTAPP_PSWXENTAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService", (SessionFactory)this.getSessionFactory());
            PSWXEntApp pSWXEntApp = (PSWXEntApp)iService.getDEModel().createEntity();
            pSWXEntApp.set("PSWXENTAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWXEntApp);
            } else {
                iService.get(pSWXEntApp);
            }
            this.onFillParentInfo_PSWXEntApp(pSWXMenuFunc, pSWXEntApp);
            return;
        }
        super.onFillParentInfo(pSWXMenuFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSWXAccount(PSWXMenuFunc pSWXMenuFunc, PSWXAccount pSWXAccount) throws Exception {
        pSWXMenuFunc.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
        pSWXMenuFunc.setPSWXAccountName(pSWXAccount.getPSWXAccountName());
    }

    protected void onFillParentInfo_PSWXEntApp(PSWXMenuFunc pSWXMenuFunc, PSWXEntApp pSWXEntApp) throws Exception {
        pSWXMenuFunc.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
        pSWXMenuFunc.setPSWXEntAppName(pSWXEntApp.getPSWXEntAppName());
        if (pSWXEntApp.getPSWXAccount() != null) {
            this.onFillParentInfo_PSWXAccount(pSWXMenuFunc, pSWXEntApp.getPSWXAccount());
        }
    }

    protected void onFillEntityFullInfo(PSWXMenuFunc pSWXMenuFunc, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWXMenuFunc, bl);
        this.onFillEntityFullInfo_PSWXAccount(pSWXMenuFunc, bl);
        this.onFillEntityFullInfo_PSWXEntApp(pSWXMenuFunc, bl);
    }

    protected void onFillEntityFullInfo_PSWXAccount(PSWXMenuFunc pSWXMenuFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWXEntApp(PSWXMenuFunc pSWXMenuFunc, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWXMenuFunc pSWXMenuFunc, boolean bl) throws Exception {
        super.onWriteBackParent(pSWXMenuFunc, bl);
    }

    public ArrayList<PSWXMenuFunc> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, "", -1);
    }

    public ArrayList<PSWXMenuFunc> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, string, -1);
    }

    public ArrayList<PSWXMenuFunc> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWXACCOUNTID", (Object)pSWXAccountBase.getPSWXAccountId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWXAccountCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWXAccountCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWXMenuFunc> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase) throws Exception {
        return this.selectByPSWXEntApp(pSWXEntAppBase, "", -1);
    }

    public ArrayList<PSWXMenuFunc> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase, String string) throws Exception {
        return this.selectByPSWXEntApp(pSWXEntAppBase, string, -1);
    }

    public ArrayList<PSWXMenuFunc> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWXENTAPPID", (Object)pSWXEntAppBase.getPSWXEntAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWXEntAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWXEntAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    public void resetPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWXMenuFunc> arrayList = this.selectByPSWXAccount(pSWXAccount);
        for (PSWXMenuFunc pSWXMenuFunc : arrayList) {
            PSWXMenuFunc pSWXMenuFunc2 = (PSWXMenuFunc)this.getDEModel().createEntity();
            pSWXMenuFunc2.setPSWXMenuFuncId(pSWXMenuFunc.getPSWXMenuFuncId());
            pSWXMenuFunc2.setPSWXAccountId(null);
            this.update(pSWXMenuFunc2);
        }
    }

    public void removeByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        final PSWXAccount pSWXAccount2 = pSWXAccount;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuFuncServiceBase.this.onBeforeRemoveByPSWXAccount(pSWXAccount2);
                PSWXMenuFuncServiceBase.this.internalRemoveByPSWXAccount(pSWXAccount2);
                PSWXMenuFuncServiceBase.this.onAfterRemoveByPSWXAccount(pSWXAccount2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void internalRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWXMenuFunc> arrayList = this.selectByPSWXAccount(pSWXAccount);
        this.onBeforeRemoveByPSWXAccount(pSWXAccount, arrayList);
        for (PSWXMenuFunc pSWXMenuFunc : arrayList) {
            this.remove(pSWXMenuFunc);
        }
        this.onAfterRemoveByPSWXAccount(pSWXAccount, arrayList);
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWXMenuFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWXMenuFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
    }

    public void resetPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWXMenuFunc> arrayList = this.selectByPSWXEntApp(pSWXEntApp);
        for (PSWXMenuFunc pSWXMenuFunc : arrayList) {
            PSWXMenuFunc pSWXMenuFunc2 = (PSWXMenuFunc)this.getDEModel().createEntity();
            pSWXMenuFunc2.setPSWXMenuFuncId(pSWXMenuFunc.getPSWXMenuFuncId());
            pSWXMenuFunc2.setPSWXEntAppId(null);
            this.update(pSWXMenuFunc2);
        }
    }

    public void removeByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        final PSWXEntApp pSWXEntApp2 = pSWXEntApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuFuncServiceBase.this.onBeforeRemoveByPSWXEntApp(pSWXEntApp2);
                PSWXMenuFuncServiceBase.this.internalRemoveByPSWXEntApp(pSWXEntApp2);
                PSWXMenuFuncServiceBase.this.onAfterRemoveByPSWXEntApp(pSWXEntApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
    }

    protected void internalRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWXMenuFunc> arrayList = this.selectByPSWXEntApp(pSWXEntApp);
        this.onBeforeRemoveByPSWXEntApp(pSWXEntApp, arrayList);
        for (PSWXMenuFunc pSWXMenuFunc : arrayList) {
            this.remove(pSWXMenuFunc);
        }
        this.onAfterRemoveByPSWXEntApp(pSWXEntApp, arrayList);
    }

    protected void onAfterRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
    }

    protected void onBeforeRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp, ArrayList<PSWXMenuFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp, ArrayList<PSWXMenuFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSWXMenuFunc(pSWXMenuFunc);
        pSCoreSysServiceBase = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByPSWXMenuFunc(pSWXMenuFunc);
        super.onBeforeRemove(pSWXMenuFunc);
    }

    protected void replaceParentInfo(PSWXMenuFunc pSWXMenuFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWXMenuFunc, cloneSession);
        if (pSWXMenuFunc.getPSWXAccountId() != null && (iEntity = cloneSession.getEntity("PSWXACCOUNT", (Object)pSWXMenuFunc.getPSWXAccountId())) != null) {
            this.onFillParentInfo_PSWXAccount(pSWXMenuFunc, (PSWXAccount)iEntity);
        }
        if (pSWXMenuFunc.getPSWXEntAppId() != null && (iEntity = cloneSession.getEntity("PSWXENTAPP", (Object)pSWXMenuFunc.getPSWXEntAppId())) != null) {
            this.onFillParentInfo_PSWXEntApp(pSWXMenuFunc, (PSWXEntApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWXMenuFunc pSWXMenuFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWXMenuFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ClickTag(bl, pSWXMenuFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncType(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXAccountId(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXEntAppId(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuFuncId(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuFuncName(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewURL(bl, pSWXMenuFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWXMenuFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ClickTag(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isClickTagDirty() : !pSWXMenuFunc.isClickTagDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getClickTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClickTag_Default(pSWXMenuFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLICKTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isCodeNameDirty() : !pSWXMenuFunc.isCodeNameDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSWXMenuFunc, bl2, bl3);
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
                string3 = "PSWXENTAPPID";
                string3 = string3 + ";";
                string3 = string3 + "PSWXACCOUNTID";
                String string4 = this.checkFieldDupRule(this.getPSWXMenuFuncDEModel(), "CODENAME", string3, pSWXMenuFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_FuncType(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isFuncTypeDirty() && !bl2 : !pSWXMenuFunc.isFuncTypeDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getFuncType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncType_Default(pSWXMenuFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isMemoDirty() : !pSWXMenuFunc.isMemoDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWXMenuFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXAccountId(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isPSWXAccountIdDirty() && !bl2 : !pSWXMenuFunc.isPSWXAccountIdDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getPSWXAccountId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXACCOUNTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXAccountId_Default(pSWXMenuFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXACCOUNTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXEntAppId(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isPSWXEntAppIdDirty() : !pSWXMenuFunc.isPSWXEntAppIdDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getPSWXEntAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXEntAppId_Default(pSWXMenuFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXENTAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuFuncId(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isPSWXMenuFuncIdDirty() && !bl2 : !pSWXMenuFunc.isPSWXMenuFuncIdDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getPSWXMenuFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuFuncId_Default(pSWXMenuFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuFuncName(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isPSWXMenuFuncNameDirty() && !bl2 : !pSWXMenuFunc.isPSWXMenuFuncNameDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getPSWXMenuFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuFuncName_Default(pSWXMenuFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isUserCatDirty() : !pSWXMenuFunc.isUserCatDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSWXMenuFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isUserTagDirty() : !pSWXMenuFunc.isUserTagDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSWXMenuFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isUserTag2Dirty() : !pSWXMenuFunc.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSWXMenuFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isUserTag3Dirty() : !pSWXMenuFunc.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSWXMenuFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isUserTag4Dirty() : !pSWXMenuFunc.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSWXMenuFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewURL(boolean bl, PSWXMenuFunc pSWXMenuFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuFunc.isViewURLDirty() : !pSWXMenuFunc.isViewURLDirty()) {
            return null;
        }
        String string = pSWXMenuFunc.getViewURL();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewURL_Default(pSWXMenuFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWXMenuFunc pSWXMenuFunc, boolean bl) throws Exception {
        super.onSyncEntity(pSWXMenuFunc, bl);
    }

    protected void onSyncIndexEntities(PSWXMenuFunc pSWXMenuFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWXMenuFunc, bl);
    }

    public Object getDataContextValue(PSWXMenuFunc pSWXMenuFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWXMenuFunc, string, iDataContextParam)) != null) {
            return object;
        }
        PSWXAccount pSWXAccount = pSWXMenuFunc.getPSWXAccount();
        if (pSWXAccount != null && pSWXAccount.contains(string)) {
            return pSWXAccount.get(string);
        }
        PSWXEntApp pSWXEntApp = pSWXMenuFunc.getPSWXEntApp();
        if (pSWXEntApp != null && pSWXEntApp.contains(string)) {
            return pSWXEntApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWXMenuFunc pSWXMenuFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWXMenuFunc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLICKTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClickTag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"FUNCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXACCOUNTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXAccountId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXACCOUNTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXAccountName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXENTAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXEntAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXENTAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXEntAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuFuncName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewURL_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ClickTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLICKTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_FuncType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCTYPE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXAccountId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXACCOUNTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXAccountName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXACCOUNTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXEntAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXENTAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXEntAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXENTAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXMenuFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXMenuFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ViewURL_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWURL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWXMenuFunc pSWXMenuFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWXMenuFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        IService iService;
        Object object = pSWXMenuFunc.get("PSWXACCOUNTID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWXMENUFUNC_PSWXACCOUNT_PSWXACCOUNTID", object);
        }
        if ((object = pSWXMenuFunc.get("PSWXENTAPPID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWXMENUFUNC_PSWXENTAPP_PSWXENTAPPID", object);
        }
        super.onUpdateParent(pSWXMenuFunc);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSWXMenuFunc pSWXMenuFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWXMENUFUNC");
        if (!bl) {
            pSWXMenuFunc.setCreateDate(null);
            pSWXMenuFunc.setCreateMan(null);
            pSWXMenuFunc.setPSWXMenuFuncId(null);
            pSWXMenuFunc.setUpdateDate(null);
            pSWXMenuFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSWXMenuFunc, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWXMenuFunc pSWXMenuFunc, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWXMenuFunc, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXENTAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWXENTAPP#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWXACCOUNT#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXENTAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWXMENUFUNC_PSWXENTAPP_PSWXENTAPPID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWXMENUFUNC_PSWXACCOUNT_PSWXACCOUNTID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXENTAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXENTAPPNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWXENTAPP", (boolean)true) == 0) {
            iEntity.set("PSWXENTAPPID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWXACCOUNT", (boolean)true) == 0) {
            iEntity.set("PSWXACCOUNTID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWXENTAPPID", "PSWXACCOUNTID"};
    }

    @Override
    public String getModelV2Tag(PSWXMenuFunc pSWXMenuFunc) {
        if (!StringHelper.isNullOrEmpty((String)pSWXMenuFunc.getCodeName())) {
            return pSWXMenuFunc.getCodeName();
        }
        return super.getModelV2Tag(pSWXMenuFunc);
    }

    @Override
    public boolean setModelV2Tag(PSWXMenuFunc pSWXMenuFunc, String string) {
        pSWXMenuFunc.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSWXENTAPPID", "");
        map.put("PSWXACCOUNTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWXMenuFunc pSWXMenuFunc, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWXMenuFunc.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWXMenuFunc, true);
        pSWXMenuFunc.set("CODENAME", string);
        if (this.select(pSWXMenuFunc, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWXMenuFunc, true);
        return super.getModelV2Entity(pSWXMenuFunc, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWXMenuFunc pSWXMenuFunc, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWXMenuFunc, objectNode, string, string2, n);
    }
}

