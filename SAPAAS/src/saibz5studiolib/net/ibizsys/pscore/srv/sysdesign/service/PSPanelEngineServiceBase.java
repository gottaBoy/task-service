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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineType;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSPanelEngineDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelEngineDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelEngine;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogicBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelEngineServiceBase
extends PSCoreSysServiceBase<PSPanelEngine> {
    private static final Log log = LogFactory.getLog(PSPanelEngineServiceBase.class);
    public static final String DATASET_CURPANEL = "CurPanel";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPanelEngineDEModel pSPanelEngineDEModel;
    private PSPanelEngineDAO pSPanelEngineDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineService";
    }

    public PSPanelEngineDEModel getPSPanelEngineDEModel() {
        if (this.pSPanelEngineDEModel == null) {
            try {
                this.pSPanelEngineDEModel = (PSPanelEngineDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelEngineDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelEngineDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPanelEngineDEModel();
    }

    public PSPanelEngineDAO getPSPanelEngineDAO() {
        if (this.pSPanelEngineDAO == null) {
            try {
                this.pSPanelEngineDAO = (PSPanelEngineDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSPanelEngineDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelEngineDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPanelEngineDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPANEL, (boolean)true) == 0) {
            return this.fetchCurPanel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPANEL, (boolean)true) == 0) {
            return this.fetchTempCurPanel(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANEL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANEL, true);
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

    protected void onFillParentInfo(PSPanelEngine pSPanelEngine, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSPanelEngine, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANELITEM_NO2PSPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelItem);
            } else {
                iService.get((IEntity)pSSysViewPanelItem);
            }
            this.onFillParentInfo_No2PSPanelItem(pSPanelEngine, pSSysViewPanelItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANELITEM_NO3PSPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelItem);
            } else {
                iService.get((IEntity)pSSysViewPanelItem);
            }
            this.onFillParentInfo_No3PSPanelItem(pSPanelEngine, pSSysViewPanelItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANELITEM_NO4PSPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelItem);
            } else {
                iService.get((IEntity)pSSysViewPanelItem);
            }
            this.onFillParentInfo_No4PSPanelItem(pSPanelEngine, pSSysViewPanelItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANELITEM_PSPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelItem);
            } else {
                iService.get((IEntity)pSSysViewPanelItem);
            }
            this.onFillParentInfo_PSPanelItem(pSPanelEngine, pSSysViewPanelItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANELLOGIC_NO2PSPANELLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelLogic pSSysViewPanelLogic = (PSSysViewPanelLogic)iService.getDEModel().createEntity();
            pSSysViewPanelLogic.set("PSSYSVIEWPANELLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelLogic);
            } else {
                iService.get((IEntity)pSSysViewPanelLogic);
            }
            this.onFillParentInfo_No2PSPanelLogic(pSPanelEngine, pSSysViewPanelLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANELLOGIC_NO3PSPANELLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelLogic pSSysViewPanelLogic = (PSSysViewPanelLogic)iService.getDEModel().createEntity();
            pSSysViewPanelLogic.set("PSSYSVIEWPANELLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelLogic);
            } else {
                iService.get((IEntity)pSSysViewPanelLogic);
            }
            this.onFillParentInfo_No3PSPanelLogic(pSPanelEngine, pSSysViewPanelLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANELLOGIC_NO4PSPANELLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelLogic pSSysViewPanelLogic = (PSSysViewPanelLogic)iService.getDEModel().createEntity();
            pSSysViewPanelLogic.set("PSSYSVIEWPANELLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelLogic);
            } else {
                iService.get((IEntity)pSSysViewPanelLogic);
            }
            this.onFillParentInfo_No4PSPanelLogic(pSPanelEngine, pSSysViewPanelLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANELLOGIC_PSPANELLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelLogic pSSysViewPanelLogic = (PSSysViewPanelLogic)iService.getDEModel().createEntity();
            pSSysViewPanelLogic.set("PSSYSVIEWPANELLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelLogic);
            } else {
                iService.get((IEntity)pSSysViewPanelLogic);
            }
            this.onFillParentInfo_PSPanelLogic(pSPanelEngine, pSSysViewPanelLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSPanelEngine, pSSysViewPanel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELENGINE_PSUIENGINETYPE_PSUIENGINETYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUIEngineTypeService", (SessionFactory)this.getSessionFactory());
            PSUIEngineType pSUIEngineType = (PSUIEngineType)iService.getDEModel().createEntity();
            pSUIEngineType.set("PSUIENGINETYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUIEngineType);
            } else {
                iService.get((IEntity)pSUIEngineType);
            }
            this.onFillParentInfo_PSUIEngineType(pSPanelEngine, pSUIEngineType);
            return;
        }
        super.onFillParentInfo((IEntity)pSPanelEngine, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSPanelEngine pSPanelEngine, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSPanelEngine.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSPanelEngine.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_No2PSPanelItem(PSPanelEngine pSPanelEngine, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSPanelEngine.setNo2PSPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSPanelEngine.setNo2PSPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
    }

    protected void onFillParentInfo_No3PSPanelItem(PSPanelEngine pSPanelEngine, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSPanelEngine.setNo3PSPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSPanelEngine.setNo3PSPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
    }

    protected void onFillParentInfo_No4PSPanelItem(PSPanelEngine pSPanelEngine, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSPanelEngine.setNo4PSPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSPanelEngine.setNo4PSPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
    }

    protected void onFillParentInfo_PSPanelItem(PSPanelEngine pSPanelEngine, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSPanelEngine.setPSPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSPanelEngine.setPSPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
    }

    protected void onFillParentInfo_No2PSPanelLogic(PSPanelEngine pSPanelEngine, PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        pSPanelEngine.setNo2PSPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        pSPanelEngine.setNo2PSPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
    }

    protected void onFillParentInfo_No3PSPanelLogic(PSPanelEngine pSPanelEngine, PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        pSPanelEngine.setNo3PSPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        pSPanelEngine.setNo3PSPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
    }

    protected void onFillParentInfo_No4PSPanelLogic(PSPanelEngine pSPanelEngine, PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        pSPanelEngine.setNo4PSPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        pSPanelEngine.setNo4PSPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
    }

    protected void onFillParentInfo_PSPanelLogic(PSPanelEngine pSPanelEngine, PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        pSPanelEngine.setPSPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        pSPanelEngine.setPSPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSPanelEngine pSPanelEngine, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSPanelEngine.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSPanelEngine.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillParentInfo_PSUIEngineType(PSPanelEngine pSPanelEngine, PSUIEngineType pSUIEngineType) throws Exception {
        pSPanelEngine.setPSUIEngineTypeId(pSUIEngineType.getPSUIEngineTypeId());
        pSPanelEngine.setPSUIEngineTypeName(pSUIEngineType.getPSUIEngineTypeName());
    }

    protected void onFillEntityFullInfo(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (bl && pSPanelEngine.getValidFlag() == null) {
            pSPanelEngine.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSPanelEngine, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSPanelEngine, bl);
        this.onFillEntityFullInfo_No2PSPanelItem(pSPanelEngine, bl);
        this.onFillEntityFullInfo_No3PSPanelItem(pSPanelEngine, bl);
        this.onFillEntityFullInfo_No4PSPanelItem(pSPanelEngine, bl);
        this.onFillEntityFullInfo_PSPanelItem(pSPanelEngine, bl);
        this.onFillEntityFullInfo_No2PSPanelLogic(pSPanelEngine, bl);
        this.onFillEntityFullInfo_No3PSPanelLogic(pSPanelEngine, bl);
        this.onFillEntityFullInfo_No4PSPanelLogic(pSPanelEngine, bl);
        this.onFillEntityFullInfo_PSPanelLogic(pSPanelEngine, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSPanelEngine, bl);
        this.onFillEntityFullInfo_PSUIEngineType(pSPanelEngine, bl);
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSPanelItem(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (pSPanelEngine.isNo2PSPanelItemIdDirty()) {
            if (pSPanelEngine.getNo2PSPanelItemId() != null) {
                if (pSPanelEngine.getNo2PSPanelItemId() == null || pSPanelEngine.getNo2PSPanelItemName() == null) {
                    PSSysViewPanelItem pSSysViewPanelItem = pSPanelEngine.getNo2PSPanelItem();
                    pSPanelEngine.setNo2PSPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                }
            } else {
                pSPanelEngine.setNo2PSPanelItemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No3PSPanelItem(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (pSPanelEngine.isNo3PSPanelItemIdDirty()) {
            if (pSPanelEngine.getNo3PSPanelItemId() != null) {
                if (pSPanelEngine.getNo3PSPanelItemId() == null || pSPanelEngine.getNo3PSPanelItemName() == null) {
                    PSSysViewPanelItem pSSysViewPanelItem = pSPanelEngine.getNo3PSPanelItem();
                    pSPanelEngine.setNo3PSPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                }
            } else {
                pSPanelEngine.setNo3PSPanelItemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No4PSPanelItem(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (pSPanelEngine.isNo4PSPanelItemIdDirty()) {
            if (pSPanelEngine.getNo4PSPanelItemId() != null) {
                if (pSPanelEngine.getNo4PSPanelItemId() == null || pSPanelEngine.getNo4PSPanelItemName() == null) {
                    PSSysViewPanelItem pSSysViewPanelItem = pSPanelEngine.getNo4PSPanelItem();
                    pSPanelEngine.setNo4PSPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                }
            } else {
                pSPanelEngine.setNo4PSPanelItemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPanelItem(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (pSPanelEngine.isPSPanelItemIdDirty()) {
            if (pSPanelEngine.getPSPanelItemId() != null) {
                if (pSPanelEngine.getPSPanelItemId() == null || pSPanelEngine.getPSPanelItemName() == null) {
                    PSSysViewPanelItem pSSysViewPanelItem = pSPanelEngine.getPSPanelItem();
                    pSPanelEngine.setPSPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                }
            } else {
                pSPanelEngine.setPSPanelItemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No2PSPanelLogic(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (pSPanelEngine.isNo2PSPanelLogicIdDirty()) {
            if (pSPanelEngine.getNo2PSPanelLogicId() != null) {
                if (pSPanelEngine.getNo2PSPanelLogicId() == null || pSPanelEngine.getNo2PSPanelLogicName() == null) {
                    PSSysViewPanelLogic pSSysViewPanelLogic = pSPanelEngine.getNo2PSPanelLogic();
                    pSPanelEngine.setNo2PSPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                }
            } else {
                pSPanelEngine.setNo2PSPanelLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No3PSPanelLogic(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (pSPanelEngine.isNo3PSPanelLogicIdDirty()) {
            if (pSPanelEngine.getNo3PSPanelLogicId() != null) {
                if (pSPanelEngine.getNo3PSPanelLogicId() == null || pSPanelEngine.getNo3PSPanelLogicName() == null) {
                    PSSysViewPanelLogic pSSysViewPanelLogic = pSPanelEngine.getNo3PSPanelLogic();
                    pSPanelEngine.setNo3PSPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                }
            } else {
                pSPanelEngine.setNo3PSPanelLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No4PSPanelLogic(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (pSPanelEngine.isNo4PSPanelLogicIdDirty()) {
            if (pSPanelEngine.getNo4PSPanelLogicId() != null) {
                if (pSPanelEngine.getNo4PSPanelLogicId() == null || pSPanelEngine.getNo4PSPanelLogicName() == null) {
                    PSSysViewPanelLogic pSSysViewPanelLogic = pSPanelEngine.getNo4PSPanelLogic();
                    pSPanelEngine.setNo4PSPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                }
            } else {
                pSPanelEngine.setNo4PSPanelLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPanelLogic(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (pSPanelEngine.isPSPanelLogicIdDirty()) {
            if (pSPanelEngine.getPSPanelLogicId() != null) {
                if (pSPanelEngine.getPSPanelLogicId() == null || pSPanelEngine.getPSPanelLogicName() == null) {
                    PSSysViewPanelLogic pSSysViewPanelLogic = pSPanelEngine.getPSPanelLogic();
                    pSPanelEngine.setPSPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                }
            } else {
                pSPanelEngine.setPSPanelLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSUIEngineType(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        if (pSPanelEngine.isPSUIEngineTypeIdDirty()) {
            if (pSPanelEngine.getPSUIEngineTypeId() != null) {
                if (pSPanelEngine.getPSUIEngineTypeId() == null || pSPanelEngine.getPSUIEngineTypeName() == null) {
                    PSUIEngineType pSUIEngineType = pSPanelEngine.getPSUIEngineType();
                    pSPanelEngine.setPSUIEngineTypeName(pSUIEngineType.getPSUIEngineTypeName());
                }
            } else {
                pSPanelEngine.setPSUIEngineTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPanelEngine, bl);
    }

    public ArrayList<PSPanelEngine> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelEngine> selectByNo2PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByNo2PSPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByNo2PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByNo2PSPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByNo2PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSPanelItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectTempByNo2PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByNo2PSPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSPanelEngine> selectTempByNo2PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo2PSPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo2PSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectByNo3PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByNo3PSPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByNo3PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByNo3PSPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByNo3PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3PSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo3PSPanelItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo3PSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectTempByNo3PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByNo3PSPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSPanelEngine> selectTempByNo3PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3PSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo3PSPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo3PSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectByNo4PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByNo4PSPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByNo4PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByNo4PSPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByNo4PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO4PSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo4PSPanelItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo4PSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectTempByNo4PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByNo4PSPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSPanelEngine> selectTempByNo4PSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO4PSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo4PSPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo4PSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectByPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByPSPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByPSPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPanelItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectTempByPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByPSPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSPanelEngine> selectTempByPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectByNo2PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectByNo2PSPanelLogic(pSSysViewPanelLogicBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByNo2PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        return this.selectByNo2PSPanelLogic(pSSysViewPanelLogicBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByNo2PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSPanelLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectTempByNo2PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectTempByNo2PSPanelLogic(pSSysViewPanelLogicBase, "");
    }

    public ArrayList<PSPanelEngine> selectTempByNo2PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo2PSPanelLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo2PSPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectByNo3PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectByNo3PSPanelLogic(pSSysViewPanelLogicBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByNo3PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        return this.selectByNo3PSPanelLogic(pSSysViewPanelLogicBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByNo3PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3PSPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo3PSPanelLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo3PSPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectTempByNo3PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectTempByNo3PSPanelLogic(pSSysViewPanelLogicBase, "");
    }

    public ArrayList<PSPanelEngine> selectTempByNo3PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3PSPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo3PSPanelLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo3PSPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectByNo4PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectByNo4PSPanelLogic(pSSysViewPanelLogicBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByNo4PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        return this.selectByNo4PSPanelLogic(pSSysViewPanelLogicBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByNo4PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO4PSPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo4PSPanelLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo4PSPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectTempByNo4PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectTempByNo4PSPanelLogic(pSSysViewPanelLogicBase, "");
    }

    public ArrayList<PSPanelEngine> selectTempByNo4PSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO4PSPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo4PSPanelLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo4PSPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectByPSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectByPSPanelLogic(pSSysViewPanelLogicBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByPSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        return this.selectByPSPanelLogic(pSSysViewPanelLogicBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByPSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPanelLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectTempByPSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectTempByPSPanelLogic(pSSysViewPanelLogicBase, "");
    }

    public ArrayList<PSPanelEngine> selectTempByPSPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSPanelLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelEngine> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSPanelEngine> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelEngine> selectByPSUIEngineType(PSUIEngineTypeBase pSUIEngineTypeBase) throws Exception {
        return this.selectByPSUIEngineType(pSUIEngineTypeBase, "", -1);
    }

    public ArrayList<PSPanelEngine> selectByPSUIEngineType(PSUIEngineTypeBase pSUIEngineTypeBase, String string) throws Exception {
        return this.selectByPSUIEngineType(pSUIEngineTypeBase, string, -1);
    }

    public ArrayList<PSPanelEngine> selectByPSUIEngineType(PSUIEngineTypeBase pSUIEngineTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUIENGINETYPEID", (Object)pSUIEngineTypeBase.getPSUIEngineTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUIEngineTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUIEngineTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELENGINE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSPANELENGINE", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setPSSysPFPluginId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSPanelEngineServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSPanelEngineServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo2PSPanelItem(pSSysViewPanelItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanelItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELENGINE_PSSYSVIEWPANELITEM_NO2PSPANELITEMID", "", iDataEntityModel.getName(), "PSPANELENGINE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanelItem), arrayList.get(0)));
        }
    }

    public void resetNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo2PSPanelItem(pSSysViewPanelItem);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo2PSPanelItemId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void resetTempNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo2PSPanelItem(pSSysViewPanelItem);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo2PSPanelItemId(null);
            this.updateTemp((IEntity)pSPanelEngine2);
        }
    }

    public void removeByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByNo2PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.internalRemoveByNo2PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.onAfterRemoveByNo2PSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo2PSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByNo2PSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByNo2PSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo3PSPanelItem(pSSysViewPanelItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanelItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELENGINE_PSSYSVIEWPANELITEM_NO3PSPANELITEMID", "", iDataEntityModel.getName(), "PSPANELENGINE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanelItem), arrayList.get(0)));
        }
    }

    public void resetNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo3PSPanelItem(pSSysViewPanelItem);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo3PSPanelItemId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void resetTempNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo3PSPanelItem(pSSysViewPanelItem);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo3PSPanelItemId(null);
            this.updateTemp((IEntity)pSPanelEngine2);
        }
    }

    public void removeByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByNo3PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.internalRemoveByNo3PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.onAfterRemoveByNo3PSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo3PSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByNo3PSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByNo3PSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo4PSPanelItem(pSSysViewPanelItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanelItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELENGINE_PSSYSVIEWPANELITEM_NO4PSPANELITEMID", "", iDataEntityModel.getName(), "PSPANELENGINE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanelItem), arrayList.get(0)));
        }
    }

    public void resetNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo4PSPanelItem(pSSysViewPanelItem);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo4PSPanelItemId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void resetTempNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo4PSPanelItem(pSSysViewPanelItem);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo4PSPanelItemId(null);
            this.updateTemp((IEntity)pSPanelEngine2);
        }
    }

    public void removeByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByNo4PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.internalRemoveByNo4PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.onAfterRemoveByNo4PSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo4PSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByNo4PSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByNo4PSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSPanelItem(pSSysViewPanelItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanelItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELENGINE_PSSYSVIEWPANELITEM_PSPANELITEMID", "", iDataEntityModel.getName(), "PSPANELENGINE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanelItem), arrayList.get(0)));
        }
    }

    public void resetPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSPanelItem(pSSysViewPanelItem);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setPSPanelItemId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void resetTempPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByPSPanelItem(pSSysViewPanelItem);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setPSPanelItemId(null);
            this.updateTemp((IEntity)pSPanelEngine2);
        }
    }

    public void removeByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByPSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.internalRemoveByPSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.onAfterRemoveByPSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByPSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByPSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo2PSPanelLogic(pSSysViewPanelLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanelLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELENGINE_PSSYSVIEWPANELLOGIC_NO2PSPANELLOGICID", "", iDataEntityModel.getName(), "PSPANELENGINE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanelLogic), arrayList.get(0)));
        }
    }

    public void resetNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo2PSPanelLogic(pSSysViewPanelLogic);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo2PSPanelLogicId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void resetTempNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo2PSPanelLogic(pSSysViewPanelLogic);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo2PSPanelLogicId(null);
            this.updateTemp((IEntity)pSPanelEngine2);
        }
    }

    public void removeByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByNo2PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.internalRemoveByNo2PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.onAfterRemoveByNo2PSPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo2PSPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveByNo2PSPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByNo2PSPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo3PSPanelLogic(pSSysViewPanelLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanelLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELENGINE_PSSYSVIEWPANELLOGIC_NO3PSPANELLOGICID", "", iDataEntityModel.getName(), "PSPANELENGINE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanelLogic), arrayList.get(0)));
        }
    }

    public void resetNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo3PSPanelLogic(pSSysViewPanelLogic);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo3PSPanelLogicId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void resetTempNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo3PSPanelLogic(pSSysViewPanelLogic);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo3PSPanelLogicId(null);
            this.updateTemp((IEntity)pSPanelEngine2);
        }
    }

    public void removeByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByNo3PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.internalRemoveByNo3PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.onAfterRemoveByNo3PSPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo3PSPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveByNo3PSPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByNo3PSPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo4PSPanelLogic(pSSysViewPanelLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanelLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELENGINE_PSSYSVIEWPANELLOGIC_NO4PSPANELLOGICID", "", iDataEntityModel.getName(), "PSPANELENGINE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanelLogic), arrayList.get(0)));
        }
    }

    public void resetNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo4PSPanelLogic(pSSysViewPanelLogic);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo4PSPanelLogicId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void resetTempNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo4PSPanelLogic(pSSysViewPanelLogic);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setNo4PSPanelLogicId(null);
            this.updateTemp((IEntity)pSPanelEngine2);
        }
    }

    public void removeByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByNo4PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.internalRemoveByNo4PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.onAfterRemoveByNo4PSPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByNo4PSPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveByNo4PSPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByNo4PSPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSPanelLogic(pSSysViewPanelLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanelLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELENGINE_PSSYSVIEWPANELLOGIC_PSPANELLOGICID", "", iDataEntityModel.getName(), "PSPANELENGINE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanelLogic), arrayList.get(0)));
        }
    }

    public void resetPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSPanelLogic(pSSysViewPanelLogic);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setPSPanelLogicId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void resetTempPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByPSPanelLogic(pSSysViewPanelLogic);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setPSPanelLogicId(null);
            this.updateTemp((IEntity)pSPanelEngine2);
        }
    }

    public void removeByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByPSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.internalRemoveByPSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.onAfterRemoveByPSPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveByPSPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByPSPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setPSSysViewPanelId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setPSSysViewPanelId(null);
            this.updateTemp((IEntity)pSPanelEngine2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelEngineServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelEngineServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void testRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
    }

    public void resetPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSUIEngineType(pSUIEngineType);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            PSPanelEngine pSPanelEngine2 = (PSPanelEngine)this.getDEModel().createEntity();
            pSPanelEngine2.setPSPanelEngineId(pSPanelEngine.getPSPanelEngineId());
            pSPanelEngine2.setPSUIEngineTypeId(null);
            this.update(pSPanelEngine2);
        }
    }

    public void removeByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
        final PSUIEngineType pSUIEngineType2 = pSUIEngineType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveByPSUIEngineType(pSUIEngineType2);
                PSPanelEngineServiceBase.this.internalRemoveByPSUIEngineType(pSUIEngineType2);
                PSPanelEngineServiceBase.this.onAfterRemoveByPSUIEngineType(pSUIEngineType2);
            }
        });
    }

    protected void onBeforeRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
    }

    protected void internalRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectByPSUIEngineType(pSUIEngineType);
        this.onBeforeRemoveByPSUIEngineType(pSUIEngineType, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.remove((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveByPSUIEngineType(pSUIEngineType, arrayList);
    }

    protected void onAfterRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
    }

    protected void onBeforeRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPanelEngine pSPanelEngine) throws Exception {
        super.onBeforeRemove(pSPanelEngine);
    }

    public void removeTempByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveTempByNo2PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.internalRemoveTempByNo2PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.onAfterRemoveTempByNo2PSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo2PSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByNo2PSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.removeTemp((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveTempByNo2PSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo2PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void removeTempByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveTempByNo3PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.internalRemoveTempByNo3PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.onAfterRemoveTempByNo3PSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo3PSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByNo3PSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.removeTemp((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveTempByNo3PSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo3PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void removeTempByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveTempByNo4PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.internalRemoveTempByNo4PSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.onAfterRemoveTempByNo4PSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo4PSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByNo4PSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.removeTemp((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveTempByNo4PSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo4PSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void removeTempByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveTempByPSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.internalRemoveTempByPSPanelItem(pSSysViewPanelItem2);
                PSPanelEngineServiceBase.this.onAfterRemoveTempByPSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByPSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByPSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.removeTemp((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveTempByPSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void removeTempByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveTempByNo2PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.internalRemoveTempByNo2PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.onAfterRemoveTempByNo2PSPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveTempByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo2PSPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveTempByNo2PSPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.removeTemp((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveTempByNo2PSPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveTempByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo2PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void removeTempByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveTempByNo3PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.internalRemoveTempByNo3PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.onAfterRemoveTempByNo3PSPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveTempByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo3PSPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveTempByNo3PSPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.removeTemp((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveTempByNo3PSPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveTempByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo3PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void removeTempByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveTempByNo4PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.internalRemoveTempByNo4PSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.onAfterRemoveTempByNo4PSPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveTempByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByNo4PSPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveTempByNo4PSPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.removeTemp((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveTempByNo4PSPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveTempByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo4PSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void removeTempByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveTempByPSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.internalRemoveTempByPSPanelLogic(pSSysViewPanelLogic2);
                PSPanelEngineServiceBase.this.onAfterRemoveTempByPSPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveTempByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByPSPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveTempByPSPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.removeTemp((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveTempByPSPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveTempByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelEngineServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelEngineServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelEngineServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelEngine> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            this.removeTemp((IEntity)pSPanelEngine);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelEngine> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSPanelEngine pSPanelEngine, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPanelEngine, cloneSession);
        if (pSPanelEngine.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSPanelEngine.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSPanelEngine, (PSSysPFPlugin)iEntity);
        }
        if (pSPanelEngine.getNo2PSPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSPanelEngine.getNo2PSPanelItemId())) != null) {
            this.onFillParentInfo_No2PSPanelItem(pSPanelEngine, (PSSysViewPanelItem)iEntity);
        }
        if (pSPanelEngine.getNo3PSPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSPanelEngine.getNo3PSPanelItemId())) != null) {
            this.onFillParentInfo_No3PSPanelItem(pSPanelEngine, (PSSysViewPanelItem)iEntity);
        }
        if (pSPanelEngine.getNo4PSPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSPanelEngine.getNo4PSPanelItemId())) != null) {
            this.onFillParentInfo_No4PSPanelItem(pSPanelEngine, (PSSysViewPanelItem)iEntity);
        }
        if (pSPanelEngine.getPSPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSPanelEngine.getPSPanelItemId())) != null) {
            this.onFillParentInfo_PSPanelItem(pSPanelEngine, (PSSysViewPanelItem)iEntity);
        }
        if (pSPanelEngine.getNo2PSPanelLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELLOGIC", (Object)pSPanelEngine.getNo2PSPanelLogicId())) != null) {
            this.onFillParentInfo_No2PSPanelLogic(pSPanelEngine, (PSSysViewPanelLogic)iEntity);
        }
        if (pSPanelEngine.getNo3PSPanelLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELLOGIC", (Object)pSPanelEngine.getNo3PSPanelLogicId())) != null) {
            this.onFillParentInfo_No3PSPanelLogic(pSPanelEngine, (PSSysViewPanelLogic)iEntity);
        }
        if (pSPanelEngine.getNo4PSPanelLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELLOGIC", (Object)pSPanelEngine.getNo4PSPanelLogicId())) != null) {
            this.onFillParentInfo_No4PSPanelLogic(pSPanelEngine, (PSSysViewPanelLogic)iEntity);
        }
        if (pSPanelEngine.getPSPanelLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELLOGIC", (Object)pSPanelEngine.getPSPanelLogicId())) != null) {
            this.onFillParentInfo_PSPanelLogic(pSPanelEngine, (PSSysViewPanelLogic)iEntity);
        }
        if (pSPanelEngine.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSPanelEngine.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelEngine, (PSSysViewPanel)iEntity);
        }
        if (pSPanelEngine.getPSUIEngineTypeId() != null && (iEntity = cloneSession.getEntity("PSUIENGINETYPE", (Object)pSPanelEngine.getPSUIEngineTypeId())) != null) {
            this.onFillParentInfo_PSUIEngineType(pSPanelEngine, (PSUIEngineType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPanelEngine, bl);
    }

    protected void onCheckEntity(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_EngineOption(bl, pSPanelEngine, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam10(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam10Flag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam10Label(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam2(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam2Flag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam2Label(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam3(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam3Flag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam3Label(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam4(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam4Flag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam4Label(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam5(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam5Flag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam5Label(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam6(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam6Flag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam6Label(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam7(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam7Flag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam7Label(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam8(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam8Flag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam8Label(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam9(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam9Flag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam9Label(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParamFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParamLabel(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PanelItemFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PanelItemLabel(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PanelLogicFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PanelLogicLabel(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSPanelItemId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSPanelItemName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSPanelLogicId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSPanelLogicName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PanelItemFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PanelItemLabel(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PanelLogicFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PanelLogicLabel(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSPanelItemId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSPanelItemName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSPanelLogicId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSPanelLogicName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PanelItemFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PanelItemLabel(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PanelLogicFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PanelLogicLabel(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSPanelItemId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSPanelItemName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSPanelLogicId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSPanelLogicName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelItemFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelItemLabel(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelLogicFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelLogicLabel(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelEngineId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelEngineName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelItemId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelItemName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUIEngineTypeId(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUIEngineTypeName(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam10(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam2(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam3(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam4(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam5(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam6(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam7(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam8(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam9(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam2(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam3(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam4(bl, pSPanelEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPanelEngine, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_EngineOption(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineOptionDirty() : !pSPanelEngine.isEngineOptionDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineOption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineOption_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEOPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParamDirty() : !pSPanelEngine.isEngineParamDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam10(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam10Dirty() : !pSPanelEngine.isEngineParam10Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam10_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam10Flag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam10FlagDirty() : !pSPanelEngine.isEngineParam10FlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam10Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam10Flag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM10FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam10Label(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam10LabelDirty() : !pSPanelEngine.isEngineParam10LabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam10Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam10Label_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM10LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam2(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam2Dirty() : !pSPanelEngine.isEngineParam2Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam2_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam2Flag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam2FlagDirty() : !pSPanelEngine.isEngineParam2FlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam2Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam2Flag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM2FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam2Label(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam2LabelDirty() : !pSPanelEngine.isEngineParam2LabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam2Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam2Label_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM2LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam3(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam3Dirty() : !pSPanelEngine.isEngineParam3Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam3_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam3Flag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam3FlagDirty() : !pSPanelEngine.isEngineParam3FlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam3Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam3Flag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM3FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam3Label(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam3LabelDirty() : !pSPanelEngine.isEngineParam3LabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam3Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam3Label_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM3LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam4(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam4Dirty() : !pSPanelEngine.isEngineParam4Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam4_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam4Flag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam4FlagDirty() : !pSPanelEngine.isEngineParam4FlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam4Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam4Flag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM4FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam4Label(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam4LabelDirty() : !pSPanelEngine.isEngineParam4LabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam4Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam4Label_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM4LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam5(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam5Dirty() : !pSPanelEngine.isEngineParam5Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam5_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam5Flag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam5FlagDirty() : !pSPanelEngine.isEngineParam5FlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam5Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam5Flag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM5FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam5Label(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam5LabelDirty() : !pSPanelEngine.isEngineParam5LabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam5Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam5Label_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM5LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam6(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam6Dirty() : !pSPanelEngine.isEngineParam6Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam6_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam6Flag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam6FlagDirty() : !pSPanelEngine.isEngineParam6FlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam6Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam6Flag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM6FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam6Label(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam6LabelDirty() : !pSPanelEngine.isEngineParam6LabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam6Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam6Label_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM6LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam7(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam7Dirty() : !pSPanelEngine.isEngineParam7Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam7_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam7Flag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam7FlagDirty() : !pSPanelEngine.isEngineParam7FlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam7Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam7Flag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM7FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam7Label(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam7LabelDirty() : !pSPanelEngine.isEngineParam7LabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam7Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam7Label_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM7LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam8(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam8Dirty() : !pSPanelEngine.isEngineParam8Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam8_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam8Flag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam8FlagDirty() : !pSPanelEngine.isEngineParam8FlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam8Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam8Flag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM8FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam8Label(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam8LabelDirty() : !pSPanelEngine.isEngineParam8LabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam8Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam8Label_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM8LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam9(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam9Dirty() : !pSPanelEngine.isEngineParam9Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam9_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam9Flag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam9FlagDirty() : !pSPanelEngine.isEngineParam9FlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParam9Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam9Flag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM9FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam9Label(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParam9LabelDirty() : !pSPanelEngine.isEngineParam9LabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParam9Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam9Label_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM9LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParamFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParamFlagDirty() : !pSPanelEngine.isEngineParamFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getEngineParamFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParamFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParamLabel(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isEngineParamLabelDirty() : !pSPanelEngine.isEngineParamLabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getEngineParamLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParamLabel_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAMLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isMemoDirty() : !pSPanelEngine.isMemoDirty()) {
            return null;
        }
        String string = pSPanelEngine.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_No2PanelItemFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo2PanelItemFlagDirty() : !pSPanelEngine.isNo2PanelItemFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getNo2PanelItemFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No2PanelItemFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PANELITEMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PanelItemLabel(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo2PanelItemLabelDirty() : !pSPanelEngine.isNo2PanelItemLabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo2PanelItemLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PanelItemLabel_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PANELITEMLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PanelLogicFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo2PanelLogicFlagDirty() : !pSPanelEngine.isNo2PanelLogicFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getNo2PanelLogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No2PanelLogicFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PANELLOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PanelLogicLabel(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo2PanelLogicLabelDirty() : !pSPanelEngine.isNo2PanelLogicLabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo2PanelLogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PanelLogicLabel_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PANELLOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSPanelItemId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo2PSPanelItemIdDirty() : !pSPanelEngine.isNo2PSPanelItemIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo2PSPanelItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSPanelItemId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSPANELITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSPanelItemName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo2PSPanelItemNameDirty() : !pSPanelEngine.isNo2PSPanelItemNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo2PSPanelItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSPanelItemName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSPANELITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSPanelLogicId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo2PSPanelLogicIdDirty() : !pSPanelEngine.isNo2PSPanelLogicIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo2PSPanelLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSPanelLogicId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSPANELLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSPanelLogicName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo2PSPanelLogicNameDirty() : !pSPanelEngine.isNo2PSPanelLogicNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo2PSPanelLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSPanelLogicName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSPANELLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PanelItemFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo3PanelItemFlagDirty() : !pSPanelEngine.isNo3PanelItemFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getNo3PanelItemFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No3PanelItemFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PANELITEMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PanelItemLabel(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo3PanelItemLabelDirty() : !pSPanelEngine.isNo3PanelItemLabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo3PanelItemLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PanelItemLabel_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PANELITEMLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PanelLogicFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo3PanelLogicFlagDirty() : !pSPanelEngine.isNo3PanelLogicFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getNo3PanelLogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No3PanelLogicFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PANELLOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PanelLogicLabel(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo3PanelLogicLabelDirty() : !pSPanelEngine.isNo3PanelLogicLabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo3PanelLogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PanelLogicLabel_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PANELLOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PSPanelItemId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo3PSPanelItemIdDirty() : !pSPanelEngine.isNo3PSPanelItemIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo3PSPanelItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSPanelItemId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSPANELITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PSPanelItemName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo3PSPanelItemNameDirty() : !pSPanelEngine.isNo3PSPanelItemNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo3PSPanelItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSPanelItemName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSPANELITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PSPanelLogicId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo3PSPanelLogicIdDirty() : !pSPanelEngine.isNo3PSPanelLogicIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo3PSPanelLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSPanelLogicId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSPANELLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PSPanelLogicName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo3PSPanelLogicNameDirty() : !pSPanelEngine.isNo3PSPanelLogicNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo3PSPanelLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSPanelLogicName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSPANELLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PanelItemFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo4PanelItemFlagDirty() : !pSPanelEngine.isNo4PanelItemFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getNo4PanelItemFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No4PanelItemFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PANELITEMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PanelItemLabel(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo4PanelItemLabelDirty() : !pSPanelEngine.isNo4PanelItemLabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo4PanelItemLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PanelItemLabel_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PANELITEMLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PanelLogicFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo4PanelLogicFlagDirty() : !pSPanelEngine.isNo4PanelLogicFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getNo4PanelLogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No4PanelLogicFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PANELLOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PanelLogicLabel(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo4PanelLogicLabelDirty() : !pSPanelEngine.isNo4PanelLogicLabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo4PanelLogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PanelLogicLabel_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PANELLOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSPanelItemId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo4PSPanelItemIdDirty() : !pSPanelEngine.isNo4PSPanelItemIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo4PSPanelItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSPanelItemId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSPANELITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSPanelItemName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo4PSPanelItemNameDirty() : !pSPanelEngine.isNo4PSPanelItemNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo4PSPanelItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSPanelItemName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSPANELITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSPanelLogicId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo4PSPanelLogicIdDirty() : !pSPanelEngine.isNo4PSPanelLogicIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo4PSPanelLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSPanelLogicId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSPANELLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSPanelLogicName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isNo4PSPanelLogicNameDirty() : !pSPanelEngine.isNo4PSPanelLogicNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getNo4PSPanelLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSPanelLogicName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSPANELLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isOrderValueDirty() : !pSPanelEngine.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_PanelItemFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPanelItemFlagDirty() : !pSPanelEngine.isPanelItemFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getPanelItemFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PanelItemFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELITEMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelItemLabel(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPanelItemLabelDirty() : !pSPanelEngine.isPanelItemLabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPanelItemLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PanelItemLabel_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELITEMLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelLogicFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPanelLogicFlagDirty() : !pSPanelEngine.isPanelLogicFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getPanelLogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PanelLogicFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELLOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelLogicLabel(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPanelLogicLabelDirty() : !pSPanelEngine.isPanelLogicLabelDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPanelLogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PanelLogicLabel_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELLOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelEngineId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSPanelEngineIdDirty() && !bl2 : !pSPanelEngine.isPSPanelEngineIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSPanelEngineId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELENGINEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelEngineId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELENGINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelEngineName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSPanelEngineNameDirty() && !bl2 : !pSPanelEngine.isPSPanelEngineNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSPanelEngineName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELENGINENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelEngineName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELENGINENAME");
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
                string3 = "PSSYSVIEWPANELID";
                String string4 = this.checkFieldDupRule(this.getPSPanelEngineDEModel(), "PSPANELENGINENAME", string3, pSPanelEngine, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSPANELENGINENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelItemId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSPanelItemIdDirty() : !pSPanelEngine.isPSPanelItemIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSPanelItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelItemId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelItemName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSPanelItemNameDirty() : !pSPanelEngine.isPSPanelItemNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSPanelItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelItemName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSPanelLogicIdDirty() : !pSPanelEngine.isPSPanelLogicIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSPanelLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSPanelLogicNameDirty() : !pSPanelEngine.isPSPanelLogicNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSPanelLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSSysPFPluginIdDirty() : !pSPanelEngine.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSSysViewPanelIdDirty() : !pSPanelEngine.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSUIEngineTypeId(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSUIEngineTypeIdDirty() : !pSPanelEngine.isPSUIEngineTypeIdDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSUIEngineTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeId_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUIEngineTypeName(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isPSUIEngineTypeNameDirty() && !bl2 : !pSPanelEngine.isPSUIEngineTypeNameDirty()) {
            return null;
        }
        String string = pSPanelEngine.getPSUIEngineTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeName_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isUserCatDirty() : !pSPanelEngine.isUserCatDirty()) {
            return null;
        }
        String string = pSPanelEngine.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isUserTagDirty() : !pSPanelEngine.isUserTagDirty()) {
            return null;
        }
        String string = pSPanelEngine.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isUserTag2Dirty() : !pSPanelEngine.isUserTag2Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isUserTag3Dirty() : !pSPanelEngine.isUserTag3Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isUserTag4Dirty() : !pSPanelEngine.isUserTag4Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isValidFlagDirty() : !pSPanelEngine.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSPanelEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewParam(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParamDirty() : !pSPanelEngine.isViewParamDirty()) {
            return null;
        }
        String string = pSPanelEngine.getViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam10(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParam10Dirty() : !pSPanelEngine.isViewParam10Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getViewParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam10_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam2(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParam2Dirty() : !pSPanelEngine.isViewParam2Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getViewParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam2_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam3(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParam3Dirty() : !pSPanelEngine.isViewParam3Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getViewParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam3_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam4(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParam4Dirty() : !pSPanelEngine.isViewParam4Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getViewParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam4_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam5(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParam5Dirty() : !pSPanelEngine.isViewParam5Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getViewParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam5_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam6(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParam6Dirty() : !pSPanelEngine.isViewParam6Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getViewParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam6_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam7(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParam7Dirty() : !pSPanelEngine.isViewParam7Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getViewParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam7_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam8(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParam8Dirty() : !pSPanelEngine.isViewParam8Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getViewParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam8_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam9(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isViewParam9Dirty() : !pSPanelEngine.isViewParam9Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getViewParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam9_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isWFViewParamDirty() : !pSPanelEngine.isWFViewParamDirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getWFViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFViewParam_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam2(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isWFViewParam2Dirty() : !pSPanelEngine.isWFViewParam2Dirty()) {
            return null;
        }
        Integer n = pSPanelEngine.getWFViewParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFViewParam2_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam3(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isWFViewParam3Dirty() : !pSPanelEngine.isWFViewParam3Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getWFViewParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFViewParam3_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam4(boolean bl, PSPanelEngine pSPanelEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelEngine.isWFViewParam4Dirty() : !pSPanelEngine.isWFViewParam4Dirty()) {
            return null;
        }
        String string = pSPanelEngine.getWFViewParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFViewParam4_Default((IEntity)pSPanelEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPanelEngine, bl);
    }

    protected void onSyncIndexEntities(PSPanelEngine pSPanelEngine, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPanelEngine, bl);
    }

    public Object getDataContextValue(PSPanelEngine pSPanelEngine, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPanelEngine, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysViewPanel pSSysViewPanel = pSPanelEngine.getPSSysViewPanel();
        if (pSSysViewPanel != null && pSSysViewPanel.contains(string)) {
            return pSSysViewPanel.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPanelEngine pSPanelEngine, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPanelEngine, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEOPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineOption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM10FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam10Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM10LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam10Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM2FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam2Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM2LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam2Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM3FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam3Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM3LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam3Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM4FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam4Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM4LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam4Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM5FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam5Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM5LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam5Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM6FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam6Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM6LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam6Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM7FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam7Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM7LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam7Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM8FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam8Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM8LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam8Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM9FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam9Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM9LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam9Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParamFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAMLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParamLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PANELITEMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PanelItemFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PANELITEMLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PanelItemLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PANELLOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PanelLogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PANELLOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PanelLogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSPANELLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSPanelLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSPANELLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSPanelLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PANELITEMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PanelItemFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PANELITEMLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PanelItemLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PANELLOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PanelLogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PANELLOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PanelLogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSPANELLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSPanelLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSPANELLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSPanelLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PANELITEMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PanelItemFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PANELITEMLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PanelItemLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PANELLOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PanelLogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PANELLOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PanelLogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSPANELLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSPanelLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSPANELLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSPanelLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELITEMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelItemFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELITEMLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelItemLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELLOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelLogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELLOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelLogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELENGINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelEngineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELENGINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelEngineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_EngineOption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEOPTION", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam10Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam10Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM10LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam2Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam2Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM2LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam3Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam3Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM3LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam4Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam4Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM4LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam5Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam5Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM5LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam6Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam6Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM6LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam7Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam7Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM7LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam8Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam8Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM8LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam9Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam9Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM9LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParamFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParamLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAMLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PanelItemFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No2PanelItemLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PANELITEMLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PanelLogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No2PanelLogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PANELLOGICLABEL", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSPanelItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSPANELITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSPanelItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSPANELITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSPanelLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSPANELLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSPanelLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSPANELLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PanelItemFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No3PanelItemLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PANELITEMLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PanelLogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No3PanelLogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PANELLOGICLABEL", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PSPanelItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSPANELITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PSPanelItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSPANELITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PSPanelLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSPANELLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PSPanelLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSPANELLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PanelItemFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No4PanelItemLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PANELITEMLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PanelLogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No4PanelLogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PANELLOGICLABEL", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSPanelItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSPANELITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSPanelItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSPANELITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSPanelLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSPANELLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSPanelLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSPANELLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PanelItemFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PanelItemLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PANELITEMLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PanelLogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PanelLogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PANELLOGICLABEL", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelEngineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELENGINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelEngineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELENGINENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSPANELENGINENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSUIEngineTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUIENGINETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUIEngineTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUIENGINETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM2", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM7", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM8", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVIEWPARAM3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFViewParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVIEWPARAM4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPanelEngine pSPanelEngine) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPanelEngine)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPanelEngine pSPanelEngine) throws Exception {
        super.onUpdateParent((IEntity)pSPanelEngine);
    }

    @Override
    protected void exportCurXmlModel(PSPanelEngine pSPanelEngine, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPANELENGINE");
        if (!bl) {
            pSPanelEngine.setCreateDate(null);
            pSPanelEngine.setCreateMan(null);
            pSPanelEngine.setPSPanelEngineId(null);
            pSPanelEngine.setUpdateDate(null);
            pSPanelEngine.setUpdateMan(null);
            pSPanelEngine.setNo2PSPanelItemId(null);
            pSPanelEngine.setNo3PSPanelItemId(null);
            pSPanelEngine.setNo4PSPanelItemId(null);
            pSPanelEngine.setPSPanelItemId(null);
            pSPanelEngine.setNo2PSPanelLogicId(null);
            pSPanelEngine.setNo3PSPanelLogicId(null);
            pSPanelEngine.setNo4PSPanelLogicId(null);
            pSPanelEngine.setPSPanelLogicId(null);
            pSPanelEngine.setPSSysViewPanelId(null);
            pSPanelEngine.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSPanelEngine, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSPanelEngine pSPanelEngine, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSPanelEngine, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSPANELENGINE_PSSYSVIEWPANEL_PSSYSVIEWPANELID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            iEntity.set("PSSYSVIEWPANELID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSVIEWPANELID"};
    }

    @Override
    public String getModelV2Tag(PSPanelEngine pSPanelEngine) {
        if (!StringHelper.isNullOrEmpty((String)pSPanelEngine.getPSPanelEngineName())) {
            return pSPanelEngine.getPSPanelEngineName();
        }
        return super.getModelV2Tag(pSPanelEngine);
    }

    @Override
    public boolean setModelV2Tag(PSPanelEngine pSPanelEngine, String string) {
        pSPanelEngine.setPSPanelEngineName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSPANELENGINENAME", "");
        map.put("PSSYSVIEWPANELID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSPanelEngine pSPanelEngine, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSPanelEngine.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSPanelEngine, true);
        pSPanelEngine.set("PSPANELENGINENAME", string);
        if (this.select(pSPanelEngine, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSPanelEngine, true);
        return super.getModelV2Entity(pSPanelEngine, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSPanelEngine pSPanelEngine, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSPanelEngine, objectNode, string, string2, n);
    }
}

