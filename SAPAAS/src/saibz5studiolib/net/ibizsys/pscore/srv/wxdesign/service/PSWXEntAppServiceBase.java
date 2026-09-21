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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowServiceBase;
import net.ibizsys.pscore.srv.wxdesign.dao.PSWXEntAppDAO;
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXEntAppDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccountBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFuncBase;
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

public abstract class PSWXEntAppServiceBase
extends PSCoreSysServiceBase<PSWXEntApp> {
    private static final Log log = LogFactory.getLog(PSWXEntAppServiceBase.class);
    public static final String DATASET_CURWX = "CurWX";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWXEntAppDEModel pSWXEntAppDEModel;
    private PSWXEntAppDAO pSWXEntAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService";
    }

    public PSWXEntAppDEModel getPSWXEntAppDEModel() {
        if (this.pSWXEntAppDEModel == null) {
            try {
                this.pSWXEntAppDEModel = (PSWXEntAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXEntAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXEntAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWXEntAppDEModel();
    }

    public PSWXEntAppDAO getPSWXEntAppDAO() {
        if (this.pSWXEntAppDAO == null) {
            try {
                this.pSWXEntAppDAO = (PSWXEntAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wxdesign.dao.PSWXEntAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXEntAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWXEntAppDAO();
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

    protected void onFillParentInfo(PSWXEntApp pSWXEntApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXENTAPP_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSWXEntApp, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXENTAPP_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSWXEntApp, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXENTAPP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSWXEntApp, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXENTAPP_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory());
            PSWXAccount pSWXAccount = (PSWXAccount)iService.getDEModel().createEntity();
            pSWXAccount.set("PSWXACCOUNTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWXAccount);
            } else {
                iService.get((IEntity)pSWXAccount);
            }
            this.onFillParentInfo_PSWXAccount(pSWXEntApp, pSWXAccount);
            return;
        }
        super.onFillParentInfo((IEntity)pSWXEntApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysApp(PSWXEntApp pSWXEntApp, PSSysApp pSSysApp) throws Exception {
        pSWXEntApp.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSWXEntApp.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysResource(PSWXEntApp pSWXEntApp, PSSysResource pSSysResource) throws Exception {
        pSWXEntApp.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSWXEntApp.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSWXEntApp pSWXEntApp, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSWXEntApp.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSWXEntApp.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSWXAccount(PSWXEntApp pSWXEntApp, PSWXAccount pSWXAccount) throws Exception {
        pSWXEntApp.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
        pSWXEntApp.setPSWXAccountName(pSWXAccount.getPSWXAccountName());
    }

    protected void onFillEntityFullInfo(PSWXEntApp pSWXEntApp, boolean bl) throws Exception {
        if (bl) {
            if (pSWXEntApp.getPSWXLogicsCnt() == null) {
                pSWXEntApp.setPSWXLogicsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWXEntApp.getPSWXMenuFuncsCnt() == null) {
                pSWXEntApp.setPSWXMenuFuncsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWXEntApp.getPSWXMenusCnt() == null) {
                pSWXEntApp.setPSWXMenusCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWXEntApp.getValidFlag() == null) {
                pSWXEntApp.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSWXEntApp, bl);
        this.onFillEntityFullInfo_PSSysApp(pSWXEntApp, bl);
        this.onFillEntityFullInfo_PSSysResource(pSWXEntApp, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSWXEntApp, bl);
        this.onFillEntityFullInfo_PSWXAccount(pSWXEntApp, bl);
    }

    protected void onFillEntityFullInfo_PSSysApp(PSWXEntApp pSWXEntApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSWXEntApp pSWXEntApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSWXEntApp pSWXEntApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWXAccount(PSWXEntApp pSWXEntApp, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWXEntApp pSWXEntApp, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWXEntApp, bl);
    }

    public ArrayList<PSWXEntApp> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSWXEntApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSWXEntApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXEntApp> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSWXEntApp> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSWXEntApp> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXEntApp> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSWXEntApp> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSWXEntApp> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXEntApp> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, "", -1);
    }

    public ArrayList<PSWXEntApp> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, string, -1);
    }

    public ArrayList<PSWXEntApp> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSSysApp(pSSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXENTAPP_PSSYSAPP_PSSYSAPPID", "", iDataEntityModel.getName(), "PSWXENTAPP", iDataEntityModel.getDataInfo((IEntity)pSSysApp), arrayList.get(0)));
        }
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSWXEntApp pSWXEntApp : arrayList) {
            PSWXEntApp pSWXEntApp2 = (PSWXEntApp)this.getDEModel().createEntity();
            pSWXEntApp2.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
            pSWXEntApp2.setPSSysAppId(null);
            this.update(pSWXEntApp2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXEntAppServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSWXEntAppServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSWXEntAppServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSWXEntApp pSWXEntApp : arrayList) {
            this.remove((IEntity)pSWXEntApp);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSWXEntApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSWXEntApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXENTAPP_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSWXENTAPP", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSWXEntApp pSWXEntApp : arrayList) {
            PSWXEntApp pSWXEntApp2 = (PSWXEntApp)this.getDEModel().createEntity();
            pSWXEntApp2.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
            pSWXEntApp2.setPSSysResourceId(null);
            this.update(pSWXEntApp2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXEntAppServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSWXEntAppServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSWXEntAppServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSWXEntApp pSWXEntApp : arrayList) {
            this.remove((IEntity)pSWXEntApp);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSWXEntApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSWXEntApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXENTAPP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSWXENTAPP", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSWXEntApp pSWXEntApp : arrayList) {
            PSWXEntApp pSWXEntApp2 = (PSWXEntApp)this.getDEModel().createEntity();
            pSWXEntApp2.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
            pSWXEntApp2.setPSSysSFPluginId(null);
            this.update(pSWXEntApp2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXEntAppServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWXEntAppServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWXEntAppServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSWXEntApp pSWXEntApp : arrayList) {
            this.remove((IEntity)pSWXEntApp);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWXEntApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWXEntApp> arrayList) throws Exception {
    }

    public void testRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    public void resetPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSWXAccount(pSWXAccount);
        for (PSWXEntApp pSWXEntApp : arrayList) {
            PSWXEntApp pSWXEntApp2 = (PSWXEntApp)this.getDEModel().createEntity();
            pSWXEntApp2.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
            pSWXEntApp2.setPSWXAccountId(null);
            this.update(pSWXEntApp2);
        }
    }

    public void removeByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        final PSWXAccount pSWXAccount2 = pSWXAccount;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXEntAppServiceBase.this.onBeforeRemoveByPSWXAccount(pSWXAccount2);
                PSWXEntAppServiceBase.this.internalRemoveByPSWXAccount(pSWXAccount2);
                PSWXEntAppServiceBase.this.onAfterRemoveByPSWXAccount(pSWXAccount2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void internalRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWXEntApp> arrayList = this.selectByPSWXAccount(pSWXAccount);
        this.onBeforeRemoveByPSWXAccount(pSWXAccount, arrayList);
        for (PSWXEntApp pSWXEntApp : arrayList) {
            this.remove((IEntity)pSWXEntApp);
        }
        this.onAfterRemoveByPSWXAccount(pSWXAccount, arrayList);
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWXEntApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWXEntApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWXEntApp pSWXEntApp) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByPSWXEntApp(pSWXEntApp);
        pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSWXEntApp(pSWXEntApp);
        pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXMenuFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSWXEntApp(pSWXEntApp);
        ((PSWXMenuFuncServiceBase)pSCoreSysServiceBase).removeByPSWXEntApp(pSWXEntApp);
        pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXMenuServiceBase)pSCoreSysServiceBase).testRemoveByPSWXEntApp(pSWXEntApp);
        super.onBeforeRemove(pSWXEntApp);
    }

    protected void replaceParentInfo(PSWXEntApp pSWXEntApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSWXEntApp, cloneSession);
        if (pSWXEntApp.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSWXEntApp.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSWXEntApp, (PSSysApp)iEntity);
        }
        if (pSWXEntApp.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSWXEntApp.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSWXEntApp, (PSSysResource)iEntity);
        }
        if (pSWXEntApp.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSWXEntApp.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSWXEntApp, (PSSysSFPlugin)iEntity);
        }
        if (pSWXEntApp.getPSWXAccountId() != null && (iEntity = cloneSession.getEntity("PSWXACCOUNT", (Object)pSWXEntApp.getPSWXAccountId())) != null) {
            this.onFillParentInfo_PSWXAccount(pSWXEntApp, (PSWXAccount)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWXEntApp pSWXEntApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWXEntApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AppType(bl, pSWXEntApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppUrl(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXAccountId(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXEntAppId(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXEntAppName(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXLogicsCnt(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuFuncsCnt(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenusCnt(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RepEnterFlag(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RepLocationFlag(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXEntAppParams(bl, pSWXEntApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWXEntApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AppType(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isAppTypeDirty() && !bl2 : !pSWXEntApp.isAppTypeDirty()) {
            return null;
        }
        String string = pSWXEntApp.getAppType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppType_Default((IEntity)pSWXEntApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppUrl(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isAppUrlDirty() : !pSWXEntApp.isAppUrlDirty()) {
            return null;
        }
        String string = pSWXEntApp.getAppUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppUrl_Default((IEntity)pSWXEntApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isCodeNameDirty() && !bl2 : !pSWXEntApp.isCodeNameDirty()) {
            return null;
        }
        String string = pSWXEntApp.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSWXEntApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSWXACCOUNTID";
                String string4 = this.checkFieldDupRule(this.getPSWXEntAppDEModel(), "CODENAME", string3, pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isMemoDirty() : !pSWXEntApp.isMemoDirty()) {
            return null;
        }
        String string = pSWXEntApp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isOrderValueDirty() : !pSWXEntApp.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSWXEntApp.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isPSSysAppIdDirty() : !pSWXEntApp.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSWXEntApp.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isPSSysResourceIdDirty() : !pSWXEntApp.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSWXEntApp.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isPSSysSFPluginIdDirty() : !pSWXEntApp.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSWXEntApp.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXAccountId(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isPSWXAccountIdDirty() && !bl2 : !pSWXEntApp.isPSWXAccountIdDirty()) {
            return null;
        }
        String string = pSWXEntApp.getPSWXAccountId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXACCOUNTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXAccountId_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXEntAppId(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isPSWXEntAppIdDirty() && !bl2 : !pSWXEntApp.isPSWXEntAppIdDirty()) {
            return null;
        }
        String string = pSWXEntApp.getPSWXEntAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXENTAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXEntAppId_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXEntAppName(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isPSWXEntAppNameDirty() && !bl2 : !pSWXEntApp.isPSWXEntAppNameDirty()) {
            return null;
        }
        String string = pSWXEntApp.getPSWXEntAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXENTAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXEntAppName_Default((IEntity)pSWXEntApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXENTAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXLogicsCnt(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isPSWXLogicsCntDirty() : !pSWXEntApp.isPSWXLogicsCntDirty()) {
            return null;
        }
        Integer n = pSWXEntApp.getPSWXLogicsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSWXLogicsCnt_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXMenuFuncsCnt(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isPSWXMenuFuncsCntDirty() : !pSWXEntApp.isPSWXMenuFuncsCntDirty()) {
            return null;
        }
        Integer n = pSWXEntApp.getPSWXMenuFuncsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSWXMenuFuncsCnt_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXMenusCnt(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isPSWXMenusCntDirty() : !pSWXEntApp.isPSWXMenusCntDirty()) {
            return null;
        }
        Integer n = pSWXEntApp.getPSWXMenusCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSWXMenusCnt_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_RepEnterFlag(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isRepEnterFlagDirty() : !pSWXEntApp.isRepEnterFlagDirty()) {
            return null;
        }
        Integer n = pSWXEntApp.getRepEnterFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RepEnterFlag_Default((IEntity)pSWXEntApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPENTERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RepLocationFlag(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isRepLocationFlagDirty() : !pSWXEntApp.isRepLocationFlagDirty()) {
            return null;
        }
        Integer n = pSWXEntApp.getRepLocationFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RepLocationFlag_Default((IEntity)pSWXEntApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPLOCATIONFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isUserCatDirty() : !pSWXEntApp.isUserCatDirty()) {
            return null;
        }
        String string = pSWXEntApp.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isUserTagDirty() : !pSWXEntApp.isUserTagDirty()) {
            return null;
        }
        String string = pSWXEntApp.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isUserTag2Dirty() : !pSWXEntApp.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWXEntApp.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isUserTag3Dirty() : !pSWXEntApp.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWXEntApp.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isUserTag4Dirty() : !pSWXEntApp.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWXEntApp.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isValidFlagDirty() && !bl2 : !pSWXEntApp.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSWXEntApp.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSWXEntApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_WXEntAppParams(boolean bl, PSWXEntApp pSWXEntApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXEntApp.isWXEntAppParamsDirty() : !pSWXEntApp.isWXEntAppParamsDirty()) {
            return null;
        }
        String string = pSWXEntApp.getWXEntAppParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WXEntAppParams_Default((IEntity)pSWXEntApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXENTAPPPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWXEntApp pSWXEntApp, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWXEntApp, bl);
    }

    protected void onSyncIndexEntities(PSWXEntApp pSWXEntApp, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWXEntApp, bl);
    }

    public Object getDataContextValue(PSWXEntApp pSWXEntApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWXEntApp, string, iDataContextParam)) != null) {
            return object;
        }
        PSWXAccount pSWXAccount = pSWXEntApp.getPSWXAccount();
        if (pSWXAccount != null && pSWXAccount.contains(string)) {
            return pSWXAccount.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWXEntApp pSWXEntApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSWXEntApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppUrl_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSWXLOGICSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXLogicsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUFUNCSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuFuncsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenusCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPENTERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RepEnterFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPLOCATIONFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RepLocationFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WXENTAPPPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WXEntAppParams_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AppType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPURL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSWXLogicsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSWXMenuFuncsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSWXMenusCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RepEnterFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RepLocationFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WXEntAppParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXENTAPPPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWXEntApp pSWXEntApp) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXLOGIC_PSWXENTAPP_PSWXENTAPPID", (boolean)true) == 0) && this.onMergeChild_PSWXLogics(pSWXEntApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENUFUNC_PSWXENTAPP_PSWXENTAPPID", (boolean)true) == 0) && this.onMergeChild_PSWXMenuFuncs(pSWXEntApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID", (boolean)true) == 0) && this.onMergeChild_PSWXMenus(pSWXEntApp)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSWXEntApp)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSWXLogics(PSWXEntApp pSWXEntApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSWXLOGICSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWXEntApp.getPSWXEntAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWXENTAPPID", (Object)pSWXEntApp.getPSWXEntAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWXEntApp, false);
        return true;
    }

    protected boolean onMergeChild_PSWXMenuFuncs(PSWXEntApp pSWXEntApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSWXMENUFUNCSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWXEntApp.getPSWXEntAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWXENTAPPID", (Object)pSWXEntApp.getPSWXEntAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWXEntApp, false);
        return true;
    }

    protected boolean onMergeChild_PSWXMenus(PSWXEntApp pSWXEntApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSWXMENUSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWXEntApp.getPSWXEntAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWXENTAPPID", (Object)pSWXEntApp.getPSWXEntAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWXEntApp, false);
        return true;
    }

    protected void onUpdateParent(PSWXEntApp pSWXEntApp) throws Exception {
        Object object = pSWXEntApp.get("PSWXACCOUNTID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWXENTAPP_PSWXACCOUNT_PSWXACCOUNTID", object);
        }
        super.onUpdateParent((IEntity)pSWXEntApp);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSWXEntApp pSWXEntApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWXENTAPP");
        if (!bl) {
            pSWXEntApp.setCreateDate(null);
            pSWXEntApp.setCreateMan(null);
            pSWXEntApp.setPSWXEntAppId(null);
            pSWXEntApp.setUpdateDate(null);
            pSWXEntApp.setUpdateMan(null);
            super.exportCurXmlModel(pSWXEntApp, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWXEntApp pSWXEntApp, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWXEntApp, string);
        objectNode.remove("pswxlogicscnt");
        objectNode.remove("pswxmenufuncscnt");
        objectNode.remove("pswxmenuscnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWXACCOUNT#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWXENTAPP_PSWXACCOUNT_PSWXACCOUNTID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWXACCOUNT", (boolean)true) == 0) {
            iEntity.set("PSWXACCOUNTID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWXACCOUNTID"};
    }

    @Override
    public String getModelV2Tag(PSWXEntApp pSWXEntApp) {
        if (!StringHelper.isNullOrEmpty((String)pSWXEntApp.getCodeName())) {
            return pSWXEntApp.getCodeName();
        }
        return super.getModelV2Tag(pSWXEntApp);
    }

    @Override
    public boolean setModelV2Tag(PSWXEntApp pSWXEntApp, String string) {
        pSWXEntApp.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSWXACCOUNTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWXEntApp pSWXEntApp, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWXEntApp.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWXEntApp, true);
        pSWXEntApp.set("CODENAME", string);
        if (this.select(pSWXEntApp, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWXEntApp, true);
        return super.getModelV2Entity(pSWXEntApp, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWXEntApp pSWXEntApp, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWXEntApp, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSWXMENUFUNC_PSWXENTAPP_PSWXENTAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSWXEntApp pSWXEntApp, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXENTAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWXMENU", (Object)pSWXEntApp.getPSWXEntAppId()))).exists()) {
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
        if (this.isExportRelatedModelV2("DER1N_PSWXMENUFUNC_PSWXENTAPP_PSWXENTAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXENTAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWXMENUFUNC", (Object)pSWXEntApp.getPSWXEntAppId()))).exists()) {
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
        super.onExportRelatedModelV2(pSWXEntApp, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSWXEntApp pSWXEntApp, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSWXMenu> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID")) {
            pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXENTAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWXMENU", (Object)pSWXEntApp.getPSWXEntAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSWXMenu)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSWXMenu>();
                object3 = ((PSWXMenuServiceBase)pSCoreSysServiceBase).selectByPSWXEntApp(pSWXEntApp);
                arrayNode = StringHelper.format((String)"PSWXENTAPP#%1$s", (Object)pSWXEntApp.getPSWXEntAppId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWXMenu)object2.next();
                    object = ((PSWXMenuServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWXMenu)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWXMENUFUNC_PSWXENTAPP_PSWXENTAPPID")) {
            pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXENTAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWXMENUFUNC", (Object)pSWXEntApp.getPSWXEntAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSWXMenu)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSWXMenuFuncServiceBase)pSCoreSysServiceBase).selectByPSWXEntApp(pSWXEntApp);
                arrayNode = StringHelper.format((String)"PSWXENTAPP#%1$s", (Object)pSWXEntApp.getPSWXEntAppId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWXMenuFunc)object2.next();
                    object = ((PSWXMenuFuncServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWXMenu)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSWXEntApp, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSWXEntApp pSWXEntApp) throws Exception {
        super.onEmptyModelV2(pSWXEntApp);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
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
    protected IEntity onGetRelatedModelV2Entity(PSWXEntApp pSWXEntApp, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSWXMenu();
        entityBase.set("PSWXENTAPPID", pSWXEntApp.getPSWXEntAppId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWXMenuFunc();
        entityBase.set("PSWXENTAPPID", pSWXEntApp.getPSWXEntAppId());
        pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSWXEntApp, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSWXEntApp pSWXEntApp, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSWXEntAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSWXMenu();
                    ((PSWXMenuBase)object).setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
                    ((PSWXMenuBase)object).setPSWXEntAppName(pSWXEntApp.getPSWXEntAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWXMenu();
                        entityBase.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
                        entityBase.setPSWXEntAppName(pSWXEntApp.getPSWXEntAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWXEntAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSWXMenuFunc();
                    ((PSWXMenuFuncBase)object).setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
                    ((PSWXMenuFuncBase)object).setPSWXEntAppName(pSWXEntApp.getPSWXEntAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWXMenuFunc();
                        entityBase.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
                        entityBase.setPSWXEntAppName(pSWXEntApp.getPSWXEntAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSWXEntApp, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSWXEntApp pSWXEntApp, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWXMenus(pSWXEntApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWXMENUFUNC_PSWXENTAPP_PSWXENTAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWXMenuFuncs(pSWXEntApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSWXEntApp, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSWXMenus(PSWXEntApp pSWXEntApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWXMENU", true), (boolean)false) == 0) {
            PSWXMenuService pSWXMenuService = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
            PSWXMenu pSWXMenu = new PSWXMenu();
            pSWXMenu.setPSWXMenuId(pSMOSFile.getPSModelId());
            if (!pSWXMenuService.get((IEntity)pSWXMenu, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWXMenu.getPSWXEntAppId(), (String)pSWXEntApp.getPSWXEntAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWXMenuService.exportModelV2(pSWXMenu);
            pSWXMenu.reset();
            if (!pSWXMenuService.setModelV2ResScope((IEntity)pSWXMenu, "PSWXENTAPP", pSWXEntApp.getPSWXEntAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWXMenuService.importModelV2(pSWXMenu, objectNode);
            SessionFactoryManager.commit();
            return pSWXMenuService.getFile((IEntity)pSWXMenu);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWXMenuFuncs(PSWXEntApp pSWXEntApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWXMENUFUNC", true), (boolean)false) == 0) {
            PSWXMenuFuncService pSWXMenuFuncService = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
            PSWXMenuFunc pSWXMenuFunc = new PSWXMenuFunc();
            pSWXMenuFunc.setPSWXMenuFuncId(pSMOSFile.getPSModelId());
            if (!pSWXMenuFuncService.get((IEntity)pSWXMenuFunc, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWXMenuFunc.getPSWXEntAppId(), (String)pSWXEntApp.getPSWXEntAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWXMenuFuncService.exportModelV2(pSWXMenuFunc);
            pSWXMenuFunc.reset();
            if (!pSWXMenuFuncService.setModelV2ResScope((IEntity)pSWXMenuFunc, "PSWXENTAPP", pSWXEntApp.getPSWXEntAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWXMenuFuncService.importModelV2(pSWXMenuFunc, objectNode);
            SessionFactoryManager.commit();
            return pSWXMenuFuncService.getFile((IEntity)pSWXMenuFunc);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSWXEntApp pSWXEntApp, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSWXMenus(pSWXEntApp, list);
        this.onFillPasteHelps_PSWXMenuFuncs(pSWXEntApp, list);
        super.onFillPasteHelps(pSWXEntApp, list);
    }

    protected void onFillPasteHelps_PSWXMenus(PSWXEntApp pSWXEntApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWXMENU");
        pSHelpSection.setSectionParam2("DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528]\u7684[\u5fae\u4fe1\u83dc\u5355]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWXMenuFuncs(PSWXEntApp pSWXEntApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWXMENUFUNC");
        pSHelpSection.setSectionParam2("DER1N_PSWXMENUFUNC_PSWXENTAPP_PSWXENTAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528]\u7684[\u5fae\u4fe1\u83dc\u5355\u529f\u80fd]");
        list.add(pSHelpSection);
    }
}

