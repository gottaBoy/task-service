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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDETBItemDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETBItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTViewBase;
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

public abstract class PSDETBItemServiceBase
extends PSCoreSysServiceBase<PSDETBItem> {
    private static final Log log = LogFactory.getLog(PSDETBItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATETEMPWITHPREVIEW = "CreateTempWithPreview";
    public static final String ACTION_GETTEMPWITHPREVIEW = "GetTempWithPreview";
    public static final String ACTION_UPDATETEMPWITHPREVIEW = "UpdateTempWithPreview";
    private PSDETBItemDEModel pSDETBItemDEModel;
    private PSDETBItemDAO pSDETBItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService";
    }

    public PSDETBItemDEModel getPSDETBItemDEModel() {
        if (this.pSDETBItemDEModel == null) {
            try {
                this.pSDETBItemDEModel = (PSDETBItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETBItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETBItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDETBItemDEModel();
    }

    public PSDETBItemDAO getPSDETBItemDAO() {
        if (this.pSDETBItemDAO == null) {
            try {
                this.pSDETBItemDAO = (PSDETBItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDETBItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETBItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDETBItemDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_CREATETEMPWITHPREVIEW, (boolean)true) == 0) {
            this.createTempWithPreview((PSDETBItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETTEMPWITHPREVIEW, (boolean)true) == 0) {
            this.getTempWithPreview((PSDETBItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATETEMPWITHPREVIEW, (boolean)true) == 0) {
            this.updateTempWithPreview((PSDETBItem)iEntity);
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

    public void createTempWithPreview(PSDETBItem pSDETBItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATETEMPWITHPREVIEW, 0, pSDETBItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDETBItem, ACTION_CREATETEMPWITHPREVIEW);
        final PSDETBItem pSDETBItem2 = pSDETBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDETBItemServiceBase.this.getService(), PSDETBItemServiceBase.ACTION_CREATETEMPWITHPREVIEW, 40, pSDETBItem2, null).getResult() != 1) {
                    PSDETBItemServiceBase.this.onCreateTempWithPreview(pSDETBItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATETEMPWITHPREVIEW, 99, pSDETBItem, null);
        }
    }

    protected void onCreateTempWithPreview(PSDETBItem pSDETBItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateTempWithPreview]");
    }

    public void getTempWithPreview(PSDETBItem pSDETBItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETTEMPWITHPREVIEW, 0, pSDETBItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDETBItem, ACTION_GETTEMPWITHPREVIEW);
        final PSDETBItem pSDETBItem2 = pSDETBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDETBItemServiceBase.this.getService(), PSDETBItemServiceBase.ACTION_GETTEMPWITHPREVIEW, 40, pSDETBItem2, null).getResult() != 1) {
                    PSDETBItemServiceBase.this.onGetTempWithPreview(pSDETBItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETTEMPWITHPREVIEW, 99, pSDETBItem, null);
        }
    }

    protected void onGetTempWithPreview(PSDETBItem pSDETBItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetTempWithPreview]");
    }

    public void updateTempWithPreview(PSDETBItem pSDETBItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATETEMPWITHPREVIEW, 0, pSDETBItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDETBItem, ACTION_UPDATETEMPWITHPREVIEW);
        final PSDETBItem pSDETBItem2 = pSDETBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDETBItemServiceBase.this.getService(), PSDETBItemServiceBase.ACTION_UPDATETEMPWITHPREVIEW, 40, pSDETBItem2, null).getResult() != 1) {
                    PSDETBItemServiceBase.this.onUpdateTempWithPreview(pSDETBItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATETEMPWITHPREVIEW, 99, pSDETBItem, null);
        }
    }

    protected void onUpdateTempWithPreview(PSDETBItem pSDETBItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateTempWithPreview]");
    }

    protected void onFillParentInfo(PSDETBItem pSDETBItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSAPPVIEW_OPENPSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppView);
            } else {
                iService.get(pSAppView);
            }
            this.onFillParentInfo_OpenPSAppView(pSDETBItem, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDETBItem, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSDETBITEM_PPSDETBITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService", (SessionFactory)this.getSessionFactory());
            PSDETBItem pSDETBItem2 = (PSDETBItem)iService.getDEModel().createEntity();
            pSDETBItem2.set("PSDETBITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETBItem2);
            } else {
                iService.get(pSDETBItem2);
            }
            this.onFillParentInfo_PPSDETBItem(pSDETBItem, pSDETBItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_PSDEToolbar(pSDETBItem, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDETBItem, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDETBItem, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSDEVIEWBASE_OPENPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_OpenPSDEView(pSDETBItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDETBItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSDETBItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDETBItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDETBItem, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSSYSPDTVIEW_OPENPSSYSPDTVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService", (SessionFactory)this.getSessionFactory());
            PSSysPDTView pSSysPDTView = (PSSysPDTView)iService.getDEModel().createEntity();
            pSSysPDTView.set("PSSYSPDTVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPDTView);
            } else {
                iService.get(pSSysPDTView);
            }
            this.onFillParentInfo_OpenPSSysPDTView(pSDETBItem, pSSysPDTView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDETBItem, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysResource);
            } else {
                iService.get(pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSDETBItem, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETBITEM_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSDETBItem, pSSysUniRes);
            return;
        }
        super.onFillParentInfo(pSDETBItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDETBITEM_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", string2);
            return this.onSyncDER1NData_PSDEToolbar(pSDEToolbar, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_OpenPSAppView(PSDETBItem pSDETBItem, PSAppView pSAppView) throws Exception {
        pSDETBItem.setOpenPSAppViewId(pSAppView.getPSAppViewId());
        pSDETBItem.setOpenPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_PSDELogic(PSDETBItem pSDETBItem, PSDELogic pSDELogic) throws Exception {
        pSDETBItem.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDETBItem.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PPSDETBItem(PSDETBItem pSDETBItem, PSDETBItem pSDETBItem2) throws Exception {
        pSDETBItem.setPPSDETBItemId(pSDETBItem2.getPSDETBItemId());
        pSDETBItem.setPPSDETBItemName(pSDETBItem2.getPSDETBItemName());
        if (pSDETBItem2.getPSDEToolbar() != null) {
            this.onFillParentInfo_PSDEToolbar(pSDETBItem, pSDETBItem2.getPSDEToolbar());
        }
    }

    protected void onFillParentInfo_PSDEToolbar(PSDETBItem pSDETBItem, PSDEToolbar pSDEToolbar) throws Exception {
        pSDETBItem.setPSDEId(pSDEToolbar.getPSDEId());
        pSDETBItem.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDETBItem.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
        pSDETBItem.setPSSystemId(pSDEToolbar.getPSSystemId());
    }

    protected String onSyncDER1NData_PSDEToolbar(PSDEToolbar pSDEToolbar, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEToolbar(pSDEToolbar);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDETBItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
            for (PSDETBItem pSDETBItem : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDETBItem, (String)"PSDETBITEMID", (String)""))) continue;
                this.remove(pSDETBItem);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDETBItem pSDETBItem, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDETBItem.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDETBItem.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSDETBItem pSDETBItem, PSDEUIAction pSDEUIAction) throws Exception {
        pSDETBItem.setDEUACap(pSDEUIAction.getCaption());
        pSDETBItem.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDETBItem.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_OpenPSDEView(PSDETBItem pSDETBItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSDETBItem.setOpenPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDETBItem.setOpenPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDETBItem pSDETBItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSDETBItem.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDETBItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSDETBItem pSDETBItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSDETBItem.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDETBItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSDETBItem pSDETBItem, PSSysCss pSSysCss) throws Exception {
        pSDETBItem.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDETBItem.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSDETBItem pSDETBItem, PSSysImage pSSysImage) throws Exception {
        pSDETBItem.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDETBItem.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_OpenPSSysPDTView(PSDETBItem pSDETBItem, PSSysPDTView pSSysPDTView) throws Exception {
        pSDETBItem.setOpenPSSysPDTViewId(pSSysPDTView.getPSSysPDTViewId());
        pSDETBItem.setOpenPSSysPDTViewName(pSSysPDTView.getPSSysPDTViewName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDETBItem pSDETBItem, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDETBItem.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDETBItem.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysResource(PSDETBItem pSDETBItem, PSSysResource pSSysResource) throws Exception {
        pSDETBItem.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSDETBItem.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSDETBItem pSDETBItem, PSSysUniRes pSSysUniRes) throws Exception {
        pSDETBItem.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSDETBItem.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillEntityFullInfo(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        if (bl) {
            if (pSDETBItem.getHiddenItem() == null) {
                pSDETBItem.setHiddenItem((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDETBItem.getSpanFlag() == null) {
                pSDETBItem.setSpanFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSDETBItem, bl);
        this.onFillEntityFullInfo_OpenPSAppView(pSDETBItem, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDETBItem, bl);
        this.onFillEntityFullInfo_PPSDETBItem(pSDETBItem, bl);
        this.onFillEntityFullInfo_PSDEToolbar(pSDETBItem, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDETBItem, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDETBItem, bl);
        this.onFillEntityFullInfo_OpenPSDEView(pSDETBItem, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDETBItem, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSDETBItem, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDETBItem, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDETBItem, bl);
        this.onFillEntityFullInfo_OpenPSSysPDTView(pSDETBItem, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDETBItem, bl);
        this.onFillEntityFullInfo_PSSysResource(pSDETBItem, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSDETBItem, bl);
    }

    protected void onFillEntityFullInfo_OpenPSAppView(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSDETBItem(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEToolbar(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        if (pSDETBItem.isPSDEUAGroupIdDirty()) {
            if (pSDETBItem.getPSDEUAGroupId() != null) {
                if (pSDETBItem.getPSDEUAGroupId() == null || pSDETBItem.getPSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDETBItem.getPSDEUAGroup();
                    pSDETBItem.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDETBItem.setPSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OpenPSDEView(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        if (pSDETBItem.isCapPSLanResIdDirty()) {
            if (pSDETBItem.getCapPSLanResId() != null) {
                if (pSDETBItem.getCapPSLanResId() == null || pSDETBItem.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDETBItem.getCapPSLanRes();
                    pSDETBItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDETBItem.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        if (pSDETBItem.isTipPSLanResIdDirty()) {
            if (pSDETBItem.getTipPSLanResId() != null) {
                if (pSDETBItem.getTipPSLanResId() == null || pSDETBItem.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDETBItem.getTipPSLanRes();
                    pSDETBItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDETBItem.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        if (pSDETBItem.isPSSysCssIdDirty()) {
            if (pSDETBItem.getPSSysCssId() != null) {
                if (pSDETBItem.getPSSysCssId() == null || pSDETBItem.getPSSysCssName() == null) {
                    PSSysCss pSSysCss = pSDETBItem.getPSSysCss();
                    pSDETBItem.setPSSysCssName(pSSysCss.getPSSysCssName());
                }
            } else {
                pSDETBItem.setPSSysCssName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        if (pSDETBItem.isPSSysImageIdDirty()) {
            if (pSDETBItem.getPSSysImageId() != null) {
                if (pSDETBItem.getPSSysImageId() == null || pSDETBItem.getPSSysImageName() == null) {
                    PSSysImage pSSysImage = pSDETBItem.getPSSysImage();
                    pSDETBItem.setPSSysImageName(pSSysImage.getPSSysImageName());
                }
            } else {
                pSDETBItem.setPSSysImageName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OpenPSSysPDTView(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSDETBItem pSDETBItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSDETBItem, bl);
    }

    public ArrayList<PSDETBItem> selectByOpenPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByOpenPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByOpenPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByOpenPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByOpenPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETBItem> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETBItem> selectByPPSDETBItem(PSDETBItemBase pSDETBItemBase) throws Exception {
        return this.selectByPPSDETBItem(pSDETBItemBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPPSDETBItem(PSDETBItemBase pSDETBItemBase, String string) throws Exception {
        return this.selectByPPSDETBItem(pSDETBItemBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPPSDETBItem(PSDETBItemBase pSDETBItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDETBITEMID", (Object)pSDETBItemBase.getPSDETBItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDETBItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDETBItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETBItem> selectTempByPPSDETBItem(PSDETBItemBase pSDETBItemBase) throws Exception {
        return this.selectTempByPPSDETBItem(pSDETBItemBase, "");
    }

    public ArrayList<PSDETBItem> selectTempByPPSDETBItem(PSDETBItemBase pSDETBItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDETBITEMID", (Object)pSDETBItemBase.getPSDETBItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSDETBItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSDETBItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETBItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETBItem> selectTempByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectTempByPSDEToolbar(pSDEToolbarBase, "");
    }

    public ArrayList<PSDETBItem> selectTempByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEToolbarCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETBItem> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETBItem> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETBItem> selectByOpenPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByOpenPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByOpenPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByOpenPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByOpenPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPENPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOpenPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOpenPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETBItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETBItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETBItem> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETBItem> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETBItem> selectByOpenPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase) throws Exception {
        return this.selectByOpenPSSysPDTView(pSSysPDTViewBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByOpenPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string) throws Exception {
        return this.selectByOpenPSSysPDTView(pSSysPDTViewBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByOpenPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPENPSSYSPDTVIEWID", (Object)pSSysPDTViewBase.getPSSysPDTViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOpenPSSysPDTViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOpenPSSysPDTViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETBItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETBItem> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETBItem> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSDETBItem> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
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

    public void testRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByOpenPSAppView(pSAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSAPPVIEW_OPENPSAPPVIEWID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSAppView), arrayList.get(0)));
        }
    }

    public void resetOpenPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByOpenPSAppView(pSAppView);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setOpenPSAppViewId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByOpenPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByOpenPSAppView(pSAppView2);
                PSDETBItemServiceBase.this.internalRemoveByOpenPSAppView(pSAppView2);
                PSDETBItemServiceBase.this.onAfterRemoveByOpenPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByOpenPSAppView(pSAppView);
        this.onBeforeRemoveByOpenPSAppView(pSAppView, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByOpenPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByOpenPSAppView(PSAppView pSAppView, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOpenPSAppView(PSAppView pSAppView, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSDELogicId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDETBItemServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDETBItemServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
    }

    public void resetPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPPSDETBItem(pSDETBItem);
        for (PSDETBItem pSDETBItem2 : arrayList) {
            PSDETBItem pSDETBItem3 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem3.setPSDETBItemId(pSDETBItem2.getPSDETBItemId());
            pSDETBItem3.setPPSDETBItemId(null);
            this.update(pSDETBItem3);
        }
    }

    public void resetTempPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectTempByPPSDETBItem(pSDETBItem);
        for (PSDETBItem pSDETBItem2 : arrayList) {
            PSDETBItem pSDETBItem3 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem3.setPSDETBItemId(pSDETBItem2.getPSDETBItemId());
            pSDETBItem3.setPPSDETBItemId(null);
            this.updateTemp(pSDETBItem3);
        }
    }

    public void removeByPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        final PSDETBItem pSDETBItem2 = pSDETBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPPSDETBItem(pSDETBItem2);
                PSDETBItemServiceBase.this.internalRemoveByPPSDETBItem(pSDETBItem2);
                PSDETBItemServiceBase.this.onAfterRemoveByPPSDETBItem(pSDETBItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
    }

    protected void internalRemoveByPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPPSDETBItem(pSDETBItem);
        this.onBeforeRemoveByPPSDETBItem(pSDETBItem, arrayList);
        for (PSDETBItem pSDETBItem2 : arrayList) {
            this.remove(pSDETBItem2);
        }
        this.onAfterRemoveByPPSDETBItem(pSDETBItem, arrayList);
    }

    protected void onAfterRemoveByPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSDETBItem(PSDETBItem pSDETBItem, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDETBItem(PSDETBItem pSDETBItem, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    public void resetPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSDEToolbarId(null);
            this.update(pSDETBItem2);
        }
    }

    public void resetTempPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectTempByPSDEToolbar(pSDEToolbar);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSDEToolbarId(null);
            this.updateTemp(pSDETBItem2);
        }
    }

    public void removeByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPSDEToolbar(pSDEToolbar2);
                PSDETBItemServiceBase.this.internalRemoveByPSDEToolbar(pSDEToolbar2);
                PSDETBItemServiceBase.this.onAfterRemoveByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSDEUAGroupId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDETBItemServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDETBItemServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSDEUIActionId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDETBItemServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDETBItemServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByOpenPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSDEVIEWBASE_OPENPSDEVIEWID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByOpenPSDEView(pSDEViewBase);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setOpenPSDEViewId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByOpenPSDEView(pSDEViewBase2);
                PSDETBItemServiceBase.this.internalRemoveByOpenPSDEView(pSDEViewBase2);
                PSDETBItemServiceBase.this.onAfterRemoveByOpenPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByOpenPSDEView(pSDEViewBase);
        this.onBeforeRemoveByOpenPSDEView(pSDEViewBase, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByOpenPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setCapPSLanResId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDETBItemServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDETBItemServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setTipPSLanResId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSDETBItemServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSDETBItemServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSSysCssId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDETBItemServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDETBItemServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSSysImageId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDETBItemServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDETBItemServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByOpenPSSysPDTView(pSSysPDTView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPDTVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPDTView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSSYSPDTVIEW_OPENPSSYSPDTVIEWID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSSysPDTView), arrayList.get(0)));
        }
    }

    public void resetOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByOpenPSSysPDTView(pSSysPDTView);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setOpenPSSysPDTViewId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        final PSSysPDTView pSSysPDTView2 = pSSysPDTView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByOpenPSSysPDTView(pSSysPDTView2);
                PSDETBItemServiceBase.this.internalRemoveByOpenPSSysPDTView(pSSysPDTView2);
                PSDETBItemServiceBase.this.onAfterRemoveByOpenPSSysPDTView(pSSysPDTView2);
            }
        });
    }

    protected void onBeforeRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void internalRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByOpenPSSysPDTView(pSSysPDTView);
        this.onBeforeRemoveByOpenPSSysPDTView(pSSysPDTView, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByOpenPSSysPDTView(pSSysPDTView, arrayList);
    }

    protected void onAfterRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void onBeforeRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSSysPFPluginId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDETBItemServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDETBItemServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSSysResourceId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSDETBItemServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSDETBItemServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETBITEM_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSDETBITEM", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSDETBItem pSDETBItem : arrayList) {
            PSDETBItem pSDETBItem2 = (PSDETBItem)this.getDEModel().createEntity();
            pSDETBItem2.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
            pSDETBItem2.setPSSysUniResId(null);
            this.update(pSDETBItem2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSDETBItemServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSDETBItemServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.remove(pSDETBItem);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDETBItem pSDETBItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).testRemoveByPPSDETBItem(pSDETBItem);
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).removeByPPSDETBItem(pSDETBItem);
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDETBItem(pSDETBItem);
        super.onBeforeRemove(pSDETBItem);
    }

    protected void onBeforeRemoveTemp(PSDETBItem pSDETBItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).resetTempPSDETBItem(pSDETBItem);
        pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).resetTempPPSDETBItem(pSDETBItem);
        super.onBeforeRemoveTemp(pSDETBItem);
    }

    public void removeTempByPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        final PSDETBItem pSDETBItem2 = pSDETBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveTempByPPSDETBItem(pSDETBItem2);
                PSDETBItemServiceBase.this.internalRemoveTempByPPSDETBItem(pSDETBItem2);
                PSDETBItemServiceBase.this.onAfterRemoveTempByPPSDETBItem(pSDETBItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
    }

    protected void internalRemoveTempByPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectTempByPPSDETBItem(pSDETBItem);
        this.onBeforeRemoveTempByPPSDETBItem(pSDETBItem, arrayList);
        for (PSDETBItem pSDETBItem2 : arrayList) {
            this.removeTemp(pSDETBItem2);
        }
        this.onAfterRemoveTempByPPSDETBItem(pSDETBItem, arrayList);
    }

    protected void onAfterRemoveTempByPPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSDETBItem(PSDETBItem pSDETBItem, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSDETBItem(PSDETBItem pSDETBItem, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    public void removeTempByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItemServiceBase.this.onBeforeRemoveTempByPSDEToolbar(pSDEToolbar2);
                PSDETBItemServiceBase.this.internalRemoveTempByPSDEToolbar(pSDEToolbar2);
                PSDETBItemServiceBase.this.onAfterRemoveTempByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDETBItem> arrayList = this.selectTempByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveTempByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDETBItem pSDETBItem : arrayList) {
            this.removeTemp(pSDETBItem);
        }
        this.onAfterRemoveTempByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDETBItem> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDETBItem pSDETBItem) throws Exception {
        super.getRelatedDataTempMajor(pSDETBItem);
    }

    protected void updateRelatedDataTempMajor(PSDETBItem pSDETBItem, PSDETBItem pSDETBItem2) throws Exception {
        super.updateRelatedDataTempMajor(pSDETBItem, pSDETBItem2);
    }

    protected void replaceParentInfo(PSDETBItem pSDETBItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDETBItem, cloneSession);
        if (pSDETBItem.getOpenPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSDETBItem.getOpenPSAppViewId())) != null) {
            this.onFillParentInfo_OpenPSAppView(pSDETBItem, (PSAppView)iEntity);
        }
        if (pSDETBItem.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDETBItem.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDETBItem, (PSDELogic)iEntity);
        }
        if (pSDETBItem.getPPSDETBItemId() != null && (iEntity = cloneSession.getEntity("PSDETBITEM", (Object)pSDETBItem.getPPSDETBItemId())) != null) {
            this.onFillParentInfo_PPSDETBItem(pSDETBItem, (PSDETBItem)iEntity);
        }
        if (pSDETBItem.getPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDETBItem.getPSDEToolbarId())) != null) {
            this.onFillParentInfo_PSDEToolbar(pSDETBItem, (PSDEToolbar)iEntity);
        }
        if (pSDETBItem.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDETBItem.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDETBItem, (PSDEUAGroup)iEntity);
        }
        if (pSDETBItem.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDETBItem.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDETBItem, (PSDEUIAction)iEntity);
        }
        if (pSDETBItem.getOpenPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDETBItem.getOpenPSDEViewId())) != null) {
            this.onFillParentInfo_OpenPSDEView(pSDETBItem, (PSDEViewBase)iEntity);
        }
        if (pSDETBItem.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDETBItem.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDETBItem, (PSLanguageRes)iEntity);
        }
        if (pSDETBItem.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDETBItem.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSDETBItem, (PSLanguageRes)iEntity);
        }
        if (pSDETBItem.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDETBItem.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDETBItem, (PSSysCss)iEntity);
        }
        if (pSDETBItem.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDETBItem.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDETBItem, (PSSysImage)iEntity);
        }
        if (pSDETBItem.getOpenPSSysPDTViewId() != null && (iEntity = cloneSession.getEntity("PSSYSPDTVIEW", (Object)pSDETBItem.getOpenPSSysPDTViewId())) != null) {
            this.onFillParentInfo_OpenPSSysPDTView(pSDETBItem, (PSSysPDTView)iEntity);
        }
        if (pSDETBItem.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDETBItem.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDETBItem, (PSSysPFPlugin)iEntity);
        }
        if (pSDETBItem.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSDETBItem.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSDETBItem, (PSSysResource)iEntity);
        }
        if (pSDETBItem.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSDETBItem.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSDETBItem, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDETBItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionLevel(bl, pSDETBItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BorderStyle(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BtnActionType(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterMode(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CssId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLogic(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupExtractMode(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HiddenItem(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlContent(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlPageUrl(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemStyle(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelTag(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelValue(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoPrivDM(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenPSAppViewId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenPSDEViewId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenPSSysPDTViewId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDETBItemId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewHtml(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETBItemId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETBItemName(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupName(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssName(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageName(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawContent(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawCssStyle(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowMode(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpanFlag(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TBItemType(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToggleMode(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParams(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VisibleLogic(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSDETBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDETBItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionLevel(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isActionLevelDirty() : !pSDETBItem.isActionLevelDirty()) {
            return null;
        }
        Integer n = pSDETBItem.getActionLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionLevel_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_BorderStyle(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isBorderStyleDirty() : !pSDETBItem.isBorderStyleDirty()) {
            return null;
        }
        String string = pSDETBItem.getBorderStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BorderStyle_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_BtnActionType(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isBtnActionTypeDirty() : !pSDETBItem.isBtnActionTypeDirty()) {
            return null;
        }
        String string = pSDETBItem.getBtnActionType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BtnActionType_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isCapPSLanResIdDirty() : !pSDETBItem.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isCapPSLanResNameDirty() : !pSDETBItem.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDETBItem.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isCaptionDirty() : !pSDETBItem.isCaptionDirty()) {
            return null;
        }
        String string = pSDETBItem.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isCodeNameDirty() : !pSDETBItem.isCodeNameDirty()) {
            return null;
        }
        String string = pSDETBItem.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isContentTypeDirty() : !pSDETBItem.isContentTypeDirty()) {
            return null;
        }
        String string = pSDETBItem.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CounterId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isCounterIdDirty() : !pSDETBItem.isCounterIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CounterId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CounterMode(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isCounterModeDirty() : !pSDETBItem.isCounterModeDirty()) {
            return null;
        }
        Integer n = pSDETBItem.getCounterMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CounterMode_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CssId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isCssIdDirty() : !pSDETBItem.isCssIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CssId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isCustomCodeDirty() : !pSDETBItem.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDETBItem.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Data(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isDataDirty() : !pSDETBItem.isDataDirty()) {
            return null;
        }
        String string = pSDETBItem.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isDefaultFlagDirty() : !pSDETBItem.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDETBItem.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isDynaClassDirty() : !pSDETBItem.isDynaClassDirty()) {
            return null;
        }
        String string = pSDETBItem.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableLogic(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isEnableLogicDirty() : !pSDETBItem.isEnableLogicDirty()) {
            return null;
        }
        String string = pSDETBItem.getEnableLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableLogic_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupExtractMode(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isGroupExtractModeDirty() : !pSDETBItem.isGroupExtractModeDirty()) {
            return null;
        }
        String string = pSDETBItem.getGroupExtractMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupExtractMode_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPEXTRACTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isHeightDirty() : !pSDETBItem.isHeightDirty()) {
            return null;
        }
        Double d = pSDETBItem.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_HiddenItem(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isHiddenItemDirty() : !pSDETBItem.isHiddenItemDirty()) {
            return null;
        }
        Integer n = pSDETBItem.getHiddenItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HiddenItem_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_HtmlContent(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isHtmlContentDirty() : !pSDETBItem.isHtmlContentDirty()) {
            return null;
        }
        String string = pSDETBItem.getHtmlContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlContent_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_HtmlPageUrl(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isHtmlPageUrlDirty() : !pSDETBItem.isHtmlPageUrlDirty()) {
            return null;
        }
        String string = pSDETBItem.getHtmlPageUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlPageUrl_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ItemStyle(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isItemStyleDirty() : !pSDETBItem.isItemStyleDirty()) {
            return null;
        }
        String string = pSDETBItem.getItemStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemStyle_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_LevelTag(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isLevelTagDirty() : !pSDETBItem.isLevelTagDirty()) {
            return null;
        }
        String string = pSDETBItem.getLevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelTag_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_LevelValue(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isLevelValueDirty() : !pSDETBItem.isLevelValueDirty()) {
            return null;
        }
        Integer n = pSDETBItem.getLevelValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LevelValue_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isMemoDirty() : !pSDETBItem.isMemoDirty()) {
            return null;
        }
        String string = pSDETBItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_NoPrivDM(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isNoPrivDMDirty() : !pSDETBItem.isNoPrivDMDirty()) {
            return null;
        }
        Integer n = pSDETBItem.getNoPrivDM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoPrivDM_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOPRIVDM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenPSAppViewId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isOpenPSAppViewIdDirty() : !pSDETBItem.isOpenPSAppViewIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getOpenPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenPSAppViewId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OpenPSDEViewId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isOpenPSDEViewIdDirty() : !pSDETBItem.isOpenPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getOpenPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenPSDEViewId_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenPSSysPDTViewId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isOpenPSSysPDTViewIdDirty() : !pSDETBItem.isOpenPSSysPDTViewIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getOpenPSSysPDTViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenPSSysPDTViewId_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENPSSYSPDTVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isOrderValueDirty() : !pSDETBItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDETBItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDETBItemId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPPSDETBItemIdDirty() : !pSDETBItem.isPPSDETBItemIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPPSDETBItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDETBItemId_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDETBITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPredefinedTypeDirty() : !pSDETBItem.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSDETBItem.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PreviewHtml(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPreviewHtmlDirty() : !pSDETBItem.isPreviewHtmlDirty()) {
            return null;
        }
        String string = pSDETBItem.getPreviewHtml();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewHtml_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSDELogicIdDirty() : !pSDETBItem.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETBItemId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSDETBItemIdDirty() && !bl2 : !pSDETBItem.isPSDETBItemIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSDETBItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETBITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETBItemId_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETBITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETBItemName(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSDETBItemNameDirty() && !bl2 : !pSDETBItem.isPSDETBItemNameDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSDETBItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETBITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETBItemName_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETBITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEToolbarId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSDEToolbarIdDirty() && !bl2 : !pSDETBItem.isPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSDEToolbarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarId_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSDEUAGroupIdDirty() : !pSDETBItem.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUAGroupName(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSDEUAGroupNameDirty() : !pSDETBItem.isPSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupName_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSDEUIActionIdDirty() : !pSDETBItem.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSSysCssIdDirty() : !pSDETBItem.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssName(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSSysCssNameDirty() : !pSDETBItem.isPSSysCssNameDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSSysCssName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssName_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSSysImageIdDirty() : !pSDETBItem.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageName(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSSysImageNameDirty() : !pSDETBItem.isPSSysImageNameDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSSysImageName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageName_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSSysPFPluginIdDirty() : !pSDETBItem.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSSysResourceIdDirty() : !pSDETBItem.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isPSSysUniResIdDirty() : !pSDETBItem.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_RawContent(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isRawContentDirty() : !pSDETBItem.isRawContentDirty()) {
            return null;
        }
        String string = pSDETBItem.getRawContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawContent_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_RawCssStyle(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isRawCssStyleDirty() : !pSDETBItem.isRawCssStyleDirty()) {
            return null;
        }
        String string = pSDETBItem.getRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawCssStyle_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ShowMode(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isShowModeDirty() : !pSDETBItem.isShowModeDirty()) {
            return null;
        }
        String string = pSDETBItem.getShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShowMode_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpanFlag(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isSpanFlagDirty() : !pSDETBItem.isSpanFlagDirty()) {
            return null;
        }
        Integer n = pSDETBItem.getSpanFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SpanFlag_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TBItemType(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isTBItemTypeDirty() && !bl2 : !pSDETBItem.isTBItemTypeDirty()) {
            return null;
        }
        String string = pSDETBItem.getTBItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TBITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TBItemType_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TBITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isTemplateModeDirty() : !pSDETBItem.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSDETBItem.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isTipPSLanResIdDirty() : !pSDETBItem.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSDETBItem.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isTipPSLanResNameDirty() : !pSDETBItem.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSDETBItem.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ToggleMode(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isToggleModeDirty() : !pSDETBItem.isToggleModeDirty()) {
            return null;
        }
        String string = pSDETBItem.getToggleMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToggleMode_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isTooltipInfoDirty() : !pSDETBItem.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSDETBItem.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UIActionParams(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isUIActionParamsDirty() : !pSDETBItem.isUIActionParamsDirty()) {
            return null;
        }
        String string = pSDETBItem.getUIActionParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionParams_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isUserParamsDirty() : !pSDETBItem.isUserParamsDirty()) {
            return null;
        }
        String string = pSDETBItem.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isUserTagDirty() : !pSDETBItem.isUserTagDirty()) {
            return null;
        }
        String string = pSDETBItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isUserTag2Dirty() : !pSDETBItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDETBItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDETBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_VisibleLogic(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isVisibleLogicDirty() : !pSDETBItem.isVisibleLogicDirty()) {
            return null;
        }
        String string = pSDETBItem.getVisibleLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VisibleLogic_Default(pSDETBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VISIBLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Width(boolean bl, PSDETBItem pSDETBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETBItem.isWidthDirty() : !pSDETBItem.isWidthDirty()) {
            return null;
        }
        Double d = pSDETBItem.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default(pSDETBItem, bl2, bl3);
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

    protected void onSyncEntity(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        super.onSyncEntity(pSDETBItem, bl);
    }

    protected void onSyncIndexEntities(PSDETBItem pSDETBItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDETBItem, bl);
    }

    public Object getDataContextValue(PSDETBItem pSDETBItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDETBItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDETBItem pSDETBItem2 = pSDETBItem.getPPSDETBItem();
        if (pSDETBItem2 != null && pSDETBItem2.contains(string)) {
            return pSDETBItem2.get(string);
        }
        PSDEToolbar pSDEToolbar = pSDETBItem.getPSDEToolbar();
        if (pSDEToolbar != null && pSDEToolbar.contains(string)) {
            return pSDEToolbar.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDETBItem pSDETBItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDETBItem, arrayList, n);
        this.onExportMajorModel_TipPSLanRes(pSDETBItem, arrayList, n);
        super.onExportMajorModel(pSDETBItem, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDETBItem pSDETBItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDETBItem.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDETBItem.getCapPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_TipPSLanRes(PSDETBItem pSDETBItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDETBItem.getTipPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDETBItem.getTipPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionLevel_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEUACAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEUACap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPEXTRACTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupExtractMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIDDENITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HiddenItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLPAGEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlPageUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMSTYLETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemStyleText_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"NOPRIVDM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoPrivDM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSSYSPDTVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSSysPDTViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSSYSPDTVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSSysPDTViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDETBITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDETBItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDETBITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDETBItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWHTML", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewHtml_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDETBITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETBItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETBITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETBItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SHOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPANFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpanFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TBITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TBItemType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"TOGGLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToggleMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VISIBLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VisibleLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEUACap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEUACAP", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_EnableLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENABLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupExtractMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPEXTRACTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_NoPrivDM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OpenPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSSysPDTViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSSYSPDTVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSSysPDTViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSSYSPDTVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSDETBItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDETBITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDETBItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDETBITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDETBItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETBITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETBItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETBITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("RAWCONTENT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_ShowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHOWMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpanFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TBItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TBITEMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_UIActionParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_VisibleLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VISIBLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDETBItem pSDETBItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDETBItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDETBItem pSDETBItem) throws Exception {
        super.onUpdateParent(pSDETBItem);
    }

    @Override
    protected void exportCurXmlModel(PSDETBItem pSDETBItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETBITEM");
        if (!bl) {
            pSDETBItem.setCreateDate(null);
            pSDETBItem.setCreateMan(null);
            pSDETBItem.setLevelTag(null);
            pSDETBItem.setLevelValue(null);
            pSDETBItem.setPSDETBItemId(null);
            pSDETBItem.setUpdateDate(null);
            pSDETBItem.setUpdateMan(null);
            pSDETBItem.setPPSDETBItemId(null);
            pSDETBItem.setPSDEId(null);
            pSDETBItem.setPSDEToolbarId(null);
            pSDETBItem.setPSDEToolbarName(null);
            pSDETBItem.setPSSystemId(null);
            super.exportCurXmlModel(pSDETBItem, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDETBItem pSDETBItem, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDETBItem(pSDETBItem, xmlNode);
        super.onExportRelatedXmlModel(pSDETBItem, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDETBItem(PSDETBItem pSDETBItem, XmlNode xmlNode) throws Exception {
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETBItem> arrayList = null;
        String string = pSDETBItem.getPSDETBItemId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETBItemService.selectByPPSDETBItem(pSDETBItem, "ORDER BY ORDERVALUE ASC") : pSDETBItemService.selectTempByPPSDETBItem(pSDETBItem, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDETBITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSDETBItem pSDETBItem2 : arrayList) {
                pSDETBItem2.set("ORDERVALUE", null);
                pSDETBItemService.exportXmlModel(pSDETBItem2, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDETBItem pSDETBItem, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDETBITEMS");
        this.importRelatedXmlModel_PSDETBItem(pSDETBItem, xmlNode2);
        super.onImportRelatedXmlModel(pSDETBItem, xmlNode);
    }

    protected void importRelatedXmlModel_PSDETBItem(PSDETBItem pSDETBItem, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDETBItem.getPSDETBItemId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDETBItemService.removeByPPSDETBItem(pSDETBItem);
        } else {
            pSDETBItemService.removeTempByPPSDETBItem(pSDETBItem);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDETBItem pSDETBItem2 = new PSDETBItem();
                pSDETBItem2.setOrderValue(n);
                n += 100;
                pSDETBItemService.fillParentInfo(pSDETBItem2, "DER1N", "DER1N_PSDETBITEM_PSDETBITEM_PPSDETBITEMID", pSDETBItem.getPSDETBItemId());
                pSDETBItemService.importXmlModel(pSDETBItem2, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETBItem pSDETBItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETBItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDETBITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDETBITEM#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETOOLBARID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDETOOLBAR#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDETBITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETBITEM_PSDETBITEM_PPSDETBITEMID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETOOLBARID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETBITEM_PSDETOOLBAR_PSDETOOLBARID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDETBITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDETBITEMNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETOOLBARID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETOOLBARNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDETBITEM", (boolean)true) == 0) {
            iEntity.set("PPSDETBITEMID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBAR", (boolean)true) == 0) {
            iEntity.set("PSDETOOLBARID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSDETBITEMID", "PSDETOOLBARID"};
    }

    @Override
    public String getModelV2Tag(PSDETBItem pSDETBItem) {
        return super.getModelV2Tag(pSDETBItem);
    }

    @Override
    public boolean setModelV2Tag(PSDETBItem pSDETBItem, String string) {
        return super.setModelV2Tag(pSDETBItem, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PPSDETBITEMID", "");
        map.put("PSDETOOLBARID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDETBItem pSDETBItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDETBItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDETBItem, true);
        return super.getModelV2Entity(pSDETBItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDETBItem pSDETBItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDETBItem.getPPSDETBItemId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDETBItem.getPSDEToolbarId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdetoolbarid")) {
            objectNode.put("psdetoolbarid", "<PSDETOOLBAR>");
        }
        return super.testCompileCurModelV2(pSDETBItem, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDETBItem pSDETBItem, String string, Map<String, String> map) throws Exception {
        if (PSDETBItemServiceBase.isSimpleImportExportMode()) {
            map.put("PPSDETBITEMID", "");
            map.put("PSDETOOLBARID", "");
        }
        return super.onFillModelV2(objectNode, pSDETBItem, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDETBITEM_PSDETBITEM_PPSDETBITEMID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDETBItem pSDETBItem, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDETBItem, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDETBItem pSDETBItem, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETBITEM_PSDETBITEM_PPSDETBITEMID")) {
            PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> modelNodes = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETBITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETBITEM", (Object)pSDETBItem.getPSDETBItemId()));
                if (file.exists()) {
                    modelNodes = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        modelNodes.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                modelNodes = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETBITEM#%1$s", (Object)pSDETBItem.getPSDETBItemId());
                for (PSDETBItem model : pSDETBItemService.selectByPPSDETBItem(pSDETBItem)) {
                    String modelScope = pSDETBItemService.getModelV2ResScope(model);
                    if (StringHelper.compare(scope, modelScope, false) != 0) continue;
                    modelNodes.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (modelNodes != null && modelNodes.size() > 0) {
                ArrayNode childNodes = objectNode.putArray(pSDETBItemService.getModelV2Name(false).toLowerCase());
                Collections.sort(modelNodes, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("psdetbitemname")) {
                            string = objectNode.get("psdetbitemname").asText();
                        }
                        if (objectNode2.has("psdetbitemname")) {
                            string2 = objectNode2.get("psdetbitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode modelNode : modelNodes) {
                    PSDETBItem model = new PSDETBItem();
                    PSModelV2Helper.fromJSONObject(model, modelNode, false);
                    model.remove("ordervalue");
                    childNodes.add(pSDETBItemService.exportModelV2(model, string));
                }
            }
        }
        super.onExportCurModelV2(pSDETBItem, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDETBItem pSDETBItem) throws Exception {
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETBItem> arrayList = pSDETBItemService.selectByPPSDETBItem(pSDETBItem);
        String string = StringHelper.format((String)"PSDETBITEM#%1$s", (Object)pSDETBItem.getPSDETBItemId());
        for (PSDETBItem pSDETBItem2 : arrayList) {
            String string2 = pSDETBItemService.getModelV2ResScope(pSDETBItem2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDETBItemService.emptyModelV2(pSDETBItem2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDETBItem.getPSDETBItemId());
        pSDETBItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDETBItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETBITEM WHERE PPSDETBITEMID = ?", sqlParamList);
        super.onEmptyModelV2(pSDETBItem);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSDETBItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDETBItem pSDETBItem, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDETBItem pSDETBItem2 = new PSDETBItem();
        pSDETBItem2.set("PPSDETBITEMID", pSDETBItem.getPSDETBItemId());
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDETBItemService.getModelV2Entity(pSDETBItem2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDETBItem, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDETBItem pSDETBItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDETBItemService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDETBItem pSDETBItem2 = new PSDETBItem();
                pSDETBItem2.setPPSDETBItemId(pSDETBItem.getPSDETBItemId());
                pSDETBItem2.setPPSDETBItemName(pSDETBItem.getPSDETBItemName());
                pSDETBItem2.setOrderValue(n2 += 10);
                pSDETBItemService.compileModelV2(pSDETBItem2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDETBItem pSDETBItem3 = new PSDETBItem();
                    pSDETBItem3.setPPSDETBItemId(pSDETBItem.getPSDETBItemId());
                    pSDETBItem3.setPPSDETBItemName(pSDETBItem.getPSDETBItemName());
                    pSDETBItemService.compileModelV2(pSDETBItem3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDETBItem, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDETBItem pSDETBItem, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDETBITEM_PSDETBITEM_PPSDETBITEMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDETBItems(pSDETBItem, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDETBItem, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDETBItems(PSDETBItem pSDETBItem, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDETBITEM", true), (boolean)false) == 0) {
            PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
            PSDETBItem pSDETBItem2 = new PSDETBItem();
            pSDETBItem2.setPSDETBItemId(pSMOSFile.getPSModelId());
            if (!pSDETBItemService.get(pSDETBItem2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDETBItem2.getPPSDETBItemId(), (String)pSDETBItem.getPSDETBItemId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDETBItemService.exportModelV2(pSDETBItem2);
            pSDETBItem2.reset();
            if (!pSDETBItemService.setModelV2ResScope(pSDETBItem2, "PSDETBITEM", pSDETBItem.getPSDETBItemId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDETBItemService.importModelV2(pSDETBItem2, objectNode);
            SessionFactoryManager.commit();
            return pSDETBItemService.getFile(pSDETBItem2);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDETBItem pSDETBItem, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDETBItems(pSDETBItem, list);
        super.onFillPasteHelps(pSDETBItem, list);
    }

    protected void onFillPasteHelps_PSDETBItems(PSDETBItem pSDETBItem, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDETBITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDETBITEM_PSDETBITEM_PPSDETBITEMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5de5\u5177\u680f\u9879]\u7684[\u5de5\u5177\u680f\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSDETBItem pSDETBItem) throws Exception {
        return pSDETBItem.getTBItemType();
    }
}
