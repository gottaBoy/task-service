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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDTSQueueDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDTSQueueDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDTSQueue;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDTSQueueServiceBase
extends PSCoreSysServiceBase<PSDEDTSQueue> {
    private static final Log log = LogFactory.getLog(PSDEDTSQueueServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEDTSQueueDEModel pSDEDTSQueueDEModel;
    private PSDEDTSQueueDAO pSDEDTSQueueDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueService";
    }

    public PSDEDTSQueueDEModel getPSDEDTSQueueDEModel() {
        if (this.pSDEDTSQueueDEModel == null) {
            try {
                this.pSDEDTSQueueDEModel = (PSDEDTSQueueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDTSQueueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDTSQueueDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDTSQueueDEModel();
    }

    public PSDEDTSQueueDAO getPSDEDTSQueueDAO() {
        if (this.pSDEDTSQueueDAO == null) {
            try {
                this.pSDEDTSQueueDAO = (PSDEDTSQueueDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDTSQueueDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDTSQueueDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDTSQueueDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEDTSQueue pSDEDTSQueue, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSDATAENTITY_HISTORYPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_HistoryPSDE(pSDEDTSQueue, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDTSQueue, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSDEACTION_CANCELPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDEDTSQueue, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSDEACTION_FINISHPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_FinishPSDEAction(pSDEDTSQueue, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSDEACTION_PUSHPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_PushPSDEAction(pSDEDTSQueue, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSDEACTION_REFRESHPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_RefreshPSDEAction(pSDEDTSQueue, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSDEFIELD_ERRORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ErrorPSDEF(pSDEDTSQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSDEFIELD_STATEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_StatePSDEF(pSDEDTSQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSDEFIELD_TIMEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TimePSDEF(pSDEDTSQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEDTSQueue, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDTSQUEUE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDEDTSQueue, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDTSQueue, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_HistoryPSDE(PSDEDTSQueue pSDEDTSQueue, PSDataEntity pSDataEntity) throws Exception {
        pSDEDTSQueue.setHistoryPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDTSQueue.setHistoryPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSDEDTSQueue pSDEDTSQueue, PSDataEntity pSDataEntity) throws Exception {
        pSDEDTSQueue.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDTSQueue.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSDEDTSQueue, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_PSDEAction(PSDEDTSQueue pSDEDTSQueue, PSDEAction pSDEAction) throws Exception {
        pSDEDTSQueue.setCancelPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDTSQueue.setCancelPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_FinishPSDEAction(PSDEDTSQueue pSDEDTSQueue, PSDEAction pSDEAction) throws Exception {
        pSDEDTSQueue.setFinishPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDTSQueue.setFinishPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PushPSDEAction(PSDEDTSQueue pSDEDTSQueue, PSDEAction pSDEAction) throws Exception {
        pSDEDTSQueue.setPushPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDTSQueue.setPushPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_RefreshPSDEAction(PSDEDTSQueue pSDEDTSQueue, PSDEAction pSDEAction) throws Exception {
        pSDEDTSQueue.setRefreshPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDTSQueue.setRefreshPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_ErrorPSDEF(PSDEDTSQueue pSDEDTSQueue, PSDEField pSDEField) throws Exception {
        pSDEDTSQueue.setErrorPSDEFId(pSDEField.getPSDEFieldId());
        pSDEDTSQueue.setErrorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_StatePSDEF(PSDEDTSQueue pSDEDTSQueue, PSDEField pSDEField) throws Exception {
        pSDEDTSQueue.setStatePSDEFId(pSDEField.getPSDEFieldId());
        pSDEDTSQueue.setStatePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TimePSDEF(PSDEDTSQueue pSDEDTSQueue, PSDEField pSDEField) throws Exception {
        pSDEDTSQueue.setTimePSDEFId(pSDEField.getPSDEFieldId());
        pSDEDTSQueue.setTimePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEDTSQueue pSDEDTSQueue, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEDTSQueue.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEDTSQueue.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSDEDTSQueue pSDEDTSQueue, PSSystem pSSystem) throws Exception {
        pSDEDTSQueue.setPSSystemId(pSSystem.getPSSystemId());
        pSDEDTSQueue.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDTSQueue.getDefaultFlag() == null) {
                pSDEDTSQueue.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEDTSQueue.getValidFlag() == null) {
                pSDEDTSQueue.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_HistoryPSDE(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_FinishPSDEAction(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_PushPSDEAction(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_RefreshPSDEAction(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_ErrorPSDEF(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_StatePSDEF(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_TimePSDEF(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEDTSQueue, bl);
        this.onFillEntityFullInfo_PSSystem(pSDEDTSQueue, bl);
    }

    protected void onFillEntityFullInfo_HistoryPSDE(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        if (pSDEDTSQueue.isHistoryPSDEIdDirty()) {
            if (pSDEDTSQueue.getHistoryPSDEId() != null) {
                if (pSDEDTSQueue.getHistoryPSDEId() == null || pSDEDTSQueue.getHistoryPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDTSQueue.getHistoryPSDE();
                    pSDEDTSQueue.setHistoryPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEDTSQueue.setHistoryPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        if (pSDEDTSQueue.isPSDEIdDirty()) {
            if (pSDEDTSQueue.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSDEDTSQueue.getPSDEId() == null || pSDEDTSQueue.getPSDEName() == null) {
                    pSDataEntity = pSDEDTSQueue.getPSDE();
                    pSDEDTSQueue.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSDEDTSQueue.getPSDE()).getPSSystemId(), (Object)pSDEDTSQueue.getPSSystemId()) != 0L) {
                    pSDEDTSQueue.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSDEDTSQueue, bl);
                }
            } else {
                pSDEDTSQueue.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_FinishPSDEAction(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PushPSDEAction(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        if (pSDEDTSQueue.isPushPSDEActionIdDirty()) {
            if (pSDEDTSQueue.getPushPSDEActionId() != null) {
                if (pSDEDTSQueue.getPushPSDEActionId() == null || pSDEDTSQueue.getPushPSDEActionName() == null) {
                    PSDEAction pSDEAction = pSDEDTSQueue.getPushPSDEAction();
                    pSDEDTSQueue.setPushPSDEActionName(pSDEAction.getPSDEActionName());
                }
            } else {
                pSDEDTSQueue.setPushPSDEActionName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefreshPSDEAction(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        if (pSDEDTSQueue.isRefreshPSDEActionIdDirty()) {
            if (pSDEDTSQueue.getRefreshPSDEActionId() != null) {
                if (pSDEDTSQueue.getRefreshPSDEActionId() == null || pSDEDTSQueue.getRefreshPSDEActionName() == null) {
                    PSDEAction pSDEAction = pSDEDTSQueue.getRefreshPSDEAction();
                    pSDEDTSQueue.setRefreshPSDEActionName(pSDEAction.getPSDEActionName());
                }
            } else {
                pSDEDTSQueue.setRefreshPSDEActionName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ErrorPSDEF(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        if (pSDEDTSQueue.isErrorPSDEFIdDirty()) {
            if (pSDEDTSQueue.getErrorPSDEFId() != null) {
                if (pSDEDTSQueue.getErrorPSDEFId() == null || pSDEDTSQueue.getErrorPSDEFName() == null) {
                    PSDEField pSDEField = pSDEDTSQueue.getErrorPSDEF();
                    pSDEDTSQueue.setErrorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDTSQueue.setErrorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_StatePSDEF(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        if (pSDEDTSQueue.isStatePSDEFIdDirty()) {
            if (pSDEDTSQueue.getStatePSDEFId() != null) {
                if (pSDEDTSQueue.getStatePSDEFId() == null || pSDEDTSQueue.getStatePSDEFName() == null) {
                    PSDEField pSDEField = pSDEDTSQueue.getStatePSDEF();
                    pSDEDTSQueue.setStatePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDTSQueue.setStatePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TimePSDEF(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        if (pSDEDTSQueue.isTimePSDEFIdDirty()) {
            if (pSDEDTSQueue.getTimePSDEFId() != null) {
                if (pSDEDTSQueue.getTimePSDEFId() == null || pSDEDTSQueue.getTimePSDEFName() == null) {
                    PSDEField pSDEField = pSDEDTSQueue.getTimePSDEF();
                    pSDEDTSQueue.setTimePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDTSQueue.setTimePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        if (pSDEDTSQueue.isPSSystemIdDirty()) {
            if (pSDEDTSQueue.getPSSystemId() != null) {
                if (pSDEDTSQueue.getPSSystemId() == null || pSDEDTSQueue.getPSSystemName() == null) {
                    PSSystem pSSystem = pSDEDTSQueue.getPSSystem();
                    pSDEDTSQueue.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSDEDTSQueue.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDTSQueue, bl);
    }

    public ArrayList<PSDEDTSQueue> selectByHistoryPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByHistoryPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByHistoryPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByHistoryPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByHistoryPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("HISTORYPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByHistoryPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByHistoryPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDTSQueue> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDTSQueue> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CANCELPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
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

    public ArrayList<PSDEDTSQueue> selectByFinishPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByFinishPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByFinishPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByFinishPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByFinishPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FINISHPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFinishPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFinishPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDTSQueue> selectByPushPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPushPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPushPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPushPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPushPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PUSHPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPushPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPushPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDTSQueue> selectByRefreshPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByRefreshPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByRefreshPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByRefreshPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByRefreshPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFRESHPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefreshPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefreshPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDTSQueue> selectByErrorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByErrorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByErrorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByErrorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByErrorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ERRORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByErrorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByErrorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDTSQueue> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStatePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStatePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDTSQueue> selectByTimePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTimePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByTimePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTimePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByTimePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIMEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTimePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTimePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDTSQueue> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDTSQueue> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDEDTSQueue> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByHistoryPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByHistoryPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSDATAENTITY_HISTORYPSDEID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetHistoryPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByHistoryPSDE(pSDataEntity);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setHistoryPSDEId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByHistoryPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByHistoryPSDE(pSDataEntity2);
                PSDEDTSQueueServiceBase.this.internalRemoveByHistoryPSDE(pSDataEntity2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByHistoryPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByHistoryPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByHistoryPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByHistoryPSDE(pSDataEntity);
        this.onBeforeRemoveByHistoryPSDE(pSDataEntity, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByHistoryPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByHistoryPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByHistoryPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByHistoryPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setPSDEId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDTSQueueServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSDEACTION_CANCELPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setCancelPSDEActionId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDEDTSQueueServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByFinishPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSDEACTION_FINISHPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByFinishPSDEAction(pSDEAction);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setFinishPSDEActionId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByFinishPSDEAction(pSDEAction2);
                PSDEDTSQueueServiceBase.this.internalRemoveByFinishPSDEAction(pSDEAction2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByFinishPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByFinishPSDEAction(pSDEAction);
        this.onBeforeRemoveByFinishPSDEAction(pSDEAction, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByFinishPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByFinishPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFinishPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByPushPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPushPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSDEACTION_PUSHPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPushPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPushPSDEAction(pSDEAction);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setPushPSDEActionId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByPushPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByPushPSDEAction(pSDEAction2);
                PSDEDTSQueueServiceBase.this.internalRemoveByPushPSDEAction(pSDEAction2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByPushPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPushPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPushPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPushPSDEAction(pSDEAction);
        this.onBeforeRemoveByPushPSDEAction(pSDEAction, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByPushPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPushPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPushPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPushPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByRefreshPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByRefreshPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSDEACTION_REFRESHPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetRefreshPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByRefreshPSDEAction(pSDEAction);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setRefreshPSDEActionId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByRefreshPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByRefreshPSDEAction(pSDEAction2);
                PSDEDTSQueueServiceBase.this.internalRemoveByRefreshPSDEAction(pSDEAction2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByRefreshPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByRefreshPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByRefreshPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByRefreshPSDEAction(pSDEAction);
        this.onBeforeRemoveByRefreshPSDEAction(pSDEAction, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByRefreshPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByRefreshPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByRefreshPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefreshPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByErrorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByErrorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSDEFIELD_ERRORPSDEFID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetErrorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByErrorPSDEF(pSDEField);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setErrorPSDEFId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByErrorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByErrorPSDEF(pSDEField2);
                PSDEDTSQueueServiceBase.this.internalRemoveByErrorPSDEF(pSDEField2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByErrorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByErrorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByErrorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByErrorPSDEF(pSDEField);
        this.onBeforeRemoveByErrorPSDEF(pSDEField, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByErrorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByErrorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByErrorPSDEF(PSDEField pSDEField, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByErrorPSDEF(PSDEField pSDEField, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByStatePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSDEFIELD_STATEPSDEFID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByStatePSDEF(pSDEField);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setStatePSDEFId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByStatePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByStatePSDEF(pSDEField2);
                PSDEDTSQueueServiceBase.this.internalRemoveByStatePSDEF(pSDEField2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByStatePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByStatePSDEF(pSDEField);
        this.onBeforeRemoveByStatePSDEF(pSDEField, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByStatePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByTimePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSDEFIELD_TIMEPSDEFID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByTimePSDEF(pSDEField);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setTimePSDEFId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByTimePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByTimePSDEF(pSDEField2);
                PSDEDTSQueueServiceBase.this.internalRemoveByTimePSDEF(pSDEField2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByTimePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByTimePSDEF(pSDEField);
        this.onBeforeRemoveByTimePSDEF(pSDEField, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByTimePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTimePSDEF(PSDEField pSDEField, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTimePSDEF(PSDEField pSDEField, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setPSSysSFPluginId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEDTSQueueServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDTSQUEUE_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSDEDTSQUEUE", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            PSDEDTSQueue pSDEDTSQueue2 = (PSDEDTSQueue)this.getDEModel().createEntity();
            pSDEDTSQueue2.setPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
            pSDEDTSQueue2.setPSSystemId(null);
            this.update(pSDEDTSQueue2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDTSQueueServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDEDTSQueueServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDEDTSQueueServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEDTSQueue> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDEDTSQueue pSDEDTSQueue : arrayList) {
            this.remove((IEntity)pSDEDTSQueue);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEDTSQueue> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDTSQueue pSDEDTSQueue) throws Exception {
        PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        pSDELogicNodeService.testRemoveByDstPSDEDTSQueue(pSDEDTSQueue);
        super.onBeforeRemove(pSDEDTSQueue);
    }

    protected void replaceParentInfo(PSDEDTSQueue pSDEDTSQueue, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDTSQueue, cloneSession);
        if (pSDEDTSQueue.getHistoryPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDTSQueue.getHistoryPSDEId())) != null) {
            this.onFillParentInfo_HistoryPSDE(pSDEDTSQueue, (PSDataEntity)iEntity);
        }
        if (pSDEDTSQueue.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDTSQueue.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDTSQueue, (PSDataEntity)iEntity);
        }
        if (pSDEDTSQueue.getCancelPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDTSQueue.getCancelPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDEDTSQueue, (PSDEAction)iEntity);
        }
        if (pSDEDTSQueue.getFinishPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDTSQueue.getFinishPSDEActionId())) != null) {
            this.onFillParentInfo_FinishPSDEAction(pSDEDTSQueue, (PSDEAction)iEntity);
        }
        if (pSDEDTSQueue.getPushPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDTSQueue.getPushPSDEActionId())) != null) {
            this.onFillParentInfo_PushPSDEAction(pSDEDTSQueue, (PSDEAction)iEntity);
        }
        if (pSDEDTSQueue.getRefreshPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDTSQueue.getRefreshPSDEActionId())) != null) {
            this.onFillParentInfo_RefreshPSDEAction(pSDEDTSQueue, (PSDEAction)iEntity);
        }
        if (pSDEDTSQueue.getErrorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDTSQueue.getErrorPSDEFId())) != null) {
            this.onFillParentInfo_ErrorPSDEF(pSDEDTSQueue, (PSDEField)iEntity);
        }
        if (pSDEDTSQueue.getStatePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDTSQueue.getStatePSDEFId())) != null) {
            this.onFillParentInfo_StatePSDEF(pSDEDTSQueue, (PSDEField)iEntity);
        }
        if (pSDEDTSQueue.getTimePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDTSQueue.getTimePSDEFId())) != null) {
            this.onFillParentInfo_TimePSDEF(pSDEDTSQueue, (PSDEField)iEntity);
        }
        if (pSDEDTSQueue.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEDTSQueue.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEDTSQueue, (PSSysSFPlugin)iEntity);
        }
        if (pSDEDTSQueue.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDEDTSQueue.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDEDTSQueue, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDTSQueue, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CancelledState(bl, pSDEDTSQueue, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CancelledStateText(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CancelPSDEActionId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CancelTimeout(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatedState(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatedStateText(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ErrorPSDEFId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ErrorPSDEFName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FailedState(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FailedStateText(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishedState(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishedStateText(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishPSDEActionId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HistoryPSDEId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HistoryPSDEName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProcessingState(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProcessingStateText(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDTSQueueId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDTSQueueName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PushPSDEActionId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PushPSDEActionName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueueParams(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefreshPSDEActionId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefreshPSDEActionName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefreshTimer(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimePSDEFId(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimePSDEFName(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEDTSQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDTSQueue, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CancelledState(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isCancelledStateDirty() : !pSDEDTSQueue.isCancelledStateDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getCancelledState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CancelledState_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANCELLEDSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CancelledStateText(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isCancelledStateTextDirty() : !pSDEDTSQueue.isCancelledStateTextDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getCancelledStateText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CancelledStateText_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANCELLEDSTATETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CancelPSDEActionId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isCancelPSDEActionIdDirty() : !pSDEDTSQueue.isCancelPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getCancelPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CancelPSDEActionId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANCELPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CancelTimeout(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isCancelTimeoutDirty() : !pSDEDTSQueue.isCancelTimeoutDirty()) {
            return null;
        }
        Integer n = pSDEDTSQueue.getCancelTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CancelTimeout_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANCELTIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isCodeNameDirty() : !pSDEDTSQueue.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEDTSQueueDEModel(), "CODENAME", string3, pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreatedState(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isCreatedStateDirty() : !pSDEDTSQueue.isCreatedStateDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getCreatedState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatedState_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEDSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatedStateText(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isCreatedStateTextDirty() : !pSDEDTSQueue.isCreatedStateTextDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getCreatedStateText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatedStateText_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEDSTATETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isDefaultFlagDirty() && !bl2 : !pSDEDTSQueue.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDEDTSQueue.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSDEDTSQueueDEModel(), "DEFAULTFLAG", string, pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_ErrorPSDEFId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isErrorPSDEFIdDirty() : !pSDEDTSQueue.isErrorPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getErrorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ErrorPSDEFId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ERRORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ErrorPSDEFName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isErrorPSDEFNameDirty() : !pSDEDTSQueue.isErrorPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getErrorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ErrorPSDEFName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ERRORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FailedState(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isFailedStateDirty() : !pSDEDTSQueue.isFailedStateDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getFailedState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FailedState_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FAILEDSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FailedStateText(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isFailedStateTextDirty() : !pSDEDTSQueue.isFailedStateTextDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getFailedStateText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FailedStateText_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FAILEDSTATETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishedState(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isFinishedStateDirty() : !pSDEDTSQueue.isFinishedStateDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getFinishedState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishedState_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHEDSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishedStateText(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isFinishedStateTextDirty() : !pSDEDTSQueue.isFinishedStateTextDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getFinishedStateText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishedStateText_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHEDSTATETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishPSDEActionId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isFinishPSDEActionIdDirty() : !pSDEDTSQueue.isFinishPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getFinishPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishPSDEActionId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HistoryPSDEId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isHistoryPSDEIdDirty() : !pSDEDTSQueue.isHistoryPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getHistoryPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HistoryPSDEId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HISTORYPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HistoryPSDEName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isHistoryPSDENameDirty() : !pSDEDTSQueue.isHistoryPSDENameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getHistoryPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HistoryPSDEName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HISTORYPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isLockFlagDirty() : !pSDEDTSQueue.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEDTSQueue.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isMemoDirty() : !pSDEDTSQueue.isMemoDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_ProcessingState(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isProcessingStateDirty() : !pSDEDTSQueue.isProcessingStateDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getProcessingState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProcessingState_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSINGSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProcessingStateText(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isProcessingStateTextDirty() : !pSDEDTSQueue.isProcessingStateTextDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getProcessingStateText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProcessingStateText_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSINGSTATETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDTSQueueId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isPSDEDTSQueueIdDirty() && !bl2 : !pSDEDTSQueue.isPSDEDTSQueueIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getPSDEDTSQueueId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDTSQUEUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDTSQueueId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDTSQUEUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDTSQueueName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isPSDEDTSQueueNameDirty() && !bl2 : !pSDEDTSQueue.isPSDEDTSQueueNameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getPSDEDTSQueueName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDTSQUEUENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDTSQueueName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDTSQUEUENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isPSDEIdDirty() && !bl2 : !pSDEDTSQueue.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isPSDENameDirty() && !bl2 : !pSDEDTSQueue.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isPSSysSFPluginIdDirty() : !pSDEDTSQueue.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isPSSystemIdDirty() : !pSDEDTSQueue.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isPSSystemNameDirty() : !pSDEDTSQueue.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PushPSDEActionId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isPushPSDEActionIdDirty() && !bl2 : !pSDEDTSQueue.isPushPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getPushPSDEActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUSHPSDEACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PushPSDEActionId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUSHPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PushPSDEActionName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isPushPSDEActionNameDirty() && !bl2 : !pSDEDTSQueue.isPushPSDEActionNameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getPushPSDEActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUSHPSDEACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PushPSDEActionName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUSHPSDEACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueueParams(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isQueueParamsDirty() : !pSDEDTSQueue.isQueueParamsDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getQueueParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QueueParams_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUEUEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefreshPSDEActionId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isRefreshPSDEActionIdDirty() : !pSDEDTSQueue.isRefreshPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getRefreshPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefreshPSDEActionId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFRESHPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefreshPSDEActionName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isRefreshPSDEActionNameDirty() : !pSDEDTSQueue.isRefreshPSDEActionNameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getRefreshPSDEActionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefreshPSDEActionName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFRESHPSDEACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefreshTimer(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isRefreshTimerDirty() : !pSDEDTSQueue.isRefreshTimerDirty()) {
            return null;
        }
        Integer n = pSDEDTSQueue.getRefreshTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefreshTimer_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFRESHTIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isStatePSDEFIdDirty() : !pSDEDTSQueue.isStatePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getStatePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isStatePSDEFNameDirty() : !pSDEDTSQueue.isStatePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getStatePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimePSDEFId(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isTimePSDEFIdDirty() : !pSDEDTSQueue.isTimePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getTimePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimePSDEFId_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimePSDEFName(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isTimePSDEFNameDirty() : !pSDEDTSQueue.isTimePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getTimePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimePSDEFName_Default((IEntity)pSDEDTSQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isUserCatDirty() : !pSDEDTSQueue.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isUserTagDirty() : !pSDEDTSQueue.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isUserTag2Dirty() : !pSDEDTSQueue.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isUserTag3Dirty() : !pSDEDTSQueue.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isUserTag4Dirty() : !pSDEDTSQueue.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDTSQueue.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEDTSQueue pSDEDTSQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDTSQueue.isValidFlagDirty() && !bl2 : !pSDEDTSQueue.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEDTSQueue.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEDTSQueue, bl2, bl3);
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

    protected void onSyncEntity(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDTSQueue, bl);
    }

    protected void onSyncIndexEntities(PSDEDTSQueue pSDEDTSQueue, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDTSQueue, bl);
    }

    public Object getDataContextValue(PSDEDTSQueue pSDEDTSQueue, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDTSQueue, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEDTSQueue.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDTSQueue pSDEDTSQueue, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDTSQueue, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CANCELLEDSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CancelledState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANCELLEDSTATETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CancelledStateText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANCELPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CancelPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANCELPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CancelPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANCELTIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CancelTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatedState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDSTATETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatedStateText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ERRORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ErrorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ERRORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ErrorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FAILEDSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FailedState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FAILEDSTATETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FailedStateText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHEDSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishedState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHEDSTATETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishedStateText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HISTORYPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HistoryPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HISTORYPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HistoryPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROCESSINGSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProcessingState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROCESSINGSTATETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProcessingStateText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDTSQUEUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDTSQueueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDTSQUEUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDTSQueueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUSHPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PushPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUSHPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PushPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUEUEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueueParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFRESHPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefreshPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFRESHPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefreshPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFRESHTIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefreshTimer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimePSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CancelledState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANCELLEDSTATE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CancelledStateText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANCELLEDSTATETEXT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CancelPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANCELPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CancelPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANCELPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CancelTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreatedState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEDSTATE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatedStateText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEDSTATETEXT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_ErrorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ERRORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ErrorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ERRORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FailedState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FAILEDSTATE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FailedStateText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FAILEDSTATETEXT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishedState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHEDSTATE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishedStateText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHEDSTATETEXT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HistoryPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HISTORYPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HistoryPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HISTORYPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_ProcessingState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROCESSINGSTATE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProcessingStateText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROCESSINGSTATETEXT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDTSQueueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDTSQUEUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDTSQueueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDTSQUEUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PushPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUSHPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PushPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUSHPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QueueParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUEUEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefreshPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFRESHPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefreshPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFRESHPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefreshTimer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StatePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StatePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEDTSQueue pSDEDTSQueue) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDTSQueue)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDTSQueue pSDEDTSQueue) throws Exception {
        Object object = pSDEDTSQueue.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDTSQUEUE_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEDTSQueue);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEDTSQueue pSDEDTSQueue, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDTSQUEUE");
        if (!bl) {
            pSDEDTSQueue.setCreateDate(null);
            pSDEDTSQueue.setCreateMan(null);
            pSDEDTSQueue.setPSDEDTSQueueId(null);
            pSDEDTSQueue.setUpdateDate(null);
            pSDEDTSQueue.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDTSQueue, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDTSQueue pSDEDTSQueue, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDTSQueue, string);
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
            return "DER1N_PSDEDTSQUEUE_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEDTSQueue pSDEDTSQueue) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDTSQueue.getCodeName())) {
            return pSDEDTSQueue.getCodeName();
        }
        return super.getModelV2Tag(pSDEDTSQueue);
    }

    @Override
    public boolean setModelV2Tag(PSDEDTSQueue pSDEDTSQueue, String string) {
        pSDEDTSQueue.setCodeName(string);
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
    public boolean getModelV2Entity(PSDEDTSQueue pSDEDTSQueue, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDTSQueue.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDTSQueue, true);
        pSDEDTSQueue.set("CODENAME", string);
        if (this.select(pSDEDTSQueue, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDTSQueue, true);
        return super.getModelV2Entity(pSDEDTSQueue, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDTSQueue pSDEDTSQueue, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDTSQueue, objectNode, string, string2, n);
    }
}

