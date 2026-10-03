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
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wxdesign.dao.PSWXLogicDAO;
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXLogicDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccountBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntAppBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXLogic;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFuncBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXLogicServiceBase
extends PSCoreSysServiceBase<PSWXLogic> {
    private static final Log log = LogFactory.getLog(PSWXLogicServiceBase.class);
    public static final String DATASET_CURWX = "CurWX";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWXLogicDEModel pSWXLogicDEModel;
    private PSWXLogicDAO pSWXLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService";
    }

    public PSWXLogicDEModel getPSWXLogicDEModel() {
        if (this.pSWXLogicDEModel == null) {
            try {
                this.pSWXLogicDEModel = (PSWXLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWXLogicDEModel();
    }

    public PSWXLogicDAO getPSWXLogicDAO() {
        if (this.pSWXLogicDAO == null) {
            try {
                this.pSWXLogicDAO = (PSWXLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wxdesign.dao.PSWXLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWXLogicDAO();
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

    protected void onFillParentInfo(PSWXLogic pSWXLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXLOGIC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSWXLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXLOGIC_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSWXLogic, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXLOGIC_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysResource);
            } else {
                iService.get(pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSWXLogic, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXLOGIC_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSWXLogic, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXLOGIC_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory());
            PSWXAccount pSWXAccount = (PSWXAccount)iService.getDEModel().createEntity();
            pSWXAccount.set("PSWXACCOUNTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWXAccount);
            } else {
                iService.get(pSWXAccount);
            }
            this.onFillParentInfo_PSWXAccount(pSWXLogic, pSWXAccount);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXLOGIC_PSWXENTAPP_PSWXENTAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService", (SessionFactory)this.getSessionFactory());
            PSWXEntApp pSWXEntApp = (PSWXEntApp)iService.getDEModel().createEntity();
            pSWXEntApp.set("PSWXENTAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWXEntApp);
            } else {
                iService.get(pSWXEntApp);
            }
            this.onFillParentInfo_PSWXEntApp(pSWXLogic, pSWXEntApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXLOGIC_PSWXMENUFUNC_PSWXMENUFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService", (SessionFactory)this.getSessionFactory());
            PSWXMenuFunc pSWXMenuFunc = (PSWXMenuFunc)iService.getDEModel().createEntity();
            pSWXMenuFunc.set("PSWXMENUFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWXMenuFunc);
            } else {
                iService.get(pSWXMenuFunc);
            }
            this.onFillParentInfo_PSWXMenuFunc(pSWXLogic, pSWXMenuFunc);
            return;
        }
        super.onFillParentInfo(pSWXLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSWXLogic pSWXLogic, PSDataEntity pSDataEntity) throws Exception {
        pSWXLogic.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSWXLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEAction(PSWXLogic pSWXLogic, PSDEAction pSDEAction) throws Exception {
        pSWXLogic.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSWXLogic.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSSysResource(PSWXLogic pSWXLogic, PSSysResource pSSysResource) throws Exception {
        pSWXLogic.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSWXLogic.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSWXLogic pSWXLogic, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSWXLogic.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSWXLogic.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSWXAccount(PSWXLogic pSWXLogic, PSWXAccount pSWXAccount) throws Exception {
        pSWXLogic.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
        pSWXLogic.setPSWXAccountName(pSWXAccount.getPSWXAccountName());
    }

    protected void onFillParentInfo_PSWXEntApp(PSWXLogic pSWXLogic, PSWXEntApp pSWXEntApp) throws Exception {
        pSWXLogic.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
        pSWXLogic.setPSWXEntAppName(pSWXEntApp.getPSWXEntAppName());
        if (pSWXEntApp.getPSWXAccount() != null) {
            this.onFillParentInfo_PSWXAccount(pSWXLogic, pSWXEntApp.getPSWXAccount());
        }
    }

    protected void onFillParentInfo_PSWXMenuFunc(PSWXLogic pSWXLogic, PSWXMenuFunc pSWXMenuFunc) throws Exception {
        pSWXLogic.setPSWXMenuFuncId(pSWXMenuFunc.getPSWXMenuFuncId());
        pSWXLogic.setPSWXMenuFuncName(pSWXMenuFunc.getPSWXMenuFuncName());
    }

    protected void onFillEntityFullInfo(PSWXLogic pSWXLogic, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWXLogic, bl);
        this.onFillEntityFullInfo_PSDE(pSWXLogic, bl);
        this.onFillEntityFullInfo_PSDEAction(pSWXLogic, bl);
        this.onFillEntityFullInfo_PSSysResource(pSWXLogic, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSWXLogic, bl);
        this.onFillEntityFullInfo_PSWXAccount(pSWXLogic, bl);
        this.onFillEntityFullInfo_PSWXEntApp(pSWXLogic, bl);
        this.onFillEntityFullInfo_PSWXMenuFunc(pSWXLogic, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSWXLogic pSWXLogic, boolean bl) throws Exception {
        if (pSWXLogic.isPSDEIdDirty()) {
            if (pSWXLogic.getPSDEId() != null) {
                if (pSWXLogic.getPSDEId() == null || pSWXLogic.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSWXLogic.getPSDE();
                    pSWXLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSWXLogic.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEAction(PSWXLogic pSWXLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSWXLogic pSWXLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSWXLogic pSWXLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWXAccount(PSWXLogic pSWXLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWXEntApp(PSWXLogic pSWXLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWXMenuFunc(PSWXLogic pSWXLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWXLogic pSWXLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSWXLogic, bl);
    }

    public ArrayList<PSWXLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSWXLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSWXLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXLogic> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSWXLogic> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSWXLogic> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWXLogic> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSWXLogic> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSWXLogic> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXLogic> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSWXLogic> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSWXLogic> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXLogic> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, "", -1);
    }

    public ArrayList<PSWXLogic> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, string, -1);
    }

    public ArrayList<PSWXLogic> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXLogic> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase) throws Exception {
        return this.selectByPSWXEntApp(pSWXEntAppBase, "", -1);
    }

    public ArrayList<PSWXLogic> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase, String string) throws Exception {
        return this.selectByPSWXEntApp(pSWXEntAppBase, string, -1);
    }

    public ArrayList<PSWXLogic> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXLogic> selectByPSWXMenuFunc(PSWXMenuFuncBase pSWXMenuFuncBase) throws Exception {
        return this.selectByPSWXMenuFunc(pSWXMenuFuncBase, "", -1);
    }

    public ArrayList<PSWXLogic> selectByPSWXMenuFunc(PSWXMenuFuncBase pSWXMenuFuncBase, String string) throws Exception {
        return this.selectByPSWXMenuFunc(pSWXMenuFuncBase, string, -1);
    }

    public ArrayList<PSWXLogic> selectByPSWXMenuFunc(PSWXMenuFuncBase pSWXMenuFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWXMENUFUNCID", (Object)pSWXMenuFuncBase.getPSWXMenuFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWXMenuFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWXMenuFuncCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXLOGIC_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSWXLOGIC", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSWXLogic pSWXLogic : arrayList) {
            PSWXLogic pSWXLogic2 = (PSWXLogic)this.getDEModel().createEntity();
            pSWXLogic2.setPSWXLogicId(pSWXLogic.getPSWXLogicId());
            pSWXLogic2.setPSDEId(null);
            this.update(pSWXLogic2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXLogicServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSWXLogicServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSWXLogicServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSWXLogic pSWXLogic : arrayList) {
            this.remove(pSWXLogic);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXLOGIC_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSWXLOGIC", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSWXLogic pSWXLogic : arrayList) {
            PSWXLogic pSWXLogic2 = (PSWXLogic)this.getDEModel().createEntity();
            pSWXLogic2.setPSWXLogicId(pSWXLogic.getPSWXLogicId());
            pSWXLogic2.setPSDEActionId(null);
            this.update(pSWXLogic2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXLogicServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSWXLogicServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSWXLogicServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSWXLogic pSWXLogic : arrayList) {
            this.remove(pSWXLogic);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXLOGIC_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSWXLOGIC", iDataEntityModel.getDataInfo(pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSWXLogic pSWXLogic : arrayList) {
            PSWXLogic pSWXLogic2 = (PSWXLogic)this.getDEModel().createEntity();
            pSWXLogic2.setPSWXLogicId(pSWXLogic.getPSWXLogicId());
            pSWXLogic2.setPSSysResourceId(null);
            this.update(pSWXLogic2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXLogicServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSWXLogicServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSWXLogicServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSWXLogic pSWXLogic : arrayList) {
            this.remove(pSWXLogic);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXLOGIC_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSWXLOGIC", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSWXLogic pSWXLogic : arrayList) {
            PSWXLogic pSWXLogic2 = (PSWXLogic)this.getDEModel().createEntity();
            pSWXLogic2.setPSWXLogicId(pSWXLogic.getPSWXLogicId());
            pSWXLogic2.setPSSysSFPluginId(null);
            this.update(pSWXLogic2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXLogicServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWXLogicServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWXLogicServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSWXLogic pSWXLogic : arrayList) {
            this.remove(pSWXLogic);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    public void resetPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSWXAccount(pSWXAccount);
        for (PSWXLogic pSWXLogic : arrayList) {
            PSWXLogic pSWXLogic2 = (PSWXLogic)this.getDEModel().createEntity();
            pSWXLogic2.setPSWXLogicId(pSWXLogic.getPSWXLogicId());
            pSWXLogic2.setPSWXAccountId(null);
            this.update(pSWXLogic2);
        }
    }

    public void removeByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        final PSWXAccount pSWXAccount2 = pSWXAccount;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXLogicServiceBase.this.onBeforeRemoveByPSWXAccount(pSWXAccount2);
                PSWXLogicServiceBase.this.internalRemoveByPSWXAccount(pSWXAccount2);
                PSWXLogicServiceBase.this.onAfterRemoveByPSWXAccount(pSWXAccount2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void internalRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSWXAccount(pSWXAccount);
        this.onBeforeRemoveByPSWXAccount(pSWXAccount, arrayList);
        for (PSWXLogic pSWXLogic : arrayList) {
            this.remove(pSWXLogic);
        }
        this.onAfterRemoveByPSWXAccount(pSWXAccount, arrayList);
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSWXEntApp(pSWXEntApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWXENTAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWXEntApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXLOGIC_PSWXENTAPP_PSWXENTAPPID", "", iDataEntityModel.getName(), "PSWXLOGIC", iDataEntityModel.getDataInfo(pSWXEntApp), arrayList.get(0)));
        }
    }

    public void resetPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSWXEntApp(pSWXEntApp);
        for (PSWXLogic pSWXLogic : arrayList) {
            PSWXLogic pSWXLogic2 = (PSWXLogic)this.getDEModel().createEntity();
            pSWXLogic2.setPSWXLogicId(pSWXLogic.getPSWXLogicId());
            pSWXLogic2.setPSWXEntAppId(null);
            this.update(pSWXLogic2);
        }
    }

    public void removeByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        final PSWXEntApp pSWXEntApp2 = pSWXEntApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXLogicServiceBase.this.onBeforeRemoveByPSWXEntApp(pSWXEntApp2);
                PSWXLogicServiceBase.this.internalRemoveByPSWXEntApp(pSWXEntApp2);
                PSWXLogicServiceBase.this.onAfterRemoveByPSWXEntApp(pSWXEntApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
    }

    protected void internalRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSWXEntApp(pSWXEntApp);
        this.onBeforeRemoveByPSWXEntApp(pSWXEntApp, arrayList);
        for (PSWXLogic pSWXLogic : arrayList) {
            this.remove(pSWXLogic);
        }
        this.onAfterRemoveByPSWXEntApp(pSWXEntApp, arrayList);
    }

    protected void onAfterRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
    }

    protected void onBeforeRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSWXMenuFunc(pSWXMenuFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWXMENUFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWXMenuFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXLOGIC_PSWXMENUFUNC_PSWXMENUFUNCID", "", iDataEntityModel.getName(), "PSWXLOGIC", iDataEntityModel.getDataInfo(pSWXMenuFunc), arrayList.get(0)));
        }
    }

    public void resetPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSWXMenuFunc(pSWXMenuFunc);
        for (PSWXLogic pSWXLogic : arrayList) {
            PSWXLogic pSWXLogic2 = (PSWXLogic)this.getDEModel().createEntity();
            pSWXLogic2.setPSWXLogicId(pSWXLogic.getPSWXLogicId());
            pSWXLogic2.setPSWXMenuFuncId(null);
            this.update(pSWXLogic2);
        }
    }

    public void removeByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        final PSWXMenuFunc pSWXMenuFunc2 = pSWXMenuFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXLogicServiceBase.this.onBeforeRemoveByPSWXMenuFunc(pSWXMenuFunc2);
                PSWXLogicServiceBase.this.internalRemoveByPSWXMenuFunc(pSWXMenuFunc2);
                PSWXLogicServiceBase.this.onAfterRemoveByPSWXMenuFunc(pSWXMenuFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
    }

    protected void internalRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        ArrayList<PSWXLogic> arrayList = this.selectByPSWXMenuFunc(pSWXMenuFunc);
        this.onBeforeRemoveByPSWXMenuFunc(pSWXMenuFunc, arrayList);
        for (PSWXLogic pSWXLogic : arrayList) {
            this.remove(pSWXLogic);
        }
        this.onAfterRemoveByPSWXMenuFunc(pSWXMenuFunc, arrayList);
    }

    protected void onAfterRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc, ArrayList<PSWXLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWXLogic pSWXLogic) throws Exception {
        super.onBeforeRemove(pSWXLogic);
    }

    protected void replaceParentInfo(PSWXLogic pSWXLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWXLogic, cloneSession);
        if (pSWXLogic.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSWXLogic.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSWXLogic, (PSDataEntity)iEntity);
        }
        if (pSWXLogic.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSWXLogic.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSWXLogic, (PSDEAction)iEntity);
        }
        if (pSWXLogic.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSWXLogic.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSWXLogic, (PSSysResource)iEntity);
        }
        if (pSWXLogic.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSWXLogic.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSWXLogic, (PSSysSFPlugin)iEntity);
        }
        if (pSWXLogic.getPSWXAccountId() != null && (iEntity = cloneSession.getEntity("PSWXACCOUNT", (Object)pSWXLogic.getPSWXAccountId())) != null) {
            this.onFillParentInfo_PSWXAccount(pSWXLogic, (PSWXAccount)iEntity);
        }
        if (pSWXLogic.getPSWXEntAppId() != null && (iEntity = cloneSession.getEntity("PSWXENTAPP", (Object)pSWXLogic.getPSWXEntAppId())) != null) {
            this.onFillParentInfo_PSWXEntApp(pSWXLogic, (PSWXEntApp)iEntity);
        }
        if (pSWXLogic.getPSWXMenuFuncId() != null && (iEntity = cloneSession.getEntity("PSWXMENUFUNC", (Object)pSWXLogic.getPSWXMenuFuncId())) != null) {
            this.onFillParentInfo_PSWXMenuFunc(pSWXLogic, (PSWXMenuFunc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWXLogic pSWXLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWXLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSWXLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventType(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXAccountId(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXEntAppId(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXLogicId(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXLogicName(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuFuncId(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWXLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWXLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isCodeNameDirty() && !bl2 : !pSWXLogic.isCodeNameDirty()) {
            return null;
        }
        String string = pSWXLogic.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSWXLogic, bl2, bl3);
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
                string3 = "PSWXENTAPPID";
                String string4 = this.checkFieldDupRule(this.getPSWXLogicDEModel(), "CODENAME", string3, pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventType(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isEventTypeDirty() && !bl2 : !pSWXLogic.isEventTypeDirty()) {
            return null;
        }
        String string = pSWXLogic.getEventType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventType_Default(pSWXLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isMemoDirty() : !pSWXLogic.isMemoDirty()) {
            return null;
        }
        String string = pSWXLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSDEActionIdDirty() && !bl2 : !pSWXLogic.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSDEActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_PSDEAction(pSWXLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEActionId_Default(pSWXLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSDEIdDirty() && !bl2 : !pSWXLogic.isPSDEIdDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSDENameDirty() && !bl2 : !pSWXLogic.isPSDENameDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSSysResourceIdDirty() : !pSWXLogic.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSSysSFPluginIdDirty() : !pSWXLogic.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXAccountId(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSWXAccountIdDirty() && !bl2 : !pSWXLogic.isPSWXAccountIdDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSWXAccountId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXACCOUNTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXAccountId_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXEntAppId(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSWXEntAppIdDirty() : !pSWXLogic.isPSWXEntAppIdDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSWXEntAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXEntAppId_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXLogicId(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSWXLogicIdDirty() && !bl2 : !pSWXLogic.isPSWXLogicIdDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSWXLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXLogicId_Default(pSWXLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXLogicName(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSWXLogicNameDirty() && !bl2 : !pSWXLogic.isPSWXLogicNameDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSWXLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXLOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXLogicName_Default(pSWXLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuFuncId(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isPSWXMenuFuncIdDirty() : !pSWXLogic.isPSWXMenuFuncIdDirty()) {
            return null;
        }
        String string = pSWXLogic.getPSWXMenuFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuFuncId_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isUserCatDirty() : !pSWXLogic.isUserCatDirty()) {
            return null;
        }
        String string = pSWXLogic.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isUserTagDirty() : !pSWXLogic.isUserTagDirty()) {
            return null;
        }
        String string = pSWXLogic.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSWXLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
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
                String string4 = this.checkFieldDupRule(this.getPSWXLogicDEModel(), "USERTAG", string3, pSWXLogic, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("USERTAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isUserTag2Dirty() : !pSWXLogic.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWXLogic.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isUserTag3Dirty() : !pSWXLogic.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWXLogic.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSWXLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWXLogic pSWXLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXLogic.isUserTag4Dirty() : !pSWXLogic.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWXLogic.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSWXLogic, bl2, bl3);
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

    protected void onSyncEntity(PSWXLogic pSWXLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSWXLogic, bl);
    }

    protected void onSyncIndexEntities(PSWXLogic pSWXLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWXLogic, bl);
    }

    public Object getDataContextValue(PSWXLogic pSWXLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWXLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSWXAccount pSWXAccount = pSWXLogic.getPSWXAccount();
        if (pSWXAccount != null && pSWXAccount.contains(string)) {
            return pSWXAccount.get(string);
        }
        PSWXEntApp pSWXEntApp = pSWXLogic.getPSWXEntApp();
        if (pSWXEntApp != null && pSWXEntApp.contains(string)) {
            return pSWXEntApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWXLogic pSWXLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWXLogic, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"EVENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_PSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSWXLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXLogicName_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_EventType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_PSDEActionId_PSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEACTIONID", "PSDEACTION", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u903b\u8f91\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PSWXLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected boolean onMergeChild(String string, String string2, PSWXLogic pSWXLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWXLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWXLogic pSWXLogic) throws Exception {
        IService iService;
        Object object = pSWXLogic.get("PSWXACCOUNTID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWXLOGIC_PSWXACCOUNT_PSWXACCOUNTID", object);
        }
        if ((object = pSWXLogic.get("PSWXENTAPPID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWXLOGIC_PSWXENTAPP_PSWXENTAPPID", object);
        }
        super.onUpdateParent(pSWXLogic);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSWXLogic pSWXLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWXLOGIC");
        if (!bl) {
            pSWXLogic.setCreateDate(null);
            pSWXLogic.setCreateMan(null);
            pSWXLogic.setPSWXLogicId(null);
            pSWXLogic.setPSWXMenuFuncName(null);
            pSWXLogic.setUpdateDate(null);
            pSWXLogic.setUpdateMan(null);
            super.exportCurXmlModel(pSWXLogic, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWXLogic pSWXLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWXLogic, string);
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
            return "DER1N_PSWXLOGIC_PSWXACCOUNT_PSWXACCOUNTID";
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
    public String getModelV2Tag(PSWXLogic pSWXLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSWXLogic.getCodeName())) {
            return pSWXLogic.getCodeName();
        }
        return super.getModelV2Tag(pSWXLogic);
    }

    @Override
    public boolean setModelV2Tag(PSWXLogic pSWXLogic, String string) {
        pSWXLogic.setCodeName(string);
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
    public boolean getModelV2Entity(PSWXLogic pSWXLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWXLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWXLogic, true);
        pSWXLogic.set("CODENAME", string);
        if (this.select(pSWXLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWXLogic, true);
        return super.getModelV2Entity(pSWXLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWXLogic pSWXLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSWXLogic, objectNode, string, string2, n);
    }
}

