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
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBPartDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBPartDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBPart;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBPartBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboardBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortletBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBPartServiceBase
extends PSCoreSysServiceBase<PSSysDBPart> {
    private static final Log log = LogFactory.getLog(PSSysDBPartServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDBPartDEModel pSSysDBPartDEModel;
    private PSSysDBPartDAO pSSysDBPartDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService";
    }

    public PSSysDBPartDEModel getPSSysDBPartDEModel() {
        if (this.pSSysDBPartDEModel == null) {
            try {
                this.pSSysDBPartDEModel = (PSSysDBPartDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBPartDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBPartDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDBPartDEModel();
    }

    public PSSysDBPartDAO getPSSysDBPartDAO() {
        if (this.pSSysDBPartDAO == null) {
            try {
                this.pSSysDBPartDAO = (PSSysDBPartDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBPartDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBPartDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDBPartDAO();
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

    protected void onFillParentInfo(PSSysDBPart pSSysDBPart, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPART_PSLANGUAGERES_TITLEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TitlePSLanREs(pSSysDBPart, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPART_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSSysDBPart, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPART_PSSYSDASHBOARD_PSSYSDASHBOARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService", (SessionFactory)this.getSessionFactory());
            PSSysDashboard pSSysDashboard = (PSSysDashboard)iService.getDEModel().createEntity();
            pSSysDashboard.set("PSSYSDASHBOARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDashboard);
            } else {
                iService.get((IEntity)pSSysDashboard);
            }
            this.onFillParentInfo_PSSysDashboard(pSSysDBPart, pSSysDashboard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPART_PSSYSDBPART_PPSSYSDBPARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService", (SessionFactory)this.getSessionFactory());
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)iService.getDEModel().createEntity();
            pSSysDBPart2.set("PSSYSDBPARTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDBPart2);
            } else {
                iService.get((IEntity)pSSysDBPart2);
            }
            this.onFillParentInfo_PPSSysDBPart(pSSysDBPart, pSSysDBPart2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPART_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSSysDBPart, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPART_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysDBPart, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPART_PSSYSPORTLET_PSSYSPORTLETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService", (SessionFactory)this.getSessionFactory());
            PSSysPortlet pSSysPortlet = (PSSysPortlet)iService.getDEModel().createEntity();
            pSSysPortlet.set("PSSYSPORTLETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPortlet);
            } else {
                iService.get((IEntity)pSSysPortlet);
            }
            this.onFillParentInfo_PSSysPortlet(pSSysDBPart, pSSysPortlet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPART_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSSysDBPart, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPART_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUniRes);
            } else {
                iService.get((IEntity)pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSSysDBPart, pSSysUniRes);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDBPart, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_TitlePSLanREs(PSSysDBPart pSSysDBPart, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysDBPart.setTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysDBPart.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSSysDBPart pSSysDBPart, PSSysCss pSSysCss) throws Exception {
        pSSysDBPart.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysDBPart.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDashboard(PSSysDBPart pSSysDBPart, PSSysDashboard pSSysDashboard) throws Exception {
        pSSysDBPart.setPSSysDashboardId(pSSysDashboard.getPSSysDashboardId());
        pSSysDBPart.setPSSysDashboardName(pSSysDashboard.getPSSysDashboardName());
    }

    protected void onFillParentInfo_PPSSysDBPart(PSSysDBPart pSSysDBPart, PSSysDBPart pSSysDBPart2) throws Exception {
        pSSysDBPart.setPPSSysDBPartId(pSSysDBPart2.getPSSysDBPartId());
        pSSysDBPart.setPPSSysDBPartName(pSSysDBPart2.getPSSysDBPartName());
    }

    protected void onFillParentInfo_PSSysImage(PSSysDBPart pSSysDBPart, PSSysImage pSSysImage) throws Exception {
        pSSysDBPart.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSSysDBPart.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysDBPart pSSysDBPart, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysDBPart.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysDBPart.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPortlet(PSSysDBPart pSSysDBPart, PSSysPortlet pSSysPortlet) throws Exception {
        pSSysDBPart.setPortletType(pSSysPortlet.getPortletType());
        pSSysDBPart.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
        pSSysDBPart.setPSSysPortletName(pSSysPortlet.getPSSysPortletName());
    }

    protected void onFillParentInfo_PSSysResource(PSSysDBPart pSSysDBPart, PSSysResource pSSysResource) throws Exception {
        pSSysDBPart.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSSysDBPart.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSSysDBPart pSSysDBPart, PSSysUniRes pSSysUniRes) throws Exception {
        pSSysDBPart.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSSysDBPart.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillEntityFullInfo(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
        if (bl) {
            if (pSSysDBPart.getDBPartType() == null) {
                pSSysDBPart.setDBPartType((String)this.getDefaultValue(this.getWebContext(), "", "SYSPORTLET", 25));
            }
            if (pSSysDBPart.getValidFlag() == null) {
                pSSysDBPart.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysDBPart, bl);
        this.onFillEntityFullInfo_TitlePSLanREs(pSSysDBPart, bl);
        this.onFillEntityFullInfo_PSSysCss(pSSysDBPart, bl);
        this.onFillEntityFullInfo_PSSysDashboard(pSSysDBPart, bl);
        this.onFillEntityFullInfo_PPSSysDBPart(pSSysDBPart, bl);
        this.onFillEntityFullInfo_PSSysImage(pSSysDBPart, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysDBPart, bl);
        this.onFillEntityFullInfo_PSSysPortlet(pSSysDBPart, bl);
        this.onFillEntityFullInfo_PSSysResource(pSSysDBPart, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSSysDBPart, bl);
    }

    protected void onFillEntityFullInfo_TitlePSLanREs(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
        if (pSSysDBPart.isTitlePSLanResIdDirty()) {
            if (pSSysDBPart.getTitlePSLanResId() != null) {
                if (pSSysDBPart.getTitlePSLanResId() == null || pSSysDBPart.getTitlePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysDBPart.getTitlePSLanREs();
                    pSSysDBPart.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysDBPart.setTitlePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDashboard(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
        if (pSSysDBPart.isPSSysDashboardIdDirty()) {
            if (pSSysDBPart.getPSSysDashboardId() != null) {
                if (pSSysDBPart.getPSSysDashboardId() == null || pSSysDBPart.getPSSysDashboardName() == null) {
                    PSSysDashboard pSSysDashboard = pSSysDBPart.getPSSysDashboard();
                    pSSysDBPart.setPSSysDashboardName(pSSysDashboard.getPSSysDashboardName());
                }
            } else {
                pSSysDBPart.setPSSysDashboardName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSSysDBPart(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
        if (pSSysDBPart.isPPSSysDBPartIdDirty()) {
            if (pSSysDBPart.getPPSSysDBPartId() != null) {
                if (pSSysDBPart.getPPSSysDBPartId() == null || pSSysDBPart.getPPSSysDBPartName() == null) {
                    PSSysDBPart pSSysDBPart2 = pSSysDBPart.getPPSSysDBPart();
                    pSSysDBPart.setPPSSysDBPartName(pSSysDBPart2.getPSSysDBPartName());
                }
            } else {
                pSSysDBPart.setPPSSysDBPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysImage(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPortlet(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDBPart, bl);
    }

    public ArrayList<PSSysDBPart> selectByTitlePSLanREs(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTitlePSLanREs(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysDBPart> selectByTitlePSLanREs(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTitlePSLanREs(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysDBPart> selectByTitlePSLanREs(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSLanREsCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSLanREsCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDBPart> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDBPart> selectByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase) throws Exception {
        return this.selectByPSSysDashboard(pSSysDashboardBase, "", -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase, String string) throws Exception {
        return this.selectByPSSysDashboard(pSSysDashboardBase, string, -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDASHBOARDID", (Object)pSSysDashboardBase.getPSSysDashboardId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDashboardCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDashboardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDBPart> selectTempByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase) throws Exception {
        return this.selectTempByPSSysDashboard(pSSysDashboardBase, "");
    }

    public ArrayList<PSSysDBPart> selectTempByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDASHBOARDID", (Object)pSSysDashboardBase.getPSSysDashboardId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysDashboardCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysDashboardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDBPart> selectByPPSSysDBPart(PSSysDBPartBase pSSysDBPartBase) throws Exception {
        return this.selectByPPSSysDBPart(pSSysDBPartBase, "", -1);
    }

    public ArrayList<PSSysDBPart> selectByPPSSysDBPart(PSSysDBPartBase pSSysDBPartBase, String string) throws Exception {
        return this.selectByPPSSysDBPart(pSSysDBPartBase, string, -1);
    }

    public ArrayList<PSSysDBPart> selectByPPSSysDBPart(PSSysDBPartBase pSSysDBPartBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSDBPARTID", (Object)pSSysDBPartBase.getPSSysDBPartId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysDBPartCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysDBPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDBPart> selectTempByPPSSysDBPart(PSSysDBPartBase pSSysDBPartBase) throws Exception {
        return this.selectTempByPPSSysDBPart(pSSysDBPartBase, "");
    }

    public ArrayList<PSSysDBPart> selectTempByPPSSysDBPart(PSSysDBPartBase pSSysDBPartBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSDBPARTID", (Object)pSSysDBPartBase.getPSSysDBPartId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSSysDBPartCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSSysDBPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDBPart> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDBPart> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDBPart> selectByPSSysPortlet(PSSysPortletBase pSSysPortletBase) throws Exception {
        return this.selectByPSSysPortlet(pSSysPortletBase, "", -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysPortlet(PSSysPortletBase pSSysPortletBase, String string) throws Exception {
        return this.selectByPSSysPortlet(pSSysPortletBase, string, -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysPortlet(PSSysPortletBase pSSysPortletBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDBPart> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDBPart> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSSysDBPart> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
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

    public void testRemoveByTitlePSLanREs(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByTitlePSLanREs(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBPART_PSLANGUAGERES_TITLEPSLANRESID", "", iDataEntityModel.getName(), "PSSYSDBPART", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTitlePSLanREs(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByTitlePSLanREs(pSLanguageRes);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart2.setPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
            pSSysDBPart2.setTitlePSLanResId(null);
            this.update(pSSysDBPart2);
        }
    }

    public void removeByTitlePSLanREs(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveByTitlePSLanREs(pSLanguageRes2);
                PSSysDBPartServiceBase.this.internalRemoveByTitlePSLanREs(pSLanguageRes2);
                PSSysDBPartServiceBase.this.onAfterRemoveByTitlePSLanREs(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSLanREs(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTitlePSLanREs(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByTitlePSLanREs(pSLanguageRes);
        this.onBeforeRemoveByTitlePSLanREs(pSLanguageRes, arrayList);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            this.remove((IEntity)pSSysDBPart);
        }
        this.onAfterRemoveByTitlePSLanREs(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTitlePSLanREs(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSLanREs(PSLanguageRes pSLanguageRes, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSLanREs(PSLanguageRes pSLanguageRes, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBPART_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSDBPART", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart2.setPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
            pSSysDBPart2.setPSSysCssId(null);
            this.update(pSSysDBPart2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSSysDBPartServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSSysDBPartServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            this.remove((IEntity)pSSysDBPart);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
    }

    public void resetPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysDashboard(pSSysDashboard);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart2.setPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
            pSSysDBPart2.setPSSysDashboardId(null);
            this.update(pSSysDBPart2);
        }
    }

    public void resetTempPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectTempByPSSysDashboard(pSSysDashboard);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart2.setPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
            pSSysDBPart2.setPSSysDashboardId(null);
            this.updateTemp((IEntity)pSSysDBPart2);
        }
    }

    public void removeByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        final PSSysDashboard pSSysDashboard2 = pSSysDashboard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveByPSSysDashboard(pSSysDashboard2);
                PSSysDBPartServiceBase.this.internalRemoveByPSSysDashboard(pSSysDashboard2);
                PSSysDBPartServiceBase.this.onAfterRemoveByPSSysDashboard(pSSysDashboard2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
    }

    protected void internalRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysDashboard(pSSysDashboard);
        this.onBeforeRemoveByPSSysDashboard(pSSysDashboard, arrayList);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            this.remove((IEntity)pSSysDBPart);
        }
        this.onAfterRemoveByPSSysDashboard(pSSysDashboard, arrayList);
    }

    protected void onAfterRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
    }

    public void resetPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPPSSysDBPart(pSSysDBPart);
        for (PSSysDBPart pSSysDBPart2 : arrayList) {
            PSSysDBPart pSSysDBPart3 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart3.setPSSysDBPartId(pSSysDBPart2.getPSSysDBPartId());
            pSSysDBPart3.setPPSSysDBPartId(null);
            this.update(pSSysDBPart3);
        }
    }

    public void resetTempPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectTempByPPSSysDBPart(pSSysDBPart);
        for (PSSysDBPart pSSysDBPart2 : arrayList) {
            PSSysDBPart pSSysDBPart3 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart3.setPSSysDBPartId(pSSysDBPart2.getPSSysDBPartId());
            pSSysDBPart3.setPPSSysDBPartId(null);
            this.updateTemp((IEntity)pSSysDBPart3);
        }
    }

    public void removeByPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
        final PSSysDBPart pSSysDBPart2 = pSSysDBPart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveByPPSSysDBPart(pSSysDBPart2);
                PSSysDBPartServiceBase.this.internalRemoveByPPSSysDBPart(pSSysDBPart2);
                PSSysDBPartServiceBase.this.onAfterRemoveByPPSSysDBPart(pSSysDBPart2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
    }

    protected void internalRemoveByPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPPSSysDBPart(pSSysDBPart);
        this.onBeforeRemoveByPPSSysDBPart(pSSysDBPart, arrayList);
        for (PSSysDBPart pSSysDBPart2 : arrayList) {
            this.remove((IEntity)pSSysDBPart2);
        }
        this.onAfterRemoveByPPSSysDBPart(pSSysDBPart, arrayList);
    }

    protected void onAfterRemoveByPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysDBPart(PSSysDBPart pSSysDBPart, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysDBPart(PSSysDBPart pSSysDBPart, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBPART_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSSYSDBPART", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart2.setPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
            pSSysDBPart2.setPSSysImageId(null);
            this.update(pSSysDBPart2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSSysDBPartServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSSysDBPartServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            this.remove((IEntity)pSSysDBPart);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBPART_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSDBPART", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart2.setPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
            pSSysDBPart2.setPSSysPFPluginId(null);
            this.update(pSSysDBPart2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysDBPartServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysDBPartServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            this.remove((IEntity)pSSysDBPart);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysPortlet(pSSysPortlet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPORTLET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPortlet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBPART_PSSYSPORTLET_PSSYSPORTLETID", "", iDataEntityModel.getName(), "PSSYSDBPART", iDataEntityModel.getDataInfo((IEntity)pSSysPortlet), arrayList.get(0)));
        }
    }

    public void resetPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysPortlet(pSSysPortlet);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart2.setPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
            pSSysDBPart2.setPSSysPortletId(null);
            this.update(pSSysDBPart2);
        }
    }

    public void removeByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        final PSSysPortlet pSSysPortlet2 = pSSysPortlet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveByPSSysPortlet(pSSysPortlet2);
                PSSysDBPartServiceBase.this.internalRemoveByPSSysPortlet(pSSysPortlet2);
                PSSysDBPartServiceBase.this.onAfterRemoveByPSSysPortlet(pSSysPortlet2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
    }

    protected void internalRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysPortlet(pSSysPortlet);
        this.onBeforeRemoveByPSSysPortlet(pSSysPortlet, arrayList);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            this.remove((IEntity)pSSysDBPart);
        }
        this.onAfterRemoveByPSSysPortlet(pSSysPortlet, arrayList);
    }

    protected void onAfterRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBPART_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSSYSDBPART", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart2.setPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
            pSSysDBPart2.setPSSysResourceId(null);
            this.update(pSSysDBPart2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSSysDBPartServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSSysDBPartServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            this.remove((IEntity)pSSysDBPart);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBPART_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSSYSDBPART", iDataEntityModel.getDataInfo((IEntity)pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            PSSysDBPart pSSysDBPart2 = (PSSysDBPart)this.getDEModel().createEntity();
            pSSysDBPart2.setPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
            pSSysDBPart2.setPSSysUniResId(null);
            this.update(pSSysDBPart2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysDBPartServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysDBPartServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            this.remove((IEntity)pSSysDBPart);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDBPart pSSysDBPart) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysDashboardLogicService)ServiceGlobal.getService(PSSysDashboardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDBPart(pSSysDBPart);
        pSCoreSysServiceBase = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBPartServiceBase)pSCoreSysServiceBase).testRemoveByPPSSysDBPart(pSSysDBPart);
        ((PSSysDBPartServiceBase)pSCoreSysServiceBase).removeByPPSSysDBPart(pSSysDBPart);
        super.onBeforeRemove(pSSysDBPart);
    }

    protected void onBeforeRemoveTemp(PSSysDBPart pSSysDBPart) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBPartServiceBase)pSCoreSysServiceBase).resetTempPPSSysDBPart(pSSysDBPart);
        pSCoreSysServiceBase = (PSSysDashboardLogicService)ServiceGlobal.getService(PSSysDashboardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardLogicServiceBase)pSCoreSysServiceBase).resetTempPSSysDBPart(pSSysDBPart);
        super.onBeforeRemoveTemp((IEntity)pSSysDBPart);
    }

    public void removeTempByPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
        final PSSysDBPart pSSysDBPart2 = pSSysDBPart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveTempByPPSSysDBPart(pSSysDBPart2);
                PSSysDBPartServiceBase.this.internalRemoveTempByPPSSysDBPart(pSSysDBPart2);
                PSSysDBPartServiceBase.this.onAfterRemoveTempByPPSSysDBPart(pSSysDBPart2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
    }

    protected void internalRemoveTempByPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectTempByPPSSysDBPart(pSSysDBPart);
        this.onBeforeRemoveTempByPPSSysDBPart(pSSysDBPart, arrayList);
        for (PSSysDBPart pSSysDBPart2 : arrayList) {
            this.removeTemp((IEntity)pSSysDBPart2);
        }
        this.onAfterRemoveTempByPPSSysDBPart(pSSysDBPart, arrayList);
    }

    protected void onAfterRemoveTempByPPSSysDBPart(PSSysDBPart pSSysDBPart) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSSysDBPart(PSSysDBPart pSSysDBPart, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSSysDBPart(PSSysDBPart pSSysDBPart, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    public void removeTempByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        final PSSysDashboard pSSysDashboard2 = pSSysDashboard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPartServiceBase.this.onBeforeRemoveTempByPSSysDashboard(pSSysDashboard2);
                PSSysDBPartServiceBase.this.internalRemoveTempByPSSysDashboard(pSSysDashboard2);
                PSSysDBPartServiceBase.this.onAfterRemoveTempByPSSysDashboard(pSSysDashboard2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
    }

    protected void internalRemoveTempByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSSysDBPart> arrayList = this.selectTempByPSSysDashboard(pSSysDashboard);
        this.onBeforeRemoveTempByPSSysDashboard(pSSysDashboard, arrayList);
        for (PSSysDBPart pSSysDBPart : arrayList) {
            this.removeTemp((IEntity)pSSysDBPart);
        }
        this.onAfterRemoveTempByPSSysDashboard(pSSysDashboard, arrayList);
    }

    protected void onAfterRemoveTempByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysDashboard(PSSysDashboard pSSysDashboard, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysDashboard(PSSysDashboard pSSysDashboard, ArrayList<PSSysDBPart> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSSysDBPart pSSysDBPart) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSSysDBPart);
    }

    protected void updateRelatedDataTempMajor(PSSysDBPart pSSysDBPart, PSSysDBPart pSSysDBPart2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSSysDBPart, (IEntity)pSSysDBPart2);
    }

    protected void replaceParentInfo(PSSysDBPart pSSysDBPart, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDBPart, cloneSession);
        if (pSSysDBPart.getTitlePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysDBPart.getTitlePSLanResId())) != null) {
            this.onFillParentInfo_TitlePSLanREs(pSSysDBPart, (PSLanguageRes)iEntity);
        }
        if (pSSysDBPart.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysDBPart.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSSysDBPart, (PSSysCss)iEntity);
        }
        if (pSSysDBPart.getPSSysDashboardId() != null && (iEntity = cloneSession.getEntity("PSSYSDASHBOARD", (Object)pSSysDBPart.getPSSysDashboardId())) != null) {
            this.onFillParentInfo_PSSysDashboard(pSSysDBPart, (PSSysDashboard)iEntity);
        }
        if (pSSysDBPart.getPPSSysDBPartId() != null && (iEntity = cloneSession.getEntity("PSSYSDBPART", (Object)pSSysDBPart.getPPSSysDBPartId())) != null) {
            this.onFillParentInfo_PPSSysDBPart(pSSysDBPart, (PSSysDBPart)iEntity);
        }
        if (pSSysDBPart.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSSysDBPart.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSSysDBPart, (PSSysImage)iEntity);
        }
        if (pSSysDBPart.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysDBPart.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysDBPart, (PSSysPFPlugin)iEntity);
        }
        if (pSSysDBPart.getPSSysPortletId() != null && (iEntity = cloneSession.getEntity("PSSYSPORTLET", (Object)pSSysDBPart.getPSSysPortletId())) != null) {
            this.onFillParentInfo_PSSysPortlet(pSSysDBPart, (PSSysPortlet)iEntity);
        }
        if (pSSysDBPart.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSSysDBPart.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSSysDBPart, (PSSysResource)iEntity);
        }
        if (pSSysDBPart.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSSysDBPart.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSSysDBPart, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDBPart, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BL_Pos(bl, pSSysDBPart, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColSpan(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG_OS(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD_OS(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM_OS(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS_OS(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBPartType(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAnchor(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexAlign(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexBasis(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexDir(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexGrow(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexShrink(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexVAlign(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HAlignSelf(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlContent(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutMode(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewRowMode(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PartParams(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PartStyle(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PosInfo(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysDBPartId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysDBPartName(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDashboardId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDashboardName(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBPartId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBPartName(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPortletId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawContent(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawCssStyle(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowTitleBar(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwapMode(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitleBarCloseMode(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResId(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResName(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VAlignSelf(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSSysDBPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDBPart, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BL_Pos(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isBL_PosDirty() : !pSSysDBPart.isBL_PosDirty()) {
            return null;
        }
        String string = pSSysDBPart.getBL_Pos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BL_Pos_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isColIdDirty() : !pSSysDBPart.isColIdDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getColId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColId_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColSpan(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isColSpanDirty() : !pSSysDBPart.isColSpanDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getColSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColSpan_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_LG(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isCol_LGDirty() : !pSSysDBPart.isCol_LGDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getCol_LG();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_LG_OS(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isCol_LG_OSDirty() : !pSSysDBPart.isCol_LG_OSDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getCol_LG_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_OS_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_MD(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isCol_MDDirty() : !pSSysDBPart.isCol_MDDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getCol_MD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_MD_OS(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isCol_MD_OSDirty() : !pSSysDBPart.isCol_MD_OSDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getCol_MD_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_OS_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_SM(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isCol_SMDirty() : !pSSysDBPart.isCol_SMDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getCol_SM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_SM_OS(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isCol_SM_OSDirty() : !pSSysDBPart.isCol_SM_OSDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getCol_SM_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_OS_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_XS(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isCol_XSDirty() : !pSSysDBPart.isCol_XSDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getCol_XS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Col_XS_OS(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isCol_XS_OSDirty() : !pSSysDBPart.isCol_XS_OSDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getCol_XS_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_OS_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isContentTypeDirty() : !pSSysDBPart.isContentTypeDirty()) {
            return null;
        }
        String string = pSSysDBPart.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_DBPartType(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isDBPartTypeDirty() && !bl2 : !pSSysDBPart.isDBPartTypeDirty()) {
            return null;
        }
        String string = pSSysDBPart.getDBPartType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBPARTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBPartType_Default((IEntity)pSSysDBPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBPARTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isDynaClassDirty() : !pSSysDBPart.isDynaClassDirty()) {
            return null;
        }
        String string = pSSysDBPart.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableAnchor(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isEnableAnchorDirty() : !pSSysDBPart.isEnableAnchorDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getEnableAnchor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAnchor_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexAlign(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isFlexAlignDirty() : !pSSysDBPart.isFlexAlignDirty()) {
            return null;
        }
        String string = pSSysDBPart.getFlexAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexAlign_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexBasis(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isFlexBasisDirty() : !pSSysDBPart.isFlexBasisDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getFlexBasis();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexBasis_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexDir(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isFlexDirDirty() : !pSSysDBPart.isFlexDirDirty()) {
            return null;
        }
        String string = pSSysDBPart.getFlexDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexDir_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexGrow(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isFlexGrowDirty() : !pSSysDBPart.isFlexGrowDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getFlexGrow();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexGrow_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexShrink(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isFlexShrinkDirty() : !pSSysDBPart.isFlexShrinkDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getFlexShrink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexShrink_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexVAlign(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isFlexVAlignDirty() : !pSSysDBPart.isFlexVAlignDirty()) {
            return null;
        }
        String string = pSSysDBPart.getFlexVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexVAlign_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_HAlignSelf(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isHAlignSelfDirty() : !pSSysDBPart.isHAlignSelfDirty()) {
            return null;
        }
        String string = pSSysDBPart.getHAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HAlignSelf_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Height(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isHeightDirty() : !pSSysDBPart.isHeightDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_HtmlContent(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isHtmlContentDirty() : !pSSysDBPart.isHtmlContentDirty()) {
            return null;
        }
        String string = pSSysDBPart.getHtmlContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlContent_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_LayoutMode(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isLayoutModeDirty() : !pSSysDBPart.isLayoutModeDirty()) {
            return null;
        }
        String string = pSSysDBPart.getLayoutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutMode_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isMemoDirty() : !pSSysDBPart.isMemoDirty()) {
            return null;
        }
        String string = pSSysDBPart.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_NewRowMode(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isNewRowModeDirty() : !pSSysDBPart.isNewRowModeDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getNewRowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NewRowMode_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isOrderValueDirty() : !pSSysDBPart.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PartParams(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPartParamsDirty() : !pSSysDBPart.isPartParamsDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPartParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PartParams_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PartStyle(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPartStyleDirty() : !pSSysDBPart.isPartStyleDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPartStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PartStyle_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PosInfo(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPosInfoDirty() : !pSSysDBPart.isPosInfoDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPosInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PosInfo_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysDBPartId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPPSSysDBPartIdDirty() : !pSSysDBPart.isPPSSysDBPartIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPPSSysDBPartId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysDBPartId_Default((IEntity)pSSysDBPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSDBPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysDBPartName(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPPSSysDBPartNameDirty() : !pSSysDBPart.isPPSSysDBPartNameDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPPSSysDBPartName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysDBPartName_Default((IEntity)pSSysDBPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSDBPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysCssIdDirty() : !pSSysDBPart.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDashboardId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysDashboardIdDirty() : !pSSysDBPart.isPSSysDashboardIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysDashboardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDashboardId_Default((IEntity)pSSysDBPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDASHBOARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDashboardName(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysDashboardNameDirty() : !pSSysDBPart.isPSSysDashboardNameDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysDashboardName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDashboardName_Default((IEntity)pSSysDBPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDASHBOARDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBPartId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysDBPartIdDirty() && !bl2 : !pSSysDBPart.isPSSysDBPartIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysDBPartId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPARTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBPartId_Default((IEntity)pSSysDBPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBPartName(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysDBPartNameDirty() && !bl2 : !pSSysDBPart.isPSSysDBPartNameDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysDBPartName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPARTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBPartName_Default((IEntity)pSSysDBPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSDASHBOARDID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBPartDEModel(), "PSSYSDBPARTNAME", string3, pSSysDBPart, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDBPARTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysImageIdDirty() : !pSSysDBPart.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysPFPluginIdDirty() : !pSSysDBPart.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPortletId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysPortletIdDirty() : !pSSysDBPart.isPSSysPortletIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysPortletId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPortletId_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysResourceIdDirty() : !pSSysDBPart.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isPSSysUniResIdDirty() : !pSSysDBPart.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_RawContent(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isRawContentDirty() : !pSSysDBPart.isRawContentDirty()) {
            return null;
        }
        String string = pSSysDBPart.getRawContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawContent_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_RawCssStyle(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isRawCssStyleDirty() : !pSSysDBPart.isRawCssStyleDirty()) {
            return null;
        }
        String string = pSSysDBPart.getRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawCssStyle_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ShowTitleBar(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isShowTitleBarDirty() : !pSSysDBPart.isShowTitleBarDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getShowTitleBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowTitleBar_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_SwapMode(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isSwapModeDirty() : !pSSysDBPart.isSwapModeDirty()) {
            return null;
        }
        String string = pSSysDBPart.getSwapMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwapMode_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isTemplateModeDirty() : !pSSysDBPart.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Title(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isTitleDirty() : !pSSysDBPart.isTitleDirty()) {
            return null;
        }
        String string = pSSysDBPart.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_TitleBarCloseMode(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isTitleBarCloseModeDirty() : !pSSysDBPart.isTitleBarCloseModeDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getTitleBarCloseMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TitleBarCloseMode_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_TitlePSLanResId(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isTitlePSLanResIdDirty() : !pSSysDBPart.isTitlePSLanResIdDirty()) {
            return null;
        }
        String string = pSSysDBPart.getTitlePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResId_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_TitlePSLanResName(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isTitlePSLanResNameDirty() : !pSSysDBPart.isTitlePSLanResNameDirty()) {
            return null;
        }
        String string = pSSysDBPart.getTitlePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResName_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isTooltipInfoDirty() : !pSSysDBPart.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSSysDBPart.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isUserTagDirty() : !pSSysDBPart.isUserTagDirty()) {
            return null;
        }
        String string = pSSysDBPart.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isUserTag2Dirty() : !pSSysDBPart.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysDBPart.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isValidFlagDirty() && !bl2 : !pSSysDBPart.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_VAlignSelf(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isVAlignSelfDirty() : !pSSysDBPart.isVAlignSelfDirty()) {
            return null;
        }
        String string = pSSysDBPart.getVAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VAlignSelf_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Width(boolean bl, PSSysDBPart pSSysDBPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBPart.isWidthDirty() : !pSSysDBPart.isWidthDirty()) {
            return null;
        }
        Integer n = pSSysDBPart.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default((IEntity)pSSysDBPart, bl2, bl3);
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

    protected void onSyncEntity(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDBPart, bl);
    }

    protected void onSyncIndexEntities(PSSysDBPart pSSysDBPart, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDBPart, bl);
    }

    public Object getDataContextValue(PSSysDBPart pSSysDBPart, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDBPart, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysDashboard pSSysDashboard = pSSysDBPart.getPSSysDashboard();
        if (pSSysDashboard != null && pSSysDashboard.contains(string)) {
            return pSSysDashboard.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDBPart pSSysDBPart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_TitlePSLanREs(pSSysDBPart, arrayList, n);
        super.onExportMajorModel((IEntity)pSSysDBPart, arrayList, n);
    }

    protected void onExportMajorModel_TitlePSLanREs(PSSysDBPart pSSysDBPart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSSysDBPart.getTitlePSLanREs() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSSysDBPart.getTitlePSLanREs(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
        if (StringHelper.compare((String)string, (String)"DBPARTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBPartType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEANCHOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAnchor_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PPSSYSDBPARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysDBPartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSDBPARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysDBPartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDASHBOARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDashboardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDASHBOARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDashboardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBPARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBPartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBPARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBPartName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DBPartType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBPARTTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PPSSysDBPartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSDBPARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysDBPartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSDBPARTNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PSSysDashboardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDASHBOARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDashboardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDASHBOARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBPartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBPARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBPartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBPARTNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("PSSYSDBPARTNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected boolean onMergeChild(String string, String string2, PSSysDBPart pSSysDBPart) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDBPart)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDBPart pSSysDBPart) throws Exception {
        super.onUpdateParent((IEntity)pSSysDBPart);
    }

    protected void onCopyDetails(PSSysDBPart pSSysDBPart, Object object) throws Exception {
        PSSysDBPart pSSysDBPart2 = new PSSysDBPart();
        pSSysDBPart2.set("PSSYSDBPARTID", object);
        String string = DataObject.getStringValue((Object)pSSysDBPart.get("PSSYSDBPARTID"));
        super.onCopyDetails((IEntity)pSSysDBPart, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysDBPart pSSysDBPart, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDBPART");
        if (!bl) {
            pSSysDBPart.setCreateDate(null);
            pSSysDBPart.setCreateMan(null);
            pSSysDBPart.setPSSysDBPartId(null);
            pSSysDBPart.setUpdateDate(null);
            pSSysDBPart.setUpdateMan(null);
            pSSysDBPart.setPPSSysDBPartId(null);
            pSSysDBPart.setPSSysDashboardId(null);
            pSSysDBPart.setPSSysDashboardName(null);
            super.exportCurXmlModel(pSSysDBPart, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysDBPart pSSysDBPart, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSSysDBPart, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysDBPart pSSysDBPart, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSSysDBPart, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDBPart pSSysDBPart, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDBPart, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSDBPARTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSDBPART#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDASHBOARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSDASHBOARD#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSDBPARTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDBPART_PSSYSDBPART_PPSSYSDBPARTID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDASHBOARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDBPART_PSSYSDASHBOARD_PSSYSDASHBOARDID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSDBPARTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSDBPARTNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDASHBOARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDASHBOARDNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSDBPART", (boolean)true) == 0) {
            iEntity.set("PPSSYSDBPARTID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDASHBOARD", (boolean)true) == 0) {
            iEntity.set("PSSYSDASHBOARDID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSSYSDBPARTID", "PSSYSDASHBOARDID"};
    }

    @Override
    public String getModelV2Tag(PSSysDBPart pSSysDBPart) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDBPart.getPSSysDBPartName())) {
            return pSSysDBPart.getPSSysDBPartName();
        }
        return super.getModelV2Tag(pSSysDBPart);
    }

    @Override
    public boolean setModelV2Tag(PSSysDBPart pSSysDBPart, String string) {
        pSSysDBPart.setPSSysDBPartName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSDBPARTNAME", "");
        map.put("PPSSYSDBPARTID", "");
        map.put("PSSYSDASHBOARDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDBPart pSSysDBPart, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDBPart.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDBPart, true);
        pSSysDBPart.set("PSSYSDBPARTNAME", string);
        if (this.select(pSSysDBPart, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDBPart, true);
        return super.getModelV2Entity(pSSysDBPart, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDBPart pSSysDBPart, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSSysDBPart.getPPSSysDBPartId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDBPart.getPSSysDashboardId())) {
            bl = true;
        } else if (bl && !objectNode.has("pssysdashboardid")) {
            objectNode.put("pssysdashboardid", "<PSSYSDASHBOARD>");
        }
        return super.testCompileCurModelV2(pSSysDBPart, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSSysDBPart pSSysDBPart, String string, Map<String, String> map) throws Exception {
        if (PSSysDBPartServiceBase.isSimpleImportExportMode()) {
            map.put("PPSSYSDBPARTID", "");
            map.put("PSSYSDASHBOARDID", "");
        }
        return super.onFillModelV2(objectNode, pSSysDBPart, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSDBPART_PSSYSDBPART_PPSSYSDBPARTID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysDBPart pSSysDBPart, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysDBPart, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysDBPart pSSysDBPart, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSDBPART_PSSYSDBPART_PPSSYSDBPARTID")) {
            Object object;
            PSSysDBPart pSSysDBPart22;
            Object object2;
            Object object3;
            Object object4;
            PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysDBPart> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSDBPART#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSDBPART", (Object)pSSysDBPart.getPSSysDBPartId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysDBPart22 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysDBPart22);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysDBPart>();
                object4 = pSSysDBPartService.selectByPPSSysDBPart(pSSysDBPart);
                object3 = StringHelper.format((String)"PSSYSDBPART#%1$s", (Object)pSSysDBPart.getPSSysDBPartId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysDBPart22 = object2.next();
                    object = pSSysDBPartService.getModelV2ResScope((IEntity)pSSysDBPart22);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysDBPart)PSModelV2Helper.toJSONObject((IEntity)pSSysDBPart22, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysDBPartService.getModelV2Name(false);
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
                        if (objectNode.has("pssysdbpartname")) {
                            string = objectNode.get("pssysdbpartname").asText();
                        }
                        if (objectNode2.has("pssysdbpartname")) {
                            string2 = objectNode2.get("pssysdbpartname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysDBPart pSSysDBPart22 : arrayList) {
                    object = new PSSysDBPart();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysDBPart22, false);
                    ((PSSysDBPartBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSSysDBPartService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysDBPart, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysDBPart pSSysDBPart) throws Exception {
        PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysDBPart> arrayList = pSSysDBPartService.selectByPPSSysDBPart(pSSysDBPart);
        String string = StringHelper.format((String)"PSSYSDBPART#%1$s", (Object)pSSysDBPart.getPSSysDBPartId());
        for (PSSysDBPart pSSysDBPart2 : arrayList) {
            String string2 = pSSysDBPartService.getModelV2ResScope((IEntity)pSSysDBPart2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysDBPartService.emptyModelV2(pSSysDBPart2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysDBPart.getPSSysDBPartId());
        pSSysDBPartService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysDBPartService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSDBPART WHERE PPSSYSDBPARTID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysDBPart);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysDBPartService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysDBPart pSSysDBPart, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysDBPart pSSysDBPart2 = new PSSysDBPart();
        pSSysDBPart2.set("PPSSYSDBPARTID", pSSysDBPart.getPSSysDBPartId());
        PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysDBPartService.getModelV2Entity(pSSysDBPart2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysDBPart, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysDBPart pSSysDBPart, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysDBPartService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysDBPart pSSysDBPart2 = new PSSysDBPart();
                pSSysDBPart2.setPPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
                pSSysDBPart2.setPPSSysDBPartName(pSSysDBPart.getPSSysDBPartName());
                pSSysDBPart2.setOrderValue(n2 += 10);
                pSSysDBPartService.compileModelV2(pSSysDBPart2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysDBPart pSSysDBPart3 = new PSSysDBPart();
                    pSSysDBPart3.setPPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
                    pSSysDBPart3.setPPSSysDBPartName(pSSysDBPart.getPSSysDBPartName());
                    pSSysDBPartService.compileModelV2(pSSysDBPart3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysDBPart, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysDBPart pSSysDBPart, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSSysDBPart, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSSysDBPart pSSysDBPart, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSSysDBPart, list);
    }

    @Override
    public Object getDataType(PSSysDBPart pSSysDBPart) throws Exception {
        return pSSysDBPart.getDBPartType();
    }
}

