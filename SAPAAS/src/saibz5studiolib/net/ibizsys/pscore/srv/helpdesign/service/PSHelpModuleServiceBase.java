/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.helpdesign.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.ibizsys.paas.demodel.IDataEntityModel;
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
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityServiceBase;
import net.ibizsys.pscore.srv.helpdesign.dao.PSHelpModuleDAO;
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpModuleDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticleBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModuleBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpPrj;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpPrjBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModArtService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModArtServiceBase;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpModuleServiceBase
extends PSCoreSysServiceBase<PSHelpModule> {
    private static final Log log = LogFactory.getLog(PSHelpModuleServiceBase.class);
    public static final String DATASET_CURCHILD = "CurChild";
    public static final String DATASET_CURPRJ = "CurPrj";
    public static final String DATASET_CURPRJROOT = "CurPrjRoot";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_ROOT = "Root";
    public static final String DATASET_VALID = "Valid";
    public static final String DATASET_VALIDROOT = "ValidRoot";
    private PSHelpModuleDEModel pSHelpModuleDEModel;
    private PSHelpModuleDAO pSHelpModuleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService";
    }

    public PSHelpModuleDEModel getPSHelpModuleDEModel() {
        if (this.pSHelpModuleDEModel == null) {
            try {
                this.pSHelpModuleDEModel = (PSHelpModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpModuleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpModuleDEModel();
    }

    public PSHelpModuleDAO getPSHelpModuleDAO() {
        if (this.pSHelpModuleDAO == null) {
            try {
                this.pSHelpModuleDAO = (PSHelpModuleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.helpdesign.dao.PSHelpModuleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpModuleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpModuleDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURCHILD, (boolean)true) == 0) {
            return this.fetchCurChild(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPRJ, (boolean)true) == 0) {
            return this.fetchCurPrj(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPRJROOT, (boolean)true) == 0) {
            return this.fetchCurPrjRoot(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_ROOT, (boolean)true) == 0) {
            return this.fetchRoot(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALID, (boolean)true) == 0) {
            return this.fetchValid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALIDROOT, (boolean)true) == 0) {
            return this.fetchValidRoot(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurChild(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURCHILD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPrj(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPRJ, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPrjRoot(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPRJROOT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchRoot(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_ROOT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchValidRoot(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALIDROOT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSHelpModule pSHelpModule, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPMODULE_PSHELPARTICLE_PSHELPARTICLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService", (SessionFactory)this.getSessionFactory());
            PSHelpArticle pSHelpArticle = (PSHelpArticle)iService.getDEModel().createEntity();
            pSHelpArticle.set("PSHELPARTICLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpArticle);
            } else {
                iService.get(pSHelpArticle);
            }
            this.onFillParentInfo_PSHelpArticle(pSHelpModule, pSHelpArticle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPMODULE_PSHELPMODULE_PPSHELPMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService", (SessionFactory)this.getSessionFactory());
            PSHelpModule pSHelpModule2 = (PSHelpModule)iService.getDEModel().createEntity();
            pSHelpModule2.set("PSHELPMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpModule2);
            } else {
                iService.get(pSHelpModule2);
            }
            this.onFillParentInfo_PPSHelpModule(pSHelpModule, pSHelpModule2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPMODULE_PSHELPPRJ_PSHELPPRJID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpPrjService", (SessionFactory)this.getSessionFactory());
            PSHelpPrj pSHelpPrj = (PSHelpPrj)iService.getDEModel().createEntity();
            pSHelpPrj.set("PSHELPPRJID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpPrj);
            } else {
                iService.get(pSHelpPrj);
            }
            this.onFillParentInfo_PSHelpPrj(pSHelpModule, pSHelpPrj);
            return;
        }
        super.onFillParentInfo(pSHelpModule, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSHelpArticle(PSHelpModule pSHelpModule, PSHelpArticle pSHelpArticle) throws Exception {
        pSHelpModule.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
        pSHelpModule.setPSHelpArticleName(pSHelpArticle.getPSHelpArticleName());
    }

    protected void onFillParentInfo_PPSHelpModule(PSHelpModule pSHelpModule, PSHelpModule pSHelpModule2) throws Exception {
        pSHelpModule.setPPSHelpModuleId(pSHelpModule2.getPSHelpModuleId());
        pSHelpModule.setPPSHelpModuleName(pSHelpModule2.getPSHelpModuleName());
        if (pSHelpModule2.getPSHelpPrj() != null) {
            this.onFillParentInfo_PSHelpPrj(pSHelpModule, pSHelpModule2.getPSHelpPrj());
        }
    }

    protected void onFillParentInfo_PSHelpPrj(PSHelpModule pSHelpModule, PSHelpPrj pSHelpPrj) throws Exception {
        pSHelpModule.setPSHelpPrjId(pSHelpPrj.getPSHelpPrjId());
        pSHelpModule.setPSHelpPrjName(pSHelpPrj.getPSHelpPrjName());
    }

    protected void onFillEntityFullInfo(PSHelpModule pSHelpModule, boolean bl) throws Exception {
        if (bl && pSHelpModule.getValidFlag() == null) {
            pSHelpModule.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSHelpModule, bl);
        this.onFillEntityFullInfo_PSHelpArticle(pSHelpModule, bl);
        this.onFillEntityFullInfo_PPSHelpModule(pSHelpModule, bl);
        this.onFillEntityFullInfo_PSHelpPrj(pSHelpModule, bl);
    }

    protected void onFillEntityFullInfo_PSHelpArticle(PSHelpModule pSHelpModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSHelpModule(PSHelpModule pSHelpModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSHelpPrj(PSHelpModule pSHelpModule, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSHelpModule pSHelpModule, boolean bl) throws Exception {
        super.onWriteBackParent(pSHelpModule, bl);
    }

    public ArrayList<PSHelpModule> selectByPSHelpArticle(PSHelpArticleBase pSHelpArticleBase) throws Exception {
        return this.selectByPSHelpArticle(pSHelpArticleBase, "", -1);
    }

    public ArrayList<PSHelpModule> selectByPSHelpArticle(PSHelpArticleBase pSHelpArticleBase, String string) throws Exception {
        return this.selectByPSHelpArticle(pSHelpArticleBase, string, -1);
    }

    public ArrayList<PSHelpModule> selectByPSHelpArticle(PSHelpArticleBase pSHelpArticleBase, String string, int n) throws Exception {
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

    public ArrayList<PSHelpModule> selectByPPSHelpModule(PSHelpModuleBase pSHelpModuleBase) throws Exception {
        return this.selectByPPSHelpModule(pSHelpModuleBase, "", -1);
    }

    public ArrayList<PSHelpModule> selectByPPSHelpModule(PSHelpModuleBase pSHelpModuleBase, String string) throws Exception {
        return this.selectByPPSHelpModule(pSHelpModuleBase, string, -1);
    }

    public ArrayList<PSHelpModule> selectByPPSHelpModule(PSHelpModuleBase pSHelpModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSHELPMODULEID", (Object)pSHelpModuleBase.getPSHelpModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSHelpModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSHelpModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpModule> selectByPSHelpPrj(PSHelpPrjBase pSHelpPrjBase) throws Exception {
        return this.selectByPSHelpPrj(pSHelpPrjBase, "", -1);
    }

    public ArrayList<PSHelpModule> selectByPSHelpPrj(PSHelpPrjBase pSHelpPrjBase, String string) throws Exception {
        return this.selectByPSHelpPrj(pSHelpPrjBase, string, -1);
    }

    public ArrayList<PSHelpModule> selectByPSHelpPrj(PSHelpPrjBase pSHelpPrjBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPPRJID", (Object)pSHelpPrjBase.getPSHelpPrjId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpPrjCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpPrjCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpModule> arrayList = this.selectByPSHelpArticle(pSHelpArticle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPARTICLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpArticle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPMODULE_PSHELPARTICLE_PSHELPARTICLEID", "", iDataEntityModel.getName(), "PSHELPMODULE", iDataEntityModel.getDataInfo(pSHelpArticle), arrayList.get(0)));
        }
    }

    public void resetPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpModule> arrayList = this.selectByPSHelpArticle(pSHelpArticle);
        for (PSHelpModule pSHelpModule : arrayList) {
            PSHelpModule pSHelpModule2 = (PSHelpModule)this.getDEModel().createEntity();
            pSHelpModule2.setPSHelpModuleId(pSHelpModule.getPSHelpModuleId());
            pSHelpModule2.setPSHelpArticleId(null);
            this.update(pSHelpModule2);
        }
    }

    public void removeByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        final PSHelpArticle pSHelpArticle2 = pSHelpArticle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpModuleServiceBase.this.onBeforeRemoveByPSHelpArticle(pSHelpArticle2);
                PSHelpModuleServiceBase.this.internalRemoveByPSHelpArticle(pSHelpArticle2);
                PSHelpModuleServiceBase.this.onAfterRemoveByPSHelpArticle(pSHelpArticle2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
    }

    protected void internalRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpModule> arrayList = this.selectByPSHelpArticle(pSHelpArticle);
        this.onBeforeRemoveByPSHelpArticle(pSHelpArticle, arrayList);
        for (PSHelpModule pSHelpModule : arrayList) {
            this.remove(pSHelpModule);
        }
        this.onAfterRemoveByPSHelpArticle(pSHelpArticle, arrayList);
    }

    protected void onAfterRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle, ArrayList<PSHelpModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle, ArrayList<PSHelpModule> arrayList) throws Exception {
    }

    public void testRemoveByPPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    public void resetPPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<PSHelpModule> arrayList = this.selectByPPSHelpModule(pSHelpModule);
        for (PSHelpModule pSHelpModule2 : arrayList) {
            PSHelpModule pSHelpModule3 = (PSHelpModule)this.getDEModel().createEntity();
            pSHelpModule3.setPSHelpModuleId(pSHelpModule2.getPSHelpModuleId());
            pSHelpModule3.setPPSHelpModuleId(null);
            this.update(pSHelpModule3);
        }
    }

    public void removeByPPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        final PSHelpModule pSHelpModule2 = pSHelpModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpModuleServiceBase.this.onBeforeRemoveByPPSHelpModule(pSHelpModule2);
                PSHelpModuleServiceBase.this.internalRemoveByPPSHelpModule(pSHelpModule2);
                PSHelpModuleServiceBase.this.onAfterRemoveByPPSHelpModule(pSHelpModule2);
            }
        });
    }

    protected void onBeforeRemoveByPPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    protected void internalRemoveByPPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<PSHelpModule> arrayList = this.selectByPPSHelpModule(pSHelpModule);
        this.onBeforeRemoveByPPSHelpModule(pSHelpModule, arrayList);
        for (PSHelpModule pSHelpModule2 : arrayList) {
            this.remove(pSHelpModule2);
        }
        this.onAfterRemoveByPPSHelpModule(pSHelpModule, arrayList);
    }

    protected void onAfterRemoveByPPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    protected void onBeforeRemoveByPPSHelpModule(PSHelpModule pSHelpModule, ArrayList<PSHelpModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSHelpModule(PSHelpModule pSHelpModule, ArrayList<PSHelpModule> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpPrj(PSHelpPrj pSHelpPrj) throws Exception {
        ArrayList<PSHelpModule> arrayList = this.selectByPSHelpPrj(pSHelpPrj, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPPRJ");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpPrj);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPMODULE_PSHELPPRJ_PSHELPPRJID", "", iDataEntityModel.getName(), "PSHELPMODULE", iDataEntityModel.getDataInfo(pSHelpPrj), arrayList.get(0)));
        }
    }

    public void resetPSHelpPrj(PSHelpPrj pSHelpPrj) throws Exception {
        ArrayList<PSHelpModule> arrayList = this.selectByPSHelpPrj(pSHelpPrj);
        for (PSHelpModule pSHelpModule : arrayList) {
            PSHelpModule pSHelpModule2 = (PSHelpModule)this.getDEModel().createEntity();
            pSHelpModule2.setPSHelpModuleId(pSHelpModule.getPSHelpModuleId());
            pSHelpModule2.setPSHelpPrjId(null);
            this.update(pSHelpModule2);
        }
    }

    public void removeByPSHelpPrj(PSHelpPrj pSHelpPrj) throws Exception {
        final PSHelpPrj pSHelpPrj2 = pSHelpPrj;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpModuleServiceBase.this.onBeforeRemoveByPSHelpPrj(pSHelpPrj2);
                PSHelpModuleServiceBase.this.internalRemoveByPSHelpPrj(pSHelpPrj2);
                PSHelpModuleServiceBase.this.onAfterRemoveByPSHelpPrj(pSHelpPrj2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpPrj(PSHelpPrj pSHelpPrj) throws Exception {
    }

    protected void internalRemoveByPSHelpPrj(PSHelpPrj pSHelpPrj) throws Exception {
        ArrayList<PSHelpModule> arrayList = this.selectByPSHelpPrj(pSHelpPrj);
        this.onBeforeRemoveByPSHelpPrj(pSHelpPrj, arrayList);
        for (PSHelpModule pSHelpModule : arrayList) {
            this.remove(pSHelpModule);
        }
        this.onAfterRemoveByPSHelpPrj(pSHelpPrj, arrayList);
    }

    protected void onAfterRemoveByPSHelpPrj(PSHelpPrj pSHelpPrj) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpPrj(PSHelpPrj pSHelpPrj, ArrayList<PSHelpModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpPrj(PSHelpPrj pSHelpPrj, ArrayList<PSHelpModule> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpModule pSHelpModule) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpModule(pSHelpModule);
        pSCoreSysServiceBase = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpModule(pSHelpModule);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpModule(pSHelpModule);
        pSCoreSysServiceBase = (PSHelpModArtService)ServiceGlobal.getService(PSHelpModArtService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpModArtServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpModule(pSHelpModule);
        ((PSHelpModArtServiceBase)pSCoreSysServiceBase).removeByPSHelpModule(pSHelpModule);
        pSCoreSysServiceBase = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpModuleServiceBase)pSCoreSysServiceBase).testRemoveByPPSHelpModule(pSHelpModule);
        ((PSHelpModuleServiceBase)pSCoreSysServiceBase).removeByPPSHelpModule(pSHelpModule);
        super.onBeforeRemove(pSHelpModule);
    }

    protected void replaceParentInfo(PSHelpModule pSHelpModule, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSHelpModule, cloneSession);
        if (pSHelpModule.getPSHelpArticleId() != null && (iEntity = cloneSession.getEntity("PSHELPARTICLE", (Object)pSHelpModule.getPSHelpArticleId())) != null) {
            this.onFillParentInfo_PSHelpArticle(pSHelpModule, (PSHelpArticle)iEntity);
        }
        if (pSHelpModule.getPPSHelpModuleId() != null && (iEntity = cloneSession.getEntity("PSHELPMODULE", (Object)pSHelpModule.getPPSHelpModuleId())) != null) {
            this.onFillParentInfo_PPSHelpModule(pSHelpModule, (PSHelpModule)iEntity);
        }
        if (pSHelpModule.getPSHelpPrjId() != null && (iEntity = cloneSession.getEntity("PSHELPPRJ", (Object)pSHelpModule.getPSHelpPrjId())) != null) {
            this.onFillParentInfo_PSHelpPrj(pSHelpModule, (PSHelpPrj)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpModule pSHelpModule, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSHelpModule, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArticleUrl(bl, pSHelpModule, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModParam(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModParam2(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleSN(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSHelpModuleId(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleId(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpModuleId(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpModuleName(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpPrjId(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSHelpModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSHelpModule, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArticleUrl(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isArticleUrlDirty() : !pSHelpModule.isArticleUrlDirty()) {
            return null;
        }
        String string = pSHelpModule.getArticleUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleUrl_Default(pSHelpModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isCodeNameDirty() : !pSHelpModule.isCodeNameDirty()) {
            return null;
        }
        String string = pSHelpModule.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSHelpModule, bl2, bl3);
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
                string3 = "PSHELPPRJID";
                String string4 = this.checkFieldDupRule(this.getPSHelpModuleDEModel(), "CODENAME", string3, pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isMemoDirty() : !pSHelpModule.isMemoDirty()) {
            return null;
        }
        String string = pSHelpModule.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModParam(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isModParamDirty() : !pSHelpModule.isModParamDirty()) {
            return null;
        }
        String string = pSHelpModule.getModParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModParam_Default(pSHelpModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModParam2(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isModParam2Dirty() : !pSHelpModule.isModParam2Dirty()) {
            return null;
        }
        String string = pSHelpModule.getModParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModParam2_Default(pSHelpModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleSN(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isModuleSNDirty() : !pSHelpModule.isModuleSNDirty()) {
            return null;
        }
        String string = pSHelpModule.getModuleSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleSN_Default(pSHelpModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULESN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isOrderValueDirty() : !pSHelpModule.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSHelpModule.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSHelpModuleId(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isPPSHelpModuleIdDirty() : !pSHelpModule.isPPSHelpModuleIdDirty()) {
            return null;
        }
        String string = pSHelpModule.getPPSHelpModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSHelpModuleId_Default(pSHelpModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSHELPMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArticleId(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isPSHelpArticleIdDirty() : !pSHelpModule.isPSHelpArticleIdDirty()) {
            return null;
        }
        String string = pSHelpModule.getPSHelpArticleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleId_Default(pSHelpModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLEID");
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
                string3 = "PSHELPPRJID";
                String string4 = this.checkFieldDupRule(this.getPSHelpModuleDEModel(), "PSHELPARTICLEID", string3, pSHelpModule, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSHELPARTICLEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpModuleId(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isPSHelpModuleIdDirty() && !bl2 : !pSHelpModule.isPSHelpModuleIdDirty()) {
            return null;
        }
        String string = pSHelpModule.getPSHelpModuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpModuleId_Default(pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpModuleName(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isPSHelpModuleNameDirty() && !bl2 : !pSHelpModule.isPSHelpModuleNameDirty()) {
            return null;
        }
        String string = pSHelpModule.getPSHelpModuleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODULENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpModuleName_Default(pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpPrjId(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isPSHelpPrjIdDirty() && !bl2 : !pSHelpModule.isPSHelpPrjIdDirty()) {
            return null;
        }
        String string = pSHelpModule.getPSHelpPrjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPPRJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpPrjId_Default(pSHelpModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPPRJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isUserCatDirty() : !pSHelpModule.isUserCatDirty()) {
            return null;
        }
        String string = pSHelpModule.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isUserTagDirty() : !pSHelpModule.isUserTagDirty()) {
            return null;
        }
        String string = pSHelpModule.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isUserTag2Dirty() : !pSHelpModule.isUserTag2Dirty()) {
            return null;
        }
        String string = pSHelpModule.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isUserTag3Dirty() : !pSHelpModule.isUserTag3Dirty()) {
            return null;
        }
        String string = pSHelpModule.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isUserTag4Dirty() : !pSHelpModule.isUserTag4Dirty()) {
            return null;
        }
        String string = pSHelpModule.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSHelpModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSHelpModule pSHelpModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpModule.isValidFlagDirty() && !bl2 : !pSHelpModule.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSHelpModule.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSHelpModule, bl2, bl3);
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

    protected void onSyncEntity(PSHelpModule pSHelpModule, boolean bl) throws Exception {
        super.onSyncEntity(pSHelpModule, bl);
    }

    protected void onSyncIndexEntities(PSHelpModule pSHelpModule, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSHelpModule, bl);
    }

    public Object getDataContextValue(PSHelpModule pSHelpModule, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSHelpModule, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpModule pSHelpModule, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSHelpModule, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ARTICLEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleUrl_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSHELPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSHelpModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSHELPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSHelpModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPPRJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpPrjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPPRJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpPrjName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ArticleUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLEURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModuleSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULESN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_PPSHelpModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSHELPMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSHELPMODULEID", "PSHELPMODULE", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSHelpModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSHELPMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSHelpPrjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPPRJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpPrjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPPRJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSHelpModule pSHelpModule) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSHelpModule)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpModule pSHelpModule) throws Exception {
        super.onUpdateParent(pSHelpModule);
    }

    @Override
    protected void exportCurXmlModel(PSHelpModule pSHelpModule, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPMODULE");
        if (!bl) {
            pSHelpModule.setCreateDate(null);
            pSHelpModule.setCreateMan(null);
            pSHelpModule.setPSHelpModuleId(null);
            pSHelpModule.setUpdateDate(null);
            pSHelpModule.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpModule, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSHelpModule pSHelpModule, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSHelpModule, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSHELPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSHELPMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSHELPPRJID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSHELPPRJ#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSHELPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSHELPMODULE_PSHELPMODULE_PPSHELPMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSHELPPRJID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSHELPMODULE_PSHELPPRJ_PSHELPPRJID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSHELPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSHELPMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSHELPPRJID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSHELPPRJNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSHELPMODULE", (boolean)true) == 0) {
            iEntity.set("PPSHELPMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSHELPPRJ", (boolean)true) == 0) {
            iEntity.set("PSHELPPRJID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSHELPMODULEID", "PSHELPPRJID"};
    }

    @Override
    public String getModelV2Tag(PSHelpModule pSHelpModule) {
        if (!StringHelper.isNullOrEmpty((String)pSHelpModule.getCodeName())) {
            return pSHelpModule.getCodeName();
        }
        return super.getModelV2Tag(pSHelpModule);
    }

    @Override
    public boolean setModelV2Tag(PSHelpModule pSHelpModule, String string) {
        return super.setModelV2Tag(pSHelpModule, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PPSHELPMODULEID", "");
        map.put("PSHELPPRJID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSHelpModule pSHelpModule, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSHelpModule.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSHelpModule, true);
        pSHelpModule.set("CODENAME", string);
        if (this.select(pSHelpModule, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSHelpModule, true);
        return super.getModelV2Entity(pSHelpModule, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSHelpModule pSHelpModule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSHelpModule, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSHELPMODULE_PSHELPMODULE_PPSHELPMODULEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSHelpModule pSHelpModule, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSHELPMODULE_PSHELPMODULE_PPSHELPMODULEID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSHELPMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSHELPMODULE", (Object)pSHelpModule.getPSHelpModuleId()))).exists()) {
            PSHelpModuleService pSHelpModuleService = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSHelpModuleService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSHelpModule pSHelpModule2 = new PSHelpModule();
                PSModelV2Helper.fromJSONObject((IDataObject)pSHelpModule2, objectNode, false);
                String string6 = pSHelpModuleService.getModelV2Tag(pSHelpModule2);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSHELPMODULE", (Object)pSHelpModule2.getPSHelpModuleId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSHelpModuleService.exportModelV2(pSHelpModule2, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSHelpModule, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSHelpModule pSHelpModule, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSHELPMODULE_PSHELPMODULE_PPSHELPMODULEID")) {
            PSHelpModuleService pSHelpModuleService = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSHELPMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSHELPMODULE", (Object)pSHelpModule.getPSHelpModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSHELPMODULE#%1$s", (Object)pSHelpModule.getPSHelpModuleId());
                for (PSHelpModule child : pSHelpModuleService.selectByPPSHelpModule(pSHelpModule)) {
                    String childScope = pSHelpModuleService.getModelV2ResScope(child);
                    if (StringHelper.compare((String)scope, (String)childScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSHelpModuleService.getModelV2Name(false).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("pshelpmodulename")) {
                            string = objectNode.get("pshelpmodulename").asText();
                        }
                        if (objectNode2.has("pshelpmodulename")) {
                            string2 = objectNode2.get("pshelpmodulename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSHelpModule child = new PSHelpModule();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    output.add(pSHelpModuleService.exportModelV2(child, string));
                }
            }
        }
        super.onExportCurModelV2(pSHelpModule, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSHelpModule pSHelpModule) throws Exception {
        super.onEmptyModelV2(pSHelpModule);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSHelpModuleService pSHelpModuleService = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
        if (pSHelpModuleService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSHelpModule pSHelpModule, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSHelpModule pSHelpModule2 = new PSHelpModule();
        pSHelpModule2.set("PPSHELPMODULEID", pSHelpModule.getPSHelpModuleId());
        PSHelpModuleService pSHelpModuleService = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSHelpModuleService.getModelV2Entity(pSHelpModule2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSHelpModule, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSHelpModule pSHelpModule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSHelpModuleServiceBase.isSimpleImportExportMode("")) {
            PSHelpModuleService pSHelpModuleService = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSHelpModuleService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSHelpModule pSHelpModule2 = new PSHelpModule();
                    pSHelpModule2.setPPSHelpModuleId(pSHelpModule.getPSHelpModuleId());
                    pSHelpModule2.setPPSHelpModuleName(pSHelpModule.getPSHelpModuleName());
                    pSHelpModuleService.compileModelV2(pSHelpModule2, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSHelpModule pSHelpModule3 = new PSHelpModule();
                        pSHelpModule3.setPPSHelpModuleId(pSHelpModule.getPSHelpModuleId());
                        pSHelpModule3.setPPSHelpModuleName(pSHelpModule.getPSHelpModuleName());
                        pSHelpModuleService.compileModelV2(pSHelpModule3, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSHelpModule, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSHelpModule pSHelpModule, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSHelpModule, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSHelpModule pSHelpModule, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSHelpModule, list);
    }
}

