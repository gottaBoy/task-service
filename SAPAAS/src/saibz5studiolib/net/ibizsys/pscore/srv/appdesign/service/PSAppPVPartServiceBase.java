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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppPVPartDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppPVPartDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPVPart;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPVPartBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortletBase;
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

public abstract class PSAppPVPartServiceBase
extends PSCoreSysServiceBase<PSAppPVPart> {
    private static final Log log = LogFactory.getLog(PSAppPVPartServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppPVPartDEModel pSAppPVPartDEModel;
    private PSAppPVPartDAO pSAppPVPartDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService";
    }

    public PSAppPVPartDEModel getPSAppPVPartDEModel() {
        if (this.pSAppPVPartDEModel == null) {
            try {
                this.pSAppPVPartDEModel = (PSAppPVPartDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppPVPartDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppPVPartDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppPVPartDEModel();
    }

    public PSAppPVPartDAO getPSAppPVPartDAO() {
        if (this.pSAppPVPartDAO == null) {
            try {
                this.pSAppPVPartDAO = (PSAppPVPartDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppPVPartDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppPVPartDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppPVPartDAO();
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

    protected void onFillParentInfo(PSAppPVPart pSAppPVPart, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSAPPMENU_PSAPPMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = (PSAppMenu)iService.getDEModel().createEntity();
            pSAppMenu.set("PSAPPMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppMenu);
            } else {
                iService.get((IEntity)pSAppMenu);
            }
            this.onFillParentInfo_PSAppMenu(pSAppPVPart, pSAppMenu);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSAPPPORTALVIEW_PSAPPPORTALVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService", (SessionFactory)this.getSessionFactory());
            PSAppPortalView pSAppPortalView = (PSAppPortalView)iService.getDEModel().createEntity();
            pSAppPortalView.set("PSAPPPORTALVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppPortalView);
            } else {
                iService.get((IEntity)pSAppPortalView);
            }
            this.onFillParentInfo_PSAppPortalView(pSAppPVPart, pSAppPortalView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSAPPPVPART_PPSAPPPVPARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService", (SessionFactory)this.getSessionFactory());
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)iService.getDEModel().createEntity();
            pSAppPVPart2.set("PSAPPPVPARTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppPVPart2);
            } else {
                iService.get((IEntity)pSAppPVPart2);
            }
            this.onFillParentInfo_PPSAppPVPart(pSAppPVPart, pSAppPVPart2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSAPPUTILVIEW_MENUPSAPPUTILVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService", (SessionFactory)this.getSessionFactory());
            PSAppUtilView pSAppUtilView = (PSAppUtilView)iService.getDEModel().createEntity();
            pSAppUtilView.set("PSAPPUTILVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppUtilView);
            } else {
                iService.get((IEntity)pSAppUtilView);
            }
            this.onFillParentInfo_MenuPSAppUtilView(pSAppPVPart, pSAppUtilView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSAPPVIEW_PSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppView);
            } else {
                iService.get((IEntity)pSAppView);
            }
            this.onFillParentInfo_PSAppView(pSAppPVPart, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSLANGUAGERES_TITLEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TitlePSLanRes(pSAppPVPart, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSAppPVPart, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSAppPVPart, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSSYSPFPLUGIN_AMPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_AMPSSysPFPlugin(pSAppPVPart, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSAppPVPart, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSSYSPORTLET_PSSYSPORTLETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService", (SessionFactory)this.getSessionFactory());
            PSSysPortlet pSSysPortlet = (PSSysPortlet)iService.getDEModel().createEntity();
            pSSysPortlet.set("PSSYSPORTLETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPortlet);
            } else {
                iService.get((IEntity)pSSysPortlet);
            }
            this.onFillParentInfo_PSSysPortlet(pSAppPVPart, pSSysPortlet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSAppPVPart, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPVPART_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUniRes);
            } else {
                iService.get((IEntity)pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSAppPVPart, pSSysUniRes);
            return;
        }
        super.onFillParentInfo((IEntity)pSAppPVPart, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppMenu(PSAppPVPart pSAppPVPart, PSAppMenu pSAppMenu) throws Exception {
        pSAppPVPart.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSAppPVPart.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
    }

    protected void onFillParentInfo_PSAppPortalView(PSAppPVPart pSAppPVPart, PSAppPortalView pSAppPortalView) throws Exception {
        pSAppPVPart.setPSAppPortalViewId(pSAppPortalView.getPSAppPortalViewId());
        pSAppPVPart.setPSAppPortalViewName(pSAppPortalView.getPSAppPortalViewName());
        pSAppPVPart.setPSSystemId(pSAppPortalView.getPSSystemId());
    }

    protected void onFillParentInfo_PPSAppPVPart(PSAppPVPart pSAppPVPart, PSAppPVPart pSAppPVPart2) throws Exception {
        pSAppPVPart.setPPSAppPVPartId(pSAppPVPart2.getPSAppPVPartId());
        pSAppPVPart.setPPSAppPVPartName(pSAppPVPart2.getPSAppPVPartName());
    }

    protected void onFillParentInfo_MenuPSAppUtilView(PSAppPVPart pSAppPVPart, PSAppUtilView pSAppUtilView) throws Exception {
        pSAppPVPart.setMenuPSAppUtilViewId(pSAppUtilView.getPSAppUtilViewId());
        pSAppPVPart.setMenuPSAppUtilViewName(pSAppUtilView.getPSAppUtilViewName());
    }

    protected void onFillParentInfo_PSAppView(PSAppPVPart pSAppPVPart, PSAppView pSAppView) throws Exception {
        pSAppPVPart.setPSAppViewId(pSAppView.getPSAppViewId());
        pSAppPVPart.setPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_TitlePSLanRes(PSAppPVPart pSAppPVPart, PSLanguageRes pSLanguageRes) throws Exception {
        pSAppPVPart.setTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSAppPVPart.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSAppPVPart pSAppPVPart, PSSysCss pSSysCss) throws Exception {
        pSAppPVPart.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSAppPVPart.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSAppPVPart pSAppPVPart, PSSysImage pSSysImage) throws Exception {
        pSAppPVPart.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSAppPVPart.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_AMPSSysPFPlugin(PSAppPVPart pSAppPVPart, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSAppPVPart.setAMPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSAppPVPart.setAMPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSAppPVPart pSAppPVPart, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSAppPVPart.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSAppPVPart.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPortlet(PSAppPVPart pSAppPVPart, PSSysPortlet pSSysPortlet) throws Exception {
        pSAppPVPart.setPortletType(pSSysPortlet.getPortletType());
        pSAppPVPart.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
        pSAppPVPart.setPSSysPortletName(pSSysPortlet.getPSSysPortletName());
    }

    protected void onFillParentInfo_PSSysResource(PSAppPVPart pSAppPVPart, PSSysResource pSSysResource) throws Exception {
        pSAppPVPart.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSAppPVPart.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSAppPVPart pSAppPVPart, PSSysUniRes pSSysUniRes) throws Exception {
        pSAppPVPart.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSAppPVPart.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillEntityFullInfo(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
        if (bl) {
            if (pSAppPVPart.getColId() == null) {
                pSAppPVPart.setColId((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSAppPVPart.getColSpan() == null) {
                pSAppPVPart.setColSpan((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSAppPVPart.getValidFlag() == null) {
                pSAppPVPart.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSAppPVPart, bl);
        this.onFillEntityFullInfo_PSAppMenu(pSAppPVPart, bl);
        this.onFillEntityFullInfo_PSAppPortalView(pSAppPVPart, bl);
        this.onFillEntityFullInfo_PPSAppPVPart(pSAppPVPart, bl);
        this.onFillEntityFullInfo_MenuPSAppUtilView(pSAppPVPart, bl);
        this.onFillEntityFullInfo_PSAppView(pSAppPVPart, bl);
        this.onFillEntityFullInfo_TitlePSLanRes(pSAppPVPart, bl);
        this.onFillEntityFullInfo_PSSysCss(pSAppPVPart, bl);
        this.onFillEntityFullInfo_PSSysImage(pSAppPVPart, bl);
        this.onFillEntityFullInfo_AMPSSysPFPlugin(pSAppPVPart, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSAppPVPart, bl);
        this.onFillEntityFullInfo_PSSysPortlet(pSAppPVPart, bl);
        this.onFillEntityFullInfo_PSSysResource(pSAppPVPart, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSAppPVPart, bl);
    }

    protected void onFillEntityFullInfo_PSAppMenu(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppPortalView(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSAppPVPart(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MenuPSAppUtilView(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppView(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TitlePSLanRes(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
        if (pSAppPVPart.isTitlePSLanResIdDirty()) {
            if (pSAppPVPart.getTitlePSLanResId() != null) {
                if (pSAppPVPart.getTitlePSLanResId() == null || pSAppPVPart.getTitlePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSAppPVPart.getTitlePSLanRes();
                    pSAppPVPart.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSAppPVPart.setTitlePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AMPSSysPFPlugin(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPortlet(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSAppPVPart, bl);
    }

    public ArrayList<PSAppPVPart> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppPVPart> selectByPSAppPortalView(PSAppPortalViewBase pSAppPortalViewBase) throws Exception {
        return this.selectByPSAppPortalView(pSAppPortalViewBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPSAppPortalView(PSAppPortalViewBase pSAppPortalViewBase, String string) throws Exception {
        return this.selectByPSAppPortalView(pSAppPortalViewBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPSAppPortalView(PSAppPortalViewBase pSAppPortalViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPPORTALVIEWID", (Object)pSAppPortalViewBase.getPSAppPortalViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppPortalViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppPortalViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPVPart> selectTempByPSAppPortalView(PSAppPortalViewBase pSAppPortalViewBase) throws Exception {
        return this.selectTempByPSAppPortalView(pSAppPortalViewBase, "");
    }

    public ArrayList<PSAppPVPart> selectTempByPSAppPortalView(PSAppPortalViewBase pSAppPortalViewBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPPORTALVIEWID", (Object)pSAppPortalViewBase.getPSAppPortalViewId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSAppPortalViewCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSAppPortalViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPVPart> selectByPPSAppPVPart(PSAppPVPartBase pSAppPVPartBase) throws Exception {
        return this.selectByPPSAppPVPart(pSAppPVPartBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPPSAppPVPart(PSAppPVPartBase pSAppPVPartBase, String string) throws Exception {
        return this.selectByPPSAppPVPart(pSAppPVPartBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPPSAppPVPart(PSAppPVPartBase pSAppPVPartBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSAPPPVPARTID", (Object)pSAppPVPartBase.getPSAppPVPartId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSAppPVPartCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSAppPVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPVPart> selectTempByPPSAppPVPart(PSAppPVPartBase pSAppPVPartBase) throws Exception {
        return this.selectTempByPPSAppPVPart(pSAppPVPartBase, "");
    }

    public ArrayList<PSAppPVPart> selectTempByPPSAppPVPart(PSAppPVPartBase pSAppPVPartBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSAPPPVPARTID", (Object)pSAppPVPartBase.getPSAppPVPartId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSAppPVPartCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSAppPVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPVPart> selectByMenuPSAppUtilView(PSAppUtilViewBase pSAppUtilViewBase) throws Exception {
        return this.selectByMenuPSAppUtilView(pSAppUtilViewBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByMenuPSAppUtilView(PSAppUtilViewBase pSAppUtilViewBase, String string) throws Exception {
        return this.selectByMenuPSAppUtilView(pSAppUtilViewBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByMenuPSAppUtilView(PSAppUtilViewBase pSAppUtilViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MENUPSAPPUTILVIEWID", (Object)pSAppUtilViewBase.getPSAppUtilViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMenuPSAppUtilViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMenuPSAppUtilViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPVPart> selectByPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPVPart> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPVPart> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppPVPart> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppPVPart> selectByAMPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByAMPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByAMPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByAMPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByAMPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AMPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAMPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAMPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPVPart> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppPVPart> selectByPSSysPortlet(PSSysPortletBase pSSysPortletBase) throws Exception {
        return this.selectByPSSysPortlet(pSSysPortletBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysPortlet(PSSysPortletBase pSSysPortletBase, String string) throws Exception {
        return this.selectByPSSysPortlet(pSSysPortletBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysPortlet(PSSysPortletBase pSSysPortletBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPORTLETID", (Object)pSSysPortletBase.getPSSysPortletId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPortletCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPortletCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPVPart> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppPVPart> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSAppPVPart> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
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

    public void testRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSAppMenu(pSAppMenu, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMENU");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppMenu);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSAPPMENU_PSAPPMENUID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSAppMenu), arrayList.get(0)));
        }
    }

    public void resetPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSAppMenu(pSAppMenu);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSAppMenuId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPSAppMenu(pSAppMenu2);
                PSAppPVPartServiceBase.this.internalRemoveByPSAppMenu(pSAppMenu2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSAppMenu(pSAppMenu);
        this.onBeforeRemoveByPSAppMenu(pSAppMenu, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
    }

    public void resetPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSAppPortalView(pSAppPortalView);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSAppPortalViewId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void resetTempPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectTempByPSAppPortalView(pSAppPortalView);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSAppPortalViewId(null);
            this.updateTemp((IEntity)pSAppPVPart2);
        }
    }

    public void removeByPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
        final PSAppPortalView pSAppPortalView2 = pSAppPortalView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPSAppPortalView(pSAppPortalView2);
                PSAppPVPartServiceBase.this.internalRemoveByPSAppPortalView(pSAppPortalView2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPSAppPortalView(pSAppPortalView2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
    }

    protected void internalRemoveByPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSAppPortalView(pSAppPortalView);
        this.onBeforeRemoveByPSAppPortalView(pSAppPortalView, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByPSAppPortalView(pSAppPortalView, arrayList);
    }

    protected void onAfterRemoveByPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
    }

    protected void onBeforeRemoveByPSAppPortalView(PSAppPortalView pSAppPortalView, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppPortalView(PSAppPortalView pSAppPortalView, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
    }

    public void resetPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPPSAppPVPart(pSAppPVPart);
        for (PSAppPVPart pSAppPVPart2 : arrayList) {
            PSAppPVPart pSAppPVPart3 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart3.setPSAppPVPartId(pSAppPVPart2.getPSAppPVPartId());
            pSAppPVPart3.setPPSAppPVPartId(null);
            this.update(pSAppPVPart3);
        }
    }

    public void resetTempPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectTempByPPSAppPVPart(pSAppPVPart);
        for (PSAppPVPart pSAppPVPart2 : arrayList) {
            PSAppPVPart pSAppPVPart3 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart3.setPSAppPVPartId(pSAppPVPart2.getPSAppPVPartId());
            pSAppPVPart3.setPPSAppPVPartId(null);
            this.updateTemp((IEntity)pSAppPVPart3);
        }
    }

    public void removeByPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
        final PSAppPVPart pSAppPVPart2 = pSAppPVPart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPPSAppPVPart(pSAppPVPart2);
                PSAppPVPartServiceBase.this.internalRemoveByPPSAppPVPart(pSAppPVPart2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPPSAppPVPart(pSAppPVPart2);
            }
        });
    }

    protected void onBeforeRemoveByPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
    }

    protected void internalRemoveByPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPPSAppPVPart(pSAppPVPart);
        this.onBeforeRemoveByPPSAppPVPart(pSAppPVPart, arrayList);
        for (PSAppPVPart pSAppPVPart2 : arrayList) {
            this.remove((IEntity)pSAppPVPart2);
        }
        this.onAfterRemoveByPPSAppPVPart(pSAppPVPart, arrayList);
    }

    protected void onAfterRemoveByPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
    }

    protected void onBeforeRemoveByPPSAppPVPart(PSAppPVPart pSAppPVPart, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSAppPVPart(PSAppPVPart pSAppPVPart, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByMenuPSAppUtilView(PSAppUtilView pSAppUtilView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByMenuPSAppUtilView(pSAppUtilView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPUTILVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppUtilView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSAPPUTILVIEW_MENUPSAPPUTILVIEWID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSAppUtilView), arrayList.get(0)));
        }
    }

    public void resetMenuPSAppUtilView(PSAppUtilView pSAppUtilView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByMenuPSAppUtilView(pSAppUtilView);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setMenuPSAppUtilViewId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByMenuPSAppUtilView(PSAppUtilView pSAppUtilView) throws Exception {
        final PSAppUtilView pSAppUtilView2 = pSAppUtilView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByMenuPSAppUtilView(pSAppUtilView2);
                PSAppPVPartServiceBase.this.internalRemoveByMenuPSAppUtilView(pSAppUtilView2);
                PSAppPVPartServiceBase.this.onAfterRemoveByMenuPSAppUtilView(pSAppUtilView2);
            }
        });
    }

    protected void onBeforeRemoveByMenuPSAppUtilView(PSAppUtilView pSAppUtilView) throws Exception {
    }

    protected void internalRemoveByMenuPSAppUtilView(PSAppUtilView pSAppUtilView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByMenuPSAppUtilView(pSAppUtilView);
        this.onBeforeRemoveByMenuPSAppUtilView(pSAppUtilView, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByMenuPSAppUtilView(pSAppUtilView, arrayList);
    }

    protected void onAfterRemoveByMenuPSAppUtilView(PSAppUtilView pSAppUtilView) throws Exception {
    }

    protected void onBeforeRemoveByMenuPSAppUtilView(PSAppUtilView pSAppUtilView, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMenuPSAppUtilView(PSAppUtilView pSAppUtilView, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSAppView(pSAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSAPPVIEW_PSAPPVIEWID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSAppView), arrayList.get(0)));
        }
    }

    public void resetPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSAppView(pSAppView);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSAppViewId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPSAppView(pSAppView2);
                PSAppPVPartServiceBase.this.internalRemoveByPSAppView(pSAppView2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSAppView(pSAppView);
        this.onBeforeRemoveByPSAppView(pSAppView, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByTitlePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSLANGUAGERES_TITLEPSLANRESID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setTitlePSLanResId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes2);
                PSAppPVPartServiceBase.this.internalRemoveByTitlePSLanRes(pSLanguageRes2);
                PSAppPVPartServiceBase.this.onAfterRemoveByTitlePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSSysCssId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSAppPVPartServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSSysImageId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSAppPVPartServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByAMPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByAMPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSSYSPFPLUGIN_AMPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetAMPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByAMPSSysPFPlugin(pSSysPFPlugin);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setAMPSSysPFPluginId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByAMPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByAMPSSysPFPlugin(pSSysPFPlugin2);
                PSAppPVPartServiceBase.this.internalRemoveByAMPSSysPFPlugin(pSSysPFPlugin2);
                PSAppPVPartServiceBase.this.onAfterRemoveByAMPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByAMPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByAMPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByAMPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByAMPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByAMPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByAMPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByAMPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAMPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSSysPFPluginId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppPVPartServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysPortlet(pSSysPortlet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPORTLET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPortlet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSSYSPORTLET_PSSYSPORTLETID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSSysPortlet), arrayList.get(0)));
        }
    }

    public void resetPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysPortlet(pSSysPortlet);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSSysPortletId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        final PSSysPortlet pSSysPortlet2 = pSSysPortlet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPSSysPortlet(pSSysPortlet2);
                PSAppPVPartServiceBase.this.internalRemoveByPSSysPortlet(pSSysPortlet2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPSSysPortlet(pSSysPortlet2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
    }

    protected void internalRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysPortlet(pSSysPortlet);
        this.onBeforeRemoveByPSSysPortlet(pSSysPortlet, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByPSSysPortlet(pSSysPortlet, arrayList);
    }

    protected void onAfterRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSSysResourceId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSAppPVPartServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPVPART_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSAPPPVPART", iDataEntityModel.getDataInfo((IEntity)pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            PSAppPVPart pSAppPVPart2 = (PSAppPVPart)this.getDEModel().createEntity();
            pSAppPVPart2.setPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
            pSAppPVPart2.setPSSysUniResId(null);
            this.update(pSAppPVPart2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSAppPVPartServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSAppPVPartServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.remove((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppPVPart pSAppPVPart) throws Exception {
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        pSAppPVPartService.testRemoveByPPSAppPVPart(pSAppPVPart);
        pSAppPVPartService.removeByPPSAppPVPart(pSAppPVPart);
        super.onBeforeRemove(pSAppPVPart);
    }

    protected void onBeforeRemoveTemp(PSAppPVPart pSAppPVPart) throws Exception {
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        pSAppPVPartService.resetTempPPSAppPVPart(pSAppPVPart);
        super.onBeforeRemoveTemp((IEntity)pSAppPVPart);
    }

    public void removeTempByPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
        final PSAppPVPart pSAppPVPart2 = pSAppPVPart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveTempByPPSAppPVPart(pSAppPVPart2);
                PSAppPVPartServiceBase.this.internalRemoveTempByPPSAppPVPart(pSAppPVPart2);
                PSAppPVPartServiceBase.this.onAfterRemoveTempByPPSAppPVPart(pSAppPVPart2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
    }

    protected void internalRemoveTempByPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectTempByPPSAppPVPart(pSAppPVPart);
        this.onBeforeRemoveTempByPPSAppPVPart(pSAppPVPart, arrayList);
        for (PSAppPVPart pSAppPVPart2 : arrayList) {
            this.removeTemp((IEntity)pSAppPVPart2);
        }
        this.onAfterRemoveTempByPPSAppPVPart(pSAppPVPart, arrayList);
    }

    protected void onAfterRemoveTempByPPSAppPVPart(PSAppPVPart pSAppPVPart) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSAppPVPart(PSAppPVPart pSAppPVPart, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSAppPVPart(PSAppPVPart pSAppPVPart, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    public void removeTempByPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
        final PSAppPortalView pSAppPortalView2 = pSAppPortalView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPartServiceBase.this.onBeforeRemoveTempByPSAppPortalView(pSAppPortalView2);
                PSAppPVPartServiceBase.this.internalRemoveTempByPSAppPortalView(pSAppPortalView2);
                PSAppPVPartServiceBase.this.onAfterRemoveTempByPSAppPortalView(pSAppPortalView2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
    }

    protected void internalRemoveTempByPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
        ArrayList<PSAppPVPart> arrayList = this.selectTempByPSAppPortalView(pSAppPortalView);
        this.onBeforeRemoveTempByPSAppPortalView(pSAppPortalView, arrayList);
        for (PSAppPVPart pSAppPVPart : arrayList) {
            this.removeTemp((IEntity)pSAppPVPart);
        }
        this.onAfterRemoveTempByPSAppPortalView(pSAppPortalView, arrayList);
    }

    protected void onAfterRemoveTempByPSAppPortalView(PSAppPortalView pSAppPortalView) throws Exception {
    }

    protected void onBeforeRemoveTempByPSAppPortalView(PSAppPortalView pSAppPortalView, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSAppPortalView(PSAppPortalView pSAppPortalView, ArrayList<PSAppPVPart> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSAppPVPart pSAppPVPart) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSAppPVPart);
    }

    protected void updateRelatedDataTempMajor(PSAppPVPart pSAppPVPart, PSAppPVPart pSAppPVPart2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSAppPVPart, (IEntity)pSAppPVPart2);
    }

    protected void replaceParentInfo(PSAppPVPart pSAppPVPart, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSAppPVPart, cloneSession);
        if (pSAppPVPart.getPSAppMenuId() != null && (iEntity = cloneSession.getEntity("PSAPPMENU", (Object)pSAppPVPart.getPSAppMenuId())) != null) {
            this.onFillParentInfo_PSAppMenu(pSAppPVPart, (PSAppMenu)iEntity);
        }
        if (pSAppPVPart.getPSAppPortalViewId() != null && (iEntity = cloneSession.getEntity("PSAPPPORTALVIEW", (Object)pSAppPVPart.getPSAppPortalViewId())) != null) {
            this.onFillParentInfo_PSAppPortalView(pSAppPVPart, (PSAppPortalView)iEntity);
        }
        if (pSAppPVPart.getPPSAppPVPartId() != null && (iEntity = cloneSession.getEntity("PSAPPPVPART", (Object)pSAppPVPart.getPPSAppPVPartId())) != null) {
            this.onFillParentInfo_PPSAppPVPart(pSAppPVPart, (PSAppPVPart)iEntity);
        }
        if (pSAppPVPart.getMenuPSAppUtilViewId() != null && (iEntity = cloneSession.getEntity("PSAPPUTILVIEW", (Object)pSAppPVPart.getMenuPSAppUtilViewId())) != null) {
            this.onFillParentInfo_MenuPSAppUtilView(pSAppPVPart, (PSAppUtilView)iEntity);
        }
        if (pSAppPVPart.getPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSAppPVPart.getPSAppViewId())) != null) {
            this.onFillParentInfo_PSAppView(pSAppPVPart, (PSAppView)iEntity);
        }
        if (pSAppPVPart.getTitlePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSAppPVPart.getTitlePSLanResId())) != null) {
            this.onFillParentInfo_TitlePSLanRes(pSAppPVPart, (PSLanguageRes)iEntity);
        }
        if (pSAppPVPart.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSAppPVPart.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSAppPVPart, (PSSysCss)iEntity);
        }
        if (pSAppPVPart.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSAppPVPart.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSAppPVPart, (PSSysImage)iEntity);
        }
        if (pSAppPVPart.getAMPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSAppPVPart.getAMPSSysPFPluginId())) != null) {
            this.onFillParentInfo_AMPSSysPFPlugin(pSAppPVPart, (PSSysPFPlugin)iEntity);
        }
        if (pSAppPVPart.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSAppPVPart.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSAppPVPart, (PSSysPFPlugin)iEntity);
        }
        if (pSAppPVPart.getPSSysPortletId() != null && (iEntity = cloneSession.getEntity("PSSYSPORTLET", (Object)pSAppPVPart.getPSSysPortletId())) != null) {
            this.onFillParentInfo_PSSysPortlet(pSAppPVPart, (PSSysPortlet)iEntity);
        }
        if (pSAppPVPart.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSAppPVPart.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSAppPVPart, (PSSysResource)iEntity);
        }
        if (pSAppPVPart.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSAppPVPart.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSAppPVPart, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSAppPVPart, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AMPSSysPFPluginId(bl, pSAppPVPart, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BL_Pos(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColSpan(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG_OS(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD_OS(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM_OS(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS_OS(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAnchor(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomMenu(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexAlign(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexBasis(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexDir(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexGrow(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexShrink(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexVAlign(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HAlignSelf(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlContent(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutMode(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MenuPSAppUtilViewId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MOBAMStyle(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewRowMode(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PartParams(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PartStyle(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PosInfo(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSAppPVPartId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppPortalViewId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppPVPartId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppPVPartName(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPortletId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PVPartType(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawContent(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawCssStyle(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowTitleBar(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwapMode(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitleBarCloseMode(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResId(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResName(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VAlignSelf(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSAppPVPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSAppPVPart, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AMPSSysPFPluginId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isAMPSSysPFPluginIdDirty() : !pSAppPVPart.isAMPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getAMPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AMPSSysPFPluginId_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AMPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BL_Pos(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isBL_PosDirty() : !pSAppPVPart.isBL_PosDirty()) {
            return null;
        }
        String string = pSAppPVPart.getBL_Pos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BL_Pos_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isColIdDirty() : !pSAppPVPart.isColIdDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getColId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColId_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColSpan(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isColSpanDirty() : !pSAppPVPart.isColSpanDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getColSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColSpan_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLSPAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_LG(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isCol_LGDirty() : !pSAppPVPart.isCol_LGDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getCol_LG();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_LG_OS(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isCol_LG_OSDirty() : !pSAppPVPart.isCol_LG_OSDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getCol_LG_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_OS_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_MD(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isCol_MDDirty() : !pSAppPVPart.isCol_MDDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getCol_MD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_MD_OS(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isCol_MD_OSDirty() : !pSAppPVPart.isCol_MD_OSDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getCol_MD_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_OS_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_SM(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isCol_SMDirty() : !pSAppPVPart.isCol_SMDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getCol_SM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_SM_OS(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isCol_SM_OSDirty() : !pSAppPVPart.isCol_SM_OSDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getCol_SM_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_OS_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_XS(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isCol_XSDirty() : !pSAppPVPart.isCol_XSDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getCol_XS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_XS_OS(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isCol_XS_OSDirty() : !pSAppPVPart.isCol_XS_OSDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getCol_XS_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_OS_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isContentTypeDirty() : !pSAppPVPart.isContentTypeDirty()) {
            return null;
        }
        String string = pSAppPVPart.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isDynaClassDirty() : !pSAppPVPart.isDynaClassDirty()) {
            return null;
        }
        String string = pSAppPVPart.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableAnchor(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isEnableAnchorDirty() : !pSAppPVPart.isEnableAnchorDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getEnableAnchor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAnchor_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEANCHOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCustomMenu(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isEnableCustomMenuDirty() : !pSAppPVPart.isEnableCustomMenuDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getEnableCustomMenu();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomMenu_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECUSTOMMENU");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexAlign(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isFlexAlignDirty() : !pSAppPVPart.isFlexAlignDirty()) {
            return null;
        }
        String string = pSAppPVPart.getFlexAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexAlign_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexBasis(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isFlexBasisDirty() : !pSAppPVPart.isFlexBasisDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getFlexBasis();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexBasis_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexDir(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isFlexDirDirty() : !pSAppPVPart.isFlexDirDirty()) {
            return null;
        }
        String string = pSAppPVPart.getFlexDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexDir_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexGrow(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isFlexGrowDirty() : !pSAppPVPart.isFlexGrowDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getFlexGrow();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexGrow_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexShrink(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isFlexShrinkDirty() : !pSAppPVPart.isFlexShrinkDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getFlexShrink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexShrink_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexVAlign(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isFlexVAlignDirty() : !pSAppPVPart.isFlexVAlignDirty()) {
            return null;
        }
        String string = pSAppPVPart.getFlexVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexVAlign_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_HAlignSelf(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isHAlignSelfDirty() : !pSAppPVPart.isHAlignSelfDirty()) {
            return null;
        }
        String string = pSAppPVPart.getHAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HAlignSelf_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Height(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isHeightDirty() : !pSAppPVPart.isHeightDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_HtmlContent(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isHtmlContentDirty() : !pSAppPVPart.isHtmlContentDirty()) {
            return null;
        }
        String string = pSAppPVPart.getHtmlContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlContent_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_LayoutMode(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isLayoutModeDirty() : !pSAppPVPart.isLayoutModeDirty()) {
            return null;
        }
        String string = pSAppPVPart.getLayoutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutMode_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isMemoDirty() : !pSAppPVPart.isMemoDirty()) {
            return null;
        }
        String string = pSAppPVPart.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_MenuPSAppUtilViewId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isMenuPSAppUtilViewIdDirty() : !pSAppPVPart.isMenuPSAppUtilViewIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getMenuPSAppUtilViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MenuPSAppUtilViewId_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MENUPSAPPUTILVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MOBAMStyle(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isMOBAMStyleDirty() : !pSAppPVPart.isMOBAMStyleDirty()) {
            return null;
        }
        String string = pSAppPVPart.getMOBAMStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MOBAMStyle_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBAMTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewRowMode(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isNewRowModeDirty() : !pSAppPVPart.isNewRowModeDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getNewRowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NewRowMode_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWROWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isOrderValueDirty() : !pSAppPVPart.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PartParams(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPartParamsDirty() : !pSAppPVPart.isPartParamsDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPartParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PartParams_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARTPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PartStyle(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPartStyleDirty() : !pSAppPVPart.isPartStyleDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPartStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PartStyle_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARTSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PosInfo(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPosInfoDirty() : !pSAppPVPart.isPosInfoDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPosInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PosInfo_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POSINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSAppPVPartId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPPSAppPVPartIdDirty() : !pSAppPVPart.isPPSAppPVPartIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPPSAppPVPartId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSAppPVPartId_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSAPPPVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppMenuId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSAppMenuIdDirty() : !pSAppPVPart.isPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSAppMenuId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuId_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppPortalViewId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSAppPortalViewIdDirty() && !bl2 : !pSAppPVPart.isPSAppPortalViewIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSAppPortalViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPORTALVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppPortalViewId_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPORTALVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppPVPartId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSAppPVPartIdDirty() && !bl2 : !pSAppPVPart.isPSAppPVPartIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSAppPVPartId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPVPARTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppPVPartId_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppPVPartName(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSAppPVPartNameDirty() && !bl2 : !pSAppPVPart.isPSAppPVPartNameDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSAppPVPartName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPVPARTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppPVPartName_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSAPPPORTALVIEWID";
                String string4 = this.checkFieldDupRule(this.getPSAppPVPartDEModel(), "PSAPPPVPARTNAME", string3, pSAppPVPart, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPPVPARTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSAppViewIdDirty() : !pSAppPVPart.isPSAppViewIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewId_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSSysCssIdDirty() : !pSAppPVPart.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSSysImageIdDirty() : !pSAppPVPart.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSSysPFPluginIdDirty() : !pSAppPVPart.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPortletId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSSysPortletIdDirty() : !pSAppPVPart.isPSSysPortletIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSSysPortletId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPortletId_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPORTLETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSSysResourceIdDirty() : !pSAppPVPart.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPSSysUniResIdDirty() : !pSAppPVPart.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PVPartType(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isPVPartTypeDirty() && !bl2 : !pSAppPVPart.isPVPartTypeDirty()) {
            return null;
        }
        String string = pSAppPVPart.getPVPartType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PVPARTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PVPartType_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PVPARTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawContent(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isRawContentDirty() : !pSAppPVPart.isRawContentDirty()) {
            return null;
        }
        String string = pSAppPVPart.getRawContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawContent_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_RawCssStyle(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isRawCssStyleDirty() : !pSAppPVPart.isRawCssStyleDirty()) {
            return null;
        }
        String string = pSAppPVPart.getRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawCssStyle_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ShowTitleBar(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isShowTitleBarDirty() : !pSAppPVPart.isShowTitleBarDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getShowTitleBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowTitleBar_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWTITLEBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SwapMode(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isSwapModeDirty() : !pSAppPVPart.isSwapModeDirty()) {
            return null;
        }
        String string = pSAppPVPart.getSwapMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwapMode_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SWAPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isTemplateModeDirty() : !pSAppPVPart.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Title(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isTitleDirty() : !pSAppPVPart.isTitleDirty()) {
            return null;
        }
        String string = pSAppPVPart.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_TitleBarCloseMode(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isTitleBarCloseModeDirty() : !pSAppPVPart.isTitleBarCloseModeDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getTitleBarCloseMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TitleBarCloseMode_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_TitlePSLanResId(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isTitlePSLanResIdDirty() : !pSAppPVPart.isTitlePSLanResIdDirty()) {
            return null;
        }
        String string = pSAppPVPart.getTitlePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResId_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResName(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isTitlePSLanResNameDirty() : !pSAppPVPart.isTitlePSLanResNameDirty()) {
            return null;
        }
        String string = pSAppPVPart.getTitlePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResName_Default((IEntity)pSAppPVPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isTooltipInfoDirty() : !pSAppPVPart.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSAppPVPart.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isUserTagDirty() : !pSAppPVPart.isUserTagDirty()) {
            return null;
        }
        String string = pSAppPVPart.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isUserTag2Dirty() : !pSAppPVPart.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppPVPart.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isValidFlagDirty() : !pSAppPVPart.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_VAlignSelf(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isVAlignSelfDirty() : !pSAppPVPart.isVAlignSelfDirty()) {
            return null;
        }
        String string = pSAppPVPart.getVAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VAlignSelf_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Width(boolean bl, PSAppPVPart pSAppPVPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPVPart.isWidthDirty() : !pSAppPVPart.isWidthDirty()) {
            return null;
        }
        Integer n = pSAppPVPart.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default((IEntity)pSAppPVPart, bl2, bl3);
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

    protected void onSyncEntity(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSAppPVPart, bl);
    }

    protected void onSyncIndexEntities(PSAppPVPart pSAppPVPart, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSAppPVPart, bl);
    }

    public Object getDataContextValue(PSAppPVPart pSAppPVPart, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSAppPVPart, string, iDataContextParam)) != null) {
            return object;
        }
        PSAppPortalView pSAppPortalView = pSAppPVPart.getPSAppPortalView();
        if (pSAppPortalView != null && pSAppPortalView.contains(string)) {
            return pSAppPortalView.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppPVPart pSAppPVPart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_TitlePSLanRes(pSAppPVPart, arrayList, n);
        super.onExportMajorModel((IEntity)pSAppPVPart, arrayList, n);
    }

    protected void onExportMajorModel_TitlePSLanRes(PSAppPVPart pSAppPVPart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSAppPVPart.getTitlePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSAppPVPart.getTitlePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AMPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AMPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AMPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AMPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BL_POS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BL_Pos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLSPAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColSpan_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEANCHOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAnchor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMMENU", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomMenu_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"HTMLCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MENUPSAPPUTILVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MenuPSAppUtilViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MENUPSAPPUTILVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MenuPSAppUtilViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBAMTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MOBAMStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWROWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewRowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARTPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PartParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARTSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PartStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORTLETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PortletType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POSINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PosInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSAPPPVPARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSAppPVPartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSAPPPVPARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSAppPVPartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPPORTALVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppPortalViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPPORTALVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppPortalViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPPVPARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppPVPartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPPVPARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppPVPartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPORTLETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPortletId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPORTLETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPortletName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PVPARTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PVPartType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWCSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawCssStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWTITLEBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowTitleBar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWAPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwapMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplateMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEBARCLOSEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitleBarCloseMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIGNSELF", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VAlignSelf_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AMPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AMPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AMPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AMPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ColSpan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_EnableAnchor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCustomMenu_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_MenuPSAppUtilViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MENUPSAPPUTILVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MenuPSAppUtilViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MENUPSAPPUTILVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MOBAMStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBAMTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewRowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PartParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARTPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PartStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARTSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PortletType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PORTLETTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PosInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("POSINFO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSAppPVPartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSAPPPVPARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSAppPVPartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSAPPPVPARTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSAppPortalViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPPORTALVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppPortalViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPPORTALVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppPVPartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPPVPARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppPVPartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPPVPARTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSAPPPVPARTNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
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

    protected String onTestValueRule_PSSysPortletId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPORTLETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPortletName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPORTLETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PVPartType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PVPARTTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_ShowTitleBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SwapMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWAPMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_TitleBarCloseMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TitlePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSAppPVPart pSAppPVPart) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSAppPVPart)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppPVPart pSAppPVPart) throws Exception {
        super.onUpdateParent((IEntity)pSAppPVPart);
    }

    @Override
    protected void exportCurXmlModel(PSAppPVPart pSAppPVPart, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPPVPART");
        if (!bl) {
            pSAppPVPart.setPPSAppPVPartId(null);
            pSAppPVPart.setPSAppPortalViewId(null);
            pSAppPVPart.setPSAppPortalViewName(null);
            pSAppPVPart.setPSSystemId(null);
            super.exportCurXmlModel(pSAppPVPart, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSAppPVPart pSAppPVPart, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSAppPVPart(pSAppPVPart, xmlNode);
        super.onExportRelatedXmlModel(pSAppPVPart, xmlNode);
    }

    protected void exportRelatedXmlModel_PSAppPVPart(PSAppPVPart pSAppPVPart, XmlNode xmlNode) throws Exception {
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppPVPart> arrayList = null;
        String string = pSAppPVPart.getPSAppPVPartId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppPVPartService.selectByPPSAppPVPart(pSAppPVPart, "ORDER BY ORDERVALUE ASC") : pSAppPVPartService.selectTempByPPSAppPVPart(pSAppPVPart, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSAPPPVPARTS");
            xmlNode.addNode(xmlNode2);
            for (PSAppPVPart pSAppPVPart2 : arrayList) {
                pSAppPVPart2.set("ORDERVALUE", null);
                pSAppPVPartService.exportXmlModel(pSAppPVPart2, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSAppPVPart pSAppPVPart, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSAPPPVPARTS");
        this.importRelatedXmlModel_PSAppPVPart(pSAppPVPart, xmlNode2);
        super.onImportRelatedXmlModel(pSAppPVPart, xmlNode);
    }

    protected void importRelatedXmlModel_PSAppPVPart(PSAppPVPart pSAppPVPart, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        String string = pSAppPVPart.getPSAppPVPartId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSAppPVPartService.removeByPPSAppPVPart(pSAppPVPart);
        } else {
            pSAppPVPartService.removeTempByPPSAppPVPart(pSAppPVPart);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSAppPVPart pSAppPVPart2 = new PSAppPVPart();
                pSAppPVPart2.setOrderValue(n);
                n += 100;
                pSAppPVPartService.fillParentInfo((IEntity)pSAppPVPart2, "DER1N", "DER1N_PSAPPPVPART_PSAPPPVPART_PPSAPPPVPARTID", pSAppPVPart.getPSAppPVPartId());
                pSAppPVPartService.importXmlModel(pSAppPVPart2, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppPVPart pSAppPVPart, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppPVPart, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSAPPPVPARTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPPVPART#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPPORTALVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPPORTALVIEW#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSAPPPVPARTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPPVPART_PSAPPPVPART_PPSAPPPVPARTID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPPORTALVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPPVPART_PSAPPPORTALVIEW_PSAPPPORTALVIEWID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSAPPPVPARTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSAPPPVPARTNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPPORTALVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPPORTALVIEWNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSAPPPVPART", (boolean)true) == 0) {
            iEntity.set("PPSAPPPVPARTID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSAPPPORTALVIEW", (boolean)true) == 0) {
            iEntity.set("PSAPPPORTALVIEWID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSAPPPVPARTID", "PSAPPPORTALVIEWID"};
    }

    @Override
    public String getModelV2Tag(PSAppPVPart pSAppPVPart) {
        if (!StringHelper.isNullOrEmpty((String)pSAppPVPart.getPSAppPVPartName())) {
            return pSAppPVPart.getPSAppPVPartName();
        }
        return super.getModelV2Tag(pSAppPVPart);
    }

    @Override
    public boolean setModelV2Tag(PSAppPVPart pSAppPVPart, String string) {
        pSAppPVPart.setPSAppPVPartName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSAPPPVPARTNAME", "");
        map.put("PPSAPPPVPARTID", "");
        map.put("PSAPPPORTALVIEWID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppPVPart pSAppPVPart, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppPVPart.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppPVPart, true);
        pSAppPVPart.set("PSAPPPVPARTNAME", string);
        if (this.select(pSAppPVPart, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppPVPart, true);
        return super.getModelV2Entity(pSAppPVPart, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppPVPart pSAppPVPart, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSAppPVPart.getPPSAppPVPartId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSAppPVPart.getPSAppPortalViewId())) {
            bl = true;
        } else if (bl && !objectNode.has("psappportalviewid")) {
            objectNode.put("psappportalviewid", "<PSAPPPORTALVIEW>");
        }
        return super.testCompileCurModelV2(pSAppPVPart, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSAppPVPart pSAppPVPart, String string, Map<String, String> map) throws Exception {
        if (PSAppPVPartServiceBase.isSimpleImportExportMode()) {
            map.put("PPSAPPPVPARTID", "");
            map.put("PSAPPPORTALVIEWID", "");
        }
        return super.onFillModelV2(objectNode, pSAppPVPart, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSAPPPVPART_PSAPPPVPART_PPSAPPPVPARTID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSAppPVPart pSAppPVPart, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSAppPVPart, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSAppPVPart pSAppPVPart, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPPVPART_PSAPPPVPART_PPSAPPPVPARTID")) {
            Object object;
            PSAppPVPart pSAppPVPart22;
            Object object2;
            Object object3;
            Object object4;
            PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSAppPVPart> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPPVPART#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPPVPART", (Object)pSAppPVPart.getPSAppPVPartId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSAppPVPart22 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSAppPVPart22);
                    }
                }
            } else {
                arrayList = new ArrayList<PSAppPVPart>();
                object4 = pSAppPVPartService.selectByPPSAppPVPart(pSAppPVPart);
                object3 = StringHelper.format((String)"PSAPPPVPART#%1$s", (Object)pSAppPVPart.getPSAppPVPartId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSAppPVPart22 = object2.next();
                    object = pSAppPVPartService.getModelV2ResScope((IEntity)pSAppPVPart22);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppPVPart)PSModelV2Helper.toJSONObject((IEntity)pSAppPVPart22, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSAppPVPartService.getModelV2Name(false);
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
                        if (objectNode.has("psapppvpartname")) {
                            string = objectNode.get("psapppvpartname").asText();
                        }
                        if (objectNode2.has("psapppvpartname")) {
                            string2 = objectNode2.get("psapppvpartname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSAppPVPart pSAppPVPart22 : arrayList) {
                    object = new PSAppPVPart();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSAppPVPart22, false);
                    ((PSAppPVPartBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSAppPVPartService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSAppPVPart, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSAppPVPart pSAppPVPart) throws Exception {
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppPVPart> arrayList = pSAppPVPartService.selectByPPSAppPVPart(pSAppPVPart);
        String string = StringHelper.format((String)"PSAPPPVPART#%1$s", (Object)pSAppPVPart.getPSAppPVPartId());
        for (PSAppPVPart pSAppPVPart2 : arrayList) {
            String string2 = pSAppPVPartService.getModelV2ResScope((IEntity)pSAppPVPart2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSAppPVPartService.emptyModelV2(pSAppPVPart2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSAppPVPart.getPSAppPVPartId());
        pSAppPVPartService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSAppPVPartService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSAPPPVPART WHERE PPSAPPPVPARTID = ?", sqlParamList);
        super.onEmptyModelV2(pSAppPVPart);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        if (pSAppPVPartService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSAppPVPart pSAppPVPart, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSAppPVPart pSAppPVPart2 = new PSAppPVPart();
        pSAppPVPart2.set("PPSAPPPVPARTID", pSAppPVPart.getPSAppPVPartId());
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSAppPVPartService.getModelV2Entity(pSAppPVPart2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSAppPVPart, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSAppPVPart pSAppPVPart, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSAppPVPartService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSAppPVPart pSAppPVPart2 = new PSAppPVPart();
                pSAppPVPart2.setPPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
                pSAppPVPart2.setPPSAppPVPartName(pSAppPVPart.getPSAppPVPartName());
                pSAppPVPart2.setOrderValue(n2 += 10);
                pSAppPVPartService.compileModelV2(pSAppPVPart2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSAppPVPart pSAppPVPart3 = new PSAppPVPart();
                    pSAppPVPart3.setPPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
                    pSAppPVPart3.setPPSAppPVPartName(pSAppPVPart.getPSAppPVPartName());
                    pSAppPVPartService.compileModelV2(pSAppPVPart3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSAppPVPart, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSAppPVPart pSAppPVPart, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPPVPART_PSAPPPVPART_PPSAPPPVPARTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppPVParts(pSAppPVPart, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSAppPVPart, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSAppPVParts(PSAppPVPart pSAppPVPart, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPPVPART", true), (boolean)false) == 0) {
            PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
            PSAppPVPart pSAppPVPart2 = new PSAppPVPart();
            pSAppPVPart2.setPSAppPVPartId(pSMOSFile.getPSModelId());
            if (!pSAppPVPartService.get((IEntity)pSAppPVPart2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppPVPart2.getPPSAppPVPartId(), (String)pSAppPVPart.getPSAppPVPartId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppPVPartService.exportModelV2(pSAppPVPart2);
            pSAppPVPart2.reset();
            if (!pSAppPVPartService.setModelV2ResScope((IEntity)pSAppPVPart2, "PSAPPPVPART", pSAppPVPart.getPSAppPVPartId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppPVPartService.importModelV2(pSAppPVPart2, objectNode);
            SessionFactoryManager.commit();
            return pSAppPVPartService.getFile((IEntity)pSAppPVPart2);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSAppPVPart pSAppPVPart, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSAppPVParts(pSAppPVPart, list);
        super.onFillPasteHelps(pSAppPVPart, list);
    }

    protected void onFillPasteHelps_PSAppPVParts(PSAppPVPart pSAppPVPart, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPPVPART");
        pSHelpSection.setSectionParam2("DER1N_PSAPPPVPART_PSAPPPVPART_PPSAPPPVPARTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6]\u7684[\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSAppPVPart pSAppPVPart) throws Exception {
        return pSAppPVPart.getPVPartType();
    }
}

