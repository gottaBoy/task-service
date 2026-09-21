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
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wxdesign.dao.PSWXMenuDAO;
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccountBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntAppBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuItem;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuItemBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXMenuServiceBase
extends PSCoreSysServiceBase<PSWXMenu> {
    private static final Log log = LogFactory.getLog(PSWXMenuServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_PREVIEWSAVE = "PreviewSave";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSWXMenuDEModel pSWXMenuDEModel;
    private PSWXMenuDAO pSWXMenuDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService";
    }

    public PSWXMenuDEModel getPSWXMenuDEModel() {
        if (this.pSWXMenuDEModel == null) {
            try {
                this.pSWXMenuDEModel = (PSWXMenuDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXMenuDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWXMenuDEModel();
    }

    public PSWXMenuDAO getPSWXMenuDAO() {
        if (this.pSWXMenuDAO == null) {
            try {
                this.pSWXMenuDAO = (PSWXMenuDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wxdesign.dao.PSWXMenuDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXMenuDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWXMenuDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSWXMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSWXMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSWXMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSWXMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PREVIEWSAVE, (boolean)true) == 0) {
            this.previewSave((PSWXMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSWXMenu)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void createWithModel(PSWXMenu pSWXMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSWXMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWXMenu, ACTION_CREATEWITHMODEL);
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWXMenuServiceBase.this.getService(), PSWXMenuServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSWXMenu2, null).getResult() != 1) {
                    PSWXMenuServiceBase.this.onCreateWithModel(pSWXMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSWXMenu, null);
        }
    }

    protected void onCreateWithModel(PSWXMenu pSWXMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSWXMenu pSWXMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSWXMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWXMenu, ACTION_GETDRAFTFROMWITHMODEL);
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWXMenuServiceBase.this.getService(), PSWXMenuServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSWXMenu2, null).getResult() != 1) {
                    PSWXMenuServiceBase.this.onGetDraftFromWithModel(pSWXMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSWXMenu, null);
        }
    }

    protected void onGetDraftFromWithModel(PSWXMenu pSWXMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSWXMenu pSWXMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSWXMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWXMenu, ACTION_GETDRAFTWITHMODEL);
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWXMenuServiceBase.this.getService(), PSWXMenuServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSWXMenu2, null).getResult() != 1) {
                    PSWXMenuServiceBase.this.onGetDraftWithModel(pSWXMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSWXMenu, null);
        }
    }

    protected void onGetDraftWithModel(PSWXMenu pSWXMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSWXMenu pSWXMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSWXMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWXMenu, ACTION_GETWITHMODEL);
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWXMenuServiceBase.this.getService(), PSWXMenuServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSWXMenu2, null).getResult() != 1) {
                    PSWXMenuServiceBase.this.onGetWithModel(pSWXMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSWXMenu, null);
        }
    }

    protected void onGetWithModel(PSWXMenu pSWXMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void previewSave(PSWXMenu pSWXMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 0, (IEntity)pSWXMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWXMenu, ACTION_PREVIEWSAVE);
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWXMenuServiceBase.this.getService(), PSWXMenuServiceBase.ACTION_PREVIEWSAVE, 40, (IEntity)pSWXMenu2, null).getResult() != 1) {
                    PSWXMenuServiceBase.this.onPreviewSave(pSWXMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 99, (IEntity)pSWXMenu, null);
        }
    }

    protected void onPreviewSave(PSWXMenu pSWXMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PreviewSave]");
    }

    public void updateWithModel(PSWXMenu pSWXMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSWXMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWXMenu, ACTION_UPDATEWITHMODEL);
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWXMenuServiceBase.this.getService(), PSWXMenuServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSWXMenu2, null).getResult() != 1) {
                    PSWXMenuServiceBase.this.onUpdateWithModel(pSWXMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSWXMenu, null);
        }
    }

    protected void onUpdateWithModel(PSWXMenu pSWXMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSWXMenu pSWXMenu, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENU_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory());
            PSWXAccount pSWXAccount = (PSWXAccount)iService.getDEModel().createEntity();
            pSWXAccount.set("PSWXACCOUNTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWXAccount);
            } else {
                iService.get((IEntity)pSWXAccount);
            }
            this.onFillParentInfo_PSWXAccount(pSWXMenu, pSWXAccount);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService", (SessionFactory)this.getSessionFactory());
            PSWXEntApp pSWXEntApp = (PSWXEntApp)iService.getDEModel().createEntity();
            pSWXEntApp.set("PSWXENTAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWXEntApp);
            } else {
                iService.get((IEntity)pSWXEntApp);
            }
            this.onFillParentInfo_PSWXEntApp(pSWXMenu, pSWXEntApp);
            return;
        }
        super.onFillParentInfo((IEntity)pSWXMenu, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSWXAccount(PSWXMenu pSWXMenu, PSWXAccount pSWXAccount) throws Exception {
        pSWXMenu.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
        pSWXMenu.setPSWXAccountName(pSWXAccount.getPSWXAccountName());
    }

    protected void onFillParentInfo_PSWXEntApp(PSWXMenu pSWXMenu, PSWXEntApp pSWXEntApp) throws Exception {
        pSWXMenu.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
        pSWXMenu.setPSWXEntAppName(pSWXEntApp.getPSWXEntAppName());
        if (pSWXEntApp.getPSWXAccount() != null) {
            this.onFillParentInfo_PSWXAccount(pSWXMenu, pSWXEntApp.getPSWXAccount());
        }
    }

    protected void onFillEntityFullInfo(PSWXMenu pSWXMenu, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSWXMenu, bl);
        this.onFillEntityFullInfo_PSWXAccount(pSWXMenu, bl);
        this.onFillEntityFullInfo_PSWXEntApp(pSWXMenu, bl);
    }

    protected void onFillEntityFullInfo_PSWXAccount(PSWXMenu pSWXMenu, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWXEntApp(PSWXMenu pSWXMenu, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWXMenu pSWXMenu, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWXMenu, bl);
    }

    public ArrayList<PSWXMenu> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, "", -1);
    }

    public ArrayList<PSWXMenu> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, string, -1);
    }

    public ArrayList<PSWXMenu> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string, int n) throws Exception {
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

    public ArrayList<PSWXMenu> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase) throws Exception {
        return this.selectByPSWXEntApp(pSWXEntAppBase, "", -1);
    }

    public ArrayList<PSWXMenu> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase, String string) throws Exception {
        return this.selectByPSWXEntApp(pSWXEntAppBase, string, -1);
    }

    public ArrayList<PSWXMenu> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase, String string, int n) throws Exception {
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

    public void testRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    public void resetPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWXMenu> arrayList = this.selectByPSWXAccount(pSWXAccount);
        for (PSWXMenu pSWXMenu : arrayList) {
            PSWXMenu pSWXMenu2 = (PSWXMenu)this.getDEModel().createEntity();
            pSWXMenu2.setPSWXMenuId(pSWXMenu.getPSWXMenuId());
            pSWXMenu2.setPSWXAccountId(null);
            this.update(pSWXMenu2);
        }
    }

    public void removeByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        final PSWXAccount pSWXAccount2 = pSWXAccount;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuServiceBase.this.onBeforeRemoveByPSWXAccount(pSWXAccount2);
                PSWXMenuServiceBase.this.internalRemoveByPSWXAccount(pSWXAccount2);
                PSWXMenuServiceBase.this.onAfterRemoveByPSWXAccount(pSWXAccount2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void internalRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWXMenu> arrayList = this.selectByPSWXAccount(pSWXAccount);
        this.onBeforeRemoveByPSWXAccount(pSWXAccount, arrayList);
        for (PSWXMenu pSWXMenu : arrayList) {
            this.remove((IEntity)pSWXMenu);
        }
        this.onAfterRemoveByPSWXAccount(pSWXAccount, arrayList);
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWXMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWXMenu> arrayList) throws Exception {
    }

    public void testRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWXMenu> arrayList = this.selectByPSWXEntApp(pSWXEntApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWXENTAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWXEntApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID", "", iDataEntityModel.getName(), "PSWXMENU", iDataEntityModel.getDataInfo((IEntity)pSWXEntApp), arrayList.get(0)));
        }
    }

    public void resetPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWXMenu> arrayList = this.selectByPSWXEntApp(pSWXEntApp);
        for (PSWXMenu pSWXMenu : arrayList) {
            PSWXMenu pSWXMenu2 = (PSWXMenu)this.getDEModel().createEntity();
            pSWXMenu2.setPSWXMenuId(pSWXMenu.getPSWXMenuId());
            pSWXMenu2.setPSWXEntAppId(null);
            this.update(pSWXMenu2);
        }
    }

    public void removeByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        final PSWXEntApp pSWXEntApp2 = pSWXEntApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuServiceBase.this.onBeforeRemoveByPSWXEntApp(pSWXEntApp2);
                PSWXMenuServiceBase.this.internalRemoveByPSWXEntApp(pSWXEntApp2);
                PSWXMenuServiceBase.this.onAfterRemoveByPSWXEntApp(pSWXEntApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
    }

    protected void internalRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWXMenu> arrayList = this.selectByPSWXEntApp(pSWXEntApp);
        this.onBeforeRemoveByPSWXEntApp(pSWXEntApp, arrayList);
        for (PSWXMenu pSWXMenu : arrayList) {
            this.remove((IEntity)pSWXMenu);
        }
        this.onAfterRemoveByPSWXEntApp(pSWXEntApp, arrayList);
    }

    protected void onAfterRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
    }

    protected void onBeforeRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp, ArrayList<PSWXMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp, ArrayList<PSWXMenu> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWXMenu pSWXMenu) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        pSWXMenuItemService.testRemoveByPSWXMenu(pSWXMenu);
        pSWXMenuItemService.removeByPSWXMenu(pSWXMenu);
        super.onBeforeRemove(pSWXMenu);
    }

    protected void onBeforeRemoveTemp(PSWXMenu pSWXMenu) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        pSWXMenuItemService.removeTempByPSWXMenu(pSWXMenu);
        super.onBeforeRemoveTemp((IEntity)pSWXMenu);
    }

    protected void getRelatedDataTempMajor(PSWXMenu pSWXMenu) throws Exception {
        this.getRelatedDataTempMajor_PSWXMenuItem(pSWXMenu);
        super.getRelatedDataTempMajor((IEntity)pSWXMenu);
    }

    protected void getRelatedDataTempMajor_PSWXMenuItem(PSWXMenu pSWXMenu) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWXMenuItem> arrayList = null;
        String string = pSWXMenu.getPSWXMenuId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWXMenuItemService.selectByPSWXMenu(pSWXMenu) : pSWXMenuItemService.selectTempByPSWXMenu(pSWXMenu);
        PSWXMenuServiceBase.sortHierarchyEntities(arrayList, (String)"PSWXMENUITEMID", (String)"PPSWXMENUITEMID");
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            pSWXMenuItemService.getTempMajor(pSWXMenuItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSWXMenu pSWXMenu, PSWXMenu pSWXMenu2) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.updateRelatedDataTempMajor_removePSWXMenuItem(pSWXMenu, pSWXMenu2);
        this.updateRelatedDataTempMajor_updatePSWXMenuItem(pSWXMenu, pSWXMenu2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSWXMenu, (IEntity)pSWXMenu2);
    }

    protected ArrayList<PSWXMenuItem> updateRelatedDataTempMajor_removePSWXMenuItem(PSWXMenu pSWXMenu, PSWXMenu pSWXMenu2) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWXMenuItem> arrayList = pSWXMenuItemService.selectTempByPSWXMenu(pSWXMenu);
        ArrayList<PSWXMenuItem> arrayList2 = pSWXMenuItemService.selectByPSWXMenu(pSWXMenu2);
        HashMap<String, PSWXMenuItem> hashMap = new HashMap<String, PSWXMenuItem>();
        for (PSWXMenuItem pSWXMenuItem : arrayList2) {
            hashMap.put(pSWXMenuItem.getPSWXMenuItemId(), pSWXMenuItem);
        }
        PSWXMenuServiceBase.sortHierarchyEntities(arrayList, (String)"PSWXMENUITEMID", (String)"PPSWXMENUITEMID");
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            Object object = pSWXMenuItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWXMenuItem pSWXMenuItem : hashMap.values()) {
            pSWXMenuItemService.remove((IEntity)pSWXMenuItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWXMenuItem(PSWXMenu pSWXMenu, PSWXMenu pSWXMenu2, ArrayList<PSWXMenuItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            pSWXMenuItemService.updateTempMajor(pSWXMenuItem);
        }
    }

    protected void replaceParentInfo(PSWXMenu pSWXMenu, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSWXMenu, cloneSession);
        if (pSWXMenu.getPSWXAccountId() != null && (iEntity = cloneSession.getEntity("PSWXACCOUNT", (Object)pSWXMenu.getPSWXAccountId())) != null) {
            this.onFillParentInfo_PSWXAccount(pSWXMenu, (PSWXAccount)iEntity);
        }
        if (pSWXMenu.getPSWXEntAppId() != null && (iEntity = cloneSession.getEntity("PSWXENTAPP", (Object)pSWXMenu.getPSWXEntAppId())) != null) {
            this.onFillParentInfo_PSWXEntApp(pSWXMenu, (PSWXEntApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWXMenu pSWXMenu, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWXMenu, bl);
    }

    protected void onCheckEntity(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSWXMenu, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MenuModel(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXAccountId(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXEntAppId(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuId(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuName(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWXMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWXMenu, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isCodeNameDirty() : !pSWXMenu.isCodeNameDirty()) {
            return null;
        }
        String string = pSWXMenu.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSWXMenu, bl2, bl3);
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
                string3 = "PSWXENTAPPID";
                string3 = string3 + ";";
                string3 = string3 + "PSWXACCOUNTID";
                String string4 = this.checkFieldDupRule(this.getPSWXMenuDEModel(), "CODENAME", string3, pSWXMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isDefaultFlagDirty() && !bl2 : !pSWXMenu.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSWXMenu.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSWXMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSWXENTAPPID";
                String string2 = this.checkFieldDupRule(this.getPSWXMenuDEModel(), "DEFAULTFLAG", string, pSWXMenu, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isMemoDirty() : !pSWXMenu.isMemoDirty()) {
            return null;
        }
        String string = pSWXMenu.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSWXMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_MenuModel(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isMenuModelDirty() : !pSWXMenu.isMenuModelDirty()) {
            return null;
        }
        String string = pSWXMenu.getMenuModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MenuModel_Default((IEntity)pSWXMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MENUMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXAccountId(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isPSWXAccountIdDirty() && !bl2 : !pSWXMenu.isPSWXAccountIdDirty()) {
            return null;
        }
        String string = pSWXMenu.getPSWXAccountId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXACCOUNTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXAccountId_Default((IEntity)pSWXMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXEntAppId(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isPSWXEntAppIdDirty() : !pSWXMenu.isPSWXEntAppIdDirty()) {
            return null;
        }
        String string = pSWXMenu.getPSWXEntAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXEntAppId_Default((IEntity)pSWXMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWXMenuId(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isPSWXMenuIdDirty() && !bl2 : !pSWXMenu.isPSWXMenuIdDirty()) {
            return null;
        }
        String string = pSWXMenu.getPSWXMenuId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuId_Default((IEntity)pSWXMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuName(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isPSWXMenuNameDirty() && !bl2 : !pSWXMenu.isPSWXMenuNameDirty()) {
            return null;
        }
        String string = pSWXMenu.getPSWXMenuName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuName_Default((IEntity)pSWXMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isUserCatDirty() : !pSWXMenu.isUserCatDirty()) {
            return null;
        }
        String string = pSWXMenu.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSWXMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isUserTagDirty() : !pSWXMenu.isUserTagDirty()) {
            return null;
        }
        String string = pSWXMenu.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSWXMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isUserTag2Dirty() : !pSWXMenu.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWXMenu.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSWXMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isUserTag3Dirty() : !pSWXMenu.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWXMenu.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSWXMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWXMenu pSWXMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenu.isUserTag4Dirty() : !pSWXMenu.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWXMenu.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSWXMenu, bl2, bl3);
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

    protected void onSyncEntity(PSWXMenu pSWXMenu, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWXMenu, bl);
    }

    protected void onSyncIndexEntities(PSWXMenu pSWXMenu, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWXMenu, bl);
    }

    public Object getDataContextValue(PSWXMenu pSWXMenu, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWXMenu, string, iDataContextParam)) != null) {
            return object;
        }
        PSWXAccount pSWXAccount = pSWXMenu.getPSWXAccount();
        if (pSWXAccount != null && pSWXAccount.contains(string)) {
            return pSWXAccount.get(string);
        }
        PSWXEntApp pSWXEntApp = pSWXMenu.getPSWXEntApp();
        if (pSWXEntApp != null && pSWXEntApp.contains(string)) {
            return pSWXEntApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWXMenu pSWXMenu, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSWXMenu, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MENUMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MenuModel_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSWXMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MenuModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MENUMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PSWXMenuId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXMenuName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWXMenu pSWXMenu) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSWXMenu)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWXMenu pSWXMenu) throws Exception {
        IService iService;
        Object object = pSWXMenu.get("PSWXACCOUNTID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWXMENU_PSWXACCOUNT_PSWXACCOUNTID", object);
        }
        if ((object = pSWXMenu.get("PSWXENTAPPID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID", object);
        }
        super.onUpdateParent((IEntity)pSWXMenu);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSWXMenu pSWXMenu, Object object) throws Exception {
        PSWXMenu pSWXMenu2 = new PSWXMenu();
        pSWXMenu2.set("PSWXMENUID", object);
        String string = DataObject.getStringValue((Object)pSWXMenu.get("PSWXMENUID"));
        super.onCopyDetails((IEntity)pSWXMenu, object);
    }

    @Override
    protected void exportCurXmlModel(PSWXMenu pSWXMenu, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWXMENU");
        if (!bl) {
            pSWXMenu.setCreateDate(null);
            pSWXMenu.setCreateMan(null);
            pSWXMenu.setPSWXMenuId(null);
            pSWXMenu.setUpdateDate(null);
            pSWXMenu.setUpdateMan(null);
            super.exportCurXmlModel(pSWXMenu, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSWXMenu pSWXMenu, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSWXMenu, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSWXMenu pSWXMenu, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSWXMenu, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWXMenu pSWXMenu, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWXMenu, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXENTAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWXENTAPP#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWXACCOUNT#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXENTAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWXMENU_PSWXENTAPP_PSWXENTAPPID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWXMENU_PSWXACCOUNT_PSWXACCOUNTID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXENTAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXENTAPPNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXACCOUNTNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWXENTAPP", (boolean)true) == 0) {
            iEntity.set("PSWXENTAPPID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWXACCOUNT", (boolean)true) == 0) {
            iEntity.set("PSWXACCOUNTID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWXENTAPPID", "PSWXACCOUNTID"};
    }

    @Override
    public String getModelV2Tag(PSWXMenu pSWXMenu) {
        if (!StringHelper.isNullOrEmpty((String)pSWXMenu.getCodeName())) {
            return pSWXMenu.getCodeName();
        }
        return super.getModelV2Tag(pSWXMenu);
    }

    @Override
    public boolean setModelV2Tag(PSWXMenu pSWXMenu, String string) {
        pSWXMenu.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSWXENTAPPID", "");
        map.put("PSWXACCOUNTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWXMenu pSWXMenu, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWXMenu.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWXMenu, true);
        pSWXMenu.set("CODENAME", string);
        if (this.select(pSWXMenu, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWXMenu, true);
        return super.getModelV2Entity(pSWXMenu, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWXMenu pSWXMenu, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWXMenu, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSWXMENUITEM_PSWXMENU_PSWXMENUID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSWXMenu pSWXMenu, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSWXMenu, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSWXMenu pSWXMenu, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWXMENUITEM_PSWXMENU_PSWXMENUID")) {
            Object object;
            PSWXMenuItem pSWXMenuItem2;
            Object object2;
            Object object3;
            Object object4;
            PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSWXMenuItem> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXMENU#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWXMENUITEM", (Object)pSWXMenu.getPSWXMenuId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSWXMenuItem2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSWXMenuItem2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSWXMenuItem>();
                object4 = pSWXMenuItemService.selectByPSWXMenu(pSWXMenu);
                object3 = StringHelper.format((String)"PSWXMENU#%1$s", (Object)pSWXMenu.getPSWXMenuId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSWXMenuItem2 = object2.next();
                    object = pSWXMenuItemService.getModelV2ResScope((IEntity)pSWXMenuItem2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWXMenuItem)PSModelV2Helper.toJSONObject((IEntity)pSWXMenuItem2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSWXMenuItemService.getModelV2Name(false);
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
                        if (objectNode.has("pswxmenuitemname")) {
                            string = objectNode.get("pswxmenuitemname").asText();
                        }
                        if (objectNode2.has("pswxmenuitemname")) {
                            string2 = objectNode2.get("pswxmenuitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSWXMenuItem pSWXMenuItem2 : arrayList) {
                    object = new PSWXMenuItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSWXMenuItem2, false);
                    ((PSWXMenuItemBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSWXMenuItemService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSWXMenu, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSWXMenu pSWXMenu) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWXMenuItem> arrayList = pSWXMenuItemService.selectByPSWXMenu(pSWXMenu);
        String string = StringHelper.format((String)"PSWXMENU#%1$s", (Object)pSWXMenu.getPSWXMenuId());
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            String string2 = pSWXMenuItemService.getModelV2ResScope((IEntity)pSWXMenuItem);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSWXMenuItemService.emptyModelV2(pSWXMenuItem);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSWXMenu.getPSWXMenuId());
        pSWXMenuItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSWXMenuItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWXMENUITEM WHERE PSWXMENUID = ?", sqlParamList);
        super.onEmptyModelV2(pSWXMenu);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSWXMenuItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSWXMenu pSWXMenu, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSWXMenuItem pSWXMenuItem = new PSWXMenuItem();
        pSWXMenuItem.set("PSWXMENUID", pSWXMenu.getPSWXMenuId());
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSWXMenuItemService.getModelV2Entity(pSWXMenuItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSWXMenu, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSWXMenu pSWXMenu, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSWXMenuItemService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSWXMenuItem pSWXMenuItem = new PSWXMenuItem();
                pSWXMenuItem.setPSWXMenuId(pSWXMenu.getPSWXMenuId());
                pSWXMenuItem.setPSWXMenuName(pSWXMenu.getPSWXMenuName());
                pSWXMenuItem.setOrderValue(n2 += 10);
                pSWXMenuItemService.compileModelV2(pSWXMenuItem, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSWXMenuItem pSWXMenuItem = new PSWXMenuItem();
                    pSWXMenuItem.setPSWXMenuId(pSWXMenu.getPSWXMenuId());
                    pSWXMenuItem.setPSWXMenuName(pSWXMenu.getPSWXMenuName());
                    pSWXMenuItemService.compileModelV2(pSWXMenuItem, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSWXMenu, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSWXMenu pSWXMenu, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSWXMenu, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSWXMenu pSWXMenu, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSWXMenu, list);
    }
}

