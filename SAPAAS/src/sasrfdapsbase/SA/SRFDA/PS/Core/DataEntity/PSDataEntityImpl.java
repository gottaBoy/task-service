/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IDEACMode
 *  net.ibizsys.paas.core.IDEAction
 *  net.ibizsys.paas.core.IDEActionWizard
 *  net.ibizsys.paas.core.IDEActionWizardGroup
 *  net.ibizsys.paas.core.IDEBATable
 *  net.ibizsys.paas.core.IDEDBConfig
 *  net.ibizsys.paas.core.IDEDataExport
 *  net.ibizsys.paas.core.IDEDataImport
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataSet
 *  net.ibizsys.paas.core.IDEDataSync
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDELogic
 *  net.ibizsys.paas.core.IDEMainState
 *  net.ibizsys.paas.core.IDEOPPrivRole
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.core.IDERIndex
 *  net.ibizsys.paas.core.IDEUIAction
 *  net.ibizsys.paas.core.IDEUniState
 *  net.ibizsys.paas.core.IDEUserRole
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.data.ISimpleDataObject
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
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
import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityRuntime;
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
import SA.SRFDA.PS.Core.DataEntity.PSDEGroupGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
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
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodImplBase;
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
import SA.SRFDA.PS.Core.IPSModelData;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelDataImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
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
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
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
public class PSDataEntityImpl
extends PSSystemObjectImpl
implements IPSDataEntity,
IPSDataEntityRuntime,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDataEntityImpl.class);
    private static final Map<String, String> MSCtrlActionModeMap = new HashMap<String, String>();
    private static final Map<String, String> DynaInstWFEditViewMap = new HashMap<String, String>();
    public static final String CODETYPE_SUBSYS = "SUBSYS_";
    public static final String MODELGROUP_MODEL = "\u6a21\u578b";
    public static final String MODELGROUP_FIELD = "\u5c5e\u6027\u9ad8\u7ea7";
    public static final String MODELGROUP_PERSISTENT = "\u6301\u4e45\u5316";
    public static final String MODELGROUP_DER = "\u5173\u7cfb\u9ad8\u7ea7";
    public static final String MODELGROUP_LOGIC = "\u5904\u7406\u903b\u8f91";
    public static final String MODELGROUP_MAINSTATE = "\u72b6\u6001\u63a7\u5236";
    public static final String MODELGROUP_DB = "\u6570\u636e\u5e93\u5b58\u50a8";
    public static final String MODELGROUP_UTIL = "\u529f\u80fd\u914d\u7f6e";
    public static final String MODELGROUP_REPORT = "\u6253\u5370\u53ca\u62a5\u8868";
    public static final String MODELGROUP_ACCCTRL = "\u8bbf\u95ee\u63a7\u5236";
    public static final String MODELGROUP_TEST = "\u6d4b\u8bd5";
    public static final String MODELGROUP_ADVMODEL = "\u6a21\u578b\u9ad8\u7ea7";
    public static final String[] MODELGROUPS;
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
    private ArrayList<IPSDEField> unionKeyValueFieldList = new ArrayList();
    private ArrayList<IPSDEField> mainStateFieldList = new ArrayList();
    private ArrayList<IPSDataEntity> masterPSDataEntityList = new ArrayList();
    private TreeMap<String, PSDEViewBase> predefineDEViewMap = new TreeMap();
    private ArrayList<PSDEViewBase> psDEViewBaseList = new ArrayList();
    private ArrayList<PSDEForm> psDEEditFormList = new ArrayList();
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
    public static final String[] SDPDTVIEWS;
    public static final String[] MOBSDPDTVIEWS;
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
    private Map<String, IPSDEMethodDTO> psDEMethodDTOMap = new TreeMap<String, IPSDEMethodDTO>();
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private Map<String, IPSModelData> psModelDataMap = new LinkedHashMap<String, IPSModelData>();
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
        MODELGROUPS = new String[]{"\u57fa\u672c", MODELGROUP_MODEL, MODELGROUP_FIELD, MODELGROUP_PERSISTENT, MODELGROUP_DER, MODELGROUP_LOGIC, MODELGROUP_MAINSTATE, MODELGROUP_DB, MODELGROUP_UTIL, MODELGROUP_REPORT, MODELGROUP_ACCCTRL, MODELGROUP_TEST, MODELGROUP_ADVMODEL, "\u7528\u6237\u6269\u5c55", "\u5176\u5b83"};
        SDPDTVIEWS = new String[]{"EDITVIEW", "WFEDITVIEW"};
        MOBSDPDTVIEWS = new String[]{"MOBEDITVIEW", "MOBWFEDITVIEW"};
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
        if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.psDataEntity.getPSDATAENTITYNAME().toLowerCase();
        }
        if (!StringHelper.isNullOrEmpty((String)this.strCodeName) && !iPSSystem.getPSSystemSetting().isFixCodeNameAutoCapitalize()) {
            String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
            this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
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
        if (!StringHelper.isNullOrEmpty((String)this.getIndexDEType())) {
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
            boolean bl = this.bEnableMultiStorage = (this.nStorageMode & 8) == 8;
            if (this.bEnableMultiStorage) {
                this.nStorageMode ^= 8;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getDSLINK())) {
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
        this.bNoViewMode = !this.psDataEntity.isNOVIEWMODENull() ? this.psDataEntity.getNOVIEWMODE() : iPSSystem.isNoViewMode();
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
        this.nServiceAPIMode = !this.psDataEntity.isSERVICEAPIFLAGNull() ? this.psDataEntity.getSERVICEAPIFLAG() : this.getPSSystemSetting().getServiceAPIMode();
        if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getSERVICECODENAME())) {
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
            if (!StringHelper.isNullOrEmpty((String)this.strLogicValidValue)) {
                this.strLogicInvalidValue = this.psDataEntity.getLOGICINVALIDVALUE();
                if (StringHelper.isNullOrEmpty((String)this.strLogicInvalidValue)) {
                    this.strLogicValidValue = "";
                }
            }
        }
        this.bSortByName = StringHelper.compare((String)this.getPSSystemSetting().getDEFieldSortMode(), (String)"NAME", (boolean)false) == 0;
        this.bSortByCreateDate = StringHelper.compare((String)this.getPSSystemSetting().getDEFieldSortMode(), (String)"CREATEDATE", (boolean)false) == 0;
        boolean bl = this.bSortByName_PDT = StringHelper.compare((String)this.getPSSystemSetting().getDEFieldSortMode(), (String)"NAME_PDT", (boolean)false) == 0;
        if (this.bSortByName_PDT) {
            this.bSortByName = true;
            this.bSortPDT = true;
        }
        boolean bl2 = this.bSortByCreateDate_PDT = StringHelper.compare((String)this.getPSSystemSetting().getDEFieldSortMode(), (String)"CREATEDATE_PDT", (boolean)false) == 0;
        if (this.bSortByCreateDate_PDT) {
            this.bSortByCreateDate = true;
            this.bSortPDT = true;
        }
        this.nDataAccCtrlArch = !this.psDataEntity.isACCCTRLARCHNull() ? this.psDataEntity.getACCCTRLARCH() : this.getPSSystemSetting().getDataAccCtrlArch();
        if (!this.psDataEntity.isDYNAMICMODENull()) {
            boolean bl3 = this.bEnableDynaSys = this.psDataEntity.getDYNAMICMODE() == 1;
        }
        if (!this.psDataEntity.isENABLEDYNASYSNull()) {
            this.nDEDynaSysMode = this.psDataEntity.getENABLEDYNASYS();
        }
        this.bEnableDataVer = !this.psDataEntity.isENABLEDATAVERNull() ? this.psDataEntity.getENABLEDATAVER() : this.getPSSystemSetting().isEnableDEDataVer();
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
        if (this.bInit) {
            return;
        }
        try {
            PSModelObj psModelObj;
            this.bInit = true;
            this.classOrPkgNameMap = PropertiesHelper.Load((String)this.psDataEntity.getBASECLSPARAMS());
            if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psDataEntity.getPSMODULEID());
            }
            if (this.getPSSystemModule() == null) {
                throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u6240\u5c5e\u6240\u5c5e\u7cfb\u7edf\u6a21\u5757");
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
                if (!this.bDSLinkDefined && !StringHelper.isNullOrEmpty((String)this.getPSSystemModule().getDSLink())) {
                    this.strDSLink = this.getPSSystemModule().getDSLink();
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.getDSLink())) {
                this.iPSSysDBScheme = this.getPSSystem().getPSSysDBScheme(this.getPSSysModelGroupId(), this.getDSLink(), true);
            }
            if (!this.bSubSysDE && this.iPSSysSFPub != null && !this.iPSSysSFPub.isMainPSSysSFPub()) {
                throw new Exception("\u5b9e\u4f53\u6240\u5c5e\u6a21\u5757\u540e\u53f0\u670d\u52a1\u4f53\u7cfb\u5fc5\u987b\u4e3a\u4e3b\u4f53\u7cfb");
            }
            this.nMSActionLogicMode = !this.psDataEntity.isMSACTIONLOGICFLAGNull() ? this.psDataEntity.getMSACTIONLOGICFLAG() : (!this.bSubSysDE ? this.getPSSystemSetting().getDEMSActionLogicMode() : this.getPSSystemSetting().getSubSysDEMSActionLogicMode());
            if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psDataEntity.getPSSYSIMAGEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getLNPSLANRESID())) {
                this.lnPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psDataEntity.getLNPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSSystem().getPSSysUniRes(this.psDataEntity.getPSSYSUNIRESID());
            }
            Vector<PSDEField> defields = new Vector<PSDEField>();
            CallResult callResult = this.getPSModelHelper().getPSDEFieldsNoSort(this.getId(), defields);
            if (callResult == null || callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\u9519\u8bef");
            }
            PSDEField indexTypePSDEField = null;
            PSDEField formTypePSDEField = null;
            for (PSDEField defield : defields) {
                if (defield.getINDEXTYPE()) {
                    if (indexTypePSDEField == null) {
                        indexTypePSDEField = defield;
                    } else {
                        throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u7ecf\u5b58\u5728\u7d22\u5f15\u7c7b\u578b\u5c5e\u6027[%2$s]\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49[%3$s]", (Object)this.getName(), (Object)indexTypePSDEField.getPSDEFIELDNAME(), (Object)defield.getPSDEFIELDNAME()));
                    }
                }
                if (!defield.getMULTIFORMFIELD()) continue;
                if (formTypePSDEField == null) {
                    formTypePSDEField = defield;
                    continue;
                }
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u7ecf\u5b58\u5728\u8868\u5355\u7c7b\u578b\u5c5e\u6027[%2$s]\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49[%3$s]", (Object)this.getName(), (Object)formTypePSDEField.getPSDEFIELDNAME(), (Object)defield.getPSDEFIELDNAME()));
            }
            Vector<PSDEViewBase> psDEViewBaseList = new Vector<PSDEViewBase>();
            callResult = this.getPSModelHelper().getPSDEViews(this.getId(), psDEViewBaseList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u89c6\u56fe\u96c6\u5408\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
            }
            this.psDEViewBaseList.addAll(psDEViewBaseList);
            for (PSDEViewBase psDEViewBase : this.psDEViewBaseList) {
                psModelObj = new PSModelObj();
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
            psDEViewBaseList = new Vector();
            callResult = this.getPSModelHelper().getPSDEPredefinedViews(this.getId(), psDEViewBaseList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u9884\u7f6e\u89c6\u56fe\u96c6\u5408\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
            }
            for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
                String strPDViewType = psDEViewBase.getPREDEFINEVIEWTYPE();
                if (!StringHelper.isNullOrEmpty((String)psDEViewBase.getPDVTPARAM())) {
                    strPDViewType = String.valueOf(strPDViewType) + StringHelper.format((String)":%1$s", (Object)psDEViewBase.getPDVTPARAM());
                }
                if (this.predefineDEViewMap.containsKey(strPDViewType)) {
                    throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u5b58\u5728\u9884\u7f6e\u89c6\u56fe\u7c7b\u578b[%2$s]\uff0c\u65e0\u6cd5\u91cd\u590d\u6ce8\u518c", (Object)this.getName(), (Object)strPDViewType));
                }
                this.predefineDEViewMap.put(strPDViewType, psDEViewBase);
            }
            Vector<PSDEForm> psDEEditFormList = new Vector<PSDEForm>();
            callResult = this.getPSModelHelper().getPSDEEditForms(this.getId(), psDEEditFormList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u7f16\u8f91\u8868\u5355\u96c6\u5408\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
            }
            this.psDEEditFormList.addAll(psDEEditFormList);
            for (PSDEForm psDEForm : this.psDEEditFormList) {
                psModelObj = new PSModelObj();
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
            Vector<PSDEACMode> psDEACModeList = new Vector<PSDEACMode>();
            callResult = this.getPSModelHelper().getPSDEACModes(this.getId(), psDEACModeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSDEACMode psDEACMode : psDEACModeList) {
                if (psDEACMode.isDEFAULTMODENull() || !psDEACMode.getDEFAULTMODE()) continue;
                this.defaultPSDEACModeData = psDEACMode;
                break;
            }
            Vector<PSDEPrint> psDEPrintList = new Vector<PSDEPrint>();
            callResult = this.getPSModelHelper().getPSDEPrints(this.getId(), psDEPrintList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6253\u5370\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSDEPrint psDEPrint : psDEPrintList) {
                if (this.defaultPSDEPrintData != null && !psDEPrint.getDEFAULTMODE()) continue;
                this.defaultPSDEPrintData = psDEPrint;
                break;
            }
            String strPSSysSFPluginId = this.psDataEntity.getPSSYSSFPLUGINID();
            if (StringHelper.isNullOrEmpty((String)strPSSysSFPluginId) && this.getPSSystemModule() != null) {
                strPSSysSFPluginId = this.getPSSystemModule().getDEPSSysSFPluginId();
            }
            if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
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
        log.debug((Object)StringHelper.format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u5c5e\u6027\u5f00\u59cb", (Object)this.getName()));
        this.onBeforePreparePSDEFields();
        try {
            IPSDEField iPSDEField;
            String strKey;
            Object psDEField;
            this.keyDEField = null;
            this.majorDEField = null;
            this.indexTypeDEField = null;
            this.uniTagDEField = null;
            this.formTypeDEField = null;
            this.psDEFValueRuleMap = null;
            this.psDEFValueRuleList = null;
            this.quickSearchPSDEFieldList = null;
            this.defHelpers = new ArrayList();
            this.deFieldList = new ArrayList();
            this.defHelperMap = new Hashtable();
            this.preDefineFields = new Hashtable();
            Vector<PSDEField> defields2 = new Vector<PSDEField>();
            CallResult callResult = this.getPSModelHelper().getPSDEFieldsNoSort(this.getId(), defields2);
            if (callResult == null || callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\u9519\u8bef");
            }
            Vector<PSDEField> defields = new Vector<PSDEField>();
            for (PSDEField psDEField2 : defields2) {
                if (psDEField2.GetParamIntValue("VALIDFLAG", 1) != 1) continue;
                defields.add(psDEField2);
            }
            HashMap<String, PSDEField> psDEFieldMap = new HashMap<String, PSDEField>();
            for (PSDEField psDEField3 : defields) {
                psDEFieldMap.put(psDEField3.getPSDEFIELDID(), psDEField3);
            }
            Vector<PSDEFUIMode> psDEFUIModeList = new Vector<PSDEFUIMode>();
            callResult = this.getPSModelHelper().getPSDEFUIModesByDataEntity(this.getId(), psDEFUIModeList);
            if (callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e\u9519\u8bef");
            }
            for (PSDEFUIMode psDEFUIMode : psDEFUIModeList) {
                Object psDEField4 = (PSDEField)((Object)psDEFieldMap.get(psDEFUIMode.getPSDEFID()));
                if (psDEField4 == null) continue;
                psDEField4.getPSDEFUIModes(true).add(psDEFUIMode);
            }
            Vector<PSDEFSearchMode> psDEFSearchModeList = new Vector<PSDEFSearchMode>();
            callResult = this.getPSModelHelper().getPSDEFSearchModesByDataEntity(this.getId(), psDEFSearchModeList);
            if (callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u9519\u8bef");
            }
            for (PSDEFSearchMode psDEFSearchMode : psDEFSearchModeList) {
                Object psDEField5 = (PSDEField)((Object)psDEFieldMap.get(psDEFSearchMode.getPSDEFID()));
                if (psDEField5 == null) continue;
                psDEField5.getPSDEFSearchModes(true).add(psDEFSearchMode);
            }
            Vector<PSDEFValueRule> psDEFValueRuleList = new Vector<PSDEFValueRule>();
            callResult = this.getPSModelHelper().getPSDEFValueRulesByDataEntity(this.getId(), psDEFValueRuleList);
            if (callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u9519\u8bef");
            }
            for (PSDEFValueRule psDEFValueRule : psDEFValueRuleList) {
                psDEField = (PSDEField)((Object)psDEFieldMap.get(psDEFValueRule.getPSDEFID()));
                if (psDEField == null) continue;
                psDEField.getPSDEFValueRules(true).add(psDEFValueRule);
            }
            Iterator psDEFInputTipList = new Vector<PSDEFInputTip>();
            callResult = this.getPSModelHelper().getPSDEFInputTipsByDataEntity(this.getId(), (Vector<PSDEFInputTip>)((Object)psDEFInputTipList));
            if (callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u9519\u8bef");
            }
            psDEField = ((Vector)((Object)psDEFInputTipList)).iterator();
            while (psDEField.hasNext()) {
                Object psDEField6;
                PSDEFInputTip psDEFInputTip = (PSDEFInputTip)((Object)psDEField.next());
                if (!psDEFInputTip.isVALIDFLAGNull() && !psDEFInputTip.getVALIDFLAG() || (psDEField6 = (PSDEField)((Object)psDEFieldMap.get(psDEFInputTip.getPSDEFID()))) == null) continue;
                ((PSDEField)((Object)psDEField6)).getPSDEFInputTips(true).add(psDEFInputTip);
            }
            Vector<PSSysSearchDEField> psSysSearchDEFieldList = new Vector<PSSysSearchDEField>();
            callResult = this.getPSModelHelper().getPSSysSearchDEFieldsByDataEntity(this.getId(), psSysSearchDEFieldList);
            if (callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u5168\u6587\u68c0\u7d22\u9519\u8bef");
            }
            for (PSSysSearchDEField psSysSearchDEField : psSysSearchDEFieldList) {
                PSDEField psDEField7 = (PSDEField)((Object)psDEFieldMap.get(psSysSearchDEField.getPSDEFID()));
                if (psDEField7 == null) continue;
                psDEField7.getPSSysSearchDEFields(true).add(psSysSearchDEField);
            }
            Vector<PSDEField> normaldefields = new Vector<PSDEField>();
            Vector<PSDEField> pickupdefields = new Vector<PSDEField>();
            Vector<PSDEField> pickupdatadefields = new Vector<PSDEField>();
            for (PSDEField deField : defields) {
                int nDEFType = deField.getDEFTYPE();
                if (nDEFType == 2) {
                    normaldefields.add(deField);
                    continue;
                }
                String strDataType = deField.getPSDATATYPEID();
                if (StringHelper.compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
                    pickupdatadefields.add(deField);
                    continue;
                }
                if (StringHelper.compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0) {
                    pickupdefields.add(deField);
                    continue;
                }
                normaldefields.add(deField);
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
            if (StringHelper.compare((String)this.getPSSystemUtil().getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
                this.preDefineFields.put("ORDERVALUE", "ORDERVALUE");
            }
            for (PSDEField deField : normaldefields) {
                IPSDEField iDEField = this.createPSDEField(deField);
                if (iDEField == null) continue;
                this.defHelpers.add(iDEField);
                this.defHelperMap.put(deField.getPSDEFIELDID().toUpperCase(), iDEField);
                this.defHelperMap.put(deField.getPSDEFIELDNAME().toUpperCase(), iDEField);
            }
            for (PSDEField deField : pickupdatadefields) {
                IPSDEField iDEField = this.createPSDEField(deField);
                if (iDEField == null) continue;
                this.defHelpers.add(iDEField);
                this.defHelperMap.put(deField.getPSDEFIELDID().toUpperCase(), iDEField);
                this.defHelperMap.put(deField.getPSDEFIELDNAME().toUpperCase(), iDEField);
            }
            for (PSDEField deField : pickupdefields) {
                IPSDEField iDEField = this.createPSDEField(deField);
                if (iDEField == null) continue;
                this.defHelpers.add(iDEField);
                this.defHelperMap.put(deField.getPSDEFIELDID().toUpperCase(), iDEField);
                this.defHelperMap.put(deField.getPSDEFIELDNAME().toUpperCase(), iDEField);
            }
            HashMap<String, IPSDEField> unionKeyValueMap = new HashMap<String, IPSDEField>();
            HashMap<String, IPSDEField> mainStateFieldMap = new HashMap<String, IPSDEField>();
            for (IPSDEField iDEField : this.defHelpers) {
                if (iDEField.isInit()) continue;
                try {
                    iDEField.init();
                }
                catch (Exception psDEField6) {
                    // empty catch block
                }
            }
            for (IPSDEField iDEField : this.defHelpers) {
                if (iDEField.isInit()) continue;
                try {
                    iDEField.init();
                }
                catch (Exception psDEField6) {
                    // empty catch block
                }
            }
            for (IPSDEField iDEField : this.defHelpers) {
                this.deFieldList.add(iDEField);
                if (!iDEField.isInit()) {
                    try {
                        iDEField.init();
                    }
                    catch (Exception ex) {
                        throw new Exception(StringHelper.format((String)"\u521d\u59cb\u5316\u5c5e\u6027[%1$s][%2$s]\u5931\u8d25\uff0c\u539f\u56e0\uff1a%3$s", (Object)this.getName(), (Object)iDEField.getName(), (Object)ex.getMessage()), ex);
                    }
                }
                if (iDEField.isKeyDEField()) {
                    this.keyDEField = iDEField;
                }
                if (iDEField.isUniTagField()) {
                    if (!DataTypeHelper.isStringDataType((int)iDEField.getStdDataType())) {
                        throw new Exception(StringHelper.format((String)"[%1$s]\u552f\u4e00\u4e1a\u52a1\u6807\u8bb0\u5c5e\u6027[%2$s]\u6807\u51c6\u7c7b\u578b\u5fc5\u987b\u4e3a[\u5b57\u7b26\u4e32]", (Object)this.getName(), (Object)iDEField.getName()));
                    }
                    this.uniTagDEField = iDEField;
                }
                if (iDEField.isMajorDEField()) {
                    this.majorDEField = iDEField;
                }
                if (iDEField.isKeyNameDEField()) {
                    this.keyNameDEField = iDEField;
                }
                if (!StringHelper.isNullOrEmpty((String)iDEField.getUnionKeyValue()) && !iDEField.isKeyDEField()) {
                    unionKeyValueMap.put(iDEField.getUnionKeyValue(), iDEField);
                }
                if (!StringHelper.isNullOrEmpty((String)iDEField.getDEMSFieldMode())) {
                    mainStateFieldMap.put(iDEField.getDEMSFieldMode(), iDEField);
                }
                if (!StringHelper.isNullOrEmpty((String)iDEField.getBizTag())) {
                    String strBizTag = StringHelper.format((String)"%1$s#%2$s", (Object)SRFBIZTAG, (Object)iDEField.getBizTag());
                    this.defHelperMap.put(strBizTag, iDEField);
                }
                if (iDEField.isIndexTypeDEField()) {
                    if (this.indexTypeDEField != null) {
                        throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u7ecf\u5b58\u5728\u7d22\u5f15\u7c7b\u578b\u5c5e\u6027[%2$s]\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49[%3$s]", (Object)this.getName(), (Object)this.indexTypeDEField.getName(), (Object)iDEField.getName()));
                    }
                    this.indexTypeDEField = iDEField;
                }
                if (iDEField.isFormTypeDEField()) {
                    if (this.formTypeDEField != null) {
                        throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u7ecf\u5b58\u5728\u8868\u5355\u7c7b\u578b\u5c5e\u6027[%2$s]\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49[%3$s]", (Object)this.getName(), (Object)this.formTypeDEField.getName(), (Object)iDEField.getName()));
                    }
                    this.formTypeDEField = iDEField;
                }
                if (this.isExistingModel()) {
                    if (StringHelper.isNullOrEmpty((String)iDEField.getPSDEFieldData().getPREDEFINETYPE()) || StringHelper.compare((String)iDEField.getPSDEFieldData().getPREDEFINETYPE(), (String)"NONE", (boolean)true) == 0) continue;
                    this.preDefineFields.put(iDEField.getPSDEFieldData().getPREDEFINETYPE(), iDEField.getName());
                    continue;
                }
                if (StringHelper.compare((String)iDEField.getPSDEFieldData().getPREDEFINETYPE(), (String)"NONE", (boolean)true) == 0 || StringHelper.isNullOrEmpty((String)iDEField.getPSDEFieldData().getPREDEFINETYPE())) continue;
                this.preDefineFields.put(iDEField.getPSDEFieldData().getPREDEFINETYPE(), iDEField.getName());
            }
            for (String strPreDefineType : this.preDefineFields.keySet()) {
                String strField = this.preDefineFields.get(strPreDefineType);
                IPSDEField iPSDEField2 = this.defHelperMap.get(strField.toUpperCase());
                if (iPSDEField2 == null) continue;
                if (StringHelper.compare((String)iPSDEField2.getPSDEFieldData().getPREDEFINETYPE(), (String)"NONE", (boolean)true) != 0) {
                    if (StringHelper.isNullOrEmpty((String)iPSDEField2.getPSDEFieldData().getPREDEFINETYPE())) {
                        if (!iPSDEField2.isKeyDEField()) {
                            iPSDEField2.setPreDefinedType(strPreDefineType);
                            continue;
                        }
                        this.preDefineFields.put(strPreDefineType, "");
                        continue;
                    }
                    iPSDEField2.setPreDefinedType(strPreDefineType);
                    continue;
                }
                this.preDefineFields.put(strPreDefineType, "");
            }
            this.unionKeyValueFieldList.clear();
            int i = 1;
            while (i < 9) {
                strKey = StringHelper.format((String)"KEY%1$s", (Object)i);
                iPSDEField = (IPSDEField)unionKeyValueMap.get(strKey);
                if (iPSDEField != null) {
                    this.unionKeyValueFieldList.add(iPSDEField);
                }
                ++i;
            }
            this.mainStateFieldList.clear();
            i = 1;
            while (i < 4) {
                strKey = StringHelper.format((String)"STATE%1$s", (Object)i);
                iPSDEField = (IPSDEField)mainStateFieldMap.get(strKey);
                if (iPSDEField != null) {
                    this.mainStateFieldList.add(iPSDEField);
                }
                ++i;
            }
            if (this.keyDEField == null) {
                log.warn((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b58\u5728\u952e\u503c\u5c5e\u6027\uff0c\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef!", (Object)this.getFullName()));
            }
            if (this.majorDEField == null) {
                log.warn((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b58\u5728\u4e3b\u6587\u672c\u5c5e\u6027\uff0c\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef!", (Object)this.getFullName()));
            }
            Collections.sort(this.defHelpers, new Comparator<IPSDEField>(){

                @Override
                public int compare(IPSDEField arg0, IPSDEField arg1) {
                    int nValue = arg0.getOrderValue() - arg1.getOrderValue();
                    if (nValue == 0) {
                        if (PSDataEntityImpl.this.bSortPDT && (nValue = PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg0) - PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg1)) != 0) {
                            return new Integer(PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg0)).compareTo(PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg1));
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
        }
        catch (Exception ex) {
            this.defHelpers = null;
            this.defHelperMap = null;
            this.preDefineFields = null;
            if (bException) {
                throw ex;
            }
            log.error((Object)"\u51c6\u5907\u5b9e\u4f53\u5c5e\u6027\u5931\u8d25", (Throwable)ex);
            return false;
        }
        log.debug((Object)StringHelper.format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u5c5e\u6027\u7ed3\u675f\uff0c\u8017\u65f6[%2$s]", (Object)this.getName(), (Object)(new Date().getTime() - nStartTick)));
        return this.onAfterPreparePSDEFields();
    }

    protected int getPSDEFieldPDTOrder(IPSDEField iPSDEField) {
        if (iPSDEField.isKeyDEField()) {
            return 10;
        }
        if (iPSDEField.isUniTagField()) {
            return 15;
        }
        if (iPSDEField.isMajorDEField()) {
            return 20;
        }
        if (iPSDEField.isKeyNameDEField()) {
            return 25;
        }
        if (iPSDEField.isIndexTypeDEField()) {
            return 30;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"LOGICVALID", (boolean)false) == 0) {
            return 50;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"CREATEMAN", (boolean)false) == 0) {
            return 60;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"CREATEMANNAME", (boolean)false) == 0) {
            return 65;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"CREATEDATE", (boolean)false) == 0) {
            return 70;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"UPDATEMAN", (boolean)false) == 0) {
            return 80;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"UPDATEMANNAME", (boolean)false) == 0) {
            return 85;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"UPDATEDATE", (boolean)false) == 0) {
            return 90;
        }
        return 1000;
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
            throw new Exception("\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\u65e0\u6548");
        }
        return this.defHelpers.iterator();
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
        }
        if (bTryMode) {
            return null;
        }
        throw PSDataEntityException.create(this, 20000, strDEFieldName);
    }

    protected IPSDEField createPSDEField(PSDEField psDEField) throws Exception {
        IPSDEFieldType iPSDEFieldType = this.getPSSystem().getPSDEFieldTypeByDEField(psDEField);
        if (iPSDEFieldType == null) {
            log.error((Object)StringHelper.format((String)"\u5c5e\u6027[%1$s]\u65e0\u6cd5\u83b7\u53d6\u5bf9\u5e94\u7684\u7c7b\u578b\u5bf9\u8c61", (Object)psDEField.getPSDEFIELDNAME()));
            return null;
        }
        IPSDEField iPSDEField = iPSDEFieldType.createPSDEField(psDEField);
        iPSDEField.setInitParam(this.getDAGlobalHelper(), this, iPSDEFieldType, psDEField);
        return iPSDEField;
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    public Iterator<IDEField> getDEFields() throws Exception {
        return this.deFieldList.iterator();
    }

    public IDEField getDEField(String strDEFieldName, boolean bTryMode) throws Exception {
        return this.getPSDEField(strDEFieldName, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u8868\u540d\u79f0", dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=374, fields={"TABLENAME"})
    public String getTableName() {
        try {
            if (this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) {
                return this.psDataEntity.getTABLENAME();
            }
        }
        catch (Exception e) {
            log.error((Object)e);
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u540d\u79f0", dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=379, fields={"VIEWNAME"})
    public String getViewName() {
        try {
            if ((this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) && !this.isNoViewMode()) {
                return this.psDataEntity.getVIEWNAME();
            }
        }
        catch (Exception e) {
            log.error((Object)e);
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u903b\u8f91\u6709\u6548", dynamodelmode=4, fields={"LOGICVALID"})
    public boolean isLogicValid() {
        return this.bLogicValid;
    }

    @Override
    public Object getLogicValidValue(boolean bValid) {
        if (StringHelper.isNullOrEmpty((String)this.strLogicValidValue)) {
            return bValid ? 1 : 0;
        }
        try {
            if (this.getLogicValidPSDEField() != null) {
                return this.getLogicValidPSDEField().getDEFValue(this.getLogicValidStringValue(bValid));
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8ba1\u7b97\u903b\u8f91\u6709\u6548\u6807\u8bc6\u503c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
        }
        return null;
    }

    @Override
    public String getLogicValidStringValue(boolean bValid) {
        if (StringHelper.isNullOrEmpty((String)this.strLogicValidValue)) {
            return bValid ? "1" : "0";
        }
        return bValid ? this.strLogicValidValue : this.strLogicInvalidValue;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6709\u6548\u503c", hideempty2=true, dynamodelmode=4, fields={"LOGICVALIDVALUE"})
    public String getValidLogicValue() {
        if (!this.isLogicValid()) {
            return null;
        }
        return this.getLogicValidStringValue(true);
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u65e0\u6548\u503c", hideempty2=true, dynamodelmode=4, fields={"LOGICINVALIDVALUE"})
    public String getInvalidLogicValue() {
        if (!this.isLogicValid()) {
            return null;
        }
        return this.getLogicValidStringValue(false);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e\u96c6\u5408", hideempty2=true, dynamodelmode=4, child=true, group="\u6570\u636e\u5e93\u5b58\u50a8", order=388)
    public Iterator<IPSDEDBConfig> getAllPSDEDBConfigs() throws Exception {
        return this.psDEDBConfigGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEDBConfig getPSDEDBConfig(String strDBType) throws Exception {
        return (IPSDEDBConfig)this.psDEDBConfigGlobalModel.FindModelHelper(strDBType);
    }

    @Override
    public IPSDEDBConfig getPSDEDBConfig(String strDBType, boolean bTryMode) throws Exception {
        return this.psDEDBConfigGlobalModel.FindModelHelper(strDBType, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027", dumpref=true, from="__self__", group="\u6a21\u578b", order=151)
    public IPSDEField getKeyPSDEField() {
        return this.keyDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u4fe1\u606f\u5c5e\u6027", dumpref=true, from="__self__", group="\u6a21\u578b", order=152)
    public IPSDEField getMajorPSDEField() {
        return this.majorDEField;
    }

    @Override
    @PSModelRTMeta(description="\u952e\u540d\u5c5e\u6027", dumpref=true, from="__self__", group="\u6a21\u578b", order=153)
    public IPSDEField getKeyNamePSDEField() {
        return this.keyNameDEField;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6709\u6548\u5c5e\u6027", hideempty2=true, dumpref=true, from="__self__", group="\u6a21\u578b", order=154)
    public IPSDEField getLogicValidPSDEField() throws Exception {
        return this.getPSDEFieldByPDT("LOGICVALID", true);
    }

    @Override
    public IPSPickupDEField getPSPickupDEField(String strPSDERId) throws Exception {
        Iterator<IPSDEField> deFields = this.getPSDEFields();
        while (deFields.hasNext()) {
            IPSPickupDEField iPSPickupDEField;
            IPSDEField iPSDEField = deFields.next();
            if (!iPSDEField.isLinkDEField() || StringHelper.compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0 || StringHelper.compare((String)(iPSPickupDEField = (IPSPickupDEField)iPSDEField).getDERId(), (String)strPSDERId, (boolean)true) != 0) continue;
            return iPSPickupDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorert=3)
    public IPSDataEntity getInheritPSDataEntity() throws Exception {
        if (this.getPSDERInherit() != null) {
            return this.getPSDERInherit().getMajorPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u5173\u7cfb\u5bf9\u8c61", hideempty=true, dumpref=true, ignorert=3)
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
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u627e\u5230\u9884\u5b9a\u4e49\u7c7b\u578b[%1$s]", (Object)strPreDefineType));
            }
            return null;
        }
        return this.getPSDEField(strName, bTryMode);
    }

    @Override
    public IPSDERBase getPSDER(boolean bMain, String strDERType, String strPSDERName) throws Exception {
        return null;
    }

    @Override
    public IPSDEUIAction getPSDEUIAction(String strDEUIActionId) throws Exception {
        IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)this.psDEUIActionGlobalModel.FindModelHelper(strDEUIActionId, true);
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        iPSDEUIAction = this.getPSSystem().getPSDEUIAction(strDEUIActionId, true);
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        return (IPSDEUIAction)this.psDEUIActionGlobalModel.FindModelHelper(strDEUIActionId, false);
    }

    @Override
    public IPSDEUIAction getPSDEUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
        IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)this.psDEUIActionGlobalModel.FindModelHelper(strDEUIActionId, true);
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        iPSDEUIAction = this.getPSSystem().getPSDEUIAction(strDEUIActionId, true);
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        if (!bTryMode) {
            return (IPSDEUIAction)this.psDEUIActionGlobalModel.FindModelHelper(strDEUIActionId, bTryMode);
        }
        return iPSDEUIAction;
    }

    @Override
    public void resetPSDEUIAction(String strDEUIActionId) throws Exception {
        this.psDEUIActionGlobalModel.ResetModel(strDEUIActionId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5bf9\u8c61\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEUIAction> getAllPSDEUIActions() throws Exception {
        return this.psDEUIActionGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId) throws Exception {
        IPSDEUIActionGroup iPSDEUIActionGroup = this.getPSSystem().getPSDEUIActionGroup(strDEUIActionGroupId, true);
        if (iPSDEUIActionGroup != null) {
            return iPSDEUIActionGroup;
        }
        return (IPSDEUIActionGroup)this.psDEUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId);
    }

    @Override
    public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
        IPSDEUIActionGroup iPSDEUIActionGroup = this.getPSSystem().getPSDEUIActionGroup(strDEUIActionGroupId, true);
        if (iPSDEUIActionGroup != null) {
            return iPSDEUIActionGroup;
        }
        return (IPSDEUIActionGroup)this.psDEUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId, bTryMode);
    }

    @Override
    public void resetPSDEUIActionGroup(String strDEUIActionGroupId) throws Exception {
        this.psDEUIActionGroupGlobalModel.ResetModel(strDEUIActionGroupId);
    }

    @Override
    public IPSDERBase getPSDER(boolean bMajor, String strPSDERId) throws Exception {
        if (bMajor) {
            return (IPSDERBase)this.majorPSDERGlobalModel.FindModelHelper(strPSDERId);
        }
        return (IPSDERBase)this.minorPSDERGlobalModel.FindModelHelper(strPSDERId);
    }

    @Override
    public Iterator<IPSDERBase> getPSDERs(boolean bMajor) {
        if (bMajor) {
            return this.majorPSDERGlobalModel.getPSDERs();
        }
        return this.minorPSDERGlobalModel.getPSDERs();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5173\u7cfb\u96c6\u5408", child=true, ignorert=3, group="\u6a21\u578b", order=294)
    public Iterator<IPSDERBase> getMajorPSDERs() {
        return this.getPSDERs(true);
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5173\u7cfb\u96c6\u5408", child=true, rtname="getDERs", group="\u6a21\u578b", order=292)
    public Iterator<IPSDERBase> getMinorPSDERs() {
        return this.getPSDERs(false);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b1:N\u5173\u7cfb\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDER1N> getMajorPSDER1Ns() {
        return this.getPSDER1Ns(true);
    }

    @Override
    @PSModelRTMeta(description="\u4ece1:N\u5173\u7cfb\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDER1N> getMinorPSDER1Ns() {
        return this.getPSDER1Ns(false);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Iterator<IPSDER1N> getPSDER1Ns(boolean bMajor, boolean bRemoveOrder) {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(bMajor);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N)) continue;
            psDER1NList.add((IPSDER1N)iPSDERBase);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (bRemoveOrder && psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    int nRet = o1.getRemoveOrder() - o2.getRemoveOrder();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Iterator<IPSDER1N> getPSDER1Ns(boolean bMajor) {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(bMajor);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N)) continue;
            psDER1NList.add((IPSDER1N)iPSDERBase);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u8054\u5220\u96641:N\u5173\u7cfb\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDER1N> getRemovePSDER1Ns() {
        Iterator<IPSDERBase> psDERBases = this.getPSDERs(true);
        if (psDERBases == null) {
            return null;
        }
        ArrayList<IPSDER1N> psDER1NList = new ArrayList<IPSDER1N>();
        while (psDERBases.hasNext()) {
            IPSDERBase iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N)) continue;
            IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
            psDER1NList.add(iPSDER1N);
        }
        if (psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    int nRet = o1.getRemoveOrder() - o2.getRemoveOrder();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u63a71:N\u5173\u7cfb\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDER1N> getMasterPSDER1Ns() {
        Iterator<IPSDER1N> psDER1Ns = this.getMinorPSDER1Ns();
        if (psDER1Ns == null) {
            return null;
        }
        ArrayList<IPSDER1N> psDER1NList = new ArrayList<IPSDER1N>();
        while (psDER1Ns.hasNext()) {
            IPSDER1N iPSDER1N = psDER1Ns.next();
            if (iPSDER1N.getMasterOrder() <= 0) continue;
            psDER1NList.add(iPSDER1N);
        }
        if (psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    int nRet = o1.getMasterOrder() - o2.getMasterOrder();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @PSModelRTMeta(description="\u5173\u8054\u5bfc\u51fa1:N\u5173\u7cfb\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDER1N> getExportPSDER1Ns() {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(true);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N) || (iPSDER1N = (IPSDER1N)iPSDERBase).getExportModelOrder() <= 0) continue;
            psDER1NList.add(iPSDER1N);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    int nRet = o1.getExportModelOrder() - o2.getExportModelOrder();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @PSModelRTMeta(description="\u5173\u8054\u514b\u96861:N\u5173\u7cfb\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDER1N> getClonePSDER1Ns() {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(true);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N) || (iPSDER1N = (IPSDER1N)iPSDERBase).getCloneOrder() < 0) continue;
            psDER1NList.add(iPSDER1N);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    int nRet = o1.getCloneOrder() - o2.getCloneOrder();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Iterator<IPSDER1N> getTempDataPSDER1Ns(boolean bMajor) {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(bMajor);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N) || (iPSDER1N = (IPSDER1N)iPSDERBase).getTempDataOrder() < 0) continue;
            psDER1NList.add(iPSDER1N);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    int nRet = o1.getTempDataOrder() - o2.getTempDataOrder();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Iterator<IPSDERIndex> getPSDERIndexs(boolean bMajor) {
        psDERIndexList = new ArrayList<IPSDERIndex>();
        psDERBases = this.getPSDERs(bMajor);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDERIndex) || iPSDERBase.getDERType().equals("DERMULINH")) continue;
            psDERIndexList.add((IPSDERIndex)iPSDERBase);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDERIndexList.size() == 0) {
            return null;
        }
        return psDERIndexList.iterator();
    }

    public IDERBase getDER(boolean bMajor, String strDERId) throws Exception {
        return this.getPSDER(bMajor, strDERId);
    }

    public Iterator<IDERBase> getDERs(boolean bMajor) {
        if (bMajor) {
            return this.majorPSDERGlobalModel.getDERs();
        }
        return this.minorPSDERGlobalModel.getDERs();
    }

    @Override
    public IPSDERBase getPSDER(boolean bMajor, String strPSDERId, boolean bTryMode) throws Exception {
        if (bMajor) {
            return (IPSDERBase)this.majorPSDERGlobalModel.FindModelHelper(strPSDERId, bTryMode);
        }
        return (IPSDERBase)this.minorPSDERGlobalModel.FindModelHelper(strPSDERId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="1:1\u5173\u7cfb\u96c6\u5408", outputdoc="false")
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

    public IDEDataSet getDEDataSet(String strDEDataSetId) throws Exception {
        return this.getPSDEDataSet(strDEDataSetId);
    }

    @Override
    public IPSDEDataQuery getPSDEDataQuery(String strDEDataQueryId) throws Exception {
        return (IPSDEDataQuery)this.psDEDataQueryGlobalModel.FindModelHelper(strDEDataQueryId);
    }

    @Override
    public IPSDEDataQuery getPSDEDataQuery(String strDEDataQueryId, boolean bTryMode) throws Exception {
        return (IPSDEDataQuery)this.psDEDataQueryGlobalModel.FindModelHelper(strDEDataQueryId, bTryMode);
    }

    @Override
    public void resetPSDEDataQuery(String strDEDataQueryId) throws Exception {
        this.psDEDataQueryGlobalModel.ResetModel(strDEDataQueryId);
    }

    @Override
    public IPSDEDataSet getPSDEDataSet(String strDEDataSetId) throws Exception {
        return (IPSDEDataSet)this.psDEDataSetGlobalModel.FindModelHelper(strDEDataSetId);
    }

    @Override
    public IPSDEDataSet getPSDEDataSet(String strDEDataSetId, boolean bTryMode) throws Exception {
        return (IPSDEDataSet)this.psDEDataSetGlobalModel.FindModelHelper(strDEDataSetId, bTryMode);
    }

    @Override
    public void resetPSDEDataSet(String strDEDataSetId) throws Exception {
        this.psDEDataSetGlobalModel.ResetModel(strDEDataSetId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u96c6\u5408", child=true, dynamodelmode=5, group="\u5904\u7406\u903b\u8f91", order=288)
    public Iterator<IPSDEDataSet> getAllPSDEDataSets() throws Exception {
        return this.psDEDataSetGlobalModel.getAllModelHelpers();
    }

    @Override
    public ISystem getSystem() {
        return this.getPSSystem();
    }

    public IDEField getKeyDEField() {
        return this.getKeyPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        if (StringHelper.isNullOrEmpty((String)this.psDataEntity.getLOGICNAME())) {
            return this.getName();
        }
        return this.psDataEntity.getLOGICNAME();
    }

    @Override
    public PSACHandler getPSAjaxControlHandlerData(String strAjaxControlHandlerId) throws Exception {
        PSACHandler psACHandler = this.getPSSystem().getPSAjaxControlHandlerData(strAjaxControlHandlerId, true);
        if (psACHandler != null) {
            return psACHandler;
        }
        psACHandler = this.psAjaxControlHandlerGlobalModel.FindModel(strAjaxControlHandlerId);
        if (psACHandler == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strAjaxControlHandlerId));
        }
        return psACHandler;
    }

    @Override
    public void resetPSAjaxControlHandlerData(String strAjaxControlHandlerId) {
        this.getPSSystem().resetPSAjaxControlHandlerData(strAjaxControlHandlerId);
        this.psAjaxControlHandlerGlobalModel.ResetModel(strAjaxControlHandlerId);
    }

    public IDEAction getDEAction(String strDEActionId) throws Exception {
        return this.getPSDEAction(strDEActionId);
    }

    @Override
    public IPSDataEntity getMasterPSDataEntity(IDataObject iDataObject) throws Exception {
        return null;
    }

    @Override
    public IPSDEDBSysProc getPSDEDBSysProc(String strDEDBSysProcId) throws Exception {
        return (IPSDEDBSysProc)this.psDEDBSysProcGlobalModel.FindModelHelper(strDEDBSysProcId);
    }

    @Override
    public void resetPSDEDBSysProc(String strDEDBSysProcId) {
        this.psDEDBSysProcGlobalModel.ResetModel(strDEDBSysProcId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u96c6\u5408", child=true, group="\u5904\u7406\u903b\u8f91", order=285)
    public Iterator<IPSDEAction> getAllPSDEActions() throws Exception {
        return this.psDEActionGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEAction getPSDEAction(String strDEActionId) throws Exception {
        return (IPSDEAction)this.psDEActionGlobalModel.FindModelHelper(strDEActionId);
    }

    @Override
    public IPSDEAction getPSDEAction(String strDEActionId, boolean bTryMode) throws Exception {
        return (IPSDEAction)this.psDEActionGlobalModel.FindModelHelper(strDEActionId, bTryMode);
    }

    @Override
    public void resetPSDEAction(String strDEActionId) throws Exception {
        this.psDEActionGlobalModel.ResetModel(strDEActionId);
    }

    public IDataObject createDataObject() throws Exception {
        return new DataObject();
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u7c7b\u578b\u5c5e\u6027", hideempty=true, dumpref=true, from="__self__")
    public IPSDEField getIndexTypePSDEField() {
        return this.indexTypeDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u81ea\u52a8\u586b\u5145\u6a21\u5f0f\u96c6\u5408", child=true, ignorert=1, dynamodelmode=4, outputdoc="false")
    public Iterator<IPSDEACMode> getAllPSDEACModes() throws Exception {
        return this.psDEACModeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEACMode getPSDEACMode(String strDEACModeId) throws Exception {
        return (IPSDEACMode)this.psDEACModeGlobalModel.FindModelHelper(strDEACModeId);
    }

    @Override
    public IPSDEACMode getPSDEACMode(String strDEACModeId, boolean bTryMode) throws Exception {
        return (IPSDEACMode)this.psDEACModeGlobalModel.FindModelHelper(strDEACModeId, bTryMode);
    }

    @Override
    public void resetPSDEACMode(String strDEACModeId) throws Exception {
        this.psDEACModeGlobalModel.ResetModel(strDEACModeId);
    }

    public IDEACMode getDEACMode(String strACModeName) throws Exception {
        return this.getPSDEACMode(strACModeName);
    }

    public IDEACMode getDefaultDEACMode() throws Exception {
        if (this.getDefaultPSDEACModeData() != null) {
            return this.getPSDEACMode(this.getDefaultPSDEACModeData().getPSDEACMODEID());
        }
        return this.getPSDEACMode("DEFAULT");
    }

    @Override
    public PSDEACMode getDefaultPSDEACModeData() {
        return this.defaultPSDEACModeData;
    }

    @Override
    public IPSDEDataRelation getPSDEDataRelation(String strDEDataRelationId) throws Exception {
        return (IPSDEDataRelation)this.psDEDataRelationGlobalModel.FindModelHelper(strDEDataRelationId);
    }

    @Override
    public IPSDEDataRelation getPSDEDataRelation(String strDEDataRelationId, boolean bTryMode) throws Exception {
        return (IPSDEDataRelation)this.psDEDataRelationGlobalModel.FindModelHelper(strDEDataRelationId, bTryMode);
    }

    @Override
    public void resetPSDEDataRelation(String strDEDataRelationId) throws Exception {
        this.psDEDataRelationGlobalModel.ResetModel(strDEDataRelationId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u754c\u9762\u5173\u7cfb\u7ec4\u96c6\u5408", outputdoc="false", dynamodelmode=4, child=true, dumpref=true)
    public Iterator<IPSDEDataRelation> getAllPSDEDataRelations() throws Exception {
        return this.psDEDataRelationGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u5206\u7ec4\u96c6\u5408", outputdoc="false", dynamodelmode=4, child=true, dumpref=true)
    public Iterator<IPSDEDRGroup> getAllPSDEDRGroups() throws Exception {
        return this.psDEDRGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEDRGroup getPSDEDRGroup(String strDEDRGroupId) throws Exception {
        return (IPSDEDRGroup)this.psDEDRGroupGlobalModel.FindModelHelper(strDEDRGroupId);
    }

    @Override
    public IPSDEDRGroup getPSDEDRGroup(String strDEDRGroupId, boolean bTryMode) throws Exception {
        return (IPSDEDRGroup)this.psDEDRGroupGlobalModel.FindModelHelper(strDEDRGroupId, bTryMode);
    }

    @Override
    public void resetPSDEDRGroup(String strDEDRGroupId) throws Exception {
        this.psDEDRGroupGlobalModel.ResetModel(strDEDRGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u96c6\u5408", child=true, dynamodelmode=4, group="\u5904\u7406\u903b\u8f91", order=287)
    public Iterator<IPSDEDataQuery> getAllPSDEDataQueries() throws Exception {
        return this.psDEDataQueryGlobalModel.getAllModelHelpers();
    }

    public IDEDataQuery getDEDataQuery(String strDEDataQueryId) throws Exception {
        return (IDEDataQuery)this.psDEDataQueryGlobalModel.FindModelHelper(strDEDataQueryId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u9879\u96c6\u5408", outputdoc="false", dynamodelmode=4, child=true, dumpref=true)
    public Iterator<IPSDEDRItem> getAllPSDEDRItems() throws Exception {
        return this.psDEDRItemGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEDRItem getPSDEDRItem(String strDEDRItemId) throws Exception {
        return (IPSDEDRItem)this.psDEDRItemGlobalModel.FindModelHelper(strDEDRItemId);
    }

    @Override
    public IPSDEDRItem getPSDEDRItem(String strDEDRItemId, boolean bTryMode) throws Exception {
        return (IPSDEDRItem)this.psDEDRItemGlobalModel.FindModelHelper(strDEDRItemId, bTryMode);
    }

    @Override
    public void resetPSDEDRItem(String strDEDRItemId) throws Exception {
        this.psDEDRItemGlobalModel.ResetModel(strDEDRItemId);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    public IDEDataSet getDEDataSet(String strName, boolean bTry) throws Exception {
        return (IDEDataSet)this.psDEDataSetGlobalModel.FindModelHelper(strName, bTry);
    }

    public IDEField getMajorDEField() {
        return this.getMajorPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u5bf9\u8c61\u96c6\u5408", hideempty=true, outputdoc="false")
    public Iterator<IPSDataEntity> getAllMasterPSDataEntities() throws Exception {
        if (this.masterPSDataEntityList == null || this.masterPSDataEntityList.size() == 0) {
            return null;
        }
        return this.masterPSDataEntityList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8054\u5408\u952e\u503c\u5c5e\u6027\u96c6\u5408", hideempty=true, child=true, dumpref=true, rtdump=3, from="__self__", dynamodelmode=4, group="\u6a21\u578b", order=291, doctype="quick")
    public Iterator<IPSDEField> getUnionKeyValuePSDEFields() {
        if (this.unionKeyValueFieldList == null || this.unionKeyValueFieldList.size() == 0) {
            return null;
        }
        return this.unionKeyValueFieldList.iterator();
    }

    @Override
    public Iterator<IPSDEField> getDEMainStateDEFields() {
        if (this.mainStateFieldList == null || this.mainStateFieldList.size() == 0) {
            return null;
        }
        return this.mainStateFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u5c5e\u6027\u96c6\u5408", hideempty=true, child=true, dumpref=true, rtdump=3, from="__self__", dynamodelmode=4, outputdoc="false")
    public Iterator<IPSDEField> getMainStatePSDEFields() {
        if (this.mainStateFieldList == null || this.mainStateFieldList.size() == 0) {
            return null;
        }
        return this.mainStateFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u5c5e\u6027", hideempty=true, group="\u72b6\u6001\u63a7\u5236", order=322)
    public IPSDEField getMainStatePSDEField() {
        if (this.mainStateFieldList == null || this.mainStateFieldList.size() == 0) {
            return null;
        }
        return this.mainStateFieldList.get(0);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u5c5e\u60272", hideempty=true, group="\u72b6\u6001\u63a7\u5236", order=324)
    public IPSDEField getMainState2PSDEField() {
        if (this.mainStateFieldList == null || this.mainStateFieldList.size() <= 1) {
            return null;
        }
        return this.mainStateFieldList.get(1);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u5c5e\u60273", hideempty=true, group="\u72b6\u6001\u63a7\u5236", order=326)
    public IPSDEField getMainState3PSDEField() {
        if (this.mainStateFieldList == null || this.mainStateFieldList.size() <= 2) {
            return null;
        }
        return this.mainStateFieldList.get(2);
    }

    @Override
    public Iterator<IPSDEField> getPSDEFieldsByDER(String strDERId) throws Exception {
        ArrayList<IPSLinkDEField> psDEFieldList = new ArrayList<IPSLinkDEField>();
        Iterator<IPSDEField> deFields = this.getPSDEFields();
        while (deFields.hasNext()) {
            IPSLinkDEField iPSLinkDEField;
            IPSDEField iPSDEField = deFields.next();
            if (!iPSDEField.isLinkDEField() || StringHelper.compare((String)(iPSLinkDEField = (IPSLinkDEField)iPSDEField).getDERId(), (String)strDERId, (boolean)true) != 0) continue;
            psDEFieldList.add(iPSLinkDEField);
        }
        if (psDEFieldList == null || psDEFieldList.size() == 0) {
            return null;
        }
        return psDEFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u5b9e\u4f53\u7c7b\u578b", hideempty2=true, dynamodelmode=4, fields={"INDEXDETYPE"})
    public String getIndexDEType() {
        return this.strIndexDEType;
    }

    @Override
    public String getLogicName(String strLanguage) {
        return this.psDataEntity.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u903b\u8f91\u5bf9\u8c61\u96c6\u5408", modeltype="PSDELOGIC", child=true, rtdump=1, group="\u5904\u7406\u903b\u8f91", order=286)
    public Iterator<IPSDELogic> getAllPSDELogics() throws Exception {
        return this.psDELogicGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDELogic getPSDELogic(String strDELogicId) throws Exception {
        return (IPSDELogic)this.psDELogicGlobalModel.FindModelHelper(strDELogicId);
    }

    @Override
    public IPSDELogic getPSDELogic(String strDELogicId, boolean bTryMode) throws Exception {
        return (IPSDELogic)this.psDELogicGlobalModel.FindModelHelper(strDELogicId, bTryMode);
    }

    public IDELogic getDELogic(String strDELogicId) throws Exception {
        return this.getPSDELogic(strDELogicId);
    }

    @Override
    public void resetPSDELogic(String strDELogicId) throws Exception {
        this.psDELogicGlobalModel.ResetModel(strDELogicId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u8fc1\u79fb\u903b\u8f91\u96c6\u5408", dynamodelmode=4, child=true, dumpref=true, group="\u5904\u7406\u903b\u8f91", order=289)
    public Iterator<IPSDEMSLogic> getAllPSDEMSLogics() throws Exception {
        return this.psDEMSLogicGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEMSLogic getPSDEMSLogic(String strDEMSLogicId) throws Exception {
        return (IPSDEMSLogic)this.psDEMSLogicGlobalModel.FindModelHelper(strDEMSLogicId);
    }

    @Override
    public IPSDEMSLogic getPSDEMSLogic(String strDEMSLogicId, boolean bTryMode) throws Exception {
        return (IPSDEMSLogic)this.psDEMSLogicGlobalModel.FindModelHelper(strDEMSLogicId, bTryMode);
    }

    @Override
    public void resetPSDEMSLogic(String strDEMSLogicId) throws Exception {
        this.psDEMSLogicGlobalModel.ResetModel(strDEMSLogicId);
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u4e3b\u72b6\u6001\u8fc1\u79fb\u903b\u8f91", outputdoc="false")
    public IPSDEMSLogic getDefaultPSDEMSLogic() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e34\u65f6\u6570\u636e", ignoredumpvalues="false", dynamodelmode=4, fields={"ENATEMPDATA"}, doc="\u53ef\u901a\u8fc7{@link #getTempDataHolder}\u83b7\u53d6\u4e34\u65f6\u6570\u636e\u5904\u7406\u6a21\u5f0f")
    public boolean isEnableTempData() {
        return this.getTempDataHolder() != 0;
    }

    public IDEUIAction getDEUIAction(String strDEUIActionId) throws Exception {
        return this.getPSDEUIAction(strDEUIActionId);
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u591a\u8868\u5355", dynamodelmode=4)
    public boolean isEnableMultiForm() {
        return this.bEnableMultiForm;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u7c7b\u578b\u5c5e\u6027", hideempty=true)
    public IPSDEField getFormTypePSDEField() {
        return this.formTypeDEField;
    }

    @Override
    public PSDEViewBase getPSDEViewDataByPDT(String strPreDefineType, boolean bTryMode) throws Exception {
        PSDEViewBase psDEViewBase = this.predefineDEViewMap.get(strPreDefineType);
        if (psDEViewBase == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u9884\u7f6e\u89c6\u56fe[%1$s]", (Object)strPreDefineType));
        }
        return psDEViewBase;
    }

    @Override
    public PSDEViewBase getPSDEViewDataByPDT(String strPreDefineType, String strPDTParam, boolean bTryMode) throws Exception {
        PSDEViewBase psDEViewBase;
        String strPDViewType = strPreDefineType;
        if (!StringHelper.isNullOrEmpty((String)strPDTParam)) {
            strPDViewType = String.valueOf(strPDViewType) + StringHelper.format((String)":%1$s", (Object)strPDTParam.toUpperCase());
        }
        if ((psDEViewBase = this.predefineDEViewMap.get(strPDViewType)) == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u9884\u7f6e\u89c6\u56fe[%1$s]", (Object)strPDViewType));
        }
        return psDEViewBase;
    }

    @Override
    public PSDEViewBase getPSDEViewDataByPDT(String strPreDefineType, String strPDTParamPre, String strPDTParam, boolean bTryMode) throws Exception {
        PSDEViewBase psDEViewBase;
        if (!StringHelper.isNullOrEmpty((String)strPDTParamPre) && !StringHelper.isNullOrEmpty((String)strPDTParam) && (psDEViewBase = this.getPSDEViewDataByPDT(strPreDefineType, String.valueOf(strPDTParamPre) + strPDTParam, true)) != null) {
            return psDEViewBase;
        }
        return this.getPSDEViewDataByPDT(strPreDefineType, strPDTParam, bTryMode);
    }

    @Override
    public Iterator<PSDEViewBase> getPSDEViewDatasByPDT(String strPreDefineType) throws Exception {
        strPreDefineType = strPreDefineType.toUpperCase();
        String strPreDefineType2 = String.valueOf(strPreDefineType) + ":";
        ArrayList<PSDEViewBase> psDEViewBaseList = new ArrayList<PSDEViewBase>();
        for (String strKey : this.predefineDEViewMap.keySet()) {
            if (StringHelper.compare((String)strKey, (String)strPreDefineType, (boolean)true) == 0) {
                psDEViewBaseList.add(this.predefineDEViewMap.get(strKey));
                continue;
            }
            if (strKey.indexOf(strPreDefineType2) != 0) continue;
            psDEViewBaseList.add(this.predefineDEViewMap.get(strKey));
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
                if (StringHelper.compare((String)strPSDEViewBaseId, (String)psDEViewBase.getPSDEVIEWBASEID(), (boolean)false) != 0) continue;
                return psDEViewBase;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u6570\u636e\u5bf9\u8c61[%1$s]", strPSDEViewBaseId));
    }

    @Override
    public Iterator<PSDEForm> getAllPSDEEditFormDatas() {
        return this.psDEEditFormList.iterator();
    }

    @Override
    public PSDEForm getPSDEEditFormData(String strPSDEEditFormId, boolean bTryMode) throws Exception {
        if (this.psDEEditFormList != null) {
            for (PSDEForm psDEEditForm : this.psDEEditFormList) {
                if (StringHelper.compare((String)strPSDEEditFormId, (String)psDEEditForm.getPSDEFORMID(), (boolean)false) != 0) continue;
                return psDEEditForm;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u7f16\u8f91\u8868\u5355\u6570\u636e\u5bf9\u8c61[%1$s]", strPSDEEditFormId));
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7c7b\u578b", codelist="DEType", dynamodelmode=4, group="\u57fa\u672c", order=125, fields={"DETYPE"})
    public int getDEType() {
        return this.psDataEntity.getDETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6301\u6709\u8005", codelist="DELogicHolder", ignoredumpvalues="3", dump=false, dynamodelmode=4, fields={"DEHOLDER"})
    public int getDEHolder() {
        return this.nDEHolder;
    }

    @PSModelRTMeta(description="\u5173\u7cfb\u5b9e\u4f53N:N\u5173\u7cfb", hideempty=true, name="getPSDERNN")
    public IPSDERNN getPSDERNN2() throws Exception {
        return this.internalGetPSDERNN(true);
    }

    @Override
    public IPSDERNN getPSDERNN() throws Exception {
        if (PSTemplHelper.isBusy()) {
            return this.internalGetPSDERNN(true);
        }
        return this.internalGetPSDERNN(false);
    }

    protected IPSDERNN internalGetPSDERNN(boolean bTryMode) throws Exception {
        if (this.iPSDERNN != null) {
            return this.iPSDERNN;
        }
        if (this.getDEType() != 3) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u7c7b\u578b\u4e0d\u662f\u5173\u7cfb\u5b9e\u4f53", (Object)this.getName()));
        }
        IPSDER1NBase[] list = new IPSDER1NBase[2];
        int nIndex = 0;
        Iterator<IPSDERBase> psDER1NBases = this.getPSDERs(false);
        if (psDER1NBases != null) {
            while (psDER1NBases.hasNext()) {
                IPSDERCustom iPSDERCustom;
                IPSDERBase iPSDERBase = psDER1NBases.next();
                if (iPSDERBase instanceof IPSDER1N) {
                    IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
                    if ((iPSDER1N.getMasterRS() & 2) <= 0) continue;
                    list[nIndex] = iPSDER1N;
                    if (++nIndex != 2) continue;
                    break;
                }
                if (!(iPSDERBase instanceof IPSDERCustom) || !"DER1N".equals((iPSDERCustom = (IPSDERCustom)iPSDERBase).getDERSubType()) || (iPSDERCustom.getMasterRS() & 2) <= 0) continue;
                list[nIndex] = iPSDERCustom;
                if (++nIndex == 2) break;
            }
        }
        if (nIndex != 2) {
            throw new Exception(StringHelper.format((String)"\u5173\u7cfb\u5b9e\u4f53[%1$s]\u5fc5\u987b\u5b9a\u4e492\u4e2aN:N\u5173\u7cfb", (Object)this.getName()));
        }
        PSDERNNImpl psDERNNImpl = new PSDERNNImpl();
        psDERNNImpl.init(this.getDAGlobalHelper(), this, list);
        this.iPSDERNN = psDERNNImpl;
        return this.iPSDERNN;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6620\u5c04\u96c6\u5408", child=true, dynamodelmode=4, group="\u5904\u7406\u903b\u8f91", order=298)
    public Iterator<IPSDEMap> getAllPSDEMaps() throws Exception {
        return this.psDEMapGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEMap getPSDEMap(String strDEMapId) throws Exception {
        return (IPSDEMap)this.psDEMapGlobalModel.FindModelHelper(strDEMapId);
    }

    @Override
    public IPSDEMap getPSDEMap(String strDEMapId, boolean bTryMode) throws Exception {
        return (IPSDEMap)this.psDEMapGlobalModel.FindModelHelper(strDEMapId, bTryMode);
    }

    @Override
    public void resetPSDEMap(String strDEMapId) throws Exception {
        this.psDEMapGlobalModel.ResetModel(strDEMapId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u96c6\u5408", child=true, dynamodelmode=4, group="\u529f\u80fd\u914d\u7f6e", order=420)
    public Iterator<IPSDEWF> getAllPSDEWFs() throws Exception {
        return this.psDEWFGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEWF getPSDEWF(String strWFDEId) throws Exception {
        return (IPSDEWF)this.psDEWFGlobalModel.FindModelHelper(strWFDEId);
    }

    public IDEWF getDEWF(String strDEWFId) throws Exception {
        return this.getPSDEWF(strDEWFId);
    }

    @Override
    public void resetPSDEWF(String strWFDEId) throws Exception {
        this.psDEWFGlobalModel.ResetModel(strWFDEId);
    }

    @Override
    @PSModelRTMeta(description="\u6709\u5b9e\u4f53\u5de5\u4f5c\u6d41", dump=false)
    public boolean hasPSDEWF() throws Exception {
        Iterator<IPSDEWF> psWFDEs = this.getAllPSDEWFs();
        return psWFDEs != null && psWFDEs.hasNext();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int getPSDEWFCount() throws Exception {
        nCount = 0;
        psWFDEs = this.getAllPSDEWFs();
        if (psWFDEs != null) ** GOTO lbl8
        return nCount;
lbl-1000:
        // 1 sources

        {
            ++nCount;
            psWFDEs.next();
lbl8:
            // 2 sources

            ** while (psWFDEs.hasNext())
        }
lbl9:
        // 1 sources

        return nCount;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u5de5\u4f5c\u6d41")
    public IPSDEWF getDefaultPSDEWF() throws Exception {
        if (this.defaultPSDEWF != null) {
            return this.defaultPSDEWF;
        }
        Iterator<IPSDEWF> psWFDEs = this.getAllPSDEWFs();
        if (psWFDEs != null) {
            while (psWFDEs.hasNext()) {
                IPSDEWF iPSDEWF = psWFDEs.next();
                if (!iPSDEWF.isDefaultMode()) continue;
                this.defaultPSDEWF = iPSDEWF;
                return this.defaultPSDEWF;
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5de5\u4f5c\u6d41[0]")
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
                if (iPSDEWF0 != null) continue;
                iPSDEWF0 = iPSDEWF;
            }
        }
        return iPSDEWF0;
    }

    public IDEField getLogicValidDEField() {
        try {
            return this.getLogicValidPSDEField();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    public void loadAll() throws Exception {
        boolean bLoop;
        Iterator<IPSSystemDBConfig> psSystemDBConfigs = this.getPSSystem().getAllPSSystemDBConfigs();
        if (psSystemDBConfigs != null) {
            boolean bTryMode = this.isSubSysDE() || !this.isEnableSQLStorage();
            while (psSystemDBConfigs.hasNext()) {
                IPSSystemDBConfig iPSSystemDBConfig = psSystemDBConfigs.next();
                try {
                    IPSDEDBConfig iPSDEDBConfig = this.getPSDEDBConfig(iPSSystemDBConfig.getName(), bTryMode);
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53\u6570\u636e\u5e93[%1$s]\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iPSSystemDBConfig.getName(), (Object)ex.getMessage()), ex);
                }
            }
        }
        Iterator psDEDBConfigs = this.psDEDBConfigGlobalModel.getAllModelHelpers();
        while (psDEDBConfigs.hasNext()) {
            IPSDEDBConfig iPSDEDBConfig = (IPSDEDBConfig)psDEDBConfigs.next();
            iPSDEDBConfig.loadAll();
        }
        Iterator psDEDBTables = this.psDEDBTableGlobalModel.getAllModelHelpers();
        this.psDEACModeGlobalModel.getAllModelHelpers();
        this.majorPSDERGlobalModel.getPSDERs();
        this.minorPSDERGlobalModel.getPSDERs();
        Iterator psDEDataQueries = this.psDEDataQueryGlobalModel.getAllModelHelpers();
        while (psDEDataQueries.hasNext()) {
            IPSDEDataQuery iPSDEDataQuery = (IPSDEDataQuery)psDEDataQueries.next();
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
        Iterator psDEMaps = this.psDEMapGlobalModel.getAllModelHelpers();
        while (psDEMaps.hasNext()) {
            IPSDEMap iPSDEMap = (IPSDEMap)psDEMaps.next();
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
        Iterator psDEDataRelations = this.psDEDataRelationGlobalModel.getAllModelHelpers();
        while (psDEDataRelations.hasNext()) {
            IPSDEDataRelation iPSDEDataRelation = (IPSDEDataRelation)psDEDataRelations.next();
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
            Iterator<IPSDEField> mainStatePSDEFields;
            Iterator<IPSDEField> unionKeyValuePSDEFields;
            if (this.getKeyPSDEField() != null) {
                this.getKeyPSDEField().getPSDEFSearchMode(String.format("N_%1$s_EQ", this.getKeyPSDEField().getName()), false);
            }
            if (this.getUniTagPSDEField() != null) {
                this.getUniTagPSDEField().getPSDEFSearchMode(String.format("N_%1$s_EQ", this.getUniTagPSDEField().getName()), false);
            }
            if ((unionKeyValuePSDEFields = this.getUnionKeyValuePSDEFields()) != null) {
                while (unionKeyValuePSDEFields.hasNext()) {
                    IPSDEField iPSDEField = unionKeyValuePSDEFields.next();
                    iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
                }
            }
            if ((mainStatePSDEFields = this.getMainStatePSDEFields()) != null) {
                while (mainStatePSDEFields.hasNext()) {
                    IPSDEField iPSDEField = mainStatePSDEFields.next();
                    iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
                }
            }
            psDEFields = this.getPSDEFields();
            while (psDEFields.hasNext()) {
                IPSDEField iPSDEField2 = psDEFields.next();
                Iterator<IPSDEField> dupCheckPSDEFields = iPSDEField2.getDupCheckPSDEFields();
                if (dupCheckPSDEFields == null) continue;
                while (dupCheckPSDEFields.hasNext()) {
                    IPSDEField iPSDEField = dupCheckPSDEFields.next();
                    iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
                }
            }
            Iterator<IPSDERBase> psDERBases = this.getMinorPSDERs();
            if (psDERBases != null) {
                while (psDERBases.hasNext()) {
                    IPSDERCustom iPSDERCustom;
                    IPSDEField iPSDEField;
                    IPSDERBase iPSDERBase = psDERBases.next();
                    if (iPSDERBase instanceof IPSDER1N) {
                        IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
                        iPSDEField = iPSDER1N.getPickupPSDEField();
                        if (iPSDEField == null) continue;
                        iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
                        continue;
                    }
                    if (!(iPSDERBase instanceof IPSDERCustom) || (iPSDEField = (iPSDERCustom = (IPSDERCustom)iPSDERBase).getPickupPSDEField()) == null) continue;
                    iPSDEField.getPSDEFSearchMode(String.format("N_%1$s_EQ", iPSDEField.getName()), false);
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
            IPSDEDataQuery iPSDEDataQuery = (IPSDEDataQuery)psDEDataQueries.next();
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
        HashMap<String, IPSDEMethodDTO> psDEMethodDTOMap = new HashMap<String, IPSDEMethodDTO>();
        do {
            ArrayList<IPSDEMethodDTO> list = new ArrayList<IPSDEMethodDTO>();
            Iterator<IPSDEMethodDTO> psDEMethodDTOs = this.getAllPSDEMethodDTOs();
            if (psDEMethodDTOs != null) {
                while (psDEMethodDTOs.hasNext()) {
                    IPSDEMethodDTO iPSDEMethodDTO = psDEMethodDTOs.next();
                    list.add(iPSDEMethodDTO);
                }
            }
            bLoop = false;
            for (IPSDEMethodDTO iPSDEMethodDTO : list) {
                if (psDEMethodDTOMap.containsKey(iPSDEMethodDTO.getCodeName())) continue;
                iPSDEMethodDTO.check();
                psDEMethodDTOMap.put(iPSDEMethodDTO.getCodeName(), iPSDEMethodDTO);
                bLoop = true;
            }
        } while (bLoop);
        if (this.getPSSysDBScheme() != null && this.getPSSysDBScheme() instanceof IPSSysDBSchemeRuntime) {
            ((IPSSysDBSchemeRuntime)((Object)this.getPSSysDBScheme())).registerPSDataEntity(this);
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
        if (this.getMainStatePSDEField() == null || this.getPSSystem().isEnableModelRT()) {
            return;
        }
        Iterator<IPSDEAction> psDEActions = this.getAllPSDEActions();
        if (psDEActions != null) {
            while (psDEActions.hasNext()) {
                IPSDEAction iPSDEAction = psDEActions.next();
                ArrayList<IPSDEMainState> psDEMainStateList = new ArrayList<IPSDEMainState>();
                Iterator<IPSDEMainState> psDEMainStates = this.getAllPSDEMainStates();
                if (psDEMainStates != null) {
                    while (psDEMainStates.hasNext()) {
                        IPSDEMainState iPSDEMainState = psDEMainStates.next();
                        boolean bContainsAction = false;
                        Iterator<IPSDEMainStateAction> psDEMainStateActions = iPSDEMainState.getPSDEMainStateActions();
                        if (psDEMainStateActions != null) {
                            while (psDEMainStateActions.hasNext()) {
                                IPSDEMainStateAction iPSDEMainStateAction = psDEMainStateActions.next();
                                if (StringHelper.compare((String)iPSDEMainStateAction.getPSDEActionId(), (String)iPSDEAction.getId(), (boolean)false) != 0) continue;
                                bContainsAction = true;
                                break;
                            }
                        }
                        if (iPSDEMainState.isActionAllowMode()) {
                            if (bContainsAction || !MSCtrlActionModeMap.containsKey(iPSDEAction.getActionMode())) continue;
                            psDEMainStateList.add(iPSDEMainState);
                            continue;
                        }
                        if (!bContainsAction) continue;
                        psDEMainStateList.add(iPSDEMainState);
                    }
                }
                if (psDEMainStateList.size() <= 0) continue;
                PSDEMainStateDenyActionLogicImpl psDEMainStateActionDenyLogicImpl = new PSDEMainStateDenyActionLogicImpl();
                psDEMainStateActionDenyLogicImpl.init(this.getDAGlobalHelper(), iPSDEAction, psDEMainStateList);
                this.psDELogicGlobalModel.appendAllModelHelpers(psDEMainStateActionDenyLogicImpl);
                ((IPSDEActionRuntime)((Object)iPSDEAction)).registerPSDEActionLogic(psDEMainStateActionDenyLogicImpl);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6570\u636e\u6e90", codelist="SysDeployDBMode", dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=375, fields={"DSLINK"})
    public String getDSLink() {
        return this.strDSLink;
    }

    @Override
    public String getTableSpaceId() {
        return this.strDBTableSpaceId;
    }

    @Override
    @PSModelRTMeta(description="\u540c\u65f6\u652f\u6301\u591a\u6570\u636e\u6e90", dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=378)
    public boolean isEnableMultiDS() {
        return this.bEnableMultiDS;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408", child=true, dynamodelmode=4, group="\u8bbf\u95ee\u63a7\u5236", order=510)
    public Iterator<IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception {
        return this.psDEOPPrivGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEOPPriv getPSDEOPPriv(String strDEOPPrivId) throws Exception {
        IPSDEOPPriv iPSDEOPPriv = (IPSDEOPPriv)this.psDEOPPrivGlobalModel.FindModelHelper(strDEOPPrivId, true);
        if (iPSDEOPPriv != null) {
            return iPSDEOPPriv;
        }
        return this.getPSSystem().getPSDEOPPriv(strDEOPPrivId);
    }

    @Override
    public IPSDEOPPriv getPSDEOPPriv(String strDEOPPrivId, boolean bTryMode) throws Exception {
        IPSDEOPPriv iPSDEOPPriv = (IPSDEOPPriv)this.psDEOPPrivGlobalModel.FindModelHelper(strDEOPPrivId, true);
        if (iPSDEOPPriv != null) {
            Iterator psDEOPPrivs;
            if (!strDEOPPrivId.equals(iPSDEOPPriv.getId()) && iPSDEOPPriv.getMapPSDataEntity() != null && (psDEOPPrivs = this.psDEOPPrivGlobalModel.getAllModelHelpers()) != null) {
                while (psDEOPPrivs.hasNext()) {
                    IPSDEOPPriv iPSDEOPPriv2 = (IPSDEOPPriv)psDEOPPrivs.next();
                    if (iPSDEOPPriv2.getMapPSDataEntity() != null || !strDEOPPrivId.equals(iPSDEOPPriv2.getName())) continue;
                    return iPSDEOPPriv2;
                }
            }
            return iPSDEOPPriv;
        }
        return this.getPSSystem().getPSDEOPPriv(strDEOPPrivId, bTryMode);
    }

    @Override
    public void resetPSDEOPPriv(String strDEOPPrivId) throws Exception {
        this.getPSSystem().resetPSDEOPPriv(strDEOPPrivId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u96c6\u5408", child=true, dynamodelmode=4, group="\u72b6\u6001\u63a7\u5236", order=335)
    public Iterator<IPSDEMainState> getAllPSDEMainStates() throws Exception {
        return this.psDEMainStateGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEMainState getPSDEMainState(String strDEMainStateId) throws Exception {
        return (IPSDEMainState)this.psDEMainStateGlobalModel.FindModelHelper(strDEMainStateId);
    }

    @Override
    public IPSDEMainState getPSDEMainState(String strDEMainStateId, boolean bTryMode) throws Exception {
        return (IPSDEMainState)this.psDEMainStateGlobalModel.FindModelHelper(strDEMainStateId, bTryMode);
    }

    @Override
    public void resetPSDEMainState(String strDEMainStateId) throws Exception {
        this.psDEMainStateGlobalModel.ResetModel(strDEMainStateId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u5173\u7cfb\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEMainStateRS> getAllPSDEMainStateRSs() throws Exception {
        return this.psDEMainStateRSGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u73b0\u6709\u6a21\u578b", dump=false, group="\u6570\u636e\u5e93\u5b58\u50a8", order=372)
    public boolean isExistingModel() {
        return this.bExistingModel;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u7ec4\u7ec7\u6a21\u578b", dump=false)
    public boolean isEnableOrgModel() {
        return this.bEnableOrgModel;
    }

    public IDEMainState getDEMainState(ISimpleDataObject iSimpleDataObject) throws Exception {
        return null;
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        String strNameFormat2;
        String strPKGName = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, this.classOrPkgNameMap, "PKG", iPSSysSFPub);
        String strNameFormat = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, this.classOrPkgNameMap, strCodeType, iPSSysSFPub);
        if (StringHelper.isNullOrEmpty((String)strNameFormat)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u4ee3\u7801\u7c7b\u578b[%2$s]\u4ee3\u7801\u540d\u79f0", (Object)this.getFullName(), (Object)strCodeType));
        }
        String strModuleName = "";
        if (this.getPSSystemModule() != null) {
            strModuleName = this.getPSSystemModule().getCodeName();
        }
        if (this.isSubSysDE() && this.getDynamicMode() == 2 && strCodeType.indexOf(CODETYPE_SUBSYS) != 0 && !StringHelper.isNullOrEmpty((String)(strNameFormat2 = PSSFCodeObjectHelper.getClassOrPkgName(this, null, this.classOrPkgNameMap, CODETYPE_SUBSYS + strCodeType, iPSSysSFPub)))) {
            strModuleName = "SubSys";
            strPKGName = "";
        }
        if (StringHelper.isNullOrEmpty((String)strPKGName)) {
            strPKGName = iPSSysSFPub.getPKGCodeName();
        }
        if (iPSSysSFPub.getPSSFStyle().getPSSF().isPkgLowercase()) {
            strModuleName = strModuleName.toLowerCase();
        }
        return StringHelper.format((String)strNameFormat, (Object)strPKGName, (Object)strModuleName, (Object)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u5b9e\u4f53", ignoredumpvalues="false", dynamodelmode=4, doc="\u7531\u6240\u5c5e\u6a21\u5757\u51b3\u5b9a")
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
            }
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u503c\u89c4\u5219[%2$s]", (Object)this.getName(), (Object)strPSDEFValueRuleId));
        }
        return iPSDEFValueRule;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219\u96c6\u5408", group="\u5904\u7406\u903b\u8f91", order=295)
    public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception {
        this.preparePSDEFValueRules();
        return this.psDEFValueRuleList.iterator();
    }

    private synchronized void preparePSDEFValueRules() throws Exception {
        if (this.psDEFValueRuleMap != null && this.psDEFValueRuleList != null) {
            return;
        }
        LinkedHashMap<String, IPSDEFValueRule> psDEFValueRuleMap = new LinkedHashMap<String, IPSDEFValueRule>();
        ArrayList<IPSDEFValueRule> psDEFValueRuleList = new ArrayList<IPSDEFValueRule>();
        for (IPSDEField iPSDEField : this.defHelpers) {
            Iterator<IPSDEFValueRule> psDEFValueRules = iPSDEField.getAllPSDEFValueRules();
            if (psDEFValueRules == null) continue;
            while (psDEFValueRules.hasNext()) {
                IPSDEFValueRule iPSDEFValueRule = psDEFValueRules.next();
                psDEFValueRuleMap.put(iPSDEFValueRule.getId(), iPSDEFValueRule);
                psDEFValueRuleList.add(iPSDEFValueRule);
            }
        }
        this.psDEFValueRuleMap = psDEFValueRuleMap;
        this.psDEFValueRuleList = psDEFValueRuleList;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6d4b\u8bd5\u7528\u4f8b\u96c6\u5408", child=true, dumpref=true, ignorert=3, dynamodelmode=4, group="\u6d4b\u8bd5", order=555)
    public Iterator<IPSSysTestCase> getAllPSSysTestCases() throws Exception {
        Iterator<IPSSysTestCase> psSysTestCases = this.getPSSystem().getAllPSSysTestCases();
        if (psSysTestCases == null) {
            return null;
        }
        ArrayList<IPSSysTestCase> psSysTestCaseList = new ArrayList<IPSSysTestCase>();
        while (psSysTestCases.hasNext()) {
            IPSSysTestCase iPSSysTestCase = psSysTestCases.next();
            if (iPSSysTestCase.getPSDataEntity() == null || StringHelper.compare((String)iPSSysTestCase.getPSDataEntity().getId(), (String)this.getId(), (boolean)false) != 0) continue;
            psSysTestCaseList.add(iPSSysTestCase);
        }
        if (psSysTestCaseList.size() == 0) {
            return null;
        }
        return psSysTestCaseList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6d4b\u8bd5\u6570\u636e\u96c6\u5408", child=true, dumpref=true, ignorert=3, dynamodelmode=4, group="\u6d4b\u8bd5", order=556)
    public Iterator<IPSSysTestData> getAllPSSysTestDatas() throws Exception {
        Iterator<IPSSysTestData> psSysTestDatas = this.getPSSystem().getAllPSSysTestDatas();
        if (psSysTestDatas == null) {
            return null;
        }
        ArrayList<IPSSysTestData> psSysTestDataList = new ArrayList<IPSSysTestData>();
        while (psSysTestDatas.hasNext()) {
            IPSSysTestData iPSSysTestData = psSysTestDatas.next();
            if (iPSSysTestData.getPSDataEntity() == null || StringHelper.compare((String)iPSSysTestData.getPSDataEntity().getId(), (String)this.getId(), (boolean)false) != 0) continue;
            psSysTestDataList.add(iPSSysTestData);
        }
        if (psSysTestDataList.size() == 0) {
            return null;
        }
        return psSysTestDataList.iterator();
    }

    @Override
    public boolean isEnableDEMainState() {
        return this.mainStateFieldList != null && this.mainStateFieldList.size() != 0;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u65b9\u5f0f", codelist="DEDataAccCtrlMode", dynamodelmode=4, group="\u8bbf\u95ee\u63a7\u5236", order=503, fields={"DATAACCMODE"})
    public int getDataAccCtrlMode() {
        return this.nDataAccCtrlMode;
    }

    @Override
    @PSModelRTMeta(description="\u5ba1\u8ba1\u6a21\u5f0f", codelist="DEDataAuditMode", dynamodelmode=4, ignoredumpvalues="0", group="\u8bbf\u95ee\u63a7\u5236", order=505, fields={"AUDITMODE"})
    public int getAuditMode() {
        return this.nAuditMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u6807\u5bf9\u8c61", dump=false)
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public void checkDataEntity() throws Exception {
        this.onCheckDataEntity();
    }

    protected void onCheckDataEntity() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getIndexDEType()) && this.getIndexTypePSDEField() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u7d22\u5f15/\u7ee7\u627f\u6a21\u5f0f\uff0c\u4f46\u672a\u5b9a\u4e49\u7d22\u5f15\u5c5e\u6027", (Object)this.getName()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.getIndexDEType()) && this.getIndexTypePSDEField().getPSCodeList() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u7d22\u5f15/\u7ee7\u627f\u6a21\u5f0f\uff0c\u4f46\u672a\u5b9a\u4e49\u7d22\u5f15\u5c5e\u6027\u7684\u4ee3\u7801\u8868", (Object)this.getName()));
        }
        if (this.isEnableMultiForm() && this.getFormTypePSDEField() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u591a\u8868\u5355\u6a21\u5f0f\uff0c\u4f46\u672a\u5b9a\u4e49\u8868\u5355\u8bc6\u522b\u5c5e\u6027", (Object)this.getName()));
        }
        if (this.isEnableMultiForm() && this.getFormTypePSDEField().getPSCodeList() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u591a\u8868\u5355\u6a21\u5f0f\uff0c\u4f46\u672a\u5b9a\u4e49\u8868\u5355\u8bc6\u522b\u5c5e\u6027\u7684\u4ee3\u7801\u8868", (Object)this.getName()));
        }
        if (this.getVirtualMode() == 2 && this.getInheritPSDataEntity() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u7ee7\u627f\u865a\u62df\u6a21\u5f0f\uff0c\u4f46\u672a\u6307\u5b9a\u7ee7\u627f\u5b9e\u4f53", (Object)this.getName()));
        }
        if (this.getDEType() == 3) {
            this.getPSDERNN();
        }
        if (this.getDEType() == 4) {
            if (this.getPSDEFieldByPDT("PARENTTYPE", true) == null) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u7c7b\u578b\u4e3a\u52a8\u6001\u9644\u5c5e\u5b9e\u4f53\uff0c\u4f46\u672a\u6307\u5b9a\u52a8\u6001\u7236\u7c7b\u578b\u5b58\u50a8\u5c5e\u6027", (Object)this.getName()));
            }
            if (this.getPSDEFieldByPDT("PARENTID", true) == null) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u7c7b\u578b\u4e3a\u52a8\u6001\u9644\u5c5e\u5b9e\u4f53\uff0c\u4f46\u672a\u6307\u5b9a\u52a8\u6001\u7236\u6807\u8bc6\u5b58\u50a8\u5c5e\u6027", (Object)this.getName()));
            }
        }
    }

    @Override
    public Iterator<String> getPDTViewNames() {
        if (this.predefineDEViewMap.size() == 0) {
            return null;
        }
        return this.predefineDEViewMap.keySet().iterator();
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
        ArrayList<PSDEViewBase> list = new ArrayList<PSDEViewBase>();
        Iterator<IPSDERIndex> psDERIndexs = this.getPSDERIndexs(true);
        if (psDERIndexs != null) {
            while (psDERIndexs.hasNext()) {
                IPSDERIndex iPSDERIndex = psDERIndexs.next();
                IPSDataEntity minorPSDataEntity = this.getPSSystem().getPSDataEntity2(iPSDERIndex.getMinorPSDEId());
                if (minorPSDataEntity.getVirtualMode() != 0) continue;
                ArrayList<PSDEViewBase> list2 = minorPSDataEntity.getSDPSDEViewDataList(bIncWFView, bMobile);
                for (PSDEViewBase psDEViewBase : list2) {
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
        } else {
            boolean bDynaInstMode;
            boolean bl = bDynaInstMode = this.getPSSystemDynaInstMode() != 0;
            if (bMobile) {
                String[] stringArray = MOBSDPDTVIEWS;
                int n = MOBSDPDTVIEWS.length;
                int n2 = 0;
                while (n2 < n) {
                    Iterator<PSDEViewBase> psDEViewBases;
                    boolean bWFMode;
                    String strPDTType = stringArray[n2];
                    boolean bl2 = bWFMode = StringHelper.compare((String)strPDTType, (String)"MOBWFEDITVIEW", (boolean)false) == 0;
                    if ((bIncWFView || !bWFMode) && (psDEViewBases = this.getPSDEViewDatasByPDT(strPDTType)) != null) {
                        while (psDEViewBases.hasNext()) {
                            PSDEViewBase psDEViewBase = psDEViewBases.next();
                            if (bDynaInstMode && bWFMode && !DynaInstWFEditViewMap.containsKey(psDEViewBase.getPSDEVIEWBASETYPE())) continue;
                            list.add(psDEViewBase);
                        }
                    }
                    ++n2;
                }
            } else {
                String[] stringArray = SDPDTVIEWS;
                int n = SDPDTVIEWS.length;
                int n3 = 0;
                while (n3 < n) {
                    Iterator<PSDEViewBase> psDEViewBases;
                    boolean bWFMode;
                    String strPDTType = stringArray[n3];
                    boolean bl3 = bWFMode = StringHelper.compare((String)strPDTType, (String)"WFEDITVIEW", (boolean)false) == 0;
                    if ((bIncWFView || !bWFMode) && (psDEViewBases = this.getPSDEViewDatasByPDT(strPDTType)) != null) {
                        while (psDEViewBases.hasNext()) {
                            PSDEViewBase psDEViewBase = psDEViewBases.next();
                            if (bDynaInstMode && bWFMode && !DynaInstWFEditViewMap.containsKey(psDEViewBase.getPSDEVIEWBASETYPE())) continue;
                            list.add(psDEViewBase);
                        }
                    }
                    ++n3;
                }
            }
        }
        return list;
    }

    public IDERIndex getDERIndex(boolean bMajor, String strIndexValue) throws Exception {
        Iterator<IDERBase> derBases = this.getDERs(bMajor);
        if (derBases != null) {
            while (derBases.hasNext()) {
                IDERIndex iDERIndex;
                IDERBase iDERBase = derBases.next();
                if (!(iDERBase instanceof IDERIndex) || StringHelper.compare((String)(iDERIndex = (IDERIndex)iDERBase).getTypeValue(), (String)strIndexValue, (boolean)true) != 0) continue;
                return iDERIndex;
            }
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7c7b\u578b\u503c[%2$s]\u7d22\u5f15\u5173\u7cfb[%3$s]", (Object)this.getName(), (Object)strIndexValue, (Object)bMajor));
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7d22\u5f15\u96c6\u5408", group="\u6570\u636e\u5e93\u5b58\u50a8", order=391, child=true, dynamodelmode=4)
    public Iterator<IPSDEDBIndex> getAllPSDEDBIndices() throws Exception {
        return this.psDEDBIndexGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSDEDBIndex> getAllPSDEDBIndexs() throws Exception {
        return this.getAllPSDEDBIndices();
    }

    @Override
    public IPSDEDBIndex getPSDEDBIndex(String strDEDBIndexId) throws Exception {
        return (IPSDEDBIndex)this.psDEDBIndexGlobalModel.FindModelHelper(strDEDBIndexId);
    }

    @Override
    public IPSDEDBIndex getPSDEDBIndex(String strDEDBIndexId, boolean bTryMode) throws Exception {
        return (IPSDEDBIndex)this.psDEDBIndexGlobalModel.FindModelHelper(strDEDBIndexId, bTryMode);
    }

    @Override
    public void resetPSDEDBIndex(String strDEDBIndexId) throws Exception {
        this.psDEDBIndexGlobalModel.ResetModel(strDEDBIndexId);
    }

    public IDataEntity getInheritDataEntity() throws Exception {
        return this.getInheritPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u62a5\u8868\u96c6\u5408", child=true, dynamodelmode=5, group="\u6253\u5370\u53ca\u62a5\u8868", order=472)
    public Iterator<IPSDEReport> getAllPSDEReports() throws Exception {
        return this.psDEReportGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEReport getPSDEReport(String strDEReportId) throws Exception {
        return (IPSDEReport)this.psDEReportGlobalModel.FindModelHelper(strDEReportId);
    }

    @Override
    public IPSDEReport getPSDEReport(String strDEReportId, boolean bTryMode) throws Exception {
        return (IPSDEReport)this.psDEReportGlobalModel.FindModelHelper(strDEReportId, bTryMode);
    }

    @Override
    public void resetPSDEReport(String strDEReportId) throws Exception {
        this.psDEReportGlobalModel.ResetModel(strDEReportId);
    }

    public int getDynamicMode() {
        return this.nDynamicMode;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u6a21\u5f0f", codelist="DEExtendMode", dynamodelmode=4)
    public int getExtendMode() {
        return this.nDynamicMode;
    }

    protected void setDynamicMode(int nDynamicMode) {
        this.nDynamicMode = nDynamicMode;
    }

    public String getMapDEOPPrivTag(String strDEOPPrivTag, String strDERName) {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6253\u5370\u96c6\u5408", child=true, dynamodelmode=5, group="\u6253\u5370\u53ca\u62a5\u8868", order=470)
    public Iterator<IPSDEPrint> getAllPSDEPrints() throws Exception {
        return this.psDEPrintGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEPrint getPSDEPrint(String strDEPrintId) throws Exception {
        return (IPSDEPrint)this.psDEPrintGlobalModel.FindModelHelper(strDEPrintId);
    }

    @Override
    public IPSDEPrint getPSDEPrint(String strDEPrintId, boolean bTryMode) throws Exception {
        return (IPSDEPrint)this.psDEPrintGlobalModel.FindModelHelper(strDEPrintId, bTryMode);
    }

    @Override
    public void resetPSDEPrint(String strDEPrintId) throws Exception {
        this.psDEPrintGlobalModel.ResetModel(strDEPrintId);
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6253\u5370")
    public IPSDEPrint getDefaultPSDEPrint() throws Exception {
        if (this.getDefaultPSDEPrintData() != null) {
            return this.getPSDEPrint(this.getDefaultPSDEPrintData().getPSDEPRINTID());
        }
        return this.getPSDEPrint("DEFAULT", true);
    }

    public PSDEPrint getDefaultPSDEPrintData() {
        return this.defaultPSDEPrintData;
    }

    @Override
    @PSModelRTMeta(description="\u6709\u5b9e\u4f53\u6253\u5370", dump=false)
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
        return (IPSDEViewLogic)this.psDEViewLogicGlobalModel.FindModelHelper(strDEViewLogicId);
    }

    @Override
    public IPSDEViewLogic getPSDEViewLogic(String strDEViewLogicId, boolean bTryMode) throws Exception {
        return (IPSDEViewLogic)this.psDEViewLogicGlobalModel.FindModelHelper(strDEViewLogicId, bTryMode);
    }

    protected int calcDynamicMode(int nCheckExtendMode) throws Exception {
        if (nCheckExtendMode == 2 && !this.isSubSysDE() && !this.isEnableAPIStorage()) {
            return 0;
        }
        Iterator<IPSDEDataQuery> psDEDataQueries = this.getAllPSDEDataQueries();
        while (psDEDataQueries.hasNext()) {
            IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
            if (iPSDEDataQuery.getExtendMode() != nCheckExtendMode) continue;
            return nCheckExtendMode;
        }
        Iterator<IPSDEDataSet> psDEDataSets = this.getAllPSDEDataSets();
        while (psDEDataSets.hasNext()) {
            IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
            if (iPSDEDataSet.getExtendMode() != nCheckExtendMode) continue;
            return nCheckExtendMode;
        }
        Iterator<IPSDEACMode> psDEACModes = this.getAllPSDEACModes();
        while (psDEACModes.hasNext()) {
            IPSDEACMode iPSDEACMode = psDEACModes.next();
            if (iPSDEACMode.getExtendMode() != nCheckExtendMode) continue;
            return nCheckExtendMode;
        }
        Iterator<IPSDELogic> psDELogics = this.getAllPSDELogics();
        while (psDELogics.hasNext()) {
            IPSDELogic iPSDELogic = psDELogics.next();
            if (iPSDELogic.getExtendMode() != nCheckExtendMode) continue;
            return nCheckExtendMode;
        }
        Iterator<IPSDEField> psDEFields = this.getAllPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            Iterator<IPSDEFSearchMode> psDEFSearchModes = iPSDEField.getAllPSDEFSearchModes();
            if (psDEFSearchModes == null) continue;
            while (psDEFSearchModes.hasNext()) {
                IPSDEFSearchMode iPSDEFSearchMode = psDEFSearchModes.next();
                if (iPSDEFSearchMode.getExtendMode() != nCheckExtendMode) continue;
                return nCheckExtendMode;
            }
        }
        Iterator<IPSDEUIAction> psDEUIActions = this.getAllPSDEUIActions();
        while (psDEUIActions.hasNext()) {
            IPSDEUIAction iPSDEUIAction = psDEUIActions.next();
            if (iPSDEUIAction.getExtendMode() != nCheckExtendMode) continue;
            return nCheckExtendMode;
        }
        Iterator<IPSDEAction> psDEActions = this.getAllPSDEActions();
        while (psDEActions.hasNext()) {
            IPSDEAction iPSDEAction = psDEActions.next();
            if (iPSDEAction.getExtendMode() != nCheckExtendMode) continue;
            return nCheckExtendMode;
        }
        Iterator<IPSDEReport> psDEReports = this.getAllPSDEReports();
        while (psDEReports.hasNext()) {
            IPSDEReport iPSDEReport = psDEReports.next();
            if (iPSDEReport.getExtendMode() != nCheckExtendMode) continue;
            return nCheckExtendMode;
        }
        Iterator<IPSDEPrint> psDEPrints = this.getAllPSDEPrints();
        while (psDEPrints.hasNext()) {
            IPSDEPrint iPSDEPrint = psDEPrints.next();
            if (iPSDEPrint.getExtendMode() != nCheckExtendMode) continue;
            return nCheckExtendMode;
        }
        Iterator<IPSDEUtil> psDEUtils = this.getAllPSDEUtils();
        while (psDEUtils.hasNext()) {
            IPSDEUtil iPSDEUtil = psDEUtils.next();
            if (iPSDEUtil.getExtendMode() != nCheckExtendMode) continue;
            return nCheckExtendMode;
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

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5411\u5bfc\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEWizard> getAllPSDEWizards() throws Exception {
        return this.psDEWizardGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEWizard getPSDEWizard(String strDEWizardId) throws Exception {
        return (IPSDEWizard)this.psDEWizardGlobalModel.FindModelHelper(strDEWizardId);
    }

    @Override
    public IPSDEWizard getPSDEWizard(String strDEWizardId, boolean bTryMode) throws Exception {
        return (IPSDEWizard)this.psDEWizardGlobalModel.FindModelHelper(strDEWizardId, bTryMode);
    }

    @Override
    public void resetPSDEWizard(String strDEWizardId) throws Exception {
        this.psDEWizardGlobalModel.ResetModel(strDEWizardId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u96c6\u5408", child=true, dynamodelmode=5, group="\u5904\u7406\u903b\u8f91", order=300)
    public Iterator<IPSDEDataSync> getAllPSDEDataSyncs() throws Exception {
        return this.psDEDataSyncGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEDataSync getPSDEDataSync(String strDEDataSyncId) throws Exception {
        return (IPSDEDataSync)this.psDEDataSyncGlobalModel.FindModelHelper(strDEDataSyncId);
    }

    @Override
    public IPSDEDataSync getPSDEDataSync(String strDEDataSyncId, boolean bTryMode) throws Exception {
        return (IPSDEDataSync)this.psDEDataSyncGlobalModel.FindModelHelper(strDEDataSyncId, bTryMode);
    }

    @Override
    public void resetPSDEDataSync(String strDEDataSyncId) throws Exception {
        this.psDEDataSyncGlobalModel.ResetModel(strDEDataSyncId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u53d8\u5316\u65e5\u5fd7\u6a21\u5f0f", codelist="DEDataChgLogMode", dynamodelmode=4, fields={"DATACHGLOGMODE"})
    public int getDataChangeLogMode() {
        return this.nDataChangeLogMode;
    }

    public Iterator<IDEDataSync> getDEDataSyncs(boolean bIn) {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f531:1\u5173\u7cfb", hideempty=true)
    public IPSDER11 getPSDER11() throws Exception {
        return this.minorPSDERGlobalModel.getPSDER11();
    }

    @Override
    @PSModelRTMeta(description="\u865a\u62df\u5b9e\u4f53", dynamodelmode=4, ignoredumpvalues="false", fields={"VIRTUALFLAG"})
    public boolean isVirtual() {
        return this.bVirtual;
    }

    @Override
    public Iterator<IPSDERMultiInherit> getPSDERMultiInherits(boolean bMajor) throws Exception {
        if (bMajor) {
            return this.majorPSDERGlobalModel.getPSDERMultiInherits();
        }
        return this.minorPSDERGlobalModel.getPSDERMultiInherits();
    }

    @PSModelRTMeta(description="\u65e0\u89c6\u56fe\u6a21\u5f0f", dump=false, group="\u6570\u636e\u5e93\u5b58\u50a8", fields={"NOVIEWMODE"})
    public boolean isNoViewMode() {
        return this.bNoViewMode || this.getSaaSMode() != IPSDataEntity.SAASMODE_NOTSUPPORTED.intValue();
    }

    public IDEDataQuery getDefaultDEDataQuery() {
        return this.psDEDataQueryGlobalModel.getDefaultPSDEDataQuery();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5927\u6570\u636e\u8868\u96c6\u5408", group="\u529f\u80fd\u914d\u7f6e", order=429)
    public Iterator<IPSDEBDTable> getAllPSDEBDTables() throws Exception {
        return this.psDEBDTableGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEBDTable getPSDEBDTable(String strDEBDTableId) throws Exception {
        return (IPSDEBDTable)this.psDEBDTableGlobalModel.FindModelHelper(strDEBDTableId);
    }

    @Override
    public void resetPSDEBDTable(String strDEBDTableId) throws Exception {
        this.psDEBDTableGlobalModel.ResetModel(strDEBDTableId);
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b58\u50a8\u6a21\u5f0f", codelist="DEStorageType", dynamodelmode=4, group="\u6301\u4e45\u5316", fields={"STORAGEMODE"})
    public int getStorageMode() {
        return this.nStorageMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u96c6\u5408", child=true, dynamodelmode=5, group="\u5904\u7406\u903b\u8f91", order=292)
    public Iterator<IPSDEDataExport> getAllPSDEDataExports() throws Exception {
        return this.psDEDataExportGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEDataExport getPSDEDataExport(String strDEDataExportId) throws Exception {
        return (IPSDEDataExport)this.psDEDataExportGlobalModel.FindModelHelper(strDEDataExportId);
    }

    @Override
    public IPSDEDataExport getPSDEDataExport(String strDEDataExportId, boolean bTryMode) throws Exception {
        return (IPSDEDataExport)this.psDEDataExportGlobalModel.FindModelHelper(strDEDataExportId, bTryMode);
    }

    @Override
    public void resetPSDEDataExport(String strDEDataExportId) throws Exception {
        this.psDEDataExportGlobalModel.ResetModel(strDEDataExportId);
    }

    public IDEDataExport getDEDataExport(String strDEDataExportId) throws Exception {
        return this.getPSDEDataExport(strDEDataExportId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u96c6\u5408", child=true, dynamodelmode=5, group="\u5904\u7406\u903b\u8f91", order=291)
    public Iterator<IPSDEDataImport> getAllPSDEDataImports() throws Exception {
        return this.psDEDataImportGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEDataImport getPSDEDataImport(String strDEDataImportId) throws Exception {
        return (IPSDEDataImport)this.psDEDataImportGlobalModel.FindModelHelper(strDEDataImportId);
    }

    @Override
    public IPSDEDataImport getPSDEDataImport(String strDEDataImportId, boolean bTryMode) throws Exception {
        return (IPSDEDataImport)this.psDEDataImportGlobalModel.FindModelHelper(strDEDataImportId, bTryMode);
    }

    @Override
    public void resetPSDEDataImport(String strDEDataImportId) throws Exception {
        this.psDEDataImportGlobalModel.ResetModel(strDEDataImportId);
    }

    public IDEDataImport getDEDataImport(String strDEDataImportId) throws Exception {
        return this.getPSDEDataImport(strDEDataImportId);
    }

    public IDEDataImport getDefaultDEDataImport() {
        return this.psDEDataImportGlobalModel.getDefaultPSDEDataImport();
    }

    @Override
    public Iterator<IPSDEActionWizard> getAllPSDEActionWizards() throws Exception {
        return this.psDEActionWizardGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEActionWizard getPSDEActionWizard(String strDEActionWizardId) throws Exception {
        return (IPSDEActionWizard)this.psDEActionWizardGlobalModel.FindModelHelper(strDEActionWizardId);
    }

    @Override
    public IPSDEActionWizard getPSDEActionWizard(String strDEActionWizardId, boolean bTryMode) throws Exception {
        return (IPSDEActionWizard)this.psDEActionWizardGlobalModel.FindModelHelper(strDEActionWizardId, bTryMode);
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
        return (IPSDEActionWizardGroup)this.psDEActionWizardGroupGlobalModel.FindModelHelper(strDEActionWizardGroupId);
    }

    @Override
    public IPSDEActionWizardGroup getPSDEActionWizardGroup(String strDEActionWizardGroupId, boolean bTryMode) throws Exception {
        return (IPSDEActionWizardGroup)this.psDEActionWizardGroupGlobalModel.FindModelHelper(strDEActionWizardGroupId, bTryMode);
    }

    @Override
    public void resetPSDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception {
        this.psDEActionWizardGroupGlobalModel.ResetModel(strDEActionWizardGroupId);
    }

    public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception {
        return (IDEActionWizardGroup)this.psDEActionWizardGroupGlobalModel.FindModelHelper(strDEActionWizardGroupId);
    }

    public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId, boolean bTryMode) throws Exception {
        return (IDEActionWizardGroup)this.psDEActionWizardGroupGlobalModel.FindModelHelper(strDEActionWizardGroupId, bTryMode);
    }

    public IDEActionWizard getDEActionWizard(String strDEActionWizardId) throws Exception {
        return (IDEActionWizard)this.psDEActionWizardGlobalModel.FindModelHelper(strDEActionWizardId);
    }

    @Override
    public String getLNLanResTag() {
        if (this.getLNPSLanguageRes() == null) {
            return this.strLNLanResTag;
        }
        return this.getLNPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        return this.lnPSLanguageRes;
    }

    @Override
    public String getPSHelpModuleId() {
        return this.strPSHelpModuleId;
    }

    public IDEBATable getDEBATable(String strDEBATableId) throws Exception {
        return this.getPSDEBDTable(strDEBATableId);
    }

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
        this.info("\u6a21\u578b\u8ba1\u6570", null, objNode);
        return super.check();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe2\u540d\u79f0", hideempty2=true, dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=381)
    public String getView2Name() {
        try {
            if ((this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) && !this.isNoViewMode()) {
                return this.psDataEntity.getVIEWNAME2();
            }
        }
        catch (Exception e) {
            log.error((Object)e);
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe3\u540d\u79f0", hideempty2=true, dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=382)
    public String getView3Name() {
        try {
            if ((this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) && !this.isNoViewMode()) {
                return this.psDataEntity.getVIEWNAME3();
            }
        }
        catch (Exception e) {
            log.error((Object)e);
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe4\u540d\u79f0", hideempty2=true, dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=382)
    public String getView4Name() {
        try {
            if ((this.isEnableSQLStorage() || this.isEnableNoSQLStorage()) && !this.isNoViewMode()) {
                return this.psDataEntity.getVIEWNAME4();
            }
        }
        catch (Exception e) {
            log.error((Object)e);
        }
        return "";
    }

    public IDEDataQuery getViewDEDataQuery(int nViewLevel) {
        return this.psDEDataQueryGlobalModel.getDefaultPSDEDataQuery();
    }

    @Override
    @PSModelRTMeta(description="\u865a\u62df\u4e3b\u952e\u5206\u9694\u7b26", hideempty2=true, dump=false)
    public String getVKeySeparator() {
        return this.psDataEntity.getVKEYSEPARATOR();
    }

    @Override
    public boolean isEnableViewLevel(int nViewLevel) {
        return this.nEnableViewLevel >= nViewLevel;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u89c6\u56fe\u7ea7\u522b", codelist="DEFieldViewColLevel", dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=380)
    public int getEnableViewLevel() {
        return this.nEnableViewLevel;
    }

    @Override
    public String getViewName(int nViewLevel) {
        switch (nViewLevel) {
            case -1: 
            case 0: {
                return this.getViewName();
            }
            case 3: {
                if (!StringHelper.isNullOrEmpty((String)this.getView4Name())) {
                    return this.getView4Name();
                }
            }
            case 2: {
                if (!StringHelper.isNullOrEmpty((String)this.getView3Name())) {
                    return this.getView3Name();
                }
            }
            case 1: {
                if (StringHelper.isNullOrEmpty((String)this.getView2Name())) break;
                return this.getView2Name();
            }
        }
        return this.getViewName();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5b9e\u4f53\u7f13\u5b58", dynamodelmode=4)
    public boolean isEnableEntityCache() {
        return this.bEnableEntityCache;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7f13\u5b58\u8d85\u65f6\u65f6\u957f\uff08\u6beb\u79d2\uff09", ignoredumpvalues="-1", dynamodelmode=4)
    public int getEntityCacheTimeout() {
        return this.nEntityCacheTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u7f13\u5b58\u5bf9\u8c61\u6570", dump=false)
    public int getMaxEntityCacheCount() {
        return this.nMaxEntityCacheCount;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7edf\u4e00\u72b6\u6001\u96c6\u5408", child=true, dynamodelmode=4, group="\u529f\u80fd\u914d\u7f6e", order=442)
    public Iterator<IPSDEUniState> getAllPSDEUniStates() throws Exception {
        return this.psDEUniStateGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEUniState getPSDEUniState(String strDEUniStateId) throws Exception {
        return (IPSDEUniState)this.psDEUniStateGlobalModel.FindModelHelper(strDEUniStateId);
    }

    @Override
    public IPSDEUniState getPSDEUniState(String strDEUniStateId, boolean bTryMode) throws Exception {
        return (IPSDEUniState)this.psDEUniStateGlobalModel.FindModelHelper(strDEUniStateId, bTryMode);
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

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u7edf\u4e00\u72b6\u6001", hideempty2=true)
    public IPSDEUniState getDefaultPSDEUniState() throws Exception {
        return this.psDEUniStateGlobalModel.getDefaultPSDEUniState();
    }

    public IDEUniState getDEUniState(String strDEUniStateId) throws Exception {
        return this.getPSDEUniState(strDEUniStateId);
    }

    public Iterator<IDEUniState> getDEUniStates() {
        return null;
    }

    public IDEUniState getDefaultDEUniState() {
        return this.psDEUniStateGlobalModel.getDefaultPSDEUniState();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5f02\u6b65\u5904\u7406\u961f\u5217\u96c6\u5408", child=true, dynamodelmode=4, group="\u529f\u80fd\u914d\u7f6e", order=440)
    public Iterator<IPSDEDTSQueue> getAllPSDEDTSQueues() throws Exception {
        return this.psDEDTSQueueGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEDTSQueue getPSDEDTSQueue(String strDEDTSQueueId) throws Exception {
        return (IPSDEDTSQueue)this.psDEDTSQueueGlobalModel.FindModelHelper(strDEDTSQueueId);
    }

    @Override
    public IPSDEDTSQueue getPSDEDTSQueue(String strDEDTSQueueId, boolean bTryMode) throws Exception {
        return (IPSDEDTSQueue)this.psDEDTSQueueGlobalModel.FindModelHelper(strDEDTSQueueId, bTryMode);
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

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u793a\u4f8b\u6570\u636e\u96c6\u5408", group="\u6d4b\u8bd5", order=550)
    public Iterator<IPSDESampleData> getAllPSDESampleDatas() throws Exception {
        return this.psDESampleDataGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDESampleData getPSDESampleData(String strDESampleDataId) throws Exception {
        return (IPSDESampleData)this.psDESampleDataGlobalModel.FindModelHelper(strDESampleDataId);
    }

    @Override
    public IPSDESampleData getPSDESampleData(String strDESampleDataId, boolean bTryMode) throws Exception {
        return (IPSDESampleData)this.psDESampleDataGlobalModel.FindModelHelper(strDESampleDataId, bTryMode);
    }

    @Override
    public IPSDESampleData getPSDESampleData(boolean bMust) throws Exception {
        IPSDESampleData iPSDESampleData = this.psDESampleDataGlobalModel.getRandomPSDESampleData();
        if (iPSDESampleData == null || bMust) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b9a\u4e49\u793a\u4f8b\u503c", (Object)this.getFullName()));
        }
        return iPSDESampleData;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u5bfc\u51fa\u6a21\u5f0f", codelist="DEDataImpExpMode", dynamodelmode=4, fields={"DATAIMPEXPFLAG"})
    public int getDataImpExpMode() {
        return this.nDataImpExpMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6a21\u578b\u5bfc\u5165\u5bfc\u51fa\u6a21\u5f0f", codelist="DEDataImpExpMode", dump=false)
    public int getModelImpExpMode() {
        return this.nModelImpExpMode;
    }

    public IDEField getUniTagDEField() {
        if (this.uniTagDEField != null) {
            return this.uniTagDEField;
        }
        if (DataTypeHelper.isStringDataType((int)this.getKeyDEField().getStdDataType())) {
            return this.getKeyDEField();
        }
        return null;
    }

    @Override
    public IPSDEField getUniTagPSDEField() {
        if (this.uniTagDEField != null) {
            return this.uniTagDEField;
        }
        if (this.getKeyPSDEField() != null && DataTypeHelper.isStringDataType((int)this.getKeyPSDEField().getStdDataType())) {
            return this.getKeyPSDEField();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u8d44\u6e90\u6a21\u5f0f", codelist="SysServiceApiMode", fields={"SERVICEAPIFLAG"})
    public int getServiceAPIMode() {
        if (this.isSubSysDE()) {
            return 0;
        }
        if (this.getStorageMode() == 4) {
            return 0;
        }
        return this.nServiceAPIMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u8d44\u6e90\u96c6\u5408", group="\u529f\u80fd\u914d\u7f6e", order=425)
    public Iterator<IPSDEServiceAPI> getAllPSDEServiceAPIs() throws Exception {
        return this.psDEServiceAPIGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEServiceAPI getPSDEServiceAPI(String strDEServiceAPIId) throws Exception {
        return (IPSDEServiceAPI)this.psDEServiceAPIGlobalModel.FindModelHelper(strDEServiceAPIId);
    }

    @Override
    public void resetPSDEServiceAPI(String strDEServiceAPIId) throws Exception {
        this.psDEServiceAPIGlobalModel.ResetModel(strDEServiceAPIId);
    }

    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u5ba2\u6237\u7aef\u6807\u8bc6", dynamodelmode=4)
    public String getServiceAPIClientId() {
        return this.strPSSubSysServiceAPIId;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", dynamodelmode=4, fields={"SERVICECODENAME"})
    public String getServiceCodeName() {
        return this.onGetServiceCodeName();
    }

    protected String onGetServiceCodeName() {
        if (!StringHelper.isNullOrEmpty((String)this.strServiceCodeName)) {
            return this.strServiceCodeName;
        }
        return this.getAPICodeName(null, this.getCodeName(), null);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u63a5\u53e3\u9ed8\u8ba4\u63d0\u4f9b\u5b9e\u4f53\u884c\u4e3a", dump=false)
    public boolean isEnableSADEAction() {
        return this.bEnableSADEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u63a5\u53e3\u9ed8\u8ba4\u63d0\u4f9b\u7b80\u5355\u67e5\u8be2", dump=false)
    public boolean isEnableSASelect() {
        return this.bEnableSASelect;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u63a5\u53e3\u9ed8\u8ba4\u63d0\u4f9b\u7ed3\u679c\u96c6\u67e5\u8be2", dump=false)
    public boolean isEnableSADEDataSet() {
        return this.bEnableSADEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u754c\u9762\u64cd\u4f5c", codelist="DEUserUIAbility2")
    public int getEnableUIActions() {
        return this.nEnableUIActions;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u4e3a\u64cd\u4f5c", codelist="DEUserUIAbility2")
    public int getEnableActions() {
        return this.nEnableActions;
    }

    public String getDefaultDEDTSQueueId() {
        if (this.psDEDTSQueueGlobalModel.getDefaultPSDEDTSQueue() != null) {
            return this.psDEDTSQueueGlobalModel.getDefaultPSDEDTSQueue().getId();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u5206\u5e03\u4e8b\u52a1\u5904\u7406\u961f\u5217", codelist="DEUserUIAbility2")
    public IPSDEDTSQueue getDefaultPSDEDTSQueue() throws Exception {
        String strDefaultPSDTSQueueId = this.getDefaultDEDTSQueueId();
        if (!StringHelper.isNullOrEmpty((String)strDefaultPSDTSQueueId)) {
            return this.getPSDEDTSQueue(strDefaultPSDTSQueueId);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u89d2\u8272\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEOPPrivRole> getAllPSDEOPPrivRoles() throws Exception {
        return this.psDEOPPrivRoleGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEOPPrivRole getPSDEOPPrivRole(String strDEOPPrivRoleId) throws Exception {
        return (IPSDEOPPrivRole)this.psDEOPPrivRoleGlobalModel.FindModelHelper(strDEOPPrivRoleId);
    }

    @Override
    public IPSDEOPPrivRole getPSDEOPPrivRole(String strDEOPPrivRoleId, boolean bTryMode) throws Exception {
        return (IPSDEOPPrivRole)this.psDEOPPrivRoleGlobalModel.FindModelHelper(strDEOPPrivRoleId, bTryMode);
    }

    @Override
    public void resetPSDEOPPrivRole(String strDEOPPrivRoleId) throws Exception {
        this.psDEOPPrivRoleGlobalModel.ResetModel(strDEOPPrivRoleId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272\u96c6\u5408", child=true, dynamodelmode=4, group="\u8bbf\u95ee\u63a7\u5236", order=515)
    public Iterator<IPSDEUserRole> getAllPSDEUserRoles() throws Exception {
        return this.psDEUserRoleGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEUserRole getPSDEUserRole(String strDEUserRoleId) throws Exception {
        return (IPSDEUserRole)this.psDEUserRoleGlobalModel.FindModelHelper(strDEUserRoleId);
    }

    @Override
    public IPSDEUserRole getPSDEUserRole(String strDEUserRoleId, boolean bTryMode) throws Exception {
        return (IPSDEUserRole)this.psDEUserRoleGlobalModel.FindModelHelper(strDEUserRoleId, bTryMode);
    }

    @Override
    public void resetPSDEUserRole(String strDEUserRoleId) throws Exception {
        this.psDEUserRoleGlobalModel.ResetModel(strDEUserRoleId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb", codelist="AccCtrlArch", dynamodelmode=4, group="\u8bbf\u95ee\u63a7\u5236", order=502, fields={"ACCCTRLARCH"})
    public int getDataAccCtrlArch() {
        return this.nDataAccCtrlArch;
    }

    public IDEUserRole getDEUserRole(String strDEUserRoleId) throws Exception {
        return this.getPSDEUserRole(strDEUserRoleId);
    }

    public Iterator<IDEUserRole> getDEUserRoles() {
        return null;
    }

    public Iterator<IDEOPPrivRole> getDEOPPrivRoles(String strDEOPrivTag) {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u529f\u80fd\u914d\u7f6e\u96c6\u5408", child=true, dynamodelmode=4, group="\u529f\u80fd\u914d\u7f6e", order=445)
    public Iterator<IPSDEUtil> getAllPSDEUtils() throws Exception {
        return this.psDEUtilGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEUtil getPSDEUtil(String strDEUtilId) throws Exception {
        return this.getPSDEUtil(strDEUtilId, false);
    }

    @Override
    public IPSDEUtil getPSDEUtil(String strDEUtilId, boolean bTryMode) throws Exception {
        IPSDEUtil iPSDEUtil = (IPSDEUtil)this.psDEUtilGlobalModel.FindModelHelper(strDEUtilId, true);
        if (iPSDEUtil != null) {
            return iPSDEUtil;
        }
        return this.getPSSystem().getPSSysUtil(strDEUtilId, bTryMode);
    }

    @Override
    public void resetPSDEUtil(String strDEUtilId) throws Exception {
        this.psDEUtilGlobalModel.ResetModel(strDEUtilId);
    }

    public boolean hasDEWF() {
        try {
            return this.hasPSDEWF();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u96c6\u5408", child=true, group="\u6a21\u578b", order=290)
    public Iterator<IPSDEField> getAllPSDEFields() throws Exception {
        return this.getPSDEFields();
    }

    @Override
    public String getModelName() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getName(), (Object)this.getLogicName());
    }

    public IDEDBConfig getDEDBConfig(String strDBType) throws Exception {
        return this.getPSDEDBConfig(strDBType);
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        return this.iPSSysSFPub;
    }

    @Override
    public boolean isEnableDynaStorage() {
        try {
            return this.getPSDEUtil("DYNASTORAGE", true) != null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    @Override
    @PSModelRTMeta(description="\u865a\u62df\u5b9e\u4f53\u6a21\u5f0f", codelist="DEVirtualMode", dynamodelmode=4, ignoredumpvalues="0", fields={"VIRTUALFLAG"})
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

    @Override
    @PSModelRTMeta(description="SaaS\u6a21\u5f0f", codelist="DESaaSMode", dynamodelmode=4, fields={"SAASMODE"})
    public int getSaaSMode() {
        return this.nSaaSMode;
    }

    @Override
    @PSModelRTMeta(description="SaaS\u6570\u636e\u4e3b\u952e\u5217", dynamodelmode=4)
    public String getSaaSDataIdColumnName() {
        String strSaaSDataIdColumnName;
        if (this.getSaaSMode() == SAASMODE_NOTSUPPORTED.intValue()) {
            return "";
        }
        if (this.getPSSysDBScheme() != null && !StringHelper.isNullOrEmpty((String)(strSaaSDataIdColumnName = this.getPSSysDBScheme().getSaaSDataIdColumnName()))) {
            return strSaaSDataIdColumnName;
        }
        return this.getUserParam("SAAS.IDCOLUMN", "SRFID");
    }

    @Override
    @PSModelRTMeta(description="SaaS\u6570\u636e\u79df\u6237\u5217", dynamodelmode=4)
    public String getSaaSDCIdColumnName() {
        String strSaaSDCIdColumnName;
        if (this.getSaaSMode() == SAASMODE_NOTSUPPORTED.intValue()) {
            return "";
        }
        if (this.getPSSysDBScheme() != null && !StringHelper.isNullOrEmpty((String)(strSaaSDCIdColumnName = this.getPSSysDBScheme().getSaaSDCIdColumnName()))) {
            return strSaaSDCIdColumnName;
        }
        return this.getUserParam("SAAS.DCCOLUMN", "SRFDCID");
    }

    @Override
    public Iterator<IPSAppView> getDataRedirectPSAppViews() throws Exception {
        PSDEViewBase psDEViewBase = this.getPSDEViewDataByPDT("REDIRECTVIEW", true);
        if (psDEViewBase != null) {
            ArrayList<IPSAppView> psAppViewList = new ArrayList<IPSAppView>();
            Iterator<IPSApplication> psApplications = this.getPSSystem().getAllPSApps();
            if (psApplications != null) {
                while (psApplications.hasNext()) {
                    IPSApplication iPSApplication = psApplications.next();
                    IPSAppView iPSAppView = iPSApplication.getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), true);
                    if (iPSAppView == null) continue;
                    psAppViewList.add(iPSAppView);
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
            ArrayList<IPSAppView> psAppViewList = new ArrayList<IPSAppView>();
            Iterator<IPSApplication> psApplications = this.getPSSystem().getAllPSApps();
            if (psApplications != null) {
                while (psApplications.hasNext()) {
                    IPSApplication iPSApplication = psApplications.next();
                    IPSAppView iPSAppView = iPSApplication.getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), true);
                    if (iPSAppView == null) continue;
                    psAppViewList.add(iPSAppView);
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

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u5f15\u7528", hideempty=true)
    public IPSSysRef getPSSysRef() {
        if (this.getPSSystemModule() == null) {
            return null;
        }
        return this.getPSSystemModule().getPSSysRef();
    }

    @Override
    @PSModelRTMeta(description="\u6240\u5c5e\u7cfb\u7edf\u6807\u8bc6", dynamodelmode=4)
    public String getSystemTag() {
        if (this.getPSSysRef() != null) {
            return this.getPSSysRef().getSystemTag();
        }
        return this.getPSSystem().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f")
    public IPSDEACMode getDefaultPSDEACMode() throws Exception {
        if (this.getDefaultPSDEACModeData() != null) {
            return this.getPSDEACMode(this.getDefaultPSDEACModeData().getPSDEACMODEID());
        }
        return this.getPSDEACMode("DEFAULT", true);
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6570\u636e\u96c6\u5408", dumpref=true, from="__self__", doc="\u9ed8\u8ba4\u5b9e\u4f53\u6570\u636e\u96c6\u53c2\u8003{@link net.ibizsys.model.dataentity.ds.IPSDEDataSet#isDefaultMode}")
    public IPSDEDataSet getDefaultPSDEDataSet() throws Exception {
        return this.psDEDataSetGlobalModel.getDefaultPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6570\u636e\u67e5\u8be2", dynamodelmode=4, dumpref=true, from="__self__", doc="\u9ed8\u8ba4\u5b9e\u4f53\u67e5\u8be2\u53c2\u8003{@link net.ibizsys.model.dataentity.ds.IPSDEDataQuery#isDefaultMode}")
    public IPSDEDataQuery getDefaultPSDEDataQuery() throws Exception {
        return this.psDEDataQueryGlobalModel.getDefaultPSDEDataQuery();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u89c6\u56fe\u6570\u636e\u67e5\u8be2", dynamodelmode=4, dumpref=true, from="__self__")
    public IPSDEDataQuery getViewPSDEDataQuery() throws Exception {
        return this.psDEDataQueryGlobalModel.getViewPSDEDataQuery();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3", hideempty=true, dumpref=true, dynamodelmode=4, fields={"PSSUBSYSSERVICEAPIID"})
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getServiceAPIClientId())) {
            return null;
        }
        if (this.iPSSubSysServiceAPI == null) {
            this.iPSSubSysServiceAPI = this.getPSSystem().getPSSubSysServiceAPI(this.getServiceAPIClientId());
        }
        return this.iPSSubSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53", hideempty=true, dumpref=true, from="IPSSubSysServiceAPI", dynamodelmode=4, fields={"PSSUBSYSSADEID"})
    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() throws Exception {
        if (this.getPSSubSysServiceAPI() == null) {
            return null;
        }
        if (this.iPSSubSysServiceAPIDE == null) {
            this.iPSSubSysServiceAPIDE = !StringHelper.isNullOrEmpty((String)this.psDataEntity.getPSSUBSYSSADEID()) ? this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.psDataEntity.getPSSUBSYSSADEID(), false) : this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.getName().toUpperCase(), true);
        }
        return this.iPSSubSysServiceAPIDE;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Iterator<IPSDER1N> getCustomExportPSDER1Ns(boolean bMajor) {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(bMajor);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N) || (iPSDER1N = (IPSDER1N)iPSDERBase).getCustomExportOrder() < 0) continue;
            psDER1NList.add(iPSDER1N);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    if (o1.getCustomExportOrder() == o2.getCustomExportOrder()) {
                        return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                    }
                    int nRet = o1.getCustomExportOrder() - o2.getCustomExportOrder();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Iterator<IPSDER1N> getCustomExport2PSDER1Ns(boolean bMajor) {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(bMajor);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N) || (iPSDER1N = (IPSDER1N)iPSDERBase).getCustomExportOrder2() < 0) continue;
            psDER1NList.add(iPSDER1N);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    if (o1.getCustomExportOrder2() == o2.getCustomExportOrder2()) {
                        return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                    }
                    int nRet = o1.getCustomExportOrder2() - o2.getCustomExportOrder2();
                    if (nRet == 0) {
                        return 0;
                    }
                    if (nRet > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u96c6\u5408", group="\u529f\u80fd\u914d\u7f6e", order=426)
    public Iterator<IPSAppDataEntity> getAllPSAppDataEntities() throws Exception {
        if (this.psAppDataEntityList == null) {
            ArrayList<IPSAppDataEntity> psAppDataEntityList2 = new ArrayList<IPSAppDataEntity>();
            Iterator<IPSApplication> psApplications = this.getPSSystem().getAllPSApps();
            if (psApplications != null) {
                while (psApplications.hasNext()) {
                    IPSApplication iPSApplication = psApplications.next();
                    IPSAppDataEntity iPSAppDataEntity = iPSApplication.getPSAppDataEntityByDEId(this.getId(), true);
                    if (iPSAppDataEntity == null) continue;
                    psAppDataEntityList2.add(iPSAppDataEntity);
                }
            }
            PSDataEntityImpl pSDataEntityImpl = this;
            synchronized (pSDataEntityImpl) {
                if (this.psAppDataEntityList == null) {
                    this.psAppDataEntityList = psAppDataEntityList2;
                }
            }
        }
        return this.psAppDataEntityList.iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\u96c6\u5408", outputdoc="false")
    public Iterator<IPSAppView> getAllPSAppViews() throws Exception {
        if (this.psAppViewList == null) {
            ArrayList<IPSAppView> psAppViewList2 = new ArrayList<IPSAppView>();
            Iterator<IPSAppDataEntity> psAppDataEntities = this.getAllPSAppDataEntities();
            if (psAppDataEntities != null) {
                while (psAppDataEntities.hasNext()) {
                    IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                    Iterator<IPSAppView> psAppViews = iPSAppDataEntity.getAllPSAppViews();
                    if (psAppViews == null) continue;
                    while (psAppViews.hasNext()) {
                        psAppViewList2.add(psAppViews.next());
                    }
                }
            }
            PSDataEntityImpl pSDataEntityImpl = this;
            synchronized (pSDataEntityImpl) {
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
            if (StringHelper.compare((String)iPSAppDataEntity.getId(), (String)strPSSysAppId, (boolean)false) != 0 && StringHelper.compare((String)iPSAppDataEntity.getPSApplication().getId(), (String)strPSSysAppId, (boolean)false) != 0) continue;
            return iPSAppDataEntity;
        }
        if (!bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53[%1$s]", (Object)strPSSysAppId));
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6709\u5e94\u7528\u5b9e\u4f53", dump=false)
    public boolean hasPSAppDataEntity() throws Exception {
        this.getAllPSAppDataEntities();
        return this.psAppDataEntityList.size() > 0;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u7ec4\u96c6\u5408", child=true, rtname="getDEFGroups", dynamodelmode=4, group="\u6a21\u578b\u9ad8\u7ea7", order=570)
    public Iterator<IPSDEFGroup> getAllPSDEFGroups() throws Exception {
        return this.psDEFGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEFGroup getPSDEFGroup(String strDEFGroupId) throws Exception {
        return (IPSDEFGroup)this.psDEFGroupGlobalModel.FindModelHelper(strDEFGroupId);
    }

    @Override
    public IPSDEFGroup getPSDEFGroup(String strDEFGroupId, boolean bTryMode) throws Exception {
        return (IPSDEFGroup)this.psDEFGroupGlobalModel.FindModelHelper(strDEFGroupId, bTryMode);
    }

    @Override
    public void resetPSDEFGroup(String strDEFGroupId) throws Exception {
        this.psDEFGroupGlobalModel.ResetModel(strDEFGroupId);
    }

    @Override
    public IPSDEField getPSDEFieldByBizTag(String strBizTag, boolean bTryMode) throws Exception {
        String strFullBizTag = StringHelper.format((String)"%1$s#%2$s", (Object)SRFBIZTAG, (Object)strBizTag);
        IPSDEField iPSDEField = this.internalGetPSDEField(strFullBizTag, true);
        if (iPSDEField == null && !bTryMode) {
            throw new PSDataEntityException(this, 20000, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u4e1a\u52a1\u6807\u8bb0\u5c5e\u6027[%2$s]", (Object)this.getFullName(), (Object)strBizTag));
        }
        return iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u7248\u672c\u80fd\u529b", dynamodelmode=4)
    public boolean isEnableDataVer() {
        return this.bEnableDataVer;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7ec4\u96c6\u5408", child=true, dumpref=true, rtdump=2, rtname="getDEGroups", dynamodelmode=8, group="\u6a21\u578b\u9ad8\u7ea7", order=575)
    public Iterator<IPSDEGroup> getAllPSDEGroups() throws Exception {
        return this.psDEGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEGroup getPSDEGroup(String strDEGroupId) throws Exception {
        return (IPSDEGroup)this.psDEGroupGlobalModel.FindModelHelper(strDEGroupId);
    }

    @Override
    public IPSDEGroup getPSDEGroup(String strDEGroupId, boolean bTryMode) throws Exception {
        return (IPSDEGroup)this.psDEGroupGlobalModel.FindModelHelper(strDEGroupId, bTryMode);
    }

    @Override
    public void resetPSDEGroup(String strDEGroupId) throws Exception {
        this.psDEGroupGlobalModel.ResetModel(strDEGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u96c6\u5408", child=true, dumpref=true, rtdump=2, rtname="getDERGroups", dynamodelmode=8, group="\u6a21\u578b\u9ad8\u7ea7", order=580)
    public Iterator<IPSDERGroup> getAllPSDERGroups() throws Exception {
        return this.psDERGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDERGroup getPSDERGroup(String strDERGroupId) throws Exception {
        return (IPSDERGroup)this.psDERGroupGlobalModel.FindModelHelper(strDERGroupId);
    }

    @Override
    public IPSDERGroup getPSDERGroup(String strDERGroupId, boolean bTryMode) throws Exception {
        return (IPSDERGroup)this.psDERGroupGlobalModel.FindModelHelper(strDERGroupId, bTryMode);
    }

    @Override
    public void resetPSDERGroup(String strDERGroupId) throws Exception {
        this.psDERGroupGlobalModel.ResetModel(strDERGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u7ec4\u96c6\u5408", child=true, dumpref=true, rtdump=2, dynamodelmode=8, group="\u6a21\u578b\u9ad8\u7ea7", order=585)
    public Iterator<IPSDEActionGroup> getAllPSDEActionGroups() throws Exception {
        return this.psDEActionGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEActionGroup getPSDEActionGroup(String strDEActionGroupId) throws Exception {
        return (IPSDEActionGroup)this.psDEActionGroupGlobalModel.FindModelHelper(strDEActionGroupId);
    }

    @Override
    public IPSDEActionGroup getPSDEActionGroup(String strDEActionGroupId, boolean bTryMode) throws Exception {
        return (IPSDEActionGroup)this.psDEActionGroupGlobalModel.FindModelHelper(strDEActionGroupId, bTryMode);
    }

    @Override
    public void resetPSDEActionGroup(String strDEActionGroupId) throws Exception {
        this.psDEActionGroupGlobalModel.ResetModel(strDEActionGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5e2e\u52a9\u6587\u7ae0\u96c6\u5408", outputdoc="false")
    public Iterator<IPSHelpArticle> getAllPSHelpArticles() throws Exception {
        ArrayList<IPSHelpArticle> psHelpArticleList = new ArrayList<IPSHelpArticle>();
        Iterator<IPSHelpArticle> allPSHelpArticles = this.getPSSystem().getAllPSHelpArticles();
        if (allPSHelpArticles != null) {
            while (allPSHelpArticles.hasNext()) {
                IPSHelpArticle iPSHelpArticle = allPSHelpArticles.next();
                if (iPSHelpArticle.getPSDataEntity() == null || StringHelper.compare((String)iPSHelpArticle.getPSDataEntity().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                psHelpArticleList.add(iPSHelpArticle);
            }
        }
        return psHelpArticleList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u8868\u96c6\u5408", hideempty2=true, dynamodelmode=4, child=true, group="\u6570\u636e\u5e93\u5b58\u50a8", order=390)
    public Iterator<IPSDEDBTable> getAllPSDEDBTables() throws Exception {
        return this.psDEDBTableGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEDBTable getPSDEDBTable(String strPSDEDBTableId) throws Exception {
        return (IPSDEDBTable)this.psDEDBTableGlobalModel.FindModelHelper(strPSDEDBTableId);
    }

    @Override
    public IPSDEDBTable getPSDEDBTable(String strPSDEDBTableId, boolean bTryMode) throws Exception {
        return (IPSDEDBTable)this.psDEDBTableGlobalModel.FindModelHelper(strPSDEDBTableId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6570\u636e\u5e93\u67b6\u6784", hideempty2=true, dumpref=true, dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=377)
    public IPSSysDBScheme getPSSysDBScheme() {
        return this.iPSSysDBScheme;
    }

    @Override
    public Iterator<IPSDESearch> getAllPSDESearchs() throws Exception {
        return this.psDESearchGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5168\u6587\u68c0\u7d22\u96c6\u5408", hideempty2=true, child=true, dynamodelmode=4, group="\u529f\u80fd\u914d\u7f6e", order=428)
    public Iterator<IPSDESearch> getAllPSDESearches() throws Exception {
        return this.psDESearchGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDESearch getPSDESearch(String strDESearchId) throws Exception {
        return (IPSDESearch)this.psDESearchGlobalModel.FindModelHelper(strDESearchId);
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u591a\u5b58\u50a8\u6a21\u5f0f", dynamodelmode=4)
    public boolean isEnableMultiStorage() {
        return this.bEnableMultiStorage;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301SQL\u5b58\u50a8", dynamodelmode=4)
    public boolean isEnableSQLStorage() throws Exception {
        if (this.getStorageMode() == 1) {
            return true;
        }
        if (this.isEnableMultiStorage()) {
            return !StringHelper.isNullOrEmpty((String)this.psDataEntity.getDSLINK());
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301NoSQL\u5b58\u50a8", dynamodelmode=4)
    public boolean isEnableNoSQLStorage() throws Exception {
        if (this.getStorageMode() == 2) {
            return true;
        }
        if (this.isEnableMultiStorage()) {
            Iterator<IPSDESearch> psDESearchs;
            if (this.hasPSDEBDTable()) {
                return true;
            }
            if (this.hasPSDESearch() && (psDESearchs = this.getAllPSDESearchs()) != null) {
                while (psDESearchs.hasNext()) {
                    IPSDESearch iPSDESearch = psDESearchs.next();
                    if (!iPSDESearch.getPSSysSearchDE().isNoSQLStorage()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u63a5\u53e3\u5b58\u50a8", dynamodelmode=4)
    public boolean isEnableAPIStorage() throws Exception {
        if (this.getStorageMode() == 4) {
            return true;
        }
        return this.isEnableMultiStorage() && !StringHelper.isNullOrEmpty((String)this.getServiceAPIClientId());
    }

    @Override
    @PSModelRTMeta(description="\u6709\u5b9e\u4f53\u5927\u6570\u636e\u8868", dump=false)
    public boolean hasPSDEBDTable() throws Exception {
        return this.psDEBDTableGlobalModel.getAllModelHelperCount() > 0;
    }

    @Override
    @PSModelRTMeta(description="\u6709\u5b9e\u4f53\u68c0\u7d22", dump=false)
    public boolean hasPSDESearch() throws Exception {
        return this.psDESearchGlobalModel.getAllModelHelperCount() > 0;
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u5904\u7406\u6a21\u5f0f", codelist="DETempDataHolder", ignoredumpvalues="0", fields={"ENATEMPDATA"})
    public int getTempDataHolder() {
        return this.nTempDataHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u7aef\u4e34\u65f6\u6570\u636e\u5904\u7406", ignoredumpvalues="false", dynamodelmode=4)
    public boolean isEnableTempDataBackend() {
        return (this.getTempDataHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u7aef\u4e34\u65f6\u6570\u636e\u5904\u7406", ignoredumpvalues="false", dynamodelmode=4)
    public boolean isEnableTempDataFront() {
        return (this.getTempDataHolder() & 2) == 2;
    }

    @Override
    public String getPSSubSysSADEId() {
        return this.psDataEntity.getPSSUBSYSSADEID();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u4ee5\u4e91\u670d\u52a1\u65b9\u5f0f\u63d0\u4f9b", dynamodelmode=4, doc="\u7531\u6240\u5c5e\u6a21\u5757\u51b3\u5b9a")
    public boolean isSubSysAsCloud() {
        return this.bSubSysAsCloud;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        return KeyValueHelper.genUniqueId((String)this.getPSSystemModule().getDeployId(), (String)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u641c\u7d22\u5c5e\u6027\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEField> getQuickSearchPSDEFields() throws Exception {
        if (this.quickSearchPSDEFieldList == null) {
            ArrayList<IPSDEField> quickSearchPSDEFieldList = new ArrayList<IPSDEField>();
            Iterator<IPSDEField> psDEFields = this.getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSDEField iPSDEField = psDEFields.next();
                    if (!iPSDEField.isEnableQuickSearch()) continue;
                    quickSearchPSDEFieldList.add(iPSDEField);
                }
            }
            if (this.quickSearchPSDEFieldList == null) {
                this.quickSearchPSDEFieldList = quickSearchPSDEFieldList;
            }
        }
        if (this.quickSearchPSDEFieldList == null || this.quickSearchPSDEFieldList.size() == 0) {
            return null;
        }
        return this.quickSearchPSDEFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u5bf9\u8c61")
    public IPSDEDataImport getDefaultPSDEDataImport() throws Exception {
        this.getAllPSDEDataImports();
        return this.psDEDataImportGlobalModel.getDefaultPSDEDataImport();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u5bf9\u8c61")
    public IPSDEDataExport getDefaultPSDEDataExport() throws Exception {
        this.getAllPSDEDataExports();
        return this.psDEDataExportGlobalModel.getDefaultPSDEDataExport();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u96c6\u5408", group="\u6a21\u578b", order=296)
    public Iterator<IPSCodeList> getAllPSCodeLists() throws Exception {
        if (this.psCodeListList == null) {
            ArrayList<IPSCodeList> psCodeListList = new ArrayList<IPSCodeList>();
            Iterator<IPSCodeList> psCodeLists = this.getPSSystem().getAllPSCodeLists();
            if (psCodeLists != null) {
                while (psCodeLists.hasNext()) {
                    IPSCodeList iPSCodeList = psCodeLists.next();
                    if (iPSCodeList.getPSDataEntity() == null || StringHelper.compare((String)iPSCodeList.getPSDataEntity().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psCodeListList.add(iPSCodeList);
                }
            }
            if (this.psCodeListList == null) {
                this.psCodeListList = psCodeListList;
            }
        }
        if (this.psCodeListList == null || this.psCodeListList.size() == 0) {
            return null;
        }
        return this.psCodeListList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5c5e\u6027", hideempty=true, group="\u6a21\u578b", order=160)
    public IPSDEField getOrderValuePSDEField() {
        try {
            return this.getPSDEFieldByPDT("ORDERVALUE", true);
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7248\u672c\u5c5e\u6027", hideempty=true, group="\u6a21\u578b", order=160)
    public IPSDEField getVersionPSDEField() {
        try {
            return this.getPSDEFieldByPDT("VERSION", true);
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b\u5c5e\u6027", hideempty=true, group="\u6a21\u578b", order=160)
    public IPSDEField getDataTypePSDEField() {
        try {
            IPSDEField iPSDEField = this.getPSDEFieldByPDT("DATATYPE", true);
            if (iPSDEField == null && (iPSDEField = this.getIndexTypePSDEField()) == null) {
                iPSDEField = this.getFormTypePSDEField();
            }
            return iPSDEField;
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEMethod> getAllPSDEMethods() throws Exception {
        if (this.psDEMethodList == null) {
            Iterator<IPSDEDataSet> psDEDataSets;
            ArrayList<PSDEMethodImplBase> psDEMethodList = new ArrayList<PSDEMethodImplBase>();
            Iterator<IPSDEAction> psDEActions = this.getAllPSDEActions();
            if (psDEActions != null) {
                while (psDEActions.hasNext()) {
                    IPSDEAction iPSDEAction = psDEActions.next();
                    if (!iPSDEAction.isEnableBackend()) continue;
                    PSDEActionMethodImpl psDEActionMethodImpl = new PSDEActionMethodImpl();
                    psDEActionMethodImpl.init(this.getDAGlobalHelper(), iPSDEAction);
                    psDEMethodList.add(psDEActionMethodImpl);
                }
            }
            if ((psDEDataSets = this.getAllPSDEDataSets()) != null) {
                while (psDEDataSets.hasNext()) {
                    IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                    if (!iPSDEDataSet.isEnableBackend()) continue;
                    PSDEDataSetMethodImpl psDEDataSetMethodImpl = new PSDEDataSetMethodImpl();
                    psDEDataSetMethodImpl.init(this.getDAGlobalHelper(), iPSDEDataSet);
                    psDEMethodList.add(psDEDataSetMethodImpl);
                    if (iPSDEDataSet.getPSCodeList() != null) continue;
                    int i = 0;
                    while (i < 2) {
                        Iterator<IPSDER1N> psDER1Ns = null;
                        switch (i) {
                            case 0: {
                                psDER1Ns = this.getMinorPSDER1Ns();
                                break;
                            }
                            case 1: {
                                if (this.getInheritPSDataEntity() == null) break;
                                psDER1Ns = this.getInheritPSDataEntity().getMinorPSDER1Ns();
                            }
                        }
                        if (psDER1Ns != null) {
                            while (psDER1Ns.hasNext()) {
                                IPSDEField iPSDEField;
                                IPSDER1N iPSDER1N = psDER1Ns.next();
                                if (StringHelper.isNullOrEmpty((String)iPSDER1N.getPickupDEFName()) || (iPSDEField = this.getPSDEField(iPSDER1N.getPickupDEFName(), true)) == null) continue;
                                PSDEDataSetMethodImpl psDEDataSetMethodImpl2 = new PSDEDataSetMethodImpl();
                                psDEDataSetMethodImpl2.init(this.getDAGlobalHelper(), iPSDEDataSet, iPSDER1N, iPSDEField, "DEFAULT");
                                psDEMethodList.add(psDEDataSetMethodImpl2);
                                if (iPSDER1N.getMajorPSDataEntity().getRecursivePSDER1N() == null) continue;
                                psDEDataSetMethodImpl2 = new PSDEDataSetMethodImpl();
                                psDEDataSetMethodImpl2.init(this.getDAGlobalHelper(), iPSDEDataSet, iPSDER1N, iPSDEField, "CHILDOF");
                                psDEMethodList.add(psDEDataSetMethodImpl2);
                            }
                        }
                        ++i;
                    }
                }
            }
            if (this.psDEMethodList == null) {
                this.psDEMethodList = psDEMethodList;
            }
        }
        if (this.psDEMethodList == null || this.psDEMethodList.size() == 0) {
            return null;
        }
        return this.psDEMethodList.iterator();
    }

    @Override
    public IPSDEActionMethod getPSDEActionMethod(IPSDEAction iPSDEAction, boolean bTryMode) throws Exception {
        if (iPSDEAction == null) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u53c2\u6570\u65e0\u6548"));
        }
        Iterator<IPSDEMethod> psDEMethods = this.getAllPSDEMethods();
        if (psDEMethods != null) {
            while (psDEMethods.hasNext()) {
                IPSDEActionMethod iPSDEActionMethod;
                IPSDEMethod iPSDEMethod = psDEMethods.next();
                if (!(iPSDEMethod instanceof IPSDEActionMethod) || (iPSDEActionMethod = (IPSDEActionMethod)iPSDEMethod).getPSDEAction() == null || StringHelper.compare((String)iPSDEActionMethod.getPSDEAction().getId(), (String)iPSDEAction.getId(), (boolean)false) != 0) continue;
                return iPSDEActionMethod;
            }
        }
        if (!bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a[%1$s]\u5bf9\u5e94\u7684\u5b9e\u4f53\u65b9\u6cd5", (Object)iPSDEAction.getId()));
        }
        return null;
    }

    @Override
    public IPSDEDataSetMethod getPSDEDataSetMethod(IPSDEDataSet iPSDEDataSet, boolean bTryMode) throws Exception {
        return this.getPSDEDataSetMethod(iPSDEDataSet, null, null, bTryMode);
    }

    @Override
    public IPSDEDataSetMethod getPSDEDataSetMethod(IPSDEDataSet iPSDEDataSet, IPSDER1N iPSDER1N, String strParentKeyMode, boolean bTryMode) throws Exception {
        if (iPSDEDataSet == null) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u53c2\u6570\u65e0\u6548"));
        }
        Iterator<IPSDEMethod> psDEMethods = this.getAllPSDEMethods();
        if (psDEMethods != null) {
            while (psDEMethods.hasNext()) {
                IPSDEDataSetMethod iPSDEDataSetMethod;
                IPSDEMethod iPSDEMethod = psDEMethods.next();
                if (!(iPSDEMethod instanceof IPSDEDataSetMethod) || (iPSDEDataSetMethod = (IPSDEDataSetMethod)iPSDEMethod).getPSDEDataSet() == null || StringHelper.compare((String)iPSDEDataSetMethod.getPSDEDataSet().getId(), (String)iPSDEDataSet.getId(), (boolean)false) != 0) continue;
                if (iPSDER1N == null && iPSDEDataSetMethod.getPSDER1N() == null) {
                    return iPSDEDataSetMethod;
                }
                if (iPSDER1N == null || iPSDEDataSetMethod.getPSDER1N() == null || StringHelper.compare((String)iPSDER1N.getId(), (String)iPSDEDataSetMethod.getPSDER1N().getId(), (boolean)false) != 0 || StringHelper.compare((String)strParentKeyMode, (String)iPSDEDataSetMethod.getParentKeyMode(), (boolean)false) != 0) continue;
                return iPSDEDataSetMethod;
            }
        }
        if (!bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u96c6[%1$s]\u5bf9\u5e94\u7684\u5b9e\u4f53\u65b9\u6cd5", (Object)iPSDEDataSet.getId()));
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u901a\u77e5\u96c6\u5408", child=true, dynamodelmode=5, group="\u5904\u7406\u903b\u8f91", order=300)
    public Iterator<IPSDENotify> getAllPSDENotifies() throws Exception {
        return this.psDENotifyGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDENotify getPSDENotify(String strDENotifyId) throws Exception {
        return (IPSDENotify)this.psDENotifyGlobalModel.FindModelHelper(strDENotifyId);
    }

    @Override
    public IPSDENotify getPSDENotify(String strDENotifyId, boolean bTryMode) throws Exception {
        return (IPSDENotify)this.psDENotifyGlobalModel.FindModelHelper(strDENotifyId, bTryMode);
    }

    @Override
    public void resetPSDENotify(String strDENotifyId) throws Exception {
        this.psDENotifyGlobalModel.ResetModel(strDENotifyId);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u9012\u5f52\u5173\u7cfb", hideempty=true)
    public IPSDER1N getRecursivePSDER1N() {
        psDER1Ns = this.getMajorPSDER1Ns();
        if (psDER1Ns != null) ** GOTO lbl7
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDER1N = psDER1Ns.next();
            if (!iPSDER1N.isRecursiveRS()) continue;
            return iPSDER1N;
lbl7:
            // 2 sources

            ** while (psDER1Ns.hasNext())
        }
lbl8:
        // 1 sources

        return null;
    }

    @Override
    public void tryLoad() throws Exception {
        if (!this.isInit()) {
            this.init();
        }
        this.internalPreparePSDEFields(true);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u884c\u4e3a\u63a7\u5236\u903b\u8f91\u6a21\u5f0f", codelist="DEMSActionLogicMode", dump=false)
    public int getMSActionLogicMode() {
        return this.nMSActionLogicMode;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7236\u7c7b\u578b\u5c5e\u6027", hideempty=true)
    public IPSDEField getParentTypePSDEField() {
        try {
            return this.getPSDEFieldByPDT("PARENTTYPE", true);
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7236\u6807\u8bc6\u5c5e\u6027", hideempty=true)
    public IPSDEField getParentIdPSDEField() {
        try {
            return this.getPSDEFieldByPDT("PARENTID", true);
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7236\u540d\u79f0\u5c5e\u6027", hideempty=true)
    public IPSDEField getParentNamePSDEField() {
        try {
            return this.getPSDEFieldByPDT("PARENTNAME", true);
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u7ec7\u6807\u8bc6\u5c5e\u6027", hideempty=true, dumpref=true, from="__self__", dynamodelmode=4)
    public IPSDEField getOrgIdPSDEField() {
        try {
            return this.getPSDEFieldByPDT("ORGID", true);
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5efa\u7acb")
    public boolean isEnableCreate() {
        return (this.getEnableActions() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4fee\u6539")
    public boolean isEnableModify() {
        return (this.getEnableActions() & 2) == 2;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5220\u9664")
    public boolean isEnableRemove() {
        return (this.getEnableActions() & 4) == 4;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u754c\u9762\u5efa\u7acb", dump=false)
    public boolean isEnableUICreate() {
        return (this.getEnableUIActions() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u754c\u9762\u4fee\u6539", dump=false)
    public boolean isEnableUIModify() {
        return (this.getEnableUIActions() & 2) == 2;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u754c\u9762\u5220\u9664", dump=false)
    public boolean isEnableUIRemove() {
        return (this.getEnableUIActions() & 4) == 4;
    }

    @Override
    @PSModelRTMeta(description="\u4e1a\u52a1\u6807\u8bb0", codelist="DEBizTag", fields={"BIZTAG"})
    public String getBizTag() {
        return this.psDataEntity.getBIZTAG();
    }

    @Override
    protected int onGetDynaInstMode() {
        return this.nDynaInstMode;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f", codelist="DynaInstMode3")
    public int getDynaInstMode() {
        return super.getDynaInstMode();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0")
    public String getDynaInstTag() {
        return super.getDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb02")
    public String getDynaInstTag2() {
        return super.getDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u96c6\u5408", child=true, ignorepf=true, group="\u5904\u7406\u903b\u8f91", order=296)
    public Iterator<IPSDEMethodDTO> getAllPSDEMethodDTOs() throws Exception {
        if (this.psDEMethodDTOMap == null || this.psDEMethodDTOMap.size() == 0) {
            return null;
        }
        return this.psDEMethodDTOMap.values().iterator();
    }

    @Override
    public IPSDEMethodDTO getPSDEMethodDTO(IPSDEFGroup iPSDEFGroup) throws Exception {
        if (iPSDEFGroup == null) {
            return this.getDefaultPSDEMethodDTO();
        }
        for (Map.Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"DEFAULT", (boolean)true) != 0 || entry.getValue().isDefaultMode() || entry.getValue().getPSDEFGroup() == null || StringHelper.compare((String)entry.getValue().getPSDEFGroup().getId(), (String)iPSDEFGroup.getId(), (boolean)false) != 0) continue;
            return entry.getValue();
        }
        PSDEMethodDTOImpl psDEMethodDTOImpl = new PSDEMethodDTOImpl();
        psDEMethodDTOImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroup);
        if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u65b9\u6cd5DTO\u5bf9\u8c61", psDEMethodDTOImpl.getCodeName()));
        }
        this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
        return psDEMethodDTOImpl;
    }

    @Override
    public IPSDEMethodDTO getPSDEMethodDTO(IPSSysDynaModel iPSSysDynaModel) throws Exception {
        for (Map.Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"DEFAULT", (boolean)true) != 0 || entry.getValue().isDefaultMode() || entry.getValue().getSrcPSSysDynaModel() == null || StringHelper.compare((String)entry.getValue().getSrcPSSysDynaModel().getId(), (String)iPSSysDynaModel.getId(), (boolean)false) != 0) continue;
            return entry.getValue();
        }
        PSDEMethodDTOImpl psDEMethodDTOImpl = new PSDEMethodDTOImpl();
        psDEMethodDTOImpl.initFromDynaModel(this.getDAGlobalHelper(), this, iPSSysDynaModel);
        if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u65b9\u6cd5DTO\u5bf9\u8c61", psDEMethodDTOImpl.getCodeName()));
        }
        this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
        return psDEMethodDTOImpl;
    }

    @Override
    public IPSLinkDEMethodDTO getPSLinkDEMethodDTO(IPSDataEntity iPSDataEntity, IPSDEFGroup iPSDEFGroup) throws Exception {
        for (Map.Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
            IPSLinkDEMethodDTO iPSLinkDEMethodDTO;
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"LINK", (boolean)true) != 0 || (iPSLinkDEMethodDTO = (IPSLinkDEMethodDTO)entry.getValue()).getRefPSDataEntity() == null || StringHelper.compare((String)iPSLinkDEMethodDTO.getRefPSDataEntity().getId(), (String)iPSDataEntity.getId(), (boolean)false) != 0) continue;
            if (iPSDEFGroup == null) {
                if (iPSLinkDEMethodDTO.getRefPSDEFGroup() != null) continue;
                return iPSLinkDEMethodDTO;
            }
            if (iPSLinkDEMethodDTO.getRefPSDEFGroup() == null || StringHelper.compare((String)iPSLinkDEMethodDTO.getRefPSDEFGroup().getId(), (String)iPSDEFGroup.getId(), (boolean)false) != 0) continue;
            return iPSLinkDEMethodDTO;
        }
        PSLinkDEMethodDTOImpl psDEMethodDTOImpl = new PSLinkDEMethodDTOImpl();
        psDEMethodDTOImpl.init(this.getDAGlobalHelper(), this, iPSDataEntity, iPSDEFGroup);
        if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u65b9\u6cd5DTO\u5bf9\u8c61", psDEMethodDTOImpl.getCodeName()));
        }
        this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
        return psDEMethodDTOImpl;
    }

    @Override
    public IPSLinkDEMethodDTO getPSLinkDEMethodDTO(IPSSysDynaModel iPSSysDynaModel) throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u65b9\u6cd5DTO", dumpref=true, dynamodelmode=4, from="__self__")
    public IPSDEMethodDTO getDefaultPSDEMethodDTO() throws Exception {
        for (Map.Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"DEFAULT", (boolean)true) != 0 || !entry.getValue().isDefaultMode()) continue;
            return entry.getValue();
        }
        PSDEMethodDTOImpl psDEMethodDTOImpl = new PSDEMethodDTOImpl();
        psDEMethodDTOImpl.init(this.getDAGlobalHelper(), this, null);
        if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u65b9\u6cd5DTO\u5bf9\u8c61", psDEMethodDTOImpl.getCodeName()));
        }
        this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
        return psDEMethodDTOImpl;
    }

    @Override
    public IPSDEActionInputDTO getPSDEActionInputDTO(IPSDEActionInput iPSDEActionInput) throws Exception {
        for (Map.Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
            IPSDEActionInputDTO iPSDEActionInputDTO;
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"DEACTIONINPUT", (boolean)true) != 0 || !(entry.getValue() instanceof IPSDEActionInputDTO) || (iPSDEActionInputDTO = (IPSDEActionInputDTO)entry.getValue()).getPSDEActionInput() == null || StringHelper.compare((String)iPSDEActionInputDTO.getPSDEActionInput().getId(), (String)iPSDEActionInput.getId(), (boolean)false) != 0) continue;
            return iPSDEActionInputDTO;
        }
        PSDEActionInputDTOImpl psDEMethodDTOImpl = new PSDEActionInputDTOImpl();
        psDEMethodDTOImpl.init(this.getDAGlobalHelper(), (IPSDataEntity)this, iPSDEActionInput);
        if (this.psDEMethodDTOMap.containsKey(psDEMethodDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u65b9\u6cd5DTO\u5bf9\u8c61", psDEMethodDTOImpl.getCodeName()));
        }
        this.psDEMethodDTOMap.put(psDEMethodDTOImpl.getCodeName(), psDEMethodDTOImpl);
        return psDEMethodDTOImpl;
    }

    @Override
    public IPSDEDataSetInputDTO getPSDEDataSetInputDTO(IPSDEDataSetInput iPSDEDataSetInput) throws Exception {
        for (Map.Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
            IPSDEDataSetInputDTO iPSDEDataSetInputDTO;
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"DEDATASETINPUT", (boolean)true) != 0 || !(entry.getValue() instanceof IPSDEDataSetInputDTO) || (iPSDEDataSetInputDTO = (IPSDEDataSetInputDTO)entry.getValue()).getPSDEDataSetInput() == null || StringHelper.compare((String)iPSDEDataSetInputDTO.getPSDEDataSetInput().getId(), (String)iPSDEDataSetInput.getId(), (boolean)false) != 0) continue;
            return iPSDEDataSetInputDTO;
        }
        PSDEFilterDTOImpl psDEFilterDTOImpl = new PSDEFilterDTOImpl();
        psDEFilterDTOImpl.initFromDataSetInput(this.getDAGlobalHelper(), this, iPSDEDataSetInput);
        if (this.psDEMethodDTOMap.containsKey(psDEFilterDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u65b9\u6cd5DTO\u5bf9\u8c61", psDEFilterDTOImpl.getCodeName()));
        }
        this.psDEMethodDTOMap.put(psDEFilterDTOImpl.getCodeName(), psDEFilterDTOImpl);
        return psDEFilterDTOImpl;
    }

    @Override
    public String getDEMethodDTOCodeName(IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
        String strCodeName = this.calcDEMethodDTOCodeName(iPSDEMethodDTO);
        if (StringHelper.isNullOrEmpty((String)strCodeName)) {
            throw new Exception(String.format("\u65e0\u6cd5\u8ba1\u7b97\u5b9e\u4f53\u65b9\u6cd5DTO\u4ee3\u7801\u6807\u8bc6", new Object[0]));
        }
        String strDTOFormat = this.getDTOCodeNameFormat();
        if (!StringHelper.isNullOrEmpty((String)strDTOFormat)) {
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
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"DEFAULT", (boolean)false) == 0) {
                if (iPSDEMethodDTO.getSrcPSSysDynaModel() != null) {
                    return this.getAPICodeName(this.getServiceCodeName(), iPSDEMethodDTO.getSrcPSSysDynaModel().getCodeName(), null);
                }
                if (iPSDEMethodDTO.getPSDEFGroup() != null) {
                    return this.getAPICodeName(this.getServiceCodeName(), iPSDEMethodDTO.getPSDEFGroup().getCodeName(), null);
                }
                return this.getServiceCodeName();
            }
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"DEACTIONINPUT", (boolean)false) == 0) {
                IPSDEActionInputDTO iPSDEActionInputDTO = (IPSDEActionInputDTO)iPSDEMethodDTO;
                if (iPSDEActionInputDTO.getPSDEActionInput() != null) {
                    return this.getAPICodeName(this.getServiceCodeName(), iPSDEActionInputDTO.getPSDEActionInput().getCodeName(), null);
                }
                return null;
            }
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"DEDATASETINPUT", (boolean)false) == 0) {
                IPSDEDataSetInputDTO iPSDEDataSetInputDTO = (IPSDEDataSetInputDTO)iPSDEMethodDTO;
                if (iPSDEDataSetInputDTO.getPSDEDataSetInput() != null) {
                    return this.getAPICodeName(this.getServiceCodeName(), iPSDEDataSetInputDTO.getPSDEDataSetInput().getCodeName(), "Filter");
                }
                return null;
            }
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"DEFILTER", (boolean)false) == 0) {
                if (iPSDEMethodDTO.getSrcPSSysDynaModel() != null) {
                    return this.getAPICodeName(this.getServiceCodeName(), iPSDEMethodDTO.getSrcPSSysDynaModel().getCodeName(), "Filter");
                }
                if (iPSDEMethodDTO.getPSDEFGroup() != null) {
                    return this.getAPICodeName(this.getServiceCodeName(), iPSDEMethodDTO.getPSDEFGroup().getCodeName(), "Filter");
                }
                return this.getAPICodeName(this.getServiceCodeName(), "Filter", null);
            }
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"LINK", (boolean)false) == 0) {
                IPSLinkDEMethodDTO iPSLinkDEMethodDTO = (IPSLinkDEMethodDTO)iPSDEMethodDTO;
                if (iPSLinkDEMethodDTO.getRefPSDEFGroup() != null) {
                    return String.format("_%1$s", this.getAPICodeName(iPSLinkDEMethodDTO.getRefPSDataEntity().getServiceCodeName(), iPSLinkDEMethodDTO.getRefPSDEFGroup().getCodeName(), null));
                }
                return "_" + iPSLinkDEMethodDTO.getRefPSDataEntity().getServiceCodeName();
            }
        } else {
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"DEFAULT", (boolean)false) == 0) {
                if (iPSDEMethodDTO.getSrcPSSysDynaModel() != null) {
                    return String.format("%1$s%2$s", this.getCodeName(), iPSDEMethodDTO.getSrcPSSysDynaModel().getCodeName());
                }
                if (iPSDEMethodDTO.getPSDEFGroup() != null) {
                    return String.format("%1$s%2$s", this.getCodeName(), iPSDEMethodDTO.getPSDEFGroup().getCodeName());
                }
                return this.getCodeName();
            }
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"DEACTIONINPUT", (boolean)false) == 0) {
                IPSDEActionInputDTO iPSDEActionInputDTO = (IPSDEActionInputDTO)iPSDEMethodDTO;
                if (iPSDEActionInputDTO.getPSDEActionInput() != null) {
                    return String.format("%1$s%2$s", this.getCodeName(), iPSDEActionInputDTO.getPSDEActionInput().getCodeName());
                }
                return null;
            }
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"DEDATASETINPUT", (boolean)false) == 0) {
                IPSDEDataSetInputDTO iPSDEDataSetInputDTO = (IPSDEDataSetInputDTO)iPSDEMethodDTO;
                if (iPSDEDataSetInputDTO.getPSDEDataSetInput() != null) {
                    return String.format("%1$s%2$sFilter", this.getCodeName(), iPSDEDataSetInputDTO.getPSDEDataSetInput().getCodeName());
                }
                return null;
            }
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"DEFILTER", (boolean)false) == 0) {
                if (iPSDEMethodDTO.getSrcPSSysDynaModel() != null) {
                    return String.format("%1$s%2$sFilter", this.getCodeName(), iPSDEMethodDTO.getSrcPSSysDynaModel().getCodeName());
                }
                if (iPSDEMethodDTO.getPSDEFGroup() != null) {
                    return String.format("%1$s%2$sFilter", this.getCodeName(), iPSDEMethodDTO.getPSDEFGroup().getCodeName());
                }
                return String.format("%1$sFilter", this.getCodeName());
            }
            if (StringHelper.compare((String)iPSDEMethodDTO.getType(), (String)"LINK", (boolean)false) == 0) {
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
        for (Map.Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
            IPSDEFilterDTO iPSDEFilterDTO;
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"DEFILTER", (boolean)true) != 0 || !(entry.getValue() instanceof IPSDEFilterDTO) || (iPSDEFilterDTO = (IPSDEFilterDTO)entry.getValue()).isDefaultMode() || iPSDEFilterDTO.getPSDEFGroup() == null || StringHelper.compare((String)iPSDEFilterDTO.getPSDEFGroup().getId(), (String)iPSDEFGroup.getId(), (boolean)false) != 0) continue;
            return iPSDEFilterDTO;
        }
        PSDEFilterDTOImpl psDEFilterDTOImpl = new PSDEFilterDTOImpl();
        psDEFilterDTOImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroup);
        if (this.psDEMethodDTOMap.containsKey(psDEFilterDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u8fc7\u6ee4\u5668DTO\u5bf9\u8c61", psDEFilterDTOImpl.getCodeName()));
        }
        this.psDEMethodDTOMap.put(psDEFilterDTOImpl.getCodeName(), psDEFilterDTOImpl);
        return psDEFilterDTOImpl;
    }

    @Override
    public IPSDEFilterDTO getPSDEFilterDTO(IPSSysDynaModel iPSSysDynaModel) throws Exception {
        for (Map.Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
            IPSDEFilterDTO iPSDEFilterDTO;
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"DEFILTER", (boolean)true) != 0 || !(entry.getValue() instanceof IPSDEFilterDTO) || (iPSDEFilterDTO = (IPSDEFilterDTO)entry.getValue()).isDefaultMode() || iPSDEFilterDTO.getSrcPSSysDynaModel() == null || StringHelper.compare((String)iPSDEFilterDTO.getSrcPSSysDynaModel().getId(), (String)iPSSysDynaModel.getId(), (boolean)false) != 0) continue;
            return iPSDEFilterDTO;
        }
        PSDEFilterDTOImpl psDEFilterDTOImpl = new PSDEFilterDTOImpl();
        psDEFilterDTOImpl.initFromDynaModel(this.getDAGlobalHelper(), this, iPSSysDynaModel);
        if (this.psDEMethodDTOMap.containsKey(psDEFilterDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u8fc7\u6ee4\u5668DTO\u5bf9\u8c61", psDEFilterDTOImpl.getCodeName()));
        }
        this.psDEMethodDTOMap.put(psDEFilterDTOImpl.getCodeName(), psDEFilterDTOImpl);
        return psDEFilterDTOImpl;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u8fc7\u6ee4\u5668DTO", dumpref=true, dynamodelmode=4, from="__self__", from_method="getPSDEMethodDTO", origin="IPSDEFilterDTO")
    public IPSDEFilterDTO getDefaultPSDEFilterDTO() throws Exception {
        for (Map.Entry<String, IPSDEMethodDTO> entry : this.psDEMethodDTOMap.entrySet()) {
            IPSDEFilterDTO iPSDEFilterDTO;
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"DEFILTER", (boolean)true) != 0 || !(entry.getValue() instanceof IPSDEFilterDTO) || !(iPSDEFilterDTO = (IPSDEFilterDTO)entry.getValue()).isDefaultMode()) continue;
            return iPSDEFilterDTO;
        }
        PSDEFilterDTOImpl psDEFilterDTOImpl = new PSDEFilterDTOImpl();
        psDEFilterDTOImpl.init(this.getDAGlobalHelper(), this, null);
        if (this.psDEMethodDTOMap.containsKey(psDEFilterDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u8fc7\u6ee4\u5668DTO\u5bf9\u8c61", psDEFilterDTOImpl.getCodeName()));
        }
        this.psDEMethodDTOMap.put(psDEFilterDTOImpl.getCodeName(), psDEFilterDTOImpl);
        return psDEFilterDTOImpl;
    }

    public String getDTOCodeNameFormat() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getDTOCodeNameFormat();
        }
        return this.getPSSystem().getDTOCodeNameFormat();
    }

    @Override
    public String getPSSysModelGroupId() {
        if (this.getPSSystemModule() != null && this.getPSSystemModule().getPSSysModelGroup() != null) {
            return this.getPSSystemModule().getPSSysModelGroup().getId();
        }
        return null;
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        if (!StringHelper.isNullOrEmpty((String)strModelRefType) && "SYSTEM".equals(strModelRefType)) {
            objectNode.put("name", this.getName());
        }
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u9644\u52a0\u6a21\u578b\u6570\u636e\u96c6\u5408", child=true, ignorepf=true, dynamodelmode=4, outputdoc="false")
    public Iterator<IPSModelData> getAllPSModelDatas() throws Exception {
        if (this.psModelDataMap == null || this.psModelDataMap.size() == 0) {
            return null;
        }
        return this.psModelDataMap.values().iterator();
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

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6807\u8bb0", hideempty2=true, fields={"DETAG"})
    public String getDETag() {
        return this.psDataEntity.getDETAG();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6807\u8bb02", hideempty2=true, fields={"DETAG2"})
    public String getDETag2() {
        return this.psDataEntity.getDETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5927\u6570\u636e\u5e93\u4f53\u7cfb", hideempty2=true, dumpref=true, dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=378)
    public IPSSysBDScheme getPSSysBDScheme() {
        try {
            IPSSysBDScheme iPSSysBDScheme;
            Iterator<IPSDEBDTable> psDEBDTables = this.getAllPSDEBDTables();
            if (psDEBDTables != null && psDEBDTables.hasNext()) {
                IPSDEBDTable iPSDEBDTable = psDEBDTables.next();
                return iPSDEBDTable.getPSSysBDScheme();
            }
            Iterator<IPSSysBDScheme> psSysBDSchemes = this.getPSSystem().getAllPSSysBDSchemes();
            if (psSysBDSchemes != null && this.getPSSystemModule() != null) {
                while (psSysBDSchemes.hasNext()) {
                    iPSSysBDScheme = psSysBDSchemes.next();
                    if (iPSSysBDScheme.getPSSystemModule() == null || StringHelper.compare((String)this.getPSSystemModule().getId(), (String)iPSSysBDScheme.getPSSystemModule().getId(), (boolean)false) != 0) continue;
                    return iPSSysBDScheme;
                }
            }
            if ((psSysBDSchemes = this.getPSSystem().getAllPSSysBDSchemes()) != null && !StringHelper.isNullOrEmpty((String)this.getPSSysModelGroupId())) {
                while (psSysBDSchemes.hasNext()) {
                    iPSSysBDScheme = psSysBDSchemes.next();
                    if (iPSSysBDScheme.getPSSysModelGroup() == null || StringHelper.compare((String)this.getPSSysModelGroupId(), (String)iPSSysBDScheme.getPSSysModelGroup().getId(), (boolean)false) != 0) continue;
                    return iPSSysBDScheme;
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u6d41\u903b\u8f91\u96c6\u5408", dynamodelmode=4, child=true, dumpref=true, group="\u5904\u7406\u903b\u8f91", order=288)
    public Iterator<IPSDEDataFlow> getAllPSDEDataFlows() throws Exception {
        return this.psDEDataFlowGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEDataFlow getPSDEDataFlow(String strDEDataFlowId) throws Exception {
        return (IPSDEDataFlow)this.psDEDataFlowGlobalModel.FindModelHelper(strDEDataFlowId);
    }

    @Override
    public IPSDEDataFlow getPSDEDataFlow(String strDEDataFlowId, boolean bTryMode) throws Exception {
        return (IPSDEDataFlow)this.psDEDataFlowGlobalModel.FindModelHelper(strDEDataFlowId, bTryMode);
    }

    @Override
    public void resetPSDEDataFlow(String strDEDataFlowId) throws Exception {
        this.psDEDataFlowGlobalModel.ResetModel(strDEDataFlowId);
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", codelist="DEDynaSysMode", ignoredumpvalues="0", fields={"ENABLEDYNASYS"})
    public int getDynaSysMode() {
        return this.nDEDynaSysMode;
    }

    @Override
    @PSModelRTMeta(description="\u8054\u5408\u4e3b\u952e\u6a21\u5f0f", codelist="DEUnionKeyMode", fields={"KEYRULE"})
    public String getUnionKeyMode() {
        return this.psDataEntity.getKEYRULE();
    }

    @Override
    @PSModelRTMeta(description="\u8054\u5408\u4e3b\u952e\u53c2\u6570", fields={"VKEYSEPARATOR"})
    public String getUnionKeyParam() {
        return this.psDataEntity.getVKEYSEPARATOR();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f", codelist="CodeNameMode", dump=false)
    public String getAPICodeNameMode() {
        if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getCODENAMEMODE())) {
            return this.psDataEntity.getCODENAMEMODE();
        }
        return this.getPSSystemModule().getAPICodeNameMode();
    }

    @Override
    public String getAPICodeName(String strPrefix, String strCodeName, String strSuffix) {
        return PSModelCodeNameUtils.to(this.getAPICodeNameMode(), strPrefix, strCodeName, strSuffix);
    }

    @Override
    @PSModelRTMeta(description="DTO\u4f7f\u7528\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", dump=false)
    public boolean isDTOUseServiceCodeName() {
        return !StringHelper.isNullOrEmpty((String)this.getAPICodeNameMode()) && !"NONE".equalsIgnoreCase(this.getAPICodeNameMode());
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528PQL", dump=false, ignoredumpvalues="false", fields={"ENABLEPQL"})
    public boolean isEnablePQL() {
        if (!this.psDataEntity.isENABLEPQLNull()) {
            return this.psDataEntity.getENABLEPQL();
        }
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().isEnablePQL();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u9ed8\u8ba4\u7edf\u4e00\u8d44\u6e90", dump=false, fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getPSSysUniRes() {
        return this.iPSSysUniRes;
    }
}

