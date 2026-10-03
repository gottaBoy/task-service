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
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFGroupDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFGroupDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFGroupServiceBase
extends PSCoreSysServiceBase<PSDEFGroup> {
    private static final Log log = LogFactory.getLog(PSDEFGroupServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEFGroupDEModel pSDEFGroupDEModel;
    private PSDEFGroupDAO pSDEFGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService";
    }

    public PSDEFGroupDEModel getPSDEFGroupDEModel() {
        if (this.pSDEFGroupDEModel == null) {
            try {
                this.pSDEFGroupDEModel = (PSDEFGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFGroupDEModel();
    }

    public PSDEFGroupDAO getPSDEFGroupDAO() {
        if (this.pSDEFGroupDAO == null) {
            try {
                this.pSDEFGroupDAO = (PSDEFGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFGroupDAO();
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

    protected void onFillParentInfo(PSDEFGroup pSDEFGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEFGroup, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUP_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEFGroup, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUP_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEGrid);
            } else {
                iService.get(pSDEGrid);
            }
            this.onFillParentInfo_PSDEGrid(pSDEFGroup, pSDEGrid);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUP_PSDEVRGROUP_PSDEVRGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService", (SessionFactory)this.getSessionFactory());
            PSDEVRGroup pSDEVRGroup = (PSDEVRGroup)iService.getDEModel().createEntity();
            pSDEVRGroup.set("PSDEVRGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEVRGroup);
            } else {
                iService.get(pSDEVRGroup);
            }
            this.onFillParentInfo_PSDEVRGroup(pSDEFGroup, pSDEVRGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUP_PSSYSDYNAMODEL_INITPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_InitPSSysDynaModel(pSDEFGroup, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEFGroup, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEFGroup, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo(pSDEFGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEFGroup pSDEFGroup, PSDataEntity pSDataEntity) throws Exception {
        pSDEFGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEFGroup pSDEFGroup, PSDEForm pSDEForm) throws Exception {
        pSDEFGroup.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFGroup.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEGrid(PSDEFGroup pSDEFGroup, PSDEGrid pSDEGrid) throws Exception {
        pSDEFGroup.setPSDEGridId(pSDEGrid.getPSDEGridId());
        pSDEFGroup.setPSDEGridName(pSDEGrid.getPSDEGridName());
    }

    protected void onFillParentInfo_PSDEVRGroup(PSDEFGroup pSDEFGroup, PSDEVRGroup pSDEVRGroup) throws Exception {
        pSDEFGroup.setPSDEVRGroupId(pSDEVRGroup.getPSDEVRGroupId());
        pSDEFGroup.setPSDEVRGroupName(pSDEVRGroup.getPSDEVRGroupName());
    }

    protected void onFillParentInfo_InitPSSysDynaModel(PSDEFGroup pSDEFGroup, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEFGroup.setInitPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEFGroup.setInitPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEFGroup pSDEFGroup, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEFGroup.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEFGroup.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEFGroup pSDEFGroup, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEFGroup.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEFGroup.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
        if (bl) {
            if (pSDEFGroup.getCodeName() == null) {
                pSDEFGroup.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DEFGroup", 25));
            }
            if (pSDEFGroup.getPSDEFGroupName() == null) {
                pSDEFGroup.setPSDEFGroupName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5c5e\u6027\u7ec4", 25));
            }
            if (pSDEFGroup.getValidFlag() == null) {
                pSDEFGroup.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEFGroup, bl);
        this.onFillEntityFullInfo_PSDE(pSDEFGroup, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEFGroup, bl);
        this.onFillEntityFullInfo_PSDEGrid(pSDEFGroup, bl);
        this.onFillEntityFullInfo_PSDEVRGroup(pSDEFGroup, bl);
        this.onFillEntityFullInfo_InitPSSysDynaModel(pSDEFGroup, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEFGroup, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEFGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
        if (pSDEFGroup.isPSDEIdDirty()) {
            if (pSDEFGroup.getPSDEId() != null) {
                if (pSDEFGroup.getPSDEId() == null || pSDEFGroup.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEFGroup.getPSDE();
                    pSDEFGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEFGroup.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEGrid(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEVRGroup(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InitPSSysDynaModel(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFGroup, bl);
    }

    public ArrayList<PSDEFGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEFGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEFGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFGroup> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFGroup> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFGroup> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFGroup> selectByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSDEFGroup> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSDEFGroup> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGridCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFGroup> selectByPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase) throws Exception {
        return this.selectByPSDEVRGroup(pSDEVRGroupBase, "", -1);
    }

    public ArrayList<PSDEFGroup> selectByPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase, String string) throws Exception {
        return this.selectByPSDEVRGroup(pSDEVRGroupBase, string, -1);
    }

    public ArrayList<PSDEFGroup> selectByPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVRGROUPID", (Object)pSDEVRGroupBase.getPSDEVRGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEVRGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEVRGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFGroup> selectByInitPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByInitPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEFGroup> selectByInitPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByInitPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEFGroup> selectByInitPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INITPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInitPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInitPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFGroup> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEFGroup> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEFGroup> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFGroup> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEFGroup> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEFGroup> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            PSDEFGroup pSDEFGroup2 = (PSDEFGroup)this.getDEModel().createEntity();
            pSDEFGroup2.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
            pSDEFGroup2.setPSDEId(null);
            this.update(pSDEFGroup2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEFGroupServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEFGroupServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            this.remove(pSDEFGroup);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUP_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDEFGROUP", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            PSDEFGroup pSDEFGroup2 = (PSDEFGroup)this.getDEModel().createEntity();
            pSDEFGroup2.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
            pSDEFGroup2.setPSDEFormId(null);
            this.update(pSDEFGroup2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEFGroupServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEFGroupServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            this.remove(pSDEFGroup);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDEGrid(pSDEGrid, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEGRID");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEGrid);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUP_PSDEGRID_PSDEGRIDID", "", iDataEntityModel.getName(), "PSDEFGROUP", iDataEntityModel.getDataInfo(pSDEGrid), arrayList.get(0)));
        }
    }

    public void resetPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDEGrid(pSDEGrid);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            PSDEFGroup pSDEFGroup2 = (PSDEFGroup)this.getDEModel().createEntity();
            pSDEFGroup2.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
            pSDEFGroup2.setPSDEGridId(null);
            this.update(pSDEFGroup2);
        }
    }

    public void removeByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupServiceBase.this.onBeforeRemoveByPSDEGrid(pSDEGrid2);
                PSDEFGroupServiceBase.this.internalRemoveByPSDEGrid(pSDEGrid2);
                PSDEFGroupServiceBase.this.onAfterRemoveByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            this.remove(pSDEFGroup);
        }
        this.onAfterRemoveByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDEVRGroup(pSDEVRGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVRGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEVRGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUP_PSDEVRGROUP_PSDEVRGROUPID", "", iDataEntityModel.getName(), "PSDEFGROUP", iDataEntityModel.getDataInfo(pSDEVRGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDEVRGroup(pSDEVRGroup);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            PSDEFGroup pSDEFGroup2 = (PSDEFGroup)this.getDEModel().createEntity();
            pSDEFGroup2.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
            pSDEFGroup2.setPSDEVRGroupId(null);
            this.update(pSDEFGroup2);
        }
    }

    public void removeByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        final PSDEVRGroup pSDEVRGroup2 = pSDEVRGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupServiceBase.this.onBeforeRemoveByPSDEVRGroup(pSDEVRGroup2);
                PSDEFGroupServiceBase.this.internalRemoveByPSDEVRGroup(pSDEVRGroup2);
                PSDEFGroupServiceBase.this.onAfterRemoveByPSDEVRGroup(pSDEVRGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
    }

    protected void internalRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSDEVRGroup(pSDEVRGroup);
        this.onBeforeRemoveByPSDEVRGroup(pSDEVRGroup, arrayList);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            this.remove(pSDEFGroup);
        }
        this.onAfterRemoveByPSDEVRGroup(pSDEVRGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEVRGroup(PSDEVRGroup pSDEVRGroup, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    public void testRemoveByInitPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByInitPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUP_PSSYSDYNAMODEL_INITPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEFGROUP", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetInitPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByInitPSSysDynaModel(pSSysDynaModel);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            PSDEFGroup pSDEFGroup2 = (PSDEFGroup)this.getDEModel().createEntity();
            pSDEFGroup2.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
            pSDEFGroup2.setInitPSSysDynaModelId(null);
            this.update(pSDEFGroup2);
        }
    }

    public void removeByInitPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupServiceBase.this.onBeforeRemoveByInitPSSysDynaModel(pSSysDynaModel2);
                PSDEFGroupServiceBase.this.internalRemoveByInitPSSysDynaModel(pSSysDynaModel2);
                PSDEFGroupServiceBase.this.onAfterRemoveByInitPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByInitPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByInitPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByInitPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByInitPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            this.remove(pSDEFGroup);
        }
        this.onAfterRemoveByInitPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByInitPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByInitPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInitPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEFGROUP", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            PSDEFGroup pSDEFGroup2 = (PSDEFGroup)this.getDEModel().createEntity();
            pSDEFGroup2.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
            pSDEFGroup2.setPSSysDynaModelId(null);
            this.update(pSDEFGroup2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEFGroupServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEFGroupServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            this.remove(pSDEFGroup);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEFGROUP", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            PSDEFGroup pSDEFGroup2 = (PSDEFGroup)this.getDEModel().createEntity();
            pSDEFGroup2.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
            pSDEFGroup2.setPSSysSFPluginId(null);
            this.update(pSDEFGroup2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEFGroupServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEFGroupServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFGroup> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEFGroup pSDEFGroup : arrayList) {
            this.remove(pSDEFGroup);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEFGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFGroup pSDEFGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionParamServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByInPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByOutPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByOutRefPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataQueryServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByInPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByOutPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFGroup(pSDEFGroup);
        ((PSDEFGroupDetailServiceBase)pSCoreSysServiceBase).removeByPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicParamServiceBase)pSCoreSysServiceBase).testRemoveByParamPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSDEUserRoleService)ServiceGlobal.getService(PSDEUserRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUserRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDynaModelAttrServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEFGroup(pSDEFGroup);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByEditPSDEFGroup(pSDEFGroup);
        super.onBeforeRemove(pSDEFGroup);
    }

    protected void onBeforeRemoveTemp(PSDEFGroup pSDEFGroup) throws Exception {
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDEFGroupDetailService.removeTempByPSDEFGroup(pSDEFGroup);
        super.onBeforeRemoveTemp(pSDEFGroup);
    }

    protected void getRelatedDataTempMajor(PSDEFGroup pSDEFGroup) throws Exception {
        this.getRelatedDataTempMajor_PSDEFGroupDetail(pSDEFGroup);
        super.getRelatedDataTempMajor(pSDEFGroup);
    }

    protected void getRelatedDataTempMajor_PSDEFGroupDetail(PSDEFGroup pSDEFGroup) throws Exception {
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFGroupDetail> arrayList = null;
        String string = pSDEFGroup.getPSDEFGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFGroupDetailService.selectByPSDEFGroup(pSDEFGroup) : pSDEFGroupDetailService.selectTempByPSDEFGroup(pSDEFGroup);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            pSDEFGroupDetailService.getTempMajor(pSDEFGroupDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEFGroup pSDEFGroup, PSDEFGroup pSDEFGroup2) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.updateRelatedDataTempMajor_removePSDEFGroupDetail(pSDEFGroup, pSDEFGroup2);
        this.updateRelatedDataTempMajor_updatePSDEFGroupDetail(pSDEFGroup, pSDEFGroup2, arrayList);
        super.updateRelatedDataTempMajor(pSDEFGroup, pSDEFGroup2);
    }

    protected ArrayList<PSDEFGroupDetail> updateRelatedDataTempMajor_removePSDEFGroupDetail(PSDEFGroup pSDEFGroup, PSDEFGroup pSDEFGroup2) throws Exception {
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFGroupDetail> arrayList = pSDEFGroupDetailService.selectTempByPSDEFGroup(pSDEFGroup);
        ArrayList<PSDEFGroupDetail> arrayList2 = pSDEFGroupDetailService.selectByPSDEFGroup(pSDEFGroup2);
        HashMap<String, PSDEFGroupDetail> hashMap = new HashMap<String, PSDEFGroupDetail>();
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList2) {
            hashMap.put(pSDEFGroupDetail.getPSDEFGroupDetailId(), pSDEFGroupDetail);
        }
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            Object object = pSDEFGroupDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFGroupDetail pSDEFGroupDetail : hashMap.values()) {
            pSDEFGroupDetailService.remove(pSDEFGroupDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFGroupDetail(PSDEFGroup pSDEFGroup, PSDEFGroup pSDEFGroup2, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            pSDEFGroupDetailService.updateTempMajor(pSDEFGroupDetail);
        }
    }

    protected void replaceParentInfo(PSDEFGroup pSDEFGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFGroup, cloneSession);
        if (pSDEFGroup.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEFGroup.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEFGroup, (PSDataEntity)iEntity);
        }
        if (pSDEFGroup.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFGroup.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEFGroup, (PSDEForm)iEntity);
        }
        if (pSDEFGroup.getPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSDEFGroup.getPSDEGridId())) != null) {
            this.onFillParentInfo_PSDEGrid(pSDEFGroup, (PSDEGrid)iEntity);
        }
        if (pSDEFGroup.getPSDEVRGroupId() != null && (iEntity = cloneSession.getEntity("PSDEVRGROUP", (Object)pSDEFGroup.getPSDEVRGroupId())) != null) {
            this.onFillParentInfo_PSDEVRGroup(pSDEFGroup, (PSDEVRGroup)iEntity);
        }
        if (pSDEFGroup.getInitPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEFGroup.getInitPSSysDynaModelId())) != null) {
            this.onFillParentInfo_InitPSSysDynaModel(pSDEFGroup, (PSSysDynaModel)iEntity);
        }
        if (pSDEFGroup.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEFGroup.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEFGroup, (PSSysDynaModel)iEntity);
        }
        if (pSDEFGroup.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEFGroup.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEFGroup, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEFGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DTOCodeName(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag2(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupType(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InitPSSysDynaModelId(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicMode(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam2(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupId(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupName(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEVRGroupId(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEFGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isCodeNameDirty() : !pSDEFGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEFGroup.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEFGroup, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEFGroupDEModel(), "CODENAME", string3, pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isCodeName2Dirty() : !pSDEFGroup.isCodeName2Dirty()) {
            return null;
        }
        String string = pSDEFGroup.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
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
                String string4 = this.checkFieldDupRule(this.getPSDEFGroupDEModel(), "CODENAME2", string3, pSDEFGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME2");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isCustomCodeDirty() : !pSDEFGroup.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEFGroup.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isCustomModeDirty() : !pSDEFGroup.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEFGroup.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_DTOCodeName(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isDTOCodeNameDirty() : !pSDEFGroup.isDTOCodeNameDirty()) {
            return null;
        }
        String string = pSDEFGroup.getDTOCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DTOCodeName_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DTOCODENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEFGroupDEModel(), "DTOCODENAME", string3, pSDEFGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DTOCODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isGroupTagDirty() : !pSDEFGroup.isGroupTagDirty()) {
            return null;
        }
        String string = pSDEFGroup.getGroupTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag2(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isGroupTag2Dirty() : !pSDEFGroup.isGroupTag2Dirty()) {
            return null;
        }
        String string = pSDEFGroup.getGroupTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag2_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupType(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isGroupTypeDirty() : !pSDEFGroup.isGroupTypeDirty()) {
            return null;
        }
        String string = pSDEFGroup.getGroupType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupType_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InitPSSysDynaModelId(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isInitPSSysDynaModelIdDirty() : !pSDEFGroup.isInitPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEFGroup.getInitPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InitPSSysDynaModelId_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicMode(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isLogicModeDirty() : !pSDEFGroup.isLogicModeDirty()) {
            return null;
        }
        String string = pSDEFGroup.getLogicMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicMode_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicParam(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isLogicParamDirty() : !pSDEFGroup.isLogicParamDirty()) {
            return null;
        }
        String string = pSDEFGroup.getLogicParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicParam2(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isLogicParam2Dirty() : !pSDEFGroup.isLogicParam2Dirty()) {
            return null;
        }
        String string = pSDEFGroup.getLogicParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam2_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isMemoDirty() : !pSDEFGroup.isMemoDirty()) {
            return null;
        }
        String string = pSDEFGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isOrderValueDirty() : !pSDEFGroup.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEFGroup.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFGroupId(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isPSDEFGroupIdDirty() && !bl2 : !pSDEFGroup.isPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEFGroup.getPSDEFGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupId_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupName(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isPSDEFGroupNameDirty() && !bl2 : !pSDEFGroup.isPSDEFGroupNameDirty()) {
            return null;
        }
        String string = pSDEFGroup.getPSDEFGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupName_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEFGroupDEModel(), "PSDEFGROUPNAME", string3, pSDEFGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFGROUPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isPSDEFormIdDirty() : !pSDEFGroup.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFGroup.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isPSDEGridIdDirty() : !pSDEFGroup.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDEFGroup.getPSDEGridId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isPSDEIdDirty() && !bl2 : !pSDEFGroup.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEFGroup.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isPSDENameDirty() && !bl2 : !pSDEFGroup.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEFGroup.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEVRGroupId(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isPSDEVRGroupIdDirty() : !pSDEFGroup.isPSDEVRGroupIdDirty()) {
            return null;
        }
        String string = pSDEFGroup.getPSDEVRGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEVRGroupId_Default(pSDEFGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isPSSysDynaModelIdDirty() : !pSDEFGroup.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEFGroup.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isPSSysSFPluginIdDirty() : !pSDEFGroup.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEFGroup.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isUserCatDirty() : !pSDEFGroup.isUserCatDirty()) {
            return null;
        }
        String string = pSDEFGroup.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isUserTagDirty() : !pSDEFGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isUserTag2Dirty() : !pSDEFGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isUserTag3Dirty() : !pSDEFGroup.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEFGroup.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isUserTag4Dirty() : !pSDEFGroup.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEFGroup.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEFGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEFGroup pSDEFGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroup.isValidFlagDirty() : !pSDEFGroup.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEFGroup.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEFGroup, bl2, bl3);
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

    protected void onSyncEntity(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFGroup, bl);
    }

    protected void onSyncIndexEntities(PSDEFGroup pSDEFGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFGroup, bl);
    }

    public Object getDataContextValue(PSDEFGroup pSDEFGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFGroup, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEFGroup.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFGroup pSDEFGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFGroup, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DTOCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DTOCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVRGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEVRGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVRGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEVRGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
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

    protected String onTestValueRule_DTOCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DTOCODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("DTOCODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEVRGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVRGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEVRGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVRGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSDEFGroup pSDEFGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFGroup pSDEFGroup) throws Exception {
        super.onUpdateParent(pSDEFGroup);
    }

    protected void onCopyDetails(PSDEFGroup pSDEFGroup, Object object) throws Exception {
        PSDEFGroup pSDEFGroup2 = new PSDEFGroup();
        pSDEFGroup2.set("PSDEFGROUPID", object);
        String string = DataObject.getStringValue((Object)pSDEFGroup.get("PSDEFGROUPID"));
        super.onCopyDetails(pSDEFGroup, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEFGroup pSDEFGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFGROUP");
        if (!bl) {
            pSDEFGroup.setCreateDate(null);
            pSDEFGroup.setCreateMan(null);
            pSDEFGroup.setPSDEFGroupId(null);
            pSDEFGroup.setUpdateDate(null);
            pSDEFGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFGroup, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEFGroup pSDEFGroup, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEFGroupDetail(pSDEFGroup, xmlNode);
        super.onExportRelatedXmlModel(pSDEFGroup, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEFGroupDetail(PSDEFGroup pSDEFGroup, XmlNode xmlNode) throws Exception {
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFGroupDetail> arrayList = null;
        String string = pSDEFGroup.getPSDEFGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFGroupDetailService.selectByPSDEFGroup(pSDEFGroup, "ORDER BY ORDERVALUE ASC") : pSDEFGroupDetailService.selectTempByPSDEFGroup(pSDEFGroup, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFGROUPDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
                pSDEFGroupDetail.set("ORDERVALUE", null);
                pSDEFGroupDetailService.exportXmlModel(pSDEFGroupDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEFGroup pSDEFGroup, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEFGROUPDETAILS");
        this.importRelatedXmlModel_PSDEFGroupDetail(pSDEFGroup, xmlNode2);
        super.onImportRelatedXmlModel(pSDEFGroup, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEFGroupDetail(PSDEFGroup pSDEFGroup, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEFGroup.getPSDEFGroupId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFGroupDetailService.removeByPSDEFGroup(pSDEFGroup);
        } else {
            pSDEFGroupDetailService.removeTempByPSDEFGroup(pSDEFGroup);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFGroupDetail pSDEFGroupDetail = new PSDEFGroupDetail();
                pSDEFGroupDetail.setOrderValue(n);
                n += 100;
                pSDEFGroupDetailService.fillParentInfo(pSDEFGroupDetail, "DER1N", "DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID", pSDEFGroup.getPSDEFGroupId());
                pSDEFGroupDetailService.importXmlModel(pSDEFGroupDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFGroup pSDEFGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFGroup, string);
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
            return "DER1N_PSDEFGROUP_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEFGroup pSDEFGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFGroup.getCodeName())) {
            return pSDEFGroup.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFGroup.getPSDEFGroupName())) {
            return pSDEFGroup.getPSDEFGroupName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFGroup.getCodeName())) {
            return pSDEFGroup.getCodeName();
        }
        return super.getModelV2Tag(pSDEFGroup);
    }

    @Override
    public boolean setModelV2Tag(PSDEFGroup pSDEFGroup, String string) {
        pSDEFGroup.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEFGROUPNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME2", "");
        map.put("DTOCODENAME", "");
        map.put("PSDEFGROUPNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFGroup pSDEFGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFGroup, true);
        pSDEFGroup.set("CODENAME", string);
        if (this.select(pSDEFGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFGroup, true);
        return super.getModelV2Entity(pSDEFGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFGroup pSDEFGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEFGroup, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEFGroup pSDEFGroup, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEFGroup, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEFGroup pSDEFGroup, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID")) {
            PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFGROUPDETAIL", (Object)pSDEFGroup.getPSDEFGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEFGROUP#%1$s", (Object)pSDEFGroup.getPSDEFGroupId());
                for (PSDEFGroupDetail detail : pSDEFGroupDetailService.selectByPSDEFGroup(pSDEFGroup)) {
                    String detailScope = pSDEFGroupDetailService.getModelV2ResScope(detail);
                    if (StringHelper.compare((String)scope, (String)detailScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(detail, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSDEFGroupDetailService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdefgroupdetailname")) {
                            string = objectNode.get("psdefgroupdetailname").asText();
                        }
                        if (objectNode2.has("psdefgroupdetailname")) {
                            string2 = objectNode2.get("psdefgroupdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode detailNode : arrayList) {
                    PSDEFGroupDetail detail = new PSDEFGroupDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)detail, detailNode, false);
                    output.add((JsonNode)pSDEFGroupDetailService.exportModelV2(detail, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEFGroup, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEFGroup pSDEFGroup) throws Exception {
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFGroupDetail> arrayList = pSDEFGroupDetailService.selectByPSDEFGroup(pSDEFGroup);
        String string = StringHelper.format((String)"PSDEFGROUP#%1$s", (Object)pSDEFGroup.getPSDEFGroupId());
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            String string2 = pSDEFGroupDetailService.getModelV2ResScope(pSDEFGroupDetail);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEFGroupDetailService.emptyModelV2(pSDEFGroupDetail);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEFGroup.getPSDEFGroupId());
        pSDEFGroupDetailService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEFGroupDetailService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFGROUPDETAIL WHERE PSDEFGROUPID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEFGroup);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEFGroupDetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEFGroup pSDEFGroup, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEFGroupDetail pSDEFGroupDetail = new PSDEFGroupDetail();
        pSDEFGroupDetail.set("PSDEFGROUPID", pSDEFGroup.getPSDEFGroupId());
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEFGroupDetailService.getModelV2Entity(pSDEFGroupDetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEFGroup, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEFGroup pSDEFGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEFGroupDetailService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEFGroupDetail pSDEFGroupDetail = new PSDEFGroupDetail();
                pSDEFGroupDetail.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
                pSDEFGroupDetail.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
                pSDEFGroupDetail.setPSDEId(pSDEFGroup.getPSDEId());
                pSDEFGroupDetailService.compileModelV2(pSDEFGroupDetail, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEFGroupDetail pSDEFGroupDetail = new PSDEFGroupDetail();
                    pSDEFGroupDetail.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
                    pSDEFGroupDetail.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
                    pSDEFGroupDetail.setPSDEId(pSDEFGroup.getPSDEId());
                    pSDEFGroupDetailService.compileModelV2(pSDEFGroupDetail, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEFGroup, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEFGroup pSDEFGroup, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFGroupDetails(pSDEFGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEFGroup, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEFGroupDetails(PSDEFGroup pSDEFGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFGROUPDETAIL", true), (boolean)false) == 0) {
            PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFGroupDetail pSDEFGroupDetail = new PSDEFGroupDetail();
            pSDEFGroupDetail.setPSDEFGroupDetailId(pSMOSFile.getPSModelId());
            if (!pSDEFGroupDetailService.get(pSDEFGroupDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFGroupDetail.getPSDEFGroupId(), (String)pSDEFGroup.getPSDEFGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFGroupDetailService.exportModelV2(pSDEFGroupDetail);
            pSDEFGroupDetail.reset();
            if (!pSDEFGroupDetailService.setModelV2ResScope(pSDEFGroupDetail, "PSDEFGROUP", pSDEFGroup.getPSDEFGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFGroupDetailService.importModelV2(pSDEFGroupDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDEFGroupDetailService.getFile(pSDEFGroupDetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFIELD", true), (boolean)false) == 0) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEFieldId(pSMOSFile.getPSModelId());
            if (!pSDEFieldService.get(pSDEField, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFGroupDetail pSDEFGroupDetail = new PSDEFGroupDetail();
            pSDEFGroupDetail.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
            pSDEFGroupDetail.setPSDEFId(pSDEField.getPSDEFieldId());
            this.fillPasteEntity(pSDEFGroupDetail, "PASTETAG");
            pSDEFGroupDetailService.create(pSDEFGroupDetail);
            if (StringHelper.compare((String)pSDEField.getPSDEId(), (String)pSDEFGroupDetail.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53\u6807\u8bc6]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEFGroupDetailService.getFile(pSDEFGroupDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEFGroup pSDEFGroup, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEFGroupDetails(pSDEFGroup, list);
        super.onFillPasteHelps(pSDEFGroup, list);
    }

    protected void onFillPasteHelps_PSDEFGroupDetails(PSDEFGroup pSDEFGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFGROUPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5c5e\u6027\u7ec4]\u7684[\u5c5e\u6027\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFGROUPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID");
        pSHelpSection.setUserTag("DER1N_PSDEFGROUPDETAIL_PSDEFIELD_PSDEFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u5c5e\u6027\u7684[\u5b9e\u4f53\u5c5e\u6027]\u6784\u5efa[\u5c5e\u6027\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u7ec4\u6210\u5458>", "DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID", "PSDEFGROUPID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSDEFGroupServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7ec4\u6210\u5458>");
            } else if (PSDEFGroupServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdefgroupdetails");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID|PSDEFGROUPID");
            pSMOSFile2.setFileTag3("PSDEFGROUPDETAIL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID", "PSDEFGROUPID", pSMOSFile.getPSModelId(), "", "")) {
                PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEFGroupDetailService, "DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID", "PSDEFGROUPID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSDEFGroupDetailService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFGroupServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSDEFGroupServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u7ec4\u6210\u5458>", (boolean)false) == 0 || PSDEFGroupServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEFGroupDetails", (boolean)true) == 0) {
            PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEFGroupDetailService, "DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID", "PSDEFGROUPID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSDEFGroupDetail> arrayList2 = pSDEFGroupDetailService.selectEx((ISelectContext)selectContext);
            for (PSDEFGroupDetail pSDEFGroupDetail : arrayList2) {
                PSMOSFile pSMOSFile2 = pSDEFGroupDetailService.getFile(pSMOSFile, pSDEFGroupDetail, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID", (boolean)false) == 0) {
            if (PSDEFGroupServiceBase.getMOSVer() == 1) {
                return "<\u7ec4\u6210\u5458>";
            }
            if (PSDEFGroupServiceBase.getMOSVer() == 2) {
                return "psdefgroupdetails";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEFGroup pSDEFGroup, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DEFGroup");
        defaultValueMap.put("PSDEFGROUPNAME", "\u5c5e\u6027\u7ec4");
    }
}

