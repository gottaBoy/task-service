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
package net.ibizsys.pscore.srv.wxdesign.service;

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
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowServiceBase;
import net.ibizsys.pscore.srv.wxdesign.dao.PSWXAccountDAO;
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXAccountDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntAppBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXLogic;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXLogicBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFuncBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppServiceBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicServiceBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncServiceBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXAccountServiceBase
extends PSCoreSysServiceBase<PSWXAccount> {
    private static final Log log = LogFactory.getLog(PSWXAccountServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWXAccountDEModel pSWXAccountDEModel;
    private PSWXAccountDAO pSWXAccountDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService";
    }

    public PSWXAccountDEModel getPSWXAccountDEModel() {
        if (this.pSWXAccountDEModel == null) {
            try {
                this.pSWXAccountDEModel = (PSWXAccountDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXAccountDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXAccountDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWXAccountDEModel();
    }

    public PSWXAccountDAO getPSWXAccountDAO() {
        if (this.pSWXAccountDAO == null) {
            try {
                this.pSWXAccountDAO = (PSWXAccountDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wxdesign.dao.PSWXAccountDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXAccountDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWXAccountDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSWXAccount pSWXAccount, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXACCOUNT_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSWXAccount, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXACCOUNT_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSWXAccount, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXACCOUNT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSWXAccount, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXACCOUNT_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSWXAccount, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSWXAccount, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSWXAccount pSWXAccount, PSModule pSModule) throws Exception {
        pSWXAccount.setPSModuleId(pSModule.getPSModuleId());
        pSWXAccount.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysResource(PSWXAccount pSWXAccount, PSSysResource pSSysResource) throws Exception {
        pSWXAccount.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSWXAccount.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSWXAccount pSWXAccount, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSWXAccount.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSWXAccount.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSWXAccount pSWXAccount, PSSystem pSSystem) throws Exception {
        pSWXAccount.setPSSystemId(pSSystem.getPSSystemId());
        pSWXAccount.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSWXAccount pSWXAccount, boolean bl) throws Exception {
        if (bl) {
            if (pSWXAccount.getPSWXEntAppsCnt() == null) {
                pSWXAccount.setPSWXEntAppsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWXAccount.getPSWXLogicsCnt() == null) {
                pSWXAccount.setPSWXLogicsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWXAccount.getPSWXMenuFuncsCnt() == null) {
                pSWXAccount.setPSWXMenuFuncsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWXAccount.getPSWXMenusCnt() == null) {
                pSWXAccount.setPSWXMenusCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSWXAccount, bl);
        this.onFillEntityFullInfo_PSModule(pSWXAccount, bl);
        this.onFillEntityFullInfo_PSSysResource(pSWXAccount, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSWXAccount, bl);
        this.onFillEntityFullInfo_PSSystem(pSWXAccount, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSWXAccount pSWXAccount, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSWXAccount pSWXAccount, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSWXAccount pSWXAccount, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSWXAccount pSWXAccount, boolean bl) throws Exception {
        if (pSWXAccount.isPSSystemIdDirty()) {
            if (pSWXAccount.getPSSystemId() != null) {
                if (pSWXAccount.getPSSystemId() == null || pSWXAccount.getPSSystemName() == null) {
                    PSSystem pSSystem = pSWXAccount.getPSSystem();
                    pSWXAccount.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSWXAccount.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWXAccount pSWXAccount, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWXAccount, bl);
    }

    public ArrayList<PSWXAccount> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSWXAccount> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSWXAccount> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXAccount> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSWXAccount> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSWXAccount> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWXAccount> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSWXAccount> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSWXAccount> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWXAccount> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSWXAccount> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSWXAccount> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSWXAccount> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXACCOUNT_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSWXACCOUNT", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSModule(pSModule);
        for (PSWXAccount pSWXAccount : arrayList) {
            PSWXAccount pSWXAccount2 = (PSWXAccount)this.getDEModel().createEntity();
            pSWXAccount2.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
            pSWXAccount2.setPSModuleId(null);
            this.update(pSWXAccount2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXAccountServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSWXAccountServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSWXAccountServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSWXAccount pSWXAccount : arrayList) {
            this.remove((IEntity)pSWXAccount);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSWXAccount> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSWXAccount> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXACCOUNT_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSWXACCOUNT", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSWXAccount pSWXAccount : arrayList) {
            PSWXAccount pSWXAccount2 = (PSWXAccount)this.getDEModel().createEntity();
            pSWXAccount2.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
            pSWXAccount2.setPSSysResourceId(null);
            this.update(pSWXAccount2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXAccountServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSWXAccountServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSWXAccountServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSWXAccount pSWXAccount : arrayList) {
            this.remove((IEntity)pSWXAccount);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSWXAccount> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSWXAccount> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXACCOUNT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSWXACCOUNT", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSWXAccount pSWXAccount : arrayList) {
            PSWXAccount pSWXAccount2 = (PSWXAccount)this.getDEModel().createEntity();
            pSWXAccount2.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
            pSWXAccount2.setPSSysSFPluginId(null);
            this.update(pSWXAccount2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXAccountServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWXAccountServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWXAccountServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSWXAccount pSWXAccount : arrayList) {
            this.remove((IEntity)pSWXAccount);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWXAccount> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWXAccount> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSSystem(pSSystem);
        for (PSWXAccount pSWXAccount : arrayList) {
            PSWXAccount pSWXAccount2 = (PSWXAccount)this.getDEModel().createEntity();
            pSWXAccount2.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
            pSWXAccount2.setPSSystemId(null);
            this.update(pSWXAccount2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXAccountServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSWXAccountServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSWXAccountServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSWXAccount> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSWXAccount pSWXAccount : arrayList) {
            this.remove((IEntity)pSWXAccount);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSWXAccount> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSWXAccount> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWXAccount pSWXAccount) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByPSWXAccount(pSWXAccount);
        pSCoreSysServiceBase = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXEntAppServiceBase)pSCoreSysServiceBase).testRemoveByPSWXAccount(pSWXAccount);
        ((PSWXEntAppServiceBase)pSCoreSysServiceBase).removeByPSWXAccount(pSWXAccount);
        pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSWXAccount(pSWXAccount);
        ((PSWXLogicServiceBase)pSCoreSysServiceBase).removeByPSWXAccount(pSWXAccount);
        pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXMenuFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSWXAccount(pSWXAccount);
        ((PSWXMenuFuncServiceBase)pSCoreSysServiceBase).removeByPSWXAccount(pSWXAccount);
        pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXMenuServiceBase)pSCoreSysServiceBase).testRemoveByPSWXAccount(pSWXAccount);
        ((PSWXMenuServiceBase)pSCoreSysServiceBase).removeByPSWXAccount(pSWXAccount);
        super.onBeforeRemove(pSWXAccount);
    }

    protected void replaceParentInfo(PSWXAccount pSWXAccount, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSWXAccount, cloneSession);
        if (pSWXAccount.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSWXAccount.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSWXAccount, (PSModule)iEntity);
        }
        if (pSWXAccount.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSWXAccount.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSWXAccount, (PSSysResource)iEntity);
        }
        if (pSWXAccount.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSWXAccount.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSWXAccount, (PSSysSFPlugin)iEntity);
        }
        if (pSWXAccount.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSWXAccount.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSWXAccount, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWXAccount pSWXAccount, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWXAccount, bl);
    }

    protected void onCheckEntity(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSWXAccount, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXAccountId(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXAccountName(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXEntAppsCnt(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXLogicsCnt(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuFuncsCnt(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenusCnt(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXAccountParams(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXAccountType(bl, pSWXAccount, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWXAccount, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isCodeNameDirty() && !bl2 : !pSWXAccount.isCodeNameDirty()) {
            return null;
        }
        String string = pSWXAccount.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSWXAccount, bl2, bl3);
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
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSWXAccountDEModel(), "CODENAME", string3, pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isLockFlagDirty() : !pSWXAccount.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSWXAccount.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isMemoDirty() : !pSWXAccount.isMemoDirty()) {
            return null;
        }
        String string = pSWXAccount.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSModuleIdDirty() : !pSWXAccount.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSWXAccount.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSSysResourceIdDirty() : !pSWXAccount.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSWXAccount.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSSysSFPluginIdDirty() : !pSWXAccount.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSWXAccount.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSSystemIdDirty() && !bl2 : !pSWXAccount.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSWXAccount.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSSystemNameDirty() && !bl2 : !pSWXAccount.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSWXAccount.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXAccountId(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSWXAccountIdDirty() && !bl2 : !pSWXAccount.isPSWXAccountIdDirty()) {
            return null;
        }
        String string = pSWXAccount.getPSWXAccountId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXACCOUNTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXAccountId_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXAccountName(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSWXAccountNameDirty() && !bl2 : !pSWXAccount.isPSWXAccountNameDirty()) {
            return null;
        }
        String string = pSWXAccount.getPSWXAccountName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXACCOUNTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXAccountName_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXACCOUNTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXEntAppsCnt(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSWXEntAppsCntDirty() : !pSWXAccount.isPSWXEntAppsCntDirty()) {
            return null;
        }
        Integer n = pSWXAccount.getPSWXEntAppsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSWXEntAppsCnt_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXENTAPPSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXLogicsCnt(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSWXLogicsCntDirty() : !pSWXAccount.isPSWXLogicsCntDirty()) {
            return null;
        }
        Integer n = pSWXAccount.getPSWXLogicsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSWXLogicsCnt_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXLOGICSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuFuncsCnt(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSWXMenuFuncsCntDirty() : !pSWXAccount.isPSWXMenuFuncsCntDirty()) {
            return null;
        }
        Integer n = pSWXAccount.getPSWXMenuFuncsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSWXMenuFuncsCnt_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUFUNCSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenusCnt(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isPSWXMenusCntDirty() : !pSWXAccount.isPSWXMenusCntDirty()) {
            return null;
        }
        Integer n = pSWXAccount.getPSWXMenusCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSWXMenusCnt_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isUserCatDirty() : !pSWXAccount.isUserCatDirty()) {
            return null;
        }
        String string = pSWXAccount.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isUserTagDirty() : !pSWXAccount.isUserTagDirty()) {
            return null;
        }
        String string = pSWXAccount.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isUserTag2Dirty() : !pSWXAccount.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWXAccount.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isUserTag3Dirty() : !pSWXAccount.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWXAccount.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isUserTag4Dirty() : !pSWXAccount.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWXAccount.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSWXAccount, bl2, bl3);
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

    protected EntityFieldError onCheckField_WXAccountParams(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isWXAccountParamsDirty() : !pSWXAccount.isWXAccountParamsDirty()) {
            return null;
        }
        String string = pSWXAccount.getWXAccountParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WXAccountParams_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXACCOUNTPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXAccountType(boolean bl, PSWXAccount pSWXAccount, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXAccount.isWXAccountTypeDirty() && !bl2 : !pSWXAccount.isWXAccountTypeDirty()) {
            return null;
        }
        String string = pSWXAccount.getWXAccountType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXACCOUNTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_WXAccountType_Default((IEntity)pSWXAccount, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXACCOUNTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWXAccount pSWXAccount, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWXAccount, bl);
    }

    protected void onSyncIndexEntities(PSWXAccount pSWXAccount, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWXAccount, bl);
    }

    public Object getDataContextValue(PSWXAccount pSWXAccount, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWXAccount, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWXAccount pSWXAccount, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSWXAccount, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXACCOUNTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXAccountId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXACCOUNTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXAccountName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXENTAPPSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXEntAppsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXLOGICSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXLogicsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUFUNCSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuFuncsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenusCnt_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WXACCOUNTPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WXAccountParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WXACCOUNTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WXAccountType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSWXEntAppsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSWXLogicsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSWXMenuFuncsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSWXMenusCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_WXAccountParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXACCOUNTPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WXAccountType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXACCOUNTTYPE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWXAccount pSWXAccount) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXENTAPP_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) && this.onMergeChild_PSWXEntApps(pSWXAccount)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXLOGIC_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) && this.onMergeChild_PSWXLogics(pSWXAccount)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENUFUNC_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) && this.onMergeChild_PSWXMenuFuncs(pSWXAccount)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENU_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) && this.onMergeChild_PSWXMenus(pSWXAccount)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSWXAccount)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSWXEntApps(PSWXAccount pSWXAccount) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSWXENTAPPSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWXAccount.getPSWXAccountId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWXACCOUNTID", (Object)pSWXAccount.getPSWXAccountId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWXAccount, false);
        return true;
    }

    protected boolean onMergeChild_PSWXLogics(PSWXAccount pSWXAccount) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSWXLOGICSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWXAccount.getPSWXAccountId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWXACCOUNTID", (Object)pSWXAccount.getPSWXAccountId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWXAccount, false);
        return true;
    }

    protected boolean onMergeChild_PSWXMenuFuncs(PSWXAccount pSWXAccount) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSWXMENUFUNCSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWXAccount.getPSWXAccountId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWXACCOUNTID", (Object)pSWXAccount.getPSWXAccountId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWXAccount, false);
        return true;
    }

    protected boolean onMergeChild_PSWXMenus(PSWXAccount pSWXAccount) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSWXMENUSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWXAccount.getPSWXAccountId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWXACCOUNTID", (Object)pSWXAccount.getPSWXAccountId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWXAccount, false);
        return true;
    }

    protected void onUpdateParent(PSWXAccount pSWXAccount) throws Exception {
        super.onUpdateParent((IEntity)pSWXAccount);
    }

    @Override
    protected void exportCurXmlModel(PSWXAccount pSWXAccount, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWXACCOUNT");
        if (!bl) {
            pSWXAccount.setCreateDate(null);
            pSWXAccount.setCreateMan(null);
            pSWXAccount.setPSWXAccountId(null);
            pSWXAccount.setPSWXEntAppsCnt(null);
            pSWXAccount.setPSWXLogicsCnt(null);
            pSWXAccount.setPSWXMenuFuncsCnt(null);
            pSWXAccount.setPSWXMenusCnt(null);
            pSWXAccount.setUpdateDate(null);
            pSWXAccount.setUpdateMan(null);
            super.exportCurXmlModel(pSWXAccount, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWXAccount pSWXAccount, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWXAccount, string);
        objectNode.remove("pswxentappscnt");
        objectNode.remove("pswxlogicscnt");
        objectNode.remove("pswxmenufuncscnt");
        objectNode.remove("pswxmenuscnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWXACCOUNT_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWXACCOUNT_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
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
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSWXAccount pSWXAccount) {
        if (!StringHelper.isNullOrEmpty((String)pSWXAccount.getCodeName())) {
            return pSWXAccount.getCodeName();
        }
        return super.getModelV2Tag(pSWXAccount);
    }

    @Override
    public boolean setModelV2Tag(PSWXAccount pSWXAccount, String string) {
        pSWXAccount.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWXAccount pSWXAccount, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWXAccount.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWXAccount, true);
        pSWXAccount.set("CODENAME", string);
        if (this.select(pSWXAccount, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWXAccount, true);
        return super.getModelV2Entity(pSWXAccount, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWXAccount pSWXAccount, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWXAccount, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSWXENTAPP_PSWXACCOUNT_PSWXACCOUNTID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSWXLOGIC_PSWXACCOUNT_PSWXACCOUNTID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 40;
        }
        if (StringHelper.compare((String)"DER1N_PSWXMENU_PSWXACCOUNT_PSWXACCOUNTID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 40;
        }
        if (StringHelper.compare((String)"DER1N_PSWXMENUFUNC_PSWXACCOUNT_PSWXACCOUNTID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSWXAccount pSWXAccount, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSWXENTAPP_PSWXACCOUNT_PSWXACCOUNTID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXACCOUNT#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWXENTAPP", (Object)pSWXAccount.getPSWXAccountId()))).exists()) {
            pSCoreSysServiceBase = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSWXEntApp();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSWXEntAppServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSWXEntApp)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWXENTAPP", (Object)entityBase.getPSWXEntAppId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSWXLOGIC_PSWXACCOUNT_PSWXACCOUNTID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXACCOUNT#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWXLOGIC", (Object)pSWXAccount.getPSWXAccountId()))).exists()) {
            pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSWXLogic();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSWXLogicServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSWXLogic)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWXLOGIC", (Object)entityBase.getPSWXLogicId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSWXMENU_PSWXACCOUNT_PSWXACCOUNTID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXACCOUNT#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWXMENU", (Object)pSWXAccount.getPSWXAccountId()))).exists()) {
            pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSWXMenu();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSWXMenuServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSWXMenu)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWXMENU", (Object)entityBase.getPSWXMenuId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSWXMENUFUNC_PSWXACCOUNT_PSWXACCOUNTID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXACCOUNT#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWXMENUFUNC", (Object)pSWXAccount.getPSWXAccountId()))).exists()) {
            pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSWXMenuFunc();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSWXMenuFuncServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSWXMenuFunc)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWXMENUFUNC", (Object)entityBase.getPSWXMenuFuncId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSWXAccount, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSWXAccount pSWXAccount, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSWXEntApp> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWXENTAPP_PSWXACCOUNT_PSWXACCOUNTID")) {
            pSCoreSysServiceBase = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXACCOUNT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWXENTAPP", (Object)pSWXAccount.getPSWXAccountId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSWXEntApp)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSWXEntApp>();
                object4 = ((PSWXEntAppServiceBase)pSCoreSysServiceBase).selectByPSWXAccount(pSWXAccount);
                object3 = StringHelper.format((String)"PSWXACCOUNT#%1$s", (Object)pSWXAccount.getPSWXAccountId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWXEntApp)object2.next();
                    object = ((PSWXEntAppServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWXEntApp)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("pswxentappname")) {
                            string = objectNode.get("pswxentappname").asText();
                        }
                        if (objectNode2.has("pswxentappname")) {
                            string2 = objectNode2.get("pswxentappname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWXEntApp();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWXLOGIC_PSWXACCOUNT_PSWXACCOUNTID")) {
            pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXACCOUNT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWXLOGIC", (Object)pSWXAccount.getPSWXAccountId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSWXEntApp)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWXLogicServiceBase)pSCoreSysServiceBase).selectByPSWXAccount(pSWXAccount);
                object3 = StringHelper.format((String)"PSWXACCOUNT#%1$s", (Object)pSWXAccount.getPSWXAccountId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWXLogic)object2.next();
                    object = ((PSWXLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWXEntApp)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("pswxlogicname")) {
                            string = objectNode.get("pswxlogicname").asText();
                        }
                        if (objectNode2.has("pswxlogicname")) {
                            string2 = objectNode2.get("pswxlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWXLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWXMENU_PSWXACCOUNT_PSWXACCOUNTID")) {
            pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXACCOUNT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWXMENU", (Object)pSWXAccount.getPSWXAccountId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSWXEntApp)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWXMenuServiceBase)pSCoreSysServiceBase).selectByPSWXAccount(pSWXAccount);
                object3 = StringHelper.format((String)"PSWXACCOUNT#%1$s", (Object)pSWXAccount.getPSWXAccountId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWXMenu)object2.next();
                    object = ((PSWXMenuServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWXEntApp)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("pswxmenuname")) {
                            string = objectNode.get("pswxmenuname").asText();
                        }
                        if (objectNode2.has("pswxmenuname")) {
                            string2 = objectNode2.get("pswxmenuname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWXMenu();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWXMENUFUNC_PSWXACCOUNT_PSWXACCOUNTID")) {
            pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXACCOUNT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWXMENUFUNC", (Object)pSWXAccount.getPSWXAccountId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSWXEntApp)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWXMenuFuncServiceBase)pSCoreSysServiceBase).selectByPSWXAccount(pSWXAccount);
                object3 = StringHelper.format((String)"PSWXACCOUNT#%1$s", (Object)pSWXAccount.getPSWXAccountId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWXMenuFunc)object2.next();
                    object = ((PSWXMenuFuncServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWXEntApp)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("pswxmenufuncname")) {
                            string = objectNode.get("pswxmenufuncname").asText();
                        }
                        if (objectNode2.has("pswxmenufuncname")) {
                            string2 = objectNode2.get("pswxmenufuncname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWXMenuFunc();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSWXAccount, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSWXAccount pSWXAccount) throws Exception {
        super.onEmptyModelV2(pSWXAccount);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSWXAccount pSWXAccount, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSWXEntApp();
        entityBase.set("PSWXACCOUNTID", pSWXAccount.getPSWXAccountId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWXLogic();
        entityBase.set("PSWXACCOUNTID", pSWXAccount.getPSWXAccountId());
        pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWXMenu();
        entityBase.set("PSWXACCOUNTID", pSWXAccount.getPSWXAccountId());
        pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWXMenuFunc();
        entityBase.set("PSWXACCOUNTID", pSWXAccount.getPSWXAccountId());
        pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSWXAccount, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSWXAccount pSWXAccount, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSWXAccountServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSWXEntApp();
                    ((PSWXEntAppBase)object).setPSWXAccountId(pSWXAccount.getPSWXAccountId());
                    ((PSWXEntAppBase)object).setPSWXAccountName(pSWXAccount.getPSWXAccountName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWXEntApp();
                        entityBase.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
                        entityBase.setPSWXAccountName(pSWXAccount.getPSWXAccountName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWXAccountServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSWXLogic();
                    ((PSWXLogicBase)object).setPSWXAccountId(pSWXAccount.getPSWXAccountId());
                    ((PSWXLogicBase)object).setPSWXAccountName(pSWXAccount.getPSWXAccountName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWXLogic();
                        entityBase.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
                        entityBase.setPSWXAccountName(pSWXAccount.getPSWXAccountName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWXAccountServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSWXMenu();
                    ((PSWXMenuBase)object).setPSWXAccountId(pSWXAccount.getPSWXAccountId());
                    ((PSWXMenuBase)object).setPSWXAccountName(pSWXAccount.getPSWXAccountName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWXMenu();
                        entityBase.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
                        entityBase.setPSWXAccountName(pSWXAccount.getPSWXAccountName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWXAccountServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSWXMenuFunc();
                    ((PSWXMenuFuncBase)object).setPSWXAccountId(pSWXAccount.getPSWXAccountId());
                    ((PSWXMenuFuncBase)object).setPSWXAccountName(pSWXAccount.getPSWXAccountName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string7);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWXMenuFunc();
                        entityBase.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
                        entityBase.setPSWXAccountName(pSWXAccount.getPSWXAccountName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSWXAccount, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSWXAccount pSWXAccount, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWXENTAPP_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWXEntApps(pSWXAccount, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWXLOGIC_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWXLogics(pSWXAccount, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWXMENU_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWXMenus(pSWXAccount, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWXMENUFUNC_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWXMenuFuncs(pSWXAccount, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSWXAccount, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSWXEntApps(PSWXAccount pSWXAccount, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWXENTAPP", true), (boolean)false) == 0) {
            PSWXEntAppService pSWXEntAppService = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
            PSWXEntApp pSWXEntApp = new PSWXEntApp();
            pSWXEntApp.setPSWXEntAppId(pSMOSFile.getPSModelId());
            if (!pSWXEntAppService.get((IEntity)pSWXEntApp, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWXEntApp.getPSWXAccountId(), (String)pSWXAccount.getPSWXAccountId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWXEntAppService.exportModelV2(pSWXEntApp);
            pSWXEntApp.reset();
            if (!pSWXEntAppService.setModelV2ResScope((IEntity)pSWXEntApp, "PSWXACCOUNT", pSWXAccount.getPSWXAccountId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWXEntAppService.importModelV2(pSWXEntApp, objectNode);
            SessionFactoryManager.commit();
            return pSWXEntAppService.getFile((IEntity)pSWXEntApp);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWXLogics(PSWXAccount pSWXAccount, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWXLOGIC", true), (boolean)false) == 0) {
            PSWXLogicService pSWXLogicService = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
            PSWXLogic pSWXLogic = new PSWXLogic();
            pSWXLogic.setPSWXLogicId(pSMOSFile.getPSModelId());
            if (!pSWXLogicService.get((IEntity)pSWXLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWXLogic.getPSWXAccountId(), (String)pSWXAccount.getPSWXAccountId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWXLogicService.exportModelV2(pSWXLogic);
            pSWXLogic.reset();
            if (!pSWXLogicService.setModelV2ResScope((IEntity)pSWXLogic, "PSWXACCOUNT", pSWXAccount.getPSWXAccountId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWXLogicService.importModelV2(pSWXLogic, objectNode);
            SessionFactoryManager.commit();
            return pSWXLogicService.getFile((IEntity)pSWXLogic);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWXMenus(PSWXAccount pSWXAccount, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWXMENU", true), (boolean)false) == 0) {
            PSWXMenuService pSWXMenuService = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
            PSWXMenu pSWXMenu = new PSWXMenu();
            pSWXMenu.setPSWXMenuId(pSMOSFile.getPSModelId());
            if (!pSWXMenuService.get((IEntity)pSWXMenu, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWXMenu.getPSWXAccountId(), (String)pSWXAccount.getPSWXAccountId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWXMenuService.exportModelV2(pSWXMenu);
            pSWXMenu.reset();
            if (!pSWXMenuService.setModelV2ResScope((IEntity)pSWXMenu, "PSWXACCOUNT", pSWXAccount.getPSWXAccountId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWXMenuService.importModelV2(pSWXMenu, objectNode);
            SessionFactoryManager.commit();
            return pSWXMenuService.getFile((IEntity)pSWXMenu);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWXMenuFuncs(PSWXAccount pSWXAccount, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWXMENUFUNC", true), (boolean)false) == 0) {
            PSWXMenuFuncService pSWXMenuFuncService = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
            PSWXMenuFunc pSWXMenuFunc = new PSWXMenuFunc();
            pSWXMenuFunc.setPSWXMenuFuncId(pSMOSFile.getPSModelId());
            if (!pSWXMenuFuncService.get((IEntity)pSWXMenuFunc, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWXMenuFunc.getPSWXAccountId(), (String)pSWXAccount.getPSWXAccountId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWXMenuFuncService.exportModelV2(pSWXMenuFunc);
            pSWXMenuFunc.reset();
            if (!pSWXMenuFuncService.setModelV2ResScope((IEntity)pSWXMenuFunc, "PSWXACCOUNT", pSWXAccount.getPSWXAccountId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWXMenuFuncService.importModelV2(pSWXMenuFunc, objectNode);
            SessionFactoryManager.commit();
            return pSWXMenuFuncService.getFile((IEntity)pSWXMenuFunc);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSWXAccount pSWXAccount, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSWXEntApps(pSWXAccount, list);
        this.onFillPasteHelps_PSWXLogics(pSWXAccount, list);
        this.onFillPasteHelps_PSWXMenus(pSWXAccount, list);
        this.onFillPasteHelps_PSWXMenuFuncs(pSWXAccount, list);
        super.onFillPasteHelps(pSWXAccount, list);
    }

    protected void onFillPasteHelps_PSWXEntApps(PSWXAccount pSWXAccount, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWXENTAPP");
        pSHelpSection.setSectionParam2("DER1N_PSWXENTAPP_PSWXACCOUNT_PSWXACCOUNTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5fae\u4fe1\u516c\u4f17\u53f7]\u7684[\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWXLogics(PSWXAccount pSWXAccount, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWXLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSWXLOGIC_PSWXACCOUNT_PSWXACCOUNTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5fae\u4fe1\u516c\u4f17\u53f7]\u7684[\u5fae\u4fe1\u4ea4\u4e92\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWXMenus(PSWXAccount pSWXAccount, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWXMENU");
        pSHelpSection.setSectionParam2("DER1N_PSWXMENU_PSWXACCOUNT_PSWXACCOUNTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5fae\u4fe1\u516c\u4f17\u53f7]\u7684[\u5fae\u4fe1\u83dc\u5355]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWXMenuFuncs(PSWXAccount pSWXAccount, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWXMENUFUNC");
        pSHelpSection.setSectionParam2("DER1N_PSWXMENUFUNC_PSWXACCOUNT_PSWXACCOUNTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5fae\u4fe1\u516c\u4f17\u53f7]\u7684[\u5fae\u4fe1\u83dc\u5355\u529f\u80fd]");
        list.add(pSHelpSection);
    }
}

