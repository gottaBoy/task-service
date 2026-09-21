/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.AppUITheme;
import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.Data.CodeList;
import SA.SRFDA.Ctrl.Data.ConfigPublisher;
import SA.SRFDA.Ctrl.Data.Counter;
import SA.SRFDA.Ctrl.Data.CounterType;
import SA.SRFDA.Ctrl.Data.DBAction;
import SA.SRFDA.Ctrl.Data.DBActionStep;
import SA.SRFDA.Ctrl.Data.DBObject;
import SA.SRFDA.Ctrl.Data.DBStorage;
import SA.SRFDA.Ctrl.Data.DEACMode;
import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.Data.DEDCProcType;
import SA.SRFDA.Ctrl.Data.DEDCProcess;
import SA.SRFDA.Ctrl.Data.DEDSCtrl;
import SA.SRFDA.Ctrl.Data.DEDataAction;
import SA.SRFDA.Ctrl.Data.DEDataChgDisp;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Ctrl.Data.DEDataSync;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DEMAField;
import SA.SRFDA.Ctrl.Data.DEMSMA;
import SA.SRFDA.Ctrl.Data.DEMSMap;
import SA.SRFDA.Ctrl.Data.DEMainAction;
import SA.SRFDA.Ctrl.Data.DEMainState;
import SA.SRFDA.Ctrl.Data.DEMobile;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DER1NEx;
import SA.SRFDA.Ctrl.Data.DERCUSTOM;
import SA.SRFDA.Ctrl.Data.DERGroup;
import SA.SRFDA.Ctrl.Data.DERGroupDetail;
import SA.SRFDA.Ctrl.Data.DERGroupFolder;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DERMode;
import SA.SRFDA.Ctrl.Data.DERType;
import SA.SRFDA.Ctrl.Data.DEShortcut;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DETBBHandler;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.DEWFDetail;
import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.DEWizardDetail;
import SA.SRFDA.Ctrl.Data.DGMode;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.DataGridEx;
import SA.SRFDA.Ctrl.Data.DataNotify;
import SA.SRFDA.Ctrl.Data.DataRange;
import SA.SRFDA.Ctrl.Data.DataSyncAgent;
import SA.SRFDA.Ctrl.Data.FIUpdate;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.FormItemEx;
import SA.SRFDA.Ctrl.Data.Func;
import SA.SRFDA.Ctrl.Data.GSRGroupColumn;
import SA.SRFDA.Ctrl.Data.GSRMeasure;
import SA.SRFDA.Ctrl.Data.GlobalObject;
import SA.SRFDA.Ctrl.Data.GroupStatisticsRep;
import SA.SRFDA.Ctrl.Data.IgnorePatch;
import SA.SRFDA.Ctrl.Data.LanguageItem;
import SA.SRFDA.Ctrl.Data.LayoutItem;
import SA.SRFDA.Ctrl.Data.List;
import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.Data.MainMenu;
import SA.SRFDA.Ctrl.Data.ORGTree;
import SA.SRFDA.Ctrl.Data.ORGTreeNode;
import SA.SRFDA.Ctrl.Data.ORGTreeNodeType;
import SA.SRFDA.Ctrl.Data.ORGTreeType;
import SA.SRFDA.Ctrl.Data.ORGUnit;
import SA.SRFDA.Ctrl.Data.ORGUnitType;
import SA.SRFDA.Ctrl.Data.PPModel;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.PageLogic;
import SA.SRFDA.Ctrl.Data.PageParam;
import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.Data.RCALDetail;
import SA.SRFDA.Ctrl.Data.RCAccList;
import SA.SRFDA.Ctrl.Data.Registry;
import SA.SRFDA.Ctrl.Data.Report;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.Data.SubSystem;
import SA.SRFDA.Ctrl.Data.SummaryPage;
import SA.SRFDA.Ctrl.Data.SyncAgentType;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.Data.UserDGTheme;
import SA.SRFDA.Ctrl.Data.UserGroup;
import SA.SRFDA.Ctrl.Data.UserRole;
import SA.SRFDA.Ctrl.Data.UserRoleDEField;
import SA.SRFDA.Ctrl.Data.UserRoleData;
import SA.SRFDA.Ctrl.Data.UserRoleDataAction;
import SA.SRFDA.Ctrl.Data.UserRoleDataDetail;
import SA.SRFDA.Ctrl.Data.UserRoleRes;
import SA.SRFDA.Ctrl.Data.WebPart;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IDAModelHelper {
    public void SetDAGlobalHelper(ISRFDAGlobalHelper var1);

    public int GetDEModelVersion(String var1);

    public CallResult GetDataEntity(String var1, DataEntity var2);

    public CallResult GetDataEntities(String var1, Vector<DataEntity> var2);

    public CallResult GetDEVersion(String var1, DataEntity var2);

    public CallResult GetDEField(String var1, DEField var2);

    public CallResult GetDEWF(String var1, DEWF var2);

    public CallResult GetUserDEDataGrids(String var1, String var2, String var3, Vector<DataGrid> var4);

    public CallResult GetExcelExportDEDataGrid(String var1, DataGrid var2);

    public CallResult GetSummaryPages(String var1, String var2, Vector<SummaryPage> var3);

    public CallResult GetUserRoles(String var1, Vector<UserRole> var2);

    public CallResult GetUserRoles(Vector<String> var1, Vector<UserRole> var2);

    public CallResult GetUserRoleDatas(String var1, String var2, Vector<UserRoleData> var3);

    public CallResult GetUserRoleDatas(String var1, Vector<String> var2, Vector<UserRoleData> var3);

    public CallResult GetUserRoleDEFields(String var1, String var2, Vector<UserRoleDEField> var3);

    public CallResult GetUserRoleDEFields(String var1, Vector<String> var2, Vector<UserRoleDEField> var3);

    public CallResult GetUserRoleReses(String var1, String var2, String var3, Vector<UserRoleRes> var4);

    public CallResult GetUserRoleReses(String var1, String var2, Vector<String> var3, Vector<UserRoleRes> var4);

    public CallResult GetUserRoleDataActions(String var1, Vector<UserRoleDataAction> var2);

    public CallResult GetUserRoleDataDetails(String var1, Vector<UserRoleDataDetail> var2);

    public CallResult GetUserRoleDataDRs(String var1, String var2, Vector<DataRange> var3);

    public CallResult GetDefaultDEDataGrid(String var1, DataGrid var2);

    public CallResult GetDefaultPickupDEDataGrid(String var1, DataGrid var2, String var3);

    public CallResult GetDEDataGridEx(String var1, String var2, DataGridEx var3);

    public CallResult GetUserDEDataGrid(String var1, String var2, DataGrid var3);

    public CallResult GetUserWFDataGrid(String var1, String var2, String var3, String var4, DataGrid var5);

    public CallResult GetUserPPModel(String var1, String var2, PPModel var3);

    public CallResult GetPPMWebParts(String var1, Vector<WebPart> var2);

    public CallResult GetDEFields(String var1, Vector<DEField> var2);

    public CallResult GetDEFieldsNoSort(String var1, Vector<DEField> var2);

    public CallResult GetPage(String var1, Page var2);

    public CallResult GetPageParams(String var1, Vector<PageParam> var2);

    public CallResult GetWebPart(String var1, WebPart var2);

    public CallResult GetChart(String var1, Chart var2);

    public CallResult GetList(String var1, List var2);

    public CallResult GetReport(String var1, Report var2);

    public CallResult GetChildReports(String var1, Vector<Report> var2);

    public CallResult GetQueryModel(String var1, QueryModel var2);

    public CallResult GetDBAction(String var1, String var2, String var3, String var4, DBAction var5);

    public CallResult GetDBActions(String var1, String var2, String var3, Vector<DBAction> var4);

    public CallResult GetDBActionStep(String var1, String var2, String var3, String var4, DBActionStep var5);

    public CallResult GetDBActionSteps(String var1, String var2, String var3, String var4, Vector<DBActionStep> var5);

    public CallResult GetDEDataActions(String var1, Vector<DEDataAction> var2);

    public CallResult GetDEActions(String var1, Vector<DEAction> var2);

    public CallResult GetDEShortcuts(String var1, int var2, Vector<DEShortcut> var3);

    public CallResult GetDEDSCtrls(String var1, Vector<DEDSCtrl> var2);

    public int GetPageVersion(String var1);

    public CallResult GetMainMenu(String var1, MainMenu var2);

    public CallResult GetFunc(String var1, Func var2);

    public CallResult GetDERType(String var1, DERType var2);

    public CallResult GetDERGroup(String var1, DERGroup var2);

    public CallResult GetDERGroups(String var1, Vector<DERGroup> var2);

    public CallResult GetDERGroupFolder(String var1, DERGroupFolder var2);

    public CallResult GetDERGroupDetails(String var1, Vector<DERGroupDetail> var2);

    public CallResult GetLanguageItems(String var1, Vector<LanguageItem> var2);

    public CallResult GetDGMode(String var1, DGMode var2);

    public CallResult GetDGMode(String var1, String var2, DGMode var3);

    public CallResult GetDGModeDetails(String var1, Vector<DGModeDetail> var2);

    public CallResult GetCodeList(String var1, CodeList var2);

    public CallResult GetDEACMode(String var1, String var2, DEACMode var3);

    public CallResult GetDEACModes(String var1, Vector<DEACMode> var2);

    public CallResult GetDefaultDEMainForm(String var1, Form var2);

    public CallResult GetDEForm(String var1, Form var2);

    public CallResult GetDESearchForm(String var1, SearchForm var2);

    public CallResult GetDEWFDetail(String var1, String var2, DEWFDetail var3);

    public CallResult GetDEWFForm(String var1, String var2, Form var3);

    public CallResult GetDEWFPrintForm(String var1, String var2, PrintForm var3);

    public CallResult GetDEPrintForm(String var1, String var2, PrintForm var3);

    public CallResult GetDEPrintForms(String var1, Vector<PrintForm> var2);

    public CallResult GetUserDEForm(String var1, String var2, Form var3);

    public CallResult GetDER1Ns(String var1, Vector<DER1N> var2);

    public CallResult GetDER1N(String var1, DER1N var2);

    public CallResult GetDER11(String var1, DER11 var2);

    public CallResult GetDERTypes(String var1, Vector<DERType> var2);

    public CallResult GetDERN1s(String var1, Vector<DER1N> var2);

    public CallResult GetDER11s(boolean var1, String var2, Vector<DER11> var3);

    public CallResult GetDERINDEXs(boolean var1, String var2, Vector<DERINDEX> var3);

    public CallResult GetDERCUSTOM(String var1, DERCUSTOM var2);

    public CallResult GetDERCUSTOMs(boolean var1, String var2, Vector<DERCUSTOM> var3);

    public CallResult GetDERINDEXVIEWs(boolean var1, String var2, Vector<DERINDEX> var3);

    public CallResult GetDERINDEX(String var1, DERINDEX var2);

    public CallResult GetRawDER1Ns(String var1, Vector<DER1N> var2);

    public CallResult GetRawDERN1s(String var1, Vector<DER1N> var2);

    public CallResult GetRegistry(String var1, String var2, Registry var3);

    public CallResult GetDBStorages(Vector<DBStorage> var1);

    public CallResult GetDEDataCtrls(String var1, Vector<DEDataCtrl> var2);

    @Deprecated
    public CallResult GetDEDataCtrl(String var1, DEDataCtrl var2);

    public CallResult GetDEDCProcess(String var1, DEDCProcess var2);

    public CallResult GetDEDCProcTypes(Vector<DEDCProcType> var1);

    public CallResult GetSelectQueryModels(String var1, Vector<QueryModel> var2);

    public CallResult GetGlobalObjects(Vector<GlobalObject> var1);

    public CallResult GetAppUIThemes(Vector<AppUITheme> var1);

    public CallResult GetValidFormItemExs(Vector<FormItemEx> var1);

    public CallResult GetPageLogics(String var1, Vector<PageLogic> var2);

    public CallResult GetDEDataNotifies(String var1, Vector<DataNotify> var2);

    public CallResult GetFIUpdate(String var1, String var2, FIUpdate var3);

    public int GetFIUpdateVersion(String var1, String var2);

    public CallResult GetGroupStatisticsRep(String var1, GroupStatisticsRep var2);

    public int GetGroupStatisticsRepVersion(String var1);

    public CallResult GetGSRMeasures(String var1, Vector<GSRMeasure> var2);

    public CallResult GetGSRGroupColumns(String var1, Vector<GSRGroupColumn> var2);

    public CallResult GetDEDataImports(String var1, Vector<DEDataImport> var2);

    public CallResult GetUserObjectPUserGroups(Vector<String> var1, Vector<UserGroup> var2);

    public CallResult GetDEGlobalModels(Vector<DataEntity> var1);

    public CallResult GetDESubWFs(String var1, Vector<DESubWF> var2);

    public CallResult GetUserDGTheme(String var1, String var2, UserDGTheme var3);

    public CallResult GetDEWizards(String var1, Vector<DEWizard> var2);

    public CallResult GetDEWizard(String var1, DEWizard var2);

    public CallResult GetDEWizardDetail(String var1, String var2, DEWizardDetail var3);

    public CallResult GetDBObjects(String var1, String var2, Vector<DBObject> var3);

    public CallResult GetDBObject(String var1, String var2, String var3, DBObject var4);

    public CallResult GetIgnorePatchs(String var1, String var2, Vector<IgnorePatch> var3);

    public CallResult GetMBPanel(String var1, MBPanel var2);

    public CallResult GetDEMobile(String var1, DEMobile var2);

    public CallResult GetMBList(String var1, int var2, MBList var3);

    public CallResult GetMBList(String var1, MBList var2);

    public CallResult GetDERMode(String var1, DERMode var2);

    public CallResult GetDER1NExs(String var1, Vector<DER1NEx> var2);

    public CallResult GetValidDEDataChgDisps(Vector<DEDataChgDisp> var1);

    public CallResult GetSyncAgentType(String var1, SyncAgentType var2);

    public CallResult GetDEDataSyncs(String var1, Vector<DEDataSync> var2);

    public CallResult GetValidDataSyncAgents(Vector<DataSyncAgent> var1);

    public CallResult GetDEMainActions(String var1, Vector<DEMainAction> var2);

    public CallResult GetDEMainStates(String var1, Vector<DEMainState> var2);

    public CallResult GetConfigPublishers(Vector<ConfigPublisher> var1);

    public CallResult GetDEMSMAs(String var1, Vector<DEMSMA> var2);

    public CallResult GetDEMAFields(String var1, Vector<DEMAField> var2);

    public CallResult GetDEMSMaps(String var1, Vector<DEMSMap> var2);

    public CallResult GetDETBBHandlers(Vector<DETBBHandler> var1);

    public CallResult GetORGUnit(String var1, ORGUnit var2);

    public CallResult GetORGTreeNodes(String var1, String var2, Vector<ORGTreeNode> var3);

    public CallResult GetORGTreeNode(String var1, ORGTreeNode var2);

    public CallResult GetORGTree(String var1, ORGTree var2);

    public CallResult GetORGTreeRootNodes(String var1, Vector<ORGTreeNode> var2);

    public CallResult GetChildORGTreeNodes(String var1, Vector<ORGTreeNode> var2);

    public CallResult GetAllParentORGTreeNodes(String var1, Vector<ORGTreeNode> var2);

    public CallResult GetORGUnitType(String var1, ORGUnitType var2);

    public CallResult GetORGTreeType(String var1, ORGTreeType var2);

    public CallResult GetORGTreeNodeType(String var1, ORGTreeNodeType var2);

    public CallResult GetRCAccList(String var1, RCAccList var2);

    public CallResult GetRCALDetails(String var1, Vector<RCALDetail> var2);

    public void setPreloadDEIds(String var1);

    public CallResult GetSubSystems(Vector<SubSystem> var1);

    public CallResult GetToolbar(String var1, Toolbar var2);

    public CallResult GetCounter(String var1, Counter var2);

    public CallResult GetCounterType(String var1, CounterType var2);

    public CallResult GetLayoutItem(String var1, LayoutItem var2);

    public void startPreload();

    public void stopPreload();
}

