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
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineJobService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineJobServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSCodeListTempl;
import net.ibizsys.pscore.srv.config.entity.PSCodeListTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeList;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeListBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInstBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSCodeListDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSCodeListDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDEFTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDEFTypeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemService;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCodeListServiceBase
extends PSCoreSysServiceBase<PSCodeList> {
    private static final Log log = LogFactory.getLog(PSCodeListServiceBase.class);
    public static final String DATASET_CURINST = "CurInst";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSCodeListDEModel pSCodeListDEModel;
    private PSCodeListDAO pSCodeListDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService";
    }

    public PSCodeListDEModel getPSCodeListDEModel() {
        if (this.pSCodeListDEModel == null) {
            try {
                this.pSCodeListDEModel = (PSCodeListDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSCodeListDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCodeListDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCodeListDEModel();
    }

    public PSCodeListDAO getPSCodeListDAO() {
        if (this.pSCodeListDAO == null) {
            try {
                this.pSCodeListDAO = (PSCodeListDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSCodeListDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCodeListDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCodeListDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURINST, (boolean)true) == 0) {
            return this.fetchCurInst(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURINST, (boolean)true) == 0) {
            return this.fetchTempCurInst(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurInst(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURINST, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurInst(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURINST, true);
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

    protected void onFillParentInfo(PSCodeList pSCodeList, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSCODELISTTEMPL_PSCODELISTTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCodeListTemplService", (SessionFactory)this.getSessionFactory());
            PSCodeListTempl pSCodeListTempl = (PSCodeListTempl)iService.getDEModel().createEntity();
            pSCodeListTempl.set("PSCODELISTTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeListTempl);
            } else {
                iService.get((IEntity)pSCodeListTempl);
            }
            this.onFillParentInfo_PSCodeListTempl(pSCodeList, pSCodeListTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSCodeList, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSCodeList, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_BEGINVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_BeginValuePSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_BKCOLORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_BKColorPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_CLSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ClsPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_COLORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ColorPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_DATAPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_DataPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_DISABLEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_DisablePSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_ENDVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_EndValuePSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_ICONCLSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_IconClsPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_ICONCLSXPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_IconClsXPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_ICONPATHPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_IconPathPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_ICONPATHXPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_IconPathXPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_MINORSORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MinorSortPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_PVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PValuePSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_TEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TextPSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEFIELD_VALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ValuePSDEF(pSCodeList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDELOGIC_PSDEMSLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDEMSLogic(pSCodeList, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDEVIEWBASE_LINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_LinkPSDEView(pSCodeList, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDYNACODELIST_PSDYNACODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService", (SessionFactory)this.getSessionFactory());
            PSDynaCodeList pSDynaCodeList = (PSDynaCodeList)iService.getDEModel().createEntity();
            pSDynaCodeList.set("PSDYNACODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaCodeList);
            } else {
                iService.get((IEntity)pSDynaCodeList);
            }
            this.onFillParentInfo_PSDynaCodeList(pSCodeList, pSDynaCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSDYNAINST_PSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDynaInst pSDynaInst = (PSDynaInst)iService.getDEModel().createEntity();
            pSDynaInst.set("PSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaInst);
            } else {
                iService.get((IEntity)pSDynaInst);
            }
            this.onFillParentInfo_PSDynaInst(pSCodeList, pSDynaInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSLANGUAGERES_ALLTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_AllTextPSLanRes(pSCodeList, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSLANGUAGERES_EMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_EmtpyTextPSLanRes(pSCodeList, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSCodeList, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSCodeList, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSCodeList, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSCodeList, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSCodeList, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODELIST_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSCodeList, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSCodeList, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeListTempl(PSCodeList pSCodeList, PSCodeListTempl pSCodeListTempl) throws Exception {
        pSCodeList.setPSCodeListTemplId(pSCodeListTempl.getPSCodeListTemplId());
        pSCodeList.setPSCodeListTemplName(pSCodeListTempl.getPSCodeListTemplName());
    }

    protected void onFillParentInfo_PSDE(PSCodeList pSCodeList, PSDataEntity pSDataEntity) throws Exception {
        pSCodeList.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSCodeList.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSCodeList, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_PSDEDS(PSCodeList pSCodeList, PSDEDataSet pSDEDataSet) throws Exception {
        pSCodeList.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSCodeList.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
        if (pSDEDataSet.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSCodeList, pSDEDataSet.getPSDE());
        }
    }

    protected void onFillParentInfo_BeginValuePSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setBeginValuePSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setBeginValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_BKColorPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setBKColorPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setBKColorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ClsPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setClsPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setClsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ColorPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setColorPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setColorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_DataPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setDataPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setDataPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_DisablePSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setDisablePSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setDisablePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_EndValuePSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setEndValuePSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setEndValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IconClsPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setIconClsPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setIconClsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IconClsXPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setIconClsXPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setIconClsXPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IconPathPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setIconPathPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setIconPathPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IconPathXPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setIconPathXPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setIconPathXPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MinorSortPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setMinorSortPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PValuePSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setPValuePSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setPValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TextPSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setTextPSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ValuePSDEF(PSCodeList pSCodeList, PSDEField pSDEField) throws Exception {
        pSCodeList.setValuePSDEFId(pSDEField.getPSDEFieldId());
        pSCodeList.setValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEMSLogic(PSCodeList pSCodeList, PSDELogic pSDELogic) throws Exception {
        pSCodeList.setPSDEMSLogicId(pSDELogic.getPSDELogicId());
        pSCodeList.setPSDEMSLogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_LinkPSDEView(PSCodeList pSCodeList, PSDEViewBase pSDEViewBase) throws Exception {
        pSCodeList.setLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSCodeList.setLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSDynaCodeList(PSCodeList pSCodeList, PSDynaCodeList pSDynaCodeList) throws Exception {
        pSCodeList.setPSDynaCodeListId(pSDynaCodeList.getPSDynaCodeListId());
        pSCodeList.setPSDynaCodeListName(pSDynaCodeList.getPSDynaCodeListName());
    }

    protected void onFillParentInfo_PSDynaInst(PSCodeList pSCodeList, PSDynaInst pSDynaInst) throws Exception {
        pSCodeList.setPSDynaInstId(pSDynaInst.getPSDynaInstId());
        pSCodeList.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
    }

    protected void onFillParentInfo_AllTextPSLanRes(PSCodeList pSCodeList, PSLanguageRes pSLanguageRes) throws Exception {
        pSCodeList.setAllTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSCodeList.setAllTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_EmtpyTextPSLanRes(PSCodeList pSCodeList, PSLanguageRes pSLanguageRes) throws Exception {
        pSCodeList.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSCodeList.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSCodeList pSCodeList, PSModule pSModule) throws Exception {
        pSCodeList.setModColor(pSModule.getColor());
        pSCodeList.setPSModuleId(pSModule.getPSModuleId());
        pSCodeList.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSCodeList pSCodeList, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSCodeList.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSCodeList.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSCodeList pSCodeList, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSCodeList.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSCodeList.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSCodeList pSCodeList, PSSysReqItem pSSysReqItem) throws Exception {
        pSCodeList.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSCodeList.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSCodeList pSCodeList, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSCodeList.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSCodeList.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSCodeList pSCodeList, PSSystem pSSystem) throws Exception {
        pSCodeList.setPSSystemId(pSSystem.getPSSystemId());
        pSCodeList.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (bl) {
            if (pSCodeList.getCLType() == null) {
                pSCodeList.setCLType((String)this.getDefaultValue(this.getWebContext(), "", "STATIC", 25));
            }
            if (pSCodeList.getCodeName() == null) {
                pSCodeList.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "CodeList", 25));
            }
            if (pSCodeList.getUserScope() == null) {
                pSCodeList.setUserScope((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSCodeList.getValidFlag() == null) {
                pSCodeList.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSCodeList, bl);
        this.onFillEntityFullInfo_PSCodeListTempl(pSCodeList, bl);
        this.onFillEntityFullInfo_PSDE(pSCodeList, bl);
        this.onFillEntityFullInfo_PSDEDS(pSCodeList, bl);
        this.onFillEntityFullInfo_BeginValuePSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_BKColorPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_ClsPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_ColorPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_DataPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_DisablePSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_EndValuePSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_IconClsPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_IconClsXPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_IconPathPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_IconPathXPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_MinorSortPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_PValuePSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_TextPSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_ValuePSDEF(pSCodeList, bl);
        this.onFillEntityFullInfo_PSDEMSLogic(pSCodeList, bl);
        this.onFillEntityFullInfo_LinkPSDEView(pSCodeList, bl);
        this.onFillEntityFullInfo_PSDynaCodeList(pSCodeList, bl);
        this.onFillEntityFullInfo_PSDynaInst(pSCodeList, bl);
        this.onFillEntityFullInfo_AllTextPSLanRes(pSCodeList, bl);
        this.onFillEntityFullInfo_EmtpyTextPSLanRes(pSCodeList, bl);
        this.onFillEntityFullInfo_PSModule(pSCodeList, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSCodeList, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSCodeList, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSCodeList, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSCodeList, bl);
        this.onFillEntityFullInfo_PSSystem(pSCodeList, bl);
    }

    protected void onFillEntityFullInfo_PSCodeListTempl(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isPSCodeListTemplIdDirty()) {
            if (pSCodeList.getPSCodeListTemplId() != null) {
                if (pSCodeList.getPSCodeListTemplId() == null || pSCodeList.getPSCodeListTemplName() == null) {
                    PSCodeListTempl pSCodeListTempl = pSCodeList.getPSCodeListTempl();
                    pSCodeList.setPSCodeListTemplName(pSCodeListTempl.getPSCodeListTemplName());
                }
            } else {
                pSCodeList.setPSCodeListTemplName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isPSDEIdDirty()) {
            if (pSCodeList.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSCodeList.getPSDEId() == null || pSCodeList.getPSDEName() == null) {
                    pSDataEntity = pSCodeList.getPSDE();
                    pSCodeList.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSCodeList.getPSDE()).getPSSystemId(), (Object)pSCodeList.getPSSystemId()) != 0L) {
                    pSCodeList.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSCodeList, bl);
                }
            } else {
                pSCodeList.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDS(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_BeginValuePSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isBeginValuePSDEFIdDirty()) {
            if (pSCodeList.getBeginValuePSDEFId() != null) {
                if (pSCodeList.getBeginValuePSDEFId() == null || pSCodeList.getBeginValuePSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getBeginValuePSDEF();
                    pSCodeList.setBeginValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setBeginValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_BKColorPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isBKColorPSDEFIdDirty()) {
            if (pSCodeList.getBKColorPSDEFId() != null) {
                if (pSCodeList.getBKColorPSDEFId() == null || pSCodeList.getBKColorPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getBKColorPSDEF();
                    pSCodeList.setBKColorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setBKColorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ClsPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isClsPSDEFIdDirty()) {
            if (pSCodeList.getClsPSDEFId() != null) {
                if (pSCodeList.getClsPSDEFId() == null || pSCodeList.getClsPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getClsPSDEF();
                    pSCodeList.setClsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setClsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ColorPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isColorPSDEFIdDirty()) {
            if (pSCodeList.getColorPSDEFId() != null) {
                if (pSCodeList.getColorPSDEFId() == null || pSCodeList.getColorPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getColorPSDEF();
                    pSCodeList.setColorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setColorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DataPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isDataPSDEFIdDirty()) {
            if (pSCodeList.getDataPSDEFId() != null) {
                if (pSCodeList.getDataPSDEFId() == null || pSCodeList.getDataPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getDataPSDEF();
                    pSCodeList.setDataPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setDataPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DisablePSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isDisablePSDEFIdDirty()) {
            if (pSCodeList.getDisablePSDEFId() != null) {
                if (pSCodeList.getDisablePSDEFId() == null || pSCodeList.getDisablePSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getDisablePSDEF();
                    pSCodeList.setDisablePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setDisablePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_EndValuePSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isEndValuePSDEFIdDirty()) {
            if (pSCodeList.getEndValuePSDEFId() != null) {
                if (pSCodeList.getEndValuePSDEFId() == null || pSCodeList.getEndValuePSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getEndValuePSDEF();
                    pSCodeList.setEndValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setEndValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IconClsPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isIconClsPSDEFIdDirty()) {
            if (pSCodeList.getIconClsPSDEFId() != null) {
                if (pSCodeList.getIconClsPSDEFId() == null || pSCodeList.getIconClsPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getIconClsPSDEF();
                    pSCodeList.setIconClsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setIconClsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IconClsXPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isIconClsXPSDEFIdDirty()) {
            if (pSCodeList.getIconClsXPSDEFId() != null) {
                if (pSCodeList.getIconClsXPSDEFId() == null || pSCodeList.getIconClsXPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getIconClsXPSDEF();
                    pSCodeList.setIconClsXPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setIconClsXPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IconPathPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isIconPathPSDEFIdDirty()) {
            if (pSCodeList.getIconPathPSDEFId() != null) {
                if (pSCodeList.getIconPathPSDEFId() == null || pSCodeList.getIconPathPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getIconPathPSDEF();
                    pSCodeList.setIconPathPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setIconPathPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IconPathXPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isIconPathXPSDEFIdDirty()) {
            if (pSCodeList.getIconPathXPSDEFId() != null) {
                if (pSCodeList.getIconPathXPSDEFId() == null || pSCodeList.getIconPathXPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getIconPathXPSDEF();
                    pSCodeList.setIconPathXPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setIconPathXPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorSortPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isMinorSortPSDEFIdDirty()) {
            if (pSCodeList.getMinorSortPSDEFId() != null) {
                if (pSCodeList.getMinorSortPSDEFId() == null || pSCodeList.getMinorSortPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getMinorSortPSDEF();
                    pSCodeList.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setMinorSortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PValuePSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isPValuePSDEFIdDirty()) {
            if (pSCodeList.getPValuePSDEFId() != null) {
                if (pSCodeList.getPValuePSDEFId() == null || pSCodeList.getPValuePSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getPValuePSDEF();
                    pSCodeList.setPValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setPValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TextPSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isTextPSDEFIdDirty()) {
            if (pSCodeList.getTextPSDEFId() != null) {
                if (pSCodeList.getTextPSDEFId() == null || pSCodeList.getTextPSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getTextPSDEF();
                    pSCodeList.setTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ValuePSDEF(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isValuePSDEFIdDirty()) {
            if (pSCodeList.getValuePSDEFId() != null) {
                if (pSCodeList.getValuePSDEFId() == null || pSCodeList.getValuePSDEFName() == null) {
                    PSDEField pSDEField = pSCodeList.getValuePSDEF();
                    pSCodeList.setValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSCodeList.setValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEMSLogic(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LinkPSDEView(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaCodeList(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaInst(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AllTextPSLanRes(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isAllTextPSLanResIdDirty()) {
            if (pSCodeList.getAllTextPSLanResId() != null) {
                if (pSCodeList.getAllTextPSLanResId() == null || pSCodeList.getAllTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSCodeList.getAllTextPSLanRes();
                    pSCodeList.setAllTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSCodeList.setAllTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_EmtpyTextPSLanRes(PSCodeList pSCodeList, boolean bl) throws Exception {
        if (pSCodeList.isEmptyTextPSLanResIdDirty()) {
            if (pSCodeList.getEmptyTextPSLanResId() != null) {
                if (pSCodeList.getEmptyTextPSLanResId() == null || pSCodeList.getEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSCodeList.getEmtpyTextPSLanRes();
                    pSCodeList.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSCodeList.setEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSCodeList pSCodeList, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSCodeList pSCodeList, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSCodeList, bl);
    }

    public ArrayList<PSCodeList> selectByPSCodeListTempl(PSCodeListTemplBase pSCodeListTemplBase) throws Exception {
        return this.selectByPSCodeListTempl(pSCodeListTemplBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSCodeListTempl(PSCodeListTemplBase pSCodeListTemplBase, String string) throws Exception {
        return this.selectByPSCodeListTempl(pSCodeListTemplBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSCodeListTempl(PSCodeListTemplBase pSCodeListTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTTEMPLID", (Object)pSCodeListTemplBase.getPSCodeListTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByBeginValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByBeginValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByBeginValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByBeginValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByBeginValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByBKColorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByBKColorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CLSPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByClsPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByClsPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByColorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByColorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByDisablePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDisablePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByDisablePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDisablePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByDisablePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DISABLEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDisablePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDisablePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByEndValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByEndValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByEndValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByEndValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByEndValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByIconClsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIconClsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByIconClsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIconClsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByIconClsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByIconClsXPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIconClsXPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByIconClsXPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIconClsXPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByIconClsXPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ICONCLSXPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByIconClsXPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByIconClsXPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByIconPathPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIconPathPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByIconPathPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIconPathPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByIconPathPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ICONPATHPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByIconPathPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByIconPathPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByIconPathXPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIconPathXPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByIconPathXPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIconPathXPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByIconPathXPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ICONPATHXPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByIconPathXPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByIconPathXPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORSORTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorSortPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorSortPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByPValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PVALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("VALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByPSDEMSLogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDEMSLogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSDEMSLogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDEMSLogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSDEMSLogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMSLOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMSLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMSLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByPSDynaCodeList(PSDynaCodeListBase pSDynaCodeListBase) throws Exception {
        return this.selectByPSDynaCodeList(pSDynaCodeListBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSDynaCodeList(PSDynaCodeListBase pSDynaCodeListBase, String string) throws Exception {
        return this.selectByPSDynaCodeList(pSDynaCodeListBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSDynaCodeList(PSDynaCodeListBase pSDynaCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNACODELISTID", (Object)pSDynaCodeListBase.getPSDynaCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAINSTID", (Object)pSDynaInstBase.getPSDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByAllTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByAllTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByAllTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByAllTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByAllTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ALLTEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAllTextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAllTextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByEmtpyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByEmtpyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByEmtpyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByEmtpyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByEmtpyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMPTYTEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmtpyTextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmtpyTextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeList> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSCodeList> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSCodeList> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSCodeList> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSCodeListTempl(pSCodeListTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELISTTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeListTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSCODELISTTEMPL_PSCODELISTTEMPLID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSCodeListTempl), arrayList.get(0)));
        }
    }

    public void resetPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSCodeListTempl(pSCodeListTempl);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSCodeListTemplId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
        final PSCodeListTempl pSCodeListTempl2 = pSCodeListTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSCodeListTempl(pSCodeListTempl2);
                PSCodeListServiceBase.this.internalRemoveByPSCodeListTempl(pSCodeListTempl2);
                PSCodeListServiceBase.this.onAfterRemoveByPSCodeListTempl(pSCodeListTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
    }

    protected void internalRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSCodeListTempl(pSCodeListTempl);
        this.onBeforeRemoveByPSCodeListTempl(pSCodeListTempl, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSCodeListTempl(pSCodeListTempl, arrayList);
    }

    protected void onAfterRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSDEId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSCodeListServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSCodeListServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSDEDSId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSCodeListServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSCodeListServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByBeginValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_BEGINVALUEPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetBeginValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByBeginValuePSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setBeginValuePSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByBeginValuePSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByBeginValuePSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByBeginValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByBeginValuePSDEF(pSDEField);
        this.onBeforeRemoveByBeginValuePSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByBeginValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByBeginValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByBeginValuePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBeginValuePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByBKColorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_BKCOLORPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByBKColorPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setBKColorPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByBKColorPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByBKColorPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByBKColorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByBKColorPSDEF(pSDEField);
        this.onBeforeRemoveByBKColorPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByBKColorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByBKColorPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBKColorPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByClsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_CLSPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByClsPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setClsPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByClsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByClsPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByClsPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByClsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByClsPSDEF(pSDEField);
        this.onBeforeRemoveByClsPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByClsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByColorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_COLORPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByColorPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setColorPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByColorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByColorPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByColorPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByColorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByColorPSDEF(pSDEField);
        this.onBeforeRemoveByColorPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByColorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByColorPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByColorPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByDataPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_DATAPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByDataPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setDataPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByDataPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByDataPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByDataPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByDataPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByDataPSDEF(pSDEField);
        this.onBeforeRemoveByDataPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByDataPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByDisablePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByDisablePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_DISABLEPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetDisablePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByDisablePSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setDisablePSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByDisablePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByDisablePSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByDisablePSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByDisablePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDisablePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDisablePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByDisablePSDEF(pSDEField);
        this.onBeforeRemoveByDisablePSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByDisablePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDisablePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDisablePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDisablePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByEndValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByEndValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_ENDVALUEPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetEndValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByEndValuePSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setEndValuePSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByEndValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByEndValuePSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByEndValuePSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByEndValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByEndValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByEndValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByEndValuePSDEF(pSDEField);
        this.onBeforeRemoveByEndValuePSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByEndValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByEndValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByEndValuePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEndValuePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByIconClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconClsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_ICONCLSPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetIconClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconClsPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setIconClsPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByIconClsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByIconClsPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByIconClsPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByIconClsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIconClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIconClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconClsPSDEF(pSDEField);
        this.onBeforeRemoveByIconClsPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByIconClsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIconClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIconClsPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIconClsPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByIconClsXPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconClsXPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_ICONCLSXPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetIconClsXPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconClsXPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setIconClsXPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByIconClsXPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByIconClsXPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByIconClsXPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByIconClsXPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIconClsXPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIconClsXPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconClsXPSDEF(pSDEField);
        this.onBeforeRemoveByIconClsXPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByIconClsXPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIconClsXPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIconClsXPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIconClsXPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByIconPathPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconPathPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_ICONPATHPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetIconPathPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconPathPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setIconPathPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByIconPathPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByIconPathPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByIconPathPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByIconPathPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIconPathPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIconPathPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconPathPSDEF(pSDEField);
        this.onBeforeRemoveByIconPathPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByIconPathPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIconPathPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIconPathPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIconPathPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByIconPathXPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconPathXPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_ICONPATHXPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetIconPathXPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconPathXPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setIconPathXPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByIconPathXPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByIconPathXPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByIconPathXPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByIconPathXPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIconPathXPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIconPathXPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByIconPathXPSDEF(pSDEField);
        this.onBeforeRemoveByIconPathXPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByIconPathXPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIconPathXPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIconPathXPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIconPathXPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByMinorSortPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_MINORSORTPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setMinorSortPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByMinorSortPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByMinorSortPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByMinorSortPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        this.onBeforeRemoveByMinorSortPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByMinorSortPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_PVALUEPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetPValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPValuePSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPValuePSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPValuePSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByPValuePSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByPValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPValuePSDEF(pSDEField);
        this.onBeforeRemoveByPValuePSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPValuePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPValuePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_TEXTPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByTextPSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setTextPSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByTextPSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByTextPSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByTextPSDEF(pSDEField);
        this.onBeforeRemoveByTextPSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEFIELD_VALUEPSDEFID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByValuePSDEF(pSDEField);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setValuePSDEFId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByValuePSDEF(pSDEField2);
                PSCodeListServiceBase.this.internalRemoveByValuePSDEF(pSDEField2);
                PSCodeListServiceBase.this.onAfterRemoveByValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByValuePSDEF(pSDEField);
        this.onBeforeRemoveByValuePSDEF(pSDEField, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDEMSLogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDELOGIC_PSDEMSLOGICID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDEMSLogic(pSDELogic);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSDEMSLogicId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSDEMSLogic(pSDELogic2);
                PSCodeListServiceBase.this.internalRemoveByPSDEMSLogic(pSDELogic2);
                PSCodeListServiceBase.this.onAfterRemoveByPSDEMSLogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDEMSLogic(pSDELogic);
        this.onBeforeRemoveByPSDEMSLogic(pSDELogic, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSDEMSLogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMSLogic(PSDELogic pSDELogic, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMSLogic(PSDELogic pSDELogic, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDEVIEWBASE_LINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setLinkPSDEViewId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByLinkPSDEView(pSDEViewBase2);
                PSCodeListServiceBase.this.internalRemoveByLinkPSDEView(pSDEViewBase2);
                PSCodeListServiceBase.this.onAfterRemoveByLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByLinkPSDEView(pSDEViewBase, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDynaCodeList(pSDynaCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNACODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDYNACODELIST_PSDYNACODELISTID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDynaCodeList), arrayList.get(0)));
        }
    }

    public void resetPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDynaCodeList(pSDynaCodeList);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSDynaCodeListId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
        final PSDynaCodeList pSDynaCodeList2 = pSDynaCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSDynaCodeList(pSDynaCodeList2);
                PSCodeListServiceBase.this.internalRemoveByPSDynaCodeList(pSDynaCodeList2);
                PSCodeListServiceBase.this.onAfterRemoveByPSDynaCodeList(pSDynaCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
    }

    protected void internalRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDynaCodeList(pSDynaCodeList);
        this.onBeforeRemoveByPSDynaCodeList(pSDynaCodeList, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSDynaCodeList(pSDynaCodeList, arrayList);
    }

    protected void onAfterRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDynaInst(pSDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSDYNAINST_PSDYNAINSTID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSDynaInst), arrayList.get(0)));
        }
    }

    public void resetPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDynaInst(pSDynaInst);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSDynaInstId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        final PSDynaInst pSDynaInst2 = pSDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSDynaInst(pSDynaInst2);
                PSCodeListServiceBase.this.internalRemoveByPSDynaInst(pSDynaInst2);
                PSCodeListServiceBase.this.onAfterRemoveByPSDynaInst(pSDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSDynaInst(pSDynaInst);
        this.onBeforeRemoveByPSDynaInst(pSDynaInst, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSDynaInst(pSDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByAllTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByAllTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSLANGUAGERES_ALLTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetAllTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByAllTextPSLanRes(pSLanguageRes);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setAllTextPSLanResId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByAllTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByAllTextPSLanRes(pSLanguageRes2);
                PSCodeListServiceBase.this.internalRemoveByAllTextPSLanRes(pSLanguageRes2);
                PSCodeListServiceBase.this.onAfterRemoveByAllTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByAllTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByAllTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByAllTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByAllTextPSLanRes(pSLanguageRes, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByAllTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByAllTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByAllTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAllTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByEmtpyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByEmtpyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSLANGUAGERES_EMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetEmtpyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByEmtpyTextPSLanRes(pSLanguageRes);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setEmptyTextPSLanResId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByEmtpyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByEmtpyTextPSLanRes(pSLanguageRes2);
                PSCodeListServiceBase.this.internalRemoveByEmtpyTextPSLanRes(pSLanguageRes2);
                PSCodeListServiceBase.this.onAfterRemoveByEmtpyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmtpyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByEmtpyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByEmtpyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByEmtpyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByEmtpyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByEmtpyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByEmtpyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmtpyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSModule(pSModule);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSModuleId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSCodeListServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSCodeListServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSSysDynaModelId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSCodeListServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSCodeListServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSSysPFPluginId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSCodeListServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSCodeListServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSSysReqItemId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSCodeListServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSCodeListServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODELIST_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSCODELIST", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSSysSFPluginId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSCodeListServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSCodeListServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSystem(pSSystem);
        for (PSCodeList pSCodeList : arrayList) {
            PSCodeList pSCodeList2 = (PSCodeList)this.getDEModel().createEntity();
            pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
            pSCodeList2.setPSSystemId(null);
            this.update(pSCodeList2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeListServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSCodeListServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSCodeListServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSCodeList> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSCodeList pSCodeList : arrayList) {
            this.remove((IEntity)pSCodeList);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSCodeList> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCodeList pSCodeList) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        ((PSCodeItemServiceBase)pSCoreSysServiceBase).removeByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveBySFPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByXFPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveBySwimlanePSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveBySwimlanePSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeViewServiceBase)pSCoreSysServiceBase).testRemoveByCatPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).removeByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSubSysSADEFieldService)ServiceGlobal.getService(PSSubSysSADEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIPipelineJobServiceBase)pSCoreSysServiceBase).testRemoveByStepPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeDimensionServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIHierarchyServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysDEFTypeService)ServiceGlobal.getService(PSSysDEFTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDEFTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDynaModelAttrServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTDItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTranslatorServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByActionPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFVersionServiceBase)pSCoreSysServiceBase).testRemoveByWFStepPSCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByStateCodeList(pSCodeList);
        pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByWFStepCodeList(pSCodeList);
        super.onBeforeRemove(pSCodeList);
    }

    protected void onBeforeRemoveTemp(PSCodeList pSCodeList) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        pSCodeItemService.removeTempByPSCodeList(pSCodeList);
        super.onBeforeRemoveTemp((IEntity)pSCodeList);
    }

    protected void getRelatedDataTempMajor(PSCodeList pSCodeList) throws Exception {
        this.getRelatedDataTempMajor_PSCodeItem(pSCodeList);
        super.getRelatedDataTempMajor((IEntity)pSCodeList);
    }

    protected void getRelatedDataTempMajor_PSCodeItem(PSCodeList pSCodeList) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCodeItem> arrayList = null;
        String string = pSCodeList.getPSCodeListId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSCodeItemService.selectByPSCodeList(pSCodeList) : pSCodeItemService.selectTempByPSCodeList(pSCodeList);
        PSCodeListServiceBase.sortHierarchyEntities(arrayList, (String)"PSCODEITEMID", (String)"PPSCODEITEMID");
        for (PSCodeItem pSCodeItem : arrayList) {
            pSCodeItemService.getTempMajor(pSCodeItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSCodeList pSCodeList, PSCodeList pSCodeList2) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.updateRelatedDataTempMajor_removePSCodeItem(pSCodeList, pSCodeList2);
        this.updateRelatedDataTempMajor_updatePSCodeItem(pSCodeList, pSCodeList2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSCodeList, (IEntity)pSCodeList2);
    }

    protected ArrayList<PSCodeItem> updateRelatedDataTempMajor_removePSCodeItem(PSCodeList pSCodeList, PSCodeList pSCodeList2) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCodeItem> arrayList = pSCodeItemService.selectTempByPSCodeList(pSCodeList);
        ArrayList<PSCodeItem> arrayList2 = pSCodeItemService.selectByPSCodeList(pSCodeList2);
        HashMap<String, PSCodeItem> hashMap = new HashMap<String, PSCodeItem>();
        for (PSCodeItem pSCodeItem : arrayList2) {
            hashMap.put(pSCodeItem.getPSCodeItemId(), pSCodeItem);
        }
        PSCodeListServiceBase.sortHierarchyEntities(arrayList, (String)"PSCODEITEMID", (String)"PPSCODEITEMID");
        for (PSCodeItem pSCodeItem : arrayList) {
            Object object = pSCodeItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSCodeItem pSCodeItem : hashMap.values()) {
            pSCodeItemService.remove((IEntity)pSCodeItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSCodeItem(PSCodeList pSCodeList, PSCodeList pSCodeList2, ArrayList<PSCodeItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSCodeItem pSCodeItem : arrayList) {
            pSCodeItemService.updateTempMajor(pSCodeItem);
        }
    }

    protected void replaceParentInfo(PSCodeList pSCodeList, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSCodeList, cloneSession);
        if (pSCodeList.getPSCodeListTemplId() != null && (iEntity = cloneSession.getEntity("PSCODELISTTEMPL", (Object)pSCodeList.getPSCodeListTemplId())) != null) {
            this.onFillParentInfo_PSCodeListTempl(pSCodeList, (PSCodeListTempl)iEntity);
        }
        if (pSCodeList.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSCodeList.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSCodeList, (PSDataEntity)iEntity);
        }
        if (pSCodeList.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSCodeList.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSCodeList, (PSDEDataSet)iEntity);
        }
        if (pSCodeList.getBeginValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getBeginValuePSDEFId())) != null) {
            this.onFillParentInfo_BeginValuePSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getBKColorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getBKColorPSDEFId())) != null) {
            this.onFillParentInfo_BKColorPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getClsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getClsPSDEFId())) != null) {
            this.onFillParentInfo_ClsPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getColorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getColorPSDEFId())) != null) {
            this.onFillParentInfo_ColorPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getDataPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getDataPSDEFId())) != null) {
            this.onFillParentInfo_DataPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getDisablePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getDisablePSDEFId())) != null) {
            this.onFillParentInfo_DisablePSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getEndValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getEndValuePSDEFId())) != null) {
            this.onFillParentInfo_EndValuePSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getIconClsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getIconClsPSDEFId())) != null) {
            this.onFillParentInfo_IconClsPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getIconClsXPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getIconClsXPSDEFId())) != null) {
            this.onFillParentInfo_IconClsXPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getIconPathPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getIconPathPSDEFId())) != null) {
            this.onFillParentInfo_IconPathPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getIconPathXPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getIconPathXPSDEFId())) != null) {
            this.onFillParentInfo_IconPathXPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getMinorSortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getMinorSortPSDEFId())) != null) {
            this.onFillParentInfo_MinorSortPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getPValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getPValuePSDEFId())) != null) {
            this.onFillParentInfo_PValuePSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getTextPSDEFId())) != null) {
            this.onFillParentInfo_TextPSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSCodeList.getValuePSDEFId())) != null) {
            this.onFillParentInfo_ValuePSDEF(pSCodeList, (PSDEField)iEntity);
        }
        if (pSCodeList.getPSDEMSLogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSCodeList.getPSDEMSLogicId())) != null) {
            this.onFillParentInfo_PSDEMSLogic(pSCodeList, (PSDELogic)iEntity);
        }
        if (pSCodeList.getLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSCodeList.getLinkPSDEViewId())) != null) {
            this.onFillParentInfo_LinkPSDEView(pSCodeList, (PSDEViewBase)iEntity);
        }
        if (pSCodeList.getPSDynaCodeListId() != null && (iEntity = cloneSession.getEntity("PSDYNACODELIST", (Object)pSCodeList.getPSDynaCodeListId())) != null) {
            this.onFillParentInfo_PSDynaCodeList(pSCodeList, (PSDynaCodeList)iEntity);
        }
        if (pSCodeList.getPSDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDYNAINST", (Object)pSCodeList.getPSDynaInstId())) != null) {
            this.onFillParentInfo_PSDynaInst(pSCodeList, (PSDynaInst)iEntity);
        }
        if (pSCodeList.getAllTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSCodeList.getAllTextPSLanResId())) != null) {
            this.onFillParentInfo_AllTextPSLanRes(pSCodeList, (PSLanguageRes)iEntity);
        }
        if (pSCodeList.getEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSCodeList.getEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_EmtpyTextPSLanRes(pSCodeList, (PSLanguageRes)iEntity);
        }
        if (pSCodeList.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSCodeList.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSCodeList, (PSModule)iEntity);
        }
        if (pSCodeList.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSCodeList.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSCodeList, (PSSysDynaModel)iEntity);
        }
        if (pSCodeList.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSCodeList.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSCodeList, (PSSysPFPlugin)iEntity);
        }
        if (pSCodeList.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSCodeList.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSCodeList, (PSSysReqItem)iEntity);
        }
        if (pSCodeList.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSCodeList.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSCodeList, (PSSysSFPlugin)iEntity);
        }
        if (pSCodeList.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSCodeList.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSCodeList, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCodeList pSCodeList, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSCodeList, bl);
    }

    protected void onCheckEntity(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllText(bl, pSCodeList, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AllTextPSLanResId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AllTextPSLanResName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginValuePSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginValuePSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColorPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColorPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheCat(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTag(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTimeout(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CLModel(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CLType(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeItemTag(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeListSN(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColorPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColorPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DisablePSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DisablePSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSConditions(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaSysRefMode(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCache(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaSys(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndValuePSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndValuePSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconClsPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconClsPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconClsXPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconClsXPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPathPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPathPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPathXPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPathXPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncBeginValue(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncEndValue(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEViewId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortDir(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoValueEmpty(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NumberItem(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrMode(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListTemplId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListTemplName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMSLogicId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaCodeListId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PValuePSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PValuePSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Seperator(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysRefFlag(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThresholdGroupFlag(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRefFlag(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserScope(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFId(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFName(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueSeperator(bl, pSCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSCodeList, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllText(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isAllTextDirty() : !pSCodeList.isAllTextDirty()) {
            return null;
        }
        String string = pSCodeList.getAllText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AllText_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLTEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AllTextPSLanResId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isAllTextPSLanResIdDirty() : !pSCodeList.isAllTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSCodeList.getAllTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AllTextPSLanResId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLTEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AllTextPSLanResName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isAllTextPSLanResNameDirty() : !pSCodeList.isAllTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSCodeList.getAllTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AllTextPSLanResName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLTEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginValuePSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isBeginValuePSDEFIdDirty() : !pSCodeList.isBeginValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getBeginValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeginValuePSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_BeginValuePSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isBeginValuePSDEFNameDirty() : !pSCodeList.isBeginValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getBeginValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeginValuePSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_BKColorPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isBKColorPSDEFIdDirty() : !pSCodeList.isBKColorPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getBKColorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColorPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_BKColorPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isBKColorPSDEFNameDirty() : !pSCodeList.isBKColorPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getBKColorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColorPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_CacheCat(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCacheCatDirty() : !pSCodeList.isCacheCatDirty()) {
            return null;
        }
        String string = pSCodeList.getCacheCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheCat_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHECAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTag(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCacheTagDirty() : !pSCodeList.isCacheTagDirty()) {
            return null;
        }
        String string = pSCodeList.getCacheTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheTag_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTimeout(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCacheTimeoutDirty() : !pSCodeList.isCacheTimeoutDirty()) {
            return null;
        }
        Integer n = pSCodeList.getCacheTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CacheTimeout_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CLModel(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCLModelDirty() : !pSCodeList.isCLModelDirty()) {
            return null;
        }
        String string = pSCodeList.getCLModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CLModel_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClsPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isClsPSDEFIdDirty() : !pSCodeList.isClsPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getClsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClsPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isClsPSDEFNameDirty() : !pSCodeList.isClsPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getClsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CLType(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCLTypeDirty() && !bl2 : !pSCodeList.isCLTypeDirty()) {
            return null;
        }
        String string = pSCodeList.getCLType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CLType_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeItemTag(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCodeItemTagDirty() : !pSCodeList.isCodeItemTagDirty()) {
            return null;
        }
        String string = pSCodeList.getCodeItemTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeItemTag_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEITEMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeListSN(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCodeListSNDirty() : !pSCodeList.isCodeListSNDirty()) {
            return null;
        }
        String string = pSCodeList.getCodeListSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeListSN_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODELISTSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCodeNameDirty() : !pSCodeList.isCodeNameDirty()) {
            return null;
        }
        String string = pSCodeList.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSCodeList, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSCodeListDEModel(), "CODENAME", string3, pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColorPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isColorPSDEFIdDirty() : !pSCodeList.isColorPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getColorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColorPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColorPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isColorPSDEFNameDirty() : !pSCodeList.isColorPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getColorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColorPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCustomCondDirty() : !pSCodeList.isCustomCondDirty()) {
            return null;
        }
        String string = pSCodeList.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isCustomTypeDirty() : !pSCodeList.isCustomTypeDirty()) {
            return null;
        }
        String string = pSCodeList.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isDataPSDEFIdDirty() : !pSCodeList.isDataPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getDataPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isDataPSDEFNameDirty() : !pSCodeList.isDataPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getDataPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_DisablePSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isDisablePSDEFIdDirty() : !pSCodeList.isDisablePSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getDisablePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DisablePSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DISABLEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DisablePSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isDisablePSDEFNameDirty() : !pSCodeList.isDisablePSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getDisablePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DisablePSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DISABLEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSConditions(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isDSConditionsDirty() : !pSCodeList.isDSConditionsDirty()) {
            return null;
        }
        String string = pSCodeList.getDSConditions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSConditions_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSCONDITIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isDynaModelFlagDirty() : !pSCodeList.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSCodeList.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaSysRefMode(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isDynaSysRefModeDirty() : !pSCodeList.isDynaSysRefModeDirty()) {
            return null;
        }
        Integer n = pSCodeList.getDynaSysRefMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaSysRefMode_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNASYSREFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isEmptyTextDirty() : !pSCodeList.isEmptyTextDirty()) {
            return null;
        }
        String string = pSCodeList.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSLanResId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isEmptyTextPSLanResIdDirty() : !pSCodeList.isEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSCodeList.getEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSLanResName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isEmptyTextPSLanResNameDirty() : !pSCodeList.isEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSCodeList.getEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCache(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isEnableCacheDirty() : !pSCodeList.isEnableCacheDirty()) {
            return null;
        }
        Integer n = pSCodeList.getEnableCache();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCache_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECACHE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaSys(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isEnableDynaSysDirty() : !pSCodeList.isEnableDynaSysDirty()) {
            return null;
        }
        Integer n = pSCodeList.getEnableDynaSys();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaSys_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNASYS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndValuePSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isEndValuePSDEFIdDirty() : !pSCodeList.isEndValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getEndValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EndValuePSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndValuePSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isEndValuePSDEFNameDirty() : !pSCodeList.isEndValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getEndValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EndValuePSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isExtendModeDirty() : !pSCodeList.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSCodeList.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_IconClsPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIconClsPSDEFIdDirty() : !pSCodeList.isIconClsPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getIconClsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconClsPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_IconClsPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIconClsPSDEFNameDirty() : !pSCodeList.isIconClsPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getIconClsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconClsPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_IconClsXPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIconClsXPSDEFIdDirty() : !pSCodeList.isIconClsXPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getIconClsXPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconClsXPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONCLSXPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconClsXPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIconClsXPSDEFNameDirty() : !pSCodeList.isIconClsXPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getIconClsXPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconClsXPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONCLSXPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPathPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIconPathPSDEFIdDirty() : !pSCodeList.isIconPathPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getIconPathPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPathPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATHPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPathPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIconPathPSDEFNameDirty() : !pSCodeList.isIconPathPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getIconPathPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPathPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATHPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPathXPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIconPathXPSDEFIdDirty() : !pSCodeList.isIconPathXPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getIconPathXPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPathXPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATHXPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPathXPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIconPathXPSDEFNameDirty() : !pSCodeList.isIconPathXPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getIconPathXPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPathXPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATHXPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncBeginValue(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIncBeginValueDirty() : !pSCodeList.isIncBeginValueDirty()) {
            return null;
        }
        Integer n = pSCodeList.getIncBeginValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncBeginValue_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_IncEndValue(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isIncEndValueDirty() : !pSCodeList.isIncEndValueDirty()) {
            return null;
        }
        Integer n = pSCodeList.getIncEndValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncEndValue_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkPSDEViewId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isLinkPSDEViewIdDirty() : !pSCodeList.isLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSCodeList.getLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEViewId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isLockFlagDirty() : !pSCodeList.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSCodeList.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isMemoDirty() : !pSCodeList.isMemoDirty()) {
            return null;
        }
        String string = pSCodeList.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortDir(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isMinorSortDirDirty() : !pSCodeList.isMinorSortDirDirty()) {
            return null;
        }
        String string = pSCodeList.getMinorSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortDir_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isMinorSortPSDEFIdDirty() : !pSCodeList.isMinorSortPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getMinorSortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFId_MinorSortPSDEF((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_MinorSortPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isMinorSortPSDEFNameDirty() : !pSCodeList.isMinorSortPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getMinorSortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NoValueEmpty(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isNoValueEmptyDirty() : !pSCodeList.isNoValueEmptyDirty()) {
            return null;
        }
        Integer n = pSCodeList.getNoValueEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoValueEmpty_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOVALUEEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NumberItem(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isNumberItemDirty() : !pSCodeList.isNumberItemDirty()) {
            return null;
        }
        Integer n = pSCodeList.getNumberItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NumberItem_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NUMBERITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isOrderValueDirty() : !pSCodeList.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSCodeList.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrMode(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isOrModeDirty() : !pSCodeList.isOrModeDirty()) {
            return null;
        }
        String string = pSCodeList.getOrMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrMode_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPredefinedTypeDirty() : !pSCodeList.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSCodeList.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSCodeListIdDirty() && !bl2 : !pSCodeList.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSCodeListId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSCodeListNameDirty() && !bl2 : !pSCodeList.isPSCodeListNameDirty()) {
            return null;
        }
        String string = pSCodeList.getPSCodeListName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListTemplId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSCodeListTemplIdDirty() : !pSCodeList.isPSCodeListTemplIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSCodeListTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListTemplId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListTemplName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSCodeListTemplNameDirty() : !pSCodeList.isPSCodeListTemplNameDirty()) {
            return null;
        }
        String string = pSCodeList.getPSCodeListTemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListTemplName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSDEDSIdDirty() : !pSCodeList.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_PSDEDS((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEDSId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSDEIdDirty() : !pSCodeList.isPSDEIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMSLogicId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSDEMSLogicIdDirty() : !pSCodeList.isPSDEMSLogicIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSDEMSLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMSLogicId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMSLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSDENameDirty() : !pSCodeList.isPSDENameDirty()) {
            return null;
        }
        String string = pSCodeList.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaCodeListId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSDynaCodeListIdDirty() : !pSCodeList.isPSDynaCodeListIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSDynaCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaCodeListId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSDynaInstIdDirty() : !pSCodeList.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSModuleIdDirty() : !pSCodeList.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSSysDynaModelIdDirty() : !pSCodeList.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSSysPFPluginIdDirty() : !pSCodeList.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSSysReqItemIdDirty() : !pSCodeList.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSSysSFPluginIdDirty() : !pSCodeList.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPSSystemIdDirty() && !bl2 : !pSCodeList.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PValuePSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPValuePSDEFIdDirty() : !pSCodeList.isPValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getPValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PValuePSDEFId_PValuePSDEF((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PVALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PValuePSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PVALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PValuePSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isPValuePSDEFNameDirty() : !pSCodeList.isPValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getPValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PValuePSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PVALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Seperator(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isSeperatorDirty() : !pSCodeList.isSeperatorDirty()) {
            return null;
        }
        String string = pSCodeList.getSeperator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Seperator_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEPERATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isSRFSysPubDirty() : !pSCodeList.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSCodeList.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFSYSPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysRefFlag(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isSysRefFlagDirty() : !pSCodeList.isSysRefFlagDirty()) {
            return null;
        }
        Integer n = pSCodeList.getSysRefFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysRefFlag_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSREFFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isTextPSDEFIdDirty() : !pSCodeList.isTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_TextPSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isTextPSDEFNameDirty() : !pSCodeList.isTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_ThresholdGroupFlag(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isThresholdGroupFlagDirty() : !pSCodeList.isThresholdGroupFlagDirty()) {
            return null;
        }
        Integer n = pSCodeList.getThresholdGroupFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ThresholdGroupFlag_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THRESHOLDGROUPFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserCatDirty() : !pSCodeList.isUserCatDirty()) {
            return null;
        }
        String string = pSCodeList.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserDataDirty() : !pSCodeList.isUserDataDirty()) {
            return null;
        }
        String string = pSCodeList.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserData2Dirty() : !pSCodeList.isUserData2Dirty()) {
            return null;
        }
        String string = pSCodeList.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserParamsDirty() : !pSCodeList.isUserParamsDirty()) {
            return null;
        }
        String string = pSCodeList.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserRefFlag(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserRefFlagDirty() : !pSCodeList.isUserRefFlagDirty()) {
            return null;
        }
        Integer n = pSCodeList.getUserRefFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserRefFlag_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERREFFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserScope(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserScopeDirty() : !pSCodeList.isUserScopeDirty()) {
            return null;
        }
        Integer n = pSCodeList.getUserScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserScope_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERSCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserTagDirty() : !pSCodeList.isUserTagDirty()) {
            return null;
        }
        String string = pSCodeList.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserTag2Dirty() : !pSCodeList.isUserTag2Dirty()) {
            return null;
        }
        String string = pSCodeList.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserTag3Dirty() : !pSCodeList.isUserTag3Dirty()) {
            return null;
        }
        String string = pSCodeList.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isUserTag4Dirty() : !pSCodeList.isUserTag4Dirty()) {
            return null;
        }
        String string = pSCodeList.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isValidFlagDirty() : !pSCodeList.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSCodeList.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValuePSDEFId(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isValuePSDEFIdDirty() : !pSCodeList.isValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSCodeList.getValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFId_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValuePSDEFName(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isValuePSDEFNameDirty() : !pSCodeList.isValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSCodeList.getValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFName_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueSeperator(boolean bl, PSCodeList pSCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeList.isValueSeperatorDirty() : !pSCodeList.isValueSeperatorDirty()) {
            return null;
        }
        String string = pSCodeList.getValueSeperator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueSeperator_Default((IEntity)pSCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUESEPERATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCodeList pSCodeList, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSCodeList, bl);
    }

    protected void onSyncIndexEntities(PSCodeList pSCodeList, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSCodeList, bl);
    }

    public Object getDataContextValue(PSCodeList pSCodeList, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSCodeList, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSCodeList.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSystem pSSystem = pSCodeList.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSCodeList pSCodeList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSCodeItem_PSCodeList(pSCodeList, arrayList, n);
        super.onExportRelatedModel((IEntity)pSCodeList, arrayList, n);
    }

    protected void onExportRelatedModel_PSCodeItem_PSCodeList(PSCodeList pSCodeList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCodeItem> arrayList2 = pSCodeItemService.selectByPSCodeList(pSCodeList);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"2c2e8be45e9e1014248a788c59353520");
            jSONObject.put("srfdename", (Object)"PSCODEITEM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSCodeList, (String)"PSCODELISTID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSCodeItem pSCodeItem : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSCodeItem, (String)"srfsyspub", (int)1) == 0) continue;
            pSCodeItemService.exportModel(pSCodeItem, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSCodeList pSCodeList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_EmtpyTextPSLanRes(pSCodeList, arrayList, n);
        super.onExportMajorModel((IEntity)pSCodeList, arrayList, n);
    }

    protected void onExportMajorModel_EmtpyTextPSLanRes(PSCodeList pSCodeList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSCodeList.getEmtpyTextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSCodeList.getEmtpyTextPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLTEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ALLTEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllTextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ALLTEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllTextPSLanResName_Default(iEntity, bl, bl2);
        }
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
        if (StringHelper.compare((String)string, (String)"CACHECAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CLModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CLType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEITEMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeItemTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODELISTSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeListSN_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DISABLEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DisablePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DISABLEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DisablePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSCONDITIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSConditions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNASYSREFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaSysRefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECACHE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCache_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNASYS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaSys_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONCLSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconClsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONCLSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconClsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONCLSXPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconClsXPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONCLSXPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconClsXPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATHPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPathPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATHPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPathPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATHXPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPathXPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATHXPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPathXPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCBEGINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncBeginValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCENDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncEndValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"MINORSORTPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFId_MinorSortPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOVALUEEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoValueEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NUMBERITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NumberItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEDS", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_PSDEDS(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEMSLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMSLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMSLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMSLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNACODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNACODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PVALUEPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_PValuePSDEFId_PValuePSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEPERATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Seperator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSREFFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysRefFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THRESHOLDGROUPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThresholdGroupFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERREFFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserRefFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERSCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserScope_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUESEPERATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueSeperator_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ALLTEXT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AllTextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ALLTEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AllTextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ALLTEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_CacheCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHECAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CLModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClsPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLSPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClsPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLSPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CLType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeItemTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEITEMTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeListSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODELISTSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DisablePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DISABLEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DisablePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DISABLEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DSConditions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSCONDITIONS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaSysRefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EmptyText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableCache_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaSys_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_IconClsXPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONCLSXPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconClsXPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONCLSXPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPathPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATHPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPathPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATHPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPathXPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATHXPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPathXPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATHXPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_LinkPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_MinorSortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTDIR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFId_MinorSortPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("MINORSORTPSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u9ed8\u8ba4\u6392\u5e8f\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODCOLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NoValueEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NumberItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSId_PSDEDS(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEDSID", "PSDEDATASET", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u6570\u636e\u96c6\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_PSDEMSLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMSLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMSLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMSLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDynaCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNACODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNACODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PValuePSDEFId_PValuePSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PVALUEPSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u7236\u503c\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PVALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PVALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Seperator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEPERATOR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysRefFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ThresholdGroupFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserRefFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UserScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueSeperator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUESEPERATOR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSCodeList pSCodeList) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID", (boolean)true) == 0) && this.onMergeChild_PSCodeItems(pSCodeList)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSCodeList)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSCodeItems(PSCodeList pSCodeList) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("CODEITEMTAG");
        selectField.setName("UPDATEDATE");
        selectField.setFunc("MAX");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSCodeList.getPSCodeListId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSCODELISTID", (Object)pSCodeList.getPSCodeListId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSCodeList, false);
        return true;
    }

    protected void onUpdateParent(PSCodeList pSCodeList) throws Exception {
        Object object = pSCodeList.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSCODELIST_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSCodeList);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSCodeList pSCodeList, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCODELIST");
        if (!bl) {
            pSCodeList.setCodeItemTag(null);
            pSCodeList.setCreateDate(null);
            pSCodeList.setCreateMan(null);
            pSCodeList.setPSCodeListId(null);
            pSCodeList.setPSDynaInstName(null);
            pSCodeList.setSysRefFlag(null);
            pSCodeList.setUpdateDate(null);
            pSCodeList.setUpdateMan(null);
            super.exportCurXmlModel(pSCodeList, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSCodeList pSCodeList, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSCodeItem(pSCodeList, xmlNode);
        super.onExportRelatedXmlModel(pSCodeList, xmlNode);
    }

    protected void exportRelatedXmlModel_PSCodeItem(PSCodeList pSCodeList, XmlNode xmlNode) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCodeItem> arrayList = null;
        String string = pSCodeList.getPSCodeListId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSCodeItemService.selectByPSCodeList(pSCodeList, "ORDER BY ORDERVALUE ASC") : pSCodeItemService.selectTempByPSCodeList(pSCodeList, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSCODEITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSCodeItem pSCodeItem : arrayList) {
                if (pSCodeItem.getPPSCodeItemId() != null) continue;
                pSCodeItem.set("ORDERVALUE", null);
                pSCodeItemService.exportXmlModel(pSCodeItem, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSCodeList pSCodeList, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSCODEITEMS");
        this.importRelatedXmlModel_PSCodeItem(pSCodeList, xmlNode2);
        super.onImportRelatedXmlModel(pSCodeList, xmlNode);
    }

    protected void importRelatedXmlModel_PSCodeItem(PSCodeList pSCodeList, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSCodeList.getPSCodeListId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSCodeItemService.removeByPSCodeList(pSCodeList);
        } else {
            pSCodeItemService.removeTempByPSCodeList(pSCodeList);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSCodeItem pSCodeItem = new PSCodeItem();
                pSCodeItem.setOrderValue(n);
                n += 100;
                pSCodeItemService.fillParentInfo((IEntity)pSCodeItem, "DER1N", "DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID", pSCodeList.getPSCodeListId());
                pSCodeItemService.importXmlModel(pSCodeItem, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSCodeList pSCodeList, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSCodeList, string);
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
            return "DER1N_PSCODELIST_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSCODELIST_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSCodeList pSCodeList) {
        if (!StringHelper.isNullOrEmpty((String)pSCodeList.getCodeName())) {
            return pSCodeList.getCodeName();
        }
        return super.getModelV2Tag(pSCodeList);
    }

    @Override
    public boolean setModelV2Tag(PSCodeList pSCodeList, String string) {
        pSCodeList.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSCodeList pSCodeList, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSCodeList.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSCodeList, true);
        pSCodeList.set("CODENAME", string);
        if (this.select(pSCodeList, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSCodeList, true);
        return super.getModelV2Entity(pSCodeList, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSCodeList pSCodeList, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSCodeList, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSCodeList pSCodeList, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSCodeList, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSCodeList pSCodeList, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID")) {
            Object object;
            PSCodeItem pSCodeItem2;
            Object object2;
            Object object3;
            Object object4;
            PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSCodeItem> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSCODELIST#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSCODEITEM", (Object)pSCodeList.getPSCodeListId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSCodeItem2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSCodeItem2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSCodeItem>();
                object4 = pSCodeItemService.selectByPSCodeList(pSCodeList);
                object3 = StringHelper.format((String)"PSCODELIST#%1$s", (Object)pSCodeList.getPSCodeListId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSCodeItem2 = object2.next();
                    object = pSCodeItemService.getModelV2ResScope((IEntity)pSCodeItem2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSCodeItem)PSModelV2Helper.toJSONObject((IEntity)pSCodeItem2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCodeItemService.getModelV2Name(false);
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
                        if (objectNode.has("pscodeitemname")) {
                            string = objectNode.get("pscodeitemname").asText();
                        }
                        if (objectNode2.has("pscodeitemname")) {
                            string2 = objectNode2.get("pscodeitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSCodeItem pSCodeItem2 : arrayList) {
                    object = new PSCodeItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSCodeItem2, false);
                    object3.add((JsonNode)pSCodeItemService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSCodeList, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSCodeList pSCodeList) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCodeItem> arrayList = pSCodeItemService.selectByPSCodeList(pSCodeList);
        String string = StringHelper.format((String)"PSCODELIST#%1$s", (Object)pSCodeList.getPSCodeListId());
        for (PSCodeItem pSCodeItem : arrayList) {
            String string2 = pSCodeItemService.getModelV2ResScope((IEntity)pSCodeItem);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSCodeItemService.emptyModelV2(pSCodeItem);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSCodeList.getPSCodeListId());
        pSCodeItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSCodeItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSCODEITEM WHERE PSCODELISTID = ?", sqlParamList);
        super.onEmptyModelV2(pSCodeList);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCodeItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSCodeList pSCodeList, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSCodeItem pSCodeItem = new PSCodeItem();
        pSCodeItem.set("PSCODELISTID", pSCodeList.getPSCodeListId());
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCodeItemService.getModelV2Entity(pSCodeItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSCodeList, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSCodeList pSCodeList, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCodeItemService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSCodeItem pSCodeItem = new PSCodeItem();
                pSCodeItem.setPSCodeListId(pSCodeList.getPSCodeListId());
                pSCodeItem.setPSCodeListName(pSCodeList.getPSCodeListName());
                pSCodeItem.setThresholdGroupFlag(pSCodeList.getThresholdGroupFlag());
                pSCodeItemService.compileModelV2(pSCodeItem, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSCodeItem pSCodeItem = new PSCodeItem();
                    pSCodeItem.setPSCodeListId(pSCodeList.getPSCodeListId());
                    pSCodeItem.setPSCodeListName(pSCodeList.getPSCodeListName());
                    pSCodeItem.setThresholdGroupFlag(pSCodeList.getThresholdGroupFlag());
                    pSCodeItemService.compileModelV2(pSCodeItem, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSCodeList, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSCodeList pSCodeList, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSCodeItems(pSCodeList, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSCodeList, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSCodeItems(PSCodeList pSCodeList, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSCODEITEM", true), (boolean)false) == 0) {
            PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
            PSCodeItem pSCodeItem = new PSCodeItem();
            pSCodeItem.setPSCodeItemId(pSMOSFile.getPSModelId());
            if (!pSCodeItemService.get((IEntity)pSCodeItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSCodeItem.getPSCodeListId(), (String)pSCodeList.getPSCodeListId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSCodeItemService.exportModelV2(pSCodeItem);
            pSCodeItem.reset();
            if (!pSCodeItemService.setModelV2ResScope((IEntity)pSCodeItem, "PSCODELIST", pSCodeList.getPSCodeListId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSCodeItemService.importModelV2(pSCodeItem, objectNode);
            SessionFactoryManager.commit();
            return pSCodeItemService.getFile((IEntity)pSCodeItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSCodeList pSCodeList, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSCodeItems(pSCodeList, list);
        super.onFillPasteHelps(pSCodeList, list);
    }

    protected void onFillPasteHelps_PSCodeItems(PSCodeList pSCodeList, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSCODEITEM");
        pSHelpSection.setSectionParam2("DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u4ee3\u7801\u8868]\u7684[\u4ee3\u7801\u8868\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap hashMap = new HashMap();
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        ArrayList arrayList = new ArrayList();
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSCodeList pSCodeList, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "CodeList");
    }
}

