package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.IPSModelData;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelDataImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerGlobalModel;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFGroupGlobalModel;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.AC.PSDEACModeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTO;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionRuntime;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionGroupGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionInputDTOImpl;
import SA.SRFDA.PS.Core.DataEntity.BA.IPSDEBDTable;
import SA.SRFDA.PS.Core.DataEntity.BA.PSDEBDTableGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER11;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERInherit;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERMultiInherit;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.DER.MajorPSDERGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DER.MinorPSDERGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERGroupGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERNNImpl;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.DataEntity.DR.PSDEDRGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DR.PSDEDRGroupGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DR.PSDEDRItemGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInputDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataSetGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEFilterDTOImpl;
import SA.SRFDA.PS.Core.DataEntity.DTS.IPSDEDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.DTS.PSDEDTSQueueGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataExport.PSDEDataExportGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.PSDEDataImportGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.DataSync.PSDEDataSyncGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.JIT.IPSDESampleData;
import SA.SRFDA.PS.Core.DataEntity.JIT.PSDESampleDataGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEViewLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEMSLogicGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEViewLogicGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateAction;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateRS;
import SA.SRFDA.PS.Core.DataEntity.MainState.PSDEMainStateDenyActionLogicImpl;
import SA.SRFDA.PS.Core.DataEntity.MainState.PSDEMainStateGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.MainState.PSDEMainStateRSGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.DataEntity.Notify.PSDENotifyGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.DataEntity.Print.PSDEPrintGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPrivRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.PSDEOPPrivGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Priv.PSDEOPPrivRoleGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Priv.PSDEUserRoleGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.DataEntity.Report.PSDEReportGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Search.IPSDESearch;
import SA.SRFDA.PS.Core.DataEntity.Search.PSDESearchGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEActionMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEDataSetMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSLinkDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEActionMethodImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEDataSetMethodImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodDTOImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Service.PSLinkDEMethodDTOImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionGroupGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.UniState.IPSDEUniState;
import SA.SRFDA.PS.Core.DataEntity.UniState.PSDEUniStateGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Util.IPSDEUtil;
import SA.SRFDA.PS.Core.DataEntity.Util.PSDEUtilGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.DataEntity.WF.PSDEWFGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEActionWizardGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEActionWizardGroupGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEWizardGlobalModel;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProc;
import SA.SRFDA.PS.Core.Database.IPSDEDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBSchemeRuntime;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Database.PSDEDBConfigGlobalModel;
import SA.SRFDA.PS.Core.Database.PSDEDBIndexGlobalModel;
import SA.SRFDA.PS.Core.Database.PSDEDBSysProcGlobalModel;
import SA.SRFDA.PS.Core.Database.PSDEDBTableGlobalModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFCodeObjectHelper;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.PS.Data.PSDEFInputTip;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEPrint;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSModelObj;
import SA.SRFDA.PS.Data.PSSysSearchDEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEAction;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IDEActionWizardGroup;
import net.ibizsys.paas.core.IDEBATable;
import net.ibizsys.paas.core.IDEDBConfig;
import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSync;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDELogic;
import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IDEOPPrivRole;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.core.IDEUniState;
import net.ibizsys.paas.core.IDEUserRole;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDataEntityImpl extends PSSystemObjectImpl implements IPSDataEntity, IPSDataEntityRuntime, IPSModelSortable {
   private static final Log log = LogFactory.getLog(PSDataEntityImpl.class);
   private static final Map<String, String> MSCtrlActionModeMap = new HashMap<>();
   private static final Map<String, String> DynaInstWFEditViewMap = new HashMap<>();
   public static final String CODETYPE_SUBSYS = "SUBSYS_";
   public static final String MODELGROUP_MODEL = "模型";
   public static final String MODELGROUP_FIELD = "属性高级";
   public static final String MODELGROUP_PERSISTENT = "持久化";
   public static final String MODELGROUP_DER = "关系高级";
   public static final String MODELGROUP_LOGIC = "处理逻辑";
   public static final String MODELGROUP_MAINSTATE = "状态控制";
   public static final String MODELGROUP_DB = "数据库存储";
   public static final String MODELGROUP_UTIL = "功能配置";
   public static final String MODELGROUP_REPORT = "打印及报表";
   public static final String MODELGROUP_ACCCTRL = "访问控制";
   public static final String MODELGROUP_TEST = "测试";
   public static final String MODELGROUP_ADVMODEL = "模型高级";
   public static final String[] MODELGROUPS = new String[]{
      "基本", "模型", "属性高级", "持久化", "关系高级", "处理逻辑", "状态控制", "数据库存储", "功能配置", "打印及报表", "访问控制", "测试", "模型高级", "用户扩展", "其它"
   };
   public static final int MODELORDER_MODEL = 150;
   public static final int MODELORDER_FIELD = 180;
   public static final int MODELORDER_DER = 210;
   public static final int MODELORDER_PERSISTENT = 240;
   public static final int MODELORDER_LOGIC = 270;
   public static final int MODELORDER_MAINSTATE = 320;
   public static final int MODELORDER_DB = 370;
   public static final int MODELORDER_UTIL = 400;
   public static final int MODELORDER_REPORT = 450;
   public static final int MODELORDER_ACCCTRL = 500;
   public static final int MODELORDER_TEST = 530;
   public static final int MODELORDER_ADVMODEL = 560;
   private ArrayList<IPSDEField> defHelpers;
   private ArrayList<IDEField> deFieldList;
   private Hashtable<String, IPSDEField> defHelperMap;
   private Hashtable<String, String> preDefineFields = null;
   private PSDataEntity psDataEntity = null;
   private IPSDEField keyDEField = null;
   private IPSDEField uniTagDEField = null;
   private IPSDEField majorDEField = null;
   private IPSDEField keyNameDEField = null;
   private IPSDEField indexTypeDEField = null;
   private IPSDEField formTypeDEField = null;
   private PSDEDBConfigGlobalModel psDEDBConfigGlobalModel = new PSDEDBConfigGlobalModel();
   private PSDEUIActionGlobalModel psDEUIActionGlobalModel = new PSDEUIActionGlobalModel();
   private PSDEUIActionGroupGlobalModel psDEUIActionGroupGlobalModel = new PSDEUIActionGroupGlobalModel();
   private MajorPSDERGlobalModel majorPSDERGlobalModel = new MajorPSDERGlobalModel();
   private MinorPSDERGlobalModel minorPSDERGlobalModel = new MinorPSDERGlobalModel();
   private PSDEDataQueryGlobalModel psDEDataQueryGlobalModel = new PSDEDataQueryGlobalModel();
   private PSDEDataSetGlobalModel psDEDataSetGlobalModel = new PSDEDataSetGlobalModel();
   private PSAjaxControlHandlerGlobalModel psAjaxControlHandlerGlobalModel = new PSAjaxControlHandlerGlobalModel();
   private PSDEDBSysProcGlobalModel psDEDBSysProcGlobalModel = new PSDEDBSysProcGlobalModel();
   private PSDEActionGlobalModel psDEActionGlobalModel = new PSDEActionGlobalModel();
   private PSDELogicGlobalModel psDELogicGlobalModel = new PSDELogicGlobalModel();
   private PSDEDataFlowGlobalModel psDEDataFlowGlobalModel = new PSDEDataFlowGlobalModel();
   private PSDEViewLogicGlobalModel psDEViewLogicGlobalModel = new PSDEViewLogicGlobalModel();
   private PSDEACModeGlobalModel psDEACModeGlobalModel = new PSDEACModeGlobalModel();
   private PSDEDRGlobalModel psDEDataRelationGlobalModel = new PSDEDRGlobalModel();
   private PSDEDRGroupGlobalModel psDEDRGroupGlobalModel = new PSDEDRGroupGlobalModel();
   private PSDEDRItemGlobalModel psDEDRItemGlobalModel = new PSDEDRItemGlobalModel();
   private PSDEMapGlobalModel psDEMapGlobalModel = new PSDEMapGlobalModel();
   private PSDEWFGlobalModel psDEWFGlobalModel = new PSDEWFGlobalModel();
   private PSDEMainStateGlobalModel psDEMainStateGlobalModel = new PSDEMainStateGlobalModel();
   private PSDEMainStateRSGlobalModel psDEMainStateRSGlobalModel = new PSDEMainStateRSGlobalModel();
   private PSDEDBIndexGlobalModel psDEDBIndexGlobalModel = new PSDEDBIndexGlobalModel();
   private PSDEReportGlobalModel psDEReportGlobalModel = new PSDEReportGlobalModel();
   private PSDEPrintGlobalModel psDEPrintGlobalModel = new PSDEPrintGlobalModel();
   private PSDEWizardGlobalModel psDEWizardGlobalModel = new PSDEWizardGlobalModel();
   private PSDEDataSyncGlobalModel psDEDataSyncGlobalModel = new PSDEDataSyncGlobalModel();
   private PSDEBDTableGlobalModel psDEBDTableGlobalModel = new PSDEBDTableGlobalModel();
   private PSDEDataExportGlobalModel psDEDataExportGlobalModel = new PSDEDataExportGlobalModel();
   private PSDEDataImportGlobalModel psDEDataImportGlobalModel = new PSDEDataImportGlobalModel();
   private PSDEActionWizardGlobalModel psDEActionWizardGlobalModel = new PSDEActionWizardGlobalModel();
   private PSDEActionWizardGroupGlobalModel psDEActionWizardGroupGlobalModel = new PSDEActionWizardGroupGlobalModel();
   private PSDEUniStateGlobalModel psDEUniStateGlobalModel = new PSDEUniStateGlobalModel();
   private PSDEServiceAPIGlobalModel psDEServiceAPIGlobalModel = new PSDEServiceAPIGlobalModel();
   private PSDEDTSQueueGlobalModel psDEDTSQueueGlobalModel = new PSDEDTSQueueGlobalModel();
   private PSDEOPPrivRoleGlobalModel psDEOPPrivRoleGlobalModel = new PSDEOPPrivRoleGlobalModel();
   private PSDEUserRoleGlobalModel psDEUserRoleGlobalModel = new PSDEUserRoleGlobalModel();
   private PSDEUtilGlobalModel psDEUtilGlobalModel = new PSDEUtilGlobalModel();
   private PSDESampleDataGlobalModel psDESampleDataGlobalModel = new PSDESampleDataGlobalModel();
   private PSDEFGroupGlobalModel psDEFGroupGlobalModel = new PSDEFGroupGlobalModel();
   private PSDEGroupGlobalModel psDEGroupGlobalModel = new PSDEGroupGlobalModel();
   private PSDERGroupGlobalModel psDERGroupGlobalModel = new PSDERGroupGlobalModel();
   private PSDEActionGroupGlobalModel psDEActionGroupGlobalModel = new PSDEActionGroupGlobalModel();
   private PSDEDBTableGlobalModel psDEDBTableGlobalModel = new PSDEDBTableGlobalModel();
   private PSDEOPPrivGlobalModel psDEOPPrivGlobalModel = new PSDEOPPrivGlobalModel();
   private PSDESearchGlobalModel psDESearchGlobalModel = new PSDESearchGlobalModel();
   private PSDENotifyGlobalModel psDENotifyGlobalModel = new PSDENotifyGlobalModel();
   private PSDEMSLogicGlobalModel psDEMSLogicGlobalModel = new PSDEMSLogicGlobalModel();
   private IPSSystemModule iPSSystemModule = null;
   private String strCodeName = "";
   private String strIndexDEType = "";
   private boolean bEnableMultiForm = false;
   private String strDSLink = "DEFAULT";
   private boolean bDSLinkDefined = false;
   private String strDBTableSpaceId = "";
   private boolean bEnableMultiDS = false;
   private boolean bEnableOrgModel = false;
   private boolean bExistingModel = false;
   private String strXmlTagName = null;
   private String strPSSubSysServiceAPIId = "";
   private ArrayList<IPSDEField> unionKeyValueFieldList = new ArrayList<>();
   private ArrayList<IPSDEField> mainStateFieldList = new ArrayList<>();
   private ArrayList<IPSDataEntity> masterPSDataEntityList = new ArrayList<>();
   private TreeMap<String, PSDEViewBase> predefineDEViewMap = new TreeMap<>();
   private ArrayList<PSDEViewBase> psDEViewBaseList = new ArrayList<>();
   private ArrayList<PSDEForm> psDEEditFormList = new ArrayList<>();
   private IPSDERNN iPSDERNN = null;
   private boolean bInit = false;
   private Properties classOrPkgNameMap = null;
   private boolean bSubSysDE = false;
   private Map<String, IPSDEFValueRule> psDEFValueRuleMap = null;
   private ArrayList<IPSDEFValueRule> psDEFValueRuleList = null;
   private IPSDEWF defaultPSDEWF = null;
   private int nDataAccCtrlMode = 1;
   private int nAuditMode = 0;
   private IPSSysImage iPSSysImage = null;
   private int nDynamicMode = 0;
   private PSDEACMode defaultPSDEACModeData = null;
   private PSDEPrint defaultPSDEPrintData = null;
   private boolean bDefaultDEActionTestUnit = true;
   private int nDataChangeLogMode = 0;
   private boolean bVirtual = false;
   private int nVirtualMode = 0;
   private boolean bNoViewMode = false;
   private int nStorageMode = 1;
   private String strLogicValidValue = "";
   private String strLogicInvalidValue = "";
   private boolean bLogicValid = false;
   private String strLNLanResTag = "";
   private IPSLanguageRes lnPSLanguageRes = null;
   private String strPSHelpModuleId = "";
   private boolean bSortByName = true;
   private boolean bSortByCreateDate = true;
   private boolean bSortByName_PDT = true;
   private boolean bSortByCreateDate_PDT = true;
   private boolean bSortPDT = false;
   private int nEnableViewLevel = 0;
   private boolean bEnableEntityCache = false;
   private int nEntityCacheTimeout = -1;
   private int nMaxEntityCacheCount = -1;
   private int nDataImpExpMode = 3;
   private int nModelImpExpMode = 3;
   private int nServiceAPIMode = 0;
   private String strServiceCodeName = null;
   private boolean bEnableSADEAction = true;
   private boolean bEnableSASelect = true;
   private boolean bEnableSADEDataSet = true;
   private int nEnableUIActions = 0;
   private int nEnableActions = 0;
   private int nDataAccCtrlArch = 1;
   private int nTempDataHolder = 0;
   private int nMSActionLogicMode = 0;
   public static final String[] SDPDTVIEWS = new String[]{"EDITVIEW", "WFEDITVIEW"};
   public static final String[] MOBSDPDTVIEWS = new String[]{"MOBEDITVIEW", "MOBWFEDITVIEW"};
   private IPSSysSFPub iPSSysSFPub = null;
   private boolean bEnableDynaSys = false;
   private int nSaaSMode = IPSDataEntity.SAASMODE_NOTSUPPORTED;
   private ArrayList<IPSAppDataEntity> psAppDataEntityList = null;
   private ArrayList<IPSAppView> psAppViewList = null;
   private static final String SRFBIZTAG = "SRFBIZTAG";
   private boolean bEnableDataVer = false;
   private IPSSysDBScheme iPSSysDBScheme = null;
   private IPSSubSysServiceAPI iPSSubSysServiceAPI = null;
   private IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = null;
   private boolean bEnableMultiStorage = false;
   private boolean bSubSysAsCloud = false;
   private ArrayList<IPSDEField> quickSearchPSDEFieldList;
   private ArrayList<IPSCodeList> psCodeListList;
   private ArrayList<IPSDEMethod> psDEMethodList;
   private int nOrderValue = 99999;
   private int nDynaInstMode = 0;
   private Map<String, IPSDEMethodDTO> psDEMethodDTOMap = new TreeMap<>();
   private IPSSysSFPlugin iPSSysSFPlugin = null;
   private IPSSFXCodeObject iPSSFXCodeObject = null;
   private Map<String, IPSModelData> psModelDataMap = new LinkedHashMap<>();
   private int nDEHolder = 3;
   private int nDEDynaSysMode = 0;
   private IPSSysUniRes iPSSysUniRes = null;

   static {
      MSCtrlActionModeMap.put("UPDATE", "");
      MSCtrlActionModeMap.put("UPDATE2", "");
      MSCtrlActionModeMap.put("DELETE", "");
      MSCtrlActionModeMap.put("CUSTOM", "");
      MSCtrlActionModeMap.put("CUSTOM2", "");
      DynaInstWFEditViewMap.put("DEMOBWFDYNAEDITVIEW", "");
      DynaInstWFEditViewMap.put("DEMOBWFDYNAEDITVIEW3", "");
      DynaInstWFEditViewMap.put("DEWFDYNAEDITVIEW", "");
      DynaInstWFEditViewMap.put("DEWFDYNAEDITVIEW3", "");
   }

   @Override
   public void setInitParam(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSDataEntity psDataEntity) {
      this.setDAGlobalHelper(iDAGlobalHelper);
      this.setPSSystem(iPSSystem);
      this.psDataEntity = psDataEntity;
      this.setId(this.psDataEntity.getPSDATAENTITYID());
      this.setName(this.psDataEntity.getPSDATAENTITYNAME().toUpperCase());
      this.setVersion(this.psDataEntity.getMODELVER());
      this.setPSObjectData(this.psDataEntity);
      this.strCodeName = this.psDataEntity.getCODENAME();
      if (StringHelper.isNullOrEmpty(this.strCodeName)) {
         this.strCodeName = this.psDataEntity.getPSDATAENTITYNAME().toLowerCase();
      }

      if (!StringHelper.isNullOrEmpty(this.strCodeName) && !iPSSystem.getPSSystemSetting().isFixCodeNameAutoCapitalize()) {
         String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
         this.strCodeName = strHeader + this.strCodeName.substring(1);
      }

      if (!this.psDataEntity.isORDERVALUENull() && this.psDataEntity.getORDERVALUE() >= 0) {
         this.nOrderValue = this.psDataEntity.getORDERVALUE();
      }

      if (!this.psDataEntity.isSAASMODENull()) {
         this.nSaaSMode = this.psDataEntity.getSAASMODE();
      }

      if (!this.psDataEntity.isDEHOLDERNull()) {
         this.nDEHolder = this.psDataEntity.getDEHOLDER();
      }

      this.strXmlTagName = this.strCodeName.toUpperCase();
      this.strIndexDEType = this.psDataEntity.getINDEXDETYPE();
      if (!StringHelper.isNullOrEmpty(this.getIndexDEType())) {
         this.bDefaultDEActionTestUnit = false;
      }

      if (!this.psDataEntity.isTESTCASEFLAGNull()) {
         this.bDefaultDEActionTestUnit = this.psDataEntity.getTESTCASEFLAG();
      }

      if (!this.psDataEntity.isENAMULTIFORMNull()) {
         int nMultiFormMode = this.psDataEntity.getENAMULTIFORM();
         if (nMultiFormMode == 1) {
            this.bEnableMultiForm = true;
         } else if (nMultiFormMode == 2 && this.getPSSystemDynaInstMode() == 1) {
            this.bEnableMultiForm = true;
         }
      }

      if (!this.psDataEntity.isSTORAGEMODENull()) {
         this.nStorageMode = this.psDataEntity.getSTORAGEMODE();
         this.bEnableMultiStorage = (this.nStorageMode & 8) == 8;
         if (this.bEnableMultiStorage) {
            this.nStorageMode ^= 8;
         }
      }

      if (!StringHelper.isNullOrEmpty(this.psDataEntity.getDSLINK())) {
         this.strDSLink = this.psDataEntity.getDSLINK();
         this.bDSLinkDefined = true;
      }

      this.strDBTableSpaceId = this.psDataEntity.getDBTABSPACE();
      if (!this.psDataEntity.isENABLEMULTIDSNull()) {
         this.bEnableMultiDS = this.psDataEntity.getENABLEMULTIDS();
      }

      if (!this.psDataEntity.isEXISTINGMODELNull()) {
         this.bExistingModel = this.psDataEntity.getEXISTINGMODEL();
      }

      if (!this.psDataEntity.isENABLEORGMODELNull()) {
         this.bEnableOrgModel = this.psDataEntity.getENABLEORGMODEL();
      }

      if (!this.psDataEntity.isDATAACCMODENull()) {
         this.nDataAccCtrlMode = this.psDataEntity.getDATAACCMODE();
      } else {
         int nDEType = this.getDEType();
         if ((nDEType == 2 || nDEType == 3 || nDEType == 4) && this.getPSSystem().isEnableModelRT()) {
            this.nDataAccCtrlMode = 2;
         }
      }

      if (!this.psDataEntity.isENABLEAUDITNull()) {
         if (this.psDataEntity.getENABLEAUDIT() && !this.psDataEntity.isAUDITMODENull()) {
            this.nAuditMode = this.psDataEntity.getAUDITMODE();
         }
      } else if (!this.psDataEntity.isAUDITMODENull()) {
         this.nAuditMode = this.psDataEntity.getAUDITMODE();
      }

      if (!this.psDataEntity.isDYNAMICMODENull()) {
         this.nDynamicMode = this.psDataEntity.getDYNAMICMODE();
      }

      if (!this.psDataEntity.isDATACHGLOGMODENull()) {
         this.nDataChangeLogMode = this.psDataEntity.getDATACHGLOGMODE();
      }

      if (!this.psDataEntity.isVIRTUALFLAGNull()) {
         this.nVirtualMode = this.psDataEntity.GetParamIntValue("VIRTUALFLAG", 0);
         if (this.nVirtualMode > 0) {
            this.bVirtual = true;
         }
      }

      if (this.isVirtual() && this.getVirtualMode() == 3) {
         this.strIndexDEType = "INDEX";
      }

      if (!this.psDataEntity.isNOVIEWMODENull()) {
         this.bNoViewMode = this.psDataEntity.getNOVIEWMODE();
      } else {
         this.bNoViewMode = iPSSystem.isNoViewMode();
      }

      if (!this.psDataEntity.isVIEWLEVELNull()) {
         this.nEnableViewLevel = this.psDataEntity.getVIEWLEVEL();
      }

      if (!this.psDataEntity.isENABLEENTITYCACHENull()) {
         this.bEnableEntityCache = this.psDataEntity.getENABLEENTITYCACHE();
      }

      if (!this.psDataEntity.isENTITYCACHETIMEOUTNull()) {
         this.nEntityCacheTimeout = this.psDataEntity.getENTITYCACHETIMEOUT();
      }

      if (!this.psDataEntity.isMAXENTITYCACHECNTNull()) {
         this.nMaxEntityCacheCount = this.psDataEntity.getMAXENTITYCACHECNT();
      }

      if (!this.psDataEntity.isDATAIMPEXPFLAGNull()) {
         this.nDataImpExpMode = this.psDataEntity.getDATAIMPEXPFLAG();
      }

      if (!this.psDataEntity.isMODELIMPEXPFLAGNull()) {
         this.nModelImpExpMode = this.psDataEntity.getMODELIMPEXPFLAG();
      }

      if (!this.psDataEntity.isSERVICEAPIFLAGNull()) {
         this.nServiceAPIMode = this.psDataEntity.getSERVICEAPIFLAG();
      } else {
         this.nServiceAPIMode = this.getPSSystemSetting().getServiceAPIMode();
      }

      if (!StringHelper.isNullOrEmpty(this.psDataEntity.getSERVICECODENAME())) {
         this.strServiceCodeName = this.psDataEntity.getSERVICECODENAME();
      }

      if (!this.psDataEntity.isENABLEDEACTIONNull()) {
         this.bEnableSADEAction = this.psDataEntity.getENABLEDEACTION();
      }

      if (!this.psDataEntity.isENABLESELECTNull()) {
         this.bEnableSASelect = this.psDataEntity.getENABLESELECT();
      }

      if (!this.psDataEntity.isENABLEDEDATASETNull()) {
         this.bEnableSADEDataSet = this.psDataEntity.getENABLEDEDATASET();
      }

      if (!this.psDataEntity.isENATEMPDATANull()) {
         this.nTempDataHolder = this.psDataEntity.getENATEMPDATA();
      }

      if (!this.psDataEntity.isREADONLYMODENull()) {
         int nAction = this.psDataEntity.getREADONLYMODE();
         if ((nAction & 1) == 0) {
            this.nEnableActions |= 1;
         }

         if ((nAction & 2) == 0) {
            this.nEnableActions |= 2;
         }

         if ((nAction & 4) == 0) {
            this.nEnableActions |= 4;
         }
      } else {
         this.nEnableActions = 7;
      }

      if (!this.psDataEntity.isUSERACTIONNull()) {
         int nUIAction = this.psDataEntity.getUSERACTION();
         if ((nUIAction & 1) == 0) {
            this.nEnableUIActions |= 1;
         }

         if ((nUIAction & 2) == 0) {
            this.nEnableUIActions |= 2;
         }

         if ((nUIAction & 4) == 0) {
            this.nEnableUIActions |= 4;
         }

         if ((nUIAction & 8) == 0) {
            this.nEnableUIActions |= 8;
         }
      } else {
         this.nEnableUIActions = 15;
      }

      this.strPSSubSysServiceAPIId = this.psDataEntity.getPSSUBSYSSERVICEAPIID();
      this.strPSHelpModuleId = this.psDataEntity.getPSHELPMODULEID();
      this.bLogicValid = this.psDataEntity.getLOGICVALID();
      if (this.bLogicValid) {
         this.strLogicValidValue = this.psDataEntity.getLOGICVALIDVALUE();
         if (!StringHelper.isNullOrEmpty(this.strLogicValidValue)) {
            this.strLogicInvalidValue = this.psDataEntity.getLOGICINVALIDVALUE();
            if (StringHelper.isNullOrEmpty(this.strLogicInvalidValue)) {
               this.strLogicValidValue = "";
            }
         }
      }

      this.bSortByName = StringHelper.compare(this.getPSSystemSetting().getDEFieldSortMode(), "NAME", false) == 0;
      this.bSortByCreateDate = StringHelper.compare(this.getPSSystemSetting().getDEFieldSortMode(), "CREATEDATE", false) == 0;
      this.bSortByName_PDT = StringHelper.compare(this.getPSSystemSetting().getDEFieldSortMode(), "NAME_PDT", false) == 0;
      if (this.bSortByName_PDT) {
         this.bSortByName = true;
         this.bSortPDT = true;
      }

      this.bSortByCreateDate_PDT = StringHelper.compare(this.getPSSystemSetting().getDEFieldSortMode(), "CREATEDATE_PDT", false) == 0;
      if (this.bSortByCreateDate_PDT) {
         this.bSortByCreateDate = true;
         this.bSortPDT = true;
      }

      if (!this.psDataEntity.isACCCTRLARCHNull()) {
         this.nDataAccCtrlArch = this.psDataEntity.getACCCTRLARCH();
      } else {
         this.nDataAccCtrlArch = this.getPSSystemSetting().getDataAccCtrlArch();
      }

      if (!this.psDataEntity.isDYNAMICMODENull()) {
         this.bEnableDynaSys = this.psDataEntity.getDYNAMICMODE() == 1;
      }

      if (!this.psDataEntity.isENABLEDYNASYSNull()) {
         this.nDEDynaSysMode = this.psDataEntity.getENABLEDYNASYS();
      }

      if (!this.psDataEntity.isENABLEDATAVERNull()) {
         this.bEnableDataVer = this.psDataEntity.getENABLEDATAVER();
      } else {
         this.bEnableDataVer = this.getPSSystemSetting().isEnableDEDataVer();
      }

      this.psDEDBConfigGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDBTableGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEOPPrivGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEUIActionGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEUIActionGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.majorPSDERGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.minorPSDERGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDataQueryGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDataSetGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psAjaxControlHandlerGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDBSysProcGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDELogicGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDataFlowGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEViewLogicGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEMSLogicGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEActionGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEACModeGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDBIndexGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDataRelationGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDRGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDRItemGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEMapGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEWizardGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDataSyncGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEWFGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEUniStateGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDESampleDataGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDTSQueueGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEDataImportGlobalModel.Init(iDAGlobalHelper, this);
      this.psDENotifyGlobalModel.Init(iDAGlobalHelper, this);
      this.psDEDataExportGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEMainStateGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEMainStateRSGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEReportGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEPrintGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEUtilGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEBDTableGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEActionWizardGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEActionWizardGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEServiceAPIGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEUserRoleGlobalModel.Init(iDAGlobalHelper, this);
      this.psDEOPPrivRoleGlobalModel.Init(iDAGlobalHelper, this);
      this.psDEFGroupGlobalModel.Init(iDAGlobalHelper, this);
      this.psDEGroupGlobalModel.Init(iDAGlobalHelper, this);
      this.psDERGroupGlobalModel.Init(iDAGlobalHelper, this);
      this.psDEActionGroupGlobalModel.Init(iDAGlobalHelper, this);
      this.psDESearchGlobalModel.Init(iDAGlobalHelper, this);
      this.bInit = false;
   }

   @Override
   public void init() throws Exception {
      if (!this.bInit) {
         try {
            this.bInit = true;
            this.classOrPkgNameMap = PropertiesHelper.Load(this.psDataEntity.getBASECLSPARAMS());
            if (!StringHelper.isNullOrEmpty(this.psDataEntity.getPSMODULEID())) {
               this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psDataEntity.getPSMODULEID());
            }

            if (this.getPSSystemModule() == null) {
               throw new Exception("未指定实体所属所属系统模块");
            }

            if (!this.psDataEntity.isSUBSYSDENull()) {
               this.bSubSysDE = this.psDataEntity.getSUBSYSDE();
            } else if (this.iPSSystemModule != null) {
               this.bSubSysDE = this.iPSSystemModule.isSubSysModule();
               this.bSubSysAsCloud = this.iPSSystemModule.isSubSysAsCloud();
            }

            if (this.getPSSystemModule() != null) {
               this.iPSSysSFPub = this.getPSSystemModule().getPSSysSFPub();
               if (this.getPSSystemModule().getDynaInstMode() != 0) {
                  this.nDynaInstMode = this.getPSSystemModule().getDynaInstMode();
                  if (!this.psDataEntity.isENABLEDYNASYSNull() && this.psDataEntity.getENABLEDYNASYS() == 0) {
                     this.nDynaInstMode = 0;
                  }
               }

               if (!this.bDSLinkDefined && !StringHelper.isNullOrEmpty(this.getPSSystemModule().getDSLink())) {
                  this.strDSLink = this.getPSSystemModule().getDSLink();
               }
            }

            if (!StringHelper.isNullOrEmpty(this.getDSLink())) {
               this.iPSSysDBScheme = this.getPSSystem().getPSSysDBScheme(this.getPSSysModelGroupId(), this.getDSLink(), true);
            }

            if (!this.bSubSysDE && this.iPSSysSFPub != null && !this.iPSSysSFPub.isMainPSSysSFPub()) {
               throw new Exception("实体所属模块后台服务体系必须为主体系");
            }

            if (!this.psDataEntity.isMSACTIONLOGICFLAGNull()) {
               this.nMSActionLogicMode = this.psDataEntity.getMSACTIONLOGICFLAG();
            } else if (!this.bSubSysDE) {
               this.nMSActionLogicMode = this.getPSSystemSetting().getDEMSActionLogicMode();
            } else {
               this.nMSActionLogicMode = this.getPSSystemSetting().getSubSysDEMSActionLogicMode();
            }

            if (!StringHelper.isNullOrEmpty(this.psDataEntity.getPSSYSIMAGEID())) {
               this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psDataEntity.getPSSYSIMAGEID());
            }

            if (!StringHelper.isNullOrEmpty(this.psDataEntity.getLNPSLANRESID())) {
               this.lnPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psDataEntity.getLNPSLANRESID());
            }

            if (!StringHelper.isNullOrEmpty(this.psDataEntity.getPSSYSUNIRESID())) {
               this.iPSSysUniRes = this.getPSSystem().getPSSysUniRes(this.psDataEntity.getPSSYSUNIRESID());
            }

            Vector<PSDEField> defields = new Vector<>();
            CallResult callResult = this.getPSModelHelper().getPSDEFieldsNoSort(this.getId(), defields);
            if (callResult == null || callResult.getRetCode() != 0) {
               throw new Exception("获取指定实体属性集合错误");
            }

            PSDEField indexTypePSDEField = null;
            PSDEField formTypePSDEField = null;

            for (PSDEField defield : defields) {
               if (defield.getINDEXTYPE()) {
                  if (indexTypePSDEField != null) {
                     throw new Exception(
                        StringHelper.format(
                           "实体[%1$s]已经存在索引类型属性[%2$s]，不能重复定义[%3$s]", this.getName(), indexTypePSDEField.getPSDEFIELDNAME(), defield.getPSDEFIELDNAME()
                        )
                     );
                  }

                  indexTypePSDEField = defield;
               }

               if (defield.getMULTIFORMFIELD()) {
                  if (formTypePSDEField != null) {
                     throw new Exception(
                        StringHelper.format(
                           "实体[%1$s]已经存在表单类型属性[%2$s]，不能重复定义[%3$s]", this.getName(), formTypePSDEField.getPSDEFIELDNAME(), defield.getPSDEFIELDNAME()
                        )
                     );
                  }

                  formTypePSDEField = defield;
               }
            }

            Vector<PSDEViewBase> deViews = new Vector<>();
            callResult = this.getPSModelHelper().getPSDEViews(this.getId(), deViews);
            if (callResult.isError()) {
               throw new Exception(StringHelper.format("实体[%1$s]无法获取视图集合，%2$s", this.getName(), callResult.getErrorInfo()));
            }

            this.psDEViewBaseList.addAll(deViews);

            for (PSDEViewBase psDEViewBase : this.psDEViewBaseList) {
               PSModelObj psModelObj = new PSModelObj();
               psModelObj.setPSMODELOBJNAME(psDEViewBase.getPSDEVIEWBASENAME());
               psModelObj.setREALMODELOBJID(psDEViewBase.getPSDEVIEWBASEID());
               psModelObj.setPSMODELTYPE("PSDEVIEWBASE");
               psModelObj.setPSMODELSUBTYPE(psDEViewBase.getPSDEVIEWBASETYPE());
               psModelObj.setCODENAME(psDEViewBase.getCODENAME());
               psModelObj.setLOGICNAME(psDEViewBase.getPSDEVIEWBASENAME());
               psModelObj.setMODELTAG(psDEViewBase.getPREDEFINEVIEWTYPE());
               psModelObj.setMODELTAG2(psDEViewBase.getPDVTPARAM());
               this.registerPSModelData(psModelObj);
            }

            deViews = new Vector<>();
            callResult = this.getPSModelHelper().getPSDEPredefinedViews(this.getId(), deViews);
            if (callResult.isError()) {
               throw new Exception(StringHelper.format("实体[%1$s]无法获取预置视图集合，%2$s", this.getName(), callResult.getErrorInfo()));
            }

            for (PSDEViewBase psDEViewBase : deViews) {
               String strPDViewType = psDEViewBase.getPREDEFINEVIEWTYPE();
               if (!StringHelper.isNullOrEmpty(psDEViewBase.getPDVTPARAM())) {
                  strPDViewType = strPDViewType + StringHelper.format(":%1$s", psDEViewBase.getPDVTPARAM());
               }

               if (this.predefineDEViewMap.containsKey(strPDViewType)) {
                  throw new Exception(StringHelper.format("实体[%1$s]已存在预置视图类型[%2$s]，无法重复注册", this.getName(), strPDViewType));
               }

               this.predefineDEViewMap.put(strPDViewType, psDEViewBase);
            }

            Vector<PSDEForm> deEditForms = new Vector<>();
            callResult = this.getPSModelHelper().getPSDEEditForms(this.getId(), deEditForms);
            if (callResult.isError()) {
               throw new Exception(StringHelper.format("实体[%1$s]无法获取编辑表单集合，%2$s", this.getName(), callResult.getErrorInfo()));
            }

            this.psDEEditFormList.addAll(deEditForms);

            for (PSDEForm psDEForm : this.psDEEditFormList) {
               PSModelObj psModelObj = new PSModelObj();
               psModelObj.setPSMODELOBJNAME(psDEForm.getPSDEFORMNAME());
               psModelObj.setREALMODELOBJID(psDEForm.getPSDEFORMID());
               psModelObj.setPSMODELTYPE("PSDEFORM");
               psModelObj.setPSMODELSUBTYPE("EDITFORM");
               psModelObj.setCODENAME(psDEForm.getCODENAME());
               psModelObj.setLOGICNAME(psDEForm.getPSDEFORMNAME());
               psModelObj.setMODELTAG(psDEForm.getFUNCMODE());
               psModelObj.setMODELTAG2(psDEForm.getMOBFLAG() ? "1" : "0");
               this.registerPSModelData(psModelObj);
            }

            Vector<PSDEACMode> deACModes = new Vector<>();
            callResult = this.getPSModelHelper().getPSDEACModes(this.getId(), deACModes);
            if (callResult.isError()) {
               throw new Exception(StringHelper.format("查询全部实体自填模式发生错误，%1$s", callResult.getErrorInfo()));
            }

            for (PSDEACMode psDEACMode : deACModes) {
               if (!psDEACMode.isDEFAULTMODENull() && psDEACMode.getDEFAULTMODE()) {
                  this.defaultPSDEACModeData = psDEACMode;
                  break;
               }
            }

            Vector<PSDEPrint> dePrints = new Vector<>();
            callResult = this.getPSModelHelper().getPSDEPrints(this.getId(), dePrints);
            if (callResult.isError()) {
               throw new Exception(StringHelper.format("查询全部实体打印发生错误，%1$s", callResult.getErrorInfo()));
            }

            for (PSDEPrint psDEPrint : dePrints) {
               if (this.defaultPSDEPrintData == null || psDEPrint.getDEFAULTMODE()) {
                  this.defaultPSDEPrintData = psDEPrint;
                  break;
               }
            }

            String strPSSysSFPluginId = this.psDataEntity.getPSSYSSFPLUGINID();
            if (StringHelper.isNullOrEmpty(strPSSysSFPluginId) && this.getPSSystemModule() != null) {
               strPSSysSFPluginId = this.getPSSystemModule().getDEPSSysSFPluginId();
            }

            if (!StringHelper.isNullOrEmpty(strPSSysSFPluginId)) {
               this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
            }

            if (this.getPSSysSFPlugin() != null) {
               String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId(this.getPSSysSFPlugin().getId(), this.getPSSystem().getPSSFId());
               IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
               if (iPSSysSFPluginTempl != null) {
                  this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
               }
            }

            this.onInit();
         } catch (Exception ex) {
            String strLogName = StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getModelName());
            String strExInfo = StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
            log.error(StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
            if (this.getPSSystemUtil() != null) {
               this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }

            this.throwInitException(ex);
         }
      }
   }

   @Override
   public boolean isInit() {
      return this.bInit;
   }

   @Override
   protected void onInit() throws Exception {
      super.onInit();
   }

   @Override
   public synchronized boolean preparePSDEFields(boolean bReset) throws Exception {
      if (bReset) {
         this.defHelpers = null;
         this.defHelperMap = null;
         this.preDefineFields = null;
         this.deFieldList = null;
         this.psDEFValueRuleMap = null;
         this.psDEFValueRuleList = null;
         this.quickSearchPSDEFieldList = null;
      }

      return this.internalPreparePSDEFields(false);
   }

   private final synchronized boolean internalPreparePSDEFields(boolean bException) throws Exception {
      if (this.defHelpers != null && this.defHelperMap != null && this.preDefineFields != null) {
         return true;
      }

      long nStartTick = new Date().getTime();
      log.debug(StringHelper.format("准备实体[%1$s]属性开始", this.getName()));
      this.onBeforePreparePSDEFields();

      try {
         this.keyDEField = null;
         this.majorDEField = null;
         this.indexTypeDEField = null;
         this.uniTagDEField = null;
         this.formTypeDEField = null;
         this.psDEFValueRuleMap = null;
         this.psDEFValueRuleList = null;
         this.quickSearchPSDEFieldList = null;
         this.defHelpers = new ArrayList<>();
         this.deFieldList = new ArrayList<>();
         this.defHelperMap = new Hashtable<>();
         this.preDefineFields = new Hashtable<>();
         Vector<PSDEField> defields2 = new Vector<>();
         CallResult callResult = this.getPSModelHelper().getPSDEFieldsNoSort(this.getId(), defields2);
         if (callResult == null || callResult.getRetCode() != 0) {
            throw new Exception("获取指定实体属性集合错误");
         }

         Vector<PSDEField> defields = new Vector<>();

         for (PSDEField psDEField : defields2) {
            if (psDEField.GetParamIntValue("VALIDFLAG", 1) == 1) {
               defields.add(psDEField);
            }
         }

         HashMap<String, PSDEField> psDEFieldMap = new HashMap<>();

         for (PSDEField psDEField : defields) {
            psDEFieldMap.put(psDEField.getPSDEFIELDID(), psDEField);
         }

         Vector<PSDEFUIMode> psDEFUIModeList = new Vector<>();
         callResult = this.getPSModelHelper().getPSDEFUIModesByDataEntity(this.getId(), psDEFUIModeList);
         if (callResult.getRetCode() != 0) {
            throw new Exception("获取指定实体属性界面配置错误");
         }

         for (PSDEFUIMode psDEFUIMode : psDEFUIModeList) {
            PSDEField psDEField = psDEFieldMap.get(psDEFUIMode.getPSDEFID());
            if (psDEField != null) {
               psDEField.getPSDEFUIModes(true).add(psDEFUIMode);
            }
         }

         Vector<PSDEFSearchMode> psDEFSearchModeList = new Vector<>();
         callResult = this.getPSModelHelper().getPSDEFSearchModesByDataEntity(this.getId(), psDEFSearchModeList);
         if (callResult.getRetCode() != 0) {
            throw new Exception("获取指定实体属性搜索模式错误");
         }

         for (PSDEFSearchMode psDEFSearchMode : psDEFSearchModeList) {
            PSDEField psDEField = psDEFieldMap.get(psDEFSearchMode.getPSDEFID());
            if (psDEField != null) {
               psDEField.getPSDEFSearchModes(true).add(psDEFSearchMode);
            }
         }

         Vector<PSDEFValueRule> psDEFValueRuleList = new Vector<>();
         callResult = this.getPSModelHelper().getPSDEFValueRulesByDataEntity(this.getId(), psDEFValueRuleList);
         if (callResult.getRetCode() != 0) {
            throw new Exception("获取指定实体属性值规则错误");
         }

         for (PSDEFValueRule psDEFValueRule : psDEFValueRuleList) {
            PSDEField psDEField = psDEFieldMap.get(psDEFValueRule.getPSDEFID());
            if (psDEField != null) {
               psDEField.getPSDEFValueRules(true).add(psDEFValueRule);
            }
         }

         Vector<PSDEFInputTip> psDEFInputTipList = new Vector<>();
         callResult = this.getPSModelHelper().getPSDEFInputTipsByDataEntity(this.getId(), psDEFInputTipList);
         if (callResult.getRetCode() != 0) {
            throw new Exception("获取指定实体属性输入提示错误");
         }

         for (PSDEFInputTip psDEFInputTip : psDEFInputTipList) {
            if (psDEFInputTip.isVALIDFLAGNull() || psDEFInputTip.getVALIDFLAG()) {
               PSDEField psDEField = psDEFieldMap.get(psDEFInputTip.getPSDEFID());
               if (psDEField != null) {
                  psDEField.getPSDEFInputTips(true).add(psDEFInputTip);
               }
            }
         }

         Vector<PSSysSearchDEField> psSysSearchDEFieldList = new Vector<>();
         callResult = this.getPSModelHelper().getPSSysSearchDEFieldsByDataEntity(this.getId(), psSysSearchDEFieldList);
         if (callResult.getRetCode() != 0) {
            throw new Exception("获取指定实体属性全文检索错误");
         }

         for (PSSysSearchDEField psSysSearchDEField : psSysSearchDEFieldList) {
            PSDEField psDEField = psDEFieldMap.get(psSysSearchDEField.getPSDEFID());
            if (psDEField != null) {
               psDEField.getPSSysSearchDEFields(true).add(psSysSearchDEField);
            }
         }

         Vector<PSDEField> normaldefields = new Vector<>();
         Vector<PSDEField> pickupFields = new Vector<>();
         Vector<PSDEField> pickupDataFields = new Vector<>();

         for (PSDEField deField : defields) {
            int nDEFType = deField.getDEFTYPE();
            if (nDEFType == 2) {
               normaldefields.add(deField);
            } else {
               String strDataType = deField.getPSDATATYPEID();
               if (StringHelper.compare(strDataType, "PICKUPDATA", true) == 0 || StringHelper.compare(strDataType, "PICKUPTEXT", true) == 0) {
                  pickupDataFields.add(deField);
               } else if (StringHelper.compare(strDataType, "PICKUP", true) == 0) {
                  pickupFields.add(deField);
               } else {
                  normaldefields.add(deField);
               }
            }
         }

         this.preDefineFields.put("CREATEMAN", "CREATEMAN");
         this.preDefineFields.put("CREATEMANNAME", "CREATEMANNAME");
         this.preDefineFields.put("CREATEDATE", "CREATEDATE");
         this.preDefineFields.put("UPDATEMAN", "UPDATEMAN");
         this.preDefineFields.put("UPDATEMANNAME", "UPDATEMANNAME");
         this.preDefineFields.put("UPDATEDATE", "UPDATEDATE");
         if (this.isLogicValid()) {
            this.preDefineFields.put("LOGICVALID", "ENABLE");
         }

         this.preDefineFields.put("ORGID", "ORGID");
         this.preDefineFields.put("ORGSECTORID", "ORGSECTORID");
         this.preDefineFields.put("ORGNAME", "ORGNAME");
         this.preDefineFields.put("ORGSECTORNAME", "ORGSECTORNAME");
         if (StringHelper.compare(this.getPSSystemUtil().getTemplEngineVer(), "V2", true) == 0) {
            this.preDefineFields.put("ORDERVALUE", "ORDERVALUE");
         }

         for (PSDEField deField : normaldefields) {
            IPSDEField iDEField = this.createPSDEField(deField);
            if (iDEField != null) {
               this.defHelpers.add(iDEField);
               this.defHelperMap.put(deField.getPSDEFIELDID().toUpperCase(), iDEField);
               this.defHelperMap.put(deField.getPSDEFIELDNAME().toUpperCase(), iDEField);
            }
         }

         for (PSDEField deField : pickupDataFields) {
            IPSDEField iDEField = this.createPSDEField(deField);
            if (iDEField != null) {
               this.defHelpers.add(iDEField);
               this.defHelperMap.put(deField.getPSDEFIELDID().toUpperCase(), iDEField);
               this.defHelperMap.put(deField.getPSDEFIELDNAME().toUpperCase(), iDEField);
            }
         }

         for (PSDEField deField : pickupFields) {
            IPSDEField iDEField = this.createPSDEField(deField);
            if (iDEField != null) {
               this.defHelpers.add(iDEField);
               this.defHelperMap.put(deField.getPSDEFIELDID().toUpperCase(), iDEField);
               this.defHelperMap.put(deField.getPSDEFIELDNAME().toUpperCase(), iDEField);
            }
         }

         HashMap<String, IPSDEField> unionKeyValueMap = new HashMap<>();
         HashMap<String, IPSDEField> mainStateFieldMap = new HashMap<>();

         for (IPSDEField iDEField : this.defHelpers) {
            if (!iDEField.isInit()) {
               try {
                  iDEField.init();
               } catch (Exception var18) {
               }
            }
         }

         for (IPSDEField iDEField : this.defHelpers) {
            if (!iDEField.isInit()) {
               try {
                  iDEField.init();
               } catch (Exception var17) {
               }
            }
         }

         for (IPSDEField iDEField : this.defHelpers) {
            this.deFieldList.add(iDEField);
            if (!iDEField.isInit()) {
               try {
                  iDEField.init();
               } catch (Exception ex) {
                  throw new Exception(StringHelper.format("初始化属性[%1$s][%2$s]失败，原因：%3$s", this.getName(), iDEField.getName(), ex.getMessage()), ex);
               }
            }

            if (iDEField.isKeyDEField()) {
               this.keyDEField = iDEField;
            }

            if (iDEField.isUniTagField()) {
               if (!DataTypeHelper.isStringDataType(iDEField.getStdDataType())) {
                  throw new Exception(StringHelper.format("[%1$s]唯一业务标记属性[%2$s]标准类型必须为[字符串]", this.getName(), iDEField.getName()));
               }

               this.uniTagDEField = iDEField;
            }

            if (iDEField.isMajorDEField()) {
               this.majorDEField = iDEField;
            }

            if (iDEField.isKeyNameDEField()) {
               this.keyNameDEField = iDEField;
            }

            if (!StringHelper.isNullOrEmpty(iDEField.getUnionKeyValue()) && !iDEField.isKeyDEField()) {
               unionKeyValueMap.put(iDEField.getUnionKeyValue(), iDEField);
            }

            if (!StringHelper.isNullOrEmpty(iDEField.getDEMSFieldMode())) {
               mainStateFieldMap.put(iDEField.getDEMSFieldMode(), iDEField);
            }

            if (!StringHelper.isNullOrEmpty(iDEField.getBizTag())) {
               String strBizTag = StringHelper.format("%1$s#%2$s", "SRFBIZTAG", iDEField.getBizTag());
               this.defHelperMap.put(strBizTag, iDEField);
            }

            if (iDEField.isIndexTypeDEField()) {
               if (this.indexTypeDEField != null) {
                  throw new Exception(
                     StringHelper.format("实体[%1$s]已经存在索引类型属性[%2$s]，不能重复定义[%3$s]", this.getName(), this.indexTypeDEField.getName(), iDEField.getName())
                  );
               }

               this.indexTypeDEField = iDEField;
            }

            if (iDEField.isFormTypeDEField()) {
               if (this.formTypeDEField != null) {
                  throw new Exception(
                     StringHelper.format("实体[%1$s]已经存在表单类型属性[%2$s]，不能重复定义[%3$s]", this.getName(), this.formTypeDEField.getName(), iDEField.getName())
                  );
               }

               this.formTypeDEField = iDEField;
            }

            if (this.isExistingModel()) {
               if (!StringHelper.isNullOrEmpty(iDEField.getPSDEFieldData().getPREDEFINETYPE())
                  && StringHelper.compare(iDEField.getPSDEFieldData().getPREDEFINETYPE(), "NONE", true) != 0) {
                  this.preDefineFields.put(iDEField.getPSDEFieldData().getPREDEFINETYPE(), iDEField.getName());
               }
            } else if (StringHelper.compare(iDEField.getPSDEFieldData().getPREDEFINETYPE(), "NONE", true) != 0
               && !StringHelper.isNullOrEmpty(iDEField.getPSDEFieldData().getPREDEFINETYPE())) {
               this.preDefineFields.put(iDEField.getPSDEFieldData().getPREDEFINETYPE(), iDEField.getName());
            }
         }

         for (String strPreDefineType : this.preDefineFields.keySet()) {
            String strField = this.preDefineFields.get(strPreDefineType);
            IPSDEField iPSDEField = this.defHelperMap.get(strField.toUpperCase());
            if (iPSDEField != null) {
               if (StringHelper.compare(iPSDEField.getPSDEFieldData().getPREDEFINETYPE(), "NONE", true) != 0) {
                  if (StringHelper.isNullOrEmpty(iPSDEField.getPSDEFieldData().getPREDEFINETYPE())) {
                     if (!iPSDEField.isKeyDEField()) {
                        iPSDEField.setPreDefinedType(strPreDefineType);
                     } else {
                        this.preDefineFields.put(strPreDefineType, "");
                     }
                  } else {
                     iPSDEField.setPreDefinedType(strPreDefineType);
                  }
               } else {
                  this.preDefineFields.put(strPreDefineType, "");
               }
            }
         }

         this.unionKeyValueFieldList.clear();

         for (int i = 1; i < 9; i++) {
            String strKey = StringHelper.format("KEY%1$s", i);
            IPSDEField iPSDEField = unionKeyValueMap.get(strKey);
            if (iPSDEField != null) {
               this.unionKeyValueFieldList.add(iPSDEField);
            }
         }

         this.mainStateFieldList.clear();

         for (int i = 1; i < 4; i++) {
            String strKey = StringHelper.format("STATE%1$s", i);
            IPSDEField iPSDEField = mainStateFieldMap.get(strKey);
            if (iPSDEField != null) {
               this.mainStateFieldList.add(iPSDEField);
            }
         }

         if (this.keyDEField == null) {
            log.warn(StringHelper.format("实体[%1$s]没有存在键值属性，可能会发生错误!", this.getFullName()));
         }

         if (this.majorDEField == null) {
            log.warn(StringHelper.format("实体[%1$s]没有存在主文本属性，可能会发生错误!", this.getFullName()));
         }

         Collections.sort(this.defHelpers, new Comparator<IPSDEField>() {
            public int compare(IPSDEField arg0, IPSDEField arg1) {
               int nValue = arg0.getOrderValue() - arg1.getOrderValue();
               if (nValue == 0) {
                  if (PSDataEntityImpl.this.bSortPDT) {
                     nValue = PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg0) - PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg1);
                     if (nValue != 0) {
                        return new Integer(PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg0)).compareTo(PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg1));
                     }
                  }

                  if (PSDataEntityImpl.this.bSortByName) {
                     return arg0.getName().compareTo(arg1.getName());
                  }

                  if (PSDataEntityImpl.this.bSortByCreateDate) {
                     return new Long(arg0.getCreateTime()).compareTo(arg1.getCreateTime());
                  }
               }

               return new Integer(arg0.getOrderValue()).compareTo(arg1.getOrderValue());
            }
         });
      } catch (Exception ex) {
         this.defHelpers = null;
         this.defHelperMap = null;
         this.preDefineFields = null;
         if (bException) {
            throw ex;
         }

         log.error("准备实体属性失败", ex);
         return false;
      }

      log.debug(StringHelper.format("准备实体[%1$s]属性结束，耗时[%2$s]", this.getName(), new Date().getTime() - nStartTick));
      return this.onAfterPreparePSDEFields();
   }

   protected int getPSDEFieldPDTOrder(IPSDEField iPSDEField) {
      if (iPSDEField.isKeyDEField()) {
         return 10;
      } else if (iPSDEField.isUniTagField()) {
         return 15;
      } else if (iPSDEField.isMajorDEField()) {
         return 20;
      } else if (iPSDEField.isKeyNameDEField()) {
         return 25;
      } else if (iPSDEField.isIndexTypeDEField()) {
         return 30;
      } else if (StringHelper.compare(iPSDEField.getPreDefinedType(), "LOGICVALID", false) == 0) {
         return 50;
      } else if (StringHelper.compare(iPSDEField.getPreDefinedType(), "CREATEMAN", false) == 0) {
         return 60;
      } else if (StringHelper.compare(iPSDEField.getPreDefinedType(), "CREATEMANNAME", false) == 0) {
         return 65;
      } else if (StringHelper.compare(iPSDEField.getPreDefinedType(), "CREATEDATE", false) == 0) {
         return 70;
      } else if (StringHelper.compare(iPSDEField.getPreDefinedType(), "UPDATEMAN", false) == 0) {
         return 80;
      } else if (StringHelper.compare(iPSDEField.getPreDefinedType(), "UPDATEMANNAME", false) == 0) {
         return 85;
      } else {
         return StringHelper.compare(iPSDEField.getPreDefinedType(), "UPDATEDATE", false) == 0 ? 90 : 1000;
      }
   }

   protected void onBeforePreparePSDEFields() throws Exception {
   }

   protected boolean onAfterPreparePSDEFields() throws Exception {
      return true;
   }

   @Override
   public synchronized Iterator<IPSDEField> getPSDEFields() throws Exception {
      this.internalPreparePSDEFields(true);
      if (this.defHelpers == null) {
         throw new Exception("实体属性集合无效");
      } else {
         return this.defHelpers.iterator();
      }
   }

   @Override
   public IPSDEField getPSDEField(String strDEFieldName, boolean bTryMode) throws Exception {
      IPSDEField iPSDEField = this.internalGetPSDEField(strDEFieldName, bTryMode);
      if (iPSDEField != null && !iPSDEField.isInit()) {
         iPSDEField.init();
      }

      return iPSDEField;
   }

   protected IPSDEField internalGetPSDEField(String strDEFieldName, boolean bTryMode) throws Exception {
      this.internalPreparePSDEFields(true);
      strDEFieldName = strDEFieldName.toUpperCase();
      IPSDEField iPSDEField = this.defHelperMap.get(strDEFieldName);
      if (iPSDEField != null) {
         return iPSDEField;
      } else if (bTryMode) {
         return null;
      } else {
         throw PSDataEntityException.create(this, 20000, strDEFieldName);
      }
   }

   protected IPSDEField createPSDEField(PSDEField psDEField) throws Exception {
      IPSDEFieldType iPSDEFieldType = this.getPSSystem().getPSDEFieldTypeByDEField(psDEField);
      if (iPSDEFieldType == null) {
         log.error(StringHelper.format("属性[%1$s]无法获取对应的类型对象", psDEField.getPSDEFIELDNAME()));
         return null;
      } else {
         IPSDEField iPSDEField = iPSDEFieldType.createPSDEField(psDEField);
         iPSDEField.setInitParam(this.getDAGlobalHelper(), this, iPSDEFieldType, psDEField);
         return iPSDEField;
      }
   }

   @Override
   public String getFullName() {
      return super.getFullName();
   }

   @Override
   public Iterator<IDEField> getDEFields() throws Exception {
      return this.deFieldList.iterator();
   }

   @Override
   public IDEField getDEField(String strDEFieldName, boolean bTryMode) throws Exception {
      return this.getPSDEField(strDEFieldName, bTryMode);
   }

   @PSModelRTMeta(description = "表名称", dynamodelmode = 4, group = "数据库存储", order = 374, fields = "TABLENAME")
   @Override
   public String getTableName() {
      try {
         if (this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) {
            return this.psDataEntity.getTABLENAME();
         }
      } catch (Exception e) {
         log.error(e);
      }

      return "";
   }

   @PSModelRTMeta(description = "视图名称", dynamodelmode = 4, group = "数据库存储", order = 379, fields = "VIEWNAME")
   @Override
   public String getViewName() {
      try {
         if ((this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) && !this.isNoViewMode()) {
            return this.psDataEntity.getVIEWNAME();
         }
      } catch (Exception e) {
         log.error(e);
      }

      return "";
   }

   @PSModelRTMeta(description = "启用逻辑有效", dynamodelmode = 4, fields = "LOGICVALID")
   @Override
   public boolean isLogicValid() {
      return this.bLogicValid;
   }

   @Override
   public Object getLogicValidValue(boolean bValid) {
      if (StringHelper.isNullOrEmpty(this.strLogicValidValue)) {
         return bValid ? 1 : 0;
      }

      try {
         if (this.getLogicValidPSDEField() != null) {
            return this.getLogicValidPSDEField().getDEFValue(this.getLogicValidStringValue(bValid));
         }
      } catch (Exception e) {
         log.error(StringHelper.format("计算逻辑有效标识值发生异常，%1$s", e.getMessage()), e);
      }

      return null;
   }

   @Override
   public String getLogicValidStringValue(boolean bValid) {
      if (StringHelper.isNullOrEmpty(this.strLogicValidValue)) {
         return bValid ? "1" : "0";
      } else {
         return bValid ? this.strLogicValidValue : this.strLogicInvalidValue;
      }
   }

   @PSModelRTMeta(description = "逻辑有效值", hideempty2 = true, dynamodelmode = 4, fields = "LOGICVALIDVALUE")
   @Override
   public String getValidLogicValue() {
      return !this.isLogicValid() ? null : this.getLogicValidStringValue(true);
   }

   @PSModelRTMeta(description = "逻辑无效值", hideempty2 = true, dynamodelmode = 4, fields = "LOGICINVALIDVALUE")
   @Override
   public String getInvalidLogicValue() {
      return !this.isLogicValid() ? null : this.getLogicValidStringValue(false);
   }

   @PSModelRTMeta(description = "实体数据库配置集合", hideempty2 = true, dynamodelmode = 4, child = true, group = "数据库存储", order = 388)
   @Override
   public Iterator<IPSDEDBConfig> getAllPSDEDBConfigs() throws Exception {
      return this.psDEDBConfigGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEDBConfig getPSDEDBConfig(String strDBType) throws Exception {
      return this.psDEDBConfigGlobalModel.FindModelHelper(strDBType);
   }

   @Override
   public IPSDEDBConfig getPSDEDBConfig(String strDBType, boolean bTryMode) throws Exception {
      return this.psDEDBConfigGlobalModel.FindModelHelper(strDBType, bTryMode);
   }

   @PSModelRTMeta(description = "主键属性", dumpref = true, from = "__self__", group = "模型", order = 151)
   @Override
   public IPSDEField getKeyPSDEField() {
      return this.keyDEField;
   }

   @PSModelRTMeta(description = "主信息属性", dumpref = true, from = "__self__", group = "模型", order = 152)
   @Override
   public IPSDEField getMajorPSDEField() {
      return this.majorDEField;
   }

   @PSModelRTMeta(description = "键名属性", dumpref = true, from = "__self__", group = "模型", order = 153)
   @Override
   public IPSDEField getKeyNamePSDEField() {
      return this.keyNameDEField;
   }

   @PSModelRTMeta(description = "逻辑有效属性", hideempty2 = true, dumpref = true, from = "__self__", group = "模型", order = 154)
   @Override
   public IPSDEField getLogicValidPSDEField() throws Exception {
      return this.getPSDEFieldByPDT("LOGICVALID", true);
   }

   @Override
   public IPSPickupDEField getPSPickupDEField(String strPSDERId) throws Exception {
      Iterator<IPSDEField> deFields = this.getPSDEFields();

      while (deFields.hasNext()) {
         IPSDEField iPSDEField = deFields.next();
         if (iPSDEField.isLinkDEField() && StringHelper.compare(iPSDEField.getDataType(), "PICKUP", true) == 0) {
            IPSPickupDEField iPSPickupDEField = (IPSPickupDEField)iPSDEField;
            if (StringHelper.compare(iPSPickupDEField.getDERId(), strPSDERId, true) == 0) {
               return iPSPickupDEField;
            }
         }
      }

      return null;
   }

   @PSModelRTMeta(description = "继承实体对象", hideempty = true, dumpref = true, ignorert = 3)
   @Override
   public IPSDataEntity getInheritPSDataEntity() throws Exception {
      return this.getPSDERInherit() != null ? this.getPSDERInherit().getMajorPSDataEntity() : null;
   }

   @PSModelRTMeta(description = "继承关系对象", hideempty = true, dumpref = true, ignorert = 3)
   @Override
   public IPSDERInherit getPSDERInherit() throws Exception {
      return this.minorPSDERGlobalModel.getPSDERInherit();
   }

   @Override
   public IPSDEField getPSDEFieldByPDT(String strPreDefineType, boolean bTryMode) throws Exception {
      this.internalPreparePSDEFields(true);
      String strName = null;
      if (this.preDefineFields != null) {
         strName = this.preDefineFields.get(strPreDefineType);
      }

      if (StringHelper.isNullOrEmpty(strName)) {
         if (!bTryMode) {
            throw new Exception(StringHelper.format("无法找到预定义类型[%1$s]", strPreDefineType));
         } else {
            return null;
         }
      } else {
         return this.getPSDEField(strName, bTryMode);
      }
   }

   @Override
   public IPSDERBase getPSDER(boolean bMain, String strDERType, String strPSDERName) throws Exception {
      return null;
   }

   @Override
   public IPSDEUIAction getPSDEUIAction(String strDEUIActionId) throws Exception {
      IPSDEUIAction iPSDEUIAction = this.psDEUIActionGlobalModel.FindModelHelper(strDEUIActionId, true);
      if (iPSDEUIAction != null) {
         return iPSDEUIAction;
      }

      iPSDEUIAction = this.getPSSystem().getPSDEUIAction(strDEUIActionId, true);
      return iPSDEUIAction != null ? iPSDEUIAction : this.psDEUIActionGlobalModel.FindModelHelper(strDEUIActionId, false);
   }

   @Override
   public IPSDEUIAction getPSDEUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
      IPSDEUIAction iPSDEUIAction = this.psDEUIActionGlobalModel.FindModelHelper(strDEUIActionId, true);
      if (iPSDEUIAction != null) {
         return iPSDEUIAction;
      } else {
         iPSDEUIAction = this.getPSSystem().getPSDEUIAction(strDEUIActionId, true);
         if (iPSDEUIAction != null) {
            return iPSDEUIAction;
         } else {
            return !bTryMode ? this.psDEUIActionGlobalModel.FindModelHelper(strDEUIActionId, bTryMode) : iPSDEUIAction;
         }
      }
   }

   @Override
   public void resetPSDEUIAction(String strDEUIActionId) throws Exception {
      this.psDEUIActionGlobalModel.ResetModel(strDEUIActionId);
   }

   @PSModelRTMeta(description = "实体界面行为对象集合", outputdoc = "false")
   @Override
   public Iterator<IPSDEUIAction> getAllPSDEUIActions() throws Exception {
      return this.psDEUIActionGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId) throws Exception {
      IPSDEUIActionGroup iPSDEUIActionGroup = this.getPSSystem().getPSDEUIActionGroup(strDEUIActionGroupId, true);
      return iPSDEUIActionGroup != null ? iPSDEUIActionGroup : this.psDEUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId);
   }

   @Override
   public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
      IPSDEUIActionGroup iPSDEUIActionGroup = this.getPSSystem().getPSDEUIActionGroup(strDEUIActionGroupId, true);
      return iPSDEUIActionGroup != null ? iPSDEUIActionGroup : this.psDEUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId, bTryMode);
   }

   @Override
   public void resetPSDEUIActionGroup(String strDEUIActionGroupId) throws Exception {
      this.psDEUIActionGroupGlobalModel.ResetModel(strDEUIActionGroupId);
   }

   @Override
   public IPSDERBase getPSDER(boolean bMajor, String strPSDERId) throws Exception {
      return bMajor ? this.majorPSDERGlobalModel.FindModelHelper(strPSDERId) : this.minorPSDERGlobalModel.FindModelHelper(strPSDERId);
   }

   @Override
   public Iterator<IPSDERBase> getPSDERs(boolean bMajor) {
      return bMajor ? this.majorPSDERGlobalModel.getPSDERs() : this.minorPSDERGlobalModel.getPSDERs();
   }

   @PSModelRTMeta(description = "主关系集合", child = true, ignorert = 3, group = "模型", order = 294)
   @Override
   public Iterator<IPSDERBase> getMajorPSDERs() {
      return this.getPSDERs(true);
   }

   @PSModelRTMeta(description = "从关系集合", child = true, rtname = "getDERs", group = "模型", order = 292)
   @Override
   public Iterator<IPSDERBase> getMinorPSDERs() {
      return this.getPSDERs(false);
   }

   @PSModelRTMeta(description = "主1:N关系集合", outputdoc = "false")
   @Override
   public Iterator<IPSDER1N> getMajorPSDER1Ns() {
      return this.getPSDER1Ns(true);
   }

   @PSModelRTMeta(description = "从1:N关系集合", outputdoc = "false")
   @Override
   public Iterator<IPSDER1N> getMinorPSDER1Ns() {
      return this.getPSDER1Ns(false);
   }

   @Override
   public Iterator<IPSDER1N> getPSDER1Ns(boolean bMajor, boolean bRemoveOrder) {
      ArrayList<IPSDER1N> psDER1NList = new ArrayList<>();
      Iterator<IPSDERBase> psDERBases = this.getPSDERs(bMajor);
      if (psDERBases == null) {
         return null;
      }

      while (psDERBases.hasNext()) {
         IPSDERBase iPSDERBase = psDERBases.next();
         if (iPSDERBase instanceof IPSDER1N) {
            psDER1NList.add((IPSDER1N)iPSDERBase);
         }
      }

      if (bRemoveOrder && psDER1NList.size() > 0) {
         Collections.sort(psDER1NList, new Comparator<IPSDER1N>() {
            public int compare(IPSDER1N o1, IPSDER1N o2) {
               int nRet = o1.getRemoveOrder() - o2.getRemoveOrder();
               if (nRet == 0) {
                  return 0;
               } else {
                  return nRet > 0 ? 1 : -1;
               }
            }
         });
      }

      return psDER1NList.size() == 0 ? null : psDER1NList.iterator();
   }

   @Override
   public Iterator<IPSDER1N> getPSDER1Ns(boolean bMajor) {
      ArrayList<IPSDER1N> psDER1NList = new ArrayList<>();
      Iterator<IPSDERBase> psDERBases = this.getPSDERs(bMajor);
      if (psDERBases == null) {
         return null;
      }

      while (psDERBases.hasNext()) {
         IPSDERBase iPSDERBase = psDERBases.next();
         if (iPSDERBase instanceof IPSDER1N) {
            psDER1NList.add((IPSDER1N)iPSDERBase);
         }
      }

      return psDER1NList.size() == 0 ? null : psDER1NList.iterator();
   }

   @PSModelRTMeta(description = "关联删除1:N关系集合", outputdoc = "false")
   @Override
   public Iterator<IPSDER1N> getRemovePSDER1Ns() {
      Iterator<IPSDERBase> psDERBases = this.getPSDERs(true);
      if (psDERBases == null) {
         return null;
      }

      ArrayList<IPSDER1N> psDER1NList = new ArrayList<>();

      while (psDERBases.hasNext()) {
         IPSDERBase iPSDERBase = psDERBases.next();
         if (iPSDERBase instanceof IPSDER1N) {
            IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
            psDER1NList.add(iPSDER1N);
         }
      }

      if (psDER1NList.size() > 0) {
         Collections.sort(psDER1NList, new Comparator<IPSDER1N>() {
            public int compare(IPSDER1N o1, IPSDER1N o2) {
               int nRet = o1.getRemoveOrder() - o2.getRemoveOrder();
               if (nRet == 0) {
                  return 0;
               } else {
                  return nRet > 0 ? 1 : -1;
               }
            }
         });
      }

      return psDER1NList.size() == 0 ? null : psDER1NList.iterator();
   }

   @PSModelRTMeta(description = "主控1:N关系集合", outputdoc = "false")
   @Override
   public Iterator<IPSDER1N> getMasterPSDER1Ns() {
      Iterator<IPSDER1N> psDER1Ns = this.getMinorPSDER1Ns();
      if (psDER1Ns == null) {
         return null;
      }

      ArrayList<IPSDER1N> psDER1NList = new ArrayList<>();

      while (psDER1Ns.hasNext()) {
         IPSDER1N iPSDER1N = psDER1Ns.next();
         if (iPSDER1N.getMasterOrder() > 0) {
            psDER1NList.add(iPSDER1N);
         }
      }

      if (psDER1NList.size() > 0) {
         Collections.sort(psDER1NList, new Comparator<IPSDER1N>() {
            public int compare(IPSDER1N o1, IPSDER1N o2) {
               int nRet = o1.getMasterOrder() - o2.getMasterOrder();
               if (nRet == 0) {
                  return 0;
               } else {
                  return nRet > 0 ? 1 : -1;
               }
            }
         });
      }

      return psDER1NList.size() == 0 ? null : psDER1NList.iterator();
   }

   @PSModelRTMeta(description = "关联导出1:N关系集合", outputdoc = "false")
   @Override
   public Iterator<IPSDER1N> getExportPSDER1Ns() {
      ArrayList<IPSDER1N> psDER1NList = new ArrayList<>();
      Iterator<IPSDERBase> psDERBases = this.getPSDERs(true);
      if (psDERBases == null) {
         return null;
      }

      while (psDERBases.hasNext()) {
         IPSDERBase iPSDERBase = psDERBases.next();
         if (iPSDERBase instanceof IPSDER1N) {
            IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
            if (iPSDER1N.getExportModelOrder() > 0) {
               psDER1NList.add(iPSDER1N);
            }
         }
      }

      if (psDER1NList.size() > 0) {
         Collections.sort(psDER1NList, new Comparator<IPSDER1N>() {
            public int compare(IPSDER1N o1, IPSDER1N o2) {
               int nRet = o1.getExportModelOrder() - o2.getExportModelOrder();
               if (nRet == 0) {
                  return 0;
               } else {
                  return nRet > 0 ? 1 : -1;
               }
            }
         });
      }

      return psDER1NList.size() == 0 ? null : psDER1NList.iterator();
   }

   @PSModelRTMeta(description = "关联克隆1:N关系集合", outputdoc = "false")
   @Override
   public Iterator<IPSDER1N> getClonePSDER1Ns() {
      ArrayList<IPSDER1N> psDER1NList = new ArrayList<>();
      Iterator<IPSDERBase> psDERBases = this.getPSDERs(true);
      if (psDERBases == null) {
         return null;
      }

      while (psDERBases.hasNext()) {
         IPSDERBase iPSDERBase = psDERBases.next();
         if (iPSDERBase instanceof IPSDER1N) {
            IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
            if (iPSDER1N.getCloneOrder() >= 0) {
               psDER1NList.add(iPSDER1N);
            }
         }
      }

      if (psDER1NList.size() > 0) {
         Collections.sort(psDER1NList, new Comparator<IPSDER1N>() {
            public int compare(IPSDER1N o1, IPSDER1N o2) {
               int nRet = o1.getCloneOrder() - o2.getCloneOrder();
               if (nRet == 0) {
                  return 0;
               } else {
                  return nRet > 0 ? 1 : -1;
               }
            }
         });
      }

      return psDER1NList.size() == 0 ? null : psDER1NList.iterator();
   }

   @Override
   public Iterator<IPSDER1N> getTempDataPSDER1Ns(boolean bMajor) {
      ArrayList<IPSDER1N> psDER1NList = new ArrayList<>();
      Iterator<IPSDERBase> psDERBases = this.getPSDERs(bMajor);
      if (psDERBases == null) {
         return null;
      }

      while (psDERBases.hasNext()) {
         IPSDERBase iPSDERBase = psDERBases.next();
         if (iPSDERBase instanceof IPSDER1N) {
            IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
            if (iPSDER1N.getTempDataOrder() >= 0) {
               psDER1NList.add(iPSDER1N);
            }
         }
      }

      if (psDER1NList.size() > 0) {
         Collections.sort(psDER1NList, new Comparator<IPSDER1N>() {
            public int compare(IPSDER1N o1, IPSDER1N o2) {
               int nRet = o1.getTempDataOrder() - o2.getTempDataOrder();
               if (nRet == 0) {
                  return 0;
               } else {
                  return nRet > 0 ? 1 : -1;
               }
            }
         });
      }

      return psDER1NList.size() == 0 ? null : psDER1NList.iterator();
   }

   @Override
   public Iterator<IPSDERIndex> getPSDERIndexs(boolean bMajor) {
      ArrayList<IPSDERIndex> psDERIndexList = new ArrayList<>();
      Iterator<IPSDERBase> psDERBases = this.getPSDERs(bMajor);
      if (psDERBases == null) {
         return null;
      }

      while (psDERBases.hasNext()) {
         IPSDERBase iPSDERBase = psDERBases.next();
         if (iPSDERBase instanceof IPSDERIndex && !iPSDERBase.getDERType().equals("DERMULINH")) {
            psDERIndexList.add((IPSDERIndex)iPSDERBase);
         }
      }

      return psDERIndexList.size() == 0 ? null : psDERIndexList.iterator();
   }

   @Override
   public IDERBase getDER(boolean bMajor, String strDERId) throws Exception {
      return this.getPSDER(bMajor, strDERId);
   }

   @Override
   public Iterator<IDERBase> getDERs(boolean bMajor) {
      return bMajor ? this.majorPSDERGlobalModel.getDERs() : this.minorPSDERGlobalModel.getDERs();
   }

   @Override
   public IPSDERBase getPSDER(boolean bMajor, String strPSDERId, boolean bTryMode) throws Exception {
      return bMajor ? this.majorPSDERGlobalModel.FindModelHelper(strPSDERId, bTryMode) : this.minorPSDERGlobalModel.FindModelHelper(strPSDERId, bTryMode);
   }

   @PSModelRTMeta(description = "1:1关系集合", outputdoc = "false")
   @Override
   public Iterator<IPSDER11> getPSDER11s() throws Exception {
      return this.majorPSDERGlobalModel.getPSDER11s();
   }

   @Override
   public String getUserTable() {
      return "";
   }

   @Override
   public IPSDEField getPSDEField(String strDEFieldName) throws Exception {
      return this.getPSDEField(strDEFieldName, false);
   }

   @Override
   public String getDBSchema() {
      return null;
   }

   @Override
   public IDEDataSet getDEDataSet(String strDEDataSetId) throws Exception {
      return this.getPSDEDataSet(strDEDataSetId);
   }

   @Override
   public IPSDEDataQuery getPSDEDataQuery(String strDEDataQueryId) throws Exception {
      return this.psDEDataQueryGlobalModel.FindModelHelper(strDEDataQueryId);
   }

   @Override
   public IPSDEDataQuery getPSDEDataQuery(String strDEDataQueryId, boolean bTryMode) throws Exception {
      return this.psDEDataQueryGlobalModel.FindModelHelper(strDEDataQueryId, bTryMode);
   }

   @Override
   public void resetPSDEDataQuery(String strDEDataQueryId) throws Exception {
      this.psDEDataQueryGlobalModel.ResetModel(strDEDataQueryId);
   }

   @Override
   public IPSDEDataSet getPSDEDataSet(String strDEDataSetId) throws Exception {
      return this.psDEDataSetGlobalModel.FindModelHelper(strDEDataSetId);
   }

   @Override
   public IPSDEDataSet getPSDEDataSet(String strDEDataSetId, boolean bTryMode) throws Exception {
      return this.psDEDataSetGlobalModel.FindModelHelper(strDEDataSetId, bTryMode);
   }

   @Override
   public void resetPSDEDataSet(String strDEDataSetId) throws Exception {
      this.psDEDataSetGlobalModel.ResetModel(strDEDataSetId);
   }

   @PSModelRTMeta(description = "实体数据集集合", child = true, dynamodelmode = 5, group = "处理逻辑", order = 288)
   @Override
   public Iterator<IPSDEDataSet> getAllPSDEDataSets() throws Exception {
      return this.psDEDataSetGlobalModel.getAllModelHelpers();
   }

   @Override
   public ISystem getSystem() {
      return this.getPSSystem();
   }

   @Override
   public IDEField getKeyDEField() {
      return this.getKeyPSDEField();
   }

   @PSModelRTMeta(description = "逻辑名称", fields = "LOGICNAME")
   @Override
   public String getLogicName() {
      return StringHelper.isNullOrEmpty(this.psDataEntity.getLOGICNAME()) ? this.getName() : this.psDataEntity.getLOGICNAME();
   }

   @Override
   public PSACHandler getPSAjaxControlHandlerData(String strAjaxControlHandlerId) throws Exception {
      PSACHandler psACHandler = this.getPSSystem().getPSAjaxControlHandlerData(strAjaxControlHandlerId, true);
      if (psACHandler != null) {
         return psACHandler;
      } else {
         psACHandler = this.psAjaxControlHandlerGlobalModel.FindModel(strAjaxControlHandlerId);
         if (psACHandler == null) {
            throw new Exception(StringHelper.format("无法获取指定部件处理对象[%1$s]", strAjaxControlHandlerId));
         } else {
            return psACHandler;
         }
      }
   }

   @Override
   public void resetPSAjaxControlHandlerData(String strAjaxControlHandlerId) {
      this.getPSSystem().resetPSAjaxControlHandlerData(strAjaxControlHandlerId);
      this.psAjaxControlHandlerGlobalModel.ResetModel(strAjaxControlHandlerId);
   }

   @Override
   public IDEAction getDEAction(String strDEActionId) throws Exception {
      return this.getPSDEAction(strDEActionId);
   }

   @Override
   public IPSDataEntity getMasterPSDataEntity(IDataObject iDataObject) throws Exception {
      return null;
   }

   @Override
   public IPSDEDBSysProc getPSDEDBSysProc(String strDEDBSysProcId) throws Exception {
      return this.psDEDBSysProcGlobalModel.FindModelHelper(strDEDBSysProcId);
   }

   @Override
   public void resetPSDEDBSysProc(String strDEDBSysProcId) {
      this.psDEDBSysProcGlobalModel.ResetModel(strDEDBSysProcId);
   }

   @PSModelRTMeta(description = "实体行为集合", child = true, group = "处理逻辑", order = 285)
   @Override
   public Iterator<IPSDEAction> getAllPSDEActions() throws Exception {
      return this.psDEActionGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEAction getPSDEAction(String strDEActionId) throws Exception {
      return this.psDEActionGlobalModel.FindModelHelper(strDEActionId);
   }

   @Override
   public IPSDEAction getPSDEAction(String strDEActionId, boolean bTryMode) throws Exception {
      return this.psDEActionGlobalModel.FindModelHelper(strDEActionId, bTryMode);
   }

   @Override
   public void resetPSDEAction(String strDEActionId) throws Exception {
      this.psDEActionGlobalModel.ResetModel(strDEActionId);
   }

   @Override
   public IDataObject createDataObject() throws Exception {
      return new DataObject();
   }

   @PSModelRTMeta(description = "索引类型属性", hideempty = true, dumpref = true, from = "__self__")
   @Override
   public IPSDEField getIndexTypePSDEField() {
      return this.indexTypeDEField;
   }

   @PSModelRTMeta(description = "实体自动填充模式集合", child = true, ignorert = 1, dynamodelmode = 4, outputdoc = "false")
   @Override
   public Iterator<IPSDEACMode> getAllPSDEACModes() throws Exception {
      return this.psDEACModeGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEACMode getPSDEACMode(String strDEACModeId) throws Exception {
      return this.psDEACModeGlobalModel.FindModelHelper(strDEACModeId);
   }

   @Override
   public IPSDEACMode getPSDEACMode(String strDEACModeId, boolean bTryMode) throws Exception {
      return this.psDEACModeGlobalModel.FindModelHelper(strDEACModeId, bTryMode);
   }

   @Override
   public void resetPSDEACMode(String strDEACModeId) throws Exception {
      this.psDEACModeGlobalModel.ResetModel(strDEACModeId);
   }

   @Override
   public IDEACMode getDEACMode(String strACModeName) throws Exception {
      return this.getPSDEACMode(strACModeName);
   }

   @Override
   public IDEACMode getDefaultDEACMode() throws Exception {
      return this.getDefaultPSDEACModeData() != null ? this.getPSDEACMode(this.getDefaultPSDEACModeData().getPSDEACMODEID()) : this.getPSDEACMode("DEFAULT");
   }

   @Override
   public PSDEACMode getDefaultPSDEACModeData() {
      return this.defaultPSDEACModeData;
   }

   @Override
   public IPSDEDataRelation getPSDEDataRelation(String strDEDataRelationId) throws Exception {
      return this.psDEDataRelationGlobalModel.FindModelHelper(strDEDataRelationId);
   }

   @Override
   public IPSDEDataRelation getPSDEDataRelation(String strDEDataRelationId, boolean bTryMode) throws Exception {
      return this.psDEDataRelationGlobalModel.FindModelHelper(strDEDataRelationId, bTryMode);
   }

   @Override
   public void resetPSDEDataRelation(String strDEDataRelationId) throws Exception {
      this.psDEDataRelationGlobalModel.ResetModel(strDEDataRelationId);
   }

   @PSModelRTMeta(description = "实体界面关系组集合", outputdoc = "false", dynamodelmode = 4, child = true, dumpref = true)
   @Override
   public Iterator<IPSDEDataRelation> getAllPSDEDataRelations() throws Exception {
      return this.psDEDataRelationGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "实体数据关系分组集合", outputdoc = "false", dynamodelmode = 4, child = true, dumpref = true)
   @Override
   public Iterator<IPSDEDRGroup> getAllPSDEDRGroups() throws Exception {
      return this.psDEDRGroupGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEDRGroup getPSDEDRGroup(String strDEDRGroupId) throws Exception {
      return this.psDEDRGroupGlobalModel.FindModelHelper(strDEDRGroupId);
   }

   @Override
   public IPSDEDRGroup getPSDEDRGroup(String strDEDRGroupId, boolean bTryMode) throws Exception {
      return this.psDEDRGroupGlobalModel.FindModelHelper(strDEDRGroupId, bTryMode);
   }

   @Override
   public void resetPSDEDRGroup(String strDEDRGroupId) throws Exception {
      this.psDEDRGroupGlobalModel.ResetModel(strDEDRGroupId);
   }

   @PSModelRTMeta(description = "实体数据查询集合", child = true, dynamodelmode = 4, group = "处理逻辑", order = 287)
   @Override
   public Iterator<IPSDEDataQuery> getAllPSDEDataQueries() throws Exception {
      return this.psDEDataQueryGlobalModel.getAllModelHelpers();
   }

   @Override
   public IDEDataQuery getDEDataQuery(String strDEDataQueryId) throws Exception {
      return this.psDEDataQueryGlobalModel.FindModelHelper(strDEDataQueryId);
   }

   @PSModelRTMeta(description = "实体关系界面项集合", outputdoc = "false", dynamodelmode = 4, child = true, dumpref = true)
   @Override
   public Iterator<IPSDEDRItem> getAllPSDEDRItems() throws Exception {
      return this.psDEDRItemGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEDRItem getPSDEDRItem(String strDEDRItemId) throws Exception {
      return this.psDEDRItemGlobalModel.FindModelHelper(strDEDRItemId);
   }

   @Override
   public IPSDEDRItem getPSDEDRItem(String strDEDRItemId, boolean bTryMode) throws Exception {
      return this.psDEDRItemGlobalModel.FindModelHelper(strDEDRItemId, bTryMode);
   }

   @Override
   public void resetPSDEDRItem(String strDEDRItemId) throws Exception {
      this.psDEDRItemGlobalModel.ResetModel(strDEDRItemId);
   }

   @PSModelRTMeta(description = "系统模块", dumpref = true, dynamodelmode = 4, fields = "PSMODULEID")
   @Override
   public IPSSystemModule getPSSystemModule() {
      return this.iPSSystemModule;
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.onGetCodeName();
   }

   protected String onGetCodeName() {
      return this.strCodeName;
   }

   @Override
   public IDEDataSet getDEDataSet(String strName, boolean bTry) throws Exception {
      return this.psDEDataSetGlobalModel.FindModelHelper(strName, bTry);
   }

   @Override
   public IDEField getMajorDEField() {
      return this.getMajorPSDEField();
   }

   @PSModelRTMeta(description = "主实体对象集合", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<IPSDataEntity> getAllMasterPSDataEntities() throws Exception {
      return this.masterPSDataEntityList != null && this.masterPSDataEntityList.size() != 0 ? this.masterPSDataEntityList.iterator() : null;
   }

   @PSModelRTMeta(
      description = "联合键值属性集合",
      hideempty = true,
      child = true,
      dumpref = true,
      rtdump = 3,
      from = "__self__",
      dynamodelmode = 4,
      group = "模型",
      order = 291,
      doctype = "quick"
   )
   @Override
   public Iterator<IPSDEField> getUnionKeyValuePSDEFields() {
      return this.unionKeyValueFieldList != null && this.unionKeyValueFieldList.size() != 0 ? this.unionKeyValueFieldList.iterator() : null;
   }

   @Override
   public Iterator<IPSDEField> getDEMainStateDEFields() {
      return this.mainStateFieldList != null && this.mainStateFieldList.size() != 0 ? this.mainStateFieldList.iterator() : null;
   }

   @PSModelRTMeta(
      description = "主状态属性集合",
      hideempty = true,
      child = true,
      dumpref = true,
      rtdump = 3,
      from = "__self__",
      dynamodelmode = 4,
      outputdoc = "false"
   )
   @Override
   public Iterator<IPSDEField> getMainStatePSDEFields() {
      return this.mainStateFieldList != null && this.mainStateFieldList.size() != 0 ? this.mainStateFieldList.iterator() : null;
   }

   @PSModelRTMeta(description = "主状态属性", hideempty = true, group = "状态控制", order = 322)
   @Override
   public IPSDEField getMainStatePSDEField() {
      return this.mainStateFieldList != null && this.mainStateFieldList.size() != 0 ? this.mainStateFieldList.get(0) : null;
   }

   @PSModelRTMeta(description = "主状态属性2", hideempty = true, group = "状态控制", order = 324)
   @Override
   public IPSDEField getMainState2PSDEField() {
      return this.mainStateFieldList != null && this.mainStateFieldList.size() > 1 ? this.mainStateFieldList.get(1) : null;
   }

   @PSModelRTMeta(description = "主状态属性3", hideempty = true, group = "状态控制", order = 326)
   @Override
   public IPSDEField getMainState3PSDEField() {
      return this.mainStateFieldList != null && this.mainStateFieldList.size() > 2 ? this.mainStateFieldList.get(2) : null;
   }

   @Override
   public Iterator<IPSDEField> getPSDEFieldsByDER(String strDERId) throws Exception {
      ArrayList<IPSDEField> psDEFieldList = new ArrayList<>();
      Iterator<IPSDEField> deFields = this.getPSDEFields();

      while (deFields.hasNext()) {
         IPSDEField iPSDEField = deFields.next();
         if (iPSDEField.isLinkDEField()) {
            IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)iPSDEField;
            if (StringHelper.compare(iPSLinkDEField.getDERId(), strDERId, true) == 0) {
               psDEFieldList.add(iPSLinkDEField);
            }
         }
      }

      return psDEFieldList != null && psDEFieldList.size() != 0 ? psDEFieldList.iterator() : null;
   }

   @PSModelRTMeta(description = "索引实体类型", hideempty2 = true, dynamodelmode = 4, fields = "INDEXDETYPE")
   @Override
   public String getIndexDEType() {
      return this.strIndexDEType;
   }

   @Override
   public String getLogicName(String strLanguage) {
      return this.psDataEntity.getLOGICNAME();
   }

   @PSModelRTMeta(description = "实体逻辑对象集合", modeltype = "PSDELOGIC", child = true, rtdump = 1, group = "处理逻辑", order = 286)
   @Override
   public Iterator<IPSDELogic> getAllPSDELogics() throws Exception {
      return this.psDELogicGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDELogic getPSDELogic(String strDELogicId) throws Exception {
      return this.psDELogicGlobalModel.FindModelHelper(strDELogicId);
   }

   @Override
   public IPSDELogic getPSDELogic(String strDELogicId, boolean bTryMode) throws Exception {
      return this.psDELogicGlobalModel.FindModelHelper(strDELogicId, bTryMode);
   }

   @Override
   public IDELogic getDELogic(String strDELogicId) throws Exception {
      return this.getPSDELogic(strDELogicId);
   }

   @Override
   public void resetPSDELogic(String strDELogicId) throws Exception {
      this.psDELogicGlobalModel.ResetModel(strDELogicId);
   }

   @PSModelRTMeta(description = "实体主状态迁移逻辑集合", dynamodelmode = 4, child = true, dumpref = true, group = "处理逻辑", order = 289)
   @Override
   public Iterator<IPSDEMSLogic> getAllPSDEMSLogics() throws Exception {
      return this.psDEMSLogicGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEMSLogic getPSDEMSLogic(String strDEMSLogicId) throws Exception {
      return this.psDEMSLogicGlobalModel.FindModelHelper(strDEMSLogicId);
   }

   @Override
   public IPSDEMSLogic getPSDEMSLogic(String strDEMSLogicId, boolean bTryMode) throws Exception {
      return this.psDEMSLogicGlobalModel.FindModelHelper(strDEMSLogicId, bTryMode);
   }

   @Override
   public void resetPSDEMSLogic(String strDEMSLogicId) throws Exception {
      this.psDEMSLogicGlobalModel.ResetModel(strDEMSLogicId);
   }

   @PSModelRTMeta(description = "默认实体主状态迁移逻辑", outputdoc = "false")
   @Override
   public IPSDEMSLogic getDefaultPSDEMSLogic() {
      return null;
   }

   @PSModelRTMeta(
      description = "支持临时数据",
      ignoredumpvalues = "false",
      dynamodelmode = 4,
      fields = "ENATEMPDATA",
      doc = "可通过{@link #getTempDataHolder}获取临时数据处理模式"
   )
   @Override
   public boolean isEnableTempData() {
      return this.getTempDataHolder() != 0;
   }

   @Override
   public IDEUIAction getDEUIAction(String strDEUIActionId) throws Exception {
      return this.getPSDEUIAction(strDEUIActionId);
   }

   @PSModelRTMeta(description = "支持多表单", dynamodelmode = 4)
   @Override
   public boolean isEnableMultiForm() {
      return this.bEnableMultiForm;
   }

   @PSModelRTMeta(description = "表单类型属性", hideempty = true)
   @Override
   public IPSDEField getFormTypePSDEField() {
      return this.formTypeDEField;
   }

   @Override
   public PSDEViewBase getPSDEViewDataByPDT(String strPreDefineType, boolean bTryMode) throws Exception {
      PSDEViewBase psDEViewBase = this.predefineDEViewMap.get(strPreDefineType);
      if (psDEViewBase == null && !bTryMode) {
         throw new Exception(StringHelper.format("无法获取实体预置视图[%1$s]", strPreDefineType));
      } else {
         return psDEViewBase;
      }
   }

   @Override
   public PSDEViewBase getPSDEViewDataByPDT(String strPreDefineType, String strPDTParam, boolean bTryMode) throws Exception {
      String strPDViewType = strPreDefineType;
      if (!StringHelper.isNullOrEmpty(strPDTParam)) {
         strPDViewType = strPDViewType + StringHelper.format(":%1$s", strPDTParam.toUpperCase());
      }

      PSDEViewBase psDEViewBase = this.predefineDEViewMap.get(strPDViewType);
      if (psDEViewBase == null && !bTryMode) {
         throw new Exception(StringHelper.format("无法获取实体预置视图[%1$s]", strPDViewType));
      } else {
         return psDEViewBase;
      }
   }

   @Override
   public PSDEViewBase getPSDEViewDataByPDT(String strPreDefineType, String strPDTParamPre, String strPDTParam, boolean bTryMode) throws Exception {
      if (!StringHelper.isNullOrEmpty(strPDTParamPre) && !StringHelper.isNullOrEmpty(strPDTParam)) {
         PSDEViewBase psDEViewBase = this.getPSDEViewDataByPDT(strPreDefineType, strPDTParamPre + strPDTParam, true);
         if (psDEViewBase != null) {
            return psDEViewBase;
         }
      }

      return this.getPSDEViewDataByPDT(strPreDefineType, strPDTParam, bTryMode);
   }

   @Override
   public Iterator<PSDEViewBase> getPSDEViewDatasByPDT(String strPreDefineType) throws Exception {
      strPreDefineType = strPreDefineType.toUpperCase();
      String strPreDefineType2 = strPreDefineType + ":";
      ArrayList<PSDEViewBase> psDEViewBaseList = new ArrayList<>();

      for (String strKey : this.predefineDEViewMap.keySet()) {
         if (StringHelper.compare(strKey, strPreDefineType, true) == 0) {
            psDEViewBaseList.add(this.predefineDEViewMap.get(strKey));
         } else if (strKey.indexOf(strPreDefineType2) == 0) {
            psDEViewBaseList.add(this.predefineDEViewMap.get(strKey));
         }
      }

      return psDEViewBaseList.iterator();
   }

   @Override
   public Iterator<PSDEViewBase> getPDTPSDEViewDatas() {
      return this.predefineDEViewMap.values().iterator();
   }

   @Override
   public Iterator<PSDEViewBase> getAllPSDEViewDatas() {
      return this.psDEViewBaseList.iterator();
   }

   @Override
   public PSDEViewBase getPSDEViewData(String strPSDEViewBaseId, boolean bTryMode) throws Exception {
      if (this.psDEViewBaseList != null) {
         for (PSDEViewBase psDEViewBase : this.psDEViewBaseList) {
            if (StringHelper.compare(strPSDEViewBaseId, psDEViewBase.getPSDEVIEWBASEID(), false) == 0) {
               return psDEViewBase;
            }
         }
      }

      if (bTryMode) {
         return null;
      } else {
         throw new Exception(String.format("无法获取指定实体视图数据对象[%1$s]", strPSDEViewBaseId));
      }
   }

   @Override
   public Iterator<PSDEForm> getAllPSDEEditFormDatas() {
      return this.psDEEditFormList.iterator();
   }

   @Override
   public PSDEForm getPSDEEditFormData(String strPSDEEditFormId, boolean bTryMode) throws Exception {
      if (this.psDEEditFormList != null) {
         for (PSDEForm psDEEditForm : this.psDEEditFormList) {
            if (StringHelper.compare(strPSDEEditFormId, psDEEditForm.getPSDEFORMID(), false) == 0) {
               return psDEEditForm;
            }
         }
      }

      if (bTryMode) {
         return null;
      } else {
         throw new Exception(String.format("无法获取指定实体编辑表单数据对象[%1$s]", strPSDEEditFormId));
      }
   }

   @PSModelRTMeta(description = "实体类型", codelist = "DEType", dynamodelmode = 4, group = "基本", order = 125, fields = "DETYPE")
   @Override
   public int getDEType() {
      return this.psDataEntity.getDETYPE();
   }

   @PSModelRTMeta(description = "实体持有者", codelist = "DELogicHolder", ignoredumpvalues = "3", dump = false, dynamodelmode = 4, fields = "DEHOLDER")
   @Override
   public int getDEHolder() {
      return this.nDEHolder;
   }

   @PSModelRTMeta(description = "关系实体N:N关系", hideempty = true, name = "getPSDERNN")
   public IPSDERNN getPSDERNN2() throws Exception {
      return this.internalGetPSDERNN(true);
   }

   @Override
   public IPSDERNN getPSDERNN() throws Exception {
      return PSTemplHelper.isBusy() ? this.internalGetPSDERNN(true) : this.internalGetPSDERNN(false);
   }

   protected IPSDERNN internalGetPSDERNN(boolean bTryMode) throws Exception {
      if (this.iPSDERNN != null) {
         return this.iPSDERNN;
      }

      if (this.getDEType() != 3) {
         if (bTryMode) {
            return null;
         } else {
            throw new Exception(StringHelper.format("实体[%1$s]类型不是关系实体", this.getName()));
         }
      } else {
         IPSDER1NBase[] list = new IPSDER1NBase[2];
         int nIndex = 0;
         Iterator<IPSDERBase> psDER1NBases = this.getPSDERs(false);
         if (psDER1NBases != null) {
            while (psDER1NBases.hasNext()) {
               IPSDERBase iPSDERBase = psDER1NBases.next();
               if (iPSDERBase instanceof IPSDER1N) {
                  IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
                  if ((iPSDER1N.getMasterRS() & 2) > 0) {
                     list[nIndex] = iPSDER1N;
                     if (++nIndex == 2) {
                        break;
                     }
                  }
               } else if (iPSDERBase instanceof IPSDERCustom) {
                  IPSDERCustom iPSDERCustom = (IPSDERCustom)iPSDERBase;
                  if ("DER1N".equals(iPSDERCustom.getDERSubType()) && (iPSDERCustom.getMasterRS() & 2) > 0) {
                     list[nIndex] = iPSDERCustom;
                     if (++nIndex == 2) {
                        break;
                     }
                  }
               }
            }
         }

         if (nIndex != 2) {
            throw new Exception(StringHelper.format("关系实体[%1$s]必须定义2个N:N关系", this.getName()));
         }

         PSDERNNImpl psDERNNImpl = new PSDERNNImpl();
         psDERNNImpl.init(this.getDAGlobalHelper(), this, list);
         this.iPSDERNN = psDERNNImpl;
         return this.iPSDERNN;
      }
   }

   @PSModelRTMeta(description = "实体映射集合", child = true, dynamodelmode = 4, group = "处理逻辑", order = 298)
   @Override
   public Iterator<IPSDEMap> getAllPSDEMaps() throws Exception {
      return this.psDEMapGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEMap getPSDEMap(String strDEMapId) throws Exception {
      return this.psDEMapGlobalModel.FindModelHelper(strDEMapId);
   }

   @Override
   public IPSDEMap getPSDEMap(String strDEMapId, boolean bTryMode) throws Exception {
      return this.psDEMapGlobalModel.FindModelHelper(strDEMapId, bTryMode);
   }

   @Override
   public void resetPSDEMap(String strDEMapId) throws Exception {
      this.psDEMapGlobalModel.ResetModel(strDEMapId);
   }

   @PSModelRTMeta(description = "实体工作流集合", child = true, dynamodelmode = 4, group = "功能配置", order = 420)
   @Override
   public Iterator<IPSDEWF> getAllPSDEWFs() throws Exception {
      return this.psDEWFGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEWF getPSDEWF(String strWFDEId) throws Exception {
      return this.psDEWFGlobalModel.FindModelHelper(strWFDEId);
   }

   @Override
   public IDEWF getDEWF(String strDEWFId) throws Exception {
      return this.getPSDEWF(strDEWFId);
   }

   @Override
   public void resetPSDEWF(String strWFDEId) throws Exception {
      this.psDEWFGlobalModel.ResetModel(strWFDEId);
   }

   @PSModelRTMeta(description = "有实体工作流", dump = false)
   @Override
   public boolean hasPSDEWF() throws Exception {
      Iterator<IPSDEWF> psWFDEs = this.getAllPSDEWFs();
      return psWFDEs != null && psWFDEs.hasNext();
   }

   @Override
   public int getPSDEWFCount() throws Exception {
      int nCount = 0;
      Iterator<IPSDEWF> psWFDEs = this.getAllPSDEWFs();
      if (psWFDEs == null) {
         return nCount;
      }

      while (psWFDEs.hasNext()) {
         nCount++;
         psWFDEs.next();
      }

      return nCount;
   }

   @PSModelRTMeta(description = "默认实体工作流")
   @Override
   public IPSDEWF getDefaultPSDEWF() throws Exception {
      if (this.defaultPSDEWF != null) {
         return this.defaultPSDEWF;
      }

      Iterator<IPSDEWF> psWFDEs = this.getAllPSDEWFs();
      if (psWFDEs != null) {
         while (psWFDEs.hasNext()) {
            IPSDEWF iPSDEWF = psWFDEs.next();
            if (iPSDEWF.isDefaultMode()) {
               this.defaultPSDEWF = iPSDEWF;
               return this.defaultPSDEWF;
            }
         }
      }

      return null;
   }

   @PSModelRTMeta(description = "实体工作流[0]")
   @Override
   public IPSDEWF getPSDEWF0() throws Exception {
      if (this.defaultPSDEWF != null) {
         return this.defaultPSDEWF;
      }

      IPSDEWF iPSDEWF0 = null;
      Iterator<IPSDEWF> psWFDEs = this.getAllPSDEWFs();
      if (psWFDEs != null) {
         while (psWFDEs.hasNext()) {
            IPSDEWF iPSDEWF = psWFDEs.next();
            if (iPSDEWF.isDefaultMode()) {
               this.defaultPSDEWF = iPSDEWF;
               return this.defaultPSDEWF;
            }

            if (iPSDEWF0 == null) {
               iPSDEWF0 = iPSDEWF;
            }
         }
      }

      return iPSDEWF0;
   }

   @Override
   public IDEField getLogicValidDEField() {
      try {
         return this.getLogicValidPSDEField();
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @Override
   public void loadAll() throws Exception {
      Iterator<IPSSystemDBConfig> psSystemDBConfigs = this.getPSSystem().getAllPSSystemDBConfigs();
      if (psSystemDBConfigs != null) {
         boolean bTryMode = this.isSubSysDE() || !this.isEnableSQLStorage();

         while (psSystemDBConfigs.hasNext()) {
            IPSSystemDBConfig iPSSystemDBConfig = psSystemDBConfigs.next();

            try {
               IPSDEDBConfig psDEDataQueries = this.getPSDEDBConfig(iPSSystemDBConfig.getName(), bTryMode);
            } catch (Exception ex) {
               throw new Exception(StringHelper.format("获取实体数据库[%1$s]配置发生异常，%2$s", iPSSystemDBConfig.getName(), ex.getMessage()), ex);
            }
         }
      }

      Iterator<IPSDEDBConfig> psDEDBConfigs = this.psDEDBConfigGlobalModel.getAllModelHelpers();

      while (psDEDBConfigs.hasNext()) {
         IPSDEDBConfig iPSDEDBConfig = psDEDBConfigs.next();
         iPSDEDBConfig.loadAll();
      }

      Iterator<IPSDEDBTable> psDEDBTables = this.psDEDBTableGlobalModel.getAllModelHelpers();
      this.psDEACModeGlobalModel.getAllModelHelpers();
      this.majorPSDERGlobalModel.getPSDERs();
      this.minorPSDERGlobalModel.getPSDERs();
      Iterator<IPSDEDataQuery> psDEDataQueries = this.psDEDataQueryGlobalModel.getAllModelHelpers();

      while (psDEDataQueries.hasNext()) {
         IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
         iPSDEDataQuery.loadAll();
      }

      this.psDEOPPrivGlobalModel.getAllModelHelpers();
      this.psAjaxControlHandlerGlobalModel.preloadModels();
      this.psDELogicGlobalModel.getAllModelHelpers();
      this.psDEDataFlowGlobalModel.getAllModelHelpers();
      this.psDEActionGlobalModel.getAllModelHelpers();
      this.psDEDataSetGlobalModel.getAllModelHelpers();
      this.psDEFGroupGlobalModel.getAllModelHelpers();
      this.psDEDRGroupGlobalModel.getAllModelHelpers();
      this.psDEDRItemGlobalModel.getAllModelHelpers();
      this.psDEGroupGlobalModel.getAllModelHelpers();
      this.psDERGroupGlobalModel.getAllModelHelpers();
      Iterator<IPSDEMap> psDEMaps = this.psDEMapGlobalModel.getAllModelHelpers();

      while (psDEMaps.hasNext()) {
         IPSDEMap iPSDEMap = psDEMaps.next();
         iPSDEMap.getPSDEMapDetails();
      }

      this.psDEWFGlobalModel.getAllModelHelpers();
      this.psDEUIActionGlobalModel.getAllModelHelpers();
      this.psDEUIActionGroupGlobalModel.getAllModelHelpers();
      this.psDEMainStateGlobalModel.getAllModelHelpers();
      this.psDEMainStateRSGlobalModel.getAllModelHelpers();
      this.psDEDataExportGlobalModel.getAllModelHelpers();
      this.psDEDataImportGlobalModel.getAllModelHelpers();
      this.psDEDBIndexGlobalModel.getAllModelHelpers();
      this.psDEReportGlobalModel.getAllModelHelpers();
      this.psDEPrintGlobalModel.getAllModelHelpers();
      this.psDEUtilGlobalModel.getAllModelHelpers();
      this.psDEWizardGlobalModel.getAllModelHelpers();
      this.psDEDataSyncGlobalModel.getAllModelHelpers();
      this.psDEBDTableGlobalModel.getAllModelHelpers();
      this.psDEActionWizardGlobalModel.getAllModelHelpers();
      this.psDEActionWizardGroupGlobalModel.getAllModelHelpers();
      this.psDEUniStateGlobalModel.getAllModelHelpers();
      this.psDESampleDataGlobalModel.getAllModelHelpers();
      this.psDEDTSQueueGlobalModel.getAllModelHelpers();
      this.psDEServiceAPIGlobalModel.getAllModelHelpers();
      this.psDEUserRoleGlobalModel.getAllModelHelpers();
      this.psDEOPPrivRoleGlobalModel.getAllModelHelpers();
      this.psDEActionGroupGlobalModel.getAllModelHelpers();
      this.psDESearchGlobalModel.getAllModelHelpers();
      this.psDEMSLogicGlobalModel.getAllModelHelpers();
      Iterator<IPSDEDataRelation> psDEDataRelations = this.psDEDataRelationGlobalModel.getAllModelHelpers();

      while (psDEDataRelations.hasNext()) {
         IPSDEDataRelation iPSDEDataRelation = psDEDataRelations.next();
         iPSDEDataRelation.getPSDEDRDetails();
      }

      Iterator<IPSDEField> psDEFields = this.getPSDEFields();
      if (this.defHelpers != null) {
         this.getPSSystemUtil().testPSModelLimit(this, "PSDEFIELD", this.defHelpers.size());
      }

      while (psDEFields.hasNext()) {
         IPSDEField iPSDEField = psDEFields.next();
         if (!iPSDEField.isInit()) {
            iPSDEField.init();
         }

         iPSDEField.init2();
         iPSDEField.getPSCodeList();
         iPSDEField.getPSSysDBColumn();
         iPSDEField.getAllPSDEFValueRules();
         iPSDEField.getAllPSDEFSearchModes();
         iPSDEField.getAllPSDEFInputTips();
      }

      if (this.getPSSystem().isEnableModelRT()) {
         if (this.getKeyPSDEField() != null) {
            this.getKeyPSDEField().getPSDEFSearchMode(String.format("N_%1$s_EQ", this.getKeyPSDEField().getName()), false);
         }

         if (this.getUniTagPSDEField() != null) {
            this.getUniTagPSDEField().getPSDEFSearchMode(String.format("N_%1$s_EQ", this.getUniTagPSDEField().getName()), false);
         }

         Iterator<IPSDEField> unionKeyValuePSDEFields = this.getUnionKeyValuePSDEFields();
         if (unionKeyValuePSDEFields != null) {
            while (unionKeyValuePSDEFields.hasNext()) {
               IPSDEField iPSDEField = unionKeyValuePSDEFields.next();
               iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
            }
         }

         Iterator<IPSDEField> mainStatePSDEFields = this.getMainStatePSDEFields();
         if (mainStatePSDEFields != null) {
            while (mainStatePSDEFields.hasNext()) {
               IPSDEField iPSDEField = mainStatePSDEFields.next();
               iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
            }
         }

         psDEFields = this.getPSDEFields();

         while (psDEFields.hasNext()) {
            IPSDEField iPSDEField2 = psDEFields.next();
            Iterator<IPSDEField> dupCheckPSDEFields = iPSDEField2.getDupCheckPSDEFields();
            if (dupCheckPSDEFields != null) {
               while (dupCheckPSDEFields.hasNext()) {
                  IPSDEField iPSDEField = dupCheckPSDEFields.next();
                  iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
               }
            }
         }

         Iterator<IPSDERBase> psDERBases = this.getMinorPSDERs();
         if (psDERBases != null) {
            while (psDERBases.hasNext()) {
               IPSDERBase iPSDERBase = psDERBases.next();
               if (iPSDERBase instanceof IPSDER1N) {
                  IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
                  IPSDEField iPSDEField = iPSDER1N.getPickupPSDEField();
                  if (iPSDEField != null) {
                     iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
                  }
               } else if (iPSDERBase instanceof IPSDERCustom) {
                  IPSDERCustom iPSDERCustom = (IPSDERCustom)iPSDERBase;
                  IPSDEField iPSDEField = iPSDERCustom.getPickupPSDEField();
                  if (iPSDEField != null) {
                     iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
                  }
               }
            }
         }
      }

      this.getAllPSDEFValueRules();
      this.psDENotifyGlobalModel.getAllModelHelpers();
      Iterator<IPSDEAction> psDEActions = this.getAllPSDEActions();
      if (psDEActions != null) {
         while (psDEActions.hasNext()) {
            IPSDEAction iPSDEAction = psDEActions.next();
            iPSDEAction.check();
         }
      }

      psDEDataQueries = this.psDEDataQueryGlobalModel.getAllModelHelpers();

      while (psDEDataQueries.hasNext()) {
         IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
         iPSDEDataQuery.check();
      }

      Iterator<IPSDEDataSet> psDEDataSets = this.getAllPSDEDataSets();
      if (psDEDataSets != null) {
         while (psDEDataSets.hasNext()) {
            IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
            iPSDEDataSet.check();
         }
      }

      this.getDefaultPSDEMethodDTO();
      this.getDefaultPSDEFilterDTO();
      Map<String, IPSDEMethodDTO> psDEMethodDTOMap = new HashMap<>();

      boolean bLoop;
      do {
         List<IPSDEMethodDTO> list = new ArrayList<>();
         Iterator<IPSDEMethodDTO> psDEMethodDTOs = this.getAllPSDEMethodDTOs();
         if (psDEMethodDTOs != null) {
            while (psDEMethodDTOs.hasNext()) {
               IPSDEMethodDTO iPSDEMethodDTO = psDEMethodDTOs.next();
               list.add(iPSDEMethodDTO);
            }
         }

         bLoop = false;

         for (IPSDEMethodDTO iPSDEMethodDTO : list) {
            if (!psDEMethodDTOMap.containsKey(iPSDEMethodDTO.getCodeName())) {
               iPSDEMethodDTO.check();
               psDEMethodDTOMap.put(iPSDEMethodDTO.getCodeName(), iPSDEMethodDTO);
               bLoop = true;
            }
         }
      } while (bLoop);

      if (this.getPSSysDBScheme() != null && this.getPSSysDBScheme() instanceof IPSSysDBSchemeRuntime) {
         ((IPSSysDBSchemeRuntime)this.getPSSysDBScheme()).registerPSDataEntity(this);
      }

      if ((this.getMSActionLogicMode() & 1) == 1) {
         this.preparePSDEMainStateActionLogics();
      }

      if (this.isSubSysDE()) {
         if (this.getDynamicMode() == 0) {
            this.setDynamicMode(this.calcDynamicMode(2));
         }
      } else if (this.isEnableAPIStorage()) {
         if (this.getDynamicMode() == 0) {
            this.setDynamicMode(this.calcDynamicMode(2));
         }
      } else {
         this.setDynamicMode(0);
      }
   }

   protected void preparePSDEMainStateActionLogics() throws Exception {
      if (this.getMainStatePSDEField() != null && !this.getPSSystem().isEnableModelRT()) {
         Iterator<IPSDEAction> psDEActions = this.getAllPSDEActions();
         if (psDEActions != null) {
            while (psDEActions.hasNext()) {
               IPSDEAction iPSDEAction = psDEActions.next();
               ArrayList<IPSDEMainState> psDEMainStateList = new ArrayList<>();
               Iterator<IPSDEMainState> psDEMainStates = this.getAllPSDEMainStates();
               if (psDEMainStates != null) {
                  while (psDEMainStates.hasNext()) {
                     IPSDEMainState iPSDEMainState = psDEMainStates.next();
                     boolean bContainsAction = false;
                     Iterator<IPSDEMainStateAction> psDEMainStateActions = iPSDEMainState.getPSDEMainStateActions();
                     if (psDEMainStateActions != null) {
                        while (psDEMainStateActions.hasNext()) {
                           IPSDEMainStateAction iPSDEMainStateAction = psDEMainStateActions.next();
                           if (StringHelper.compare(iPSDEMainStateAction.getPSDEActionId(), iPSDEAction.getId(), false) == 0) {
                              bContainsAction = true;
                              break;
                           }
                        }
                     }

                     if (iPSDEMainState.isActionAllowMode()) {
                        if (!bContainsAction && MSCtrlActionModeMap.containsKey(iPSDEAction.getActionMode())) {
                           psDEMainStateList.add(iPSDEMainState);
                        }
                     } else if (bContainsAction) {
                        psDEMainStateList.add(iPSDEMainState);
                     }
                  }
               }

               if (psDEMainStateList.size() > 0) {
                  PSDEMainStateDenyActionLogicImpl psDEMainStateActionDenyLogicImpl = new PSDEMainStateDenyActionLogicImpl();
                  psDEMainStateActionDenyLogicImpl.init(this.getDAGlobalHelper(), iPSDEAction, psDEMainStateList);
                  this.psDELogicGlobalModel.appendAllModelHelpers(psDEMainStateActionDenyLogicImpl);
                  ((IPSDEActionRuntime)iPSDEAction).registerPSDEActionLogic(psDEMainStateActionDenyLogicImpl);
               }
            }
         }
      }
   }

   @PSModelRTMeta(description = "默认数据源", codelist = "SysDeployDBMode", dynamodelmode = 4, group = "数据库存储", order = 375, fields = "DSLINK")
   @Override
   public String getDSLink() {
      return this.strDSLink;
   }

   @Override
   public String getTableSpaceId() {
      return this.strDBTableSpaceId;
   }

   @PSModelRTMeta(description = "同时支持多数据源", dynamodelmode = 4, group = "数据库存储", order = 378)
   @Override
   public boolean isEnableMultiDS() {
      return this.bEnableMultiDS;
   }

   @PSModelRTMeta(description = "实体操作标识集合", child = true, dynamodelmode = 4, group = "访问控制", order = 510)
   @Override
   public Iterator<IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception {
      return this.psDEOPPrivGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEOPPriv getPSDEOPPriv(String strDEOPPrivId) throws Exception {
      IPSDEOPPriv iPSDEOPPriv = this.psDEOPPrivGlobalModel.FindModelHelper(strDEOPPrivId, true);
      return iPSDEOPPriv != null ? iPSDEOPPriv : this.getPSSystem().getPSDEOPPriv(strDEOPPrivId);
   }

   @Override
   public IPSDEOPPriv getPSDEOPPriv(String strDEOPPrivId, boolean bTryMode) throws Exception {
      IPSDEOPPriv iPSDEOPPriv = this.psDEOPPrivGlobalModel.FindModelHelper(strDEOPPrivId, true);
      if (iPSDEOPPriv == null) {
         return this.getPSSystem().getPSDEOPPriv(strDEOPPrivId, bTryMode);
      }

      if (!strDEOPPrivId.equals(iPSDEOPPriv.getId()) && iPSDEOPPriv.getMapPSDataEntity() != null) {
         Iterator<IPSDEOPPriv> psDEOPPrivs = this.psDEOPPrivGlobalModel.getAllModelHelpers();
         if (psDEOPPrivs != null) {
            while (psDEOPPrivs.hasNext()) {
               IPSDEOPPriv iPSDEOPPriv2 = psDEOPPrivs.next();
               if (iPSDEOPPriv2.getMapPSDataEntity() == null && strDEOPPrivId.equals(iPSDEOPPriv2.getName())) {
                  return iPSDEOPPriv2;
               }
            }
         }
      }

      return iPSDEOPPriv;
   }

   @Override
   public void resetPSDEOPPriv(String strDEOPPrivId) throws Exception {
      this.getPSSystem().resetPSDEOPPriv(strDEOPPrivId);
   }

   @PSModelRTMeta(description = "实体主状态集合", child = true, dynamodelmode = 4, group = "状态控制", order = 335)
   @Override
   public Iterator<IPSDEMainState> getAllPSDEMainStates() throws Exception {
      return this.psDEMainStateGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEMainState getPSDEMainState(String strDEMainStateId) throws Exception {
      return this.psDEMainStateGlobalModel.FindModelHelper(strDEMainStateId);
   }

   @Override
   public IPSDEMainState getPSDEMainState(String strDEMainStateId, boolean bTryMode) throws Exception {
      return this.psDEMainStateGlobalModel.FindModelHelper(strDEMainStateId, bTryMode);
   }

   @Override
   public void resetPSDEMainState(String strDEMainStateId) throws Exception {
      this.psDEMainStateGlobalModel.ResetModel(strDEMainStateId);
   }

   @PSModelRTMeta(description = "实体主状态关系集合", outputdoc = "false")
   @Override
   public Iterator<IPSDEMainStateRS> getAllPSDEMainStateRSs() throws Exception {
      return this.psDEMainStateRSGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "现有模型", dump = false, group = "数据库存储", order = 372)
   @Override
   public boolean isExistingModel() {
      return this.bExistingModel;
   }

   @PSModelRTMeta(description = "附加组织模型", dump = false)
   @Override
   public boolean isEnableOrgModel() {
      return this.bEnableOrgModel;
   }

   @Override
   public IDEMainState getDEMainState(ISimpleDataObject iSimpleDataObject) throws Exception {
      return null;
   }

   @Override
   public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
      String strPKGName = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, this.classOrPkgNameMap, "PKG", iPSSysSFPub);
      String strNameFormat = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, this.classOrPkgNameMap, strCodeType, iPSSysSFPub);
      if (StringHelper.isNullOrEmpty(strNameFormat)) {
         throw new Exception(StringHelper.format("无法获取实体[%1$s]代码类型[%2$s]代码名称", this.getFullName(), strCodeType));
      }

      String strModuleName = "";
      if (this.getPSSystemModule() != null) {
         strModuleName = this.getPSSystemModule().getCodeName();
      }

      if (this.isSubSysDE() && this.getDynamicMode() == 2 && strCodeType.indexOf("SUBSYS_") != 0) {
         String strNameFormat2 = PSSFCodeObjectHelper.getClassOrPkgName(this, null, this.classOrPkgNameMap, "SUBSYS_" + strCodeType, iPSSysSFPub);
         if (!StringHelper.isNullOrEmpty(strNameFormat2)) {
            strModuleName = "SubSys";
            strPKGName = "";
         }
      }

      if (StringHelper.isNullOrEmpty(strPKGName)) {
         strPKGName = iPSSysSFPub.getPKGCodeName();
      }

      if (iPSSysSFPub.getPSSFStyle().getPSSF().isPkgLowercase()) {
         strModuleName = strModuleName.toLowerCase();
      }

      return StringHelper.format(strNameFormat, strPKGName, strModuleName, this.getCodeName());
   }

   @PSModelRTMeta(description = "子系统实体", ignoredumpvalues = "false", dynamodelmode = 4, doc = "由所属模块决定")
   @Override
   public boolean isSubSysDE() {
      return this.bSubSysDE;
   }

   @Override
   public IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId) throws Exception {
      return this.getPSDEFValueRule(strPSDEFValueRuleId, false);
   }

   @Override
   public IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId, boolean bTryMode) throws Exception {
      this.preparePSDEFValueRules();
      IPSDEFValueRule iPSDEFValueRule = this.psDEFValueRuleMap.get(strPSDEFValueRuleId);
      if (iPSDEFValueRule == null) {
         if (bTryMode) {
            return null;
         } else {
            throw new Exception(StringHelper.format("实体[%1$s]无法获取指定值规则[%2$s]", this.getName(), strPSDEFValueRuleId));
         }
      } else {
         return iPSDEFValueRule;
      }
   }

   @PSModelRTMeta(description = "属性值规则集合", group = "处理逻辑", order = 295)
   @Override
   public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception {
      this.preparePSDEFValueRules();
      return this.psDEFValueRuleList.iterator();
   }

   private synchronized void preparePSDEFValueRules() throws Exception {
      if (this.psDEFValueRuleMap == null || this.psDEFValueRuleList == null) {
         Map<String, IPSDEFValueRule> psDEFValueRuleMap = new LinkedHashMap<>();
         ArrayList<IPSDEFValueRule> psDEFValueRuleList = new ArrayList<>();

         for (IPSDEField iPSDEField : this.defHelpers) {
            Iterator<IPSDEFValueRule> psDEFValueRules = iPSDEField.getAllPSDEFValueRules();
            if (psDEFValueRules != null) {
               while (psDEFValueRules.hasNext()) {
                  IPSDEFValueRule iPSDEFValueRule = psDEFValueRules.next();
                  psDEFValueRuleMap.put(iPSDEFValueRule.getId(), iPSDEFValueRule);
                  psDEFValueRuleList.add(iPSDEFValueRule);
               }
            }
         }

         this.psDEFValueRuleMap = psDEFValueRuleMap;
         this.psDEFValueRuleList = psDEFValueRuleList;
      }
   }

   @PSModelRTMeta(description = "实体测试用例集合", child = true, dumpref = true, ignorert = 3, dynamodelmode = 4, group = "测试", order = 555)
   @Override
   public Iterator<IPSSysTestCase> getAllPSSysTestCases() throws Exception {
      Iterator<IPSSysTestCase> psSysTestCases = this.getPSSystem().getAllPSSysTestCases();
      if (psSysTestCases == null) {
         return null;
      }

      ArrayList<IPSSysTestCase> psSysTestCaseList = new ArrayList<>();

      while (psSysTestCases.hasNext()) {
         IPSSysTestCase iPSSysTestCase = psSysTestCases.next();
         if (iPSSysTestCase.getPSDataEntity() != null && StringHelper.compare(iPSSysTestCase.getPSDataEntity().getId(), this.getId(), false) == 0) {
            psSysTestCaseList.add(iPSSysTestCase);
         }
      }

      return psSysTestCaseList.size() == 0 ? null : psSysTestCaseList.iterator();
   }

   @PSModelRTMeta(description = "实体测试数据集合", child = true, dumpref = true, ignorert = 3, dynamodelmode = 4, group = "测试", order = 556)
   @Override
   public Iterator<IPSSysTestData> getAllPSSysTestDatas() throws Exception {
      Iterator<IPSSysTestData> psSysTestDatas = this.getPSSystem().getAllPSSysTestDatas();
      if (psSysTestDatas == null) {
         return null;
      }

      ArrayList<IPSSysTestData> psSysTestDataList = new ArrayList<>();

      while (psSysTestDatas.hasNext()) {
         IPSSysTestData iPSSysTestData = psSysTestDatas.next();
         if (iPSSysTestData.getPSDataEntity() != null && StringHelper.compare(iPSSysTestData.getPSDataEntity().getId(), this.getId(), false) == 0) {
            psSysTestDataList.add(iPSSysTestData);
         }
      }

      return psSysTestDataList.size() == 0 ? null : psSysTestDataList.iterator();
   }

   @Override
   public boolean isEnableDEMainState() {
      return this.mainStateFieldList != null && this.mainStateFieldList.size() != 0;
   }

   @PSModelRTMeta(description = "实体数据访问控制方式", codelist = "DEDataAccCtrlMode", dynamodelmode = 4, group = "访问控制", order = 503, fields = "DATAACCMODE")
   @Override
   public int getDataAccCtrlMode() {
      return this.nDataAccCtrlMode;
   }

   @PSModelRTMeta(
      description = "审计模式",
      codelist = "DEDataAuditMode",
      dynamodelmode = 4,
      ignoredumpvalues = "0",
      group = "访问控制",
      order = 505,
      fields = "AUDITMODE"
   )
   @Override
   public int getAuditMode() {
      return this.nAuditMode;
   }

   @PSModelRTMeta(description = "实体图标对象", dump = false)
   @Override
   public IPSSysImage getPSSysImage() {
      return this.iPSSysImage;
   }

   @Override
   public void checkDataEntity() throws Exception {
      this.onCheckDataEntity();
   }

   protected void onCheckDataEntity() throws Exception {
      if (!StringHelper.isNullOrEmpty(this.getIndexDEType()) && this.getIndexTypePSDEField() == null) {
         throw new Exception(StringHelper.format("实体[%1$s]定义了索引/继承模式，但未定义索引属性", this.getName()));
      }

      if (!StringHelper.isNullOrEmpty(this.getIndexDEType()) && this.getIndexTypePSDEField().getPSCodeList() == null) {
         throw new Exception(StringHelper.format("实体[%1$s]定义了索引/继承模式，但未定义索引属性的代码表", this.getName()));
      }

      if (this.isEnableMultiForm() && this.getFormTypePSDEField() == null) {
         throw new Exception(StringHelper.format("实体[%1$s]定义了多表单模式，但未定义表单识别属性", this.getName()));
      }

      if (this.isEnableMultiForm() && this.getFormTypePSDEField().getPSCodeList() == null) {
         throw new Exception(StringHelper.format("实体[%1$s]定义了多表单模式，但未定义表单识别属性的代码表", this.getName()));
      }

      if (this.getVirtualMode() == 2 && this.getInheritPSDataEntity() == null) {
         throw new Exception(StringHelper.format("实体[%1$s]定义了继承虚拟模式，但未指定继承实体", this.getName()));
      }

      if (this.getDEType() == 3) {
         this.getPSDERNN();
      }

      if (this.getDEType() == 4) {
         if (this.getPSDEFieldByPDT("PARENTTYPE", true) == null) {
            throw new Exception(StringHelper.format("实体[%1$s]类型为动态附属实体，但未指定动态父类型存储属性", this.getName()));
         }

         if (this.getPSDEFieldByPDT("PARENTID", true) == null) {
            throw new Exception(StringHelper.format("实体[%1$s]类型为动态附属实体，但未指定动态父标识存储属性", this.getName()));
         }
      }
   }

   @Override
   public Iterator<String> getPDTViewNames() {
      return this.predefineDEViewMap.size() == 0 ? null : this.predefineDEViewMap.keySet().iterator();
   }

   @Override
   public String getPSDEViewIdByPDT(String strPDTName) throws Exception {
      return this.getPSDEViewDataByPDT(strPDTName, false).getPSDEVIEWBASEID();
   }

   @Override
   public ArrayList<PSDEViewBase> getSDPSDEViewDataList(boolean bIncWFView) throws Exception {
      return this.getSDPSDEViewDataList(bIncWFView, false);
   }

   @Override
   public ArrayList<PSDEViewBase> getSDPSDEViewDataList(boolean bIncWFView, boolean bMobile) throws Exception {
      ArrayList<PSDEViewBase> list = new ArrayList<>();
      Iterator<IPSDERIndex> psDERIndexs = this.getPSDERIndexs(true);
      if (psDERIndexs == null) {
         boolean bDynaInstMode = this.getPSSystemDynaInstMode() != 0;
         if (bMobile) {
            String[] var20 = MOBSDPDTVIEWS;
            int var18 = MOBSDPDTVIEWS.length;

            for (int var16 = 0; var16 < var18; var16++) {
               String strPDTType = var20[var16];
               boolean bWFMode = StringHelper.compare(strPDTType, "MOBWFEDITVIEW", false) == 0;
               if (bIncWFView || !bWFMode) {
                  Iterator<PSDEViewBase> psDEViewBases = this.getPSDEViewDatasByPDT(strPDTType);
                  if (psDEViewBases != null) {
                     while (psDEViewBases.hasNext()) {
                        PSDEViewBase psDEViewBase = psDEViewBases.next();
                        if (!bDynaInstMode || !bWFMode || DynaInstWFEditViewMap.containsKey(psDEViewBase.getPSDEVIEWBASETYPE())) {
                           list.add(psDEViewBase);
                        }
                     }
                  }
               }
            }
         } else {
            String[] var21 = SDPDTVIEWS;
            int var19 = SDPDTVIEWS.length;

            for (int var17 = 0; var17 < var19; var17++) {
               String strPDTType = var21[var17];
               boolean bWFMode = StringHelper.compare(strPDTType, "WFEDITVIEW", false) == 0;
               if (bIncWFView || !bWFMode) {
                  Iterator<PSDEViewBase> psDEViewBases = this.getPSDEViewDatasByPDT(strPDTType);
                  if (psDEViewBases != null) {
                     while (psDEViewBases.hasNext()) {
                        PSDEViewBase psDEViewBase = psDEViewBases.next();
                        if (!bDynaInstMode || !bWFMode || DynaInstWFEditViewMap.containsKey(psDEViewBase.getPSDEVIEWBASETYPE())) {
                           list.add(psDEViewBase);
                        }
                     }
                  }
               }
            }
         }
      } else {
         while (psDERIndexs.hasNext()) {
            IPSDERIndex iPSDERIndex = psDERIndexs.next();
            IPSDataEntity minorPSDataEntity = this.getPSSystem().getPSDataEntity2(iPSDERIndex.getMinorPSDEId());
            if (minorPSDataEntity.getVirtualMode() == 0) {
               for (PSDEViewBase psDEViewBase : minorPSDataEntity.getSDPSDEViewDataList(bIncWFView, bMobile)) {
                  PSDEViewBase psDEViewBase2 = new PSDEViewBase();
                  psDEViewBase.CopyTo(psDEViewBase2, false);
                  psDEViewBase2.set("SRFDATATYPE", iPSDERIndex.getTypeValue());
                  psDEViewBase2.set("SRFDERID", iPSDERIndex.getId());
                  psDEViewBase2.set("SRFDERNAME", iPSDERIndex.getName());
                  psDEViewBase2.set("SRFDERTYPE", iPSDERIndex.getDERType());
                  psDEViewBase2.set("SRFMINORDEID", minorPSDataEntity.getId());
                  psDEViewBase2.set("SRFMINORDENAME", minorPSDataEntity.getName());
                  list.add(psDEViewBase2);
               }
            }
         }
      }

      return list;
   }

   @Override
   public IDERIndex getDERIndex(boolean bMajor, String strIndexValue) throws Exception {
      Iterator<IDERBase> derBases = this.getDERs(bMajor);
      if (derBases != null) {
         while (derBases.hasNext()) {
            IDERBase iDERBase = derBases.next();
            if (iDERBase instanceof IDERIndex) {
               IDERIndex iDERIndex = (IDERIndex)iDERBase;
               if (StringHelper.compare(iDERIndex.getTypeValue(), strIndexValue, true) == 0) {
                  return iDERIndex;
               }
            }
         }
      }

      throw new Exception(StringHelper.format("无法获取实体[%1$s]类型值[%2$s]索引关系[%3$s]", this.getName(), strIndexValue, bMajor));
   }

   @PSModelRTMeta(description = "数据库索引集合", group = "数据库存储", order = 391, child = true, dynamodelmode = 4)
   @Override
   public Iterator<IPSDEDBIndex> getAllPSDEDBIndices() throws Exception {
      return this.psDEDBIndexGlobalModel.getAllModelHelpers();
   }

   @Override
   public Iterator<IPSDEDBIndex> getAllPSDEDBIndexs() throws Exception {
      return this.getAllPSDEDBIndices();
   }

   @Override
   public IPSDEDBIndex getPSDEDBIndex(String strDEDBIndexId) throws Exception {
      return this.psDEDBIndexGlobalModel.FindModelHelper(strDEDBIndexId);
   }

   @Override
   public IPSDEDBIndex getPSDEDBIndex(String strDEDBIndexId, boolean bTryMode) throws Exception {
      return this.psDEDBIndexGlobalModel.FindModelHelper(strDEDBIndexId, bTryMode);
   }

   @Override
   public void resetPSDEDBIndex(String strDEDBIndexId) throws Exception {
      this.psDEDBIndexGlobalModel.ResetModel(strDEDBIndexId);
   }

   @Override
   public IDataEntity getInheritDataEntity() throws Exception {
      return this.getInheritPSDataEntity();
   }

   @PSModelRTMeta(description = "实体报表集合", child = true, dynamodelmode = 5, group = "打印及报表", order = 472)
   @Override
   public Iterator<IPSDEReport> getAllPSDEReports() throws Exception {
      return this.psDEReportGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEReport getPSDEReport(String strDEReportId) throws Exception {
      return this.psDEReportGlobalModel.FindModelHelper(strDEReportId);
   }

   @Override
   public IPSDEReport getPSDEReport(String strDEReportId, boolean bTryMode) throws Exception {
      return this.psDEReportGlobalModel.FindModelHelper(strDEReportId, bTryMode);
   }

   @Override
   public void resetPSDEReport(String strDEReportId) throws Exception {
      this.psDEReportGlobalModel.ResetModel(strDEReportId);
   }

   @Override
   public int getDynamicMode() {
      return this.nDynamicMode;
   }

   @PSModelRTMeta(description = "扩展模式", codelist = "DEExtendMode", dynamodelmode = 4)
   @Override
   public int getExtendMode() {
      return this.nDynamicMode;
   }

   protected void setDynamicMode(int nDynamicMode) {
      this.nDynamicMode = nDynamicMode;
   }

   @Override
   public String getMapDEOPPrivTag(String strDEOPPrivTag, String strDERName) {
      return null;
   }

   @PSModelRTMeta(description = "实体打印集合", child = true, dynamodelmode = 5, group = "打印及报表", order = 470)
   @Override
   public Iterator<IPSDEPrint> getAllPSDEPrints() throws Exception {
      return this.psDEPrintGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEPrint getPSDEPrint(String strDEPrintId) throws Exception {
      return this.psDEPrintGlobalModel.FindModelHelper(strDEPrintId);
   }

   @Override
   public IPSDEPrint getPSDEPrint(String strDEPrintId, boolean bTryMode) throws Exception {
      return this.psDEPrintGlobalModel.FindModelHelper(strDEPrintId, bTryMode);
   }

   @Override
   public void resetPSDEPrint(String strDEPrintId) throws Exception {
      this.psDEPrintGlobalModel.ResetModel(strDEPrintId);
   }

   @PSModelRTMeta(description = "默认实体打印")
   @Override
   public IPSDEPrint getDefaultPSDEPrint() throws Exception {
      return this.getDefaultPSDEPrintData() != null ? this.getPSDEPrint(this.getDefaultPSDEPrintData().getPSDEPRINTID()) : this.getPSDEPrint("DEFAULT", true);
   }

   public PSDEPrint getDefaultPSDEPrintData() {
      return this.defaultPSDEPrintData;
   }

   @PSModelRTMeta(description = "有实体打印", dump = false)
   @Override
   public boolean hasPSDEPrint() throws Exception {
      return this.defaultPSDEPrintData != null;
   }

   @Override
   public Iterator<IPSDEViewLogic> getAllPSDEViewLogics() throws Exception {
      return this.psDEViewLogicGlobalModel.getAllModelHelpers();
   }

   @Override
   public void resetPSDEViewLogic(String strDEViewLogicId) throws Exception {
      this.psDEViewLogicGlobalModel.ResetModel(strDEViewLogicId);
   }

   @Override
   public IPSDEViewLogic getPSDEViewLogic(String strDEViewLogicId) throws Exception {
      return this.psDEViewLogicGlobalModel.FindModelHelper(strDEViewLogicId);
   }

   @Override
   public IPSDEViewLogic getPSDEViewLogic(String strDEViewLogicId, boolean bTryMode) throws Exception {
      return this.psDEViewLogicGlobalModel.FindModelHelper(strDEViewLogicId, bTryMode);
   }

   protected int calcDynamicMode(int nCheckExtendMode) throws Exception {
      if (nCheckExtendMode == 2 && !this.isSubSysDE() && !this.isEnableAPIStorage()) {
         return 0;
      }

      Iterator<IPSDEDataQuery> psDEDataQueries = this.getAllPSDEDataQueries();

      while (psDEDataQueries.hasNext()) {
         IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
         if (iPSDEDataQuery.getExtendMode() == nCheckExtendMode) {
            return nCheckExtendMode;
         }
      }

      Iterator<IPSDEDataSet> psDEDataSets = this.getAllPSDEDataSets();

      while (psDEDataSets.hasNext()) {
         IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
         if (iPSDEDataSet.getExtendMode() == nCheckExtendMode) {
            return nCheckExtendMode;
         }
      }

      Iterator<IPSDEACMode> psDEACModes = this.getAllPSDEACModes();

      while (psDEACModes.hasNext()) {
         IPSDEACMode iPSDEACMode = psDEACModes.next();
         if (iPSDEACMode.getExtendMode() == nCheckExtendMode) {
            return nCheckExtendMode;
         }
      }

      Iterator<IPSDELogic> psDELogics = this.getAllPSDELogics();

      while (psDELogics.hasNext()) {
         IPSDELogic iPSDELogic = psDELogics.next();
         if (iPSDELogic.getExtendMode() == nCheckExtendMode) {
            return nCheckExtendMode;
         }
      }

      Iterator<IPSDEField> psDEFields = this.getAllPSDEFields();

      while (psDEFields.hasNext()) {
         IPSDEField iPSDEField = psDEFields.next();
         Iterator<IPSDEFSearchMode> psDEFSearchModes = iPSDEField.getAllPSDEFSearchModes();
         if (psDEFSearchModes != null) {
            while (psDEFSearchModes.hasNext()) {
               IPSDEFSearchMode iPSDEFSearchMode = psDEFSearchModes.next();
               if (iPSDEFSearchMode.getExtendMode() == nCheckExtendMode) {
                  return nCheckExtendMode;
               }
            }
         }
      }

      Iterator<IPSDEUIAction> psDEUIActions = this.getAllPSDEUIActions();

      while (psDEUIActions.hasNext()) {
         IPSDEUIAction iPSDEUIAction = psDEUIActions.next();
         if (iPSDEUIAction.getExtendMode() == nCheckExtendMode) {
            return nCheckExtendMode;
         }
      }

      Iterator<IPSDEAction> psDEActions = this.getAllPSDEActions();

      while (psDEActions.hasNext()) {
         IPSDEAction iPSDEAction = psDEActions.next();
         if (iPSDEAction.getExtendMode() == nCheckExtendMode) {
            return nCheckExtendMode;
         }
      }

      Iterator<IPSDEReport> psDEReports = this.getAllPSDEReports();

      while (psDEReports.hasNext()) {
         IPSDEReport iPSDEReport = psDEReports.next();
         if (iPSDEReport.getExtendMode() == nCheckExtendMode) {
            return nCheckExtendMode;
         }
      }

      Iterator<IPSDEPrint> psDEPrints = this.getAllPSDEPrints();

      while (psDEPrints.hasNext()) {
         IPSDEPrint iPSDEPrint = psDEPrints.next();
         if (iPSDEPrint.getExtendMode() == nCheckExtendMode) {
            return nCheckExtendMode;
         }
      }

      Iterator<IPSDEUtil> psDEUtils = this.getAllPSDEUtils();

      while (psDEUtils.hasNext()) {
         IPSDEUtil iPSDEUtil = psDEUtils.next();
         if (iPSDEUtil.getExtendMode() == nCheckExtendMode) {
            return nCheckExtendMode;
         }
      }

      return 0;
   }

   @Override
   public boolean hasDefaultDEActionTestUnit() {
      return this.bDefaultDEActionTestUnit;
   }

   @Override
   public String getXmlTagName() {
      return this.strXmlTagName;
   }

   @Override
   public String getModelType() {
      return "PSDATAENTITY";
   }

   @PSModelRTMeta(description = "实体向导集合", outputdoc = "false")
   @Override
   public Iterator<IPSDEWizard> getAllPSDEWizards() throws Exception {
      return this.psDEWizardGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEWizard getPSDEWizard(String strDEWizardId) throws Exception {
      return this.psDEWizardGlobalModel.FindModelHelper(strDEWizardId);
   }

   @Override
   public IPSDEWizard getPSDEWizard(String strDEWizardId, boolean bTryMode) throws Exception {
      return this.psDEWizardGlobalModel.FindModelHelper(strDEWizardId, bTryMode);
   }

   @Override
   public void resetPSDEWizard(String strDEWizardId) throws Exception {
      this.psDEWizardGlobalModel.ResetModel(strDEWizardId);
   }

   @PSModelRTMeta(description = "实体数据同步集合", child = true, dynamodelmode = 5, group = "处理逻辑", order = 300)
   @Override
   public Iterator<IPSDEDataSync> getAllPSDEDataSyncs() throws Exception {
      return this.psDEDataSyncGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEDataSync getPSDEDataSync(String strDEDataSyncId) throws Exception {
      return this.psDEDataSyncGlobalModel.FindModelHelper(strDEDataSyncId);
   }

   @Override
   public IPSDEDataSync getPSDEDataSync(String strDEDataSyncId, boolean bTryMode) throws Exception {
      return this.psDEDataSyncGlobalModel.FindModelHelper(strDEDataSyncId, bTryMode);
   }

   @Override
   public void resetPSDEDataSync(String strDEDataSyncId) throws Exception {
      this.psDEDataSyncGlobalModel.ResetModel(strDEDataSyncId);
   }

   @PSModelRTMeta(description = "实体数据变化日志模式", codelist = "DEDataChgLogMode", dynamodelmode = 4, fields = "DATACHGLOGMODE")
   @Override
   public int getDataChangeLogMode() {
      return this.nDataChangeLogMode;
   }

   @Override
   public Iterator<IDEDataSync> getDEDataSyncs(boolean bIn) {
      return null;
   }

   @PSModelRTMeta(description = "实体1:1关系", hideempty = true)
   @Override
   public IPSDER11 getPSDER11() throws Exception {
      return this.minorPSDERGlobalModel.getPSDER11();
   }

   @PSModelRTMeta(description = "虚拟实体", dynamodelmode = 4, ignoredumpvalues = "false", fields = "VIRTUALFLAG")
   @Override
   public boolean isVirtual() {
      return this.bVirtual;
   }

   @Override
   public Iterator<IPSDERMultiInherit> getPSDERMultiInherits(boolean bMajor) throws Exception {
      return bMajor ? this.majorPSDERGlobalModel.getPSDERMultiInherits() : this.minorPSDERGlobalModel.getPSDERMultiInherits();
   }

   @PSModelRTMeta(description = "无视图模式", dump = false, group = "数据库存储", fields = "NOVIEWMODE")
   @Override
   public boolean isNoViewMode() {
      return this.bNoViewMode || this.getSaaSMode() != IPSDataEntity.SAASMODE_NOTSUPPORTED;
   }

   @Override
   public IDEDataQuery getDefaultDEDataQuery() {
      return this.psDEDataQueryGlobalModel.getDefaultPSDEDataQuery();
   }

   @PSModelRTMeta(description = "实体大数据表集合", group = "功能配置", order = 429)
   @Override
   public Iterator<IPSDEBDTable> getAllPSDEBDTables() throws Exception {
      return this.psDEBDTableGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEBDTable getPSDEBDTable(String strDEBDTableId) throws Exception {
      return this.psDEBDTableGlobalModel.FindModelHelper(strDEBDTableId);
   }

   @Override
   public void resetPSDEBDTable(String strDEBDTableId) throws Exception {
      this.psDEBDTableGlobalModel.ResetModel(strDEBDTableId);
   }

   @PSModelRTMeta(description = "默认存储模式", codelist = "DEStorageType", dynamodelmode = 4, group = "持久化", fields = "STORAGEMODE")
   @Override
   public int getStorageMode() {
      return this.nStorageMode;
   }

   @PSModelRTMeta(description = "实体数据导出集合", child = true, dynamodelmode = 5, group = "处理逻辑", order = 292)
   @Override
   public Iterator<IPSDEDataExport> getAllPSDEDataExports() throws Exception {
      return this.psDEDataExportGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEDataExport getPSDEDataExport(String strDEDataExportId) throws Exception {
      return this.psDEDataExportGlobalModel.FindModelHelper(strDEDataExportId);
   }

   @Override
   public IPSDEDataExport getPSDEDataExport(String strDEDataExportId, boolean bTryMode) throws Exception {
      return this.psDEDataExportGlobalModel.FindModelHelper(strDEDataExportId, bTryMode);
   }

   @Override
   public void resetPSDEDataExport(String strDEDataExportId) throws Exception {
      this.psDEDataExportGlobalModel.ResetModel(strDEDataExportId);
   }

   @Override
   public IDEDataExport getDEDataExport(String strDEDataExportId) throws Exception {
      return this.getPSDEDataExport(strDEDataExportId);
   }

   @PSModelRTMeta(description = "实体数据导入集合", child = true, dynamodelmode = 5, group = "处理逻辑", order = 291)
   @Override
   public Iterator<IPSDEDataImport> getAllPSDEDataImports() throws Exception {
      return this.psDEDataImportGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEDataImport getPSDEDataImport(String strDEDataImportId) throws Exception {
      return this.psDEDataImportGlobalModel.FindModelHelper(strDEDataImportId);
   }

   @Override
   public IPSDEDataImport getPSDEDataImport(String strDEDataImportId, boolean bTryMode) throws Exception {
      return this.psDEDataImportGlobalModel.FindModelHelper(strDEDataImportId, bTryMode);
   }

   @Override
   public void resetPSDEDataImport(String strDEDataImportId) throws Exception {
      this.psDEDataImportGlobalModel.ResetModel(strDEDataImportId);
   }

   @Override
   public IDEDataImport getDEDataImport(String strDEDataImportId) throws Exception {
      return this.getPSDEDataImport(strDEDataImportId);
   }

   @Override
   public IDEDataImport getDefaultDEDataImport() {
      return this.psDEDataImportGlobalModel.getDefaultPSDEDataImport();
   }

   @Override
   public Iterator<IPSDEActionWizard> getAllPSDEActionWizards() throws Exception {
      return this.psDEActionWizardGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEActionWizard getPSDEActionWizard(String strDEActionWizardId) throws Exception {
      return this.psDEActionWizardGlobalModel.FindModelHelper(strDEActionWizardId);
   }

   @Override
   public IPSDEActionWizard getPSDEActionWizard(String strDEActionWizardId, boolean bTryMode) throws Exception {
      return this.psDEActionWizardGlobalModel.FindModelHelper(strDEActionWizardId, bTryMode);
   }

   @Override
   public void resetPSDEActionWizard(String strDEActionWizardId) throws Exception {
      this.psDEActionWizardGlobalModel.ResetModel(strDEActionWizardId);
   }

   @Override
   public Iterator<IPSDEActionWizardGroup> getAllPSDEActionWizardGroups() throws Exception {
      return this.psDEActionWizardGroupGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEActionWizardGroup getPSDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception {
      return this.psDEActionWizardGroupGlobalModel.FindModelHelper(strDEActionWizardGroupId);
   }

   @Override
   public IPSDEActionWizardGroup getPSDEActionWizardGroup(String strDEActionWizardGroupId, boolean bTryMode) throws Exception {
      return this.psDEActionWizardGroupGlobalModel.FindModelHelper(strDEActionWizardGroupId, bTryMode);
   }

   @Override
   public void resetPSDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception {
      this.psDEActionWizardGroupGlobalModel.ResetModel(strDEActionWizardGroupId);
   }

   @Override
   public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception {
      return this.psDEActionWizardGroupGlobalModel.FindModelHelper(strDEActionWizardGroupId);
   }

   @Override
   public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId, boolean bTryMode) throws Exception {
      return this.psDEActionWizardGroupGlobalModel.FindModelHelper(strDEActionWizardGroupId, bTryMode);
   }

   @Override
   public IDEActionWizard getDEActionWizard(String strDEActionWizardId) throws Exception {
      return this.psDEActionWizardGlobalModel.FindModelHelper(strDEActionWizardId);
   }

   @Override
   public String getLNLanResTag() {
      return this.getLNPSLanguageRes() == null ? this.strLNLanResTag : this.getLNPSLanguageRes().getLanResTag();
   }

   @PSModelRTMeta(description = "逻辑名称语言资源")
   @Override
   public IPSLanguageRes getLNPSLanguageRes() {
      return this.lnPSLanguageRes;
   }

   @Override
   public String getPSHelpModuleId() {
      return this.strPSHelpModuleId;
   }

   @Override
   public IDEBATable getDEBATable(String strDEBATableId) throws Exception {
      return this.getPSDEBDTable(strDEBATableId);
   }

   @Override
   public Iterator<IDEBATable> getDEBATables() {
      return null;
   }

   @Override
   public int check() throws Exception {
      this.psDEDBConfigGlobalModel.checkAll();
      this.psDEDBTableGlobalModel.checkAll();
      this.psDEOPPrivGlobalModel.checkAll();
      this.psDEACModeGlobalModel.checkAll();
      this.psDEDataSetGlobalModel.checkAll();
      this.psDELogicGlobalModel.checkAll();
      this.psDEDataFlowGlobalModel.checkAll();
      this.psDEActionGlobalModel.checkAll();
      this.psDEDRGroupGlobalModel.checkAll();
      this.psDEDRItemGlobalModel.checkAll();
      this.psDEMapGlobalModel.checkAll();
      this.psDEWFGlobalModel.checkAll();
      this.psDEUIActionGlobalModel.checkAll();
      this.psDEMainStateGlobalModel.checkAll();
      this.psDEDataExportGlobalModel.checkAll();
      this.psDEDBIndexGlobalModel.checkAll();
      this.psDEReportGlobalModel.checkAll();
      this.psDEPrintGlobalModel.checkAll();
      this.psDEWizardGlobalModel.checkAll();
      this.psDEDataSyncGlobalModel.checkAll();
      this.psDEBDTableGlobalModel.checkAll();
      this.psDEDataRelationGlobalModel.checkAll();
      this.psDEActionWizardGlobalModel.checkAll();
      this.psDEActionWizardGroupGlobalModel.checkAll();
      Iterator<IPSDEField> psDEFields = this.getPSDEFields();

      while (psDEFields.hasNext()) {
         IPSDEField iPSDEField = psDEFields.next();
         iPSDEField.check();
      }

      ObjectNode objNode = JsonNodeHelper.createObjectNode();
      objNode.put(String.format("%1$s_cnt", "PSDEFIELD").toLowerCase(), this.defHelpers == null ? 0 : this.defHelpers.size());
      objNode.put(String.format("%1$s_cnt", "PSDER").toLowerCase(), this.minorPSDERGlobalModel.getPSDERCount());
      this.info("模型计数", null, objNode);
      return super.check();
   }

   @PSModelRTMeta(description = "视图2名称", hideempty2 = true, dynamodelmode = 4, group = "数据库存储", order = 381)
   @Override
   public String getView2Name() {
      try {
         if ((this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) && !this.isNoViewMode()) {
            return this.psDataEntity.getVIEWNAME2();
         }
      } catch (Exception e) {
         log.error(e);
      }

      return "";
   }

   @PSModelRTMeta(description = "视图3名称", hideempty2 = true, dynamodelmode = 4, group = "数据库存储", order = 382)
   @Override
   public String getView3Name() {
      try {
         if ((this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) && !this.isNoViewMode()) {
            return this.psDataEntity.getVIEWNAME3();
         }
      } catch (Exception e) {
         log.error(e);
      }

      return "";
   }

   @PSModelRTMeta(description = "视图4名称", hideempty2 = true, dynamodelmode = 4, group = "数据库存储", order = 382)
   @Override
   public String getView4Name() {
      try {
         if ((this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) && !this.isNoViewMode()) {
            return this.psDataEntity.getVIEWNAME4();
         }
      } catch (Exception e) {
         log.error(e);
      }

      return "";
   }

   @Override
   public IDEDataQuery getViewDEDataQuery(int nViewLevel) {
      return this.psDEDataQueryGlobalModel.getDefaultPSDEDataQuery();
   }

   @PSModelRTMeta(description = "虚拟主键分隔符", hideempty2 = true, dump = false)
   @Override
   public String getVKeySeparator() {
      return this.psDataEntity.getVKEYSEPARATOR();
   }

   @Override
   public boolean isEnableViewLevel(int nViewLevel) {
      return this.nEnableViewLevel >= nViewLevel;
   }

   @PSModelRTMeta(description = "启用视图级别", codelist = "DEFieldViewColLevel", dynamodelmode = 4, group = "数据库存储", order = 380)
   @Override
   public int getEnableViewLevel() {
      return this.nEnableViewLevel;
   }

   @Override
   public String getViewName(int nViewLevel) {
      switch (nViewLevel) {
         case -1:
         case 0:
            return this.getViewName();
         case 3:
            if (!StringHelper.isNullOrEmpty(this.getView4Name())) {
               return this.getView4Name();
            }
         case 2:
            if (!StringHelper.isNullOrEmpty(this.getView3Name())) {
               return this.getView3Name();
            }
         case 1:
            if (!StringHelper.isNullOrEmpty(this.getView2Name())) {
               return this.getView2Name();
            }
         default:
            return this.getViewName();
      }
   }

   @PSModelRTMeta(description = "启用实体缓存", dynamodelmode = 4)
   @Override
   public boolean isEnableEntityCache() {
      return this.bEnableEntityCache;
   }

   @PSModelRTMeta(description = "实体缓存超时时长（毫秒）", ignoredumpvalues = "-1", dynamodelmode = 4)
   @Override
   public int getEntityCacheTimeout() {
      return this.nEntityCacheTimeout;
   }

   @PSModelRTMeta(description = "最大缓存对象数", dump = false)
   @Override
   public int getMaxEntityCacheCount() {
      return this.nMaxEntityCacheCount;
   }

   @PSModelRTMeta(description = "实体统一状态集合", child = true, dynamodelmode = 4, group = "功能配置", order = 442)
   @Override
   public Iterator<IPSDEUniState> getAllPSDEUniStates() throws Exception {
      return this.psDEUniStateGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEUniState getPSDEUniState(String strDEUniStateId) throws Exception {
      return this.psDEUniStateGlobalModel.FindModelHelper(strDEUniStateId);
   }

   @Override
   public IPSDEUniState getPSDEUniState(String strDEUniStateId, boolean bTryMode) throws Exception {
      return this.psDEUniStateGlobalModel.FindModelHelper(strDEUniStateId, bTryMode);
   }

   @Override
   public void resetPSDEUniState(String strDEUniStateId) throws Exception {
      this.psDEUniStateGlobalModel.ResetModel(strDEUniStateId);
   }

   @Override
   public boolean hasPSDEUniState() throws Exception {
      Iterator<IPSDEUniState> psDEUniStates = this.getAllPSDEUniStates();
      return psDEUniStates != null && psDEUniStates.hasNext();
   }

   @PSModelRTMeta(description = "默认实体统一状态", hideempty2 = true)
   @Override
   public IPSDEUniState getDefaultPSDEUniState() throws Exception {
      return this.psDEUniStateGlobalModel.getDefaultPSDEUniState();
   }

   @Override
   public IDEUniState getDEUniState(String strDEUniStateId) throws Exception {
      return this.getPSDEUniState(strDEUniStateId);
   }

   @Override
   public Iterator<IDEUniState> getDEUniStates() {
      return null;
   }

   @Override
   public IDEUniState getDefaultDEUniState() {
      return this.psDEUniStateGlobalModel.getDefaultPSDEUniState();
   }

   @PSModelRTMeta(description = "实体异步处理队列集合", child = true, dynamodelmode = 4, group = "功能配置", order = 440)
   @Override
   public Iterator<IPSDEDTSQueue> getAllPSDEDTSQueues() throws Exception {
      return this.psDEDTSQueueGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEDTSQueue getPSDEDTSQueue(String strDEDTSQueueId) throws Exception {
      return this.psDEDTSQueueGlobalModel.FindModelHelper(strDEDTSQueueId);
   }

   @Override
   public IPSDEDTSQueue getPSDEDTSQueue(String strDEDTSQueueId, boolean bTryMode) throws Exception {
      return this.psDEDTSQueueGlobalModel.FindModelHelper(strDEDTSQueueId, bTryMode);
   }

   @Override
   public void resetPSDEDTSQueue(String strDEDTSQueueId) throws Exception {
      this.psDEDTSQueueGlobalModel.ResetModel(strDEDTSQueueId);
   }

   @Override
   public boolean hasPSDEDTSQueue() throws Exception {
      Iterator<IPSDEDTSQueue> psDEDTSQueues = this.getAllPSDEDTSQueues();
      return psDEDTSQueues != null && psDEDTSQueues.hasNext();
   }

   @PSModelRTMeta(description = "实体示例数据集合", group = "测试", order = 550)
   @Override
   public Iterator<IPSDESampleData> getAllPSDESampleDatas() throws Exception {
      return this.psDESampleDataGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDESampleData getPSDESampleData(String strDESampleDataId) throws Exception {
      return this.psDESampleDataGlobalModel.FindModelHelper(strDESampleDataId);
   }

   @Override
   public IPSDESampleData getPSDESampleData(String strDESampleDataId, boolean bTryMode) throws Exception {
      return this.psDESampleDataGlobalModel.FindModelHelper(strDESampleDataId, bTryMode);
   }

   @Override
   public IPSDESampleData getPSDESampleData(boolean bMust) throws Exception {
      IPSDESampleData iPSDESampleData = this.psDESampleDataGlobalModel.getRandomPSDESampleData();
      if (iPSDESampleData != null && !bMust) {
         return iPSDESampleData;
      } else {
         throw new Exception(StringHelper.format("实体[%1$s]没有定义示例值", this.getFullName()));
      }
   }

   @PSModelRTMeta(description = "实体数据导入导出模式", codelist = "DEDataImpExpMode", dynamodelmode = 4, fields = "DATAIMPEXPFLAG")
   @Override
   public int getDataImpExpMode() {
      return this.nDataImpExpMode;
   }

   @PSModelRTMeta(description = "实体模型导入导出模式", codelist = "DEDataImpExpMode", dump = false)
   @Override
   public int getModelImpExpMode() {
      return this.nModelImpExpMode;
   }

   @Override
   public IDEField getUniTagDEField() {
      if (this.uniTagDEField != null) {
         return this.uniTagDEField;
      } else {
         return DataTypeHelper.isStringDataType(this.getKeyDEField().getStdDataType()) ? this.getKeyDEField() : null;
      }
   }

   @Override
   public IPSDEField getUniTagPSDEField() {
      if (this.uniTagDEField != null) {
         return this.uniTagDEField;
      } else {
         return this.getKeyPSDEField() != null && DataTypeHelper.isStringDataType(this.getKeyPSDEField().getStdDataType()) ? this.getKeyPSDEField() : null;
      }
   }

   @PSModelRTMeta(description = "实体服务资源模式", codelist = "SysServiceApiMode", fields = "SERVICEAPIFLAG")
   @Override
   public int getServiceAPIMode() {
      if (this.isSubSysDE()) {
         return 0;
      } else {
         return this.getStorageMode() == 4 ? 0 : this.nServiceAPIMode;
      }
   }

   @PSModelRTMeta(description = "实体服务资源集合", group = "功能配置", order = 425)
   @Override
   public Iterator<IPSDEServiceAPI> getAllPSDEServiceAPIs() throws Exception {
      return this.psDEServiceAPIGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEServiceAPI getPSDEServiceAPI(String strDEServiceAPIId) throws Exception {
      return this.psDEServiceAPIGlobalModel.FindModelHelper(strDEServiceAPIId);
   }

   @Override
   public void resetPSDEServiceAPI(String strDEServiceAPIId) throws Exception {
      this.psDEServiceAPIGlobalModel.ResetModel(strDEServiceAPIId);
   }

   @PSModelRTMeta(description = "服务接口客户端标识", dynamodelmode = 4)
   @Override
   public String getServiceAPIClientId() {
      return this.strPSSubSysServiceAPIId;
   }

   @PSModelRTMeta(description = "服务代码标识", dynamodelmode = 4, fields = "SERVICECODENAME")
   @Override
   public String getServiceCodeName() {
      return this.onGetServiceCodeName();
   }

   protected String onGetServiceCodeName() {
      return !StringHelper.isNullOrEmpty(this.strServiceCodeName) ? this.strServiceCodeName : this.getAPICodeName(null, this.getCodeName(), null);
   }

   @PSModelRTMeta(description = "实体接口默认提供实体行为", dump = false)
   @Override
   public boolean isEnableSADEAction() {
      return this.bEnableSADEAction;
   }

   @PSModelRTMeta(description = "实体接口默认提供简单查询", dump = false)
   @Override
   public boolean isEnableSASelect() {
      return this.bEnableSASelect;
   }

   @PSModelRTMeta(description = "实体接口默认提供结果集查询", dump = false)
   @Override
   public boolean isEnableSADEDataSet() {
      return this.bEnableSADEDataSet;
   }

   @PSModelRTMeta(description = "支持界面操作", codelist = "DEUserUIAbility2")
   @Override
   public int getEnableUIActions() {
      return this.nEnableUIActions;
   }

   @PSModelRTMeta(description = "支持行为操作", codelist = "DEUserUIAbility2")
   @Override
   public int getEnableActions() {
      return this.nEnableActions;
   }

   @Override
   public String getDefaultDEDTSQueueId() {
      return this.psDEDTSQueueGlobalModel.getDefaultPSDEDTSQueue() != null ? this.psDEDTSQueueGlobalModel.getDefaultPSDEDTSQueue().getId() : null;
   }

   @PSModelRTMeta(description = "默认实体分布事务处理队列", codelist = "DEUserUIAbility2")
   @Override
   public IPSDEDTSQueue getDefaultPSDEDTSQueue() throws Exception {
      String strDefaultPSDTSQueueId = this.getDefaultDEDTSQueueId();
      return !StringHelper.isNullOrEmpty(strDefaultPSDTSQueueId) ? this.getPSDEDTSQueue(strDefaultPSDTSQueueId) : null;
   }

   @PSModelRTMeta(description = "实体数据操作角色集合", outputdoc = "false")
   @Override
   public Iterator<IPSDEOPPrivRole> getAllPSDEOPPrivRoles() throws Exception {
      return this.psDEOPPrivRoleGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEOPPrivRole getPSDEOPPrivRole(String strDEOPPrivRoleId) throws Exception {
      return this.psDEOPPrivRoleGlobalModel.FindModelHelper(strDEOPPrivRoleId);
   }

   @Override
   public IPSDEOPPrivRole getPSDEOPPrivRole(String strDEOPPrivRoleId, boolean bTryMode) throws Exception {
      return this.psDEOPPrivRoleGlobalModel.FindModelHelper(strDEOPPrivRoleId, bTryMode);
   }

   @Override
   public void resetPSDEOPPrivRole(String strDEOPPrivRoleId) throws Exception {
      this.psDEOPPrivRoleGlobalModel.ResetModel(strDEOPPrivRoleId);
   }

   @PSModelRTMeta(description = "实体操作角色集合", child = true, dynamodelmode = 4, group = "访问控制", order = 515)
   @Override
   public Iterator<IPSDEUserRole> getAllPSDEUserRoles() throws Exception {
      return this.psDEUserRoleGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEUserRole getPSDEUserRole(String strDEUserRoleId) throws Exception {
      return this.psDEUserRoleGlobalModel.FindModelHelper(strDEUserRoleId);
   }

   @Override
   public IPSDEUserRole getPSDEUserRole(String strDEUserRoleId, boolean bTryMode) throws Exception {
      return this.psDEUserRoleGlobalModel.FindModelHelper(strDEUserRoleId, bTryMode);
   }

   @Override
   public void resetPSDEUserRole(String strDEUserRoleId) throws Exception {
      this.psDEUserRoleGlobalModel.ResetModel(strDEUserRoleId);
   }

   @PSModelRTMeta(description = "实体访问控制体系", codelist = "AccCtrlArch", dynamodelmode = 4, group = "访问控制", order = 502, fields = "ACCCTRLARCH")
   @Override
   public int getDataAccCtrlArch() {
      return this.nDataAccCtrlArch;
   }

   @Override
   public IDEUserRole getDEUserRole(String strDEUserRoleId) throws Exception {
      return this.getPSDEUserRole(strDEUserRoleId);
   }

   @Override
   public Iterator<IDEUserRole> getDEUserRoles() {
      return null;
   }

   @Override
   public Iterator<IDEOPPrivRole> getDEOPPrivRoles(String strDEOPrivTag) {
      return null;
   }

   @PSModelRTMeta(description = "实体功能配置集合", child = true, dynamodelmode = 4, group = "功能配置", order = 445)
   @Override
   public Iterator<IPSDEUtil> getAllPSDEUtils() throws Exception {
      return this.psDEUtilGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEUtil getPSDEUtil(String strDEUtilId) throws Exception {
      return this.getPSDEUtil(strDEUtilId, false);
   }

   @Override
   public IPSDEUtil getPSDEUtil(String strDEUtilId, boolean bTryMode) throws Exception {
      IPSDEUtil iPSDEUtil = this.psDEUtilGlobalModel.FindModelHelper(strDEUtilId, true);
      return iPSDEUtil != null ? iPSDEUtil : this.getPSSystem().getPSSysUtil(strDEUtilId, bTryMode);
   }

   @Override
   public void resetPSDEUtil(String strDEUtilId) throws Exception {
      this.psDEUtilGlobalModel.ResetModel(strDEUtilId);
   }

   @Override
   public boolean hasDEWF() {
      try {
         return this.hasPSDEWF();
      } catch (Exception ex) {
         log.error(ex);
         return false;
      }
   }

   @PSModelRTMeta(description = "属性集合", child = true, group = "模型", order = 290)
   @Override
   public Iterator<IPSDEField> getAllPSDEFields() throws Exception {
      return this.getPSDEFields();
   }

   @Override
   public String getModelName() {
      return StringHelper.format("%1$s#%2$s", this.getName(), this.getLogicName());
   }

   @Override
   public IDEDBConfig getDEDBConfig(String strDBType) throws Exception {
      return this.getPSDEDBConfig(strDBType);
   }

   @PSModelRTMeta(description = "后台服务发布对象", hideempty = true)
   @Override
   public IPSSysSFPub getPSSysSFPub() {
      return this.iPSSysSFPub;
   }

   @Override
   public boolean isEnableDynaStorage() {
      try {
         return this.getPSDEUtil("DYNASTORAGE", true) != null;
      } catch (Exception ex) {
         log.error(ex);
         return false;
      }
   }

   @PSModelRTMeta(description = "虚拟实体模式", codelist = "DEVirtualMode", dynamodelmode = 4, ignoredumpvalues = "0", fields = "VIRTUALFLAG")
   @Override
   public int getVirtualMode() {
      return this.nVirtualMode;
   }

   @Override
   public boolean isEnableDynaSys() {
      return this.bEnableDynaSys && this.getPSSystem().isEnableDynaSys();
   }

   @Override
   public String getPSDynaDETemplId() {
      return "";
   }

   @PSModelRTMeta(description = "SaaS模式", codelist = "DESaaSMode", dynamodelmode = 4, fields = "SAASMODE")
   @Override
   public int getSaaSMode() {
      return this.nSaaSMode;
   }

   @PSModelRTMeta(description = "SaaS数据主键列", dynamodelmode = 4)
   @Override
   public String getSaaSDataIdColumnName() {
      if (this.getSaaSMode() == SAASMODE_NOTSUPPORTED) {
         return "";
      }

      if (this.getPSSysDBScheme() != null) {
         String strSaaSDataIdColumnName = this.getPSSysDBScheme().getSaaSDataIdColumnName();
         if (!StringHelper.isNullOrEmpty(strSaaSDataIdColumnName)) {
            return strSaaSDataIdColumnName;
         }
      }

      return this.getUserParam("SAAS.IDCOLUMN", "SRFID");
   }

   @PSModelRTMeta(description = "SaaS数据租户列", dynamodelmode = 4)
   @Override
   public String getSaaSDCIdColumnName() {
      if (this.getSaaSMode() == SAASMODE_NOTSUPPORTED) {
         return "";
      }

      if (this.getPSSysDBScheme() != null) {
         String strSaaSDCIdColumnName = this.getPSSysDBScheme().getSaaSDCIdColumnName();
         if (!StringHelper.isNullOrEmpty(strSaaSDCIdColumnName)) {
            return strSaaSDCIdColumnName;
         }
      }

      return this.getUserParam("SAAS.DCCOLUMN", "SRFDCID");
   }

   @Override
   public Iterator<IPSAppView> getDataRedirectPSAppViews() throws Exception {
      PSDEViewBase psDEViewBase = this.getPSDEViewDataByPDT("REDIRECTVIEW", true);
      if (psDEViewBase != null) {
         ArrayList<IPSAppView> psAppViewList = new ArrayList<>();
         Iterator<IPSApplication> psApplications = this.getPSSystem().getAllPSApps();
         if (psApplications != null) {
            while (psApplications.hasNext()) {
               IPSApplication iPSApplication = psApplications.next();
               IPSAppView iPSAppView = iPSApplication.getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), true);
               if (iPSAppView != null) {
                  psAppViewList.add(iPSAppView);
               }
            }
         }

         if (psAppViewList.size() > 0) {
            return psAppViewList.iterator();
         }
      }

      return null;
   }

   @Override
   public Iterator<IPSAppView> getMobDataRedirectPSAppViews() throws Exception {
      PSDEViewBase psDEViewBase = this.getPSDEViewDataByPDT("MOBREDIRECTVIEW", true);
      if (psDEViewBase != null) {
         ArrayList<IPSAppView> psAppViewList = new ArrayList<>();
         Iterator<IPSApplication> psApplications = this.getPSSystem().getAllPSApps();
         if (psApplications != null) {
            while (psApplications.hasNext()) {
               IPSApplication iPSApplication = psApplications.next();
               IPSAppView iPSAppView = iPSApplication.getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), true);
               if (iPSAppView != null) {
                  psAppViewList.add(iPSAppView);
               }
            }
         }

         if (psAppViewList.size() > 0) {
            return psAppViewList.iterator();
         }
      }

      return null;
   }

   @Override
   public boolean hasPSDEViewBase() {
      return this.psDEViewBaseList != null && this.psDEViewBaseList.size() > 0;
   }

   @PSModelRTMeta(description = "子系统引用", hideempty = true)
   @Override
   public IPSSysRef getPSSysRef() {
      return this.getPSSystemModule() == null ? null : this.getPSSystemModule().getPSSysRef();
   }

   @PSModelRTMeta(description = "所属系统标识", dynamodelmode = 4)
   @Override
   public String getSystemTag() {
      return this.getPSSysRef() != null ? this.getPSSysRef().getSystemTag() : this.getPSSystem().getCodeName();
   }

   @PSModelRTMeta(description = "默认实体自填模式")
   @Override
   public IPSDEACMode getDefaultPSDEACMode() throws Exception {
      return this.getDefaultPSDEACModeData() != null
         ? this.getPSDEACMode(this.getDefaultPSDEACModeData().getPSDEACMODEID())
         : this.getPSDEACMode("DEFAULT", true);
   }

   @PSModelRTMeta(
      description = "默认实体数据集合",
      dumpref = true,
      from = "__self__",
      doc = "默认实体数据集参考{@link net.ibizsys.model.dataentity.ds.IPSDEDataSet#isDefaultMode}"
   )
   @Override
   public IPSDEDataSet getDefaultPSDEDataSet() throws Exception {
      return this.psDEDataSetGlobalModel.getDefaultPSDEDataSet();
   }

   @PSModelRTMeta(
      description = "默认实体数据查询",
      dynamodelmode = 4,
      dumpref = true,
      from = "__self__",
      doc = "默认实体查询参考{@link net.ibizsys.model.dataentity.ds.IPSDEDataQuery#isDefaultMode}"
   )
   @Override
   public IPSDEDataQuery getDefaultPSDEDataQuery() throws Exception {
      return this.psDEDataQueryGlobalModel.getDefaultPSDEDataQuery();
   }

   @PSModelRTMeta(description = "默认实体视图数据查询", dynamodelmode = 4, dumpref = true, from = "__self__")
   @Override
   public IPSDEDataQuery getViewPSDEDataQuery() throws Exception {
      return this.psDEDataQueryGlobalModel.getViewPSDEDataQuery();
   }

   @PSModelRTMeta(description = "子系统服务接口", hideempty = true, dumpref = true, dynamodelmode = 4, fields = "PSSUBSYSSERVICEAPIID")
   @Override
   public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
      if (StringHelper.isNullOrEmpty(this.getServiceAPIClientId())) {
         return null;
      }

      if (this.iPSSubSysServiceAPI == null) {
         this.iPSSubSysServiceAPI = this.getPSSystem().getPSSubSysServiceAPI(this.getServiceAPIClientId());
      }

      return this.iPSSubSysServiceAPI;
   }

   @PSModelRTMeta(description = "子系统服务接口实体", hideempty = true, dumpref = true, from = "IPSSubSysServiceAPI", dynamodelmode = 4, fields = "PSSUBSYSSADEID")
   @Override
   public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() throws Exception {
      if (this.getPSSubSysServiceAPI() == null) {
         return null;
      }

      if (this.iPSSubSysServiceAPIDE == null) {
         if (!StringHelper.isNullOrEmpty(this.psDataEntity.getPSSUBSYSSADEID())) {
            this.iPSSubSysServiceAPIDE = this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.psDataEntity.getPSSUBSYSSADEID(), false);
         } else {
            this.iPSSubSysServiceAPIDE = this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.getName().toUpperCase(), true);
         }
      }

      return this.iPSSubSysServiceAPIDE;
   }

   @Override
   public Iterator<IPSDER1N> getCustomExportPSDER1Ns(boolean bMajor) {
      ArrayList<IPSDER1N> psDER1NList = new ArrayList<>();
      Iterator<IPSDERBase> psDERBases = this.getPSDERs(bMajor);
      if (psDERBases == null) {
         return null;
      }

      while (psDERBases.hasNext()) {
         IPSDERBase iPSDERBase = psDERBases.next();
         if (iPSDERBase instanceof IPSDER1N) {
            IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
            if (iPSDER1N.getCustomExportOrder() >= 0) {
               psDER1NList.add(iPSDER1N);
            }
         }
      }

      if (psDER1NList.size() > 0) {
         Collections.sort(psDER1NList, new Comparator<IPSDER1N>() {
            public int compare(IPSDER1N o1, IPSDER1N o2) {
               if (o1.getCustomExportOrder() == o2.getCustomExportOrder()) {
                  return StringHelper.compare(o1.getName(), o2.getName(), false);
               } else {
                  int nRet = o1.getCustomExportOrder() - o2.getCustomExportOrder();
                  if (nRet == 0) {
                     return 0;
                  } else {
                     return nRet > 0 ? 1 : -1;
                  }
               }
            }
         });
      }

      return psDER1NList.size() == 0 ? null : psDER1NList.iterator();
   }

   @Override
   public Iterator<IPSDER1N> getCustomExport2PSDER1Ns(boolean bMajor) {
      ArrayList<IPSDER1N> psDER1NList = new ArrayList<>();
      Iterator<IPSDERBase> psDERBases = this.getPSDERs(bMajor);
      if (psDERBases == null) {
         return null;
      }

      while (psDERBases.hasNext()) {
         IPSDERBase iPSDERBase = psDERBases.next();
         if (iPSDERBase instanceof IPSDER1N) {
            IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
            if (iPSDER1N.getCustomExportOrder2() >= 0) {
               psDER1NList.add(iPSDER1N);
            }
         }
      }

      if (psDER1NList.size() > 0) {
         Collections.sort(psDER1NList, new Comparator<IPSDER1N>() {
            public int compare(IPSDER1N o1, IPSDER1N o2) {
               if (o1.getCustomExportOrder2() == o2.getCustomExportOrder2()) {
                  return StringHelper.compare(o1.getName(), o2.getName(), false);
               } else {
                  int nRet = o1.getCustomExportOrder2() - o2.getCustomExportOrder2();
                  if (nRet == 0) {
                     return 0;
                  } else {
                     return nRet > 0 ? 1 : -1;
                  }
               }
            }
         });
      }

      return psDER1NList.size() == 0 ? null : psDER1NList.iterator();
   }

   @PSModelRTMeta(description = "应用实体集合", group = "功能配置", order = 426)
   @Override
   public Iterator<IPSAppDataEntity> getAllPSAppDataEntities() throws Exception {
      if (this.psAppDataEntityList == null) {
         ArrayList<IPSAppDataEntity> psAppDataEntityList2 = new ArrayList<>();
         Iterator<IPSApplication> psApplications = this.getPSSystem().getAllPSApps();
         if (psApplications != null) {
            while (psApplications.hasNext()) {
               IPSApplication iPSApplication = psApplications.next();
               IPSAppDataEntity iPSAppDataEntity = iPSApplication.getPSAppDataEntityByDEId(this.getId(), true);
               if (iPSAppDataEntity != null) {
                  psAppDataEntityList2.add(iPSAppDataEntity);
               }
            }
         }

         synchronized (this) {
            if (this.psAppDataEntityList == null) {
               this.psAppDataEntityList = psAppDataEntityList2;
            }
         }
      }

      return this.psAppDataEntityList.iterator();
   }

   @PSModelRTMeta(description = "应用实体视图集合", outputdoc = "false")
   @Override
   public Iterator<IPSAppView> getAllPSAppViews() throws Exception {
      if (this.psAppViewList == null) {
         ArrayList<IPSAppView> psAppViewList2 = new ArrayList<>();
         Iterator<IPSAppDataEntity> psAppDataEntities = this.getAllPSAppDataEntities();
         if (psAppDataEntities != null) {
            while (psAppDataEntities.hasNext()) {
               IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
               Iterator<IPSAppView> psAppViews = iPSAppDataEntity.getAllPSAppViews();
               if (psAppViews != null) {
                  while (psAppViews.hasNext()) {
                     psAppViewList2.add(psAppViews.next());
                  }
               }
            }
         }

         synchronized (this) {
            if (this.psAppViewList == null) {
               this.psAppViewList = psAppViewList2;
            }
         }
      }

      return this.psAppViewList.iterator();
   }

   @Override
   public IPSAppDataEntity getPSAppDataEntity(String strPSSysAppId, boolean bTryMode) throws Exception {
      Iterator<IPSAppDataEntity> psDataEntities = this.getAllPSAppDataEntities();

      while (psDataEntities.hasNext()) {
         IPSAppDataEntity iPSAppDataEntity = psDataEntities.next();
         if (StringHelper.compare(iPSAppDataEntity.getId(), strPSSysAppId, false) == 0
            || StringHelper.compare(iPSAppDataEntity.getPSApplication().getId(), strPSSysAppId, false) == 0) {
            return iPSAppDataEntity;
         }
      }

      if (!bTryMode) {
         throw new Exception(StringHelper.format("无法获取指定应用实体[%1$s]", strPSSysAppId));
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "有应用实体", dump = false)
   @Override
   public boolean hasPSAppDataEntity() throws Exception {
      this.getAllPSAppDataEntities();
      return this.psAppDataEntityList.size() > 0;
   }

   @PSModelRTMeta(description = "实体属性组集合", child = true, rtname = "getDEFGroups", dynamodelmode = 4, group = "模型高级", order = 570)
   @Override
   public Iterator<IPSDEFGroup> getAllPSDEFGroups() throws Exception {
      return this.psDEFGroupGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEFGroup getPSDEFGroup(String strDEFGroupId) throws Exception {
      return this.psDEFGroupGlobalModel.FindModelHelper(strDEFGroupId);
   }

   @Override
   public IPSDEFGroup getPSDEFGroup(String strDEFGroupId, boolean bTryMode) throws Exception {
      return this.psDEFGroupGlobalModel.FindModelHelper(strDEFGroupId, bTryMode);
   }

   @Override
   public void resetPSDEFGroup(String strDEFGroupId) throws Exception {
      this.psDEFGroupGlobalModel.ResetModel(strDEFGroupId);
   }

   @Override
   public IPSDEField getPSDEFieldByBizTag(String strBizTag, boolean bTryMode) throws Exception {
      String strFullBizTag = StringHelper.format("%1$s#%2$s", "SRFBIZTAG", strBizTag);
      IPSDEField iPSDEField = this.internalGetPSDEField(strFullBizTag, true);
      if (iPSDEField == null && !bTryMode) {
         throw new PSDataEntityException(this, 20000, StringHelper.format("实体[%1$s]不存在指定业务标记属性[%2$s]", this.getFullName(), strBizTag));
      } else {
         return iPSDEField;
      }
   }

   @PSModelRTMeta(description = "启用数据版本能力", dynamodelmode = 4)
   @Override
   public boolean isEnableDataVer() {
      return this.bEnableDataVer;
   }

   @PSModelRTMeta(description = "实体组集合", child = true, dumpref = true, rtdump = 2, rtname = "getDEGroups", dynamodelmode = 8, group = "模型高级", order = 575)
   @Override
   public Iterator<IPSDEGroup> getAllPSDEGroups() throws Exception {
      return this.psDEGroupGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEGroup getPSDEGroup(String strDEGroupId) throws Exception {
      return this.psDEGroupGlobalModel.FindModelHelper(strDEGroupId);
   }

   @Override
   public IPSDEGroup getPSDEGroup(String strDEGroupId, boolean bTryMode) throws Exception {
      return this.psDEGroupGlobalModel.FindModelHelper(strDEGroupId, bTryMode);
   }

   @Override
   public void resetPSDEGroup(String strDEGroupId) throws Exception {
      this.psDEGroupGlobalModel.ResetModel(strDEGroupId);
   }

   @PSModelRTMeta(description = "实体关系组集合", child = true, dumpref = true, rtdump = 2, rtname = "getDERGroups", dynamodelmode = 8, group = "模型高级", order = 580)
   @Override
   public Iterator<IPSDERGroup> getAllPSDERGroups() throws Exception {
      return this.psDERGroupGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDERGroup getPSDERGroup(String strDERGroupId) throws Exception {
      return this.psDERGroupGlobalModel.FindModelHelper(strDERGroupId);
   }

   @Override
   public IPSDERGroup getPSDERGroup(String strDERGroupId, boolean bTryMode) throws Exception {
      return this.psDERGroupGlobalModel.FindModelHelper(strDERGroupId, bTryMode);
   }

   @Override
   public void resetPSDERGroup(String strDERGroupId) throws Exception {
      this.psDERGroupGlobalModel.ResetModel(strDERGroupId);
   }

   @PSModelRTMeta(description = "实体行为组集合", child = true, dumpref = true, rtdump = 2, dynamodelmode = 8, group = "模型高级", order = 585)
   @Override
   public Iterator<IPSDEActionGroup> getAllPSDEActionGroups() throws Exception {
      return this.psDEActionGroupGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEActionGroup getPSDEActionGroup(String strDEActionGroupId) throws Exception {
      return this.psDEActionGroupGlobalModel.FindModelHelper(strDEActionGroupId);
   }

   @Override
   public IPSDEActionGroup getPSDEActionGroup(String strDEActionGroupId, boolean bTryMode) throws Exception {
      return this.psDEActionGroupGlobalModel.FindModelHelper(strDEActionGroupId, bTryMode);
   }

   @Override
   public void resetPSDEActionGroup(String strDEActionGroupId) throws Exception {
      this.psDEActionGroupGlobalModel.ResetModel(strDEActionGroupId);
   }

   @PSModelRTMeta(description = "实体帮助文章集合", outputdoc = "false")
   @Override
   public Iterator<IPSHelpArticle> getAllPSHelpArticles() throws Exception {
      ArrayList<IPSHelpArticle> psHelpArticleList = new ArrayList<>();
      Iterator<IPSHelpArticle> allPSHelpArticles = this.getPSSystem().getAllPSHelpArticles();
      if (allPSHelpArticles != null) {
         while (allPSHelpArticles.hasNext()) {
            IPSHelpArticle iPSHelpArticle = allPSHelpArticles.next();
            if (iPSHelpArticle.getPSDataEntity() != null && StringHelper.compare(iPSHelpArticle.getPSDataEntity().getId(), this.getId(), false) == 0) {
               psHelpArticleList.add(iPSHelpArticle);
            }
         }
      }

      return psHelpArticleList.iterator();
   }

   @PSModelRTMeta(description = "实体数据表集合", hideempty2 = true, dynamodelmode = 4, child = true, group = "数据库存储", order = 390)
   @Override
   public Iterator<IPSDEDBTable> getAllPSDEDBTables() throws Exception {
      return this.psDEDBTableGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEDBTable getPSDEDBTable(String strPSDEDBTableId) throws Exception {
      return this.psDEDBTableGlobalModel.FindModelHelper(strPSDEDBTableId);
   }

   @Override
   public IPSDEDBTable getPSDEDBTable(String strPSDEDBTableId, boolean bTryMode) throws Exception {
      return this.psDEDBTableGlobalModel.FindModelHelper(strPSDEDBTableId, bTryMode);
   }

   @PSModelRTMeta(description = "关系数据库架构", hideempty2 = true, dumpref = true, dynamodelmode = 4, group = "数据库存储", order = 377)
   @Override
   public IPSSysDBScheme getPSSysDBScheme() {
      return this.iPSSysDBScheme;
   }

   @Override
   public Iterator<IPSDESearch> getAllPSDESearchs() throws Exception {
      return this.psDESearchGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "实体全文检索集合", hideempty2 = true, child = true, dynamodelmode = 4, group = "功能配置", order = 428)
   @Override
   public Iterator<IPSDESearch> getAllPSDESearches() throws Exception {
      return this.psDESearchGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDESearch getPSDESearch(String strDESearchId) throws Exception {
      return this.psDESearchGlobalModel.FindModelHelper(strDESearchId);
   }

   @PSModelRTMeta(description = "支持多存储模式", dynamodelmode = 4)
   @Override
   public boolean isEnableMultiStorage() {
      return this.bEnableMultiStorage;
   }

   @PSModelRTMeta(description = "支持SQL存储", dynamodelmode = 4)
   @Override
   public boolean isEnableSQLStorage() throws Exception {
      if (this.getStorageMode() == 1) {
         return true;
      } else {
         return this.isEnableMultiStorage() ? !StringHelper.isNullOrEmpty(this.psDataEntity.getDSLINK()) : false;
      }
   }

   @PSModelRTMeta(description = "支持NoSQL存储", dynamodelmode = 4)
   @Override
   public boolean isEnableNoSQLStorage() throws Exception {
      if (this.getStorageMode() == 2) {
         return true;
      }

      if (this.isEnableMultiStorage()) {
         if (this.hasPSDEBDTable()) {
            return true;
         }

         if (this.hasPSDESearch()) {
            Iterator<IPSDESearch> psDESearchs = this.getAllPSDESearchs();
            if (psDESearchs != null) {
               while (psDESearchs.hasNext()) {
                  IPSDESearch iPSDESearch = psDESearchs.next();
                  if (iPSDESearch.getPSSysSearchDE().isNoSQLStorage()) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   @PSModelRTMeta(description = "支持接口存储", dynamodelmode = 4)
   @Override
   public boolean isEnableAPIStorage() throws Exception {
      return this.getStorageMode() == 4 ? true : this.isEnableMultiStorage() && !StringHelper.isNullOrEmpty(this.getServiceAPIClientId());
   }

   @PSModelRTMeta(description = "有实体大数据表", dump = false)
   @Override
   public boolean hasPSDEBDTable() throws Exception {
      return this.psDEBDTableGlobalModel.getAllModelHelperCount() > 0;
   }

   @PSModelRTMeta(description = "有实体检索", dump = false)
   @Override
   public boolean hasPSDESearch() throws Exception {
      return this.psDESearchGlobalModel.getAllModelHelperCount() > 0;
   }

   @PSModelRTMeta(description = "临时数据处理模式", codelist = "DETempDataHolder", ignoredumpvalues = "0", fields = "ENATEMPDATA")
   @Override
   public int getTempDataHolder() {
      return this.nTempDataHolder;
   }

   @PSModelRTMeta(description = "支持后端临时数据处理", ignoredumpvalues = "false", dynamodelmode = 4)
   @Override
   public boolean isEnableTempDataBackend() {
      return (this.getTempDataHolder() & 1) == 1;
   }

   @PSModelRTMeta(description = "支持前端临时数据处理", ignoredumpvalues = "false", dynamodelmode = 4)
   @Override
   public boolean isEnableTempDataFront() {
      return (this.getTempDataHolder() & 2) == 2;
   }

   @Override
   public String getPSSubSysSADEId() {
      return this.psDataEntity.getPSSUBSYSSADEID();
   }

   @PSModelRTMeta(description = "子系统以云服务方式提供", dynamodelmode = 4, doc = "由所属模块决定")
   @Override
   public boolean isSubSysAsCloud() {
      return this.bSubSysAsCloud;
   }

   @PSModelRTMeta(description = "部署数据标识", dump = false)
   @Override
   public String getDeployId() {
      return KeyValueHelper.genUniqueId(this.getPSSystemModule().getDeployId(), this.getName());
   }

   @PSModelRTMeta(description = "快速搜索属性集合", outputdoc = "false")
   @Override
   public Iterator<IPSDEField> getQuickSearchPSDEFields() throws Exception {
      if (this.quickSearchPSDEFieldList == null) {
         ArrayList<IPSDEField> quickSearchPSDEFieldList = new ArrayList<>();
         Iterator<IPSDEField> psDEFields = this.getAllPSDEFields();
         if (psDEFields != null) {
            while (psDEFields.hasNext()) {
               IPSDEField iPSDEField = psDEFields.next();
               if (iPSDEField.isEnableQuickSearch()) {
                  quickSearchPSDEFieldList.add(iPSDEField);
               }
            }
         }

         if (this.quickSearchPSDEFieldList == null) {
            this.quickSearchPSDEFieldList = quickSearchPSDEFieldList;
         }
      }

      return this.quickSearchPSDEFieldList != null && this.quickSearchPSDEFieldList.size() != 0 ? this.quickSearchPSDEFieldList.iterator() : null;
   }

   @PSModelRTMeta(description = "默认实体数据导入对象")
   @Override
   public IPSDEDataImport getDefaultPSDEDataImport() throws Exception {
      this.getAllPSDEDataImports();
      return this.psDEDataImportGlobalModel.getDefaultPSDEDataImport();
   }

   @PSModelRTMeta(description = "默认实体数据导出对象")
   @Override
   public IPSDEDataExport getDefaultPSDEDataExport() throws Exception {
      this.getAllPSDEDataExports();
      return this.psDEDataExportGlobalModel.getDefaultPSDEDataExport();
   }

   @PSModelRTMeta(description = "代码表集合", group = "模型", order = 296)
   @Override
   public Iterator<IPSCodeList> getAllPSCodeLists() throws Exception {
      if (this.psCodeListList == null) {
         ArrayList<IPSCodeList> psCodeListList = new ArrayList<>();
         Iterator<IPSCodeList> psCodeLists = this.getPSSystem().getAllPSCodeLists();
         if (psCodeLists != null) {
            while (psCodeLists.hasNext()) {
               IPSCodeList iPSCodeList = psCodeLists.next();
               if (iPSCodeList.getPSDataEntity() != null && StringHelper.compare(iPSCodeList.getPSDataEntity().getId(), this.getId(), false) == 0) {
                  psCodeListList.add(iPSCodeList);
               }
            }
         }

         if (this.psCodeListList == null) {
            this.psCodeListList = psCodeListList;
         }
      }

      return this.psCodeListList != null && this.psCodeListList.size() != 0 ? this.psCodeListList.iterator() : null;
   }

   @PSModelRTMeta(description = "排序值属性", hideempty = true, group = "模型", order = 160)
   @Override
   public IPSDEField getOrderValuePSDEField() {
      try {
         return this.getPSDEFieldByPDT("ORDERVALUE", true);
      } catch (Exception e) {
         log.error(e);
         return null;
      }
   }

   @PSModelRTMeta(description = "数据版本属性", hideempty = true, group = "模型", order = 160)
   @Override
   public IPSDEField getVersionPSDEField() {
      try {
         return this.getPSDEFieldByPDT("VERSION", true);
      } catch (Exception e) {
         log.error(e);
         return null;
      }
   }

   @PSModelRTMeta(description = "数据类型属性", hideempty = true, group = "模型", order = 160)
   @Override
   public IPSDEField getDataTypePSDEField() {
      try {
         IPSDEField iPSDEField = this.getPSDEFieldByPDT("DATATYPE", true);
         if (iPSDEField == null) {
            iPSDEField = this.getIndexTypePSDEField();
            if (iPSDEField == null) {
               iPSDEField = this.getFormTypePSDEField();
            }
         }

         return iPSDEField;
      } catch (Exception e) {
         log.error(e);
         return null;
      }
   }

   @PSModelRTMeta(description = "实体方法集合", outputdoc = "false")
   @Override
   public Iterator<IPSDEMethod> getAllPSDEMethods() throws Exception {
      if (this.psDEMethodList == null) {
         ArrayList<IPSDEMethod> psDEMethodList = new ArrayList<>();
         Iterator<IPSDEAction> psDEActions = this.getAllPSDEActions();
         if (psDEActions != null) {
            while (psDEActions.hasNext()) {
               IPSDEAction iPSDEAction = psDEActions.next();
               if (iPSDEAction.isEnableBackend()) {
                  PSDEActionMethodImpl psDEActionMethodImpl = new PSDEActionMethodImpl();
                  psDEActionMethodImpl.init(this.getDAGlobalHelper(), iPSDEAction);
                  psDEMethodList.add(psDEActionMethodImpl);
               }
            }
         }

         Iterator<IPSDEDataSet> psDEDataSets = this.getAllPSDEDataSets();
         if (psDEDataSets != null) {
            while (psDEDataSets.hasNext()) {
               IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
               if (iPSDEDataSet.isEnableBackend()) {
                  PSDEDataSetMethodImpl psDEDataSetMethodImpl = new PSDEDataSetMethodImpl();
                  psDEDataSetMethodImpl.init(this.getDAGlobalHelper(), iPSDEDataSet);
                  psDEMethodList.add(psDEDataSetMethodImpl);
                  if (iPSDEDataSet.getPSCodeList() == null) {
                     for (int i = 0; i < 2; i++) {
                        Iterator<IPSDER1N> psDER1Ns = null;
                        switch (i) {
                           case 0:
                              psDER1Ns = this.getMinorPSDER1Ns();
                              break;
                           case 1:
                              if (this.getInheritPSDataEntity() != null) {
                                 psDER1Ns = this.getInheritPSDataEntity().getMinorPSDER1Ns();
                              }
                        }

                        if (psDER1Ns != null) {
                           while (psDER1Ns.hasNext()) {
                              IPSDER1N iPSDER1N = psDER1Ns.next();
                              if (!StringHelper.isNullOrEmpty(iPSDER1N.getPickupDEFName())) {
                                 IPSDEField iPSDEField = this.getPSDEField(iPSDER1N.getPickupDEFName(), true);
                                 if (iPSDEField != null) {
                                    PSDEDataSetMethodImpl psDEDataSetMethodImplx = new PSDEDataSetMethodImpl();
                                    psDEDataSetMethodImplx.init(this.getDAGlobalHelper(), iPSDEDataSet, iPSDER1N, iPSDEField, "DEFAULT");
                                    psDEMethodList.add(psDEDataSetMethodImplx);
                                    if (iPSDER1N.getMajorPSDataEntity().getRecursivePSDER1N() != null) {
                                       psDEDataSetMethodImplx = new PSDEDataSetMethodImpl();
                                       psDEDataSetMethodImplx.init(this.getDAGlobalHelper(), iPSDEDataSet, iPSDER1N, iPSDEField, "CHILDOF");
                                       psDEMethodList.add(psDEDataSetMethodImplx);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         if (this.psDEMethodList == null) {
            this.psDEMethodList = psDEMethodList;
         }
      }

      return this.psDEMethodList != null && this.psDEMethodList.size() != 0 ? this.psDEMethodList.iterator() : null;
   }

   @Override
   public IPSDEActionMethod getPSDEActionMethod(IPSDEAction iPSDEAction, boolean bTryMode) throws Exception {
      if (iPSDEAction == null) {
         throw new Exception(StringHelper.format("传入参数无效"));
      }

      Iterator<IPSDEMethod> psDEMethods = this.getAllPSDEMethods();
      if (psDEMethods != null) {
         while (psDEMethods.hasNext()) {
            IPSDEMethod iPSDEMethod = psDEMethods.next();
            if (iPSDEMethod instanceof IPSDEActionMethod) {
               IPSDEActionMethod iPSDEActionMethod = (IPSDEActionMethod)iPSDEMethod;
               if (iPSDEActionMethod.getPSDEAction() != null
                  && StringHelper.compare(iPSDEActionMethod.getPSDEAction().getId(), iPSDEAction.getId(), false) == 0) {
                  return iPSDEActionMethod;
               }
            }
         }
      }

      if (!bTryMode) {
         throw new Exception(StringHelper.format("无法获取指定实体行为[%1$s]对应的实体方法", iPSDEAction.getId()));
      } else {
         return null;
      }
   }

   @Override
   public IPSDEDataSetMethod getPSDEDataSetMethod(IPSDEDataSet iPSDEDataSet, boolean bTryMode) throws Exception {
      return this.getPSDEDataSetMethod(iPSDEDataSet, null, null, bTryMode);
   }

   @Override
   public IPSDEDataSetMethod getPSDEDataSetMethod(IPSDEDataSet iPSDEDataSet, IPSDER1N iPSDER1N, String strParentKeyMode, boolean bTryMode) throws Exception {
      if (iPSDEDataSet == null) {
         throw new Exception(StringHelper.format("传入参数无效"));
      }

      Iterator<IPSDEMethod> psDEMethods = this.getAllPSDEMethods();
      if (psDEMethods != null) {
         while (psDEMethods.hasNext()) {
            IPSDEMethod iPSDEMethod = psDEMethods.next();
            if (iPSDEMethod instanceof IPSDEDataSetMethod) {
               IPSDEDataSetMethod iPSDEDataSetMethod = (IPSDEDataSetMethod)iPSDEMethod;
               if (iPSDEDataSetMethod.getPSDEDataSet() != null
                  && StringHelper.compare(iPSDEDataSetMethod.getPSDEDataSet().getId(), iPSDEDataSet.getId(), false) == 0) {
                  if (iPSDER1N == null && iPSDEDataSetMethod.getPSDER1N() == null) {
                     return iPSDEDataSetMethod;
                  }

                  if (iPSDER1N != null
                     && iPSDEDataSetMethod.getPSDER1N() != null
                     && StringHelper.compare(iPSDER1N.getId(), iPSDEDataSetMethod.getPSDER1N().getId(), false) == 0
                     && StringHelper.compare(strParentKeyMode, iPSDEDataSetMethod.getParentKeyMode(), false) == 0) {
                     return iPSDEDataSetMethod;
                  }
               }
            }
         }
      }

      if (!bTryMode) {
         throw new Exception(StringHelper.format("无法获取指定实体数据集[%1$s]对应的实体方法", iPSDEDataSet.getId()));
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "实体通知集合", child = true, dynamodelmode = 5, group = "处理逻辑", order = 300)
   @Override
   public Iterator<IPSDENotify> getAllPSDENotifies() throws Exception {
      return this.psDENotifyGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDENotify getPSDENotify(String strDENotifyId) throws Exception {
      return this.psDENotifyGlobalModel.FindModelHelper(strDENotifyId);
   }

   @Override
   public IPSDENotify getPSDENotify(String strDENotifyId, boolean bTryMode) throws Exception {
      return this.psDENotifyGlobalModel.FindModelHelper(strDENotifyId, bTryMode);
   }

   @Override
   public void resetPSDENotify(String strDENotifyId) throws Exception {
      this.psDENotifyGlobalModel.ResetModel(strDENotifyId);
   }

   @PSModelRTMeta(description = "实体递归关系", hideempty = true)
   @Override
   public IPSDER1N getRecursivePSDER1N() {
      Iterator<IPSDER1N> psDER1Ns = this.getMajorPSDER1Ns();
      if (psDER1Ns == null) {
         return null;
      }

      while (psDER1Ns.hasNext()) {
         IPSDER1N iPSDER1N = psDER1Ns.next();
         if (iPSDER1N.isRecursiveRS()) {
            return iPSDER1N;
         }
      }

      return null;
   }

   @Override
   public void tryLoad() throws Exception {
      if (!this.isInit()) {
         this.init();
      }

      this.internalPreparePSDEFields(true);
   }

   @PSModelRTMeta(description = "主状态行为控制逻辑模式", codelist = "DEMSActionLogicMode", dump = false)
   @Override
   public int getMSActionLogicMode() {
      return this.nMSActionLogicMode;
   }

   @PSModelRTMeta(description = "排序值", ignoredumpvalues = "99999")
   @Override
   public int getOrderValue() {
      return this.nOrderValue;
   }

   @PSModelRTMeta(description = "动态父类型属性", hideempty = true)
   @Override
   public IPSDEField getParentTypePSDEField() {
      try {
         return this.getPSDEFieldByPDT("PARENTTYPE", true);
      } catch (Exception e) {
         log.error(e);
         return null;
      }
   }

   @PSModelRTMeta(description = "动态父标识属性", hideempty = true)
   @Override
   public IPSDEField getParentIdPSDEField() {
      try {
         return this.getPSDEFieldByPDT("PARENTID", true);
      } catch (Exception e) {
         log.error(e);
         return null;
      }
   }

   @PSModelRTMeta(description = "动态父名称属性", hideempty = true)
   @Override
   public IPSDEField getParentNamePSDEField() {
      try {
         return this.getPSDEFieldByPDT("PARENTNAME", true);
      } catch (Exception e) {
         log.error(e);
         return null;
      }
   }

   @PSModelRTMeta(description = "组织标识属性", hideempty = true, dumpref = true, from = "__self__", dynamodelmode = 4)
   @Override
   public IPSDEField getOrgIdPSDEField() {
      try {
         return this.getPSDEFieldByPDT("ORGID", true);
      } catch (Exception e) {
         log.error(e);
         return null;
      }
   }

   @PSModelRTMeta(description = "支持建立")
   @Override
   public boolean isEnableCreate() {
      return (this.getEnableActions() & 1) == 1;
   }

   @PSModelRTMeta(description = "支持修改")
   @Override
   public boolean isEnableModify() {
      return (this.getEnableActions() & 2) == 2;
   }

   @PSModelRTMeta(description = "支持删除")
   @Override
   public boolean isEnableRemove() {
      return (this.getEnableActions() & 4) == 4;
   }

   @PSModelRTMeta(description = "支持界面建立", dump = false)
   @Override
   public boolean isEnableUICreate() {
      return (this.getEnableUIActions() & 1) == 1;
   }

   @PSModelRTMeta(description = "支持界面修改", dump = false)
   @Override
   public boolean isEnableUIModify() {
      return (this.getEnableUIActions() & 2) == 2;
   }

   @PSModelRTMeta(description = "支持界面删除", dump = false)
   @Override
   public boolean isEnableUIRemove() {
      return (this.getEnableUIActions() & 4) == 4;
   }

   @PSModelRTMeta(description = "业务标记", codelist = "DEBizTag", fields = "BIZTAG")
   @Override
   public String getBizTag() {
      return this.psDataEntity.getBIZTAG();
   }

   @Override
   protected int onGetDynaInstMode() {
      return this.nDynaInstMode;
   }

   @PSModelRTMeta(description = "动态实例模式", codelist = "DynaInstMode3")
   @Override
   public int getDynaInstMode() {
      return super.getDynaInstMode();
   }

   @PSModelRTMeta(description = "动态实例标记")
   @Override
   public String getDynaInstTag() {
      return super.getDynaInstTag();
   }

   @PSModelRTMeta(description = "动态实例标记2")
   @Override
   public String getDynaInstTag2() {
      return super.getDynaInstTag2();
   }

   @PSModelRTMeta(description = "实体方法DTO集合", child = true, ignorepf = true, group = "处理逻辑", order = 296)
   @Override
   public Iterator<IPSDEMethodDTO> getAllPSDEMethodDTOs() throws Exception {
      return this.psDEMethodDTOMap != null && this.psDEMethodDTOMap.size() != 0 ? this.psDEMethodDTOMap.values().iterator() : null;
   }

   @Override
   public IPSDEMethodDTO getPSDEMethodDTO(IPSDEFGroup iPSDEFGroup) throws Exception {
      if (iPSDEFGroup == null) {
         return this.getDefaultPSDEMethodDTO();
      }

      for (Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "DEFAULT", true) == 0
            && !entry.getValue().isDefaultMode()
            && entry.getValue().getPSDEFGroup() != null
            && StringHelper.compare(entry.getValue().getPSDEFGroup().getId(), iPSDEFGroup.getId(), false) == 0) {
            return entry.getValue();
         }
      }

      PSDEMethodDTOImpl psDEMethodDTOImpl = new PSDEMethodDTOImpl();
      psDEMethodDTOImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroup);
      if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
         throw new Exception(String.format("实体中已存在代码标识为[%1$s]的方法DTO对象", psDEMethodDTOImpl.getCodeName()));
      }

      this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
      return psDEMethodDTOImpl;
   }

   @Override
   public IPSDEMethodDTO getPSDEMethodDTO(IPSSysDynaModel iPSSysDynaModel) throws Exception {
      for (Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "DEFAULT", true) == 0
            && !entry.getValue().isDefaultMode()
            && entry.getValue().getSrcPSSysDynaModel() != null
            && StringHelper.compare(entry.getValue().getSrcPSSysDynaModel().getId(), iPSSysDynaModel.getId(), false) == 0) {
            return entry.getValue();
         }
      }

      PSDEMethodDTOImpl psDEMethodDTOImpl = new PSDEMethodDTOImpl();
      psDEMethodDTOImpl.initFromDynaModel(this.getDAGlobalHelper(), this, iPSSysDynaModel);
      if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
         throw new Exception(String.format("实体中已存在代码标识为[%1$s]的方法DTO对象", psDEMethodDTOImpl.getCodeName()));
      }

      this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
      return psDEMethodDTOImpl;
   }

   @Override
   public IPSLinkDEMethodDTO getPSLinkDEMethodDTO(IPSDataEntity iPSDataEntity, IPSDEFGroup iPSDEFGroup) throws Exception {
      for (Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "LINK", true) == 0) {
            IPSLinkDEMethodDTO iPSLinkDEMethodDTO = (IPSLinkDEMethodDTO)entry.getValue();
            if (iPSLinkDEMethodDTO.getRefPSDataEntity() != null
               && StringHelper.compare(iPSLinkDEMethodDTO.getRefPSDataEntity().getId(), iPSDataEntity.getId(), false) == 0) {
               if (iPSDEFGroup == null) {
                  if (iPSLinkDEMethodDTO.getRefPSDEFGroup() == null) {
                     return iPSLinkDEMethodDTO;
                  }
               } else if (iPSLinkDEMethodDTO.getRefPSDEFGroup() != null
                  && StringHelper.compare(iPSLinkDEMethodDTO.getRefPSDEFGroup().getId(), iPSDEFGroup.getId(), false) == 0) {
                  return iPSLinkDEMethodDTO;
               }
            }
         }
      }

      PSLinkDEMethodDTOImpl psDEMethodDTOImpl = new PSLinkDEMethodDTOImpl();
      psDEMethodDTOImpl.init(this.getDAGlobalHelper(), this, iPSDataEntity, iPSDEFGroup);
      if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
         throw new Exception(String.format("实体中已存在代码标识为[%1$s]的方法DTO对象", psDEMethodDTOImpl.getCodeName()));
      }

      this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
      return psDEMethodDTOImpl;
   }

   @Override
   public IPSLinkDEMethodDTO getPSLinkDEMethodDTO(IPSSysDynaModel iPSSysDynaModel) throws Exception {
      return null;
   }

   @PSModelRTMeta(description = "默认实体方法DTO", dumpref = true, dynamodelmode = 4, from = "__self__")
   @Override
   public IPSDEMethodDTO getDefaultPSDEMethodDTO() throws Exception {
      for (Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "DEFAULT", true) == 0 && entry.getValue().isDefaultMode()) {
            return entry.getValue();
         }
      }

      PSDEMethodDTOImpl psDEMethodDTOImpl = new PSDEMethodDTOImpl();
      psDEMethodDTOImpl.init(this.getDAGlobalHelper(), this, null);
      if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
         throw new Exception(String.format("实体中已存在代码标识为[%1$s]的方法DTO对象", psDEMethodDTOImpl.getCodeName()));
      }

      this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
      return psDEMethodDTOImpl;
   }

   @Override
   public IPSDEActionInputDTO getPSDEActionInputDTO(IPSDEActionInput iPSDEActionInput) throws Exception {
      for (Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "DEACTIONINPUT", true) == 0 && entry.getValue() instanceof IPSDEActionInputDTO) {
            IPSDEActionInputDTO iPSDEActionInputDTO = (IPSDEActionInputDTO)entry.getValue();
            if (iPSDEActionInputDTO.getPSDEActionInput() != null
               && StringHelper.compare(iPSDEActionInputDTO.getPSDEActionInput().getId(), iPSDEActionInput.getId(), false) == 0) {
               return iPSDEActionInputDTO;
            }
         }
      }

      PSDEActionInputDTOImpl psDEMethodDTOImpl = new PSDEActionInputDTOImpl();
      psDEMethodDTOImpl.init(this.getDAGlobalHelper(), this, iPSDEActionInput);
      if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
         throw new Exception(String.format("实体中已存在代码标识为[%1$s]的方法DTO对象", psDEMethodDTOImpl.getCodeName()));
      }

      this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
      return psDEMethodDTOImpl;
   }

   @Override
   public IPSDEDataSetInputDTO getPSDEDataSetInputDTO(IPSDEDataSetInput iPSDEDataSetInput) throws Exception {
      for (Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "DEDATASETINPUT", true) == 0 && entry.getValue() instanceof IPSDEDataSetInputDTO) {
            IPSDEDataSetInputDTO iPSDEDataSetInputDTO = (IPSDEDataSetInputDTO)entry.getValue();
            if (iPSDEDataSetInputDTO.getPSDEDataSetInput() != null
               && StringHelper.compare(iPSDEDataSetInputDTO.getPSDEDataSetInput().getId(), iPSDEDataSetInput.getId(), false) == 0) {
               return iPSDEDataSetInputDTO;
            }
         }
      }

      PSDEFilterDTOImpl psDEFilterDTOImpl = new PSDEFilterDTOImpl();
      psDEFilterDTOImpl.initFromDataSetInput(this.getDAGlobalHelper(), this, iPSDEDataSetInput);
      if (this.psDEMethodDTOMap.containsKey(psDEFilterDTOImpl.getCodeName())) {
         throw new Exception(String.format("实体中已存在代码标识为[%1$s]的方法DTO对象", psDEFilterDTOImpl.getCodeName()));
      }

      this.psDEMethodDTOMap.put(psDEFilterDTOImpl.getCodeName(), psDEFilterDTOImpl);
      return psDEFilterDTOImpl;
   }

   @Override
   public String getDEMethodDTOCodeName(IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
      String strCodeName = this.calcDEMethodDTOCodeName(iPSDEMethodDTO);
      if (StringHelper.isNullOrEmpty(strCodeName)) {
         throw new Exception(String.format("无法计算实体方法DTO代码标识"));
      }

      String strDTOFormat = this.getDTOCodeNameFormat();
      if (!StringHelper.isNullOrEmpty(strDTOFormat)) {
         strCodeName = String.format(strDTOFormat, strCodeName);
      }

      boolean bUnderscore = strCodeName.indexOf("_") == 0;
      strCodeName = this.getAPICodeName(null, strCodeName, null);
      if (bUnderscore && strCodeName.indexOf("_") != 0) {
         strCodeName = "_" + strCodeName;
      }

      return strCodeName;
   }

   protected String calcDEMethodDTOCodeName(IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
      if (this.isDTOUseServiceCodeName()) {
         if (StringHelper.compare(iPSDEMethodDTO.getType(), "DEFAULT", false) == 0) {
            if (iPSDEMethodDTO.getSrcPSSysDynaModel() != null) {
               return this.getAPICodeName(this.getServiceCodeName(), iPSDEMethodDTO.getSrcPSSysDynaModel().getCodeName(), null);
            }

            if (iPSDEMethodDTO.getPSDEFGroup() != null) {
               return this.getAPICodeName(this.getServiceCodeName(), iPSDEMethodDTO.getPSDEFGroup().getCodeName(), null);
            }

            return this.getServiceCodeName();
         }

         if (StringHelper.compare(iPSDEMethodDTO.getType(), "DEACTIONINPUT", false) == 0) {
            IPSDEActionInputDTO iPSDEActionInputDTO = (IPSDEActionInputDTO)iPSDEMethodDTO;
            if (iPSDEActionInputDTO.getPSDEActionInput() != null) {
               return this.getAPICodeName(this.getServiceCodeName(), iPSDEActionInputDTO.getPSDEActionInput().getCodeName(), null);
            }

            return null;
         }

         if (StringHelper.compare(iPSDEMethodDTO.getType(), "DEDATASETINPUT", false) == 0) {
            IPSDEDataSetInputDTO iPSDEDataSetInputDTO = (IPSDEDataSetInputDTO)iPSDEMethodDTO;
            if (iPSDEDataSetInputDTO.getPSDEDataSetInput() != null) {
               return this.getAPICodeName(this.getServiceCodeName(), iPSDEDataSetInputDTO.getPSDEDataSetInput().getCodeName(), "Filter");
            }

            return null;
         }

         if (StringHelper.compare(iPSDEMethodDTO.getType(), "DEFILTER", false) == 0) {
            if (iPSDEMethodDTO.getSrcPSSysDynaModel() != null) {
               return this.getAPICodeName(this.getServiceCodeName(), iPSDEMethodDTO.getSrcPSSysDynaModel().getCodeName(), "Filter");
            }

            if (iPSDEMethodDTO.getPSDEFGroup() != null) {
               return this.getAPICodeName(this.getServiceCodeName(), iPSDEMethodDTO.getPSDEFGroup().getCodeName(), "Filter");
            }

            return this.getAPICodeName(this.getServiceCodeName(), "Filter", null);
         }

         if (StringHelper.compare(iPSDEMethodDTO.getType(), "LINK", false) == 0) {
            IPSLinkDEMethodDTO iPSLinkDEMethodDTO = (IPSLinkDEMethodDTO)iPSDEMethodDTO;
            if (iPSLinkDEMethodDTO.getRefPSDEFGroup() != null) {
               return String.format(
                  "_%1$s",
                  this.getAPICodeName(iPSLinkDEMethodDTO.getRefPSDataEntity().getServiceCodeName(), iPSLinkDEMethodDTO.getRefPSDEFGroup().getCodeName(), null)
               );
            }

            return "_" + iPSLinkDEMethodDTO.getRefPSDataEntity().getServiceCodeName();
         }
      } else {
         if (StringHelper.compare(iPSDEMethodDTO.getType(), "DEFAULT", false) == 0) {
            if (iPSDEMethodDTO.getSrcPSSysDynaModel() != null) {
               return String.format("%1$s%2$s", this.getCodeName(), iPSDEMethodDTO.getSrcPSSysDynaModel().getCodeName());
            }

            if (iPSDEMethodDTO.getPSDEFGroup() != null) {
               return String.format("%1$s%2$s", this.getCodeName(), iPSDEMethodDTO.getPSDEFGroup().getCodeName());
            }

            return this.getCodeName();
         }

         if (StringHelper.compare(iPSDEMethodDTO.getType(), "DEACTIONINPUT", false) == 0) {
            IPSDEActionInputDTO iPSDEActionInputDTO = (IPSDEActionInputDTO)iPSDEMethodDTO;
            if (iPSDEActionInputDTO.getPSDEActionInput() != null) {
               return String.format("%1$s%2$s", this.getCodeName(), iPSDEActionInputDTO.getPSDEActionInput().getCodeName());
            }

            return null;
         }

         if (StringHelper.compare(iPSDEMethodDTO.getType(), "DEDATASETINPUT", false) == 0) {
            IPSDEDataSetInputDTO iPSDEDataSetInputDTO = (IPSDEDataSetInputDTO)iPSDEMethodDTO;
            if (iPSDEDataSetInputDTO.getPSDEDataSetInput() != null) {
               return String.format("%1$s%2$sFilter", this.getCodeName(), iPSDEDataSetInputDTO.getPSDEDataSetInput().getCodeName());
            }

            return null;
         }

         if (StringHelper.compare(iPSDEMethodDTO.getType(), "DEFILTER", false) == 0) {
            if (iPSDEMethodDTO.getSrcPSSysDynaModel() != null) {
               return String.format("%1$s%2$sFilter", this.getCodeName(), iPSDEMethodDTO.getSrcPSSysDynaModel().getCodeName());
            }

            if (iPSDEMethodDTO.getPSDEFGroup() != null) {
               return String.format("%1$s%2$sFilter", this.getCodeName(), iPSDEMethodDTO.getPSDEFGroup().getCodeName());
            }

            return String.format("%1$sFilter", this.getCodeName());
         }

         if (StringHelper.compare(iPSDEMethodDTO.getType(), "LINK", false) == 0) {
            IPSLinkDEMethodDTO iPSLinkDEMethodDTO = (IPSLinkDEMethodDTO)iPSDEMethodDTO;
            if (iPSLinkDEMethodDTO.getRefPSDEFGroup() != null) {
               return String.format("_%1$s%2$s", iPSLinkDEMethodDTO.getRefPSDataEntity().getCodeName(), iPSLinkDEMethodDTO.getRefPSDEFGroup().getCodeName());
            }

            return "_" + iPSLinkDEMethodDTO.getRefPSDataEntity().getCodeName();
         }
      }

      return null;
   }

   @Override
   public IPSDEFilterDTO getPSDEFilterDTO(IPSDEFGroup iPSDEFGroup) throws Exception {
      if (iPSDEFGroup == null) {
         return this.getDefaultPSDEFilterDTO();
      }

      for (Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "DEFILTER", true) == 0 && entry.getValue() instanceof IPSDEFilterDTO) {
            IPSDEFilterDTO iPSDEFilterDTO = (IPSDEFilterDTO)entry.getValue();
            if (!iPSDEFilterDTO.isDefaultMode()
               && iPSDEFilterDTO.getPSDEFGroup() != null
               && StringHelper.compare(iPSDEFilterDTO.getPSDEFGroup().getId(), iPSDEFGroup.getId(), false) == 0) {
               return iPSDEFilterDTO;
            }
         }
      }

      PSDEFilterDTOImpl psDEFilterDTOImpl = new PSDEFilterDTOImpl();
      psDEFilterDTOImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroup);
      if (this.psDEMethodDTOMap.containsKey(psDEFilterDTOImpl.getCodeName())) {
         throw new Exception(String.format("实体中已存在代码标识为[%1$s]的过滤器DTO对象", psDEFilterDTOImpl.getCodeName()));
      }

      this.psDEMethodDTOMap.put(psDEFilterDTOImpl.getCodeName(), psDEFilterDTOImpl);
      return psDEFilterDTOImpl;
   }

   @Override
   public IPSDEFilterDTO getPSDEFilterDTO(IPSSysDynaModel iPSSysDynaModel) throws Exception {
      for (Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "DEFILTER", true) == 0 && entry.getValue() instanceof IPSDEFilterDTO) {
            IPSDEFilterDTO iPSDEFilterDTO = (IPSDEFilterDTO)entry.getValue();
            if (!iPSDEFilterDTO.isDefaultMode()
               && iPSDEFilterDTO.getSrcPSSysDynaModel() != null
               && StringHelper.compare(iPSDEFilterDTO.getSrcPSSysDynaModel().getId(), iPSSysDynaModel.getId(), false) == 0) {
               return iPSDEFilterDTO;
            }
         }
      }

      PSDEFilterDTOImpl psDEFilterDTOImpl = new PSDEFilterDTOImpl();
      psDEFilterDTOImpl.initFromDynaModel(this.getDAGlobalHelper(), this, iPSSysDynaModel);
      if (this.psDEMethodDTOMap.containsKey(psDEFilterDTOImpl.getCodeName())) {
         throw new Exception(String.format("实体中已存在代码标识为[%1$s]的过滤器DTO对象", psDEFilterDTOImpl.getCodeName()));
      }

      this.psDEMethodDTOMap.put(psDEFilterDTOImpl.getCodeName(), psDEFilterDTOImpl);
      return psDEFilterDTOImpl;
   }

   @PSModelRTMeta(
      description = "默认实体过滤器DTO",
      dumpref = true,
      dynamodelmode = 4,
      from = "__self__",
      from_method = "getPSDEMethodDTO",
      origin = "IPSDEFilterDTO"
   )
   @Override
   public IPSDEFilterDTO getDefaultPSDEFilterDTO() throws Exception {
      for (Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "DEFILTER", true) == 0 && entry.getValue() instanceof IPSDEFilterDTO) {
            IPSDEFilterDTO iPSDEFilterDTO = (IPSDEFilterDTO)entry.getValue();
            if (iPSDEFilterDTO.isDefaultMode()) {
               return iPSDEFilterDTO;
            }
         }
      }

      PSDEFilterDTOImpl psDEFilterDTOImpl = new PSDEFilterDTOImpl();
      psDEFilterDTOImpl.init(this.getDAGlobalHelper(), this, null);
      if (this.psDEMethodDTOMap.containsKey(psDEFilterDTOImpl.getCodeName())) {
         throw new Exception(String.format("实体中已存在代码标识为[%1$s]的过滤器DTO对象", psDEFilterDTOImpl.getCodeName()));
      }

      this.psDEMethodDTOMap.put(psDEFilterDTOImpl.getCodeName(), psDEFilterDTOImpl);
      return psDEFilterDTOImpl;
   }

   public String getDTOCodeNameFormat() {
      return this.getPSSystemModule() != null ? this.getPSSystemModule().getDTOCodeNameFormat() : this.getPSSystem().getDTOCodeNameFormat();
   }

   @Override
   public String getPSSysModelGroupId() {
      return this.getPSSystemModule() != null && this.getPSSystemModule().getPSSysModelGroup() != null
         ? this.getPSSystemModule().getPSSysModelGroup().getId()
         : null;
   }

   @Override
   protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
      super.onFillModelRefNode(objectNode, strModelRefType);
      if (!StringHelper.isNullOrEmpty(strModelRefType) && "SYSTEM".equals(strModelRefType)) {
         objectNode.put("name", this.getName());
      }
   }

   @PSModelRTMeta(description = "后台扩展插件", hideempty = true)
   @Override
   public IPSSysSFPlugin getPSSysSFPlugin() {
      return this.iPSSysSFPlugin;
   }

   @PSModelRTMeta(description = "扩展绘制器", hideempty = true)
   @Override
   public IPSSFXCodeObject getRender() {
      return this.iPSSFXCodeObject;
   }

   @PSModelRTMeta(description = "实体附加模型数据集合", child = true, ignorepf = true, dynamodelmode = 4, outputdoc = "false")
   @Override
   public Iterator<IPSModelData> getAllPSModelDatas() throws Exception {
      return this.psModelDataMap != null && this.psModelDataMap.size() != 0 ? this.psModelDataMap.values().iterator() : null;
   }

   protected IPSModelData registerPSModelData(PSModelObj psModelObj) throws Exception {
      PSModelDataImpl psModelDataImpl = new PSModelDataImpl();
      psModelDataImpl.init(this.getDAGlobalHelper(), this, psModelObj);
      this.psModelDataMap.put(psModelDataImpl.getId(), psModelDataImpl);
      return psModelDataImpl;
   }

   @Override
   protected String onGetMOSFileName() {
      return this.getName();
   }

   @PSModelRTMeta(description = "实体标记", hideempty2 = true, fields = "DETAG")
   @Override
   public String getDETag() {
      return this.psDataEntity.getDETAG();
   }

   @PSModelRTMeta(description = "实体标记2", hideempty2 = true, fields = "DETAG2")
   @Override
   public String getDETag2() {
      return this.psDataEntity.getDETAG2();
   }

   @PSModelRTMeta(description = "默认大数据库体系", hideempty2 = true, dumpref = true, dynamodelmode = 4, group = "数据库存储", order = 378)
   @Override
   public IPSSysBDScheme getPSSysBDScheme() {
      try {
         Iterator<IPSDEBDTable> psDEBDTables = this.getAllPSDEBDTables();
         if (psDEBDTables != null && psDEBDTables.hasNext()) {
            IPSDEBDTable iPSDEBDTable = psDEBDTables.next();
            return iPSDEBDTable.getPSSysBDScheme();
         }

         Iterator<IPSSysBDScheme> psSysBDSchemes = this.getPSSystem().getAllPSSysBDSchemes();
         if (psSysBDSchemes != null && this.getPSSystemModule() != null) {
            while (psSysBDSchemes.hasNext()) {
               IPSSysBDScheme iPSSysBDScheme = psSysBDSchemes.next();
               if (iPSSysBDScheme.getPSSystemModule() != null
                  && StringHelper.compare(this.getPSSystemModule().getId(), iPSSysBDScheme.getPSSystemModule().getId(), false) == 0) {
                  return iPSSysBDScheme;
               }
            }
         }

         psSysBDSchemes = this.getPSSystem().getAllPSSysBDSchemes();
         if (psSysBDSchemes != null && !StringHelper.isNullOrEmpty(this.getPSSysModelGroupId())) {
            while (psSysBDSchemes.hasNext()) {
               IPSSysBDScheme iPSSysBDScheme = psSysBDSchemes.next();
               if (iPSSysBDScheme.getPSSysModelGroup() != null
                  && StringHelper.compare(this.getPSSysModelGroupId(), iPSSysBDScheme.getPSSysModelGroup().getId(), false) == 0) {
                  return iPSSysBDScheme;
               }
            }
         }
      } catch (Exception ex) {
         log.error(ex);
      }

      return null;
   }

   @PSModelRTMeta(description = "实体数据流逻辑集合", dynamodelmode = 4, child = true, dumpref = true, group = "处理逻辑", order = 288)
   @Override
   public Iterator<IPSDEDataFlow> getAllPSDEDataFlows() throws Exception {
      return this.psDEDataFlowGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEDataFlow getPSDEDataFlow(String strDEDataFlowId) throws Exception {
      return this.psDEDataFlowGlobalModel.FindModelHelper(strDEDataFlowId);
   }

   @Override
   public IPSDEDataFlow getPSDEDataFlow(String strDEDataFlowId, boolean bTryMode) throws Exception {
      return this.psDEDataFlowGlobalModel.FindModelHelper(strDEDataFlowId, bTryMode);
   }

   @Override
   public void resetPSDEDataFlow(String strDEDataFlowId) throws Exception {
      this.psDEDataFlowGlobalModel.ResetModel(strDEDataFlowId);
   }

   @PSModelRTMeta(description = "动态系统模式", codelist = "DEDynaSysMode", ignoredumpvalues = "0", fields = "ENABLEDYNASYS")
   @Override
   public int getDynaSysMode() {
      return this.nDEDynaSysMode;
   }

   @PSModelRTMeta(description = "联合主键模式", codelist = "DEUnionKeyMode", fields = "KEYRULE")
   @Override
   public String getUnionKeyMode() {
      return this.psDataEntity.getKEYRULE();
   }

   @PSModelRTMeta(description = "联合主键参数", fields = "VKEYSEPARATOR")
   @Override
   public String getUnionKeyParam() {
      return this.psDataEntity.getVKEYSEPARATOR();
   }

   @PSModelRTMeta(description = "服务代码标识模式", codelist = "CodeNameMode", dump = false)
   @Override
   public String getAPICodeNameMode() {
      return !StringHelper.isNullOrEmpty(this.psDataEntity.getCODENAMEMODE())
         ? this.psDataEntity.getCODENAMEMODE()
         : this.getPSSystemModule().getAPICodeNameMode();
   }

   @Override
   public String getAPICodeName(String strPrefix, String strCodeName, String strSuffix) {
      return PSModelCodeNameUtils.to(this.getAPICodeNameMode(), strPrefix, strCodeName, strSuffix);
   }

   @PSModelRTMeta(description = "DTO使用服务代码标识", dump = false)
   @Override
   public boolean isDTOUseServiceCodeName() {
      return !StringHelper.isNullOrEmpty(this.getAPICodeNameMode()) && !"NONE".equalsIgnoreCase(this.getAPICodeNameMode());
   }

   @PSModelRTMeta(description = "启用PQL", dump = false, ignoredumpvalues = "false", fields = "ENABLEPQL")
   @Override
   public boolean isEnablePQL() {
      if (!this.psDataEntity.isENABLEPQLNull()) {
         return this.psDataEntity.getENABLEPQL();
      } else {
         return this.getPSSystemModule() != null ? this.getPSSystemModule().isEnablePQL() : false;
      }
   }

   @PSModelRTMeta(description = "实体默认统一资源", dump = false, fields = "PSSYSUNIRESID")
   @Override
   public IPSSysUniRes getPSSysUniRes() {
      return this.iPSSysUniRes;
   }
}
