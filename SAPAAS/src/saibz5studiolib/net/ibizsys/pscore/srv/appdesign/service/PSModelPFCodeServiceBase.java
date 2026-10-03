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
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSModelPFCodeDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSModelPFCodeDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSModelPFCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelPFCodeServiceBase
extends PSCoreSysServiceBase<PSModelPFCode> {
    private static final Log log = LogFactory.getLog(PSModelPFCodeServiceBase.class);
    public static final String DATASET_CURMODEL = "CurModel";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_LOCATECODE = "LocateCode";
    private PSModelPFCodeDEModel pSModelPFCodeDEModel;
    private PSModelPFCodeDAO pSModelPFCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSModelPFCodeService";
    }

    public PSModelPFCodeDEModel getPSModelPFCodeDEModel() {
        if (this.pSModelPFCodeDEModel == null) {
            try {
                this.pSModelPFCodeDEModel = (PSModelPFCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSModelPFCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelPFCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelPFCodeDEModel();
    }

    public PSModelPFCodeDAO getPSModelPFCodeDAO() {
        if (this.pSModelPFCodeDAO == null) {
            try {
                this.pSModelPFCodeDAO = (PSModelPFCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSModelPFCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelPFCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelPFCodeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURMODEL, (boolean)true) == 0) {
            return this.fetchCurModel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_LOCATECODE, (boolean)true) == 0) {
            this.locateCode((PSModelPFCode)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurModel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMODEL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void locateCode(PSModelPFCode pSModelPFCode) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_LOCATECODE, 0, pSModelPFCode, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSModelPFCode, ACTION_LOCATECODE);
        final PSModelPFCode pSModelPFCode2 = pSModelPFCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSModelPFCodeServiceBase.this.getService(), PSModelPFCodeServiceBase.ACTION_LOCATECODE, 40, pSModelPFCode2, null).getResult() != 1) {
                    PSModelPFCodeServiceBase.this.onLocateCode(pSModelPFCode2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_LOCATECODE, 99, pSModelPFCode, null);
        }
    }

    protected void onLocateCode(PSModelPFCode pSModelPFCode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[LocateCode]");
    }

    protected void onFillParentInfo(PSModelPFCode pSModelPFCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELPFCODE_PSPFPUBCODE_PSPFPUBCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubCodeService", (SessionFactory)this.getSessionFactory());
            PSPFPubCode pSPFPubCode = (PSPFPubCode)iService.getDEModel().createEntity();
            pSPFPubCode.set("PSPFPUBCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPubCode);
            } else {
                iService.get(pSPFPubCode);
            }
            this.onFillParentInfo_PSSFPubCode(pSModelPFCode, pSPFPubCode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELPFCODE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSModelPFCode, pSSysApp);
            return;
        }
        super.onFillParentInfo(pSModelPFCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFPubCode(PSModelPFCode pSModelPFCode, PSPFPubCode pSPFPubCode) throws Exception {
        pSModelPFCode.setPSPFPubCodeId(pSPFPubCode.getPSPFPubCodeId());
        pSModelPFCode.setPSPFPubCodeName(pSPFPubCode.getPSPFPubCodeName());
    }

    protected void onFillParentInfo_PSSysApp(PSModelPFCode pSModelPFCode, PSSysApp pSSysApp) throws Exception {
        pSModelPFCode.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSModelPFCode.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillEntityFullInfo(PSModelPFCode pSModelPFCode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSModelPFCode, bl);
        this.onFillEntityFullInfo_PSSFPubCode(pSModelPFCode, bl);
        this.onFillEntityFullInfo_PSSysApp(pSModelPFCode, bl);
    }

    protected void onFillEntityFullInfo_PSSFPubCode(PSModelPFCode pSModelPFCode, boolean bl) throws Exception {
        if (pSModelPFCode.isPSPFPubCodeIdDirty()) {
            if (pSModelPFCode.getPSPFPubCodeId() != null) {
                if (pSModelPFCode.getPSPFPubCodeId() == null || pSModelPFCode.getPSPFPubCodeName() == null) {
                    PSPFPubCode pSPFPubCode = pSModelPFCode.getPSSFPubCode();
                    pSModelPFCode.setPSPFPubCodeName(pSPFPubCode.getPSPFPubCodeName());
                }
            } else {
                pSModelPFCode.setPSPFPubCodeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp(PSModelPFCode pSModelPFCode, boolean bl) throws Exception {
        if (pSModelPFCode.isPSSysAppIdDirty()) {
            if (pSModelPFCode.getPSSysAppId() != null) {
                if (pSModelPFCode.getPSSysAppId() == null || pSModelPFCode.getPSSysAppName() == null) {
                    PSSysApp pSSysApp = pSModelPFCode.getPSSysApp();
                    pSModelPFCode.setPSSysAppName(pSSysApp.getPSSysAppName());
                }
            } else {
                pSModelPFCode.setPSSysAppName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelPFCode pSModelPFCode, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelPFCode, bl);
    }

    public ArrayList<PSModelPFCode> selectByPSSFPubCode(PSPFPubCodeBase pSPFPubCodeBase) throws Exception {
        return this.selectByPSSFPubCode(pSPFPubCodeBase, "", -1);
    }

    public ArrayList<PSModelPFCode> selectByPSSFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string) throws Exception {
        return this.selectByPSSFPubCode(pSPFPubCodeBase, string, -1);
    }

    public ArrayList<PSModelPFCode> selectByPSSFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPUBCODEID", (Object)pSPFPubCodeBase.getPSPFPubCodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFPubCodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFPubCodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelPFCode> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSModelPFCode> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSModelPFCode> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    public void resetPSSFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSModelPFCode> arrayList = this.selectByPSSFPubCode(pSPFPubCode);
        for (PSModelPFCode pSModelPFCode : arrayList) {
            PSModelPFCode pSModelPFCode2 = (PSModelPFCode)this.getDEModel().createEntity();
            pSModelPFCode2.setPSModelPFCodeId(pSModelPFCode.getPSModelPFCodeId());
            pSModelPFCode2.setPSPFPubCodeId(null);
            this.update(pSModelPFCode2);
        }
    }

    public void removeByPSSFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        final PSPFPubCode pSPFPubCode2 = pSPFPubCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelPFCodeServiceBase.this.onBeforeRemoveByPSSFPubCode(pSPFPubCode2);
                PSModelPFCodeServiceBase.this.internalRemoveByPSSFPubCode(pSPFPubCode2);
                PSModelPFCodeServiceBase.this.onAfterRemoveByPSSFPubCode(pSPFPubCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void internalRemoveByPSSFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSModelPFCode> arrayList = this.selectByPSSFPubCode(pSPFPubCode);
        this.onBeforeRemoveByPSSFPubCode(pSPFPubCode, arrayList);
        for (PSModelPFCode pSModelPFCode : arrayList) {
            this.remove(pSModelPFCode);
        }
        this.onAfterRemoveByPSSFPubCode(pSPFPubCode, arrayList);
    }

    protected void onAfterRemoveByPSSFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSModelPFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSModelPFCode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSModelPFCode> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSModelPFCode pSModelPFCode : arrayList) {
            PSModelPFCode pSModelPFCode2 = (PSModelPFCode)this.getDEModel().createEntity();
            pSModelPFCode2.setPSModelPFCodeId(pSModelPFCode.getPSModelPFCodeId());
            pSModelPFCode2.setPSSysAppId(null);
            this.update(pSModelPFCode2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelPFCodeServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSModelPFCodeServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSModelPFCodeServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSModelPFCode> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSModelPFCode pSModelPFCode : arrayList) {
            this.remove(pSModelPFCode);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSModelPFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSModelPFCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelPFCode pSModelPFCode) throws Exception {
        super.onBeforeRemove(pSModelPFCode);
    }

    protected void replaceParentInfo(PSModelPFCode pSModelPFCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelPFCode, cloneSession);
        if (pSModelPFCode.getPSPFPubCodeId() != null && (iEntity = cloneSession.getEntity("PSPFPUBCODE", (Object)pSModelPFCode.getPSPFPubCodeId())) != null) {
            this.onFillParentInfo_PSSFPubCode(pSModelPFCode, (PSPFPubCode)iEntity);
        }
        if (pSModelPFCode.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSModelPFCode.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSModelPFCode, (PSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelPFCode pSModelPFCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelPFCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeMode(bl, pSModelPFCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodePath(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodePkgName(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomFlag(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjFolder(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjName(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelPFCodeId(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelPFCodeName(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelType(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeId(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeName(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubCode(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCode(bl, pSModelPFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelPFCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeMode(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isCodeModeDirty() : !pSModelPFCode.isCodeModeDirty()) {
            return null;
        }
        String string = pSModelPFCode.getCodeMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeMode_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodePath(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isCodePathDirty() : !pSModelPFCode.isCodePathDirty()) {
            return null;
        }
        String string = pSModelPFCode.getCodePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePath_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodePkgName(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isCodePkgNameDirty() : !pSModelPFCode.isCodePkgNameDirty()) {
            return null;
        }
        String string = pSModelPFCode.getCodePkgName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePkgName_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomFlag(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isCustomFlagDirty() : !pSModelPFCode.isCustomFlagDirty()) {
            return null;
        }
        Integer n = pSModelPFCode.getCustomFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomFlag_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isMemoDirty() : !pSModelPFCode.isMemoDirty()) {
            return null;
        }
        String string = pSModelPFCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelPFCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PrjFolder(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPrjFolderDirty() : !pSModelPFCode.isPrjFolderDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPrjFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjFolder_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrjName(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPrjNameDirty() : !pSModelPFCode.isPrjNameDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPrjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjName_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPSModelIdDirty() : !pSModelPFCode.isPSModelIdDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPSModelNameDirty() : !pSModelPFCode.isPSModelNameDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelPFCodeId(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPSModelPFCodeIdDirty() && !bl2 : !pSModelPFCode.isPSModelPFCodeIdDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPSModelPFCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELPFCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelPFCodeId_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELPFCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelPFCodeName(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPSModelPFCodeNameDirty() : !pSModelPFCode.isPSModelPFCodeNameDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPSModelPFCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelPFCodeName_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELPFCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelType(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPSModelTypeDirty() : !pSModelPFCode.isPSModelTypeDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPSModelType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelType_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubCodeId(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPSPFPubCodeIdDirty() : !pSModelPFCode.isPSPFPubCodeIdDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPSPFPubCodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeId_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubCodeName(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPSPFPubCodeNameDirty() : !pSModelPFCode.isPSPFPubCodeNameDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPSPFPubCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeName_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPSSysAppIdDirty() : !pSModelPFCode.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPSSysAppNameDirty() : !pSModelPFCode.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPSSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubCode(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isPubCodeDirty() : !pSModelPFCode.isPubCodeDirty()) {
            return null;
        }
        String string = pSModelPFCode.getPubCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubCode_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCode(boolean bl, PSModelPFCode pSModelPFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPFCode.isUserCodeDirty() : !pSModelPFCode.isUserCodeDirty()) {
            return null;
        }
        String string = pSModelPFCode.getUserCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCode_Default(pSModelPFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelPFCode pSModelPFCode, boolean bl) throws Exception {
        super.onSyncEntity(pSModelPFCode, bl);
    }

    protected void onSyncIndexEntities(PSModelPFCode pSModelPFCode, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelPFCode, bl);
    }

    public Object getDataContextValue(PSModelPFCode pSModelPFCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelPFCode, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelPFCode pSModelPFCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelPFCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodePkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELPFCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelPFCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELPFCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelPFCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCode_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodePkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEPKGNAME", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_CustomFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PrjFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJFOLDER", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelPFCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELPFCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelPFCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELPFCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_UserCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSModelPFCode pSModelPFCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelPFCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelPFCode pSModelPFCode) throws Exception {
        super.onUpdateParent(pSModelPFCode);
    }

    @Override
    protected void exportCurXmlModel(PSModelPFCode pSModelPFCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELPFCODE");
        if (!bl) {
            pSModelPFCode.setCodePath(null);
            pSModelPFCode.setCodePkgName(null);
            pSModelPFCode.setCreateDate(null);
            pSModelPFCode.setCreateMan(null);
            pSModelPFCode.setPSModelPFCodeId(null);
            pSModelPFCode.setPSModelPFCodeName(null);
            pSModelPFCode.setPSPFPubCodeName(null);
            pSModelPFCode.setPSSysAppName(null);
            pSModelPFCode.setPubCode(null);
            pSModelPFCode.setUpdateDate(null);
            pSModelPFCode.setUpdateMan(null);
            super.exportCurXmlModel(pSModelPFCode, xmlNode, bl);
        }
    }
}

