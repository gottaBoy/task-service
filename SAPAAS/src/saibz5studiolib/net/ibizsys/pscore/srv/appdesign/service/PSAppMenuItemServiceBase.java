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
import java.util.Iterator;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppMenuItemDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppMenuItemDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFuncBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItemBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppMenuItemServiceBase
extends PSCoreSysServiceBase<PSAppMenuItem> {
    private static final Log log = LogFactory.getLog(PSAppMenuItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_MENUITEM = "MenuItem";
    public static final String ACTION_CALCPSDEID = "CalcPSDEId";
    public static final String ACTION_CHANGEAPPFUNC = "ChangeAppFunc";
    public static final String ACTION_CREATETEMPWITHPREVIEW = "CreateTempWithPreview";
    public static final String ACTION_GETTEMPWITHPREVIEW = "GetTempWithPreview";
    public static final String ACTION_UPDATETEMPWITHPREVIEW = "UpdateTempWithPreview";
    private PSAppMenuItemDEModel pSAppMenuItemDEModel;
    private PSAppMenuItemDAO pSAppMenuItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService";
    }

    public PSAppMenuItemDEModel getPSAppMenuItemDEModel() {
        if (this.pSAppMenuItemDEModel == null) {
            try {
                this.pSAppMenuItemDEModel = (PSAppMenuItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppMenuItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppMenuItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppMenuItemDEModel();
    }

    public PSAppMenuItemDAO getPSAppMenuItemDAO() {
        if (this.pSAppMenuItemDAO == null) {
            try {
                this.pSAppMenuItemDAO = (PSAppMenuItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppMenuItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppMenuItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppMenuItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_MENUITEM, (boolean)true) == 0) {
            return this.fetchMenuItem(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_MENUITEM, (boolean)true) == 0) {
            return this.fetchTempMenuItem(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCPSDEID, (boolean)true) == 0) {
            this.calcPSDEId((PSAppMenuItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGEAPPFUNC, (boolean)true) == 0) {
            this.changeAppFunc((PSAppMenuItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATETEMPWITHPREVIEW, (boolean)true) == 0) {
            this.createTempWithPreview((PSAppMenuItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETTEMPWITHPREVIEW, (boolean)true) == 0) {
            this.getTempWithPreview((PSAppMenuItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATETEMPWITHPREVIEW, (boolean)true) == 0) {
            this.updateTempWithPreview((PSAppMenuItem)iEntity);
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

    public DBFetchResult fetchMenuItem(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_MENUITEM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempMenuItem(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_MENUITEM, true);
        return dBFetchResult;
    }

    public void calcPSDEId(PSAppMenuItem pSAppMenuItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCPSDEID, 0, (IEntity)pSAppMenuItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppMenuItem, ACTION_CALCPSDEID);
        final PSAppMenuItem pSAppMenuItem2 = pSAppMenuItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuItemServiceBase.this.getService(), PSAppMenuItemServiceBase.ACTION_CALCPSDEID, 40, (IEntity)pSAppMenuItem2, null).getResult() != 1) {
                    PSAppMenuItemServiceBase.this.onCalcPSDEId(pSAppMenuItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCPSDEID, 99, (IEntity)pSAppMenuItem, null);
        }
    }

    protected void onCalcPSDEId(PSAppMenuItem pSAppMenuItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcPSDEId]");
    }

    public void changeAppFunc(PSAppMenuItem pSAppMenuItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEAPPFUNC, 0, (IEntity)pSAppMenuItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppMenuItem, ACTION_CHANGEAPPFUNC);
        final PSAppMenuItem pSAppMenuItem2 = pSAppMenuItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuItemServiceBase.this.getService(), PSAppMenuItemServiceBase.ACTION_CHANGEAPPFUNC, 40, (IEntity)pSAppMenuItem2, null).getResult() != 1) {
                    PSAppMenuItemServiceBase.this.onChangeAppFunc(pSAppMenuItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEAPPFUNC, 99, (IEntity)pSAppMenuItem, null);
        }
    }

    protected void onChangeAppFunc(PSAppMenuItem pSAppMenuItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeAppFunc]");
    }

    public void createTempWithPreview(PSAppMenuItem pSAppMenuItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATETEMPWITHPREVIEW, 0, (IEntity)pSAppMenuItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppMenuItem, ACTION_CREATETEMPWITHPREVIEW);
        final PSAppMenuItem pSAppMenuItem2 = pSAppMenuItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuItemServiceBase.this.getService(), PSAppMenuItemServiceBase.ACTION_CREATETEMPWITHPREVIEW, 40, (IEntity)pSAppMenuItem2, null).getResult() != 1) {
                    PSAppMenuItemServiceBase.this.onCreateTempWithPreview(pSAppMenuItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATETEMPWITHPREVIEW, 99, (IEntity)pSAppMenuItem, null);
        }
    }

    protected void onCreateTempWithPreview(PSAppMenuItem pSAppMenuItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateTempWithPreview]");
    }

    public void getTempWithPreview(PSAppMenuItem pSAppMenuItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETTEMPWITHPREVIEW, 0, (IEntity)pSAppMenuItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppMenuItem, ACTION_GETTEMPWITHPREVIEW);
        final PSAppMenuItem pSAppMenuItem2 = pSAppMenuItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuItemServiceBase.this.getService(), PSAppMenuItemServiceBase.ACTION_GETTEMPWITHPREVIEW, 40, (IEntity)pSAppMenuItem2, null).getResult() != 1) {
                    PSAppMenuItemServiceBase.this.onGetTempWithPreview(pSAppMenuItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETTEMPWITHPREVIEW, 99, (IEntity)pSAppMenuItem, null);
        }
    }

    protected void onGetTempWithPreview(PSAppMenuItem pSAppMenuItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetTempWithPreview]");
    }

    public void updateTempWithPreview(PSAppMenuItem pSAppMenuItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATETEMPWITHPREVIEW, 0, (IEntity)pSAppMenuItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppMenuItem, ACTION_UPDATETEMPWITHPREVIEW);
        final PSAppMenuItem pSAppMenuItem2 = pSAppMenuItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuItemServiceBase.this.getService(), PSAppMenuItemServiceBase.ACTION_UPDATETEMPWITHPREVIEW, 40, (IEntity)pSAppMenuItem2, null).getResult() != 1) {
                    PSAppMenuItemServiceBase.this.onUpdateTempWithPreview(pSAppMenuItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATETEMPWITHPREVIEW, 99, (IEntity)pSAppMenuItem, null);
        }
    }

    protected void onUpdateTempWithPreview(PSAppMenuItem pSAppMenuItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateTempWithPreview]");
    }

    protected void onFillParentInfo(PSAppMenuItem pSAppMenuItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSAPPFUNC_PSAPPFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService", (SessionFactory)this.getSessionFactory());
            PSAppFunc pSAppFunc = (PSAppFunc)iService.getDEModel().createEntity();
            pSAppFunc.set("PSAPPFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppFunc);
            } else {
                iService.get((IEntity)pSAppFunc);
            }
            this.onFillParentInfo_PSAppFunc(pSAppMenuItem, pSAppFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSAPPLOCALDE_PSAPPLOCALDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService", (SessionFactory)this.getSessionFactory());
            PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iService.getDEModel().createEntity();
            pSAppLocalDE.set("PSAPPLOCALDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppLocalDE);
            } else {
                iService.get((IEntity)pSAppLocalDE);
            }
            this.onFillParentInfo_PSAppLocalDE(pSAppMenuItem, pSAppLocalDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSAPPMENUITEM_PPSAPPMENUITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService", (SessionFactory)this.getSessionFactory());
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)iService.getDEModel().createEntity();
            pSAppMenuItem2.set("PSAPPMENUITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppMenuItem2);
            } else {
                iService.get((IEntity)pSAppMenuItem2);
            }
            this.onFillParentInfo_PPSAppMenuItem(pSAppMenuItem, pSAppMenuItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSAPPMENU_PSAPPMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = (PSAppMenu)iService.getDEModel().createEntity();
            pSAppMenu.set("PSAPPMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppMenu);
            } else {
                iService.get((IEntity)pSAppMenu);
            }
            this.onFillParentInfo_PSAppMenu(pSAppMenuItem, pSAppMenu);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSAPPMENU_REFPSAPPMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = (PSAppMenu)iService.getDEModel().createEntity();
            pSAppMenu.set("PSAPPMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppMenu);
            } else {
                iService.get((IEntity)pSAppMenu);
            }
            this.onFillParentInfo_RefPSAppMenu(pSAppMenuItem, pSAppMenu);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSAPPVIEW_OPENPSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppView);
            } else {
                iService.get((IEntity)pSAppView);
            }
            this.onFillParentInfo_OpenPSAppView(pSAppMenuItem, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSAppMenuItem, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUIAction);
            } else {
                iService.get((IEntity)pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSAppMenuItem, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSAppMenuItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSAppMenuItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSAppMenuItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSAppMenuItem, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSAppMenuItem, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSAppMenuItem, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENUITEM_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUniRes);
            } else {
                iService.get((IEntity)pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSAppMenuItem, pSSysUniRes);
            return;
        }
        super.onFillParentInfo((IEntity)pSAppMenuItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppFunc(PSAppMenuItem pSAppMenuItem, PSAppFunc pSAppFunc) throws Exception {
        pSAppMenuItem.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
        pSAppMenuItem.setPSAppFuncName(pSAppFunc.getPSAppFuncName());
    }

    protected void onFillParentInfo_PSAppLocalDE(PSAppMenuItem pSAppMenuItem, PSAppLocalDE pSAppLocalDE) throws Exception {
        pSAppMenuItem.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
        pSAppMenuItem.setPSAppLocalDEName(pSAppLocalDE.getPSAppLocalDEName());
        pSAppMenuItem.setPSDEId(pSAppLocalDE.getPSDEId());
    }

    protected void onFillParentInfo_PPSAppMenuItem(PSAppMenuItem pSAppMenuItem, PSAppMenuItem pSAppMenuItem2) throws Exception {
        pSAppMenuItem.setPPSAppMenuItemId(pSAppMenuItem2.getPSAppMenuItemId());
        pSAppMenuItem.setPPSAppMenuItemName(pSAppMenuItem2.getPSAppMenuItemName());
        if (pSAppMenuItem2.getPSAppMenu() != null) {
            this.onFillParentInfo_PSAppMenu(pSAppMenuItem, pSAppMenuItem2.getPSAppMenu());
        }
    }

    protected void onFillParentInfo_PSAppMenu(PSAppMenuItem pSAppMenuItem, PSAppMenu pSAppMenu) throws Exception {
        pSAppMenuItem.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSAppMenuItem.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
        pSAppMenuItem.setPSSysAppId(pSAppMenu.getPSSysAppId());
    }

    protected void onFillParentInfo_RefPSAppMenu(PSAppMenuItem pSAppMenuItem, PSAppMenu pSAppMenu) throws Exception {
        pSAppMenuItem.setRefPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSAppMenuItem.setRefPSAppMenuName(pSAppMenu.getPSAppMenuName());
    }

    protected void onFillParentInfo_OpenPSAppView(PSAppMenuItem pSAppMenuItem, PSAppView pSAppView) throws Exception {
        pSAppMenuItem.setOpenPSAppViewId(pSAppView.getPSAppViewId());
        pSAppMenuItem.setOpenPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_PSDELogic(PSAppMenuItem pSAppMenuItem, PSDELogic pSDELogic) throws Exception {
        pSAppMenuItem.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSAppMenuItem.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSAppMenuItem pSAppMenuItem, PSDEUIAction pSDEUIAction) throws Exception {
        pSAppMenuItem.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSAppMenuItem.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSAppMenuItem pSAppMenuItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSAppMenuItem.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSAppMenuItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSAppMenuItem pSAppMenuItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSAppMenuItem.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSAppMenuItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSAppMenuItem pSAppMenuItem, PSSysCss pSSysCss) throws Exception {
        pSAppMenuItem.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSAppMenuItem.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSAppMenuItem pSAppMenuItem, PSSysImage pSSysImage) throws Exception {
        pSAppMenuItem.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSAppMenuItem.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSAppMenuItem pSAppMenuItem, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSAppMenuItem.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSAppMenuItem.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysResource(PSAppMenuItem pSAppMenuItem, PSSysResource pSSysResource) throws Exception {
        pSAppMenuItem.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSAppMenuItem.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSAppMenuItem pSAppMenuItem, PSSysUniRes pSSysUniRes) throws Exception {
        pSAppMenuItem.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSAppMenuItem.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillEntityFullInfo(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
        if (bl) {
            if (pSAppMenuItem.getHiddenItem() == null) {
                pSAppMenuItem.setHiddenItem((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSAppMenuItem.getMenuItemState() == null) {
                pSAppMenuItem.setMenuItemState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSAppFunc(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSAppLocalDE(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PPSAppMenuItem(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSAppMenu(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_RefPSAppMenu(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_OpenPSAppView(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSDELogic(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSSysCss(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSSysImage(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSSysResource(pSAppMenuItem, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSAppMenuItem, bl);
    }

    protected void onFillEntityFullInfo_PSAppFunc(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppLocalDE(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSAppMenuItem(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppMenu(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSAppMenu(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OpenPSAppView(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
        if (pSAppMenuItem.isCapPSLanResIdDirty()) {
            if (pSAppMenuItem.getCapPSLanResId() != null) {
                if (pSAppMenuItem.getCapPSLanResId() == null || pSAppMenuItem.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSAppMenuItem.getCapPSLanRes();
                    pSAppMenuItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSAppMenuItem.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
        if (pSAppMenuItem.isTipPSLanResIdDirty()) {
            if (pSAppMenuItem.getTipPSLanResId() != null) {
                if (pSAppMenuItem.getTipPSLanResId() == null || pSAppMenuItem.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSAppMenuItem.getTipPSLanRes();
                    pSAppMenuItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSAppMenuItem.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
        if (pSAppMenuItem.isPSSysCssIdDirty()) {
            if (pSAppMenuItem.getPSSysCssId() != null) {
                if (pSAppMenuItem.getPSSysCssId() == null || pSAppMenuItem.getPSSysCssName() == null) {
                    PSSysCss pSSysCss = pSAppMenuItem.getPSSysCss();
                    pSAppMenuItem.setPSSysCssName(pSSysCss.getPSSysCssName());
                }
            } else {
                pSAppMenuItem.setPSSysCssName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysImage(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
        if (pSAppMenuItem.isPSSysImageIdDirty()) {
            if (pSAppMenuItem.getPSSysImageId() != null) {
                if (pSAppMenuItem.getPSSysImageId() == null || pSAppMenuItem.getPSSysImageName() == null) {
                    PSSysImage pSSysImage = pSAppMenuItem.getPSSysImage();
                    pSAppMenuItem.setPSSysImageName(pSSysImage.getPSSysImageName());
                }
            } else {
                pSAppMenuItem.setPSSysImageName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSAppMenuItem, bl);
    }

    public ArrayList<PSAppMenuItem> selectByPSAppFunc(PSAppFuncBase pSAppFuncBase) throws Exception {
        return this.selectByPSAppFunc(pSAppFuncBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSAppFunc(PSAppFuncBase pSAppFuncBase, String string) throws Exception {
        return this.selectByPSAppFunc(pSAppFuncBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSAppFunc(PSAppFuncBase pSAppFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPFUNCID", (Object)pSAppFuncBase.getPSAppFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPLOCALDEID", (Object)pSAppLocalDEBase.getPSAppLocalDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppLocalDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppLocalDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByPPSAppMenuItem(PSAppMenuItemBase pSAppMenuItemBase) throws Exception {
        return this.selectByPPSAppMenuItem(pSAppMenuItemBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPPSAppMenuItem(PSAppMenuItemBase pSAppMenuItemBase, String string) throws Exception {
        return this.selectByPPSAppMenuItem(pSAppMenuItemBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPPSAppMenuItem(PSAppMenuItemBase pSAppMenuItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSAPPMENUITEMID", (Object)pSAppMenuItemBase.getPSAppMenuItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSAppMenuItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSAppMenuItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectTempByPPSAppMenuItem(PSAppMenuItemBase pSAppMenuItemBase) throws Exception {
        return this.selectTempByPPSAppMenuItem(pSAppMenuItemBase, "");
    }

    public ArrayList<PSAppMenuItem> selectTempByPPSAppMenuItem(PSAppMenuItemBase pSAppMenuItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSAPPMENUITEMID", (Object)pSAppMenuItemBase.getPSAppMenuItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSAppMenuItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSAppMenuItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPMENUID", (Object)pSAppMenuBase.getPSAppMenuId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppMenuCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppMenuCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectTempByPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectTempByPSAppMenu(pSAppMenuBase, "");
    }

    public ArrayList<PSAppMenuItem> selectTempByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPMENUID", (Object)pSAppMenuBase.getPSAppMenuId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSAppMenuCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSAppMenuCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByRefPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectByRefPSAppMenu(pSAppMenuBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByRefPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        return this.selectByRefPSAppMenu(pSAppMenuBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByRefPSAppMenu(PSAppMenuBase pSAppMenuBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSAPPMENUID", (Object)pSAppMenuBase.getPSAppMenuId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSAppMenuCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSAppMenuCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByOpenPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByOpenPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByOpenPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByOpenPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByOpenPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPENPSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOpenPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOpenPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTipPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTipPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenuItem> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppMenuItem> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSAppMenuItem> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNIRESID", (Object)pSSysUniResBase.getPSSysUniResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSAppFunc(pSAppFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSAPPFUNC_PSAPPFUNCID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSAppFunc), arrayList.get(0)));
        }
    }

    public void resetPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSAppFunc(pSAppFunc);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSAppFuncId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
        final PSAppFunc pSAppFunc2 = pSAppFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSAppFunc(pSAppFunc2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSAppFunc(pSAppFunc2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSAppFunc(pSAppFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
    }

    protected void internalRemoveByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSAppFunc(pSAppFunc);
        this.onBeforeRemoveByPSAppFunc(pSAppFunc, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSAppFunc(pSAppFunc, arrayList);
    }

    protected void onAfterRemoveByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSAppFunc(PSAppFunc pSAppFunc, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppFunc(PSAppFunc pSAppFunc, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPLOCALDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppLocalDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSAPPLOCALDE_PSAPPLOCALDEID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSAppLocalDE), arrayList.get(0)));
        }
    }

    public void resetPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSAppLocalDEId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        final PSAppLocalDE pSAppLocalDE2 = pSAppLocalDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void internalRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
    }

    public void resetPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPPSAppMenuItem(pSAppMenuItem);
        for (PSAppMenuItem pSAppMenuItem2 : arrayList) {
            PSAppMenuItem pSAppMenuItem3 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem3.setPSAppMenuItemId(pSAppMenuItem2.getPSAppMenuItemId());
            pSAppMenuItem3.setPPSAppMenuItemId(null);
            this.update(pSAppMenuItem3);
        }
    }

    public void resetTempPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectTempByPPSAppMenuItem(pSAppMenuItem);
        for (PSAppMenuItem pSAppMenuItem2 : arrayList) {
            PSAppMenuItem pSAppMenuItem3 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem3.setPSAppMenuItemId(pSAppMenuItem2.getPSAppMenuItemId());
            pSAppMenuItem3.setPPSAppMenuItemId(null);
            this.updateTemp((IEntity)pSAppMenuItem3);
        }
    }

    public void removeByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
        final PSAppMenuItem pSAppMenuItem2 = pSAppMenuItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPPSAppMenuItem(pSAppMenuItem2);
                PSAppMenuItemServiceBase.this.internalRemoveByPPSAppMenuItem(pSAppMenuItem2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPPSAppMenuItem(pSAppMenuItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
    }

    protected void internalRemoveByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPPSAppMenuItem(pSAppMenuItem);
        this.onBeforeRemoveByPPSAppMenuItem(pSAppMenuItem, arrayList);
        for (PSAppMenuItem pSAppMenuItem2 : arrayList) {
            this.remove((IEntity)pSAppMenuItem2);
        }
        this.onAfterRemoveByPPSAppMenuItem(pSAppMenuItem, arrayList);
    }

    protected void onAfterRemoveByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    public void resetPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSAppMenu(pSAppMenu);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSAppMenuId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void resetTempPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectTempByPSAppMenu(pSAppMenu);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSAppMenuId(null);
            this.updateTemp((IEntity)pSAppMenuItem2);
        }
    }

    public void removeByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSAppMenu(pSAppMenu2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSAppMenu(pSAppMenu2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSAppMenu(pSAppMenu);
        this.onBeforeRemoveByPSAppMenu(pSAppMenu, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByRefPSAppMenu(pSAppMenu, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMENU");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppMenu);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSAPPMENU_REFPSAPPMENUID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSAppMenu), arrayList.get(0)));
        }
    }

    public void resetRefPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByRefPSAppMenu(pSAppMenu);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setRefPSAppMenuId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByRefPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByRefPSAppMenu(pSAppMenu2);
                PSAppMenuItemServiceBase.this.internalRemoveByRefPSAppMenu(pSAppMenu2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByRefPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveByRefPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByRefPSAppMenu(pSAppMenu);
        this.onBeforeRemoveByRefPSAppMenu(pSAppMenu, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByRefPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveByRefPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveByRefPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByOpenPSAppView(pSAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSAPPVIEW_OPENPSAPPVIEWID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSAppView), arrayList.get(0)));
        }
    }

    public void resetOpenPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByOpenPSAppView(pSAppView);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setOpenPSAppViewId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByOpenPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByOpenPSAppView(pSAppView2);
                PSAppMenuItemServiceBase.this.internalRemoveByOpenPSAppView(pSAppView2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByOpenPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByOpenPSAppView(pSAppView);
        this.onBeforeRemoveByOpenPSAppView(pSAppView, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByOpenPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByOpenPSAppView(PSAppView pSAppView, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOpenPSAppView(PSAppView pSAppView, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSDELogicId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSDEUIActionId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setCapPSLanResId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSAppMenuItemServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setTipPSLanResId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSAppMenuItemServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSSysCssId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSSysImageId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSSysPFPluginId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSSysResourceId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENUITEM_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSAPPMENUITEM", iDataEntityModel.getDataInfo((IEntity)pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            PSAppMenuItem pSAppMenuItem2 = (PSAppMenuItem)this.getDEModel().createEntity();
            pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
            pSAppMenuItem2.setPSSysUniResId(null);
            this.update(pSAppMenuItem2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSAppMenuItemServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSAppMenuItemServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.remove((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppMenuItem pSAppMenuItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByPPSAppMenuItem(pSAppMenuItem);
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).resetPPSAppMenuItem(pSAppMenuItem);
        pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenuItem(pSAppMenuItem);
        super.onBeforeRemove(pSAppMenuItem);
    }

    protected void onBeforeRemoveTemp(PSAppMenuItem pSAppMenuItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).resetTempPSAppMenuItem(pSAppMenuItem);
        pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).resetTempPPSAppMenuItem(pSAppMenuItem);
        super.onBeforeRemoveTemp((IEntity)pSAppMenuItem);
    }

    public void removeTempByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
        final PSAppMenuItem pSAppMenuItem2 = pSAppMenuItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveTempByPPSAppMenuItem(pSAppMenuItem2);
                PSAppMenuItemServiceBase.this.internalRemoveTempByPPSAppMenuItem(pSAppMenuItem2);
                PSAppMenuItemServiceBase.this.onAfterRemoveTempByPPSAppMenuItem(pSAppMenuItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
    }

    protected void internalRemoveTempByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectTempByPPSAppMenuItem(pSAppMenuItem);
        this.onBeforeRemoveTempByPPSAppMenuItem(pSAppMenuItem, arrayList);
        for (PSAppMenuItem pSAppMenuItem2 : arrayList) {
            this.removeTemp((IEntity)pSAppMenuItem2);
        }
        this.onAfterRemoveTempByPPSAppMenuItem(pSAppMenuItem, arrayList);
    }

    protected void onAfterRemoveTempByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSAppMenuItem(PSAppMenuItem pSAppMenuItem, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    public void removeTempByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItemServiceBase.this.onBeforeRemoveTempByPSAppMenu(pSAppMenu2);
                PSAppMenuItemServiceBase.this.internalRemoveTempByPSAppMenu(pSAppMenu2);
                PSAppMenuItemServiceBase.this.onAfterRemoveTempByPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveTempByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppMenuItem> arrayList = this.selectTempByPSAppMenu(pSAppMenu);
        this.onBeforeRemoveTempByPSAppMenu(pSAppMenu, arrayList);
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            this.removeTemp((IEntity)pSAppMenuItem);
        }
        this.onAfterRemoveTempByPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveTempByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveTempByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppMenuItem> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSAppMenuItem pSAppMenuItem) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSAppMenuItem);
    }

    protected void updateRelatedDataTempMajor(PSAppMenuItem pSAppMenuItem, PSAppMenuItem pSAppMenuItem2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSAppMenuItem, (IEntity)pSAppMenuItem2);
    }

    protected void replaceParentInfo(PSAppMenuItem pSAppMenuItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSAppMenuItem, cloneSession);
        if (pSAppMenuItem.getPSAppFuncId() != null && (iEntity = cloneSession.getEntity("PSAPPFUNC", (Object)pSAppMenuItem.getPSAppFuncId())) != null) {
            this.onFillParentInfo_PSAppFunc(pSAppMenuItem, (PSAppFunc)iEntity);
        }
        if (pSAppMenuItem.getPSAppLocalDEId() != null && (iEntity = cloneSession.getEntity("PSAPPLOCALDE", (Object)pSAppMenuItem.getPSAppLocalDEId())) != null) {
            this.onFillParentInfo_PSAppLocalDE(pSAppMenuItem, (PSAppLocalDE)iEntity);
        }
        if (pSAppMenuItem.getPPSAppMenuItemId() != null && (iEntity = cloneSession.getEntity("PSAPPMENUITEM", (Object)pSAppMenuItem.getPPSAppMenuItemId())) != null) {
            this.onFillParentInfo_PPSAppMenuItem(pSAppMenuItem, (PSAppMenuItem)iEntity);
        }
        if (pSAppMenuItem.getPSAppMenuId() != null && (iEntity = cloneSession.getEntity("PSAPPMENU", (Object)pSAppMenuItem.getPSAppMenuId())) != null) {
            this.onFillParentInfo_PSAppMenu(pSAppMenuItem, (PSAppMenu)iEntity);
        }
        if (pSAppMenuItem.getRefPSAppMenuId() != null && (iEntity = cloneSession.getEntity("PSAPPMENU", (Object)pSAppMenuItem.getRefPSAppMenuId())) != null) {
            this.onFillParentInfo_RefPSAppMenu(pSAppMenuItem, (PSAppMenu)iEntity);
        }
        if (pSAppMenuItem.getOpenPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSAppMenuItem.getOpenPSAppViewId())) != null) {
            this.onFillParentInfo_OpenPSAppView(pSAppMenuItem, (PSAppView)iEntity);
        }
        if (pSAppMenuItem.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSAppMenuItem.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSAppMenuItem, (PSDELogic)iEntity);
        }
        if (pSAppMenuItem.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSAppMenuItem.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSAppMenuItem, (PSDEUIAction)iEntity);
        }
        if (pSAppMenuItem.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSAppMenuItem.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSAppMenuItem, (PSLanguageRes)iEntity);
        }
        if (pSAppMenuItem.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSAppMenuItem.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSAppMenuItem, (PSLanguageRes)iEntity);
        }
        if (pSAppMenuItem.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSAppMenuItem.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSAppMenuItem, (PSSysCss)iEntity);
        }
        if (pSAppMenuItem.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSAppMenuItem.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSAppMenuItem, (PSSysImage)iEntity);
        }
        if (pSAppMenuItem.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSAppMenuItem.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSAppMenuItem, (PSSysPFPlugin)iEntity);
        }
        if (pSAppMenuItem.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSAppMenuItem.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSAppMenuItem, (PSSysResource)iEntity);
        }
        if (pSAppMenuItem.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSAppMenuItem.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSAppMenuItem, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSAppMenuItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionLevel(bl, pSAppMenuItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AMItemType(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BL_Pos(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BorderStyle(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BtnActionType(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG_OS(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD_OS(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM_OS(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS_OS(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterMode(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CssId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DisableClose(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableMode(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Expand(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FillerObj(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexAlign(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexBasis(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexDir(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexGrow(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexShrink(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexVAlign(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HAlignSelf(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HiddenItem(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HIdeSideBar(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlContent(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlPageUrl(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InformTag(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InformTag2(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemStyle(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutMode(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelTag(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelValue(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MenuItemState(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenDefault(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenPSAppViewId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSAppMenuItemId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedTypeParam(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewHtml(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppFuncId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppLocalDEId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuItemId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuItemName(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssName(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageName(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawContent(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawCssStyle(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSAppMenuId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpanFlag(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitleBarCloseMode(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToggleMode(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VAlignSelf(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSAppMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSAppMenuItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionLevel(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isActionLevelDirty() : !pSAppMenuItem.isActionLevelDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getActionLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionLevel_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AMItemType(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isAMItemTypeDirty() && !bl2 : !pSAppMenuItem.isAMItemTypeDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getAMItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AMITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AMItemType_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AMITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BL_Pos(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isBL_PosDirty() : !pSAppMenuItem.isBL_PosDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getBL_Pos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BL_Pos_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BL_POS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BorderStyle(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isBorderStyleDirty() : !pSAppMenuItem.isBorderStyleDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getBorderStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BorderStyle_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BORDERSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BtnActionType(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isBtnActionTypeDirty() : !pSAppMenuItem.isBtnActionTypeDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getBtnActionType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BtnActionType_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BTNACTIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCapPSLanResIdDirty() : !pSAppMenuItem.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCapPSLanResNameDirty() : !pSAppMenuItem.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCaptionDirty() : !pSAppMenuItem.isCaptionDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_LG(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCol_LGDirty() : !pSAppMenuItem.isCol_LGDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getCol_LG();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_LG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_LG_OS(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCol_LG_OSDirty() : !pSAppMenuItem.isCol_LG_OSDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getCol_LG_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_OS_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_LG_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_MD(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCol_MDDirty() : !pSAppMenuItem.isCol_MDDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getCol_MD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_MD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_MD_OS(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCol_MD_OSDirty() : !pSAppMenuItem.isCol_MD_OSDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getCol_MD_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_OS_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_MD_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_SM(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCol_SMDirty() : !pSAppMenuItem.isCol_SMDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getCol_SM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_SM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_SM_OS(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCol_SM_OSDirty() : !pSAppMenuItem.isCol_SM_OSDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getCol_SM_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_OS_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_SM_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_XS(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCol_XSDirty() : !pSAppMenuItem.isCol_XSDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getCol_XS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_XS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_XS_OS(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCol_XS_OSDirty() : !pSAppMenuItem.isCol_XS_OSDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getCol_XS_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_OS_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_XS_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isContentTypeDirty() : !pSAppMenuItem.isContentTypeDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCounterIdDirty() : !pSAppMenuItem.isCounterIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CounterId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterMode(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCounterModeDirty() : !pSAppMenuItem.isCounterModeDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getCounterMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CounterMode_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CssId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCssIdDirty() : !pSAppMenuItem.isCssIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CssId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isCustomCodeDirty() : !pSAppMenuItem.isCustomCodeDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isDataDirty() : !pSAppMenuItem.isDataDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DisableClose(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isDisableCloseDirty() : !pSAppMenuItem.isDisableCloseDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getDisableClose();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DisableClose_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DISABLECLOSE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isDynaClassDirty() : !pSAppMenuItem.isDynaClassDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isDynaModelFlagDirty() : !pSAppMenuItem.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSAppMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableMode(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isEnableModeDirty() : !pSAppMenuItem.isEnableModeDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getEnableMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableMode_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Expand(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isExpandDirty() : !pSAppMenuItem.isExpandDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getExpand();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Expand_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPAND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FillerObj(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isFillerObjDirty() : !pSAppMenuItem.isFillerObjDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getFillerObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FillerObj_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILLEROBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexAlign(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isFlexAlignDirty() : !pSAppMenuItem.isFlexAlignDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getFlexAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexAlign_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexBasis(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isFlexBasisDirty() : !pSAppMenuItem.isFlexBasisDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getFlexBasis();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexBasis_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXBASIS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexDir(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isFlexDirDirty() : !pSAppMenuItem.isFlexDirDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getFlexDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexDir_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexGrow(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isFlexGrowDirty() : !pSAppMenuItem.isFlexGrowDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getFlexGrow();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexGrow_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXGROW");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexShrink(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isFlexShrinkDirty() : !pSAppMenuItem.isFlexShrinkDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getFlexShrink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexShrink_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXSHRINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexVAlign(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isFlexVAlignDirty() : !pSAppMenuItem.isFlexVAlignDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getFlexVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexVAlign_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXVALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HAlignSelf(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isHAlignSelfDirty() : !pSAppMenuItem.isHAlignSelfDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getHAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HAlignSelf_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HALIGNSELF");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isHeightDirty() : !pSAppMenuItem.isHeightDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HiddenItem(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isHiddenItemDirty() : !pSAppMenuItem.isHiddenItemDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getHiddenItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HiddenItem_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HIDDENITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HIdeSideBar(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isHIdeSideBarDirty() : !pSAppMenuItem.isHIdeSideBarDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getHIdeSideBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HIdeSideBar_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HIDESIDEBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HtmlContent(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isHtmlContentDirty() : !pSAppMenuItem.isHtmlContentDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getHtmlContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlContent_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTMLCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HtmlPageUrl(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isHtmlPageUrlDirty() : !pSAppMenuItem.isHtmlPageUrlDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getHtmlPageUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlPageUrl_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTMLPAGEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InformTag(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isInformTagDirty() : !pSAppMenuItem.isInformTagDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getInformTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InformTag_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INFORMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InformTag2(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isInformTag2Dirty() : !pSAppMenuItem.isInformTag2Dirty()) {
            return null;
        }
        String string = pSAppMenuItem.getInformTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InformTag2_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INFORMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemStyle(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isItemStyleDirty() : !pSAppMenuItem.isItemStyleDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getItemStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemStyle_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LayoutMode(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isLayoutModeDirty() : !pSAppMenuItem.isLayoutModeDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getLayoutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutMode_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelTag(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isLevelTagDirty() : !pSAppMenuItem.isLevelTagDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getLevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelTag_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelValue(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isLevelValueDirty() : !pSAppMenuItem.isLevelValueDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getLevelValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LevelValue_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isMemoDirty() : !pSAppMenuItem.isMemoDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSAppMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_MenuItemState(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isMenuItemStateDirty() : !pSAppMenuItem.isMenuItemStateDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getMenuItemState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MenuItemState_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MENUITEMSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenDefault(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isOpenDefaultDirty() : !pSAppMenuItem.isOpenDefaultDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getOpenDefault();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OpenDefault_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENDEFAULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenPSAppViewId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isOpenPSAppViewIdDirty() : !pSAppMenuItem.isOpenPSAppViewIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getOpenPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenPSAppViewId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENPSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isOrderValueDirty() : !pSAppMenuItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSAppMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSAppMenuItemId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPPSAppMenuItemIdDirty() : !pSAppMenuItem.isPPSAppMenuItemIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPPSAppMenuItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSAppMenuItemId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSAPPMENUITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPredefinedTypeDirty() : !pSAppMenuItem.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedTypeParam(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPredefinedTypeParamDirty() : !pSAppMenuItem.isPredefinedTypeParamDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPredefinedTypeParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedTypeParam_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewHtml(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPreviewHtmlDirty() : !pSAppMenuItem.isPreviewHtmlDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPreviewHtml();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewHtml_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWHTML");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppFuncId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSAppFuncIdDirty() : !pSAppMenuItem.isPSAppFuncIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSAppFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppFuncId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppLocalDEId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSAppLocalDEIdDirty() : !pSAppMenuItem.isPSAppLocalDEIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSAppLocalDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppLocalDEId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppMenuId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSAppMenuIdDirty() && !bl2 : !pSAppMenuItem.isPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSAppMenuId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppMenuItemId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSAppMenuItemIdDirty() && !bl2 : !pSAppMenuItem.isPSAppMenuItemIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSAppMenuItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuItemId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppMenuItemName(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSAppMenuItemNameDirty() && !bl2 : !pSAppMenuItem.isPSAppMenuItemNameDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSAppMenuItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuItemName_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUITEMNAME");
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
                string3 = "PSAPPMENUID";
                String string4 = this.checkFieldDupRule(this.getPSAppMenuItemDEModel(), "PSAPPMENUITEMNAME", string3, pSAppMenuItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPMENUITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSDELogicIdDirty() : !pSAppMenuItem.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSDEUIActionIdDirty() : !pSAppMenuItem.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSSysCssIdDirty() : !pSAppMenuItem.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssName(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSSysCssNameDirty() : !pSAppMenuItem.isPSSysCssNameDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSSysCssName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssName_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSSysImageIdDirty() : !pSAppMenuItem.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageName(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSSysImageNameDirty() : !pSAppMenuItem.isPSSysImageNameDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSSysImageName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageName_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSSysPFPluginIdDirty() : !pSAppMenuItem.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSSysResourceIdDirty() : !pSAppMenuItem.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default((IEntity)pSAppMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isPSSysUniResIdDirty() : !pSAppMenuItem.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawContent(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isRawContentDirty() : !pSAppMenuItem.isRawContentDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getRawContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawContent_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawCssStyle(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isRawCssStyleDirty() : !pSAppMenuItem.isRawCssStyleDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawCssStyle_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWCSSSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSAppMenuId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isRefPSAppMenuIdDirty() : !pSAppMenuItem.isRefPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getRefPSAppMenuId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSAppMenuId_RefPSAppMenu((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSAPPMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_RefPSAppMenuId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSAPPMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpanFlag(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isSpanFlagDirty() : !pSAppMenuItem.isSpanFlagDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getSpanFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SpanFlag_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPANFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isTemplateModeDirty() : !pSAppMenuItem.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLATEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isTipPSLanResIdDirty() : !pSAppMenuItem.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isTipPSLanResNameDirty() : !pSAppMenuItem.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitleBarCloseMode(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isTitleBarCloseModeDirty() : !pSAppMenuItem.isTitleBarCloseModeDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getTitleBarCloseMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TitleBarCloseMode_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEBARCLOSEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToggleMode(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isToggleModeDirty() : !pSAppMenuItem.isToggleModeDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getToggleMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToggleMode_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOGGLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isTooltipInfoDirty() : !pSAppMenuItem.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLTIPINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isUserParamsDirty() : !pSAppMenuItem.isUserParamsDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isUserTagDirty() : !pSAppMenuItem.isUserTagDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSAppMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isUserTag2Dirty() : !pSAppMenuItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppMenuItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSAppMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_VAlignSelf(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isVAlignSelfDirty() : !pSAppMenuItem.isVAlignSelfDirty()) {
            return null;
        }
        String string = pSAppMenuItem.getVAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VAlignSelf_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIGNSELF");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Width(boolean bl, PSAppMenuItem pSAppMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenuItem.isWidthDirty() : !pSAppMenuItem.isWidthDirty()) {
            return null;
        }
        Integer n = pSAppMenuItem.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default((IEntity)pSAppMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSAppMenuItem, bl);
    }

    protected void onSyncIndexEntities(PSAppMenuItem pSAppMenuItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSAppMenuItem, bl);
    }

    public Object getDataContextValue(PSAppMenuItem pSAppMenuItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSAppMenuItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSAppMenuItem pSAppMenuItem2 = pSAppMenuItem.getPPSAppMenuItem();
        if (pSAppMenuItem2 != null && pSAppMenuItem2.contains(string)) {
            return pSAppMenuItem2.get(string);
        }
        PSAppMenu pSAppMenu = pSAppMenuItem.getPSAppMenu();
        if (pSAppMenu != null && pSAppMenu.contains(string)) {
            return pSAppMenu.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppMenuItem pSAppMenuItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSAppMenuItem, arrayList, n);
        this.onExportMajorModel_TipPSLanRes(pSAppMenuItem, arrayList, n);
        super.onExportMajorModel((IEntity)pSAppMenuItem, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSAppMenuItem pSAppMenuItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSAppMenuItem.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSAppMenuItem.getCapPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_TipPSLanRes(PSAppMenuItem pSAppMenuItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSAppMenuItem.getTipPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSAppMenuItem.getTipPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AMITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AMItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BL_POS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BL_Pos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BORDERSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BorderStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BTNACTIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BtnActionType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_LG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_LG_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_LG_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_LG_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_MD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_MD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_MD_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_MD_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_SM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_SM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_SM_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_SM_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_XS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_XS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_XS_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_XS_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DISABLECLOSE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DisableClose_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPAND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Expand_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILLEROBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FillerObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXBASIS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexBasis_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXGROW", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexGrow_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXSHRINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexShrink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXVALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexVAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HALIGNSELF", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HAlignSelf_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIDDENITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HiddenItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIDESIDEBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HIdeSideBar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLPAGEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlPageUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INFORMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InformTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INFORMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InformTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMSTYLETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemStyleText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MENUITEMSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MenuItemState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENDEFAULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenDefault_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSAPPMENUITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSAppMenuItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSAPPMENUITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSAppMenuItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWHTML", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewHtml_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWCSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawCssStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"REFPSAPPMENU", (boolean)true) == 0) {
            return this.onTestValueRule_RefPSAppMenuId_RefPSAppMenu(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSAppMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSAPPMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSAppMenuName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPANFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpanFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplateMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEBARCLOSEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitleBarCloseMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOGGLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToggleMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIGNSELF", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VAlignSelf_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AMItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AMITEMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BL_Pos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BL_POS", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BorderStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BORDERSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BtnActionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BTNACTIONTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Col_LG_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_LG_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_MD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_MD_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_SM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_SM_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_XS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_XS_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COUNTERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CounterMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_CssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSID", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DisableClose_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Expand_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FillerObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILLEROBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexBasis_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXDIR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexGrow_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexShrink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexVAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXVALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HAlignSelf_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HALIGNSELF", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HiddenItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HIdeSideBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HtmlContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTMLCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HtmlPageUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTMLPAGEURL", iEntity, bl2, null, false, 300, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InformTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INFORMTAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InformTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INFORMTAG2", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemStyleText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMSTYLETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LayoutMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LevelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEVELTAG", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LevelValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MenuItemState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OpenDefault_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OpenPSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSAppMenuItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSAPPMENUITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSAppMenuItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSAPPMENUITEMNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedTypeParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPEPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedTypeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewHtml_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWHTML", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppLocalDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPLOCALDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppLocalDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPLOCALDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppMenuId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppMenuItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppMenuItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUITEMNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSAPPMENUITEMNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppMenuName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUniResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawCssStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWCSSSTYLE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSAppMenuId_RefPSAppMenu(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("REFPSAPPMENUID", "PSAPPMENU", "CurApp", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u83dc\u5355\u5f15\u7528\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSAppMenuId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSAPPMENUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSAppMenuName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSAPPMENUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpanFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TemplateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TipPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitleBarCloseMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ToggleMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOGGLEMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TooltipInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLTIPINFO", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_VAlignSelf_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALIGNSELF", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSAppMenuItem pSAppMenuItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSAppMenuItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppMenuItem pSAppMenuItem) throws Exception {
        super.onUpdateParent((IEntity)pSAppMenuItem);
    }

    @Override
    protected void exportCurXmlModel(PSAppMenuItem pSAppMenuItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPMENUITEM");
        if (!bl) {
            pSAppMenuItem.setCreateDate(null);
            pSAppMenuItem.setCreateMan(null);
            pSAppMenuItem.setLevelTag(null);
            pSAppMenuItem.setLevelValue(null);
            pSAppMenuItem.setPSAppMenuItemId(null);
            pSAppMenuItem.setPSSysAppId(null);
            pSAppMenuItem.setUpdateDate(null);
            pSAppMenuItem.setUpdateMan(null);
            pSAppMenuItem.setPPSAppMenuItemId(null);
            pSAppMenuItem.setPSAppMenuId(null);
            pSAppMenuItem.setPSAppMenuName(null);
            pSAppMenuItem.setPSSysAppId(null);
            super.exportCurXmlModel(pSAppMenuItem, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSAppMenuItem pSAppMenuItem, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSAppMenuItem(pSAppMenuItem, xmlNode);
        super.onExportRelatedXmlModel(pSAppMenuItem, xmlNode);
    }

    protected void exportRelatedXmlModel_PSAppMenuItem(PSAppMenuItem pSAppMenuItem, XmlNode xmlNode) throws Exception {
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuItem> arrayList = null;
        String string = pSAppMenuItem.getPSAppMenuItemId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppMenuItemService.selectByPPSAppMenuItem(pSAppMenuItem, "ORDER BY ORDERVALUE ASC") : pSAppMenuItemService.selectTempByPPSAppMenuItem(pSAppMenuItem, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSAPPMENUITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSAppMenuItem pSAppMenuItem2 : arrayList) {
                pSAppMenuItem2.set("ORDERVALUE", null);
                pSAppMenuItemService.exportXmlModel(pSAppMenuItem2, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSAppMenuItem pSAppMenuItem, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSAPPMENUITEMS");
        this.importRelatedXmlModel_PSAppMenuItem(pSAppMenuItem, xmlNode2);
        super.onImportRelatedXmlModel(pSAppMenuItem, xmlNode);
    }

    protected void importRelatedXmlModel_PSAppMenuItem(PSAppMenuItem pSAppMenuItem, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSAppMenuItem.getPSAppMenuItemId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSAppMenuItemService.removeByPPSAppMenuItem(pSAppMenuItem);
        } else {
            pSAppMenuItemService.removeTempByPPSAppMenuItem(pSAppMenuItem);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSAppMenuItem pSAppMenuItem2 = new PSAppMenuItem();
                pSAppMenuItem2.setOrderValue(n);
                n += 100;
                pSAppMenuItemService.fillParentInfo((IEntity)pSAppMenuItem2, "DER1N", "DER1N_PSAPPMENUITEM_PSAPPMENUITEM_PPSAPPMENUITEMID", pSAppMenuItem.getPSAppMenuItemId());
                pSAppMenuItemService.importXmlModel(pSAppMenuItem2, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppMenuItem pSAppMenuItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppMenuItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSAPPMENUITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPMENUITEM#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMENUID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPMENU#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSAPPMENUITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPMENUITEM_PSAPPMENUITEM_PPSAPPMENUITEMID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMENUID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPMENUITEM_PSAPPMENU_PSAPPMENUID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSAPPMENUITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSAPPMENUITEMNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMENUID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMENUNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSAPPMENUITEM", (boolean)true) == 0) {
            iEntity.set("PPSAPPMENUITEMID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENU", (boolean)true) == 0) {
            iEntity.set("PSAPPMENUID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSAPPMENUITEMID", "PSAPPMENUID"};
    }

    @Override
    public String getModelV2Tag(PSAppMenuItem pSAppMenuItem) {
        if (!StringHelper.isNullOrEmpty((String)pSAppMenuItem.getPSAppMenuItemName())) {
            return pSAppMenuItem.getPSAppMenuItemName();
        }
        return super.getModelV2Tag(pSAppMenuItem);
    }

    @Override
    public boolean setModelV2Tag(PSAppMenuItem pSAppMenuItem, String string) {
        pSAppMenuItem.setPSAppMenuItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSAPPMENUITEMNAME", "");
        map.put("PPSAPPMENUITEMID", "");
        map.put("PSAPPMENUID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppMenuItem pSAppMenuItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppMenuItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppMenuItem, true);
        pSAppMenuItem.set("PSAPPMENUITEMNAME", string);
        if (this.select(pSAppMenuItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppMenuItem, true);
        return super.getModelV2Entity(pSAppMenuItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppMenuItem pSAppMenuItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSAppMenuItem.getPPSAppMenuItemId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSAppMenuItem.getPSAppMenuId())) {
            bl = true;
        } else if (bl && !objectNode.has("psappmenuid")) {
            objectNode.put("psappmenuid", "<PSAPPMENU>");
        }
        return super.testCompileCurModelV2(pSAppMenuItem, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSAppMenuItem pSAppMenuItem, String string, Map<String, String> map) throws Exception {
        if (PSAppMenuItemServiceBase.isSimpleImportExportMode()) {
            map.put("PPSAPPMENUITEMID", "");
            map.put("PSAPPMENUID", "");
        }
        return super.onFillModelV2(objectNode, pSAppMenuItem, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSAPPMENUITEM_PSAPPMENUITEM_PPSAPPMENUITEMID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSAppMenuItem pSAppMenuItem, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSAppMenuItem, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSAppMenuItem pSAppMenuItem, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPMENUITEM_PSAPPMENUITEM_PPSAPPMENUITEMID")) {
            Object object;
            PSAppMenuItem pSAppMenuItem22;
            Object object2;
            Object object3;
            Object object4;
            PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSAppMenuItem> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMENUITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPMENUITEM", (Object)pSAppMenuItem.getPSAppMenuItemId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSAppMenuItem22 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSAppMenuItem22);
                    }
                }
            } else {
                arrayList = new ArrayList<PSAppMenuItem>();
                object4 = pSAppMenuItemService.selectByPPSAppMenuItem(pSAppMenuItem);
                object3 = StringHelper.format((String)"PSAPPMENUITEM#%1$s", (Object)pSAppMenuItem.getPSAppMenuItemId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSAppMenuItem22 = object2.next();
                    object = pSAppMenuItemService.getModelV2ResScope((IEntity)pSAppMenuItem22);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppMenuItem)PSModelV2Helper.toJSONObject((IEntity)pSAppMenuItem22, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSAppMenuItemService.getModelV2Name(false);
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
                        if (objectNode.has("psappmenuitemname")) {
                            string = objectNode.get("psappmenuitemname").asText();
                        }
                        if (objectNode2.has("psappmenuitemname")) {
                            string2 = objectNode2.get("psappmenuitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSAppMenuItem pSAppMenuItem22 : arrayList) {
                    object = new PSAppMenuItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSAppMenuItem22, false);
                    ((PSAppMenuItemBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSAppMenuItemService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSAppMenuItem, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSAppMenuItem pSAppMenuItem) throws Exception {
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuItem> arrayList = pSAppMenuItemService.selectByPPSAppMenuItem(pSAppMenuItem);
        String string = StringHelper.format((String)"PSAPPMENUITEM#%1$s", (Object)pSAppMenuItem.getPSAppMenuItemId());
        for (PSAppMenuItem pSAppMenuItem2 : arrayList) {
            String string2 = pSAppMenuItemService.getModelV2ResScope((IEntity)pSAppMenuItem2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSAppMenuItemService.emptyModelV2(pSAppMenuItem2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSAppMenuItem.getPSAppMenuItemId());
        pSAppMenuItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSAppMenuItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSAPPMENUITEM WHERE PPSAPPMENUITEMID = ?", sqlParamList);
        super.onEmptyModelV2(pSAppMenuItem);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSAppMenuItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSAppMenuItem pSAppMenuItem, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSAppMenuItem pSAppMenuItem2 = new PSAppMenuItem();
        pSAppMenuItem2.set("PPSAPPMENUITEMID", pSAppMenuItem.getPSAppMenuItemId());
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSAppMenuItemService.getModelV2Entity(pSAppMenuItem2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSAppMenuItem, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSAppMenuItem pSAppMenuItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSAppMenuItemService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSAppMenuItem pSAppMenuItem2 = new PSAppMenuItem();
                pSAppMenuItem2.setPPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
                pSAppMenuItem2.setPPSAppMenuItemName(pSAppMenuItem.getPSAppMenuItemName());
                pSAppMenuItem2.setOrderValue(n2 += 10);
                pSAppMenuItemService.compileModelV2(pSAppMenuItem2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSAppMenuItem pSAppMenuItem3 = new PSAppMenuItem();
                    pSAppMenuItem3.setPPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
                    pSAppMenuItem3.setPPSAppMenuItemName(pSAppMenuItem.getPSAppMenuItemName());
                    pSAppMenuItemService.compileModelV2(pSAppMenuItem3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSAppMenuItem, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSAppMenuItem pSAppMenuItem, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPMENUITEM_PSAPPMENUITEM_PPSAPPMENUITEMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppMenuItems(pSAppMenuItem, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSAppMenuItem, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSAppMenuItems(PSAppMenuItem pSAppMenuItem, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPMENUITEM", true), (boolean)false) == 0) {
            PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
            PSAppMenuItem pSAppMenuItem2 = new PSAppMenuItem();
            pSAppMenuItem2.setPSAppMenuItemId(pSMOSFile.getPSModelId());
            if (!pSAppMenuItemService.get((IEntity)pSAppMenuItem2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppMenuItem2.getPPSAppMenuItemId(), (String)pSAppMenuItem.getPSAppMenuItemId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppMenuItemService.exportModelV2(pSAppMenuItem2);
            pSAppMenuItem2.reset();
            if (!pSAppMenuItemService.setModelV2ResScope((IEntity)pSAppMenuItem2, "PSAPPMENUITEM", pSAppMenuItem.getPSAppMenuItemId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppMenuItemService.importModelV2(pSAppMenuItem2, objectNode);
            SessionFactoryManager.commit();
            return pSAppMenuItemService.getFile((IEntity)pSAppMenuItem2);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSAppMenuItem pSAppMenuItem, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSAppMenuItems(pSAppMenuItem, list);
        super.onFillPasteHelps(pSAppMenuItem, list);
    }

    protected void onFillPasteHelps_PSAppMenuItems(PSAppMenuItem pSAppMenuItem, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPMENUITEM");
        pSHelpSection.setSectionParam2("DER1N_PSAPPMENUITEM_PSAPPMENUITEM_PPSAPPMENUITEMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u83dc\u5355\u9879]\u7684[\u5e94\u7528\u83dc\u5355\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSAppMenuItem pSAppMenuItem) throws Exception {
        return pSAppMenuItem.getAMItemType();
    }
}

