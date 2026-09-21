/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 */
package net.ibizsys.model;

import java.util.Vector;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSAppFunc;
import net.ibizsys.model.entity.PSAppIndexView;
import net.ibizsys.model.entity.PSAppLan;
import net.ibizsys.model.entity.PSAppMenu;
import net.ibizsys.model.entity.PSAppMenuItem;
import net.ibizsys.model.entity.PSAppMenuItemType;
import net.ibizsys.model.entity.PSAppModule;
import net.ibizsys.model.entity.PSAppPDTView;
import net.ibizsys.model.entity.PSAppPortalView;
import net.ibizsys.model.entity.PSAppPortalViewPart;
import net.ibizsys.model.entity.PSAppUIStyle;
import net.ibizsys.model.entity.PSAppUITheme;
import net.ibizsys.model.entity.PSAppUserMode;
import net.ibizsys.model.entity.PSAppUtilPage;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.entity.PSCodeItem;
import net.ibizsys.model.entity.PSCodeList;
import net.ibizsys.model.entity.PSControlType;
import net.ibizsys.model.entity.PSCounter;
import net.ibizsys.model.entity.PSCounterType;
import net.ibizsys.model.entity.PSDBType;
import net.ibizsys.model.entity.PSDBValueOP;
import net.ibizsys.model.entity.PSDEACMode;
import net.ibizsys.model.entity.PSDEACModeItem;
import net.ibizsys.model.entity.PSDEAction;
import net.ibizsys.model.entity.PSDEActionLogic;
import net.ibizsys.model.entity.PSDEActionParam;
import net.ibizsys.model.entity.PSDEActionType;
import net.ibizsys.model.entity.PSDEChart;
import net.ibizsys.model.entity.PSDEChartAxes;
import net.ibizsys.model.entity.PSDEChartSeries;
import net.ibizsys.model.entity.PSDEDRDetail;
import net.ibizsys.model.entity.PSDEDRGroup;
import net.ibizsys.model.entity.PSDEDRItem;
import net.ibizsys.model.entity.PSDEDSDQ;
import net.ibizsys.model.entity.PSDEDSGroupParam;
import net.ibizsys.model.entity.PSDEDataQuery;
import net.ibizsys.model.entity.PSDEDataQueryCode;
import net.ibizsys.model.entity.PSDEDataQueryCodeCond;
import net.ibizsys.model.entity.PSDEDataQueryCodeExp;
import net.ibizsys.model.entity.PSDEDataRelation;
import net.ibizsys.model.entity.PSDEDataSet;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSDEFIUDetail;
import net.ibizsys.model.entity.PSDEFIUpdate;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleCond;
import net.ibizsys.model.entity.PSDEFValueRuleType;
import net.ibizsys.model.entity.PSDEFValueRuleTypeDetail;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSDEFieldType;
import net.ibizsys.model.entity.PSDEForm;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.entity.PSDEFormItemVR;
import net.ibizsys.model.entity.PSDEGEIUDetail;
import net.ibizsys.model.entity.PSDEGEIUpdate;
import net.ibizsys.model.entity.PSDEGrid;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.model.entity.PSDEGridColumnType;
import net.ibizsys.model.entity.PSDEList;
import net.ibizsys.model.entity.PSDEListItem;
import net.ibizsys.model.entity.PSDELogic;
import net.ibizsys.model.entity.PSDELogicLink;
import net.ibizsys.model.entity.PSDELogicLinkCond;
import net.ibizsys.model.entity.PSDELogicLinkCondType;
import net.ibizsys.model.entity.PSDELogicLinkType;
import net.ibizsys.model.entity.PSDELogicNode;
import net.ibizsys.model.entity.PSDELogicNodeParam;
import net.ibizsys.model.entity.PSDELogicNodeType;
import net.ibizsys.model.entity.PSDELogicParam;
import net.ibizsys.model.entity.PSDEMainState;
import net.ibizsys.model.entity.PSDEMainStateAction;
import net.ibizsys.model.entity.PSDEMainStateOPPriv;
import net.ibizsys.model.entity.PSDEOPPriv;
import net.ibizsys.model.entity.PSDEPrint;
import net.ibizsys.model.entity.PSDER;
import net.ibizsys.model.entity.PSDERType;
import net.ibizsys.model.entity.PSDEToolbar;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.entity.PSDEUIActionGroup;
import net.ibizsys.model.entity.PSDEUIActionGroupDetail;
import net.ibizsys.model.entity.PSDEUIActionType;
import net.ibizsys.model.entity.PSDEUtil;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSDEViewCtrl;
import net.ibizsys.model.entity.PSDEViewView;
import net.ibizsys.model.entity.PSDRItemType;
import net.ibizsys.model.entity.PSDataEntity;
import net.ibizsys.model.entity.PSDepSlnSys;
import net.ibizsys.model.entity.PSDynaAppView;
import net.ibizsys.model.entity.PSDynaInst;
import net.ibizsys.model.entity.PSEditorType;
import net.ibizsys.model.entity.PSFDLogicType;
import net.ibizsys.model.entity.PSFormDetailType;
import net.ibizsys.model.entity.PSFormType;
import net.ibizsys.model.entity.PSLanguageItem;
import net.ibizsys.model.entity.PSLanguageRes;
import net.ibizsys.model.entity.PSPF;
import net.ibizsys.model.entity.PSPFCtrlTempl;
import net.ibizsys.model.entity.PSPFCtrlTemplDetail;
import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.entity.PSPFPluginTempl;
import net.ibizsys.model.entity.PSPFPubCode;
import net.ibizsys.model.entity.PSPFStyle;
import net.ibizsys.model.entity.PSPortletType;
import net.ibizsys.model.entity.PSSysCounter;
import net.ibizsys.model.entity.PSSysCss;
import net.ibizsys.model.entity.PSSysDBValueFunc;
import net.ibizsys.model.entity.PSSysDEFType;
import net.ibizsys.model.entity.PSSysDashboard;
import net.ibizsys.model.entity.PSSysDashboardPart;
import net.ibizsys.model.entity.PSSysEditorStyle;
import net.ibizsys.model.entity.PSSysImage;
import net.ibizsys.model.entity.PSSysModelInst;
import net.ibizsys.model.entity.PSSysPDTView;
import net.ibizsys.model.entity.PSSysPFPlugin;
import net.ibizsys.model.entity.PSSysPFPluginTempl;
import net.ibizsys.model.entity.PSSysPortlet;
import net.ibizsys.model.entity.PSSysUniRes;
import net.ibizsys.model.entity.PSSysValueRule;
import net.ibizsys.model.entity.PSSysWFSetting;
import net.ibizsys.model.entity.PSSystem;
import net.ibizsys.model.entity.PSSystemApplication;
import net.ibizsys.model.entity.PSToolbarItemType;
import net.ibizsys.model.entity.PSViewType;
import net.ibizsys.model.entity.PSWFDE;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.entity.PSWFLinkCondType;
import net.ibizsys.model.entity.PSWFLinkType;
import net.ibizsys.model.entity.PSWFProcParam;
import net.ibizsys.model.entity.PSWFProcRole;
import net.ibizsys.model.entity.PSWFProcSubWF;
import net.ibizsys.model.entity.PSWFProcess;
import net.ibizsys.model.entity.PSWFProcessType;
import net.ibizsys.model.entity.PSWFRole;
import net.ibizsys.model.entity.PSWFVersion;
import net.ibizsys.model.entity.PSWorkflow;
import net.ibizsys.paas.core.CallResult;

public interface IPSModelQueryHelper {
    public void active();

    public boolean isAlwaysActive();

    public void activeAlways();

    public long getLastActiveTime();

    public void setModelInstVer(int var1);

    public void startLoadPSSysApp(String var1, int var2) throws Exception;

    public void stopLoadPSSysApp() throws Exception;

    public void startLoadPSSystem(String var1, int var2) throws Exception;

    public void stopLoadPSSystem() throws Exception;

    public CallResult getPSDBType(String var1, PSDBType var2);

    public CallResult getPSSystem(String var1, PSSystem var2);

    public CallResult getPSSysModelInst(String var1, PSSysModelInst var2);

    public CallResult getPSAppViewRefs(String var1, Vector<PSAppViewRef> var2);

    public CallResult getPSDEViewBase(String var1, PSDEViewBase var2);

    public CallResult getPSDEViewViews(String var1, Vector<PSDEViewView> var2);

    public CallResult getPSDEViewCtrls(String var1, Vector<PSDEViewCtrl> var2);

    public CallResult getPSApplicationView(String var1, PSAppView var2);

    public CallResult getPSAppIndexView(String var1, PSAppIndexView var2);

    public CallResult getPSAppPortalView(String var1, PSAppPortalView var2);

    public CallResult getPSAppMenuItems(String var1, Vector<PSAppMenuItem> var2);

    public CallResult getPSAppMenu(String var1, PSAppMenu var2);

    public CallResult getPSDEGrid(String var1, PSDEGrid var2);

    public CallResult getPSDEToolbar(String var1, PSDEToolbar var2);

    public CallResult getPSDEFormItemVRs(String var1, Vector<PSDEFormItemVR> var2);

    public CallResult getPSDEFIUDetails(String var1, Vector<PSDEFIUDetail> var2);

    public CallResult getPSDEFIUpdates(String var1, Vector<PSDEFIUpdate> var2);

    public CallResult getPSDEFormDetails(String var1, Vector<PSDEFormDetail> var2);

    public CallResult getPSDEForm(String var1, PSDEForm var2);

    public CallResult getPSDEFDLogics(String var1, Vector<PSDEFDLogic> var2);

    public CallResult getPSDEGridColumns(String var1, Vector<PSDEGridColumn> var2);

    public CallResult getPSDEGEIUpdates(String var1, Vector<PSDEGEIUpdate> var2);

    public CallResult getPSDEGEIUDetails(String var1, Vector<PSDEGEIUDetail> var2);

    public CallResult getPSDEToolbarItems(String var1, Vector<PSDEToolbarItem> var2);

    public CallResult getPSSysDashboard(String var1, PSSysDashboard var2);

    public CallResult getPSSysDashboardParts(String var1, Vector<PSSysDashboardPart> var2);

    public CallResult getPSDEList(String var1, PSDEList var2);

    public CallResult getPSDEListItems(String var1, Vector<PSDEListItem> var2);

    public CallResult getPSDEChart(String var1, PSDEChart var2);

    public CallResult getPSDEChartAxeses(String var1, Vector<PSDEChartAxes> var2);

    public CallResult getPSDEChartSerieses(String var1, Vector<PSDEChartSeries> var2);

    public CallResult getPSAppPortalViewParts(String var1, Vector<PSAppPortalViewPart> var2);

    public CallResult getPSDepSlnSys(String var1, PSDepSlnSys var2);

    public CallResult getPSCodeItems(String var1, Vector<PSCodeItem> var2);

    public CallResult getPSCodeList(String var1, PSCodeList var2);

    public CallResult getAllPSCodeLists(String var1, Vector<PSCodeList> var2);

    public CallResult getAllPSSysCsses(String var1, Vector<PSSysCss> var2);

    public CallResult getPSSysCss(String var1, PSSysCss var2);

    public CallResult getAllPSSysImages(String var1, Vector<PSSysImage> var2);

    public CallResult getPSSysImage(String var1, PSSysImage var2);

    public CallResult getPSSysWFSetting(String var1, PSSysWFSetting var2);

    public CallResult getPSDataEntity(String var1, String var2, PSDataEntity var3);

    public CallResult getPSDataEntity(String var1, PSDataEntity var2);

    public CallResult getPSDER(String var1, PSDER var2);

    public CallResult getPSDEField(String var1, PSDEField var2);

    public CallResult getPSDEFieldsNoSort(String var1, Vector<PSDEField> var2);

    public CallResult getPSDEAction(String var1, PSDEAction var2);

    public CallResult getPSDEActions(String var1, Vector<PSDEAction> var2);

    public CallResult getPSDEActionParams(String var1, Vector<PSDEActionParam> var2);

    public CallResult getPSDEActionLogics(String var1, Vector<PSDEActionLogic> var2);

    public CallResult getPSDELogic(String var1, PSDELogic var2);

    public CallResult getPSDEUIActionGroup(String var1, PSDEUIActionGroup var2);

    public CallResult getPSDEUIAction(String var1, PSDEUIAction var2);

    public CallResult getPSSysDEUIActions(String var1, Vector<PSDEUIAction> var2);

    public CallResult getPSDEUIActions(String var1, Vector<PSDEUIAction> var2);

    public CallResult getPSDEACModes(String var1, Vector<PSDEACMode> var2);

    public CallResult getPSDEACMode(String var1, PSDEACMode var2);

    public CallResult getPSDEUIActionGroups(String var1, Vector<PSDEUIActionGroup> var2);

    public CallResult getPSDEUIActionGroupDetails(String var1, Vector<PSDEUIActionGroupDetail> var2);

    public CallResult getPSDEUIActionType(String var1, PSDEUIActionType var2);

    public CallResult getPSSysDEUIActionGroups(String var1, Vector<PSDEUIActionGroup> var2);

    public CallResult getPSDEViews(String var1, Vector<PSDEViewBase> var2);

    public CallResult getPSDEPredefinedViews(String var1, Vector<PSDEViewBase> var2);

    public CallResult getPSDEPrints(String var1, Vector<PSDEPrint> var2);

    public CallResult getPSDERs(String var1, Vector<PSDER> var2);

    public CallResult getPSDEFUIModesByDataEntity(String var1, Vector<PSDEFUIMode> var2);

    public CallResult getPSDEFSearchModesByDataEntity(String var1, Vector<PSDEFSearchMode> var2);

    public CallResult getPSDEFValueRulesByDataEntity(String var1, Vector<PSDEFValueRule> var2);

    public CallResult getPSDEDataQuery(String var1, PSDEDataQuery var2);

    public CallResult getPSDEDataQueries(String var1, Vector<PSDEDataQuery> var2);

    public CallResult getPSDEDataQueryCodes(String var1, Vector<PSDEDataQueryCode> var2);

    public CallResult getPSDEDataQueryCode(String var1, PSDEDataQueryCode var2);

    public CallResult getPSDEDataQueryCodeExps(String var1, Vector<PSDEDataQueryCodeExp> var2);

    public CallResult getPSDEDataQueryCodeConds(String var1, Vector<PSDEDataQueryCodeCond> var2);

    public CallResult getPSDEDataSet(String var1, PSDEDataSet var2);

    public CallResult getPSDEDataSets(String var1, Vector<PSDEDataSet> var2);

    public CallResult getPSDEDSDQs(String var1, Vector<PSDEDSDQ> var2);

    public CallResult getPSDEDSGroupParams(String var1, Vector<PSDEDSGroupParam> var2);

    public CallResult getPSAjaxControlHandlers(String var1, Vector<PSACHandler> var2);

    public CallResult getPSDEActionType(String var1, PSDEActionType var2);

    public CallResult getPSDELogics(String var1, Vector<PSDELogic> var2);

    public CallResult getPSDELogicParams(String var1, Vector<PSDELogicParam> var2);

    public CallResult getPSDELogicNodes(String var1, Vector<PSDELogicNode> var2);

    public CallResult getPSDELogicLinks(String var1, Vector<PSDELogicLink> var2);

    public CallResult getPSDELogicNodeParams(String var1, Vector<PSDELogicNodeParam> var2);

    public CallResult getPSDELogicLinkConds(String var1, Vector<PSDELogicLinkCond> var2);

    public CallResult getPSDELogicLinkCondType(String var1, PSDELogicLinkCondType var2);

    public CallResult getPSDELogicNodeType(String var1, PSDELogicNodeType var2);

    public CallResult getPSDELogicLinkType(String var1, PSDELogicLinkType var2);

    public CallResult getPSDEACModeItems(String var1, Vector<PSDEACModeItem> var2);

    public CallResult getPSDEDRDetails(String var1, Vector<PSDEDRDetail> var2);

    public CallResult getPSDEDataRelations(String var1, Vector<PSDEDataRelation> var2);

    public CallResult getPSDEDRGroups(String var1, Vector<PSDEDRGroup> var2);

    public CallResult getPSDEDRItems(String var1, Vector<PSDEDRItem> var2);

    public CallResult getPSDRItemType(String var1, PSDRItemType var2);

    public CallResult getPSWFDEs(String var1, Vector<PSWFDE> var2);

    public CallResult getPSDEMainStateOPPrivs(String var1, Vector<PSDEMainStateOPPriv> var2);

    public CallResult getPSDEMainStateActions(String var1, Vector<PSDEMainStateAction> var2);

    public CallResult getPSDEMainStates(String var1, Vector<PSDEMainState> var2);

    public CallResult getAllPSSysDEFTypes(String var1, Vector<PSSysDEFType> var2);

    public CallResult getPSSysDEFType(String var1, PSSysDEFType var2);

    public CallResult getPSDEFValueRuleConds(String var1, Vector<PSDEFValueRuleCond> var2);

    public CallResult getPSDEFValueRuleTypeDetail(String var1, PSDEFValueRuleTypeDetail var2);

    public CallResult getPSDEFValueRuleType(String var1, PSDEFValueRuleType var2);

    public CallResult getAllPSDEFieldTypes(Vector<PSDEFieldType> var1);

    public CallResult getAllPSDERs(String var1, Vector<PSDER> var2);

    public CallResult getPSDERType(String var1, PSDERType var2);

    public CallResult getPSDERsByMinorDEId(String var1, Vector<PSDER> var2);

    public CallResult getPSDEUtils(String var1, Vector<PSDEUtil> var2);

    public CallResult getAllPSSysLans(String var1, Vector<PSAppLan> var2);

    public CallResult getAllPSLanguageItems(String var1, Vector<PSLanguageItem> var2);

    public CallResult getAllPSLanguageReses(String var1, Vector<PSLanguageRes> var2);

    public CallResult getPSSysValueRule(String var1, PSSysValueRule var2);

    public CallResult getAllPSSysValueRules(String var1, Vector<PSSysValueRule> var2);

    public CallResult getPSSysPortlet(String var1, PSSysPortlet var2);

    public CallResult getAllPSSysPortlets(String var1, Vector<PSSysPortlet> var2);

    public CallResult getAllPSSysPDTViews(String var1, Vector<PSSysPDTView> var2);

    public CallResult getPSSysPDTView(String var1, PSSysPDTView var2);

    public CallResult getPSSystemApplication(String var1, PSSystemApplication var2);

    public CallResult getAllPSSystemApplications(String var1, Vector<PSSystemApplication> var2);

    public CallResult getPSViewType(String var1, PSViewType var2);

    public CallResult getAllPSApplicationViews(String var1, Vector<PSAppView> var2);

    public CallResult getPSAppFunc(String var1, PSAppFunc var2);

    public CallResult getPSAppUserMode(String var1, PSAppUserMode var2);

    public CallResult getPSAppUtilPage(String var1, PSAppUtilPage var2);

    public CallResult getPSAppUIStyle(String var1, PSAppUIStyle var2);

    public CallResult getPSAppUITheme(String var1, PSAppUITheme var2);

    public CallResult getAllPSAppMenus(String var1, Vector<PSAppMenu> var2);

    public CallResult getAllPSAppUtilPages(String var1, Vector<PSAppUtilPage> var2);

    public CallResult getAllPSAppLans(String var1, Vector<PSAppLan> var2);

    public CallResult getPSAppLan(String var1, PSAppLan var2);

    public CallResult getAllPSAppFuncs(String var1, Vector<PSAppFunc> var2);

    public CallResult getPSSysAjaxControlHandlers(String var1, Vector<PSACHandler> var2);

    public CallResult getPSWFDEsByWF(String var1, Vector<PSWFDE> var2);

    public CallResult getPSWFLinkCondType(String var1, PSWFLinkCondType var2);

    public CallResult getPSWFLinkType(String var1, PSWFLinkType var2);

    public CallResult getPSWFProcessType(String var1, PSWFProcessType var2);

    public CallResult getAllPSWFRoles(String var1, Vector<PSWFRole> var2);

    public CallResult getPSWFUIActions(String var1, Vector<PSDEUIAction> var2);

    public CallResult getPSWFUIActionGroups(String var1, Vector<PSDEUIActionGroup> var2);

    public CallResult getPSWFVersions(String var1, Vector<PSWFVersion> var2);

    public CallResult getPSWFProcesses(String var1, Vector<PSWFProcess> var2);

    public CallResult getPSWFLinks(String var1, Vector<PSWFLink> var2);

    public CallResult getPSWFProcParams(String var1, Vector<PSWFProcParam> var2);

    public CallResult getPSWFProcSubWFs(String var1, Vector<PSWFProcSubWF> var2);

    public CallResult getPSWFLinkConds(String var1, Vector<PSWFLinkCond> var2);

    public CallResult getPSWFProcRoles(String var1, Vector<PSWFProcRole> var2);

    public CallResult getAllPSWorkflows(String var1, Vector<PSWorkflow> var2);

    public CallResult getPSSysCounter(String var1, PSSysCounter var2);

    public CallResult getPSCounterType(String var1, PSCounterType var2);

    public CallResult getAllPSSysCounters(String var1, Vector<PSSysCounter> var2);

    public CallResult getAllPSSysEditorStyles(String var1, Vector<PSSysEditorStyle> var2);

    public CallResult getPSSysUniRes(String var1, PSSysUniRes var2);

    public CallResult getAllPSSysUniReses(String var1, Vector<PSSysUniRes> var2);

    public CallResult getPSSysDBValueFunc(String var1, PSSysDBValueFunc var2);

    public CallResult getPSDEOPPriv(String var1, PSDEOPPriv var2);

    public CallResult getPSDEOPPrivsBySystem(String var1, Vector<PSDEOPPriv> var2);

    public CallResult getPSEditorType(String var1, PSEditorType var2);

    public CallResult getPSDBValueOP(String var1, PSDBValueOP var2);

    public CallResult getPSCounter(String var1, PSCounter var2);

    public CallResult getPSPortletType(String var1, PSPortletType var2);

    public CallResult getPSFormDetailType(String var1, PSFormDetailType var2);

    public CallResult getPSFormType(String var1, PSFormType var2);

    public CallResult getPSFDLogicType(String var1, PSFDLogicType var2);

    public CallResult getPSControlType(String var1, PSControlType var2);

    public CallResult getPSToolbarItemType(String var1, PSToolbarItemType var2);

    public CallResult getPSDEGridColumnType(String var1, PSDEGridColumnType var2);

    public CallResult getPSAppMenuItemType(String var1, PSAppMenuItemType var2);

    public CallResult getPSDynaAppView(String var1, PSDynaAppView var2);

    public CallResult getAllPSAppViewLastModifyTimes(String var1, Vector<PSAppView> var2);

    public CallResult getPSAppModule(String var1, PSAppModule var2);

    public CallResult getAllPSAppModules(String var1, Vector<PSAppModule> var2);

    public CallResult getPSPF(String var1, PSPF var2);

    public CallResult getPSPFCtrlTemplDetails(String var1, Vector<PSPFCtrlTemplDetail> var2);

    public CallResult getPSPFStyle(String var1, PSPFStyle var2);

    public CallResult getPSPFCtrlTemplsByPFStyle(String var1, Vector<PSPFCtrlTempl> var2);

    public CallResult getPSPFEditorTemplsByPFStyle(String var1, Vector<PSPFEditorTempl> var2);

    public CallResult getPSPFPubCodes(String var1, Vector<PSPFPubCode> var2);

    public CallResult getPSPFPubCode(String var1, PSPFPubCode var2);

    public CallResult getPSPFEditorTemplsByPF(String var1, Vector<PSPFEditorTempl> var2);

    public CallResult getPSPFPubCodesByPPSPFPubCode(String var1, Vector<PSPFPubCode> var2);

    public CallResult getPSPFPluginTempl(String var1, PSPFPluginTempl var2);

    public CallResult getPSSysPFPlugin(String var1, PSSysPFPlugin var2);

    public CallResult getPSSysPFPluginTempl(String var1, PSSysPFPluginTempl var2);

    public CallResult getAllPSSysPFPluginTempls(String var1, Vector<PSSysPFPluginTempl> var2);

    public CallResult getAllPSSysPFPlugins(String var1, Vector<PSSysPFPlugin> var2);

    public CallResult getPSWorkflow(String var1, PSWorkflow var2);

    public CallResult getPSDynaInst(String var1, PSDynaInst var2);

    public CallResult getPSAppPDTView(String var1, PSAppPDTView var2);

    public CallResult getAllPSAppPDTViews(String var1, Vector<PSAppPDTView> var2);

    public CallResult getPSDataEntityTagsByDynaInst(String var1, int var2, int var3, Vector<PSDataEntity> var4);

    public CallResult getPSWFVersionTagsByDynaInst(String var1, int var2, int var3, Vector<PSWFVersion> var4);

    public CallResult getPSDEViewBaseTagsByDynaInst(String var1, int var2, int var3, Vector<PSDEViewBase> var4);

    public CallResult getPSDEFormTagsByDynaInst(String var1, int var2, int var3, Vector<PSDEForm> var4);
}

