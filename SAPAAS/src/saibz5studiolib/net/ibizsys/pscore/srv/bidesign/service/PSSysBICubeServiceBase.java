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
package net.ibizsys.pscore.srv.bidesign.service;

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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimensionBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasureBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBISchemeBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeServiceBase
extends PSCoreSysServiceBase<PSSysBICube> {
    private static final Log log = LogFactory.getLog(PSSysBICubeServiceBase.class);
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBICubeDEModel pSSysBICubeDEModel;
    private PSSysBICubeDAO pSSysBICubeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService";
    }

    public PSSysBICubeDEModel getPSSysBICubeDEModel() {
        if (this.pSSysBICubeDEModel == null) {
            try {
                this.pSSysBICubeDEModel = (PSSysBICubeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBICubeDEModel();
    }

    public PSSysBICubeDAO getPSSysBICubeDAO() {
        if (this.pSSysBICubeDAO == null) {
            try {
                this.pSSysBICubeDAO = (PSSysBICubeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBICubeDAO();
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

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysBICube pSSysBICube, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysBICube, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSSysBICube, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSDEFIELD_KEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_KeyPSDEF(pSSysBICube, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSDEFIELD_TYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TypePSDEF(pSSysBICube, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSDEUAGROUP_PORTLETPSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PortletPSDEUAGroup(pSSysBICube, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSDEVIEWBASE_DRILLDETAILPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_DrillDetailPSDEView(pSSysBICube, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSDEVIEWBASE_DRILLDOWNPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_DrillDownPSDEView(pSSysBICube, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSSYSBISCHEME_PSSYSBISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBIScheme pSSysBIScheme = (PSSysBIScheme)iService.getDEModel().createEntity();
            pSSysBIScheme.set("PSSYSBISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBIScheme);
            } else {
                iService.get(pSSysBIScheme);
            }
            this.onFillParentInfo_PSSysBIScheme(pSSysBICube, pSSysBIScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysBICube, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysBICube, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBE_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSSysBICube, pSSysUniRes);
            return;
        }
        super.onFillParentInfo(pSSysBICube, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysBICube pSSysBICube, PSDataEntity pSDataEntity) throws Exception {
        pSSysBICube.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysBICube.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSSysBICube pSSysBICube, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysBICube.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSSysBICube.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_KeyPSDEF(PSSysBICube pSSysBICube, PSDEField pSDEField) throws Exception {
        pSSysBICube.setKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSSysBICube.setKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TypePSDEF(PSSysBICube pSSysBICube, PSDEField pSDEField) throws Exception {
        pSSysBICube.setTypePSDEFId(pSDEField.getPSDEFieldId());
        pSSysBICube.setTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PortletPSDEUAGroup(PSSysBICube pSSysBICube, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSSysBICube.setPortletPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSSysBICube.setPortletPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_DrillDetailPSDEView(PSSysBICube pSSysBICube, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysBICube.setDrillDetailPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSSysBICube.setDrillDetailPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_DrillDownPSDEView(PSSysBICube pSSysBICube, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysBICube.setDrillDownPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSSysBICube.setDrillDownPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSSysBIScheme(PSSysBICube pSSysBICube, PSSysBIScheme pSSysBIScheme) throws Exception {
        pSSysBICube.setPSSysBISchemeId(pSSysBIScheme.getPSSysBISchemeId());
        pSSysBICube.setPSSysBISchemeName(pSSysBIScheme.getPSSysBISchemeName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysBICube pSSysBICube, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysBICube.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysBICube.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysBICube pSSysBICube, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysBICube.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysBICube.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSSysBICube pSSysBICube, PSSysUniRes pSSysUniRes) throws Exception {
        pSSysBICube.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSSysBICube.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillEntityFullInfo(PSSysBICube pSSysBICube, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBICube.getCodeName() == null) {
                pSSysBICube.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Cube", 25));
            }
            if (pSSysBICube.getValidFlag() == null) {
                pSSysBICube.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysBICube, bl);
        this.onFillEntityFullInfo_PSDE(pSSysBICube, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSSysBICube, bl);
        this.onFillEntityFullInfo_KeyPSDEF(pSSysBICube, bl);
        this.onFillEntityFullInfo_TypePSDEF(pSSysBICube, bl);
        this.onFillEntityFullInfo_PortletPSDEUAGroup(pSSysBICube, bl);
        this.onFillEntityFullInfo_DrillDetailPSDEView(pSSysBICube, bl);
        this.onFillEntityFullInfo_DrillDownPSDEView(pSSysBICube, bl);
        this.onFillEntityFullInfo_PSSysBIScheme(pSSysBICube, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysBICube, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysBICube, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSSysBICube, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysBICube pSSysBICube, boolean bl) throws Exception {
        if (pSSysBICube.isPSDEIdDirty()) {
            if (pSSysBICube.getPSDEId() != null) {
                if (pSSysBICube.getPSDEId() == null || pSSysBICube.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysBICube.getPSDE();
                    pSSysBICube.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysBICube.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_KeyPSDEF(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TypePSDEF(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PortletPSDEUAGroup(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DrillDetailPSDEView(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DrillDownPSDEView(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIScheme(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSSysBICube pSSysBICube, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBICube pSSysBICube, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBICube, bl);
    }

    public ArrayList<PSSysBICube> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICube> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICube> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEYPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKeyPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKeyPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICube> selectByTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICube> selectByPortletPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPortletPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByPortletPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPortletPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByPortletPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PORTLETPSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPortletPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPortletPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICube> selectByDrillDetailPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByDrillDetailPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByDrillDetailPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByDrillDetailPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByDrillDetailPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DRILLDETAILPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDrillDetailPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDrillDetailPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICube> selectByDrillDownPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByDrillDownPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByDrillDownPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByDrillDownPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByDrillDownPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DRILLDOWNPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDrillDownPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDrillDownPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICube> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICube> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICube> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICube> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSSysBICube> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSSysBICube> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setPSDEId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysBICubeServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysBICubeServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setPSDEDataSetId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysBICubeServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysBICubeServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSDEFIELD_KEYPSDEFID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByKeyPSDEF(pSDEField);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setKeyPSDEFId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByKeyPSDEF(pSDEField2);
                PSSysBICubeServiceBase.this.internalRemoveByKeyPSDEF(pSDEField2);
                PSSysBICubeServiceBase.this.onAfterRemoveByKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByKeyPSDEF(pSDEField);
        this.onBeforeRemoveByKeyPSDEF(pSDEField, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSDEFIELD_TYPEPSDEFID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByTypePSDEF(pSDEField);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setTypePSDEFId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByTypePSDEF(pSDEField2);
                PSSysBICubeServiceBase.this.internalRemoveByTypePSDEF(pSDEField2);
                PSSysBICubeServiceBase.this.onAfterRemoveByTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByTypePSDEF(pSDEField);
        this.onBeforeRemoveByTypePSDEF(pSDEField, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTypePSDEF(PSDEField pSDEField, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTypePSDEF(PSDEField pSDEField, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByPortletPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPortletPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSDEUAGROUP_PORTLETPSDEUAGROUPID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPortletPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPortletPSDEUAGroup(pSDEUAGroup);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setPortletPSDEUAGroupId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByPortletPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByPortletPSDEUAGroup(pSDEUAGroup2);
                PSSysBICubeServiceBase.this.internalRemoveByPortletPSDEUAGroup(pSDEUAGroup2);
                PSSysBICubeServiceBase.this.onAfterRemoveByPortletPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPortletPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPortletPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPortletPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPortletPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByPortletPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPortletPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPortletPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPortletPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByDrillDetailPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSDEVIEWBASE_DRILLDETAILPSDEVIEWID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByDrillDetailPSDEView(pSDEViewBase);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setDrillDetailPSDEViewId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByDrillDetailPSDEView(pSDEViewBase2);
                PSSysBICubeServiceBase.this.internalRemoveByDrillDetailPSDEView(pSDEViewBase2);
                PSSysBICubeServiceBase.this.onAfterRemoveByDrillDetailPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByDrillDetailPSDEView(pSDEViewBase);
        this.onBeforeRemoveByDrillDetailPSDEView(pSDEViewBase, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByDrillDetailPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByDrillDownPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSDEVIEWBASE_DRILLDOWNPSDEVIEWID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByDrillDownPSDEView(pSDEViewBase);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setDrillDownPSDEViewId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByDrillDownPSDEView(pSDEViewBase2);
                PSSysBICubeServiceBase.this.internalRemoveByDrillDownPSDEView(pSDEViewBase2);
                PSSysBICubeServiceBase.this.onAfterRemoveByDrillDownPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByDrillDownPSDEView(pSDEViewBase);
        this.onBeforeRemoveByDrillDownPSDEView(pSDEViewBase, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByDrillDownPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSSYSBISCHEME_PSSYSBISCHEMEID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSSysBIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setPSSysBISchemeId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        final PSSysBIScheme pSSysBIScheme2 = pSSysBIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSSysBICubeServiceBase.this.internalRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSSysBICubeServiceBase.this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setPSSysDynaModelId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysBICubeServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysBICubeServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setPSSysSFPluginId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysBICubeServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysBICubeServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBE_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSSYSBICUBE", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSSysBICube pSSysBICube : arrayList) {
            PSSysBICube pSSysBICube2 = (PSSysBICube)this.getDEModel().createEntity();
            pSSysBICube2.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
            pSSysBICube2.setPSSysUniResId(null);
            this.update(pSSysBICube2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysBICubeServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysBICubeServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysBICube> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSSysBICube pSSysBICube : arrayList) {
            this.remove(pSSysBICube);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysBICube> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBICube pSSysBICube) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICube(pSSysBICube);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICube(pSSysBICube);
        pSCoreSysServiceBase = (PSSysBIAggTableService)ServiceGlobal.getService(PSSysBIAggTableService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIAggTableServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICube(pSSysBICube);
        ((PSSysBIAggTableServiceBase)pSCoreSysServiceBase).removeByPSSysBICube(pSSysBICube);
        pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeDimensionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICube(pSSysBICube);
        ((PSSysBICubeDimensionServiceBase)pSCoreSysServiceBase).removeByPSSysBICube(pSSysBICube);
        pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICube(pSSysBICube);
        ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).removeByPSSysBICube(pSSysBICube);
        pSCoreSysServiceBase = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICube(pSSysBICube);
        pSCoreSysServiceBase = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICube(pSSysBICube);
        super.onBeforeRemove(pSSysBICube);
    }

    protected void replaceParentInfo(PSSysBICube pSSysBICube, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBICube, cloneSession);
        if (pSSysBICube.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysBICube.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysBICube, (PSDataEntity)iEntity);
        }
        if (pSSysBICube.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysBICube.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSSysBICube, (PSDEDataSet)iEntity);
        }
        if (pSSysBICube.getKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBICube.getKeyPSDEFId())) != null) {
            this.onFillParentInfo_KeyPSDEF(pSSysBICube, (PSDEField)iEntity);
        }
        if (pSSysBICube.getTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBICube.getTypePSDEFId())) != null) {
            this.onFillParentInfo_TypePSDEF(pSSysBICube, (PSDEField)iEntity);
        }
        if (pSSysBICube.getPortletPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSSysBICube.getPortletPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PortletPSDEUAGroup(pSSysBICube, (PSDEUAGroup)iEntity);
        }
        if (pSSysBICube.getDrillDetailPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysBICube.getDrillDetailPSDEViewId())) != null) {
            this.onFillParentInfo_DrillDetailPSDEView(pSSysBICube, (PSDEViewBase)iEntity);
        }
        if (pSSysBICube.getDrillDownPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysBICube.getDrillDownPSDEViewId())) != null) {
            this.onFillParentInfo_DrillDownPSDEView(pSSysBICube, (PSDEViewBase)iEntity);
        }
        if (pSSysBICube.getPSSysBISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBISCHEME", (Object)pSSysBICube.getPSSysBISchemeId())) != null) {
            this.onFillParentInfo_PSSysBIScheme(pSSysBICube, (PSSysBIScheme)iEntity);
        }
        if (pSSysBICube.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysBICube.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysBICube, (PSSysDynaModel)iEntity);
        }
        if (pSSysBICube.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysBICube.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysBICube, (PSSysSFPlugin)iEntity);
        }
        if (pSSysBICube.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSSysBICube.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSSysBICube, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBICube pSSysBICube, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBICube, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BICubeOption(bl, pSSysBICube, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BICubeParams(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BICubeTag(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BICubeTag2(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DrillDetailPSDEViewId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DrillDownPSDEViewId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomized(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PortletPSDEUAGroupId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeName(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBISchemeId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypePSDEFId(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBICube, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBICube, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BICubeOption(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isBICubeOptionDirty() : !pSSysBICube.isBICubeOptionDirty()) {
            return null;
        }
        Integer n = pSSysBICube.getBICubeOption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BICubeOption_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBEOPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BICubeParams(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isBICubeParamsDirty() : !pSSysBICube.isBICubeParamsDirty()) {
            return null;
        }
        String string = pSSysBICube.getBICubeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BICubeParams_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BICubeTag(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isBICubeTagDirty() : !pSSysBICube.isBICubeTagDirty()) {
            return null;
        }
        String string = pSSysBICube.getBICubeTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BICubeTag_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BICubeTag2(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isBICubeTag2Dirty() : !pSSysBICube.isBICubeTag2Dirty()) {
            return null;
        }
        String string = pSSysBICube.getBICubeTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BICubeTag2_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isCodeNameDirty() && !bl2 : !pSSysBICube.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBICube.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysBICube, bl2, bl3);
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
                string3 = "PSSYSBISCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBICubeDEModel(), "CODENAME", string3, pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_DrillDetailPSDEViewId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isDrillDetailPSDEViewIdDirty() : !pSSysBICube.isDrillDetailPSDEViewIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getDrillDetailPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DrillDetailPSDEViewId_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRILLDETAILPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DrillDownPSDEViewId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isDrillDownPSDEViewIdDirty() : !pSSysBICube.isDrillDownPSDEViewIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getDrillDownPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DrillDownPSDEViewId_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRILLDOWNPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCustomized(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isEnableCustomizedDirty() : !pSSysBICube.isEnableCustomizedDirty()) {
            return null;
        }
        Integer n = pSSysBICube.getEnableCustomized();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomized_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_KeyPSDEFId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isKeyPSDEFIdDirty() : !pSSysBICube.isKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFId_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isMemoDirty() : !pSSysBICube.isMemoDirty()) {
            return null;
        }
        String string = pSSysBICube.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_PortletPSDEUAGroupId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPortletPSDEUAGroupIdDirty() : !pSSysBICube.isPortletPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getPortletPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PortletPSDEUAGroupId_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTLETPSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPSDEDataSetIdDirty() : !pSSysBICube.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPSDEIdDirty() && !bl2 : !pSSysBICube.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPSDENameDirty() : !pSSysBICube.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysBICube.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPSSysBICubeIdDirty() && !bl2 : !pSSysBICube.isPSSysBICubeIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getPSSysBICubeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeId_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeName(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPSSysBICubeNameDirty() && !bl2 : !pSSysBICube.isPSSysBICubeNameDirty()) {
            return null;
        }
        String string = pSSysBICube.getPSSysBICubeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeName_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysBICubeDEModel(), "PSSYSBICUBENAME", string3, pSSysBICube, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBICUBENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBISchemeId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPSSysBISchemeIdDirty() && !bl2 : !pSSysBICube.isPSSysBISchemeIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getPSSysBISchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBISCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBISchemeId_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPSSysDynaModelIdDirty() : !pSSysBICube.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPSSysSFPluginIdDirty() : !pSSysBICube.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isPSSysUniResIdDirty() : !pSSysBICube.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_TypePSDEFId(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isTypePSDEFIdDirty() : !pSSysBICube.isTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBICube.getTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypePSDEFId_Default(pSSysBICube, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isUserCatDirty() : !pSSysBICube.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBICube.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isUserTagDirty() : !pSSysBICube.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBICube.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isUserTag2Dirty() : !pSSysBICube.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBICube.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isUserTag3Dirty() : !pSSysBICube.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBICube.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isUserTag4Dirty() : !pSSysBICube.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBICube.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBICube, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBICube pSSysBICube, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICube.isValidFlagDirty() && !bl2 : !pSSysBICube.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBICube.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysBICube, bl2, bl3);
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

    protected void onSyncEntity(PSSysBICube pSSysBICube, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBICube, bl);
    }

    protected void onSyncIndexEntities(PSSysBICube pSSysBICube, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBICube, bl);
    }

    public Object getDataContextValue(PSSysBICube pSSysBICube, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBICube, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBIScheme pSSysBIScheme = pSSysBICube.getPSSysBIScheme();
        if (pSSysBIScheme != null && pSSysBIScheme.contains(string)) {
            return pSSysBIScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBICube pSSysBICube, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBICube, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BICUBEOPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeOption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BICUBEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BICUBETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BICUBETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeTag2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DRILLDETAILPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDetailPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDETAILPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDetailPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDOWNPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDownPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDOWNPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDownPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMIZED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomized_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORTLETPSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PortletPSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORTLETPSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PortletPSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypePSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BICubeOption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BICubeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BICUBEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BICubeTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BICUBETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BICubeTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BICUBETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_DrillDetailPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDETAILPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDetailPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDETAILPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDownPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDOWNPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDownPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDOWNPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableCustomized_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_KeyPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PortletPSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PORTLETPSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PortletPSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PORTLETPSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_TypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysBICube pSSysBICube) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBICube)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBICube pSSysBICube) throws Exception {
        super.onUpdateParent(pSSysBICube);
    }

    protected void onCopyDetails(PSSysBICube pSSysBICube, Object object) throws Exception {
        Object object2;
        PSSysBICube pSSysBICube2 = new PSSysBICube();
        pSSysBICube2.set("PSSYSBICUBEID", object);
        String string = DataObject.getStringValue((Object)pSSysBICube.get("PSSYSBICUBEID"));
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBICubeMeasure> measures = ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).selectByPSSysBICube(pSSysBICube2);
        for (PSSysBICubeMeasure entityBase : measures) {
            object2 = entityBase.get("PSSYSBICUBEMEASUREID");
            pSCoreSysServiceBase.getDraftFrom(entityBase);
            pSCoreSysServiceBase.fillParentInfo(entityBase, "DER1N", "DER1N_PSSYSBICUBEMEASURE_PSSYSBICUBE_PSSYSBICUBEID", string);
            pSCoreSysServiceBase.create(entityBase);
            pSCoreSysServiceBase.copyDetails(entityBase, object2);
        }
        pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBICubeDimension> dimensions = ((PSSysBICubeDimensionServiceBase)pSCoreSysServiceBase).selectByPSSysBICube(pSSysBICube2);
        for (PSSysBICubeDimension entityBase : dimensions) {
            object2 = entityBase.get("PSSYSBICUBEDIMENSIONID");
            pSCoreSysServiceBase.getDraftFrom(entityBase);
            pSCoreSysServiceBase.fillParentInfo(entityBase, "DER1N", "DER1N_PSSYSBICUBEDIMENSION_PSSYSBICUBE_PSSYSBICUBEID", string);
            pSCoreSysServiceBase.create(entityBase);
            pSCoreSysServiceBase.copyDetails(entityBase, object2);
        }
        super.onCopyDetails(pSSysBICube, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysBICube pSSysBICube, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBICUBE");
        if (!bl) {
            pSSysBICube.setCreateDate(null);
            pSSysBICube.setCreateMan(null);
            pSSysBICube.setPSSysBICubeId(null);
            pSSysBICube.setUpdateDate(null);
            pSSysBICube.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBICube, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBICube pSSysBICube, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBICube, string);
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
            return "DER1N_PSSYSBICUBE_PSSYSBISCHEME_PSSYSBISCHEMEID";
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
    public String getModelV2Tag(PSSysBICube pSSysBICube) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBICube.getCodeName())) {
            return pSSysBICube.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBICube.getPSSysBICubeName())) {
            return pSSysBICube.getPSSysBICubeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBICube.getCodeName())) {
            return pSSysBICube.getCodeName();
        }
        return super.getModelV2Tag(pSSysBICube);
    }

    @Override
    public boolean setModelV2Tag(PSSysBICube pSSysBICube, String string) {
        pSSysBICube.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSBICUBENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBISCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBICube pSSysBICube, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBICube.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBICube, true);
        pSSysBICube.set("CODENAME", string);
        if (this.select(pSSysBICube, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBICube, true);
        return super.getModelV2Entity(pSSysBICube, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBICube pSSysBICube, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBICube, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSBICUBEDIMENSION_PSSYSBICUBE_PSSYSBICUBEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSBICUBEMEASURE_PSSYSBICUBE_PSSYSBICUBEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysBICube pSSysBICube, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSBICUBEDIMENSION_PSSYSBICUBE_PSSYSBICUBEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBICUBE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBICUBEDIMENSION", (Object)pSSysBICube.getPSSysBICubeId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysBICubeDimension();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBICubeDimensionServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBICubeDimension)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBICUBEDIMENSION", (Object)((PSSysBICubeDimension)entityBase).getPSSysBICubeDimensionId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSBICUBEMEASURE_PSSYSBICUBE_PSSYSBICUBEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBICUBE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBICUBEMEASURE", (Object)pSSysBICube.getPSSysBICubeId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysBICubeMeasure();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBICubeMeasure)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBICUBEMEASURE", (Object)((PSSysBICubeMeasure)entityBase).getPSSysBICubeMeasureId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysBICube, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysBICube pSSysBICube, ObjectNode objectNode, String string, boolean bl) throws Exception {
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBICUBEDIMENSION_PSSYSBICUBE_PSSYSBICUBEID")) {
            PSSysBICubeDimensionService service = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> items = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBICUBE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBICUBEDIMENSION", (Object)pSSysBICube.getPSSysBICubeId()));
                if (file.exists()) {
                    items = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        items.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                items = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSBICUBE#%1$s", (Object)pSSysBICube.getPSSysBICubeId());
                for (PSSysBICubeDimension dimension : service.selectByPSSysBICube(pSSysBICube)) {
                    if (StringHelper.compare(scope, service.getModelV2ResScope(dimension), false) != 0) continue;
                    items.add(PSModelV2Helper.toJSONObject(dimension, false));
                }
            }
            if (items != null && !items.isEmpty()) {
                ArrayNode arrayNode = objectNode.putArray(service.getModelV2Name(false).toLowerCase());
                Collections.sort(items, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssysbicubedimensionname")) {
                            string = objectNode.get("pssysbicubedimensionname").asText();
                        }
                        if (objectNode2.has("pssysbicubedimensionname")) {
                            string2 = objectNode2.get("pssysbicubedimensionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode item : items) {
                    PSSysBICubeDimension dimension = new PSSysBICubeDimension();
                    PSModelV2Helper.fromJSONObject(dimension, item, false);
                    arrayNode.add((JsonNode)service.exportModelV2(dimension, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBICUBEMEASURE_PSSYSBICUBE_PSSYSBICUBEID")) {
            PSSysBICubeMeasureService service = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> items = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBICUBE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBICUBEMEASURE", (Object)pSSysBICube.getPSSysBICubeId()));
                if (file.exists()) {
                    items = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        items.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                items = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSBICUBE#%1$s", (Object)pSSysBICube.getPSSysBICubeId());
                for (PSSysBICubeMeasure measure : service.selectByPSSysBICube(pSSysBICube)) {
                    if (StringHelper.compare(scope, service.getModelV2ResScope(measure), false) != 0) continue;
                    items.add(PSModelV2Helper.toJSONObject(measure, false));
                }
            }
            if (items != null && !items.isEmpty()) {
                ArrayNode arrayNode = objectNode.putArray(service.getModelV2Name(false).toLowerCase());
                Collections.sort(items, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssysbicubemeasurename")) {
                            string = objectNode.get("pssysbicubemeasurename").asText();
                        }
                        if (objectNode2.has("pssysbicubemeasurename")) {
                            string2 = objectNode2.get("pssysbicubemeasurename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode item : items) {
                    PSSysBICubeMeasure measure = new PSSysBICubeMeasure();
                    PSModelV2Helper.fromJSONObject(measure, item, false);
                    arrayNode.add((JsonNode)service.exportModelV2(measure, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysBICube, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysBICube pSSysBICube) throws Exception {
        super.onEmptyModelV2(pSSysBICube);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysBICube pSSysBICube, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysBICubeDimension();
        entityBase.set("PSSYSBICUBEID", pSSysBICube.getPSSysBICubeId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysBICubeMeasure();
        entityBase.set("PSSYSBICUBEID", pSSysBICube.getPSSysBICubeId());
        pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysBICube, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysBICube pSSysBICube, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysBICubeServiceBase.isSimpleImportExportMode("")) {
            PSSysBICubeDimensionService service = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String modelName = service.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray(objectNode, modelName.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode item = (ObjectNode)arrayNode.get(i);
                    PSSysBICubeDimension dimension = new PSSysBICubeDimension();
                    dimension.setPSDEId(pSSysBICube.getPSDEId());
                    dimension.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
                    dimension.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
                    dimension.setPSSysBISchemeId(pSSysBICube.getPSSysBISchemeId());
                    service.compileModelV2(dimension, item, string, null, n);
                }
            } else {
                File directory = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)modelName));
                if (directory.exists()) {
                    File[] folders = directory.listFiles();
                    if (folders != null) {
                        for (File folder : folders) {
                            if (!folder.isDirectory()) continue;
                            PSSysBICubeDimension dimension = new PSSysBICubeDimension();
                            dimension.setPSDEId(pSSysBICube.getPSDEId());
                            dimension.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
                            dimension.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
                            dimension.setPSSysBISchemeId(pSSysBICube.getPSSysBISchemeId());
                            service.compileModelV2(dimension, null, string, folder.getCanonicalPath(), n);
                        }
                    }
                }
            }
        }
        if (!PSSysBICubeServiceBase.isSimpleImportExportMode("")) {
            PSSysBICubeMeasureService service = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String modelName = service.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray(objectNode, modelName.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode item = (ObjectNode)arrayNode.get(i);
                    PSSysBICubeMeasure measure = new PSSysBICubeMeasure();
                    measure.setPSDEId(pSSysBICube.getPSDEId());
                    measure.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
                    measure.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
                    measure.setPSSysBISchemeId(pSSysBICube.getPSSysBISchemeId());
                    service.compileModelV2(measure, item, string, null, n);
                }
            } else {
                File directory = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)modelName));
                if (directory.exists()) {
                    File[] folders = directory.listFiles();
                    if (folders != null) {
                        for (File folder : folders) {
                            if (!folder.isDirectory()) continue;
                            PSSysBICubeMeasure measure = new PSSysBICubeMeasure();
                            measure.setPSDEId(pSSysBICube.getPSDEId());
                            measure.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
                            measure.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
                            measure.setPSSysBISchemeId(pSSysBICube.getPSSysBISchemeId());
                            service.compileModelV2(measure, null, string, folder.getCanonicalPath(), n);
                        }
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysBICube, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysBICube pSSysBICube, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBICUBEDIMENSION_PSSYSBICUBE_PSSYSBICUBEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBICubeDimensions(pSSysBICube, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBICUBEMEASURE_PSSYSBICUBE_PSSYSBICUBEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBICubeMeasures(pSSysBICube, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysBICube, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysBICubeDimensions(PSSysBICube pSSysBICube, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBICUBEDIMENSION", true), (boolean)false) == 0) {
            PSSysBICubeDimensionService pSSysBICubeDimensionService = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
            PSSysBICubeDimension pSSysBICubeDimension = new PSSysBICubeDimension();
            pSSysBICubeDimension.setPSSysBICubeDimensionId(pSMOSFile.getPSModelId());
            if (!pSSysBICubeDimensionService.get(pSSysBICubeDimension, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBICubeDimension.getPSSysBICubeId(), (String)pSSysBICube.getPSSysBICubeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBICubeDimensionService.exportModelV2(pSSysBICubeDimension);
            pSSysBICubeDimension.reset();
            if (!pSSysBICubeDimensionService.setModelV2ResScope(pSSysBICubeDimension, "PSSYSBICUBE", pSSysBICube.getPSSysBICubeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBICubeDimensionService.importModelV2(pSSysBICubeDimension, objectNode);
            SessionFactoryManager.commit();
            return pSSysBICubeDimensionService.getFile(pSSysBICubeDimension);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysBICubeMeasures(PSSysBICube pSSysBICube, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBICUBEMEASURE", true), (boolean)false) == 0) {
            PSSysBICubeMeasureService pSSysBICubeMeasureService = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
            PSSysBICubeMeasure pSSysBICubeMeasure = new PSSysBICubeMeasure();
            pSSysBICubeMeasure.setPSSysBICubeMeasureId(pSMOSFile.getPSModelId());
            if (!pSSysBICubeMeasureService.get(pSSysBICubeMeasure, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBICubeMeasure.getPSSysBICubeId(), (String)pSSysBICube.getPSSysBICubeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBICubeMeasureService.exportModelV2(pSSysBICubeMeasure);
            pSSysBICubeMeasure.reset();
            if (!pSSysBICubeMeasureService.setModelV2ResScope(pSSysBICubeMeasure, "PSSYSBICUBE", pSSysBICube.getPSSysBICubeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBICubeMeasureService.importModelV2(pSSysBICubeMeasure, objectNode);
            SessionFactoryManager.commit();
            return pSSysBICubeMeasureService.getFile(pSSysBICubeMeasure);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysBICube pSSysBICube, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysBICubeDimensions(pSSysBICube, list);
        this.onFillPasteHelps_PSSysBICubeMeasures(pSSysBICube, list);
        super.onFillPasteHelps(pSSysBICube, list);
    }

    protected void onFillPasteHelps_PSSysBICubeDimensions(PSSysBICube pSSysBICube, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBICUBEDIMENSION");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBICUBEDIMENSION_PSSYSBICUBE_PSSYSBICUBEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u667a\u80fd\u7acb\u65b9\u4f53]\u7684[\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysBICubeMeasures(PSSysBICube pSSysBICube, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBICUBEMEASURE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBICUBEMEASURE_PSSYSBICUBE_PSSYSBICUBEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u667a\u80fd\u7acb\u65b9\u4f53]\u7684[\u667a\u80fd\u7acb\u65b9\u4f53\u6307\u6807]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBICube pSSysBICube, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Cube");
    }
}
