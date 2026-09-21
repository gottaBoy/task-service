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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSThresholdGroupDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSThresholdGroupDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSThreshold;
import net.ibizsys.pscore.srv.sysdesign.entity.PSThresholdGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSThresholdGroupServiceBase
extends PSCoreSysServiceBase<PSThresholdGroup> {
    private static final Log log = LogFactory.getLog(PSThresholdGroupServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSThresholdGroupDEModel pSThresholdGroupDEModel;
    private PSThresholdGroupDAO pSThresholdGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService";
    }

    public PSThresholdGroupDEModel getPSThresholdGroupDEModel() {
        if (this.pSThresholdGroupDEModel == null) {
            try {
                this.pSThresholdGroupDEModel = (PSThresholdGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSThresholdGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSThresholdGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSThresholdGroupDEModel();
    }

    public PSThresholdGroupDAO getPSThresholdGroupDAO() {
        if (this.pSThresholdGroupDAO == null) {
            try {
                this.pSThresholdGroupDAO = (PSThresholdGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSThresholdGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSThresholdGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSThresholdGroupDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
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

    protected void onFillParentInfo(PSThresholdGroup pSThresholdGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSThresholdGroup, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSThresholdGroup, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSDEFIELD_BEGINVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_BeginValuePSDEF(pSThresholdGroup, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSDEFIELD_BKCOLORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_BKColorPSDEF(pSThresholdGroup, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSDEFIELD_COLORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ColorPSDEF(pSThresholdGroup, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSDEFIELD_DATAPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_DataPSDEF(pSThresholdGroup, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSDEFIELD_ENDVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_EndValuePSDEF(pSThresholdGroup, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSDEFIELD_ICONCLSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_IconClsPSDEF(pSThresholdGroup, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSDEFIELD_TEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TextPSDEF(pSThresholdGroup, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSThresholdGroup, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSThresholdGroup, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTHRESHOLDGROUP_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSThresholdGroup, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSThresholdGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSThresholdGroup pSThresholdGroup, PSDataEntity pSDataEntity) throws Exception {
        pSThresholdGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSThresholdGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDS(PSThresholdGroup pSThresholdGroup, PSDEDataSet pSDEDataSet) throws Exception {
        pSThresholdGroup.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSThresholdGroup.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_BeginValuePSDEF(PSThresholdGroup pSThresholdGroup, PSDEField pSDEField) throws Exception {
        pSThresholdGroup.setBeginValuePSDEFId(pSDEField.getPSDEFieldId());
        pSThresholdGroup.setBeginValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_BKColorPSDEF(PSThresholdGroup pSThresholdGroup, PSDEField pSDEField) throws Exception {
        pSThresholdGroup.setBKColorPSDEFId(pSDEField.getPSDEFieldId());
        pSThresholdGroup.setBKColorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ColorPSDEF(PSThresholdGroup pSThresholdGroup, PSDEField pSDEField) throws Exception {
        pSThresholdGroup.setColorPSDEFId(pSDEField.getPSDEFieldId());
        pSThresholdGroup.setColorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_DataPSDEF(PSThresholdGroup pSThresholdGroup, PSDEField pSDEField) throws Exception {
        pSThresholdGroup.setDataPSDEFId(pSDEField.getPSDEFieldId());
        pSThresholdGroup.setDataPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_EndValuePSDEF(PSThresholdGroup pSThresholdGroup, PSDEField pSDEField) throws Exception {
        pSThresholdGroup.setEndValuePSDEFId(pSDEField.getPSDEFieldId());
        pSThresholdGroup.setEndValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IconClsPSDEF(PSThresholdGroup pSThresholdGroup, PSDEField pSDEField) throws Exception {
        pSThresholdGroup.setIconClsPSDEFId(pSDEField.getPSDEFieldId());
        pSThresholdGroup.setIconClsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TextPSDEF(PSThresholdGroup pSThresholdGroup, PSDEField pSDEField) throws Exception {
        pSThresholdGroup.setTextPSDEFId(pSDEField.getPSDEFieldId());
        pSThresholdGroup.setTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSModule(PSThresholdGroup pSThresholdGroup, PSModule pSModule) throws Exception {
        pSThresholdGroup.setPSModuleId(pSModule.getPSModuleId());
        pSThresholdGroup.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSThresholdGroup pSThresholdGroup, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSThresholdGroup.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSThresholdGroup.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSystem(PSThresholdGroup pSThresholdGroup, PSSystem pSSystem) throws Exception {
        pSThresholdGroup.setPSSystemId(pSSystem.getPSSystemId());
        pSThresholdGroup.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        if (bl) {
            if (pSThresholdGroup.getCodeName() == null) {
                pSThresholdGroup.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "ThresholdGroup", 25));
            }
            if (pSThresholdGroup.getPSThresholdGroupName() == null) {
                pSThresholdGroup.setPSThresholdGroupName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u9608\u503c\u7ec4", 25));
            }
            if (pSThresholdGroup.getValidFlag() == null) {
                pSThresholdGroup.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSThresholdGroup, bl);
        this.onFillEntityFullInfo_PSDE(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_PSDEDS(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_BeginValuePSDEF(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_BKColorPSDEF(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_ColorPSDEF(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_DataPSDEF(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_EndValuePSDEF(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_IconClsPSDEF(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_TextPSDEF(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_PSModule(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSThresholdGroup, bl);
        this.onFillEntityFullInfo_PSSystem(pSThresholdGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        if (pSThresholdGroup.isPSDEIdDirty()) {
            if (pSThresholdGroup.getPSDEId() != null) {
                if (pSThresholdGroup.getPSDEId() == null || pSThresholdGroup.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSThresholdGroup.getPSDE();
                    pSThresholdGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSThresholdGroup.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDS(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_BeginValuePSDEF(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        if (pSThresholdGroup.isBeginValuePSDEFIdDirty()) {
            if (pSThresholdGroup.getBeginValuePSDEFId() != null) {
                if (pSThresholdGroup.getBeginValuePSDEFId() == null || pSThresholdGroup.getBeginValuePSDEFName() == null) {
                    PSDEField pSDEField = pSThresholdGroup.getBeginValuePSDEF();
                    pSThresholdGroup.setBeginValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSThresholdGroup.setBeginValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_BKColorPSDEF(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        if (pSThresholdGroup.isBKColorPSDEFIdDirty()) {
            if (pSThresholdGroup.getBKColorPSDEFId() != null) {
                if (pSThresholdGroup.getBKColorPSDEFId() == null || pSThresholdGroup.getBKColorPSDEFName() == null) {
                    PSDEField pSDEField = pSThresholdGroup.getBKColorPSDEF();
                    pSThresholdGroup.setBKColorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSThresholdGroup.setBKColorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ColorPSDEF(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        if (pSThresholdGroup.isColorPSDEFIdDirty()) {
            if (pSThresholdGroup.getColorPSDEFId() != null) {
                if (pSThresholdGroup.getColorPSDEFId() == null || pSThresholdGroup.getColorPSDEFName() == null) {
                    PSDEField pSDEField = pSThresholdGroup.getColorPSDEF();
                    pSThresholdGroup.setColorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSThresholdGroup.setColorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DataPSDEF(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        if (pSThresholdGroup.isDataPSDEFIdDirty()) {
            if (pSThresholdGroup.getDataPSDEFId() != null) {
                if (pSThresholdGroup.getDataPSDEFId() == null || pSThresholdGroup.getDataPSDEFName() == null) {
                    PSDEField pSDEField = pSThresholdGroup.getDataPSDEF();
                    pSThresholdGroup.setDataPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSThresholdGroup.setDataPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_EndValuePSDEF(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        if (pSThresholdGroup.isEndValuePSDEFIdDirty()) {
            if (pSThresholdGroup.getEndValuePSDEFId() != null) {
                if (pSThresholdGroup.getEndValuePSDEFId() == null || pSThresholdGroup.getEndValuePSDEFName() == null) {
                    PSDEField pSDEField = pSThresholdGroup.getEndValuePSDEF();
                    pSThresholdGroup.setEndValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSThresholdGroup.setEndValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IconClsPSDEF(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        if (pSThresholdGroup.isIconClsPSDEFIdDirty()) {
            if (pSThresholdGroup.getIconClsPSDEFId() != null) {
                if (pSThresholdGroup.getIconClsPSDEFId() == null || pSThresholdGroup.getIconClsPSDEFName() == null) {
                    PSDEField pSDEField = pSThresholdGroup.getIconClsPSDEF();
                    pSThresholdGroup.setIconClsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSThresholdGroup.setIconClsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TextPSDEF(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        if (pSThresholdGroup.isTextPSDEFIdDirty()) {
            if (pSThresholdGroup.getTextPSDEFId() != null) {
                if (pSThresholdGroup.getTextPSDEFId() == null || pSThresholdGroup.getTextPSDEFName() == null) {
                    PSDEField pSDEField = pSThresholdGroup.getTextPSDEF();
                    pSThresholdGroup.setTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSThresholdGroup.setTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSThresholdGroup, bl);
    }

    public ArrayList<PSThresholdGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSThresholdGroup> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSThresholdGroup> selectByBeginValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByBeginValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByBeginValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByBeginValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByBeginValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BEGINVALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBeginValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBeginValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSThresholdGroup> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByBKColorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByBKColorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BKCOLORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBKColorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBKColorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSThresholdGroup> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByColorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByColorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("COLORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByColorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByColorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSThresholdGroup> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DATAPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDataPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDataPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSThresholdGroup> selectByEndValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByEndValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByEndValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByEndValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByEndValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ENDVALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEndValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEndValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSThresholdGroup> selectByIconClsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIconClsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByIconClsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIconClsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByIconClsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ICONCLSPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByIconClsPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByIconClsPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSThresholdGroup> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEXTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTextPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTextPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSThresholdGroup> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSThresholdGroup> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSThresholdGroup> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSThresholdGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setPSDEId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSThresholdGroupServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setPSDEDSId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSThresholdGroupServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByBeginValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSDEFIELD_BEGINVALUEPSDEFID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetBeginValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByBeginValuePSDEF(pSDEField);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setBeginValuePSDEFId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByBeginValuePSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.internalRemoveByBeginValuePSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByBeginValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByBeginValuePSDEF(pSDEField);
        this.onBeforeRemoveByBeginValuePSDEF(pSDEField, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByBeginValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByBeginValuePSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBeginValuePSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByBKColorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSDEFIELD_BKCOLORPSDEFID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByBKColorPSDEF(pSDEField);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setBKColorPSDEFId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByBKColorPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.internalRemoveByBKColorPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByBKColorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByBKColorPSDEF(pSDEField);
        this.onBeforeRemoveByBKColorPSDEF(pSDEField, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByBKColorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByBKColorPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBKColorPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByColorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSDEFIELD_COLORPSDEFID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByColorPSDEF(pSDEField);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setColorPSDEFId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByColorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByColorPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.internalRemoveByColorPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByColorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByColorPSDEF(pSDEField);
        this.onBeforeRemoveByColorPSDEF(pSDEField, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByColorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByColorPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByColorPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByDataPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSDEFIELD_DATAPSDEFID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByDataPSDEF(pSDEField);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setDataPSDEFId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByDataPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByDataPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.internalRemoveByDataPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByDataPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByDataPSDEF(pSDEField);
        this.onBeforeRemoveByDataPSDEF(pSDEField, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByDataPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByEndValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByEndValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSDEFIELD_ENDVALUEPSDEFID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetEndValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByEndValuePSDEF(pSDEField);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setEndValuePSDEFId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByEndValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByEndValuePSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.internalRemoveByEndValuePSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByEndValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByEndValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByEndValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByEndValuePSDEF(pSDEField);
        this.onBeforeRemoveByEndValuePSDEF(pSDEField, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByEndValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByEndValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByEndValuePSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEndValuePSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByIconClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByIconClsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSDEFIELD_ICONCLSPSDEFID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetIconClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByIconClsPSDEF(pSDEField);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setIconClsPSDEFId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByIconClsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByIconClsPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.internalRemoveByIconClsPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByIconClsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIconClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIconClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByIconClsPSDEF(pSDEField);
        this.onBeforeRemoveByIconClsPSDEF(pSDEField, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByIconClsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIconClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIconClsPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIconClsPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSDEFIELD_TEXTPSDEFID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByTextPSDEF(pSDEField);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setTextPSDEFId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByTextPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.internalRemoveByTextPSDEF(pSDEField2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByTextPSDEF(pSDEField);
        this.onBeforeRemoveByTextPSDEF(pSDEField, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSModule(pSModule);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setPSModuleId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSThresholdGroupServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTHRESHOLDGROUP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSTHRESHOLDGROUP", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setPSSysDynaModelId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSThresholdGroupServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSSystem(pSSystem);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            PSThresholdGroup pSThresholdGroup2 = (PSThresholdGroup)this.getDEModel().createEntity();
            pSThresholdGroup2.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
            pSThresholdGroup2.setPSSystemId(null);
            this.update(pSThresholdGroup2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSThresholdGroupServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSThresholdGroupServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSThresholdGroupServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSThresholdGroup> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSThresholdGroup pSThresholdGroup : arrayList) {
            this.remove((IEntity)pSThresholdGroup);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSThresholdGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSThresholdGroup pSThresholdGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).testRemoveByPSThresholdGroup(pSThresholdGroup);
        pSCoreSysServiceBase = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdServiceBase)pSCoreSysServiceBase).testRemoveByPSThresholdGroup(pSThresholdGroup);
        ((PSThresholdServiceBase)pSCoreSysServiceBase).removeByPSThresholdGroup(pSThresholdGroup);
        super.onBeforeRemove(pSThresholdGroup);
    }

    protected void onBeforeRemoveTemp(PSThresholdGroup pSThresholdGroup) throws Exception {
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        pSThresholdService.removeTempByPSThresholdGroup(pSThresholdGroup);
        super.onBeforeRemoveTemp((IEntity)pSThresholdGroup);
    }

    protected void getRelatedDataTempMajor(PSThresholdGroup pSThresholdGroup) throws Exception {
        this.getRelatedDataTempMajor_PSThreshold(pSThresholdGroup);
        super.getRelatedDataTempMajor((IEntity)pSThresholdGroup);
    }

    protected void getRelatedDataTempMajor_PSThreshold(PSThresholdGroup pSThresholdGroup) throws Exception {
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSThreshold> arrayList = null;
        String string = pSThresholdGroup.getPSThresholdGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSThresholdService.selectByPSThresholdGroup(pSThresholdGroup) : pSThresholdService.selectTempByPSThresholdGroup(pSThresholdGroup);
        for (PSThreshold pSThreshold : arrayList) {
            pSThresholdService.getTempMajor(pSThreshold);
        }
    }

    protected void updateRelatedDataTempMajor(PSThresholdGroup pSThresholdGroup, PSThresholdGroup pSThresholdGroup2) throws Exception {
        ArrayList<PSThreshold> arrayList = this.updateRelatedDataTempMajor_removePSThreshold(pSThresholdGroup, pSThresholdGroup2);
        this.updateRelatedDataTempMajor_updatePSThreshold(pSThresholdGroup, pSThresholdGroup2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSThresholdGroup, (IEntity)pSThresholdGroup2);
    }

    protected ArrayList<PSThreshold> updateRelatedDataTempMajor_removePSThreshold(PSThresholdGroup pSThresholdGroup, PSThresholdGroup pSThresholdGroup2) throws Exception {
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSThreshold> arrayList = pSThresholdService.selectTempByPSThresholdGroup(pSThresholdGroup);
        ArrayList<PSThreshold> arrayList2 = pSThresholdService.selectByPSThresholdGroup(pSThresholdGroup2);
        HashMap<String, PSThreshold> hashMap = new HashMap<String, PSThreshold>();
        for (PSThreshold pSThreshold : arrayList2) {
            hashMap.put(pSThreshold.getPSThresholdId(), pSThreshold);
        }
        for (PSThreshold pSThreshold : arrayList) {
            Object object = pSThreshold.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSThreshold pSThreshold : hashMap.values()) {
            pSThresholdService.remove((IEntity)pSThreshold);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSThreshold(PSThresholdGroup pSThresholdGroup, PSThresholdGroup pSThresholdGroup2, ArrayList<PSThreshold> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        for (PSThreshold pSThreshold : arrayList) {
            pSThresholdService.updateTempMajor(pSThreshold);
        }
    }

    protected void replaceParentInfo(PSThresholdGroup pSThresholdGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSThresholdGroup, cloneSession);
        if (pSThresholdGroup.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSThresholdGroup.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSThresholdGroup, (PSDataEntity)iEntity);
        }
        if (pSThresholdGroup.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSThresholdGroup.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSThresholdGroup, (PSDEDataSet)iEntity);
        }
        if (pSThresholdGroup.getBeginValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSThresholdGroup.getBeginValuePSDEFId())) != null) {
            this.onFillParentInfo_BeginValuePSDEF(pSThresholdGroup, (PSDEField)iEntity);
        }
        if (pSThresholdGroup.getBKColorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSThresholdGroup.getBKColorPSDEFId())) != null) {
            this.onFillParentInfo_BKColorPSDEF(pSThresholdGroup, (PSDEField)iEntity);
        }
        if (pSThresholdGroup.getColorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSThresholdGroup.getColorPSDEFId())) != null) {
            this.onFillParentInfo_ColorPSDEF(pSThresholdGroup, (PSDEField)iEntity);
        }
        if (pSThresholdGroup.getDataPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSThresholdGroup.getDataPSDEFId())) != null) {
            this.onFillParentInfo_DataPSDEF(pSThresholdGroup, (PSDEField)iEntity);
        }
        if (pSThresholdGroup.getEndValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSThresholdGroup.getEndValuePSDEFId())) != null) {
            this.onFillParentInfo_EndValuePSDEF(pSThresholdGroup, (PSDEField)iEntity);
        }
        if (pSThresholdGroup.getIconClsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSThresholdGroup.getIconClsPSDEFId())) != null) {
            this.onFillParentInfo_IconClsPSDEF(pSThresholdGroup, (PSDEField)iEntity);
        }
        if (pSThresholdGroup.getTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSThresholdGroup.getTextPSDEFId())) != null) {
            this.onFillParentInfo_TextPSDEF(pSThresholdGroup, (PSDEField)iEntity);
        }
        if (pSThresholdGroup.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSThresholdGroup.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSThresholdGroup, (PSModule)iEntity);
        }
        if (pSThresholdGroup.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSThresholdGroup.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSThresholdGroup, (PSSysDynaModel)iEntity);
        }
        if (pSThresholdGroup.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSThresholdGroup.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSThresholdGroup, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSThresholdGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginValuePSDEFId(bl, pSThresholdGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginValuePSDEFName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColorPSDEFId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColorPSDEFName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColorPSDEFId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColorPSDEFName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndValuePSDEFId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndValuePSDEFName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconClsPSDEFId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconClsPSDEFName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncBeginValue(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncEndValue(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSThresholdGroupId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSThresholdGroupName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFId(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFName(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThresholdGroupTag(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThresholdGroupTag2(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThresholdGroupType(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSThresholdGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSThresholdGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginValuePSDEFId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isBeginValuePSDEFIdDirty() : !pSThresholdGroup.isBeginValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getBeginValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeginValuePSDEFId_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINVALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginValuePSDEFName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isBeginValuePSDEFNameDirty() : !pSThresholdGroup.isBeginValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getBeginValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeginValuePSDEFName_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINVALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKColorPSDEFId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isBKColorPSDEFIdDirty() : !pSThresholdGroup.isBKColorPSDEFIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getBKColorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColorPSDEFId_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKColorPSDEFName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isBKColorPSDEFNameDirty() : !pSThresholdGroup.isBKColorPSDEFNameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getBKColorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColorPSDEFName_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isCodeNameDirty() && !bl2 : !pSThresholdGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSThresholdGroup, bl2, bl3);
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
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSThresholdGroupDEModel(), "CODENAME", string3, pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColorPSDEFId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isColorPSDEFIdDirty() : !pSThresholdGroup.isColorPSDEFIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getColorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColorPSDEFId_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColorPSDEFName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isColorPSDEFNameDirty() : !pSThresholdGroup.isColorPSDEFNameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getColorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColorPSDEFName_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isCustomCondDirty() : !pSThresholdGroup.isCustomCondDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataPSDEFId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isDataPSDEFIdDirty() : !pSThresholdGroup.isDataPSDEFIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getDataPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFId_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataPSDEFName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isDataPSDEFNameDirty() : !pSThresholdGroup.isDataPSDEFNameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getDataPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFName_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndValuePSDEFId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isEndValuePSDEFIdDirty() : !pSThresholdGroup.isEndValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getEndValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EndValuePSDEFId_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDVALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndValuePSDEFName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isEndValuePSDEFNameDirty() : !pSThresholdGroup.isEndValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getEndValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EndValuePSDEFName_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDVALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconClsPSDEFId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isIconClsPSDEFIdDirty() : !pSThresholdGroup.isIconClsPSDEFIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getIconClsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconClsPSDEFId_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONCLSPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconClsPSDEFName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isIconClsPSDEFNameDirty() : !pSThresholdGroup.isIconClsPSDEFNameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getIconClsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconClsPSDEFName_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONCLSPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncBeginValue(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isIncBeginValueDirty() : !pSThresholdGroup.isIncBeginValueDirty()) {
            return null;
        }
        Integer n = pSThresholdGroup.getIncBeginValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncBeginValue_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCBEGINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncEndValue(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isIncEndValueDirty() : !pSThresholdGroup.isIncEndValueDirty()) {
            return null;
        }
        Integer n = pSThresholdGroup.getIncEndValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncEndValue_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCENDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isMemoDirty() : !pSThresholdGroup.isMemoDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isPSDEDSIdDirty() : !pSThresholdGroup.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isPSDEIdDirty() : !pSThresholdGroup.isPSDEIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isPSDENameDirty() : !pSThresholdGroup.isPSDENameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isPSModuleIdDirty() : !pSThresholdGroup.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isPSSysDynaModelIdDirty() : !pSThresholdGroup.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isPSSystemIdDirty() : !pSThresholdGroup.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSThresholdGroupId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isPSThresholdGroupIdDirty() && !bl2 : !pSThresholdGroup.isPSThresholdGroupIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getPSThresholdGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTHRESHOLDGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSThresholdGroupId_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTHRESHOLDGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSThresholdGroupName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isPSThresholdGroupNameDirty() && !bl2 : !pSThresholdGroup.isPSThresholdGroupNameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getPSThresholdGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTHRESHOLDGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSThresholdGroupName_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTHRESHOLDGROUPNAME");
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
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSThresholdGroupDEModel(), "PSTHRESHOLDGROUPNAME", string3, pSThresholdGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSTHRESHOLDGROUPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFId(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isTextPSDEFIdDirty() : !pSThresholdGroup.isTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFId_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFName(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isTextPSDEFNameDirty() : !pSThresholdGroup.isTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFName_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThresholdGroupTag(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isThresholdGroupTagDirty() : !pSThresholdGroup.isThresholdGroupTagDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getThresholdGroupTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ThresholdGroupTag_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THRESHOLDGROUPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThresholdGroupTag2(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isThresholdGroupTag2Dirty() : !pSThresholdGroup.isThresholdGroupTag2Dirty()) {
            return null;
        }
        String string = pSThresholdGroup.getThresholdGroupTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ThresholdGroupTag2_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THRESHOLDGROUPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThresholdGroupType(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isThresholdGroupTypeDirty() && !bl2 : !pSThresholdGroup.isThresholdGroupTypeDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getThresholdGroupType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THRESHOLDGROUPTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ThresholdGroupType_Default((IEntity)pSThresholdGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THRESHOLDGROUPTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isUserCatDirty() : !pSThresholdGroup.isUserCatDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isUserTagDirty() : !pSThresholdGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSThresholdGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isUserTag2Dirty() : !pSThresholdGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSThresholdGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isUserTag3Dirty() : !pSThresholdGroup.isUserTag3Dirty()) {
            return null;
        }
        String string = pSThresholdGroup.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isUserTag4Dirty() : !pSThresholdGroup.isUserTag4Dirty()) {
            return null;
        }
        String string = pSThresholdGroup.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSThresholdGroup pSThresholdGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSThresholdGroup.isValidFlagDirty() && !bl2 : !pSThresholdGroup.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSThresholdGroup.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSThresholdGroup, bl2, bl3);
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

    protected void onSyncEntity(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSThresholdGroup, bl);
    }

    protected void onSyncIndexEntities(PSThresholdGroup pSThresholdGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSThresholdGroup, bl);
    }

    public Object getDataContextValue(PSThresholdGroup pSThresholdGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSThresholdGroup, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSThresholdGroup pSThresholdGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSThresholdGroup, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKCOLORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKCOLORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONCLSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconClsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONCLSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconClsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCBEGINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncBeginValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCENDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncEndValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTHRESHOLDGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSThresholdGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTHRESHOLDGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSThresholdGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THRESHOLDGROUPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThresholdGroupTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THRESHOLDGROUPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThresholdGroupTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THRESHOLDGROUPTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThresholdGroupType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BeginValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEGINVALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeginValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEGINVALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKColorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKColorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ColorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_DataPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EndValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENDVALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EndValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENDVALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconClsPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONCLSPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconClsPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONCLSPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IncBeginValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IncEndValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSThresholdGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTHRESHOLDGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSThresholdGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTHRESHOLDGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThresholdGroupTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("THRESHOLDGROUPTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThresholdGroupTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("THRESHOLDGROUPTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThresholdGroupType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("THRESHOLDGROUPTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected boolean onMergeChild(String string, String string2, PSThresholdGroup pSThresholdGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSThresholdGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSThresholdGroup pSThresholdGroup) throws Exception {
        super.onUpdateParent((IEntity)pSThresholdGroup);
    }

    protected void onCopyDetails(PSThresholdGroup pSThresholdGroup, Object object) throws Exception {
        PSThresholdGroup pSThresholdGroup2 = new PSThresholdGroup();
        pSThresholdGroup2.set("PSTHRESHOLDGROUPID", object);
        String string = DataObject.getStringValue((Object)pSThresholdGroup.get("PSTHRESHOLDGROUPID"));
        super.onCopyDetails((IEntity)pSThresholdGroup, object);
    }

    @Override
    protected void exportCurXmlModel(PSThresholdGroup pSThresholdGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSTHRESHOLDGROUP");
        if (!bl) {
            pSThresholdGroup.setCreateDate(null);
            pSThresholdGroup.setCreateMan(null);
            pSThresholdGroup.setPSThresholdGroupId(null);
            pSThresholdGroup.setUpdateDate(null);
            pSThresholdGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSThresholdGroup, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSThresholdGroup pSThresholdGroup, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSThreshold(pSThresholdGroup, xmlNode);
        super.onExportRelatedXmlModel(pSThresholdGroup, xmlNode);
    }

    protected void exportRelatedXmlModel_PSThreshold(PSThresholdGroup pSThresholdGroup, XmlNode xmlNode) throws Exception {
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSThreshold> arrayList = null;
        String string = pSThresholdGroup.getPSThresholdGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSThresholdService.selectByPSThresholdGroup(pSThresholdGroup) : pSThresholdService.selectTempByPSThresholdGroup(pSThresholdGroup);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSTHRESHOLDS");
            xmlNode.addNode(xmlNode2);
            for (PSThreshold pSThreshold : arrayList) {
                pSThresholdService.exportXmlModel(pSThreshold, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSThresholdGroup pSThresholdGroup, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSTHRESHOLDS");
        this.importRelatedXmlModel_PSThreshold(pSThresholdGroup, xmlNode2);
        super.onImportRelatedXmlModel(pSThresholdGroup, xmlNode);
    }

    protected void importRelatedXmlModel_PSThreshold(PSThresholdGroup pSThresholdGroup, XmlNode xmlNode) throws Exception {
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        String string = pSThresholdGroup.getPSThresholdGroupId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSThresholdService.removeByPSThresholdGroup(pSThresholdGroup);
        } else {
            pSThresholdService.removeTempByPSThresholdGroup(pSThresholdGroup);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSThreshold pSThreshold = new PSThreshold();
                pSThresholdService.fillParentInfo((IEntity)pSThreshold, "DER1N", "DER1N_PSTHRESHOLD_PSTHRESHOLDGROUP_PSTHRESHOLDGROUPID", pSThresholdGroup.getPSThresholdGroupId());
                pSThresholdService.importXmlModel(pSThreshold, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSThresholdGroup pSThresholdGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSThresholdGroup, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSTHRESHOLDGROUP_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSTHRESHOLDGROUP_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSThresholdGroup pSThresholdGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSThresholdGroup.getCodeName())) {
            return pSThresholdGroup.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSThresholdGroup.getPSThresholdGroupName())) {
            return pSThresholdGroup.getPSThresholdGroupName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSThresholdGroup.getCodeName())) {
            return pSThresholdGroup.getCodeName();
        }
        return super.getModelV2Tag(pSThresholdGroup);
    }

    @Override
    public boolean setModelV2Tag(PSThresholdGroup pSThresholdGroup, String string) {
        return super.setModelV2Tag(pSThresholdGroup, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSTHRESHOLDGROUPNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSTHRESHOLDGROUPNAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSThresholdGroup pSThresholdGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSThresholdGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSThresholdGroup, true);
        pSThresholdGroup.set("CODENAME", string);
        if (this.select(pSThresholdGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSThresholdGroup, true);
        return super.getModelV2Entity(pSThresholdGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSThresholdGroup pSThresholdGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSThresholdGroup, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSTHRESHOLD_PSTHRESHOLDGROUP_PSTHRESHOLDGROUPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSThresholdGroup pSThresholdGroup, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSThresholdGroup, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSThresholdGroup pSThresholdGroup, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSTHRESHOLD_PSTHRESHOLDGROUP_PSTHRESHOLDGROUPID")) {
            Object object;
            PSThreshold pSThreshold2;
            Object object2;
            Object object3;
            Object object4;
            PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSThreshold> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSTHRESHOLDGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSTHRESHOLD", (Object)pSThresholdGroup.getPSThresholdGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSThreshold2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSThreshold2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSThreshold>();
                object4 = pSThresholdService.selectByPSThresholdGroup(pSThresholdGroup);
                object3 = StringHelper.format((String)"PSTHRESHOLDGROUP#%1$s", (Object)pSThresholdGroup.getPSThresholdGroupId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSThreshold2 = object2.next();
                    object = pSThresholdService.getModelV2ResScope((IEntity)pSThreshold2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSThreshold)PSModelV2Helper.toJSONObject((IEntity)pSThreshold2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSThresholdService.getModelV2Name(false);
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
                        if (objectNode.has("psthresholdname")) {
                            string = objectNode.get("psthresholdname").asText();
                        }
                        if (objectNode2.has("psthresholdname")) {
                            string2 = objectNode2.get("psthresholdname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSThreshold pSThreshold2 : arrayList) {
                    object = new PSThreshold();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSThreshold2, false);
                    object3.add((JsonNode)pSThresholdService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSThresholdGroup, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSThresholdGroup pSThresholdGroup) throws Exception {
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSThreshold> arrayList = pSThresholdService.selectByPSThresholdGroup(pSThresholdGroup);
        String string = StringHelper.format((String)"PSTHRESHOLDGROUP#%1$s", (Object)pSThresholdGroup.getPSThresholdGroupId());
        for (PSThreshold pSThreshold : arrayList) {
            String string2 = pSThresholdService.getModelV2ResScope((IEntity)pSThreshold);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSThresholdService.emptyModelV2(pSThreshold);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSThresholdGroup.getPSThresholdGroupId());
        pSThresholdService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSThresholdService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSTHRESHOLD WHERE PSTHRESHOLDGROUPID = ?", sqlParamList);
        super.onEmptyModelV2(pSThresholdGroup);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        if (pSThresholdService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSThresholdGroup pSThresholdGroup, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSThreshold pSThreshold = new PSThreshold();
        pSThreshold.set("PSTHRESHOLDGROUPID", pSThresholdGroup.getPSThresholdGroupId());
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSThresholdService.getModelV2Entity(pSThreshold, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSThresholdGroup, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSThresholdGroup pSThresholdGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSThresholdService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSThreshold pSThreshold = new PSThreshold();
                pSThreshold.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
                pSThreshold.setPSThresholdGroupName(pSThresholdGroup.getPSThresholdGroupName());
                pSThresholdService.compileModelV2(pSThreshold, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSThreshold pSThreshold = new PSThreshold();
                    pSThreshold.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
                    pSThreshold.setPSThresholdGroupName(pSThresholdGroup.getPSThresholdGroupName());
                    pSThresholdService.compileModelV2(pSThreshold, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSThresholdGroup, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSThresholdGroup pSThresholdGroup, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSTHRESHOLD_PSTHRESHOLDGROUP_PSTHRESHOLDGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSThresholds(pSThresholdGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSThresholdGroup, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSThresholds(PSThresholdGroup pSThresholdGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSTHRESHOLD", true), (boolean)false) == 0) {
            PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
            PSThreshold pSThreshold = new PSThreshold();
            pSThreshold.setPSThresholdId(pSMOSFile.getPSModelId());
            if (!pSThresholdService.get((IEntity)pSThreshold, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSThreshold.getPSThresholdGroupId(), (String)pSThresholdGroup.getPSThresholdGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSThresholdService.exportModelV2(pSThreshold);
            pSThreshold.reset();
            if (!pSThresholdService.setModelV2ResScope((IEntity)pSThreshold, "PSTHRESHOLDGROUP", pSThresholdGroup.getPSThresholdGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSThresholdService.importModelV2(pSThreshold, objectNode);
            SessionFactoryManager.commit();
            return pSThresholdService.getFile((IEntity)pSThreshold);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSThresholdGroup pSThresholdGroup, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSThresholds(pSThresholdGroup, list);
        super.onFillPasteHelps(pSThresholdGroup, list);
    }

    protected void onFillPasteHelps_PSThresholds(PSThresholdGroup pSThresholdGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSTHRESHOLD");
        pSHelpSection.setSectionParam2("DER1N_PSTHRESHOLD_PSTHRESHOLDGROUP_PSTHRESHOLDGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9608\u503c\u7ec4]\u7684[\u9608\u503c\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSThresholdGroup pSThresholdGroup, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "ThresholdGroup");
        defaultValueMap.put("PSTHRESHOLDGROUPNAME", "\u9608\u503c\u7ec4");
    }
}

