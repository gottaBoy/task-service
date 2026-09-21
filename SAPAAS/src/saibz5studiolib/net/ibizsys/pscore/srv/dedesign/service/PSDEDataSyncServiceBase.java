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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDataSyncDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataSyncDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSync;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgentBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataSyncServiceBase
extends PSCoreSysServiceBase<PSDEDataSync> {
    private static final Log log = LogFactory.getLog(PSDEDataSyncServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDEIN = "CurDEIn";
    public static final String DATASET_CURDEOUT = "CurDEOut";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEDataSyncDEModel pSDEDataSyncDEModel;
    private PSDEDataSyncDAO pSDEDataSyncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService";
    }

    public PSDEDataSyncDEModel getPSDEDataSyncDEModel() {
        if (this.pSDEDataSyncDEModel == null) {
            try {
                this.pSDEDataSyncDEModel = (PSDEDataSyncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataSyncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataSyncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDataSyncDEModel();
    }

    public PSDEDataSyncDAO getPSDEDataSyncDAO() {
        if (this.pSDEDataSyncDAO == null) {
            try {
                this.pSDEDataSyncDAO = (PSDEDataSyncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDataSyncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataSyncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDataSyncDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEIN, (boolean)true) == 0) {
            return this.fetchCurDEIn(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEOUT, (boolean)true) == 0) {
            return this.fetchCurDEOut(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEIn(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEIN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEOut(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEOUT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEDataSync pSDEDataSync, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDataSync, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSDEACTION_IMPORTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_ImportPSDEAction(pSDEDataSync, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSDEACTION_INPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_InPSDEAction(pSDEDataSync, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSDEACTION_OUTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_OutPSDEAction(pSDEDataSync, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSDEDATASET_INPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_InPSDEDataSet(pSDEDataSync, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSDEDATASET_OUTPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_OutPSDEDataSet(pSDEDataSync, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSSYSDATASYNCAGENT_INPSSYSDATASYNCAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService", (SessionFactory)this.getSessionFactory());
            PSSysDataSyncAgent pSSysDataSyncAgent = (PSSysDataSyncAgent)iService.getDEModel().createEntity();
            pSSysDataSyncAgent.set("PSSYSDATASYNCAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDataSyncAgent);
            } else {
                iService.get((IEntity)pSSysDataSyncAgent);
            }
            this.onFillParentInfo_InPSSysDataSyncAgent(pSDEDataSync, pSSysDataSyncAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSSYSDATASYNCAGENT_OUTPSSYSDATASYNCAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService", (SessionFactory)this.getSessionFactory());
            PSSysDataSyncAgent pSSysDataSyncAgent = (PSSysDataSyncAgent)iService.getDEModel().createEntity();
            pSSysDataSyncAgent.set("PSSYSDATASYNCAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDataSyncAgent);
            } else {
                iService.get((IEntity)pSSysDataSyncAgent);
            }
            this.onFillParentInfo_OutPSSysDataSyncAgent(pSDEDataSync, pSSysDataSyncAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEDataSync, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASYNC_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEDataSync, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDataSync, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEDataSync pSDEDataSync, PSDataEntity pSDataEntity) throws Exception {
        pSDEDataSync.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDataSync.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_ImportPSDEAction(PSDEDataSync pSDEDataSync, PSDEAction pSDEAction) throws Exception {
        pSDEDataSync.setImportPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataSync.setImportPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_InPSDEAction(PSDEDataSync pSDEDataSync, PSDEAction pSDEAction) throws Exception {
        pSDEDataSync.setInPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataSync.setInPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_OutPSDEAction(PSDEDataSync pSDEDataSync, PSDEAction pSDEAction) throws Exception {
        pSDEDataSync.setOutPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataSync.setOutPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_InPSDEDataSet(PSDEDataSync pSDEDataSync, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEDataSync.setInPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEDataSync.setInPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_OutPSDEDataSet(PSDEDataSync pSDEDataSync, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEDataSync.setOutPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEDataSync.setOutPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_InPSSysDataSyncAgent(PSDEDataSync pSDEDataSync, PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        pSDEDataSync.setInPSSysDataSyncAgentId(pSSysDataSyncAgent.getPSSysDataSyncAgentId());
        pSDEDataSync.setInPSSysDataSyncAgentName(pSSysDataSyncAgent.getPSSysDataSyncAgentName());
    }

    protected void onFillParentInfo_OutPSSysDataSyncAgent(PSDEDataSync pSDEDataSync, PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        pSDEDataSync.setOutPSSysDataSyncAgentId(pSSysDataSyncAgent.getPSSysDataSyncAgentId());
        pSDEDataSync.setOutPSSysDataSyncAgentName(pSSysDataSyncAgent.getPSSysDataSyncAgentName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEDataSync pSDEDataSync, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEDataSync.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEDataSync.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEDataSync pSDEDataSync, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEDataSync.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEDataSync.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDataSync.getCodeName() == null) {
                pSDEDataSync.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DataSync", 25));
            }
            if (pSDEDataSync.getValidFlag() == null) {
                pSDEDataSync.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEDataSync, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDataSync, bl);
        this.onFillEntityFullInfo_ImportPSDEAction(pSDEDataSync, bl);
        this.onFillEntityFullInfo_InPSDEAction(pSDEDataSync, bl);
        this.onFillEntityFullInfo_OutPSDEAction(pSDEDataSync, bl);
        this.onFillEntityFullInfo_InPSDEDataSet(pSDEDataSync, bl);
        this.onFillEntityFullInfo_OutPSDEDataSet(pSDEDataSync, bl);
        this.onFillEntityFullInfo_InPSSysDataSyncAgent(pSDEDataSync, bl);
        this.onFillEntityFullInfo_OutPSSysDataSyncAgent(pSDEDataSync, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEDataSync, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEDataSync, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
        if (pSDEDataSync.isPSDEIdDirty()) {
            if (pSDEDataSync.getPSDEId() != null) {
                if (pSDEDataSync.getPSDEId() == null || pSDEDataSync.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDataSync.getPSDE();
                    pSDEDataSync.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEDataSync.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ImportPSDEAction(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSDEAction(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSDEAction(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSDEDataSet(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSDEDataSet(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSSysDataSyncAgent(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSSysDataSyncAgent(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDataSync, bl);
    }

    public ArrayList<PSDEDataSync> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataSync> selectByImportPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByImportPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByImportPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByImportPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByImportPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("IMPORTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByImportPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByImportPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSync> selectByInPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByInPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByInPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByInPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByInPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSync> selectByOutPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByOutPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByOutPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByOutPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByOutPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSync> selectByInPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByInPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByInPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByInPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByInPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSync> selectByOutPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByOutPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByOutPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByOutPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByOutPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSync> selectByInPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase) throws Exception {
        return this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgentBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByInPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string) throws Exception {
        return this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgentBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByInPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSSYSDATASYNCAGENTID", (Object)pSSysDataSyncAgentBase.getPSSysDataSyncAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSSysDataSyncAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSSysDataSyncAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSync> selectByOutPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase) throws Exception {
        return this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgentBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByOutPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string) throws Exception {
        return this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgentBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByOutPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSSYSDATASYNCAGENTID", (Object)pSSysDataSyncAgentBase.getPSSysDataSyncAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSSysDataSyncAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSSysDataSyncAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSync> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSREQITEMID", (Object)pSSysReqItemBase.getPSSysReqItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysReqItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysReqItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSync> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEDataSync> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEDataSync> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setPSDEId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDataSyncServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    public void testRemoveByImportPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByImportPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASYNC_PSDEACTION_IMPORTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATASYNC", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetImportPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByImportPSDEAction(pSDEAction);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setImportPSDEActionId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByImportPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByImportPSDEAction(pSDEAction2);
                PSDEDataSyncServiceBase.this.internalRemoveByImportPSDEAction(pSDEAction2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByImportPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByImportPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByImportPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByImportPSDEAction(pSDEAction);
        this.onBeforeRemoveByImportPSDEAction(pSDEAction, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByImportPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByImportPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByImportPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByImportPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    public void testRemoveByInPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByInPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASYNC_PSDEACTION_INPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATASYNC", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetInPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByInPSDEAction(pSDEAction);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setInPSDEActionId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByInPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByInPSDEAction(pSDEAction2);
                PSDEDataSyncServiceBase.this.internalRemoveByInPSDEAction(pSDEAction2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByInPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByInPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByInPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByInPSDEAction(pSDEAction);
        this.onBeforeRemoveByInPSDEAction(pSDEAction, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByInPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByInPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByInPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    public void testRemoveByOutPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByOutPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASYNC_PSDEACTION_OUTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATASYNC", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetOutPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByOutPSDEAction(pSDEAction);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setOutPSDEActionId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByOutPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByOutPSDEAction(pSDEAction2);
                PSDEDataSyncServiceBase.this.internalRemoveByOutPSDEAction(pSDEAction2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByOutPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByOutPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByOutPSDEAction(pSDEAction);
        this.onBeforeRemoveByOutPSDEAction(pSDEAction, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByOutPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByOutPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByOutPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    public void testRemoveByInPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByInPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASYNC_PSDEDATASET_INPSDEDATASETID", "", iDataEntityModel.getName(), "PSDEDATASYNC", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetInPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByInPSDEDataSet(pSDEDataSet);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setInPSDEDataSetId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByInPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByInPSDEDataSet(pSDEDataSet2);
                PSDEDataSyncServiceBase.this.internalRemoveByInPSDEDataSet(pSDEDataSet2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByInPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByInPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByInPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByInPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByInPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByInPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByInPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByInPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    public void testRemoveByOutPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByOutPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASYNC_PSDEDATASET_OUTPSDEDATASETID", "", iDataEntityModel.getName(), "PSDEDATASYNC", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetOutPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByOutPSDEDataSet(pSDEDataSet);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setOutPSDEDataSetId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByOutPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByOutPSDEDataSet(pSDEDataSet2);
                PSDEDataSyncServiceBase.this.internalRemoveByOutPSDEDataSet(pSDEDataSet2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByOutPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByOutPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByOutPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByOutPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByOutPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByOutPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByOutPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    public void testRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDATASYNCAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDataSyncAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASYNC_PSSYSDATASYNCAGENT_INPSSYSDATASYNCAGENTID", "", iDataEntityModel.getName(), "PSDEDATASYNC", iDataEntityModel.getDataInfo((IEntity)pSSysDataSyncAgent), arrayList.get(0)));
        }
    }

    public void resetInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgent);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setInPSSysDataSyncAgentId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        final PSSysDataSyncAgent pSSysDataSyncAgent2 = pSSysDataSyncAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent2);
                PSDEDataSyncServiceBase.this.internalRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent2);
            }
        });
    }

    protected void onBeforeRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void internalRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgent);
        this.onBeforeRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent, arrayList);
    }

    protected void onAfterRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void onBeforeRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    public void testRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDATASYNCAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDataSyncAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASYNC_PSSYSDATASYNCAGENT_OUTPSSYSDATASYNCAGENTID", "", iDataEntityModel.getName(), "PSDEDATASYNC", iDataEntityModel.getDataInfo((IEntity)pSSysDataSyncAgent), arrayList.get(0)));
        }
    }

    public void resetOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgent);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setOutPSSysDataSyncAgentId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        final PSSysDataSyncAgent pSSysDataSyncAgent2 = pSSysDataSyncAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent2);
                PSDEDataSyncServiceBase.this.internalRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void internalRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgent);
        this.onBeforeRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent, arrayList);
    }

    protected void onAfterRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void onBeforeRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASYNC_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEDATASYNC", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setPSSysReqItemId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEDataSyncServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASYNC_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEDATASYNC", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            PSDEDataSync pSDEDataSync2 = (PSDEDataSync)this.getDEModel().createEntity();
            pSDEDataSync2.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
            pSDEDataSync2.setPSSysSFPluginId(null);
            this.update(pSDEDataSync2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSyncServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEDataSyncServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEDataSyncServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDataSync> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEDataSync pSDEDataSync : arrayList) {
            this.remove((IEntity)pSDEDataSync);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEDataSync> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDataSync pSDEDataSync) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSync(pSDEDataSync);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEDataSync(pSDEDataSync);
        super.onBeforeRemove(pSDEDataSync);
    }

    protected void replaceParentInfo(PSDEDataSync pSDEDataSync, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDataSync, cloneSession);
        if (pSDEDataSync.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDataSync.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDataSync, (PSDataEntity)iEntity);
        }
        if (pSDEDataSync.getImportPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataSync.getImportPSDEActionId())) != null) {
            this.onFillParentInfo_ImportPSDEAction(pSDEDataSync, (PSDEAction)iEntity);
        }
        if (pSDEDataSync.getInPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataSync.getInPSDEActionId())) != null) {
            this.onFillParentInfo_InPSDEAction(pSDEDataSync, (PSDEAction)iEntity);
        }
        if (pSDEDataSync.getOutPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataSync.getOutPSDEActionId())) != null) {
            this.onFillParentInfo_OutPSDEAction(pSDEDataSync, (PSDEAction)iEntity);
        }
        if (pSDEDataSync.getInPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEDataSync.getInPSDEDataSetId())) != null) {
            this.onFillParentInfo_InPSDEDataSet(pSDEDataSync, (PSDEDataSet)iEntity);
        }
        if (pSDEDataSync.getOutPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEDataSync.getOutPSDEDataSetId())) != null) {
            this.onFillParentInfo_OutPSDEDataSet(pSDEDataSync, (PSDEDataSet)iEntity);
        }
        if (pSDEDataSync.getInPSSysDataSyncAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSDATASYNCAGENT", (Object)pSDEDataSync.getInPSSysDataSyncAgentId())) != null) {
            this.onFillParentInfo_InPSSysDataSyncAgent(pSDEDataSync, (PSSysDataSyncAgent)iEntity);
        }
        if (pSDEDataSync.getOutPSSysDataSyncAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSDATASYNCAGENT", (Object)pSDEDataSync.getOutPSSysDataSyncAgentId())) != null) {
            this.onFillParentInfo_OutPSSysDataSyncAgent(pSDEDataSync, (PSSysDataSyncAgent)iEntity);
        }
        if (pSDEDataSync.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEDataSync.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEDataSync, (PSSysReqItem)iEntity);
        }
        if (pSDEDataSync.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEDataSync.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEDataSync, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDataSync, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEDataSync, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DENames(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventType(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportFull(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilterModel(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImportPSDEActionId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InCustomCode(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InCustomMode(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSDEActionId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSDEDataSetId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSSysDataSyncAgentId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutCustomCode(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutCustomMode(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutMode(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSDEActionId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSDEDataSetId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSSysDataSyncAgentId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutTimer(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSyncId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSyncName(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncDir(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncExport(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimerMode(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEDataSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDataSync, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isCodeNameDirty() && !bl2 : !pSDEDataSync.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDataSync.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEDataSync, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEDataSyncDEModel(), "CODENAME", string3, pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_DENames(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isDENamesDirty() : !pSDEDataSync.isDENamesDirty()) {
            return null;
        }
        String string = pSDEDataSync.getDENames();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DENames_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DENAMES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isDynaModelFlagDirty() : !pSDEDataSync.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventType(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isEventTypeDirty() && !bl2 : !pSDEDataSync.isEventTypeDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getEventType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EventType_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportFull(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isExportFullDirty() : !pSDEDataSync.isExportFullDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getExportFull();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportFull_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTFULL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FilterModel(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isFilterModelDirty() : !pSDEDataSync.isFilterModelDirty()) {
            return null;
        }
        String string = pSDEDataSync.getFilterModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilterModel_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILTERMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImportPSDEActionId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isImportPSDEActionIdDirty() : !pSDEDataSync.isImportPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getImportPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ImportPSDEActionId_ImportPSDEAction((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPORTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_ImportPSDEActionId_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPORTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InCustomCode(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isInCustomCodeDirty() : !pSDEDataSync.isInCustomCodeDirty()) {
            return null;
        }
        String string = pSDEDataSync.getInCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InCustomCode_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InCustomMode(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isInCustomModeDirty() : !pSDEDataSync.isInCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getInCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InCustomMode_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSDEActionId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isInPSDEActionIdDirty() : !pSDEDataSync.isInPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getInPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSDEActionId_InPSDEAction((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_InPSDEActionId_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSDEDataSetId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isInPSDEDataSetIdDirty() : !pSDEDataSync.isInPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getInPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSDEDataSetId_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSSysDataSyncAgentId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isInPSSysDataSyncAgentIdDirty() : !pSDEDataSync.isInPSSysDataSyncAgentIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getInPSSysDataSyncAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSSysDataSyncAgentId_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSSYSDATASYNCAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isLockFlagDirty() : !pSDEDataSync.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isMemoDirty() : !pSDEDataSync.isMemoDirty()) {
            return null;
        }
        String string = pSDEDataSync.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_OutCustomCode(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isOutCustomCodeDirty() : !pSDEDataSync.isOutCustomCodeDirty()) {
            return null;
        }
        String string = pSDEDataSync.getOutCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutCustomCode_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTCUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutCustomMode(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isOutCustomModeDirty() : !pSDEDataSync.isOutCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getOutCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OutCustomMode_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTCUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutMode(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isOutModeDirty() : !pSDEDataSync.isOutModeDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getOutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OutMode_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSDEActionId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isOutPSDEActionIdDirty() : !pSDEDataSync.isOutPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getOutPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSDEActionId_OutPSDEAction((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_OutPSDEActionId_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSDEDataSetId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isOutPSDEDataSetIdDirty() : !pSDEDataSync.isOutPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getOutPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSDEDataSetId_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSSysDataSyncAgentId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isOutPSSysDataSyncAgentIdDirty() : !pSDEDataSync.isOutPSSysDataSyncAgentIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getOutPSSysDataSyncAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSSysDataSyncAgentId_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSSYSDATASYNCAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutTimer(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isOutTimerDirty() : !pSDEDataSync.isOutTimerDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getOutTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OutTimer_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTTIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSyncId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isPSDEDataSyncIdDirty() && !bl2 : !pSDEDataSync.isPSDEDataSyncIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getPSDEDataSyncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASYNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSyncId_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASYNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSyncName(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isPSDEDataSyncNameDirty() && !bl2 : !pSDEDataSync.isPSDEDataSyncNameDirty()) {
            return null;
        }
        String string = pSDEDataSync.getPSDEDataSyncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASYNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSyncName_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASYNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isPSDEIdDirty() && !bl2 : !pSDEDataSync.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isPSDENameDirty() && !bl2 : !pSDEDataSync.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEDataSync.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isPSDynaInstIdDirty() : !pSDEDataSync.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isPSSysReqItemIdDirty() : !pSDEDataSync.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isPSSysSFPluginIdDirty() : !pSDEDataSync.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDataSync.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_SyncDir(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isSyncDirDirty() && !bl2 : !pSDEDataSync.isSyncDirDirty()) {
            return null;
        }
        String string = pSDEDataSync.getSyncDir();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDIR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncDir_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncExport(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isSyncExportDirty() : !pSDEDataSync.isSyncExportDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getSyncExport();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncExport_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCEXPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimerMode(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isTimerModeDirty() : !pSDEDataSync.isTimerModeDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getTimerMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TimerMode_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isToDoTaskDirty() : !pSDEDataSync.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEDataSync.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSDEDataSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TODOTASK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isUserCatDirty() : !pSDEDataSync.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDataSync.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isUserTagDirty() : !pSDEDataSync.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDataSync.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isUserTag2Dirty() : !pSDEDataSync.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDataSync.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isUserTag3Dirty() : !pSDEDataSync.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDataSync.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isUserTag4Dirty() : !pSDEDataSync.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDataSync.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEDataSync pSDEDataSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSync.isValidFlagDirty() && !bl2 : !pSDEDataSync.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataSync.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEDataSync, bl2, bl3);
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

    protected void onSyncEntity(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDataSync, bl);
    }

    protected void onSyncIndexEntities(PSDEDataSync pSDEDataSync, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDataSync, bl);
    }

    public Object getDataContextValue(PSDEDataSync pSDEDataSync, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDataSync, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDataSync pSDEDataSync, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDataSync, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DENAMES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DENames_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTFULL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportFull_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTERMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilterModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPORTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"IMPORTPSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_ImportPSDEActionId_ImportPSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPORTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImportPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPORTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImportPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InCustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InCustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"INPSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEActionId_InPSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSYSDATASYNCAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDataSyncAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSYSDATASYNCAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDataSyncAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTCUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutCustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTCUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutCustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"OUTPSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEActionId_OutPSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSDATASYNCAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysDataSyncAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSDATASYNCAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysDataSyncAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTTIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutTimer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASYNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSyncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASYNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSyncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCEXPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncExport_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimerMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DENames_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DENAMES", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EventType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportFull_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FilterModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILTERMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImportPSDEActionId_ImportPSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("IMPORTPSDEACTIONID", "PSDEACTION", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5bfc\u5165\u6570\u636e\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImportPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPORTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImportPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPORTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InCustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INCUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InCustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InPSDEActionId_InPSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("INPSDEACTIONID", "PSDEACTION", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u8f93\u5165\u8fc7\u6ee4\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSysDataSyncAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDATASYNCAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSysDataSyncAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDATASYNCAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_OutCustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTCUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutCustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OutMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OutPSDEActionId_OutPSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("OUTPSDEACTIONID", "PSDEACTION", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u8f93\u51fa\u8fc7\u6ee4\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysDataSyncAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSDATASYNCAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysDataSyncAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSDATASYNCAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutTimer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDataSyncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASYNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSyncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASYNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysReqItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SyncDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCDIR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncExport_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TimerMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ToDoTask_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TODOTASK", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected boolean onMergeChild(String string, String string2, PSDEDataSync pSDEDataSync) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDataSync)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDataSync pSDEDataSync) throws Exception {
        Object object = pSDEDataSync.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDATASYNC_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEDataSync);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEDataSync pSDEDataSync, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDATASYNC");
        if (!bl) {
            pSDEDataSync.setCreateDate(null);
            pSDEDataSync.setCreateMan(null);
            pSDEDataSync.setPSDEDataSyncId(null);
            pSDEDataSync.setUpdateDate(null);
            pSDEDataSync.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDataSync, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDataSync pSDEDataSync, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDataSync, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDATASYNC_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEDataSync pSDEDataSync) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDataSync.getCodeName())) {
            return pSDEDataSync.getCodeName();
        }
        return super.getModelV2Tag(pSDEDataSync);
    }

    @Override
    public boolean setModelV2Tag(PSDEDataSync pSDEDataSync, String string) {
        pSDEDataSync.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDataSync pSDEDataSync, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDataSync.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDataSync, true);
        pSDEDataSync.set("CODENAME", string);
        if (this.select(pSDEDataSync, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDataSync, true);
        return super.getModelV2Entity(pSDEDataSync, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDataSync pSDEDataSync, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDataSync, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEDataSync pSDEDataSync, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DataSync");
    }
}

