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
package net.ibizsys.pscore.srv.helpdesign.service;

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
import net.ibizsys.pscore.srv.helpdesign.dao.PSHelpModArtDAO;
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpModArtDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticleBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModArt;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModuleBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpModArtServiceBase
extends PSCoreSysServiceBase<PSHelpModArt> {
    private static final Log log = LogFactory.getLog(PSHelpModArtServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSHelpModArtDEModel pSHelpModArtDEModel;
    private PSHelpModArtDAO pSHelpModArtDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.helpdesign.service.PSHelpModArtService";
    }

    public PSHelpModArtDEModel getPSHelpModArtDEModel() {
        if (this.pSHelpModArtDEModel == null) {
            try {
                this.pSHelpModArtDEModel = (PSHelpModArtDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpModArtDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpModArtDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpModArtDEModel();
    }

    public PSHelpModArtDAO getPSHelpModArtDAO() {
        if (this.pSHelpModArtDAO == null) {
            try {
                this.pSHelpModArtDAO = (PSHelpModArtDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.helpdesign.dao.PSHelpModArtDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpModArtDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpModArtDAO();
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

    protected void onFillParentInfo(PSHelpModArt pSHelpModArt, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPMODART_PSHELPARTICLE_PSHELPARTICLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService", (SessionFactory)this.getSessionFactory());
            PSHelpArticle pSHelpArticle = (PSHelpArticle)iService.getDEModel().createEntity();
            pSHelpArticle.set("PSHELPARTICLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpArticle);
            } else {
                iService.get(pSHelpArticle);
            }
            this.onFillParentInfo_PSHelpArticle(pSHelpModArt, pSHelpArticle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPMODART_PSHELPMODULE_PSHELPMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService", (SessionFactory)this.getSessionFactory());
            PSHelpModule pSHelpModule = (PSHelpModule)iService.getDEModel().createEntity();
            pSHelpModule.set("PSHELPMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpModule);
            } else {
                iService.get(pSHelpModule);
            }
            this.onFillParentInfo_PSHelpModule(pSHelpModArt, pSHelpModule);
            return;
        }
        super.onFillParentInfo(pSHelpModArt, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSHelpArticle(PSHelpModArt pSHelpModArt, PSHelpArticle pSHelpArticle) throws Exception {
        pSHelpModArt.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
        pSHelpModArt.setPSHelpArticleName(pSHelpArticle.getPSHelpArticleName());
    }

    protected void onFillParentInfo_PSHelpModule(PSHelpModArt pSHelpModArt, PSHelpModule pSHelpModule) throws Exception {
        pSHelpModArt.setPSHelpModuleId(pSHelpModule.getPSHelpModuleId());
        pSHelpModArt.setPSHelpModuleName(pSHelpModule.getPSHelpModuleName());
    }

    protected void onFillEntityFullInfo(PSHelpModArt pSHelpModArt, boolean bl) throws Exception {
        if (bl && pSHelpModArt.getValidFlag() == null) {
            pSHelpModArt.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSHelpModArt, bl);
        this.onFillEntityFullInfo_PSHelpArticle(pSHelpModArt, bl);
        this.onFillEntityFullInfo_PSHelpModule(pSHelpModArt, bl);
    }

    protected void onFillEntityFullInfo_PSHelpArticle(PSHelpModArt pSHelpModArt, boolean bl) throws Exception {
        if (pSHelpModArt.isPSHelpArticleIdDirty()) {
            if (pSHelpModArt.getPSHelpArticleId() != null) {
                if (pSHelpModArt.getPSHelpArticleId() == null || pSHelpModArt.getPSHelpArticleName() == null) {
                    PSHelpArticle pSHelpArticle = pSHelpModArt.getPSHelpArticle();
                    pSHelpModArt.setPSHelpArticleName(pSHelpArticle.getPSHelpArticleName());
                }
            } else {
                pSHelpModArt.setPSHelpArticleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSHelpModule(PSHelpModArt pSHelpModArt, boolean bl) throws Exception {
        if (pSHelpModArt.isPSHelpModuleIdDirty()) {
            if (pSHelpModArt.getPSHelpModuleId() != null) {
                if (pSHelpModArt.getPSHelpModuleId() == null || pSHelpModArt.getPSHelpModuleName() == null) {
                    PSHelpModule pSHelpModule = pSHelpModArt.getPSHelpModule();
                    pSHelpModArt.setPSHelpModuleName(pSHelpModule.getPSHelpModuleName());
                }
            } else {
                pSHelpModArt.setPSHelpModuleName(null);
            }
        }
    }

    protected void onWriteBackParent(PSHelpModArt pSHelpModArt, boolean bl) throws Exception {
        super.onWriteBackParent(pSHelpModArt, bl);
    }

    public ArrayList<PSHelpModArt> selectByPSHelpArticle(PSHelpArticleBase pSHelpArticleBase) throws Exception {
        return this.selectByPSHelpArticle(pSHelpArticleBase, "", -1);
    }

    public ArrayList<PSHelpModArt> selectByPSHelpArticle(PSHelpArticleBase pSHelpArticleBase, String string) throws Exception {
        return this.selectByPSHelpArticle(pSHelpArticleBase, string, -1);
    }

    public ArrayList<PSHelpModArt> selectByPSHelpArticle(PSHelpArticleBase pSHelpArticleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPARTICLEID", (Object)pSHelpArticleBase.getPSHelpArticleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpArticleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpArticleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpModArt> selectByPSHelpModule(PSHelpModuleBase pSHelpModuleBase) throws Exception {
        return this.selectByPSHelpModule(pSHelpModuleBase, "", -1);
    }

    public ArrayList<PSHelpModArt> selectByPSHelpModule(PSHelpModuleBase pSHelpModuleBase, String string) throws Exception {
        return this.selectByPSHelpModule(pSHelpModuleBase, string, -1);
    }

    public ArrayList<PSHelpModArt> selectByPSHelpModule(PSHelpModuleBase pSHelpModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPMODULEID", (Object)pSHelpModuleBase.getPSHelpModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpModuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpModArt> arrayList = this.selectByPSHelpArticle(pSHelpArticle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPARTICLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpArticle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPMODART_PSHELPARTICLE_PSHELPARTICLEID", "", iDataEntityModel.getName(), "PSHELPMODART", iDataEntityModel.getDataInfo(pSHelpArticle), arrayList.get(0)));
        }
    }

    public void resetPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpModArt> arrayList = this.selectByPSHelpArticle(pSHelpArticle);
        for (PSHelpModArt pSHelpModArt : arrayList) {
            PSHelpModArt pSHelpModArt2 = (PSHelpModArt)this.getDEModel().createEntity();
            pSHelpModArt2.setPSHelpModArtId(pSHelpModArt.getPSHelpModArtId());
            pSHelpModArt2.setPSHelpArticleId(null);
            this.update(pSHelpModArt2);
        }
    }

    public void removeByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        final PSHelpArticle pSHelpArticle2 = pSHelpArticle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpModArtServiceBase.this.onBeforeRemoveByPSHelpArticle(pSHelpArticle2);
                PSHelpModArtServiceBase.this.internalRemoveByPSHelpArticle(pSHelpArticle2);
                PSHelpModArtServiceBase.this.onAfterRemoveByPSHelpArticle(pSHelpArticle2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
    }

    protected void internalRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpModArt> arrayList = this.selectByPSHelpArticle(pSHelpArticle);
        this.onBeforeRemoveByPSHelpArticle(pSHelpArticle, arrayList);
        for (PSHelpModArt pSHelpModArt : arrayList) {
            this.remove(pSHelpModArt);
        }
        this.onAfterRemoveByPSHelpArticle(pSHelpArticle, arrayList);
    }

    protected void onAfterRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle, ArrayList<PSHelpModArt> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle, ArrayList<PSHelpModArt> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    public void resetPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<PSHelpModArt> arrayList = this.selectByPSHelpModule(pSHelpModule);
        for (PSHelpModArt pSHelpModArt : arrayList) {
            PSHelpModArt pSHelpModArt2 = (PSHelpModArt)this.getDEModel().createEntity();
            pSHelpModArt2.setPSHelpModArtId(pSHelpModArt.getPSHelpModArtId());
            pSHelpModArt2.setPSHelpModuleId(null);
            this.update(pSHelpModArt2);
        }
    }

    public void removeByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        final PSHelpModule pSHelpModule2 = pSHelpModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpModArtServiceBase.this.onBeforeRemoveByPSHelpModule(pSHelpModule2);
                PSHelpModArtServiceBase.this.internalRemoveByPSHelpModule(pSHelpModule2);
                PSHelpModArtServiceBase.this.onAfterRemoveByPSHelpModule(pSHelpModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    protected void internalRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<PSHelpModArt> arrayList = this.selectByPSHelpModule(pSHelpModule);
        this.onBeforeRemoveByPSHelpModule(pSHelpModule, arrayList);
        for (PSHelpModArt pSHelpModArt : arrayList) {
            this.remove(pSHelpModArt);
        }
        this.onAfterRemoveByPSHelpModule(pSHelpModule, arrayList);
    }

    protected void onAfterRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpModule(PSHelpModule pSHelpModule, ArrayList<PSHelpModArt> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpModule(PSHelpModule pSHelpModule, ArrayList<PSHelpModArt> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpModArt pSHelpModArt) throws Exception {
        super.onBeforeRemove(pSHelpModArt);
    }

    protected void replaceParentInfo(PSHelpModArt pSHelpModArt, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSHelpModArt, cloneSession);
        if (pSHelpModArt.getPSHelpArticleId() != null && (iEntity = cloneSession.getEntity("PSHELPARTICLE", (Object)pSHelpModArt.getPSHelpArticleId())) != null) {
            this.onFillParentInfo_PSHelpArticle(pSHelpModArt, (PSHelpArticle)iEntity);
        }
        if (pSHelpModArt.getPSHelpModuleId() != null && (iEntity = cloneSession.getEntity("PSHELPMODULE", (Object)pSHelpModArt.getPSHelpModuleId())) != null) {
            this.onFillParentInfo_PSHelpModule(pSHelpModArt, (PSHelpModule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpModArt pSHelpModArt, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSHelpModArt, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSHelpModArt, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModArtParam(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModArtParam2(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleId(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleName(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpModArtId(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpModArtName(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpModuleId(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpModuleName(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSHelpModArt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSHelpModArt, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isCodeNameDirty() : !pSHelpModArt.isCodeNameDirty()) {
            return null;
        }
        String string = pSHelpModArt.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSHelpModArt, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isMemoDirty() : !pSHelpModArt.isMemoDirty()) {
            return null;
        }
        String string = pSHelpModArt.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSHelpModArt, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModArtParam(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isModArtParamDirty() : !pSHelpModArt.isModArtParamDirty()) {
            return null;
        }
        String string = pSHelpModArt.getModArtParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModArtParam_Default(pSHelpModArt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODARTPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModArtParam2(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isModArtParam2Dirty() : !pSHelpModArt.isModArtParam2Dirty()) {
            return null;
        }
        String string = pSHelpModArt.getModArtParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModArtParam2_Default(pSHelpModArt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODARTPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isOrderValueDirty() : !pSHelpModArt.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSHelpModArt.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSHelpModArt, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpArticleId(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isPSHelpArticleIdDirty() : !pSHelpModArt.isPSHelpArticleIdDirty()) {
            return null;
        }
        String string = pSHelpModArt.getPSHelpArticleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleId_Default(pSHelpModArt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArticleName(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isPSHelpArticleNameDirty() : !pSHelpModArt.isPSHelpArticleNameDirty()) {
            return null;
        }
        String string = pSHelpModArt.getPSHelpArticleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleName_Default(pSHelpModArt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpModArtId(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isPSHelpModArtIdDirty() && !bl2 : !pSHelpModArt.isPSHelpModArtIdDirty()) {
            return null;
        }
        String string = pSHelpModArt.getPSHelpModArtId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODARTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpModArtId_Default(pSHelpModArt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpModArtName(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isPSHelpModArtNameDirty() && !bl2 : !pSHelpModArt.isPSHelpModArtNameDirty()) {
            return null;
        }
        String string = pSHelpModArt.getPSHelpModArtName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODARTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpModArtName_Default(pSHelpModArt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpModuleId(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isPSHelpModuleIdDirty() : !pSHelpModArt.isPSHelpModuleIdDirty()) {
            return null;
        }
        String string = pSHelpModArt.getPSHelpModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpModuleId_Default(pSHelpModArt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpModuleName(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isPSHelpModuleNameDirty() : !pSHelpModArt.isPSHelpModuleNameDirty()) {
            return null;
        }
        String string = pSHelpModArt.getPSHelpModuleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpModuleName_Default(pSHelpModArt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODULENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isUserCatDirty() : !pSHelpModArt.isUserCatDirty()) {
            return null;
        }
        String string = pSHelpModArt.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSHelpModArt, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isUserTagDirty() : !pSHelpModArt.isUserTagDirty()) {
            return null;
        }
        String string = pSHelpModArt.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSHelpModArt, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isUserTag2Dirty() : !pSHelpModArt.isUserTag2Dirty()) {
            return null;
        }
        String string = pSHelpModArt.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSHelpModArt, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isUserTag3Dirty() : !pSHelpModArt.isUserTag3Dirty()) {
            return null;
        }
        String string = pSHelpModArt.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSHelpModArt, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isUserTag4Dirty() : !pSHelpModArt.isUserTag4Dirty()) {
            return null;
        }
        String string = pSHelpModArt.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSHelpModArt, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSHelpModArt pSHelpModArt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModArt.isValidFlagDirty() && !bl2 : !pSHelpModArt.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSHelpModArt.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSHelpModArt, bl2, bl3);
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

    protected void onSyncEntity(PSHelpModArt pSHelpModArt, boolean bl) throws Exception {
        super.onSyncEntity(pSHelpModArt, bl);
    }

    protected void onSyncIndexEntities(PSHelpModArt pSHelpModArt, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSHelpModArt, bl);
    }

    public Object getDataContextValue(PSHelpModArt pSHelpModArt, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSHelpModArt, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpModArt pSHelpModArt, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSHelpModArt, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODARTPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModArtParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODARTPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModArtParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModArtId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModArtName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModuleName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ModArtParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODARTPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModArtParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODARTPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSHelpArticleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpModArtId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPMODARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpModArtName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPMODARTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSHelpModArt pSHelpModArt) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSHelpModArt)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpModArt pSHelpModArt) throws Exception {
        super.onUpdateParent(pSHelpModArt);
    }

    @Override
    protected void exportCurXmlModel(PSHelpModArt pSHelpModArt, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPMODART");
        if (!bl) {
            pSHelpModArt.setCreateDate(null);
            pSHelpModArt.setCreateMan(null);
            pSHelpModArt.setPSHelpModArtId(null);
            pSHelpModArt.setUpdateDate(null);
            pSHelpModArt.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpModArt, xmlNode, bl);
        }
    }
}

