/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl
 *  SA.SRFDA.Ctrl.Data.DEBHGroup
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.DevImage
 *  SA.SRFDA.Ctrl.Data.FIUpdate
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.GSR2
 *  SA.SRFDA.Ctrl.Data.GroupStatisticsRep
 *  SA.SRFDA.Ctrl.Data.MBPanel
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.PageParamFolder
 *  SA.SRFDA.Ctrl.Data.PageParamType
 *  SA.SRFDA.Ctrl.Data.QueryModel
 *  SA.SRFDA.Ctrl.Data.TBTempl
 *  SA.SRFDA.Ctrl.Data.THGroup
 *  SA.SRFDA.Ctrl.Data.Toolbar
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Ctrl.Data.ValueRule
 *  SA.SRFDA.Ctrl.DataSync.ISyncAgentTypeHelper
 *  SA.SRFDA.Ctrl.ICounterHelper
 *  SA.SRFDA.Ctrl.ICounterTypeHelper
 *  SA.SRFDA.Ctrl.IDAGlobalModel
 *  SA.SRFDA.Ctrl.IDAModelStorage
 *  SA.SRFDA.Ctrl.IDASubSystemHelper
 *  SA.SRFDA.Ctrl.IDBStorage
 *  SA.SRFDA.Ctrl.IDEBehaviorHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDERGroupFolderHelper
 *  SA.SRFDA.Ctrl.IDERModeHelper
 *  SA.SRFDA.Ctrl.IDERTypeHelper
 *  SA.SRFDA.Ctrl.ILayoutItemHelper
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Ctrl.ORG.IORGTreeNodeTypeHelper
 *  SA.SRFDA.Ctrl.ORG.IORGTreeTypeHelper
 *  SA.SRFDA.Ctrl.ORG.IORGUnitTypeHelper
 *  SA.SRFDA.Model.DGModelMainQueryConfig
 *  SA.SRFDA.Security.IRCAccListHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.UIGear.IUIGear
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl;
import SA.SRFDA.Ctrl.Data.DEBHGroup;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.DevImage;
import SA.SRFDA.Ctrl.Data.FIUpdate;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.GSR2;
import SA.SRFDA.Ctrl.Data.GroupStatisticsRep;
import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.PageParamFolder;
import SA.SRFDA.Ctrl.Data.PageParamType;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.Data.THGroup;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.Data.ValueRule;
import SA.SRFDA.Ctrl.DataSync.ISyncAgentTypeHelper;
import SA.SRFDA.Ctrl.ICounterHelper;
import SA.SRFDA.Ctrl.ICounterTypeHelper;
import SA.SRFDA.Ctrl.IDAGlobalModel;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDASubSystemHelper;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEBehaviorHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDERGroupFolderHelper;
import SA.SRFDA.Ctrl.IDERModeHelper;
import SA.SRFDA.Ctrl.IDERTypeHelper;
import SA.SRFDA.Ctrl.ILayoutItemHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Ctrl.ORG.IORGTreeNodeTypeHelper;
import SA.SRFDA.Ctrl.ORG.IORGTreeTypeHelper;
import SA.SRFDA.Ctrl.ORG.IORGUnitTypeHelper;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSDEDataCtrl;
import SA.SRFDA.Security.IRCAccListHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.UIGear.IUIGear;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDAModelStorage
implements IDAModelStorage {
    private static final Log log = LogFactory.getLog(PSDAModelStorage.class);
    private ArrayList<IDASubSystemHelper> subSystemHelperList = new ArrayList();
    private Map<String, String> deDataCtrlObjMap = new HashMap<String, String>();
    private Map<String, IDEDataCtrl> deDataCtrlMap = new HashMap<String, IDEDataCtrl>();
    private Map<String, String> deNameMap = new HashMap<String, String>();

    public CallResult Init() {
        this.deDataCtrlObjMap.put("DE1115", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDataCtrl");
        this.deDataCtrlObjMap.put("DE1117", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelFieldDataCtrl");
        this.deDataCtrlObjMap.put("DE1132", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelFieldValueDataCtrl");
        this.deDataCtrlObjMap.put("DE1431", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSRobotWorkTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1434", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSCommonModelDataCtrl");
        this.deDataCtrlObjMap.put("DE1460", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSWorkspaceTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1461", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSWorkspaceDataCtrl");
        this.deDataCtrlObjMap.put("DE1492", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysUtilTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1501", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDBTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1502", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFDataCtrl");
        this.deDataCtrlObjMap.put("DE1503", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFDataCtrl");
        this.deDataCtrlObjMap.put("DE1505", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEFieldTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1513", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFStyleDataCtrl");
        this.deDataCtrlObjMap.put("DE1515", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFCodeTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1516", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFCodeTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1533", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysLanResDataCtrl");
        this.deDataCtrlObjMap.put("DE1534", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysLanItemDataCtrl");
        this.deDataCtrlObjMap.put("DE1550", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFStyleVerDataCtrl");
        this.deDataCtrlObjMap.put("DE1551", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFVerCodeDataCtrl");
        this.deDataCtrlObjMap.put("DE1552", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFVerCodeItemDataCtrl");
        this.deDataCtrlObjMap.put("DE1553", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFStyleCodeDataCtrl");
        this.deDataCtrlObjMap.put("DE1590", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelInitDataCtrl");
        this.deDataCtrlObjMap.put("DE1591", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelInitStepDataCtrl");
        this.deDataCtrlObjMap.put("DE1595", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFStyleDataCtrl");
        this.deDataCtrlObjMap.put("DE1598", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSViewEngineDataCtrl");
        this.deDataCtrlObjMap.put("DE1600", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSViewTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1601", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSCtrlTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1605", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSEditorTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1620", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysToobarDataCtrl");
        this.deDataCtrlObjMap.put("DE1627", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSCtrlTypeEventDataCtrl");
        this.deDataCtrlObjMap.put("DE1628", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSCtrlTypeActionDataCtrl");
        this.deDataCtrlObjMap.put("DE1638", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFPreviewNodeDataCtrl");
        this.deDataCtrlObjMap.put("DE1661", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFPluginTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1662", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFStyleParamDataCtrl");
        this.deDataCtrlObjMap.put("DE1680", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSHelpSectionTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1681", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSHelpArticleTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1682", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSHelpArticleTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1683", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSHelpSectionTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1685", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSHelpPrjTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1686", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSHelpPrjTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1691", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSUIEngineTypeDataCtrl");
        this.deDataCtrlObjMap.put("DE1800", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFStyleCodeDataCtrl");
        this.deDataCtrlObjMap.put("DE1801", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFViewTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1802", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFCtrlTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1803", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFCtrlTemplDetailDataCtrl");
        this.deDataCtrlObjMap.put("DE1804", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFEditorTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1805", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFUIActionTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1806", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFViewLogicTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1808", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFAppTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1817", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFPluginTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE1822", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSBackServiceDataCtrl");
        this.deDataCtrlObjMap.put("DE1885", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSvrDomainDataCtrl");
        this.deDataCtrlObjMap.put("DE1886", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSWorkshopServerDataCtrl");
        this.deDataCtrlObjMap.put("DE1890", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSvrServerDataCtrl");
        this.deDataCtrlObjMap.put("DE1891", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDBServerDataCtrl");
        this.deDataCtrlObjMap.put("DE1895", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysModelInstDataCtrl");
        this.deDataCtrlObjMap.put("DE1896", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysModelVerDataCtrl");
        this.deDataCtrlObjMap.put("DE1898", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCInstDataCtrl");
        this.deDataCtrlObjMap.put("DE1899", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDeployCenterDataCtrl");
        this.deDataCtrlObjMap.put("DE1900", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDBDevInstDataCtrl");
        this.deDataCtrlObjMap.put("DE1901", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSAppServerDataCtrl");
        this.deDataCtrlObjMap.put("DE1903", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSVNServerDataCtrl");
        this.deDataCtrlObjMap.put("DE1907", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSTaskServerCmdDataCtrl");
        this.deDataCtrlObjMap.put("DE1912", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSMobAppPackServerDataCtrl");
        this.deDataCtrlObjMap.put("DE1914", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSMSPlatformDataCtrl");
        this.deDataCtrlObjMap.put("DE1917", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSMavenServerDataCtrl");
        this.deDataCtrlObjMap.put("DE1933", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysModelQueryDataCtrl");
        this.deDataCtrlObjMap.put("DE1935", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSRobotDataCtrl");
        this.deDataCtrlObjMap.put("DE1950", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSubSysDataCtrl");
        this.deDataCtrlObjMap.put("DE1971", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysIssueEngineDataCtrl");
        this.deDataCtrlObjMap.put("DE2010", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevCenterDataCtrl");
        this.deDataCtrlObjMap.put("DE2012", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevUserDataCtrl");
        this.deDataCtrlObjMap.put("DE2015", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCDBInstDataCtrl");
        this.deDataCtrlObjMap.put("DE2020", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevSlnDataCtrl");
        this.deDataCtrlObjMap.put("DE2021", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevSlnSysDataCtrl");
        this.deDataCtrlObjMap.put("DE2030", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSystemDataCtrl");
        this.deDataCtrlObjMap.put("DE2032", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSystemDBConfigDataCtrl");
        this.deDataCtrlObjMap.put("DE2040", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSCodeListDataCtrl");
        this.deDataCtrlObjMap.put("DE2050", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDataEntityDataCtrl");
        this.deDataCtrlObjMap.put("DE2051", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEFieldDataCtrl");
        this.deDataCtrlObjMap.put("DE2052", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDERDataCtrl");
        this.deDataCtrlObjMap.put("DE2055", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDBConfigDataCtrl");
        this.deDataCtrlObjMap.put("DE2056", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataSetDataCtrl");
        this.deDataCtrlObjMap.put("DE2057", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataQueryDataCtrl");
        this.deDataCtrlObjMap.put("DE2058", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataQueryJoinDataCtrl");
        this.deDataCtrlObjMap.put("DE2059", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataQueryCondDataCtrl");
        this.deDataCtrlObjMap.put("DE2060", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEFDTColumnDataCtrl");
        this.deDataCtrlObjMap.put("DE2064", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEOPPrivDataCtrl");
        this.deDataCtrlObjMap.put("DE2067", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEFValueRuleDataCtrl");
        this.deDataCtrlObjMap.put("DE2070", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDBSysProcDataCtrl");
        this.deDataCtrlObjMap.put("DE2072", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDBSysProcCodeDataCtrl");
        this.deDataCtrlObjMap.put("DE2074", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDBSysProcFieldDataCtrl");
        this.deDataCtrlObjMap.put("DE2076", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEActionDataCtrl");
        this.deDataCtrlObjMap.put("DE2081", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataRelationDataCtrl");
        this.deDataCtrlObjMap.put("DE2082", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDRItemDataCtrl");
        this.deDataCtrlObjMap.put("DE2083", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDELogicDataCtrl");
        this.deDataCtrlObjMap.put("DE2084", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDELogicNodeDataCtrl");
        this.deDataCtrlObjMap.put("DE2086", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDELogicParamDataCtrl");
        this.deDataCtrlObjMap.put("DE2091", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDRGroupDataCtrl");
        this.deDataCtrlObjMap.put("DE2092", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDRDetailDataCtrl");
        this.deDataCtrlObjMap.put("DE2100", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSystemDeployDataCtrl");
        this.deDataCtrlObjMap.put("DE2101", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSystemDeployDBDataCtrl");
        this.deDataCtrlObjMap.put("DE2130", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysRefDataCtrl");
        this.deDataCtrlObjMap.put("DE2201", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEFormDataCtrl");
        this.deDataCtrlObjMap.put("DE2202", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEFormDetailDataCtrl");
        this.deDataCtrlObjMap.put("DE2203", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEFUIModeDataCtrl");
        this.deDataCtrlObjMap.put("DE2204", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEFSearchItemDataCtrl");
        this.deDataCtrlObjMap.put("DE2206", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEToobarDataCtrl");
        this.deDataCtrlObjMap.put("DE2210", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEGridDataCtrl");
        this.deDataCtrlObjMap.put("DE2211", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEGridColumnDataCtrl");
        this.deDataCtrlObjMap.put("DE2212", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEFGridColumnDataCtrl");
        this.deDataCtrlObjMap.put("DE2215", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEACModeDataCtrl");
        this.deDataCtrlObjMap.put("DE2217", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataViewDataCtrl");
        this.deDataCtrlObjMap.put("DE2245", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysDBSchemeDataCtrl");
        this.deDataCtrlObjMap.put("DE2290", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSACHandlerDataCtrl");
        this.deDataCtrlObjMap.put("DE2300", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEViewBaseDataCtrl");
        this.deDataCtrlObjMap.put("DE2302", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEViewCtrlDataCtrl");
        this.deDataCtrlObjMap.put("DE2303", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEViewLogicDataCtrl");
        this.deDataCtrlObjMap.put("DE2500", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysAppDataCtrl");
        this.deDataCtrlObjMap.put("DE2506", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSAppViewDataCtrl");
        this.deDataCtrlObjMap.put("DE2507", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSAppDEViewDataCtrl");
        this.deDataCtrlObjMap.put("DE2520", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSAppMenuDataCtrl");
        this.deDataCtrlObjMap.put("DE2521", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSAppMenuItemDataCtrl");
        this.deDataCtrlObjMap.put("DE2560", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSAppStoryBoardDataCtrl");
        this.deDataCtrlObjMap.put("DE2580", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSAppViewTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE2581", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSAppEditorTemplDataCtrl");
        this.deDataCtrlObjMap.put("DE2590", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSAppViewCodeDataCtrl");
        this.deDataCtrlObjMap.put("DE2650", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCMSPlatformDataCtrl");
        this.deDataCtrlObjMap.put("DE2700", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevSysDiffRepDataCtrl");
        this.deDataCtrlObjMap.put("DE2800", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysSFPubDataCtrl");
        this.deDataCtrlObjMap.put("DE2810", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysServiceAPIDataCtrl");
        this.deDataCtrlObjMap.put("DE2815", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSubSysServiceAPIDataCtrl");
        this.deDataCtrlObjMap.put("DE2831", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysRunSessionDataCtrl");
        this.deDataCtrlObjMap.put("DE2850", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSUAWizardDataCtrl");
        this.deDataCtrlObjMap.put("DE2851", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSUAWizard2DataCtrl");
        this.deDataCtrlObjMap.put("DE2853", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSUAWizard3DataCtrl");
        this.deDataCtrlObjMap.put("DE2854", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSHelpArticleDataCtrl");
        this.deDataCtrlObjMap.put("DE2900", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSV3MigrateDataCtrl");
        this.deDataCtrlObjMap.put("DE2901", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSV3MigrateDEDataCtrl");
        this.deDataCtrlObjMap.put("DE2902", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSV3MigrateDEFormDataCtrl");
        this.deDataCtrlObjMap.put("DE2903", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSV3MigrateDEGridDataCtrl");
        this.deDataCtrlObjMap.put("DE2922", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysDevBKTaskDataCtrl");
        this.deDataCtrlObjMap.put("DE2928", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevCenterFileDataCtrl");
        this.deDataCtrlObjMap.put("DE2939", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevSlnSysDynaInstDataCtrl");
        this.deDataCtrlObjMap.put("DE2943", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCDBInstBKDataCtrl");
        this.deDataCtrlObjMap.put("DE2968", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevSlnSysDynaInstTagDataCtrl");
        this.deDataCtrlObjMap.put("DE2969", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevSlnSysDynaInstRefDataCtrl");
        this.deDataCtrlObjMap.put("DE2970", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCRobotDataCtrl");
        this.deDataCtrlObjMap.put("DE2971", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCWorkspaceDataCtrl");
        this.deDataCtrlObjMap.put("DE2975", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCWorkspaceActionDataCtrl");
        this.deDataCtrlObjMap.put("DE2984", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCBKTaskDataCtrl");
        this.deDataCtrlObjMap.put("DE3150", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevSlnSysBakDataCtrl");
        this.deDataCtrlObjMap.put("DE3153", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDevSlnSysDepInstDataCtrl");
        this.deDataCtrlObjMap.put("DE3252", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCCodeSnippetDataCtrl");
        this.deDataCtrlObjMap.put("DE4073", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysRTDEFInputTipDataCtrl");
        this.deDataCtrlObjMap.put("DE4200", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFPreviewActionDataCtrl");
        this.deDataCtrlObjMap.put("DE4201", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFPreviewActionDataCtrl");
        this.deDataCtrlObjMap.put("DE4202", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSCodePreviewActionDataCtrl");
        this.deDataCtrlObjMap.put("DE4203", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSCodeServerActionDataCtrl");
        this.deDataCtrlObjMap.put("DE4501", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCDBTableDataCtrl");
        this.deDataCtrlObjMap.put("DE4502", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCDBViewDataCtrl");
        this.deDataCtrlObjMap.put("DE4531", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelSFCodeDataCtrl");
        this.deDataCtrlObjMap.put("DE4532", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelPFCodeDataCtrl");
        this.deDataCtrlObjMap.put("DE4533", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelRTDataCtrl");
        this.deDataCtrlObjMap.put("DE4700", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSUWCreateDEDataCtrl");
        this.deDataCtrlObjMap.put("DE4711", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSUWProjectDataCtrl");
        this.deDataCtrlObjMap.put("DE2001", "SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysDynaModelDataCtrl");
        this.deNameMap.put("DE1115", "PSMODEL");
        this.deNameMap.put("DE1117", "PSMODELFIELD");
        this.deNameMap.put("DE1132", "PSMODELFIELDVALUE");
        this.deNameMap.put("DE1431", "PSROBOTWORKTYPE");
        this.deNameMap.put("DE1434", "PSROBOTABILITY");
        this.deNameMap.put("DE1460", "PSWORKSPACETYPE");
        this.deNameMap.put("DE1461", "PSWORKSPACE");
        this.deNameMap.put("DE1492", "PSSYSUTILTYPE");
        this.deNameMap.put("DE1501", "PSDBTYPE");
        this.deNameMap.put("DE1502", "PSSF");
        this.deNameMap.put("DE1503", "PSPF");
        this.deNameMap.put("DE1505", "PSDEFTYPE");
        this.deNameMap.put("DE1513", "PSSFSTYLE");
        this.deNameMap.put("DE1515", "PSSFCODETYPE");
        this.deNameMap.put("DE1516", "PSSFCODETEMPL");
        this.deNameMap.put("DE1533", "PSSYSLANRES");
        this.deNameMap.put("DE1534", "PSSYSLANITEM");
        this.deNameMap.put("DE1550", "PSSFSTYLEVER");
        this.deNameMap.put("DE1551", "PSSFVERCODE");
        this.deNameMap.put("DE1552", "PSSFVERCODEITEM");
        this.deNameMap.put("DE1553", "PSSFSTYLECODE");
        this.deNameMap.put("DE1590", "PSMODELINIT");
        this.deNameMap.put("DE1591", "PSMIDETAIL");
        this.deNameMap.put("DE1595", "PSPFSTYLE");
        this.deNameMap.put("DE1598", "PSVIEWENGINE");
        this.deNameMap.put("DE1600", "PSVIEWTYPE");
        this.deNameMap.put("DE1601", "PSCTRLTYPE");
        this.deNameMap.put("DE1605", "PSEDITORTYPE");
        this.deNameMap.put("DE1620", "PSSYSTOOLBAR");
        this.deNameMap.put("DE1627", "PSCTRLTYPEEVENT");
        this.deNameMap.put("DE1628", "PSCTRLTYPEACTION");
        this.deNameMap.put("DE1638", "PSPFPREVIEWNODE");
        this.deNameMap.put("DE1661", "PSSFPLUGINTEMPL");
        this.deNameMap.put("DE1662", "PSSFSTYLEPARAM");
        this.deNameMap.put("DE1680", "PSHELPSECTIONTYPE");
        this.deNameMap.put("DE1681", "PSHELPARTICLETYPE");
        this.deNameMap.put("DE1682", "PSHELPARTICLETEMPL");
        this.deNameMap.put("DE1683", "PSHELPSECTIONTEMPL");
        this.deNameMap.put("DE1685", "PSHELPPRJTYPE");
        this.deNameMap.put("DE1686", "PSHELPPRJTEMPL");
        this.deNameMap.put("DE1691", "PSUIENGINETYPE");
        this.deNameMap.put("DE1800", "PSPFSTYLECODE");
        this.deNameMap.put("DE1801", "PSPFVIEWTEMPL");
        this.deNameMap.put("DE1802", "PSPFCTRLTEMPL");
        this.deNameMap.put("DE1803", "PSPFCTDETAIL");
        this.deNameMap.put("DE1804", "PSPFEDITORTEMPL");
        this.deNameMap.put("DE1805", "PSPFUATEMPL");
        this.deNameMap.put("DE1806", "PSPFVLTEMPL");
        this.deNameMap.put("DE1808", "PSPFAPPTEMPL");
        this.deNameMap.put("DE1817", "PSPFPLUGINTEMPL");
        this.deNameMap.put("DE1822", "PSBACKSERVICE");
        this.deNameMap.put("DE1885", "PSSVRDOMAIN");
        this.deNameMap.put("DE1886", "PSWORKSHOPSERVER");
        this.deNameMap.put("DE1890", "PSSVRSERVER");
        this.deNameMap.put("DE1891", "PSDBSERVER");
        this.deNameMap.put("DE1895", "PSSYSMODELINST");
        this.deNameMap.put("DE1896", "PSSYSMODELVER");
        this.deNameMap.put("DE1898", "PSDCINST");
        this.deNameMap.put("DE1899", "PSDEPLOYCENTER");
        this.deNameMap.put("DE1900", "PSDBDEVINST");
        this.deNameMap.put("DE1901", "PSAPPSERVER");
        this.deNameMap.put("DE1903", "PSSVNSERVER");
        this.deNameMap.put("DE1907", "PSTSCMD");
        this.deNameMap.put("DE1912", "PSMOBAPPPACKSERVER");
        this.deNameMap.put("DE1914", "PSMSPLATFORM");
        this.deNameMap.put("DE1917", "PSMAVENSERVER");
        this.deNameMap.put("DE1933", "PSSYSMODELQUERY");
        this.deNameMap.put("DE1935", "PSROBOT");
        this.deNameMap.put("DE1950", "PSSUBSYS");
        this.deNameMap.put("DE1971", "PSSYSISSUEENGINE");
        this.deNameMap.put("DE2010", "PSDEVCENTER");
        this.deNameMap.put("DE2012", "PSDEVUSER");
        this.deNameMap.put("DE2015", "PSDEVCENTERDBINST");
        this.deNameMap.put("DE2020", "PSDEVSLN");
        this.deNameMap.put("DE2021", "PSDEVSLNSYS");
        this.deNameMap.put("DE2030", "PSSYSTEM");
        this.deNameMap.put("DE2032", "PSSYSTEMDBCFG");
        this.deNameMap.put("DE2040", "PSCODELIST");
        this.deNameMap.put("DE2050", "PSDATAENTITY");
        this.deNameMap.put("DE2051", "PSDEFIELD");
        this.deNameMap.put("DE2052", "PSDER");
        this.deNameMap.put("DE2055", "PSDEDBCFG");
        this.deNameMap.put("DE2056", "PSDEDATASET");
        this.deNameMap.put("DE2057", "PSDEDATAQUERY");
        this.deNameMap.put("DE2058", "PSDEDQJOIN");
        this.deNameMap.put("DE2059", "PSDEDQCOND");
        this.deNameMap.put("DE2060", "PSDEFDTCOL");
        this.deNameMap.put("DE2064", "PSDEOPPRIV");
        this.deNameMap.put("DE2067", "PSDEFVALUERULE");
        this.deNameMap.put("DE2070", "PSDESYSPROC");
        this.deNameMap.put("DE2072", "PSDESPCODE");
        this.deNameMap.put("DE2074", "PSDESPFIELD");
        this.deNameMap.put("DE2076", "PSDEACTION");
        this.deNameMap.put("DE2081", "PSDEDATARELATION");
        this.deNameMap.put("DE2082", "PSDEDRITEM");
        this.deNameMap.put("DE2083", "PSDELOGIC");
        this.deNameMap.put("DE2084", "PSDELOGICNODE");
        this.deNameMap.put("DE2086", "PSDELOGICPARAM");
        this.deNameMap.put("DE2091", "PSDEDRGROUP");
        this.deNameMap.put("DE2092", "PSDEDRDETAIL");
        this.deNameMap.put("DE2100", "PSSYSDEPLOY");
        this.deNameMap.put("DE2101", "PSSYSDEPLOYDB");
        this.deNameMap.put("DE2130", "PSSYSREF");
        this.deNameMap.put("DE2201", "PSDEFORM");
        this.deNameMap.put("DE2202", "PSDEFORMDETAIL");
        this.deNameMap.put("DE2203", "PSDEFFORMITEM");
        this.deNameMap.put("DE2204", "PSDEFSFITEM");
        this.deNameMap.put("DE2206", "PSDETOOLBAR");
        this.deNameMap.put("DE2210", "PSDEGRID");
        this.deNameMap.put("DE2211", "PSDEGRIDCOL");
        this.deNameMap.put("DE2212", "PSDEFGRIDCOL");
        this.deNameMap.put("DE2215", "PSDEACMODE");
        this.deNameMap.put("DE2217", "PSDEDATAVIEW");
        this.deNameMap.put("DE2245", "PSSYSDBSCHEME");
        this.deNameMap.put("DE2290", "PSACHANDLER");
        this.deNameMap.put("DE2300", "PSDEVIEWBASE");
        this.deNameMap.put("DE2302", "PSDEVIEWCTRL");
        this.deNameMap.put("DE2303", "PSDEVIEWLOGIC");
        this.deNameMap.put("DE2500", "PSSYSAPP");
        this.deNameMap.put("DE2506", "PSAPPVIEW");
        this.deNameMap.put("DE2507", "PSAPPDEVIEW");
        this.deNameMap.put("DE2520", "PSAPPMENU");
        this.deNameMap.put("DE2521", "PSAPPMENUITEM");
        this.deNameMap.put("DE2560", "PSAPPSTORYBOARD");
        this.deNameMap.put("DE2580", "PSAPPVIEWTEMPL");
        this.deNameMap.put("DE2581", "PSAPPEDITORTEMPL");
        this.deNameMap.put("DE2590", "PSAPPVIEWCODE");
        this.deNameMap.put("DE2650", "PSDCMSPLATFORM");
        this.deNameMap.put("DE2700", "PSDEVSYSDIFFREP");
        this.deNameMap.put("DE2800", "PSSYSSFPUB");
        this.deNameMap.put("DE2810", "PSSYSSERVICEAPI");
        this.deNameMap.put("DE2815", "PSSUBSYSSERVICEAPI");
        this.deNameMap.put("DE2831", "PSSYSRUNSESSION");
        this.deNameMap.put("DE2850", "PSUAWIZARD");
        this.deNameMap.put("DE2851", "PSUAWIZARD2");
        this.deNameMap.put("DE2853", "PSUAWIZARD3");
        this.deNameMap.put("DE2854", "PSHELPARTICLE");
        this.deNameMap.put("DE2900", "PSV3MIGRATE");
        this.deNameMap.put("DE2901", "PSV3MIGRATEDE");
        this.deNameMap.put("DE2902", "PSV3MGFORM");
        this.deNameMap.put("DE2903", "PSV3MGGRID");
        this.deNameMap.put("DE2922", "PSSYSDEVBKTASK");
        this.deNameMap.put("DE2928", "PSDEVCENTERFILE");
        this.deNameMap.put("DE2939", "PSDEVSLNSYSDYNAINST");
        this.deNameMap.put("DE2943", "PSDCDBINSTBK");
        this.deNameMap.put("DE2968", "PSDEVSLNSYSDYNAINSTTAG");
        this.deNameMap.put("DE2969", "PSDEVSLNSYSDYNAINSTREF");
        this.deNameMap.put("DE2970", "PSDCROBOT");
        this.deNameMap.put("DE2971", "PSDCWORKSPACE");
        this.deNameMap.put("DE2975", "PSDCWORKSPACEACTION");
        this.deNameMap.put("DE2984", "PSDCBKTASK");
        this.deNameMap.put("DE3150", "PSDEVSLNSYSBAK");
        this.deNameMap.put("DE3153", "PSDEVSLNSYSDEPINST");
        this.deNameMap.put("DE3252", "PSDCCODESNIPPET");
        this.deNameMap.put("DE4073", "PSSYSRTDEFINPUTTIP");
        this.deNameMap.put("DE4200", "PSPFPREVIEWACTION");
        this.deNameMap.put("DE4201", "PSSFPREVIEWACTION");
        this.deNameMap.put("DE4202", "PSCODEPREVIEWACTION");
        this.deNameMap.put("DE4203", "PSCODESERVERACTION");
        this.deNameMap.put("DE4501", "PSDCDBTABLE");
        this.deNameMap.put("DE4502", "PSDCDBVIEW");
        this.deNameMap.put("DE4531", "PSMODELSFCODE");
        this.deNameMap.put("DE4532", "PSMODELPFCODE");
        this.deNameMap.put("DE4533", "PSMODELRT");
        this.deNameMap.put("DE4700", "PSUWCREATEDE");
        this.deNameMap.put("DE4711", "PSUWPROJECT");
        this.deNameMap.put("DE2001", "PSSYSDYNAMODEL");
        this.deNameMap.put("DE2001", "PSSYSDYNAMODEL");
        this.deNameMap.put("DE2001", "PSSYSDYNAMODEL");
        this.deNameMap.put("DE1985", "PSSTUDIOPLUGIN");
        this.deNameMap.put("DE1986", "PSSTUDIOPLUGINDATA");
        this.deNameMap.put("DE2663", "PSDEVSLNMSDEPRES");
        this.deNameMap.put("DE2662", "PSDEVSLNRES");
        this.deNameMap.put("DE2988", "PSDEVSLNPIPELINE");
        this.deNameMap.put("DE2989", "PSDEVSLNPIPELINEREF");
        this.deNameMap.put("DE2993", "PSDEVSLNPIPELINELOG");
        this.deNameMap.put("DE2994", "PSDEVSLNPIPELINESTAGE");
        this.deNameMap.put("DE2995", "PSDEVSLNPIPELINESTEP");
        this.deNameMap.put("DE1936", "PSCREDENTIAL");
        return new CallResult();
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(String strQueryModelId) {
        return null;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String strQueryModelId, boolean bDeleteMode) {
        return null;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(QueryModel queryModel) {
        return null;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(QueryModel queryModel, boolean bDeleteMode) {
        return null;
    }

    public BaseDAQueryModelHelper GetDAQueryModelHelper(String strDEId, DGModelMainQueryConfig mainQueryConfig) {
        return null;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(String strQueryModelId, DataGrid gridView) {
        return null;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String strQueryModelId, DataGrid gridView, boolean bDeleteMode) {
        return null;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(DataGrid gridView) {
        return null;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(DataGrid gridView, boolean bDeleteMode) {
        return null;
    }

    public BaseDAQueryModelHelper getDAQueryModelHelper(IDEHelper iDEHelper) {
        return null;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(IDEHelper iDEHelper) {
        return null;
    }

    public IDEDataCtrl FindDEDataCtrl(String strDEID, ISRFDAWebContext webContext) {
        String strObject = this.deDataCtrlObjMap.get(strDEID);
        if (StringHelper.isNullOrEmpty((String)strObject)) {
            return null;
        }
        try {
            IDEDataCtrl iDEDataCtrl = (IDEDataCtrl)ObjectHelper.create((String)strObject);
            if (iDEDataCtrl instanceof IPSDEDataCtrl) {
                ((IPSDEDataCtrl)iDEDataCtrl).setPSModelName(this.deNameMap.get(strDEID));
            }
            return iDEDataCtrl;
        }
        catch (Exception e) {
            log.error((Object)String.format("\u5efa\u7acb\u5bf9\u8c61[%1$s]\u53d1\u751f\u5f02\u5e38, %2$s", strObject, e.getMessage()));
            return null;
        }
    }

    public IDEDataCtrl FindDEDataCtrl2(String strDEID, ISRFDAWebContext webContext) throws Exception {
        return null;
    }

    public IDEDataCtrl FindDEDataCtrl(String strDEID, String strOpPersonId, ISRFDAWebContext webContext) {
        return null;
    }

    public IDEDataCtrl FindDEDataCtrl2(String strDEID, String strOpPersonId, ISRFDAWebContext webContext) throws Exception {
        return null;
    }

    public IDEDataCtrl FindDEDataCtrlEx(String strDEID, IDEDataCtrl curDataCtrl) {
        return null;
    }

    public IDEDataCtrl FindDEDataCtrlEx2(String strDEID, IDEDataCtrl curDataCtrl) throws Exception {
        return null;
    }

    public IDEHelper FindDEHelper(String strDEID) {
        return null;
    }

    public IDEHelper FindDEHelper(String strDEID, boolean bCache) {
        return null;
    }

    public IDEHelper FindDEHelper2(String strDEID) throws Exception {
        return null;
    }

    public IDEHelper FindDEHelper2(String strDEID, boolean bCache) throws Exception {
        return null;
    }

    public void ResetCodeListConfig(String strCodeListId) {
    }

    public void ResetAllCodeList() {
    }

    public CodeListConfig FindCodeListConfig(String strCodeListId) {
        return null;
    }

    public Page FindPage(String strPageId) {
        return null;
    }

    public IPageHelper FindPage2(String strPageId) throws Exception {
        return null;
    }

    public void ResetPage(String strPageId) {
    }

    public DataLockDataCtrl GetDataLockDataCtrl() {
        return null;
    }

    public IDEDataCtrl GetSessionDataDataCtrl() {
        return null;
    }

    public IDBStorage FindDBStorage(String strDBStorageId) {
        return null;
    }

    public CallResult GetQueryModel(String strQueryModelId, QueryModel queryModel, boolean bCache) {
        return null;
    }

    public void ResetQueryModel(String strQueryModelId) {
    }

    public CallResult GetDEMainForm(String strDEId, Form form, boolean bCache) {
        return null;
    }

    public FIUpdate FindFIUpdate(String strDEId, String strFIUpdateMode) {
        return null;
    }

    public void ResetFIUpdate(String strDEid, String strFIUpdateMode) {
    }

    public GroupStatisticsRep FindGroupStatisticsRep(String strGroupStatisticsRepId) {
        return null;
    }

    public void ResetGroupStatisticsRep(String strGroupStatisticsRepId) {
    }

    public int GetDAModelVersion(String strDEId, Object objDataId) {
        return 0;
    }

    public int GetDAModelVersion(String strDEId, Object objDataId, boolean bReset) {
        return 0;
    }

    public THGroup FindTHGroup(String strTHGroupId) {
        return null;
    }

    public void ResetTHGroup(String strTHGroupId) {
    }

    public TreeView FindTreeView(String strTreeViewId) {
        return null;
    }

    public void ResetTreeView(String strTreeViewId) {
    }

    public GSR2 FindGSR2(String strGSR2Id) {
        return null;
    }

    public void ResetGSR2(String strGSR2Id) {
    }

    public ValueRule FindValueRule(String strValueRuleId) {
        return null;
    }

    public void ResetValueRule(String strValueRuleId) {
    }

    public DevImage FindDevImage(String strDevImageId) {
        return null;
    }

    public void ResetDevImage(String strDevImageId) {
    }

    public TBTempl FindTBTempl(String strTBTemplId) {
        return null;
    }

    public void ResetTBTempl(String strTBTemplId) {
    }

    public Toolbar FindToolbar(String strToolbarId) {
        return null;
    }

    public void ResetToolbar(String strToolbarId) {
    }

    public DEBehavior FindDEBehavior(String strDEBehaviorId) {
        return null;
    }

    public IDEBehaviorHelper FindDEBehavior2(String strDEBehaviorId) throws Exception {
        return null;
    }

    public void ResetDEBehavior(String strDEBehaviorId) {
    }

    public PageParamType FindPageParamType(String strPageParamTypeId) {
        return null;
    }

    public void ResetPageParamType(String strPageParamTypeId) {
    }

    public PageParamFolder FindPageParamFolder(String strPageParamFolderId) {
        return null;
    }

    public void ResetPageParamFolder(String strPageParamFolderId) {
    }

    public DEBHGroup FindDEBHGroup(String strDEBHGroupId) {
        return null;
    }

    public void ResetDEBHGroup(String strDEBHGroupId) {
    }

    public IUIGear FindUIGear(String strUIGearId) {
        return null;
    }

    public void ResetUIGear(String strUIGearId) {
    }

    public IDAGlobalModel FindGlobalModel(String strDEId) {
        return null;
    }

    public boolean IsEnableGlobalModel() {
        return false;
    }

    public MBPanel FindMBPanel(String strMBPanelId) {
        return null;
    }

    public void ResetMBPanel(String strMBPanelId) {
    }

    public IDERModeHelper FindDERMode(String strDERModeId) throws Exception {
        return null;
    }

    public IDERTypeHelper FindDERType(String strDERTypeId) throws Exception {
        return null;
    }

    public void ResetDERType(String strDERTypeId) {
    }

    public IDERGroupFolderHelper FindDERGroupFolder(String strDERGroupFolderId) throws Exception {
        return null;
    }

    public void ResetDERGroupFolder(String strDERGroupFolderId) {
    }

    public IDEDataCtrl FindGlobalDEDataCtrl(String strDEId, String strUserTag) throws Exception {
        return null;
    }

    public ISyncAgentTypeHelper FindSyncAgentType(String strSyncAgentTypeId) throws Exception {
        return null;
    }

    public void ResetSyncAgentType(String strSyncAgentTypeId) {
    }

    public void ReloadDETBBHandlers() throws Exception {
    }

    public String GetDETBBHandler(String strDEId, String strTBBHandler) {
        return null;
    }

    public boolean TestProduct(String strProductId) {
        return false;
    }

    public boolean TestDataEntity(String strDEId) {
        return false;
    }

    public IORGUnitTypeHelper FindORGUnitType(String strORGUnitTypeId) throws Exception {
        return null;
    }

    public IORGTreeTypeHelper FindORGTreeType(String strORGTreeTypeId) throws Exception {
        return null;
    }

    public IORGTreeNodeTypeHelper FindORGTreeNodeType(String strORGTreeNodeTypeId) throws Exception {
        return null;
    }

    public IRCAccListHelper FindRCAccList(String strRCAccListId) throws Exception {
        return null;
    }

    public void ResetRCAccList(String strRCAccListId) {
    }

    public Iterator<IDASubSystemHelper> getSubSystems() {
        return this.subSystemHelperList.iterator();
    }

    public ICounterTypeHelper FindCounterType(String strCounterTypeId) throws Exception {
        return null;
    }

    public ICounterHelper FindCounter(String strCounterId) throws Exception {
        return null;
    }

    public ILayoutItemHelper FindLayoutItem(String strLayoutItemId) throws Exception {
        return null;
    }
}

