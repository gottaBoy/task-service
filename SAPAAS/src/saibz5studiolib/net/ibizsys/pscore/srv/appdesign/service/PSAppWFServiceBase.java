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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppWFDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppWFDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModuleBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWF;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWFVer;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFVerService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppWFServiceBase
extends PSCoreSysServiceBase<PSAppWF> {
    private static final Log log = LogFactory.getLog(PSAppWFServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURAPPVALID = "CurAppValid";
    public static final String DATASET_CURWF = "CurWF";
    public static final String DATASET_CURWFVALID = "CurWFValid";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppWFDEModel pSAppWFDEModel;
    private PSAppWFDAO pSAppWFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppWFService";
    }

    public PSAppWFDEModel getPSAppWFDEModel() {
        if (this.pSAppWFDEModel == null) {
            try {
                this.pSAppWFDEModel = (PSAppWFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppWFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppWFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppWFDEModel();
    }

    public PSAppWFDAO getPSAppWFDAO() {
        if (this.pSAppWFDAO == null) {
            try {
                this.pSAppWFDAO = (PSAppWFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppWFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppWFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppWFDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPVALID, (boolean)true) == 0) {
            return this.fetchCurAppValid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWF, (boolean)true) == 0) {
            return this.fetchCurWF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWFVALID, (boolean)true) == 0) {
            return this.fetchCurWFValid(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurAppValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPVALID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurWF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurWFValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWFVALID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSAppWF pSAppWF, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPWF_PSAPPMODULE_PSAPPMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService", (SessionFactory)this.getSessionFactory());
            PSAppModule pSAppModule = (PSAppModule)iService.getDEModel().createEntity();
            pSAppModule.set("PSAPPMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppModule);
            } else {
                iService.get(pSAppModule);
            }
            this.onFillParentInfo_PSAppModule(pSAppWF, pSAppModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppWF, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkflow);
            } else {
                iService.get(pSWorkflow);
            }
            this.onFillParentInfo_PSWorkflow(pSAppWF, pSWorkflow);
            return;
        }
        super.onFillParentInfo(pSAppWF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppModule(PSAppWF pSAppWF, PSAppModule pSAppModule) throws Exception {
        pSAppWF.setPSAppModuleId(pSAppModule.getPSAppModuleId());
        pSAppWF.setPSAppModuleName(pSAppModule.getPSAppModuleName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppWF pSAppWF, PSSysApp pSSysApp) throws Exception {
        pSAppWF.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppWF.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSWorkflow(PSAppWF pSAppWF, PSWorkflow pSWorkflow) throws Exception {
        pSAppWF.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
        pSAppWF.setPSWorkflowName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillEntityFullInfo(PSAppWF pSAppWF, boolean bl) throws Exception {
        if (bl && pSAppWF.getValidFlag() == null) {
            pSAppWF.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSAppWF, bl);
        this.onFillEntityFullInfo_PSAppModule(pSAppWF, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppWF, bl);
        this.onFillEntityFullInfo_PSWorkflow(pSAppWF, bl);
    }

    protected void onFillEntityFullInfo_PSAppModule(PSAppWF pSAppWF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppWF pSAppWF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWorkflow(PSAppWF pSAppWF, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppWF pSAppWF, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppWF, bl);
    }

    public ArrayList<PSAppWF> selectByPSAppModule(PSAppModuleBase pSAppModuleBase) throws Exception {
        return this.selectByPSAppModule(pSAppModuleBase, "", -1);
    }

    public ArrayList<PSAppWF> selectByPSAppModule(PSAppModuleBase pSAppModuleBase, String string) throws Exception {
        return this.selectByPSAppModule(pSAppModuleBase, string, -1);
    }

    public ArrayList<PSAppWF> selectByPSAppModule(PSAppModuleBase pSAppModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPMODULEID", (Object)pSAppModuleBase.getPSAppModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppWF> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppWF> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppWF> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppWF> selectByPSWorkflow(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWorkflow(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSAppWF> selectByPSWorkflow(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWorkflow(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSAppWF> selectByPSWorkflow(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWORKFLOWID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWorkflowCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWorkflowCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<PSAppWF> arrayList = this.selectByPSAppModule(pSAppModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPWF_PSAPPMODULE_PSAPPMODULEID", "", iDataEntityModel.getName(), "PSAPPWF", iDataEntityModel.getDataInfo(pSAppModule), arrayList.get(0)));
        }
    }

    public void resetPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<PSAppWF> arrayList = this.selectByPSAppModule(pSAppModule);
        for (PSAppWF pSAppWF : arrayList) {
            PSAppWF pSAppWF2 = (PSAppWF)this.getDEModel().createEntity();
            pSAppWF2.setPSAppWFId(pSAppWF.getPSAppWFId());
            pSAppWF2.setPSAppModuleId(null);
            this.update(pSAppWF2);
        }
    }

    public void removeByPSAppModule(PSAppModule pSAppModule) throws Exception {
        final PSAppModule pSAppModule2 = pSAppModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppWFServiceBase.this.onBeforeRemoveByPSAppModule(pSAppModule2);
                PSAppWFServiceBase.this.internalRemoveByPSAppModule(pSAppModule2);
                PSAppWFServiceBase.this.onAfterRemoveByPSAppModule(pSAppModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
    }

    protected void internalRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<PSAppWF> arrayList = this.selectByPSAppModule(pSAppModule);
        this.onBeforeRemoveByPSAppModule(pSAppModule, arrayList);
        for (PSAppWF pSAppWF : arrayList) {
            this.remove(pSAppWF);
        }
        this.onAfterRemoveByPSAppModule(pSAppModule, arrayList);
    }

    protected void onAfterRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
    }

    protected void onBeforeRemoveByPSAppModule(PSAppModule pSAppModule, ArrayList<PSAppWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppModule(PSAppModule pSAppModule, ArrayList<PSAppWF> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppWF> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppWF pSAppWF : arrayList) {
            PSAppWF pSAppWF2 = (PSAppWF)this.getDEModel().createEntity();
            pSAppWF2.setPSAppWFId(pSAppWF.getPSAppWFId());
            pSAppWF2.setPSSysAppId(null);
            this.update(pSAppWF2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppWFServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppWFServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppWFServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppWF> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppWF pSAppWF : arrayList) {
            this.remove(pSAppWF);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppWF> arrayList) throws Exception {
    }

    public void testRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSAppWF> arrayList = this.selectByPSWorkflow(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID", "", iDataEntityModel.getName(), "PSAPPWF", iDataEntityModel.getDataInfo(pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSAppWF> arrayList = this.selectByPSWorkflow(pSWorkflow);
        for (PSAppWF pSAppWF : arrayList) {
            PSAppWF pSAppWF2 = (PSAppWF)this.getDEModel().createEntity();
            pSAppWF2.setPSAppWFId(pSAppWF.getPSAppWFId());
            pSAppWF2.setPSWorkflowId(null);
            this.update(pSAppWF2);
        }
    }

    public void removeByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppWFServiceBase.this.onBeforeRemoveByPSWorkflow(pSWorkflow2);
                PSAppWFServiceBase.this.internalRemoveByPSWorkflow(pSWorkflow2);
                PSAppWFServiceBase.this.onAfterRemoveByPSWorkflow(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSAppWF> arrayList = this.selectByPSWorkflow(pSWorkflow);
        this.onBeforeRemoveByPSWorkflow(pSWorkflow, arrayList);
        for (PSAppWF pSAppWF : arrayList) {
            this.remove(pSAppWF);
        }
        this.onAfterRemoveByPSWorkflow(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkflow(PSWorkflow pSWorkflow, ArrayList<PSAppWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkflow(PSWorkflow pSWorkflow, ArrayList<PSAppWF> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppWF pSAppWF) throws Exception {
        PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
        pSAppWFVerService.testRemoveByPSAppWF(pSAppWF);
        super.onBeforeRemove(pSAppWF);
    }

    protected void replaceParentInfo(PSAppWF pSAppWF, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppWF, cloneSession);
        if (pSAppWF.getPSAppModuleId() != null && (iEntity = cloneSession.getEntity("PSAPPMODULE", (Object)pSAppWF.getPSAppModuleId())) != null) {
            this.onFillParentInfo_PSAppModule(pSAppWF, (PSAppModule)iEntity);
        }
        if (pSAppWF.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppWF.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppWF, (PSSysApp)iEntity);
        }
        if (pSAppWF.getPSWorkflowId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSAppWF.getPSWorkflowId())) != null) {
            this.onFillParentInfo_PSWorkflow(pSAppWF, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppWF pSAppWF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppWF, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSAppWF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppModuleId(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppWFId(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppWFName(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkflowId(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppWF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isMemoDirty() : !pSAppWF.isMemoDirty()) {
            return null;
        }
        String string = pSAppWF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppModuleId(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isPSAppModuleIdDirty() : !pSAppWF.isPSAppModuleIdDirty()) {
            return null;
        }
        String string = pSAppWF.getPSAppModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppModuleId_Default(pSAppWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppWFId(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isPSAppWFIdDirty() && !bl2 : !pSAppWF.isPSAppWFIdDirty()) {
            return null;
        }
        String string = pSAppWF.getPSAppWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppWFId_Default(pSAppWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppWFName(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isPSAppWFNameDirty() && !bl2 : !pSAppWF.isPSAppWFNameDirty()) {
            return null;
        }
        String string = pSAppWF.getPSAppWFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPWFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppWFName_Default(pSAppWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPWFNAME");
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
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppWFDEModel(), "PSAPPWFNAME", string3, pSAppWF, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPWFNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isPSSysAppIdDirty() && !bl2 : !pSAppWF.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppWF.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkflowId(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isPSWorkflowIdDirty() && !bl2 : !pSAppWF.isPSWorkflowIdDirty()) {
            return null;
        }
        String string = pSAppWF.getPSWorkflowId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKFLOWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkflowId_Default(pSAppWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKFLOWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppWFDEModel(), "PSWORKFLOWID", string3, pSAppWF, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSWORKFLOWID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isUserCatDirty() : !pSAppWF.isUserCatDirty()) {
            return null;
        }
        String string = pSAppWF.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSAppWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isUserTagDirty() : !pSAppWF.isUserTagDirty()) {
            return null;
        }
        String string = pSAppWF.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSAppWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isUserTag2Dirty() : !pSAppWF.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppWF.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSAppWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isUserTag3Dirty() : !pSAppWF.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppWF.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSAppWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isUserTag4Dirty() : !pSAppWF.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppWF.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSAppWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppWF pSAppWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppWF.isValidFlagDirty() && !bl2 : !pSAppWF.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppWF.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSAppWF, bl2, bl3);
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

    protected void onSyncEntity(PSAppWF pSAppWF, boolean bl) throws Exception {
        super.onSyncEntity(pSAppWF, bl);
    }

    protected void onSyncIndexEntities(PSAppWF pSAppWF, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppWF, bl);
    }

    public Object getDataContextValue(PSAppWF pSAppWF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppWF, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = pSAppWF.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppWF pSAppWF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppWF, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkflowId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkflowName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSAppModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSWorkflowId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKFLOWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkflowName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKFLOWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSAppWF pSAppWF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppWF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppWF pSAppWF) throws Exception {
        super.onUpdateParent(pSAppWF);
    }

    @Override
    protected void exportCurXmlModel(PSAppWF pSAppWF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPWF");
        if (!bl) {
            pSAppWF.setCreateDate(null);
            pSAppWF.setCreateMan(null);
            pSAppWF.setPSAppWFId(null);
            pSAppWF.setUpdateDate(null);
            pSAppWF.setUpdateMan(null);
            super.exportCurXmlModel(pSAppWF, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppWF pSAppWF, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppWF, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPWF_PSAPPMODULE_PSAPPMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSAPPMODULE", (boolean)true) == 0) {
            iEntity.set("PSAPPMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSAPPMODULEID", "PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(PSAppWF pSAppWF) {
        if (!StringHelper.isNullOrEmpty((String)pSAppWF.getPSAppWFName())) {
            return pSAppWF.getPSAppWFName();
        }
        return super.getModelV2Tag(pSAppWF);
    }

    @Override
    public boolean setModelV2Tag(PSAppWF pSAppWF, String string) {
        pSAppWF.setPSAppWFName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSAPPWFNAME", "");
        map.put("PSAPPWFNAME", "");
        map.put("PSWORKFLOWID", "");
        map.put("PSAPPMODULEID", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppWF pSAppWF, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppWF.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppWF, true);
        pSAppWF.set("PSAPPWFNAME", string);
        if (this.select(pSAppWF, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppWF, true);
        return super.getModelV2Entity(pSAppWF, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppWF pSAppWF, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSAppWF, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSAppWF pSAppWF, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPWF#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPWFVER", (Object)pSAppWF.getPSAppWFId()))).exists()) {
            PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSAppWFVerService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSAppWFVer pSAppWFVer = new PSAppWFVer();
                PSModelV2Helper.fromJSONObject((IDataObject)pSAppWFVer, objectNode, false);
                String string6 = pSAppWFVerService.getModelV2Tag(pSAppWFVer);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPWFVER", (Object)pSAppWFVer.getPSAppWFVerId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSAppWFVerService.exportModelV2(pSAppWFVer, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSAppWF, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSAppWF pSAppWF, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID")) {
            Object object;
            PSAppWFVer pSAppWFVer2;
            Object object2;
            Object object3;
            Object object4;
            PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPWF#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPWFVER", (Object)pSAppWF.getPSAppWFId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        object2 = line;
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                object4 = pSAppWFVerService.selectByPSAppWF(pSAppWF);
                object3 = StringHelper.format((String)"PSAPPWF#%1$s", (Object)pSAppWF.getPSAppWFId());
                for (PSAppWFVer item : (ArrayList<PSAppWFVer>)object4) {
                    pSAppWFVer2 = item;
                    object = pSAppWFVerService.getModelV2ResScope(pSAppWFVer2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(pSAppWFVer2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSAppWFVerService.getModelV2Name(false);
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
                        if (objectNode.has("psappwfvername")) {
                            string = objectNode.get("psappwfvername").asText();
                        }
                        if (objectNode2.has("psappwfvername")) {
                            string2 = objectNode2.get("psappwfvername").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    PSAppWFVer entity = new PSAppWFVer();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSAppWFVerService.exportModelV2(entity, string));
                }
            }
        }
        super.onExportCurModelV2(pSAppWF, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSAppWF pSAppWF) throws Exception {
        super.onEmptyModelV2(pSAppWF);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
        if (pSAppWFVerService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSAppWF pSAppWF, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSAppWFVer pSAppWFVer = new PSAppWFVer();
        pSAppWFVer.set("PSAPPWFID", pSAppWF.getPSAppWFId());
        PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSAppWFVerService.getModelV2Entity(pSAppWFVer, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSAppWF, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSAppWF pSAppWF, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSAppWFServiceBase.isSimpleImportExportMode("")) {
            PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSAppWFVerService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSAppWFVer pSAppWFVer = new PSAppWFVer();
                    pSAppWFVer.setPSAppWFId(pSAppWF.getPSAppWFId());
                    pSAppWFVer.setPSAppWFName(pSAppWF.getPSAppWFName());
                    pSAppWFVerService.compileModelV2(pSAppWFVer, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSAppWFVer pSAppWFVer = new PSAppWFVer();
                        pSAppWFVer.setPSAppWFId(pSAppWF.getPSAppWFId());
                        pSAppWFVer.setPSAppWFName(pSAppWF.getPSAppWFName());
                        pSAppWFVerService.compileModelV2(pSAppWFVer, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSAppWF, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSAppWF pSAppWF, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppWFVers(pSAppWF, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSAppWF, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSAppWFVers(PSAppWF pSAppWF, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPWFVER", true), (boolean)false) == 0) {
            PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
            PSAppWFVer pSAppWFVer = new PSAppWFVer();
            pSAppWFVer.setPSAppWFVerId(pSMOSFile.getPSModelId());
            if (!pSAppWFVerService.get(pSAppWFVer, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppWFVer.getPSAppWFId(), (String)pSAppWF.getPSAppWFId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppWFVerService.exportModelV2(pSAppWFVer);
            pSAppWFVer.reset();
            if (!pSAppWFVerService.setModelV2ResScope(pSAppWFVer, "PSAPPWF", pSAppWF.getPSAppWFId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppWFVerService.importModelV2(pSAppWFVer, objectNode);
            SessionFactoryManager.commit();
            return pSAppWFVerService.getFile(pSAppWFVer);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFVERSION", true), (boolean)false) == 0) {
            PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = new PSWFVersion();
            pSWFVersion.setPSWFVersionId(pSMOSFile.getPSModelId());
            if (!pSWFVersionService.get(pSWFVersion, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
            PSAppWFVer pSAppWFVer = new PSAppWFVer();
            pSAppWFVer.setPSAppWFId(pSAppWF.getPSAppWFId());
            pSAppWFVer.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
            this.fillPasteEntity(pSAppWFVer, "PASTETAG");
            pSAppWFVerService.create(pSAppWFVer);
            if (StringHelper.compare((String)pSWFVersion.getPSWFId(), (String)pSAppWFVer.getPSWorkflowId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5de5\u4f5c\u6d41\u6807\u8bc6]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSAppWFVerService.getFile(pSAppWFVer);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSAppWF pSAppWF, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSAppWFVers(pSAppWF, list);
        super.onFillPasteHelps(pSAppWF, list);
    }

    protected void onFillPasteHelps_PSAppWFVers(PSAppWF pSAppWF, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPWFVER");
        pSHelpSection.setSectionParam2("DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u5de5\u4f5c\u6d41]\u7684[\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPWFVER");
        pSHelpSection.setSectionParam2("DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID");
        pSHelpSection.setUserTag("DER1N_PSAPPWFVER_PSWFVERSION_PSWFVERSIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5de5\u4f5c\u6d41\u7684[\u6d41\u7a0b\u5b9a\u4e49\u7248\u672c]\u6784\u5efa[\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u7248\u672c>", "DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID", "PSAPPWFID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSAppWFServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7248\u672c>");
            } else if (PSAppWFServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappwfvers");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID|PSAPPWFID");
            pSMOSFile2.setFileTag3("PSAPPWFVER");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID", "PSAPPWFID", pSMOSFile.getPSModelId(), "", "")) {
                PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSAppWFVerService, "DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID", "PSAPPWFID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSAppWFVerService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSAppWFServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSAppWFServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u7248\u672c>", (boolean)false) == 0 || PSAppWFServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppWFVers", (boolean)true) == 0) {
            PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSAppWFVerService, "DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID", "PSAPPWFID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSAppWFVer> arrayList2 = pSAppWFVerService.selectEx((ISelectContext)selectContext);
            for (PSAppWFVer pSAppWFVer : arrayList2) {
                PSMOSFile pSMOSFile2 = pSAppWFVerService.getFile(pSMOSFile, pSAppWFVer, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPWFVER_PSAPPWF_PSAPPWFID", (boolean)false) == 0) {
            if (PSAppWFServiceBase.getMOSVer() == 1) {
                return "<\u7248\u672c>";
            }
            if (PSAppWFServiceBase.getMOSVer() == 2) {
                return "psappwfvers";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}
