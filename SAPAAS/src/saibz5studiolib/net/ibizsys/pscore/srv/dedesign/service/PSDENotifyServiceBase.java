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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDENotifyDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDENotifyDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotify;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotifyTarget;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrint;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrintBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReportBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyTargetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyTargetServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgQueue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgQueueBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDENotifyServiceBase
extends PSCoreSysServiceBase<PSDENotify> {
    private static final Log log = LogFactory.getLog(PSDENotifyServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDENotifyDEModel pSDENotifyDEModel;
    private PSDENotifyDAO pSDENotifyDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService";
    }

    public PSDENotifyDEModel getPSDENotifyDEModel() {
        if (this.pSDENotifyDEModel == null) {
            try {
                this.pSDENotifyDEModel = (PSDENotifyDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDENotifyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDENotifyDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDENotifyDEModel();
    }

    public PSDENotifyDAO getPSDENotifyDAO() {
        if (this.pSDENotifyDAO == null) {
            try {
                this.pSDENotifyDAO = (PSDENotifyDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDENotifyDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDENotifyDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDENotifyDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
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

    protected void onFillParentInfo(PSDENotify pSDENotify, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFY_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDENotify, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFY_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSDENotify, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFY_PSDEFIELD_BEGINPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_BeginPSDEF(pSDENotify, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFY_PSDEFIELD_ENDPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_EndPSDEF(pSDENotify, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFY_PSDEPRINT_PSDEPRINTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService", (SessionFactory)this.getSessionFactory());
            PSDEPrint pSDEPrint = (PSDEPrint)iService.getDEModel().createEntity();
            pSDEPrint.set("PSDEPRINTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEPrint);
            } else {
                iService.get(pSDEPrint);
            }
            this.onFillParentInfo_PSDEPrint(pSDENotify, pSDEPrint);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFY_PSDEREPORT_PSDEREPORTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEReportService", (SessionFactory)this.getSessionFactory());
            PSDEReport pSDEReport = (PSDEReport)iService.getDEModel().createEntity();
            pSDEReport.set("PSDEREPORTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEReport);
            } else {
                iService.get(pSDEReport);
            }
            this.onFillParentInfo_PSDEReport(pSDENotify, pSDEReport);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFY_PSSYSMSGQUEUE_PSSYSMSGQUEUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueService", (SessionFactory)this.getSessionFactory());
            PSSysMsgQueue pSSysMsgQueue = (PSSysMsgQueue)iService.getDEModel().createEntity();
            pSSysMsgQueue.set("PSSYSMSGQUEUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysMsgQueue);
            } else {
                iService.get(pSSysMsgQueue);
            }
            this.onFillParentInfo_PSSysMsgQueue(pSDENotify, pSSysMsgQueue);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFY_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysMsgTempl);
            } else {
                iService.get(pSSysMsgTempl);
            }
            this.onFillParentInfo_PSSysMsgTempl(pSDENotify, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFY_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDENotify, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo(pSDENotify, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDENotify pSDENotify, PSDataEntity pSDataEntity) throws Exception {
        pSDENotify.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDENotify.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDS(PSDENotify pSDENotify, PSDEDataSet pSDEDataSet) throws Exception {
        pSDENotify.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDENotify.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_BeginPSDEF(PSDENotify pSDENotify, PSDEField pSDEField) throws Exception {
        pSDENotify.setBeginPSDEFId(pSDEField.getPSDEFieldId());
        pSDENotify.setBeginPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_EndPSDEF(PSDENotify pSDENotify, PSDEField pSDEField) throws Exception {
        pSDENotify.setEndPSDEFId(pSDEField.getPSDEFieldId());
        pSDENotify.setEndPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEPrint(PSDENotify pSDENotify, PSDEPrint pSDEPrint) throws Exception {
        pSDENotify.setPSDEPrintId(pSDEPrint.getPSDEPrintId());
        pSDENotify.setPSDEPrintName(pSDEPrint.getPSDEPrintName());
    }

    protected void onFillParentInfo_PSDEReport(PSDENotify pSDENotify, PSDEReport pSDEReport) throws Exception {
        pSDENotify.setPSDEReportId(pSDEReport.getPSDEReportId());
        pSDENotify.setPSDEReportName(pSDEReport.getPSDEReportName());
    }

    protected void onFillParentInfo_PSSysMsgQueue(PSDENotify pSDENotify, PSSysMsgQueue pSSysMsgQueue) throws Exception {
        pSDENotify.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
        pSDENotify.setPSSysMsgQueueName(pSSysMsgQueue.getPSSysMsgQueueName());
    }

    protected void onFillParentInfo_PSSysMsgTempl(PSDENotify pSDENotify, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSDENotify.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSDENotify.setPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDENotify pSDENotify, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDENotify.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDENotify.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSDENotify pSDENotify, boolean bl) throws Exception {
        if (bl) {
            if (pSDENotify.getCodeName() == null) {
                pSDENotify.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Notify", 25));
            }
            if (pSDENotify.getPSDENotifyName() == null) {
                pSDENotify.setPSDENotifyName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u901a\u77e5", 25));
            }
            if (pSDENotify.getTimerMode() == null) {
                pSDENotify.setTimerMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDENotify.getValidFlag() == null) {
                pSDENotify.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDENotify, bl);
        this.onFillEntityFullInfo_PSDE(pSDENotify, bl);
        this.onFillEntityFullInfo_PSDEDS(pSDENotify, bl);
        this.onFillEntityFullInfo_BeginPSDEF(pSDENotify, bl);
        this.onFillEntityFullInfo_EndPSDEF(pSDENotify, bl);
        this.onFillEntityFullInfo_PSDEPrint(pSDENotify, bl);
        this.onFillEntityFullInfo_PSDEReport(pSDENotify, bl);
        this.onFillEntityFullInfo_PSSysMsgQueue(pSDENotify, bl);
        this.onFillEntityFullInfo_PSSysMsgTempl(pSDENotify, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDENotify, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDENotify pSDENotify, boolean bl) throws Exception {
        if (pSDENotify.isPSDEIdDirty()) {
            if (pSDENotify.getPSDEId() != null) {
                if (pSDENotify.getPSDEId() == null || pSDENotify.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDENotify.getPSDE();
                    pSDENotify.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDENotify.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDS(PSDENotify pSDENotify, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_BeginPSDEF(PSDENotify pSDENotify, boolean bl) throws Exception {
        if (pSDENotify.isBeginPSDEFIdDirty()) {
            if (pSDENotify.getBeginPSDEFId() != null) {
                if (pSDENotify.getBeginPSDEFId() == null || pSDENotify.getBeginPSDEFName() == null) {
                    PSDEField pSDEField = pSDENotify.getBeginPSDEF();
                    pSDENotify.setBeginPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDENotify.setBeginPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_EndPSDEF(PSDENotify pSDENotify, boolean bl) throws Exception {
        if (pSDENotify.isEndPSDEFIdDirty()) {
            if (pSDENotify.getEndPSDEFId() != null) {
                if (pSDENotify.getEndPSDEFId() == null || pSDENotify.getEndPSDEFName() == null) {
                    PSDEField pSDEField = pSDENotify.getEndPSDEF();
                    pSDENotify.setEndPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDENotify.setEndPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEPrint(PSDENotify pSDENotify, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEReport(PSDENotify pSDENotify, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMsgQueue(PSDENotify pSDENotify, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMsgTempl(PSDENotify pSDENotify, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDENotify pSDENotify, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDENotify pSDENotify, boolean bl) throws Exception {
        super.onWriteBackParent(pSDENotify, bl);
    }

    public ArrayList<PSDENotify> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDENotify> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDENotify> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDENotify> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDENotify> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDENotify> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotify> selectByBeginPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByBeginPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDENotify> selectByBeginPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByBeginPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDENotify> selectByBeginPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BEGINPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBeginPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBeginPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotify> selectByEndPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByEndPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDENotify> selectByEndPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByEndPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDENotify> selectByEndPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ENDPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEndPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEndPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotify> selectByPSDEPrint(PSDEPrintBase pSDEPrintBase) throws Exception {
        return this.selectByPSDEPrint(pSDEPrintBase, "", -1);
    }

    public ArrayList<PSDENotify> selectByPSDEPrint(PSDEPrintBase pSDEPrintBase, String string) throws Exception {
        return this.selectByPSDEPrint(pSDEPrintBase, string, -1);
    }

    public ArrayList<PSDENotify> selectByPSDEPrint(PSDEPrintBase pSDEPrintBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPRINTID", (Object)pSDEPrintBase.getPSDEPrintId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEPrintCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEPrintCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotify> selectByPSDEReport(PSDEReportBase pSDEReportBase) throws Exception {
        return this.selectByPSDEReport(pSDEReportBase, "", -1);
    }

    public ArrayList<PSDENotify> selectByPSDEReport(PSDEReportBase pSDEReportBase, String string) throws Exception {
        return this.selectByPSDEReport(pSDEReportBase, string, -1);
    }

    public ArrayList<PSDENotify> selectByPSDEReport(PSDEReportBase pSDEReportBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEREPORTID", (Object)pSDEReportBase.getPSDEReportId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEReportCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEReportCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotify> selectByPSSysMsgQueue(PSSysMsgQueueBase pSSysMsgQueueBase) throws Exception {
        return this.selectByPSSysMsgQueue(pSSysMsgQueueBase, "", -1);
    }

    public ArrayList<PSDENotify> selectByPSSysMsgQueue(PSSysMsgQueueBase pSSysMsgQueueBase, String string) throws Exception {
        return this.selectByPSSysMsgQueue(pSSysMsgQueueBase, string, -1);
    }

    public ArrayList<PSDENotify> selectByPSSysMsgQueue(PSSysMsgQueueBase pSSysMsgQueueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGQUEUEID", (Object)pSSysMsgQueueBase.getPSSysMsgQueueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgQueueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgQueueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotify> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSDENotify> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSDENotify> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotify> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDENotify> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDENotify> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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
        ArrayList<PSDENotify> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFY_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDENOTIFY", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDENotify pSDENotify : arrayList) {
            PSDENotify pSDENotify2 = (PSDENotify)this.getDEModel().createEntity();
            pSDENotify2.setPSDENotifyId(pSDENotify.getPSDENotifyId());
            pSDENotify2.setPSDEId(null);
            this.update(pSDENotify2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDENotifyServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDENotifyServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDENotify pSDENotify : arrayList) {
            this.remove(pSDENotify);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFY_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSDENOTIFY", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSDENotify pSDENotify : arrayList) {
            PSDENotify pSDENotify2 = (PSDENotify)this.getDEModel().createEntity();
            pSDENotify2.setPSDENotifyId(pSDENotify.getPSDENotifyId());
            pSDENotify2.setPSDEDSId(null);
            this.update(pSDENotify2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSDENotifyServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSDENotifyServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSDENotify pSDENotify : arrayList) {
            this.remove(pSDENotify);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    public void testRemoveByBeginPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByBeginPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFY_PSDEFIELD_BEGINPSDEFID", "", iDataEntityModel.getName(), "PSDENOTIFY", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetBeginPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByBeginPSDEF(pSDEField);
        for (PSDENotify pSDENotify : arrayList) {
            PSDENotify pSDENotify2 = (PSDENotify)this.getDEModel().createEntity();
            pSDENotify2.setPSDENotifyId(pSDENotify.getPSDENotifyId());
            pSDENotify2.setBeginPSDEFId(null);
            this.update(pSDENotify2);
        }
    }

    public void removeByBeginPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyServiceBase.this.onBeforeRemoveByBeginPSDEF(pSDEField2);
                PSDENotifyServiceBase.this.internalRemoveByBeginPSDEF(pSDEField2);
                PSDENotifyServiceBase.this.onAfterRemoveByBeginPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByBeginPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByBeginPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByBeginPSDEF(pSDEField);
        this.onBeforeRemoveByBeginPSDEF(pSDEField, arrayList);
        for (PSDENotify pSDENotify : arrayList) {
            this.remove(pSDENotify);
        }
        this.onAfterRemoveByBeginPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByBeginPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByBeginPSDEF(PSDEField pSDEField, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBeginPSDEF(PSDEField pSDEField, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    public void testRemoveByEndPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByEndPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFY_PSDEFIELD_ENDPSDEFID", "", iDataEntityModel.getName(), "PSDENOTIFY", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetEndPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByEndPSDEF(pSDEField);
        for (PSDENotify pSDENotify : arrayList) {
            PSDENotify pSDENotify2 = (PSDENotify)this.getDEModel().createEntity();
            pSDENotify2.setPSDENotifyId(pSDENotify.getPSDENotifyId());
            pSDENotify2.setEndPSDEFId(null);
            this.update(pSDENotify2);
        }
    }

    public void removeByEndPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyServiceBase.this.onBeforeRemoveByEndPSDEF(pSDEField2);
                PSDENotifyServiceBase.this.internalRemoveByEndPSDEF(pSDEField2);
                PSDENotifyServiceBase.this.onAfterRemoveByEndPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByEndPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByEndPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByEndPSDEF(pSDEField);
        this.onBeforeRemoveByEndPSDEF(pSDEField, arrayList);
        for (PSDENotify pSDENotify : arrayList) {
            this.remove(pSDENotify);
        }
        this.onAfterRemoveByEndPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByEndPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByEndPSDEF(PSDEField pSDEField, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEndPSDEF(PSDEField pSDEField, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    public void testRemoveByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDEPrint(pSDEPrint, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPRINT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEPrint);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFY_PSDEPRINT_PSDEPRINTID", "", iDataEntityModel.getName(), "PSDENOTIFY", iDataEntityModel.getDataInfo(pSDEPrint), arrayList.get(0)));
        }
    }

    public void resetPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDEPrint(pSDEPrint);
        for (PSDENotify pSDENotify : arrayList) {
            PSDENotify pSDENotify2 = (PSDENotify)this.getDEModel().createEntity();
            pSDENotify2.setPSDENotifyId(pSDENotify.getPSDENotifyId());
            pSDENotify2.setPSDEPrintId(null);
            this.update(pSDENotify2);
        }
    }

    public void removeByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        final PSDEPrint pSDEPrint2 = pSDEPrint;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyServiceBase.this.onBeforeRemoveByPSDEPrint(pSDEPrint2);
                PSDENotifyServiceBase.this.internalRemoveByPSDEPrint(pSDEPrint2);
                PSDENotifyServiceBase.this.onAfterRemoveByPSDEPrint(pSDEPrint2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
    }

    protected void internalRemoveByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDEPrint(pSDEPrint);
        this.onBeforeRemoveByPSDEPrint(pSDEPrint, arrayList);
        for (PSDENotify pSDENotify : arrayList) {
            this.remove(pSDENotify);
        }
        this.onAfterRemoveByPSDEPrint(pSDEPrint, arrayList);
    }

    protected void onAfterRemoveByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
    }

    protected void onBeforeRemoveByPSDEPrint(PSDEPrint pSDEPrint, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEPrint(PSDEPrint pSDEPrint, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    public void testRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDEReport(pSDEReport, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEREPORT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEReport);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFY_PSDEREPORT_PSDEREPORTID", "", iDataEntityModel.getName(), "PSDENOTIFY", iDataEntityModel.getDataInfo(pSDEReport), arrayList.get(0)));
        }
    }

    public void resetPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDEReport(pSDEReport);
        for (PSDENotify pSDENotify : arrayList) {
            PSDENotify pSDENotify2 = (PSDENotify)this.getDEModel().createEntity();
            pSDENotify2.setPSDENotifyId(pSDENotify.getPSDENotifyId());
            pSDENotify2.setPSDEReportId(null);
            this.update(pSDENotify2);
        }
    }

    public void removeByPSDEReport(PSDEReport pSDEReport) throws Exception {
        final PSDEReport pSDEReport2 = pSDEReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyServiceBase.this.onBeforeRemoveByPSDEReport(pSDEReport2);
                PSDENotifyServiceBase.this.internalRemoveByPSDEReport(pSDEReport2);
                PSDENotifyServiceBase.this.onAfterRemoveByPSDEReport(pSDEReport2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void internalRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSDEReport(pSDEReport);
        this.onBeforeRemoveByPSDEReport(pSDEReport, arrayList);
        for (PSDENotify pSDENotify : arrayList) {
            this.remove(pSDENotify);
        }
        this.onAfterRemoveByPSDEReport(pSDEReport, arrayList);
    }

    protected void onAfterRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void onBeforeRemoveByPSDEReport(PSDEReport pSDEReport, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEReport(PSDEReport pSDEReport, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMsgQueue(PSSysMsgQueue pSSysMsgQueue) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSSysMsgQueue(pSSysMsgQueue, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGQUEUE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysMsgQueue);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFY_PSSYSMSGQUEUE_PSSYSMSGQUEUEID", "", iDataEntityModel.getName(), "PSDENOTIFY", iDataEntityModel.getDataInfo(pSSysMsgQueue), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgQueue(PSSysMsgQueue pSSysMsgQueue) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSSysMsgQueue(pSSysMsgQueue);
        for (PSDENotify pSDENotify : arrayList) {
            PSDENotify pSDENotify2 = (PSDENotify)this.getDEModel().createEntity();
            pSDENotify2.setPSDENotifyId(pSDENotify.getPSDENotifyId());
            pSDENotify2.setPSSysMsgQueueId(null);
            this.update(pSDENotify2);
        }
    }

    public void removeByPSSysMsgQueue(PSSysMsgQueue pSSysMsgQueue) throws Exception {
        final PSSysMsgQueue pSSysMsgQueue2 = pSSysMsgQueue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyServiceBase.this.onBeforeRemoveByPSSysMsgQueue(pSSysMsgQueue2);
                PSDENotifyServiceBase.this.internalRemoveByPSSysMsgQueue(pSSysMsgQueue2);
                PSDENotifyServiceBase.this.onAfterRemoveByPSSysMsgQueue(pSSysMsgQueue2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgQueue(PSSysMsgQueue pSSysMsgQueue) throws Exception {
    }

    protected void internalRemoveByPSSysMsgQueue(PSSysMsgQueue pSSysMsgQueue) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSSysMsgQueue(pSSysMsgQueue);
        this.onBeforeRemoveByPSSysMsgQueue(pSSysMsgQueue, arrayList);
        for (PSDENotify pSDENotify : arrayList) {
            this.remove(pSDENotify);
        }
        this.onAfterRemoveByPSSysMsgQueue(pSSysMsgQueue, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgQueue(PSSysMsgQueue pSSysMsgQueue) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgQueue(PSSysMsgQueue pSSysMsgQueue, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgQueue(PSSysMsgQueue pSSysMsgQueue, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFY_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSDENOTIFY", iDataEntityModel.getDataInfo(pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        for (PSDENotify pSDENotify : arrayList) {
            PSDENotify pSDENotify2 = (PSDENotify)this.getDEModel().createEntity();
            pSDENotify2.setPSDENotifyId(pSDENotify.getPSDENotifyId());
            pSDENotify2.setPSSysMsgTemplId(null);
            this.update(pSDENotify2);
        }
    }

    public void removeByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyServiceBase.this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSDENotifyServiceBase.this.internalRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSDENotifyServiceBase.this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSDENotify pSDENotify : arrayList) {
            this.remove(pSDENotify);
        }
        this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFY_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDENOTIFY", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDENotify pSDENotify : arrayList) {
            PSDENotify pSDENotify2 = (PSDENotify)this.getDEModel().createEntity();
            pSDENotify2.setPSDENotifyId(pSDENotify.getPSDENotifyId());
            pSDENotify2.setPSSysSFPluginId(null);
            this.update(pSDENotify2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDENotifyServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDENotifyServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDENotify> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDENotify pSDENotify : arrayList) {
            this.remove(pSDENotify);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDENotify> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDENotify pSDENotify) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDENotify(pSDENotify);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDENotify(pSDENotify);
        pSCoreSysServiceBase = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDENotifyTargetServiceBase)pSCoreSysServiceBase).testRemoveByPSDENotify(pSDENotify);
        ((PSDENotifyTargetServiceBase)pSCoreSysServiceBase).removeByPSDENotify(pSDENotify);
        super.onBeforeRemove(pSDENotify);
    }

    protected void onBeforeRemoveTemp(PSDENotify pSDENotify) throws Exception {
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        pSDENotifyTargetService.removeTempByPSDENotify(pSDENotify);
        super.onBeforeRemoveTemp(pSDENotify);
    }

    protected void getRelatedDataTempMajor(PSDENotify pSDENotify) throws Exception {
        this.getRelatedDataTempMajor_PSDENotifyTarget(pSDENotify);
        super.getRelatedDataTempMajor(pSDENotify);
    }

    protected void getRelatedDataTempMajor_PSDENotifyTarget(PSDENotify pSDENotify) throws Exception {
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDENotifyTarget> arrayList = null;
        String string = pSDENotify.getPSDENotifyId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDENotifyTargetService.selectByPSDENotify(pSDENotify) : pSDENotifyTargetService.selectTempByPSDENotify(pSDENotify);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            pSDENotifyTargetService.getTempMajor(pSDENotifyTarget);
        }
    }

    protected void updateRelatedDataTempMajor(PSDENotify pSDENotify, PSDENotify pSDENotify2) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.updateRelatedDataTempMajor_removePSDENotifyTarget(pSDENotify, pSDENotify2);
        this.updateRelatedDataTempMajor_updatePSDENotifyTarget(pSDENotify, pSDENotify2, arrayList);
        super.updateRelatedDataTempMajor(pSDENotify, pSDENotify2);
    }

    protected ArrayList<PSDENotifyTarget> updateRelatedDataTempMajor_removePSDENotifyTarget(PSDENotify pSDENotify, PSDENotify pSDENotify2) throws Exception {
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDENotifyTarget> arrayList = pSDENotifyTargetService.selectTempByPSDENotify(pSDENotify);
        ArrayList<PSDENotifyTarget> arrayList2 = pSDENotifyTargetService.selectByPSDENotify(pSDENotify2);
        HashMap<String, PSDENotifyTarget> hashMap = new HashMap<String, PSDENotifyTarget>();
        for (PSDENotifyTarget pSDENotifyTarget : arrayList2) {
            hashMap.put(pSDENotifyTarget.getPSDENotifyTargetId(), pSDENotifyTarget);
        }
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            Object object = pSDENotifyTarget.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDENotifyTarget pSDENotifyTarget : hashMap.values()) {
            pSDENotifyTargetService.remove(pSDENotifyTarget);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDENotifyTarget(PSDENotify pSDENotify, PSDENotify pSDENotify2, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            pSDENotifyTargetService.updateTempMajor(pSDENotifyTarget);
        }
    }

    protected void replaceParentInfo(PSDENotify pSDENotify, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDENotify, cloneSession);
        if (pSDENotify.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDENotify.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDENotify, (PSDataEntity)iEntity);
        }
        if (pSDENotify.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDENotify.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSDENotify, (PSDEDataSet)iEntity);
        }
        if (pSDENotify.getBeginPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDENotify.getBeginPSDEFId())) != null) {
            this.onFillParentInfo_BeginPSDEF(pSDENotify, (PSDEField)iEntity);
        }
        if (pSDENotify.getEndPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDENotify.getEndPSDEFId())) != null) {
            this.onFillParentInfo_EndPSDEF(pSDENotify, (PSDEField)iEntity);
        }
        if (pSDENotify.getPSDEPrintId() != null && (iEntity = cloneSession.getEntity("PSDEPRINT", (Object)pSDENotify.getPSDEPrintId())) != null) {
            this.onFillParentInfo_PSDEPrint(pSDENotify, (PSDEPrint)iEntity);
        }
        if (pSDENotify.getPSDEReportId() != null && (iEntity = cloneSession.getEntity("PSDEREPORT", (Object)pSDENotify.getPSDEReportId())) != null) {
            this.onFillParentInfo_PSDEReport(pSDENotify, (PSDEReport)iEntity);
        }
        if (pSDENotify.getPSSysMsgQueueId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGQUEUE", (Object)pSDENotify.getPSSysMsgQueueId())) != null) {
            this.onFillParentInfo_PSSysMsgQueue(pSDENotify, (PSSysMsgQueue)iEntity);
        }
        if (pSDENotify.getPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSDENotify.getPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_PSSysMsgTempl(pSDENotify, (PSSysMsgTempl)iEntity);
        }
        if (pSDENotify.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDENotify.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDENotify, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDENotify pSDENotify, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDENotify, bl);
    }

    protected void onCheckEntity(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AttachmentType(bl, pSDENotify, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginPSDEFId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginPSDEFName(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CheckTimer(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndPSDEFId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndPSDEFName(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventModel(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Events(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilterModel(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreException(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgType(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NotifyEnd(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NotifyStart(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NotifySubType(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NotifyTag(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NotifyTag2(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PropertyMap(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDENotifyId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDENotifyName(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEPrintId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEReportId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgQueueId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskMode(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplFlag(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadRunMode(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimerMode(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDENotify, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDENotify, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AttachmentType(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isAttachmentTypeDirty() : !pSDENotify.isAttachmentTypeDirty()) {
            return null;
        }
        String string = pSDENotify.getAttachmentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttachmentType_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTACHMENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginPSDEFId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isBeginPSDEFIdDirty() : !pSDENotify.isBeginPSDEFIdDirty()) {
            return null;
        }
        String string = pSDENotify.getBeginPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeginPSDEFId_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginPSDEFName(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isBeginPSDEFNameDirty() : !pSDENotify.isBeginPSDEFNameDirty()) {
            return null;
        }
        String string = pSDENotify.getBeginPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeginPSDEFName_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CheckTimer(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isCheckTimerDirty() : !pSDENotify.isCheckTimerDirty()) {
            return null;
        }
        Integer n = pSDENotify.getCheckTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CheckTimer_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHECKTIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isCodeNameDirty() && !bl2 : !pSDENotify.isCodeNameDirty()) {
            return null;
        }
        String string = pSDENotify.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDENotify, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDENotifyDEModel(), "CODENAME", string3, pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isCustomCodeDirty() : !pSDENotify.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDENotify.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isCustomCondDirty() : !pSDENotify.isCustomCondDirty()) {
            return null;
        }
        String string = pSDENotify.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isCustomModeDirty() : !pSDENotify.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDENotify.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isCustomTypeDirty() : !pSDENotify.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDENotify.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndPSDEFId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isEndPSDEFIdDirty() : !pSDENotify.isEndPSDEFIdDirty()) {
            return null;
        }
        String string = pSDENotify.getEndPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EndPSDEFId_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndPSDEFName(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isEndPSDEFNameDirty() : !pSDENotify.isEndPSDEFNameDirty()) {
            return null;
        }
        String string = pSDENotify.getEndPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EndPSDEFName_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventModel(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isEventModelDirty() : !pSDENotify.isEventModelDirty()) {
            return null;
        }
        String string = pSDENotify.getEventModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventModel_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Events(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isEventsDirty() : !pSDENotify.isEventsDirty()) {
            return null;
        }
        String string = pSDENotify.getEvents();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Events_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FilterModel(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isFilterModelDirty() : !pSDENotify.isFilterModelDirty()) {
            return null;
        }
        String string = pSDENotify.getFilterModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilterModel_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_IgnoreException(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isIgnoreExceptionDirty() : !pSDENotify.isIgnoreExceptionDirty()) {
            return null;
        }
        Integer n = pSDENotify.getIgnoreException();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreException_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREEXCEPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isMemoDirty() : !pSDENotify.isMemoDirty()) {
            return null;
        }
        String string = pSDENotify.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_MsgType(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isMsgTypeDirty() && !bl2 : !pSDENotify.isMsgTypeDirty()) {
            return null;
        }
        Integer n = pSDENotify.getMsgType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_MsgType_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NotifyEnd(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isNotifyEndDirty() : !pSDENotify.isNotifyEndDirty()) {
            return null;
        }
        Integer n = pSDENotify.getNotifyEnd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NotifyEnd_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOTIFYEND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NotifyStart(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isNotifyStartDirty() : !pSDENotify.isNotifyStartDirty()) {
            return null;
        }
        Integer n = pSDENotify.getNotifyStart();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NotifyStart_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOTIFYSTART");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NotifySubType(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isNotifySubTypeDirty() : !pSDENotify.isNotifySubTypeDirty()) {
            return null;
        }
        String string = pSDENotify.getNotifySubType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NotifySubType_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOTIFYSUBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NotifyTag(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isNotifyTagDirty() : !pSDENotify.isNotifyTagDirty()) {
            return null;
        }
        String string = pSDENotify.getNotifyTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NotifyTag_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOTIFYTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NotifyTag2(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isNotifyTag2Dirty() : !pSDENotify.isNotifyTag2Dirty()) {
            return null;
        }
        String string = pSDENotify.getNotifyTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NotifyTag2_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOTIFYTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PropertyMap(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPropertyMapDirty() : !pSDENotify.isPropertyMapDirty()) {
            return null;
        }
        String string = pSDENotify.getPropertyMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PropertyMap_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROPERTYMAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSDEDSIdDirty() : !pSDENotify.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDENotify.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSDEIdDirty() && !bl2 : !pSDENotify.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDENotify.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSDENameDirty() && !bl2 : !pSDENotify.isPSDENameDirty()) {
            return null;
        }
        String string = pSDENotify.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDENotifyId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSDENotifyIdDirty() && !bl2 : !pSDENotify.isPSDENotifyIdDirty()) {
            return null;
        }
        String string = pSDENotify.getPSDENotifyId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDENotifyId_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDENotifyName(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSDENotifyNameDirty() && !bl2 : !pSDENotify.isPSDENotifyNameDirty()) {
            return null;
        }
        String string = pSDENotify.getPSDENotifyName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDENotifyName_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDENotifyDEModel(), "PSDENOTIFYNAME", string3, pSDENotify, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDENOTIFYNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEPrintId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSDEPrintIdDirty() : !pSDENotify.isPSDEPrintIdDirty()) {
            return null;
        }
        String string = pSDENotify.getPSDEPrintId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEPrintId_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPRINTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEReportId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSDEReportIdDirty() : !pSDENotify.isPSDEReportIdDirty()) {
            return null;
        }
        String string = pSDENotify.getPSDEReportId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEReportId_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEREPORTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMsgQueueId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSSysMsgQueueIdDirty() && !bl2 : !pSDENotify.isPSSysMsgQueueIdDirty()) {
            return null;
        }
        String string = pSDENotify.getPSSysMsgQueueId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGQUEUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgQueueId_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGQUEUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSSysMsgTemplIdDirty() && !bl2 : !pSDENotify.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSDENotify.getPSSysMsgTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isPSSysSFPluginIdDirty() : !pSDENotify.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDENotify.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskMode(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isTaskModeDirty() : !pSDENotify.isTaskModeDirty()) {
            return null;
        }
        Integer n = pSDENotify.getTaskMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TaskMode_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplFlag(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isTemplFlagDirty() : !pSDENotify.isTemplFlagDirty()) {
            return null;
        }
        Integer n = pSDENotify.getTemplFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplFlag_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadRunMode(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isThreadRunModeDirty() : !pSDENotify.isThreadRunModeDirty()) {
            return null;
        }
        Integer n = pSDENotify.getThreadRunMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ThreadRunMode_Default(pSDENotify, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THREADRUNMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimerMode(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isTimerModeDirty() && !bl2 : !pSDENotify.isTimerModeDirty()) {
            return null;
        }
        Integer n = pSDENotify.getTimerMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMERMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_TimerMode_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isUserCatDirty() : !pSDENotify.isUserCatDirty()) {
            return null;
        }
        String string = pSDENotify.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isUserTagDirty() : !pSDENotify.isUserTagDirty()) {
            return null;
        }
        String string = pSDENotify.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isUserTag2Dirty() : !pSDENotify.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDENotify.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isUserTag3Dirty() : !pSDENotify.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDENotify.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isUserTag4Dirty() : !pSDENotify.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDENotify.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDENotify, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDENotify pSDENotify, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotify.isValidFlagDirty() && !bl2 : !pSDENotify.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDENotify.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDENotify, bl2, bl3);
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

    protected void onSyncEntity(PSDENotify pSDENotify, boolean bl) throws Exception {
        super.onSyncEntity(pSDENotify, bl);
    }

    protected void onSyncIndexEntities(PSDENotify pSDENotify, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDENotify, bl);
    }

    public Object getDataContextValue(PSDENotify pSDENotify, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDENotify, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDENotify pSDENotify, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDENotify, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ATTACHMENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttachmentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHECKTIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CheckTimer_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Events_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTERMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilterModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREEXCEPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreException_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOTIFYEND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NotifyEnd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOTIFYSTART", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NotifyStart_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOTIFYSUBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NotifySubType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOTIFYTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NotifyTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOTIFYTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NotifyTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROPERTYMAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PropertyMap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENOTIFYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDENotifyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENOTIFYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDENotifyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPRINTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEPrintId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPRINTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEPrintName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEReportId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEREPORTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEReportName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGQUEUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgQueueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGQUEUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgQueueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THREADRUNMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThreadRunMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimerMode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AttachmentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTACHMENTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeginPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEGINPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeginPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEGINPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CheckTimer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldValueRangeRule("CHECKTIMER", iEntity, bl2, new Double(0.0), true, new Double(1440.0), true, "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[0]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[1440]", false)) {
                return null;
            }
            return "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[0]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[1440]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_CustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCOND", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EndPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENDPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EndPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENDPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Events_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_IgnoreException_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MsgType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NotifyEnd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldValueRangeRule("NOTIFYEND", iEntity, bl2, new Double(-1440.0), true, new Double(1440.0), true, "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[-1440]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[1440]", false)) {
                return null;
            }
            return "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[-1440]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[1440]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NotifyStart_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldValueRangeRule("NOTIFYSTART", iEntity, bl2, new Double(-1440.0), true, new Double(1440.0), true, "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[-1440]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[1440]", false)) {
                return null;
            }
            return "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[-1440]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[1440]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NotifySubType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NOTIFYSUBTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NotifyTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NOTIFYTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NotifyTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NOTIFYTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PropertyMap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROPERTYMAP", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDENotifyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENOTIFYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDENotifyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENOTIFYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEPrintId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPRINTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEPrintName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPRINTNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEReportId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEREPORTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEReportName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEREPORTNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgQueueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGQUEUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgQueueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGQUEUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_TaskMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TemplFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ThreadRunMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TimerMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDENotify pSDENotify) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDENotify)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDENotify pSDENotify) throws Exception {
        super.onUpdateParent(pSDENotify);
    }

    @Override
    protected void exportCurXmlModel(PSDENotify pSDENotify, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDENOTIFY");
        if (!bl) {
            pSDENotify.setCreateDate(null);
            pSDENotify.setCreateMan(null);
            pSDENotify.setPSDENotifyId(null);
            pSDENotify.setUpdateDate(null);
            pSDENotify.setUpdateMan(null);
            super.exportCurXmlModel(pSDENotify, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDENotify pSDENotify, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDENotifyTarget(pSDENotify, xmlNode);
        super.onExportRelatedXmlModel(pSDENotify, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDENotifyTarget(PSDENotify pSDENotify, XmlNode xmlNode) throws Exception {
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDENotifyTarget> arrayList = null;
        String string = pSDENotify.getPSDENotifyId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDENotifyTargetService.selectByPSDENotify(pSDENotify) : pSDENotifyTargetService.selectTempByPSDENotify(pSDENotify);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDENOTIFYTARGETS");
            xmlNode.addNode(xmlNode2);
            for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
                pSDENotifyTargetService.exportXmlModel(pSDENotifyTarget, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDENotify pSDENotify, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDENOTIFYTARGETS");
        this.importRelatedXmlModel_PSDENotifyTarget(pSDENotify, xmlNode2);
        super.onImportRelatedXmlModel(pSDENotify, xmlNode);
    }

    protected void importRelatedXmlModel_PSDENotifyTarget(PSDENotify pSDENotify, XmlNode xmlNode) throws Exception {
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDENotify.getPSDENotifyId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDENotifyTargetService.removeByPSDENotify(pSDENotify);
        } else {
            pSDENotifyTargetService.removeTempByPSDENotify(pSDENotify);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDENotifyTarget pSDENotifyTarget = new PSDENotifyTarget();
                pSDENotifyTargetService.fillParentInfo(pSDENotifyTarget, "DER1N", "DER1N_PSDENOTIFYTARGET_PSDENOTIFY_PSDENOTIFYID", pSDENotify.getPSDENotifyId());
                pSDENotifyTargetService.importXmlModel(pSDENotifyTarget, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDENotify pSDENotify, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDENotify, string);
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
            return "DER1N_PSDENOTIFY_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDENotify pSDENotify) {
        if (!StringHelper.isNullOrEmpty((String)pSDENotify.getCodeName())) {
            return pSDENotify.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDENotify.getPSDENotifyName())) {
            return pSDENotify.getPSDENotifyName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDENotify.getCodeName())) {
            return pSDENotify.getCodeName();
        }
        return super.getModelV2Tag(pSDENotify);
    }

    @Override
    public boolean setModelV2Tag(PSDENotify pSDENotify, String string) {
        pSDENotify.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDENOTIFYNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDENOTIFYNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDENotify pSDENotify, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDENotify.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDENotify, true);
        pSDENotify.set("CODENAME", string);
        if (this.select(pSDENotify, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDENotify, true);
        return super.getModelV2Entity(pSDENotify, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDENotify pSDENotify, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDENotify, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDENOTIFYTARGET_PSDENOTIFY_PSDENOTIFYID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDENotify pSDENotify, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDENotify, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDENotify pSDENotify, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDENOTIFYTARGET_PSDENOTIFY_PSDENOTIFYID")) {
            PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDENOTIFY#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDENOTIFYTARGET", (Object)pSDENotify.getPSDENotifyId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDENOTIFY#%1$s", (Object)pSDENotify.getPSDENotifyId());
                for (PSDENotifyTarget target : pSDENotifyTargetService.selectByPSDENotify(pSDENotify)) {
                    String targetScope = pSDENotifyTargetService.getModelV2ResScope(target);
                    if (StringHelper.compare((String)scope, (String)targetScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(target, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String modelName = pSDENotifyTargetService.getModelV2Name(false);
                ArrayNode arrayNode = objectNode.putArray(modelName.toLowerCase());
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
                        if (objectNode.has("psdenotifytargetname")) {
                            string = objectNode.get("psdenotifytargetname").asText();
                        }
                        if (objectNode2.has("psdenotifytargetname")) {
                            string2 = objectNode2.get("psdenotifytargetname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode targetNode : arrayList) {
                    PSDENotifyTarget target = new PSDENotifyTarget();
                    PSModelV2Helper.fromJSONObject((IDataObject)target, targetNode, false);
                    arrayNode.add((JsonNode)pSDENotifyTargetService.exportModelV2(target, string));
                }
            }
        }
        super.onExportCurModelV2(pSDENotify, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDENotify pSDENotify) throws Exception {
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDENotifyTarget> arrayList = pSDENotifyTargetService.selectByPSDENotify(pSDENotify);
        String string = StringHelper.format((String)"PSDENOTIFY#%1$s", (Object)pSDENotify.getPSDENotifyId());
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            String string2 = pSDENotifyTargetService.getModelV2ResScope(pSDENotifyTarget);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDENotifyTargetService.emptyModelV2(pSDENotifyTarget);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDENotify.getPSDENotifyId());
        pSDENotifyTargetService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDENotifyTargetService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDENOTIFYTARGET WHERE PSDENOTIFYID = ?", sqlParamList);
        super.onEmptyModelV2(pSDENotify);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        if (pSDENotifyTargetService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDENotify pSDENotify, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDENotifyTarget pSDENotifyTarget = new PSDENotifyTarget();
        pSDENotifyTarget.set("PSDENOTIFYID", pSDENotify.getPSDENotifyId());
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDENotifyTargetService.getModelV2Entity(pSDENotifyTarget, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDENotify, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDENotify pSDENotify, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDENotifyTargetService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDENotifyTarget pSDENotifyTarget = new PSDENotifyTarget();
                pSDENotifyTarget.setPSDEId(pSDENotify.getPSDEId());
                pSDENotifyTarget.setPSDENotifyId(pSDENotify.getPSDENotifyId());
                pSDENotifyTarget.setPSDENotifyName(pSDENotify.getPSDENotifyName());
                pSDENotifyTargetService.compileModelV2(pSDENotifyTarget, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDENotifyTarget pSDENotifyTarget = new PSDENotifyTarget();
                    pSDENotifyTarget.setPSDEId(pSDENotify.getPSDEId());
                    pSDENotifyTarget.setPSDENotifyId(pSDENotify.getPSDENotifyId());
                    pSDENotifyTarget.setPSDENotifyName(pSDENotify.getPSDENotifyName());
                    pSDENotifyTargetService.compileModelV2(pSDENotifyTarget, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDENotify, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDENotify pSDENotify, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDENOTIFYTARGET_PSDENOTIFY_PSDENOTIFYID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDENotifyTargets(pSDENotify, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDENotify, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDENotifyTargets(PSDENotify pSDENotify, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDENOTIFYTARGET", true), (boolean)false) == 0) {
            PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
            PSDENotifyTarget pSDENotifyTarget = new PSDENotifyTarget();
            pSDENotifyTarget.setPSDENotifyTargetId(pSMOSFile.getPSModelId());
            if (!pSDENotifyTargetService.get(pSDENotifyTarget, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDENotifyTarget.getPSDENotifyId(), (String)pSDENotify.getPSDENotifyId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDENotifyTargetService.exportModelV2(pSDENotifyTarget);
            pSDENotifyTarget.reset();
            if (!pSDENotifyTargetService.setModelV2ResScope(pSDENotifyTarget, "PSDENOTIFY", pSDENotify.getPSDENotifyId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDENotifyTargetService.importModelV2(pSDENotifyTarget, objectNode);
            SessionFactoryManager.commit();
            return pSDENotifyTargetService.getFile(pSDENotifyTarget);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDENotify pSDENotify, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDENotifyTargets(pSDENotify, list);
        super.onFillPasteHelps(pSDENotify, list);
    }

    protected void onFillPasteHelps_PSDENotifyTargets(PSDENotify pSDENotify, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDENOTIFYTARGET");
        pSHelpSection.setSectionParam2("DER1N_PSDENOTIFYTARGET_PSDENOTIFY_PSDENOTIFYID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u901a\u77e5]\u7684[\u5b9e\u4f53\u901a\u77e5\u76ee\u6807]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDENotify pSDENotify, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Notify");
        defaultValueMap.put("PSDENOTIFYNAME", "\u901a\u77e5");
    }
}
