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
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFSAHandler;
import net.ibizsys.pscore.srv.config.entity.PSSFSAHandlerBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysSAHandlerDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSAHandlerDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSAHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSAHandlerServiceBase
extends PSCoreSysServiceBase<PSSysSAHandler> {
    private static final Log log = LogFactory.getLog(PSSysSAHandlerServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysSAHandlerDEModel pSSysSAHandlerDEModel;
    private PSSysSAHandlerDAO pSSysSAHandlerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysSAHandlerService";
    }

    public PSSysSAHandlerDEModel getPSSysSAHandlerDEModel() {
        if (this.pSSysSAHandlerDEModel == null) {
            try {
                this.pSSysSAHandlerDEModel = (PSSysSAHandlerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSAHandlerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSAHandlerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSAHandlerDEModel();
    }

    public PSSysSAHandlerDAO getPSSysSAHandlerDAO() {
        if (this.pSSysSAHandlerDAO == null) {
            try {
                this.pSSysSAHandlerDAO = (PSSysSAHandlerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysSAHandlerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSAHandlerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSAHandlerDAO();
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

    protected void onFillParentInfo(PSSysSAHandler pSSysSAHandler, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSAHANDLER_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysSAHandler, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSAHANDLER_PSSFSAHANDLER_PSSFSAHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFSAHandlerService", (SessionFactory)this.getSessionFactory());
            PSSFSAHandler pSSFSAHandler = (PSSFSAHandler)iService.getDEModel().createEntity();
            pSSFSAHandler.set("PSSFSAHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFSAHandler);
            } else {
                iService.get(pSSFSAHandler);
            }
            this.onFillParentInfo_PSSFSAHandler(pSSysSAHandler, pSSFSAHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSAHANDLER_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysSAHandler, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSAHANDLER_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysSAHandler, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysSAHandler, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysSAHandler pSSysSAHandler, PSModule pSModule) throws Exception {
        pSSysSAHandler.setPSModuleId(pSModule.getPSModuleId());
        pSSysSAHandler.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSFSAHandler(PSSysSAHandler pSSysSAHandler, PSSFSAHandler pSSFSAHandler) throws Exception {
        pSSysSAHandler.setPSSFSAHandlerId(pSSFSAHandler.getPSSFSAHandlerId());
        pSSysSAHandler.setPSSFSAHandlerName(pSSFSAHandler.getPSSFSAHandlerName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysSAHandler pSSysSAHandler, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysSAHandler.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysSAHandler.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSystem(PSSysSAHandler pSSysSAHandler, PSSystem pSSystem) throws Exception {
        pSSysSAHandler.setPSSystemId(pSSystem.getPSSystemId());
        pSSysSAHandler.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysSAHandler pSSysSAHandler, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysSAHandler, bl);
        this.onFillEntityFullInfo_PSModule(pSSysSAHandler, bl);
        this.onFillEntityFullInfo_PSSFSAHandler(pSSysSAHandler, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysSAHandler, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysSAHandler, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysSAHandler pSSysSAHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFSAHandler(PSSysSAHandler pSSysSAHandler, boolean bl) throws Exception {
        if (pSSysSAHandler.isPSSFSAHandlerIdDirty()) {
            if (pSSysSAHandler.getPSSFSAHandlerId() != null) {
                if (pSSysSAHandler.getPSSFSAHandlerId() == null || pSSysSAHandler.getPSSFSAHandlerName() == null) {
                    PSSFSAHandler pSSFSAHandler = pSSysSAHandler.getPSSFSAHandler();
                    pSSysSAHandler.setPSSFSAHandlerName(pSSFSAHandler.getPSSFSAHandlerName());
                }
            } else {
                pSSysSAHandler.setPSSFSAHandlerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysSAHandler pSSysSAHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysSAHandler pSSysSAHandler, boolean bl) throws Exception {
        if (pSSysSAHandler.isPSSystemIdDirty()) {
            if (pSSysSAHandler.getPSSystemId() != null) {
                if (pSSysSAHandler.getPSSystemId() == null || pSSysSAHandler.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysSAHandler.getPSSystem();
                    pSSysSAHandler.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysSAHandler.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysSAHandler pSSysSAHandler, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysSAHandler, bl);
    }

    public ArrayList<PSSysSAHandler> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysSAHandler> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysSAHandler> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSAHandler> selectByPSSFSAHandler(PSSFSAHandlerBase pSSFSAHandlerBase) throws Exception {
        return this.selectByPSSFSAHandler(pSSFSAHandlerBase, "", -1);
    }

    public ArrayList<PSSysSAHandler> selectByPSSFSAHandler(PSSFSAHandlerBase pSSFSAHandlerBase, String string) throws Exception {
        return this.selectByPSSFSAHandler(pSSFSAHandlerBase, string, -1);
    }

    public ArrayList<PSSysSAHandler> selectByPSSFSAHandler(PSSFSAHandlerBase pSSFSAHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSAHANDLERID", (Object)pSSFSAHandlerBase.getPSSFSAHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFSAHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFSAHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSAHandler> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysSAHandler> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysSAHandler> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSAHandler> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysSAHandler> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysSAHandler> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSAHANDLER_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSSAHANDLER", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSModule(pSModule);
        for (PSSysSAHandler pSSysSAHandler : arrayList) {
            PSSysSAHandler pSSysSAHandler2 = (PSSysSAHandler)this.getDEModel().createEntity();
            pSSysSAHandler2.setPSSysSAHandlerId(pSSysSAHandler.getPSSysSAHandlerId());
            pSSysSAHandler2.setPSModuleId(null);
            this.update(pSSysSAHandler2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSAHandlerServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysSAHandlerServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysSAHandlerServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysSAHandler pSSysSAHandler : arrayList) {
            this.remove(pSSysSAHandler);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSAHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSAHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSFSAHandler(PSSFSAHandler pSSFSAHandler) throws Exception {
    }

    public void resetPSSFSAHandler(PSSFSAHandler pSSFSAHandler) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSSFSAHandler(pSSFSAHandler);
        for (PSSysSAHandler pSSysSAHandler : arrayList) {
            PSSysSAHandler pSSysSAHandler2 = (PSSysSAHandler)this.getDEModel().createEntity();
            pSSysSAHandler2.setPSSysSAHandlerId(pSSysSAHandler.getPSSysSAHandlerId());
            pSSysSAHandler2.setPSSFSAHandlerId(null);
            this.update(pSSysSAHandler2);
        }
    }

    public void removeByPSSFSAHandler(PSSFSAHandler pSSFSAHandler) throws Exception {
        final PSSFSAHandler pSSFSAHandler2 = pSSFSAHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSAHandlerServiceBase.this.onBeforeRemoveByPSSFSAHandler(pSSFSAHandler2);
                PSSysSAHandlerServiceBase.this.internalRemoveByPSSFSAHandler(pSSFSAHandler2);
                PSSysSAHandlerServiceBase.this.onAfterRemoveByPSSFSAHandler(pSSFSAHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFSAHandler(PSSFSAHandler pSSFSAHandler) throws Exception {
    }

    protected void internalRemoveByPSSFSAHandler(PSSFSAHandler pSSFSAHandler) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSSFSAHandler(pSSFSAHandler);
        this.onBeforeRemoveByPSSFSAHandler(pSSFSAHandler, arrayList);
        for (PSSysSAHandler pSSysSAHandler : arrayList) {
            this.remove(pSSysSAHandler);
        }
        this.onAfterRemoveByPSSFSAHandler(pSSFSAHandler, arrayList);
    }

    protected void onAfterRemoveByPSSFSAHandler(PSSFSAHandler pSSFSAHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSSFSAHandler(PSSFSAHandler pSSFSAHandler, ArrayList<PSSysSAHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFSAHandler(PSSFSAHandler pSSFSAHandler, ArrayList<PSSysSAHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSAHANDLER_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSSAHANDLER", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysSAHandler pSSysSAHandler : arrayList) {
            PSSysSAHandler pSSysSAHandler2 = (PSSysSAHandler)this.getDEModel().createEntity();
            pSSysSAHandler2.setPSSysSAHandlerId(pSSysSAHandler.getPSSysSAHandlerId());
            pSSysSAHandler2.setPSSysDynaModelId(null);
            this.update(pSSysSAHandler2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSAHandlerServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysSAHandlerServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysSAHandlerServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysSAHandler pSSysSAHandler : arrayList) {
            this.remove(pSSysSAHandler);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysSAHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysSAHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSAHANDLER_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSSAHANDLER", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysSAHandler pSSysSAHandler : arrayList) {
            PSSysSAHandler pSSysSAHandler2 = (PSSysSAHandler)this.getDEModel().createEntity();
            pSSysSAHandler2.setPSSysSAHandlerId(pSSysSAHandler.getPSSysSAHandlerId());
            pSSysSAHandler2.setPSSystemId(null);
            this.update(pSSysSAHandler2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSAHandlerServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysSAHandlerServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysSAHandlerServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSAHandler> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysSAHandler pSSysSAHandler : arrayList) {
            this.remove(pSSysSAHandler);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSAHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSAHandler> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSAHandler pSSysSAHandler) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSAHandler(pSSysSAHandler);
        pSCoreSysServiceBase = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSAHandler(pSSysSAHandler);
        super.onBeforeRemove(pSSysSAHandler);
    }

    protected void replaceParentInfo(PSSysSAHandler pSSysSAHandler, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysSAHandler, cloneSession);
        if (pSSysSAHandler.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysSAHandler.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysSAHandler, (PSModule)iEntity);
        }
        if (pSSysSAHandler.getPSSFSAHandlerId() != null && (iEntity = cloneSession.getEntity("PSSFSAHANDLER", (Object)pSSysSAHandler.getPSSFSAHandlerId())) != null) {
            this.onFillParentInfo_PSSFSAHandler(pSSysSAHandler, (PSSFSAHandler)iEntity);
        }
        if (pSSysSAHandler.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysSAHandler.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysSAHandler, (PSSysDynaModel)iEntity);
        }
        if (pSSysSAHandler.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysSAHandler.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysSAHandler, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSAHandler pSSysSAHandler, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysSAHandler, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ClientHandlerObj(bl, pSSysSAHandler, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClientHandlerObj2(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerObj(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerObj2(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerParams(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFSAHandlerId(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFSAHandlerName(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSAHandlerId(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSAHandlerName(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SAType(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysSAHandler, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ClientHandlerObj(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isClientHandlerObjDirty() && !bl2 : !pSSysSAHandler.isClientHandlerObjDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getClientHandlerObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLIENTHANDLEROBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClientHandlerObj_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLIENTHANDLEROBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClientHandlerObj2(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isClientHandlerObj2Dirty() : !pSSysSAHandler.isClientHandlerObj2Dirty()) {
            return null;
        }
        String string = pSSysSAHandler.getClientHandlerObj2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClientHandlerObj2_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLIENTHANDLEROBJ2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isCodeNameDirty() : !pSSysSAHandler.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysSAHandler, bl2, bl3);
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysSAHandlerDEModel(), "CODENAME", string3, pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isDynaModelFlagDirty() : !pSSysSAHandler.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSSysSAHandler.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerObj(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isHandlerObjDirty() && !bl2 : !pSSysSAHandler.isHandlerObjDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getHandlerObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerObj_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerObj2(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isHandlerObj2Dirty() : !pSSysSAHandler.isHandlerObj2Dirty()) {
            return null;
        }
        String string = pSSysSAHandler.getHandlerObj2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerObj2_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerParams(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isHandlerParamsDirty() : !pSSysSAHandler.isHandlerParamsDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getHandlerParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerParams_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isLockFlagDirty() : !pSSysSAHandler.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysSAHandler.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isMemoDirty() : !pSSysSAHandler.isMemoDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isPSDynaInstIdDirty() : !pSSysSAHandler.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isPSModuleIdDirty() : !pSSysSAHandler.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFSAHandlerId(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isPSSFSAHandlerIdDirty() : !pSSysSAHandler.isPSSFSAHandlerIdDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getPSSFSAHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFSAHandlerId_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSAHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFSAHandlerName(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isPSSFSAHandlerNameDirty() : !pSSysSAHandler.isPSSFSAHandlerNameDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getPSSFSAHandlerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFSAHandlerName_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSAHANDLERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isPSSysDynaModelIdDirty() : !pSSysSAHandler.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSAHandlerId(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isPSSysSAHandlerIdDirty() && !bl2 : !pSSysSAHandler.isPSSysSAHandlerIdDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getPSSysSAHandlerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSAHANDLERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSAHandlerId_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSAHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSAHandlerName(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isPSSysSAHandlerNameDirty() && !bl2 : !pSSysSAHandler.isPSSysSAHandlerNameDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getPSSysSAHandlerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSAHANDLERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSAHandlerName_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSAHANDLERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isPSSystemIdDirty() && !bl2 : !pSSysSAHandler.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isPSSystemNameDirty() : !pSSysSAHandler.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_SAType(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isSATypeDirty() && !bl2 : !pSSysSAHandler.isSATypeDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getSAType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SATYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SAType_Default(pSSysSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isUserCatDirty() : !pSSysSAHandler.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isUserTagDirty() : !pSSysSAHandler.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSAHandler.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isUserTag2Dirty() : !pSSysSAHandler.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSAHandler.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isUserTag3Dirty() : !pSSysSAHandler.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSAHandler.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSAHandler pSSysSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSAHandler.isUserTag4Dirty() : !pSSysSAHandler.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSAHandler.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysSAHandler, bl2, bl3);
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

    protected void onSyncEntity(PSSysSAHandler pSSysSAHandler, boolean bl) throws Exception {
        super.onSyncEntity(pSSysSAHandler, bl);
    }

    protected void onSyncIndexEntities(PSSysSAHandler pSSysSAHandler, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysSAHandler, bl);
    }

    public Object getDataContextValue(PSSysSAHandler pSSysSAHandler, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysSAHandler, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSAHandler pSSysSAHandler, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysSAHandler, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLIENTHANDLEROBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClientHandlerObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLIENTHANDLEROBJ2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClientHandlerObj2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLEROBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLEROBJ2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerObj2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSAHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFSAHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSAHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFSAHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSAHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSAHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSAHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSAHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SAType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ClientHandlerObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLIENTHANDLEROBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClientHandlerObj2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLIENTHANDLEROBJ2", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HandlerObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLEROBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerObj2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLEROBJ2", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLERPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSSFSAHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSAHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFSAHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSAHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysSAHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSAHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSAHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSAHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SAType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSSysSAHandler pSSysSAHandler) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysSAHandler)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSAHandler pSSysSAHandler) throws Exception {
        super.onUpdateParent(pSSysSAHandler);
    }

    @Override
    protected void exportCurXmlModel(PSSysSAHandler pSSysSAHandler, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSAHANDLER");
        if (!bl) {
            pSSysSAHandler.setCreateDate(null);
            pSSysSAHandler.setCreateMan(null);
            pSSysSAHandler.setPSSysSAHandlerId(null);
            pSSysSAHandler.setUpdateDate(null);
            pSSysSAHandler.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSAHandler, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSAHandler pSSysSAHandler, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSAHandler, string);
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
            return "DER1N_PSSYSSAHANDLER_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSAHANDLER_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysSAHandler pSSysSAHandler) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSAHandler.getCodeName())) {
            return pSSysSAHandler.getCodeName();
        }
        return super.getModelV2Tag(pSSysSAHandler);
    }

    @Override
    public boolean setModelV2Tag(PSSysSAHandler pSSysSAHandler, String string) {
        pSSysSAHandler.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSAHandler pSSysSAHandler, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSAHandler.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSAHandler, true);
        pSSysSAHandler.set("CODENAME", string);
        if (this.select(pSSysSAHandler, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSAHandler, true);
        return super.getModelV2Entity(pSSysSAHandler, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSAHandler pSSysSAHandler, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysSAHandler, objectNode, string, string2, n);
    }
}

