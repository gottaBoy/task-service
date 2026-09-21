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
 *  net.ibizsys.paas.entity.EntityBase
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
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEMapDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDQBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDS;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDSBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDQService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDQServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRefBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRefDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRefDEBase;
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

public abstract class PSDEMapServiceBase
extends PSCoreSysServiceBase<PSDEMap> {
    private static final Log log = LogFactory.getLog(PSDEMapServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEMapDEModel pSDEMapDEModel;
    private PSDEMapDAO pSDEMapDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEMapService";
    }

    public PSDEMapDEModel getPSDEMapDEModel() {
        if (this.pSDEMapDEModel == null) {
            try {
                this.pSDEMapDEModel = (PSDEMapDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEMapDEModel();
    }

    public PSDEMapDAO getPSDEMapDAO() {
        if (this.pSDEMapDAO == null) {
            try {
                this.pSDEMapDAO = (PSDEMapDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEMapDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEMapDAO();
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

    protected void onFillParentInfo(PSDEMap pSDEMap, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAP_PSDATAENTITY_DSTPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_DstPSDE(pSDEMap, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEMap, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEMap, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAP_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEMap, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAP_PSSYSREFDE_DSTPSSYSREFDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRefDEService", (SessionFactory)this.getSessionFactory());
            PSSysRefDE pSSysRefDE = (PSSysRefDE)iService.getDEModel().createEntity();
            pSSysRefDE.set("PSSYSREFDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysRefDE);
            } else {
                iService.get((IEntity)pSSysRefDE);
            }
            this.onFillParentInfo_DstPSSysRefDE(pSDEMap, pSSysRefDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAP_PSSYSREF_PSSYSREFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService", (SessionFactory)this.getSessionFactory());
            PSSysRef pSSysRef = (PSSysRef)iService.getDEModel().createEntity();
            pSSysRef.set("PSSYSREFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysRef);
            } else {
                iService.get((IEntity)pSSysRef);
            }
            this.onFillParentInfo_PSSysRef(pSDEMap, pSSysRef);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAP_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEMap, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEMap, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEMap, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDE(PSDEMap pSDEMap, PSDataEntity pSDataEntity) throws Exception {
        pSDEMap.setDSTPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEMap.setDSTPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSDEMap pSDEMap, PSDataEntity pSDataEntity) throws Exception {
        pSDEMap.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEMap.setPSDEName(pSDataEntity.getPSDataEntityName());
        pSDEMap.setPSSystemId(pSDataEntity.getPSSystemId());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEMap pSDEMap, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEMap.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEMap.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEMap pSDEMap, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEMap.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEMap.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_DstPSSysRefDE(PSDEMap pSDEMap, PSSysRefDE pSSysRefDE) throws Exception {
        pSDEMap.setDstPSSysRefDEId(pSSysRefDE.getPSSysRefDEId());
        pSDEMap.setDstPSSysRefDEName(pSSysRefDE.getPSSysRefDEName());
    }

    protected void onFillParentInfo_PSSysRef(PSDEMap pSDEMap, PSSysRef pSSysRef) throws Exception {
        pSDEMap.setPSSysRefId(pSSysRef.getPSSysRefId());
        pSDEMap.setPSSysRefName(pSSysRef.getPSSysRefName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEMap pSDEMap, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEMap.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEMap.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEMap pSDEMap, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEMap.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEMap.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSDEMap pSDEMap, boolean bl) throws Exception {
        if (bl) {
            if (pSDEMap.getCodeName() == null) {
                pSDEMap.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DEMap", 25));
            }
            if (pSDEMap.getDefaultMode() == null) {
                pSDEMap.setDefaultMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEMap.getMapTarget() == null) {
                pSDEMap.setMapTarget((String)this.getDefaultValue(this.getWebContext(), "", "SYSCUR", 25));
            }
            if (pSDEMap.getPSDEMapName() == null) {
                pSDEMap.setPSDEMapName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5b9e\u4f53\u6620\u5c04", 25));
            }
            if (pSDEMap.getValidFlag() == null) {
                pSDEMap.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEMap, bl);
        this.onFillEntityFullInfo_DstPSDE(pSDEMap, bl);
        this.onFillEntityFullInfo_PSDE(pSDEMap, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEMap, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEMap, bl);
        this.onFillEntityFullInfo_DstPSSysRefDE(pSDEMap, bl);
        this.onFillEntityFullInfo_PSSysRef(pSDEMap, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEMap, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEMap, bl);
    }

    protected void onFillEntityFullInfo_DstPSDE(PSDEMap pSDEMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEMap pSDEMap, boolean bl) throws Exception {
        if (pSDEMap.isPSDEIdDirty()) {
            if (pSDEMap.getPSDEId() != null) {
                if (pSDEMap.getPSDEId() == null || pSDEMap.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEMap.getPSDE();
                    pSDEMap.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEMap.setPSSystemId(pSDataEntity.getPSSystemId());
                }
            } else {
                pSDEMap.setPSDEName(null);
                pSDEMap.setPSSystemId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEMap pSDEMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEMap pSDEMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSSysRefDE(PSDEMap pSDEMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysRef(PSDEMap pSDEMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEMap pSDEMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEMap pSDEMap, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEMap pSDEMap, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEMap, bl);
    }

    public ArrayList<PSDEMap> selectByDstPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByDstPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEMap> selectByDstPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByDstPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEMap> selectByDstPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMap> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEMap> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEMap> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMap> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEMap> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEMap> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMap> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEMap> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEMap> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMap> selectByDstPSSysRefDE(PSSysRefDEBase pSSysRefDEBase) throws Exception {
        return this.selectByDstPSSysRefDE(pSSysRefDEBase, "", -1);
    }

    public ArrayList<PSDEMap> selectByDstPSSysRefDE(PSSysRefDEBase pSSysRefDEBase, String string) throws Exception {
        return this.selectByDstPSSysRefDE(pSSysRefDEBase, string, -1);
    }

    public ArrayList<PSDEMap> selectByDstPSSysRefDE(PSSysRefDEBase pSSysRefDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSSYSREFDEID", (Object)pSSysRefDEBase.getPSSysRefDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSSysRefDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSSysRefDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMap> selectByPSSysRef(PSSysRefBase pSSysRefBase) throws Exception {
        return this.selectByPSSysRef(pSSysRefBase, "", -1);
    }

    public ArrayList<PSDEMap> selectByPSSysRef(PSSysRefBase pSSysRefBase, String string) throws Exception {
        return this.selectByPSSysRef(pSSysRefBase, string, -1);
    }

    public ArrayList<PSDEMap> selectByPSSysRef(PSSysRefBase pSSysRefBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSREFID", (Object)pSSysRefBase.getPSSysRefId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysRefCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysRefCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMap> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEMap> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEMap> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMap> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEMap> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEMap> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByDstPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAP_PSDATAENTITY_DSTPSDEID", "", iDataEntityModel.getName(), "PSDEMAP", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByDstPSDE(pSDataEntity);
        for (PSDEMap pSDEMap : arrayList) {
            PSDEMap pSDEMap2 = (PSDEMap)this.getDEModel().createEntity();
            pSDEMap2.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMap2.setDSTPSDEId(null);
            this.update(pSDEMap2);
        }
    }

    public void removeByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapServiceBase.this.onBeforeRemoveByDstPSDE(pSDataEntity2);
                PSDEMapServiceBase.this.internalRemoveByDstPSDE(pSDataEntity2);
                PSDEMapServiceBase.this.onAfterRemoveByDstPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByDstPSDE(pSDataEntity);
        this.onBeforeRemoveByDstPSDE(pSDataEntity, arrayList);
        for (PSDEMap pSDEMap : arrayList) {
            this.remove((IEntity)pSDEMap);
        }
        this.onAfterRemoveByDstPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEMap pSDEMap : arrayList) {
            PSDEMap pSDEMap2 = (PSDEMap)this.getDEModel().createEntity();
            pSDEMap2.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMap2.setPSDEId(null);
            this.update(pSDEMap2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEMapServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEMapServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEMap pSDEMap : arrayList) {
            this.remove((IEntity)pSDEMap);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEMAP", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEMap pSDEMap : arrayList) {
            PSDEMap pSDEMap2 = (PSDEMap)this.getDEModel().createEntity();
            pSDEMap2.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMap2.setPSSysDynaModelId(null);
            this.update(pSDEMap2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEMapServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEMapServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEMap pSDEMap : arrayList) {
            this.remove((IEntity)pSDEMap);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAP_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEMAP", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEMap pSDEMap : arrayList) {
            PSDEMap pSDEMap2 = (PSDEMap)this.getDEModel().createEntity();
            pSDEMap2.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMap2.setPSSysPFPluginId(null);
            this.update(pSDEMap2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEMapServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEMapServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEMap pSDEMap : arrayList) {
            this.remove((IEntity)pSDEMap);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    public void testRemoveByDstPSSysRefDE(PSSysRefDE pSSysRefDE) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByDstPSSysRefDE(pSSysRefDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREFDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysRefDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAP_PSSYSREFDE_DSTPSSYSREFDEID", "", iDataEntityModel.getName(), "PSDEMAP", iDataEntityModel.getDataInfo((IEntity)pSSysRefDE), arrayList.get(0)));
        }
    }

    public void resetDstPSSysRefDE(PSSysRefDE pSSysRefDE) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByDstPSSysRefDE(pSSysRefDE);
        for (PSDEMap pSDEMap : arrayList) {
            PSDEMap pSDEMap2 = (PSDEMap)this.getDEModel().createEntity();
            pSDEMap2.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMap2.setDstPSSysRefDEId(null);
            this.update(pSDEMap2);
        }
    }

    public void removeByDstPSSysRefDE(PSSysRefDE pSSysRefDE) throws Exception {
        final PSSysRefDE pSSysRefDE2 = pSSysRefDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapServiceBase.this.onBeforeRemoveByDstPSSysRefDE(pSSysRefDE2);
                PSDEMapServiceBase.this.internalRemoveByDstPSSysRefDE(pSSysRefDE2);
                PSDEMapServiceBase.this.onAfterRemoveByDstPSSysRefDE(pSSysRefDE2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSSysRefDE(PSSysRefDE pSSysRefDE) throws Exception {
    }

    protected void internalRemoveByDstPSSysRefDE(PSSysRefDE pSSysRefDE) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByDstPSSysRefDE(pSSysRefDE);
        this.onBeforeRemoveByDstPSSysRefDE(pSSysRefDE, arrayList);
        for (PSDEMap pSDEMap : arrayList) {
            this.remove((IEntity)pSDEMap);
        }
        this.onAfterRemoveByDstPSSysRefDE(pSSysRefDE, arrayList);
    }

    protected void onAfterRemoveByDstPSSysRefDE(PSSysRefDE pSSysRefDE) throws Exception {
    }

    protected void onBeforeRemoveByDstPSSysRefDE(PSSysRefDE pSSysRefDE, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSSysRefDE(PSSysRefDE pSSysRefDE, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSysRef(PSSysRef pSSysRef) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysRef(pSSysRef, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysRef);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAP_PSSYSREF_PSSYSREFID", "", iDataEntityModel.getName(), "PSDEMAP", iDataEntityModel.getDataInfo((IEntity)pSSysRef), arrayList.get(0)));
        }
    }

    public void resetPSSysRef(PSSysRef pSSysRef) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysRef(pSSysRef);
        for (PSDEMap pSDEMap : arrayList) {
            PSDEMap pSDEMap2 = (PSDEMap)this.getDEModel().createEntity();
            pSDEMap2.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMap2.setPSSysRefId(null);
            this.update(pSDEMap2);
        }
    }

    public void removeByPSSysRef(PSSysRef pSSysRef) throws Exception {
        final PSSysRef pSSysRef2 = pSSysRef;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapServiceBase.this.onBeforeRemoveByPSSysRef(pSSysRef2);
                PSDEMapServiceBase.this.internalRemoveByPSSysRef(pSSysRef2);
                PSDEMapServiceBase.this.onAfterRemoveByPSSysRef(pSSysRef2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysRef(PSSysRef pSSysRef) throws Exception {
    }

    protected void internalRemoveByPSSysRef(PSSysRef pSSysRef) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysRef(pSSysRef);
        this.onBeforeRemoveByPSSysRef(pSSysRef, arrayList);
        for (PSDEMap pSDEMap : arrayList) {
            this.remove((IEntity)pSDEMap);
        }
        this.onAfterRemoveByPSSysRef(pSSysRef, arrayList);
    }

    protected void onAfterRemoveByPSSysRef(PSSysRef pSSysRef) throws Exception {
    }

    protected void onBeforeRemoveByPSSysRef(PSSysRef pSSysRef, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysRef(PSSysRef pSSysRef, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAP_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEMAP", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEMap pSDEMap : arrayList) {
            PSDEMap pSDEMap2 = (PSDEMap)this.getDEModel().createEntity();
            pSDEMap2.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMap2.setPSSysReqItemId(null);
            this.update(pSDEMap2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEMapServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEMapServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEMap pSDEMap : arrayList) {
            this.remove((IEntity)pSDEMap);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEMAP", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEMap pSDEMap : arrayList) {
            PSDEMap pSDEMap2 = (PSDEMap)this.getDEModel().createEntity();
            pSDEMap2.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMap2.setPSSysSFPluginId(null);
            this.update(pSDEMap2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEMapServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEMapServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEMap> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEMap pSDEMap : arrayList) {
            this.remove((IEntity)pSDEMap);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEMap> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEMap pSDEMap) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEMap(pSDEMap);
        pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMap(pSDEMap);
        ((PSDEMapActionServiceBase)pSCoreSysServiceBase).removeByPSDEMap(pSDEMap);
        pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMap(pSDEMap);
        ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).removeByPSDEMap(pSDEMap);
        pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDQServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMap(pSDEMap);
        ((PSDEMapDQServiceBase)pSCoreSysServiceBase).removeByPSDEMap(pSDEMap);
        pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDSServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMap(pSDEMap);
        ((PSDEMapDSServiceBase)pSCoreSysServiceBase).removeByPSDEMap(pSDEMap);
        super.onBeforeRemove(pSDEMap);
    }

    protected void onBeforeRemoveTemp(PSDEMap pSDEMap) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDSServiceBase)pSCoreSysServiceBase).removeTempByPSDEMap(pSDEMap);
        pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDQServiceBase)pSCoreSysServiceBase).removeTempByPSDEMap(pSDEMap);
        pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapActionServiceBase)pSCoreSysServiceBase).removeTempByPSDEMap(pSDEMap);
        pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).removeTempByPSDEMap(pSDEMap);
        super.onBeforeRemoveTemp((IEntity)pSDEMap);
    }

    protected void getRelatedDataTempMajor(PSDEMap pSDEMap) throws Exception {
        this.getRelatedDataTempMajor_PSDEMapDetail(pSDEMap);
        this.getRelatedDataTempMajor_PSDEMapAction(pSDEMap);
        this.getRelatedDataTempMajor_PSDEMapDQ(pSDEMap);
        this.getRelatedDataTempMajor_PSDEMapDS(pSDEMap);
        super.getRelatedDataTempMajor((IEntity)pSDEMap);
    }

    protected void getRelatedDataTempMajor_PSDEMapDetail(PSDEMap pSDEMap) throws Exception {
        PSDEMapDetailService pSDEMapDetailService = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapDetail> arrayList = null;
        String string = pSDEMap.getPSDEMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMapDetailService.selectByPSDEMap(pSDEMap) : pSDEMapDetailService.selectTempByPSDEMap(pSDEMap);
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            pSDEMapDetailService.getTempMajor(pSDEMapDetail);
        }
    }

    protected void getRelatedDataTempMajor_PSDEMapAction(PSDEMap pSDEMap) throws Exception {
        PSDEMapActionService pSDEMapActionService = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapAction> arrayList = null;
        String string = pSDEMap.getPSDEMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMapActionService.selectByPSDEMap(pSDEMap) : pSDEMapActionService.selectTempByPSDEMap(pSDEMap);
        for (PSDEMapAction pSDEMapAction : arrayList) {
            pSDEMapActionService.getTempMajor(pSDEMapAction);
        }
    }

    protected void getRelatedDataTempMajor_PSDEMapDQ(PSDEMap pSDEMap) throws Exception {
        PSDEMapDQService pSDEMapDQService = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapDQ> arrayList = null;
        String string = pSDEMap.getPSDEMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMapDQService.selectByPSDEMap(pSDEMap) : pSDEMapDQService.selectTempByPSDEMap(pSDEMap);
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            pSDEMapDQService.getTempMajor(pSDEMapDQ);
        }
    }

    protected void getRelatedDataTempMajor_PSDEMapDS(PSDEMap pSDEMap) throws Exception {
        PSDEMapDSService pSDEMapDSService = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapDS> arrayList = null;
        String string = pSDEMap.getPSDEMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMapDSService.selectByPSDEMap(pSDEMap) : pSDEMapDSService.selectTempByPSDEMap(pSDEMap);
        for (PSDEMapDS pSDEMapDS : arrayList) {
            pSDEMapDSService.getTempMajor(pSDEMapDS);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEMap pSDEMap, PSDEMap pSDEMap2) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.updateRelatedDataTempMajor_removePSDEMapDS(pSDEMap, pSDEMap2);
        ArrayList<PSDEMapDQ> arrayList2 = this.updateRelatedDataTempMajor_removePSDEMapDQ(pSDEMap, pSDEMap2);
        ArrayList<PSDEMapAction> arrayList3 = this.updateRelatedDataTempMajor_removePSDEMapAction(pSDEMap, pSDEMap2);
        ArrayList<PSDEMapDetail> arrayList4 = this.updateRelatedDataTempMajor_removePSDEMapDetail(pSDEMap, pSDEMap2);
        this.updateRelatedDataTempMajor_updatePSDEMapDetail(pSDEMap, pSDEMap2, arrayList4);
        this.updateRelatedDataTempMajor_updatePSDEMapAction(pSDEMap, pSDEMap2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSDEMapDQ(pSDEMap, pSDEMap2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEMapDS(pSDEMap, pSDEMap2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEMap, (IEntity)pSDEMap2);
    }

    protected ArrayList<PSDEMapDetail> updateRelatedDataTempMajor_removePSDEMapDetail(PSDEMap pSDEMap, PSDEMap pSDEMap2) throws Exception {
        PSDEMapDetailService pSDEMapDetailService = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapDetail> arrayList = pSDEMapDetailService.selectTempByPSDEMap(pSDEMap);
        ArrayList<PSDEMapDetail> arrayList2 = pSDEMapDetailService.selectByPSDEMap(pSDEMap2);
        HashMap<String, PSDEMapDetail> hashMap = new HashMap<String, PSDEMapDetail>();
        for (PSDEMapDetail pSDEMapDetail : arrayList2) {
            hashMap.put(pSDEMapDetail.getPSDEMapDetailId(), pSDEMapDetail);
        }
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            Object object = pSDEMapDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEMapDetail pSDEMapDetail : hashMap.values()) {
            pSDEMapDetailService.remove((IEntity)pSDEMapDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEMapDetail(PSDEMap pSDEMap, PSDEMap pSDEMap2, ArrayList<PSDEMapDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEMapDetailService pSDEMapDetailService = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            pSDEMapDetailService.updateTempMajor(pSDEMapDetail);
        }
    }

    protected ArrayList<PSDEMapAction> updateRelatedDataTempMajor_removePSDEMapAction(PSDEMap pSDEMap, PSDEMap pSDEMap2) throws Exception {
        PSDEMapActionService pSDEMapActionService = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapAction> arrayList = pSDEMapActionService.selectTempByPSDEMap(pSDEMap);
        ArrayList<PSDEMapAction> arrayList2 = pSDEMapActionService.selectByPSDEMap(pSDEMap2);
        HashMap<String, PSDEMapAction> hashMap = new HashMap<String, PSDEMapAction>();
        for (PSDEMapAction pSDEMapAction : arrayList2) {
            hashMap.put(pSDEMapAction.getPSDEMapActionId(), pSDEMapAction);
        }
        for (PSDEMapAction pSDEMapAction : arrayList) {
            Object object = pSDEMapAction.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEMapAction pSDEMapAction : hashMap.values()) {
            pSDEMapActionService.remove((IEntity)pSDEMapAction);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEMapAction(PSDEMap pSDEMap, PSDEMap pSDEMap2, ArrayList<PSDEMapAction> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEMapActionService pSDEMapActionService = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEMapAction pSDEMapAction : arrayList) {
            pSDEMapActionService.updateTempMajor(pSDEMapAction);
        }
    }

    protected ArrayList<PSDEMapDQ> updateRelatedDataTempMajor_removePSDEMapDQ(PSDEMap pSDEMap, PSDEMap pSDEMap2) throws Exception {
        PSDEMapDQService pSDEMapDQService = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapDQ> arrayList = pSDEMapDQService.selectTempByPSDEMap(pSDEMap);
        ArrayList<PSDEMapDQ> arrayList2 = pSDEMapDQService.selectByPSDEMap(pSDEMap2);
        HashMap<String, PSDEMapDQ> hashMap = new HashMap<String, PSDEMapDQ>();
        for (PSDEMapDQ pSDEMapDQ : arrayList2) {
            hashMap.put(pSDEMapDQ.getPSDEMapDQId(), pSDEMapDQ);
        }
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            Object object = pSDEMapDQ.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEMapDQ pSDEMapDQ : hashMap.values()) {
            pSDEMapDQService.remove((IEntity)pSDEMapDQ);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEMapDQ(PSDEMap pSDEMap, PSDEMap pSDEMap2, ArrayList<PSDEMapDQ> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEMapDQService pSDEMapDQService = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            pSDEMapDQService.updateTempMajor(pSDEMapDQ);
        }
    }

    protected ArrayList<PSDEMapDS> updateRelatedDataTempMajor_removePSDEMapDS(PSDEMap pSDEMap, PSDEMap pSDEMap2) throws Exception {
        PSDEMapDSService pSDEMapDSService = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapDS> arrayList = pSDEMapDSService.selectTempByPSDEMap(pSDEMap);
        ArrayList<PSDEMapDS> arrayList2 = pSDEMapDSService.selectByPSDEMap(pSDEMap2);
        HashMap<String, PSDEMapDS> hashMap = new HashMap<String, PSDEMapDS>();
        for (PSDEMapDS pSDEMapDS : arrayList2) {
            hashMap.put(pSDEMapDS.getPSDEMapDSId(), pSDEMapDS);
        }
        for (PSDEMapDS pSDEMapDS : arrayList) {
            Object object = pSDEMapDS.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEMapDS pSDEMapDS : hashMap.values()) {
            pSDEMapDSService.remove((IEntity)pSDEMapDS);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEMapDS(PSDEMap pSDEMap, PSDEMap pSDEMap2, ArrayList<PSDEMapDS> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEMapDSService pSDEMapDSService = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEMapDS pSDEMapDS : arrayList) {
            pSDEMapDSService.updateTempMajor(pSDEMapDS);
        }
    }

    protected void replaceParentInfo(PSDEMap pSDEMap, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEMap, cloneSession);
        if (pSDEMap.getDSTPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEMap.getDSTPSDEId())) != null) {
            this.onFillParentInfo_DstPSDE(pSDEMap, (PSDataEntity)iEntity);
        }
        if (pSDEMap.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEMap.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEMap, (PSDataEntity)iEntity);
        }
        if (pSDEMap.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEMap.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEMap, (PSSysDynaModel)iEntity);
        }
        if (pSDEMap.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEMap.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEMap, (PSSysPFPlugin)iEntity);
        }
        if (pSDEMap.getDstPSSysRefDEId() != null && (iEntity = cloneSession.getEntity("PSSYSREFDE", (Object)pSDEMap.getDstPSSysRefDEId())) != null) {
            this.onFillParentInfo_DstPSSysRefDE(pSDEMap, (PSSysRefDE)iEntity);
        }
        if (pSDEMap.getPSSysRefId() != null && (iEntity = cloneSession.getEntity("PSSYSREF", (Object)pSDEMap.getPSSysRefId())) != null) {
            this.onFillParentInfo_PSSysRef(pSDEMap, (PSSysRef)iEntity);
        }
        if (pSDEMap.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEMap.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEMap, (PSSysReqItem)iEntity);
        }
        if (pSDEMap.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEMap.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEMap, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEMap pSDEMap, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEMap, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AutoDEActionMap(bl, pSDEMap, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AutoDEDQMap(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AutoDEDSMap(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AutoDEFieldMap(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultMode(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSTPSDEId(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSSysRefDEId(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicHolder(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapMode(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapTarget(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PropertyMap(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapId(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapName(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRefId(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEMap, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AutoDEActionMap(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isAutoDEActionMapDirty() : !pSDEMap.isAutoDEActionMapDirty()) {
            return null;
        }
        Integer n = pSDEMap.getAutoDEActionMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AutoDEActionMap_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTODEACTIONMAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AutoDEDQMap(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isAutoDEDQMapDirty() : !pSDEMap.isAutoDEDQMapDirty()) {
            return null;
        }
        Integer n = pSDEMap.getAutoDEDQMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AutoDEDQMap_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTODEDQMAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AutoDEDSMap(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isAutoDEDSMapDirty() : !pSDEMap.isAutoDEDSMapDirty()) {
            return null;
        }
        Integer n = pSDEMap.getAutoDEDSMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AutoDEDSMap_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTODEDSMAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AutoDEFieldMap(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isAutoDEFieldMapDirty() : !pSDEMap.isAutoDEFieldMapDirty()) {
            return null;
        }
        Integer n = pSDEMap.getAutoDEFieldMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AutoDEFieldMap_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTODEFIELDMAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isCodeNameDirty() && !bl2 : !pSDEMap.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEMap.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEMap, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEMapDEModel(), "CODENAME", string3, pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isCustomCodeDirty() : !pSDEMap.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEMap.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isCustomModeDirty() : !pSDEMap.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEMap.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultMode(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isDefaultModeDirty() : !pSDEMap.isDefaultModeDirty()) {
            return null;
        }
        Integer n = pSDEMap.getDefaultMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultMode_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
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
                String string2 = this.checkFieldDupRule(this.getPSDEMapDEModel(), "DEFAULTMODE", string, pSDEMap, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSTPSDEId(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isDSTPSDEIdDirty() : !pSDEMap.isDSTPSDEIdDirty()) {
            return null;
        }
        String string = pSDEMap.getDSTPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSTPSDEId_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSSysRefDEId(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isDstPSSysRefDEIdDirty() : !pSDEMap.isDstPSSysRefDEIdDirty()) {
            return null;
        }
        String string = pSDEMap.getDstPSSysRefDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSSysRefDEId_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSSYSREFDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicHolder(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isLogicHolderDirty() : !pSDEMap.isLogicHolderDirty()) {
            return null;
        }
        Integer n = pSDEMap.getLogicHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogicHolder_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isLogicNameDirty() : !pSDEMap.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEMap.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapMode(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isMapModeDirty() : !pSDEMap.isMapModeDirty()) {
            return null;
        }
        String string = pSDEMap.getMapMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapMode_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapTarget(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isMapTargetDirty() && !bl2 : !pSDEMap.isMapTargetDirty()) {
            return null;
        }
        String string = pSDEMap.getMapTarget();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPTARGET");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapTarget_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPTARGET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isMemoDirty() : !pSDEMap.isMemoDirty()) {
            return null;
        }
        String string = pSDEMap.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isOrderValueDirty() : !pSDEMap.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEMap.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PropertyMap(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPropertyMapDirty() : !pSDEMap.isPropertyMapDirty()) {
            return null;
        }
        String string = pSDEMap.getPropertyMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PropertyMap_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPSDEIdDirty() && !bl2 : !pSDEMap.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEMap.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMapId(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPSDEMapIdDirty() && !bl2 : !pSDEMap.isPSDEMapIdDirty()) {
            return null;
        }
        String string = pSDEMap.getPSDEMapId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapId_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapName(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPSDEMapNameDirty() && !bl2 : !pSDEMap.isPSDEMapNameDirty()) {
            return null;
        }
        String string = pSDEMap.getPSDEMapName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapName_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEMapDEModel(), "PSDEMAPNAME", string3, pSDEMap, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEMAPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPSDENameDirty() && !bl2 : !pSDEMap.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEMap.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPSSysDynaModelIdDirty() : !pSDEMap.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEMap.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPSSysPFPluginIdDirty() : !pSDEMap.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEMap.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysRefId(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPSSysRefIdDirty() : !pSDEMap.isPSSysRefIdDirty()) {
            return null;
        }
        String string = pSDEMap.getPSSysRefId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRefId_Default((IEntity)pSDEMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPSSysReqItemIdDirty() : !pSDEMap.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEMap.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isPSSysSFPluginIdDirty() : !pSDEMap.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEMap.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isUserCatDirty() : !pSDEMap.isUserCatDirty()) {
            return null;
        }
        String string = pSDEMap.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isUserTagDirty() : !pSDEMap.isUserTagDirty()) {
            return null;
        }
        String string = pSDEMap.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isUserTag2Dirty() : !pSDEMap.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEMap.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isUserTag3Dirty() : !pSDEMap.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEMap.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isUserTag4Dirty() : !pSDEMap.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEMap.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEMap pSDEMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMap.isValidFlagDirty() : !pSDEMap.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEMap.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEMap, bl2, bl3);
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

    protected void onSyncEntity(PSDEMap pSDEMap, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEMap, bl);
    }

    protected void onSyncIndexEntities(PSDEMap pSDEMap, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEMap, bl);
    }

    public Object getDataContextValue(PSDEMap pSDEMap, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEMap, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEMap pSDEMap, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEMap, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AUTODEACTIONMAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AutoDEActionMap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTODEDQMAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AutoDEDQMap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTODEDSMAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AutoDEDSMap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTODEFIELDMAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AutoDEFieldMap_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSSYSREFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSSysRefDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSSYSREFDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSSysRefDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPTARGET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapTarget_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROPERTYMAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PropertyMap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRefName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AutoDEActionMap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AutoDEDQMap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AutoDEDSMap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AutoDEFieldMap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefaultMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DSTPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DSTPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSSysRefDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSSYSREFDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSSysRefDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSSYSREFDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapTarget_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPTARGET", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEMapId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMapName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEMap pSDEMap) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEMap)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEMap pSDEMap) throws Exception {
        Object object = pSDEMap.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEMAP_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEMap);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEMap pSDEMap, Object object) throws Exception {
        PSDEMap pSDEMap2 = new PSDEMap();
        pSDEMap2.set("PSDEMAPID", object);
        String string = DataObject.getStringValue((Object)pSDEMap.get("PSDEMAPID"));
        super.onCopyDetails((IEntity)pSDEMap, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEMap pSDEMap, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEMAP");
        if (!bl) {
            super.exportCurXmlModel(pSDEMap, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEMap pSDEMap, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEMapDetail(pSDEMap, xmlNode);
        this.exportRelatedXmlModel_PSDEMapAction(pSDEMap, xmlNode);
        this.exportRelatedXmlModel_PSDEMapDQ(pSDEMap, xmlNode);
        super.onExportRelatedXmlModel(pSDEMap, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEMapDetail(PSDEMap pSDEMap, XmlNode xmlNode) throws Exception {
        PSDEMapDetailService pSDEMapDetailService = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapDetail> arrayList = null;
        String string = pSDEMap.getPSDEMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMapDetailService.selectByPSDEMap(pSDEMap) : pSDEMapDetailService.selectTempByPSDEMap(pSDEMap);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEMAPDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEMapDetail pSDEMapDetail : arrayList) {
                pSDEMapDetailService.exportXmlModel(pSDEMapDetail, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEMapAction(PSDEMap pSDEMap, XmlNode xmlNode) throws Exception {
        PSDEMapActionService pSDEMapActionService = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapAction> arrayList = null;
        String string = pSDEMap.getPSDEMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMapActionService.selectByPSDEMap(pSDEMap) : pSDEMapActionService.selectTempByPSDEMap(pSDEMap);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEMAPACTIONS");
            xmlNode.addNode(xmlNode2);
            for (PSDEMapAction pSDEMapAction : arrayList) {
                pSDEMapActionService.exportXmlModel(pSDEMapAction, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEMapDQ(PSDEMap pSDEMap, XmlNode xmlNode) throws Exception {
        PSDEMapDQService pSDEMapDQService = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMapDQ> arrayList = null;
        String string = pSDEMap.getPSDEMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMapDQService.selectByPSDEMap(pSDEMap) : pSDEMapDQService.selectTempByPSDEMap(pSDEMap);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEMAPDQS");
            xmlNode.addNode(xmlNode2);
            for (PSDEMapDQ pSDEMapDQ : arrayList) {
                pSDEMapDQService.exportXmlModel(pSDEMapDQ, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEMap pSDEMap, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEMAPDETAILS");
        this.importRelatedXmlModel_PSDEMapDetail(pSDEMap, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEMAPACTIONS");
        this.importRelatedXmlModel_PSDEMapAction(pSDEMap, xmlNode3);
        XmlNode xmlNode4 = xmlNode.getChildNodeByNodeName("PSDEMAPDQS");
        this.importRelatedXmlModel_PSDEMapDQ(pSDEMap, xmlNode4);
        super.onImportRelatedXmlModel(pSDEMap, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEMapDetail(PSDEMap pSDEMap, XmlNode xmlNode) throws Exception {
        PSDEMapDetailService pSDEMapDetailService = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEMap.getPSDEMapId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEMapDetailService.removeByPSDEMap(pSDEMap);
        } else {
            pSDEMapDetailService.removeTempByPSDEMap(pSDEMap);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEMapDetail pSDEMapDetail = new PSDEMapDetail();
                pSDEMapDetailService.fillParentInfo((IEntity)pSDEMapDetail, "DER1N", "DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID", pSDEMap.getPSDEMapId());
                pSDEMapDetailService.importXmlModel(pSDEMapDetail, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEMapAction(PSDEMap pSDEMap, XmlNode xmlNode) throws Exception {
        PSDEMapActionService pSDEMapActionService = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEMap.getPSDEMapId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEMapActionService.removeByPSDEMap(pSDEMap);
        } else {
            pSDEMapActionService.removeTempByPSDEMap(pSDEMap);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEMapAction pSDEMapAction = new PSDEMapAction();
                pSDEMapActionService.fillParentInfo((IEntity)pSDEMapAction, "DER1N", "DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID", pSDEMap.getPSDEMapId());
                pSDEMapActionService.importXmlModel(pSDEMapAction, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEMapDQ(PSDEMap pSDEMap, XmlNode xmlNode) throws Exception {
        PSDEMapDQService pSDEMapDQService = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEMap.getPSDEMapId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEMapDQService.removeByPSDEMap(pSDEMap);
        } else {
            pSDEMapDQService.removeTempByPSDEMap(pSDEMap);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEMapDQ pSDEMapDQ = new PSDEMapDQ();
                pSDEMapDQService.fillParentInfo((IEntity)pSDEMapDQ, "DER1N", "DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID", pSDEMap.getPSDEMapId());
                pSDEMapDQService.importXmlModel(pSDEMapDQ, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEMap pSDEMap, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEMap, string);
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
            return "DER1N_PSDEMAP_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEMap pSDEMap) {
        if (!StringHelper.isNullOrEmpty((String)pSDEMap.getCodeName())) {
            return pSDEMap.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEMap.getPSDEMapName())) {
            return pSDEMap.getPSDEMapName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEMap.getCodeName())) {
            return pSDEMap.getCodeName();
        }
        return super.getModelV2Tag(pSDEMap);
    }

    @Override
    public boolean setModelV2Tag(PSDEMap pSDEMap, String string) {
        pSDEMap.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEMAPNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEMAPNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEMap pSDEMap, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEMap.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEMap, true);
        pSDEMap.set("CODENAME", string);
        if (this.select(pSDEMap, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEMap, true);
        return super.getModelV2Entity(pSDEMap, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEMap pSDEMap, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEMap, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEMap pSDEMap, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEMap, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEMap pSDEMap, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSDEMapAction> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID")) {
            pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEMAP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEMAPACTION", (Object)pSDEMap.getPSDEMapId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEMapAction)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEMapAction>();
                object4 = ((PSDEMapActionServiceBase)pSCoreSysServiceBase).selectByPSDEMap(pSDEMap);
                object3 = StringHelper.format((String)"PSDEMAP#%1$s", (Object)pSDEMap.getPSDEMapId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEMapAction)object2.next();
                    object = ((PSDEMapActionServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEMapAction)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psdemapactionname")) {
                            string = objectNode.get("psdemapactionname").asText();
                        }
                        if (objectNode2.has("psdemapactionname")) {
                            string2 = objectNode2.get("psdemapactionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEMapAction();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID")) {
            pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEMAP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEMAPDETAIL", (Object)pSDEMap.getPSDEMapId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEMapAction)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).selectByPSDEMap(pSDEMap);
                object3 = StringHelper.format((String)"PSDEMAP#%1$s", (Object)pSDEMap.getPSDEMapId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEMapDetail)object2.next();
                    object = ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEMapAction)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psdemapdetailname")) {
                            string = objectNode.get("psdemapdetailname").asText();
                        }
                        if (objectNode2.has("psdemapdetailname")) {
                            string2 = objectNode2.get("psdemapdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEMapDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID")) {
            pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEMAP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEMAPDQ", (Object)pSDEMap.getPSDEMapId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEMapAction)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEMapDQServiceBase)pSCoreSysServiceBase).selectByPSDEMap(pSDEMap);
                object3 = StringHelper.format((String)"PSDEMAP#%1$s", (Object)pSDEMap.getPSDEMapId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEMapDQ)object2.next();
                    object = ((PSDEMapDQServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEMapAction)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psdemapdqname")) {
                            string = objectNode.get("psdemapdqname").asText();
                        }
                        if (objectNode2.has("psdemapdqname")) {
                            string2 = objectNode2.get("psdemapdqname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEMapDQ();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID")) {
            pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEMAP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEMAPDS", (Object)pSDEMap.getPSDEMapId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEMapAction)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEMapDSServiceBase)pSCoreSysServiceBase).selectByPSDEMap(pSDEMap);
                object3 = StringHelper.format((String)"PSDEMAP#%1$s", (Object)pSDEMap.getPSDEMapId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEMapDS)object2.next();
                    object = ((PSDEMapDSServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEMapAction)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psdemapdsname")) {
                            string = objectNode.get("psdemapdsname").asText();
                        }
                        if (objectNode2.has("psdemapdsname")) {
                            string2 = objectNode2.get("psdemapdsname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEMapDS();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEMap, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEMap pSDEMap) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSDEMapActionServiceBase)pSCoreSysServiceBase).selectByPSDEMap(pSDEMap);
        String string2 = StringHelper.format((String)"PSDEMAP#%1$s", (Object)pSDEMap.getPSDEMapId());
        for (PSDEMapAction entityBase : arrayList) {
            string = ((PSDEMapActionServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSDEMap.getPSDEMapId());
        ((PSDEMapActionServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEMapActionServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEMAPACTION WHERE PSDEMAPID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).selectByPSDEMap(pSDEMap);
        string2 = StringHelper.format((String)"PSDEMAP#%1$s", (Object)pSDEMap.getPSDEMapId());
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            string = ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEMapDetail);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEMapDetail);
        }
        object = new SqlParamList();
        object.addString(pSDEMap.getPSDEMapId());
        ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEMAPDETAIL WHERE PSDEMAPID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEMapDQServiceBase)pSCoreSysServiceBase).selectByPSDEMap(pSDEMap);
        string2 = StringHelper.format((String)"PSDEMAP#%1$s", (Object)pSDEMap.getPSDEMapId());
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            string = ((PSDEMapDQServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEMapDQ);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEMapDQ);
        }
        object = new SqlParamList();
        object.addString(pSDEMap.getPSDEMapId());
        ((PSDEMapDQServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEMapDQServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEMAPDQ WHERE PSDEMAPID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEMapDSServiceBase)pSCoreSysServiceBase).selectByPSDEMap(pSDEMap);
        string2 = StringHelper.format((String)"PSDEMAP#%1$s", (Object)pSDEMap.getPSDEMapId());
        for (PSDEMapDS pSDEMapDS : arrayList) {
            string = ((PSDEMapDSServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEMapDS);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEMapDS);
        }
        object = new SqlParamList();
        object.addString(pSDEMap.getPSDEMapId());
        ((PSDEMapDSServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEMapDSServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEMAPDS WHERE PSDEMAPID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSDEMap);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEMap pSDEMap, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEMapAction();
        entityBase.set("PSDEMAPID", pSDEMap.getPSDEMapId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEMapDetail();
        entityBase.set("PSDEMAPID", pSDEMap.getPSDEMapId());
        pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEMapDQ();
        entityBase.set("PSDEMAPID", pSDEMap.getPSDEMapId());
        pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEMapDS();
        entityBase.set("PSDEMAPID", pSDEMap.getPSDEMapId());
        pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEMap, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEMap pSDEMap, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSDEMapAction();
                ((PSDEMapActionBase)object).setDstPSDEId(pSDEMap.getDSTPSDEId());
                ((PSDEMapActionBase)object).setPSDEId(pSDEMap.getPSDEId());
                ((PSDEMapActionBase)object).setPSDEMapId(pSDEMap.getPSDEMapId());
                ((PSDEMapActionBase)object).setPSDEMapName(pSDEMap.getPSDEMapName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEMapAction();
                    entityBase.setDstPSDEId(pSDEMap.getDSTPSDEId());
                    entityBase.setPSDEId(pSDEMap.getPSDEId());
                    entityBase.setPSDEMapId(pSDEMap.getPSDEMapId());
                    entityBase.setPSDEMapName(pSDEMap.getPSDEMapName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSDEMapDetail();
                ((PSDEMapDetailBase)object).setPSDEId(pSDEMap.getPSDEId());
                ((PSDEMapDetailBase)object).setPSDEMapId(pSDEMap.getPSDEMapId());
                ((PSDEMapDetailBase)object).setPSDEMapName(pSDEMap.getPSDEMapName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string5);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEMapDetail();
                    entityBase.setPSDEId(pSDEMap.getPSDEId());
                    entityBase.setPSDEMapId(pSDEMap.getPSDEMapId());
                    entityBase.setPSDEMapName(pSDEMap.getPSDEMapName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                object = new PSDEMapDQ();
                ((PSDEMapDQBase)object).setDstPSDEId(pSDEMap.getDSTPSDEId());
                ((PSDEMapDQBase)object).setPSDEId(pSDEMap.getPSDEId());
                ((PSDEMapDQBase)object).setPSDEMapId(pSDEMap.getPSDEMapId());
                ((PSDEMapDQBase)object).setPSDEMapName(pSDEMap.getPSDEMapName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string6);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEMapDQ();
                    entityBase.setDstPSDEId(pSDEMap.getDSTPSDEId());
                    entityBase.setPSDEId(pSDEMap.getPSDEId());
                    entityBase.setPSDEMapId(pSDEMap.getPSDEMapId());
                    entityBase.setPSDEMapName(pSDEMap.getPSDEMapName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                object = new PSDEMapDS();
                ((PSDEMapDSBase)object).setDstPSDEId(pSDEMap.getDSTPSDEId());
                ((PSDEMapDSBase)object).setPSDEId(pSDEMap.getPSDEId());
                ((PSDEMapDSBase)object).setPSDEMapId(pSDEMap.getPSDEMapId());
                ((PSDEMapDSBase)object).setPSDEMapName(pSDEMap.getPSDEMapName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string7);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEMapDS();
                    entityBase.setDstPSDEId(pSDEMap.getDSTPSDEId());
                    entityBase.setPSDEId(pSDEMap.getPSDEId());
                    entityBase.setPSDEMapId(pSDEMap.getPSDEMapId());
                    entityBase.setPSDEMapName(pSDEMap.getPSDEMapName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEMap, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEMap pSDEMap, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEMapActions(pSDEMap, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEMapDetails(pSDEMap, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEMapDQs(pSDEMap, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEMap, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEMapActions(PSDEMap pSDEMap, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEMAPACTION", true), (boolean)false) == 0) {
            PSDEMapActionService pSDEMapActionService = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEMapAction pSDEMapAction = new PSDEMapAction();
            pSDEMapAction.setPSDEMapActionId(pSMOSFile.getPSModelId());
            if (!pSDEMapActionService.get((IEntity)pSDEMapAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEMapAction.getPSDEMapId(), (String)pSDEMap.getPSDEMapId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEMapActionService.exportModelV2(pSDEMapAction);
            pSDEMapAction.reset();
            if (!pSDEMapActionService.setModelV2ResScope((IEntity)pSDEMapAction, "PSDEMAP", pSDEMap.getPSDEMapId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEMapActionService.importModelV2(pSDEMapAction, objectNode);
            SessionFactoryManager.commit();
            return pSDEMapActionService.getFile((IEntity)pSDEMapAction);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEACTION", true), (boolean)false) == 0) {
            PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = new PSDEAction();
            pSDEAction.setPSDEActionId(pSMOSFile.getPSModelId());
            if (!pSDEActionService.get((IEntity)pSDEAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEMapActionService pSDEMapActionService = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEMapAction pSDEMapAction = new PSDEMapAction();
            pSDEMapAction.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMapAction.setPSDEActionId(pSDEAction.getPSDEActionId());
            this.fillPasteEntity((IEntity)pSDEMapAction, "PASTETAG");
            pSDEMapActionService.create(pSDEMapAction);
            if (StringHelper.compare((String)pSDEAction.getPSDEId(), (String)pSDEMapAction.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u6e90\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEMapActionService.getFile((IEntity)pSDEMapAction);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEMapDetails(PSDEMap pSDEMap, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEMAPDETAIL", true), (boolean)false) == 0) {
            PSDEMapDetailService pSDEMapDetailService = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEMapDetail pSDEMapDetail = new PSDEMapDetail();
            pSDEMapDetail.setPSDEMapDetailId(pSMOSFile.getPSModelId());
            if (!pSDEMapDetailService.get((IEntity)pSDEMapDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEMapDetail.getPSDEMapId(), (String)pSDEMap.getPSDEMapId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEMapDetailService.exportModelV2(pSDEMapDetail);
            pSDEMapDetail.reset();
            if (!pSDEMapDetailService.setModelV2ResScope((IEntity)pSDEMapDetail, "PSDEMAP", pSDEMap.getPSDEMapId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEMapDetailService.importModelV2(pSDEMapDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDEMapDetailService.getFile((IEntity)pSDEMapDetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFIELD", true), (boolean)false) == 0) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEFieldId(pSMOSFile.getPSModelId());
            if (!pSDEFieldService.get((IEntity)pSDEField, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEMapDetailService pSDEMapDetailService = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEMapDetail pSDEMapDetail = new PSDEMapDetail();
            pSDEMapDetail.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMapDetail.setSrcPSDEFId(pSDEField.getPSDEFieldId());
            this.fillPasteEntity((IEntity)pSDEMapDetail, "PASTETAG");
            pSDEMapDetailService.create(pSDEMapDetail);
            if (StringHelper.compare((String)pSDEField.getPSDEId(), (String)pSDEMapDetail.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[PSDEID]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEMapDetailService.getFile((IEntity)pSDEMapDetail);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEMapDQs(PSDEMap pSDEMap, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEMAPDQ", true), (boolean)false) == 0) {
            PSDEMapDQService pSDEMapDQService = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
            PSDEMapDQ pSDEMapDQ = new PSDEMapDQ();
            pSDEMapDQ.setPSDEMapDQId(pSMOSFile.getPSModelId());
            if (!pSDEMapDQService.get((IEntity)pSDEMapDQ, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEMapDQ.getPSDEMapId(), (String)pSDEMap.getPSDEMapId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEMapDQService.exportModelV2(pSDEMapDQ);
            pSDEMapDQ.reset();
            if (!pSDEMapDQService.setModelV2ResScope((IEntity)pSDEMapDQ, "PSDEMAP", pSDEMap.getPSDEMapId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEMapDQService.importModelV2(pSDEMapDQ, objectNode);
            SessionFactoryManager.commit();
            return pSDEMapDQService.getFile((IEntity)pSDEMapDQ);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDATAQUERY", true), (boolean)false) == 0) {
            PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
            pSDEDataQuery.setPSDEDataQueryId(pSMOSFile.getPSModelId());
            if (!pSDEDataQueryService.get((IEntity)pSDEDataQuery, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEMapDQService pSDEMapDQService = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
            PSDEMapDQ pSDEMapDQ = new PSDEMapDQ();
            pSDEMapDQ.setPSDEMapId(pSDEMap.getPSDEMapId());
            pSDEMapDQ.setPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
            this.fillPasteEntity((IEntity)pSDEMapDQ, "PASTETAG");
            pSDEMapDQService.create(pSDEMapDQ);
            if (StringHelper.compare((String)pSDEDataQuery.getPSDEId(), (String)pSDEMapDQ.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u6e90\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEMapDQService.getFile((IEntity)pSDEMapDQ);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEMap pSDEMap, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEMapActions(pSDEMap, list);
        this.onFillPasteHelps_PSDEMapDetails(pSDEMap, list);
        this.onFillPasteHelps_PSDEMapDQs(pSDEMap, list);
        super.onFillPasteHelps(pSDEMap, list);
    }

    protected void onFillPasteHelps_PSDEMapActions(PSDEMap pSDEMap, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMAPACTION");
        pSHelpSection.setSectionParam2("DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u6620\u5c04]\u7684[\u5b9e\u4f53\u6620\u5c04\u884c\u4e3a]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMAPACTION");
        pSHelpSection.setSectionParam2("DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID");
        pSHelpSection.setUserTag("DER1N_PSDEMAPACTION_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u884c\u4e3a]\u6784\u5efa[\u5b9e\u4f53\u6620\u5c04\u884c\u4e3a]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEMapDetails(PSDEMap pSDEMap, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMAPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u6620\u5c04]\u7684[\u5b9e\u4f53\u6620\u5c04\u5c5e\u6027]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMAPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID");
        pSHelpSection.setUserTag("DER1N_PSDEMAPDETAIL_PSDEFIELD_SRCPSDEFID");
        pSHelpSection.setContent("\u7c98\u8d34[\u5b9e\u4f53\u5c5e\u6027]\u6784\u5efa[\u5b9e\u4f53\u6620\u5c04\u5c5e\u6027]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEMapDQs(PSDEMap pSDEMap, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMAPDQ");
        pSHelpSection.setSectionParam2("DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u6620\u5c04]\u7684[\u5b9e\u4f53\u6620\u5c04\u67e5\u8be2]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMAPDQ");
        pSHelpSection.setSectionParam2("DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID");
        pSHelpSection.setUserTag("DER1N_PSDEMAPDQ_PSDEDATAQUERY_PSDEDATAQUERYID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u6570\u636e\u67e5\u8be2]\u6784\u5efa[\u5b9e\u4f53\u6620\u5c04\u67e5\u8be2]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        ArrayList arrayList;
        SelectField selectField;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSMOSFile pSMOSFile2;
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5c5e\u6027\u6620\u5c04>", "DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEMapServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5c5e\u6027\u6620\u5c04>");
            } else if (PSDEMapServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdemapdetails");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID|PSDEMAPID");
            pSMOSFile2.setFileTag3("PSDEMAPDETAIL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEMapServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u884c\u4e3a\u6620\u5c04>", "DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEMapServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u884c\u4e3a\u6620\u5c04>");
            } else if (PSDEMapServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdemapactions");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID|PSDEMAPID");
            pSMOSFile2.setFileTag3("PSDEMAPACTION");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEMapServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u96c6\u5408\u6620\u5c04>", "DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEMapServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u96c6\u5408\u6620\u5c04>");
            } else if (PSDEMapServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdemapds");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID|PSDEMAPID");
            pSMOSFile2.setFileTag3("PSDEMAPDS");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEMapServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u67e5\u8be2\u6620\u5c04>", "DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEMapServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u67e5\u8be2\u6620\u5c04>");
            } else if (PSDEMapServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdemapdqs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID|PSDEMAPID");
            pSMOSFile2.setFileTag3("PSDEMAPDQ");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEMapServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        PSMOSFile pSMOSFile2;
        ArrayList arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSDEMapServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5c5e\u6027\u6620\u5c04>", (boolean)false) == 0 || PSDEMapServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEMapDetails", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEMapServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u884c\u4e3a\u6620\u5c04>", (boolean)false) == 0 || PSDEMapServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEMapActions", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEMapServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u96c6\u5408\u6620\u5c04>", (boolean)false) == 0 || PSDEMapServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"psdemapds", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEMapServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u67e5\u8be2\u6620\u5c04>", (boolean)false) == 0 || PSDEMapServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEMapDQs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID", "PSDEMAPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (arrayList2.size() > 0) {
            return PSMOSFileUtil.append(arrayList2.toArray(new PSMOSFile[arrayList2.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID", (boolean)false) == 0) {
            if (PSDEMapServiceBase.getMOSVer() == 1) {
                return "<\u5c5e\u6027\u6620\u5c04>";
            }
            if (PSDEMapServiceBase.getMOSVer() == 2) {
                return "psdemapdetails";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID", (boolean)false) == 0) {
            if (PSDEMapServiceBase.getMOSVer() == 1) {
                return "<\u884c\u4e3a\u6620\u5c04>";
            }
            if (PSDEMapServiceBase.getMOSVer() == 2) {
                return "psdemapactions";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID", (boolean)false) == 0) {
            if (PSDEMapServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u96c6\u5408\u6620\u5c04>";
            }
            if (PSDEMapServiceBase.getMOSVer() == 2) {
                return "psdemapds";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID", (boolean)false) == 0) {
            if (PSDEMapServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u67e5\u8be2\u6620\u5c04>";
            }
            if (PSDEMapServiceBase.getMOSVer() == 2) {
                return "psdemapdqs";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEMap pSDEMap, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DEMap");
        defaultValueMap.put("PSDEMAPNAME", "\u5b9e\u4f53\u6620\u5c04");
    }
}

