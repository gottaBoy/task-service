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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDataImpDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataImpDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImpItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataImpServiceBase
extends PSCoreSysServiceBase<PSDEDataImp> {
    private static final Log log = LogFactory.getLog(PSDEDataImpServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEDataImpDEModel pSDEDataImpDEModel;
    private PSDEDataImpDAO pSDEDataImpDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService";
    }

    public PSDEDataImpDEModel getPSDEDataImpDEModel() {
        if (this.pSDEDataImpDEModel == null) {
            try {
                this.pSDEDataImpDEModel = (PSDEDataImpDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataImpDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataImpDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDataImpDEModel();
    }

    public PSDEDataImpDAO getPSDEDataImpDAO() {
        if (this.pSDEDataImpDAO == null) {
            try {
                this.pSDEDataImpDAO = (PSDEDataImpDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDataImpDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataImpDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDataImpDAO();
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

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, true);
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

    protected void onFillParentInfo(PSDEDataImp pSDEDataImp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAIMP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDataImp, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAIMP_PSDEACTION_CREATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_CreatePSDEAction(pSDEDataImp, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAIMP_PSDEACTION_UPDATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_UpdatePSDEAction(pSDEDataImp, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAIMP_PSDEOPPRIV_CREATEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_CreatePSDEOPPriv(pSDEDataImp, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAIMP_PSDEOPPRIV_UPDATEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_UpdatePSDEOPPriv(pSDEDataImp, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAIMP_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEDataImp, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAIMP_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEDataImp, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAIMP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEDataImp, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo(pSDEDataImp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEDataImp pSDEDataImp, PSDataEntity pSDataEntity) throws Exception {
        pSDEDataImp.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDataImp.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_CreatePSDEAction(PSDEDataImp pSDEDataImp, PSDEAction pSDEAction) throws Exception {
        pSDEDataImp.setCreatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataImp.setCreatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UpdatePSDEAction(PSDEDataImp pSDEDataImp, PSDEAction pSDEAction) throws Exception {
        pSDEDataImp.setUpdatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataImp.setUpdatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_CreatePSDEOPPriv(PSDEDataImp pSDEDataImp, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEDataImp.setCreatePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEDataImp.setCreatePSDEOPPrivIName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_UpdatePSDEOPPriv(PSDEDataImp pSDEDataImp, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEDataImp.setUpdatePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEDataImp.setUpdatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEDataImp pSDEDataImp, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEDataImp.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEDataImp.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEDataImp pSDEDataImp, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEDataImp.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEDataImp.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEDataImp pSDEDataImp, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEDataImp.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEDataImp.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDataImp.getCodeName() == null) {
                pSDEDataImp.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DataImport", 25));
            }
            if (pSDEDataImp.getPSDEDataImpName() == null) {
                pSDEDataImp.setPSDEDataImpName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u6570\u636e\u5bfc\u5165", 25));
            }
            if (pSDEDataImp.getValidFlag() == null) {
                pSDEDataImp.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEDataImp, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDataImp, bl);
        this.onFillEntityFullInfo_CreatePSDEAction(pSDEDataImp, bl);
        this.onFillEntityFullInfo_UpdatePSDEAction(pSDEDataImp, bl);
        this.onFillEntityFullInfo_CreatePSDEOPPriv(pSDEDataImp, bl);
        this.onFillEntityFullInfo_UpdatePSDEOPPriv(pSDEDataImp, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEDataImp, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEDataImp, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEDataImp, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CreatePSDEAction(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
        if (pSDEDataImp.isCreatePSDEActionIdDirty()) {
            if (pSDEDataImp.getCreatePSDEActionId() != null) {
                if (pSDEDataImp.getCreatePSDEActionId() == null || pSDEDataImp.getCreatePSDEActionName() == null) {
                    PSDEAction pSDEAction = pSDEDataImp.getCreatePSDEAction();
                    pSDEDataImp.setCreatePSDEActionName(pSDEAction.getPSDEActionName());
                }
            } else {
                pSDEDataImp.setCreatePSDEActionName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UpdatePSDEAction(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
        if (pSDEDataImp.isUpdatePSDEActionIdDirty()) {
            if (pSDEDataImp.getUpdatePSDEActionId() != null) {
                if (pSDEDataImp.getUpdatePSDEActionId() == null || pSDEDataImp.getUpdatePSDEActionName() == null) {
                    PSDEAction pSDEAction = pSDEDataImp.getUpdatePSDEAction();
                    pSDEDataImp.setUpdatePSDEActionName(pSDEAction.getPSDEActionName());
                }
            } else {
                pSDEDataImp.setUpdatePSDEActionName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CreatePSDEOPPriv(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
        if (pSDEDataImp.isCreatePSDEOPPrivIdDirty()) {
            if (pSDEDataImp.getCreatePSDEOPPrivId() != null) {
                if (pSDEDataImp.getCreatePSDEOPPrivId() == null || pSDEDataImp.getCreatePSDEOPPrivIName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSDEDataImp.getCreatePSDEOPPriv();
                    pSDEDataImp.setCreatePSDEOPPrivIName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSDEDataImp.setCreatePSDEOPPrivIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UpdatePSDEOPPriv(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
        if (pSDEDataImp.isUpdatePSDEOPPrivIdDirty()) {
            if (pSDEDataImp.getUpdatePSDEOPPrivId() != null) {
                if (pSDEDataImp.getUpdatePSDEOPPrivId() == null || pSDEDataImp.getUpdatePSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSDEDataImp.getUpdatePSDEOPPriv();
                    pSDEDataImp.setUpdatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSDEDataImp.setUpdatePSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEDataImp, bl);
    }

    public ArrayList<PSDEDataImp> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDataImp> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDataImp> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataImp> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataImp> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataImp> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CREATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCreatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCreatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataImp> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataImp> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataImp> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPDATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUpdatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUpdatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataImp> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByCreatePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEDataImp> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByCreatePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEDataImp> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CREATEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCreatePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCreatePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataImp> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByUpdatePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEDataImp> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByUpdatePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEDataImp> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPDATEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUpdatePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUpdatePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataImp> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEDataImp> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEDataImp> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataImp> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEDataImp> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEDataImp> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataImp> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEDataImp> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEDataImp> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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
        ArrayList<PSDEDataImp> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            PSDEDataImp pSDEDataImp2 = (PSDEDataImp)this.getDEModel().createEntity();
            pSDEDataImp2.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
            pSDEDataImp2.setPSDEId(null);
            this.update(pSDEDataImp2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataImpServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDataImpServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDataImpServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            this.remove(pSDEDataImp);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByCreatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAIMP_PSDEACTION_CREATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAIMP", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            PSDEDataImp pSDEDataImp2 = (PSDEDataImp)this.getDEModel().createEntity();
            pSDEDataImp2.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
            pSDEDataImp2.setCreatePSDEActionId(null);
            this.update(pSDEDataImp2);
        }
    }

    public void removeByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataImpServiceBase.this.onBeforeRemoveByCreatePSDEAction(pSDEAction2);
                PSDEDataImpServiceBase.this.internalRemoveByCreatePSDEAction(pSDEAction2);
                PSDEDataImpServiceBase.this.onAfterRemoveByCreatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        this.onBeforeRemoveByCreatePSDEAction(pSDEAction, arrayList);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            this.remove(pSDEDataImp);
        }
        this.onAfterRemoveByCreatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByUpdatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAIMP_PSDEACTION_UPDATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAIMP", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            PSDEDataImp pSDEDataImp2 = (PSDEDataImp)this.getDEModel().createEntity();
            pSDEDataImp2.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
            pSDEDataImp2.setUpdatePSDEActionId(null);
            this.update(pSDEDataImp2);
        }
    }

    public void removeByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataImpServiceBase.this.onBeforeRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEDataImpServiceBase.this.internalRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEDataImpServiceBase.this.onAfterRemoveByUpdatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        this.onBeforeRemoveByUpdatePSDEAction(pSDEAction, arrayList);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            this.remove(pSDEDataImp);
        }
        this.onAfterRemoveByUpdatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAIMP_PSDEOPPRIV_CREATEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEDATAIMP", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            PSDEDataImp pSDEDataImp2 = (PSDEDataImp)this.getDEModel().createEntity();
            pSDEDataImp2.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
            pSDEDataImp2.setCreatePSDEOPPrivId(null);
            this.update(pSDEDataImp2);
        }
    }

    public void removeByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataImpServiceBase.this.onBeforeRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
                PSDEDataImpServiceBase.this.internalRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
                PSDEDataImpServiceBase.this.onAfterRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByCreatePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            this.remove(pSDEDataImp);
        }
        this.onAfterRemoveByCreatePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAIMP_PSDEOPPRIV_UPDATEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEDATAIMP", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            PSDEDataImp pSDEDataImp2 = (PSDEDataImp)this.getDEModel().createEntity();
            pSDEDataImp2.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
            pSDEDataImp2.setUpdatePSDEOPPrivId(null);
            this.update(pSDEDataImp2);
        }
    }

    public void removeByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataImpServiceBase.this.onBeforeRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
                PSDEDataImpServiceBase.this.internalRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
                PSDEDataImpServiceBase.this.onAfterRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByUpdatePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            this.remove(pSDEDataImp);
        }
        this.onAfterRemoveByUpdatePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAIMP_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEDATAIMP", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            PSDEDataImp pSDEDataImp2 = (PSDEDataImp)this.getDEModel().createEntity();
            pSDEDataImp2.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
            pSDEDataImp2.setPSSysPFPluginId(null);
            this.update(pSDEDataImp2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataImpServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataImpServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataImpServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            this.remove(pSDEDataImp);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAIMP_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEDATAIMP", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            PSDEDataImp pSDEDataImp2 = (PSDEDataImp)this.getDEModel().createEntity();
            pSDEDataImp2.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
            pSDEDataImp2.setPSSysReqItemId(null);
            this.update(pSDEDataImp2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataImpServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEDataImpServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEDataImpServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            this.remove(pSDEDataImp);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAIMP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEDATAIMP", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            PSDEDataImp pSDEDataImp2 = (PSDEDataImp)this.getDEModel().createEntity();
            pSDEDataImp2.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
            pSDEDataImp2.setPSSysSFPluginId(null);
            this.update(pSDEDataImp2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataImpServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEDataImpServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEDataImpServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDataImp> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEDataImp pSDEDataImp : arrayList) {
            this.remove(pSDEDataImp);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEDataImp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDataImp pSDEDataImp) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataImp(pSDEDataImp);
        ((PSDEDataImpItemServiceBase)pSCoreSysServiceBase).removeByPSDEDataImp(pSDEDataImp);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataImp(pSDEDataImp);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEDataImp(pSDEDataImp);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataImp(pSDEDataImp);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataImp(pSDEDataImp);
        super.onBeforeRemove(pSDEDataImp);
    }

    protected void onBeforeRemoveTemp(PSDEDataImp pSDEDataImp) throws Exception {
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        pSDEDataImpItemService.removeTempByPSDEDataImp(pSDEDataImp);
        super.onBeforeRemoveTemp(pSDEDataImp);
    }

    protected void getRelatedDataTempMajor(PSDEDataImp pSDEDataImp) throws Exception {
        this.getRelatedDataTempMajor_PSDEDataImpItem(pSDEDataImp);
        super.getRelatedDataTempMajor(pSDEDataImp);
    }

    protected void getRelatedDataTempMajor_PSDEDataImpItem(PSDEDataImp pSDEDataImp) throws Exception {
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDataImpItem> arrayList = null;
        String string = pSDEDataImp.getPSDEDataImpId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDataImpItemService.selectByPSDEDataImp(pSDEDataImp) : pSDEDataImpItemService.selectTempByPSDEDataImp(pSDEDataImp);
        for (PSDEDataImpItem pSDEDataImpItem : arrayList) {
            pSDEDataImpItemService.getTempMajor(pSDEDataImpItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEDataImp pSDEDataImp, PSDEDataImp pSDEDataImp2) throws Exception {
        ArrayList<PSDEDataImpItem> arrayList = this.updateRelatedDataTempMajor_removePSDEDataImpItem(pSDEDataImp, pSDEDataImp2);
        this.updateRelatedDataTempMajor_updatePSDEDataImpItem(pSDEDataImp, pSDEDataImp2, arrayList);
        super.updateRelatedDataTempMajor(pSDEDataImp, pSDEDataImp2);
    }

    protected ArrayList<PSDEDataImpItem> updateRelatedDataTempMajor_removePSDEDataImpItem(PSDEDataImp pSDEDataImp, PSDEDataImp pSDEDataImp2) throws Exception {
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDataImpItem> arrayList = pSDEDataImpItemService.selectTempByPSDEDataImp(pSDEDataImp);
        ArrayList<PSDEDataImpItem> arrayList2 = pSDEDataImpItemService.selectByPSDEDataImp(pSDEDataImp2);
        HashMap<String, PSDEDataImpItem> hashMap = new HashMap<String, PSDEDataImpItem>();
        for (PSDEDataImpItem pSDEDataImpItem : arrayList2) {
            hashMap.put(pSDEDataImpItem.getPSDEDataImpItemId(), pSDEDataImpItem);
        }
        for (PSDEDataImpItem pSDEDataImpItem : arrayList) {
            Object object = pSDEDataImpItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDataImpItem pSDEDataImpItem : hashMap.values()) {
            pSDEDataImpItemService.remove(pSDEDataImpItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDataImpItem(PSDEDataImp pSDEDataImp, PSDEDataImp pSDEDataImp2, ArrayList<PSDEDataImpItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDataImpItem pSDEDataImpItem : arrayList) {
            pSDEDataImpItemService.updateTempMajor(pSDEDataImpItem);
        }
    }

    protected void replaceParentInfo(PSDEDataImp pSDEDataImp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEDataImp, cloneSession);
        if (pSDEDataImp.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDataImp.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDataImp, (PSDataEntity)iEntity);
        }
        if (pSDEDataImp.getCreatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataImp.getCreatePSDEActionId())) != null) {
            this.onFillParentInfo_CreatePSDEAction(pSDEDataImp, (PSDEAction)iEntity);
        }
        if (pSDEDataImp.getUpdatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataImp.getUpdatePSDEActionId())) != null) {
            this.onFillParentInfo_UpdatePSDEAction(pSDEDataImp, (PSDEAction)iEntity);
        }
        if (pSDEDataImp.getCreatePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEDataImp.getCreatePSDEOPPrivId())) != null) {
            this.onFillParentInfo_CreatePSDEOPPriv(pSDEDataImp, (PSDEOPPriv)iEntity);
        }
        if (pSDEDataImp.getUpdatePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEDataImp.getUpdatePSDEOPPrivId())) != null) {
            this.onFillParentInfo_UpdatePSDEOPPriv(pSDEDataImp, (PSDEOPPriv)iEntity);
        }
        if (pSDEDataImp.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEDataImp.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEDataImp, (PSSysPFPlugin)iEntity);
        }
        if (pSDEDataImp.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEDataImp.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEDataImp, (PSSysReqItem)iEntity);
        }
        if (pSDEDataImp.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEDataImp.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEDataImp, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEDataImp, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionHolder(bl, pSDEDataImp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BatchSize(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEActionId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEActionName(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEOPPrivId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEOPPrivIName(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataImpType(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomized(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImpParams(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImpTag(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImpTag2(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_POTime(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataImpId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataImpName(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StopWhenError(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEActionId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEActionName(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEOPPrivId(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEOPPrivName(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEDataImp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEDataImp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionHolder(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isActionHolderDirty() : !pSDEDataImp.isActionHolderDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getActionHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionHolder_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BatchSize(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isBatchSizeDirty() : !pSDEDataImp.isBatchSizeDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getBatchSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BatchSize_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BATCHSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isCodeNameDirty() && !bl2 : !pSDEDataImp.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDataImp.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEDataImp, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEDataImpDEModel(), "CODENAME", string3, pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isContentTypeDirty() : !pSDEDataImp.isContentTypeDirty()) {
            return null;
        }
        String string = pSDEDataImp.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreatePSDEActionId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isCreatePSDEActionIdDirty() : !pSDEDataImp.isCreatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getCreatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEActionId_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatePSDEActionName(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isCreatePSDEActionNameDirty() : !pSDEDataImp.isCreatePSDEActionNameDirty()) {
            return null;
        }
        String string = pSDEDataImp.getCreatePSDEActionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEActionName_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatePSDEOPPrivId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isCreatePSDEOPPrivIdDirty() : !pSDEDataImp.isCreatePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getCreatePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEOPPrivId_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatePSDEOPPrivIName(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isCreatePSDEOPPrivINameDirty() : !pSDEDataImp.isCreatePSDEOPPrivINameDirty()) {
            return null;
        }
        String string = pSDEDataImp.getCreatePSDEOPPrivIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEOPPrivIName_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEOPPRIVINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isCustomCodeDirty() : !pSDEDataImp.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEDataImp.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isCustomModeDirty() : !pSDEDataImp.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataImpType(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isDataImpTypeDirty() : !pSDEDataImp.isDataImpTypeDirty()) {
            return null;
        }
        String string = pSDEDataImp.getDataImpType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataImpType_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAIMPTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isDefaultFlagDirty() : !pSDEDataImp.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSDEDataImp, bl2, bl3);
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
                String string2 = this.checkFieldDupRule(this.getPSDEDataImpDEModel(), "DEFAULTFLAG", string, pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isDynaModelFlagDirty() : !pSDEDataImp.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableCustomized(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isEnableCustomizedDirty() : !pSDEDataImp.isEnableCustomizedDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getEnableCustomized();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomized_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isExtendModeDirty() : !pSDEDataImp.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImpParams(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isImpParamsDirty() : !pSDEDataImp.isImpParamsDirty()) {
            return null;
        }
        String string = pSDEDataImp.getImpParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ImpParams_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImpTag(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isImpTagDirty() : !pSDEDataImp.isImpTagDirty()) {
            return null;
        }
        String string = pSDEDataImp.getImpTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ImpTag_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImpTag2(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isImpTag2Dirty() : !pSDEDataImp.isImpTag2Dirty()) {
            return null;
        }
        String string = pSDEDataImp.getImpTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ImpTag2_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isLockFlagDirty() : !pSDEDataImp.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isMemoDirty() : !pSDEDataImp.isMemoDirty()) {
            return null;
        }
        String string = pSDEDataImp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_POTime(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isPOTimeDirty() : !pSDEDataImp.isPOTimeDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getPOTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_POTime_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataImpId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isPSDEDataImpIdDirty() && !bl2 : !pSDEDataImp.isPSDEDataImpIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getPSDEDataImpId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAIMPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataImpId_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAIMPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataImpName(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isPSDEDataImpNameDirty() && !bl2 : !pSDEDataImp.isPSDEDataImpNameDirty()) {
            return null;
        }
        String string = pSDEDataImp.getPSDEDataImpName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAIMPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataImpName_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAIMPNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEDataImpDEModel(), "PSDEDATAIMPNAME", string3, pSDEDataImp, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDATAIMPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isPSDEIdDirty() && !bl2 : !pSDEDataImp.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isPSDynaInstIdDirty() : !pSDEDataImp.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isPSSysPFPluginIdDirty() : !pSDEDataImp.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isPSSysReqItemIdDirty() : !pSDEDataImp.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isPSSysSFPluginIdDirty() : !pSDEDataImp.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_StopWhenError(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isStopWhenErrorDirty() : !pSDEDataImp.isStopWhenErrorDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getStopWhenError();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StopWhenError_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STOPWHENERROR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isToDoTaskDirty() : !pSDEDataImp.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEDataImp.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UpdatePSDEActionId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isUpdatePSDEActionIdDirty() : !pSDEDataImp.isUpdatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getUpdatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEActionId_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEActionName(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isUpdatePSDEActionNameDirty() : !pSDEDataImp.isUpdatePSDEActionNameDirty()) {
            return null;
        }
        String string = pSDEDataImp.getUpdatePSDEActionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEActionName_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEOPPrivId(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isUpdatePSDEOPPrivIdDirty() : !pSDEDataImp.isUpdatePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEDataImp.getUpdatePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEOPPrivId_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEOPPrivName(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isUpdatePSDEOPPrivNameDirty() : !pSDEDataImp.isUpdatePSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSDEDataImp.getUpdatePSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEOPPrivName_Default(pSDEDataImp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isUserCatDirty() : !pSDEDataImp.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDataImp.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isUserTagDirty() : !pSDEDataImp.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDataImp.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isUserTag2Dirty() : !pSDEDataImp.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDataImp.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isUserTag3Dirty() : !pSDEDataImp.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDataImp.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isUserTag4Dirty() : !pSDEDataImp.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDataImp.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEDataImp, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEDataImp pSDEDataImp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataImp.isValidFlagDirty() && !bl2 : !pSDEDataImp.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataImp.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEDataImp, bl2, bl3);
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

    protected void onSyncEntity(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
        super.onSyncEntity(pSDEDataImp, bl);
    }

    protected void onSyncIndexEntities(PSDEDataImp pSDEDataImp, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEDataImp, bl);
    }

    public Object getDataContextValue(PSDEDataImp pSDEDataImp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEDataImp, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDataImp pSDEDataImp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEDataImp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BATCHSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BatchSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEOPPRIVINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEOPPrivIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAIMPTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataImpType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMIZED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomized_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImpParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImpTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImpTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_POTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAIMPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataImpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAIMPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataImpName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"STOPWHENERROR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StopWhenError_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEOPPrivName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ActionHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BatchSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_CreatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEOPPrivIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEOPPRIVINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DataImpType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAIMPTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCustomized_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ImpParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImpTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImpTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_POTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDataImpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAIMPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataImpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAIMPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_StopWhenError_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UpdatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSDEDataImp pSDEDataImp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEDataImp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDataImp pSDEDataImp) throws Exception {
        Object object = pSDEDataImp.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDATAIMP_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEDataImp);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEDataImp pSDEDataImp, Object object) throws Exception {
        PSDEDataImp pSDEDataImp2 = new PSDEDataImp();
        pSDEDataImp2.set("PSDEDATAIMPID", object);
        String string = DataObject.getStringValue((Object)pSDEDataImp.get("PSDEDATAIMPID"));
        super.onCopyDetails(pSDEDataImp, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEDataImp pSDEDataImp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDATAIMP");
        if (!bl) {
            pSDEDataImp.setCreateDate(null);
            pSDEDataImp.setCreateMan(null);
            pSDEDataImp.setPSDEDataImpId(null);
            pSDEDataImp.setUpdateDate(null);
            pSDEDataImp.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDataImp, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEDataImp pSDEDataImp, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEDataImpItem(pSDEDataImp, xmlNode);
        super.onExportRelatedXmlModel(pSDEDataImp, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEDataImpItem(PSDEDataImp pSDEDataImp, XmlNode xmlNode) throws Exception {
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDataImpItem> arrayList = null;
        String string = pSDEDataImp.getPSDEDataImpId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDataImpItemService.selectByPSDEDataImp(pSDEDataImp, "ORDER BY ORDERVALUE ASC") : pSDEDataImpItemService.selectTempByPSDEDataImp(pSDEDataImp, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEDATAIMPITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSDEDataImpItem pSDEDataImpItem : arrayList) {
                pSDEDataImpItem.set("ORDERVALUE", null);
                pSDEDataImpItemService.exportXmlModel(pSDEDataImpItem, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEDataImp pSDEDataImp, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEDATAIMPITEMS");
        this.importRelatedXmlModel_PSDEDataImpItem(pSDEDataImp, xmlNode2);
        super.onImportRelatedXmlModel(pSDEDataImp, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEDataImpItem(PSDEDataImp pSDEDataImp, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEDataImp.getPSDEDataImpId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEDataImpItemService.removeByPSDEDataImp(pSDEDataImp);
        } else {
            pSDEDataImpItemService.removeTempByPSDEDataImp(pSDEDataImp);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEDataImpItem pSDEDataImpItem = new PSDEDataImpItem();
                pSDEDataImpItem.setOrderValue(n);
                n += 100;
                pSDEDataImpItemService.fillParentInfo(pSDEDataImpItem, "DER1N", "DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID", pSDEDataImp.getPSDEDataImpId());
                pSDEDataImpItemService.importXmlModel(pSDEDataImpItem, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDataImp pSDEDataImp, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDataImp, string);
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
            return "DER1N_PSDEDATAIMP_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEDataImp pSDEDataImp) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDataImp.getCodeName())) {
            return pSDEDataImp.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDataImp.getPSDEDataImpName())) {
            return pSDEDataImp.getPSDEDataImpName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDataImp.getCodeName())) {
            return pSDEDataImp.getCodeName();
        }
        return super.getModelV2Tag(pSDEDataImp);
    }

    @Override
    public boolean setModelV2Tag(PSDEDataImp pSDEDataImp, String string) {
        pSDEDataImp.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEDATAIMPNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEDATAIMPNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDataImp pSDEDataImp, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDataImp.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDataImp, true);
        pSDEDataImp.set("CODENAME", string);
        if (this.select(pSDEDataImp, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDataImp, true);
        return super.getModelV2Entity(pSDEDataImp, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDataImp pSDEDataImp, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDataImp, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEDataImp pSDEDataImp, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEDataImp, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEDataImp pSDEDataImp, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID")) {
            PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATAIMP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDATAIMPITEM", (Object)pSDEDataImp.getPSDEDataImpId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEDATAIMP#%1$s", (Object)pSDEDataImp.getPSDEDataImpId());
                for (PSDEDataImpItem item : pSDEDataImpItemService.selectByPSDEDataImp(pSDEDataImp)) {
                    String itemScope = pSDEDataImpItemService.getModelV2ResScope(item);
                    if (StringHelper.compare((String)scope, (String)itemScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSDEDataImpItemService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdedataimpitemname")) {
                            string = objectNode.get("psdedataimpitemname").asText();
                        }
                        if (objectNode2.has("psdedataimpitemname")) {
                            string2 = objectNode2.get("psdedataimpitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode itemNode : arrayList) {
                    PSDEDataImpItem item = new PSDEDataImpItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, itemNode, false);
                    output.add((JsonNode)pSDEDataImpItemService.exportModelV2(item, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEDataImp, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEDataImp pSDEDataImp) throws Exception {
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDataImpItem> arrayList = pSDEDataImpItemService.selectByPSDEDataImp(pSDEDataImp);
        String string = StringHelper.format((String)"PSDEDATAIMP#%1$s", (Object)pSDEDataImp.getPSDEDataImpId());
        for (PSDEDataImpItem pSDEDataImpItem : arrayList) {
            String string2 = pSDEDataImpItemService.getModelV2ResScope(pSDEDataImpItem);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEDataImpItemService.emptyModelV2(pSDEDataImpItem);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEDataImp.getPSDEDataImpId());
        pSDEDataImpItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEDataImpItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDATAIMPITEM WHERE PSDEDATAIMPID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEDataImp);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEDataImpItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEDataImp pSDEDataImp, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEDataImpItem pSDEDataImpItem = new PSDEDataImpItem();
        pSDEDataImpItem.set("PSDEDATAIMPID", pSDEDataImp.getPSDEDataImpId());
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEDataImpItemService.getModelV2Entity(pSDEDataImpItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEDataImp, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEDataImp pSDEDataImp, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEDataImpItemService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEDataImpItem pSDEDataImpItem = new PSDEDataImpItem();
                pSDEDataImpItem.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
                pSDEDataImpItem.setPSDEDataImpName(pSDEDataImp.getPSDEDataImpName());
                pSDEDataImpItem.setPSDEId(pSDEDataImp.getPSDEId());
                pSDEDataImpItemService.compileModelV2(pSDEDataImpItem, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEDataImpItem pSDEDataImpItem = new PSDEDataImpItem();
                    pSDEDataImpItem.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
                    pSDEDataImpItem.setPSDEDataImpName(pSDEDataImp.getPSDEDataImpName());
                    pSDEDataImpItem.setPSDEId(pSDEDataImp.getPSDEId());
                    pSDEDataImpItemService.compileModelV2(pSDEDataImpItem, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEDataImp, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEDataImp pSDEDataImp, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEDataImpItems(pSDEDataImp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEDataImp, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEDataImpItems(PSDEDataImp pSDEDataImp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDATAIMPITEM", true), (boolean)false) == 0) {
            PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
            PSDEDataImpItem pSDEDataImpItem = new PSDEDataImpItem();
            pSDEDataImpItem.setPSDEDataImpItemId(pSMOSFile.getPSModelId());
            if (!pSDEDataImpItemService.get(pSDEDataImpItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEDataImpItem.getPSDEDataImpId(), (String)pSDEDataImp.getPSDEDataImpId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEDataImpItemService.exportModelV2(pSDEDataImpItem);
            pSDEDataImpItem.reset();
            if (!pSDEDataImpItemService.setModelV2ResScope(pSDEDataImpItem, "PSDEDATAIMP", pSDEDataImp.getPSDEDataImpId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEDataImpItemService.importModelV2(pSDEDataImpItem, objectNode);
            SessionFactoryManager.commit();
            return pSDEDataImpItemService.getFile(pSDEDataImpItem);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFIELD", true), (boolean)false) == 0) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEFieldId(pSMOSFile.getPSModelId());
            if (!pSDEFieldService.get(pSDEField, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
            PSDEDataImpItem pSDEDataImpItem = new PSDEDataImpItem();
            pSDEDataImpItem.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
            pSDEDataImpItem.setPSDEFId(pSDEField.getPSDEFieldId());
            this.fillPasteEntity(pSDEDataImpItem, "PASTETAG");
            pSDEDataImpItemService.create(pSDEDataImpItem);
            if (StringHelper.compare((String)pSDEField.getPSDEId(), (String)pSDEDataImpItem.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEDataImpItemService.getFile(pSDEDataImpItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEDataImp pSDEDataImp, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEDataImpItems(pSDEDataImp, list);
        super.onFillPasteHelps(pSDEDataImp, list);
    }

    protected void onFillPasteHelps_PSDEDataImpItems(PSDEDataImp pSDEDataImp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEDATAIMPITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u6570\u636e\u5bfc\u5165]\u7684[\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u9879]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEDATAIMPITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID");
        pSHelpSection.setUserTag("DER1N_PSDEDATAIMPITEM_PSDEFIELD_PSDEFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u5c5e\u6027\u7684[\u5b9e\u4f53\u5c5e\u6027]\u6784\u5efa[\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5bfc\u5165\u9879>", "DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID", "PSDEDATAIMPID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSDEDataImpServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5bfc\u5165\u9879>");
            } else if (PSDEDataImpServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdedataimpitems");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID|PSDEDATAIMPID");
            pSMOSFile2.setFileTag3("PSDEDATAIMPITEM");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID", "PSDEDATAIMPID", pSMOSFile.getPSModelId(), "", "")) {
                PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEDataImpItemService, "DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID", "PSDEDATAIMPID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSDEDataImpItemService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEDataImpServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSDEDataImpServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5bfc\u5165\u9879>", (boolean)false) == 0 || PSDEDataImpServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEDataImpItems", (boolean)true) == 0) {
            PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEDataImpItemService, "DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID", "PSDEDATAIMPID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSDEDataImpItem> arrayList2 = pSDEDataImpItemService.selectEx((ISelectContext)selectContext);
            for (PSDEDataImpItem pSDEDataImpItem : arrayList2) {
                PSMOSFile pSMOSFile2 = pSDEDataImpItemService.getFile(pSMOSFile, pSDEDataImpItem, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDATAIMPITEM_PSDEDATAIMP_PSDEDATAIMPID", (boolean)false) == 0) {
            if (PSDEDataImpServiceBase.getMOSVer() == 1) {
                return "<\u5bfc\u5165\u9879>";
            }
            if (PSDEDataImpServiceBase.getMOSVer() == 2) {
                return "psdedataimpitems";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEDataImp pSDEDataImp, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DataImport");
        defaultValueMap.put("PSDEDATAIMPNAME", "\u6570\u636e\u5bfc\u5165");
    }
}

