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
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSCondService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSCondServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBILevelService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBILevelServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataTypeBase;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFieldDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFieldDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDTCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDTColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETable;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETableBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBIdxFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBIdxFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSGrpParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSGrpParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELLCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEModelService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEModelServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyTargetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyTargetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESPFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESPFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlDSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlDSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDETemplService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDETemplServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionServiceBase;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEFieldBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValueBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequence;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequenceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslatorBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnitBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCaseBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTCAssertService;
import net.ibizsys.pscore.srv.systest.service.PSSysTCAssertServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemService;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcParamService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcParamServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFieldServiceBase
extends PSCoreSysServiceBase<PSDEField> {
    private static final Log log = LogFactory.getLog(PSDEFieldServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDERMAJORDE = "CurDERMajorDE";
    public static final String DATASET_CURDERMINORDE = "CurDERMinorDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_KEY = "Key";
    public static final String DATASET_KEYEX = "KeyEx";
    public static final String ACTION_AJAXFILLDVT = "AjaxFillDVT";
    public static final String ACTION_AJAXFILLDATATYPE = "AjaxFillDataType";
    public static final String ACTION_AUTOCODENAME = "AUTOCODENAME";
    public static final String ACTION_CHANGEDEFTYPE = "ChangeDEFType";
    public static final String ACTION_CREATEDEFAULTINPUTTIP = "CreateDefaultInputTip";
    public static final String ACTION_CREATEDEFAULTVR = "CreateDefaultVR";
    public static final String ACTION_MAKELINKMODE = "MAKELINKMODE";
    public static final String ACTION_MAKEREALMODE = "MAKEREALMODE";
    public static final String ACTION_RESETREFS = "RESETREFS";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEFieldDEModel pSDEFieldDEModel;
    private PSDEFieldDAO pSDEFieldDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService";
    }

    public PSDEFieldDEModel getPSDEFieldDEModel() {
        if (this.pSDEFieldDEModel == null) {
            try {
                this.pSDEFieldDEModel = (PSDEFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFieldDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFieldDEModel();
    }

    public PSDEFieldDAO getPSDEFieldDAO() {
        if (this.pSDEFieldDAO == null) {
            try {
                this.pSDEFieldDAO = (PSDEFieldDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFieldDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFieldDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFieldDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDERMAJORDE, (boolean)true) == 0) {
            return this.fetchCurDERMajorDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDERMINORDE, (boolean)true) == 0) {
            return this.fetchCurDERMinorDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_KEY, (boolean)true) == 0) {
            return this.fetchKey(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_KEYEX, (boolean)true) == 0) {
            return this.fetchKeyEx(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_AJAXFILLDVT, (boolean)true) == 0) {
            this.ajaxFillDVT((PSDEField)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_AJAXFILLDATATYPE, (boolean)true) == 0) {
            this.ajaxFillDataType((PSDEField)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_AUTOCODENAME, (boolean)true) == 0) {
            this.autoCodeName((PSDEField)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGEDEFTYPE, (boolean)true) == 0) {
            this.changeDEFType((PSDEField)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEDEFAULTINPUTTIP, (boolean)true) == 0) {
            this.createDefaultInputTip((PSDEField)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEDEFAULTVR, (boolean)true) == 0) {
            this.createDefaultVR((PSDEField)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_MAKELINKMODE, (boolean)true) == 0) {
            this.makeLinkMode((PSDEField)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_MAKEREALMODE, (boolean)true) == 0) {
            this.makeRealMode((PSDEField)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_RESETREFS, (boolean)true) == 0) {
            this.resetRefs((PSDEField)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDERMajorDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDERMAJORDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDERMinorDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDERMINORDE, false);
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

    public DBFetchResult fetchKey(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_KEY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchKeyEx(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_KEYEX, false);
        return dBFetchResult;
    }

    public void ajaxFillDVT(PSDEField pSDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLDVT, 0, (IEntity)pSDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEField, ACTION_AJAXFILLDVT);
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFieldServiceBase.this.getService(), PSDEFieldServiceBase.ACTION_AJAXFILLDVT, 40, (IEntity)pSDEField2, null).getResult() != 1) {
                    PSDEFieldServiceBase.this.onAjaxFillDVT(pSDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLDVT, 99, (IEntity)pSDEField, null);
        }
    }

    protected void onAjaxFillDVT(PSDEField pSDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[AjaxFillDVT]");
    }

    public void ajaxFillDataType(PSDEField pSDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLDATATYPE, 0, (IEntity)pSDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEField, ACTION_AJAXFILLDATATYPE);
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFieldServiceBase.this.getService(), PSDEFieldServiceBase.ACTION_AJAXFILLDATATYPE, 40, (IEntity)pSDEField2, null).getResult() != 1) {
                    PSDEFieldServiceBase.this.onAjaxFillDataType(pSDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLDATATYPE, 99, (IEntity)pSDEField, null);
        }
    }

    protected void onAjaxFillDataType(PSDEField pSDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[AjaxFillDataType]");
    }

    public void autoCodeName(PSDEField pSDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_AUTOCODENAME, 0, (IEntity)pSDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEField, ACTION_AUTOCODENAME);
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFieldServiceBase.this.getService(), PSDEFieldServiceBase.ACTION_AUTOCODENAME, 40, (IEntity)pSDEField2, null).getResult() != 1) {
                    PSDEFieldServiceBase.this.onAutoCodeName(pSDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_AUTOCODENAME, 99, (IEntity)pSDEField, null);
        }
    }

    protected void onAutoCodeName(PSDEField pSDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[AUTOCODENAME]");
    }

    public void changeDEFType(PSDEField pSDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDEFTYPE, 0, (IEntity)pSDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEField, ACTION_CHANGEDEFTYPE);
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFieldServiceBase.this.getService(), PSDEFieldServiceBase.ACTION_CHANGEDEFTYPE, 40, (IEntity)pSDEField2, null).getResult() != 1) {
                    PSDEFieldServiceBase.this.onChangeDEFType(pSDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDEFTYPE, 99, (IEntity)pSDEField, null);
        }
    }

    protected void onChangeDEFType(PSDEField pSDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeDEFType]");
    }

    public void createDefaultInputTip(PSDEField pSDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEFAULTINPUTTIP, 0, (IEntity)pSDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEField, ACTION_CREATEDEFAULTINPUTTIP);
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFieldServiceBase.this.getService(), PSDEFieldServiceBase.ACTION_CREATEDEFAULTINPUTTIP, 40, (IEntity)pSDEField2, null).getResult() != 1) {
                    PSDEFieldServiceBase.this.onCreateDefaultInputTip(pSDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEFAULTINPUTTIP, 99, (IEntity)pSDEField, null);
        }
    }

    protected void onCreateDefaultInputTip(PSDEField pSDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateDefaultInputTip]");
    }

    public void createDefaultVR(PSDEField pSDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEFAULTVR, 0, (IEntity)pSDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEField, ACTION_CREATEDEFAULTVR);
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFieldServiceBase.this.getService(), PSDEFieldServiceBase.ACTION_CREATEDEFAULTVR, 40, (IEntity)pSDEField2, null).getResult() != 1) {
                    PSDEFieldServiceBase.this.onCreateDefaultVR(pSDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEFAULTVR, 99, (IEntity)pSDEField, null);
        }
    }

    protected void onCreateDefaultVR(PSDEField pSDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateDefaultVR]");
    }

    public void makeLinkMode(PSDEField pSDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_MAKELINKMODE, 0, (IEntity)pSDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEField, ACTION_MAKELINKMODE);
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFieldServiceBase.this.getService(), PSDEFieldServiceBase.ACTION_MAKELINKMODE, 40, (IEntity)pSDEField2, null).getResult() != 1) {
                    PSDEFieldServiceBase.this.onMakeLinkMode(pSDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_MAKELINKMODE, 99, (IEntity)pSDEField, null);
        }
    }

    protected void onMakeLinkMode(PSDEField pSDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[MAKELINKMODE]");
    }

    public void makeRealMode(PSDEField pSDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_MAKEREALMODE, 0, (IEntity)pSDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEField, ACTION_MAKEREALMODE);
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFieldServiceBase.this.getService(), PSDEFieldServiceBase.ACTION_MAKEREALMODE, 40, (IEntity)pSDEField2, null).getResult() != 1) {
                    PSDEFieldServiceBase.this.onMakeRealMode(pSDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_MAKEREALMODE, 99, (IEntity)pSDEField, null);
        }
    }

    protected void onMakeRealMode(PSDEField pSDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[MAKEREALMODE]");
    }

    public void resetRefs(PSDEField pSDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_RESETREFS, 0, (IEntity)pSDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEField, ACTION_RESETREFS);
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFieldServiceBase.this.getService(), PSDEFieldServiceBase.ACTION_RESETREFS, 40, (IEntity)pSDEField2, null).getResult() != 1) {
                    PSDEFieldServiceBase.this.onResetRefs(pSDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_RESETREFS, 99, (IEntity)pSDEField, null);
        }
    }

    protected void onResetRefs(PSDEField pSDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RESETREFS]");
    }

    protected void onFillParentInfo(PSDEField pSDEField, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSDEField, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEField, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDEFDATATYPE_PSDATATYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService", (SessionFactory)this.getSessionFactory());
            PSDEFDataType pSDEFDataType = (PSDEFDataType)iService.getDEModel().createEntity();
            pSDEFDataType.set("PSDEFDATATYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFDataType);
            } else {
                iService.get((IEntity)pSDEFDataType);
            }
            this.onFillParentInfo_PSDataType(pSDEField, pSDEFDataType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField2 = (PSDEField)iService.getDEModel().createEntity();
            pSDEField2.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField2);
            } else {
                iService.get((IEntity)pSDEField2);
            }
            this.onFillParentInfo_DERPSDEF(pSDEField, pSDEField2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDEFIELD_DUPCHKPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField3 = (PSDEField)iService.getDEModel().createEntity();
            pSDEField3.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField3);
            } else {
                iService.get((IEntity)pSDEField3);
            }
            this.onFillParentInfo_DupChkPSDEF(pSDEField, pSDEField3);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDEFIELD_NO2DUPCHKPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField4 = (PSDEField)iService.getDEModel().createEntity();
            pSDEField4.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField4);
            } else {
                iService.get((IEntity)pSDEField4);
            }
            this.onFillParentInfo_No2DupChkPSDEF(pSDEField, pSDEField4);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDEFIELD_NO3DUPCHKPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField5 = (PSDEField)iService.getDEModel().createEntity();
            pSDEField5.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField5);
            } else {
                iService.get((IEntity)pSDEField5);
            }
            this.onFillParentInfo_No3DupChkPSDEF(pSDEField, pSDEField5);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDEFIELD_RESTRICTEDPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField6 = (PSDEField)iService.getDEModel().createEntity();
            pSDEField6.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField6);
            } else {
                iService.get((IEntity)pSDEField6);
            }
            this.onFillParentInfo_RestrictedPSDEF(pSDEField, pSDEField6);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDEFIELD_VALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField7 = (PSDEField)iService.getDEModel().createEntity();
            pSDEField7.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField7);
            } else {
                iService.get((IEntity)pSDEField7);
            }
            this.onFillParentInfo_ValuePSDEF(pSDEField, pSDEField7);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDER_O2MPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_O2MPSDER(pSDEField, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDER_O2OPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_O2OPSDER(pSDEField, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_PSDER(pSDEField, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDETABLE_PSDETABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETableService", (SessionFactory)this.getSessionFactory());
            PSDETable pSDETable = (PSDETable)iService.getDEModel().createEntity();
            pSDETable.set("PSDETABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDETable);
            } else {
                iService.get((IEntity)pSDETable);
            }
            this.onFillParentInfo_PSDETable(pSDEField, pSDETable);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSLANGUAGERES_LNPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_LNPSLanRes(pSDEField, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSUBSYSSADEFIELD_PSSUBSYSSADEFIELDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADEField pSSubSysSADEField = (PSSubSysSADEField)iService.getDEModel().createEntity();
            pSSubSysSADEField.set("PSSUBSYSSADEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysSADEField);
            } else {
                iService.get((IEntity)pSSubSysSADEField);
            }
            this.onFillParentInfo_PSSubSysSADEField(pSDEField, pSSubSysSADEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSYSDBCOLUMN_PSSYSDBCOLUMNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService", (SessionFactory)this.getSessionFactory());
            PSSysDBColumn pSSysDBColumn = (PSSysDBColumn)iService.getDEModel().createEntity();
            pSSysDBColumn.set("PSSYSDBCOLUMNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDBColumn);
            } else {
                iService.get((IEntity)pSSysDBColumn);
            }
            this.onFillParentInfo_PSSysDBColumn(pSDEField, pSSysDBColumn);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSYSDYNAMODEL_REFPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_RefPSSysDynaModel(pSDEField, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSYSSAMPLEVALUE_PSSYSSAMPLEVALUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService", (SessionFactory)this.getSessionFactory());
            PSSysSampleValue pSSysSampleValue = (PSSysSampleValue)iService.getDEModel().createEntity();
            pSSysSampleValue.set("PSSYSSAMPLEVALUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSampleValue);
            } else {
                iService.get((IEntity)pSSysSampleValue);
            }
            this.onFillParentInfo_PSSysSampleValue(pSDEField, pSSysSampleValue);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSYSSEQUENCE_PSSYSSEQUENCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService", (SessionFactory)this.getSessionFactory());
            PSSysSequence pSSysSequence = (PSSysSequence)iService.getDEModel().createEntity();
            pSSysSequence.set("PSSYSSEQUENCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSequence);
            } else {
                iService.get((IEntity)pSSysSequence);
            }
            this.onFillParentInfo_PSSysSequence(pSDEField, pSSysSequence);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSYSTRANSLATOR_EXPPSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTranslator);
            } else {
                iService.get((IEntity)pSSysTranslator);
            }
            this.onFillParentInfo_ExpPSSysTranslator(pSDEField, pSSysTranslator);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSYSTRANSLATOR_IMPPSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTranslator);
            } else {
                iService.get((IEntity)pSSysTranslator);
            }
            this.onFillParentInfo_ImpPSSysTranslator(pSDEField, pSSysTranslator);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSYSTRANSLATOR_PSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTranslator);
            } else {
                iService.get((IEntity)pSSysTranslator);
            }
            this.onFillParentInfo_PSSysTranslator(pSDEField, pSSysTranslator);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSYSUNIT_PSSYSUNITID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService", (SessionFactory)this.getSessionFactory());
            PSSysUnit pSSysUnit = (PSSysUnit)iService.getDEModel().createEntity();
            pSSysUnit.set("PSSYSUNITID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUnit);
            } else {
                iService.get((IEntity)pSSysUnit);
            }
            this.onFillParentInfo_PSSysUnit(pSDEField, pSSysUnit);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysValueRule);
            } else {
                iService.get((IEntity)pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSDEField, pSSysValueRule);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEField, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSDEField pSDEField, PSCodeList pSCodeList) throws Exception {
        pSDEField.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEField.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDE(PSDEField pSDEField, PSDataEntity pSDataEntity) throws Exception {
        pSDEField.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEField.setPSDEName(pSDataEntity.getPSDataEntityName());
        pSDEField.setPSSubSysSADEId(pSDataEntity.getPSSubSysSADEId());
        pSDEField.setPSSystemId(pSDataEntity.getPSSystemId());
    }

    protected void onFillParentInfo_PSDataType(PSDEField pSDEField, PSDEFDataType pSDEFDataType) throws Exception {
        pSDEField.setPSDataTypeId(pSDEFDataType.getPSDEFDataTypeId());
        pSDEField.setPSDataTypeName(pSDEFDataType.getPSDEFDataTypeName());
    }

    protected void onFillParentInfo_DERPSDEF(PSDEField pSDEField, PSDEField pSDEField2) throws Exception {
        pSDEField.setDERPSDEFId(pSDEField2.getPSDEFieldId());
        pSDEField.setDERPSDEFName(pSDEField2.getPSDEFieldName());
    }

    protected void onFillParentInfo_DupChkPSDEF(PSDEField pSDEField, PSDEField pSDEField2) throws Exception {
        pSDEField.setDupCheckPSDEFId(pSDEField2.getPSDEFieldId());
        pSDEField.setDupCheckPSDEFName(pSDEField2.getPSDEFieldName());
    }

    protected void onFillParentInfo_No2DupChkPSDEF(PSDEField pSDEField, PSDEField pSDEField2) throws Exception {
        pSDEField.setNo2DupChkPSDEFId(pSDEField2.getPSDEFieldId());
        pSDEField.setNo2DupChkPSDEFName(pSDEField2.getPSDEFieldName());
    }

    protected void onFillParentInfo_No3DupChkPSDEF(PSDEField pSDEField, PSDEField pSDEField2) throws Exception {
        pSDEField.setNo3DupChkPSDEFId(pSDEField2.getPSDEFieldId());
        pSDEField.setNo3DupChkPSDEFName(pSDEField2.getPSDEFieldName());
    }

    protected void onFillParentInfo_RestrictedPSDEF(PSDEField pSDEField, PSDEField pSDEField2) throws Exception {
        pSDEField.setRestrictedPSDEFId(pSDEField2.getPSDEFieldId());
        pSDEField.setRestrictedPSDEFName(pSDEField2.getPSDEFieldName());
    }

    protected void onFillParentInfo_ValuePSDEF(PSDEField pSDEField, PSDEField pSDEField2) throws Exception {
        pSDEField.setValuePSDEFId(pSDEField2.getPSDEFieldId());
        pSDEField.setValuePSDEFName(pSDEField2.getPSDEFieldName());
    }

    protected void onFillParentInfo_O2MPSDER(PSDEField pSDEField, PSDER pSDER) throws Exception {
        pSDEField.setO2MPSDERId(pSDER.getPSDERId());
        pSDEField.setO2MPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_O2OPSDER(PSDEField pSDEField, PSDER pSDER) throws Exception {
        pSDEField.setO2OPSDERId(pSDER.getPSDERId());
        pSDEField.setO2OPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSDER(PSDEField pSDEField, PSDER pSDER) throws Exception {
        pSDEField.setPSDERId(pSDER.getPSDERId());
        pSDEField.setPSDERName(pSDER.getPSDERName());
        if (pSDER.getMinorPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEField, pSDER.getMinorPSDE());
        }
    }

    protected void onFillParentInfo_PSDETable(PSDEField pSDEField, PSDETable pSDETable) throws Exception {
        pSDEField.setPSDETableId(pSDETable.getPSDETableId());
    }

    protected void onFillParentInfo_LNPSLanRes(PSDEField pSDEField, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEField.setLNPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEField.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSubSysSADEField(PSDEField pSDEField, PSSubSysSADEField pSSubSysSADEField) throws Exception {
        pSDEField.setPSSubSysSADEFieldId(pSSubSysSADEField.getPSSubSysSADEFieldId());
        pSDEField.setPSSubSysSADEFieldName(pSSubSysSADEField.getPSSubSysSADEFieldName());
    }

    protected void onFillParentInfo_PSSysDBColumn(PSDEField pSDEField, PSSysDBColumn pSSysDBColumn) throws Exception {
        pSDEField.setPSSysDBColumnId(pSSysDBColumn.getPSSysDBColumnId());
    }

    protected void onFillParentInfo_RefPSSysDynaModel(PSDEField pSDEField, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEField.setRefPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEField.setRefPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSampleValue(PSDEField pSDEField, PSSysSampleValue pSSysSampleValue) throws Exception {
        pSDEField.setPSSysSampleValueId(pSSysSampleValue.getPSSysSampleValueId());
        pSDEField.setPSSysSampleValueName(pSSysSampleValue.getPSSysSampleValueName());
    }

    protected void onFillParentInfo_PSSysSequence(PSDEField pSDEField, PSSysSequence pSSysSequence) throws Exception {
        pSDEField.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
        pSDEField.setPSSysSequenceName(pSSysSequence.getPSSysSequenceName());
    }

    protected void onFillParentInfo_ExpPSSysTranslator(PSDEField pSDEField, PSSysTranslator pSSysTranslator) throws Exception {
        pSDEField.setExpPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSDEField.setExpPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillParentInfo_ImpPSSysTranslator(PSDEField pSDEField, PSSysTranslator pSSysTranslator) throws Exception {
        pSDEField.setImpPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSDEField.setImpPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillParentInfo_PSSysTranslator(PSDEField pSDEField, PSSysTranslator pSSysTranslator) throws Exception {
        pSDEField.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSDEField.setPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillParentInfo_PSSysUnit(PSDEField pSDEField, PSSysUnit pSSysUnit) throws Exception {
        pSDEField.setPSSysUnitId(pSSysUnit.getPSSysUnitId());
        pSDEField.setPSSysUnitName(pSSysUnit.getPSSysUnitName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSDEField pSDEField, PSSysValueRule pSSysValueRule) throws Exception {
        pSDEField.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSDEField.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected boolean onFillEntityKeyValue(PSDEField pSDEField, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEField.get("PSDEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEField.get("PSDEFIELDNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEField.set(this.getPSDEFieldDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEField pSDEField, boolean bl) throws Exception {
        if (bl) {
            if (pSDEField.getAllowEmpty() == null) {
                pSDEField.setAllowEmpty((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDEField.getDEFType() == null) {
                pSDEField.setDEFType((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDEField.getEnableUserInput() == null) {
                pSDEField.setEnableUserInput((Integer)this.getDefaultValue(this.getWebContext(), "", "3", 9));
            }
            if (pSDEField.getFKey() == null) {
                pSDEField.setFKey((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getLogicName() == null) {
                pSDEField.setLogicName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5c5e\u6027", 25));
            }
            if (pSDEField.getMajorField() == null) {
                pSDEField.setMajorField((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getPKey() == null) {
                pSDEField.setPKey((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getPSDEFDTColsCnt() == null) {
                pSDEField.setPSDEFDTColsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getPSDEFieldsCnt() == null) {
                pSDEField.setPSDEFieldsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getPSDEFInputTipsCnt() == null) {
                pSDEField.setPSDEFInputTipsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getPSDEFSFItemsCnt() == null) {
                pSDEField.setPSDEFSFItemsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getPSDEFUIModesCnt() == null) {
                pSDEField.setPSDEFUIModesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getPSDEFValueRulesCnt() == null) {
                pSDEField.setPSDEFValueRulesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getPSSysTestCasesCnt() == null) {
                pSDEField.setPSSysTestCasesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEField.getValidFlag() == null) {
                pSDEField.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEField, bl);
        this.onFillEntityFullInfo_PSCodeList(pSDEField, bl);
        this.onFillEntityFullInfo_PSDE(pSDEField, bl);
        this.onFillEntityFullInfo_PSDataType(pSDEField, bl);
        this.onFillEntityFullInfo_DERPSDEF(pSDEField, bl);
        this.onFillEntityFullInfo_DupChkPSDEF(pSDEField, bl);
        this.onFillEntityFullInfo_No2DupChkPSDEF(pSDEField, bl);
        this.onFillEntityFullInfo_No3DupChkPSDEF(pSDEField, bl);
        this.onFillEntityFullInfo_RestrictedPSDEF(pSDEField, bl);
        this.onFillEntityFullInfo_ValuePSDEF(pSDEField, bl);
        this.onFillEntityFullInfo_O2MPSDER(pSDEField, bl);
        this.onFillEntityFullInfo_O2OPSDER(pSDEField, bl);
        this.onFillEntityFullInfo_PSDER(pSDEField, bl);
        this.onFillEntityFullInfo_PSDETable(pSDEField, bl);
        this.onFillEntityFullInfo_LNPSLanRes(pSDEField, bl);
        this.onFillEntityFullInfo_PSSubSysSADEField(pSDEField, bl);
        this.onFillEntityFullInfo_PSSysDBColumn(pSDEField, bl);
        this.onFillEntityFullInfo_RefPSSysDynaModel(pSDEField, bl);
        this.onFillEntityFullInfo_PSSysSampleValue(pSDEField, bl);
        this.onFillEntityFullInfo_PSSysSequence(pSDEField, bl);
        this.onFillEntityFullInfo_ExpPSSysTranslator(pSDEField, bl);
        this.onFillEntityFullInfo_ImpPSSysTranslator(pSDEField, bl);
        this.onFillEntityFullInfo_PSSysTranslator(pSDEField, bl);
        this.onFillEntityFullInfo_PSSysUnit(pSDEField, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSDEField, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isPSCodeListIdDirty()) {
            if (pSDEField.getPSCodeListId() != null) {
                if (pSDEField.getPSCodeListId() == null || pSDEField.getPSCodeListName() == null) {
                    PSCodeList pSCodeList = pSDEField.getPSCodeList();
                    pSDEField.setPSCodeListName(pSCodeList.getPSCodeListName());
                }
            } else {
                pSDEField.setPSCodeListName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isPSDEIdDirty()) {
            if (pSDEField.getPSDEId() != null) {
                if (pSDEField.getPSDEId() == null || pSDEField.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEField.getPSDE();
                    pSDEField.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEField.setPSSubSysSADEId(pSDataEntity.getPSSubSysSADEId());
                    pSDEField.setPSSystemId(pSDataEntity.getPSSystemId());
                }
            } else {
                pSDEField.setPSDEName(null);
                pSDEField.setPSSubSysSADEId(null);
                pSDEField.setPSSystemId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDataType(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isPSDataTypeIdDirty()) {
            if (pSDEField.getPSDataTypeId() != null) {
                if (pSDEField.getPSDataTypeId() == null || pSDEField.getPSDataTypeName() == null) {
                    PSDEFDataType pSDEFDataType = pSDEField.getPSDataType();
                    pSDEField.setPSDataTypeName(pSDEFDataType.getPSDEFDataTypeName());
                }
            } else {
                pSDEField.setPSDataTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DERPSDEF(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isDERPSDEFIdDirty()) {
            if (pSDEField.getDERPSDEFId() != null) {
                if (pSDEField.getDERPSDEFId() == null || pSDEField.getDERPSDEFName() == null) {
                    PSDEField pSDEField2 = pSDEField.getDERPSDEF();
                    pSDEField.setDERPSDEFName(pSDEField2.getPSDEFieldName());
                }
            } else {
                pSDEField.setDERPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DupChkPSDEF(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isDupCheckPSDEFIdDirty()) {
            if (pSDEField.getDupCheckPSDEFId() != null) {
                if (pSDEField.getDupCheckPSDEFId() == null || pSDEField.getDupCheckPSDEFName() == null) {
                    PSDEField pSDEField2 = pSDEField.getDupChkPSDEF();
                    pSDEField.setDupCheckPSDEFName(pSDEField2.getPSDEFieldName());
                }
            } else {
                pSDEField.setDupCheckPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No2DupChkPSDEF(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isNo2DupChkPSDEFIdDirty()) {
            if (pSDEField.getNo2DupChkPSDEFId() != null) {
                if (pSDEField.getNo2DupChkPSDEFId() == null || pSDEField.getNo2DupChkPSDEFName() == null) {
                    PSDEField pSDEField2 = pSDEField.getNo2DupChkPSDEF();
                    pSDEField.setNo2DupChkPSDEFName(pSDEField2.getPSDEFieldName());
                }
            } else {
                pSDEField.setNo2DupChkPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No3DupChkPSDEF(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isNo3DupChkPSDEFIdDirty()) {
            if (pSDEField.getNo3DupChkPSDEFId() != null) {
                if (pSDEField.getNo3DupChkPSDEFId() == null || pSDEField.getNo3DupChkPSDEFName() == null) {
                    PSDEField pSDEField2 = pSDEField.getNo3DupChkPSDEF();
                    pSDEField.setNo3DupChkPSDEFName(pSDEField2.getPSDEFieldName());
                }
            } else {
                pSDEField.setNo3DupChkPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RestrictedPSDEF(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isRestrictedPSDEFIdDirty()) {
            if (pSDEField.getRestrictedPSDEFId() != null) {
                if (pSDEField.getRestrictedPSDEFId() == null || pSDEField.getRestrictedPSDEFName() == null) {
                    PSDEField pSDEField2 = pSDEField.getRestrictedPSDEF();
                    pSDEField.setRestrictedPSDEFName(pSDEField2.getPSDEFieldName());
                }
            } else {
                pSDEField.setRestrictedPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ValuePSDEF(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isValuePSDEFIdDirty()) {
            if (pSDEField.getValuePSDEFId() != null) {
                if (pSDEField.getValuePSDEFId() == null || pSDEField.getValuePSDEFName() == null) {
                    PSDEField pSDEField2 = pSDEField.getValuePSDEF();
                    pSDEField.setValuePSDEFName(pSDEField2.getPSDEFieldName());
                }
            } else {
                pSDEField.setValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_O2MPSDER(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isO2MPSDERIdDirty()) {
            if (pSDEField.getO2MPSDERId() != null) {
                if (pSDEField.getO2MPSDERId() == null || pSDEField.getO2MPSDERName() == null) {
                    PSDER pSDER = pSDEField.getO2MPSDER();
                    pSDEField.setO2MPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEField.setO2MPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_O2OPSDER(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isO2OPSDERIdDirty()) {
            if (pSDEField.getO2OPSDERId() != null) {
                if (pSDEField.getO2OPSDERId() == null || pSDEField.getO2OPSDERName() == null) {
                    PSDER pSDER = pSDEField.getO2OPSDER();
                    pSDEField.setO2OPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEField.setO2OPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDER(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isPSDERIdDirty()) {
            if (pSDEField.getPSDERId() != null) {
                PSDER pSDER;
                if (pSDEField.getPSDERId() == null || pSDEField.getPSDERName() == null) {
                    pSDER = pSDEField.getPSDER();
                    pSDEField.setPSDERName(pSDER.getPSDERName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDER = pSDEField.getPSDER()).getMinorPSDEId(), (Object)pSDEField.getPSDEId()) != 0L) {
                    pSDEField.setPSDEId(pSDER.getMinorPSDEId());
                    this.onFillEntityFullInfo_PSDE(pSDEField, bl);
                }
            } else {
                pSDEField.setPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDETable(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LNPSLanRes(PSDEField pSDEField, boolean bl) throws Exception {
        if (pSDEField.isLNPSLanResIdDirty()) {
            if (pSDEField.getLNPSLanResId() != null) {
                if (pSDEField.getLNPSLanResId() == null || pSDEField.getLNPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEField.getLNPSLanRes();
                    pSDEField.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEField.setLNPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubSysSADEField(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDBColumn(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSSysDynaModel(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSampleValue(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSequence(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ExpPSSysTranslator(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ImpPSSysTranslator(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTranslator(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUnit(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSDEField pSDEField, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEField pSDEField, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEField, bl);
    }

    public ArrayList<PSDEField> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEField> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase) throws Exception {
        return this.selectByPSDataType(pSDEFDataTypeBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase, String string) throws Exception {
        return this.selectByPSDataType(pSDEFDataTypeBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDATATYPEID", (Object)pSDEFDataTypeBase.getPSDEFDataTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDataTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDataTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByDERPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDERPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEField> selectByDERPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDERPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEField> selectByDERPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DERPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDERPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDERPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByDupChkPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDupChkPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEField> selectByDupChkPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDupChkPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEField> selectByDupChkPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DUPCHKPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDupChkPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDupChkPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByNo2DupChkPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByNo2DupChkPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEField> selectByNo2DupChkPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByNo2DupChkPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEField> selectByNo2DupChkPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2DUPCHKPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2DupChkPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2DupChkPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByNo3DupChkPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByNo3DupChkPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEField> selectByNo3DupChkPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByNo3DupChkPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEField> selectByNo3DupChkPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3DUPCHKPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo3DupChkPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo3DupChkPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByRestrictedPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByRestrictedPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEField> selectByRestrictedPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByRestrictedPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEField> selectByRestrictedPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RESTRICTEDPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRestrictedPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRestrictedPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEField> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEField> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEField> selectByO2MPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByO2MPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEField> selectByO2MPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByO2MPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEField> selectByO2MPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("O2MPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByO2MPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByO2MPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByO2OPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByO2OPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEField> selectByO2OPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByO2OPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEField> selectByO2OPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("O2OPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByO2OPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByO2OPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSDETable(PSDETableBase pSDETableBase) throws Exception {
        return this.selectByPSDETable(pSDETableBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSDETable(PSDETableBase pSDETableBase, String string) throws Exception {
        return this.selectByPSDETable(pSDETableBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSDETable(PSDETableBase pSDETableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETABLEID", (Object)pSDETableBase.getPSDETableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEField> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEField> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LNPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLNPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLNPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSSubSysSADEField(PSSubSysSADEFieldBase pSSubSysSADEFieldBase) throws Exception {
        return this.selectByPSSubSysSADEField(pSSubSysSADEFieldBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSSubSysSADEField(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, String string) throws Exception {
        return this.selectByPSSubSysSADEField(pSSubSysSADEFieldBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSSubSysSADEField(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSADEFIELDID", (Object)pSSubSysSADEFieldBase.getPSSubSysSADEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysSADEFieldCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysSADEFieldCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSSysDBColumn(PSSysDBColumnBase pSSysDBColumnBase) throws Exception {
        return this.selectByPSSysDBColumn(pSSysDBColumnBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSSysDBColumn(PSSysDBColumnBase pSSysDBColumnBase, String string) throws Exception {
        return this.selectByPSSysDBColumn(pSSysDBColumnBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSSysDBColumn(PSSysDBColumnBase pSSysDBColumnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBCOLUMNID", (Object)pSSysDBColumnBase.getPSSysDBColumnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBColumnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBColumnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByRefPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByRefPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEField> selectByRefPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByRefPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEField> selectByRefPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase) throws Exception {
        return this.selectByPSSysSampleValue(pSSysSampleValueBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase, String string) throws Exception {
        return this.selectByPSSysSampleValue(pSSysSampleValueBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSAMPLEVALUEID", (Object)pSSysSampleValueBase.getPSSysSampleValueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSampleValueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSampleValueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSSysSequence(PSSysSequenceBase pSSysSequenceBase) throws Exception {
        return this.selectByPSSysSequence(pSSysSequenceBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSSysSequence(PSSysSequenceBase pSSysSequenceBase, String string) throws Exception {
        return this.selectByPSSysSequence(pSSysSequenceBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSSysSequence(PSSysSequenceBase pSSysSequenceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEQUENCEID", (Object)pSSysSequenceBase.getPSSysSequenceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSequenceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSequenceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByExpPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByExpPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSDEField> selectByExpPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByExpPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSDEField> selectByExpPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EXPPSSYSTRANSLATORID", (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByExpPSSysTranslatorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByExpPSSysTranslatorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByImpPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByImpPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSDEField> selectByImpPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByImpPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSDEField> selectByImpPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("IMPPSSYSTRANSLATORID", (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByImpPSSysTranslatorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByImpPSSysTranslatorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTRANSLATORID", (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTranslatorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTranslatorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSSysUnit(PSSysUnitBase pSSysUnitBase) throws Exception {
        return this.selectByPSSysUnit(pSSysUnitBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSSysUnit(PSSysUnitBase pSSysUnitBase, String string) throws Exception {
        return this.selectByPSSysUnit(pSSysUnitBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSSysUnit(PSSysUnitBase pSSysUnitBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNITID", (Object)pSSysUnitBase.getPSSysUnitId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUnitCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUnitCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEField> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSDEField> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSDEField> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVALUERULEID", (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSCodeListId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSDEFieldServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSDEId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEFieldServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSDataType(pSDEFDataType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFDATATYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFDataType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSDEFDATATYPE_PSDATATYPEID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSDEFDataType), arrayList.get(0)));
        }
    }

    public void resetPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSDataType(pSDEFDataType);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSDataTypeId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        final PSDEFDataType pSDEFDataType2 = pSDEFDataType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSDataType(pSDEFDataType2);
                PSDEFieldServiceBase.this.internalRemoveByPSDataType(pSDEFDataType2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSDataType(pSDEFDataType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
    }

    protected void internalRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSDataType(pSDEFDataType);
        this.onBeforeRemoveByPSDataType(pSDEFDataType, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSDataType(pSDEFDataType, arrayList);
    }

    protected void onAfterRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
    }

    protected void onBeforeRemoveByPSDataType(PSDEFDataType pSDEFDataType, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDataType(PSDEFDataType pSDEFDataType, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByDERPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByDERPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetDERPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByDERPSDEF(pSDEField);
        for (PSDEField pSDEField2 : arrayList) {
            PSDEField pSDEField3 = (PSDEField)this.getDEModel().createEntity();
            pSDEField3.setPSDEFieldId(pSDEField2.getPSDEFieldId());
            pSDEField3.setDERPSDEFId(null);
            this.update(pSDEField3);
        }
    }

    public void removeByDERPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByDERPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.internalRemoveByDERPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.onAfterRemoveByDERPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDERPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDERPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByDERPSDEF(pSDEField);
        this.onBeforeRemoveByDERPSDEF(pSDEField, arrayList);
        for (PSDEField pSDEField2 : arrayList) {
            this.remove((IEntity)pSDEField2);
        }
        this.onAfterRemoveByDERPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDERPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDERPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDERPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByDupChkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByDupChkPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSDEFIELD_DUPCHKPSDEFID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetDupChkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByDupChkPSDEF(pSDEField);
        for (PSDEField pSDEField2 : arrayList) {
            PSDEField pSDEField3 = (PSDEField)this.getDEModel().createEntity();
            pSDEField3.setPSDEFieldId(pSDEField2.getPSDEFieldId());
            pSDEField3.setDupCheckPSDEFId(null);
            this.update(pSDEField3);
        }
    }

    public void removeByDupChkPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByDupChkPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.internalRemoveByDupChkPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.onAfterRemoveByDupChkPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDupChkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDupChkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByDupChkPSDEF(pSDEField);
        this.onBeforeRemoveByDupChkPSDEF(pSDEField, arrayList);
        for (PSDEField pSDEField2 : arrayList) {
            this.remove((IEntity)pSDEField2);
        }
        this.onAfterRemoveByDupChkPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDupChkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDupChkPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDupChkPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByNo2DupChkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByNo2DupChkPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSDEFIELD_NO2DUPCHKPSDEFID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetNo2DupChkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByNo2DupChkPSDEF(pSDEField);
        for (PSDEField pSDEField2 : arrayList) {
            PSDEField pSDEField3 = (PSDEField)this.getDEModel().createEntity();
            pSDEField3.setPSDEFieldId(pSDEField2.getPSDEFieldId());
            pSDEField3.setNo2DupChkPSDEFId(null);
            this.update(pSDEField3);
        }
    }

    public void removeByNo2DupChkPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByNo2DupChkPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.internalRemoveByNo2DupChkPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.onAfterRemoveByNo2DupChkPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByNo2DupChkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByNo2DupChkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByNo2DupChkPSDEF(pSDEField);
        this.onBeforeRemoveByNo2DupChkPSDEF(pSDEField, arrayList);
        for (PSDEField pSDEField2 : arrayList) {
            this.remove((IEntity)pSDEField2);
        }
        this.onAfterRemoveByNo2DupChkPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByNo2DupChkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByNo2DupChkPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2DupChkPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByNo3DupChkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByNo3DupChkPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSDEFIELD_NO3DUPCHKPSDEFID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetNo3DupChkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByNo3DupChkPSDEF(pSDEField);
        for (PSDEField pSDEField2 : arrayList) {
            PSDEField pSDEField3 = (PSDEField)this.getDEModel().createEntity();
            pSDEField3.setPSDEFieldId(pSDEField2.getPSDEFieldId());
            pSDEField3.setNo3DupChkPSDEFId(null);
            this.update(pSDEField3);
        }
    }

    public void removeByNo3DupChkPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByNo3DupChkPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.internalRemoveByNo3DupChkPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.onAfterRemoveByNo3DupChkPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByNo3DupChkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByNo3DupChkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByNo3DupChkPSDEF(pSDEField);
        this.onBeforeRemoveByNo3DupChkPSDEF(pSDEField, arrayList);
        for (PSDEField pSDEField2 : arrayList) {
            this.remove((IEntity)pSDEField2);
        }
        this.onAfterRemoveByNo3DupChkPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByNo3DupChkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByNo3DupChkPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo3DupChkPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByRestrictedPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByRestrictedPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSDEFIELD_RESTRICTEDPSDEFID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetRestrictedPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByRestrictedPSDEF(pSDEField);
        for (PSDEField pSDEField2 : arrayList) {
            PSDEField pSDEField3 = (PSDEField)this.getDEModel().createEntity();
            pSDEField3.setPSDEFieldId(pSDEField2.getPSDEFieldId());
            pSDEField3.setRestrictedPSDEFId(null);
            this.update(pSDEField3);
        }
    }

    public void removeByRestrictedPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByRestrictedPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.internalRemoveByRestrictedPSDEF(pSDEField2);
                PSDEFieldServiceBase.this.onAfterRemoveByRestrictedPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByRestrictedPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByRestrictedPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByRestrictedPSDEF(pSDEField);
        this.onBeforeRemoveByRestrictedPSDEF(pSDEField, arrayList);
        for (PSDEField pSDEField2 : arrayList) {
            this.remove((IEntity)pSDEField2);
        }
        this.onAfterRemoveByRestrictedPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByRestrictedPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByRestrictedPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRestrictedPSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSDEFIELD_VALUEPSDEFID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByValuePSDEF(pSDEField);
        for (PSDEField pSDEField2 : arrayList) {
            PSDEField pSDEField3 = (PSDEField)this.getDEModel().createEntity();
            pSDEField3.setPSDEFieldId(pSDEField2.getPSDEFieldId());
            pSDEField3.setValuePSDEFId(null);
            this.update(pSDEField3);
        }
    }

    public void removeByValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByValuePSDEF(pSDEField2);
                PSDEFieldServiceBase.this.internalRemoveByValuePSDEF(pSDEField2);
                PSDEFieldServiceBase.this.onAfterRemoveByValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByValuePSDEF(pSDEField);
        this.onBeforeRemoveByValuePSDEF(pSDEField, arrayList);
        for (PSDEField pSDEField2 : arrayList) {
            this.remove((IEntity)pSDEField2);
        }
        this.onAfterRemoveByValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByO2MPSDER(PSDER pSDER) throws Exception {
    }

    public void resetO2MPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByO2MPSDER(pSDER);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setO2MPSDERId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByO2MPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByO2MPSDER(pSDER2);
                PSDEFieldServiceBase.this.internalRemoveByO2MPSDER(pSDER2);
                PSDEFieldServiceBase.this.onAfterRemoveByO2MPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByO2MPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByO2MPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByO2MPSDER(pSDER);
        this.onBeforeRemoveByO2MPSDER(pSDER, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByO2MPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByO2MPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByO2MPSDER(PSDER pSDER, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByO2MPSDER(PSDER pSDER, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByO2OPSDER(PSDER pSDER) throws Exception {
    }

    public void resetO2OPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByO2OPSDER(pSDER);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setO2OPSDERId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByO2OPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByO2OPSDER(pSDER2);
                PSDEFieldServiceBase.this.internalRemoveByO2OPSDER(pSDER2);
                PSDEFieldServiceBase.this.onAfterRemoveByO2OPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByO2OPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByO2OPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByO2OPSDER(pSDER);
        this.onBeforeRemoveByO2OPSDER(pSDER, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByO2OPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByO2OPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByO2OPSDER(PSDER pSDER, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByO2OPSDER(PSDER pSDER, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSDER(pSDER);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSDERId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDEFieldServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSDETable(PSDETable pSDETable) throws Exception {
    }

    public void resetPSDETable(PSDETable pSDETable) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSDETable(pSDETable);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSDETableId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSDETable(PSDETable pSDETable) throws Exception {
        final PSDETable pSDETable2 = pSDETable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSDETable(pSDETable2);
                PSDEFieldServiceBase.this.internalRemoveByPSDETable(pSDETable2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSDETable(pSDETable2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETable(PSDETable pSDETable) throws Exception {
    }

    protected void internalRemoveByPSDETable(PSDETable pSDETable) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSDETable(pSDETable);
        this.onBeforeRemoveByPSDETable(pSDETable, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSDETable(pSDETable, arrayList);
    }

    protected void onAfterRemoveByPSDETable(PSDETable pSDETable) throws Exception {
    }

    protected void onBeforeRemoveByPSDETable(PSDETable pSDETable, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETable(PSDETable pSDETable, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByLNPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSLANGUAGERES_LNPSLANRESID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setLNPSLanResId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEFieldServiceBase.this.internalRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEFieldServiceBase.this.onAfterRemoveByLNPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByLNPSLanRes(pSLanguageRes, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByLNPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysSADEField(PSSubSysSADEField pSSubSysSADEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSubSysSADEField(pSSubSysSADEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysSADEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSSUBSYSSADEFIELD_PSSUBSYSSADEFIELDID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSubSysSADEField), arrayList.get(0)));
        }
    }

    public void resetPSSubSysSADEField(PSSubSysSADEField pSSubSysSADEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSubSysSADEField(pSSubSysSADEField);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSSubSysSADEFieldId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSSubSysSADEField(PSSubSysSADEField pSSubSysSADEField) throws Exception {
        final PSSubSysSADEField pSSubSysSADEField2 = pSSubSysSADEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSSubSysSADEField(pSSubSysSADEField2);
                PSDEFieldServiceBase.this.internalRemoveByPSSubSysSADEField(pSSubSysSADEField2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSSubSysSADEField(pSSubSysSADEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysSADEField(PSSubSysSADEField pSSubSysSADEField) throws Exception {
    }

    protected void internalRemoveByPSSubSysSADEField(PSSubSysSADEField pSSubSysSADEField) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSubSysSADEField(pSSubSysSADEField);
        this.onBeforeRemoveByPSSubSysSADEField(pSSubSysSADEField, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSSubSysSADEField(pSSubSysSADEField, arrayList);
    }

    protected void onAfterRemoveByPSSubSysSADEField(PSSubSysSADEField pSSubSysSADEField) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysSADEField(PSSubSysSADEField pSSubSysSADEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysSADEField(PSSubSysSADEField pSSubSysSADEField, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
    }

    public void resetPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysDBColumn(pSSysDBColumn);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSSysDBColumnId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
        final PSSysDBColumn pSSysDBColumn2 = pSSysDBColumn;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSSysDBColumn(pSSysDBColumn2);
                PSDEFieldServiceBase.this.internalRemoveByPSSysDBColumn(pSSysDBColumn2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSSysDBColumn(pSSysDBColumn2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
    }

    protected void internalRemoveByPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysDBColumn(pSSysDBColumn);
        this.onBeforeRemoveByPSSysDBColumn(pSSysDBColumn, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSSysDBColumn(pSSysDBColumn, arrayList);
    }

    protected void onAfterRemoveByPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBColumn(PSSysDBColumn pSSysDBColumn, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBColumn(PSSysDBColumn pSSysDBColumn, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByRefPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSSYSDYNAMODEL_REFPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByRefPSSysDynaModel(pSSysDynaModel);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setRefPSSysDynaModelId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByRefPSSysDynaModel(pSSysDynaModel2);
                PSDEFieldServiceBase.this.internalRemoveByRefPSSysDynaModel(pSSysDynaModel2);
                PSDEFieldServiceBase.this.onAfterRemoveByRefPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByRefPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByRefPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByRefPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysSampleValue(pSSysSampleValue, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSAMPLEVALUE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSampleValue);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSSYSSAMPLEVALUE_PSSYSSAMPLEVALUEID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysSampleValue), arrayList.get(0)));
        }
    }

    public void resetPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysSampleValue(pSSysSampleValue);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSSysSampleValueId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        final PSSysSampleValue pSSysSampleValue2 = pSSysSampleValue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSSysSampleValue(pSSysSampleValue2);
                PSDEFieldServiceBase.this.internalRemoveByPSSysSampleValue(pSSysSampleValue2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSSysSampleValue(pSSysSampleValue2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
    }

    protected void internalRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysSampleValue(pSSysSampleValue);
        this.onBeforeRemoveByPSSysSampleValue(pSSysSampleValue, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSSysSampleValue(pSSysSampleValue, arrayList);
    }

    protected void onAfterRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysSequence(pSSysSequence, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEQUENCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSequence);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSSYSSEQUENCE_PSSYSSEQUENCEID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysSequence), arrayList.get(0)));
        }
    }

    public void resetPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysSequence(pSSysSequence);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSSysSequenceId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
        final PSSysSequence pSSysSequence2 = pSSysSequence;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSSysSequence(pSSysSequence2);
                PSDEFieldServiceBase.this.internalRemoveByPSSysSequence(pSSysSequence2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSSysSequence(pSSysSequence2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
    }

    protected void internalRemoveByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysSequence(pSSysSequence);
        this.onBeforeRemoveByPSSysSequence(pSSysSequence, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSSysSequence(pSSysSequence, arrayList);
    }

    protected void onAfterRemoveByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSequence(PSSysSequence pSSysSequence, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSequence(PSSysSequence pSSysSequence, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByExpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByExpPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSSYSTRANSLATOR_EXPPSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetExpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByExpPSSysTranslator(pSSysTranslator);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setExpPSSysTranslatorId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByExpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByExpPSSysTranslator(pSSysTranslator2);
                PSDEFieldServiceBase.this.internalRemoveByExpPSSysTranslator(pSSysTranslator2);
                PSDEFieldServiceBase.this.onAfterRemoveByExpPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByExpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByExpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByExpPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByExpPSSysTranslator(pSSysTranslator, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByExpPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByExpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByExpPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByExpPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByImpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByImpPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSSYSTRANSLATOR_IMPPSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetImpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByImpPSSysTranslator(pSSysTranslator);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setImpPSSysTranslatorId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByImpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByImpPSSysTranslator(pSSysTranslator2);
                PSDEFieldServiceBase.this.internalRemoveByImpPSSysTranslator(pSSysTranslator2);
                PSDEFieldServiceBase.this.onAfterRemoveByImpPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByImpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByImpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByImpPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByImpPSSysTranslator(pSSysTranslator, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByImpPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByImpPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByImpPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByImpPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSSYSTRANSLATOR_PSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSSysTranslatorId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSSysTranslator(pSSysTranslator2);
                PSDEFieldServiceBase.this.internalRemoveByPSSysTranslator(pSSysTranslator2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByPSSysTranslator(pSSysTranslator, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysUnit(pSSysUnit, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUnit);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSSYSUNIT_PSSYSUNITID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysUnit), arrayList.get(0)));
        }
    }

    public void resetPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysUnit(pSSysUnit);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSSysUnitId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        final PSSysUnit pSSysUnit2 = pSSysUnit;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSSysUnit(pSSysUnit2);
                PSDEFieldServiceBase.this.internalRemoveByPSSysUnit(pSSysUnit2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSSysUnit(pSSysUnit2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
    }

    protected void internalRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysUnit(pSSysUnit);
        this.onBeforeRemoveByPSSysUnit(pSSysUnit, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSSysUnit(pSSysUnit, arrayList);
    }

    protected void onAfterRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUnit(PSSysUnit pSSysUnit, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUnit(PSSysUnit pSSysUnit, ArrayList<PSDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIELD_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = (PSDEField)this.getDEModel().createEntity();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSSysValueRuleId(null);
            this.update(pSDEField2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFieldServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFieldServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFieldServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEField> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSDEField pSDEField : arrayList) {
            this.remove((IEntity)pSDEField);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEField> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEField pSDEField) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByBeginValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByBKColorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByClsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByColorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByDataPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByDisablePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByEndValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByIconClsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByIconClsXPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByIconPathPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByIconPathXPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByMinorSortPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByMinorSortPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWIContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWIFKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWINamePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWISortPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWIUrlPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWIValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWKWPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWNamePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWSortPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEAWItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByMinorSortPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGroupTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByMinorSortPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByOrderValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveBySwimlanePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDBIdxFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQCondServiceBase)pSCoreSysServiceBase).testRemoveByPSDEField(pSDEField);
        pSCoreSysServiceBase = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDTSQueueServiceBase)pSCoreSysServiceBase).testRemoveByErrorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDTSQueueServiceBase)pSCoreSysServiceBase).testRemoveByStatePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDTSQueueServiceBase)pSCoreSysServiceBase).testRemoveByTimePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFGridColService)ServiceGlobal.getService(PSDEFGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByDERPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByDupChkPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByNo2DupChkPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByNo3DupChkPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByRestrictedPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFInputTipSetServiceBase)pSCoreSysServiceBase).testRemoveByContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFInputTipSetServiceBase)pSCoreSysServiceBase).testRemoveByECPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFInputTipSetServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFInputTipSetServiceBase)pSCoreSysServiceBase).testRemoveByUniqueTagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFInputTipServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        ((PSDEFInputTipServiceBase)pSCoreSysServiceBase).removeByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).removeByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFValueRuleServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        ((PSDEFValueRuleServiceBase)pSCoreSysServiceBase).removeByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFVRCondServiceBase)pSCoreSysServiceBase).testRemoveByExtMajorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFVRCondServiceBase)pSCoreSysServiceBase).testRemoveByExtMinorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFVRCondServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).removeByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByGroupTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByMinorSortPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByOrderValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByTreePPSEF(pSDEField);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByGroupTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByMinorSortPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByOrderValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveBySwimlanePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELLCondServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELNParamServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEF(pSDEField);
        ((PSDELNParamServiceBase)pSCoreSysServiceBase).removeByDstPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELNParamServiceBase)pSCoreSysServiceBase).testRemoveBySrcPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).testRemoveBySrcPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEModelService)ServiceGlobal.getService(PSDEModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEModelServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        ((PSDEModelServiceBase)pSCoreSysServiceBase).removeByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDENotifyTargetServiceBase)pSCoreSysServiceBase).testRemoveByTargetPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDENotifyTargetServiceBase)pSCoreSysServiceBase).testRemoveByTargetTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
        ((PSDENotifyServiceBase)pSCoreSysServiceBase).testRemoveByBeginPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
        ((PSDENotifyServiceBase)pSCoreSysServiceBase).testRemoveByEndPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERDEFMapServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERDEFMapServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByCntPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByExtMajorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByExtMinorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDESPFieldService)ServiceGlobal.getService(PSDESPFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESPFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByChildCntPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByClsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByData2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByDataPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByDataTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByIconPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByLeafFlagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByNodeId2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByNodeId3PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByNodeId4PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByNodeIdPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByShapeClsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveBySortPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByTipsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEViewCtrlDSService)ServiceGlobal.getService(PSDEViewCtrlDSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlDSServiceBase)pSCoreSysServiceBase).testRemoveByMinorsortpsdef(pSDEField);
        pSCoreSysServiceBase = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardServiceBase)pSCoreSysServiceBase).testRemoveByStatePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDynaDETemplService)ServiceGlobal.getService(PSDynaDETemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaDETemplServiceBase)pSCoreSysServiceBase).testRemoveByTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEField(pSDEField);
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).removeByPSDEField(pSDEField);
        pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDColumnServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIAggColumnServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeDimensionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeDimensionServiceBase)pSCoreSysServiceBase).testRemoveByTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeLevelServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBICubeMSCondService)ServiceGlobal.getService(PSSysBICubeMSCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMSCondServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeServiceBase)pSCoreSysServiceBase).testRemoveByKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeServiceBase)pSCoreSysServiceBase).testRemoveByTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBILevelServiceBase)pSCoreSysServiceBase).testRemoveByTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBILevelServiceBase)pSCoreSysServiceBase).testRemoveByValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByBeginPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByBKColorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByClsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByColorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByData2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByDataPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByEndPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByFinishPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByIconPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByLevelPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByOrderValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByPKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByTag2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByTagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByTipsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByTotalPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByGroupTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByAltPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByBKColorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByClsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByColorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByData2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByDataPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByIconPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByLatPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByLongPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByOrderValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByShapeClsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByTag2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByTagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByTimePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByTipsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByContentTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByDDContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByFilePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByIMContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByMobTaskUrlPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByMsgTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveBySendTimePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveBySMSContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByStatePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByTagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByTag2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByTargetPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByTargetTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByTaskUrlPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByTitlePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByWXContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTargetService)ServiceGlobal.getService(PSSysMsgTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTargetServiceBase)pSCoreSysServiceBase).testRemoveByTargetPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTargetService)ServiceGlobal.getService(PSSysMsgTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTargetServiceBase)pSCoreSysServiceBase).testRemoveByTargetTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTargetService)ServiceGlobal.getService(PSSysMsgTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTargetServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTargetService)ServiceGlobal.getService(PSSysMsgTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTargetServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByContentTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByDDContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByIMContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByLanPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByMobTaskUrlPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveBySMSContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveBySubjectPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByTaskUrlPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByTemplTagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByWCContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysOPPrivService)ServiceGlobal.getService(PSSysOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByRoleTagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysOPPrivService)ServiceGlobal.getService(PSSysOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByUserIdPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysResourceServiceBase)pSCoreSysServiceBase).testRemoveByContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysResourceServiceBase)pSCoreSysServiceBase).testRemoveByNamePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysResourceServiceBase)pSCoreSysServiceBase).testRemoveByPathPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysResourceServiceBase)pSCoreSysServiceBase).testRemoveByTagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysResourceServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysResourceServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSequenceServiceBase)pSCoreSysServiceBase).testRemoveByKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSequenceServiceBase)pSCoreSysServiceBase).testRemoveByTimePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSequenceServiceBase)pSCoreSysServiceBase).testRemoveByTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSequenceServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSequenceServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSequenceServiceBase)pSCoreSysServiceBase).testRemoveByValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).testRemoveByDstKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTDItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTranslatorServiceBase)pSCoreSysServiceBase).testRemoveByKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTranslatorServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTranslatorServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTranslatorServiceBase)pSCoreSysServiceBase).testRemoveByValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByKey2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByKey3PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByKey4PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByKey5PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByKey6PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByKey7PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByKey8PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByKey9PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByKeyPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByState2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByState3PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByState4PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByState5PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByState6PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByState7PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByState8PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByStatePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdGroupServiceBase)pSCoreSysServiceBase).testRemoveByBeginValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdGroupServiceBase)pSCoreSysServiceBase).testRemoveByBKColorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdGroupServiceBase)pSCoreSysServiceBase).testRemoveByColorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdGroupServiceBase)pSCoreSysServiceBase).testRemoveByDataPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdGroupServiceBase)pSCoreSysServiceBase).testRemoveByEndValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdGroupServiceBase)pSCoreSysServiceBase).testRemoveByIconClsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdGroupServiceBase)pSCoreSysServiceBase).testRemoveByTextPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByCacheTag2PSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByCacheTagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByClsPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByContentPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByContentTypePDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByIconPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByMsgPosPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByMsgTypePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByOrderValuePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByTltleLanResTagPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByTitlePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByProxyDataPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByProxyModulePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByProxyWFPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByPWFInstPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByStatePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByWFActorPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByWFIdPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByWFInstPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByWFRetPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByWFStatePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByWFStepPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByWFVerPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByTimeoutPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFRoleService)ServiceGlobal.getService(PSWFRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFRoleServiceBase)pSCoreSysServiceBase).testRemoveByWFUserIdPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSWFRoleService)ServiceGlobal.getService(PSWFRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFRoleServiceBase)pSCoreSysServiceBase).testRemoveByWFUserNamePSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFDTColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        ((PSDEFDTColServiceBase)pSCoreSysServiceBase).removeByPSDEF(pSDEField);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEF(pSDEField);
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).removeByPSDEF(pSDEField);
        super.onBeforeRemove(pSDEField);
    }

    protected void replaceParentInfo(PSDEField pSDEField, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEField, cloneSession);
        if (pSDEField.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEField.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSDEField, (PSCodeList)iEntity);
        }
        if (pSDEField.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEField.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEField, (PSDataEntity)iEntity);
        }
        if (pSDEField.getPSDataTypeId() != null && (iEntity = cloneSession.getEntity("PSDEFDATATYPE", (Object)pSDEField.getPSDataTypeId())) != null) {
            this.onFillParentInfo_PSDataType(pSDEField, (PSDEFDataType)iEntity);
        }
        if (pSDEField.getDERPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEField.getDERPSDEFId())) != null) {
            this.onFillParentInfo_DERPSDEF(pSDEField, (PSDEField)iEntity);
        }
        if (pSDEField.getDupCheckPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEField.getDupCheckPSDEFId())) != null) {
            this.onFillParentInfo_DupChkPSDEF(pSDEField, (PSDEField)iEntity);
        }
        if (pSDEField.getNo2DupChkPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEField.getNo2DupChkPSDEFId())) != null) {
            this.onFillParentInfo_No2DupChkPSDEF(pSDEField, (PSDEField)iEntity);
        }
        if (pSDEField.getNo3DupChkPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEField.getNo3DupChkPSDEFId())) != null) {
            this.onFillParentInfo_No3DupChkPSDEF(pSDEField, (PSDEField)iEntity);
        }
        if (pSDEField.getRestrictedPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEField.getRestrictedPSDEFId())) != null) {
            this.onFillParentInfo_RestrictedPSDEF(pSDEField, (PSDEField)iEntity);
        }
        if (pSDEField.getValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEField.getValuePSDEFId())) != null) {
            this.onFillParentInfo_ValuePSDEF(pSDEField, (PSDEField)iEntity);
        }
        if (pSDEField.getO2MPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEField.getO2MPSDERId())) != null) {
            this.onFillParentInfo_O2MPSDER(pSDEField, (PSDER)iEntity);
        }
        if (pSDEField.getO2OPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEField.getO2OPSDERId())) != null) {
            this.onFillParentInfo_O2OPSDER(pSDEField, (PSDER)iEntity);
        }
        if (pSDEField.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEField.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDEField, (PSDER)iEntity);
        }
        if (pSDEField.getPSDETableId() != null && (iEntity = cloneSession.getEntity("PSDETABLE", (Object)pSDEField.getPSDETableId())) != null) {
            this.onFillParentInfo_PSDETable(pSDEField, (PSDETable)iEntity);
        }
        if (pSDEField.getLNPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEField.getLNPSLanResId())) != null) {
            this.onFillParentInfo_LNPSLanRes(pSDEField, (PSLanguageRes)iEntity);
        }
        if (pSDEField.getPSSubSysSADEFieldId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADEFIELD", (Object)pSDEField.getPSSubSysSADEFieldId())) != null) {
            this.onFillParentInfo_PSSubSysSADEField(pSDEField, (PSSubSysSADEField)iEntity);
        }
        if (pSDEField.getPSSysDBColumnId() != null && (iEntity = cloneSession.getEntity("PSSYSDBCOLUMN", (Object)pSDEField.getPSSysDBColumnId())) != null) {
            this.onFillParentInfo_PSSysDBColumn(pSDEField, (PSSysDBColumn)iEntity);
        }
        if (pSDEField.getRefPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEField.getRefPSSysDynaModelId())) != null) {
            this.onFillParentInfo_RefPSSysDynaModel(pSDEField, (PSSysDynaModel)iEntity);
        }
        if (pSDEField.getPSSysSampleValueId() != null && (iEntity = cloneSession.getEntity("PSSYSSAMPLEVALUE", (Object)pSDEField.getPSSysSampleValueId())) != null) {
            this.onFillParentInfo_PSSysSampleValue(pSDEField, (PSSysSampleValue)iEntity);
        }
        if (pSDEField.getPSSysSequenceId() != null && (iEntity = cloneSession.getEntity("PSSYSSEQUENCE", (Object)pSDEField.getPSSysSequenceId())) != null) {
            this.onFillParentInfo_PSSysSequence(pSDEField, (PSSysSequence)iEntity);
        }
        if (pSDEField.getExpPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSDEField.getExpPSSysTranslatorId())) != null) {
            this.onFillParentInfo_ExpPSSysTranslator(pSDEField, (PSSysTranslator)iEntity);
        }
        if (pSDEField.getImpPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSDEField.getImpPSSysTranslatorId())) != null) {
            this.onFillParentInfo_ImpPSSysTranslator(pSDEField, (PSSysTranslator)iEntity);
        }
        if (pSDEField.getPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSDEField.getPSSysTranslatorId())) != null) {
            this.onFillParentInfo_PSSysTranslator(pSDEField, (PSSysTranslator)iEntity);
        }
        if (pSDEField.getPSSysUnitId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIT", (Object)pSDEField.getPSSysUnitId())) != null) {
            this.onFillParentInfo_PSSysUnit(pSDEField, (PSSysUnit)iEntity);
        }
        if (pSDEField.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSDEField.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSDEField, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEField pSDEField, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEField, bl);
        pSDEField.resetPSDETableId();
        pSDEField.resetPSSysDBColumnId();
        pSDEField.resetTableName();
    }

    protected void onCheckEntity(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSDEField, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuditInfoFormat(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BizTag(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CheckRecursion(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ComputeExp(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomExportScope(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBValueMode(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBValueMode2(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFType(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERPSDEFId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERPSDEFName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DupCheckMode(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DupCheckValues(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DupCheckPSDEFId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DupCheckPSDEFName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValueType(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAudit(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableColPriv(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableQS(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableTempData(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableUserInput(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnaWriteBack(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpPSSysTranslatorId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldHolder(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldTag(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldTag2(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FKey(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormulaFields(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormulaFormat(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImportKey(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImportOrder(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImportTag(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImpPSSysTranslatorId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IndexType(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JSFormat(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JsonFormat(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Length(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorField(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxValue(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinStrLength(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinValue(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MultiFormField(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2DupChkPSDEFId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2DupChkPSDEFName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3DupChkPSDEFId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3DupChkPSDEFName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NullValOrder(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_O2MPSDERId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_O2MPSDERName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_O2OPSDERId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_O2OPSDERName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PasteReset(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PhysicalField(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKey(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedTypeParam(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreDefineType(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataTypeId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataTypeName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFDTColsCnt(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFieldId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFieldName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFieldsCnt(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFInputTipsCnt(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFSFItemsCnt(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFUIModesCnt(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFValueRulesCnt(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETableId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADEFieldId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBColumnId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSampleValueId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSequenceId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestCasesCnt(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTranslatorId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUnitId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryColumn(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryCS(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadOnlyMode(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysDynaModelId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RestrictedPSDEFId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RestrictedPSDEFName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SequenceMode(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StateField(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StringCase(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StrLength(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TableName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TableScope(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestData(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TranslatorMode(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnicodeChar(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnionKeyValue(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Unit(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnitWidth(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateOVMode(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFId(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFName(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewColLevel(bl, pSDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEField, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isAllowEmptyDirty() && !bl2 : !pSDEField.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSDEField.getAllowEmpty();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuditInfoFormat(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isAuditInfoFormatDirty() : !pSDEField.isAuditInfoFormatDirty()) {
            return null;
        }
        String string = pSDEField.getAuditInfoFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuditInfoFormat_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUDITINFOFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BizTag(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isBizTagDirty() : !pSDEField.isBizTagDirty()) {
            return null;
        }
        String string = pSDEField.getBizTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BizTag_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIZTAG");
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
                String string4 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "BIZTAG", string3, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("BIZTAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CheckRecursion(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isCheckRecursionDirty() : !pSDEField.isCheckRecursionDirty()) {
            return null;
        }
        Integer n = pSDEField.getCheckRecursion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CheckRecursion_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHECKRECURSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isCodeNameDirty() : !pSDEField.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEField.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEField, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "CODENAME", string3, pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_ComputeExp(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isComputeExpDirty() : !pSDEField.isComputeExpDirty()) {
            return null;
        }
        String string = pSDEField.getComputeExp();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ComputeExp_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COMPUTEEXP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomExportScope(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isCustomExportScopeDirty() : !pSDEField.isCustomExportScopeDirty()) {
            return null;
        }
        Integer n = pSDEField.getCustomExportScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomExportScope_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMEXPORTSCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBValueMode(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDBValueModeDirty() : !pSDEField.isDBValueModeDirty()) {
            return null;
        }
        String string = pSDEField.getDBValueMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBValueMode_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBVALUEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBValueMode2(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDBValueMode2Dirty() : !pSDEField.isDBValueMode2Dirty()) {
            return null;
        }
        String string = pSDEField.getDBValueMode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBValueMode2_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBVALUEMODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDefaultValueDirty() : !pSDEField.isDefaultValueDirty()) {
            return null;
        }
        String string = pSDEField.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFType(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDEFTypeDirty() && !bl2 : !pSDEField.isDEFTypeDirty()) {
            return null;
        }
        Integer n = pSDEField.getDEFType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DEFType_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERPSDEFId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDERPSDEFIdDirty() : !pSDEField.isDERPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEField.getDERPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DERPSDEFId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERPSDEFName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDERPSDEFNameDirty() : !pSDEField.isDERPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEField.getDERPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DERPSDEFName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DupCheckMode(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDupCheckModeDirty() : !pSDEField.isDupCheckModeDirty()) {
            return null;
        }
        String string = pSDEField.getDupCheckMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DupCheckMode_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DUPCHECKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DupCheckValues(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDupCheckValuesDirty() : !pSDEField.isDupCheckValuesDirty()) {
            return null;
        }
        String string = pSDEField.getDupCheckValues();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DupCheckValues_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DUPCHECKVALUES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DupCheckPSDEFId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDupCheckPSDEFIdDirty() : !pSDEField.isDupCheckPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEField.getDupCheckPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DupCheckPSDEFId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DUPCHKPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DupCheckPSDEFName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDupCheckPSDEFNameDirty() : !pSDEField.isDupCheckPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEField.getDupCheckPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DupCheckPSDEFName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DUPCHKPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultValueType(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDefaultValueTypeDirty() : !pSDEField.isDefaultValueTypeDirty()) {
            return null;
        }
        String string = pSDEField.getDefaultValueType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValueType_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DVT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isDynaModelFlagDirty() : !pSDEField.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEField.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableAudit(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isEnableAuditDirty() : !pSDEField.isEnableAuditDirty()) {
            return null;
        }
        Integer n = pSDEField.getEnableAudit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAudit_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEAUDIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableColPriv(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isEnableColPrivDirty() : !pSDEField.isEnableColPrivDirty()) {
            return null;
        }
        Integer n = pSDEField.getEnableColPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableColPriv_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECOLPRIV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableQS(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isEnableQSDirty() : !pSDEField.isEnableQSDirty()) {
            return null;
        }
        Integer n = pSDEField.getEnableQS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableQS_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEQS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableTempData(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isEnableTempDataDirty() : !pSDEField.isEnableTempDataDirty()) {
            return null;
        }
        Integer n = pSDEField.getEnableTempData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableTempData_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLETEMPDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableUserInput(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isEnableUserInputDirty() : !pSDEField.isEnableUserInputDirty()) {
            return null;
        }
        Integer n = pSDEField.getEnableUserInput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableUserInput_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUSERINPUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnaWriteBack(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isEnaWriteBackDirty() : !pSDEField.isEnaWriteBackDirty()) {
            return null;
        }
        Integer n = pSDEField.getEnaWriteBack();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnaWriteBack_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENAWRITEBACK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isExportScopeDirty() : !pSDEField.isExportScopeDirty()) {
            return null;
        }
        Integer n = pSDEField.getExportScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpPSSysTranslatorId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isExpPSSysTranslatorIdDirty() : !pSDEField.isExpPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSDEField.getExpPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExpPSSysTranslatorId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPPSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isExtendModeDirty() : !pSDEField.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSDEField.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_FieldHolder(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isFieldHolderDirty() : !pSDEField.isFieldHolderDirty()) {
            return null;
        }
        Integer n = pSDEField.getFieldHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FieldHolder_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldTag(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isFieldTagDirty() : !pSDEField.isFieldTagDirty()) {
            return null;
        }
        String string = pSDEField.getFieldTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldTag_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldTag2(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isFieldTag2Dirty() : !pSDEField.isFieldTag2Dirty()) {
            return null;
        }
        String string = pSDEField.getFieldTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldTag2_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FKey(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isFKeyDirty() : !pSDEField.isFKeyDirty()) {
            return null;
        }
        Integer n = pSDEField.getFKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FKey_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormulaFields(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isFormulaFieldsDirty() : !pSDEField.isFormulaFieldsDirty()) {
            return null;
        }
        String string = pSDEField.getFormulaFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormulaFields_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMULAFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormulaFormat(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isFormulaFormatDirty() : !pSDEField.isFormulaFormatDirty()) {
            return null;
        }
        String string = pSDEField.getFormulaFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormulaFormat_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMULAFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImportKey(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isImportKeyDirty() : !pSDEField.isImportKeyDirty()) {
            return null;
        }
        Integer n = pSDEField.getImportKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImportKey_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPORTKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImportOrder(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isImportOrderDirty() : !pSDEField.isImportOrderDirty()) {
            return null;
        }
        Integer n = pSDEField.getImportOrder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImportOrder_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPORTORDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImportTag(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isImportTagDirty() : !pSDEField.isImportTagDirty()) {
            return null;
        }
        String string = pSDEField.getImportTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ImportTag_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPORTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImpPSSysTranslatorId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isImpPSSysTranslatorIdDirty() : !pSDEField.isImpPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSDEField.getImpPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ImpPSSysTranslatorId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPPSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IndexType(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isIndexTypeDirty() : !pSDEField.isIndexTypeDirty()) {
            return null;
        }
        Integer n = pSDEField.getIndexType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IndexType_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INDEXTYPE");
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
                String string2 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "INDEXTYPE", string, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("INDEXTYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JSFormat(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isJSFormatDirty() : !pSDEField.isJSFormatDirty()) {
            return null;
        }
        String string = pSDEField.getJSFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JSFormat_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JsonFormat(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isJsonFormatDirty() : !pSDEField.isJsonFormatDirty()) {
            return null;
        }
        String string = pSDEField.getJsonFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JsonFormat_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSONFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Length(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isLengthDirty() : !pSDEField.isLengthDirty()) {
            return null;
        }
        Integer n = pSDEField.getLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Length_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isLNPSLanResIdDirty() : !pSDEField.isLNPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEField.getLNPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isLNPSLanResNameDirty() : !pSDEField.isLNPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEField.getLNPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isLockFlagDirty() : !pSDEField.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEField.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isLogicNameDirty() && !bl2 : !pSDEField.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEField.getLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_MajorField(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isMajorFieldDirty() && !bl2 : !pSDEField.isMajorFieldDirty()) {
            return null;
        }
        Integer n = pSDEField.getMajorField();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFIELD");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_MajorField_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L || DataTypeHelper.compare((int)9, (Object)n, (Object)"2") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "MAJORFIELD", string, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MAJORFIELD");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxValue(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isMaxValueDirty() : !pSDEField.isMaxValueDirty()) {
            return null;
        }
        String string = pSDEField.getMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaxValue_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isMemoDirty() : !pSDEField.isMemoDirty()) {
            return null;
        }
        String string = pSDEField.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinStrLength(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isMinStrLengthDirty() : !pSDEField.isMinStrLengthDirty()) {
            return null;
        }
        Integer n = pSDEField.getMinStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinStrLength_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINSTRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinValue(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isMinValueDirty() : !pSDEField.isMinValueDirty()) {
            return null;
        }
        String string = pSDEField.getMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinValue_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MultiFormField(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isMultiFormFieldDirty() : !pSDEField.isMultiFormFieldDirty()) {
            return null;
        }
        Integer n = pSDEField.getMultiFormField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MultiFormField_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MULTIFORMFIELD");
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
                String string2 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "MULTIFORMFIELD", string, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MULTIFORMFIELD");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2DupChkPSDEFId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isNo2DupChkPSDEFIdDirty() : !pSDEField.isNo2DupChkPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEField.getNo2DupChkPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2DupChkPSDEFId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2DUPCHKPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2DupChkPSDEFName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isNo2DupChkPSDEFNameDirty() : !pSDEField.isNo2DupChkPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEField.getNo2DupChkPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2DupChkPSDEFName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2DUPCHKPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3DupChkPSDEFId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isNo3DupChkPSDEFIdDirty() : !pSDEField.isNo3DupChkPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEField.getNo3DupChkPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3DupChkPSDEFId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3DUPCHKPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3DupChkPSDEFName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isNo3DupChkPSDEFNameDirty() : !pSDEField.isNo3DupChkPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEField.getNo3DupChkPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3DupChkPSDEFName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3DUPCHKPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NullValOrder(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isNullValOrderDirty() : !pSDEField.isNullValOrderDirty()) {
            return null;
        }
        String string = pSDEField.getNullValOrder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NullValOrder_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NULLVALORDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_O2MPSDERId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isO2MPSDERIdDirty() : !pSDEField.isO2MPSDERIdDirty()) {
            return null;
        }
        String string = pSDEField.getO2MPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_O2MPSDERId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("O2MPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_O2MPSDERName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isO2MPSDERNameDirty() : !pSDEField.isO2MPSDERNameDirty()) {
            return null;
        }
        String string = pSDEField.getO2MPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_O2MPSDERName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("O2MPSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_O2OPSDERId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isO2OPSDERIdDirty() : !pSDEField.isO2OPSDERIdDirty()) {
            return null;
        }
        String string = pSDEField.getO2OPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_O2OPSDERId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("O2OPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_O2OPSDERName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isO2OPSDERNameDirty() : !pSDEField.isO2OPSDERNameDirty()) {
            return null;
        }
        String string = pSDEField.getO2OPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_O2OPSDERName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("O2OPSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isOrderValueDirty() : !pSDEField.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEField.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PasteReset(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPasteResetDirty() : !pSDEField.isPasteResetDirty()) {
            return null;
        }
        Integer n = pSDEField.getPasteReset();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PasteReset_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASTERESET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PhysicalField(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPhysicalFieldDirty() : !pSDEField.isPhysicalFieldDirty()) {
            return null;
        }
        Integer n = pSDEField.getPhysicalField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PhysicalField_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHYSICALFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PKey(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPKeyDirty() && !bl2 : !pSDEField.isPKeyDirty()) {
            return null;
        }
        Integer n = pSDEField.getPKey();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEY");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PKey_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L || DataTypeHelper.compare((int)9, (Object)n, (Object)"2") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "PKEY", string, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PKEY");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPrecision2Dirty() : !pSDEField.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSDEField.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedTypeParam(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPredefinedTypeParamDirty() : !pSDEField.isPredefinedTypeParamDirty()) {
            return null;
        }
        String string = pSDEField.getPredefinedTypeParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedTypeParam_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreDefineType(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPreDefineTypeDirty() : !pSDEField.isPreDefineTypeDirty()) {
            return null;
        }
        String string = pSDEField.getPreDefineType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreDefineType_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)25, (Object)string, (Object)"ORDERVALUE") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"DATATYPE") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"VERSION") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"LOGICVALID") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"CREATEMAN") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"CREATEMANNAME") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"CREATEDATE") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"UPDATEMAN") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"UPDATEMANNAME") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"UPDATEDATE") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"ORGID") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"ORGNAME") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"ORGSECTORID") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"ORGSECTORNAME") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PARENTTYPE") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PARENTSUBTYPE") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PARENTID") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PARENTDATA") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PARENTIDPATH") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PARENTNAMEPATH") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"TIMESTAMP") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"DYNASTORAGE") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"CLOSEFLAG") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"VERSIONID") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PARENTVERSION") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PARENTVERSIONID") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"LOCKFLAG") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"CLOSEFLAG") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"CHILDTYPE") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"CHILDID") == 0L;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "PREDEFINETYPE", string3, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PREDEFINETYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSCodeListIdDirty() : !pSDEField.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSCodeListNameDirty() : !pSDEField.isPSCodeListNameDirty()) {
            return null;
        }
        String string = pSDEField.getPSCodeListName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListName_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDataTypeId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDataTypeIdDirty() && !bl2 : !pSDEField.isPSDataTypeIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSDataTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATATYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataTypeId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATATYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)25, (Object)string, (Object)"PICKUP") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PICKUPTEXT") == 0L;
            if (bl4) {
                String string3 = "";
                string3 = "PSDERID";
                String string4 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "PSDATATYPEID", string3, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDATATYPEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDataTypeName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDataTypeNameDirty() && !bl2 : !pSDEField.isPSDataTypeNameDirty()) {
            return null;
        }
        String string = pSDEField.getPSDataTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATATYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataTypeName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATATYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFDTColsCnt(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDEFDTColsCntDirty() : !pSDEField.isPSDEFDTColsCntDirty()) {
            return null;
        }
        Integer n = pSDEField.getPSDEFDTColsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEFDTColsCnt_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDTCOLSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFieldId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDEFieldIdDirty() && !bl2 : !pSDEField.isPSDEFieldIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSDEFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFieldId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFieldName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDEFieldNameDirty() && !bl2 : !pSDEField.isPSDEFieldNameDirty()) {
            return null;
        }
        String string = pSDEField.getPSDEFieldName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFieldName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "PSDEFIELDNAME", string3, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFIELDNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFieldsCnt(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDEFieldsCntDirty() : !pSDEField.isPSDEFieldsCntDirty()) {
            return null;
        }
        Integer n = pSDEField.getPSDEFieldsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEFieldsCnt_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFInputTipsCnt(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDEFInputTipsCntDirty() : !pSDEField.isPSDEFInputTipsCntDirty()) {
            return null;
        }
        Integer n = pSDEField.getPSDEFInputTipsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEFInputTipsCnt_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFINPUTTIPSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFSFItemsCnt(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDEFSFItemsCntDirty() : !pSDEField.isPSDEFSFItemsCntDirty()) {
            return null;
        }
        Integer n = pSDEField.getPSDEFSFItemsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEFSFItemsCnt_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFSFITEMSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFUIModesCnt(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDEFUIModesCntDirty() : !pSDEField.isPSDEFUIModesCntDirty()) {
            return null;
        }
        Integer n = pSDEField.getPSDEFUIModesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEFUIModesCnt_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFUIMODESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFValueRulesCnt(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDEFValueRulesCntDirty() : !pSDEField.isPSDEFValueRulesCntDirty()) {
            return null;
        }
        Integer n = pSDEField.getPSDEFValueRulesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEFValueRulesCnt_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVALUERULESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDEIdDirty() && !bl2 : !pSDEField.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDENameDirty() && !bl2 : !pSDEField.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEField.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDERIdDirty() : !pSDEField.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDERNameDirty() : !pSDEField.isPSDERNameDirty()) {
            return null;
        }
        String string = pSDEField.getPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETableId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDETableIdDirty() : !pSDEField.isPSDETableIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSDETableId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETableId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSDynaInstIdDirty() : !pSDEField.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysSADEFieldId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSSubSysSADEFieldIdDirty() : !pSDEField.isPSSubSysSADEFieldIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSSubSysSADEFieldId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADEFieldId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADEFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBColumnId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSSysDBColumnIdDirty() : !pSDEField.isPSSysDBColumnIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSSysDBColumnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBColumnId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBCOLUMNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSampleValueId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSSysSampleValueIdDirty() : !pSDEField.isPSSysSampleValueIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSSysSampleValueId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSampleValueId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSAMPLEVALUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSequenceId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSSysSequenceIdDirty() : !pSDEField.isPSSysSequenceIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSSysSequenceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSequenceId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEQUENCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestCasesCnt(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSSysTestCasesCntDirty() : !pSDEField.isPSSysTestCasesCntDirty()) {
            return null;
        }
        Integer n = pSDEField.getPSSysTestCasesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysTestCasesCnt_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTCASESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTranslatorId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSSysTranslatorIdDirty() : !pSDEField.isPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTranslatorId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUnitId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSSysUnitIdDirty() : !pSDEField.isPSSysUnitIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSSysUnitId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUnitId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNITID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isPSSysValueRuleIdDirty() : !pSDEField.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEField.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryColumn(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isQueryColumnDirty() : !pSDEField.isQueryColumnDirty()) {
            return null;
        }
        Integer n = pSDEField.getQueryColumn();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_QueryColumn_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYCOLUMN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryCS(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isQueryCSDirty() : !pSDEField.isQueryCSDirty()) {
            return null;
        }
        String string = pSDEField.getQueryCS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QueryCS_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYCS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReadOnlyMode(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isReadOnlyModeDirty() : !pSDEField.isReadOnlyModeDirty()) {
            return null;
        }
        Integer n = pSDEField.getReadOnlyMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReadOnlyMode_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSSysDynaModelId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isRefPSSysDynaModelIdDirty() : !pSDEField.isRefPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEField.getRefPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysDynaModelId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RestrictedPSDEFId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isRestrictedPSDEFIdDirty() : !pSDEField.isRestrictedPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEField.getRestrictedPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RestrictedPSDEFId_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESTRICTEDPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RestrictedPSDEFName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isRestrictedPSDEFNameDirty() : !pSDEField.isRestrictedPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEField.getRestrictedPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RestrictedPSDEFName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESTRICTEDPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SequenceMode(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isSequenceModeDirty() : !pSDEField.isSequenceModeDirty()) {
            return null;
        }
        String string = pSDEField.getSequenceMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SequenceMode_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEQUENCEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isServiceCodeNameDirty() : !pSDEField.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSDEField.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICECODENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "SERVICECODENAME", string3, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("SERVICECODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StateField(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isStateFieldDirty() : !pSDEField.isStateFieldDirty()) {
            return null;
        }
        String string = pSDEField.getStateField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StateField_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEFIELD");
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
                String string4 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "STATEFIELD", string3, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("STATEFIELD");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StringCase(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isStringCaseDirty() : !pSDEField.isStringCaseDirty()) {
            return null;
        }
        String string = pSDEField.getStringCase();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StringCase_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STRINGCASE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StrLength(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isStrLengthDirty() : !pSDEField.isStrLengthDirty()) {
            return null;
        }
        Integer n = pSDEField.getStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StrLength_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TableName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isTableNameDirty() : !pSDEField.isTableNameDirty()) {
            return null;
        }
        String string = pSDEField.getTableName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TableName_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TableScope(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isTableScopeDirty() : !pSDEField.isTableScopeDirty()) {
            return null;
        }
        String string = pSDEField.getTableScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TableScope_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABLESCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestData(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isTestDataDirty() : !pSDEField.isTestDataDirty()) {
            return null;
        }
        String string = pSDEField.getTestData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestData_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TranslatorMode(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isTranslatorModeDirty() : !pSDEField.isTranslatorModeDirty()) {
            return null;
        }
        String string = pSDEField.getTranslatorMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TranslatorMode_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRANSLATORMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UnicodeChar(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUnicodeCharDirty() : !pSDEField.isUnicodeCharDirty()) {
            return null;
        }
        Integer n = pSDEField.getUnicodeChar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UnicodeChar_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNICODECHAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UnionKeyValue(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUnionKeyValueDirty() : !pSDEField.isUnionKeyValueDirty()) {
            return null;
        }
        String string = pSDEField.getUnionKeyValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UnionKeyValue_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIONKEYVALUE");
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
                String string4 = this.checkFieldDupRule(this.getPSDEFieldDEModel(), "UNIONKEYVALUE", string3, pSDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("UNIONKEYVALUE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Unit(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUnitDirty() : !pSDEField.isUnitDirty()) {
            return null;
        }
        String string = pSDEField.getUnit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Unit_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UnitWidth(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUnitWidthDirty() : !pSDEField.isUnitWidthDirty()) {
            return null;
        }
        Integer n = pSDEField.getUnitWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UnitWidth_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNITWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateOVMode(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUpdateOVModeDirty() : !pSDEField.isUpdateOVModeDirty()) {
            return null;
        }
        String string = pSDEField.getUpdateOVMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateOVMode_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEOVMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUserCatDirty() : !pSDEField.isUserCatDirty()) {
            return null;
        }
        String string = pSDEField.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUserParamsDirty() : !pSDEField.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEField.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUserTagDirty() : !pSDEField.isUserTagDirty()) {
            return null;
        }
        String string = pSDEField.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUserTag2Dirty() : !pSDEField.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEField.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUserTag3Dirty() : !pSDEField.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEField.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isUserTag4Dirty() : !pSDEField.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEField.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isValidFlagDirty() : !pSDEField.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEField.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isValueFormatDirty() : !pSDEField.isValueFormatDirty()) {
            return null;
        }
        String string = pSDEField.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValuePSDEFId(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isValuePSDEFIdDirty() : !pSDEField.isValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEField.getValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFId_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValuePSDEFName(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isValuePSDEFNameDirty() : !pSDEField.isValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEField.getValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFName_Default((IEntity)pSDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewColLevel(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEField.isViewColLevelDirty() : !pSDEField.isViewColLevelDirty()) {
            return null;
        }
        Integer n = pSDEField.getViewColLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewColLevel_Default((IEntity)pSDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWCOLLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEField pSDEField, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEField, bl);
    }

    protected void onSyncIndexEntities(PSDEField pSDEField, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEField, bl);
    }

    public Object getDataContextValue(PSDEField pSDEField, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEField, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEField.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEField pSDEField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEFDTCol_PSDEF(pSDEField, arrayList, n);
        this.onExportRelatedModel_PSDEFUIMode_PSDEF(pSDEField, arrayList, n);
        super.onExportRelatedModel((IEntity)pSDEField, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEFDTCol_PSDEF(PSDEField pSDEField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEFDTColService pSDEFDTColService = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDTCol> arrayList2 = pSDEFDTColService.selectByPSDEF(pSDEField);
        for (PSDEFDTCol pSDEFDTCol : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEFDTCol, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEFDTColService.exportModel(pSDEFDTCol, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEFUIMode_PSDEF(PSDEField pSDEField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFUIMode> arrayList2 = pSDEFUIModeService.selectByPSDEF(pSDEField);
        for (PSDEFUIMode pSDEFUIMode : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEFUIMode, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEFUIModeService.exportModel(pSDEFUIMode, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEField pSDEField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_LNPSLanRes(pSDEField, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEField, arrayList, n);
    }

    protected void onExportMajorModel_LNPSLanRes(PSDEField pSDEField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEField.getLNPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEField.getLNPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUDITINFOFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuditInfoFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIZTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BizTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHECKRECURSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CheckRecursion_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COMPUTEEXP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ComputeExp_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMEXPORTSCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomExportScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBVALUEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBValueMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBVALUEMODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBValueMode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DUPCHECKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DupCheckMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DUPCHECKVALUES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DupCheckValues_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DUPCHKPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DupCheckPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DUPCHKPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DupCheckPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DVT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValueType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEAUDIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAudit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECOLPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableColPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEQS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableQS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLETEMPDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableTempData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEUSERINPUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableUserInput_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENAWRITEBACK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnaWriteBack_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPPSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpPSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPPSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpPSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMULAFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormulaFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMULAFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormulaFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPORTKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImportKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPORTORDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImportOrder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPORTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImportTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPPSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImpPSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPPSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImpPSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INDEXTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IndexType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JSFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSONFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JsonFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Length_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINSTRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinStrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MULTIFORMFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MultiFormField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2DUPCHKPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2DupChkPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2DUPCHKPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2DupChkPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3DUPCHKPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3DupChkPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3DUPCHKPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3DupChkPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NULLVALORDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NullValOrder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"O2MPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_O2MPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"O2MPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_O2MPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"O2OPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_O2OPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"O2OPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_O2OPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASTERESET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PasteReset_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHYSICALFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PhysicalField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreDefineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATATYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATATYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFDTCOLSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFDTColsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIELDSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFieldsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFINPUTTIPSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFInputTipsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFSFITEMSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFSFItemsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFUIMODESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVALUERULESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFValueRulesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBCOLUMNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBColumnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSAMPLEVALUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSampleValueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSAMPLEVALUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSampleValueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEQUENCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSequenceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEQUENCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSequenceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTCASESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestCasesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNITID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUnitId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNITNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUnitName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUERYCOLUMN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueryColumn_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUERYCS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueryCS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READONLYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadOnlyMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESTRICTEDPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RestrictedPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESTRICTEDPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RestrictedPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEQUENCEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SequenceMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StateField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STRINGCASE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StringCase_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABLESCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TableScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRANSLATORMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TranslatorMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNICODECHAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnicodeChar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNIONKEYVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnionKeyValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Unit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNITWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnitWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEOVMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateOVMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWCOLLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewColLevel_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AuditInfoFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUDITINFOFORMAT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BizTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIZTAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CheckRecursion_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ComputeExp_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COMPUTEEXP", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_CustomExportScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DBValueMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBVALUEMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBValueMode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBVALUEMODE2", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEFType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DERPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DERPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && (this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("DERPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PSDEFIELDID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6]", true))) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6])";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DERPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DERPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DupCheckMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DUPCHECKMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DupCheckValues_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DUPCHECKVALUES", iEntity, bl2, null, false, 400, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DupCheckPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DUPCHKPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && (this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("DUPCHKPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PSDEFIELDID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6]", true)) && (this.checkFieldSimpleRule("NO2DUPCHKPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("DUPCHKPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "NO2DUPCHKPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60272]", true)) && (this.checkFieldSimpleRule("NO3DUPCHKPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("DUPCHKPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "NO3DUPCHKPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60273]", true))) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 (\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60272] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60273]))";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DupCheckPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DUPCHKPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultValueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DVT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableAudit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableColPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableQS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableTempData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableUserInput_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnaWriteBack_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpPSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXPPSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExpPSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXPPSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FieldHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FieldTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FormulaFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMULAFIELDS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormulaFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMULAFORMAT", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImportKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ImportOrder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ImportTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPORTTAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImpPSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPPSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImpPSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPPSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IndexType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_JSFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JsonFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSONFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Length_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LNPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAXVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_MinStrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MinValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MultiFormField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No2DupChkPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2DUPCHKPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && (this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("NO2DUPCHKPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PSDEFIELDID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6]", true)) && (this.checkFieldSimpleRule("DUPCHKPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("NO2DUPCHKPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "DUPCHKPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u6027]", true)) && (this.checkFieldSimpleRule("NO3DUPCHKPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("NO2DUPCHKPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "NO3DUPCHKPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60273]", true))) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 (\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u6027] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60273]))";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2DupChkPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2DUPCHKPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3DupChkPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3DUPCHKPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && (this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("NO3DUPCHKPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PSDEFIELDID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6]", true)) && (this.checkFieldSimpleRule("DUPCHKPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("NO3DUPCHKPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "DUPCHKPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u6027]", true)) && (this.checkFieldSimpleRule("NO2DUPCHKPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("NO3DUPCHKPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "NO2DUPCHKPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60272]", true))) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 (\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u6027] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60272]))";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3DupChkPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3DUPCHKPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NullValOrder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NULLVALORDER", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_O2MPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("O2MPSDERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_O2MPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("O2MPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_O2OPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("O2OPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_O2OPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("O2OPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PasteReset_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PhysicalField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PredefinedTypeParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPEPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreDefineType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDataTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDATATYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDataTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDATATYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFDTColsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && (this.checkFieldSimpleRule("DUPCHKPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "DUPCHKPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u6027]", true)) && (this.checkFieldSimpleRule("NO2DUPCHKPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "NO2DUPCHKPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60272]", true)) && (this.checkFieldSimpleRule("NO3DUPCHKPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "NO3DUPCHKPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60273]", true)) && (this.checkFieldSimpleRule("DERPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "DERPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5173\u7cfb\u5c5e\u6027]", true)) && (this.checkFieldSimpleRule("VALUEPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "VALUEPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u503c\u9879\u5c5e\u6027]", true)) && (this.checkFieldSimpleRule("RESTRICTEDPSDEFID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "RESTRICTEDPSDEFID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u9650\u5236\u5c5e\u6027]", true))) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 (\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u6027] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60272] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8303\u56f4\u5c5e\u60273]) \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5173\u7cfb\u5c5e\u6027] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u503c\u9879\u5c5e\u6027] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u9650\u5236\u5c5e\u6027])";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIELDNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("PSDEFIELDNAME", iEntity, bl2, "[A-Z_$][A-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFieldsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFInputTipsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFSFItemsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFUIModesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFValueRulesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETABLEID", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PSSubSysSADEFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADEFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEFIELDNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBColumnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBCOLUMNID", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSampleValueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSAMPLEVALUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSampleValueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSAMPLEVALUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSequenceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEQUENCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSequenceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEQUENCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysTestCasesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUnitId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNITID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUnitName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNITNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QueryColumn_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_QueryCS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYCS", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReadOnlyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RefPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RestrictedPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESTRICTEDPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && (this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("RESTRICTEDPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PSDEFIELDID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6]", true))) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6])";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RestrictedPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESTRICTEDPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SequenceMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEQUENCEMODE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("SERVICECODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StateField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEFIELD", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StringCase_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STRINGCASE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABLENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TableScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABLESCOPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTDATA", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TranslatorMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRANSLATORMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UnicodeChar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UnionKeyValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNIONKEYVALUE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Unit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNIT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UnitWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UpdateOVMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEOVMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_ValueFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && (this.checkFieldSimpleRule("PSDEFIELDID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("VALUEPSDEFID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PSDEFIELDID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6]", true))) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u5b9e\u4f53\u5c5e\u6027\u6807\u8bc6])";
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

    protected String onTestValueRule_ViewColLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEField pSDEField) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", (boolean)true) == 0) && this.onMergeChild_PSDEFDTCols(pSDEField)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", (boolean)true) == 0) && this.onMergeChild_PSDEFUIModes(pSDEField)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID", (boolean)true) == 0) && this.onMergeChild_PSDEFields(pSDEField)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID", (boolean)true) == 0) && this.onMergeChild_PSDEFInputTips(pSDEField)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", (boolean)true) == 0) && this.onMergeChild_PSDEFSFItems(pSDEField)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVALUERULE_PSDEFIELD_PSDEFID", (boolean)true) == 0) && this.onMergeChild_PSDEFValueRules(pSDEField)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", (boolean)true) == 0) && this.onMergeChild_PSSysTestCases(pSDEField)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSDEField)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSDEFDTCols(PSDEField pSDEField) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEFDTCOLSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEField.getPSDEFieldId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEFID", (Object)pSDEField.getPSDEFieldId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEField, false);
        return true;
    }

    protected boolean onMergeChild_PSDEFUIModes(PSDEField pSDEField) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEFUIMODESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEField.getPSDEFieldId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEFID", (Object)pSDEField.getPSDEFieldId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEField, false);
        return true;
    }

    protected boolean onMergeChild_PSDEFields(PSDEField pSDEField) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEFIELDSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEField.getPSDEFieldId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
        selectContext.set("DERPSDEFID", (Object)pSDEField.getPSDEFieldId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEField, false);
        return true;
    }

    protected boolean onMergeChild_PSDEFInputTips(PSDEField pSDEField) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEFINPUTTIPSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEField.getPSDEFieldId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEFID", (Object)pSDEField.getPSDEFieldId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEField, false);
        return true;
    }

    protected boolean onMergeChild_PSDEFSFItems(PSDEField pSDEField) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEFSFITEMSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEField.getPSDEFieldId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEFID", (Object)pSDEField.getPSDEFieldId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEField, false);
        return true;
    }

    protected boolean onMergeChild_PSDEFValueRules(PSDEField pSDEField) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEFVALUERULESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEField.getPSDEFieldId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEFID", (Object)pSDEField.getPSDEFieldId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEField, false);
        return true;
    }

    protected boolean onMergeChild_PSSysTestCases(PSDEField pSDEField) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSTESTCASESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEField.getPSDEFieldId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEFID", (Object)pSDEField.getPSDEFieldId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEField, false);
        return true;
    }

    protected void onUpdateParent(PSDEField pSDEField) throws Exception {
        IService iService;
        Object object = pSDEField.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFIELD_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSDEField.get("DERPSDEFID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID", object);
        }
        if ((object = pSDEField.get("PSDERID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFIELD_PSDER_PSDERID", object);
        }
        super.onUpdateParent((IEntity)pSDEField);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEField pSDEField, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFIELD");
        if (!bl) {
            pSDEField.setCreateDate(null);
            pSDEField.setCreateMan(null);
            pSDEField.setFKey(null);
            pSDEField.setPhysicalField(null);
            pSDEField.setPSDEFDTColsCnt(null);
            pSDEField.setPSDEFieldId(null);
            pSDEField.setPSDEFieldsCnt(null);
            pSDEField.setPSDEFInputTipsCnt(null);
            pSDEField.setPSDEFSFItemsCnt(null);
            pSDEField.setPSDEFUIModesCnt(null);
            pSDEField.setPSDEFValueRulesCnt(null);
            pSDEField.setPSSysTestCasesCnt(null);
            pSDEField.setPSSysTranslatorName(null);
            pSDEField.setTableName(null);
            pSDEField.setUpdateDate(null);
            pSDEField.setUpdateMan(null);
            super.exportCurXmlModel(pSDEField, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEField pSDEField, PSSystem pSSystem) throws Exception {
        PSDEField pSDEField2 = new PSDEField();
        pSDEField2.setPSDEId(pSDEField.getPSDEId());
        pSDEField2.setPSDEFieldName(pSDEField.getPSDEFieldName());
        if (this.selectOne((IEntity)pSDEField2, true)) {
            return pSDEField2.getPSDEFieldId();
        }
        return super.getEntityFolderKeyValue(pSDEField, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEField pSDEField, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEField, string);
        objectNode.remove("psdefdtcolscnt");
        objectNode.remove("psdefieldscnt");
        objectNode.remove("psdefinputtipscnt");
        objectNode.remove("psdefsfitemscnt");
        objectNode.remove("psdefuimodescnt");
        objectNode.remove("psdefvaluerulescnt");
        objectNode.remove("pssystestcasescnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDER#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFIELD_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFIELD_PSDER_PSDERID";
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDER", (boolean)true) == 0) {
            iEntity.set("PSDERID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID", "PSDERID"};
    }

    @Override
    public String getModelV2Tag(PSDEField pSDEField) {
        if (!StringHelper.isNullOrEmpty((String)pSDEField.getPSDEFieldName())) {
            return pSDEField.getPSDEFieldName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEField.getPSDEFieldName())) {
            return pSDEField.getPSDEFieldName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEField.getCodeName())) {
            return pSDEField.getCodeName();
        }
        return super.getModelV2Tag(pSDEField);
    }

    @Override
    public boolean setModelV2Tag(PSDEField pSDEField, String string) {
        pSDEField.setPSDEFieldName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEFIELDNAME", "");
        map.put("PSDEFIELDNAME", "");
        map.put("CODENAME", "");
        map.put("BIZTAG", "");
        map.put("CODENAME", "");
        map.put("PREDEFINETYPE", "");
        map.put("PSDEFIELDNAME", "");
        map.put("SERVICECODENAME", "");
        map.put("STATEFIELD", "");
        map.put("UNIONKEYVALUE", "");
        map.put("PSDEID", "");
        map.put("PSDERID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEField pSDEField, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEField.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEField, true);
        pSDEField.set("PSDEFIELDNAME", string);
        if (this.select(pSDEField, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEField, true);
        return super.getModelV2Entity(pSDEField, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEField pSDEField, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEField, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEField pSDEField, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSTESTCASE", (Object)pSDEField.getPSDEFieldId()))).exists()) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysTestCase();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysTestCase)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSTESTCASE", (Object)entityBase.getPSSysTestCaseId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEFFORMITEM", (Object)pSDEField.getPSDEFieldId()))).exists()) {
            pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSDEFUIMode();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEFUIModeService)pSCoreSysServiceBase).getModelV2Tag((PSDEFUIMode)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEFFORMITEM", (Object)entityBase.getPSDEFUIModeId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEFINPUTTIP", (Object)pSDEField.getPSDEFieldId()))).exists()) {
            pSCoreSysServiceBase = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSDEFInputTip();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEFInputTipServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDEFInputTip)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEFINPUTTIP", (Object)entityBase.getPSDEFInputTipId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEFSFITEM", (Object)pSDEField.getPSDEFieldId()))).exists()) {
            pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSDEFSFItem();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDEFSFItem)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEFSFITEM", (Object)entityBase.getPSDEFSFItemId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEFDTCOL", (Object)pSDEField.getPSDEFieldId()))).exists()) {
            pSCoreSysServiceBase = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSDEFDTCol();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEFDTColServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDEFDTCol)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEFDTCOL", (Object)entityBase.getPSDEFDTColId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSDEField, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEField pSDEField, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSSysTestCase> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID")) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSTESTCASE", (Object)pSDEField.getPSDEFieldId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysTestCase)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysTestCase>();
                object4 = ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).selectByPSDEF(pSDEField);
                object3 = StringHelper.format((String)"PSDEFIELD#%1$s", (Object)pSDEField.getPSDEFieldId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysTestCase)object2.next();
                    object = ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysTestCase)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssystestcasename")) {
                            string = objectNode.get("pssystestcasename").asText();
                        }
                        if (objectNode2.has("pssystestcasename")) {
                            string2 = objectNode2.get("pssystestcasename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysTestCase();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID")) {
            pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFFORMITEM", (Object)pSDEField.getPSDEFieldId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysTestCase)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).selectByPSDEF(pSDEField);
                object3 = StringHelper.format((String)"PSDEFIELD#%1$s", (Object)pSDEField.getPSDEFieldId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFUIMode)object2.next();
                    object = ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysTestCase)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdefformitemname")) {
                            string = objectNode.get("psdefformitemname").asText();
                        }
                        if (objectNode2.has("psdefformitemname")) {
                            string2 = objectNode2.get("psdefformitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFUIMode();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID")) {
            pSCoreSysServiceBase = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFINPUTTIP", (Object)pSDEField.getPSDEFieldId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysTestCase)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFInputTipServiceBase)pSCoreSysServiceBase).selectByPSDEF(pSDEField);
                object3 = StringHelper.format((String)"PSDEFIELD#%1$s", (Object)pSDEField.getPSDEFieldId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFInputTip)object2.next();
                    object = ((PSDEFInputTipServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysTestCase)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdefinputtipname")) {
                            string = objectNode.get("psdefinputtipname").asText();
                        }
                        if (objectNode2.has("psdefinputtipname")) {
                            string2 = objectNode2.get("psdefinputtipname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFInputTip();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID")) {
            pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFSFITEM", (Object)pSDEField.getPSDEFieldId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysTestCase)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).selectByPSDEF(pSDEField);
                object3 = StringHelper.format((String)"PSDEFIELD#%1$s", (Object)pSDEField.getPSDEFieldId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFSFItem)object2.next();
                    object = ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysTestCase)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdefsfitemname")) {
                            string = objectNode.get("psdefsfitemname").asText();
                        }
                        if (objectNode2.has("psdefsfitemname")) {
                            string2 = objectNode2.get("psdefsfitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFSFItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID")) {
            pSCoreSysServiceBase = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIELD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFDTCOL", (Object)pSDEField.getPSDEFieldId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysTestCase)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFDTColServiceBase)pSCoreSysServiceBase).selectByPSDEF(pSDEField);
                object3 = StringHelper.format((String)"PSDEFIELD#%1$s", (Object)pSDEField.getPSDEFieldId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFDTCol)object2.next();
                    object = ((PSDEFDTColServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysTestCase)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdefdtcolname")) {
                            string = objectNode.get("psdefdtcolname").asText();
                        }
                        if (objectNode2.has("psdefdtcolname")) {
                            string2 = objectNode2.get("psdefdtcolname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFDTCol();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEField, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEField pSDEField) throws Exception {
        super.onEmptyModelV2(pSDEField);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEField pSDEField, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysTestCase();
        entityBase.set("PSDEFID", pSDEField.getPSDEFieldId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFUIMode();
        entityBase.set("PSDEFID", pSDEField.getPSDEFieldId());
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFInputTip();
        entityBase.set("PSDEFID", pSDEField.getPSDEFieldId());
        pSCoreSysServiceBase = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFSFItem();
        entityBase.set("PSDEFID", pSDEField.getPSDEFieldId());
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFDTCol();
        entityBase.set("PSDEFID", pSDEField.getPSDEFieldId());
        pSCoreSysServiceBase = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEField, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEField pSDEField, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSDEFieldServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysTestCase();
                    ((PSSysTestCaseBase)object).setPSDEFId(pSDEField.getPSDEFieldId());
                    ((PSSysTestCaseBase)object).setPSDEFName(pSDEField.getPSDEFieldName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysTestCase();
                        entityBase.setPSDEFId(pSDEField.getPSDEFieldId());
                        entityBase.setPSDEFName(pSDEField.getPSDEFieldName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDEFieldServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null && (arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase())) == null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)"psdefuimodes");
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSDEFUIMode();
                    ((PSDEFUIModeBase)object).setPSDEFId(pSDEField.getPSDEFieldId());
                    ((PSDEFUIModeBase)object).setPSDEFName(pSDEField.getPSDEFieldName());
                    ((PSDEFUIModeBase)object).setPSDEId(pSDEField.getPSDEId());
                    ((PSDEFUIModeBase)object).setPSDEName(pSDEField.getPSDEName());
                    ((PSDEFUIModeBase)object).setPSSystemId(pSDEField.getPSSystemId());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (!((File)object2).exists()) {
                    string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)"PSDEFUIMODES");
                    object2 = new File(string5);
                }
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEFUIMode();
                        entityBase.setPSDEFId(pSDEField.getPSDEFieldId());
                        entityBase.setPSDEFName(pSDEField.getPSDEFieldName());
                        entityBase.setPSDEId(pSDEField.getPSDEId());
                        entityBase.setPSDEName(pSDEField.getPSDEName());
                        entityBase.setPSSystemId(pSDEField.getPSSystemId());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDEFieldServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSDEFInputTip();
                    ((PSDEFInputTipBase)object).setPSDEFId(pSDEField.getPSDEFieldId());
                    ((PSDEFInputTipBase)object).setPSDEFName(pSDEField.getPSDEFieldName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEFInputTip();
                        entityBase.setPSDEFId(pSDEField.getPSDEFieldId());
                        entityBase.setPSDEFName(pSDEField.getPSDEFieldName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDEFieldServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSDEFSFItem();
                    ((PSDEFSFItemBase)object).setLogicName(pSDEField.getLogicName());
                    ((PSDEFSFItemBase)object).setO2MPSDERId(pSDEField.getO2MPSDERId());
                    ((PSDEFSFItemBase)object).setO2OPSDERId(pSDEField.getO2OPSDERId());
                    ((PSDEFSFItemBase)object).setPSDEFId(pSDEField.getPSDEFieldId());
                    ((PSDEFSFItemBase)object).setPSDEFName(pSDEField.getPSDEFieldName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string7);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEFSFItem();
                        entityBase.setLogicName(pSDEField.getLogicName());
                        entityBase.setO2MPSDERId(pSDEField.getO2MPSDERId());
                        entityBase.setO2OPSDERId(pSDEField.getO2OPSDERId());
                        entityBase.setPSDEFId(pSDEField.getPSDEFieldId());
                        entityBase.setPSDEFName(pSDEField.getPSDEFieldName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDEFieldServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSDEFDTCol();
                    ((PSDEFDTColBase)object).setPSDEFId(pSDEField.getPSDEFieldId());
                    ((PSDEFDTColBase)object).setPSDEFName(pSDEField.getPSDEFieldName());
                    ((PSDEFDTColBase)object).setPSDEId(pSDEField.getPSDEId());
                    ((PSDEFDTColBase)object).setPSDEName(pSDEField.getPSDEName());
                    ((PSDEFDTColBase)object).setTableName(pSDEField.getTableName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string8 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string8);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEFDTCol();
                        entityBase.setPSDEFId(pSDEField.getPSDEFieldId());
                        entityBase.setPSDEFName(pSDEField.getPSDEFieldName());
                        entityBase.setPSDEId(pSDEField.getPSDEId());
                        entityBase.setPSDEName(pSDEField.getPSDEName());
                        entityBase.setTableName(pSDEField.getTableName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEField, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEField pSDEField, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysTestCases(pSDEField, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFUIModes(pSDEField, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFInputTips(pSDEField, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFSFItems(pSDEField, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFDTCols(pSDEField, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEField, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysTestCases(PSDEField pSDEField, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSTESTCASE", true), (boolean)false) == 0) {
            PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            PSSysTestCase pSSysTestCase = new PSSysTestCase();
            pSSysTestCase.setPSSysTestCaseId(pSMOSFile.getPSModelId());
            if (!pSSysTestCaseService.get((IEntity)pSSysTestCase, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysTestCase.getPSDEFId(), (String)pSDEField.getPSDEFieldId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysTestCaseService.exportModelV2(pSSysTestCase);
            pSSysTestCase.reset();
            if (!pSSysTestCaseService.setModelV2ResScope((IEntity)pSSysTestCase, "PSDEFIELD", pSDEField.getPSDEFieldId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysTestCaseService.importModelV2(pSSysTestCase, objectNode);
            SessionFactoryManager.commit();
            return pSSysTestCaseService.getFile((IEntity)pSSysTestCase);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEFUIModes(PSDEField pSDEField, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFFORMITEM", true), (boolean)false) == 0) {
            PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
            PSDEFUIMode pSDEFUIMode = new PSDEFUIMode();
            pSDEFUIMode.setPSDEFUIModeId(pSMOSFile.getPSModelId());
            if (!pSDEFUIModeService.get((IEntity)pSDEFUIMode, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFUIMode.getPSDEFId(), (String)pSDEField.getPSDEFieldId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFUIModeService.exportModelV2(pSDEFUIMode);
            pSDEFUIMode.reset();
            if (!pSDEFUIModeService.setModelV2ResScope((IEntity)pSDEFUIMode, "PSDEFIELD", pSDEField.getPSDEFieldId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFUIModeService.importModelV2(pSDEFUIMode, objectNode);
            SessionFactoryManager.commit();
            return pSDEFUIModeService.getFile((IEntity)pSDEFUIMode);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEFInputTips(PSDEField pSDEField, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFINPUTTIP", true), (boolean)false) == 0) {
            PSDEFInputTipService pSDEFInputTipService = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
            PSDEFInputTip pSDEFInputTip = new PSDEFInputTip();
            pSDEFInputTip.setPSDEFInputTipId(pSMOSFile.getPSModelId());
            if (!pSDEFInputTipService.get((IEntity)pSDEFInputTip, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFInputTip.getPSDEFId(), (String)pSDEField.getPSDEFieldId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFInputTipService.exportModelV2(pSDEFInputTip);
            pSDEFInputTip.reset();
            if (!pSDEFInputTipService.setModelV2ResScope((IEntity)pSDEFInputTip, "PSDEFIELD", pSDEField.getPSDEFieldId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFInputTipService.importModelV2(pSDEFInputTip, objectNode);
            SessionFactoryManager.commit();
            return pSDEFInputTipService.getFile((IEntity)pSDEFInputTip);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEFSFItems(PSDEField pSDEField, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFSFITEM", true), (boolean)false) == 0) {
            PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
            PSDEFSFItem pSDEFSFItem = new PSDEFSFItem();
            pSDEFSFItem.setPSDEFSFItemId(pSMOSFile.getPSModelId());
            if (!pSDEFSFItemService.get((IEntity)pSDEFSFItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFSFItem.getPSDEFId(), (String)pSDEField.getPSDEFieldId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFSFItemService.exportModelV2(pSDEFSFItem);
            pSDEFSFItem.reset();
            if (!pSDEFSFItemService.setModelV2ResScope((IEntity)pSDEFSFItem, "PSDEFIELD", pSDEField.getPSDEFieldId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFSFItemService.importModelV2(pSDEFSFItem, objectNode);
            SessionFactoryManager.commit();
            return pSDEFSFItemService.getFile((IEntity)pSDEFSFItem);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEFDTCols(PSDEField pSDEField, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFDTCOL", true), (boolean)false) == 0) {
            PSDEFDTColService pSDEFDTColService = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
            PSDEFDTCol pSDEFDTCol = new PSDEFDTCol();
            pSDEFDTCol.setPSDEFDTColId(pSMOSFile.getPSModelId());
            if (!pSDEFDTColService.get((IEntity)pSDEFDTCol, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFDTCol.getPSDEFId(), (String)pSDEField.getPSDEFieldId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFDTColService.exportModelV2(pSDEFDTCol);
            pSDEFDTCol.reset();
            if (!pSDEFDTColService.setModelV2ResScope((IEntity)pSDEFDTCol, "PSDEFIELD", pSDEField.getPSDEFieldId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFDTColService.importModelV2(pSDEFDTCol, objectNode);
            SessionFactoryManager.commit();
            return pSDEFDTColService.getFile((IEntity)pSDEFDTCol);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEField pSDEField, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysTestCases(pSDEField, list);
        this.onFillPasteHelps_PSDEFUIModes(pSDEField, list);
        this.onFillPasteHelps_PSDEFInputTips(pSDEField, list);
        this.onFillPasteHelps_PSDEFSFItems(pSDEField, list);
        this.onFillPasteHelps_PSDEFDTCols(pSDEField, list);
        super.onFillPasteHelps(pSDEField, list);
    }

    protected void onFillPasteHelps_PSSysTestCases(PSDEField pSDEField, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSTESTCASE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5c5e\u6027]\u7684[\u7cfb\u7edf\u6d4b\u8bd5\u7528\u4f8b]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEFUIModes(PSDEField pSDEField, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFFORMITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5c5e\u6027]\u7684[\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEFInputTips(PSDEField pSDEField, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFINPUTTIP");
        pSHelpSection.setSectionParam2("DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5c5e\u6027]\u7684[\u5b9e\u4f53\u5c5e\u6027\u8f93\u5165\u63d0\u793a]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEFSFItems(PSDEField pSDEField, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFSFITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5c5e\u6027]\u7684[\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEFDTCols(PSDEField pSDEField, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFDTCOL");
        pSHelpSection.setSectionParam2("DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5c5e\u6027]\u7684[\u5c5e\u6027\u6570\u636e\u5e93\u5217\u914d\u7f6e]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u5e93>", "DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u5e93>");
            } else if (PSDEFieldServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdefdtcols");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID|PSDEFID");
            pSMOSFile2.setFileTag3("PSDEFDTCOL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u503c\u89c4\u5219>", "DER1N_PSDEFVALUERULE_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u503c\u89c4\u5219>");
            } else if (PSDEFieldServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdefvaluerules");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEFVALUERULE_PSDEFIELD_PSDEFID|PSDEFID");
            pSMOSFile2.setFileTag3("PSDEFVALUERULE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEFVALUERULE_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFVALUERULE_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u641c\u7d22\u6a21\u5f0f>", "DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u641c\u7d22\u6a21\u5f0f>");
            } else if (PSDEFieldServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdefsfitems");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID|PSDEFID");
            pSMOSFile2.setFileTag3("PSDEFSFITEM");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u754c\u9762\u6a21\u5f0f>", "DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u754c\u9762\u6a21\u5f0f>");
            } else if (PSDEFieldServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdefuimodes");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID|PSDEFID");
            pSMOSFile2.setFileTag3("PSDEFFORMITEM");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5168\u6587\u68c0\u7d22>", "DER1N_PSSYSSEARCHDEFIELD_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5168\u6587\u68c0\u7d22>");
            } else if (PSDEFieldServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyssearchdefields");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSSEARCHDEFIELD_PSDEFIELD_PSDEFID|PSDEFID");
            pSMOSFile2.setFileTag3("PSSYSSEARCHDEFIELD");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSSEARCHDEFIELD_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHDEFIELD_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f15\u7528]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u8f93\u5165\u63d0\u793a>", "DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u8f93\u5165\u63d0\u793a>");
            } else if (PSDEFieldServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdefinputtips");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID|PSDEFID");
            pSMOSFile2.setFileTag3("PSDEFINPUTTIP");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u503c\u89c4\u5219\u6d4b\u8bd5\u7528\u4f8b>", "DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u503c\u89c4\u5219\u6d4b\u8bd5\u7528\u4f8b>");
            } else if (PSDEFieldServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssystestcases");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID|PSDEFID");
            pSMOSFile2.setFileTag3("PSSYSTESTCASE");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u5e2e\u52a9\u7ae0\u8282>", "DER1N_PSHELPSECTION_PSDEFIELD_PSDEFIELDID", "PSDEFIELDID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e2e\u52a9\u7ae0\u8282>");
            } else if (PSDEFieldServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pshelpsections");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSHELPSECTION_PSDEFIELD_PSDEFIELDID|PSDEFIELDID");
            pSMOSFile2.setFileTag3("PSHELPSECTION");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSHELPSECTION_PSDEFIELD_PSDEFIELDID", "PSDEFIELDID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSHELPSECTION_PSDEFIELD_PSDEFIELDID", "PSDEFIELDID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f15\u7528]", "<\u5173\u7cfb\u5c5e\u6027>", "DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID", "DERPSDEFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5173\u7cfb\u5c5e\u6027>");
            } else if (PSDEFieldServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdefields");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID|DERPSDEFID");
            pSMOSFile2.setFileTag3("PSDEFIELD");
            pSMOSFile2.setFileTag4("[\u5f15\u7528]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID", "DERPSDEFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID", "DERPSDEFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSDEFieldServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u5e93>", (boolean)false) == 0 || PSDEFieldServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEFDTCols", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u503c\u89c4\u5219>", (boolean)false) == 0 || PSDEFieldServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEFValueRules", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFVALUERULE_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u641c\u7d22\u6a21\u5f0f>", (boolean)false) == 0 || PSDEFieldServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEFSFItems", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u754c\u9762\u6a21\u5f0f>", (boolean)false) == 0 || PSDEFieldServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEFUIModes", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u8f93\u5165\u63d0\u793a>", (boolean)false) == 0 || PSDEFieldServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEFInputTips", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5168\u6587\u68c0\u7d22>", (boolean)false) == 0 || PSDEFieldServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"pssyssearchdefields", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHDEFIELD_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u503c\u89c4\u5219\u6d4b\u8bd5\u7528\u4f8b>", (boolean)false) == 0 || PSDEFieldServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysTestCases", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", "PSDEFID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u5e2e\u52a9\u7ae0\u8282>", (boolean)false) == 0 || PSDEFieldServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"pshelpsections", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSHELPSECTION_PSDEFIELD_PSDEFIELDID", "PSDEFIELDID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEFieldServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f15\u7528]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u5173\u7cfb\u5c5e\u6027>", (boolean)false) == 0 || PSDEFieldServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEFields", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID", "DERPSDEFID", pSMOSFile.getPSModelId(), "", "");
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", (boolean)false) == 0) {
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u5e93>";
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2) {
                return "psdefdtcols";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFVALUERULE_PSDEFIELD_PSDEFID", (boolean)false) == 0) {
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                return "<\u503c\u89c4\u5219>";
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2) {
                return "psdefvaluerules";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", (boolean)false) == 0) {
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                return "<\u641c\u7d22\u6a21\u5f0f>";
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2) {
                return "psdefsfitems";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", (boolean)false) == 0) {
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                return "<\u754c\u9762\u6a21\u5f0f>";
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2) {
                return "psdefuimodes";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFINPUTTIP_PSDEFIELD_PSDEFID", (boolean)false) == 0) {
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u8f93\u5165\u63d0\u793a>";
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2) {
                return "psdefinputtips";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHDEFIELD_PSDEFIELD_PSDEFID", (boolean)false) == 0) {
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                return "<\u5168\u6587\u68c0\u7d22>";
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2) {
                return "pssyssearchdefields";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", (boolean)false) == 0) {
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u503c\u89c4\u5219\u6d4b\u8bd5\u7528\u4f8b>";
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2) {
                return "pssystestcases";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSHELPSECTION_PSDEFIELD_PSDEFIELDID", (boolean)false) == 0) {
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u5e2e\u52a9\u7ae0\u8282>";
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2) {
                return "pshelpsections";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFIELD_PSDEFIELD_DERPSDEFID", (boolean)false) == 0) {
            if (PSDEFieldServiceBase.getMOSVer() == 1) {
                return "[\u5f15\u7528]/<\u5173\u7cfb\u5c5e\u6027>";
            }
            if (PSDEFieldServiceBase.getMOSVer() == 2) {
                return "psdefields";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEField pSDEField, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("LOGICNAME", "\u5c5e\u6027");
    }
}

