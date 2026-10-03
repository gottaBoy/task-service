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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysContentCatDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysContentCatDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContentBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContentCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContentCatBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysContentCatServiceBase
extends PSCoreSysServiceBase<PSSysContentCat> {
    private static final Log log = LogFactory.getLog(PSSysContentCatServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYS2 = "CurSys2";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysContentCatDEModel pSSysContentCatDEModel;
    private PSSysContentCatDAO pSSysContentCatDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatService";
    }

    public PSSysContentCatDEModel getPSSysContentCatDEModel() {
        if (this.pSSysContentCatDEModel == null) {
            try {
                this.pSSysContentCatDEModel = (PSSysContentCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysContentCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysContentCatDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysContentCatDEModel();
    }

    public PSSysContentCatDAO getPSSysContentCatDAO() {
        if (this.pSSysContentCatDAO == null) {
            try {
                this.pSSysContentCatDAO = (PSSysContentCatDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysContentCatDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysContentCatDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysContentCatDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS2, (boolean)true) == 0) {
            return this.fetchCurSys2(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysContentCat pSSysContentCat, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCONTENTCAT_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysContentCat, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatService", (SessionFactory)this.getSessionFactory());
            PSSysContentCat pSSysContentCat2 = (PSSysContentCat)iService.getDEModel().createEntity();
            pSSysContentCat2.set("PSSYSCONTENTCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysContentCat2);
            } else {
                iService.get(pSSysContentCat2);
            }
            this.onFillParentInfo_PPSSysContentCat(pSSysContentCat, pSSysContentCat2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCONTENTCAT_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysContentCat, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCONTENTCAT_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysContentCat, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysContentCat, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysContentCat pSSysContentCat, PSModule pSModule) throws Exception {
        pSSysContentCat.setPSModuleId(pSModule.getPSModuleId());
        pSSysContentCat.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PPSSysContentCat(PSSysContentCat pSSysContentCat, PSSysContentCat pSSysContentCat2) throws Exception {
        pSSysContentCat.setPPSSysContentCatId(pSSysContentCat2.getPSSysContentCatId());
        pSSysContentCat.setPPSSysContentCatName(pSSysContentCat2.getPSSysContentCatName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysContentCat pSSysContentCat, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysContentCat.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysContentCat.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSystem(PSSysContentCat pSSysContentCat, PSSystem pSSystem) throws Exception {
        pSSysContentCat.setPSSystemId(pSSystem.getPSSystemId());
        pSSysContentCat.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysContentCat pSSysContentCat, boolean bl) throws Exception {
        if (bl) {
            if (pSSysContentCat.getCodeName() == null) {
                pSSysContentCat.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "ContentCat", 25));
            }
            if (pSSysContentCat.getOrderValue() == null) {
                pSSysContentCat.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "1000", 9));
            }
            if (pSSysContentCat.getPSSysContentCatName() == null) {
                pSSysContentCat.setPSSysContentCatName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5185\u5bb9\u5206\u7c7b", 25));
            }
        }
        super.onFillEntityFullInfo(pSSysContentCat, bl);
        this.onFillEntityFullInfo_PSModule(pSSysContentCat, bl);
        this.onFillEntityFullInfo_PPSSysContentCat(pSSysContentCat, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysContentCat, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysContentCat, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysContentCat pSSysContentCat, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSysContentCat(PSSysContentCat pSSysContentCat, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysContentCat pSSysContentCat, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysContentCat pSSysContentCat, boolean bl) throws Exception {
        if (pSSysContentCat.isPSSystemIdDirty()) {
            if (pSSysContentCat.getPSSystemId() != null) {
                if (pSSysContentCat.getPSSystemId() == null || pSSysContentCat.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysContentCat.getPSSystem();
                    pSSysContentCat.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysContentCat.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysContentCat pSSysContentCat, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysContentCat, bl);
    }

    public ArrayList<PSSysContentCat> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysContentCat> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysContentCat> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysContentCat> selectByPPSSysContentCat(PSSysContentCatBase pSSysContentCatBase) throws Exception {
        return this.selectByPPSSysContentCat(pSSysContentCatBase, "", -1);
    }

    public ArrayList<PSSysContentCat> selectByPPSSysContentCat(PSSysContentCatBase pSSysContentCatBase, String string) throws Exception {
        return this.selectByPPSSysContentCat(pSSysContentCatBase, string, -1);
    }

    public ArrayList<PSSysContentCat> selectByPPSSysContentCat(PSSysContentCatBase pSSysContentCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSCONTENTCATID", (Object)pSSysContentCatBase.getPSSysContentCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysContentCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysContentCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysContentCat> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysContentCat> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysContentCat> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysContentCat> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysContentCat> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysContentCat> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCONTENTCAT_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSCONTENTCAT", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPSModule(pSModule);
        for (PSSysContentCat pSSysContentCat : arrayList) {
            PSSysContentCat pSSysContentCat2 = (PSSysContentCat)this.getDEModel().createEntity();
            pSSysContentCat2.setPSSysContentCatId(pSSysContentCat.getPSSysContentCatId());
            pSSysContentCat2.setPSModuleId(null);
            this.update(pSSysContentCat2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysContentCatServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysContentCatServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysContentCatServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysContentCat pSSysContentCat : arrayList) {
            this.remove(pSSysContentCat);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysContentCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysContentCat> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysContentCat(PSSysContentCat pSSysContentCat) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPPSSysContentCat(pSSysContentCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCONTENTCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysContentCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID", "", iDataEntityModel.getName(), "PSSYSCONTENTCAT", iDataEntityModel.getDataInfo(pSSysContentCat), arrayList.get(0)));
        }
    }

    public void resetPPSSysContentCat(PSSysContentCat pSSysContentCat) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPPSSysContentCat(pSSysContentCat);
        for (PSSysContentCat pSSysContentCat2 : arrayList) {
            PSSysContentCat pSSysContentCat3 = (PSSysContentCat)this.getDEModel().createEntity();
            pSSysContentCat3.setPSSysContentCatId(pSSysContentCat2.getPSSysContentCatId());
            pSSysContentCat3.setPPSSysContentCatId(null);
            this.update(pSSysContentCat3);
        }
    }

    public void removeByPPSSysContentCat(PSSysContentCat pSSysContentCat) throws Exception {
        final PSSysContentCat pSSysContentCat2 = pSSysContentCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysContentCatServiceBase.this.onBeforeRemoveByPPSSysContentCat(pSSysContentCat2);
                PSSysContentCatServiceBase.this.internalRemoveByPPSSysContentCat(pSSysContentCat2);
                PSSysContentCatServiceBase.this.onAfterRemoveByPPSSysContentCat(pSSysContentCat2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysContentCat(PSSysContentCat pSSysContentCat) throws Exception {
    }

    protected void internalRemoveByPPSSysContentCat(PSSysContentCat pSSysContentCat) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPPSSysContentCat(pSSysContentCat);
        this.onBeforeRemoveByPPSSysContentCat(pSSysContentCat, arrayList);
        for (PSSysContentCat pSSysContentCat2 : arrayList) {
            this.remove(pSSysContentCat2);
        }
        this.onAfterRemoveByPPSSysContentCat(pSSysContentCat, arrayList);
    }

    protected void onAfterRemoveByPPSSysContentCat(PSSysContentCat pSSysContentCat) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysContentCat(PSSysContentCat pSSysContentCat, ArrayList<PSSysContentCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysContentCat(PSSysContentCat pSSysContentCat, ArrayList<PSSysContentCat> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCONTENTCAT_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSCONTENTCAT", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysContentCat pSSysContentCat : arrayList) {
            PSSysContentCat pSSysContentCat2 = (PSSysContentCat)this.getDEModel().createEntity();
            pSSysContentCat2.setPSSysContentCatId(pSSysContentCat.getPSSysContentCatId());
            pSSysContentCat2.setPSSysDynaModelId(null);
            this.update(pSSysContentCat2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysContentCatServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysContentCatServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysContentCatServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysContentCat pSSysContentCat : arrayList) {
            this.remove(pSSysContentCat);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysContentCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysContentCat> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCONTENTCAT_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSCONTENTCAT", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysContentCat pSSysContentCat : arrayList) {
            PSSysContentCat pSSysContentCat2 = (PSSysContentCat)this.getDEModel().createEntity();
            pSSysContentCat2.setPSSysContentCatId(pSSysContentCat.getPSSysContentCatId());
            pSSysContentCat2.setPSSystemId(null);
            this.update(pSSysContentCat2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysContentCatServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysContentCatServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysContentCatServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysContentCat> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysContentCat pSSysContentCat : arrayList) {
            this.remove(pSSysContentCat);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysContentCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysContentCat> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysContentCat pSSysContentCat) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysContentCatServiceBase)pSCoreSysServiceBase).testRemoveByPPSSysContentCat(pSSysContentCat);
        pSCoreSysServiceBase = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysContentServiceBase)pSCoreSysServiceBase).testRemoveByPSSysContentCat(pSSysContentCat);
        pSCoreSysServiceBase = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysResourceServiceBase)pSCoreSysServiceBase).testRemoveByPSSysContentCat(pSSysContentCat);
        super.onBeforeRemove(pSSysContentCat);
    }

    protected void replaceParentInfo(PSSysContentCat pSSysContentCat, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysContentCat, cloneSession);
        if (pSSysContentCat.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysContentCat.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysContentCat, (PSModule)iEntity);
        }
        if (pSSysContentCat.getPPSSysContentCatId() != null && (iEntity = cloneSession.getEntity("PSSYSCONTENTCAT", (Object)pSSysContentCat.getPPSSysContentCatId())) != null) {
            this.onFillParentInfo_PPSSysContentCat(pSSysContentCat, (PSSysContentCat)iEntity);
        }
        if (pSSysContentCat.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysContentCat.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysContentCat, (PSSysDynaModel)iEntity);
        }
        if (pSSysContentCat.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysContentCat.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysContentCat, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysContentCat pSSysContentCat, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysContentCat, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CatTag(bl, pSSysContentCat, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CatTag2(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysContentCatId(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysContentCatId(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysContentCatName(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Subject(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tags(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysContentCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysContentCat, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CatTag(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isCatTagDirty() : !pSSysContentCat.isCatTagDirty()) {
            return null;
        }
        String string = pSSysContentCat.getCatTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatTag_Default(pSSysContentCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CatTag2(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isCatTag2Dirty() : !pSSysContentCat.isCatTag2Dirty()) {
            return null;
        }
        String string = pSSysContentCat.getCatTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatTag2_Default(pSSysContentCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isCodeNameDirty() : !pSSysContentCat.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysContentCat.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysContentCat, bl2, bl3);
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
                string3 = "PPSSYSCONTENTCATID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysContentCatDEModel(), "CODENAME", string3, pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isMemoDirty() : !pSSysContentCat.isMemoDirty()) {
            return null;
        }
        String string = pSSysContentCat.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isOrderValueDirty() : !pSSysContentCat.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysContentCat.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysContentCatId(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isPPSSysContentCatIdDirty() : !pSSysContentCat.isPPSSysContentCatIdDirty()) {
            return null;
        }
        String string = pSSysContentCat.getPPSSysContentCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysContentCatId_Default(pSSysContentCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSCONTENTCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isPSModuleIdDirty() : !pSSysContentCat.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysContentCat.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysContentCatId(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isPSSysContentCatIdDirty() && !bl2 : !pSSysContentCat.isPSSysContentCatIdDirty()) {
            return null;
        }
        String string = pSSysContentCat.getPSSysContentCatId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCONTENTCATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysContentCatId_Default(pSSysContentCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCONTENTCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysContentCatName(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isPSSysContentCatNameDirty() && !bl2 : !pSSysContentCat.isPSSysContentCatNameDirty()) {
            return null;
        }
        String string = pSSysContentCat.getPSSysContentCatName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCONTENTCATNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysContentCatName_Default(pSSysContentCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCONTENTCATNAME");
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
                string3 = "PPSSYSCONTENTCATID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysContentCatDEModel(), "PSSYSCONTENTCATNAME", string3, pSSysContentCat, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSCONTENTCATNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isPSSysDynaModelIdDirty() : !pSSysContentCat.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysContentCat.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysContentCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isPSSystemIdDirty() : !pSSysContentCat.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysContentCat.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isPSSystemNameDirty() : !pSSysContentCat.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysContentCat.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_Subject(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isSubjectDirty() : !pSSysContentCat.isSubjectDirty()) {
            return null;
        }
        String string = pSSysContentCat.getSubject();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Subject_Default(pSSysContentCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBJECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tags(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isTagsDirty() : !pSSysContentCat.isTagsDirty()) {
            return null;
        }
        String string = pSSysContentCat.getTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tags_Default(pSSysContentCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isUserCatDirty() : !pSSysContentCat.isUserCatDirty()) {
            return null;
        }
        String string = pSSysContentCat.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isUserTagDirty() : !pSSysContentCat.isUserTagDirty()) {
            return null;
        }
        String string = pSSysContentCat.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isUserTag2Dirty() : !pSSysContentCat.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysContentCat.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isUserTag3Dirty() : !pSSysContentCat.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysContentCat.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysContentCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysContentCat pSSysContentCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysContentCat.isUserTag4Dirty() : !pSSysContentCat.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysContentCat.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysContentCat, bl2, bl3);
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

    protected void onSyncEntity(PSSysContentCat pSSysContentCat, boolean bl) throws Exception {
        super.onSyncEntity(pSSysContentCat, bl);
    }

    protected void onSyncIndexEntities(PSSysContentCat pSSysContentCat, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysContentCat, bl);
    }

    public Object getDataContextValue(PSSysContentCat pSSysContentCat, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysContentCat, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysContentCat.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysContentCat pSSysContentCat, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysContentCat, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CATTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CATTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatTag2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSCONTENTCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysContentCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSCONTENTCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysContentCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCONTENTCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysContentCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCONTENTCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysContentCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBJECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Subject_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tags_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CatTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CatTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSSysContentCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSCONTENTCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysContentCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSCONTENTCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysContentCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCONTENTCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysContentCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCONTENTCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Subject_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBJECT", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tags_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysContentCat pSSysContentCat) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysContentCat)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysContentCat pSSysContentCat) throws Exception {
        super.onUpdateParent(pSSysContentCat);
    }

    @Override
    protected void exportCurXmlModel(PSSysContentCat pSSysContentCat, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCONTENTCAT");
        if (!bl) {
            pSSysContentCat.setCreateDate(null);
            pSSysContentCat.setCreateMan(null);
            pSSysContentCat.setPSSysContentCatId(null);
            pSSysContentCat.setUpdateDate(null);
            pSSysContentCat.setUpdateMan(null);
            super.exportCurXmlModel(pSSysContentCat, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysContentCat pSSysContentCat, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysContentCat, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSCONTENTCATID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSCONTENTCAT#%1$s", (Object)string);
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSCONTENTCATID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCONTENTCAT_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCONTENTCAT_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSCONTENTCATID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSCONTENTCATNAME", null);
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
        if (StringHelper.compare((String)string, (String)"PSSYSCONTENTCAT", (boolean)true) == 0) {
            iEntity.set("PPSSYSCONTENTCATID", (Object)string2);
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
        return new String[]{"PPSSYSCONTENTCATID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysContentCat pSSysContentCat) {
        if (!StringHelper.isNullOrEmpty((String)pSSysContentCat.getCodeName())) {
            return pSSysContentCat.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysContentCat.getPSSysContentCatName())) {
            return pSSysContentCat.getPSSysContentCatName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysContentCat.getCodeName())) {
            return pSSysContentCat.getCodeName();
        }
        return super.getModelV2Tag(pSSysContentCat);
    }

    @Override
    public boolean setModelV2Tag(PSSysContentCat pSSysContentCat, String string) {
        pSSysContentCat.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSCONTENTCATNAME", "");
        map.put("CODENAME", "");
        map.put("PPSSYSCONTENTCATID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysContentCat pSSysContentCat, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysContentCat.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysContentCat, true);
        pSSysContentCat.set("CODENAME", string);
        if (this.select(pSSysContentCat, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysContentCat, true);
        return super.getModelV2Entity(pSSysContentCat, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysContentCat pSSysContentCat, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysContentCat, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysContentCat pSSysContentCat, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSCONTENTCAT#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSCONTENTCAT", (Object)pSSysContentCat.getPSSysContentCatId()))).exists()) {
            pSCoreSysServiceBase = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysContentCat();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysContentCatServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysContentCat)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSCONTENTCAT", (Object)((PSSysContentCat)entityBase).getPSSysContentCatId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSCONTENTCAT#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSCONTENT", (Object)pSSysContentCat.getPSSysContentCatId()))).exists()) {
            pSCoreSysServiceBase = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysContent();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysContentServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysContent)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSCONTENT", (Object)((PSSysContent)entityBase).getPSSysContentId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysContentCat, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysContentCat pSSysContentCat, ObjectNode objectNode, String string, boolean bl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID")) {
            pSCoreSysServiceBase = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> categories = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSCONTENTCAT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSCONTENTCAT", (Object)pSSysContentCat.getPSSysContentCatId()));
                if (file.exists()) {
                    categories = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        categories.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                categories = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSCONTENTCAT#%1$s", (Object)pSSysContentCat.getPSSysContentCatId());
                for (PSSysContentCat category : ((PSSysContentCatServiceBase)pSCoreSysServiceBase).selectByPPSSysContentCat(pSSysContentCat)) {
                    String categoryScope = ((PSSysContentCatServiceBase)pSCoreSysServiceBase).getModelV2ResScope(category);
                    if (StringHelper.compare(scope, categoryScope, false) != 0) continue;
                    categories.add(PSModelV2Helper.toJSONObject(category, false));
                }
            }
            if (categories != null && !categories.isEmpty()) {
                ArrayNode arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
                Collections.sort(categories, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssyscontentcatname")) {
                            string = objectNode.get("pssyscontentcatname").asText();
                        }
                        if (objectNode2.has("pssyscontentcatname")) {
                            string2 = objectNode2.get("pssyscontentcatname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode categoryNode : categories) {
                    PSSysContentCat category = new PSSysContentCat();
                    PSModelV2Helper.fromJSONObject((IDataObject)category, categoryNode, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(category, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID")) {
            pSCoreSysServiceBase = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> contents = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSCONTENTCAT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSCONTENT", (Object)pSSysContentCat.getPSSysContentCatId()));
                if (file.exists()) {
                    contents = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        contents.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                contents = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSCONTENTCAT#%1$s", (Object)pSSysContentCat.getPSSysContentCatId());
                for (PSSysContent content : ((PSSysContentServiceBase)pSCoreSysServiceBase).selectByPSSysContentCat(pSSysContentCat)) {
                    String contentScope = ((PSSysContentServiceBase)pSCoreSysServiceBase).getModelV2ResScope(content);
                    if (StringHelper.compare(scope, contentScope, false) != 0) continue;
                    contents.add(PSModelV2Helper.toJSONObject(content, false));
                }
            }
            if (contents != null && !contents.isEmpty()) {
                ArrayNode arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
                Collections.sort(contents, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssyscontentname")) {
                            string = objectNode.get("pssyscontentname").asText();
                        }
                        if (objectNode2.has("pssyscontentname")) {
                            string2 = objectNode2.get("pssyscontentname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode contentNode : contents) {
                    PSSysContent content = new PSSysContent();
                    PSModelV2Helper.fromJSONObject((IDataObject)content, contentNode, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(content, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysContentCat, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysContentCat pSSysContentCat) throws Exception {
        super.onEmptyModelV2(pSSysContentCat);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysContentCat pSSysContentCat, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysContentCat();
        entityBase.set("PPSSYSCONTENTCATID", pSSysContentCat.getPSSysContentCatId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysContent();
        entityBase.set("PSSYSCONTENTCATID", pSSysContentCat.getPSSysContentCatId());
        pSCoreSysServiceBase = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysContentCat, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysContentCat pSSysContentCat, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSysContentCatServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    ObjectNode categoryNode = (ObjectNode)arrayNode.get(n2);
                    PSSysContentCat category = new PSSysContentCat();
                    category.setPPSSysContentCatId(pSSysContentCat.getPSSysContentCatId());
                    category.setPPSSysContentCatName(pSSysContentCat.getPSSysContentCatName());
                    pSCoreSysServiceBase.compileModelV2(category, categoryNode, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File folder = new File(string4);
                if (folder.exists()) {
                    File[] files = folder.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (!file.isDirectory()) continue;
                            PSSysContentCat category = new PSSysContentCat();
                            category.setPPSSysContentCatId(pSSysContentCat.getPSSysContentCatId());
                            category.setPPSSysContentCatName(pSSysContentCat.getPSSysContentCatName());
                            pSCoreSysServiceBase.compileModelV2(category, null, string, file.getCanonicalPath(), n);
                        }
                    }
                }
            }
        }
        if (!PSSysContentCatServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    ObjectNode contentNode = (ObjectNode)arrayNode.get(n2);
                    PSSysContent content = new PSSysContent();
                    content.setPSSysContentCatId(pSSysContentCat.getPSSysContentCatId());
                    content.setPSSysContentCatName(pSSysContentCat.getPSSysContentCatName());
                    pSCoreSysServiceBase.compileModelV2(content, contentNode, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File folder = new File(string5);
                if (folder.exists()) {
                    File[] files = folder.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (!file.isDirectory()) continue;
                            PSSysContent content = new PSSysContent();
                            content.setPSSysContentCatId(pSSysContentCat.getPSSysContentCatId());
                            content.setPSSysContentCatName(pSSysContentCat.getPSSysContentCatName());
                            pSCoreSysServiceBase.compileModelV2(content, null, string, file.getCanonicalPath(), n);
                        }
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysContentCat, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysContentCat pSSysContentCat, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysContentCats(pSSysContentCat, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysContents(pSSysContentCat, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysContentCat, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysContentCats(PSSysContentCat pSSysContentCat, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSCONTENTCAT", true), (boolean)false) == 0) {
            PSSysContentCatService pSSysContentCatService = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
            PSSysContentCat pSSysContentCat2 = new PSSysContentCat();
            pSSysContentCat2.setPSSysContentCatId(pSMOSFile.getPSModelId());
            if (!pSSysContentCatService.get(pSSysContentCat2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysContentCat2.getPPSSysContentCatId(), (String)pSSysContentCat.getPSSysContentCatId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysContentCatService.exportModelV2(pSSysContentCat2);
            pSSysContentCat2.reset();
            if (!pSSysContentCatService.setModelV2ResScope(pSSysContentCat2, "PSSYSCONTENTCAT", pSSysContentCat.getPSSysContentCatId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysContentCatService.importModelV2(pSSysContentCat2, objectNode);
            SessionFactoryManager.commit();
            return pSSysContentCatService.getFile(pSSysContentCat2);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysContents(PSSysContentCat pSSysContentCat, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSCONTENT", true), (boolean)false) == 0) {
            PSSysContentService pSSysContentService = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
            PSSysContent pSSysContent = new PSSysContent();
            pSSysContent.setPSSysContentId(pSMOSFile.getPSModelId());
            if (!pSSysContentService.get(pSSysContent, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysContent.getPSSysContentCatId(), (String)pSSysContentCat.getPSSysContentCatId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysContentService.exportModelV2(pSSysContent);
            pSSysContent.reset();
            if (!pSSysContentService.setModelV2ResScope(pSSysContent, "PSSYSCONTENTCAT", pSSysContentCat.getPSSysContentCatId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysContentService.importModelV2(pSSysContent, objectNode);
            SessionFactoryManager.commit();
            return pSSysContentService.getFile(pSSysContent);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysContentCat pSSysContentCat, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysContentCats(pSSysContentCat, list);
        this.onFillPasteHelps_PSSysContents(pSSysContentCat, list);
        super.onFillPasteHelps(pSSysContentCat, list);
    }

    protected void onFillPasteHelps_PSSysContentCats(PSSysContentCat pSSysContentCat, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSCONTENTCAT");
        pSHelpSection.setSectionParam2("DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5185\u5bb9\u5206\u7c7b]\u7684[\u7cfb\u7edf\u5185\u5bb9\u5206\u7c7b]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysContents(PSSysContentCat pSSysContentCat, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSCONTENT");
        pSHelpSection.setSectionParam2("DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5185\u5bb9\u5206\u7c7b]\u7684[\u7cfb\u7edf\u5185\u5bb9]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        ArrayList arrayList;
        SelectField selectField;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSMOSFile pSMOSFile2;
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5b50\u5206\u7c7b>", "DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID", "PPSSYSCONTENTCATID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysContentCatServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5b50\u5206\u7c7b>");
            } else if (PSSysContentCatServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyscontentcats");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID|PPSSYSCONTENTCATID");
            pSMOSFile2.setFileTag3("PSSYSCONTENTCAT");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID", "PPSSYSCONTENTCATID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID", "PPSSYSCONTENTCATID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysContentCatServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5185\u5bb9>", "DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID", "PSSYSCONTENTCATID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysContentCatServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5185\u5bb9>");
            } else if (PSSysContentCatServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyscontents");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID|PSSYSCONTENTCATID");
            pSMOSFile2.setFileTag3("PSSYSCONTENT");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID", "PSSYSCONTENTCATID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID", "PSSYSCONTENTCATID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysContentCatServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        PSMOSFile pSMOSFile2;
        ArrayList<? extends IEntity> arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSSysContentCatServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5b50\u5206\u7c7b>", (boolean)false) == 0 || PSSysContentCatServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysContentCats", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID", "PPSSYSCONTENTCATID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (IEntity entity : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entity, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysContentCatServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5185\u5bb9>", (boolean)false) == 0 || PSSysContentCatServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysContents", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID", "PSSYSCONTENTCATID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (IEntity entity : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entity, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (arrayList2.size() > 0) {
            return PSMOSFileUtil.append(arrayList2.toArray(new PSMOSFile[arrayList2.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSCONTENTCAT_PSSYSCONTENTCAT_PPSSYSCONTENTCATID", (boolean)false) == 0) {
            if (PSSysContentCatServiceBase.getMOSVer() == 1) {
                return "<\u5b50\u5206\u7c7b>";
            }
            if (PSSysContentCatServiceBase.getMOSVer() == 2) {
                return "pssyscontentcats";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSCONTENT_PSSYSCONTENTCAT_PSSYSCONTENTCATID", (boolean)false) == 0) {
            if (PSSysContentCatServiceBase.getMOSVer() == 1) {
                return "<\u5185\u5bb9>";
            }
            if (PSSysContentCatServiceBase.getMOSVer() == 2) {
                return "pssyscontents";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysContentCat pSSysContentCat, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "ContentCat");
        defaultValueMap.put("PSSYSCONTENTCATNAME", "\u5185\u5bb9\u5206\u7c7b");
    }
}
