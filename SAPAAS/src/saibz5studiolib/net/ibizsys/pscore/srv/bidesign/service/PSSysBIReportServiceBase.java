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
package net.ibizsys.pscore.srv.bidesign.service;

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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBIReportDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIReportDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReport;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReportItem;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBISchemeBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIReportServiceBase
extends PSCoreSysServiceBase<PSSysBIReport> {
    private static final Log log = LogFactory.getLog(PSSysBIReportServiceBase.class);
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBIReportDEModel pSSysBIReportDEModel;
    private PSSysBIReportDAO pSSysBIReportDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService";
    }

    public PSSysBIReportDEModel getPSSysBIReportDEModel() {
        if (this.pSSysBIReportDEModel == null) {
            try {
                this.pSSysBIReportDEModel = (PSSysBIReportDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIReportDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIReportDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBIReportDEModel();
    }

    public PSSysBIReportDAO getPSSysBIReportDAO() {
        if (this.pSSysBIReportDAO == null) {
            try {
                this.pSSysBIReportDAO = (PSSysBIReportDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBIReportDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIReportDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBIReportDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchTempCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysBIReport pSSysBIReport, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORT_PSSYSBICUBE_PSSYSBICUBEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService", (SessionFactory)this.getSessionFactory());
            PSSysBICube pSSysBICube = (PSSysBICube)iService.getDEModel().createEntity();
            pSSysBICube.set("PSSYSBICUBEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICube);
            } else {
                iService.get(pSSysBICube);
            }
            this.onFillParentInfo_PSSysBICube(pSSysBIReport, pSSysBICube);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORT_PSSYSBISCHEME_PSSYSBISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBIScheme pSSysBIScheme = (PSSysBIScheme)iService.getDEModel().createEntity();
            pSSysBIScheme.set("PSSYSBISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBIScheme);
            } else {
                iService.get(pSSysBIScheme);
            }
            this.onFillParentInfo_PSSysBIScheme(pSSysBIReport, pSSysBIScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORT_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysBIReport, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORT_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysResource);
            } else {
                iService.get(pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSSysBIReport, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysBIReport, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORT_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSSysBIReport, pSSysUniRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORT_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSSysBIReport, pSSysViewPanel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORT_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSSysBIReport, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo(pSSysBIReport, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysBICube(PSSysBIReport pSSysBIReport, PSSysBICube pSSysBICube) throws Exception {
        pSSysBIReport.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
        pSSysBIReport.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
    }

    protected void onFillParentInfo_PSSysBIScheme(PSSysBIReport pSSysBIReport, PSSysBIScheme pSSysBIScheme) throws Exception {
        pSSysBIReport.setPSSysBISchemeId(pSSysBIScheme.getPSSysBISchemeId());
        pSSysBIReport.setPSSysBISchemeName(pSSysBIScheme.getPSSysBISchemeName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysBIReport pSSysBIReport, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysBIReport.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysBIReport.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysResource(PSSysBIReport pSSysBIReport, PSSysResource pSSysResource) throws Exception {
        pSSysBIReport.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSSysBIReport.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysBIReport pSSysBIReport, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysBIReport.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysBIReport.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSSysBIReport pSSysBIReport, PSSysUniRes pSSysUniRes) throws Exception {
        pSSysBIReport.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSSysBIReport.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSSysBIReport pSSysBIReport, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysBIReport.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSSysBIReport.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSSysBIReport pSSysBIReport, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSSysBIReport.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSSysBIReport.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBIReport.getCodeName() == null) {
                pSSysBIReport.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "BIReport", 25));
            }
            if (pSSysBIReport.getValidFlag() == null) {
                pSSysBIReport.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysBIReport, bl);
        this.onFillEntityFullInfo_PSSysBICube(pSSysBIReport, bl);
        this.onFillEntityFullInfo_PSSysBIScheme(pSSysBIReport, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysBIReport, bl);
        this.onFillEntityFullInfo_PSSysResource(pSSysBIReport, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysBIReport, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSSysBIReport, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSSysBIReport, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSSysBIReport, bl);
    }

    protected void onFillEntityFullInfo_PSSysBICube(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIScheme(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBIReport, bl);
    }

    public ArrayList<PSSysBIReport> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, "", -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, string, -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBEID", (Object)pSSysBICubeBase.getPSSysBICubeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIReport> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, "", -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, string, -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBISCHEMEID", (Object)pSSysBISchemeBase.getPSSysBISchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBISchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBISchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIReport> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIReport> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIReport> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIReport> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIReport> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSSysBIReport> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIReport> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSSysBIReport> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSSysBIReport> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGGROUPID", (Object)pSViewMsgGroupBase.getPSViewMsgGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewMsgGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewMsgGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysBICube(pSSysBICube, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBICube);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORT_PSSYSBICUBE_PSSYSBICUBEID", "", iDataEntityModel.getName(), "PSSYSBIREPORT", iDataEntityModel.getDataInfo(pSSysBICube), arrayList.get(0)));
        }
    }

    public void resetPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysBICube(pSSysBICube);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            PSSysBIReport pSSysBIReport2 = (PSSysBIReport)this.getDEModel().createEntity();
            pSSysBIReport2.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
            pSSysBIReport2.setPSSysBICubeId(null);
            this.update(pSSysBIReport2);
        }
    }

    public void removeByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        final PSSysBICube pSSysBICube2 = pSSysBICube;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportServiceBase.this.onBeforeRemoveByPSSysBICube(pSSysBICube2);
                PSSysBIReportServiceBase.this.internalRemoveByPSSysBICube(pSSysBICube2);
                PSSysBIReportServiceBase.this.onAfterRemoveByPSSysBICube(pSSysBICube2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void internalRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysBICube(pSSysBICube);
        this.onBeforeRemoveByPSSysBICube(pSSysBICube, arrayList);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            this.remove(pSSysBIReport);
        }
        this.onAfterRemoveByPSSysBICube(pSSysBICube, arrayList);
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORT_PSSYSBISCHEME_PSSYSBISCHEMEID", "", iDataEntityModel.getName(), "PSSYSBIREPORT", iDataEntityModel.getDataInfo(pSSysBIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            PSSysBIReport pSSysBIReport2 = (PSSysBIReport)this.getDEModel().createEntity();
            pSSysBIReport2.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
            pSSysBIReport2.setPSSysBISchemeId(null);
            this.update(pSSysBIReport2);
        }
    }

    public void removeByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        final PSSysBIScheme pSSysBIScheme2 = pSSysBIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportServiceBase.this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSSysBIReportServiceBase.this.internalRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSSysBIReportServiceBase.this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            this.remove(pSSysBIReport);
        }
        this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORT_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSBIREPORT", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            PSSysBIReport pSSysBIReport2 = (PSSysBIReport)this.getDEModel().createEntity();
            pSSysBIReport2.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
            pSSysBIReport2.setPSSysPFPluginId(null);
            this.update(pSSysBIReport2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysBIReportServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysBIReportServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            this.remove(pSSysBIReport);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORT_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSSYSBIREPORT", iDataEntityModel.getDataInfo(pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            PSSysBIReport pSSysBIReport2 = (PSSysBIReport)this.getDEModel().createEntity();
            pSSysBIReport2.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
            pSSysBIReport2.setPSSysResourceId(null);
            this.update(pSSysBIReport2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSSysBIReportServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSSysBIReportServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            this.remove(pSSysBIReport);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSBIREPORT", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            PSSysBIReport pSSysBIReport2 = (PSSysBIReport)this.getDEModel().createEntity();
            pSSysBIReport2.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
            pSSysBIReport2.setPSSysSFPluginId(null);
            this.update(pSSysBIReport2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysBIReportServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysBIReportServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            this.remove(pSSysBIReport);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORT_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSSYSBIREPORT", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            PSSysBIReport pSSysBIReport2 = (PSSysBIReport)this.getDEModel().createEntity();
            pSSysBIReport2.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
            pSSysBIReport2.setPSSysUniResId(null);
            this.update(pSSysBIReport2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysBIReportServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysBIReportServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            this.remove(pSSysBIReport);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORT_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSSYSBIREPORT", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            PSSysBIReport pSSysBIReport2 = (PSSysBIReport)this.getDEModel().createEntity();
            pSSysBIReport2.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
            pSSysBIReport2.setPSSysViewPanelId(null);
            this.update(pSSysBIReport2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysBIReportServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysBIReportServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            this.remove(pSSysBIReport);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORT_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSSYSBIREPORT", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            PSSysBIReport pSSysBIReport2 = (PSSysBIReport)this.getDEModel().createEntity();
            pSSysBIReport2.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
            pSSysBIReport2.setPSViewMsgGroupId(null);
            this.update(pSSysBIReport2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysBIReportServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysBIReportServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysBIReport> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSSysBIReport pSSysBIReport : arrayList) {
            this.remove(pSSysBIReport);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysBIReport> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBIReport pSSysBIReport) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBIReport(pSSysBIReport);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBIReport(pSSysBIReport);
        pSCoreSysServiceBase = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBIReport(pSSysBIReport);
        ((PSSysBIReportItemServiceBase)pSCoreSysServiceBase).removeByPSSysBIReport(pSSysBIReport);
        super.onBeforeRemove(pSSysBIReport);
    }

    protected void onBeforeRemoveTemp(PSSysBIReport pSSysBIReport) throws Exception {
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        pSSysBIReportItemService.removeTempByPSSysBIReport(pSSysBIReport);
        super.onBeforeRemoveTemp(pSSysBIReport);
    }

    protected void getRelatedDataTempMajor(PSSysBIReport pSSysBIReport) throws Exception {
        this.getRelatedDataTempMajor_PSSysBIReportItem(pSSysBIReport);
        super.getRelatedDataTempMajor(pSSysBIReport);
    }

    protected void getRelatedDataTempMajor_PSSysBIReportItem(PSSysBIReport pSSysBIReport) throws Exception {
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBIReportItem> arrayList = null;
        String string = pSSysBIReport.getPSSysBIReportId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysBIReportItemService.selectByPSSysBIReport(pSSysBIReport) : pSSysBIReportItemService.selectTempByPSSysBIReport(pSSysBIReport);
        PSSysBIReportServiceBase.sortHierarchyEntities(arrayList, (String)"PSSYSBIREPORTITEMID", (String)"PPSSYSBIREPORTITEMID");
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            pSSysBIReportItemService.getTempMajor(pSSysBIReportItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysBIReport pSSysBIReport, PSSysBIReport pSSysBIReport2) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.updateRelatedDataTempMajor_removePSSysBIReportItem(pSSysBIReport, pSSysBIReport2);
        this.updateRelatedDataTempMajor_updatePSSysBIReportItem(pSSysBIReport, pSSysBIReport2, arrayList);
        super.updateRelatedDataTempMajor(pSSysBIReport, pSSysBIReport2);
    }

    protected ArrayList<PSSysBIReportItem> updateRelatedDataTempMajor_removePSSysBIReportItem(PSSysBIReport pSSysBIReport, PSSysBIReport pSSysBIReport2) throws Exception {
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBIReportItem> arrayList = pSSysBIReportItemService.selectTempByPSSysBIReport(pSSysBIReport);
        ArrayList<PSSysBIReportItem> arrayList2 = pSSysBIReportItemService.selectByPSSysBIReport(pSSysBIReport2);
        HashMap<String, PSSysBIReportItem> hashMap = new HashMap<String, PSSysBIReportItem>();
        for (PSSysBIReportItem pSSysBIReportItem : arrayList2) {
            hashMap.put(pSSysBIReportItem.getPSSysBIReportItemId(), pSSysBIReportItem);
        }
        PSSysBIReportServiceBase.sortHierarchyEntities(arrayList, (String)"PSSYSBIREPORTITEMID", (String)"PPSSYSBIREPORTITEMID");
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            Object object = pSSysBIReportItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysBIReportItem pSSysBIReportItem : hashMap.values()) {
            pSSysBIReportItemService.remove(pSSysBIReportItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysBIReportItem(PSSysBIReport pSSysBIReport, PSSysBIReport pSSysBIReport2, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            pSSysBIReportItemService.updateTempMajor(pSSysBIReportItem);
        }
    }

    protected void replaceParentInfo(PSSysBIReport pSSysBIReport, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBIReport, cloneSession);
        if (pSSysBIReport.getPSSysBICubeId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBE", (Object)pSSysBIReport.getPSSysBICubeId())) != null) {
            this.onFillParentInfo_PSSysBICube(pSSysBIReport, (PSSysBICube)iEntity);
        }
        if (pSSysBIReport.getPSSysBISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBISCHEME", (Object)pSSysBIReport.getPSSysBISchemeId())) != null) {
            this.onFillParentInfo_PSSysBIScheme(pSSysBIReport, (PSSysBIScheme)iEntity);
        }
        if (pSSysBIReport.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysBIReport.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysBIReport, (PSSysPFPlugin)iEntity);
        }
        if (pSSysBIReport.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSSysBIReport.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSSysBIReport, (PSSysResource)iEntity);
        }
        if (pSSysBIReport.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysBIReport.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysBIReport, (PSSysSFPlugin)iEntity);
        }
        if (pSSysBIReport.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSSysBIReport.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSSysBIReport, (PSSysUniRes)iEntity);
        }
        if (pSSysBIReport.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSSysBIReport.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSSysBIReport, (PSSysViewPanel)iEntity);
        }
        if (pSSysBIReport.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSSysBIReport.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSSysBIReport, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBIReport, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BIReportModel(bl, pSSysBIReport, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIReportParams(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIReportTag(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIReportTag2(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIReportUIModel(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomized(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeId(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIReportId(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIReportName(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBISchemeId(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBIReport, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBIReport, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BIReportModel(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isBIReportModelDirty() : !pSSysBIReport.isBIReportModelDirty()) {
            return null;
        }
        String string = pSSysBIReport.getBIReportModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIReportModel_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPORTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIReportParams(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isBIReportParamsDirty() : !pSSysBIReport.isBIReportParamsDirty()) {
            return null;
        }
        String string = pSSysBIReport.getBIReportParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIReportParams_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPORTPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIReportTag(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isBIReportTagDirty() : !pSSysBIReport.isBIReportTagDirty()) {
            return null;
        }
        String string = pSSysBIReport.getBIReportTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIReportTag_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPORTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIReportTag2(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isBIReportTag2Dirty() : !pSSysBIReport.isBIReportTag2Dirty()) {
            return null;
        }
        String string = pSSysBIReport.getBIReportTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIReportTag2_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPORTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIReportUIModel(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isBIReportUIModelDirty() : !pSSysBIReport.isBIReportUIModelDirty()) {
            return null;
        }
        String string = pSSysBIReport.getBIReportUIModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIReportUIModel_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPORTUIMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isCodeNameDirty() && !bl2 : !pSSysBIReport.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBIReport.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysBIReport, bl2, bl3);
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
                string3 = "PSSYSBISCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIReportDEModel(), "CODENAME", string3, pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableCustomized(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isEnableCustomizedDirty() : !pSSysBIReport.isEnableCustomizedDirty()) {
            return null;
        }
        Integer n = pSSysBIReport.getEnableCustomized();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomized_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECUSTOMIZED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isMemoDirty() : !pSSysBIReport.isMemoDirty()) {
            return null;
        }
        String string = pSSysBIReport.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeId(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSSysBICubeIdDirty() && !bl2 : !pSSysBIReport.isPSSysBICubeIdDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSSysBICubeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeId_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIReportId(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSSysBIReportIdDirty() && !bl2 : !pSSysBIReport.isPSSysBIReportIdDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSSysBIReportId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIReportId_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIReportName(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSSysBIReportNameDirty() && !bl2 : !pSSysBIReport.isPSSysBIReportNameDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSSysBIReportName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIReportName_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTNAME");
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
                string3 = "PSSYSBISCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIReportDEModel(), "PSSYSBIREPORTNAME", string3, pSSysBIReport, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBIREPORTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBISchemeId(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSSysBISchemeIdDirty() && !bl2 : !pSSysBIReport.isPSSysBISchemeIdDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSSysBISchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBISCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBISchemeId_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBISCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSSysPFPluginIdDirty() : !pSSysBIReport.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSSysResourceIdDirty() : !pSSysBIReport.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSSysSFPluginIdDirty() : !pSSysBIReport.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSSysUniResIdDirty() : !pSSysBIReport.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSSysViewPanelIdDirty() : !pSSysBIReport.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isPSViewMsgGroupIdDirty() : !pSSysBIReport.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSSysBIReport.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSSysBIReport, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isUserCatDirty() : !pSSysBIReport.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBIReport.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isUserTagDirty() : !pSSysBIReport.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBIReport.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isUserTag2Dirty() : !pSSysBIReport.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBIReport.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isUserTag3Dirty() : !pSSysBIReport.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBIReport.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isUserTag4Dirty() : !pSSysBIReport.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBIReport.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBIReport, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBIReport pSSysBIReport, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReport.isValidFlagDirty() && !bl2 : !pSSysBIReport.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBIReport.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysBIReport, bl2, bl3);
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

    protected void onSyncEntity(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBIReport, bl);
    }

    protected void onSyncIndexEntities(PSSysBIReport pSSysBIReport, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBIReport, bl);
    }

    public Object getDataContextValue(PSSysBIReport pSSysBIReport, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBIReport, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBIReport pSSysBIReport, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBIReport, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BIREPORTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIReportModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIREPORTPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIReportParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIREPORTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIReportTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIREPORTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIReportTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIREPORTUIMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIReportUIModel_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMIZED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomized_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIReportId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIREPORTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIReportName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BIReportModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIREPORTMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIReportParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIREPORTPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIReportTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIREPORTTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIReportTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIREPORTTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIReportUIModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIREPORTUIMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_EnableCustomized_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSysBICubeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIReportId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIREPORTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIReportName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIREPORTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBISchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBISCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysViewPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysBIReport pSSysBIReport) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBIReport)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBIReport pSSysBIReport) throws Exception {
        super.onUpdateParent(pSSysBIReport);
    }

    protected void onCopyDetails(PSSysBIReport pSSysBIReport, Object object) throws Exception {
        PSSysBIReport pSSysBIReport2 = new PSSysBIReport();
        pSSysBIReport2.set("PSSYSBIREPORTID", object);
        String string = DataObject.getStringValue((Object)pSSysBIReport.get("PSSYSBIREPORTID"));
        super.onCopyDetails(pSSysBIReport, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysBIReport pSSysBIReport, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBIREPORT");
        if (!bl) {
            pSSysBIReport.setCreateDate(null);
            pSSysBIReport.setCreateMan(null);
            pSSysBIReport.setPSSysBIReportId(null);
            pSSysBIReport.setUpdateDate(null);
            pSSysBIReport.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBIReport, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysBIReport pSSysBIReport, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysBIReportItem(pSSysBIReport, xmlNode);
        super.onExportRelatedXmlModel(pSSysBIReport, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysBIReportItem(PSSysBIReport pSSysBIReport, XmlNode xmlNode) throws Exception {
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBIReportItem> arrayList = null;
        String string = pSSysBIReport.getPSSysBIReportId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysBIReportItemService.selectByPSSysBIReport(pSSysBIReport, "ORDER BY ORDERVALUE ASC") : pSSysBIReportItemService.selectTempByPSSysBIReport(pSSysBIReport, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSBIREPORTITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
                if (pSSysBIReportItem.getPPSSysBIReportItemId() != null) continue;
                pSSysBIReportItem.set("ORDERVALUE", null);
                pSSysBIReportItemService.exportXmlModel(pSSysBIReportItem, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysBIReport pSSysBIReport, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSBIREPORTITEMS");
        this.importRelatedXmlModel_PSSysBIReportItem(pSSysBIReport, xmlNode2);
        super.onImportRelatedXmlModel(pSSysBIReport, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysBIReportItem(PSSysBIReport pSSysBIReport, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysBIReport.getPSSysBIReportId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysBIReportItemService.removeByPSSysBIReport(pSSysBIReport);
        } else {
            pSSysBIReportItemService.removeTempByPSSysBIReport(pSSysBIReport);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysBIReportItem pSSysBIReportItem = new PSSysBIReportItem();
                pSSysBIReportItem.setOrderValue(n);
                n += 100;
                pSSysBIReportItemService.fillParentInfo(pSSysBIReportItem, "DER1N", "DER1N_PSSYSBIREPORTITEM_PSSYSBIREPORT_PSSYSBIREPORTID", pSSysBIReport.getPSSysBIReportId());
                pSSysBIReportItemService.importXmlModel(pSSysBIReportItem, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBIReport pSSysBIReport, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBIReport, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBISCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBIREPORT_PSSYSBISCHEME_PSSYSBISCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSBISCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBISCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysBIReport pSSysBIReport) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBIReport.getPSSysBIReportName())) {
            return pSSysBIReport.getPSSysBIReportName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBIReport.getCodeName())) {
            return pSSysBIReport.getCodeName();
        }
        return super.getModelV2Tag(pSSysBIReport);
    }

    @Override
    public boolean setModelV2Tag(PSSysBIReport pSSysBIReport, String string) {
        pSSysBIReport.setPSSysBIReportName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSBIREPORTNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBISCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBIReport pSSysBIReport, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBIReport.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBIReport, true);
        pSSysBIReport.set("PSSYSBIREPORTNAME", string);
        if (this.select(pSSysBIReport, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBIReport, true);
        return super.getModelV2Entity(pSSysBIReport, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBIReport pSSysBIReport, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBIReport, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSBIREPORTITEM_PSSYSBIREPORT_PSSYSBIREPORTID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysBIReport pSSysBIReport, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysBIReport, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysBIReport pSSysBIReport, ObjectNode objectNode, String string, boolean bl) throws Exception {
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBIREPORTITEM_PSSYSBIREPORT_PSSYSBIREPORTID")) {
            PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBIREPORT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBIREPORTITEM", (Object)pSSysBIReport.getPSSysBIReportId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSBIREPORT#%1$s", (Object)pSSysBIReport.getPSSysBIReportId());
                for (PSSysBIReportItem item : pSSysBIReportItemService.selectByPSSysBIReport(pSSysBIReport)) {
                    if (StringHelper.compare(scope, pSSysBIReportItemService.getModelV2ResScope(item), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode items = objectNode.putArray(pSSysBIReportItemService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssysbireportitemname")) {
                            string = objectNode.get("pssysbireportitemname").asText();
                        }
                        if (objectNode2.has("pssysbireportitemname")) {
                            string2 = objectNode2.get("pssysbireportitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSSysBIReportItem item = new PSSysBIReportItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, child, false);
                    items.add((JsonNode)pSSysBIReportItemService.exportModelV2(item, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysBIReport, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysBIReport pSSysBIReport) throws Exception {
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBIReportItem> arrayList = pSSysBIReportItemService.selectByPSSysBIReport(pSSysBIReport);
        String string = StringHelper.format((String)"PSSYSBIREPORT#%1$s", (Object)pSSysBIReport.getPSSysBIReportId());
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            String string2 = pSSysBIReportItemService.getModelV2ResScope(pSSysBIReportItem);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysBIReportItemService.emptyModelV2(pSSysBIReportItem);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysBIReport.getPSSysBIReportId());
        pSSysBIReportItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysBIReportItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSBIREPORTITEM WHERE PSSYSBIREPORTID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysBIReport);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysBIReportItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysBIReport pSSysBIReport, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysBIReportItem pSSysBIReportItem = new PSSysBIReportItem();
        pSSysBIReportItem.set("PSSYSBIREPORTID", pSSysBIReport.getPSSysBIReportId());
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysBIReportItemService.getModelV2Entity(pSSysBIReportItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysBIReport, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysBIReport pSSysBIReport, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysBIReportItemService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysBIReportItem pSSysBIReportItem = new PSSysBIReportItem();
                pSSysBIReportItem.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
                pSSysBIReportItem.setPSSysBIReportName(pSSysBIReport.getPSSysBIReportName());
                pSSysBIReportItem.setPSSysBISchemeId(pSSysBIReport.getPSSysBISchemeId());
                pSSysBIReportItemService.compileModelV2(pSSysBIReportItem, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysBIReportItem pSSysBIReportItem = new PSSysBIReportItem();
                    pSSysBIReportItem.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
                    pSSysBIReportItem.setPSSysBIReportName(pSSysBIReport.getPSSysBIReportName());
                    pSSysBIReportItem.setPSSysBISchemeId(pSSysBIReport.getPSSysBISchemeId());
                    pSSysBIReportItemService.compileModelV2(pSSysBIReportItem, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysBIReport, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysBIReport pSSysBIReport, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBIREPORTITEM_PSSYSBIREPORT_PSSYSBIREPORTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBIReportItems(pSSysBIReport, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysBIReport, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysBIReportItems(PSSysBIReport pSSysBIReport, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBIREPORTITEM", true), (boolean)false) == 0) {
            PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysBIReportItem pSSysBIReportItem = new PSSysBIReportItem();
            pSSysBIReportItem.setPSSysBIReportItemId(pSMOSFile.getPSModelId());
            if (!pSSysBIReportItemService.get(pSSysBIReportItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBIReportItem.getPSSysBIReportId(), (String)pSSysBIReport.getPSSysBIReportId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBIReportItemService.exportModelV2(pSSysBIReportItem);
            pSSysBIReportItem.reset();
            if (!pSSysBIReportItemService.setModelV2ResScope(pSSysBIReportItem, "PSSYSBIREPORT", pSSysBIReport.getPSSysBIReportId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBIReportItemService.importModelV2(pSSysBIReportItem, objectNode);
            SessionFactoryManager.commit();
            return pSSysBIReportItemService.getFile(pSSysBIReportItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysBIReport pSSysBIReport, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysBIReportItems(pSSysBIReport, list);
        super.onFillPasteHelps(pSSysBIReport, list);
    }

    protected void onFillPasteHelps_PSSysBIReportItems(PSSysBIReport pSSysBIReport, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBIREPORTITEM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBIREPORTITEM_PSSYSBIREPORT_PSSYSBIREPORTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u667a\u80fd\u62a5\u8868]\u7684[\u667a\u80fd\u62a5\u8868\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBIReport pSSysBIReport, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "BIReport");
    }
}
