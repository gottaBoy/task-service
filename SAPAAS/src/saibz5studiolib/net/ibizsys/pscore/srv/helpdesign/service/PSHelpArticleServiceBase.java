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
 *  net.ibizsys.paas.service.SessionFactoryManager
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

import com.fasterxml.jackson.databind.JsonNode;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.helpdesign.dao.PSHelpArticleDAO;
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpArticleDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticleCat;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticleCatBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModArtService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModArtServiceBase;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleServiceBase;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpArticleServiceBase
extends PSCoreSysServiceBase<PSHelpArticle> {
    private static final Log log = LogFactory.getLog(PSHelpArticleServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    private PSHelpArticleDEModel pSHelpArticleDEModel;
    private PSHelpArticleDAO pSHelpArticleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService";
    }

    public PSHelpArticleDEModel getPSHelpArticleDEModel() {
        if (this.pSHelpArticleDEModel == null) {
            try {
                this.pSHelpArticleDEModel = (PSHelpArticleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpArticleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArticleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpArticleDEModel();
    }

    public PSHelpArticleDAO getPSHelpArticleDAO() {
        if (this.pSHelpArticleDAO == null) {
            try {
                this.pSHelpArticleDAO = (PSHelpArticleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.helpdesign.dao.PSHelpArticleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArticleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpArticleDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSHelpArticle pSHelpArticle, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTICLE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSHelpArticle, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTICLE_PSHELPARTICLECAT_PSHELPARTICLECATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleCatService", (SessionFactory)this.getSessionFactory());
            PSHelpArticleCat pSHelpArticleCat = (PSHelpArticleCat)iService.getDEModel().createEntity();
            pSHelpArticleCat.set("PSHELPARTICLECATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpArticleCat);
            } else {
                iService.get(pSHelpArticleCat);
            }
            this.onFillParentInfo_PSHelpArticleCat(pSHelpArticle, pSHelpArticleCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTICLE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSHelpArticle, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTICLE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSHelpArticle, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTICLE_PSSYSUSERCASE_PSSYSUSERCASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService", (SessionFactory)this.getSessionFactory());
            PSSysUserCase pSSysUserCase = (PSSysUserCase)iService.getDEModel().createEntity();
            pSSysUserCase.set("PSSYSUSERCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUserCase);
            } else {
                iService.get(pSSysUserCase);
            }
            this.onFillParentInfo_PSSysUserCase(pSHelpArticle, pSSysUserCase);
            return;
        }
        super.onFillParentInfo(pSHelpArticle, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSHelpArticle pSHelpArticle, PSDataEntity pSDataEntity) throws Exception {
        pSHelpArticle.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSHelpArticle.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSHelpArticleCat(PSHelpArticle pSHelpArticle, PSHelpArticleCat pSHelpArticleCat) throws Exception {
        pSHelpArticle.setPSHelpArticleCatId(pSHelpArticleCat.getPSHelpArticleCatId());
        pSHelpArticle.setPSHelpArticleCatName(pSHelpArticleCat.getPSHelpArticleCatName());
    }

    protected void onFillParentInfo_PSModule(PSHelpArticle pSHelpArticle, PSModule pSModule) throws Exception {
        pSHelpArticle.setPSModuleId(pSModule.getPSModuleId());
        pSHelpArticle.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSystem(PSHelpArticle pSHelpArticle, PSSystem pSSystem) throws Exception {
        pSHelpArticle.setPSSystemId(pSSystem.getPSSystemId());
        pSHelpArticle.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUserCase(PSHelpArticle pSHelpArticle, PSSysUserCase pSSysUserCase) throws Exception {
        pSHelpArticle.setPSSysUserCaseId(pSSysUserCase.getPSSysUserCaseId());
        pSHelpArticle.setPSSysUserCaseName(pSSysUserCase.getPSSysUserCaseName());
    }

    protected void onFillEntityFullInfo(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSHelpArticle, bl);
        this.onFillEntityFullInfo_PSDE(pSHelpArticle, bl);
        this.onFillEntityFullInfo_PSHelpArticleCat(pSHelpArticle, bl);
        this.onFillEntityFullInfo_PSModule(pSHelpArticle, bl);
        this.onFillEntityFullInfo_PSSystem(pSHelpArticle, bl);
        this.onFillEntityFullInfo_PSSysUserCase(pSHelpArticle, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
        if (pSHelpArticle.isPSDEIdDirty()) {
            if (pSHelpArticle.getPSDEId() != null) {
                if (pSHelpArticle.getPSDEId() == null || pSHelpArticle.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSHelpArticle.getPSDE();
                    pSHelpArticle.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSHelpArticle.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSHelpArticleCat(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
        if (pSHelpArticle.isPSSystemIdDirty()) {
            if (pSHelpArticle.getPSSystemId() != null) {
                if (pSHelpArticle.getPSSystemId() == null || pSHelpArticle.getPSSystemName() == null) {
                    PSSystem pSSystem = pSHelpArticle.getPSSystem();
                    pSHelpArticle.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSHelpArticle.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysUserCase(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
        super.onWriteBackParent(pSHelpArticle, bl);
    }

    public ArrayList<PSHelpArticle> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSHelpArticle> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSHelpArticle> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSHelpArticle> selectByPSHelpArticleCat(PSHelpArticleCatBase pSHelpArticleCatBase) throws Exception {
        return this.selectByPSHelpArticleCat(pSHelpArticleCatBase, "", -1);
    }

    public ArrayList<PSHelpArticle> selectByPSHelpArticleCat(PSHelpArticleCatBase pSHelpArticleCatBase, String string) throws Exception {
        return this.selectByPSHelpArticleCat(pSHelpArticleCatBase, string, -1);
    }

    public ArrayList<PSHelpArticle> selectByPSHelpArticleCat(PSHelpArticleCatBase pSHelpArticleCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPARTICLECATID", (Object)pSHelpArticleCatBase.getPSHelpArticleCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpArticleCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpArticleCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpArticle> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSHelpArticle> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSHelpArticle> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpArticle> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSHelpArticle> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSHelpArticle> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpArticle> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, "", -1);
    }

    public ArrayList<PSHelpArticle> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, string, -1);
    }

    public ArrayList<PSHelpArticle> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERCASEID", (Object)pSSysUserCaseBase.getPSSysUserCaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserCaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserCaseCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            PSHelpArticle pSHelpArticle2 = (PSHelpArticle)this.getDEModel().createEntity();
            pSHelpArticle2.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
            pSHelpArticle2.setPSDEId(null);
            this.update(pSHelpArticle2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArticleServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSHelpArticleServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSHelpArticleServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            this.remove(pSHelpArticle);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpArticleCat(PSHelpArticleCat pSHelpArticleCat) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSHelpArticleCat(pSHelpArticleCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPARTICLECAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpArticleCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPARTICLE_PSHELPARTICLECAT_PSHELPARTICLECATID", "", iDataEntityModel.getName(), "PSHELPARTICLE", iDataEntityModel.getDataInfo(pSHelpArticleCat), arrayList.get(0)));
        }
    }

    public void resetPSHelpArticleCat(PSHelpArticleCat pSHelpArticleCat) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSHelpArticleCat(pSHelpArticleCat);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            PSHelpArticle pSHelpArticle2 = (PSHelpArticle)this.getDEModel().createEntity();
            pSHelpArticle2.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
            pSHelpArticle2.setPSHelpArticleCatId(null);
            this.update(pSHelpArticle2);
        }
    }

    public void removeByPSHelpArticleCat(PSHelpArticleCat pSHelpArticleCat) throws Exception {
        final PSHelpArticleCat pSHelpArticleCat2 = pSHelpArticleCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArticleServiceBase.this.onBeforeRemoveByPSHelpArticleCat(pSHelpArticleCat2);
                PSHelpArticleServiceBase.this.internalRemoveByPSHelpArticleCat(pSHelpArticleCat2);
                PSHelpArticleServiceBase.this.onAfterRemoveByPSHelpArticleCat(pSHelpArticleCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpArticleCat(PSHelpArticleCat pSHelpArticleCat) throws Exception {
    }

    protected void internalRemoveByPSHelpArticleCat(PSHelpArticleCat pSHelpArticleCat) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSHelpArticleCat(pSHelpArticleCat);
        this.onBeforeRemoveByPSHelpArticleCat(pSHelpArticleCat, arrayList);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            this.remove(pSHelpArticle);
        }
        this.onAfterRemoveByPSHelpArticleCat(pSHelpArticleCat, arrayList);
    }

    protected void onAfterRemoveByPSHelpArticleCat(PSHelpArticleCat pSHelpArticleCat) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpArticleCat(PSHelpArticleCat pSHelpArticleCat, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpArticleCat(PSHelpArticleCat pSHelpArticleCat, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPARTICLE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSHELPARTICLE", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSModule(pSModule);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            PSHelpArticle pSHelpArticle2 = (PSHelpArticle)this.getDEModel().createEntity();
            pSHelpArticle2.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
            pSHelpArticle2.setPSModuleId(null);
            this.update(pSHelpArticle2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArticleServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSHelpArticleServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSHelpArticleServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            this.remove(pSHelpArticle);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPARTICLE_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSHELPARTICLE", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSSystem(pSSystem);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            PSHelpArticle pSHelpArticle2 = (PSHelpArticle)this.getDEModel().createEntity();
            pSHelpArticle2.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
            pSHelpArticle2.setPSSystemId(null);
            this.update(pSHelpArticle2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArticleServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSHelpArticleServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSHelpArticleServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            this.remove(pSHelpArticle);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSSysUserCase(pSSysUserCase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERCASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUserCase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPARTICLE_PSSYSUSERCASE_PSSYSUSERCASEID", "", iDataEntityModel.getName(), "PSHELPARTICLE", iDataEntityModel.getDataInfo(pSSysUserCase), arrayList.get(0)));
        }
    }

    public void resetPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            PSHelpArticle pSHelpArticle2 = (PSHelpArticle)this.getDEModel().createEntity();
            pSHelpArticle2.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
            pSHelpArticle2.setPSSysUserCaseId(null);
            this.update(pSHelpArticle2);
        }
    }

    public void removeByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        final PSSysUserCase pSSysUserCase2 = pSSysUserCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArticleServiceBase.this.onBeforeRemoveByPSSysUserCase(pSSysUserCase2);
                PSHelpArticleServiceBase.this.internalRemoveByPSSysUserCase(pSSysUserCase2);
                PSHelpArticleServiceBase.this.onAfterRemoveByPSSysUserCase(pSSysUserCase2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void internalRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSHelpArticle> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        this.onBeforeRemoveByPSSysUserCase(pSSysUserCase, arrayList);
        for (PSHelpArticle pSHelpArticle : arrayList) {
            this.remove(pSHelpArticle);
        }
        this.onAfterRemoveByPSSysUserCase(pSSysUserCase, arrayList);
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSHelpArticle> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpArticle pSHelpArticle) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSHelpModArtService)ServiceGlobal.getService(PSHelpModArtService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpModArtServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpArticle(pSHelpArticle);
        pSCoreSysServiceBase = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpModuleServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpArticle(pSHelpArticle);
        pSCoreSysServiceBase = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpArticle(pSHelpArticle);
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).removeByPSHelpArticle(pSHelpArticle);
        pSCoreSysServiceBase = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).testRemoveByRefPSHelpArticle(pSHelpArticle);
        super.onBeforeRemove(pSHelpArticle);
    }

    protected void replaceParentInfo(PSHelpArticle pSHelpArticle, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSHelpArticle, cloneSession);
        if (pSHelpArticle.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSHelpArticle.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSHelpArticle, (PSDataEntity)iEntity);
        }
        if (pSHelpArticle.getPSHelpArticleCatId() != null && (iEntity = cloneSession.getEntity("PSHELPARTICLECAT", (Object)pSHelpArticle.getPSHelpArticleCatId())) != null) {
            this.onFillParentInfo_PSHelpArticleCat(pSHelpArticle, (PSHelpArticleCat)iEntity);
        }
        if (pSHelpArticle.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSHelpArticle.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSHelpArticle, (PSModule)iEntity);
        }
        if (pSHelpArticle.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSHelpArticle.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSHelpArticle, (PSSystem)iEntity);
        }
        if (pSHelpArticle.getPSSysUserCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERCASE", (Object)pSHelpArticle.getPSSysUserCaseId())) != null) {
            this.onFillParentInfo_PSSysUserCase(pSHelpArticle, (PSSysUserCase)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSHelpArticle, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArticleParam(bl, pSHelpArticle, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleParam2(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleParam3(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleParam4(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleParam5(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleParam6(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleParam7(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleParam8(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleSN(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleType(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArticleVer(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BottomContent(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderContent(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Keywords(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleCatId(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleId(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleName(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserCaseId(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCaption(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSHelpArticle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSHelpArticle, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArticleParam(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleParamDirty() : !pSHelpArticle.isArticleParamDirty()) {
            return null;
        }
        String string = pSHelpArticle.getArticleParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleParam_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleParam2(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleParam2Dirty() : !pSHelpArticle.isArticleParam2Dirty()) {
            return null;
        }
        String string = pSHelpArticle.getArticleParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleParam2_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleParam3(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleParam3Dirty() : !pSHelpArticle.isArticleParam3Dirty()) {
            return null;
        }
        String string = pSHelpArticle.getArticleParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleParam3_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleParam4(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleParam4Dirty() : !pSHelpArticle.isArticleParam4Dirty()) {
            return null;
        }
        String string = pSHelpArticle.getArticleParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleParam4_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleParam5(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleParam5Dirty() : !pSHelpArticle.isArticleParam5Dirty()) {
            return null;
        }
        Integer n = pSHelpArticle.getArticleParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArticleParam5_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleParam6(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleParam6Dirty() : !pSHelpArticle.isArticleParam6Dirty()) {
            return null;
        }
        Integer n = pSHelpArticle.getArticleParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArticleParam6_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleParam7(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleParam7Dirty() : !pSHelpArticle.isArticleParam7Dirty()) {
            return null;
        }
        Integer n = pSHelpArticle.getArticleParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArticleParam7_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleParam8(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleParam8Dirty() : !pSHelpArticle.isArticleParam8Dirty()) {
            return null;
        }
        Integer n = pSHelpArticle.getArticleParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArticleParam8_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleSN(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleSNDirty() : !pSHelpArticle.isArticleSNDirty()) {
            return null;
        }
        String string = pSHelpArticle.getArticleSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleSN_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLESN");
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
                string3 = "PSDEID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSHelpArticleDEModel(), "ARTICLESN", string3, pSHelpArticle, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("ARTICLESN");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleType(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleTypeDirty() && !bl2 : !pSHelpArticle.isArticleTypeDirty()) {
            return null;
        }
        String string = pSHelpArticle.getArticleType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleType_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArticleVer(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isArticleVerDirty() : !pSHelpArticle.isArticleVerDirty()) {
            return null;
        }
        String string = pSHelpArticle.getArticleVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleVer_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BottomContent(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isBottomContentDirty() : !pSHelpArticle.isBottomContentDirty()) {
            return null;
        }
        String string = pSHelpArticle.getBottomContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomContent_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isCodeNameDirty() : !pSHelpArticle.isCodeNameDirty()) {
            return null;
        }
        String string = pSHelpArticle.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSHelpArticle, bl2, bl3);
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
                string3 = "PSDEID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSHelpArticleDEModel(), "CODENAME", string3, pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_Content(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isContentDirty() : !pSHelpArticle.isContentDirty()) {
            return null;
        }
        String string = pSHelpArticle.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderContent(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isHeaderContentDirty() : !pSHelpArticle.isHeaderContentDirty()) {
            return null;
        }
        String string = pSHelpArticle.getHeaderContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderContent_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Keywords(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isKeywordsDirty() : !pSHelpArticle.isKeywordsDirty()) {
            return null;
        }
        String string = pSHelpArticle.getKeywords();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Keywords_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYWORDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isMemoDirty() : !pSHelpArticle.isMemoDirty()) {
            return null;
        }
        String string = pSHelpArticle.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isPSDEIdDirty() : !pSHelpArticle.isPSDEIdDirty()) {
            return null;
        }
        String string = pSHelpArticle.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isPSDENameDirty() : !pSHelpArticle.isPSDENameDirty()) {
            return null;
        }
        String string = pSHelpArticle.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpArticleCatId(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isPSHelpArticleCatIdDirty() : !pSHelpArticle.isPSHelpArticleCatIdDirty()) {
            return null;
        }
        String string = pSHelpArticle.getPSHelpArticleCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleCatId_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLECATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArticleId(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isPSHelpArticleIdDirty() && !bl2 : !pSHelpArticle.isPSHelpArticleIdDirty()) {
            return null;
        }
        String string = pSHelpArticle.getPSHelpArticleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleId_Default(pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpArticleName(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isPSHelpArticleNameDirty() && !bl2 : !pSHelpArticle.isPSHelpArticleNameDirty()) {
            return null;
        }
        String string = pSHelpArticle.getPSHelpArticleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleName_Default(pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isPSModuleIdDirty() : !pSHelpArticle.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSHelpArticle.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isPSSystemIdDirty() : !pSHelpArticle.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSHelpArticle.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isPSSystemNameDirty() : !pSHelpArticle.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSHelpArticle.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserCaseId(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isPSSysUserCaseIdDirty() : !pSHelpArticle.isPSSysUserCaseIdDirty()) {
            return null;
        }
        String string = pSHelpArticle.getPSSysUserCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserCaseId_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERCASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubCaption(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isSubCaptionDirty() : !pSHelpArticle.isSubCaptionDirty()) {
            return null;
        }
        String string = pSHelpArticle.getSubCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCaption_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isTitleDirty() : !pSHelpArticle.isTitleDirty()) {
            return null;
        }
        String string = pSHelpArticle.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default(pSHelpArticle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isUserCatDirty() : !pSHelpArticle.isUserCatDirty()) {
            return null;
        }
        String string = pSHelpArticle.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isUserTagDirty() : !pSHelpArticle.isUserTagDirty()) {
            return null;
        }
        String string = pSHelpArticle.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isUserTag2Dirty() : !pSHelpArticle.isUserTag2Dirty()) {
            return null;
        }
        String string = pSHelpArticle.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isUserTag3Dirty() : !pSHelpArticle.isUserTag3Dirty()) {
            return null;
        }
        String string = pSHelpArticle.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSHelpArticle, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSHelpArticle pSHelpArticle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticle.isUserTag4Dirty() : !pSHelpArticle.isUserTag4Dirty()) {
            return null;
        }
        String string = pSHelpArticle.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSHelpArticle, bl2, bl3);
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

    protected void onSyncEntity(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
        super.onSyncEntity(pSHelpArticle, bl);
    }

    protected void onSyncIndexEntities(PSHelpArticle pSHelpArticle, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSHelpArticle, bl);
    }

    public Object getDataContextValue(PSHelpArticle pSHelpArticle, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSHelpArticle, string, iDataContextParam)) != null) {
            return object;
        }
        PSModule pSModule = pSHelpArticle.getPSModule();
        if (pSModule != null && pSModule.contains(string)) {
            return pSModule.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpArticle pSHelpArticle, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSHelpArticle, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ARTICLEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLEPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLEPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLEPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLEPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLEPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLEPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLEPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARTICLEVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOTTOMCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYWORDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Keywords_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLECATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLECATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ArticleParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLEPARAM", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ArticleParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLEPARAM2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ArticleParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLEPARAM3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ArticleParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLEPARAM4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ArticleParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ArticleParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ArticleParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ArticleParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ArticleSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLESN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("ARTICLESN", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ArticleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ArticleVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLEVER", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BottomContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_HeaderContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Keywords_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYWORDS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLECATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLECATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBCAPTION", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSHelpArticle pSHelpArticle) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSHelpArticle)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpArticle pSHelpArticle) throws Exception {
        super.onUpdateParent(pSHelpArticle);
    }

    @Override
    protected void exportCurXmlModel(PSHelpArticle pSHelpArticle, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPARTICLE");
        if (!bl) {
            pSHelpArticle.setCreateDate(null);
            pSHelpArticle.setCreateMan(null);
            pSHelpArticle.setPSHelpArticleId(null);
            pSHelpArticle.setUpdateDate(null);
            pSHelpArticle.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpArticle, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSHelpArticle pSHelpArticle, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSHelpArticle, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSHELPARTICLE_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSHELPARTICLE_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSHELPARTICLE_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSHelpArticle pSHelpArticle) {
        if (!StringHelper.isNullOrEmpty((String)pSHelpArticle.getCodeName())) {
            return pSHelpArticle.getCodeName();
        }
        return super.getModelV2Tag(pSHelpArticle);
    }

    @Override
    public boolean setModelV2Tag(PSHelpArticle pSHelpArticle, String string) {
        return super.setModelV2Tag(pSHelpArticle, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("ARTICLESN", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSHelpArticle pSHelpArticle, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSHelpArticle.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSHelpArticle, true);
        pSHelpArticle.set("CODENAME", string);
        if (this.select(pSHelpArticle, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSHelpArticle, true);
        return super.getModelV2Entity(pSHelpArticle, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSHelpArticle pSHelpArticle, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSHelpArticle, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSHELPSECTION_PSHELPARTICLE_PSHELPARTICLEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSHelpArticle pSHelpArticle, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSHELPSECTION_PSHELPARTICLE_PSHELPARTICLEID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSHELPARTICLE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSHELPSECTION", (Object)pSHelpArticle.getPSHelpArticleId()))).exists()) {
            PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSHelpSectionService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSHelpSection pSHelpSection = new PSHelpSection();
                PSModelV2Helper.fromJSONObject((IDataObject)pSHelpSection, objectNode, false);
                String string6 = pSHelpSectionService.getModelV2Tag(pSHelpSection);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSHELPSECTION", (Object)pSHelpSection.getPSHelpSectionId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSHelpSectionService.exportModelV2(pSHelpSection, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSHelpArticle, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSHelpArticle pSHelpArticle, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSHELPSECTION_PSHELPARTICLE_PSHELPARTICLEID")) {
            PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSHELPARTICLE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSHELPSECTION", (Object)pSHelpArticle.getPSHelpArticleId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String sectionJson : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)sectionJson)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)sectionJson));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String resScope = StringHelper.format((String)"PSHELPARTICLE#%1$s", (Object)pSHelpArticle.getPSHelpArticleId());
                for (PSHelpSection section : pSHelpSectionService.selectByPSHelpArticle(pSHelpArticle)) {
                    String sectionScope = pSHelpSectionService.getModelV2ResScope(section);
                    if (StringHelper.compare((String)resScope, (String)sectionScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(section, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String sectionName = pSHelpSectionService.getModelV2Name(false);
                ArrayNode sectionArray = objectNode.putArray(sectionName.toLowerCase());
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
                        if (objectNode.has("pshelpsectionname")) {
                            string = objectNode.get("pshelpsectionname").asText();
                        }
                        if (objectNode2.has("pshelpsectionname")) {
                            string2 = objectNode2.get("pshelpsectionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode sectionNode : arrayList) {
                    PSHelpSection section = new PSHelpSection();
                    PSModelV2Helper.fromJSONObject((IDataObject)section, sectionNode, false);
                    sectionArray.add((JsonNode)pSHelpSectionService.exportModelV2(section, string));
                }
            }
        }
        super.onExportCurModelV2(pSHelpArticle, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSHelpArticle pSHelpArticle) throws Exception {
        super.onEmptyModelV2(pSHelpArticle);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        if (pSHelpSectionService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSHelpArticle pSHelpArticle, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.set("PSHELPARTICLEID", pSHelpArticle.getPSHelpArticleId());
        PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSHelpSectionService.getModelV2Entity(pSHelpSection, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSHelpArticle, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSHelpArticle pSHelpArticle, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSHelpArticleServiceBase.isSimpleImportExportMode("")) {
            PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSHelpSectionService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSHelpSection pSHelpSection = new PSHelpSection();
                    pSHelpSection.setPSDEId(pSHelpArticle.getPSDEId());
                    pSHelpSection.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
                    pSHelpSection.setPSHelpArticleName(pSHelpArticle.getPSHelpArticleName());
                    pSHelpSectionService.compileModelV2(pSHelpSection, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSHelpSection pSHelpSection = new PSHelpSection();
                        pSHelpSection.setPSDEId(pSHelpArticle.getPSDEId());
                        pSHelpSection.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
                        pSHelpSection.setPSHelpArticleName(pSHelpArticle.getPSHelpArticleName());
                        pSHelpSectionService.compileModelV2(pSHelpSection, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSHelpArticle, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSHelpArticle pSHelpArticle, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSHELPSECTION_PSHELPARTICLE_PSHELPARTICLEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSHelpSections(pSHelpArticle, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSHelpArticle, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSHelpSections(PSHelpArticle pSHelpArticle, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSHELPSECTION", true), (boolean)false) == 0) {
            PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
            PSHelpSection pSHelpSection = new PSHelpSection();
            pSHelpSection.setPSHelpSectionId(pSMOSFile.getPSModelId());
            if (!pSHelpSectionService.get(pSHelpSection, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSHelpSection.getPSHelpArticleId(), (String)pSHelpArticle.getPSHelpArticleId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSHelpSectionService.exportModelV2(pSHelpSection);
            pSHelpSection.reset();
            if (!pSHelpSectionService.setModelV2ResScope(pSHelpSection, "PSHELPARTICLE", pSHelpArticle.getPSHelpArticleId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSHelpSectionService.importModelV2(pSHelpSection, objectNode);
            SessionFactoryManager.commit();
            return pSHelpSectionService.getFile(pSHelpSection);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSHelpArticle pSHelpArticle, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSHelpSections(pSHelpArticle, list);
        super.onFillPasteHelps(pSHelpArticle, list);
    }

    protected void onFillPasteHelps_PSHelpSections(PSHelpArticle pSHelpArticle, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSHELPSECTION");
        pSHelpSection.setSectionParam2("DER1N_PSHELPSECTION_PSHELPARTICLE_PSHELPARTICLEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e2e\u52a9\u6587\u7ae0]\u7684[\u5e2e\u52a9\u7ae0\u8282]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSHelpArticle pSHelpArticle) throws Exception {
        return pSHelpArticle.getArticleType();
    }
}
